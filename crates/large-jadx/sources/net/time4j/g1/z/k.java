package net.time4j.g1.z;

import java.math.BigDecimal;
import java.util.Locale;
import net.time4j.engine.o;
import net.time4j.engine.p;

/* compiled from: FractionalElement.java */
/* loaded from: classes3.dex */
enum k implements p<BigDecimal> {

    FRACTION;
    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return name();
    }

    @Override // java.lang.Enum
    public Class<BigDecimal> getType() {
        return BigDecimal.class;
    }

    @Override // java.lang.Enum
    public int compare(o oVar, o oVar2) {
        return (BigDecimal)oVar.p(this).compareTo((BigDecimal)oVar2.p(this));
    }

    @Override // java.lang.Enum
    public BigDecimal getDefaultMaximum() {
        return BigDecimal.ONE;
    }

    @Override // java.lang.Enum
    public BigDecimal getDefaultMinimum() {
        return BigDecimal.ZERO;
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
