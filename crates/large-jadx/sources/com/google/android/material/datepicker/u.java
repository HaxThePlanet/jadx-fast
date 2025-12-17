package com.google.android.material.datepicker;

import android.content.res.Resources;
import android.icu.text.DateFormat;
import android.icu.util.TimeZone;
import f.c.a.e.j;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
class u {

    static AtomicReference<com.google.android.material.datepicker.t> a;
    static {
        AtomicReference atomicReference = new AtomicReference();
        u.a = atomicReference;
    }

    static long a(long l) {
        final Calendar calendar = u.q();
        calendar.setTimeInMillis(l);
        return u.f(calendar).getTimeInMillis();
    }

    private static int b(String string, String string2, int i3, int i4) {
        int indexOf;
        char charAt;
        int i;
        int obj5;
        while (i4 >= 0) {
            if (i4 < string.length()) {
            }
            if (string2.indexOf(string.charAt(i4)) == -1) {
            }
            int i2 = 39;
            if (string.charAt(i4) == i2) {
            }
            obj5 += i3;
            obj5 += i3;
            while (obj5 >= 0) {
                if (obj5 < string.length()) {
                }
                if (string.charAt(obj5) != i2) {
                }
                obj5 += i3;
            }
            if (obj5 < string.length()) {
            }
            if (string.charAt(obj5) != i2) {
            }
        }
        return i4;
    }

    static DateFormat c(Locale locale) {
        return u.e("MMMd", locale);
    }

    static DateFormat d(Locale locale) {
        return u.e("MMMEd", locale);
    }

    private static DateFormat e(String string, Locale locale2) {
        final DateFormat obj0 = DateFormat.getInstanceForSkeleton(string, locale2);
        obj0.setTimeZone(u.p());
        return obj0;
    }

    static Calendar f(Calendar calendar) {
        Calendar obj4 = u.r(calendar);
        final Calendar calendar2 = u.q();
        calendar2.set(obj4.get(1), obj4.get(2), obj4.get(5));
        return calendar2;
    }

    private static DateFormat g(int i, Locale locale2) {
        final DateFormat obj0 = DateFormat.getDateInstance(i, locale2);
        obj0.setTimeZone(u.n());
        return obj0;
    }

    static DateFormat h(Locale locale) {
        return u.g(0, locale);
    }

    static DateFormat i(Locale locale) {
        return u.g(2, locale);
    }

    static DateFormat j(Locale locale) {
        final DateFormat obj1 = u.i(locale);
        obj1.applyPattern(u.u((SimpleDateFormat)obj1.toPattern()));
        return obj1;
    }

    static SimpleDateFormat k() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat((SimpleDateFormat)DateFormat.getDateInstance(3, Locale.getDefault()).toPattern().replaceAll("\\s+", ""), Locale.getDefault());
        simpleDateFormat.setTimeZone(u.n());
        simpleDateFormat.setLenient(false);
        return simpleDateFormat;
    }

    static String l(Resources resources, SimpleDateFormat simpleDateFormat2) {
        int length;
        String obj6;
        obj6 = simpleDateFormat2.toPattern();
        String str4 = "y";
        if (obj6.replaceAll("[^y]", "").length() == 1) {
            obj6 = obj6.replace(str4, "yyyy");
        }
        return obj6.replace("d", resources.getString(j.E)).replace("M", resources.getString(j.F)).replace(str4, resources.getString(j.G));
    }

    static com.google.android.material.datepicker.t m() {
        Object obj;
        if ((t)u.a.get() == null) {
            obj = t.c();
        }
        return obj;
    }

    private static TimeZone n() {
        return TimeZone.getTimeZone("UTC");
    }

    static Calendar o() {
        Calendar calendar = u.m().a();
        final int i5 = 0;
        calendar.set(11, i5);
        calendar.set(12, i5);
        calendar.set(13, i5);
        calendar.set(14, i5);
        calendar.setTimeZone(u.n());
        return calendar;
    }

    private static TimeZone p() {
        return TimeZone.getTimeZone("UTC");
    }

    static Calendar q() {
        return u.r(0);
    }

    static Calendar r(Calendar calendar) {
        long timeInMillis;
        Calendar instance = Calendar.getInstance(u.n());
        if (calendar == null) {
            instance.clear();
        } else {
            instance.setTimeInMillis(calendar.getTimeInMillis());
        }
        return instance;
    }

    static DateFormat s(Locale locale) {
        return u.e("yMMMd", locale);
    }

    static DateFormat t(Locale locale) {
        return u.e("yMMMEd", locale);
    }

    private static String u(String string) {
        String string2;
        int stringBuilder;
        int i4 = 1;
        int i = u.b(string, "yY", i4, 0);
        if (i >= string.length()) {
            return string;
        }
        string2 = "EMd";
        final int i6 = u.b(string, string2, i4, i);
        if (i6 < string.length()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(",");
            string2 = stringBuilder.toString();
        }
        return string.replace(string.substring(i2 += i4, i6), " ").trim();
    }
}
