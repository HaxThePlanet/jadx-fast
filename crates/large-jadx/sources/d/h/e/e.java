package d.h.e;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.util.Log;
import d.e.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* compiled from: AnimatorSet.java */
/* loaded from: classes.dex */
public final class e extends c implements b.b {

    private static final Comparator<e.d> R = new e$c<>();
    boolean A = false;
    private boolean B = false;
    long C = 0;
    private v D;
    private e.f E = new e$f();
    private long F = -1;
    private m G = null;
    private long H = 0;
    private long I = -1;
    private long J = -1;
    private int K = -1;
    boolean L = false;
    private boolean M = true;
    private e.g N = new e$g();
    private boolean O = false;
    private long P = -1;
    private d Q = new e$a();
    private ArrayList<e.f> w = new ArrayList<>();
    g<c, e.f> x = new g<>();
    private ArrayList<e.d> y = new ArrayList<>();
    private ArrayList<e.f> z = new ArrayList<>();

    class c implements Comparator<e.d> {
        c() {
            super();
        }

        public int a(e.d dVar, e.d dVar2) {
            int i = 1;
            long l = dVar.a();
            final long l3 = dVar2.a();
            i = 1;
            if (l == l3) {
                if (i6 + i3 == i) {
                    return i3 - i6;
                }
                return i6 - i3;
            }
            long l4 = -1L;
            i = -1;
            if (l3 == l4) {
                return i;
            }
            if (l == l4) {
                return i;
            }
            l -= l3;
            if (l2 <= 0) {
            }
            return i;
        }
    }

    private static class d {

        final e.f a;
        final int b;
        d(e.f fVar, int i) {
            super();
            this.a = fVar;
            this.b = i;
        }

        long a() {
            long l = -1;
            if (this.b == 0) {
                return this.a.z;
            }
            if (this.b == 1) {
                l = -1L;
                if (fVar2.z != l) {
                    l = fVar2.a.g() + l4;
                }
                return l;
            }
            return this.a.A;
        }

        public String toString() {
            String str;
            if (this.b == 0) {
                str = "start";
            } else {
                int i = 1;
                String r0 = this.b == 1 ? "delay ended" : "end";
            }
            StringBuilder stringBuilder = new StringBuilder();
            r0 = " ";
            r0 = (this.b == 1 ? "delay ended" : "end").toString();
            r0 = r0 + r0 + r0;
            return (this.b == 1 ? "delay ended" : "end");
        }
    }

    public class e {

        private e.f a;
        final /* synthetic */ e b;
        e(c cVar) {
            this.b = eVar;
            super();
            eVar.A = true;
            this.a = eVar.F(cVar);
        }

        public e.e a(c cVar) {
            this.a.d(this.b.F(cVar));
            return this;
        }
    }

    private static class f implements java.lang.Cloneable {

        long A = 0;
        long B = 0;
        c a;
        ArrayList<e.f> b = null;
        boolean c = false;
        ArrayList<e.f> v;
        ArrayList<e.f> w;
        e.f x = null;
        boolean y = false;
        long z = 0;
        f(c cVar) {
            super();
            this.a = cVar;
        }

        void a(e.f fVar) {
            if (this.b == null) {
                this.b = new ArrayList();
            }
            if (!this.b.contains(fVar)) {
                this.b.add(fVar);
                fVar.b(this);
            }
        }

        public void b(e.f fVar) {
            if (this.w == null) {
                this.w = new ArrayList();
            }
            if (!this.w.contains(fVar)) {
                this.w.add(fVar);
                fVar.a(this);
            }
        }

        public void c(ArrayList<e.f> arrayList) {
            int i = 0;
            if (arrayList == null) {
                return;
            }
            i = 0;
            while (i < arrayList.size()) {
                b((e.f)arrayList.get(i));
                i = i + 1;
            }
        }

        public void d(e.f fVar) {
            if (this.v == null) {
                this.v = new ArrayList();
            }
            if (!this.v.contains(fVar)) {
                this.v.add(fVar);
                fVar.d(this);
            }
        }

        public e.f e() {
            ArrayList list;
            try {
                final Object clone = super.clone();
                clone.a = this.a.d();
                if (this.b != null) {
                    clone.b = new ArrayList(this.b);
                }
                if (this.v != null) {
                    clone.v = new ArrayList(this.v);
                }
                if (this.w != null) {
                    clone.w = new ArrayList(this.w);
                }
            } catch (java.lang.CloneNotSupportedException unused) {
                throw new AssertionError();
            }
            return clone;
        }
    }

