package com.airbnb.lottie.v.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.p;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.l;
import com.airbnb.lottie.v.l.a;

/* loaded from: classes.dex */
public class k implements com.airbnb.lottie.v.k.b {

    private final String a;
    private final b b;
    private final b c;
    private final l d;
    private final boolean e;
    public k(String string, b b2, b b3, l l4, boolean z5) {
        super();
        this.a = string;
        this.b = b2;
        this.c = b3;
        this.d = l4;
        this.e = z5;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c a(f f, a a2) {
        p pVar = new p(f, a2, this);
        return pVar;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b b() {
        return this.b;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String c() {
        return this.a;
    }

    @Override // com.airbnb.lottie.v.k.b
    public b d() {
        return this.c;
    }

    @Override // com.airbnb.lottie.v.k.b
    public l e() {
        return this.d;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean f() {
        return this.e;
    }
}
