package com.google.android.material.datepicker;

import java.util.Calendar;
import java.util.TimeZone;

/* loaded from: classes2.dex */
class t {

    private static final com.google.android.material.datepicker.t c;
    private final Long a;
    private final TimeZone b;
    static {
        final int i = 0;
        t tVar = new t(i, i);
        t.c = tVar;
    }

    private t(Long long, TimeZone timeZone2) {
        super();
        this.a = long;
        this.b = timeZone2;
    }

    static com.google.android.material.datepicker.t c() {
        return t.c;
    }

    Calendar a() {
        return b(this.b);
    }

    Calendar b(TimeZone timeZone) {
        Long longValue;
        Calendar obj3;
        if (timeZone == null) {
            obj3 = Calendar.getInstance();
        } else {
            obj3 = Calendar.getInstance(timeZone);
        }
        longValue = this.a;
        if (longValue != null) {
            obj3.setTimeInMillis(longValue.longValue());
        }
        return obj3;
    }
}
