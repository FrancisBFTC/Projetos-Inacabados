package aes.encrypt;
import javax.crypto.spec.SecretKeySpec;

import Decoder.BASE64Decoder;

import javax.crypto.spec.IvParameterSpec;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.crypto.Cipher;
  
public class EncriptaDecriptaAES {
       
		
		
       static String IV = "AAAAAAAAAAAAAAAA";
      
     
  
       public static void main(String [] args) throws IOException {
    	   
    	  
    	   
    	   String hashCode = "fGwXfERan92FG9cN2s5tXeLAAixaASBt";
    	   String keyAes = "3EE4582DD1573591EEB960CA1F832F99";
    	   String MyIv = "593B2A8D4587DAB1";
    	   
    	  
    
            try{	 
                 
            	System.out.println(
            			decrypt(hashCode, keyAes, MyIv, true
            	));
            } catch (Exception e) {
      			 e.printStackTrace();
               
      		 }
      		 
      	     
      	 

             
       }
       
      
       
       public static byte[] encodeByte(String code){
    	   System.out.println("");
    	   byte[] getCode = code.getBytes();
    	  
    	   return getCode;
       }
       
       public static String decrypt(String cipherText, String key1, String iv1, final boolean oldDecrypt) throws Exception {
   		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
   		SecretKeySpec keySpec = EncriptaDecriptaAES.generateKey(key1);
   		IvParameterSpec ivSpec = EncriptaDecriptaAES.getIv(iv1);
   		cipher.init(Cipher.DECRYPT_MODE,keySpec,ivSpec);
   		cipherText = cipherText.replaceAll("-", "+");
   		cipherText = cipherText.replaceAll("_", "/");
   		byte[] decordedValue = new BASE64Decoder().decodeBuffer(cipherText);
   		byte[] decValue = cipher.doFinal(decordedValue);
   		return new String(decValue, "iso-8859-1");
   		}
        
       private static SecretKeySpec generateKey(String genKey) throws Exception {	
   			return new SecretKeySpec(genKey.getBytes(), "AES");		
   	   }
   	
       private static IvParameterSpec getIv(String getIv) throws Exception {
   			return new IvParameterSpec(getIv.getBytes());	
   	   }
       
      
}
