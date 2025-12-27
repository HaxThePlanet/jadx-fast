package net.time4j.engine;

import java.util.Locale;

/* compiled from: FlagElement.java */
/* loaded from: classes3.dex */
public enum a0 implements p<Boolean> {

    DAYLIGHT_SAVING,
    LEAP_SECOND;
    @Override // java.lang.Enum
    public String getDisplayName(Locale locale) {
        return name();
    }

    @Override // java.lang.Enum
    public Class<Boolean> getType() {
        return Boolean.class;
    }

    @Override // java.lang.Enum
    public int compare(o oVar, o oVar2) {
        int i = 0;
        boolean z = oVar.v(this);
        if (z == oVar2.v(this)) {
            i = 0;
        } else {
            oVar = z ? 1 : -1;
        }
        return (z ? 1 : -1);
    }

    @Override // java.lang.Enum
    public Boolean getDefaultMaximum() {
        return Boolean.TRUE;
    }

    @Override // java.lang.Enum
    public Boolean getDefaultMinimum() {
        return Boolean.FALSE;
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
