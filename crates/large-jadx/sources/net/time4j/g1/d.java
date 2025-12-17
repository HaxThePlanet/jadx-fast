package net.time4j.g1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.time4j.engine.e;

/* loaded from: classes3.dex */
public abstract class d<V extends Comparable<V>>  extends e<V> {

    private static final Map<String, String> a;
    static {
        HashMap hashMap = new HashMap();
        hashMap.put("YEAR_OF_DISPLAY", "L_year");
        hashMap.put("MONTH_AS_NUMBER", "L_month");
        hashMap.put("HOUR_FROM_0_TO_24", "L_hour");
        String str9 = "L_day";
        hashMap.put("DAY_OF_MONTH", str9);
        hashMap.put("DAY_OF_DIVISION", str9);
        d.a = Collections.unmodifiableMap(hashMap);
    }

    protected d(String string) {
        super(string);
    }
}
