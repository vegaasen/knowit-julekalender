package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Finn summen av alle positive heltall mellom 0 og 1000 som er har 7 som en primtallsfaktor,
 * der det reverserte tallet også har 7 som en primtallsfaktor.
 * <p>
 * For eksempel teller 259 da en får 952 om en reverserer sifrene og begge disse tallene har 7 som en primtallsfaktor.
 * <p>
 * Solution is quite verbose, but yeye /care :P
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Seventh implements OJulMedDinGlede {

    public static final int SEVENTH = 7;

    @Override
    public void hohoho() {
        List<Integer> primeFun = new ArrayList<>();
        new MeasuredInvocation() {
            @Override
            public void what() {
                for (int i = 1000; i >= 0; i--) {
                    if (primolini(i).contains(SEVENTH) && primolini(Integer.parseInt(new StringBuilder(Integer.toString(i)).reverse().toString())).contains(SEVENTH)) {
                        primeFun.add(i);
                    }
                }
            }
        }.execute();
        System.out.println(String.format("{%s} items found. These are {%s}. Sum {%s}",
                primeFun.size(),
                primeFun,
                primeFun.parallelStream().mapToInt(Integer::intValue).sum()));
    }

    private List<Integer> primolini(long candidate) {
        List<Integer> factors = new ArrayList<>();
        long primeCandidate = candidate;
        for (int i = 3; i <= primeCandidate; i++) {
            if (primeCandidate % i == 0) {
                factors.add(i);
                primeCandidate /= i;
                i--;
            }
        }
        return factors;
    }

}
