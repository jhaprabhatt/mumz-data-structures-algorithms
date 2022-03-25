package com.mumz.test.dsa;

public class ExcelSheetColumnNumber {


    public static int titleToNumber(String columnTitle) {
        if (columnTitle == null || columnTitle.trim().length() == 0) return 0;
        int length = columnTitle.length() - 1;
        int columnNumber = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            char current = columnTitle.charAt(i);
            columnNumber += ((current - 65) + 1) * Math.pow(26, length - i);
        }
        return columnNumber;
    }

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }
}
