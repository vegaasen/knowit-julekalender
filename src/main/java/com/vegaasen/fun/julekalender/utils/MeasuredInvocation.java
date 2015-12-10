package com.vegaasen.fun.julekalender.utils;

import com.google.common.base.Stopwatch;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public abstract class MeasuredInvocation {

    private final Stopwatch casio;
    private final int luke;

    public MeasuredInvocation(int luke) {
        casio = Stopwatch.createUnstarted();
        this.luke = luke;
    }

    public abstract void what();

    public void execute() {
        casio.start();
        try {
            what();
        } catch (Exception e) {
            //* gulp *
        }
        casio.stop();
        System.out.println(String.format("Luke %s: Invocation took {%sms}", luke, casio.elapsed(TimeUnit.MILLISECONDS)));
    }

}
