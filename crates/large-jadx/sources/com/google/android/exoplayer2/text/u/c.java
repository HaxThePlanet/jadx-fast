package com.google.android.exoplayer2.text.u;

import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class c extends d {

    private final d0 n;
    public c() {
        super("Mp4WebvttDecoder");
        d0 d0Var = new d0();
        this.n = d0Var;
    }

    private static c C(d0 d0, int i2) {
        int str;
        int i3;
        Object emptyList;
        int i4;
        int i5;
        int i;
        c obj7;
        int obj8;
        final int i6 = 0;
        i3 = str;
        while (obj8 > 0) {
            int i7 = 8;
            i5 = d0.n();
            i8 -= i7;
            emptyList = p0.B(d0.d(), d0.e(), i9);
            d0.J(i9);
            obj8 -= i9;
            if (i5 == 1937011815) {
            } else {
            }
            if (i5 == 1885436268) {
            }
            str = h.q(i6, emptyList.trim(), Collections.emptyList());
            i3 = h.o(emptyList);
        }
        if (str == null) {
            str = "";
        }
        if (i3 != 0) {
            i3.o(str);
            obj7 = i3.a();
        } else {
            obj7 = h.l(str);
        }
        return obj7;
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f z(byte[] bArr, int i2, boolean z3) {
        int i;
        int obj3;
        d0 obj4;
        this.n.G(bArr, i2);
        ArrayList obj2 = new ArrayList();
        while (this.n.a() > 0) {
            obj3 = this.n.n();
            if (this.n.n() == 1987343459) {
            } else {
            }
            this.n.J(obj3 += -8);
            obj2.add(c.C(this.n, obj3 += -8));
        }
        obj3 = new d(obj2);
        return obj3;
    }
}
