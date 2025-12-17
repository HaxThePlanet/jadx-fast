package h.a.b;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.RecyclerView.j;
import androidx.recyclerview.widget.h;
import androidx.recyclerview.widget.h.b;
import androidx.recyclerview.widget.h.e;
import androidx.recyclerview.widget.l;
import h.a.b.f.b;
import h.a.b.g.a;
import h.a.b.g.a.a;
import h.a.b.g.b;
import h.a.b.h.d;
import h.a.b.h.e;
import h.a.b.h.f;
import h.a.b.h.g;
import h.a.b.h.h;
import h.a.b.i.a;
import h.a.b.i.c;
import h.a.c.b;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public class b<T extends f>  extends h.a.b.a implements a.a {

    private static int B0;
    private h.a.b.b.j<T> A;
    protected h.a.b.b.t A0;
    private long B;
    private long C;
    private boolean D;
    private h.e E;
    private h.a.b.b.h F;
    protected Handler G;
    private List<h.a.b.b.v<T>> H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private List<T> M;
    private List<T> N;
    private boolean O;
    private boolean P;
    private int Q;
    private b R;
    private ViewGroup S;
    protected LayoutInflater T;
    private HashMap<Integer, T> U;
    private boolean V;
    private Serializable W;
    private Serializable X;
    private Set<d> Y;
    private boolean Z;
    private boolean a0;
    private boolean b0;
    private int c0;
    private int d0;
    private int e0;
    private boolean f0;
    private boolean g0;
    private boolean h0;
    private boolean i0;
    private boolean j0;
    private a k0;
    private l l0;
    private int m0;
    private int n0;
    private boolean o0;
    private boolean p0;
    private boolean q0;
    private T r0;
    public h.a.b.b.p s0;
    public h.a.b.b.q t0;
    protected h.a.b.b.u u0;
    private List<T> v;
    protected h.a.b.b.o v0;
    private List<T> w;
    protected h.a.b.b.r w0;
    private List<T> x;
    protected h.a.b.b.s x0;
    private Set<T> y;
    protected h.a.b.b.i y0;
    private List<h.a.b.b.l> z;
    protected h.a.b.b.n z0;

    class a implements Runnable {

        final int a;
        final h.a.b.b b;
        a(h.a.b.b b, int i2) {
            this.b = b;
            this.a = i2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            b.E(this.b, this.a);
        }
    }

    class b implements Handler.Callback {

        final int a;
        final int b;
        final h.a.b.b c;
        b(h.a.b.b b, int i2, int i3) {
            this.c = b;
            this.a = i2;
            this.b = i3;
            super();
        }

        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message message) {
            int i3;
            h.a.b.b i;
            int i2;
            int i5;
            int i4;
            int obj7;
            obj7 = this.c;
            i2 = 0;
            if (obj7.f == null) {
                return i2;
            }
            obj7 = obj7.l().a();
            i = this.c.l().f();
            i5 = this.a;
            final int i9 = this.b;
            final int i11 = 1;
            if (i10 -= i > 0) {
                i2 = this.c.l().e();
                if (i2 > i11) {
                    i7 += i2;
                }
                b.E(this.c, obj7 += i3);
            } else {
                if (i5 < obj7) {
                    b.E(this.c, i5);
                }
            }
            return i11;
        }
    }

    class c implements Comparator<Integer> {
        c(h.a.b.b b) {
            super();
        }

        @Override // java.util.Comparator
        public int a(Integer integer, Integer integer2) {
            return obj2 -= obj1;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((Integer)object, (Integer)object2);
        }
    }

    class d implements Runnable {

        final boolean a;
        final h.a.b.b b;
        d(h.a.b.b b, boolean z2) {
            this.b = b;
            this.a = z2;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            int arr;
            String str;
            h.a.b.b.t tVar;
            ViewGroup view;
            arr = 0;
            if (this.a) {
                if (b.C(this.b) == null) {
                    h.a.b.b bVar7 = this.b;
                    b bVar11 = new b(bVar7, bVar7.A0, b.L(bVar7));
                    b.D(bVar7, bVar11);
                    b.C(this.b).g(bVar12.f);
                    bVar10.a.c("Sticky headers enabled", new Object[arr]);
                }
            } else {
                if (this.b.l0()) {
                    b.C(this.b).l();
                    b.D(this.b, 0);
                    bVar5.a.c("Sticky headers disabled", new Object[arr]);
                }
            }
        }
    }

    class e implements Runnable {

        final h.a.b.b a;
        e(h.a.b.b b) {
            this.a = b;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a.b.b bVar;
            Object view;
            int i = 0;
            if (b.U(this.a)) {
                bVar8.a.e("Double call detected! Headers already shown OR the method showAllHeaders() was already called!", new Object[i]);
            }
            b.V(this.a, i);
            bVar = this.a;
            h.a.b.b bVar5 = this.a;
            h.a.b.b bVar6 = this.a;
            if (bVar.f != null && bVar.l().a() == 0 && bVar5.o1(bVar5.O0(i)) && !bVar6.o1(bVar6.O0(1))) {
                if (bVar.l().a() == 0) {
                    bVar5 = this.a;
                    if (bVar5.o1(bVar5.O0(i))) {
                        bVar6 = this.a;
                        if (!bVar6.o1(bVar6.O0(1))) {
                            bVar7.f.q1(i);
                        }
                    }
                }
            }
        }
    }

    class f implements Runnable {

        final h.a.b.b a;
        f(h.a.b.b b) {
            this.a = b;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            h.a.b.b bVar;
            h.a.b.b.i iVar;
            int i;
            b.W(this.a);
            bVar = this.a;
            if (bVar.y0 != null) {
                bVar.a.a("onLoadMore     invoked!", new Object[0]);
                h.a.b.b bVar3 = this.a;
                bVar3.y0.a(bVar3.R0(), this.a.I0());
            }
        }
    }

    public interface i {
        public abstract void a(int i, int i2);
    }

    private class j extends AsyncTask<Void, Void, Void> {

        private final List<T> a;
        private final int b;
        final h.a.b.b c;
        j(h.a.b.b b, int i2, List list3) {
            this.c = b;
            super();
            this.b = i2;
            if (list3 == null) {
                ArrayList obj1 = new ArrayList();
            } else {
                super(list3);
            }
            this.a = obj1;
        }

        @Override // android.os.AsyncTask
        protected Void a(Void... voidArr) {
            Object[] arr;
            String str;
            Object cHANGE;
            c obj4;
            b.J(this.c, System.currentTimeMillis());
            obj4 = this.b;
            str = 0;
            if (obj4 != 1) {
                if (obj4 != 2) {
                } else {
                    obj4.a.a("doInBackground - started FILTER", new Object[str]);
                    b.N(this.c, this.a);
                    obj4.a.a("doInBackground - ended FILTER", new Object[str]);
                }
            } else {
                obj4.a.a("doInBackground - started UPDATE", new Object[str]);
                b.K(this.c, this.a);
                b.M(this.c, this.a, d.CHANGE);
                obj4.a.a("doInBackground - ended UPDATE", new Object[str]);
            }
            return null;
        }

        @Override // android.os.AsyncTask
        protected void b(Void void) {
            h.a.b.d fILTER;
            h.a.b.b obj2;
            if (b.O(this.c) == null) {
                if (b.P(this.c) != null) {
                    obj2 = this.b;
                    if (obj2 != 1) {
                        if (obj2 != 2) {
                        } else {
                            b.Q(this.c, d.FILTER);
                            this.c.y1();
                        }
                    } else {
                        b.Q(this.c, d.CHANGE);
                        this.c.z1();
                    }
                }
            } else {
            }
            b.S(this.c, 0);
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object[] objectArr) {
            return a((Void[])objectArr);
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            bVar.a.c("FilterAsyncTask cancelled!", new Object[0]);
        }

        @Override // android.os.AsyncTask
        protected void onPostExecute(Object object) {
            b((Void)object);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            boolean z2;
            boolean z;
            int i;
            Object[] arr;
            String str;
            i = 0;
            if (b.I(this.c)) {
                bVar2.a.e("Cannot filter while endlessLoading", new Object[i]);
                cancel(true);
            }
            bVar4.a.a("Removing all deleted items before filtering/updating", new Object[i]);
            this.a.removeAll(this.c.H0());
            z = bVar5.z0;
            if (this.c.r1() && z != null) {
                bVar4.a.a("Removing all deleted items before filtering/updating", new Object[i]);
                this.a.removeAll(this.c.H0());
                z = bVar5.z0;
                if (z != null) {
                    z.a(3);
                }
            }
        }
    }

    public class k implements Handler.Callback {

        final h.a.b.b a;
        public k(h.a.b.b b) {
            this.a = b;
            super();
        }

        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message message) {
            h.a.b.b.j jVar;
            int i;
            int what = message.what;
            int i2 = 0;
            final int i3 = 1;
            if (what != i3 && what != 2 && what != 8) {
                if (what != 2) {
                    if (what != 8) {
                        return i2;
                    }
                    b.T(this.a);
                    return i3;
                }
            }
            if (b.R(this.a) != null) {
                b.R(this.a).cancel(i3);
            }
            b.j jVar2 = new b.j(this.a, message.what, (List)message.obj);
            b.S(this.a, jVar2);
            b.R(this.a).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[i2]);
            return i3;
        }
    }

    private static class l {

        int a;
        int b;
        int c;
        public l(int i, int i2) {
            super();
            this.b = i;
            this.c = i2;
        }

        public l(int i, int i2, int i3) {
            super(i2, i3);
            this.a = i;
        }

        public String toString() {
            String string;
            int i;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Notification{operation=");
            stringBuilder.append(this.c);
            if (this.c == 4) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(", fromPosition=");
                stringBuilder2.append(this.a);
                string = stringBuilder2.toString();
            } else {
                string = "";
            }
            stringBuilder.append(string);
            stringBuilder.append(", position=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public interface m {
        public abstract void e(RecyclerView.e0 recyclerView$e0, int i2);
    }

    public interface n {
        public abstract void a(int i);
    }

    public interface o {
        public abstract void a(int i);
    }

    public interface p {
        public abstract boolean x(View view, int i2);
    }

    public interface q {
        public abstract void a(int i);
    }

    public interface t {
        public abstract void a(int i, int i2);
    }

    public interface u {
        public abstract void a(int i);
    }

    private class v {

        int a;
        int b;
        T c;
        T d;
        public v(h.a.b.b b, f f2, f f3) {
            super(b, f2, f3, -1);
        }

        public v(h.a.b.b b, f f2, f f3, int i4) {
            super();
            int obj1 = -1;
            this.a = obj1;
            this.b = obj1;
            obj1 = 0;
            this.c = obj1;
            this.d = obj1;
            this.c = f2;
            this.d = f3;
            this.b = i4;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("RestoreInfo[item=");
            stringBuilder.append(this.d);
            stringBuilder.append(", refItem=");
            stringBuilder.append(this.c);
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    private class g extends RecyclerView.j {

        final h.a.b.b a;
        private g(h.a.b.b b) {
            this.a = b;
            super();
        }

        g(h.a.b.b b, h.a.b.c c2) {
            super(b);
        }

        private void a(int i, int i2) {
            boolean z;
            if (b.F(this.a)) {
                b.H(this.a, i, i2);
            }
            b.G(this.a, true);
        }

        private void b(int i) {
            int aVar;
            int i3;
            int i2;
            int obj4;
            aVar = this.a.W0();
            if (aVar >= 0 && aVar == i) {
                if (aVar == i) {
                    Object[] arr = new Object[1];
                    i2 = 0;
                    arr[i2] = Integer.valueOf(aVar);
                    obj4.a.a("updateStickyHeader position=%s", arr);
                    aVar = new b.g.a(this);
                    obj4.f.postDelayed(aVar, 100);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onChanged() {
            b(this.a.W0());
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeChanged(int i, int i2) {
            b(i);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeInserted(int i, int i2) {
            a(i, i2);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$j
        public void onItemRangeRemoved(int i, int i2) {
            b(i);
            a(i, -i2);
        }
    }

    public static class h extends h.b {

        protected List<T> a;
        protected List<T> b;
        public final List<T> a() {
            return this.b;
        }

        @Override // androidx.recyclerview.widget.h$b
        public boolean areContentsTheSame(int i, int i2) {
            return obj2 ^= 1;
        }

        @Override // androidx.recyclerview.widget.h$b
        public boolean areItemsTheSame(int i, int i2) {
            return (f)this.a.get(i).equals((f)this.b.get(i2));
        }

        public final void b(List<T> list, List<T> list2) {
            this.a = list;
            this.b = list2;
        }

        @Override // androidx.recyclerview.widget.h$b
        public Object getChangePayload(int i, int i2) {
            return d.CHANGE;
        }

        @Override // androidx.recyclerview.widget.h$b
        public final int getNewListSize() {
            return this.b.size();
        }

        @Override // androidx.recyclerview.widget.h$b
        public final int getOldListSize() {
            return this.a.size();
        }
    }

    public interface r extends h.a.b.b.m {
        @Override // h.a.b.b$m
        public abstract void k(int i, int i2);

        @Override // h.a.b.b$m
        public abstract boolean v1(int i, int i2);
    }

    public interface s extends h.a.b.b.m {
        @Override // h.a.b.b$m
        public abstract void n0(int i, int i2);
    }
    static {
        String simpleName = b.class.getSimpleName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(simpleName);
        stringBuilder.append("_parentSelected");
        stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(simpleName);
        stringBuilder2.append("_childSelected");
        stringBuilder2.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(simpleName);
        stringBuilder3.append("_headersShown");
        stringBuilder3.toString();
        StringBuilder stringBuilder4 = new StringBuilder();
        stringBuilder4.append(simpleName);
        stringBuilder4.append("_stickyHeaders");
        stringBuilder4.toString();
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append(simpleName);
        stringBuilder5.append("_selectedLevel");
        stringBuilder5.toString();
        StringBuilder stringBuilder6 = new StringBuilder();
        stringBuilder6.append(simpleName);
        stringBuilder6.append("_filter");
        stringBuilder6.toString();
        b.B0 = 1000;
    }

    public b(List<T> list) {
        super(list, 0);
    }

    public b(List<T> list, Object object2) {
        super(list, object2, 0);
    }

    public b(List<T> list, Object object2, boolean z3) {
        Object obj4;
        int obj6;
        super(z3);
        obj6 = 0;
        this.D = obj6;
        b.k kVar = new b.k(this);
        Handler handler = new Handler(Looper.getMainLooper(), kVar);
        this.G = handler;
        this.I = obj6;
        this.J = obj6;
        int i = 1;
        this.K = i;
        this.L = i;
        this.O = obj6;
        this.P = obj6;
        HashMap hashMap = new HashMap();
        this.U = hashMap;
        this.V = obj6;
        int i2 = 0;
        this.W = i2;
        this.X = "";
        this.Z = i;
        this.a0 = obj6;
        this.b0 = obj6;
        this.c0 = b.B0;
        this.d0 = obj6;
        this.e0 = -1;
        this.f0 = obj6;
        this.g0 = obj6;
        this.h0 = obj6;
        this.i0 = obj6;
        this.j0 = obj6;
        this.m0 = i;
        this.n0 = obj6;
        this.o0 = obj6;
        this.p0 = obj6;
        this.q0 = obj6;
        if (list == null) {
            obj4 = new ArrayList();
            this.v = obj4;
        } else {
            obj6 = new ArrayList(list);
            this.v = obj6;
        }
        obj4 = new ArrayList();
        this.M = obj4;
        obj4 = new ArrayList();
        this.N = obj4;
        obj4 = new ArrayList();
        this.H = obj4;
        obj4 = new ArrayList();
        if (object2 != null) {
            a0(object2);
        }
        obj4 = new b.g(this, i2);
        registerAdapterDataObserver(obj4);
    }

    private boolean A0(T t, List<T> list2) {
        boolean iterator;
        Object hashSet;
        boolean z;
        int i;
        boolean next;
        boolean hidden;
        int i2;
        i = 0;
        if (j1(t) && (d)t.a() && this.Y == null) {
            if ((d)t.a()) {
                if (this.Y == null) {
                    hashSet = new HashSet();
                    this.Y = hashSet;
                }
                this.Y.add(t);
            }
            iterator = E0(t).iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                i2 = 1;
                if (next instanceof d && D0((f)next, list2)) {
                } else {
                }
                next.setHidden(z2 ^= i2);
                if (!next.isHidden()) {
                }
                list2.add(next);
                i = i2;
                if (D0(next, list2)) {
                } else {
                }
            }
            t.d(i);
        }
        return i;
    }

    private void A1(int i, List<T> list2, boolean z3) {
        List itemCount;
        String str;
        Integer valueOf;
        int obj4;
        java.util.Collection obj5;
        c obj6;
        itemCount = getItemCount();
        if (i < itemCount) {
            this.v.addAll(i, list2);
        } else {
            this.v.addAll(list2);
            obj4 = itemCount;
        }
        if (z3 != null) {
            itemCount = new Object[2];
            this.a.a("addItems on position=%s itemCount=%s", Integer.valueOf(obj4), Integer.valueOf(list2.size()));
            notifyItemRangeInserted(obj4, list2.size());
        }
    }

    private void B0(List<T> list) {
        ArrayList arrayList;
        boolean fILTER;
        boolean next;
        boolean next2;
        int cancelled;
        Object obj7;
        cancelled = 1;
        final Object[] arr = new Object[cancelled];
        final int i = 0;
        arr[i] = this.W;
        this.a.a("filterItems with filterEntity=\"%s\"", arr);
        arrayList = new ArrayList();
        this.a0 = cancelled;
        synchronized (this) {
            try {
                if (a1(this.W)) {
                } else {
                }
                obj7 = list.iterator();
                for (f next : obj7) {
                    cancelled = this.A;
                    D0(next, arrayList);
                }
                cancelled = this.A;
                if (cancelled != null) {
                } else {
                }
                if (cancelled.isCancelled()) {
                } else {
                }
                D0((f)obj7.next(), arrayList);
                if (a1(this.W)) {
                } else {
                }
                K1(list);
                arrayList = 0;
                this.Y = arrayList;
                if (this.x == null) {
                }
                L1(list);
                this.x = arrayList;
                obj7 = arrayList;
                if (a1(this.W)) {
                }
                this.X = this.W;
                e0(obj7, d.FILTER);
                this.a0 = i;
                throw list;
            }
        }
    }

    private void B1(T t, boolean z2) {
        int obj3;
        if (z2 != 0) {
            this.K = true;
        }
        removeItem(M0(t));
        this.K = this.K;
    }

    static b C(h.a.b.b b) {
        return b.R;
    }

    private void C1(int i) {
        int i2;
        int obj3;
        final RecyclerView view = this.f;
        if (view != null) {
            view.y1(Math.min(Math.max(0, i), itemCount--));
        }
    }

    static b D(h.a.b.b b, b b2) {
        b.R = b2;
        return b2;
    }

    private boolean D0(T t, List<T> list2) {
        h.a.b.b.j cancelled;
        boolean contains2;
        boolean z;
        g gVar;
        boolean contains;
        cancelled = this.A;
        final int i = 0;
        if (cancelled != null && cancelled.isCancelled()) {
            if (cancelled.isCancelled()) {
                return i;
            }
        }
        if (this.x != null && !s1(t) && list2.contains(t)) {
            if (!s1(t)) {
                if (list2.contains(t)) {
                }
            }
            return i;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        if (!A0(t, arrayList)) {
            z = C0(t, L0(Serializable.class));
        }
        gVar = N0(t);
        if (z && this.O && Z0(t) && !list2.contains(gVar)) {
            gVar = N0(t);
            if (this.O) {
                if (Z0(t)) {
                    if (!list2.contains(gVar)) {
                        gVar.setHidden(i);
                        list2.add(gVar);
                    }
                }
            }
            list2.addAll(arrayList);
        }
        t.setHidden(z ^ 1);
        return z;
    }

    private void D1(List<T> list) {
        int i;
        int i2;
        g gVar;
        boolean hidden;
        boolean z;
        int i3;
        int size;
        if (this.Z) {
            i();
        }
        L1(list);
        i = 0;
        final int i4 = 0;
        i2 = i4;
        while (i2 < list.size()) {
            Object obj = list.get(i2);
            i3 = 1;
            if (l1((f)obj)) {
            }
            if (!this.O && o1(obj) && !obj.isHidden()) {
            }
            gVar = N0(obj);
            if (gVar != null && !gVar.equals(i) && !j1(gVar)) {
            }
            i2 += i3;
            if (!gVar.equals(i)) {
            }
            if (!j1(gVar)) {
            }
            gVar.setHidden(i4);
            list.add(i2, gVar);
            i2++;
            i = gVar;
            if (o1(obj)) {
            }
            if (!obj.isHidden()) {
            }
            this.O = i3;
            Object obj2 = obj;
            (d)obj2.d(i3);
            z = J0(obj2, i4);
            if (i2 < list.size()) {
            } else {
            }
            list.addAll(z);
            list.addAll(i2 + 1, z);
        }
    }

    static void E(h.a.b.b b, int i2) {
        b.C1(i2);
    }

    private int E1(int i, List<T> list2, int i3) {
        int i4;
        int i2;
        Object obj;
        boolean z;
        final int i5 = 1;
        size -= i5;
        i2 = 0;
        while (i4 >= 0) {
            obj = list2.get(i4);
            if (l1((f)obj) && (d)obj.c() >= i3 && o0(i + i4, i5) > 0) {
            }
            i4--;
            if ((d)obj.c() >= i3) {
            }
            if (o0(i + i4, i5) > 0) {
            }
            i2++;
        }
        return i2;
    }

    static boolean F(h.a.b.b b) {
        return b.L;
    }

    static boolean G(h.a.b.b b, boolean z2) {
        b.L = z2;
        return z2;
    }

    static void H(h.a.b.b b, int i2, int i3) {
        b.d0(i2, i3);
    }

    static boolean I(h.a.b.b b) {
        return b.o0;
    }

    static long J(h.a.b.b b, long l2) {
        b.B = l2;
        return l2;
    }

    private List<T> J0(d d, boolean z2) {
        boolean next;
        boolean hidden;
        Object obj4;
        ArrayList arrayList = new ArrayList();
        if (d != null && c1(d)) {
            if (c1(d)) {
                obj4 = d.b().iterator();
                while (obj4.hasNext()) {
                    next = obj4.next();
                    arrayList.add(next);
                    if (!(f)next.isHidden() && z2 && l1(next) && (d)next.b().size() > 0) {
                    }
                    arrayList.add(next);
                    if (z2) {
                    }
                    if (l1(next)) {
                    }
                    if ((d)next.b().size() > 0) {
                    }
                    arrayList.addAll(J0(next, true));
                }
            }
        }
        return arrayList;
    }

    static void K(h.a.b.b b, List list2) {
        b.D1(list2);
    }

    private void K1(List<T> list) {
        int i2;
        int i3;
        Object obj;
        boolean equals;
        boolean size;
        int size2;
        int i;
        boolean z2;
        int i4;
        Set contains;
        Iterator iterator;
        boolean next;
        boolean z;
        if (list == null) {
        }
        i2 = 0;
        final int i5 = 0;
        i3 = i5;
        while (i3 < list.size()) {
            obj = list.get(i3);
            (f)obj.setHidden(i5);
            i = 1;
            if (j1(obj)) {
            }
            obj = N0(obj);
            if (this.O && this.x == null && obj != null && !obj.equals(i2) && !j1(obj)) {
            }
            i3 += i;
            if (this.x == null) {
            }
            obj = N0(obj);
            if (obj != null) {
            }
            if (!obj.equals(i2)) {
            }
            if (!j1(obj)) {
            }
            obj.setHidden(i5);
            list.add(i3, obj);
            i3++;
            i2 = obj;
            size = obj;
            contains = this.Y;
            if (contains != null && contains.contains((d)size)) {
            } else {
            }
            i4 = i5;
            size.d(i4);
            if (c1(size)) {
            }
            z2 = size.b();
            iterator = z2.iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                (f)next.setHidden(i5);
                if (next instanceof d) {
                }
                (d)next.d(i5);
                K1(next.b());
            }
            if (size.a() && this.x == null) {
            }
            if (this.x == null) {
            }
            if (i3 < list.size()) {
            } else {
            }
            list.addAll(z2);
            i3 += size;
            list.addAll(i3 + 1, z2);
            next = iterator.next();
            (f)next.setHidden(i5);
            if (next instanceof d) {
            }
            (d)next.d(i5);
            K1(next.b());
            if (contains.contains(size)) {
            } else {
            }
            i4 = i;
        }
    }

    static ViewGroup L(h.a.b.b b) {
        return b.S;
    }

    private void L1(List<T> list) {
        Object next;
        int size;
        Iterator iterator = this.M.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (list.size() > 0) {
            } else {
            }
            list.add((f)next);
            list.add(0, next);
        }
        list.addAll(this.N);
    }

    static void M(h.a.b.b b, List list2, h.a.b.d d3) {
        b.e0(list2, d3);
    }

    static void N(h.a.b.b b, List list2) {
        b.B0(list2);
    }

    static h.e O(h.a.b.b b) {
        return b.E;
    }

    static List P(h.a.b.b b) {
        return b.z;
    }

    static void Q(h.a.b.b b, h.a.b.d d2) {
        b.v0(d2);
    }

    private void Q1(boolean z) {
        Object[] eVar;
        String str;
        int obj3;
        int i = 0;
        if (z) {
            this.a.c("showAllHeaders at startup", new Object[i]);
            R1(true);
        } else {
            this.a.c("showAllHeaders with insert notification (in Post!)", new Object[i]);
            eVar = new b.e(this);
            this.G.post(eVar);
        }
    }

    static h.a.b.b.j R(h.a.b.b b) {
        return b.A;
    }

    private void R1(boolean z) {
        int i3;
        int i2;
        boolean z2;
        int i;
        g gVar;
        boolean equals;
        i3 = 0;
        i2 = 0;
        i = 1;
        while (i3 < itemCount -= size) {
            f fVar = O0(i3);
            gVar = N0(fVar);
            if (gVar != null && !gVar.equals(i2) && !j1(gVar)) {
            }
            if (S1(i3, fVar, z)) {
            }
            i3 += i;
            i = 1;
            i3++;
            if (!gVar.equals(i2)) {
            }
            if (!j1(gVar)) {
            }
            gVar.setHidden(i);
            i2 = gVar;
        }
        this.O = i;
    }

    static h.a.b.b.j S(h.a.b.b b, h.a.b.b.j b$j2) {
        b.A = j2;
        return j2;
    }

    private h.a.b.b.v<T> S0(T t) {
        Object next;
        boolean equals;
        Iterator iterator = this.H.iterator();
        for (b.v next : iterator) {
        }
        return 0;
    }

    private boolean S1(int i, T t2, boolean z3) {
        f obj7;
        final g gVar = N0(t2);
        final int i2 = 0;
        if (gVar != null) {
            if (S0(t2) != null) {
            } else {
                if (gVar.isHidden()) {
                    Object[] arr = new Object[2];
                    arr[i2] = Integer.valueOf(i);
                    int i4 = 1;
                    arr[i4] = gVar;
                    this.a.d("Showing header position=%s header=%s", arr);
                    gVar.setHidden(i2);
                    A1(i, Collections.singletonList(gVar), z3 ^= i4);
                    return i4;
                }
            }
        }
        return i2;
    }

    static void T(h.a.b.b b) {
        b.g1();
    }

    private void T1(List<T> list) {
        boolean next;
        HashSet hashSet2;
        HashSet hashSet;
        boolean next2;
        int i;
        g gVar;
        int i2;
        Iterator obj7;
        if (this.O && !this.P) {
            if (!this.P) {
                this.P = true;
                hashSet2 = new HashSet();
                hashSet = new HashSet();
                obj7 = list.iterator();
                i = 0;
                while (obj7.hasNext()) {
                    next2 = obj7.next();
                    gVar = N0((f)next2);
                    if (gVar == null) {
                    } else {
                    }
                    if (S1(M0(next2), next2, i)) {
                    } else {
                    }
                    hashSet.add(gVar);
                    i = 0;
                    hashSet2.add(gVar);
                }
                hashSet.removeAll(hashSet2);
                obj7 = hashSet.iterator();
                for (g next3 : obj7) {
                    notifyItemChanged(M0(next3), d.CHANGE);
                }
                this.P = i;
            }
        }
    }

    static boolean U(h.a.b.b b) {
        return b.O;
    }

    private void U1() {
        f fVar;
        this.G.removeMessages(8);
        this.a.d("onLoadMore     show progressItem", new Object[0]);
        if (this.q0) {
            c0(this.r0);
        } else {
            b0(this.r0);
        }
    }

    static void V(h.a.b.b b, boolean z2) {
        b.R1(z2);
    }

    static void W(h.a.b.b b) {
        b.U1();
    }

    private T X0(int i) {
        return (f)this.U.get(Integer.valueOf(i));
    }

    private void X1(T t, Object object2) {
        boolean hidden;
        boolean hidden2;
        g header;
        int i;
        Object[] arr;
        String str;
        f obj6;
        hidden2 = t;
        header = (h)hidden2.getHeader();
        arr = new Object[2];
        this.a.d("Unlink header %s from %s", header, hidden2);
        hidden2.setHeader(0);
        if (Z0(t) && object2 != null && !header.isHidden()) {
            hidden2 = t;
            header = (h)hidden2.getHeader();
            arr = new Object[2];
            this.a.d("Unlink header %s from %s", header, hidden2);
            hidden2.setHeader(0);
            if (object2 != null) {
                if (!header.isHidden()) {
                    notifyItemChanged(M0(header), object2);
                }
                if (!t.isHidden()) {
                    notifyItemChanged(M0(t), object2);
                }
            }
        }
    }

    private void d0(int i, int i2) {
        Iterator iterator;
        String str;
        int stringBuilder;
        Object next;
        int i3;
        int intValue;
        int obj8;
        int obj9;
        List list = p();
        if (i2 > 0) {
            b.c cVar = new b.c(this);
            Collections.sort(list, cVar);
            str = "+";
        } else {
            str = "";
        }
        iterator = list.iterator();
        final int i5 = 0;
        stringBuilder = i5;
        i3 = 1;
        while (iterator.hasNext()) {
            next = iterator.next();
            if ((Integer)next.intValue() >= i) {
            }
            i3 = 1;
            t(next.intValue());
            f(Math.max(intValue3 += i2, i));
            stringBuilder = i3;
        }
        if (stringBuilder != null) {
            iterator = new Object[2];
            stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(i2);
            iterator[i5] = stringBuilder.toString();
            iterator[i3] = p();
            this.a.d("AdjustedSelected(%s)=%s", iterator);
        }
    }

    private boolean d1(int i, List<T> list2) {
        Object next;
        int i2;
        int i3;
        boolean z;
        int obj5;
        final Iterator obj6 = list2.iterator();
        i2 = 0;
        for (f next : obj6) {
            i3 = 1;
            obj5 += i3;
            i2 = 0;
        }
        return i2;
    }

    private void e0(List<T> list, h.a.b.d d2) {
        List z;
        Object[] arr;
        Object obj3;
        h.a.b.b.h obj4;
        synchronized (this) {
            try {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Animate changes with DiffUtils! oldSize=");
                stringBuilder.append(getItemCount());
                stringBuilder.append(" newSize=");
                stringBuilder.append(list.size());
                this.a.d(stringBuilder.toString(), new Object[0]);
                if (this.F == null) {
                }
                obj4 = new b.h();
                this.F = obj4;
                this.F.b(this.v, list);
                this.E = h.c(this.F, this.b0);
                f0(list, d2);
                throw list;
            }
        }
    }

    private void e1(int i, g g2) {
        c cVar;
        Object[] arr;
        int i2;
        String str;
        Object obj6;
        if (i >= 0) {
            arr = new Object[2];
            i2 = 1;
            arr[i2] = g2;
            this.a.d("Hiding header position=%s header=$s", arr);
            g2.setHidden(i2);
            this.v.remove(i);
            notifyItemRemoved(i);
        }
    }

    private void f0(List<T> list, h.a.b.d d2) {
        boolean lVar;
        List list2;
        Object[] arr;
        Integer valueOf;
        c cVar;
        int size;
        String str;
        int i;
        Object valueOf2;
        List obj8;
        ArrayList arrayList = new ArrayList();
        this.z = arrayList;
        int i2 = 2;
        int i3 = 1;
        int i6 = 3;
        valueOf = 0;
        synchronized (this) {
            try {
                if (list.size() <= this.c0) {
                } else {
                }
                arr = new Object[i6];
                arr[valueOf] = Integer.valueOf(getItemCount());
                arr[i3] = Integer.valueOf(list.size());
                arr[i2] = Integer.valueOf(this.c0);
                this.a.a("Animate changes! oldSize=%s newSize=%s limit=%s", arr);
                ArrayList arrayList2 = new ArrayList(this.v);
                this.w = arrayList2;
                i0(arrayList2, list);
                g0(this.w, list);
                if (this.b0) {
                }
                h0(this.w, list);
                arr = new Object[i6];
                arr[valueOf] = Integer.valueOf(getItemCount());
                if (list != null) {
                } else {
                }
                valueOf2 = Integer.valueOf(list.size());
                valueOf2 = "0";
                arr[i3] = valueOf2;
                arr[i2] = Integer.valueOf(this.c0);
                this.a.a("NotifyDataSetChanged! oldSize=%s newSize=%s limit=%s", arr);
                this.w = list;
                lVar = new b.l(-1, valueOf);
                this.z.add(lVar);
                if (this.A == null) {
                }
                v0(d2);
                throw list;
            }
        }
    }

    private void f1(T t) {
        boolean hidden;
        final g obj2 = N0(t);
        if (obj2 != null && !obj2.isHidden()) {
            if (!obj2.isHidden()) {
                e1(M0(obj2), obj2);
            }
        }
    }

    private void g0(List<T> list, List<T> list2) {
        int i3;
        int i2;
        Object obj;
        h.a.b.b.j cancelled;
        int i;
        boolean lVar;
        int size;
        String str;
        HashSet hashSet = new HashSet(list);
        this.y = hashSet;
        int i4 = 0;
        i2 = i3;
        i = 1;
        while (i3 < list2.size()) {
            cancelled = this.A;
            obj = list2.get(i3);
            if (!this.y.contains((f)obj)) {
            }
            i3++;
            i = 1;
            size = new Object[2];
            size[i4] = Integer.valueOf(i3);
            size[i] = obj;
            this.a.d("calculateAdditions add position=%s item=%s", size);
            if (this.b0) {
            } else {
            }
            if (i3 < list.size()) {
            } else {
            }
            list.add(obj);
            lVar = new b.l(i3, i);
            this.z.add(lVar);
            i2++;
            list.add(i3, obj);
            list.add(obj);
            lVar = new b.l(list.size(), i);
            this.z.add(lVar);
        }
        this.y = 0;
        final Object[] obj10 = new Object[i];
        obj10[i4] = Integer.valueOf(i2);
        this.a.a("calculateAdditions total new=%s", obj10);
    }

    private void g1() {
        int i;
        Object[] arr;
        String str;
        if (M0(this.r0) >= 0) {
            this.a.d("onLoadMore     remove progressItem", new Object[0]);
            if (this.q0) {
                J1(this.r0);
            } else {
                I1(this.r0);
            }
        }
    }

    private void h0(List<T> list, List<T> list2) {
        int i2;
        int i3;
        int indexOf;
        h.a.b.b.j cancelled;
        List list3;
        h.a.b.b.l lVar;
        int i;
        final int i4 = 1;
        size -= i4;
        final int i5 = 0;
        i3 = i5;
        while (i2 >= 0) {
            cancelled = this.A;
            indexOf = list.indexOf((f)list2.get(i2));
            if (indexOf >= 0 && indexOf != i2) {
            }
            i2--;
            if (indexOf != i2) {
            }
            Object[] arr = new Object[2];
            arr[i5] = Integer.valueOf(indexOf);
            arr[i4] = Integer.valueOf(i2);
            this.a.d("calculateMovedItems fromPosition=%s toPosition=%s", arr);
            Object remove = list.remove(indexOf);
            if (i2 < list.size()) {
            } else {
            }
            list.add((f)remove);
            lVar = new b.l(indexOf, i2, 4);
            this.z.add(lVar);
            i3++;
            list.add(i2, remove);
        }
        final Object[] obj10 = new Object[i4];
        obj10[i5] = Integer.valueOf(i3);
        this.a.a("calculateMovedItems total move=%s", obj10);
    }

    private void h1() {
        Object aVar;
        l lVar;
        Object[] arr;
        String str;
        if (this.l0 == null) {
            if (this.f == null) {
            } else {
                if (this.k0 == null) {
                    a aVar2 = new a(this);
                    this.k0 = aVar2;
                    this.a.c("Initialized default ItemTouchHelperCallback", new Object[0]);
                }
                lVar = new l(this.k0);
                this.l0 = lVar;
                lVar.g(this.f);
            }
            IllegalStateException illegalStateException = new IllegalStateException("RecyclerView cannot be null. Enabling LongPressDrag or Swipe must be done after the Adapter has been attached to the RecyclerView.");
            throw illegalStateException;
        }
    }

    private void i0(List<T> list, List<T> list2) {
        int i4;
        int i;
        int i2;
        Object notifyChange;
        h.a.b.b.j cancelled;
        boolean lVar;
        int i3;
        boolean valueOf;
        HashSet hashSet = new HashSet(list2);
        this.y = hashSet;
        final int i5 = 1;
        size -= i5;
        final int i6 = 0;
        i2 = i;
        while (i4 >= 0) {
            cancelled = this.A;
            notifyChange = list.get(i4);
            i3 = 2;
            if (!this.y.contains((f)notifyChange)) {
            } else {
            }
            if (this.Z) {
            }
            i4--;
            lVar = list2.get((Integer)j0(list, list2).get(notifyChange).intValue());
            if (!m1()) {
            } else {
            }
            list.set(i4, (f)lVar);
            lVar = new b.l(i4, i3);
            this.z.add(lVar);
            i++;
            if (notifyChange.shouldNotifyChange(lVar)) {
            }
            Object[] arr = new Object[i3];
            arr[i6] = Integer.valueOf(i4);
            arr[i5] = notifyChange;
            this.a.d("calculateRemovals remove position=%s item=%s", arr);
            list.remove(i4);
            lVar = new b.l(i4, 3);
            this.z.add(lVar);
            i2++;
        }
        this.y = 0;
        Object[] obj12 = new Object[i5];
        obj12[i6] = Integer.valueOf(i);
        this.a.a("calculateModifications total mod=%s", obj12);
        obj12 = new Object[i5];
        obj12[i6] = Integer.valueOf(i2);
        this.a.a("calculateRemovals total out=%s", obj12);
    }

    private Map<T, Integer> j0(List<T> list, List<T> list2) {
        int i;
        Object obj;
        h.a.b.b.j cancelled;
        boolean valueOf;
        if (this.Z) {
            HashSet hashSet = new HashSet(list);
            this.y = hashSet;
            HashMap obj4 = new HashMap();
            i = 0;
            while (i < list2.size()) {
                cancelled = this.A;
                if (cancelled != null) {
                    break;
                } else {
                }
                obj = list2.get(i);
                if (this.y.contains((f)obj)) {
                }
                i++;
                obj4.put(obj, Integer.valueOf(i));
                if (cancelled.isCancelled()) {
                    break;
                } else {
                }
            }
            return obj4;
        }
        return 0;
    }

    private void m0(int i, int i2) {
        b.b bVar = new b.b(this, i, i2);
        Handler handler = new Handler(Looper.getMainLooper(), bVar);
        handler.sendMessageDelayed(Message.obtain(this.G), 150);
    }

    private boolean q0(List<T> list, d d2) {
        boolean obj2;
        Object obj3;
        if (list.contains(d2) && list.removeAll(d2.b())) {
            obj2 = list.removeAll(d2.b()) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    private void s0(int i, T t2) {
        f fVar;
        d dVar;
        if (l1(t2)) {
            n0(i);
        }
        fVar = O0(i + -1);
        dVar = K0(fVar);
        if (fVar != null && dVar != null) {
            dVar = K0(fVar);
            if (dVar != null) {
                fVar = dVar;
            }
        }
        b.v vVar = new b.v(this, fVar, t2);
        this.H.add(vVar);
        Object[] arr = new Object[2];
        List list2 = this.H;
        final int i6 = 1;
        arr[i6] = Integer.valueOf(i);
        this.a.d("Recycled Item %s on position=%s", arr);
    }

    private void t0(d d, T t2) {
        final int i = 0;
        b.v vVar = new b.v(this, d, t2, J0(d, i).indexOf(t2));
        this.H.add(vVar);
        Object[] arr = new Object[2];
        List list3 = this.H;
        final int i4 = 1;
        arr[i] = list3.get(size -= i4);
        arr[i4] = Integer.valueOf(M0(d));
        this.a.d("Recycled SubItem %s with Parent position=%s", arr);
    }

    private void t1(T t, g g2, Object object3) {
        boolean hidden;
        Object header;
        g uNLINK;
        Object[] arr;
        String str;
        int obj5;
        Object obj6;
        if (t != null && t instanceof h) {
            if (t instanceof h) {
                hidden = t;
                if ((h)hidden.getHeader() != null && !hidden.getHeader().equals(g2)) {
                    if (!hidden.getHeader().equals(g2)) {
                        X1(hidden, d.UNLINK);
                    }
                }
                arr = new Object[2];
                this.a.d("Link header %s to %s", g2, hidden);
                hidden.setHeader(g2);
                if (hidden.getHeader() == null && g2 != null && object3 != null && !g2.isHidden()) {
                    if (g2 != null) {
                        arr = new Object[2];
                        this.a.d("Link header %s to %s", g2, hidden);
                        hidden.setHeader(g2);
                        if (object3 != null) {
                            if (!g2.isHidden()) {
                                notifyItemChanged(M0(g2), object3);
                            }
                            if (!t.isHidden()) {
                                notifyItemChanged(M0(t), object3);
                            }
                        }
                    }
                }
            } else {
                notifyItemChanged(M0(g2), object3);
            }
        } else {
        }
    }

    private void u1(T t) {
        boolean key;
        Integer valueOf2;
        int i;
        Integer valueOf;
        Object obj5;
        if (!this.U.containsKey(Integer.valueOf(t.getItemViewType()))) {
            this.U.put(Integer.valueOf(t.getItemViewType()), t);
            valueOf2 = new Object[2];
            this.a.c("Mapped viewType %s from %s", Integer.valueOf(t.getItemViewType()), a.a(t));
        }
    }

    private void v0(h.a.b.d d) {
        Object iterator;
        Object[] next;
        String str;
        Object[] arr;
        Integer valueOf;
        Object obj8;
        final int i2 = 0;
        int i3 = 1;
        final int i4 = 0;
        synchronized (this) {
            try {
                this.a.c("Dispatching notifications", new Object[i4]);
                this.v = this.F.a();
                this.E.c(this);
                this.E = i2;
                arr = new Object[i3];
                arr[i4] = Integer.valueOf(this.z.size());
                this.a.c("Performing %s notifications", arr);
                this.v = this.w;
                B(i4);
                iterator = this.z.iterator();
                while (iterator.hasNext()) {
                    Object next2 = iterator.next();
                    arr = next2.c;
                    if (arr != i3) {
                    } else {
                    }
                    notifyItemInserted(next2.b);
                    if (arr != 2) {
                    } else {
                    }
                    notifyItemChanged(next2.b, d);
                    if (arr != 3) {
                    } else {
                    }
                    notifyItemRemoved(next2.b);
                    if (arr != 4) {
                    } else {
                    }
                    notifyItemMoved(next2.a, next2.b);
                    this.a.e("notifyDataSetChanged!", new Object[i4]);
                    notifyDataSetChanged();
                }
                next2 = iterator.next();
                arr = next2.c;
                if (arr != i3) {
                } else {
                }
                if (arr != 2) {
                } else {
                }
                if (arr != 3) {
                } else {
                }
                if (arr != 4) {
                } else {
                }
                this.a.e("notifyDataSetChanged!", new Object[i4]);
                notifyDataSetChanged();
                notifyItemMoved(next2.a, next2.b);
                notifyItemRemoved(next2.b);
                notifyItemChanged(next2.b, d);
                notifyItemInserted(next2.b);
                this.w = i2;
                this.z = i2;
                B(i3);
                currentTimeMillis -= l;
                this.C = i;
                Object[] arr2 = new Object[i3];
                arr2[i4] = Long.valueOf(i);
                this.a.c("Animate changes DONE in %sms", arr2);
                throw d;
            }
        }
    }

    private int y0(int i, boolean z2, boolean z3, boolean z4) {
        List next;
        int i2;
        c size;
        boolean z;
        Object[] arr;
        String str;
        int obj10;
        h.a.b.d obj11;
        String obj12;
        int obj13;
        next = O0(i);
        i2 = 0;
        if (!j1(next)) {
            return i2;
        }
        f fVar = next;
        final int i4 = 2;
        final int i5 = 1;
        if (!c1((d)fVar)) {
            fVar.d(i2);
            obj12 = new Object[i4];
            obj12[i2] = Integer.valueOf(i);
            obj12[i5] = Boolean.valueOf(fVar.a());
            this.a.e("No subItems to Expand on position %s expanded %s", obj12);
            return i2;
        }
        int i3 = 3;
        if (z3 == null && z2 == null) {
            if (z2 == null) {
                arr = new Object[i3];
                arr[i2] = Integer.valueOf(i);
                arr[i5] = Boolean.valueOf(fVar.a());
                arr[i4] = Boolean.valueOf(this.j0);
                this.a.d("Request to Expand on position=%s expanded=%s anyParentSelected=%s", arr);
            }
        }
        if (z3 == null) {
            if (!fVar.a()) {
                if (this.j0) {
                    if (fVar.c() <= this.e0 && this.g0 && z2 == null && p0(this.d0) > 0) {
                        if (this.g0) {
                            if (z2 == null) {
                                if (p0(this.d0) > 0) {
                                    obj10 = M0(next);
                                }
                            }
                        }
                        next = J0(fVar, i5);
                        arr = obj10 + 1;
                        this.v.addAll(arr, next);
                        size = next.size();
                        fVar.d(i5);
                        if (z3 == null && this.f0 && z2 == null) {
                            if (this.f0) {
                                if (z2 == null) {
                                    m0(obj10, size);
                                }
                            }
                        }
                        if (z4 != 0) {
                            notifyItemChanged(obj10, d.EXPANDED);
                        }
                        notifyItemRangeInserted(arr, size);
                        if (z3 == null && this.O) {
                            if (this.O) {
                                obj11 = next.iterator();
                                obj13 = i2;
                                while (obj11.hasNext()) {
                                    obj13 += i5;
                                    if (S1(obj10 + obj13, (f)obj11.next(), i2) != null) {
                                    }
                                    obj13++;
                                }
                            }
                        }
                        if (!z0(this.M, fVar)) {
                            z0(this.N, fVar);
                        }
                        obj13 = new Object[i3];
                        obj12 = z3 != null ? "Initially expanded" : "Expanded";
                        obj13[i2] = obj12;
                        obj13[i5] = Integer.valueOf(size);
                        obj13[i4] = Integer.valueOf(obj10);
                        this.a.d("%s %s subItems on position=%s", obj13);
                        i2 = size;
                    }
                } else {
                }
            }
        } else {
        }
        return i2;
    }

    private boolean z0(List<T> list, d d2) {
        int indexOf = list.indexOf(d2);
        indexOf++;
        if (indexOf >= 0 && i < list.size()) {
            indexOf++;
            if (i < list.size()) {
                return list.addAll(i, d2.b());
            }
            return list.addAll(d2.b());
        }
        return 0;
    }

    @Override // h.a.b.a
    public final boolean A(int i) {
        return s1(O0(i));
    }

    protected boolean C0(T t, Serializable serializable2) {
        Object obj2;
        if (t instanceof e && (e)t.a(serializable2)) {
            obj2 = (e)t.a(serializable2) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public final List<T> E0(d d) {
        boolean z;
        Object obj3;
        if (d != null) {
            if (!c1(d)) {
            } else {
                ArrayList arrayList = new ArrayList(d.b());
                if (!this.H.isEmpty()) {
                    arrayList.removeAll(G0(d));
                }
            }
            return arrayList;
        }
        obj3 = new ArrayList();
        return obj3;
    }

    public final List<T> F0() {
        return Collections.unmodifiableList(this.v);
    }

    @Override // h.a.b.a
    public void F1(int i, Object object2) {
        n0(i);
        this.a.d("removeItem delegates removal to removeRange", new Object[0]);
        H1(i, 1, object2);
    }

    public final List<T> G0(d d) {
        Object next;
        f equals;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.H.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            equals = next.c;
            if (equals != null && equals.equals(d) && next.b >= 0) {
            }
            if (equals.equals(d)) {
            }
            if (next.b >= 0) {
            }
            arrayList.add(next.d);
        }
        return arrayList;
    }

    @Override // h.a.b.a
    public void G1(int i, int i2) {
        H1(i, i2, d.REM_SUB_ITEM);
    }

    public List<T> H0() {
        f fVar;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = this.H.iterator();
        for (b.v next2 : iterator) {
            arrayList.add(next2.d);
        }
        return arrayList;
    }

    @Override // h.a.b.a
    public void H1(int i, int i2, Object object3) {
        c cVar;
        int i3;
        int i5;
        int i4;
        boolean z;
        boolean iterator;
        boolean next;
        h.a.b.d uNLINK;
        h.a.b.b.u obj11;
        int obj12;
        final int itemCount = getItemCount();
        Object[] arr = new Object[2];
        int i8 = 0;
        arr[i8] = Integer.valueOf(i);
        final int i9 = 1;
        arr[i9] = Integer.valueOf(i2);
        this.a.a("removeRange positionStart=%s itemCount=%s", arr);
        if (i >= 0) {
            cVar = i + i2;
            if (cVar > itemCount) {
            } else {
                if (i2 != 0) {
                    if (itemCount == 0) {
                    } else {
                        int i7 = 0;
                        i3 = i;
                        i4 = i5;
                        while (i3 < cVar) {
                            i5 = O0(i);
                            if (i5 == 0) {
                            } else {
                            }
                            if (!this.K && i4 == 0) {
                            }
                            i5.setHidden(i9);
                            if (this.J && o1(i5)) {
                            }
                            this.v.remove(i);
                            z = this.x;
                            if (this.K && z != null) {
                            }
                            t(i3);
                            i3++;
                            z = this.x;
                            if (z != null) {
                            }
                            z.remove(i5);
                            if (o1(i5)) {
                            }
                            iterator = U0((g)i5).iterator();
                            while (iterator.hasNext()) {
                                next = iterator.next();
                                (h)next.setHeader(i7);
                                if (object3 != null) {
                                }
                                notifyItemChanged(M0(next), d.UNLINK);
                            }
                            next = iterator.next();
                            (h)next.setHeader(i7);
                            if (object3 != null) {
                            }
                            notifyItemChanged(M0(next), d.UNLINK);
                            if (i4 == 0) {
                            }
                            if (i4 == 0) {
                            } else {
                            }
                            t0(i4, i5);
                            s0(i, i5);
                            i4 = K0(i5);
                        }
                        notifyItemRangeRemoved(i, i2);
                        obj11 = M0(N0(i5));
                        if (obj11 >= 0) {
                            notifyItemChanged(obj11, object3);
                        }
                        obj12 = M0(i4);
                        if (obj12 >= 0 && obj12 != obj11) {
                            if (obj12 != obj11) {
                                notifyItemChanged(obj12, object3);
                            }
                        }
                        if (this.u0 != null && !this.I && itemCount > 0 && getItemCount() == 0) {
                            if (!this.I) {
                                if (itemCount > 0) {
                                    if (getItemCount() == 0) {
                                        this.u0.a(R0());
                                    }
                                }
                            }
                        }
                    }
                }
            }
            this.a.e("removeRange Nothing to delete!", new Object[i8]);
        }
        this.a.b("Cannot removeRange with positionStart OutOfBounds!", new Object[i8]);
    }

    @Override // h.a.b.a
    public int I0() {
        if (this.n0 > 0) {
            return (int)ceil;
        }
        return 0;
    }

    public final void I1(T t) {
        boolean remove;
        int i;
        Object[] arr;
        String str;
        String str2;
        if (this.N.remove(t)) {
            i = 1;
            arr = new Object[i];
            arr[0] = a.a(t);
            this.a.a("Remove scrollable footer %s", arr);
            B1(t, i);
        }
    }

    public final void J1(T t) {
        boolean remove;
        int i;
        Object[] arr;
        String str;
        String str2;
        if (this.M.remove(t)) {
            i = 1;
            arr = new Object[i];
            arr[0] = a.a(t);
            this.a.a("Remove scrollable header %s", arr);
            B1(t, i);
        }
    }

    public d K0(T t) {
        Object next;
        boolean iterator;
        boolean equals;
        boolean hidden;
        Iterator iterator2 = this.v.iterator();
        while (iterator2.hasNext()) {
            next = iterator2.next();
            if (j1((f)next)) {
            } else {
            }
            if ((d)next.a()) {
            } else {
            }
            if (c1(next)) {
            } else {
            }
            iterator = next.b().iterator();
            for (f equals : iterator) {
            }
            equals = iterator.next();
        }
        return null;
    }

    public <F extends Serializable> F L0(Class<F> class) {
        return (Serializable)class.cast(this.W);
    }

    @Override // h.a.b.a
    public final int M0(f f) {
        List list;
        int obj2;
        if (f != null) {
            obj2 = this.v.indexOf(f);
        } else {
            obj2 = -1;
        }
        return obj2;
    }

    public h.a.b.b<T> M1(boolean z) {
        int obj2;
        if (!this.O && z != 0) {
            if (z != 0) {
                Q1(true);
            }
        }
        return this;
    }

    public g N0(T t) {
        boolean z;
        if (t != null && t instanceof h) {
            if (t instanceof h) {
                return (h)t.getHeader();
            }
        }
        return null;
    }

    public h.a.b.b<T> N1(boolean z) {
        O1(z, this.S);
        return this;
    }

    public T O0(int i) {
        int itemCount;
        if (i >= 0 && i >= getItemCount()) {
            if (i >= getItemCount()) {
            }
            return (f)this.v.get(i);
        }
        return 0;
    }

    public h.a.b.b<T> O1(boolean z, ViewGroup viewGroup2) {
        String str;
        Object[] arr = new Object[2];
        str = viewGroup2 != null ? " with user defined Sticky Container" : "";
        this.a.c("Set stickyHeaders=%s (in Post!)%s", Boolean.valueOf(z), str);
        this.S = viewGroup2;
        b.d dVar = new b.d(this, z);
        this.G.post(dVar);
        return this;
    }

    @Override // h.a.b.a
    public final l P0() {
        h1();
        return this.l0;
    }

    public final h.a.b.b<T> P1(boolean z) {
        Object[] arr = new Object[1];
        this.a.c("Set swipeEnabled=%s", Boolean.valueOf(z));
        h1();
        this.k0.F(z);
        return this;
    }

    @Override // h.a.b.a
    public final a Q0() {
        h1();
        return this.k0;
    }

    @Override // h.a.b.a
    public final int R0() {
        int itemCount;
        int size;
        if (Y0()) {
            itemCount = getItemCount();
        } else {
            i -= size;
        }
        return itemCount;
    }

    @Override // h.a.b.a
    public g T0(int i) {
        boolean z2;
        boolean z;
        int obj4;
        final int i2 = 0;
        if (!this.O) {
            return i2;
        }
        while (obj4 >= 0) {
            z2 = O0(obj4);
            obj4--;
        }
        return i2;
    }

    public List<h> U0(g g) {
        int i;
        f fVar;
        boolean z;
        ArrayList arrayList = new ArrayList();
        fVar = O0(i2++);
        while (b1(fVar, g)) {
            arrayList.add((h)fVar);
            fVar = O0(i++);
        }
        return arrayList;
    }

    @Override // h.a.b.a
    public int V0() {
        return this.Q;
    }

    @Override // h.a.b.a
    public void V1(int i) {
        h.a.b.b.a aVar;
        int i2;
        final RecyclerView view = this.f;
        if (view != null) {
            aVar = new b.a(this, i);
            view.postDelayed(aVar, 150);
        }
    }

    @Override // h.a.b.a
    public final int W0() {
        int i;
        if (l0()) {
            i = this.R.p();
        } else {
            i = -1;
        }
        return i;
    }

    public void W1(List<T> list, int i2, int i3) {
        int itemCount;
        c cVar;
        int i4;
        int lINK;
        String str;
        int i;
        int i5;
        int i7;
        Boolean valueOf2;
        int i6;
        Integer valueOf;
        List obj10;
        int obj11;
        int obj12;
        if (i2 >= 0 && i2 < getItemCount() && i3 >= 0) {
            if (i2 < getItemCount()) {
                if (i3 >= 0) {
                    if (i3 >= getItemCount()) {
                    } else {
                        Object[] arr = new Object[4];
                        i = 0;
                        arr[i] = Integer.valueOf(i2);
                        i5 = 1;
                        arr[i5] = Boolean.valueOf(r(i2));
                        i7 = 2;
                        arr[i7] = Integer.valueOf(i3);
                        arr[3] = Boolean.valueOf(r(i3));
                        this.a.d("swapItems from=%s [selected? %s] to=%s [selected? %s]", arr);
                        if (i2 < i3 && j1(O0(i2)) && k1(i3)) {
                            if (j1(O0(i2))) {
                                if (k1(i3)) {
                                    n0(i3);
                                }
                            }
                        }
                        itemCount = "swapItems from=%s to=%s";
                        if (i2 < i3) {
                            lINK = i2;
                            while (lINK < i3) {
                                valueOf2 = new Object[i7];
                                valueOf2[i] = Integer.valueOf(lINK);
                                i6 = lINK + 1;
                                valueOf2[i5] = Integer.valueOf(i6);
                                this.a.d(itemCount, valueOf2);
                                Collections.swap(list, lINK, i6);
                                u(lINK, i6);
                                lINK = i6;
                            }
                        } else {
                            lINK = i2;
                            while (lINK > i3) {
                                valueOf2 = new Object[i7];
                                valueOf2[i] = Integer.valueOf(lINK);
                                i6 = lINK + -1;
                                valueOf2[i5] = Integer.valueOf(i6);
                                this.a.d(itemCount, valueOf2);
                                Collections.swap(list, lINK, i6);
                                u(lINK, i6);
                                lINK--;
                            }
                        }
                        notifyItemMoved(i2, i3);
                        if (this.O) {
                            obj10 = O0(i3);
                            itemCount = O0(i2);
                            lINK = itemCount instanceof g;
                            if (lINK && obj10 instanceof g) {
                                if (obj10 instanceof g) {
                                    if (i2 < i3) {
                                        obj11 = U0((g)obj10).iterator();
                                        for (h obj12 : obj11) {
                                            t1(obj12, obj10, d.LINK);
                                        }
                                    } else {
                                        obj10 = U0((g)itemCount).iterator();
                                        for (h obj11 : obj10) {
                                            t1(obj11, itemCount, d.LINK);
                                        }
                                    }
                                } else {
                                    if (lINK) {
                                        obj10 = i2 < i3 ? i3 + 1 : i3;
                                        if (i2 < i3) {
                                        } else {
                                            obj12 = i2 + 1;
                                        }
                                        lINK = d.LINK;
                                        t1(O0(obj10), T0(obj10), lINK);
                                        t1(O0(obj12), (g)itemCount, lINK);
                                    } else {
                                        if (obj10 instanceof g) {
                                            i4 = i2 < i3 ? i2 : i2 + 1;
                                            if (i2 < i3) {
                                                obj11 = i3 + 1;
                                            }
                                            lINK = d.LINK;
                                            t1(O0(i4), T0(i4), lINK);
                                            t1(O0(obj11), (g)obj10, lINK);
                                        } else {
                                            obj10 = i2 < i3 ? i3 : i2;
                                            if (i2 < i3) {
                                            } else {
                                                obj11 = i3;
                                            }
                                            obj12 = O0(obj10);
                                            itemCount = N0(obj12);
                                            obj10 = T0(obj10);
                                            if (itemCount != null && obj10 != null && !obj10.equals(itemCount)) {
                                                obj10 = T0(obj10);
                                                if (obj10 != null) {
                                                    if (!obj10.equals(itemCount)) {
                                                        t1(obj12, obj10, d.LINK);
                                                    }
                                                }
                                                t1(O0(obj11), itemCount, d.LINK);
                                            }
                                        }
                                    }
                                }
                            } else {
                            }
                        }
                    }
                }
            }
        }
    }

    public boolean X(int i, T t2) {
        int i2 = 0;
        if (t2 == null) {
            this.a.b("addItem No item to add!", new Object[i2]);
            return i2;
        }
        this.a.d("addItem delegates addition to addItems!", new Object[i2]);
        return Z(i, Collections.singletonList(t2));
    }

    public boolean Y(T t) {
        return X(getItemCount(), t);
    }

    @Override // h.a.b.a
    public boolean Y0() {
        int i;
        Serializable serializable = this.W;
        if (serializable instanceof String != null) {
            return empty ^= i;
        }
        if (serializable != null) {
        } else {
            i = 0;
        }
        return i;
    }

    public void Y1(List<T> list) {
        Z1(list, false);
    }

    public boolean Z(int i, List<T> list2) {
        int arr;
        boolean empty;
        String str;
        int obj4;
        List obj5;
        arr = 0;
        if (list2 != null) {
            if (list2.isEmpty()) {
            } else {
                int i3 = R0();
                if (i < 0) {
                    this.a.e("addItems Position is negative! adding items to the end", new Object[arr]);
                    obj4 += i3;
                }
                int i2 = 1;
                A1(obj4, list2, i2);
                T1(list2);
                if (!this.P && this.u0 != null && !this.I && i3 == 0 && getItemCount() > 0) {
                    if (this.u0 != null) {
                        if (!this.I) {
                            if (i3 == 0) {
                                if (getItemCount() > 0) {
                                    this.u0.a(R0());
                                }
                            }
                        }
                    }
                }
            }
            return i2;
        }
        this.a.b("addItems No items to add!", new Object[arr]);
        return arr;
    }

    public boolean Z0(T t) {
        int obj1;
        obj1 = N0(t) != null ? 1 : 0;
        return obj1;
    }

    public void Z1(List<T> list, boolean z2) {
        int str;
        ArrayList obj2;
        Handler obj3;
        this.x = 0;
        if (list == null) {
            obj2 = new ArrayList();
        }
        if (z2) {
            str = 1;
            this.G.removeMessages(str);
            obj3 = this.G;
            obj3.sendMessage(Message.obtain(obj3, str, obj2));
        } else {
            obj3 = new ArrayList(obj2);
            D1(obj3);
            this.v = obj3;
            this.a.e("updateDataSet with notifyDataSetChanged!", new Object[0]);
            notifyDataSetChanged();
            z1();
        }
    }

    public h.a.b.b<T> a0(Object object) {
        int arr;
        boolean iterator;
        boolean iterator2;
        boolean obj3;
        boolean z3;
        boolean obj;
        boolean obj2;
        boolean z2;
        boolean z;
        Object[] next2;
        Object[] next;
        Object[] next3;
        String contentView;
        arr = 0;
        if (object == null) {
            this.a.b("Invalid listener class: null", new Object[arr]);
            return this;
        }
        next = new Object[1];
        next[arr] = a.a(object);
        this.a.c("Adding listener class %s as:", next);
        if (object instanceof b.p) {
            this.a.c("- OnItemClickListener", new Object[arr]);
            this.s0 = (b.p)object;
            iterator = j().iterator();
            for (b next2 : iterator) {
                next2.getContentView().setOnClickListener(next2);
            }
        }
        if (object instanceof b.q) {
            this.a.c("- OnItemLongClickListener", new Object[arr]);
            this.t0 = (b.q)object;
            iterator2 = j().iterator();
            for (b next3 : iterator2) {
                next3.getContentView().setOnLongClickListener(next3);
            }
        }
        if (object instanceof b.r) {
            this.a.c("- OnItemMoveListener", new Object[arr]);
            this.w0 = (b.r)object;
        }
        if (object instanceof b.s) {
            this.a.c("- OnItemSwipeListener", new Object[arr]);
            this.x0 = (b.s)object;
        }
        if (object instanceof b.n) {
            this.a.c("- OnDeleteCompleteListener", new Object[arr]);
            this.z0 = (b.n)object;
        }
        if (object instanceof b.t) {
            this.a.c("- OnStickyHeaderChangeListener", new Object[arr]);
            this.A0 = (b.t)object;
        }
        if (object instanceof b.u) {
            this.a.c("- OnUpdateListener", new Object[arr]);
            z2 = object;
            this.u0 = (b.u)z2;
            z2.a(R0());
        }
        if (object instanceof b.o) {
            this.a.c("- OnFilterListener", new Object[arr]);
            this.v0 = (b.o)object;
        }
        return this;
    }

    @Override // h.a.b.a
    public boolean a1(Serializable serializable) {
        boolean z;
        int i;
        boolean z2;
        Object obj4;
        z = this.X;
        if (serializable instanceof String != null && z instanceof String != null) {
            z = this.X;
            if (z instanceof String != null) {
                return obj4 ^= i;
            }
        }
        Serializable serializable2 = this.X;
        if (serializable2 != null) {
            if (!serializable2.equals(serializable)) {
            } else {
                i = 0;
            }
        }
        return i;
    }

    public void a2(int i, T t2, Object object3) {
        int i2 = 0;
        if (t2 == null) {
            this.a.b("updateItem No Item to update!", new Object[i2]);
        }
        if (i >= 0 && i >= getItemCount()) {
            if (i >= getItemCount()) {
            }
            this.v.set(i, t2);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("updateItem notifyItemChanged on position ");
            stringBuilder.append(i);
            this.a.a(stringBuilder.toString(), new Object[i2]);
            notifyItemChanged(i, object3);
        }
        this.a.b("Cannot updateItem on position out of OutOfBounds!", new Object[i2]);
    }

    public final boolean b0(T t) {
        int size2;
        List i;
        Object[] size;
        int i2 = 1;
        i = 0;
        if (!this.N.contains(t)) {
            size = new Object[i2];
            size[i] = a.a(t);
            this.a.a("Add scrollable footer %s", size);
            t.setSelectable(i);
            t.setDraggable(i);
            if (t == this.r0) {
                size2 = this.N.size();
            } else {
                size2 = i;
            }
            if (size2 > 0 && this.N.size() > 0) {
                if (this.N.size() > 0) {
                    this.N.add(i, t);
                } else {
                    this.N.add(t);
                }
            } else {
            }
            A1(itemCount -= size2, Collections.singletonList(t), i2);
            return i2;
        }
        Object[] arr = new Object[i2];
        arr[i] = a.a(t);
        this.a.e("Scrollable footer %s already added", arr);
        return i;
    }

    public boolean b1(T t, g g2) {
        int obj1;
        obj1 = N0(t);
        if (obj1 != null && g2 != null && obj1.equals(g2)) {
            if (g2 != null) {
                obj1 = obj1.equals(g2) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj1;
    }

    public void b2(T t) {
        c2(t, 0);
    }

    @Override // h.a.b.a
    public void c(int i, int i2) {
        final h.a.b.b.s sVar = this.x0;
        if (sVar != null) {
            sVar.n0(i, i2);
        }
    }

    public final boolean c0(T t) {
        int size;
        int i = 1;
        Object[] arr2 = new Object[i];
        final int i2 = 0;
        arr2[i2] = a.a(t);
        this.a.a("Add scrollable header %s", arr2);
        if (!this.M.contains(t)) {
            t.setSelectable(i2);
            t.setDraggable(i2);
            if (t == this.r0) {
                size = this.M.size();
            } else {
                size = i2;
            }
            this.M.add(t);
            B(i);
            A1(size, Collections.singletonList(t), i);
            B(i2);
            return i;
        }
        Object[] arr = new Object[i];
        arr[i2] = a.a(t);
        this.a.e("Scrollable header %s already added", arr);
        return i2;
    }

    @Override // h.a.b.a
    public boolean c1(d d) {
        List list;
        int obj2;
        if (d != 0 && d.b() != null && d.b().size() > 0) {
            if (d.b() != null) {
                obj2 = d.b().size() > 0 ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    public void c2(T t, Object object2) {
        a2(M0(t), t, object2);
    }

    @Override // h.a.b.a
    public boolean d(int i, int i2) {
        f contains2;
        boolean contains;
        int obj3;
        contains2 = O0(i2);
        if (!this.M.contains(contains2) && !this.N.contains(contains2)) {
            if (!this.N.contains(contains2)) {
                contains2 = this.w0;
                if (contains2 != null) {
                    obj3 = contains2.v1(i, i2) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // h.a.b.a
    public void e(RecyclerView.e0 recyclerView$e0, int i2) {
        Object rVar;
        rVar = this.w0;
        if (rVar != null) {
            rVar.e(e0, i2);
        } else {
            rVar = this.x0;
            if (rVar != null) {
                rVar.e(e0, i2);
            }
        }
    }

    @Override // h.a.b.a
    public int getItemCount() {
        return this.v.size();
    }

    @Override // h.a.b.a
    public long getItemId(int i) {
        long l;
        int obj3;
        obj3 = O0(i);
        if (obj3 != null) {
            l = (long)obj3;
        } else {
            l = -1;
        }
        return l;
    }

    @Override // h.a.b.a
    public int getItemViewType(int i) {
        f fVar = O0(i);
        final int i2 = 1;
        if (fVar == null) {
            Object[] arr = new Object[2];
            final int i4 = 0;
            arr[i4] = Integer.valueOf(i);
            arr[i2] = Integer.valueOf(getItemCount());
            this.a.b("Item for ViewType not found! position=%s, items=%s", arr);
            return i4;
        }
        u1(fVar);
        this.V = i2;
        return fVar.getItemViewType();
    }

    @Override // h.a.b.a
    public void h() {
        final int i = 0;
        this.i0 = i;
        this.j0 = i;
        super.h();
    }

    @Override // h.a.b.a
    public boolean i1() {
        return this.p0;
    }

    public boolean j1(T t) {
        return t instanceof d;
    }

    @Override // h.a.b.a
    public boolean k(int i, int i2) {
        W1(this.v, i, i2);
        h.a.b.b.r rVar = this.w0;
        if (rVar != null) {
            rVar.k(i, i2);
        }
        return 1;
    }

    @Override // h.a.b.a
    public boolean k0() {
        return this.O;
    }

    @Override // h.a.b.a
    public boolean k1(int i) {
        return l1(O0(i));
    }

    @Override // h.a.b.a
    public boolean l0() {
        int i;
        i = this.R != null ? 1 : 0;
        return i;
    }

    public boolean l1(T t) {
        f obj2;
        if (j1(t) && (d)t.a()) {
            obj2 = (d)t.a() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // h.a.b.a
    public boolean m1() {
        return this.a0;
    }

    @Override // h.a.b.a
    public int n0(int i) {
        return o0(i, false);
    }

    @Override // h.a.b.a
    public final boolean n1() {
        a aVar;
        int i;
        aVar = this.k0;
        if (aVar != null && aVar.D()) {
            i = aVar.D() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // h.a.b.a
    public int o0(int i, boolean z2) {
        f next;
        Object valueOf;
        boolean z3;
        int size;
        boolean z;
        int obj11;
        Object obj12;
        next = O0(i);
        final int i2 = 0;
        if (!j1(next)) {
            return i2;
        }
        valueOf = next;
        final int i3 = 1;
        final List list = J0((d)valueOf, i3);
        Object[] arr = new Object[3];
        arr[i2] = Integer.valueOf(i);
        arr[i3] = Boolean.valueOf(valueOf.a());
        final int i5 = 2;
        arr[i5] = Boolean.valueOf(d1(i, list));
        this.a.d("Request to Collapse on position=%s expanded=%s hasSubItemsSelected=%s", arr);
        if (valueOf.a() && list.size() > 0) {
            if (list.size() > 0) {
                if (d1(i, list)) {
                    if (S0(next) != null && this.h0) {
                        if (this.h0) {
                            E1(i + 1, list, valueOf.c());
                        }
                        this.v.removeAll(list);
                        size = list.size();
                        valueOf.d(i2);
                        if (z2 != null) {
                            notifyItemChanged(i, d.COLLAPSED);
                        }
                        notifyItemRangeRemoved(i + 1, size);
                        if (this.O && !o1(next)) {
                            if (!o1(next)) {
                                obj12 = list.iterator();
                                for (f next : obj12) {
                                    f1(next);
                                }
                            }
                        }
                        if (!q0(this.M, valueOf)) {
                            q0(this.N, valueOf);
                        }
                        next = new Object[i5];
                        next[i2] = Integer.valueOf(size);
                        next[i3] = Integer.valueOf(i);
                        this.a.d("Collapsed %s subItems on position %s", next);
                    }
                } else {
                }
            }
        }
        return size;
    }

    public boolean o1(T t) {
        Object obj1;
        if (t != null && t instanceof g) {
            obj1 = t instanceof g ? 1 : 0;
        } else {
        }
        return obj1;
    }

    @Override // h.a.b.a
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Object[] arr;
        boolean obj3;
        super.onAttachedToRecyclerView(recyclerView);
        this.a.d("Attached Adapter to RecyclerView", new Object[0]);
        if (this.O && l0()) {
            if (l0()) {
                this.R.g(this.f);
            }
        }
    }

    @Override // h.a.b.a
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        ArrayList arrayList = new ArrayList();
        onBindViewHolder(e0, i2, Collections.unmodifiableList(arrayList));
    }

    @Override // h.a.b.a
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2, List list3) {
        f fVar;
        boolean z;
        boolean enabled;
        List obj6;
        if (!this.V) {
        } else {
            super.onBindViewHolder(e0, i2, list3);
            fVar = O0(i2);
            e0.itemView.setEnabled(fVar.isEnabled());
            fVar.bindViewHolder(this, e0, i2, list3);
            if (fVar != null && l0() && o1(fVar) && !this.h && this.R.p() >= 0 && list3.isEmpty() && obj6-- == i2) {
                e0.itemView.setEnabled(fVar.isEnabled());
                fVar.bindViewHolder(this, e0, i2, list3);
                if (l0()) {
                    if (o1(fVar)) {
                        if (!this.h) {
                            if (this.R.p() >= 0) {
                                if (list3.isEmpty()) {
                                    if (obj6-- == i2) {
                                        e0.itemView.setVisibility(4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            x1(i2);
            x(e0, i2);
        }
        IllegalStateException obj4 = new IllegalStateException("AutoMap is not active, this method cannot be called. You should implement the AutoMap properly.");
        throw obj4;
    }

    @Override // h.a.b.a
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        boolean z;
        LayoutInflater obj5;
        f fVar = X0(i2);
        final int i3 = 0;
        if (fVar == null) {
        } else {
            if (!this.V) {
            } else {
                if (this.T == null) {
                    this.T = LayoutInflater.from(viewGroup.getContext());
                }
                return fVar.createViewHolder(this.T.inflate(fVar.getLayoutRes(), viewGroup, i3), this);
            }
        }
        Object[] arr = new Object[1];
        arr[i3] = Integer.valueOf(i2);
        IllegalStateException obj4 = new IllegalStateException(String.format("ViewType instance not found for viewType %s. You should implement the AutoMap properly.", arr));
        throw obj4;
    }

    @Override // h.a.b.a
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        boolean z;
        if (l0()) {
            this.R.l();
            this.R = 0;
        }
        super.onDetachedFromRecyclerView(recyclerView);
        this.a.d("Detached Adapter from RecyclerView", new Object[0]);
    }

    @Override // h.a.b.a
    public void onViewAttachedToWindow(RecyclerView.e0 recyclerView$e0) {
        final int adapterPosition = e0.getAdapterPosition();
        final f fVar = O0(adapterPosition);
        if (fVar != null) {
            fVar.onViewAttached(this, e0, adapterPosition);
        }
    }

    @Override // h.a.b.a
    public void onViewDetachedFromWindow(RecyclerView.e0 recyclerView$e0) {
        final int adapterPosition = e0.getAdapterPosition();
        final f fVar = O0(adapterPosition);
        if (fVar != null) {
            fVar.onViewDetached(this, e0, adapterPosition);
        }
    }

    @Override // h.a.b.a
    public void onViewRecycled(RecyclerView.e0 recyclerView$e0) {
        boolean itemView;
        int i;
        super.onViewRecycled(e0);
        if (l0()) {
            e0.itemView.setVisibility(0);
        }
        int adapterPosition = e0.getAdapterPosition();
        f fVar = O0(adapterPosition);
        if (fVar != null) {
            fVar.unbindViewHolder(this, e0, adapterPosition);
        }
    }

    @Override // h.a.b.a
    public int p0(int i) {
        return E1(0, this.v, i);
    }

    @Override // h.a.b.a
    public boolean p1(int i) {
        f obj1;
        obj1 = O0(i);
        if (obj1 != null && obj1.isEnabled()) {
            obj1 = obj1.isEnabled() ? 1 : 0;
        } else {
        }
        return obj1;
    }

    @Override // h.a.b.a
    public boolean q(int i) {
        f obj1;
        obj1 = O0(i);
        if (obj1 != null && obj1.isSelectable()) {
            obj1 = obj1.isSelectable() ? 1 : 0;
        } else {
        }
        return obj1;
    }

    @Override // h.a.b.a
    public final boolean q1() {
        a aVar;
        int i;
        aVar = this.k0;
        if (aVar != null && aVar.s()) {
            i = aVar.s() ? 1 : 0;
        } else {
        }
        return i;
    }

    public boolean r0(T t) {
        List list;
        Object obj2;
        if (t != null && this.v.contains(t)) {
            obj2 = this.v.contains(t) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // h.a.b.a
    public final boolean r1() {
        List empty;
        int i;
        empty = this.H;
        synchronized (this) {
            try {
                if (!empty.isEmpty()) {
                } else {
                }
                i = 1;
                i = 0;
                return i;
                throw th;
            }
        }
    }

    @Override // h.a.b.a
    public void removeItem(int i) {
        F1(i, d.CHANGE);
    }

    public final boolean s1(T t) {
        boolean contains;
        Object obj2;
        if (t != null) {
            if (!this.M.contains(t)) {
                obj2 = this.N.contains(t) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj2;
    }

    @Override // h.a.b.a
    public final void u0() {
        boolean z;
        if (l0()) {
            this.R.m();
        }
    }

    @Override // h.a.b.a
    public void v(int i) {
        boolean fVar;
        boolean selectable;
        int i2;
        int i3;
        fVar = O0(i);
        final int i6 = 0;
        final int i7 = -1;
        if (fVar != null && fVar.isSelectable()) {
            if (fVar.isSelectable()) {
                selectable = K0(fVar);
                i2 = 1;
                i3 = selectable != null ? i2 : i6;
                if (!j1(fVar)) {
                    if (i3 == 0 && !this.i0) {
                        if (!this.i0) {
                            this.j0 = i2;
                            if (i3 != 0) {
                                this.e0 = selectable.c();
                            }
                            super.v(i);
                        } else {
                            if (i3 != 0) {
                                if (this.e0 != i7) {
                                    if (!this.j0 && i5 += i2 == this.e0) {
                                        if (i5 += i2 == this.e0) {
                                            this.i0 = i2;
                                            this.e0 = i4 += i2;
                                            super.v(i);
                                        }
                                    }
                                } else {
                                }
                            }
                        }
                    } else {
                    }
                } else {
                }
            }
        }
        if (super.o() == 0) {
            this.e0 = i7;
            this.i0 = i6;
            this.j0 = i6;
        }
    }

    @Override // h.a.b.a
    public void v1(int i, int i2) {
        w1(i, i2, d.MOVE);
    }

    @Override // h.a.b.a
    public int w0(int i) {
        return x0(i, false);
    }

    @Override // h.a.b.a
    public void w1(int i, int i2, Object object3) {
        Object[] arr = new Object[2];
        final int i4 = 0;
        arr[i4] = Integer.valueOf(i);
        arr[1] = Integer.valueOf(i2);
        this.a.d("moveItem fromPosition=%s toPosition=%s", arr);
        if (r(i)) {
            t(i);
            g(i2);
        }
        f fVar = O0(i);
        boolean z2 = l1(fVar);
        if (z2) {
            n0(i2);
        }
        this.v.remove(i);
        A1(i2, Collections.singletonList(fVar), i4);
        notifyItemMoved(i, i2);
        if (object3 != null) {
            notifyItemChanged(i2, object3);
        }
        if (this.O) {
            S1(i2, fVar, i4);
        }
        if (z2) {
            w0(i2);
        }
    }

    @Override // h.a.b.a
    public int x0(int i, boolean z2) {
        final int i2 = 0;
        return y0(i, i2, i2, z2);
    }

    @Override // h.a.b.a
    protected void x1(int i) {
        int i3;
        boolean fVar;
        Object valueOf;
        int size;
        boolean z2;
        boolean z;
        int i2;
        c cVar;
        Object[] arr;
        int obj6;
        if (i1() && !this.o0) {
            if (!this.o0) {
                if (O0(i) == this.r0) {
                } else {
                    int i5 = 0;
                    if (this.q0) {
                        i3 = this.m0;
                        if (Y0()) {
                            size = i5;
                        } else {
                            size = this.M.size();
                        }
                    } else {
                        itemCount -= i8;
                        if (Y0()) {
                        } else {
                            size = this.N.size();
                        }
                    }
                    i3 -= size;
                    if (!this.q0) {
                        z2 = this.q0;
                        if (i != M0(this.r0) && i >= i4 && z2 && i > 0 && i > i4) {
                            if (i >= i4) {
                                z2 = this.q0;
                                if (z2) {
                                    if (i > 0) {
                                        if (i > i4) {
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                    }
                    arr = new Object[6];
                    arr[i5] = Boolean.valueOf(z2);
                    i2 = 1;
                    arr[i2] = Boolean.valueOf(this.o0);
                    arr[2] = Integer.valueOf(i);
                    arr[3] = Integer.valueOf(getItemCount());
                    arr[4] = Integer.valueOf(this.m0);
                    arr[5] = Integer.valueOf(i4);
                    this.a.d("onLoadMore     topEndless=%s, loading=%s, position=%s, itemCount=%s threshold=%s, currentThreshold=%s", arr);
                    this.o0 = i2;
                    fVar = new b.f(this);
                    this.G.post(fVar);
                }
            }
        }
    }

    @Override // h.a.b.a
    protected void y1() {
        int i;
        final h.a.b.b.o oVar = this.v0;
        if (oVar != null) {
            oVar.a(R0());
        }
    }

    @Override // h.a.b.a
    protected void z1() {
        int i;
        final h.a.b.b.u uVar = this.u0;
        if (uVar != null) {
            uVar.a(R0());
        }
    }
}
