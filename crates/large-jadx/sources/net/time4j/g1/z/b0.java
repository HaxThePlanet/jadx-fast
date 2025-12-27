package net.time4j.g1.z;

import java.util.Locale;
import java.util.Map;
import net.time4j.engine.o;
import net.time4j.g1.b;
import net.time4j.tz.f;
import net.time4j.tz.k;

/* compiled from: TimezoneElement.java */
/* loaded from: classes3.dex */
enum b0 implements net.time4j.engine.p<k> {

    TIMEZONE_ID,
    TIMEZONE_OFFSET;
    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        Object value;
        if ((String)b.d(locale).m().get("L_zone") == null) {
            String name = name();
        }
        return value;
    }

    @Override // java.lang.Enum
    public Class<k> getType() {
        return k.class;
    }

    @Override // java.lang.Enum
    public int compare(o oVar, o oVar2) {
        return oVar.t().a().compareTo(oVar2.t().a());
    }

    @Override // java.lang.Enum
    public k getDefaultMaximum() {
        return p.s(f.AHEAD_OF_UTC, 14);
    }

    @Override // java.lang.Enum
    public k getDefaultMinimum() {
        return p.s(f.BEHIND_UTC, 14);
    }

    @Override // java.lang.Enum
    public char getSymbol() {
        return 0;
    }

    @Override // java.lang.Enum
    public boolean isDateElement() {
        return false;
    }

    @Override // java.lang.Enum
    public boolean isLenient() {
        return false;
    }

    @Override // java.lang.Enum
    public boolean isTimeElement() {
        return false;
    }
}
