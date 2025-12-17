package com.airbnb.lottie.v.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.q;
import com.airbnb.lottie.v.j.h;
import com.airbnb.lottie.v.l.a;

/* loaded from: classes.dex */
public class o implements com.airbnb.lottie.v.k.b {

    private final String a;
    private final int b;
    private final h c;
    private final boolean d;
    public o(String string, int i2, h h3, boolean z4) {
        super();
        this.a = string;
        this.b = i2;
        this.c = h3;
        this.d = z4;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c a(f f, a a2) {
        q qVar = new q(f, a2, this);
        return qVar;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String b() {
        return this.a;
    }

    @Override // com.airbnb.lottie.v.k.b
    public h c() {
        return this.c;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean d() {
        return this.d;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapePath{name=");
        stringBuilder.append(this.a);
        stringBuilder.append(", index=");
        stringBuilder.append(this.b);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
