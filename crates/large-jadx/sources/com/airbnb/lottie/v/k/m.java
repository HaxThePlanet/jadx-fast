package com.airbnb.lottie.v.k;

import android.graphics.Path.FillType;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.g;
import com.airbnb.lottie.v.j.d;

/* compiled from: ShapeFill.java */
/* loaded from: classes.dex */
public class m implements b {

    private final boolean a;
    private final Path.FillType b;
    private final String c;
    private final com.airbnb.lottie.v.j.a d;
    private final d e;
    private final boolean f;
    public m(String str, boolean z, Path.FillType fillType, com.airbnb.lottie.v.j.a aVar, d dVar, boolean z2) {
        super();
        this.c = str;
        this.a = z;
        this.b = fillType;
        this.d = aVar;
        this.e = dVar;
        this.f = z2;
    }

    public c a(f fVar, com.airbnb.lottie.v.l.a aVar) {
        return new g(fVar, aVar, this);
    }

    public com.airbnb.lottie.v.j.a b() {
        return this.d;
    }

    public Path.FillType c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public d e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ShapeFill{color=, fillEnabled=";
        str = str2 + this.a + 125;
        return str;
    }
}