    class g {

        private long a = -1;
        private boolean b = false;
        final /* synthetic */ e c;
        g() {
            this.c = eVar;
            super();
        }

        long a() {
            return this.a;
        }

        long b() {
            if (eVar.L) {
                return (this.c.h() - this.c.C) - this.a;
            }
            return this.a;
        }

        boolean c() {
            boolean z = true;
            int r0 = this.a != -1 ? 1 : 0;
            return (this.a != -1 ? 1 : 0);
        }

        void d() {
            this.a = -1L;
            this.b = false;
        }

        void e(boolean z) {
            if (z) {
                long l3 = this.c.h();
                long l = -1L;
                if (l3 == l) {
                    throw new UnsupportedOperationException("Error: Cannot reverse infinite animator set");
                }
            }
            long l2 = 0L;
            if (this.a >= l2 && z != this.b) {
                this.a = (this.c.h() - this.c.C) - this.a;
                this.b = z;
            }
        }
    }

    class a extends d {

        final /* synthetic */ e a;
        a() {
            this.a = eVar;
            super();
        }

        @Override // d.h.e.d
        public void e(c cVar) throws AndroidRuntimeException {
            if (this.a.x.get(cVar) == null) {
                throw new AndroidRuntimeException("Error: animation ended is not in the node map");
            } else {
                (e.f)this.a.x.get(cVar).c = true;
                return;
            }
        }
    }

    class b extends d {

        final /* synthetic */ e a;
        b(e eVar) {
            this.a = eVar2;
            super();
        }

        @Override // d.h.e.d
        public void e(c cVar) throws AndroidRuntimeException {
            if (this.a.x.get(cVar) == null) {
                throw new AndroidRuntimeException("Error: animation ended is not in the node map");
            } else {
                (e.f)this.a.x.get(cVar).c = true;
                return;
            }
        }
    }

    public e() {
        super();
        ArrayList arrayList = new ArrayList();
        g gVar = new g();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        d.h.e.v vVar2 = v.M(0, 1065353216).R(0L);
        this.D = vVar2;
        d.h.e.e.g gVar3 = new e.g(this);
        d.h.e.e.a aVar = new e.a(this);
        this.x.put(vVar2, new e.f(vVar2));
        this.z.add(this.E);
    }

    private void A() {
        int i;
        int i2;
        int i3 = 0;
        int i4;
        int i5;
        int size;
        long l;
        boolean z3;
        ArrayList list;
        long l2;
        int i6;
        int i7;
        ArrayList item;
        ArrayList list2;
        boolean z2 = false;
        final boolean z4 = true;
        if (!this.A) {
            i = z2;
            while (this.A < this.z.size()) {
                l2 = (e.f)this.z.get(i).a.h();
                if (l != l2) {
                    break;
                }
            }
            i2 = z2;
            if (this.A == 0) {
                return;
            }
        }
        this.A = z2;
        int size2 = this.z.size();
        while (this.z < this.A) {
            (e.f)this.z.get(i4).y = z2;
            i4 = i4 + 1;
        }
        while (this.z < this.A) {
            Object item5 = this.z.get(i5);
            i5 = i5 + 1;
        }
        while (i3 < this.A) {
            Object item3 = this.z.get(i3);
            i3 = i3 + 1;
        }
        this.E.z = 0L;
        this.E.A = this.D.f();
        X(this.E, new ArrayList(this.z.size()));
        T();
        this.H = (e.d)this.y.get(this.y.size() - z4).a();
    }

    private void B() {
        int i;
        Object item;
        boolean z2;
        final boolean z = false;
        this.B = z;
        long l = -1L;
        this.I = l;
        this.J = l;
        i = -1;
        this.K = i;
        this.v = z;
        this.P = l;
        this.N.d();
        this.w.clear();
        Q();
        if (this.a != null) {
            Object clone = this.a.clone();
            while (i < clone.size()) {
                (c.a)clone.get(i).b(this, this.L);
                i = i + 1;
            }
        }
        R();
        this.M = true;
        this.L = z;
    }

    private int C(long j) {
        int j2;
        Object item;
        int cmp;
        long l = -1;
        if (this.L) {
            long l3 = h() - j;
            int i = -1;
            if (this.K != -1) {
            }
            this.K = j2;
            j2 = j2 - 1;
            while (this.y >= 0) {
                long l6 = (e.d)this.y.get(j2).a();
                j2 = j2 - 1;
            }
        } else {
            j2 = this.K + 1;
            while (this.L < this.y.size()) {
                item = this.y.get(j2);
                long l5 = item.a();
                l = -1L;
                j2 = j2 + 1;
            }
        }
        return j2;
    }

