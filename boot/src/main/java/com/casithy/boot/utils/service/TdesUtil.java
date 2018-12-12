package com.casithy.boot.utils.service;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Casithy blog: https://casithy.cn
 *
 * @version 创建时间：2018年12月12日 上午11:39:36
 *
 */
@Slf4j
public class TdesUtil {
	
	public static byte[] hexStringToByte(String key){  
        String f = DigestUtils.md5Hex(key);  
        byte[] bkeys = new String(f).getBytes();  
        byte[] enk = new byte[24];  
        for (int i=0;i<24;i++){  
            enk[i] = bkeys[i];  
        }  
        return enk;  
    }


	/**
	 * 3des加密
	 * 
	 * @param key
	 * @param srcStr
	 * @return
	 */
	public static String encode3Des(String key, String srcStr) {
		byte[] keybyte = hexStringToByte(key);
		byte[] src = srcStr.getBytes();
		try {
			// 生成密钥
			SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
			// 加密
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, deskey);
			String pwd = Base64.encodeBase64String(cipher.doFinal(src));
			return pwd;
		} catch (Exception e) {
			log.error("====== 3DES encode error ======");
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 3DES解密
	 * 
	 * @param key    加密密钥，长度为24字节
	 * @param desStr 解密后的字符串
	 * @return
	 *
	 * 		lee on 2017-08-09 10:52:54
	 */
	public static String decode3Des(String key, String desStr) {
		Base64 base64 = new Base64();
		byte[] keybyte = hexStringToByte(key);
		byte[] src = base64.decode(desStr);
		try {
			SecretKey deskey = new SecretKeySpec(keybyte, "DESede");
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.DECRYPT_MODE, deskey);
			String pwd = new String(cipher.doFinal(src));
			return pwd;
		}  catch (Exception e) {
			log.error("====== 3DES decode error ======");
			e.printStackTrace();
		}
		return null;
	}
}
