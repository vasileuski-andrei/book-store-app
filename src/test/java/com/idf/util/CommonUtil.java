package com.idf.util;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class CommonUtil {

    private static final String ALFA_NUMERICAL = "0123456789abcdefghijklmnopqrstuvwxyz";

    public static String getRandomString(int stringLength) {
        StringBuilder stringBuilder = new StringBuilder(stringLength);
        Random random = new Random();

        for (int i = 0; i < stringLength; i++) {
            stringBuilder.append(ALFA_NUMERICAL.charAt(random.nextInt(ALFA_NUMERICAL.length())));
        }
        return stringBuilder.toString();
    }
}
