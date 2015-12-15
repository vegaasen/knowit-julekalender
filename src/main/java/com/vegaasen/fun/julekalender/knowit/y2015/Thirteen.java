package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;

import java.util.ArrayList;
import java.util.List;

/**
 * unsolved. didn't bother spending more time on it.
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Thirteen implements OJulMedDinGlede {

    private static final int MAX_NUM = 10_000;
    private static final int[] KNALL_TALL = new int[]{2, 3, 5};

    @Override
    public void hohoho() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (isKnall(i)) {
                numbers.add(i);
                if (numbers.size() == MAX_NUM) {
                    break;
                }
            }
        }
        System.out.println(String.format("Knall tall number %s found {%s}", MAX_NUM, numbers.get(MAX_NUM - 1)));
    }

    private boolean isKnall(int candidate) {
        if (candidate == 1) {
            return true;
        }
        for (int knall : KNALL_TALL) {
            if (candidate % knall == 0) {
                return true;
            }
        }
        return false;
    }

}
