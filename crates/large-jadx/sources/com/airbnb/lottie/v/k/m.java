package com.airbnb.lottie.v.k;

import android.graphics.Path.FillType;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.g;
import com.airbnb.lottie.v.j.a;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.l.a;

/* loaded from: classes.dex */
public class m implements com.airbnb.lottie.v.k.b {

    private final boolean a;
    private final Path.FillType b;
    private final String c;
    private final a d;
    private final d e;
    private final boolean f;
    public m(String string, boolean z2, Path.FillType path$FillType3, a a4, d d5, boolean z6) {
        super();
        this.c = string;
        this.a = z2;
        this.b = fillType3;
        this.d = a4;
        this.e = d5;
        this.f = z6;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c a(f f, a a2) {
        g gVar = new g(f, a2, this);
        return gVar;
    }

    @Override // com.airbnb.lottie.v.k.b
    public a b() {
        return this.d;
    }

    @Override // com.airbnb.lottie.v.k.b
    public Path.FillType c() {
        return this.b;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String d() {
        return this.c;
    }

    @Override // com.airbnb.lottie.v.k.b
    public d e() {
        return this.e;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean f() {
        return this.f;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeFill{color=, fillEnabled=");
        stringBuilder.append(this.a);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
