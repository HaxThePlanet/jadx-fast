package com.iterable.iterableapi;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/* compiled from: IterableInboxSession.java */
/* loaded from: classes2.dex */
public class i0 {

    public final Date a;
    public final Date b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final List<i0.a> g;
    public final String h;

    public static class a {

        final String a;
        final boolean b;
        final int c;
        final float d;
        public a(String str, boolean z, int i, float f) {
            super();
            this.a = str;
            this.b = z;
            this.c = i;
            this.d = f;
        }
    }
    public i0(Date date, Date date2, int i, int i2, int i3, int i4, List<i0.a> list) {
        super();
        this.a = date;
        this.b = date2;
        this.c = i;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = list;
        this.h = UUID.randomUUID().toString();
    }

    public i0() {
        super();
        Date date = null;
        this.a = date;
        this.b = date;
        final int i = 0;
        this.c = i;
        this.d = i;
        this.e = i;
        this.f = i;
        this.g = date;
        this.h = UUID.randomUUID().toString();
    }
}
