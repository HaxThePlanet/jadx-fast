package com.airbnb.lottie.v.k;

import android.graphics.Path.FillType;
import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.h;
import com.airbnb.lottie.v.j.b;
import com.airbnb.lottie.v.j.c;
import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.j.f;
import com.airbnb.lottie.v.l.a;

/* loaded from: classes.dex */
public class d implements com.airbnb.lottie.v.k.b {

    private final com.airbnb.lottie.v.k.f a;
    private final Path.FillType b;
    private final c c;
    private final d d;
    private final f e;
    private final f f;
    private final String g;
    private final boolean h;
    public d(String string, com.airbnb.lottie.v.k.f f2, Path.FillType path$FillType3, c c4, d d5, f f6, f f7, b b8, b b9, boolean z10) {
        super();
        this.a = f2;
        this.b = fillType3;
        this.c = c4;
        this.d = d5;
        this.e = f6;
        this.f = f7;
        this.g = string;
        this.h = z10;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c a(f f, a a2) {
        h hVar = new h(f, a2, this);
        return hVar;
    }

    @Override // com.airbnb.lottie.v.k.b
    public f b() {
        return this.f;
    }

    @Override // com.airbnb.lottie.v.k.b
    public Path.FillType c() {
        return this.b;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c d() {
        return this.c;
    }

    @Override // com.airbnb.lottie.v.k.b
    public com.airbnb.lottie.v.k.f e() {
        return this.a;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String f() {
        return this.g;
    }

    @Override // com.airbnb.lottie.v.k.b
    public d g() {
        return this.d;
    }

    @Override // com.airbnb.lottie.v.k.b
    public f h() {
        return this.e;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean i() {
        return this.h;
    }
}
