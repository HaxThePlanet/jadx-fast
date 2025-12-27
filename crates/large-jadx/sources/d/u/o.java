package d.u;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import d.e.a;
import d.e.d;
import d.e.g;
import d.h.l.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: Transition.java */
/* loaded from: classes.dex */
public abstract class o implements java.lang.Cloneable {

    private static final int[] Y;
    private static final g Z = new o$a();
    private static java.lang.ThreadLocal<a<Animator, o.d>> a0;
    private ArrayList<Integer> A = null;
    private ArrayList<View> B = null;
    private ArrayList<Class<?>> C = null;
    private ArrayList<String> D = null;
    private ArrayList<Integer> E = null;
    private ArrayList<View> F = null;
    private ArrayList<Class<?>> G = null;
    private v H = new v();
    private v I = new v();
    s J = null;
    private int[] K;
    private ArrayList<u> L;
    private ArrayList<u> M;
    boolean N = false;
    ArrayList<Animator> O = new ArrayList<>();
    private int P = 0;
    private boolean Q = false;
    private boolean R = false;
    private ArrayList<o.f> S = null;
    private ArrayList<Animator> T = new ArrayList<>();
    r U;
    private o.e V;
    private a<String, String> W;
    private g X;
    private String a;
    private long b = -1;
    long c = -1;
    private TimeInterpolator v = null;
    ArrayList<Integer> w = new ArrayList<>();
    ArrayList<View> x = new ArrayList<>();
    private ArrayList<String> y = null;
    private ArrayList<Class<?>> z = null;

    class b extends AnimatorListenerAdapter {

