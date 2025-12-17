package com.google.android.exoplayer2.source.hls;

import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.l2.i;
import com.google.android.exoplayer2.l2.j;
import com.google.android.exoplayer2.l2.k;
import com.google.android.exoplayer2.l2.p;
import com.google.android.exoplayer2.l2.t.f;
import com.google.android.exoplayer2.l2.v.e;
import com.google.android.exoplayer2.l2.v.g;
import com.google.android.exoplayer2.l2.v.i;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.m0;

/* loaded from: classes2.dex */
public final class e implements com.google.android.exoplayer2.source.hls.n {

    private static final p d;
    final i a;
    private final i1 b;
    private final m0 c;
    static {
        p pVar = new p();
        e.d = pVar;
    }

    public e(i i, i1 i12, m0 m03) {
        super();
        this.a = i;
        this.b = i12;
        this.c = m03;
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public void a(k k) {
        this.a.a(k);
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public void b() {
        final int i = 0;
        this.a.d(i, obj2);
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public boolean c() {
        int i;
        i iVar;
        boolean z;
        iVar = this.a;
        if (!iVar instanceof i && !iVar instanceof e && !iVar instanceof g) {
            if (!iVar instanceof e) {
                if (!iVar instanceof g) {
                    if (iVar instanceof f) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public boolean d(j j) {
        int obj3;
        obj3 = this.a.c(j, e.d) == 0 ? 1 : 0;
        return obj3;
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public boolean e() {
        int i;
        i iVar;
        iVar = this.a;
        if (!iVar instanceof d0) {
            if (iVar instanceof g) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        return i;
    }

    @Override // com.google.android.exoplayer2.source.hls.n
    public com.google.android.exoplayer2.source.hls.n f() {
        Object tVar;
        String str;
        String concat;
        m0 m0Var;
        String valueOf;
        g.f(z ^= 1);
        i iVar = this.a;
        if (iVar instanceof t) {
            tVar = new t(i1Var.c, this.c);
            e eVar = new e(tVar, this.b, this.c);
            return eVar;
        } else {
            if (iVar instanceof i) {
                tVar = new i();
            } else {
                if (iVar instanceof e) {
                    tVar = new e();
                } else {
                    if (iVar instanceof g) {
                        tVar = new g();
                    } else {
                        if (iVar instanceof f) {
                            tVar = new f();
                        }
                    }
                }
            }
        }
        String str2 = "Unexpected extractor type for recreation: ";
        valueOf = String.valueOf(this.a.getClass().getSimpleName());
        if (valueOf.length() != 0) {
            concat = str2.concat(valueOf);
        } else {
            valueOf = new String(str2);
            concat = valueOf;
        }
        IllegalStateException illegalStateException = new IllegalStateException(concat);
        throw illegalStateException;
    }
}
