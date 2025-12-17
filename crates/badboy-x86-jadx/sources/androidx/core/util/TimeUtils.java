package androidx.core.util;

import java.io.PrintWriter;

/* loaded from: classes5.dex */
public final class TimeUtils {

    public static final int HUNDRED_DAY_FIELD_LEN = 19;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    private static char[] sFormatStr;
    private static final Object sFormatSync;
    static {
        Object object = new Object();
        TimeUtils.sFormatSync = object;
        TimeUtils.sFormatStr = new char[24];
    }

    private static int accumField(int amt, int suffix, boolean always, int zeropad) {
        int i2;
        int i;
        if (amt <= 99) {
            if (always && zeropad >= 3) {
                if (zeropad >= 3) {
                } else {
                    if (amt <= 9) {
                        if (always && zeropad >= 2) {
                            if (zeropad >= 2) {
                            } else {
                                if (!always && amt > 0) {
                                    if (amt > 0) {
                                    }
                                    return 0;
                                }
                            }
                        } else {
                        }
                        return suffix + 1;
                    }
                }
            } else {
            }
            return suffix + 2;
        }
        return suffix + 3;
    }

    public static void formatDuration(long time, long now, PrintWriter pw) {
        if (Long.compare(time, i) == 0) {
            obj7.print("--");
        }
        TimeUtils.formatDuration(time - pw, obj1, obj7);
    }

    public static void formatDuration(long duration, PrintWriter pw) {
        TimeUtils.formatDuration(duration, pw, obj3);
    }

    public static void formatDuration(long duration, PrintWriter pw, int fieldLen) {
        final Object sFormatSync = TimeUtils.sFormatSync;
        String string = new String(TimeUtils.sFormatStr, 0, TimeUtils.formatDurationLocked(duration, pw));
        fieldLen.print(string);
        return;
        synchronized (sFormatSync) {
            sFormatSync = TimeUtils.sFormatSync;
            string = new String(TimeUtils.sFormatStr, 0, TimeUtils.formatDurationLocked(duration, pw));
            fieldLen.print(string);
        }
    }

    public static void formatDuration(long duration, StringBuilder builder) {
        final Object sFormatSync = TimeUtils.sFormatSync;
        final int i = 0;
        obj6.append(TimeUtils.sFormatStr, i, TimeUtils.formatDurationLocked(duration, builder));
        return;
        synchronized (sFormatSync) {
            sFormatSync = TimeUtils.sFormatSync;
            i = 0;
            obj6.append(TimeUtils.sFormatStr, i, TimeUtils.formatDurationLocked(duration, builder));
        }
    }

    private static int formatDurationLocked(long duration, int fieldLen) {
        int i2;
        int cArr;
        int prefix;
        int seconds;
        int seconds2;
        int days;
        int myLen;
        int i6;
        int i3;
        int i5;
        int i;
        int hours2;
        int hours;
        int i15;
        int i11;
        int i4;
        int minutes;
        int i16;
        int i7;
        int i8;
        int i9;
        int i12;
        int i10;
        int i13;
        int i17;
        int myLen2;
        int i14;
        int i18;
        i2 = duration;
        int i19 = obj22;
        if (sFormatStr.length < i19) {
            TimeUtils.sFormatStr = new char[i19];
        }
        final char[] sFormatStr2 = TimeUtils.sFormatStr;
        int i22 = 0;
        myLen = 32;
        if (Long.compare(i2, i22) == 0) {
            int i21 = 0;
            while (i21 < i19--) {
                sFormatStr2[i21] = myLen;
            }
            sFormatStr2[i21] = 48;
            return i21 + 1;
        }
        if (Long.compare(i2, i22) > 0) {
            prefix = 43;
        } else {
            prefix = 45;
            i2 = -i2;
        }
        int i25 = 1000;
        final int i44 = (int)i38;
        seconds = (int)floor;
        days = 0;
        i12 = 86400;
        if (seconds > i12) {
            seconds -= i12;
        }
        if (seconds > 3600) {
            hours2 = seconds / 3600;
            seconds -= i46;
            i10 = hours2;
        } else {
            i10 = hours2;
        }
        if (seconds > 60) {
            minutes = seconds / 60;
            i13 = seconds;
            i17 = minutes;
        } else {
            i13 = seconds;
            i17 = minutes;
        }
        seconds2 = 0;
        final int i48 = 2;
        int i39 = 0;
        int i42 = 1;
        if (i19 != 0) {
            int accumField5 = TimeUtils.accumField(days, i42, i39, i39);
            i6 = accumField5 > 0 ? i42 : i39;
            accumField5 += accumField;
            i3 = myLen3 > 0 ? i42 : i39;
            myLen3 += accumField2;
            i5 = myLen4 > 0 ? i42 : i39;
            myLen4 += accumField3;
            i = myLen5 > 0 ? 3 : i39;
            myLen = myLen2;
            while (myLen < i19) {
                sFormatStr2[seconds2] = myLen;
                seconds2++;
                myLen++;
            }
        }
        sFormatStr2[seconds2] = prefix;
        int i35 = seconds2 + 1;
        i14 = i19 != 0 ? i42 : i39;
        int i49 = i39;
        final int i50 = i42;
        int start = days;
        final int i47 = i51;
        int pos3 = TimeUtils.printField(sFormatStr2, start, 'd', i35, false, 0);
        int i52 = start;
        i15 = pos3 != i47 ? i50 : i49;
        i16 = i14 != 0 ? i48 : i49;
        int pos4 = TimeUtils.printField(sFormatStr2, i10, 'h', pos3, i15, i16);
        i11 = pos4 != i47 ? i50 : i49;
        i7 = i14 != 0 ? i48 : i49;
        int pos5 = TimeUtils.printField(sFormatStr2, i17, 'm', pos4, i11, i7);
        i4 = pos5 != i47 ? i50 : i49;
        i8 = i14 != 0 ? i48 : i49;
        int pos6 = TimeUtils.printField(sFormatStr2, i13, 's', pos5, i4, i8);
        if (i14 != 0 && pos6 != i47) {
            i9 = pos6 != i47 ? 3 : i49;
        } else {
        }
        int printField = TimeUtils.printField(sFormatStr2, i44, 'm', pos6, true, i9);
        sFormatStr2[printField] = 115;
        return printField + 1;
    }

    private static int printField(char[] formatStr, int amt, char suffix, int pos, boolean always, int zeropad) {
        int i2;
        int i3;
        int i;
        int obj4;
        int obj6;
        if (!always) {
            if (amt > 0) {
                if (always) {
                    if (zeropad < 3) {
                        if (amt > 99) {
                            i3 = amt / 100;
                            formatStr[pos] = (char)i5;
                            pos++;
                            amt -= i;
                        }
                    } else {
                    }
                } else {
                }
                if (always) {
                    if (zeropad < 2 && obj4 <= 9) {
                        if (obj4 <= 9) {
                            if (pos != obj6) {
                                i3 = obj4 / 10;
                                formatStr[obj6] = (char)i4;
                                obj6++;
                                obj4 -= i;
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
                formatStr[obj6] = (char)dig;
                obj6++;
                formatStr[obj6] = suffix;
                obj6++;
            }
        } else {
        }
        return obj6;
    }
}
