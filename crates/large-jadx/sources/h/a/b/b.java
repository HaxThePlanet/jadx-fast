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
import androidx.recyclerview.widget.h.b;
import androidx.recyclerview.widget.h.e;
import androidx.recyclerview.widget.l;
import h.a.b.g.a.a;
import h.a.b.h.d;
import h.a.b.h.e;
import h.a.b.h.f;
import h.a.b.h.g;
import h.a.b.i.c;
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

/* compiled from: FlexibleAdapter.java */
/* loaded from: classes2.dex */
public class b<T extends f> extends a implements a.a {

    private static int B0;
    private b.j<T> A;
    protected b.t A0;
    private long B;
    private long C;
    private boolean D;
    private h.e E;
    private b.h F;
    protected Handler G;
    private List<b.v<T>> H;
    private boolean I;
    private boolean J;
    private boolean K;
    private boolean L;
    private List<T> M;
    private List<T> N;
    private boolean O;
    private boolean P;
    private int Q;
    private h.a.b.g.b R;
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
    private h.a.b.g.a k0;
    private l l0;
    private int m0;
    private int n0;
    private boolean o0;
    private boolean p0;
    private boolean q0;
    private T r0;
    public b.p s0;
    public b.q t0;
    protected b.u u0;
    private List<T> v;
    protected b.o v0;
    private List<T> w;
    protected b.r w0;
    private List<T> x;
    protected b.s x0;
    private Set<T> y;
    protected b.i y0;
    private List<b.l> z;
    protected b.n z0;

    class a implements Runnable {

        final /* synthetic */ int a;
        final /* synthetic */ b b;
        a(int i) {
            this.b = bVar;
            this.a = i;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.C1(this.a);
        }
    }

