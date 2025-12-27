package com.airbnb.lottie.v.k;

import android.graphics.PointF;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.l.a;

/* compiled from: CircleShape.java */
/* loaded from: classes.dex */
public class a implements b {

    private final String a;
    private final m<PointF, PointF> b;
    private final com.airbnb.lottie.v.j.f c;
    private final boolean d;
    private final boolean e;
    public a(String str, m<PointF, PointF> mVar, com.airbnb.lottie.v.j.f fVar, boolean z, boolean z2) {
        super();
        this.a = str;
        this.b = mVar;
        this.c = fVar;
        this.d = z;
        this.e = z2;
    }

    public c a(com.airbnb.lottie.f fVar, a aVar) {
        return new f(fVar, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public m<PointF, PointF> c() {
        return this.b;
    }

    public com.airbnb.lottie.v.j.f d() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.d;
    }
}
