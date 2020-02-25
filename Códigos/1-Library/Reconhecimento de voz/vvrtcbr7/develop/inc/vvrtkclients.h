/******************************************************************************/
/*                                                                            */
/* OCO Source Materials 5871-AAA                                              */
/* (C) Copyright International Business Machine Corp, 1994.                   */
/* All Rights Reserved                                                        */
/*                                                                            */
/* US Government Users Restricted Rights - Use, duplication, or               */
/* disclosure restricted by GSA ADP Schedule Contract with IBM Corp.          */
/*                                                                            */
/* PROGRAM NAME: VVRtkClients.DLL                                             */
/*                                                                            */
/* AUTHOR(S): Jie Zeng                                                        */
/*                                                                            */
/* FILE NAME: VVRtkClients.H                                                  *
/*                                                                            */
/* DESCRIPTIVE NAME: This is VVRtkClients functions DLL's header file.        */
/*                                                                            */
/* STATUS: INITIAL REVISION                                                   */
/*                                                                            */
/* NOTES:                                                                     */
/*                                                                            */
/* MODULE STRUCTURE:                                                          */
/*                                                                            */
/* DEPENDENCIES:                                                              */
/*                                                                            */
/* CODE UPDATES:                                                              */
/*                                                                            */
/* MODULE TYPE: (C language)                                                  */
/*                                                                            */
/* COMPILER OPTIONS:                                                          */
/*                                                                            */
/* CHANGE HISTORY:                                                            */
/*                                                                            */
/* DEVELOPER    DATE      PTR    DESCRIPTION                                  */
/* ---------  --------  -------  -------------------------------------------- */
/*  JZ        06-20-99    --     INITIAL FILE CREATION                        */
/*                                                                            */
/******************************************************************************/

#ifndef __VVRTKCLIENTS_LAUNCH_DLL__
#define __VVRTKCLIENTS_LAUNCH_DLL__

