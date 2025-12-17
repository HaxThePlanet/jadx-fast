package com.google.android.exoplayer2.text.u;

import android.text.TextUtils;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.d0;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class i extends d {

    private final d0 n;
    private final com.google.android.exoplayer2.text.u.e o;
    public i() {
        super("WebvttDecoder");
        d0 d0Var = new d0();
        this.n = d0Var;
        e eVar = new e();
        this.o = eVar;
    }

    private static int C(d0 d0) {
        int i2;
        int i;
        String equals;
        final int i3 = 0;
        final int i4 = -1;
        i = i3;
        i2 = i4;
        while (i2 == i4) {
            i = d0.e();
            String str = d0.o();
            if (str == null) {
            } else {
            }
            if ("STYLE".equals(str)) {
            } else {
            }
            if (str.startsWith("NOTE")) {
            } else {
            }
            i2 = 3;
            i2 = 1;
            i2 = 2;
            i2 = i3;
        }
        d0.I(i);
        return i2;
    }

    private static void D(d0 d0) {
        while (!TextUtils.isEmpty(d0.o())) {
        }
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f z(byte[] bArr, int i2, boolean z3) {
        int i;
        d0 obj3;
        d0 obj4;
        this.n.G(bArr, i2);
        ArrayList obj2 = new ArrayList();
        j.e(this.n);
        while (TextUtils.isEmpty(this.n.o()) == null) {
        }
        obj3 = new ArrayList();
        obj4 = i.C(this.n);
        while (obj4 != null) {
            obj4 = h.m(this.n, obj2);
            if (obj4 == 3 && obj4 != null) {
            }
            obj4 = i.C(this.n);
            obj4 = h.m(this.n, obj2);
            if (obj4 != null) {
            }
            obj3.add(obj4);
            this.n.o();
            obj2.addAll(this.o.d(this.n));
            i.D(this.n);
        }
        obj2 = new k(obj3);
        return obj2;
    }
}