        final /* synthetic */ a a;
        final /* synthetic */ o b;
        b(a aVar) {
            this.b = oVar;
            this.a = aVar;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            this.b.O.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            this.b.O.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {

        final /* synthetic */ o a;
        c() {
            this.a = oVar;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.a.p();
            animator.removeListener(this);
        }
    }

    private static class d {

        View a;
        String b;
        u c;
        q0 d;
        o e;
        d(View view, String str, o oVar, q0 q0Var, u uVar) {
            super();
            this.a = view;
            this.b = str;
            this.c = uVar;
            this.d = q0Var;
            this.e = oVar;
        }
    }

    public static abstract class e {
        public abstract Rect a(o oVar);
    }

    public interface f {
        void onTransitionCancel(o oVar);

        void onTransitionEnd(o oVar);

        void onTransitionPause(o oVar);

        void onTransitionResume(o oVar);

        void onTransitionStart(o oVar);
    }

    static class a extends g {
        a() {
            super();
        }

        @Override // d.u.g
        public Path a(float f, float f2, float f3, float f4) {
            final Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }
    static {
        o.Y = new int[] { 2, 1, 3, 4 };
        o.a0 = new ThreadLocal();
    }

    public o() {
        super();
        this.a = getClass().getName();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        d.u.v vVar = new v();
        d.u.v vVar2 = new v();
        this.K = o.Y;
        final ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.X = o.Z;
    }

    private static a<Animator, o.d> A() {
        Object obj;
        if ((a)o.a0.get() == null) {
            o.a0.set(new a());
        }
        return obj;
    }

    private static boolean K(u uVar, u uVar2, String str) {
        boolean z = true;
        Object value = uVar.a.get(str);
        Object value2 = uVar2.a.get(str);
        if (value == null || value2 != null) {
            int i3 = 0;
        }
        return z;
    }

    private void L(a<View, u> aVar, a<View, u> aVar2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int i = 0;
        boolean z;
        boolean z2;
        Object obj;
        ArrayList list;
        i = 0;
        while (i < sparseArray.size()) {
            Object valueAt = sparseArray.valueAt(i);
            i = i + 1;
        }
    }

    private void M(a<View, u> aVar, a<View, u> aVar2) {
        int i;
        Object remove;
        boolean z;
        ArrayList list;
        i = aVar.size() - 1;
        while (i >= 0) {
            remove = aVar.j(i);
            i = i - 1;
        }
    }

    private void N(a<View, u> aVar, a<View, u> aVar2, d<View> dVar, d<View> dVar2) {
        int i = 0;
        boolean z;
        boolean z2;
        Object obj2;
        ArrayList list;
        i = 0;
        while (i < dVar.n()) {
            Object obj = dVar.o(i);
            i = i + 1;
        }
    }

    private void O(a<View, u> aVar, a<View, u> aVar2, a<String, View> aVar3, a<String, View> aVar4) {
        int i = 0;
        boolean z;
        boolean z2;
        Object obj2;
        ArrayList list;
        i = 0;
        while (i < aVar3.size()) {
            Object obj = aVar3.n(i);
            i = i + 1;
        }
    }

    private void P(v vVar, v vVar2) {
        int i = 0;
        a aVar;
        a aVar2;
        final a aVar3 = new a(vVar.a);
        a aVar5 = new a(vVar2.a);
        i = 0;
        for (int i2 : iArr) {
        }
        c(aVar3, aVar5);
    }

    private void V(Animator animator, a<Animator, o.d> aVar) {
        if (animator != null) {
            animator.addListener(new o.b(this, aVar));
            e(animator);
        }
    }

    private void c(a<View, u> aVar, a<View, u> aVar2) {
        int i = 0;
        Object obj;
        boolean z;
        Object obj3;
        i = 0;
        Object obj2 = null;
        while (i < aVar.size()) {
            obj = aVar.n(i);
            i = i + 1;
            obj2 = null;
        }
        while (i < aVar2.size()) {
            obj3 = aVar2.n(i);
            i = i + 1;
        }
    }

    private static void d(v vVar, View view, u uVar) {
        SparseArray sparseArray;
        vVar.a.put(view, uVar);
        int id = view.getId();
        Object obj2 = null;
        if (id >= 0) {
            if (vVar.b.indexOfKey(id) >= 0) {
                vVar.b.put(id, obj2);
            } else {
                vVar.b.put(id, view);
            }
        }
        String str = u.J(view);
        if (str != null) {
            if (vVar.d.containsKey(str)) {
                vVar.d.put(str, obj2);
            } else {
                vVar.d.put(str, view);
            }
        }
        z = view.getParent() instanceof ListView;
        if (view.getParent() instanceof istView) {
            android.view.ViewParent parent2 = view.getParent();
            if (parent2.getAdapter().hasStableIds()) {
                long itemIdAtPosition = parent2.getItemIdAtPosition(parent2.getPositionForView(view));
                if (vVar.c.h(itemIdAtPosition) < 0) {
                    boolean z = true;
                    u.u0(view, z);
                    vVar.c.k(itemIdAtPosition, view);
                } else {
                    Object obj = vVar.c.f(itemIdAtPosition);
                    if (obj != null) {
                        z = false;
                        u.u0(obj, z);
                        vVar.c.k(itemIdAtPosition, obj2);
                    }
                }
            }
        }
    }

    private void g(View view, boolean z) {
        ArrayList list2;
        ArrayList list6;
        int i;
        boolean instance;
        if (view == null) {
            return;
        }
        int childCount = view.getId();
        if (this.A != null && this.A.contains(Integer.valueOf(childCount))) {
            return;
        }
        if (this.B != null && this.B.contains(view)) {
            return;
        }
        i = 0;
        if (this.C != null) {
            while (i < this.C.size()) {
                if ((Class)this.C.get(i).isInstance(view)) {
                    return;
                }
            }
        }
        z = view.getParent() instanceof ViewGroup;
        if (view.getParent() instanceof ViewGroup) {
            d.u.u uVar = new u(view);
            if (z) {
                j(uVar);
            } else {
                f(uVar);
            }
            uVar.c.add(this);
            h(uVar);
            if (z) {
                o.d(this.H, view, uVar);
            } else {
                o.d(this.I, view, uVar);
            }
        }
        z3 = view instanceof ViewGroup;
        if (view instanceof ViewGroup && this.E != null) {
            if (this.E.contains(Integer.valueOf(childCount))) {
                return;
            }
            if (this.F != null && this.F.contains(view)) {
                return;
            }
            if (this.G != null) {
                while (this.A < this.G.size()) {
                    if ((Class)this.G.get(i).isInstance(view)) {
                        return;
                    }
                }
            }
            while (i < view.getChildCount()) {
                g(view.getChildAt(i), z);
                i = i + 1;
            }
        }
    }

    public long B() {
        return this.b;
    }

    public List<Integer> C() {
        return this.w;
    }

    public List<String> D() {
        return this.y;
    }

    public List<Class<?>> E() {
        return this.z;
    }

    public List<View> F() {
        return this.x;
    }

    public u H(View view, boolean z) {
        d.u.v vVar;
        if (this.J != null) {
            return this.J.H(view, z);
        }
        z = z ? this.H : this.I;
        return (u)(z ? this.H : this.I).get(view);
    }

    public boolean I(u uVar, u uVar2) {
        boolean z3 = false;
        String[] strArr;
        int length;
        int i;
        boolean z2;
        if (uVar != null && uVar2 != null && strArr != null) {
            length = strArr.length;
            for (String str : strArr) {
            }
        }
        return z3;
    }

    boolean J(View view) {
        int i;
        ArrayList list9;
        Integer num;
        boolean instance;
        int id = view.getId();
        i = 0;
        if (this.A != null && this.A.contains(Integer.valueOf(id))) {
            return false;
        }
        if (this.B != null && this.B.contains(view)) {
            return false;
        }
        if (this.C != null) {
            while (i < this.C.size()) {
                if ((Class)this.C.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.D != null && u.J(view) != null) {
            if (this.D.contains(u.J(view))) {
                return false;
            }
        }
        boolean z = true;
        if (this.w.size() == 0 && this.x.size() == 0) {
            if (this.z == null || this.z.isEmpty()) {
                return this.y != null && this.y.isEmpty() ? z : z;
            }
        }
        if (!this.w.contains(Integer.valueOf(id))) {
            if (!this.x.contains(view)) {
                if (this.y != null && this.y.contains(u.J(view))) {
                    return true;
                }
                if (this.z != null) {
                    while (this.y < this.z.size()) {
                        if ((Class)this.z.get(i).isInstance(view)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public void Q(View view) {
        a aVar;
        int i;
        Object item;
        View view2;
        ArrayList list;
        if (!this.R) {
            aVar = o.A();
            int i2 = 1;
            i = aVar.size() - i2;
            while (i >= 0) {
                item = aVar.n(i);
                i = i - 1;
            }
            if (this.S != null && this.S.size() > 0) {
                Object clone = this.S.clone();
                i = 0;
                while (i < clone.size()) {
                    (o.f)clone.get(i).onTransitionPause(this);
                    i = i + 1;
                }
            }
            this.Q = true;
        }
    }

    void R(ViewGroup viewGroup) {
        int i;
        Object obj2;
        int i2 = 0;
        boolean running;
        View view;
        View view2;
        d.u.u uVar;
        d.u.u uVar2;
        this.L = new ArrayList();
        this.M = new ArrayList();
        P(this.H, this.I);
        a aVar = o.A();
        i2 = 1;
        i = aVar.size() - i2;
        while (this.I >= 0) {
            Object obj = aVar.j(i);
            i = i - 1;
        }
        this.o(viewGroup, this.H, this.I, this.L, this.M);
        W();
    }

    public o S(o.f fVar) {
        if (this.S == null) {
            return this;
        }
        this.S.remove(fVar);
        if (this.S.size() == 0) {
            this.S = null;
        }
        return this;
    }

    public o T(View view) {
        this.x.remove(view);
        return this;
    }

    public void U(View view) {
        boolean z;
        int i;
        Object item;
        View view2;
        ArrayList list;
        if (this.Q) {
            boolean z2 = false;
            if (!this.R) {
                a aVar = o.A();
                i = aVar.size() - 1;
                while (i >= 0) {
                    item = aVar.n(i);
                    i = i - 1;
                }
                if (this.S != null && this.S.size() > 0) {
                    Object clone = this.S.clone();
                    i = z2;
                    while (i < clone.size()) {
                        (o.f)clone.get(i).onTransitionResume(this);
                        i = i + 1;
                    }
                }
            }
            this.Q = z2;
        }
    }

    protected void W() {
        f0();
        a aVar = o.A();
        Iterator it = this.T.iterator();
        while (it.hasNext()) {
            Object item = it.next();
        }
        this.T.clear();
        p();
    }

    void X(boolean z) {
        this.N = z;
    }

    public o Y(long j) {
        this.c = j;
        return this;
    }

    public void Z(o.e eVar) {
        this.V = eVar;
    }

    public o a(o.f fVar) {
        if (this.S == null) {
            this.S = new ArrayList();
        }
        this.S.add(fVar);
        return this;
    }

    public o a0(TimeInterpolator timeInterpolator) {
        this.v = timeInterpolator;
        return this;
    }

    public o b(View view) {
        this.x.add(view);
        return this;
    }

    public void b0(g gVar) {
        if (gVar == null) {
            this.X = o.Z;
        } else {
            this.X = gVar;
        }
    }

    public void c0(r rVar) {
        this.U = rVar;
    }

    protected void cancel() {
        int i;
        Object item;
        int i2 = 0;
        Object item2;
        i = this.O.size() - 1;
        while (this.O >= 0) {
            (Animator)this.O.get(i).cancel();
            i = i - 1;
        }
        if (this.S != null && this.S.size() > 0) {
            Object clone = this.S.clone();
            i2 = 0;
            while (i2 < clone.size()) {
                (o.f)clone.get(i2).onTransitionCancel(this);
                i2 = i2 + 1;
            }
        }
    }

    protected void e(Animator animator) {
        long startDelay = 0;
        if (animator == null) {
            p();
        } else {
            long l = s();
            startDelay = 0L;
            if (l >= startDelay) {
                animator.setDuration(s());
            }
            long l3 = B();
            if (l3 >= startDelay) {
                animator.setStartDelay(B() + animator.getStartDelay());
            }
            if (v() != null) {
                animator.setInterpolator(v());
            }
            animator.addListener(new o.c(this));
            animator.start();
        }
    }

    public o e0(long j) {
        this.b = j;
        return this;
    }

    protected void f0() {
        ArrayList list;
        int size;
        int i2;
        Object item;
        if (this.P == 0) {
            boolean z = false;
            if (this.S != null && this.S.size() > 0) {
                Object clone = this.S.clone();
                i2 = z;
                while (i2 < clone.size()) {
                    (o.f)clone.get(i2).onTransitionStart(this);
                    i2 = i2 + 1;
                }
            }
            this.R = z;
        }
        this.P++;
    }

    String g0(String str) {
        int size2;
        long l = -1;
        int size4;
        String str3;
        String str4;
        StringBuilder stringBuilder2 = new StringBuilder();
        String simpleName = getClass().getSimpleName();
        String str5 = "@";
        String str6 = Integer.toHexString(hashCode());
        String str7 = ": ";
        str3 = str + simpleName + str5 + str6 + str7;
        l = -1L;
        str2 = ") ";
        if (this.c != l) {
            StringBuilder stringBuilder3 = new StringBuilder();
            String str8 = "dur(";
            str3 = str3 + str8 + this.c + str2;
        }
        if (this.b != l) {
            StringBuilder stringBuilder4 = new StringBuilder();
            String str9 = "dly(";
            str3 = str3 + str9 + this.b + str2;
        }
        if (this.v != null) {
            StringBuilder stringBuilder9 = new StringBuilder();
            String str12 = "interp(";
            str3 = str3 + str12 + this.v + str2;
        }
        if (this.w.size() <= 0) {
            if (this.x.size() > 0) {
                StringBuilder stringBuilder5 = new StringBuilder();
                String str10 = "tgts(";
                str4 = str3 + str10;
                str2 = ", ";
                size2 = 0;
                if (this.w.size() > 0) {
                    while (this.c < this.w.size()) {
                        StringBuilder stringBuilder = new StringBuilder();
                        Object item2 = this.w.get(size2);
                        str4 = str4 + item2;
                        size2 = size2 + 1;
                    }
                }
                if (this.x.size() > 0) {
                    while (this.b < this.x.size()) {
                        StringBuilder stringBuilder7 = new StringBuilder();
                        Object item = this.x.get(size2);
                        str4 = str4 + item;
                        size2 = size2 + 1;
                    }
                }
                StringBuilder stringBuilder8 = new StringBuilder();
                String str11 = ")";
                str3 = str4 + str11;
            }
        }
        return str3;
    }

    void h(u uVar) {
        int i = 0;
        boolean key;
        Object obj;
        String str;
        if (this.U != null) {
            if (!uVar.a.isEmpty()) {
                String[] strArr = this.U.b();
                if (strArr == null) {
                    return;
                }
                i = 0;
                for (String str : strArr) {
                    if (!uVar.a.containsKey(str)) {
                        break;
                    }
                }
                i = 1;
                if (i == 0) {
                    this.U.a(uVar);
                }
            }
        }
    }

    void k(ViewGroup viewGroup, boolean z) {
        int size2;
        boolean empty;
        int size3;
        d.u.u uVar;
        d.u.v vVar;
        a aVar;
        d.u.v vVar2;
        l(z);
        size2 = 0;
        if (this.w.size() <= 0) {
            if (this.x.size() <= 0 || this.y != null) {
                g(viewGroup, z);
            } else {
                if (!(!this.y.isEmpty() || this.z != null)) {
                    if (this.z.isEmpty()) {
                        while (this.x < this.w.size()) {
                            View viewById = viewGroup.findViewById((Integer)this.w.get(size2).intValue());
                            size2 = size2 + 1;
                        }
                        while (size2 < this.x.size()) {
                            Object item = this.x.get(size2);
                            d.u.u uVar2 = new u(item);
                            uVar2.c.add(this);
                            h(uVar2);
                            size2 = size2 + 1;
                        }
                    }
                }
            }
        }
        if (!z && this.W != null) {
            size2 = this.W.size();
            ArrayList arrayList = new ArrayList(size2);
            while (this.x < this.W) {
                arrayList.add(this.H.d.remove((String)this.W.j(size2)));
                size2 = size2 + 1;
            }
            while (size2 < this.W) {
                Object item2 = arrayList.get(size2);
                size2 = size2 + 1;
            }
        }
    }

    void l(boolean z) {
        if (z) {
            this.H.a.clear();
            this.H.b.clear();
            this.H.c.b();
        } else {
            this.I.a.clear();
            this.I.b.clear();
            this.I.c.b();
        }
    }

    public o m() {
        final ArrayList list = null;
        try {
            final Object clone = super.clone();
            clone.T = new ArrayList();
            clone.H = new v();
            clone.I = new v();
            clone.L = list;
            clone.M = list;
        } catch (java.lang.CloneNotSupportedException unused) {
            return obj;
        }
        return clone;
    }

    protected void o(ViewGroup viewGroup, v vVar, v vVar2, ArrayList<u> arrayList, ArrayList<u> arrayList2) {
        long min = 9223372036854775807L;
        View view;
        d.u.u uVar = null;
        d.u.u uVar2;
        long l;
        int i = 0;
        d.u.u uVar3;
        boolean contains;
        Object obj;
        int i2 = 0;
        Object viewGroup2;
        int size2;
        int i3 = 0;
        Object vVar32;
        Animator animator;
        int i4 = 0;
        int i5 = 0;
        boolean equals2;
        int length2;
        String arrayList42;
        Object obj7;
        Object obj8;
        Object obj9;
        Object obj3;
        final Object viewGroup4 = this;
        viewGroup2 = viewGroup;
        final a aVar2 = o.A();
        final SparseIntArray sparseIntArray = new SparseIntArray();
        size2 = arrayList.size();
        min = Long.MAX_VALUE;
        i5 = 0;
        while (i5 < size2) {
            Object item2 = arrayList.get(i5);
            Object item3 = arrayList2.get(i5);
            i5 = i5 + 1;
        }
        if (sparseIntArray.size() != 0) {
            i4 = 0;
            while (i4 < sparseIntArray.size()) {
                Object item = viewGroup4.T.get(sparseIntArray.keyAt(i4));
                l = (long)sparseIntArray.valueAt(i4) - min + item.getStartDelay();
                item.setStartDelay(l);
                i4 = i4 + 1;
            }
        }
    }

    protected void p() {
        int i2;
        int i;
        int size;
        int i5;
        Object item;
        final int i7 = 1;
        this.P -= i7;
        if (this.P == 0) {
            boolean z = false;
            if (this.S != null && this.S.size() > 0) {
                Object clone = this.S.clone();
                i5 = z;
                while (i5 < clone.size()) {
                    (o.f)clone.get(i5).onTransitionEnd(this);
                    i5 = i5 + 1;
                }
            }
            i2 = z;
            while (this.P < this.H.c.n()) {
                Object obj2 = this.H.c.o(i2);
                i2 = i2 + 1;
            }
            while (this.P < this.I.c.n()) {
                Object obj = this.I.c.o(i);
                i = i + 1;
            }
            this.R = true;
        }
    }

    void r(ViewGroup viewGroup) {
        a aVar;
        int size;
        View view;
        aVar = o.A();
        size = aVar.size();
    }

    public long s() {
        return this.c;
    }

    public Rect t() {
        if (this.V == null) {
            return null;
        }
        return this.V.a(this);
    }

    @Override // java.lang.Object
    public String toString() {
        return g0("");
    }

    public o.e u() {
        return this.V;
    }

    public TimeInterpolator v() {
        return this.v;
    }

    u w(View view, boolean z) {
        ArrayList list;
        int i = 0;
        int i2 = -1;
        View view3;
        ArrayList list2;
        if (this.J != null) {
            return this.J.w(view, z);
        }
        ArrayList r0 = z ? this.L : this.M;
        i = 0;
        if (this.J == null) {
            return null;
        }
        i2 = -1;
        i2 = 0;
        while (i2 < list.size()) {
            Object item = list.get(i2);
            if (item.b == view) {
                break;
            }
        }
        if (i2 >= 0 && z) {
        }
        return i;
    }

    public String x() {
        return this.a;
    }

    public g y() {
        return this.X;
    }

    public r z() {
        return this.U;
    }

    public String[] G() {
        return null;
    }

    o d0(ViewGroup viewGroup) {
        return this;
    }

    public abstract void f(u uVar);

    public abstract void j(u uVar);

    public Animator n(ViewGroup viewGroup, u uVar, u uVar2) {
        return null;
    }
}
