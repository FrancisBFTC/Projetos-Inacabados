/*----------------------------------------------------------------------------*\
*
*
*                                             IBM (R)
*                                     (c) 1997,1999 IBM Corp.
*                                     All Rights Reserved.
*
*    File Name:    VTUNINST.CPP
*
*    Description:  ViaVoice 7.0.0.60 Runtime
*                  Uninstallation Support Functions
*
*    Comments:     This code is meant to facilitate uninstallation of ViaVoice
*                  Runtimes  V7.0 on Win95 or Windows NT.  It is written in C++.
*
*                  Please review the licensing agreement for more information.
\*----------------------------------------------------------------------------*/

//includes

#include <direct.h>
#include <string.h>
#include <io.h>
#include <stdio.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <time.h>
#include <afxole.h>
#include <shlobj.h>
#include "stdafx.h"
//#include "vvrtkreg.h"
//#include "vvuninst.h"
#include "rtreturn.h"
#include "VV70u_US.h"

//forward declarations
BOOL      bHandle_RT_Removal(char * szRTUninstalling);
BOOL      bCheckDictRTUninstStatus(void);
HINSTANCE MyLoadLibrary (char *szLibraryName, char *szCopyName );
void      MyFreeLibrary(HINSTANCE * hInst, char *szCopyName);


//globals
BOOL g_bRemovedRT = FALSE;

//some simplification
//typedef BOOL (*TYPEGetFullPath ) ( VVRtkRegApi::VVPath vvPath, LPTSTR lpszFullPath );
//typedef BOOL (*TYPEGETFULLPATH)      ( VVRtkRegApi::VVPath vvPath, char * lpszFullPath );

///////////////////////////////////////////////////////////////////////////////
//
// Function:  Handle_RT_Removal
//
//  Purpose:  Checks to see if Dict/TTS Runtime is removable and if so calls the
//            uninstaller, else keeps the runtimes
//
//  Parms  :  INPUT STRING  szRTUninstalling
//                    call with ID_PRODUCT_RTCONTROL or ID_PRODUCT_RTDICT
//
//  Output  -  Sets a flag if runtimes were removed.
//
//  Returns:   TRUE if everything went ok else a FALSE
//
///////////////////////////////////////////////////////////////////////////////

