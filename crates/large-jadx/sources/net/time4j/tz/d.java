package net.time4j.tz;

/* compiled from: NameStyle.java */
/* loaded from: classes3.dex */
public enum d {

    LONG_DAYLIGHT_TIME,
    LONG_STANDARD_TIME,
    SHORT_DAYLIGHT_TIME,
    SHORT_STANDARD_TIME;
    @Override // java.lang.Enum
    public boolean isAbbreviation() {
        boolean z = false;
        if (this == d.SHORT_STANDARD_TIME || this == d.SHORT_DAYLIGHT_TIME) {
            int i2 = 1;
        }
        return z;
    }

    @Override // java.lang.Enum
    public boolean isDaylightSaving() {
        boolean z = false;
        if (this == d.SHORT_DAYLIGHT_TIME || this == d.LONG_DAYLIGHT_TIME) {
            int i2 = 1;
        }
        return z;
    }
}
