package com.airbnb.lottie.v.k;

import com.airbnb.lottie.f;
import com.airbnb.lottie.t.b.c;
import com.airbnb.lottie.t.b.d;
import com.airbnb.lottie.v.l.a;
import java.util.Arrays;
import java.util.List;

/* compiled from: ShapeGroup.java */
/* loaded from: classes.dex */
public class n implements b {

    private final String a;
    private final List<b> b;
    private final boolean c;
    public n(String str, List<b> list, boolean z) {
        super();
        this.a = str;
        this.b = list;
        this.c = z;
    }

    public c a(f fVar, a aVar) {
        return new d(fVar, aVar, this);
    }

    public List<b> b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public boolean d() {
        return this.c;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "ShapeGroup{name='";
        String str4 = "' Shapes: ";
        String str5 = Arrays.toString(this.b.toArray());
        str = str2 + this.a + str4 + str5 + 125;
        return str;
    }
}
