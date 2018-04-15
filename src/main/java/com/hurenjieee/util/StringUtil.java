package com.hurenjieee.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description: TODO
 * @Author: JackKuang
 * @Since: 2018年4月15日下午5:20:32  
 */
public class StringUtil {

    static Pattern p = Pattern.compile("\\s*|\t|\r|\n");;

    public static String getStringNoBlank(String str){
        if (str != null && !"".equals(str)) {
            Matcher m = p.matcher(str);
            String strNoBlank = m.replaceAll("");
            return strNoBlank;
        } else {
            return str;
        }
    }
}
