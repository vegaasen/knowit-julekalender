package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;
import com.vegaasen.fun.julekalender.utils.PathPrettifier;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Second implements OJulMedDinGlede {

    private static final String STOCKS = "/2015/2_sJVZp7BH.txt";

    @Override
    public void hohoho() {
        new MeasuredInvocation() {
            @Override
            public void what() {
                try {
                    double bestBuy = 0d;
                    List<Double> stocks = Files.lines(PathPrettifier.INSTANCE.getFormattedPath(STOCKS)).map(Double::parseDouble).collect(Collectors.toList());
                    for (int stockIn = 0; stockIn < stocks.size(); stockIn++) {
                        for (int stockOut = stockIn + 1; stockOut < stocks.size(); stockOut++) {
                            double candidateBestBuy = stocks.get(stockOut) - stocks.get(stockIn);
                            if (candidateBestBuy > bestBuy) {
                                bestBuy = candidateBestBuy;
                            }
                        }
                    }
                    System.out.println(String.format("Based on {%s} stocks, the maximums profet lies within {%.4f}", stocks.size(), bestBuy));
                } catch (IOException e) {
                    // *gulp *
                }
            }
        }.execute();
    }

}
