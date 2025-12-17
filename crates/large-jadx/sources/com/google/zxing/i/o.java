package com.google.zxing.i;

import com.google.zxing.a;
import com.google.zxing.c;
import com.google.zxing.e;
import com.google.zxing.g.b;
import java.util.Map;

/* loaded from: classes2.dex */
public final class o implements e {

    private final com.google.zxing.i.j a;
    public o() {
        super();
        j jVar = new j();
        this.a = jVar;
    }

    public b a(String string, a a2, int i3, int i4, Map<c, ?> map5) {
        if (a2 != a.UPC_A) {
        } else {
            return this.a.a("0".concat(String.valueOf(string)), a.EAN_13, i3, i4, map5);
        }
        IllegalArgumentException obj8 = new IllegalArgumentException("Can only encode UPC-A, but got ".concat(String.valueOf(a2)));
        throw obj8;
    }
}
