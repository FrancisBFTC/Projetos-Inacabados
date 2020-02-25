#if !defined(VV70U_US_H)
#define VV70U_US_H 1
/*----------------------------------------------------------------------------*\
 *
 *
 *                                             IBM (R)
 *                                     (c) 1997,1999 IBM Corp.
 *                                     All Rights Reserved.
 *
 *    File Name:    VV70u_US.H
 *
 *    Description:  ViaVoice 7.0.0.60 Runtime
 *                  Uninstallation Support 
 *                  header file.
 *
 *    Comments:     This header facilitates deinstalling the viavoice runtimes.
 *                  The code is written for C/C++.  Include after <windows.h>.
 *
 *                  Please review the licensing agreement for more information.
\*----------------------------------------------------------------------------*/


//Ptrs for functions defined in the dictation and tts runtime dlls
typedef	int (WINAPI *TYPEIsRemovable)(LPCSTR);
typedef int (WINAPI *TYPEUninstallQuietly)(LPCSTR, LPCSTR);
typedef int (WINAPI *TYPECreateAddRemoveEntry)(LPCSTR);
typedef int (WINAPI *TYPEUnregisterClient)(LPCSTR , LPCSTR , LPCSTR , LPCSTR );

#endif
