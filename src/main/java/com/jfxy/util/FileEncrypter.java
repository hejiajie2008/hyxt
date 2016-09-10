package com.jfxy.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class FileEncrypter {
	private FileInputStream fis;


	/**
	 * 加密函数 输入： 要加密的文件，密码（由0-F组成，共48个字符，表示3个8位的密码）如：
	 * AD67EA2F3BE6E5ADD368DFE03120B5DF92A8FD8FEC2F0746 其中： AD67EA2F3BE6E5AD
	 * DES密码一 D368DFE03120B5DF DES密码二 92A8FD8FEC2F0746 DES密码三 输出：
	 * 对输入的文件加密后，保存到同一文件夹下增加了".tdes"扩展名的文件中。
	 */
	private void encrypt(File fileIn,File fileOut, String sKey) {
		try {
			if (sKey.length() == 48) {
				byte[] bytK1 = getKeyByStr(sKey.substring(0, 16));
				byte[] bytK2 = getKeyByStr(sKey.substring(16, 32));
				byte[] bytK3 = getKeyByStr(sKey.substring(32, 48));

				fis = new FileInputStream(fileIn);
				byte[] bytIn = new byte[(int) fileIn.length()];
				for (int i = 0; i < fileIn.length(); i++) {
					bytIn[i] = (byte) fis.read();
				}
				// 加密
				byte[] bytOut = encryptByDES(
						encryptByDES(encryptByDES(bytIn, bytK1), bytK2), bytK3);
				FileOutputStream fos = new FileOutputStream(fileOut);
				for (int i = 0; i < bytOut.length; i++) {
					fos.write((int) bytOut[i]);
				}
				fos.close();
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 输入密码的字符形式，返回字节数组形式。 如输入字符串：AD67EA2F3BE6E5AD
	 * 返回字节数组：{173,103,234,47,59,230,229,173}
	 */
	private byte[] getKeyByStr(String str) {
		byte[] bRet = new byte[str.length() / 2];
		for (int i = 0; i < str.length() / 2; i++) {
			Integer itg = new Integer(16 * getChrInt(str.charAt(2 * i))
					+ getChrInt(str.charAt(2 * i + 1)));
			bRet[i] = itg.byteValue();
		}
		return bRet;
	}

	/**
	 * 计算一个16进制字符的10进制值 输入：0-F
	 */
	private int getChrInt(char chr) {
		int iRet = 0;
		if (chr == "0".charAt(0))
			iRet = 0;
		if (chr == "1".charAt(0))
			iRet = 1;
		if (chr == "2".charAt(0))
			iRet = 2;
		if (chr == "3".charAt(0))
			iRet = 3;
		if (chr == "4".charAt(0))
			iRet = 4;
		if (chr == "5".charAt(0))
			iRet = 5;
		if (chr == "6".charAt(0))
			iRet = 6;
		if (chr == "7".charAt(0))
			iRet = 7;
		if (chr == "8".charAt(0))
			iRet = 8;
		if (chr == "9".charAt(0))
			iRet = 9;
		if (chr == "A".charAt(0))
			iRet = 10;
		if (chr == "B".charAt(0))
			iRet = 11;
		if (chr == "C".charAt(0))
			iRet = 12;
		if (chr == "D".charAt(0))
			iRet = 13;
		if (chr == "E".charAt(0))
			iRet = 14;
		if (chr == "F".charAt(0))
			iRet = 15;
		return iRet;
	}

	/**
	 * 用DES方法加密输入的字节 bytKey需为8字节长，是加密的密码
	 */
	private byte[] encryptByDES(byte[] bytP, byte[] bytKey) throws Exception {
		DESKeySpec desKS = new DESKeySpec(bytKey);
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
		SecretKey sk = skf.generateSecret(desKS);
		Cipher cip = Cipher.getInstance("DES");
		cip.init(Cipher.ENCRYPT_MODE, sk);
		return cip.doFinal(bytP);
	}
	
    public String md5s(String plainText) {  
        String str = null;  
        try {  
            MessageDigest md = MessageDigest.getInstance("MD5");  
            md.update(plainText.getBytes());  
            byte b[] = md.digest();  
  
            int i;  
  
            StringBuffer buf = new StringBuffer("");  
            for (int offset = 0; offset < b.length; offset++) {  
                i = b[offset];  
                if (i < 0)  
                    i += 256;  
                if (i < 16)  
                    buf.append("0");  
                buf.append(Integer.toHexString(i));  
            }  
            // System.out.println("result: " + buf.toString());// 32位的加密  
            // System.out.println("result: " + buf.toString().substring(8,  
            // 24));// 16位的加密  
            str = buf.toString().substring(8, 24);  
        } catch (NoSuchAlgorithmException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return str;  
    }  
  

    /** 
     * 解密函数 输入： 要解密的文件，密码（由0-F组成，共48个字符，表示3个8位的密码）如： 
     * AD67EA2F3BE6E5ADD368DFE03120B5DF92A8FD8FEC2F0746 其中： AD67EA2F3BE6E5AD 
     * DES密码一 D368DFE03120B5DF DES密码二 92A8FD8FEC2F0746 DES密码三 输出： 
     * 对输入的文件解密后，保存到用户指定的文件中。 
     */  
    private void decrypt(File fileIn,File fileOut, String sKey) {  
        try {  
            if (sKey.length() == 48) {  
                String strPath = fileIn.getPath();  
                
                System.out.println(strPath);
                strPath = strPath.substring(0, strPath.length() - 5);  
                
                byte[] bytK1 = getKeyByStr(sKey.substring(0, 16));  
                byte[] bytK2 = getKeyByStr(sKey.substring(16, 32));  
                byte[] bytK3 = getKeyByStr(sKey.substring(32, 48));  
  
                 fis = new FileInputStream(fileIn);  
                byte[] bytIn = new byte[(int) fileIn.length()];  
                for (int i = 0; i < fileIn.length(); i++) {  
                    bytIn[i] = (byte) fis.read();  
                }  
                // 解密  
                byte[] bytOut = decryptByDES(decryptByDES(decryptByDES(bytIn,  
                        bytK3), bytK2), bytK1);  
               
                fileOut.createNewFile();  
                FileOutputStream fos = new FileOutputStream(fileOut);  
                for (int i = 0; i < bytOut.length; i++) {  
                    fos.write((int) bytOut[i]);  
                }  
                fos.close();  
            }  
        } catch (FileNotFoundException e) {  
            System.out.println("解密错误！");  
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
       
    }  
    
    
    /** 
     * 用DES方法解密输入的字节 bytKey需为8字节长，是解密的密码 
     */  
    private byte[] decryptByDES(byte[] bytE, byte[] bytKey) throws Exception {  
        DESKeySpec desKS = new DESKeySpec(bytKey);  
        SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");  
        SecretKey sk = skf.generateSecret(desKS);  
        Cipher cip = Cipher.getInstance("DES");  
        cip.init(Cipher.DECRYPT_MODE, sk);  
        return cip.doFinal(bytE);  
    }  
	
	
	public static void main(String args[]) {  
		
        FileEncrypter da = new FileEncrypter();  
        
       
        /**
        String pass = scan.next();  
        String pass1 = pass.substring(0, 2);  
        String pass2 = pass.substring(2, 4);  
        String pass3 = pass.substring(4);  
        System.out.println(pass1);  
        System.out.println(pass2);  
        System.out.println(pass3);  
        **/
        
        
        String pass = "jfcreditadmin"; 
        String pass1 = pass.substring(0, 2);  
        String pass2 = pass.substring(2, 4);  
        String pass3 = pass.substring(4);  

        //String name = scan.next();  
        String inpath1="d:/tt/t1/aa.txt";
        String outpath1="d:/tt/t1/en_aa.txt";
        String outpath2="d:/tt/t1/dn_aa.txt";
        
        inpath1="d:/tt/t1/111.jpg";
        outpath1="d:/tt/t1/en_111.jpg";
         outpath2="d:/tt/t1/dn_111.jpg";
        int type=1;
        String pp=da.md5s(pass1) + da.md5s(pass2)  
                + da.md5s(pass3);
        if(type==0){
        	 da.encrypt(new File(inpath1),new File(outpath1), pp);  
        }else{
        	da.decrypt(new File(outpath1),new File(outpath2), pp);  
        }
    }  

}
