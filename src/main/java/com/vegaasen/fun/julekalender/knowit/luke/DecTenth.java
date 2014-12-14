package com.vegaasen.fun.julekalender.knowit.luke;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public final class DecTenth {

    private static final int NUM_OF_ATTENDEES = 1500, UNO = 1, ZERO = 0;

    public static void main(final String... args) {
        doIt();
    }

    private static void doIt() {
        final List<Integer> attendees = Lists.newArrayList();
        for (int seat = UNO; seat < NUM_OF_ATTENDEES + UNO; seat++) {
            attendees.add(seat);
        }
        int candidate = ZERO;
        while (attendees.size() > UNO) {
            attendees.remove((candidate + UNO) % attendees.size());
            candidate =
                    candidate + UNO >= attendees.size() ?
                            ZERO :
                            candidate + UNO;
        }
        System.out.println(String.format("The guy at {%s} is still not drunk as skunk.", attendees.get(0)));
    }

}
