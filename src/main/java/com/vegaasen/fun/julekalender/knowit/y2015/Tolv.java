package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;

/**
 * Finn summen av alle tall fra og med 1 og til og med 100 000 000 som er har 7 som en divisor,
 * og samtidig IKKE har 5 som en divisor.
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Tolv implements OJulMedDinGlede {

    private static final long MAX_NUM = 100_000_000L;
    private static final int INCREMENTOR = 7;

    @Override
    public void hohoho() {
        final long[] sumOfAllZeNumberz = new long[1];
        new MeasuredInvocation(12) {
            @Override
            public void what() {
                long candidate = 0l;
                for (long i = INCREMENTOR; i < MAX_NUM; i += INCREMENTOR) {
                    if (i % INCREMENTOR == 0 && i % 5 != 0) {
                        candidate += i;
                    }
                }
                sumOfAllZeNumberz[0] = candidate;
            }
        }.execute();
        System.out.println(String.format("The sum or all the various numbers is {%s}", sumOfAllZeNumberz[0]));
    }


}
