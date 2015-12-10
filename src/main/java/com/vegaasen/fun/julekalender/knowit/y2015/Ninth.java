package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Ninth implements OJulMedDinGlede {

    private static final int ALPHABET_LENGTH = 26;
    private static final long EXCEL_COLUMN_LENGTH = 142453146368L;

    @Override
    public void hohoho() {
        new MeasuredInvocation(9) {
            @Override
            public void what() {
                System.out.println(String.format("What {%s}", findMeTheExcelColumnTitle(EXCEL_COLUMN_LENGTH)));
            }
        }.execute();
    }

    public static String findMeTheExcelColumnTitle(long columnLenght) {
        StringBuilder excelColumnTitle = new StringBuilder();
        while (columnLenght-- > 0) {
            excelColumnTitle.append((char) ((int) 'A' + (columnLenght % ALPHABET_LENGTH)));
            columnLenght /= ALPHABET_LENGTH;
        }
        return excelColumnTitle.reverse().toString();
    }

}
