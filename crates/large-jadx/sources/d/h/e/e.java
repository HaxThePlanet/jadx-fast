package d.h.e;

import android.os.Looper;
import android.util.AndroidRuntimeException;
import android.util.Log;
import d.e.g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class e extends d.h.e.c implements d.h.e.b.b {

    private static final Comparator<d.h.e.e.d> R;
    boolean A = false;
    private boolean B = false;
    long C = 0;
    private d.h.e.v D;
    private d.h.e.e.f E;
    private long F = -1;
    private d.h.e.m G = null;
    private long H = 0;
    private long I = -1;
    private long J = -1;
    private int K = -1;
    boolean L = false;
    private boolean M = true;
    private d.h.e.e.g N;
    private boolean O = false;
    private long P = -1;
    private d.h.e.d Q;
    private ArrayList<d.h.e.e.f> w;
    g<d.h.e.c, d.h.e.e.f> x;
    private ArrayList<d.h.e.e.d> y;
    private ArrayList<d.h.e.e.f> z;

    class c implements Comparator<d.h.e.e.d> {
        @Override // java.util.Comparator
        public int a(d.h.e.e.d e$d, d.h.e.e.d e$d2) {
            int i;
            long l = d.a();
            final long l2 = d2.a();
            i = 1;
            int obj9 = d2.b;
            int obj8 = d.b;
            if (Long.compare(l, l2) == 0 && obj9 + obj8 == i) {
                obj9 = d2.b;
                obj8 = d.b;
                if (obj9 + obj8 == i) {
                    return obj8 -= obj9;
                }
                return obj9 -= obj8;
            }
            obj8 = -1;
            final int i4 = -1;
            if (Long.compare(l2, obj8) == 0) {
                return i4;
            }
            if (Long.compare(l, obj8) == 0) {
                return i;
            }
            if (Long.compare(i3, obj8) > 0) {
            } else {
                i = i4;
            }
            return i;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((e.d)object, (e.d)object2);
        }
    }

    private static class d {

        final d.h.e.e.f a;
        final int b;
        d(d.h.e.e.f e$f, int i2) {
            super();
            this.a = f;
            this.b = i2;
        }

        long a() {
            Object fVar;
            int i;
            int i2 = this.b;
            if (i2 == 0) {
                return fVar3.z;
            }
            if (i2 == 1) {
                fVar = this.a;
                long l3 = fVar.z;
                if (Long.compare(l3, i) == 0) {
                } else {
                    l4 += l3;
                }
                return i;
            }
            return fVar2.A;
        }

        public String toString() {
            String str;
            int i;
            int i2 = this.b;
            str = i2 == 0 ? "start" : i2 == i ? "delay ended" : "end";
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(" ");
            stringBuilder.append(fVar.a.toString());
            return stringBuilder.toString();
        }
    }

    public class e {

        private d.h.e.e.f a;
        final d.h.e.e b;
        e(d.h.e.e e, d.h.e.c c2) {
            this.b = e;
            super();
            e.A = true;
            this.a = e.F(c2);
        }

        public d.h.e.e.e a(d.h.e.c c) {
            this.a.d(this.b.F(c));
            return this;
        }
    }

    private static class f implements java.lang.Cloneable {

        long A = 0;
        long B = 0;
        d.h.e.c a;
        ArrayList<d.h.e.e.f> b = null;
        boolean c = false;
        ArrayList<d.h.e.e.f> v;
        ArrayList<d.h.e.e.f> w;
        d.h.e.e.f x = null;
        boolean y = false;
        long z = 0;
        f(d.h.e.c c) {
            super();
            int i = 0;
            final int i3 = 0;
            int i2 = 0;
            this.a = c;
        }

        @Override // java.lang.Cloneable
        void a(d.h.e.e.f e$f) {
            ArrayList arrayList;
            boolean contains;
            if (this.b == null) {
                arrayList = new ArrayList();
                this.b = arrayList;
            }
            if (!this.b.contains(f)) {
                this.b.add(f);
                f.b(this);
            }
        }

        @Override // java.lang.Cloneable
        public void b(d.h.e.e.f e$f) {
            ArrayList arrayList;
            boolean contains;
            if (this.w == null) {
                arrayList = new ArrayList();
                this.w = arrayList;
            }
            if (!this.w.contains(f)) {
                this.w.add(f);
                f.a(this);
            }
        }

        public void c(ArrayList<d.h.e.e.f> arrayList) {
            int i;
            Object obj;
            if (arrayList == null) {
            }
            i = 0;
            while (i < arrayList.size()) {
                b((e.f)arrayList.get(i));
                i++;
            }
        }

        @Override // java.lang.Cloneable
        public Object clone() {
            return e();
        }

        @Override // java.lang.Cloneable
        public void d(d.h.e.e.f e$f) {
            ArrayList arrayList;
            boolean contains;
            if (this.v == null) {
                arrayList = new ArrayList();
                this.v = arrayList;
            }
            if (!this.v.contains(f)) {
                this.v.add(f);
                f.d(this);
            }
        }

        @Override // java.lang.Cloneable
        public d.h.e.e.f e() {
            ArrayList arrayList;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList list;
            try {
                final Object clone = super.clone();
                clone.a = this.a.d();
                if (this.b != null) {
                }
                arrayList = new ArrayList(this.b);
                clone.b = arrayList;
                if (this.v != null) {
                }
                arrayList2 = new ArrayList(this.v);
                clone.v = arrayList2;
                if (this.w != null) {
                }
                arrayList3 = new ArrayList(this.w);
                clone.w = arrayList3;
                clone.c = false;
                return (e.f)clone;
                AssertionError assertionError = new AssertionError();
                throw assertionError;
            }
        }
    }

    class g {

        private long a = -1;
        private boolean b = false;
        final d.h.e.e c;
        g(d.h.e.e e) {
            this.c = e;
            super();
            final int i = -1;
            final int obj3 = 0;
        }

        long a() {
            return this.a;
        }

        long b() {
            d.h.e.e eVar = this.c;
            if (eVar.L) {
                return i -= l4;
            }
            return this.a;
        }

        boolean c() {
            int i;
            i = Long.compare(l, i2) != 0 ? 1 : 0;
            return i;
        }

        void d() {
            this.a = -1;
            this.b = false;
        }

        void e(boolean z) {
            int cmp2;
            int cmp;
            int i;
            int i2;
            if (z) {
                if (Long.compare(l, i) == 0) {
                } else {
                }
                UnsupportedOperationException obj5 = new UnsupportedOperationException("Error: Cannot reverse infinite animator set");
                throw obj5;
            }
            if (Long.compare(l2, i2) >= 0 && z != this.b) {
                if (z != this.b) {
                    this.a = i3 -= i2;
                    this.b = z;
                }
            }
        }
    }

    class a extends d.h.e.d {

        final d.h.e.e a;
        a(d.h.e.e e) {
            this.a = e;
            super();
        }

        @Override // d.h.e.d
        public void e(d.h.e.c c) {
            if (eVar.x.get(c) == null) {
            } else {
                obj2.c = true;
            }
            AndroidRuntimeException obj2 = new AndroidRuntimeException("Error: animation ended is not in the node map");
            throw obj2;
        }
    }

    class b extends d.h.e.d {

        final d.h.e.e a;
        b(d.h.e.e e, d.h.e.e e2) {
            this.a = e2;
            super();
        }

        @Override // d.h.e.d
        public void e(d.h.e.c c) {
            if (eVar.x.get(c) == null) {
            } else {
                obj2.c = true;
            }
            AndroidRuntimeException obj2 = new AndroidRuntimeException("Error: animation ended is not in the node map");
            throw obj2;
        }
    }
    static {
        e.c cVar = new e.c();
        e.R = cVar;
    }

    public e() {
        super();
        ArrayList arrayList = new ArrayList();
        this.w = arrayList;
        g gVar = new g();
        this.x = gVar;
        ArrayList arrayList2 = new ArrayList();
        this.y = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.z = arrayList3;
        int i = 0;
        float[] fArr = new float[2];
        fArr = new int[]{0, 1065353216};
        d.h.e.v vVar2 = v.M(fArr).R(0);
        this.D = vVar2;
        e.f fVar2 = new e.f(vVar2);
        this.E = fVar2;
        final int i6 = -1;
        final int i7 = 0;
        int i3 = -1;
        int i4 = 1;
        e.g gVar3 = new e.g(this);
        this.N = gVar3;
        e.a aVar = new e.a(this);
        this.Q = aVar;
        this.x.put(vVar2, fVar2);
        this.z.add(this.E);
    }

    private void A() {
        boolean z;
        int i5;
        int i;
        int size2;
        int i3;
        int i2;
        long l;
        boolean size;
        long l2;
        int i4;
        ArrayList list;
        ArrayList list2;
        i = 0;
        final int i7 = 1;
        if (!this.A) {
            i5 = i;
            while (i5 < this.z.size()) {
                i5++;
            }
            z = i;
            if (z == 0) {
            }
        }
        this.A = i;
        int size3 = this.z.size();
        i3 = i;
        while (i3 < size3) {
            l.y = i;
            i3++;
        }
        i2 = i;
        while (i2 < size3) {
            l = this.z.get(i2);
            if (l.y) {
            } else {
            }
            l.y = i7;
            size = l.v;
            if (size == null) {
            } else {
            }
            D((e.f)l, size);
            l.v.remove(l);
            size = l.v.size();
            i4 = i;
            while (i4 < size) {
                l.c(obj4.w);
                i4++;
            }
            l2 = i;
            while (l2 < size) {
                list = l.v.get(l2);
                (e.f)list.c(l.w);
                list.y = i7;
                l2++;
            }
            i2++;
            list = l.v.get(l2);
            (e.f)list.c(l.w);
            list.y = i7;
            l2++;
            l.c(obj4.w);
            i4++;
        }
        while (i < size3) {
            i2 = this.z.get(i);
            l = this.E;
            if ((e.f)i2 != l && i2.w == null) {
            }
            i++;
            if (i2.w == null) {
            }
            (e.f)i2.b(l);
        }
        ArrayList arrayList = new ArrayList(this.z.size());
        d.h.e.e.f fVar = this.E;
        fVar.z = 0;
        fVar.A = this.D.f();
        X(this.E, arrayList);
        T();
        ArrayList list4 = this.y;
        this.H = (e.d)list4.get(size5 -= i7).a();
    }

    private void B() {
        Object clone;
        int size;
        int i;
        Object obj;
        boolean z;
        final int i2 = 0;
        this.B = i2;
        int i3 = -1;
        this.I = i3;
        this.J = i3;
        this.K = -1;
        this.v = i2;
        this.P = i3;
        this.N.d();
        this.w.clear();
        Q();
        clone = this.a;
        if (clone != null) {
            clone = clone.clone();
            i = i2;
            while (i < (ArrayList)clone.size()) {
                (c.a)clone.get(i).b(this, this.L);
                i++;
            }
        }
        R();
        this.M = true;
        this.L = i2;
    }

    private int C(long l) {
        int size;
        int i3;
        int i;
        Object cmp;
        int cmp2;
        int i2;
        int obj9;
        int obj10;
        if (this.L) {
            obj9 = this.K;
            if (obj9 == -1) {
            } else {
                size = obj9;
            }
            this.K = size;
            size--;
            while (size >= 0) {
                if (Long.compare(obj9, i) >= 0) {
                }
                size--;
                i3 = size;
            }
        } else {
            i = i3 + 1;
            while (i < this.y.size()) {
                cmp = this.y.get(i);
                if (Long.compare(l4, i2) != 0 && Long.compare(l3, l) <= 0) {
                }
                i++;
                if (Long.compare(l3, l) <= 0) {
                }
                i3 = i;
            }
        }
        return i3;
    }

    private void D(d.h.e.e.f e$f, ArrayList<d.h.e.e.f> arrayList2) {
        int contains;
        Object size;
        arrayList2.add(f);
        if (!arrayList2.contains(f) && f.v == null) {
            arrayList2.add(f);
            if (f.v == null) {
            }
            contains = 0;
            while (contains < f.v.size()) {
                D((e.f)f.v.get(contains), arrayList2);
                contains++;
            }
        }
    }

    private long G(long l, d.h.e.e.f e$f2) {
        return H(l, f2, obj4);
    }

    private long H(long l, d.h.e.e.f e$f2, boolean z3) {
        if (obj6 != null) {
            return obj3 -= i;
        }
        return l -= obj5;
    }

    private void I(int i, int i2, long l3) {
        int z2;
        boolean z3;
        int i3;
        d.h.e.e.f fVar;
        ArrayList list;
        boolean z;
        int obj10;
        final int i4 = 0;
        final int i5 = 2;
        final int i6 = 0;
        i3 = 1;
        if (this.L) {
            if (i == -1) {
                obj10 = this.y.size();
            }
            obj10 -= i3;
            while (obj10 >= i2) {
                z2 = this.y.get(obj10);
                fVar = z2.a;
                list = z2.b;
                if (list == i5) {
                } else {
                }
                if (list == i3 && !fVar.c) {
                }
                obj10--;
                if (!fVar.c) {
                }
                P(fVar, G(l3, obj13));
                if (fVar.a.l()) {
                }
                fVar.c = i6;
                this.w.add(z2.a);
                fVar.a.w(i3);
                P(fVar, i4);
                fVar.a.cancel();
            }
        } else {
            i += i3;
            while (obj10 <= i2) {
                Object obj = this.y.get(obj10);
                i3 = obj.a;
                z2 = obj.b;
                if (z2 == 0) {
                } else {
                }
                if (z2 == i5 && !i3.c) {
                }
                obj10++;
                if (!i3.c) {
                }
                P(i3, G(l3, obj13));
                this.w.add(i3);
                if (i3.a.l()) {
                }
                i3.c = i6;
                i3.a.w(i6);
                P(i3, i4);
                i3.a.cancel();
            }
        }
    }

    private void J() {
        int mVar2;
        d.h.e.c size;
        d.h.e.m mVar;
        if (this.G != null) {
            mVar2 = 0;
            while (mVar2 < this.z.size()) {
                obj.a.t(this.G);
                mVar2++;
            }
        }
        W();
        A();
    }

    private void K() {
        boolean z;
        if (!j()) {
            this.O = true;
            u(false);
        }
    }

    private static boolean L(d.h.e.e e) {
        int i;
        int i2;
        boolean z;
        final int i3 = 0;
        if (Long.compare(l, i2) > 0) {
            return i3;
        }
        i = i3;
        while (i < e.E().size()) {
            Object obj = e.E().get(i);
            i++;
        }
        return 1;
    }

    private void M() {
        int list;
        Object size;
        if (this.c != null) {
            list = 0;
            while (list < this.c.size()) {
                (c.c)this.c.get(list).a(this);
                list++;
            }
        }
    }

    private void P(d.h.e.e.f e$f, long l2) {
        float z;
        d.h.e.c cVar;
        boolean obj4;
        if (!f.c && Float.compare(z, i) == 0) {
            if (Float.compare(z, i) == 0) {
                z = 1065353216;
            }
            f.c = f.a.n((long)obj4);
        }
    }

    private void Q() {
        if (!this.M) {
        }
        b.g().k(this);
    }

    private void R() {
        int i;
        d.h.e.c cVar;
        d.h.e.d dVar;
        i = 1;
        while (i < this.z.size()) {
            obj.a.p(this.Q);
            i++;
        }
    }

    private void T() {
        int i8;
        boolean empty;
        int i7;
        Object obj;
        int i3;
        int i10;
        int i6;
        ArrayList list;
        d.h.e.e.d dVar2;
        int remove;
        d.h.e.e.d dVar;
        int i4;
        int i9;
        int i;
        int i5;
        int i2;
        long cmp;
        d.h.e.e.f fVar;
        this.y.clear();
        int i11 = 1;
        i8 = i11;
        i6 = 2;
        int i12 = 0;
        while (i8 < this.z.size()) {
            obj = this.z.get(i8);
            dVar = new e.d((e.f)obj, i12);
            this.y.add(dVar);
            e.d dVar6 = new e.d(obj, i11);
            this.y.add(dVar6);
            dVar2 = new e.d(obj, i6);
            this.y.add(dVar2);
            i8++;
            i6 = 2;
            i12 = 0;
        }
        Collections.sort(this.y, e.R);
        int size = this.y.size();
        i3 = i12;
        while (i3 < size) {
            dVar2 = this.y.get(i3);
            if (dVar2.b == i6) {
            } else {
            }
            i3++;
            d.h.e.e.f fVar5 = dVar2.a;
            i9 = fVar5.z;
            i5 = fVar5.A;
            if (Long.compare(i9, i5) == 0) {
            } else {
            }
            if (Long.compare(i5, i9) == 0) {
            } else {
            }
            i4 = i12;
            i9 = i3 + 1;
            i2 = i5;
            i = i9;
            while (i < size) {
                if (i5 < size) {
                    break loop_11;
                } else {
                }
                if (obj5.a == dVar2.a) {
                }
                i++;
                if (obj6.b == 0) {
                } else {
                }
                if (obj7.b == i11) {
                }
                i2 = i;
                i5 = i;
                if (i2 < size) {
                    break loop_11;
                } else {
                }
            }
            if (i4 != 0) {
            }
            this.y.add(i3, (e.d)this.y.remove(i2));
            i3 += i6;
            this.y.add(i3, (e.d)this.y.remove(i5));
            i3 = i9;
            if (i5 < size) {
            } else {
            }
            if (obj5.a == dVar2.a) {
            }
            i++;
            if (obj6.b == 0) {
            } else {
            }
            if (obj7.b == i11) {
            }
            i2 = i;
            i5 = i;
            if (i2 < size) {
            } else {
            }
            i4 = i11;
        }
        if (!this.y.isEmpty()) {
            if (obj2.b != 0) {
            } else {
            }
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Sorting went bad, the start event should always be at index 0");
            throw unsupportedOperationException;
        }
        e.d dVar3 = new e.d(this.E, i12);
        this.y.add(i12, dVar3);
        e.d dVar4 = new e.d(this.E, i11);
        this.y.add(i11, dVar4);
        e.d dVar5 = new e.d(this.E, i6);
        this.y.add(i6, dVar5);
        ArrayList list10 = this.y;
        if (obj3.b == 0) {
        } else {
            ArrayList list11 = this.y;
            if (obj4.b == i11) {
            } else {
            }
        }
        UnsupportedOperationException unsupportedOperationException2 = new UnsupportedOperationException("Something went wrong, the last event is not an end event");
        throw unsupportedOperationException2;
    }

    private void U(boolean z, boolean z2) {
        int size2;
        int i;
        Object clone;
        Object size;
        Object obj;
        int obj6;
        if (Looper.myLooper() == null) {
        } else {
            this.B = true;
            this.M = z2;
            obj6 = 0;
            this.v = obj6;
            this.P = -1;
            i = obj6;
            while (i < this.z.size()) {
                size.c = obj6;
                i++;
            }
            J();
            if (z) {
                if (!y()) {
                } else {
                }
                UnsupportedOperationException obj5 = new UnsupportedOperationException("Cannot reverse infinite AnimatorSet");
                throw obj5;
            }
            this.L = z;
            boolean z3 = e.L(this);
            if (!z3) {
                V();
            }
            clone = this.a;
            if (clone != null) {
                clone = clone.clone();
                while (obj6 < (ArrayList)clone.size()) {
                    (c.a)clone.get(obj6).f(this, z);
                    obj6++;
                }
            }
            if (z3) {
                e();
            }
        }
        obj5 = new AndroidRuntimeException("Animators may only be run on Looper threads");
        throw obj5;
    }

    private void V() {
        int cmp2;
        int i3;
        boolean cmp;
        boolean z;
        int i;
        int i2;
        int i4;
        boolean z2;
        x();
        i2 = 0;
        if (Long.compare(l, i2) == 0 && this.L) {
            if (this.L) {
                this.N.d();
            }
        }
        i = 1;
        if (j()) {
            u(z4 ^= i);
        } else {
            if (this.L) {
                K();
                u(z7 ^= i);
            } else {
                size -= i;
                while (i3 >= 0) {
                    i4 = fVar.a;
                    if (obj2.b == i && i4.j()) {
                    }
                    i3--;
                    i4 = fVar.a;
                    if (i4.j()) {
                    }
                    i4.u(i);
                }
            }
        }
        if (!this.L && Long.compare(i4, i2) != 0) {
            if (Long.compare(i4, i2) != 0) {
                if (this.N.c() && this.N.c()) {
                    if (this.N.c()) {
                        this.N.e(this.L);
                        i2 = this.N.a();
                    }
                    cmp = C(i2);
                    I(-1, cmp, i2);
                    size2 -= i;
                    while (i2 >= 0) {
                        if (obj.c) {
                        }
                        i2--;
                        this.w.remove(i2);
                    }
                    this.K = cmp;
                }
            } else {
            }
        } else {
        }
        if (this.M) {
            c.b(this);
        }
    }

    private void W() {
        int size;
        int i;
        int i2;
        long l;
        if (Long.compare(l2, i2) >= 0) {
            i = 0;
            while (i < this.z.size()) {
                obj.a.s(this.F);
                i++;
            }
        }
        this.D.R(this.C);
    }

    private void X(d.h.e.e.f e$f, ArrayList<d.h.e.e.f> arrayList2) {
        int i;
        String string;
        String str;
        int indexOf;
        int size;
        int cmp2;
        int cmp;
        Object obj11;
        d.h.e.e.f obj12;
        i = 0;
        final int i2 = -1;
        if (f.b == null && f == this.E) {
            if (f == this.E) {
            }
        }
        arrayList2.add(f);
        while (i < f.b.size()) {
            string = f.b.get(i);
            string.B = string.a.h();
            if (arrayList2.indexOf((e.f)string) >= 0) {
            } else {
            }
            str = string.z;
            if (Long.compare(str, i2) != 0) {
            }
            X(string, arrayList2);
            i++;
            cmp2 = f.A;
            if (Long.compare(cmp2, i2) == 0) {
            } else {
            }
            if (Long.compare(cmp2, str) >= 0) {
            }
            str = string.B;
            if (Long.compare(str, i2) == 0) {
            } else {
            }
            l2 += str;
            string.A = cmp2;
            cmp2 = i2;
            string.x = f;
            string.z = cmp2;
            string.x = f;
            string.z = i2;
            string.A = i2;
            cmp2 = 0;
            while (indexOf < arrayList2.size()) {
                obj.x = cmp2;
                obj2.z = i2;
                size.A = i2;
                indexOf++;
                cmp2 = 0;
            }
            string.z = i2;
            string.A = i2;
            string.x = cmp2;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Cycle found in AnimatorSet: ");
            stringBuilder.append(this);
            Log.w("AnimatorSet", stringBuilder.toString());
            obj.x = cmp2;
            obj2.z = i2;
            size.A = i2;
            indexOf++;
        }
        arrayList2.remove(f);
    }

    private void x() {
        int i;
        d.h.e.c cVar;
        d.h.e.d dVar;
        i = 1;
        while (i < this.z.size()) {
            obj.a.c(this.Q);
            i++;
        }
    }

    public ArrayList<d.h.e.c> E() {
        int i;
        Object obj;
        d.h.e.e.f fVar;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < this.z.size()) {
            obj = this.z.get(i);
            if ((e.f)obj != this.E) {
            }
            i++;
            arrayList.add(obj.a);
        }
        return arrayList;
    }

    @Override // d.h.e.c
    d.h.e.e.f F(d.h.e.c c) {
        Object fVar;
        boolean z;
        fVar = new e.f(c);
        this.x.put(c, fVar);
        this.z.add(fVar);
        if ((e.f)this.x.get(c) == null && c instanceof e) {
            fVar = new e.f(c);
            this.x.put(c, fVar);
            this.z.add(fVar);
            if (c instanceof e) {
                c.M = false;
            }
        }
        return fVar;
    }

    @Override // d.h.e.c
    public d.h.e.e.e N(d.h.e.c c) {
        e.e eVar = new e.e(this, c);
        return eVar;
    }

    @Override // d.h.e.c
    public void O(d.h.e.c... cArr) {
        d.h.e.e.e eVar;
        int i;
        Object length;
        if (cArr != null) {
            i = 1;
            for (Object length : cArr) {
                N(cArr[0]).a(length);
            }
        }
    }

    @Override // d.h.e.c
    public d.h.e.e S(long l) {
        if (Long.compare(l, i) < 0) {
        } else {
            this.A = true;
            this.F = l;
            return this;
        }
        IllegalArgumentException obj3 = new IllegalArgumentException("duration must be a value of zero or greater");
        throw obj3;
    }

    @Override // d.h.e.c
    public boolean a(long l) {
        boolean z;
        boolean cmp;
        int i4;
        int i3;
        int i;
        int i5;
        int i2;
        long l2;
        int obj11;
        int obj12;
        float f = v.F();
        final int i11 = 1;
        if (Float.compare(f, i6) == 0) {
            e();
            return i11;
        }
        i2 = 0;
        if (Long.compare(l5, i2) < 0) {
            this.J = l;
        }
        i = -1;
        final int i13 = 0;
        if (this.v && Long.compare(l3, i) == 0) {
            if (Long.compare(l3, i) == 0) {
                this.P = l;
            }
            Q();
            return i13;
        }
        l2 = this.P;
        if (Long.compare(l2, i2) > 0) {
            this.J = l12 += l2;
            this.P = i;
        }
        if (this.N.c()) {
            this.N.e(this.L);
            if (this.L) {
                this.J = l - l9;
            } else {
                this.J = l - l11;
            }
            u(z4 ^= i11);
            this.w.clear();
            size -= i11;
            while (i3 >= 0) {
                i.c = i13;
                i3--;
            }
            this.K = -1;
            this.N.d();
        }
        if (!this.L && Long.compare(l, i) < 0) {
            if (Long.compare(l, i) < 0) {
                return i13;
            }
        }
        f2 /= f;
        long l4 = (long)i7;
        this.I = l;
        obj11 = C(l4);
        I(this.K, obj11, l4);
        this.K = obj11;
        obj11 = i13;
        while (obj11 < this.w.size()) {
            obj12 = this.w.get(obj11);
            if (!obj12.c) {
            }
            obj11++;
            P((e.f)obj12, G(l4, i7));
        }
        obj11 -= i11;
        while (obj11 >= 0) {
            if (obj12.c) {
            }
            obj11--;
            this.w.remove(obj11);
        }
        if (this.L && this.w.size() == i11 && this.w.get(i13) == this.E) {
            if (this.w.size() == i11) {
                if (this.w.get(i13) == this.E) {
                    obj11 = i11;
                } else {
                }
            } else {
            }
        } else {
        }
        M();
        if (obj11 != null) {
            B();
            return i11;
        }
        return i13;
    }

    @Override // d.h.e.c
    public void cancel() {
        boolean z;
        Object clone;
        int i;
        int size;
        int i2;
        Object obj;
        if (Looper.myLooper() == null) {
        } else {
            clone = this.a;
            if (l() && clone != null) {
                clone = this.a;
                if (clone != null) {
                    clone = clone.clone();
                    i2 = i;
                    while (i2 < (ArrayList)clone.size()) {
                        (c.a)clone.get(i2).c(this);
                        i2++;
                    }
                }
                ArrayList arrayList = new ArrayList(this.w);
                while (i < arrayList.size()) {
                    obj2.a.cancel();
                    i++;
                }
                this.w.clear();
                B();
            }
        }
        AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException("Animators may only be run on Looper threads");
        throw androidRuntimeException;
    }

    @Override // d.h.e.c
    public Object clone() {
        return z();
    }

    @Override // d.h.e.c
    public d.h.e.c d() {
        return z();
    }

    @Override // d.h.e.c
    public void e() {
        boolean z3;
        int i;
        int size;
        boolean z2;
        int i4;
        int i2;
        int i3;
        boolean z;
        if (Looper.myLooper() == null) {
        } else {
            i4 = 2;
            i2 = 1;
            if (l() && this.L && this.K == -1) {
                i4 = 2;
                i2 = 1;
                if (this.L) {
                    if (this.K == -1) {
                        size = this.y.size();
                    }
                    this.K = size;
                    i = this.K;
                    while (i > 0) {
                        i--;
                        this.K = i5;
                        size = this.y.get(i5);
                        i3 = fVar.a;
                        if (obj.c) {
                        } else {
                        }
                        size = size.b;
                        if (size == i4) {
                        } else {
                        }
                        if (size == i2 && i3.l() != 0) {
                        }
                        i = this.K;
                        if (i3.l() != 0) {
                        }
                        i3.e();
                        i3.r();
                    }
                }
                this.w.clear();
            }
            B();
        }
        AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException("Animators may only be run on Looper threads");
        throw androidRuntimeException;
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
        int i2;
        int i;
        boolean size;
        if (this.O) {
            return 1;
        }
        int i3 = 0;
        i = i3;
        while (i < this.z.size()) {
            if (!obj.a.j()) {
                break;
            } else {
            }
            i++;
        }
        this.O = i2;
        return i2;
    }

    @Override // d.h.e.c
    public boolean k() {
        int i;
        final int i2 = 0;
        if (Long.compare(l, i2) == 0) {
            return this.B;
        }
        i = Long.compare(l2, i2) > 0 ? 1 : 0;
        return i;
    }

    @Override // d.h.e.c
    public boolean l() {
        return this.B;
    }

    @Override // d.h.e.c
    public void m() {
        boolean z;
        if (Looper.myLooper() == null) {
        } else {
            super.m();
            if (!this.v && this.v) {
                if (this.v) {
                    this.P = this.I;
                }
            }
        }
        AndroidRuntimeException androidRuntimeException = new AndroidRuntimeException("Animators may only be run on Looper threads");
        throw androidRuntimeException;
    }

    @Override // d.h.e.c
    boolean n(long l) {
        return a(l);
    }

    @Override // d.h.e.c
    public void r() {
        final int i = 1;
        U(i, i);
    }

    @Override // d.h.e.c
    public d.h.e.c s(long l) {
        S(l);
        return this;
    }

    @Override // d.h.e.c
    public void t(d.h.e.m m) {
        this.G = m;
    }

    @Override // d.h.e.c
    public String toString() {
        String string;
        int i;
        Object obj;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("AnimatorSet@");
        stringBuilder2.append(Integer.toHexString(hashCode()));
        stringBuilder2.append("{");
        string = stringBuilder2.toString();
        i = 0;
        while (i < this.z.size()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("\n    ");
            stringBuilder.append(obj.a.toString());
            string = stringBuilder.toString();
            i++;
        }
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(string);
        stringBuilder3.append("\n}");
        return stringBuilder3.toString();
    }

    @Override // d.h.e.c
    void u(boolean z) {
        boolean z2;
        int i;
        int size;
        int i2;
        int obj4;
        if (this.M) {
            if (!j()) {
            } else {
            }
            obj4 = new UnsupportedOperationException("Children must be initialized.");
            throw obj4;
        }
        J();
        if (z) {
            i = 1;
            obj4 -= i;
            while (obj4 >= 0) {
                if (obj3.b == i) {
                }
                obj4--;
                fVar2.a.u(i);
            }
        } else {
            obj4 = 0;
            i = obj4;
            while (i < this.y.size()) {
                if (obj.b == 2) {
                }
                i++;
                fVar.a.u(obj4);
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
        int i;
        i = Long.compare(l, i2) != 0 ? 1 : 0;
        return i;
    }

    @Override // d.h.e.c
    public d.h.e.e z() {
        int i;
        int i5;
        int i2;
        d.h.e.e.f fVar;
        d.h.e.c size2;
        int i6;
        int size3;
        int size;
        d.h.e.d dVar;
        int i3;
        int i4;
        ArrayList list;
        Object obj;
        final d.h.e.c cVar = super.d();
        int size4 = this.z.size();
        final int i7 = 0;
        cVar.B = i7;
        int i8 = -1;
        cVar.I = i8;
        cVar.J = i8;
        cVar.K = -1;
        cVar.v = i7;
        cVar.P = i8;
        e.g gVar = new e.g(this);
        cVar.N = gVar;
        int i9 = 1;
        cVar.M = i9;
        ArrayList arrayList = new ArrayList();
        cVar.w = arrayList;
        g gVar2 = new g();
        cVar.x = gVar2;
        ArrayList arrayList2 = new ArrayList(size4);
        cVar.z = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        cVar.y = arrayList3;
        e.b bVar = new e.b(this, (e)cVar);
        cVar.Q = bVar;
        cVar.L = i7;
        cVar.A = i9;
        HashMap hashMap = new HashMap(size4);
        i = i7;
        while (i < size4) {
            Object obj3 = this.z.get(i);
            fVar = (e.f)obj3.e();
            fVar.a.p(this.Q);
            hashMap.put(obj3, fVar);
            cVar.z.add(fVar);
            cVar.x.put(fVar.a, fVar);
            i++;
        }
        Object obj2 = hashMap.get(this.E);
        cVar.E = (e.f)obj2;
        cVar.D = (v)obj2.a;
        i5 = i7;
        while (i5 < size4) {
            i2 = this.z.get(i5);
            fVar = hashMap.get((e.f)i2);
            d.h.e.e.f fVar3 = i2.x;
            if (fVar3 == null) {
            } else {
            }
            i6 = hashMap.get(fVar3);
            fVar.x = i6;
            ArrayList list6 = i2.b;
            if (list6 == null) {
            } else {
            }
            size3 = list6.size();
            i3 = i7;
            while (i3 < size3) {
                fVar.b.set(i3, (e.f)hashMap.get(i2.b.get(i3)));
                i3++;
            }
            ArrayList list7 = i2.v;
            if (list7 == null) {
            } else {
            }
            size = list7.size();
            i4 = i7;
            while (i4 < size) {
                fVar.v.set(i4, (e.f)hashMap.get(i2.v.get(i4)));
                i4++;
            }
            ArrayList list8 = i2.w;
            if (list8 == null) {
            } else {
            }
            size2 = list8.size();
            dVar = i7;
            while (dVar < size2) {
                fVar.w.set(dVar, (e.f)hashMap.get(i2.w.get(dVar)));
                dVar++;
            }
            i5++;
            fVar.w.set(dVar, (e.f)hashMap.get(i2.w.get(dVar)));
            dVar++;
            size2 = i7;
            fVar.v.set(i4, (e.f)hashMap.get(i2.v.get(i4)));
            i4++;
            size = i7;
            fVar.b.set(i3, (e.f)hashMap.get(i2.b.get(i3)));
            i3++;
            size3 = i7;
            i6 = 0;
        }
        return cVar;
    }
}
