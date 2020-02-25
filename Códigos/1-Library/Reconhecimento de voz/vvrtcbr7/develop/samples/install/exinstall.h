/*----------------------------------------------------------------------------*\
 *
 *
 *                                             IBM (R)
 *                                     (c) 1997,1999 IBM Corp.
 *                                     All Rights Reserved.
 *
 *    File Name:    EXINSTALL.H
 *
 *    Description:  ViaVoice 7.0.0.60 Runtime
 *                  Setup and installation script support
 *                  header.
 *
 *    Comments:     This header facilitates installation of ViaVoice Runtime
 *                  V7.0 on Win95 or Windows NT.  It is intended for Install
 *                  Shield 5.5.  Main Driver Function is InstallDictRT.
 *
 *                  Please review the licensing agreement for more information.
\*----------------------------------------------------------------------------*/

prototype InstallDictRT(STRING, STRING);
prototype RegisterClient( STRING, STRING, STRING, STRING );
prototype RegisterCleanUp();
prototype CheckDictRTErrorCodes();

STRING g_bNewOrthography;