#ifdef __cplusplus
extern "C"
{
#endif

// The following ifdef block is the standard way of creating macros which make exporting 
// from a DLL simpler. All files within this DLL are compiled with the VVRTKCLIENTS_EXPORTS
// symbol defined on the command line. this symbol should not be defined on any project
// that uses this DLL. This way any other project whose source files include this file see 
// VVRTKCLIENTS_API functions as being imported from a DLL, wheras this DLL sees symbols
// defined with this macro as being exported.
#ifdef VVRTKCLIENTS_EXPORTS
   #define VVRTKCLIENTS_API __declspec(dllexport)
#else
   #define VVRTKCLIENTS_API __declspec(dllimport)
#endif




/******************************************************************************/
/* User-defined types                                                         */
/******************************************************************************/

// Client Launcher API return codes
typedef enum
{
   VVRTKRC_OK                          = 0,
   VVRTKRC_CLIENT_IS_INVALID,
   VVRTKRC_CLIENT_OPTION_IS_INVALID,
   VVRTKRC_CLIENT_OPTION_IS_MISSING,
   VVRTKRC_CLIENT_IS_NOT_FOUND,
   VVRTKRC_CLIENT_IS_NOT_RUNNING,
   VVRTKRC_CLIENT_IS_ALREADY_RUNNING,
   VVRTKRC_CLIENT_INSUFFICIENT_MEMORY,
   VVRTKRC_CLIENT_LAUNCH_FAILED,
   VVRTKRC_CLIENT_RUNTIME_PATH_UNAVAILABLE
} VVRTKCLIENT_RC;


// Clients available from runtime.
typedef enum 
{
   VVRTKCLIENT_UNKNOWN                 = -1,
   VVRTKCLIENT_USER_WIZARD             =  0,
   VVRTKCLIENT_AUDIO_SETUP_WIZARD,
   VVRTKCLIENT_ENROLLMENT_WIZARD,
   VVRTKCLIENT_VOCABULARY_EXPANDER_WIZARD,
   VVRTKCLIENT_VIAVOICE_OPTIONS,
   VVRTKCLIENT_DICTATION_MACRO_EDITOR,
   VVRTKCLIENT_VOCABULARY_MANAGER,
   VVRTKCLIENT_USER_MIGRATION_TOOL,
   VVRTKCLIENT_VOCABULARY_AND_TOPIC_INSTALLER_TOOL
} VVRTKCLIENT_ID;


// Client launching information record (used to launch clients).
typedef struct 
{
   VVRTKCLIENT_ID m_ClientID;
   char           *m_pszOptions;    
} VVRTKCLIENT_LAUNCH_INFO;


/* Notes: if you need process handler on Window platform, you can call 
          OpenProcess() function with process ID to get it.                   */        
typedef struct 
{ 
    DWORD         m_dwProcessId;
    DWORD         m_dwThreadId; 
} VVRTKCLIENT_PROCESS_INFO; 




/******************************************************************************/
/* Functions                                                                  */
/******************************************************************************/

/******************************************************************************/
/*                                                                            */
/* Function: VVRtkClients_Launch()                                            */
/*                                                                            */
/* Description:                                                               */
/*      This function is called to launch VVClient                            */
/*                                                                            */
/* Input:                                                                     */
/*      cliInfo         - a VVRTKCLIENT_LAUNCH_INFO struct.                   */
/*      *pcpiProcInfo   - a pointer to point to a VVCLIENT_PROCESS_INFO       */
/*      nReserved       - a reserved param for future use. It should be 0.    */
/*                                                                            */
/* Returns:                                                                   */
/*      VVRTKCLIENT_RC  type                                                  */
/*                                                                            */
/* Comments:                                                                  */
/*                                                                            */
/******************************************************************************/
VVRTKCLIENTS_API VVRTKCLIENT_RC VVRtkClients_Launch(VVRTKCLIENT_LAUNCH_INFO   *pcliInfo, 
                                                    VVRTKCLIENT_PROCESS_INFO  *pcpiProcInfo,
                                                    int                       nReserved); 
 

/******************************************************************************/
/*                                                                            */
/* Function: VVRtkClients_IsClientAvailable()                                 */
/*                                                                            */
/* Description:                                                               */
/*      This function is called to check if the specified ViaVoice runtime    */
/* client is installed and available for launching.                           */
/*      one.                                                                  */
/*                                                                            */
/* Input:                                                                     */
/*      vvcInfo   - a VVRTKCLIENT_LAUNCH_INFO struct.                         */
/*                                                                            */
/* Returns:                                                                   */
/*      VVRTKCLIENT_LAUNCH_RC type                                            */
/*                                                                            */
/* Comments:                                                                  */
/*                                                                            */
/******************************************************************************/
VVRTKCLIENTS_API VVRTKCLIENT_RC VVRtkClients_IsClientAvailable(VVRTKCLIENT_ID nClientID);



/******************************************************************************/
/*                                                                            */
/* Function: VVRtkClients_IsClientRunning()                                   */
/*                                                                            */
/* Description:                                                               */
/*      This function is called to check if the desired ViaVoice runtime      */
/* client is currently running (or loaded).                                   */
/*      one.                                                                  */
/*                                                                            */
/* Input:                                                                     */
/*      vvcInfo   - a VVRTKCLIENT_LAUNCH_INFO struct.                         */
/*                                                                            */
/* Returns:                                                                   */
/*      VVRTKCLIENT_LAUNCH_RC type                                            */
/*                                                                            */
/* Comments:                                                                  */
/*                                                                            */
/******************************************************************************/
VVRTKCLIENTS_API VVRTKCLIENT_RC VVRtkClients_IsClientRunning(VVRTKCLIENT_ID nClientID);


#ifdef __cplusplus
}
#endif

#endif // __VVRTKCLIENTS_LAUNCH_DLL__

