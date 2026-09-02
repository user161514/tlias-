package com.itheima.test;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class UserService {
    /**
     * 校验身份证号码是否合法
     * @param idCard 身份证号
     * @return true=合法, false=不合法
     */
    public boolean isValidIdCard(String idCard) {
        if (idCard == null) return false;

        // 1. 长度必须是18位
        if (idCard.length() != 18) return false;

        // 2. 前17位必须是数字
        String id17 = idCard.substring(0, 17);
        if (!id17.matches("\\d{17}")) return false;

        // 3. 最后一位必须是数字或X（大小写均可）
        char last = idCard.charAt(17);
        if (!(last >= '0' && last <= '9' || last == 'X' || last == 'x')) return false;

        // 4. 校验出生日期（第7-14位）
        String birthdayStr = idCard.substring(6, 14);
        if (!isValidDate(birthdayStr)) return false;

        // 5. 校验最后一位（校验码）
        return verifyCheckCode(idCard);
    }

    /**
     * 校验出生日期是否合法
     */
    private  boolean isValidDate(String yyyyMMdd) {
        try {
            LocalDate.parse(yyyyMMdd, DateTimeFormatter.ofPattern("yyyyMMdd"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    /**
     * 校验最后一位（ISO 7064:1983.MOD 11-2）
     */
    private  boolean verifyCheckCode(String idCard) {
        // 权重因子
        int[] weights = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        // 校验码映射
        char[] checkCodes = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += (idCard.charAt(i) - '0') * weights[i];
        }
        int mod = sum % 11;
        char expected = checkCodes[mod];

        char actual = Character.toUpperCase(idCard.charAt(17));
        return expected == actual;
    }

    /**
     * 从身份证提取性别
     * @param idCard 18位身份证
     * @return "男" 或 "女"
     */
    public String getGender(String idCard) {
        if (!isValidIdCard(idCard)) {
            throw new IllegalArgumentException("无效的身份证号码");
        }
        // 第17位（倒数第二位）奇数=男，偶数=女
        int genderFlag = idCard.charAt(16) - '0';
        return genderFlag % 2 == 1 ? "男" : "女";
    }

    /**
     * 从身份证提取年龄（周岁）
     */
    public int getAge(String idCard) {
        if (!isValidIdCard(idCard)) {
            throw new IllegalArgumentException("无效的身份证号码");
        }
        String birthday = idCard.substring(6, 14);
        LocalDate birthDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("yyyyMMdd"));
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}