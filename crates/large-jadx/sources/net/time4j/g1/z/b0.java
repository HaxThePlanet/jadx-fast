package net.time4j.g1.z;

import java.util.Locale;
import java.util.Map;
import net.time4j.engine.o;
import net.time4j.engine.p;
import net.time4j.g1.b;
import net.time4j.tz.f;
import net.time4j.tz.k;
import net.time4j.tz.p;

/* loaded from: classes3.dex */
enum b0 implements p<k> {

    TIMEZONE_ID,
    TIMEZONE_OFFSET;
    @Override // java.lang.Enum
    public int compare(Object object, Object object2) {
        return compare((o)object, (o)object2);
    }

    @Override // java.lang.Enum
    public int compare(o o, o o2) {
        return o.t().a().compareTo(o2.t().a());
    }

    @Override // java.lang.Enum
    public Object getDefaultMaximum() {
        return getDefaultMaximum();
    }

    @Override // java.lang.Enum
    public k getDefaultMaximum() {
        return p.s(f.AHEAD_OF_UTC, 14);
    }

    @Override // java.lang.Enum
    public Object getDefaultMinimum() {
        return getDefaultMinimum();
    }

    @Override // java.lang.Enum
    public k getDefaultMinimum() {
        return p.s(f.BEHIND_UTC, 14);
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        Object obj2;
        if ((String)b.d(locale).m().get("L_zone") == null) {
            obj2 = name();
        }
        return obj2;
    }

    @Override // java.lang.Enum
    public char getSymbol() {
        return 0;
    }

    public Class<k> getType() {
        return k.class;
    }

    @Override // java.lang.Enum
    public boolean isDateElement() {
        return 0;
    }

    @Override // java.lang.Enum
    public boolean isLenient() {
        return 0;
    }

    @Override // java.lang.Enum
    public boolean isTimeElement() {
        return 0;
    }
}
