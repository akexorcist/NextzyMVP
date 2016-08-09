package com.nextzy.myais.common.mvp.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * Created by Akexorcist on 8/9/16 AD.
 */
public class NextzyUtility {
    private static NextzyUtility util;

    public static NextzyUtility getInstance() {
        if (util == null) {
            util = new NextzyUtility();
        }
        return util;
    }

    public String getCurrentDateTime(String pattern) {
        if (pattern != null) {
            Calendar calendar = new GregorianCalendar(Locale.getDefault());
            SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
            return sdf.format(calendar.getTime());
        }
        return null;
    }

    public String convertYearAD2BE(String dateTime, String pattern, String language) {
        if (language.equalsIgnoreCase("th")) {
            String year = dateTime.split(pattern)[2];
            String yearTh = String.valueOf(Integer.parseInt(year) + 543);
            dateTime = dateTime.replace(year, yearTh);
        }
        return dateTime;
    }

    public boolean isValidIdCard(String idCard) {
        if (idCard.length() != 13) {
            return false;
        }
        try {
            int sum = 0;
            for (int i = 0; i < 12; i++) {
                sum += Integer.parseInt(String.valueOf(idCard.charAt(i))) * (13 - i);
            }
            return idCard.charAt(12) - '0' == ((11 - (sum % 11)) % 10);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String wrapBlank(String str) {
        return (str == null || "null".equalsIgnoreCase(str) || str.equals("-")) ? "" : str.trim();
    }

    public boolean isMobileNumber(String str) {
        return (str != null && str.length() == 10 && str.charAt(0) == '0');
    }

    public boolean isOTP(String str) {
        return (str != null && str.length() == 4);
    }

    public boolean isUrl(String text) {
        try {
            new URL(text);
            return true;
        } catch (MalformedURLException e) {
        }
        return false;
    }

    public static boolean isNumeric(String string) {
        if (string == null || string.isEmpty())
            return false;

        int l = string.length();
        for (int i = 0; i < l; i++) {
            if (!Character.isDigit(string.codePointAt(i)))
                return false;
        }
        return true;
    }

    public String convertMsisdn(String msisdn) {
        return msisdn.startsWith("66") ? msisdn.replaceFirst("^66", "0") : msisdn;
    }

    public String joinStringWithSeparator(List<String> list, String separator) {
        StringBuilder b = new StringBuilder();
        for (String item : list) {
            b.append(separator).append(item);
        }
        return b.toString().substring(separator.length());
    }

    public String removeHtmlLastNewLine(String str) {
        return str != null && str.endsWith("<br>") ? str.substring(0, str.length() - "<br>".length()) : str;
    }
}

