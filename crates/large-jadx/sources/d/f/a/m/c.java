package d.f.a.m;

import java.util.ArrayList;

/* compiled from: ChainHead.java */
/* loaded from: classes.dex */
public class c {

    protected e a;
    protected e b;
    protected e c;
    protected e d;
    protected e e;
    protected e f;
    protected e g;
    protected ArrayList<e> h;
    protected int i;
    protected int j;
    protected float k = 0f;
    int l;
    int m;
    int n;
    private int o;
    private boolean p = false;
    protected boolean q;
    protected boolean r;
    protected boolean s;
    private boolean t;
    public c(e eVar, int i, boolean z) {
        super();
        this.a = eVar;
        this.o = i;
        this.p = z;
    }

    private void b() {
        d.f.a.m.e eVar4;
        int i3 = 0;
        int cmp;
        int i4;
        d.f.a.m.e eVar5;
        int i6 = 8;
        float f;
        int i8;
        int i9;
        int cmp2;
        int i12 = 2;
        i = this.o * i12;
        i3 = 0;
        i3 = 1;
        while (i3 == 0) {
            this.i += i3;
            eVar4 = null;
            eVar4.q0[this.o] = eVar4;
            eVar4.p0[this.o] = eVar4;
            i6 = 8;
            i4 = i + 1;
        }
        if (this.b != null) {
            this.m -= i13;
        }
        if (this.d != null) {
            this.m -= i;
        }
        this.c = eVar4;
        if (this.o != 0 || !this.p) {
            this.e = this.a;
        } else {
            this.e = eVar4;
        }
        if (this.r && this.q) {
        }
        this.s = i3;
    }

    private static boolean c(e eVar, int i) {
        int i3 = 8;
        boolean z = true;
        int i5 = 3;
        i3 = 8;
        if (eVar.Q() != 8) {
            if (eVar.V[i] == e.b.MATCH_CONSTRAINT) {
                if (iArr[i] != 0) {
                    i5 = 3;
                    eVar = iArr[i] == 3 ? 1 : 0;
                }
            }
        }
        return (iArr[i] == 3 ? 1 : 0);
    }

    public void a() {
        if (!this.t) {
            b();
        }
        this.t = true;
    }
}
