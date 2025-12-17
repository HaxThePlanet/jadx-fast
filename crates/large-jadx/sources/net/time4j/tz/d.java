package net.time4j.tz;

/* loaded from: classes3.dex */
public enum d {

    SHORT_STANDARD_TIME,
    LONG_STANDARD_TIME,
    SHORT_DAYLIGHT_TIME,
    LONG_DAYLIGHT_TIME;
    @Override // java.lang.Enum
    public boolean isAbbreviation() {
        int i;
        net.time4j.tz.d sHORT_STANDARD_TIME;
        if (this != d.SHORT_STANDARD_TIME) {
            if (this == d.SHORT_DAYLIGHT_TIME) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.Enum
    public boolean isDaylightSaving() {
        int i;
        net.time4j.tz.d sHORT_DAYLIGHT_TIME;
        if (this != d.SHORT_DAYLIGHT_TIME) {
            if (this == d.LONG_DAYLIGHT_TIME) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }
}
