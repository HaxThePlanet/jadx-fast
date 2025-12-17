package com.airbnb.lottie.v.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.d;
import com.airbnb.lottie.v.l.a;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class n implements com.airbnb.lottie.v.k.b {

    private final String a;
    private final List<com.airbnb.lottie.v.k.b> b;
    private final boolean c;
    public n(String string, List<com.airbnb.lottie.v.k.b> list2, boolean z3) {
        super();
        this.a = string;
        this.b = list2;
        this.c = z3;
    }

    @Override // com.airbnb.lottie.v.k.b
    public c a(f f, a a2) {
        d dVar = new d(f, a2, this);
        return dVar;
    }

    public List<com.airbnb.lottie.v.k.b> b() {
        return this.b;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String c() {
        return this.a;
    }

    @Override // com.airbnb.lottie.v.k.b
    public boolean d() {
        return this.c;
    }

    @Override // com.airbnb.lottie.v.k.b
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ShapeGroup{name='");
        stringBuilder.append(this.a);
        stringBuilder.append("' Shapes: ");
        stringBuilder.append(Arrays.toString(this.b.toArray()));
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
