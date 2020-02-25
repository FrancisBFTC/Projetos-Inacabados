#if !defined(VVRTKREG_API_H__165B26F0_D732_11D2_9649_0006296988C7__INCLUDED_)
#define VVRTKREG_API_H__165B26F0_D732_11D2_9649_0006296988C7__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000



#ifdef VVRTKREG_EXPORTS
#define VVRTKREG_API __declspec(dllexport)
#else
#define VVRTKREG_API __declspec(dllimport)
#endif

///////////////////////////////////////////////////////////////////////


namespace VVRtkRegApi
{
   
	typedef enum 
   {
      VIAVOICE_RUNTIME_RECO                     = 200,
      VIAVOICE_RUNTIME_RECO_CURRENT_USER,
      VIAVOICE_RUNTIME                          = VIAVOICE_RUNTIME_RECO,
      VIAVOICE_RUNTIME_CURRENT_USER             = VIAVOICE_RUNTIME_RECO_CURRENT_USER,
   } VVComponent;


   typedef enum 
   {
      RUNTIME_BASE      = 30,
      RUNTIME_BIN,
      RUNTIME_HELP,
      RUNTIME_TEMP,
   } VVPath;


   //////////////////////////////
   // Low-level access functions.
   //////////////////////////////

	VVRTKREG_API LONG  RegCreateKey( VVComponent VVComponent, LPCTSTR lpszSubKey, LPTSTR lpszClass,
												DWORD dwOptions, REGSAM samDesired, PHKEY phkeyResult, LPDWORD lpdwDisposition);

   VVRTKREG_API LONG  RegOpenKey(VVComponent VVComponent,LPCTSTR lpszSubKey,REGSAM samDesired,PHKEY phkeyResult);

  
   //////////////////////////////
   // High-level access functions.
   //////////////////////////////

   VVRTKREG_API BOOL  GetFullPath( VVPath vvPath, LPTSTR lpszFullPath );

};

#endif //define VVRTKREG_API_H__165B26F0_D732_11D2_9649_0006296988C7__INCLUDED_