BOOL bHandle_RT_Removal(char * szRTUninstalling)
{
    //handle to helper DLL
    HINSTANCE hInst                               = NULL;
    HINSTANCE hInstVVRtkReg                       = NULL;
    
    //Function pointers from utility dll (see VV70u_XX.h)
    TYPEIsRemovable IsRemovable                   = NULL;
    TYPEUninstallQuietly UninstallQuietly         = NULL;
    TYPECreateAddRemoveEntry CreateAddRemoveEntry = NULL;
    TYPEUnregisterClient     UnregisterClient     = NULL;

    // TYPEGetFullPath          GetFullPath          = NULL;
    // TYPEGETFULLPATH                   pfnGetFullPath;
    
    // char szFullPath[_MAX_PATH];
    char szCopyFile[_MAX_PATH];
    
    CString csUninstPath;
    
    int nResult                                   = 0;
    
    CString ErrMsg, csRuntimeType;  
    
    g_bRemovedRT = FALSE; //initialize to not removed
    
    printf("TODO: Give user visual feedback that ViaVoice Uninstall is running\n");
    
    
    // if ((hInstVVRtkReg = LoadLibrary("VVRTKREG.DLL")) == NULL)
    //  {
    //    printf("TODO: Handle severe error cannot load library for uninstaller\n");
    //    return FALSE;
    //  }
    // else
    // {
    //    pfnGetFullPath = 
    //            (TYPEGETFULLPATH)    GetProcAddress(hInstVVRtkReg , "_GetFullPath");
    
    //Get Proc Address for get full path
    //    pfnGetFullPath = (TYPEGetFullPath)
    //                  GetProcAddress( hInstVVRtkReg, "GetFullPath");
    //    DWORD d = GetLastError();
    
    //use the path returned to load helper DLL for language
    //    if (VVRtkRegApi::GetFullPath( VVRtkRegApi::RUNTIME_BIN, szFullPath ))
    {
        //       FreeLibrary(hInstVVRtkReg);
        csUninstPath = "D:\\ccsyr\\develop\\";
        csUninstPath += VVUNINSTDLL;
        csUninstPath += _CURRENT_LANGUAGE_;
        csUninstPath += ".dll";
        
        if ((hInst = MyLoadLibrary(csUninstPath.GetBuffer(0), szCopyFile), szCopyFile) == NULL)
        {
            printf("TODO: Handle severe error cannot load library for uninstaller\n");
            return FALSE;
        }
    }
    //    else
    //    {
    //       FreeLibrary(hInstVVRtkReg);
    //       printf("TODO: Handle severe error cannot load path for ViaVoice Runtimes.\n");
    //       return FALSE;
    //    }
    // }
    
    //load the functions from the helper dll
    if ((UnregisterClient = (TYPEUnregisterClient)GetProcAddress(hInst, "UnregisterClient")) == NULL)
    {
        printf("TODO: Handle severe error cannot load support functions\n");
        MyFreeLibrary(&hInst, szCopyFile);
        return FALSE;
    }
    
    if ((IsRemovable = (TYPEIsRemovable)GetProcAddress(hInst, "IsRemovable")) == NULL)
    {
        printf("TODO: Handle severe error cannot load support functions\n");
        MyFreeLibrary(&hInst, szCopyFile);
        return FALSE;
    }
    
    if ((UninstallQuietly = (TYPEUninstallQuietly)GetProcAddress(hInst, "UninstallQuietly")) == NULL)
    {
        printf("TODO: Handle severe error cannot load support functions\n");
        MyFreeLibrary(&hInst, szCopyFile);
        return FALSE;
    }
    
    if ((CreateAddRemoveEntry = (TYPECreateAddRemoveEntry)GetProcAddress(hInst, "CreateAddRemoveEntry")) == NULL)
    {
        printf("TODO: Handle severe error cannot load support functions\n");
        MyFreeLibrary(&hInst, szCopyFile);
        return FALSE;
    }
    //finished loading helper functions
    
    // call to unregister this application as a client of the runtimes
    nResult = UnregisterClient(VISIBLE_NAME, MAJOR_VERSION, MINOR_VERSION, UNIQUE);
    
    // check to see if we can "safely" remove runtimes
    nResult = IsRemovable(szRTUninstalling); 
    if (nResult != 0) // it's "safe" to uninstall
    {
        printf("TODO: Ask the user if they would like to save their user data\n");
        if (1)  //assume they would like to save user data (change this line)
        {
            nResult = UninstallQuietly(szRTUninstalling, "remove");
        }
        else  //Provided for completeness
        {
            nResult = UninstallQuietly(szRTUninstalling, "remove delusr");
        }
        g_bRemovedRT = bCheckDictRTUninstStatus(); 
    }
    else // it is not safe to remove the runtimes (another program is using it)
    {
        // decrement the use count
        nResult = UninstallQuietly(szRTUninstalling, "remain");
        g_bRemovedRT = bCheckDictRTUninstStatus();

        // Create the Add/Remove Programs Entry within Control Panel
        nResult = CreateAddRemoveEntry(szRTUninstalling);
        if (nResult == FALSE)
        {
            MyFreeLibrary(&hInst, szCopyFile);
            return(FALSE);
        }
    }
    
    MyFreeLibrary(&hInst, szCopyFile);
    return(TRUE);
}

///////////////////////////////////////////////////////////////////////////////
//
// Function:  CheckDictRTUninstStatus
//
//  Purpose:  To check for status of runtime uninstall and remove the
//            key from the registry as a cleanup
//
//  Parms  :  NONE
//
//  Returns:  NONE
//
///////////////////////////////////////////////////////////////////////////////

