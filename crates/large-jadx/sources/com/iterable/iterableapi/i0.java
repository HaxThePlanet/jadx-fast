package com.iterable.iterableapi;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public class i0 {

    public final Date a;
    public final Date b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final List<com.iterable.iterableapi.i0.a> g;
    public final String h;

    public static class a {

        final String a;
        final boolean b;
        final int c;
        final float d;
        public a(String string, boolean z2, int i3, float f4) {
            super();
            this.a = string;
            this.b = z2;
            this.c = i3;
            this.d = f4;
        }
    }
    public i0() {
        super();
        int i = 0;
        this.a = i;
        this.b = i;
        final int i2 = 0;
        this.c = i2;
        this.d = i2;
        this.e = i2;
        this.f = i2;
        this.g = i;
        this.h = UUID.randomUUID().toString();
    }

    public i0(Date date, Date date2, int i3, int i4, int i5, int i6, List<com.iterable.iterableapi.i0.a> list7) {
        super();
        this.a = date;
        this.b = date2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f = i6;
        this.g = list7;
        this.h = UUID.randomUUID().toString();
    }
}
