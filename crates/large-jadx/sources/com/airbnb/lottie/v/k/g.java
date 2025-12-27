package com.airbnb.lottie.v.k;

import com.airbnb.lottie.v.j.d;
import com.airbnb.lottie.v.j.h;

/* compiled from: Mask.java */
/* loaded from: classes.dex */
public class g {

    private final g.a a;
    private final h b;
    private final d c;
    private final boolean d;

    public enum a {

        MASK_MODE_ADD,
        MASK_MODE_INTERSECT,
        MASK_MODE_NONE,
        MASK_MODE_SUBTRACT;
    }
    public g(g.a aVar, h hVar, d dVar, boolean z) {
        super();
        this.a = aVar;
        this.b = hVar;
        this.c = dVar;
        this.d = z;
    }

    public g.a a() {
        return this.a;
    }

    public h b() {
        return this.b;
    }

    public d c() {
        return this.c;
    }

    public boolean d() {
        return this.d;
    }
}
