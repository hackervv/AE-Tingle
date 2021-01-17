package com.tingle.api.service;

import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/17/22:45
 * @Description:
 */
public class MD5Util {
    
    public final static String MD5(String s) {
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        try {
            byte[] btInput = s.getBytes();
            // Get the message digest object of MD5 digest algorithm
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // Update summary with specified bytes update summary with specified bytes
            mdInst.update(btInput);
            // get cipherText
            byte[] md = mdInst.digest();
            // convert cipherText to hexadecimal String from hex
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
