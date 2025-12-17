package com.google.android.exoplayer2.m2.l;

import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.m2.d;
import com.google.android.exoplayer2.m2.g;
import com.google.android.exoplayer2.util.c0;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.m0;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class c extends g {

    private final d0 a;
    private final c0 b;
    private m0 c;
    public c() {
        super();
        d0 d0Var = new d0();
        this.a = d0Var;
        c0 c0Var = new c0();
        this.b = c0Var;
    }

    @Override // com.google.android.exoplayer2.m2.g
    protected a b(d d, ByteBuffer byteBuffer2) {
        int m0Var;
        int aVar;
        long l;
        d0 i;
        long l2;
        com.google.android.exoplayer2.m2.l.a eVar;
        int d0Var;
        int obj7;
        a obj8;
        m0Var = this.c;
        if (m0Var != null) {
            if (Long.compare(l, l2) != 0) {
                m0Var = new m0(d.w, obj2);
                this.c = m0Var;
                m0Var.a(l5 -= l2);
            }
        } else {
        }
        obj7 = byteBuffer2.array();
        obj8 = byteBuffer2.limit();
        this.a.G(obj7, obj8);
        this.b.n(obj7, obj8);
        this.b.q(39);
        obj8 = 1;
        obj7 = 32;
        i2 |= l6;
        this.b.q(20);
        i = this.b.h(8);
        eVar = 0;
        this.a.J(14);
        if (i != 0) {
            if (i != 255) {
                if (i != 4) {
                    if (i != 5) {
                        if (i != 6) {
                        } else {
                            eVar = g.a(this.a, aVar, l);
                        }
                    } else {
                        eVar = d.a(this.a, aVar, l);
                    }
                } else {
                    eVar = f.a(this.a);
                }
            } else {
                eVar = a.a(this.a, this.b.h(12), aVar);
            }
        } else {
            eVar = new e();
        }
        obj7 = 0;
        if (eVar == null) {
            obj8 = new a(new a.b[obj7]);
        } else {
            obj8 = new a.b[obj8];
            obj8[obj7] = eVar;
            aVar = new a(obj8);
            obj8 = aVar;
        }
        return obj8;
    }
}
