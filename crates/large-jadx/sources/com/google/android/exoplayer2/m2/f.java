package com.google.android.exoplayer2.m2;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.a2;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.decoder.a;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.u0;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class f extends u0 implements Handler.Callback {

    private final com.google.android.exoplayer2.m2.c D;
    private final com.google.android.exoplayer2.m2.e E;
    private final Handler F;
    private final com.google.android.exoplayer2.m2.d G;
    private com.google.android.exoplayer2.m2.b H;
    private boolean I;
    private boolean J;
    private long K;
    private long L;
    private com.google.android.exoplayer2.m2.a M;
    public f(com.google.android.exoplayer2.m2.e e, Looper looper2) {
        super(e, looper2, c.a);
    }

    public f(com.google.android.exoplayer2.m2.e e, Looper looper2, com.google.android.exoplayer2.m2.c c3) {
        int obj2;
        super(5);
        g.e(e);
        this.E = (e)e;
        if (looper2 == null) {
            obj2 = 0;
        } else {
            obj2 = p0.t(looper2, this);
        }
        this.F = obj2;
        g.e(c3);
        this.D = (c)c3;
        obj2 = new d();
        this.G = obj2;
        this.L = -9223372036854775807L;
    }

    private void S(com.google.android.exoplayer2.m2.a a, List<com.google.android.exoplayer2.m2.a.b> list2) {
        int i;
        com.google.android.exoplayer2.m2.a aVar;
        com.google.android.exoplayer2.m2.d dVar;
        ByteBuffer byteBuffer;
        int length;
        i = 0;
        while (i < a.d()) {
            i1 i1Var = a.c(i).g0();
            if (i1Var != null && this.D.b(i1Var)) {
            } else {
            }
            list2.add(a.c(i));
            i++;
            if (this.D.b(i1Var)) {
            } else {
            }
            byte[] bArr = a.c(i).S1();
            g.e(bArr);
            this.G.j();
            this.G.t(bArr.length);
            byteBuffer = dVar5.c;
            p0.i(byteBuffer);
            (ByteBuffer)byteBuffer.put((byte[])bArr);
            this.G.u();
            aVar = this.D.a(i1Var).a(this.G);
            if (aVar != null) {
            }
            S(aVar, list2);
        }
    }

    private void T(com.google.android.exoplayer2.m2.a a) {
        int i;
        Object obj3;
        final Handler handler = this.F;
        if (handler != null) {
            handler.obtainMessage(0, a).sendToTarget();
        } else {
            U(a);
        }
    }

    private void U(com.google.android.exoplayer2.m2.a a) {
        this.E.o(a);
    }

    private boolean V(long l) {
        long l2;
        long obj5;
        boolean obj6;
        final com.google.android.exoplayer2.m2.a aVar = this.M;
        final int i = 1;
        if (aVar != null && Long.compare(l2, l) <= 0) {
            if (Long.compare(l2, l) <= 0) {
                T(aVar);
                this.M = 0;
                this.L = -9223372036854775807L;
                obj5 = i;
            } else {
                obj5 = 0;
            }
        } else {
        }
        if (this.I && this.M == null) {
            if (this.M == null) {
                this.J = i;
            }
        }
        return obj5;
    }

    private void W() {
        boolean empty;
        com.google.android.exoplayer2.m2.d arrayList;
        int i;
        if (!this.I && this.M == null) {
            if (this.M == null) {
                this.G.j();
                empty = F();
                arrayList = Q(empty, this.G, 0);
                if (arrayList == -4) {
                    if (this.G.p()) {
                        this.I = true;
                    } else {
                        com.google.android.exoplayer2.m2.d dVar3 = this.G;
                        dVar3.A = this.K;
                        dVar3.u();
                        com.google.android.exoplayer2.m2.b bVar = this.H;
                        p0.i(bVar);
                        empty = (b)bVar.a(this.G);
                        arrayList = new ArrayList(empty.d());
                        S(empty, arrayList);
                        if (empty != null && !arrayList.isEmpty()) {
                            arrayList = new ArrayList(empty.d());
                            S(empty, arrayList);
                            if (!arrayList.isEmpty()) {
                                a aVar = new a(arrayList);
                                this.M = aVar;
                                this.L = dVar4.w;
                            }
                        }
                    }
                } else {
                    if (arrayList == -5) {
                        i1 i1Var = empty.b;
                        g.e(i1Var);
                        this.K = i1Var.H;
                    }
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.u0
    protected void J() {
        final int i = 0;
        this.M = i;
        this.L = -9223372036854775807L;
        this.H = i;
    }

    @Override // com.google.android.exoplayer2.u0
    protected void L(long l, boolean z2) {
        this.M = 0;
        this.L = -9223372036854775807L;
        int obj1 = 0;
        this.I = obj1;
        this.J = obj1;
    }

    @Override // com.google.android.exoplayer2.u0
    protected void P(i1[] i1Arr, long l2, long l3) {
        this.H = this.D.a(i1Arr[0]);
    }

    @Override // com.google.android.exoplayer2.u0
    public boolean a() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.u0
    public int b(i1 i1) {
        int obj2;
        if (this.D.b(i1)) {
            obj2 = i1.W == null ? 4 : 2;
            return a2.r(obj2);
        }
        return a2.r(0);
    }

    @Override // com.google.android.exoplayer2.u0
    public boolean c() {
        return this.J;
    }

    @Override // com.google.android.exoplayer2.u0
    public String getName() {
        return "MetadataRenderer";
    }

    @Override // com.google.android.exoplayer2.u0
    public boolean handleMessage(Message message) {
        if (message.what != 0) {
        } else {
            U((a)message.obj);
            return 1;
        }
        IllegalStateException obj2 = new IllegalStateException();
        throw obj2;
    }

    @Override // com.google.android.exoplayer2.u0
    public void u(long l, long l2) {
        int obj3;
        obj3 = 1;
        while (obj3 != null) {
            W();
            obj3 = V(l);
        }
    }
}
