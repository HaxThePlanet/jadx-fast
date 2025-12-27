package com.airbnb.lottie.v.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.q;
import com.airbnb.lottie.v.j.h;
import com.airbnb.lottie.v.l.a;

/* compiled from: ShapePath.java */
/* loaded from: classes.dex */
public class o implements b {

    private final String a;
    private final int b;
    private final h c;
    private final boolean d;
    public o(String str, int i, h hVar, boolean z) {
        super();
        this.a = str;
        this.b = i;
        this.c = hVar;
        this.d = z;
    }

    public c a(f fVar, a aVar) {
        return new q(fVar, aVar, this);
    }

    public String b() {
        return this.a;
    }

    public h c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ShapePath{name=";
        String str4 = ", index=";
        str = str2 + this.a + str4 + this.b + 125;
        return str;
    }
}
