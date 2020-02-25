//-----------------------------------------------------------------------------------------------------
//
//                            VoiceType and ViaVoice Past and Present
//                             Return Codes for Errors Returned
//
//-----------------------------------------------------------------------------------------------------


#define RT_CONFIG_SUCCESS    0x00000000  //operation was successfully completed.
#define RT_CONFIG_ERROR      0x00000001  //general error occured (did not complete)
#define RT_CONFIG_INSTALL    0x00000002  //message is from install of product
#define RT_CONFIG_UNINSTALL  0x00000004  //message is from uninstall of product  
#define RT_CONFIG_APP_ACTIVE 0x00000010  //speech app is running
#define RT_CONFIG_OS_BAD     0x00000020  //operating system requirements were not met
#define RT_CONFIG_NOT_ADMIN  0x00000040  //user lacks admin priv
#define RT_CONFIG_DISK_SPACE 0x00000080  //disk space is not sufficient for install
#define RT_CONFIG_NO_SOUND   0x00000100  //sound check failed
#define RT_CONFIG_DIFF_LANG  0x00000200  //older different language is on the machine
#define RT_CONFIG_REBOOT_REQ 0x00000400  //rebooting needs to be done
#define RT_CONFIG_BADCMDLNE  0x00000800  //bad command line
#define RT_PRODUCTS_EXIST    0x00001000  //products using runtime still exist
#define RT_DPRODUCTS_EXIST   0x00002000  //discrete products using runtimes exist
#define RT_CONFIG_USER_QUIT  0x40000000  //cancel by user