BOOL bCheckDictRTUninstStatus( )
{
    HKEY hKey      = NULL;
    char *szKey    = "SOFTWARE\\IBM\\ViaVoice Installation";  
    char *szKey1   = "SOFTWARE\\IBM";
    char *ErrCd    = "ErrorCode";
    LONG result    = 0;
    DWORD nSize    = 0;
    char PdCnt[256] = "0"; //initialize to success
    BOOL RtSuccess = FALSE;
    int iErrorCode = 0;
    
    //Open the key for reading
    result = RegOpenKeyEx(HKEY_LOCAL_MACHINE, szKey, 0, KEY_ALL_ACCESS, &hKey);
    if (result == ERROR_SUCCESS)
    {
        nSize = 256;
        DWORD  rgType;
        result = RegQueryValueEx(hKey, ErrCd, NULL, &rgType, (LPBYTE)&PdCnt, &nSize); 
        if (result == ERROR_SUCCESS)
        {
            if (PdCnt[0] == '0')
            {
                RtSuccess = TRUE; //Ok we have success
            }//if strnlen
            
        }//if (result == ERROR_SUCCESS)
        
    }//if (result == ERROR_SUCCESS)
    
    if (hKey != NULL)
    {
        RegCloseKey(hKey);
    }
    
    //If Runtime uninstall was successful we remove key
    if (RtSuccess)
    {
        result = RegOpenKeyEx(HKEY_LOCAL_MACHINE, szKey1, 0, KEY_ALL_ACCESS, &hKey);
        if (result == ERROR_SUCCESS)
        {
            RegDeleteKey( hKey, "ViaVoice Installation" );
        }
    }
    else
    {
        //determine the nature of the error and see if it is a real problem
        //for the most part we would like to leave the return codes
        //in the registry to help in support problems or let the
        //user see the message... these messages are only in english... though
        
        iErrorCode = atoi(PdCnt);//oscar todo check GetLastError for problems
        
        if (iErrorCode & RT_CONFIG_APP_ACTIVE)
        {
            printf("TODO:  Handle speech applications are running.\n");
            return FALSE;
        }
        
        if (iErrorCode & RT_CONFIG_OS_BAD)
        {
            printf("TODO:  Handle OS check failed.\n");
            return FALSE;
        }
        
        if (iErrorCode & RT_CONFIG_NOT_ADMIN)
        {
            printf("TODO:  Handle not administrator failure.\n");
            return FALSE;
        }   
        
        if (iErrorCode & RT_CONFIG_REBOOT_REQ)
        {
            printf("TODO: Handle Reboot Required\n");
            
            //no need to leave the key
            result = RegOpenKeyEx(HKEY_LOCAL_MACHINE, szKey1, 0, KEY_ALL_ACCESS, &hKey);
            if (result == ERROR_SUCCESS)
            {
                RegDeleteKey( hKey, "ViaVoice Installation" );
            }
            RtSuccess = TRUE;  //fall through to return below
        }
    }
    return RtSuccess;
}//end 


//////////////////////////////////////////////////////////////////
// Note to Code Below:  Generally speaking, not using windows 
// system utilities allowed to stay on the machine may present
// a problem... mainly the .dll or .exe used to uninstall may
// complain if deleting it is attempted while it is running.  
// In order to circumvent this a copy of the dll is used as
// opposed to the original.  
///////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////
//
// Function:  MyLoadLibrary
//
//  Purpose:  To copy the helper dll and delete it using a wrapper API
//
//  Parms  :  INPUT STRING szDllName
//            OUTPUT STRING szCopyName
//
//  Returns: HINSTANCE of the Dll loaded
//           NULL on Error
///////////////////////////////////////////////////////////////////////////////
HINSTANCE MyLoadLibrary (char *szLibraryName, char *szCopyName )
{
    char szCopy[_MAX_PATH];
    GetTempPath(_MAX_PATH, szCopy);
    GetTempFileName(szCopy, "dll", 0, szCopy); 
    CopyFile(szLibraryName, szCopy, FALSE);
    strcpy(szCopyName, szCopy);
    return LoadLibrary(szCopy);
}

///////////////////////////////////////////////////////////////////////////////
//
// Function:  MyFreeLibrary
//
//  Purpose:  To subtely copy the helper dll and delete it using a wrapper API
//
//  Parms  :  INPUT/OUTPUT HINSTANCE * instance handle of module to free
//            INPUT STRING szCopyName - name of copy of DLL
//         
//
//  Returns: HINSTANCE of the Dll loaded
//           NULL on Error
///////////////////////////////////////////////////////////////////////////////
void MyFreeLibrary(HINSTANCE * hInst, char *szCopyName)
{
    DeleteFile(szCopyName);
    if (hInst)
        FreeLibrary(*hInst);
    *hInst = NULL;
}


//
// From your main routine call:
//    bHandle_RT_Removal(PRODUCT_RTCONTROL );  //to uninstall the C&C Runtime
//    bHandle_RT_Removal(PRODUCT_RTDICT );     //to uninstall the Dictation Runtime
// 
//

void main ( void )
{
   BOOL bResult = FALSE;
   bResult = bHandle_RT_Removal(PRODUCT_RTCONTROL );  //to uninstall the C&C Runtime
// bHandle_RT_Removal(PRODUCT_RTDICT );     //to uninstall the Dictation Runtime
   if (bResult!=TRUE)
   {
       printf("TODO: Handle uninstall error");
   }

   return;
}
