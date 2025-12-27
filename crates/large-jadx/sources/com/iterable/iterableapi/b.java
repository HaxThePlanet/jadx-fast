package com.iterable.iterableapi;

import java.util.Date;

/* compiled from: ImpressionData.java */
/* loaded from: classes2.dex */
class b {

    final String a;
    final boolean b;
    int c = 0;
    float d = 0f;
    Date e = null;
    b(String str, boolean z) {
        super();
        this.a = str;
        this.b = z;
    }

    void a() {
        if (this.e != null) {
            this.c++;
            float f2 = 1000f;
            f = (float)(new Date().getTime()) - this.e.getTime() / f2;
            this.d += f;
            Date date = null;
            this.e = date;
        }
    }

    void b() {
        this.e = new Date();
    }
}
