package com.google.android.exoplayer2.text;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.decoder.c;
import com.google.android.exoplayer2.decoder.f;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.j1;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.z;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class l extends u0 implements Handler.Callback {

    private final Handler D;
    private final com.google.android.exoplayer2.text.k E;
    private final com.google.android.exoplayer2.text.h F;
    private final j1 G;
    private boolean H;
    private boolean I;
    private boolean J;
    private int K;
    private i1 L;
    private com.google.android.exoplayer2.text.g M;
    private com.google.android.exoplayer2.text.i N;
    private com.google.android.exoplayer2.text.j O;
    private com.google.android.exoplayer2.text.j P;
    private int Q;
    private long R;
    public l(com.google.android.exoplayer2.text.k k, Looper looper2) {
        super(k, looper2, h.a);
    }

    public l(com.google.android.exoplayer2.text.k k, Looper looper2, com.google.android.exoplayer2.text.h h3) {
        int obj2;
        super(3);
        g.e(k);
        this.E = (k)k;
        if (looper2 == null) {
            obj2 = 0;
        } else {
            obj2 = p0.t(looper2, this);
        }
        this.D = obj2;
        this.F = h3;
        obj2 = new j1();
        this.G = obj2;
        this.R = -9223372036854775807L;
    }

    private void S() {
        b0(Collections.emptyList());
    }

    private long T() {
        int i;
        long l;
        if (this.Q == -1) {
            return Long.MAX_VALUE;
        }
        g.e(this.O);
        if (this.Q >= this.O.f()) {
        } else {
            l = this.O.c(this.Q);
        }
        return l;
    }

    private void U(com.google.android.exoplayer2.text.SubtitleDecoderException subtitleDecoderException) {
        String valueOf = String.valueOf(this.L);
        StringBuilder stringBuilder = new StringBuilder(length += 39);
        stringBuilder.append("Subtitle decoding failed. streamFormat=");
        stringBuilder.append(valueOf);
        v.d("TextRenderer", stringBuilder.toString(), subtitleDecoderException);
        S();
        Z();
    }

    private void V() {
        this.J = true;
        final i1 i1Var = this.L;
        g.e(i1Var);
        this.M = this.F.a((i1)i1Var);
    }

    private void W(List<com.google.android.exoplayer2.text.c> list) {
        this.E.u(list);
    }

    private void X() {
        final int i = 0;
        this.N = i;
        this.Q = -1;
        com.google.android.exoplayer2.text.j jVar = this.O;
        if (jVar != null) {
            jVar.s();
            this.O = i;
        }
        com.google.android.exoplayer2.text.j jVar2 = this.P;
        if (jVar2 != null) {
            jVar2.s();
            this.P = i;
        }
    }

    private void Y() {
        X();
        com.google.android.exoplayer2.text.g gVar = this.M;
        g.e(gVar);
        (g)gVar.a();
        this.M = 0;
        this.K = 0;
    }

    private void Z() {
        Y();
        V();
    }

    private void b0(List<com.google.android.exoplayer2.text.c> list) {
        int i;
        Object obj3;
        final Handler handler = this.D;
        if (handler != null) {
            handler.obtainMessage(0, list).sendToTarget();
        } else {
            W(list);
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected void J() {
        this.L = 0;
        this.R = -9223372036854775807L;
        S();
        Y();
    }

    @Override // com.google.android.exoplayer2.u0
    protected void L(long l, boolean z2) {
        int obj1;
        S();
        obj1 = 0;
        this.H = obj1;
        this.I = obj1;
        this.R = -9223372036854775807L;
        if (this.K != 0) {
            Z();
        } else {
            X();
            obj1 = this.M;
            g.e(obj1);
            (g)obj1.flush();
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected void P(i1[] i1Arr, long l2, long l3) {
        int obj1;
        this.L = i1Arr[0];
        if (this.M != null) {
            this.K = 1;
        } else {
            V();
        }
    }

    @Override // com.google.android.exoplayer2.u0
    public boolean a() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.u0
    public void a0(long l) {
        g.f(z());
        this.R = l;
    }

    @Override // com.google.android.exoplayer2.u0
    public int b(i1 i1) {
        int obj2;
        if (this.F.b(i1)) {
            obj2 = i1.W == null ? 4 : 2;
            return a2.r(obj2);
        }
        if (z.p(i1.D)) {
            return a2.r(1);
        }
        return a2.r(0);
    }

    @Override // com.google.android.exoplayer2.u0
    public boolean c() {
        return this.I;
    }

    @Override // com.google.android.exoplayer2.u0
    public String getName() {
        return "TextRenderer";
    }

    @Override // com.google.android.exoplayer2.u0
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
        } else {
            W((List)message.obj);
            return 1;
        }
        IllegalStateException obj2 = new IllegalStateException();
        throw obj2;
    }

    @Override // com.google.android.exoplayer2.u0
    public void u(long l, long l2) {
        long l3;
        long cmp;
        long l5;
        com.google.android.exoplayer2.text.j cmp3;
        boolean cmp2;
        long l4;
        long obj9;
        int obj10;
        boolean obj11;
        final int obj12 = 1;
        l3 = this.R;
        if (z() && Long.compare(l3, cmp) != 0 && Long.compare(l, l3) >= 0) {
            l3 = this.R;
            if (Long.compare(l3, cmp) != 0) {
                if (Long.compare(l, l3) >= 0) {
                    X();
                    this.I = obj12;
                }
            }
        }
        if (this.I) {
        }
        if (this.P == null) {
            obj11 = this.M;
            g.e(obj11);
            (g)obj11.b(l);
            obj11 = this.M;
            g.e(obj11);
            this.P = (j)(g)obj11.c();
        }
        int i = 2;
        if (getState() != i) {
        }
        final int i2 = 0;
        if (this.O != null) {
            l5 = T();
            obj11 = i2;
            while (Long.compare(l5, l) <= 0) {
                this.Q = obj11 += obj12;
                l5 = T();
                obj11 = obj12;
            }
        } else {
            obj11 = i2;
        }
        cmp3 = this.P;
        final int i3 = 0;
        if (cmp3 != null) {
            if (cmp3.p()) {
                if (obj11 == null && Long.compare(cmp2, l4) == 0) {
                    if (Long.compare(cmp2, l4) == 0) {
                        if (this.K == i) {
                            Z();
                        } else {
                            X();
                            this.I = obj12;
                        }
                    }
                }
            } else {
                obj11 = this.O;
                if (Long.compare(l6, l) <= 0 && obj11 != null) {
                    obj11 = this.O;
                    if (obj11 != null) {
                        obj11.s();
                    }
                    this.Q = cmp3.a(l);
                    this.O = cmp3;
                    this.P = i3;
                    obj11 = obj12;
                }
            }
        }
        if (obj11 != null) {
            g.e(this.O);
            b0(this.O.e(l));
        }
        if (this.K == i) {
        }
        while (!this.H) {
            obj10 = Q(this.G, obj9, i2);
            obj10 = obj10.b;
            obj9.A = obj10.H;
            obj9.u();
            if (!obj9.q()) {
            } else {
            }
            obj11 = i2;
            this.J = obj10 &= obj11;
            if (!this.J) {
            }
            obj10 = this.M;
            g.e(obj10);
            (g)obj10.e(obj9);
            this.N = i3;
            obj11 = obj12;
            this.H = obj12;
            this.J = i2;
            obj9 = this.M;
            g.e(obj9);
            obj9 = (g)obj9.d();
            this.N = (i)obj9;
        }
    }
}
