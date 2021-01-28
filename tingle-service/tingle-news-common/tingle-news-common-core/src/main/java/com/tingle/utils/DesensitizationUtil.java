package com.tingle.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Irecck
 * @Date: 2021/01/20/0:27
 * @Description:
 */
public class DesensitizationUtil {
    /**
     * Only the first Chinese character is displayed and the others are hidden as 2 asterisks<for
     * example：李**>
     *
     * @param fullName
     * @param index    1 Desensitization for indexth
     * @return
     */
    public static String left(String fullName, int index) {
        if (StringUtils.isBlank(fullName)) {
            return "";
        }
        String name = StringUtils.left(fullName, index);
        return StringUtils.rightPad(name, StringUtils.length(fullName), "*");
    }
    
    /**
     * 3-bit plaintext is reserved at the front and 2-bit plaintext is reserved at the back
     *
     * @param name
     * @param index 3
     * @param end   2
     * @return
     */
    public static String around(String name, int index, int end) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        return StringUtils.left(name, index).concat(StringUtils.removeStart(StringUtils.leftPad(StringUtils.right(name, end), StringUtils.length(name), "*"), "***"));
    }
    
    /**
     * Show the last four digits and hide others<for example：****1234>
     *
     * @param num
     * @return
     */
    public static String right(String num, int end) {
        if (StringUtils.isBlank(num)) {
            return "";
        }
        return StringUtils.leftPad(StringUtils.right(num, end), StringUtils.length(num), "*");
    }
    
    /**
     * Desensitization of top three and bottom four mobile phone numbers
     *
     * @param mobile
     * @return
     */
    public static String mobileEncrypt(String mobile) {
        if (StringUtils.isEmpty(mobile) || (mobile.length() != 11)) {
            return mobile;
        }
        return mobile.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2");
    }
    
    /**
     * Desensitization of top three and bottom four of ID card
     *
     * @param id
     * @return
     */
    public static String idEncrypt(String id) {
        if (StringUtils.isEmpty(id) || (id.length() < 8)) {
            return id;
        }
        return id.replaceAll("(?<=\\w{3})\\w(?=\\w{4})", "*");
    }
    
    /**
     * The first two and the last three passport desensitization, passport is generally 8 or 9
     *
     * @param id
     * @return
     */
    public static String idPassport(String id) {
        if (StringUtils.isEmpty(id) || (id.length() < 8)) {
            return id;
        }
        return id.substring(0, 2) + new String(new char[id.length() - 5]).replace("\0", "*") + id.substring(id.length() - 3);
    }
    
    /**
     * Desensitization of the last few
     *
     * @param id
     * @param sensitiveSize
     * @return
     */
    public static String idPassport(String id, int sensitiveSize) {
        if (StringUtils.isBlank(id)) {
            return "";
        }
        int length = StringUtils.length(id);
        return StringUtils.rightPad(StringUtils.left(id, length - sensitiveSize), length, "*");
    }
}