    class b implements Handler.Callback {

        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ b c;
        b(int i, int i2) {
            this.c = bVar;
            this.a = i;
            this.b = i2;
            super();
        }

        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message message) {
            int min;
            int i = 0;
            if (bVar6.f == null) {
                return false;
            }
            int i4 = this.c.l().a();
            int i5 = this.c.l().f();
            i3 = (i2 + i8) - i5;
            final int i10 = 1;
            if (i2 + i8 - i5 > 0) {
                i3 = i2 - i4;
                i2 = (i2 + i8) - i5;
                i = this.c.l().e();
                if (i > i10) {
                    min = (Math.min(i3, Math.max(i, i2))) % i + i;
                }
                i4 = i4 + min;
                this.c.C1(i4);
            } else {
                if (this.a < i4) {
                    this.c.C1(this.a);
                }
            }
            return true;
        }
    }

    class c implements Comparator<Integer> {
        c() {
            super();
        }

        public int a(Integer integer, Integer integer2) {
            return integer2.intValue() - integer.intValue();
        }
    }

    class d implements Runnable {

        final /* synthetic */ boolean a;
        final /* synthetic */ b b;
        d(boolean z) {
            this.b = bVar;
            this.a = z;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i = 0;
            if (this.a) {
                if (this.b.R == null) {
                    this.b.R = new b(bVar8, bVar8.A0, this.b.S);
                    this.b.R.g(this.b.f);
                    str = "Sticky headers enabled";
                    this.b.a.c(str, new Object[i]);
                }
            } else {
                if (this.b.l0()) {
                    this.b.R.l();
                    this.b.R = 0;
                    str = "Sticky headers disabled";
                    this.b.a.c(str, new Object[i]);
                }
            }
        }
    }

    class e implements Runnable {

        final /* synthetic */ b a;
        e() {
            this.a = bVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = 0;
            if (this.a.O) {
                this.a.a.e("Double call detected! Headers already shown OR the method showAllHeaders() was already called!", new Object[i2]);
                return;
            }
            this.a.R1(i2);
            if (bVar.f != null) {
                if (this.a.l().a() == 0) {
                    if (this.a.o1(this.a.O0(i2))) {
                        if (!this.a.o1(this.a.O0(1))) {
                            this.a.f.q1(i2);
                        }
                    }
                }
            }
        }
    }

    class f implements Runnable {

        final /* synthetic */ b a;
        f() {
            this.a = bVar;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.U1();
            if (bVar.y0 != null) {
                bVar.a.a("onLoadMore     invoked!", new Object[0]);
                bVar3.y0.a(this.a.R0(), this.a.I0());
            }
        }
    }

    public interface i {
        void a(int i, int i2);
    }

    private class j extends AsyncTask<Void, Void, Void> {

        private final List<T> a = new ArrayList<>();
        private final int b;
        final /* synthetic */ b c;
        j(int i, List list) {
            this.c = bVar;
            super();
            this.b = i;
            if (list == null) {
                ArrayList arrayList = new ArrayList();
            }
            super(list);
        }

        @Override // android.os.AsyncTask
        protected Void a(Void... voidArr) {
            this.c.B = System.currentTimeMillis();
            int i3 = 0;
            if (this.b == 1) {
                this.c.a.a("doInBackground - started UPDATE", new Object[i3]);
                this.c.D1(this.a);
                this.c.e0(this.a, d.CHANGE);
                str = "doInBackground - ended UPDATE";
                this.c.a.a(str, new Object[i3]);
            } else {
                if (this.b == 2) {
                    str2 = "doInBackground - started FILTER";
                    this.c.a.a(str2, new Object[i3]);
                    this.c.B0(this.a);
                    str = "doInBackground - ended FILTER";
                    this.c.a.a(str, new Object[i3]);
                }
            }
            return null;
        }

        @Override // android.os.AsyncTask
        protected void b(Void void) {
            if (this.c.E == null) {
                if (this.c.z != null) {
                    if (this.b == 1) {
                        this.c.v0(d.CHANGE);
                        this.c.z1();
                    } else {
                        if (this.b == 2) {
                            this.c.v0(d.FILTER);
                            this.c.y1();
                        }
                    }
                }
            }
            this.c.A = 0;
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            this.c.a.c("FilterAsyncTask cancelled!", new Object[0]);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            Object[] arr;
            int i = 0;
            if (this.c.o0) {
                str = "Cannot filter while endlessLoading";
                this.c.a.e(str, new Object[i]);
                boolean z = true;
                cancel(z);
            }
            if (this.c.r1()) {
                this.c.a.a("Removing all deleted items before filtering/updating", new Object[i]);
                this.a.removeAll(this.c.H0());
                if (this.c.z0 != null) {
                    i = 3;
                    this.c.z0.a(i);
                }
            }
        }
    }

    public class k implements Handler.Callback {

        final /* synthetic */ b a;
        public k() {
            this.a = bVar;
            super();
        }

        @Override // android.os.Handler$Callback
        public boolean handleMessage(Message message) {
            int i2 = 0;
            final int i3 = 1;
            if (message.what != i3 && message.what != 2) {
                if (message.what != 8) {
                    return false;
                }
                this.a.g1();
                return true;
            }
            if (this.a.A != null) {
                this.a.A.cancel(true);
            }
            this.a.A = new b.j(this.a, message.what, (List)message.obj);
            this.a.A.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[i2]);
            return true;
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

        public String toString() {
            String str;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Notification{operation=");
            stringBuilder.append(this.c);
            int i = 4;
            if (this.c == 4) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str5 = ", fromPosition=";
                str = str5 + this.a;
            } else {
                str = "";
            }
            stringBuilder.append(str);
            stringBuilder.append(", position=");
            stringBuilder.append(this.b);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }

        public l(int i, int i2, int i3) {
            this(i2, i3);
            this.a = i;
        }
    }

    public interface m {
        void e(RecyclerView.e0 e0Var, int i);
    }

    public interface n {
        void a(int i);
    }

    public interface o {
        void a(int i);
    }

    public interface p {
        boolean x(View view, int i);
    }

    public interface q {
        void a(int i);
    }

    public interface t {
        void a(int i, int i2);
    }

    public interface u {
        void a(int i);
    }

    private class v {

        int a;
        int b;
        T c;
        T d;
        public v(f fVar, f fVar2) {
            this(bVar, fVar, fVar2, -1);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "RestoreInfo[item=";
            String str3 = ", refItem=";
            String str4 = "]";
            str = str2 + this.d + str3 + this.c + str4;
            return str;
        }

        public v(f fVar, f fVar2, int i) {
            super();
            i = -1;
            this.a = i;
            this.b = i;
            fVar = null;
            this.c = fVar;
            this.d = fVar;
            this.c = fVar;
            this.d = fVar2;
            this.b = i;
        }
    }

    private class g extends RecyclerView.j {

        final /* synthetic */ b a;
        private g() {
            this.a = bVar;
            super();
        }

        private void a(int i, int i2) {
            if (this.a.L) {
                this.a.d0(i, i2);
            }
            this.a.L = 1;
        }

        private void b(int i) {
            int i2 = this.a.W0();
            if (i2 >= 0 && i2 == i) {
                Object[] arr = new Object[1];
                int i3 = 0;
                arr[i3] = Integer.valueOf(i2);
                this.a.a.a("updateStickyHeader position=%s", arr);
                long l = 100L;
                this.a.f.postDelayed(new b.g.a(this), l);
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

        /* synthetic */ g(c cVar) {
            this(bVar);
        }
    }

    public static class h<T extends f> extends h.b {

        protected List<T> a;
        protected List<T> b;
        @Override // androidx.recyclerview.widget.h$b
        public final List<T> a() {
            return this.b;
        }

        @Override // androidx.recyclerview.widget.h$b
        public boolean areContentsTheSame(int i, int i2) {
            return !(f)this.a.get(i).shouldNotifyChange((f)this.b.get(i2));
        }

        @Override // androidx.recyclerview.widget.h$b
        public boolean areItemsTheSame(int i, int i2) {
            return (f)this.a.get(i).equals((f)this.b.get(i2));
        }

        @Override // androidx.recyclerview.widget.h$b
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

    public interface r extends b.m {
        void k(int i, int i2);

        boolean v1(int i, int i2);
    }

    public interface s extends b.m {
        void n0(int i, int i2);
    }
    static {
        String simpleName = b.class.getSimpleName();
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "_parentSelected";
        r1 = simpleName + str2;
        StringBuilder stringBuilder2 = new StringBuilder();
        String str3 = "_childSelected";
        r1 = simpleName + str3;
        StringBuilder stringBuilder3 = new StringBuilder();
        String str4 = "_headersShown";
        r1 = simpleName + str4;
        StringBuilder stringBuilder4 = new StringBuilder();
        String str5 = "_stickyHeaders";
        r1 = simpleName + str5;
        StringBuilder stringBuilder5 = new StringBuilder();
        String str6 = "_selectedLevel";
        r1 = simpleName + str6;
        StringBuilder stringBuilder6 = new StringBuilder();
        String str = "_filter";
        r1 = simpleName + str;
        b.B0 = 1000;
    }

    public b(List<T> list) {
        this(list, null);
    }

    private boolean A0(T t, List<T> list) {
        boolean z3 = false;
        boolean hidden;
        int i = 1;
        int i2 = 0;
        if (j1(t)) {
            if (t.a() && this.Y == null) {
                this.Y = new HashSet();
                this.Y.add(t);
            }
            Iterator it = E0(t).iterator();
            while (it.hasNext()) {
                Object item = it.next();
                hidden = item instanceof d;
                i = 1;
                int r1 = i;
            }
            t.d(z3);
        }
        return z3;
    }

    private void A1(int i, List<T> list, boolean z) {
        int itemCount;
        itemCount = getItemCount();
        if (i < itemCount) {
            this.v.addAll(i, list);
        } else {
            this.v.addAll(list);
        }
        if (z) {
            Object[] arr = new Object[2];
            str = "addItems on position=%s itemCount=%s";
            this.a.a(str, Integer.valueOf(itemCount), Integer.valueOf(list.size()));
            notifyItemRangeInserted(itemCount, list.size());
        }
    }

    private synchronized void B0(List<T> list) {
        boolean hasNext;
        int i = 1;
        ArrayList arrayList;
        i = 1;
        final Object[] arr = new Object[i];
        final int i2 = 0;
        arr[i2] = this.W;
        this.a.a("filterItems with filterEntity=\"%s\"", arr);
        arrayList = new ArrayList();
        this.a0 = true;
        Iterator it = list.iterator();
        if (a1(this.W)) {
            K1(list);
            Set set = null;
            this.Y = set;
            if (this.x == null) {
                L1(list);
            }
            this.x = set;
        } else {
        }
        if (a1(this.W)) {
            this.X = this.W;
            e0(arrayList, d.FILTER);
        }
        this.a0 = false;
    }

    private void B1(T t, boolean z) {
        if (z) {
            z = true;
            this.K = z;
        }
        removeItem(M0(t));
        this.K = this.K;
    }

    static /* synthetic */ h.a.b.g.b C(b bVar) {
        return bVar.R;
    }

    private void C1(int i) {
        if (this.f != null) {
            i2 = getItemCount() - 1;
            this.f.y1(Math.min(Math.max(0, i), i2));
        }
    }

    static /* synthetic */ h.a.b.g.b D(b bVar, h.a.b.g.b bVar2) {
        bVar.R = bVar2;
        return bVar2;
    }

    private boolean D0(T t, List<T> list) {
        boolean z;
        boolean contains2;
        final boolean z2 = false;
        if (this.A != null && this.A.isCancelled()) {
            return false;
        }
        if (this.x != null) {
            return !s1(t) && list.contains(t) ? z2 : z2;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        if (!A0(t, arrayList)) {
            z = C0(t, L0(Serializable.class));
        }
        if (Serializable.class) {
            g gVar = N0(t);
            if (this.O && this.Z0(t) && !list.contains(gVar)) {
                gVar.setHidden(z2);
                list.add(gVar);
            }
            list.addAll(arrayList);
        }
        t.setHidden(!z);
        return z;
    }

    private void D1(List<T> list) {
        Object obj = null;
        int i;
        boolean hidden;
        int size;
        if (this.Z) {
            i();
        }
        L1(list);
        int i2 = 0;
        final boolean z4 = false;
        i = z4;
        while (i < list.size()) {
            Object item = list.get(i);
            boolean z2 = true;
            g gVar = N0(item);
            i = i + z2;
        }
    }

    static /* synthetic */ void E(b bVar, int i) {
        bVar.C1(i);
    }

    private int E1(int i, List<T> list, int i2) {
        int i4 = 0;
        Object item;
        final int i5 = 1;
        i2 = list.size() - i5;
        i4 = 0;
        while (i2 >= 0) {
            item = list.get(i2);
            i2 = i2 - 1;
        }
        return i4;
    }

    static /* synthetic */ boolean F(b bVar) {
        return bVar.L;
    }

    static /* synthetic */ boolean G(b bVar, boolean z) {
        bVar.L = z;
        return z;
    }

    static /* synthetic */ void H(b bVar, int i, int i2) {
        bVar.d0(i, i2);
    }

    static /* synthetic */ boolean I(b bVar) {
        return bVar.o0;
    }

    static /* synthetic */ long J(b bVar, long j) {
        bVar.B = j;
        return j;
    }

    private List<T> J0(d dVar, boolean z) {
        boolean hidden = true;
        final ArrayList arrayList = new ArrayList();
        if (dVar != null && this.c1(dVar)) {
            Iterator it = dVar.b().iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
        }
        return arrayList;
    }

    static /* synthetic */ void K(b bVar, List list) {
        bVar.D1(list);
    }

    private void K1(List<T> list) {
        Object obj = null;
        int i;
        Object item;
        boolean equals;
        boolean z3;
        boolean z;
        Iterator it;
        boolean hasNext;
        boolean z4;
        if (list == null) {
            return;
        }
        int i3 = 0;
        z = false;
        i = z;
        while (i < list.size()) {
            item = list.get(i);
            item.setHidden(z);
            int i2 = 1;
            i = i + i2;
        }
    }

    static /* synthetic */ ViewGroup L(b bVar) {
        return bVar.S;
    }

    private void L1(List<T> list) {
        Iterator it = this.M.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        list.addAll(this.N);
    }

    static /* synthetic */ void M(b bVar, List list, d dVar) {
        bVar.e0(list, dVar);
    }

    static /* synthetic */ void N(b bVar, List list) {
        bVar.B0(list);
    }

    static /* synthetic */ h.e O(b bVar) {
        return bVar.E;
    }

    static /* synthetic */ List P(b bVar) {
        return bVar.z;
    }

    static /* synthetic */ void Q(b bVar, d dVar) {
        bVar.v0(dVar);
    }

    private void Q1(boolean z) {
        int i = 0;
        if (z) {
            str = "showAllHeaders at startup";
            this.a.c(str, new Object[i]);
            boolean z2 = true;
            R1(z2);
        } else {
            str = "showAllHeaders with insert notification (in Post!)";
            this.a.c(str, new Object[i]);
            this.G.post(new b.e(this));
        }
    }

    static /* synthetic */ b.j R(b bVar) {
        return bVar.A;
    }

    private void R1(boolean z) {
        int i = 0;
        Object obj = null;
        boolean equals;
        i = 0;
        int i2 = 0;
        boolean z3 = true;
        while (i < getItemCount() - this.N.size()) {
            f fVar = O0(i);
            g gVar = N0(fVar);
            i = i + z3;
            z3 = true;
        }
        this.O = z3;
    }

    static /* synthetic */ b.j S(b bVar, b.j jVar) {
        bVar.A = jVar;
        return jVar;
    }

    private b.v<T> S0(T t) {
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (item.d.equals(t) && item.a < 0) {
            }
        }
        return null;
    }

    private boolean S1(int i, T t, boolean z) {
        final g gVar = N0(t);
        final int i2 = 0;
        return false;
    }

    static /* synthetic */ void T(b bVar) {
        bVar.g1();
    }

    private void T1(List<T> list) {
        HashSet hashSet2;
        g gVar;
        int i;
        if (this.O && !this.P) {
            this.P = true;
            HashSet hashSet = new HashSet();
            hashSet2 = new HashSet();
            Iterator it2 = list.iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                Object item2 = it2.next();
                gVar = N0(item2);
            }
            hashSet2.removeAll(hashSet);
            Iterator it = hashSet2.iterator();
            while (it.hasNext()) {
                notifyItemChanged(M0((g)it.next()), d.CHANGE);
            }
            this.P = z2;
        }
    }

    static /* synthetic */ boolean U(b bVar) {
        return bVar.O;
    }

    private void U1() {
        this.G.removeMessages(8);
        this.a.d("onLoadMore     show progressItem", new Object[0]);
        if (this.q0) {
            c0(this.r0);
        } else {
            b0(this.r0);
        }
    }

    static /* synthetic */ void V(b bVar, boolean z) {
        bVar.R1(z);
    }

    static /* synthetic */ void W(b bVar) {
        bVar.U1();
    }

    private T X0(int i) {
        return (f)this.U.get(Integer.valueOf(i));
    }

    private void X1(T t, Object object) {
        if (Z0(t)) {
            f t2 = t;
            g header = t2.getHeader();
            Object[] arr = new Object[2];
            str = "Unlink header %s from %s";
            this.a.d(str, header, t2);
            g gVar = null;
            t2.setHeader(gVar);
            if (object != null && !header.isHidden()) {
                notifyItemChanged(M0(header), object);
                if (!t.isHidden()) {
                    notifyItemChanged(M0(t), object);
                }
            }
        }
    }

    private void d0(int i, int i2) {
        String str;
        int i3;
        List list = p();
        if (i2 > 0) {
            Collections.sort(list, new b.c(this));
            str = "+";
        } else {
            str = "";
        }
        Iterator it = list.iterator();
        i3 = 0;
        i3 = 1;
        while (it.hasNext()) {
            Object item = it.next();
        }
        if (i3 != 0) {
            Object[] arr = new Object[2];
            StringBuilder stringBuilder = new StringBuilder();
            str3 = str + i2;
            arr[i3] = str3;
            arr[i3] = p();
            str2 = "AdjustedSelected(%s)=%s";
            this.a.d(str2, arr);
        }
    }

    private boolean d1(int i, List<T> list) {
        int i2;
        final Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            Object item = it.next();
            boolean z2 = true;
            i2 = i2 + z2;
            if (!r(i2) && this.l1(item)) {
                return true;
            }
        }
        return false;
    }

    private synchronized void e0(List<T> list, d dVar) {
        if (this.D) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Animate changes with DiffUtils! oldSize=";
            int itemCount = getItemCount();
            String str3 = " newSize=";
            int size = list.size();
            str = str2 + itemCount + str3 + size;
            this.a.d(str, new Object[0]);
            if (this.F == null) {
                this.F = new b.h();
            }
            this.F.b(this.v, list);
            this.E = h.c(this.F, this.b0);
        } else {
            f0(list, dVar);
        }
    }

    private void e1(int i, g gVar) {
        if (i >= 0) {
            Object[] arr = new Object[2];
            int i2 = 1;
            arr[i2] = gVar;
            str = "Hiding header position=%s header=$s";
            this.a.d(str, arr);
            gVar.setHidden(true);
            this.v.remove(i);
            notifyItemRemoved(i);
        }
    }

    private synchronized void f0(List<T> list, d dVar) {
        String str2;
        this.z = new ArrayList();
        int i2 = 2;
        int i3 = 1;
        int i7 = 3;
        int i8 = 0;
        if (list != null) {
            if (list.size() > this.c0) {
                str = "NotifyDataSetChanged! oldSize=%s newSize=%s limit=%s";
                Object[] arr = new Object[i7];
                if (list != null) {
                    Integer num6 = Integer.valueOf(list.size());
                } else {
                    str2 = "0";
                }
                this.a.a("NotifyDataSetChanged! oldSize=%s newSize=%s limit=%s", Integer.valueOf(getItemCount()), str2, Integer.valueOf(this.c0));
                this.w = list;
                this.z.add(new b.l(-1, i8));
            } else {
                str = "Animate changes! oldSize=%s newSize=%s limit=%s";
                arr = new Object[i7];
                this.a.a(str, Integer.valueOf(getItemCount()), Integer.valueOf(list.size()), Integer.valueOf(this.c0));
                ArrayList arrayList2 = new ArrayList(this.v);
                this.w = arrayList2;
                i0(arrayList2, list);
                g0(this.w, list);
                if (this.b0) {
                    h0(this.w, list);
                }
            }
        }
        if (this.A == null) {
            v0(dVar);
        }
    }

    private void f1(T t) {
        final g gVar = N0(t);
        if (gVar != null && !gVar.isHidden()) {
            e1(M0(gVar), gVar);
        }
    }

    private void g0(List<T> list, List<T> list2) {
        int i;
        List list3;
        Object item;
        h.a.b.b.l lVar;
        boolean contains;
        int size;
        String str;
        this.y = new HashSet(list);
        i = 0;
        int i2 = 1;
        while (i < list2.size()) {
            if (this.A != null && this.A.isCancelled()) {
            }
        }
        this.y = null;
        final Object[] arr2 = new Object[i2];
        arr2[i] = Integer.valueOf(i);
        this.a.a("calculateAdditions total new=%s", arr2);
    }

    private void g1() {
        if (M0(this.r0) >= 0) {
            str = "onLoadMore     remove progressItem";
            this.a.d(str, new Object[0]);
            if (this.q0) {
                J1(this.r0);
            } else {
                I1(this.r0);
            }
        }
    }

    private void h0(List<T> list, List<T> list2) {
        int i;
        int i2;
        List list3;
        h.a.b.b.l lVar;
        int i3;
        final int i4 = 1;
        i = list2.size() - i4;
        i2 = 0;
        while (i >= 0) {
            if (this.A != null && this.A.isCancelled()) {
            }
        }
        final Object[] arr2 = new Object[i4];
        arr2[i2] = Integer.valueOf(i2);
        this.a.a("calculateMovedItems total move=%s", arr2);
    }

    private void h1() {
        String str;
        if (this.l0 == null && this.f != null) {
            if (this.k0 == null) {
                this.k0 = new a(this);
                str = "Initialized default ItemTouchHelperCallback";
                this.a.c(str, new Object[0]);
            }
            l lVar = new l(this.k0);
            this.l0 = lVar;
            lVar.g(this.f);
        }
    }

    private void i0(List<T> list, List<T> list2) {
        int i;
        int i2;
        Object item;
        boolean z;
        int i3 = 2;
        boolean z2;
        this.y = new HashSet(list2);
        final int i4 = 1;
        i = list.size() - i4;
        i2 = 0;
        while (i >= 0) {
            if (this.A != null && this.A.isCancelled()) {
            }
        }
        this.y = null;
        Object[] arr2 = new Object[i4];
        arr2[i2] = Integer.valueOf(i2);
        this.a.a("calculateModifications total mod=%s", arr2);
        Object[] arr3 = new Object[i4];
        arr3[i2] = Integer.valueOf(i2);
        this.a.a("calculateRemovals total out=%s", arr3);
    }

    private Map<T, Integer> j0(List<T> list, List<T> list2) {
        int i = 0;
        boolean contains;
        if (this.Z) {
            this.y = new HashSet(list);
            HashMap hashMap = new HashMap();
            i = 0;
            while (this.Z < list2.size()) {
                if (this.A != null && this.A.isCancelled()) {
                    break;
                }
            }
            return hashMap;
        }
        return null;
    }

    private void m0(int i, int i2) {
        final h.a.b.b.b bVar = new b.b(this, i, i2);
        new Handler(Looper.getMainLooper(), bVar).sendMessageDelayed(Message.obtain(this.G), 150L);
    }

    private boolean q0(List<T> list, d dVar) {
        boolean z = false;
        List list2;
        if (list.contains(dVar)) {
            list = list.removeAll(dVar.b()) ? 1 : 0;
        }
        return (list.removeAll(dVar.b()) ? 1 : 0);
    }

    private void s0(int i, T t) {
        f fVar;
        if (l1(t)) {
            n0(i);
        }
        fVar = O0(i - 1);
        if (fVar != null && dVar != null) {
        }
        this.H.add(new b.v(this, fVar, t));
        Object[] arr = new Object[2];
        final int i6 = 1;
        arr[i6] = Integer.valueOf(i);
        this.a.d("Recycled Item %s on position=%s", arr);
    }

    private void t0(d dVar, T t) {
        final boolean z = false;
        this.H.add(new b.v(this, dVar, t, J0(dVar, z).indexOf(t)));
        Object[] arr = new Object[2];
        final int i3 = 1;
        arr[z] = this.H.get(this.H.size() - i3);
        arr[i3] = Integer.valueOf(M0(dVar));
        this.a.d("Recycled SubItem %s with Parent position=%s", arr);
    }

    private void t1(T t, g gVar, Object object) {
        boolean hidden;
        if (t != null) {
            hidden = t instanceof h;
            if (t instanceof h) {
                f gVar22 = t;
                if (gVar22.getHeader() != null && !gVar22.getHeader().equals(gVar)) {
                    X1(gVar22, d.UNLINK);
                }
                if (gVar22.getHeader() == null && gVar != null) {
                    Object[] arr = new Object[2];
                    str = "Link header %s to %s";
                    this.a.d(str, gVar, gVar22);
                    gVar22.setHeader(gVar);
                    if (object != null && !gVar.isHidden()) {
                        notifyItemChanged(M0(gVar), object);
                        if (!t.isHidden()) {
                            notifyItemChanged(M0(t), object);
                        }
                    }
                }
            } else {
                notifyItemChanged(M0(gVar), object);
            }
        }
    }

    private void u1(T t) {
        if (!this.U.containsKey(Integer.valueOf(t.getItemViewType()))) {
            this.U.put(Integer.valueOf(t.getItemViewType()), t);
            Object[] arr = new Object[2];
            int i = 1;
            arr[i] = a.a(t);
            str = "Mapped viewType %s from %s";
            this.a.c(str, arr);
        }
    }

    private synchronized void v0(d dVar) {
        Object[] arr;
        Integer num;
        final h.e eVar3 = null;
        int i = 1;
        final int i2 = 0;
        if (this.E != null) {
            this.a.c("Dispatching notifications", new Object[i2]);
            this.v = this.F.a();
            this.E.c(this);
            this.E = eVar3;
        } else {
            str = "Performing %s notifications";
            arr = new Object[i];
            this.a.c(str, Integer.valueOf(this.z.size()));
            this.v = this.w;
            B(false);
            Iterator it = this.z.iterator();
            while (it.hasNext()) {
                Object item = it.next();
            }
            this.w = eVar3;
            this.z = eVar3;
            B(true);
        }
        long l = System.currentTimeMillis() - this.B;
        this.C = l;
        Object[] arr2 = new Object[i];
        this.a.c("Animate changes DONE in %sms", Long.valueOf(l));
    }

    private int y0(int i, boolean z, boolean z2, boolean z3) {
        List list;
        int size = 0;
        c cVar;
        Object[] arr;
        int i2;
        String str;
        int i3;
        h.a.b.d eXPANDED2;
        String str3;
        f fVar = O0(i);
        z = false;
        if (!j1(fVar)) {
            return z;
        }
        d dVar = fVar;
        final int i5 = 2;
        final int i6 = 1;
        if (!c1(dVar)) {
            dVar.d(z);
            Object[] arr3 = new Object[i5];
            arr3[z] = Integer.valueOf(i);
            arr3[i6] = Boolean.valueOf(dVar.a());
            this.a.e("No subItems to Expand on position %s expanded %s", arr3);
            return z;
        }
        int i4 = 3;
        if (!z2 && !this.a) {
            arr = new Object[i4];
            arr[z] = Integer.valueOf(i);
            arr[i6] = Boolean.valueOf(dVar.a());
            arr[i5] = Boolean.valueOf(this.j0);
            str = "Request to Expand on position=%s expanded=%s anyParentSelected=%s";
            this.a.d(str, arr);
        }
        if (z2 || !dVar.a()) {
            if (this.g0 && !this.a && this.p0(this.d0) > 0) {
                i3 = M0(fVar);
            }
            list = J0(dVar, true);
            i2 = i3 + 1;
            this.v.addAll(i2, list);
            size = list.size();
            dVar.d(true);
            if (!z2 && this.f0 && !this.a) {
                m0(i3, size);
            }
            if (z3) {
                notifyItemChanged(i3, d.EXPANDED);
            }
            notifyItemRangeInserted(i2, size);
            if (!z2 && this.O) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    z = z + i6;
                    i2 = i3 + z;
                }
            }
            if (!z0(this.M, dVar)) {
                z0(this.N, dVar);
            }
            Object[] arr2 = new Object[i4];
            z2 = z2 ? "Initially expanded" : "Expanded";
            arr2[z] = (z2 ? "Initially expanded" : "Expanded");
            arr2[i6] = (z2 ? "Initially expanded" : "Expanded");
            arr2[i5] = Integer.valueOf(i3);
            str2 = "%s %s subItems on position=%s";
            this.a.d("%s %s subItems on position=%s", arr2);
        }
        return size;
    }

    private boolean z0(List<T> list, d dVar) {
        int indexOf = list.indexOf(dVar);
        if (indexOf >= 0) {
            indexOf++;
            if (i < list.size()) {
                return list.addAll(i, dVar.b());
            }
            return list.addAll(dVar.b());
        }
        return false;
    }

    @Override // h.a.b.a
    public final boolean A(int i) {
        return s1(O0(i));
    }

    @Override // h.a.b.a
    protected boolean C0(T t, Serializable serializable) {
        boolean z3 = false;
        if (t instanceof e) {
            t = t.a(serializable) ? 1 : 0;
        }
        return (t.a(serializable) ? 1 : 0);
    }

    @Override // h.a.b.a
    public final List<T> E0(d dVar) {
        return new ArrayList();
    }

    @Override // h.a.b.a
    public final List<T> F0() {
        return Collections.unmodifiableList(this.v);
    }

    @Override // h.a.b.a
    public void F1(int i, Object object) {
        n0(i);
        this.a.d("removeItem delegates removal to removeRange", new Object[0]);
        H1(i, 1, object);
    }

    @Override // h.a.b.a
    public final List<T> G0(d dVar) {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        return arrayList;
    }

    @Override // h.a.b.a
    public void G1(int i, int i2) {
        H1(i, i2, d.REM_SUB_ITEM);
    }

    @Override // h.a.b.a
    public List<T> H0() {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            arrayList.add((b.v)it.next().d);
        }
        return arrayList;
    }

    @Override // h.a.b.a
    public void H1(int i, int i2, Object object) {
        int i3;
        f fVar;
        d dVar;
        f fVar2;
        boolean z;
        boolean hasNext;
        h.a.b.d uNLINK2;
        final int itemCount = getItemCount();
        Object[] arr = new Object[2];
        int i8 = 0;
        arr[i8] = Integer.valueOf(i);
        final int i9 = 1;
        arr[i9] = Integer.valueOf(i2);
        this.a.a("removeRange positionStart=%s itemCount=%s", arr);
        if (i >= 0) {
            int i6 = i + i2;
            this.a.e("removeRange Nothing to delete!", new Object[i8]);
            return;
        }
        this.a.b("Cannot removeRange with positionStart OutOfBounds!", new Object[i8]);
    }

    @Override // h.a.b.a
    public int I0() {
        if (this.n0 > 0) {
            return (int)(Math.ceil((double)R0() / (double)this.n0));
        }
        return 0;
    }

    @Override // h.a.b.a
    public final void I1(T t) {
        if (this.N.remove(t)) {
            int i = 1;
            Object[] arr = new Object[i];
            arr[0] = a.a(t);
            str = "Remove scrollable footer %s";
            this.a.a(str, arr);
            B1(t, true);
        }
    }

    @Override // h.a.b.a
    public final void J1(T t) {
        if (this.M.remove(t)) {
            int i = 1;
            Object[] arr = new Object[i];
            arr[0] = a.a(t);
            str = "Remove scrollable header %s";
            this.a.a(str, arr);
            B1(t, true);
        }
    }

    @Override // h.a.b.a
    public d K0(T t) {
        boolean hasNext;
        boolean hidden;
        Iterator it = this.v.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            if (j1(item)) {
            }
        }
        return null;
    }

    @Override // h.a.b.a
    public <F extends Serializable> F L0(Class<F> cls) {
        return (Serializable)cls.cast(this.W);
    }

    @Override // h.a.b.a
    public final int M0(f fVar) {
        int indexOf = -1;
        if (fVar != null) {
            indexOf = this.v.indexOf(fVar);
        } else {
            indexOf = -1;
        }
        return indexOf;
    }

    @Override // h.a.b.a
    public b<T> M1(boolean z) {
        if (!this.O && z) {
            boolean z2 = true;
            Q1(z2);
        }
        return this;
    }

    @Override // h.a.b.a
    public g N0(T t) {
        if (t != null) {
            z = t instanceof h;
            if (t instanceof h) {
                return t.getHeader();
            }
        }
        return null;
    }

    @Override // h.a.b.a
    public b<T> N1(boolean z) {
        O1(z, this.S);
        return this;
    }

    @Override // h.a.b.a
    public T O0(int i) {
        return null;
    }

    @Override // h.a.b.a
    public b<T> O1(boolean z, ViewGroup viewGroup) {
        String str;
        Object[] arr = new Object[2];
        String r2 = viewGroup != null ? " with user defined Sticky Container" : "";
        this.a.c((viewGroup != null ? " with user defined Sticky Container" : ""), Boolean.valueOf(z), (viewGroup != null ? " with user defined Sticky Container" : ""));
        this.S = viewGroup;
        this.G.post(new b.d(this, z));
        return this;
    }

    @Override // h.a.b.a
    public final l P0() {
        h1();
        return this.l0;
    }

    @Override // h.a.b.a
    public final b<T> P1(boolean z) {
        Object[] arr = new Object[1];
        this.a.c("Set swipeEnabled=%s", Boolean.valueOf(z));
        h1();
        this.k0.F(z);
        return this;
    }

    @Override // h.a.b.a
    public final h.a.b.g.a Q0() {
        h1();
        return this.k0;
    }

    @Override // h.a.b.a
    public final int R0() {
        int itemCount;
        if (Y0()) {
            itemCount = getItemCount();
        } else {
            itemCount = (getItemCount() - this.M.size()) - this.N.size();
        }
        return itemCount;
    }

    @Override // h.a.b.a
    public g T0(int i) {
        int i2;
        final int i3 = 0;
        if (!this.O) {
            return null;
        }
        while (i2 >= 0) {
            f fVar = O0(i2);
            if (o1(fVar)) {
                return fVar;
            }
        }
        return i3;
    }

    @Override // h.a.b.a
    public List<h.a.b.h.h> U0(g gVar) {
        int i;
        f fVar;
        final ArrayList arrayList = new ArrayList();
        i = M0(gVar) + 1;
        fVar = O0(i);
        while (b1(fVar, gVar)) {
            arrayList.add(fVar);
            i = i + 1;
            fVar = O0(i);
        }
        return arrayList;
    }

    @Override // h.a.b.a
    public int V0() {
        return this.Q;
    }

    @Override // h.a.b.a
    public void V1(int i) {
        if (this.f != null) {
            long l = 150L;
            this.f.postDelayed(new b.a(this, i), l);
        }
    }

    @Override // h.a.b.a
    public final int W0() {
        int i = -1;
        if (l0()) {
            i = this.R.p();
        } else {
            i = -1;
        }
        return i;
    }

    @Override // h.a.b.a
    public void W1(List<T> list, int i, int i2) {
        f fVar;
        int i22;
        boolean equals;
        String str;
        Boolean str2;
        Integer num;
        int i6;
        h.a.b.d lINK2;
        int i7;
    }

    @Override // h.a.b.a
    public boolean X(int i, T t) {
        int i2 = 0;
        if (t == null) {
            this.a.b("addItem No item to add!", new Object[i2]);
            return false;
        }
        this.a.d("addItem delegates addition to addItems!", new Object[i2]);
        return Z(i, Collections.singletonList(t));
    }

    @Override // h.a.b.a
    public boolean Y(T t) {
        return X(getItemCount(), t);
    }

    @Override // h.a.b.a
    public boolean Y0() {
        boolean z2 = true;
        if (serializable instanceof String) {
            return (String)L0(String.class).isEmpty() ^ 1;
        }
        if (this.W == null) {
            int i3 = 0;
        }
        return z2;
    }

    @Override // h.a.b.a
    public void Y1(List<T> list) {
        Z1(list, false);
    }

    @Override // h.a.b.a
    public boolean Z(int i, List<T> list) {
        int i3;
        int i2 = 0;
        this.a.b("addItems No items to add!", new Object[i2]);
        return false;
    }

    @Override // h.a.b.a
    public boolean Z0(T t) {
        boolean z = true;
        t = N0(t) != null ? 1 : 0;
        return (N0(t) != null ? 1 : 0);
    }

    @Override // h.a.b.a
    public void Z1(List<T> list, boolean z) {
        ArrayList arrayList;
        this.x = null;
        if (list == null) {
            arrayList = new ArrayList();
        }
        if (z) {
            int i = 1;
            this.G.removeMessages(i);
            this.G.sendMessage(Message.obtain(this.G, i, arrayList));
        } else {
            ArrayList arrayList2 = new ArrayList(arrayList);
            D1(arrayList2);
            this.v = arrayList2;
            this.a.e("updateDataSet with notifyDataSetChanged!", new Object[0]);
            notifyDataSetChanged();
            z1();
        }
    }

    @Override // h.a.b.a
    public b<T> a0(Object object) {
        Object[] arr;
        String str;
        int i = 0;
        if (object == null) {
            this.a.b("Invalid listener class: null", new Object[i]);
            return this;
        }
        arr = new Object[1];
        str = "Adding listener class %s as:";
        this.a.c(str, a.a(object));
        z = object instanceof b.p;
        if (object instanceof b.p) {
            str = "- OnItemClickListener";
            this.a.c(str, new Object[i]);
            this.s0 = (b.p)object;
            Iterator it = j().iterator();
            while (it.hasNext()) {
                Object[] item = it.next();
                item.getContentView().setOnClickListener(item);
            }
        }
        z2 = object instanceof b.q;
        if (object instanceof b.q) {
            str = "- OnItemLongClickListener";
            this.a.c(str, new Object[i]);
            this.t0 = (b.q)object;
            Iterator it2 = j().iterator();
            while (it2.hasNext()) {
                Object[] item2 = it2.next();
                item2.getContentView().setOnLongClickListener(item2);
            }
        }
        z3 = object instanceof b.r;
        if (object instanceof b.r) {
            str = "- OnItemMoveListener";
            this.a.c(str, new Object[i]);
            this.w0 = (b.r)object;
        }
        z4 = object instanceof b.s;
        if (object instanceof b.s) {
            str = "- OnItemSwipeListener";
            this.a.c(str, new Object[i]);
            this.x0 = (b.s)object;
        }
        z5 = object instanceof b.n;
        if (object instanceof b.n) {
            str = "- OnDeleteCompleteListener";
            this.a.c(str, new Object[i]);
            this.z0 = (b.n)object;
        }
        z6 = object instanceof b.t;
        if (object instanceof b.t) {
            str = "- OnStickyHeaderChangeListener";
            this.a.c(str, new Object[i]);
            this.A0 = (b.t)object;
        }
        z7 = object instanceof b.u;
        if (object instanceof b.u) {
            str = "- OnUpdateListener";
            this.a.c(str, new Object[i]);
            Object object2 = object;
            this.u0 = object2;
            object2.a(R0());
        }
        z8 = object instanceof b.o;
        if (object instanceof b.o) {
            this.a.c("- OnFilterListener", new Object[i]);
            this.v0 = object;
        }
        return this;
    }

    @Override // h.a.b.a
    public boolean a1(Serializable serializable) {
        boolean z3 = true;
        z = serializable instanceof String;
        if (serializable instanceof String && serializable3 instanceof String) {
            return serializable3.equalsIgnoreCase(serializable) ^ 1;
        }
        return z3;
    }

    @Override // h.a.b.a
    public void a2(int i, T t, Object object) {
        int i2 = 0;
        if (t == null) {
            this.a.b("updateItem No Item to update!", new Object[i2]);
            return;
        }
        this.a.b("Cannot updateItem on position out of OutOfBounds!", new Object[i2]);
    }

    @Override // h.a.b.a
    public final boolean b0(T t) {
        int size;
        Object[] arr;
        int i = 1;
        size = 0;
        if (!this.N.contains(t)) {
            arr = new Object[i];
            this.a.a("Add scrollable footer %s", a.a(t));
            t.setSelectable(false);
            t.setDraggable(false);
            if (t == this.r0) {
                size = this.N.size();
            } else {
            }
            if (this.r0 > 0) {
                if (this.N.size() > 0) {
                    this.N.add(size, t);
                } else {
                    this.N.add(t);
                }
            }
            A1(getItemCount() - size, Collections.singletonList(t), true);
            return true;
        }
        Object[] arr2 = new Object[i];
        arr2[size] = a.a(t);
        this.a.e("Scrollable footer %s already added", arr2);
        return false;
    }

    @Override // h.a.b.a
    public boolean b1(T t, g gVar) {
        boolean z = true;
        gVar = N0(t);
        t = gVar != null && gVar != null && gVar.equals(gVar) ? 1 : 0;
        return (gVar != null && gVar != null && gVar.equals(gVar) ? 1 : 0);
    }

    @Override // h.a.b.a
    public void b2(T t) {
        c2(t, null);
    }

    @Override // h.a.b.a
    public void c(int i, int i2) {
        if (this.x0 != null) {
            this.x0.n0(i, i2);
        }
    }

    @Override // h.a.b.a
    public final boolean c0(T t) {
        int size;
        int i = 1;
        Object[] arr2 = new Object[i];
        size = 0;
        arr2[size] = a.a(t);
        this.a.a("Add scrollable header %s", arr2);
        if (!this.M.contains(t)) {
            t.setSelectable(false);
            t.setDraggable(false);
            if (t == this.r0) {
                size = this.M.size();
            } else {
            }
            this.M.add(t);
            B(true);
            A1(size, Collections.singletonList(t), true);
            B(false);
            return true;
        }
        Object[] arr = new Object[i];
        arr[size] = a.a(t);
        this.a.e("Scrollable header %s already added", arr);
        return false;
    }

    @Override // h.a.b.a
    public boolean c1(d dVar) {
        List list;
        boolean z = true;
        if (dVar != null && dVar.b() != null) {
            dVar = dVar.b().size() > 0 ? 1 : 0;
        }
        return (dVar.b().size() > 0 ? 1 : 0);
    }

    @Override // h.a.b.a
    public void c2(T t, Object object) {
        a2(M0(t), t, object);
    }

    @Override // h.a.b.a
    public boolean d(int i, int i2) {
        f fVar;
        boolean contains;
        boolean z2 = true;
        fVar = O0(i2);
        if (!this.M.contains(fVar)) {
            if (this.N.contains(fVar) || this.w0 != null) {
                int i4 = 0;
            } else {
                i = this.w0.v1(i, i2) ? 1 : 0;
            }
        }
        return (this.w0.v1(i, i2) ? 1 : 0);
    }

    @Override // h.a.b.a
    public void e(RecyclerView.e0 e0Var, int i) {
        if (this.w0 != null) {
            this.w0.e(e0Var, i);
        } else {
            if (this.x0 != null) {
                this.x0.e(e0Var, i);
            }
        }
    }

    @Override // h.a.b.a
    public int getItemCount() {
        return this.v.size();
    }

    @Override // h.a.b.a
    public long getItemId(int i) {
        long l = -1;
        f fVar = O0(i);
        l = fVar != null ? (long)i2 : -1;
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
        this.V = true;
        return fVar.getItemViewType();
    }

    @Override // h.a.b.a
    public void h() {
        final boolean z = false;
        this.i0 = z;
        this.j0 = z;
        super.h();
    }

    @Override // h.a.b.a
    public boolean i1() {
        return this.p0;
    }

    @Override // h.a.b.a
    public boolean j1(T t) {
        return t instanceof d;
    }

    @Override // h.a.b.a
    public boolean k(int i, int i2) {
        W1(this.v, i, i2);
        if (this.w0 != null) {
            this.w0.k(i, i2);
        }
        return true;
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
        boolean z = true;
        int r0 = this.R != null ? 1 : 0;
        return (this.R != null ? 1 : 0);
    }

    @Override // h.a.b.a
    public boolean l1(T t) {
        boolean z3 = false;
        if (j1(t)) {
            t = t.a() ? 1 : 0;
        }
        return (t.a() ? 1 : 0);
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
        boolean z2 = false;
        int r0 = this.k0 != null && this.k0.D() ? 1 : 0;
        return (this.k0 != null && this.k0.D() ? 1 : 0);
    }

    @Override // h.a.b.a
    public int o0(int i, boolean z) {
        int size;
        boolean z3;
        f item = O0(i);
        final int i2 = 0;
        if (!j1(item)) {
            return i2;
        }
        dVar = item;
        final boolean z7 = true;
        final List list = J0(dVar, z7);
        Object[] arr2 = new Object[3];
        arr2[z7] = Boolean.valueOf(dVar.a());
        final int i6 = 2;
        arr2[i6] = Boolean.valueOf(d1(i, list));
        this.a.d("Request to Collapse on position=%s expanded=%s hasSubItemsSelected=%s", arr2);
        if (dVar.a() && list.size() > 0 && this.d1(i, list) && this.S0(item) != null && this.h0) {
            E1(i + 1, list, dVar.c());
            this.v.removeAll(list);
            size = list.size();
            dVar.d(false);
            if (z) {
                notifyItemChanged(i, d.COLLAPSED);
            }
            notifyItemRangeRemoved(i + 1, size);
            if (this.O && !this.o1(item)) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    f1((f)it.next());
                }
            }
            if (!q0(this.M, dVar)) {
                q0(this.N, dVar);
            }
            Object[] arr = new Object[i6];
            arr[z7] = Integer.valueOf(i);
            str = "Collapsed %s subItems on position %s";
            this.a.d(str, arr);
        }
        return size;
    }

    @Override // h.a.b.a
    public boolean o1(T t) {
        boolean z2 = false;
        if (t != null) {
            z = t instanceof g;
            t = t instanceof g ? 1 : 0;
        }
        return (t instanceof g ? 1 : 0);
    }

    @Override // h.a.b.a
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.a.d("Attached Adapter to RecyclerView", new Object[0]);
        if (this.O && this.l0()) {
            this.R.g(this.f);
        }
    }

    @Override // h.a.b.a
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i) {
        onBindViewHolder(e0Var, i, Collections.unmodifiableList(new ArrayList()));
    }

    @Override // h.a.b.a
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i) {
        f fVar = X0(i);
        final boolean z2 = false;
        if (fVar == null) {
            Object[] arr = new Object[1];
            arr[z2] = Integer.valueOf(i);
            throw new IllegalStateException(String.format("ViewType instance not found for viewType %s. You should implement the AutoMap properly.", arr));
        } else {
            if (this.V) {
                if (this.T == null) {
                    this.T = LayoutInflater.from(viewGroup.getContext());
                }
                return fVar.createViewHolder(this.T.inflate(fVar.getLayoutRes(), viewGroup, z2), this);
            }
        }
    }

    @Override // h.a.b.a
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        if (l0()) {
            this.R.l();
            this.R = null;
        }
        super.onDetachedFromRecyclerView(recyclerView);
        this.a.d("Detached Adapter from RecyclerView", new Object[0]);
    }

    @Override // h.a.b.a
    public void onViewAttachedToWindow(RecyclerView.e0 e0Var) {
        final int adapterPosition = e0Var.getAdapterPosition();
        final f fVar = O0(adapterPosition);
        if (fVar != null) {
            fVar.onViewAttached(this, e0Var, adapterPosition);
        }
    }

    @Override // h.a.b.a
    public void onViewDetachedFromWindow(RecyclerView.e0 e0Var) {
        final int adapterPosition = e0Var.getAdapterPosition();
        final f fVar = O0(adapterPosition);
        if (fVar != null) {
            fVar.onViewDetached(this, e0Var, adapterPosition);
        }
    }

    @Override // h.a.b.a
    public void onViewRecycled(RecyclerView.e0 e0Var) {
        super.onViewRecycled(e0Var);
        if (l0()) {
            int i = 0;
            e0Var.itemView.setVisibility(i);
        }
        int adapterPosition = e0Var.getAdapterPosition();
        f fVar = O0(adapterPosition);
        if (fVar != null) {
            fVar.unbindViewHolder(this, e0Var, adapterPosition);
        }
    }

    @Override // h.a.b.a
    public int p0(int i) {
        return E1(0, this.v, i);
    }

    @Override // h.a.b.a
    public boolean p1(int i) {
        boolean z = false;
        f fVar = O0(i);
        i = fVar != null && fVar.isEnabled() ? 1 : 0;
        return (fVar != null && fVar.isEnabled() ? 1 : 0);
    }

    @Override // h.a.b.a
    public boolean q(int i) {
        boolean z = false;
        f fVar = O0(i);
        i = fVar != null && fVar.isSelectable() ? 1 : 0;
        return (fVar != null && fVar.isSelectable() ? 1 : 0);
    }

    @Override // h.a.b.a
    public final boolean q1() {
        boolean z2 = false;
        int r0 = this.k0 != null && this.k0.s() ? 1 : 0;
        return (this.k0 != null && this.k0.s() ? 1 : 0);
    }

    @Override // h.a.b.a
    public boolean r0(T t) {
        List list;
        boolean z = false;
        if (t != null) {
            t = this.v.contains(t) ? 1 : 0;
        }
        return (this.v.contains(t) ? 1 : 0);
    }

    @Override // h.a.b.a
    public final synchronized boolean r1() {
        boolean z = false;
        int i = 0;
        return z;
    }

    @Override // h.a.b.a
    public void removeItem(int i) {
        F1(i, d.CHANGE);
    }

    @Override // h.a.b.a
    public final boolean s1(T t) {
        boolean contains;
        boolean z = true;
        if (t != null) {
            if (!this.M.contains(t)) {
                t = this.N.contains(t) ? 1 : 0;
            }
        }
        return (this.N.contains(t) ? 1 : 0);
    }

    @Override // h.a.b.a
    public final void u0() {
        if (l0()) {
            this.R.m();
        }
    }

    @Override // h.a.b.a
    public void v(int i) {
        boolean z;
        int i3;
        f fVar = O0(i);
        final boolean z4 = false;
        final int i8 = -1;
        if (fVar != null && fVar.isSelectable()) {
            d dVar = K0(fVar);
            boolean z2 = true;
            boolean r5 = dVar != null ? z2 : z4;
            if (this.j1(fVar) || i3 == 0) {
                if (!this.i0) {
                    this.j0 = z2;
                    if (i3 != 0) {
                        this.e0 = dVar.c();
                    }
                    super.v(i);
                } else {
                    if (i3 != 0) {
                        if (this.e0 == i8 || !this.j0) {
                            this.i0 = z2;
                            this.e0 = dVar.c() + z2;
                            super.v(i);
                        }
                    }
                }
            }
        }
        if (super.o() == 0) {
            this.e0 = i8;
            this.i0 = z4;
            this.j0 = z4;
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
    public void w1(int i, int i2, Object object) {
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
        A1(i2, Collections.singletonList(fVar), false);
        notifyItemMoved(i, i2);
        if (object != null) {
            notifyItemChanged(i2, object);
        }
        if (this.O) {
            S1(i2, fVar, false);
        }
        if (z2) {
            w0(i2);
        }
    }

    @Override // h.a.b.a
    public int x0(int i, boolean z) {
        z = false;
        return y0(i, z, z, z);
    }

    @Override // h.a.b.a
    protected void x1(int i) {
        int i2;
        int size;
        if (i1() && !this.o0) {
            if (O0(i) != this.r0) {
                size = 0;
                if (this.q0) {
                    if (Y0()) {
                    } else {
                        size = this.M.size();
                    }
                } else {
                    i2 = getItemCount() - this.m0;
                    if (!Y0()) {
                        size = this.N.size();
                    }
                }
                i2 -= size;
                if (!this.q0) {
                    return;
                }
                Object[] arr = new Object[6];
                int i3 = 1;
                arr[i3] = Boolean.valueOf(this.o0);
                arr[2] = Integer.valueOf(i);
                arr[3] = Integer.valueOf(getItemCount());
                arr[4] = Integer.valueOf(this.m0);
                arr[5] = Integer.valueOf(i4);
                this.a.d("onLoadMore     topEndless=%s, loading=%s, position=%s, itemCount=%s threshold=%s, currentThreshold=%s", arr);
                this.o0 = true;
                this.G.post(new b.f(this));
            }
        }
    }

    @Override // h.a.b.a
    protected void y1() {
        if (this.v0 != null) {
            this.v0.a(R0());
        }
    }

    @Override // h.a.b.a
    protected void z1() {
        if (this.u0 != null) {
            this.u0.a(R0());
        }
    }

    public b(List<T> list, Object object) {
        this(list, object, false);
    }

    @Override // h.a.b.a
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i, List list) {
        if (!this.V) {
            throw new IllegalStateException("AutoMap is not active, this method cannot be called. You should implement the AutoMap properly.");
        } else {
            super.onBindViewHolder(e0Var, i, list);
            f fVar = O0(i);
            if (fVar != null) {
                e0Var.itemView.setEnabled(fVar.isEnabled());
                fVar.bindViewHolder(this, e0Var, i, list);
                if (l0() && this.o1(fVar) && !this.h) {
                    if (this.R.p() >= 0 && list.isEmpty()) {
                        if (l().b() - 1 == i) {
                            e0Var.itemView.setVisibility(4);
                        }
                    }
                }
            }
            x1(i);
            x(e0Var, i);
            return;
        }
    }

    public b(List<T> list, Object object, boolean z) {
        super(z);
        z = false;
        this.D = z;
        this.G = new Handler(Looper.getMainLooper(), new b.k(this));
        this.I = z;
        this.J = z;
        boolean z2 = true;
        this.K = z2;
        this.L = z2;
        this.O = z;
        this.P = z;
        this.U = new HashMap();
        this.V = z;
        Serializable serializable = null;
        this.W = serializable;
        this.X = "";
        this.Z = z2;
        this.a0 = z;
        this.b0 = z;
        this.c0 = b.B0;
        this.d0 = z;
        this.e0 = -1;
        this.f0 = z;
        this.g0 = z;
        this.h0 = z;
        this.i0 = z;
        this.j0 = z;
        this.m0 = z2;
        this.n0 = z;
        this.o0 = z;
        this.p0 = z;
        this.q0 = z;
        if (list == null) {
            this.v = new ArrayList();
        } else {
            this.v = new ArrayList(list);
        }
        this.M = new ArrayList();
        this.N = new ArrayList();
        this.H = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        if (object != null) {
            a0(object);
        }
        registerAdapterDataObserver(new b.g(this, serializable));
    }
}
