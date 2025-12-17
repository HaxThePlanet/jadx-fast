package com.airbnb.lottie.v.k;

import android.graphics.PointF;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.o;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.m;
import com.airbnb.lottie.v.l.a;

/* loaded from: classes.dex */
public class j implements com.airbnb.lottie.v.k.b {

    private final String a;
    private final m<PointF, PointF> b;
    private final m<PointF, PointF> c;
    private final b d;
    private final boolean e;
    public j(String string, m<PointF, PointF> m2, m<PointF, PointF> m3, b b4, boolean z5) {
        super();
        this.a = string;
        this.b = m2;
        this.c = m3;
        this.d = b4;
        this.e = z5;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c a(f f, a a2) {
        o oVar = new o(f, a2, this);
        return oVar;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b b() {
        return this.d;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String c() {
        return this.a;
    }

    public m<PointF, PointF> d() {
        return this.b;
    }

    public m<PointF, PointF> e() {
        return this.c;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean f() {
        return this.e;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RectangleShape{position=");
        stringBuilder.append(this.b);
        stringBuilder.append(", size=");
        stringBuilder.append(this.c);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
