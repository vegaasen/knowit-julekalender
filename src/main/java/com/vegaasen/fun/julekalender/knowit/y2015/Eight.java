package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Vi definerer et primtall som et MIRPTALL dersom vi fortsatt har er primtall når sifrene reverseres.
 * Regelen gjelder imidlertid ikke dersom tallet samtidig er et palindrom (dvs likt samme hvilken ende det leses fra, som 969).
 * <p>
 * Eksempel 1: 13 er et primtall. Det er også et MIRPTALL, fordi tallet i revers, 31, også er et primtall.
 * Eksempel 2: 23 er et primtall. Det er imidlertid ikke et MIRPTALL, da vi får 32 om vi reverserer det, som ikke er et primtall.
 * Eksempel 3: 5 og 101 er ikke MIRPTALL, selv om de er primtall, da disse er palindromer.
 * <p>
 * Hvor mange positive heltall under 1000 er MIRPTALL?
 * <p>
 * Tips: Selv om 13 og 31 reverseres til hverandre er de fortsatt MIRPTALL “hver for seg” (på grunn av definisjonen).
 * Begge må derfor telles med som en del av resultatet.
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Eight implements OJulMedDinGlede {

    @Override
    public void hohoho() {
        List<Integer> mirp = new ArrayList<>();
        new MeasuredInvocation() {
            @Override
            public void what() {
                for (int i = 0; i <= 1000; i++) {
                    if (isPrime(i)) {
                        int candidatePrime = Integer.parseInt(new StringBuilder(Integer.toString(i)).reverse().toString());
                        if (!isPalindrome(i, candidatePrime) && isPrime(candidatePrime)) {
                            mirp.add(i);
                        }
                    }
                }
            }
        }.execute();
        System.out.println(String.format("Found {%s} mirpNumbers {%s}", mirp.size(), mirp));
    }

    private boolean isPalindrome(int what, int candidate) {
        return what == candidate;
    }

    private boolean isPrime(int candidate) {
        if (candidate > 2 && (candidate & 1) == 0) {
            return false;
        }
        for (int i = 3; i * i <= candidate; i += 2) {
            if (candidate % i == 0) {
                return false;
            }
        }
        return true;
    }

}
