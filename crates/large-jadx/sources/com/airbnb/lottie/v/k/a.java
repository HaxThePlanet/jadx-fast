package com.airbnb.lottie.v.k;

import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.f;
import com.airbnb.lottie.v.j.f;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.l.a;

/* loaded from: classes.dex */
public class a implements com.airbnb.lottie.v.k.b {

    private final String a;
    private final m<PointF, PointF> b;
    private final f c;
    private final boolean d;
    private final boolean e;
    public a(String string, m<PointF, PointF> m2, f f3, boolean z4, boolean z5) {
        super();
        this.a = string;
        this.b = m2;
        this.c = f3;
        this.d = z4;
        this.e = z5;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c a(f f, a a2) {
        f fVar = new f(f, a2, this);
        return fVar;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String b() {
        return this.a;
    }

    public m<PointF, PointF> c() {
        return this.b;
    }

    @Override // com.airbnb.lottie.v.k.b
    public f d() {
        return this.c;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean e() {
        return this.e;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean f() {
        return this.d;
    }
}
