package com.airbnb.lottie.v.k;

import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.o;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.l.a;

/* compiled from: RectangleShape.java */
/* loaded from: classes.dex */
public class j implements b {

    private final String a;
    private final m<PointF, PointF> b;
    private final m<PointF, PointF> c;
    private final b d;
    private final boolean e;
    public j(String str, m<PointF, PointF> mVar, m<PointF, PointF> mVar2, b bVar, boolean z) {
        super();
        this.a = str;
        this.b = mVar;
        this.c = mVar2;
        this.d = bVar;
        this.e = z;
    }

    public c a(f fVar, a aVar) {
        return new o(fVar, aVar, this);
    }

    public b b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public m<PointF, PointF> d() {
        return this.b;
    }

    public m<PointF, PointF> e() {
        return this.c;
    }

    public boolean f() {
        return this.e;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "RectangleShape{position=";
        String str3 = ", size=";
        str = str2 + this.b + str3 + this.c + 125;
        return str;
    }
}
