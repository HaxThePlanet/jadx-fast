package com.google.android.material.datepicker;

import android.content.Context;
import android.icu.text.DateFormat;
import android.os.Build.VERSION;
import android.text.format.DateUtils;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: classes2.dex */
class f {
    static String a(long l) {
        return f.b(l, obj2);
    }

    static String b(long l, SimpleDateFormat simpleDateFormat2) {
        final Calendar calendar2 = u.q();
        calendar2.setTimeInMillis(l);
        if (obj4 != null) {
            Date date = new Date(l, simpleDateFormat2);
            return obj4.format(date);
        }
        int obj4 = 1;
        if (u.o().get(obj4) == calendar2.get(obj4)) {
            return f.c(l);
        }
        return f.h(l);
    }

    static String c(long l) {
        return f.d(l, obj2);
    }

    static String d(long l, Locale locale2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Date date = new Date(l, locale2);
            return u.c(obj4).format(date);
        }
        Date date2 = new Date(l, locale2);
        return u.j(obj4).format(date2);
    }

    static String e(long l) {
        return f.f(l, obj2);
    }

    static String f(long l, Locale locale2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Date date = new Date(l, locale2);
            return u.d(obj4).format(date);
        }
        Date date2 = new Date(l, locale2);
        return u.h(obj4).format(date2);
    }

    static String g(Context context, long l2) {
        return DateUtils.formatDateTime(context, l2 -= l, obj4);
    }

    static String h(long l) {
        return f.i(l, obj2);
    }

    static String i(long l, Locale locale2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Date date = new Date(l, locale2);
            return u.s(obj4).format(date);
        }
        Date date2 = new Date(l, locale2);
        return u.i(obj4).format(date2);
    }

    static String j(long l) {
        return f.k(l, obj2);
    }

    static String k(long l, Locale locale2) {
        if (Build.VERSION.SDK_INT >= 24) {
            Date date = new Date(l, locale2);
            return u.t(obj4).format(date);
        }
        Date date2 = new Date(l, locale2);
        return u.h(obj4).format(date2);
    }
}
