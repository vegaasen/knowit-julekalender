package com.vegaasen.fun.julekalender.knowit.y2015;

import com.vegaasen.fun.julekalender.service.OJulMedDinGlede;
import com.vegaasen.fun.julekalender.utils.MeasuredInvocation;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * Da Kongeriket Norge har kommet frem til at de er best i verden har de funnet ut at de skal redefinere epoken for Unixtid.
 * Den nye epoken er definert til å være 17. mai 1814 kl 13:37:14.
 * <p>
 * Finn ut hva timestampen for 17. september 2015 kl 17:15:00 er med denne omdefinerte epoken.
 * Vi antar at skuddsekunder ikke eksisterer, og at dagens regler for skuddår har vært gjeldende hele perioden.
 * Hint: Det er ikke sikkert diverse kalenderverktøy er spesielt nøyaktige på tidspunkter så langt tilbake i tid.
 *
 * @author <a href="vegaasen@gmail.com">vegardaasen</a>
 */
public class Seventeenth implements OJulMedDinGlede {

    private static final String UTC = "UTC";

    @Override
    public void hohoho() {
        TimeZone.setDefault(TimeZone.getTimeZone(UTC));
        new MeasuredInvocation(17) {
            @Override
            public void what() {
                System.out.println(String.format("New and redefined epoch {%s}", new GregorianCalendar(2015, Calendar.SEPTEMBER, 17, 17, 15, 0).getTimeInMillis() - new GregorianCalendar(1814, Calendar.MAY, 17, 13, 37, 14).getTimeInMillis()));
            }
        }.execute();
    }
}