    private void D(e.f fVar, ArrayList<e.f> arrayList) {
        int i = 0;
        if (!arrayList.contains(fVar)) {
            arrayList.add(fVar);
            if (fVar.v == null) {
                return;
            }
            i = 0;
            while (fVar.v < fVar.v.size()) {
                D((e.f)fVar.v.get(i), arrayList);
                i = i + 1;
            }
        }
    }

    private long G(long j, e.f fVar) {
        return H(j, fVar, this.L);
    }

    private long H(long j, e.f fVar, boolean z) {
        if (z) {
            return fVar.A - (h() - j);
        }
        return j - fVar.z;
    }

    private void I(int i, int i2, long j) {
        int i3 = -1;
        boolean z;
        int i4 = 1;
        d.h.e.e.f fVar;
        long l;
        ArrayList list;
        int size;
        int i5;
        final long l2 = 0L;
        final int i7 = 2;
        final boolean z5 = false;
        i4 = 1;
        if (this.L) {
            i3 = -1;
            if (i == -1) {
                size = this.y.size();
            }
            i5 = size - i4;
            while (this.y >= i2) {
                Object item = this.y.get(i5);
                i5 = i5 - 1;
            }
        } else {
            i5 = i + i4;
            while (this.y <= i2) {
                Object item2 = this.y.get(i5);
                i5 = i5 + 1;
            }
        }
    }

    private void J() {
        int i = 0;
        d.h.e.m mVar2;
        if (this.G != null) {
            i = 0;
            while (this.G < this.z.size()) {
                (e.f)this.z.get(i).a.t(this.G);
                i = i + 1;
            }
        }
        W();
        A();
    }

    private void K() {
        if (!j()) {
            this.O = true;
            boolean z = false;
            u(z);
        }
    }

    private static boolean L(e eVar) {
        int i;
        long l2 = eVar.g();
        long l = 0L;
        i = 0;
        if (l2 > l) {
            return false;
        }
        while (i < eVar.E().size()) {
            Object item = eVar.E().get(i);
            z = item instanceof e;
            if (!e.L(item)) {
                return false;
            }
        }
        return true;
    }

    private void M() {
        int i = 0;
        if (this.c != null) {
            i = 0;
            while (this.c < this.c.size()) {
                (c.c)this.c.get(i).a(this);
                i = i + 1;
            }
        }
    }

    private void P(e.f fVar, long j) {
        float f = 1065353216;
        if (!fVar.c) {
            f = v.F();
            if (f == 0) {
                int i = 1065353216;
            }
            fVar.c = fVar.a.n((long)(float)j * f);
        }
    }

    private void Q() {
        if (!this.M) {
            return;
        }
        b.g().k(this);
    }

    private void R() {
        int i = 1;
        i = 1;
        while (i < this.z.size()) {
            (e.f)this.z.get(i).a.p(this.Q);
            i = i + 1;
        }
    }

    private void T() {
        int size;
        d.h.e.e.d dVar;
        d.h.e.e.d dVar2;
        long l;
        long l2;
        d.h.e.e.f fVar;
        this.y.clear();
        size = 1;
        int i3 = 2;
        size = 0;
        while (size < this.z.size()) {
            Object item = this.z.get(size);
            this.y.add(new e.d(item, size));
            this.y.add(new e.d(item, size));
            this.y.add(new e.d(item, i3));
            size = size + 1;
            i3 = 2;
            size = 0;
        }
        Collections.sort(this.y, e.R);
        size = this.y.size();
        while (this.z < this.y) {
            dVar = this.y.get(size);
            if (dVar.b == i3) {
            }
        }
        if (!this.y.isEmpty()) {
            if ((e.d)this.y.get(size).b != 0) {
                throw new UnsupportedOperationException("Sorting went bad, the start event should always be at index 0");
            }
        }
        this.y.add(size, new e.d(this.E, size));
        this.y.add(size, new e.d(this.E, size));
        this.y.add(i3, new e.d(this.E, i3));
        i2 = this.y.size() - size;
        if ((e.d)this.y.get(i2).b == 0) {
            throw new UnsupportedOperationException("Something went wrong, the last event is not an end event");
        } else {
            i2 = this.y.size() - size;
            if ((e.d)this.y.get(i2).b != this.y) {
                return;
            }
        }
    }

