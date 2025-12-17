package net.time4j.g1.z;

import java.math.BigDecimal;
import java.util.Locale;
import net.time4j.engine.o;
import net.time4j.engine.p;

/* loaded from: classes3.dex */
enum k implements p<BigDecimal> {

    FRACTION;
    @Override // java.lang.Enum
    public int compare(Object object, Object object2) {
        return compare((o)object, (o)object2);
    }

    @Override // java.lang.Enum
    public int compare(o o, o o2) {
        return (BigDecimal)o.p(this).compareTo((BigDecimal)o2.p(this));
    }

    @Override // java.lang.Enum
    public Object getDefaultMaximum() {
        return getDefaultMaximum();
    }

    @Override // java.lang.Enum
    public BigDecimal getDefaultMaximum() {
        return BigDecimal.ONE;
    }

    @Override // java.lang.Enum
    public Object getDefaultMinimum() {
        return getDefaultMinimum();
    }

    @Override // java.lang.Enum
    public BigDecimal getDefaultMinimum() {
        return BigDecimal.ZERO;
    }

    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return name();
    }

    @Override // java.lang.Enum
    public char getSymbol() {
        return 0;
    }

    public Class<BigDecimal> getType() {
        return BigDecimal.class;
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
