package com.vegaasen.fun.julekalender.knowit.y2015;

import com.google.common.collect.Lists;
import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;

import java.util.stream.Collectors;

/**
 * Gitt en liste med positive heltall, finn det største tallet det er mulig å lage ved å sette sammen alle tallene i lista i valgfri rekkefølge.

 Eksempel 1: [3, 30, 34, 5, 9] => 9534330
 Eksempel 2: [128,12] => 12812
 Eksempel 3: [824,938,1399,5607,6973,5703,9609,4398,8247] => 9609938824824769735703560743981399

 Finn størst mulig tall for listen: [2907, 6165, 6129, 3468, 2040, 4331, 7935, 5683, 6004, 9694, 8092, 188, 5796, 1184, 8873, 3200, 1981, 9556, 9981, 1387, 7802, 8387, 9970, 7326, 5372, 28, 628, 3408, 6, 3425, 3071, 6021, 9989, 5077, 824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247, 5164, 2026, 4, 4468, 9524, 8, 9227, 8969, 1746, 5593]
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Eighteenth implements OJulMedDinGlede {

    @Override
    public void hohoho() {
        new MeasuredInvocation(18) {
            @Override
            public void what() {
                Lists.reverse(Lists.newArrayList(2907, 6165, 6129, 3468, 2040, 4331, 7935, 5683, 6004, 9694, 8092, 188, 5796, 1184, 8873, 3200, 1981, 9556, 9981, 1387, 7802, 8387, 9970, 7326, 5372, 28, 628, 3408, 6, 3425, 3071, 6021, 9989, 5077, 824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247, 5164, 2026, 4, 4468, 9524, 8, 9227, 8969, 1746, 5593).stream().sorted((o1, o2) -> (Integer.toString(o1) + Integer.toString(o2)).compareTo(Integer.toString(o2) + (Integer.toString(o1))) > 0 ? 1 : -1).collect(Collectors.toList())).stream().forEach(System.out::print);
            }
        }.execute();
    }

}