    private void U(boolean z, boolean z2) throws AndroidRuntimeException {
        int i;
        Object item;
        Object item2;
        int i2 = 0;
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        } else {
            this.B = true;
            this.M = z2;
            boolean z22 = false;
            this.v = z22;
            this.P = -1L;
            while (i < this.z.size()) {
                (e.f)this.z.get(i).c = z22;
                i = i + 1;
            }
            J();
            if (z) {
                if (!y()) {
                    throw new UnsupportedOperationException("Cannot reverse infinite AnimatorSet");
                }
            }
            this.L = z;
            boolean z4 = e.L(this);
            if (!z4) {
                V();
            }
            if (this.a != null) {
                Object clone = this.a.clone();
                while (i2 < clone.size()) {
                    (c.a)clone.get(i2).f(this, z);
                    i2 = i2 + 1;
                }
            }
            if (z4) {
                e();
            }
            return;
        }
    }

    private void V() {
        int i;
        int i2 = 1;
        long l = 0;
        int i3;
        int i4;
        boolean z3;
        x();
        long l3 = this.N.b();
        l = 0L;
        if (l3 == l && this.L) {
            this.N.d();
        }
        i2 = 1;
        if (j()) {
            i = this.L ^ i2;
            u(i);
        } else {
            if (this.L) {
                K();
                i = this.L ^ i2;
                u(i);
            } else {
                i = this.y.size() - i2;
                while (this.N >= 0) {
                    i = i - 1;
                }
            }
        }
        if (!this.L) {
            if (this.C != l) {
                if (this.N.c()) {
                    if (this.N.c()) {
                        this.N.e(this.L);
                        l = this.N.a();
                    }
                    int i5 = C(l);
                    I(-1, i5, l);
                    i3 = this.w.size() - i2;
                    while (this.L >= 0) {
                        i3 = i3 - 1;
                    }
                    this.K = i5;
                }
            }
        }
        if (this.M) {
            c.b(this);
        }
    }

    private void W() {
        int i = 0;
        long l = 0;
        long l2;
        l = 0L;
        if (this.F >= l) {
            i = 0;
            while (i < this.z.size()) {
                (e.f)this.z.get(i).a.s(this.F);
                i = i + 1;
            }
        }
        this.D.R(this.C);
    }

    private void X(e.f fVar, ArrayList<e.f> arrayList) {
        int i = 0;
        String str;
        String str2;
        int indexOf;
        long l2;
        int size;
        d.h.e.e.f fVar2;
        int cmp;
        long l;
        int cmp2;
        d.h.e.e.f fVar3;
        i = 0;
        l = -1L;
        if (fVar.b == null) {
            if (fVar == this.E) {
                while (i < this.z.size()) {
                    Object item2 = this.z.get(i);
                    i = i + 1;
                }
            }
            return;
        }
        arrayList.add(fVar);
        while (i < fVar.b.size()) {
            Object item3 = fVar.b.get(i);
            item3.B = item3.a.h();
            i = i + 1;
        }
        arrayList.remove(fVar);
    }

    private void x() {
        int i = 1;
        i = 1;
        while (i < this.z.size()) {
            (e.f)this.z.get(i).a.c(this.Q);
            i = i + 1;
        }
    }

    @Override // d.h.e.c
    public ArrayList<c> E() {
        int i = 0;
        Object item;
        final ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < this.z.size()) {
            item = this.z.get(i);
            i = i + 1;
        }
        return arrayList;
    }

    @Override // d.h.e.c
    e.f F(c cVar) {
        Object obj;
        if ((e.f)this.x.get(cVar) == null) {
            d.h.e.e.f fVar = new e.f(cVar);
            this.x.put(cVar, fVar);
            this.z.add(fVar);
            z = cVar instanceof e;
            if (cVar instanceof e) {
                boolean z = false;
                cVar.M = z;
            }
        }
        return obj;
    }

    @Override // d.h.e.c
    public e.e N(c cVar) {
        return new e.e(this, cVar);
    }

    @Override // d.h.e.c
    public void O(c... cVarArr) {
        int i = 1;
        if (cVarArr != null) {
            i = 1;
            length = cVarArr.length;
            for (Object obj2 : cVarArr) {
                N(cVarArr[0]).a(obj2);
                length = cVarArr.length;
            }
        }
    }

    @Override // d.h.e.c
    public e S(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        } else {
            this.A = true;
            this.F = j;
            return this;
        }
    }

    @Override // d.h.e.c
    public boolean a(long j) {
        int i;
        long l = -1;
        long l2;
        long l3 = 0;
        int i3;
        int i4;
        int i2;
        int size2;
        d.h.e.e.f fVar;
        float f2 = v.F();
        i2 = 1;
        if (f2 == 0) {
            e();
            return true;
        }
        l3 = 0L;
        if (this.J < l3) {
            this.J = j;
        }
        l = -1L;
        final boolean z3 = false;
        if (this.v) {
            if (this.P == l) {
                this.P = j;
            }
            Q();
            return false;
        }
        if (this.P > l3) {
            l4 = j - l4;
            this.J += l4;
            this.P = l;
        }
        if (this.N.c()) {
            this.N.e(this.L);
            if (this.L) {
                f = (float)this.N.a() * f2;
                l = j - (long)f;
                this.J = l;
            } else {
                f = (float)(this.N.a() + this.C) * f2;
                l = j - (long)f;
                this.J = l;
            }
            u(this.L ^ i2);
            this.w.clear();
            i = this.z.size() - i2;
            while (this.L ^ i2 >= 0) {
                (e.f)this.z.get(i).c = z3;
                i = i - 1;
            }
            this.K = -1;
            this.N.d();
        }
        if (!this.L && j < this.J) {
            return false;
        }
        l2 = j - this.J;
        float f4 = (float)l2 / f2;
        long l6 = (long)f4;
        this.I = j;
        int i10 = C(l6);
        I(this.K, i10, l6);
        this.K = i10;
        while (i3 < this.w.size()) {
            Object item3 = this.w.get(i3);
            i3 = i3 + 1;
        }
        i4 = this.w.size() - i2;
        while (this.w >= 0) {
            i4 = i4 - 1;
        }
        if (this.L) {
            if (this.w.size() == i2) {
                j = i2;
            }
        }
        M();
        if (this.w != 0) {
            B();
            return true;
        }
        return false;
    }

    @Override // d.h.e.c
    public void cancel() throws AndroidRuntimeException {
        int i = 0;
        Object item;
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        } else {
            if (l()) {
                i = 0;
                if (this.a != null) {
                    Object clone = this.a.clone();
                    while (i < clone.size()) {
                        (c.a)clone.get(i).c(this);
                        i = i + 1;
                    }
                }
                ArrayList arrayList = new ArrayList(this.w);
                while (i < arrayList.size()) {
                    (e.f)arrayList.get(i).a.cancel();
                    i = i + 1;
                }
                this.w.clear();
                B();
            }
            return;
        }
    }

    @Override // d.h.e.c
    public void e() throws AndroidRuntimeException {
        int size;
        int i4;
        boolean z3;
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        } else {
            if (l()) {
                int i2 = 2;
                int i3 = 1;
                if (this.L) {
                    i4 = -1;
                    if (this.K == -1) {
                        size = this.y.size();
                    }
                    this.K = size;
                    while (this.K > 0) {
                        this.K--;
                        Object item = this.y.get(i5);
                    }
                } else {
                    i4 = this.y.size() - i3;
                    while (this.K < this.y.size() - i3) {
                        this.K += i3;
                        Object item2 = this.y.get(i7);
                    }
                }
                this.w.clear();
            }
            B();
            return;
        }
    }

    @Override // d.h.e.c
    public long f() {
        return this.F;
    }

    @Override // d.h.e.c
    public long g() {
        return this.C;
    }

    @Override // d.h.e.c
    public long h() {
        W();
        A();
        return this.H;
    }

    @Override // d.h.e.c
    boolean j() {
        boolean z = true;
        int i;
        z = true;
        if (this.O) {
            return true;
        }
        i = 0;
        while (i < this.z.size()) {
            if (!(e.f)this.z.get(i).a.j()) {
            }
        }
        this.O = z;
        return z;
    }

    @Override // d.h.e.c
    public boolean k() {
        boolean z2 = true;
        final long l3 = 0L;
        if (this.C == l3) {
            return this.B;
        }
        int r0 = this.I > l3 ? 1 : 0;
        return (this.I > l3 ? 1 : 0);
    }

    @Override // d.h.e.c
    public boolean l() {
        return this.B;
    }

    @Override // d.h.e.c
    public void m() throws AndroidRuntimeException {
        if (Looper.myLooper() == null) {
            throw new AndroidRuntimeException("Animators may only be run on Looper threads");
        } else {
            super.m();
            if (!this.v && this.v) {
                this.P = this.I;
            }
            return;
        }
    }

    @Override // d.h.e.c
    boolean n(long j) {
        return a(j);
    }

    @Override // d.h.e.c
    public void r() {
        final boolean z = true;
        U(z, z);
    }

    @Override // d.h.e.c
    public void t(m mVar) {
        this.G = mVar;
    }

    @Override // d.h.e.c
    public String toString() {
        String str;
        int i = 0;
        StringBuilder stringBuilder2 = new StringBuilder();
        String str5 = "AnimatorSet@";
        String str6 = Integer.toHexString(hashCode());
        String str7 = "{";
        str = str5 + str6 + str7;
        i = 0;
        while (i < this.z.size()) {
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = "\n    ";
            String object = (e.f)this.z.get(i).a.toString();
            str = str + str4 + object;
            i = i + 1;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        String str2 = "\n}";
        str3 = str + str2;
        return str3;
    }

    @Override // d.h.e.c
    void u(boolean z) {
        int z3;
        int i;
        int size;
        int i2 = 2;
        int i3;
        if (this.M) {
            if (!j()) {
                throw new UnsupportedOperationException("Children must be initialized.");
            }
        }
        J();
        if (z) {
            z3 = 1;
            i3 = this.y.size() - z3;
            while (this.y >= 0) {
                i3 = i3 - 1;
            }
        } else {
            boolean z4 = false;
            z3 = z4;
            while (this.M < this.y.size()) {
                i2 = 2;
                z3 = z3 + 1;
            }
        }
    }

    @Override // d.h.e.c
    public void v() {
        U(false, true);
    }

    @Override // d.h.e.c
    void w(boolean z) {
        U(z, false);
    }

    @Override // d.h.e.c
    public boolean y() {
        boolean z = true;
        long l = h();
        int r0 = l != -1 ? 1 : 0;
        return (l != -1 ? 1 : 0);
    }

    @Override // d.h.e.c
    public e z() {
        int i;
        int i2;
        int i3 = -1;
        d.h.e.e.f value;
        d.h.e.c cVar;
        int i4 = 0;
        boolean z;
        d.h.e.d dVar;
        int i5;
        int i6;
        int i7;
        ArrayList list;
        Object value2;
        final d.h.e.c cVar2 = super.d();
        int size = this.z.size();
        z = false;
        cVar2.B = z;
        long l = -1L;
        cVar2.I = l;
        cVar2.J = l;
        i3 = -1;
        cVar2.K = i3;
        cVar2.v = z;
        cVar2.P = l;
        cVar2.N = new e.g(this);
        boolean z2 = true;
        cVar2.M = z2;
        cVar2.w = new ArrayList();
        cVar2.x = new g();
        cVar2.z = new ArrayList(size);
        cVar2.y = new ArrayList();
        cVar2.Q = new e.b(this, cVar2);
        cVar2.L = z;
        cVar2.A = z2;
        HashMap hashMap = new HashMap(size);
        while (i < this.z) {
            Object item2 = this.z.get(i);
            value = item2.e();
            value.a.p(this.Q);
            hashMap.put(item2, value);
            cVar2.z.add(value);
            cVar2.x.put(value.a, value);
            i = i + 1;
        }
        Object value3 = hashMap.get(this.E);
        cVar2.E = value3;
        cVar2.D = (v)value3.a;
        while (this.E < this.z) {
            Object item = this.z.get(i2);
            value = hashMap.get(item);
            value.x = i4;
            while (this.Q < item.x) {
                value.b.set(i5, (e.f)hashMap.get(item.b.get(i5)));
                i5 = i5 + 1;
            }
            value.b.set(i5, (e.f)hashMap.get(item.b.get(i5)));
            i5 = i5 + 1;
            while (this.Q < item.x) {
                value.v.set(i6, (e.f)hashMap.get(item.v.get(i6)));
                i6 = i6 + 1;
            }
            value.v.set(i6, (e.f)hashMap.get(item.v.get(i6)));
            i6 = i6 + 1;
            while (this.Q < item.x) {
                value.w.set(i7, (e.f)hashMap.get(item.w.get(i7)));
                i7 = i7 + 1;
            }
            value.w.set(i7, (e.f)hashMap.get(item.w.get(i7)));
            i7 = i7 + 1;
            i2 = i2 + 1;
        }
        return cVar2;
    }
}
