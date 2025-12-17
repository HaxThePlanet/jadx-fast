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

/* loaded from: classes.dex */
public abstract class o implements java.lang.Cloneable {

    private static final int[] Y;
    private static final d.u.g Z;
    private static java.lang.ThreadLocal<a<Animator, d.u.o.d>> a0;
    private ArrayList<Integer> A = null;
    private ArrayList<View> B = null;
    private ArrayList<Class<?>> C = null;
    private ArrayList<String> D = null;
    private ArrayList<Integer> E = null;
    private ArrayList<View> F = null;
    private ArrayList<Class<?>> G = null;
    private d.u.v H;
    private d.u.v I;
    d.u.s J = null;
    private int[] K;
    private ArrayList<d.u.u> L;
    private ArrayList<d.u.u> M;
    boolean N = false;
    ArrayList<Animator> O;
    private int P = 0;
    private boolean Q = false;
    private boolean R = false;
    private ArrayList<d.u.o.f> S = null;
    private ArrayList<Animator> T;
    d.u.r U;
    private d.u.o.e V;
    private a<String, String> W;
    private d.u.g X;
    private String a;
    private long b = -1;
    long c = -1;
    private TimeInterpolator v = null;
    ArrayList<Integer> w;
    ArrayList<View> x;
    private ArrayList<String> y = null;
    private ArrayList<Class<?>> z = null;

    class b extends AnimatorListenerAdapter {

        final a a;
        final d.u.o b;
        b(d.u.o o, a a2) {
            this.b = o;
            this.a = a2;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            oVar.O.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            oVar.O.add(animator);
        }
    }

    class c extends AnimatorListenerAdapter {

        final d.u.o a;
        c(d.u.o o) {
            this.a = o;
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
        d.u.u c;
        d.u.q0 d;
        d.u.o e;
        d(View view, String string2, d.u.o o3, d.u.q0 q04, d.u.u u5) {
            super();
            this.a = view;
            this.b = string2;
            this.c = u5;
            this.d = q04;
            this.e = o3;
        }
    }

    public static abstract class e {
        public abstract Rect a(d.u.o o);
    }

    public interface f {
        public abstract void onTransitionCancel(d.u.o o);

        public abstract void onTransitionEnd(d.u.o o);

        public abstract void onTransitionPause(d.u.o o);

        public abstract void onTransitionResume(d.u.o o);

        public abstract void onTransitionStart(d.u.o o);
    }

    static class a extends d.u.g {
        @Override // d.u.g
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }
    static {
        int[] iArr = new int[4];
        iArr = new int[]{2, 1, 3, 4};
        o.Y = iArr;
        o.a aVar = new o.a();
        o.Z = aVar;
        ThreadLocal threadLocal = new ThreadLocal();
        o.a0 = threadLocal;
    }

    public o() {
        super();
        this.a = getClass().getName();
        int i = -1;
        int i2 = 0;
        ArrayList arrayList2 = new ArrayList();
        this.w = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.x = arrayList3;
        v vVar = new v();
        this.H = vVar;
        v vVar2 = new v();
        this.I = vVar2;
        this.K = o.Y;
        int i3 = 0;
        ArrayList arrayList4 = new ArrayList();
        this.O = arrayList4;
        ArrayList arrayList = new ArrayList();
        this.T = arrayList;
        this.X = o.Z;
    }

    private static a<Animator, d.u.o.d> A() {
        Object aVar;
        java.lang.ThreadLocal threadLocal;
        if ((a)o.a0.get() == null) {
            aVar = new a();
            o.a0.set(aVar);
        }
        return aVar;
    }

    private static boolean K(d.u.u u, d.u.u u2, String string3) {
        Object obj0;
        int obj2;
        obj0 = u.a.get(string3);
        Object obj1 = u2.a.get(string3);
        if (obj0 == null && obj1 == null) {
            if (obj1 == null) {
                obj2 = 0;
            } else {
                if (obj0 != null) {
                    if (obj1 == null) {
                    } else {
                        obj2 ^= obj0;
                    }
                }
            }
        } else {
        }
        return obj2;
    }

    private void L(a<View, d.u.u> a, a<View, d.u.u> a2, SparseArray<View> sparseArray3, SparseArray<View> sparseArray4) {
        int i;
        Object valueAt;
        boolean z;
        boolean z2;
        Object obj;
        ArrayList list;
        i = 0;
        while (i < sparseArray3.size()) {
            valueAt = sparseArray3.valueAt(i);
            z = sparseArray4.get(sparseArray3.keyAt(i));
            z2 = a.get(valueAt);
            obj = a2.get(z);
            if (valueAt != null && J((View)valueAt) && z != null && J((View)z) && (u)z2 != null && (u)obj != null) {
            }
            i++;
            if (J(valueAt)) {
            }
            z = sparseArray4.get(sparseArray3.keyAt(i));
            if ((View)z != null) {
            }
            if (J((View)z)) {
            }
            z2 = a.get(valueAt);
            obj = a2.get(z);
            if ((u)(u)z2 != null) {
            }
            if ((u)(u)obj != null) {
            }
            this.L.add((u)(u)z2);
            this.M.add((u)(u)obj);
            a.remove(valueAt);
            a2.remove(z);
        }
    }

    private void M(a<View, d.u.u> a, a<View, d.u.u> a2) {
        int i;
        Object remove;
        boolean z;
        ArrayList list;
        size--;
        while (i >= 0) {
            remove = a.j(i);
            remove = a2.remove(remove);
            if (remove != null && J((View)remove) && (u)remove != null && J(remove.b)) {
            }
            i--;
            if (J(remove)) {
            }
            remove = a2.remove(remove);
            if ((u)(u)remove != null) {
            }
            if (J(remove.b)) {
            }
            this.L.add((u)a.l(i));
            this.M.add((u)(u)remove);
        }
    }

    private void N(a<View, d.u.u> a, a<View, d.u.u> a2, d<View> d3, d<View> d4) {
        int i;
        Object obj;
        boolean z2;
        boolean z;
        Object obj2;
        ArrayList list;
        i = 0;
        while (i < d3.n()) {
            obj = d3.o(i);
            z2 = d4.f(d3.j(i));
            z = a.get(obj);
            obj2 = a2.get(z2);
            if (obj != null && J((View)obj) && z2 != null && J((View)z2) && (u)z != null && (u)obj2 != null) {
            }
            i++;
            if (J(obj)) {
            }
            z2 = d4.f(d3.j(i));
            if ((View)z2 != null) {
            }
            if (J((View)z2)) {
            }
            z = a.get(obj);
            obj2 = a2.get(z2);
            if ((u)(u)z != null) {
            }
            if ((u)(u)obj2 != null) {
            }
            this.L.add((u)(u)z);
            this.M.add((u)(u)obj2);
            a.remove(obj);
            a2.remove(z2);
        }
    }

    private void O(a<View, d.u.u> a, a<View, d.u.u> a2, a<String, View> a3, a<String, View> a4) {
        int i;
        Object obj2;
        boolean z;
        boolean z2;
        Object obj;
        ArrayList list;
        i = 0;
        while (i < a3.size()) {
            obj2 = a3.n(i);
            z = a4.get(a3.j(i));
            z2 = a.get(obj2);
            obj = a2.get(z);
            if (obj2 != null && J((View)obj2) && z != null && J((View)z) && (u)z2 != null && (u)obj != null) {
            }
            i++;
            if (J(obj2)) {
            }
            z = a4.get(a3.j(i));
            if ((View)z != null) {
            }
            if (J((View)z)) {
            }
            z2 = a.get(obj2);
            obj = a2.get(z);
            if ((u)(u)z2 != null) {
            }
            if ((u)(u)obj != null) {
            }
            this.L.add((u)(u)z2);
            this.M.add((u)(u)obj);
            a.remove(obj2);
            a2.remove(z);
        }
    }

    private void P(d.u.v v, d.u.v v2) {
        int i;
        a aVar;
        a aVar2;
        a aVar3 = new a(v.a);
        a aVar5 = new a(v2.a);
        i = 0;
        int[] iArr = this.K;
        while (i < iArr.length) {
            aVar = iArr[i];
            if (aVar != 1) {
            } else {
            }
            M(aVar3, aVar5);
            i++;
            iArr = this.K;
            if (aVar != 2) {
            } else {
            }
            O(aVar3, aVar5, v.d, v2.d);
            if (aVar != 3) {
            } else {
            }
            L(aVar3, aVar5, v.b, v2.b);
            if (aVar != 4) {
            } else {
            }
            N(aVar3, aVar5, v.c, v2.c);
        }
        c(aVar3, aVar5);
    }

    private void V(Animator animator, a<Animator, d.u.o.d> a2) {
        d.u.o.b bVar;
        if (animator != null) {
            bVar = new o.b(this, a2);
            animator.addListener(bVar);
            e(animator);
        }
    }

    private void c(a<View, d.u.u> a, a<View, d.u.u> a2) {
        int i2;
        int i3;
        Object obj;
        int i;
        boolean z;
        Object obj6;
        i3 = i2;
        i = 0;
        while (i3 < a.size()) {
            obj = a.n(i3);
            if (J(obj.b)) {
            }
            i3++;
            i = 0;
            this.L.add((u)obj);
            this.M.add(i);
        }
        while (i2 < a2.size()) {
            obj6 = a2.n(i2);
            if (J(obj6.b)) {
            }
            i2++;
            this.M.add((u)obj6);
            this.L.add(i);
        }
    }

    private static void d(d.u.v v, View view2, d.u.u u3) {
        SparseArray itemIdAtPosition;
        Object obj3;
        Object obj4;
        boolean obj5;
        v.a.put(view2, u3);
        obj5 = view2.getId();
        int i = 0;
        if (obj5 >= 0) {
            if (v.b.indexOfKey(obj5) >= 0) {
                v.b.put(obj5, i);
            } else {
                v.b.put(obj5, view2);
            }
        }
        obj5 = u.J(view2);
        if (obj5 != null) {
            if (v.d.containsKey(obj5)) {
                v.d.put(obj5, i);
            } else {
                v.d.put(obj5, view2);
            }
        }
        obj5 = view2.getParent();
        if (obj5 instanceof ListView != null && (ListView)obj5.getAdapter().hasStableIds()) {
            obj5 = view2.getParent();
            if ((ListView)obj5.getAdapter().hasStableIds()) {
                itemIdAtPosition = obj5.getItemIdAtPosition(obj5.getPositionForView(view2));
                if (v.c.h(itemIdAtPosition) >= 0) {
                    obj4 = v.c.f(itemIdAtPosition);
                    if ((View)obj4 != null) {
                        u.u0((View)obj4, false);
                        v.c.k(itemIdAtPosition, obj2);
                    }
                } else {
                    u.u0(view2, true);
                    v.c.k(itemIdAtPosition, obj2);
                }
            }
        }
    }

    private void g(View view, boolean z2) {
        int childCount;
        ArrayList contains2;
        ArrayList childAt;
        ArrayList contains;
        ArrayList contains3;
        ArrayList size;
        boolean uVar;
        ArrayList list;
        Integer valueOf;
        int i;
        int instance;
        boolean instance2;
        if (view == null) {
        }
        childCount = view.getId();
        contains = this.A;
        if (contains != null && contains.contains(Integer.valueOf(childCount))) {
            if (contains.contains(Integer.valueOf(childCount))) {
            }
        }
        contains3 = this.B;
        if (contains3 != null && contains3.contains(view)) {
            if (contains3.contains(view)) {
            }
        }
        size = this.C;
        i = 0;
        if (size != null) {
            instance = i;
            while (instance < size.size()) {
                instance++;
            }
        }
        if (parent instanceof ViewGroup) {
            uVar = new u(view);
            if (z2) {
                j(uVar);
            } else {
                f(uVar);
            }
            uVar.c.add(this);
            h(uVar);
            if (z2) {
                o.d(this.H, view, uVar);
            } else {
                o.d(this.I, view, uVar);
            }
        }
        list = this.E;
        if (view instanceof ViewGroup && list != null && list.contains(Integer.valueOf(childCount))) {
            list = this.E;
            if (list != null) {
                if (list.contains(Integer.valueOf(childCount))) {
                }
            }
            contains2 = this.F;
            if (contains2 != null && contains2.contains(view)) {
                if (contains2.contains(view)) {
                }
            }
            childAt = this.G;
            if (childAt != null) {
                list = i;
                while (list < childAt.size()) {
                    list++;
                }
            }
            while (i < (ViewGroup)view.getChildCount()) {
                g(view.getChildAt(i), z2);
                i++;
            }
        }
    }

    @Override // java.lang.Cloneable
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

    @Override // java.lang.Cloneable
    public String[] G() {
        return null;
    }

    @Override // java.lang.Cloneable
    public d.u.u H(View view, boolean z2) {
        d.u.v obj3;
        final d.u.s sVar = this.J;
        if (sVar != null) {
            return sVar.H(view, z2);
        }
        obj3 = z2 ? this.H : this.I;
        return (u)obj3.a.get(view);
    }

    @Override // java.lang.Cloneable
    public boolean I(d.u.u u, d.u.u u2) {
        int i;
        String[] iterator;
        int length;
        int i2;
        boolean z;
        if (u != null && u2 != null) {
            if (u2 != null) {
                iterator = G();
                if (iterator != null) {
                    i2 = i;
                    while (i2 < iterator.length) {
                        if (o.K(u, u2, iterator[i2])) {
                            break;
                        } else {
                        }
                        i2++;
                    }
                } else {
                    iterator = u.a.keySet().iterator();
                    while (iterator.hasNext()) {
                        if (o.K(u, u2, (String)iterator.next())) {
                            break;
                        } else {
                        }
                    }
                }
            }
        }
        return i;
    }

    @Override // java.lang.Cloneable
    boolean J(View view) {
        ArrayList contains2;
        int list;
        boolean contains;
        ArrayList contains3;
        ArrayList contains5;
        ArrayList size;
        ArrayList contains4;
        ArrayList empty;
        Object instance;
        Integer valueOf;
        boolean instance2;
        int id = view.getId();
        contains3 = this.A;
        final int i = 0;
        if (contains3 != null && contains3.contains(Integer.valueOf(id))) {
            if (contains3.contains(Integer.valueOf(id))) {
                return i;
            }
        }
        contains5 = this.B;
        if (contains5 != null && contains5.contains(view)) {
            if (contains5.contains(view)) {
                return i;
            }
        }
        size = this.C;
        if (size != null) {
            valueOf = i;
            while (valueOf < size.size()) {
                valueOf++;
            }
        }
        if (this.D != null && u.J(view) != null && this.D.contains(u.J(view))) {
            if (u.J(view) != null) {
                if (this.D.contains(u.J(view))) {
                    return i;
                }
            }
        }
        int i2 = 1;
        if (this.w.size() == 0 && this.x.size() == 0) {
            if (this.x.size() == 0) {
                empty = this.z;
                if (empty != null) {
                    empty = this.y;
                    if (empty.isEmpty() && empty != null && empty.isEmpty()) {
                        empty = this.y;
                        if (empty != null) {
                            if (empty.isEmpty()) {
                            }
                        }
                    }
                } else {
                }
                return i2;
            }
        }
        if (!this.w.contains(Integer.valueOf(id))) {
            if (this.x.contains(view)) {
            } else {
                contains2 = this.y;
                if (contains2 != null && contains2.contains(u.J(view))) {
                    if (contains2.contains(u.J(view))) {
                        return i2;
                    }
                }
                if (this.z != null) {
                    list = i;
                    while (list < this.z.size()) {
                        list++;
                    }
                }
            }
            return i;
        }
        return i2;
    }

    @Override // java.lang.Cloneable
    public void Q(View view) {
        boolean size;
        int i2;
        int i;
        Object equals;
        View view2;
        Object obj6;
        if (!this.R) {
            size = o.A();
            i = 1;
            size2 -= i;
            while (i2 >= 0) {
                equals = size.n(i2);
                if (equals.a != null && f0.d(view).equals(equals.d)) {
                }
                i2--;
                if (obj6.equals(equals.d)) {
                }
                a.b((Animator)size.j(i2));
            }
            obj6 = this.S;
            if (obj6 != null && obj6.size() > 0) {
                if (obj6.size() > 0) {
                    obj6 = this.S.clone();
                    i2 = 0;
                    while (i2 < (ArrayList)obj6.size()) {
                        (o.f)obj6.get(i2).onTransitionPause(this);
                        i2++;
                    }
                }
            }
            this.Q = i;
        }
    }

    @Override // java.lang.Cloneable
    void R(ViewGroup viewGroup) {
        int i;
        Object obj;
        Object running;
        View equals;
        View view;
        d.u.u uVar;
        d.u.u uVar2;
        ArrayList arrayList = new ArrayList();
        this.L = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.M = arrayList2;
        P(this.H, this.I);
        a aVar = o.A();
        final int i2 = 1;
        size -= i2;
        while (i >= 0) {
            obj = aVar.j(i);
            running = aVar.get((Animator)obj);
            view = running.a;
            uVar = H(view, i2);
            if (obj != null && (o.d)running != null && running.a != null && f0.d(viewGroup).equals(running.d) && uVar == null && w(view, i2) == null) {
            }
            i--;
            running = aVar.get(obj);
            if ((o.d)(o.d)running != null) {
            }
            if (running.a != null) {
            }
            if (q0Var.equals(running.d)) {
            }
            view = running.a;
            uVar = H(view, i2);
            if (uVar == null) {
            }
            if (uVar == null) {
            } else {
            }
            if (running.e.I(running.c, uVar2)) {
            } else {
            }
            running = 0;
            if (running != 0) {
            }
            if (!obj.isRunning()) {
            } else {
            }
            obj.cancel();
            if (obj.isStarted()) {
            } else {
            }
            aVar.remove(obj);
            running = i2;
            if (uVar2 != null && running.e.I(equals, uVar2)) {
            } else {
            }
            if (w(view, i2) == null) {
            }
            uVar2 = view;
        }
        this.o(viewGroup, this.H, this.I, this.L, this.M);
        W();
    }

    @Override // java.lang.Cloneable
    public d.u.o S(d.u.o.f o$f) {
        int obj2;
        final ArrayList list = this.S;
        if (list == null) {
            return this;
        }
        list.remove(f);
        if (this.S.size() == 0) {
            this.S = 0;
        }
        return this;
    }

    @Override // java.lang.Cloneable
    public d.u.o T(View view) {
        this.x.remove(view);
        return this;
    }

    @Override // java.lang.Cloneable
    public void U(View view) {
        boolean size;
        int i2;
        int i;
        Object equals;
        View view2;
        View obj6;
        i2 = 0;
        if (this.Q && !this.R) {
            i2 = 0;
            if (!this.R) {
                size = o.A();
                size2--;
                while (i >= 0) {
                    equals = size.n(i);
                    if (equals.a != null && f0.d(view).equals(equals.d)) {
                    }
                    i--;
                    if (obj6.equals(equals.d)) {
                    }
                    a.c((Animator)size.j(i));
                }
                obj6 = this.S;
                if (obj6 != null && obj6.size() > 0) {
                    if (obj6.size() > 0) {
                        obj6 = this.S.clone();
                        i = i2;
                        while (i < (ArrayList)obj6.size()) {
                            (o.f)obj6.get(i).onTransitionResume(this);
                            i++;
                        }
                    }
                }
            }
            this.Q = i2;
        }
    }

    @Override // java.lang.Cloneable
    protected void W() {
        Object next;
        boolean key;
        f0();
        a aVar = o.A();
        Iterator iterator = this.T.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            if (aVar.containsKey((Animator)next)) {
            }
            f0();
            V(next, aVar);
        }
        this.T.clear();
        p();
    }

    @Override // java.lang.Cloneable
    void X(boolean z) {
        this.N = z;
    }

    @Override // java.lang.Cloneable
    public d.u.o Y(long l) {
        this.c = l;
        return this;
    }

    @Override // java.lang.Cloneable
    public void Z(d.u.o.e o$e) {
        this.V = e;
    }

    @Override // java.lang.Cloneable
    public d.u.o a(d.u.o.f o$f) {
        ArrayList arrayList;
        if (this.S == null) {
            arrayList = new ArrayList();
            this.S = arrayList;
        }
        this.S.add(f);
        return this;
    }

    @Override // java.lang.Cloneable
    public d.u.o a0(TimeInterpolator timeInterpolator) {
        this.v = timeInterpolator;
        return this;
    }

    @Override // java.lang.Cloneable
    public d.u.o b(View view) {
        this.x.add(view);
        return this;
    }

    @Override // java.lang.Cloneable
    public void b0(d.u.g g) {
        d.u.g obj1;
        if (g == null) {
            this.X = o.Z;
        } else {
            this.X = g;
        }
    }

    @Override // java.lang.Cloneable
    public void c0(d.u.r r) {
        this.U = r;
    }

    @Override // java.lang.Cloneable
    protected void cancel() {
        int i;
        ArrayList clone;
        Object size;
        int i2;
        Object obj;
        size2--;
        while (i >= 0) {
            (Animator)this.O.get(i).cancel();
            i--;
        }
        clone = this.S;
        if (clone != null && clone.size() > 0) {
            if (clone.size() > 0) {
                clone = this.S.clone();
                i2 = 0;
                while (i2 < (ArrayList)clone.size()) {
                    (o.f)clone.get(i2).onTransitionCancel(this);
                    i2++;
                }
            }
        }
    }

    @Override // java.lang.Cloneable
    public Object clone() {
        return m();
    }

    @Override // java.lang.Cloneable
    d.u.o d0(ViewGroup viewGroup) {
        return this;
    }

    @Override // java.lang.Cloneable
    protected void e(Animator animator) {
        int cmp2;
        int cmp;
        TimeInterpolator time;
        d.u.o.c cVar;
        int startDelay;
        if (animator == null) {
            p();
        } else {
            startDelay = 0;
            if (Long.compare(l, startDelay) >= 0) {
                animator.setDuration(s());
            }
            if (Long.compare(l2, startDelay) >= 0) {
                animator.setStartDelay(l3 += startDelay);
            }
            if (v() != null) {
                animator.setInterpolator(v());
            }
            cVar = new o.c(this);
            animator.addListener(cVar);
            animator.start();
        }
    }

    @Override // java.lang.Cloneable
    public d.u.o e0(long l) {
        this.b = l;
        return this;
    }

    @Override // java.lang.Cloneable
    public abstract void f(d.u.u u);

    @Override // java.lang.Cloneable
    protected void f0() {
        int clone;
        int i;
        int size;
        int i2;
        Object obj;
        clone = this.S;
        i = 0;
        if (this.P == 0 && clone != null && clone.size() > 0) {
            clone = this.S;
            i = 0;
            if (clone != null) {
                if (clone.size() > 0) {
                    clone = this.S.clone();
                    i2 = i;
                    while (i2 < (ArrayList)clone.size()) {
                        (o.f)clone.get(i2).onTransitionStart(this);
                        i2++;
                    }
                }
            }
            this.R = i;
        }
        this.P = i3++;
    }

    @Override // java.lang.Cloneable
    String g0(String string) {
        int stringBuilder4;
        int stringBuilder2;
        Object stringBuilder5;
        int stringBuilder6;
        int size;
        int stringBuilder3;
        String str;
        int i;
        int stringBuilder;
        long l;
        String obj7;
        StringBuilder stringBuilder7 = new StringBuilder();
        stringBuilder7.append(string);
        stringBuilder7.append(getClass().getSimpleName());
        stringBuilder7.append("@");
        stringBuilder7.append(Integer.toHexString(hashCode()));
        stringBuilder7.append(": ");
        i = -1;
        str = ") ";
        if (Long.compare(l2, i) != 0) {
            stringBuilder4 = new StringBuilder();
            stringBuilder4.append(stringBuilder7.toString());
            stringBuilder4.append("dur(");
            stringBuilder4.append(this.c);
            stringBuilder4.append(str);
            obj7 = stringBuilder4.toString();
        }
        if (Long.compare(l3, i) != 0) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(obj7);
            stringBuilder2.append("dly(");
            stringBuilder2.append(this.b);
            stringBuilder2.append(str);
            obj7 = stringBuilder2.toString();
        }
        if (this.v != null) {
            stringBuilder5 = new StringBuilder();
            stringBuilder5.append(obj7);
            stringBuilder5.append("interp(");
            stringBuilder5.append(this.v);
            stringBuilder5.append(str);
            obj7 = stringBuilder5.toString();
        }
        if (this.w.size() <= 0) {
            StringBuilder stringBuilder8 = new StringBuilder();
            stringBuilder8.append(obj7);
            stringBuilder8.append("tgts(");
            obj7 = stringBuilder8.toString();
            str = ", ";
            if (this.x.size() > 0 && this.w.size() > 0) {
                stringBuilder8 = new StringBuilder();
                stringBuilder8.append(obj7);
                stringBuilder8.append("tgts(");
                obj7 = stringBuilder8.toString();
                str = ", ";
                if (this.w.size() > 0) {
                    size = i;
                    while (size < this.w.size()) {
                        if (size > 0) {
                        }
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(obj7);
                        stringBuilder.append(this.w.get(size));
                        obj7 = stringBuilder.toString();
                        size++;
                        stringBuilder = new StringBuilder();
                        stringBuilder.append(obj7);
                        stringBuilder.append(str);
                        obj7 = stringBuilder.toString();
                    }
                }
                if (this.x.size() > 0) {
                }
                stringBuilder6 = new StringBuilder();
                stringBuilder6.append(obj7);
                stringBuilder6.append(")");
                obj7 = stringBuilder6.toString();
            }
        } else {
        }
        return obj7;
    }

    @Override // java.lang.Cloneable
    void h(d.u.u u) {
        d.u.r empty;
        int i2;
        int i;
        boolean length;
        String str;
        empty = this.U.b();
        if (this.U != null && !u.a.isEmpty() && empty == null) {
            if (!u.a.isEmpty()) {
                empty = this.U.b();
                if (empty == null) {
                }
                i = i2;
                for (Object str : obj0) {
                }
                i2 = 1;
                if (i2 == 0) {
                    this.U.a(u);
                }
            }
        }
    }

    @Override // java.lang.Cloneable
    public abstract void j(d.u.u u);

    @Override // java.lang.Cloneable
    void k(ViewGroup viewGroup, boolean z2) {
        int empty;
        int i;
        int i2;
        int viewById;
        d.u.u uVar;
        d.u.v vVar;
        int obj6;
        boolean obj7;
        l(z2);
        i2 = 0;
        if (this.w.size() <= 0) {
            if (this.x.size() > 0) {
                empty = this.y;
                if (empty != null) {
                    if (empty.isEmpty()) {
                        empty = this.z;
                        if (empty != null) {
                            if (empty.isEmpty()) {
                                i = i2;
                                while (i < this.w.size()) {
                                    viewById = viewGroup.findViewById((Integer)this.w.get(i).intValue());
                                    if (viewById != null) {
                                    }
                                    i++;
                                    uVar = new u(viewById);
                                    if (z2) {
                                    } else {
                                    }
                                    f(uVar);
                                    uVar.c.add(this);
                                    h(uVar);
                                    if (z2) {
                                    } else {
                                    }
                                    o.d(this.I, viewById, uVar);
                                    o.d(this.H, viewById, uVar);
                                    j(uVar);
                                }
                                obj6 = i2;
                                while (obj6 < this.x.size()) {
                                    i = this.x.get(obj6);
                                    viewById = new u((View)i);
                                    if (z2) {
                                    } else {
                                    }
                                    f(viewById);
                                    viewById.c.add(this);
                                    h(viewById);
                                    if (z2) {
                                    } else {
                                    }
                                    o.d(this.I, i, viewById);
                                    obj6++;
                                    o.d(this.H, i, viewById);
                                    j(viewById);
                                }
                            } else {
                                g(viewGroup, z2);
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        obj6 = this.W;
        if (!z2 && obj6 != null) {
            obj6 = this.W;
            if (obj6 != null) {
                obj6 = obj6.size();
                obj7 = new ArrayList(obj6);
                empty = i2;
                while (empty < obj6) {
                    obj7.add(vVar2.d.remove((String)this.W.j(empty)));
                    empty++;
                }
                while (i2 < obj6) {
                    empty = obj7.get(i2);
                    if ((View)empty != 0) {
                    }
                    i2++;
                    vVar3.d.put((String)this.W.n(i2), (View)empty);
                }
            }
        }
    }

    @Override // java.lang.Cloneable
    void l(boolean z) {
        d obj1;
        if (z) {
            obj1.a.clear();
            obj1.b.clear();
            obj1.c.b();
        } else {
            obj1.a.clear();
            obj1.b.clear();
            obj1.c.b();
        }
    }

    @Override // java.lang.Cloneable
    public d.u.o m() {
        final int i = 0;
        final Object clone = super.clone();
        ArrayList arrayList = new ArrayList();
        clone.T = arrayList;
        v vVar = new v();
        clone.H = vVar;
        v vVar2 = new v();
        clone.I = vVar2;
        clone.L = i;
        clone.M = i;
        return (o)clone;
    }

    @Override // java.lang.Cloneable
    public Animator n(ViewGroup viewGroup, d.u.u u2, d.u.u u3) {
        return null;
    }

    protected void o(ViewGroup viewGroup, d.u.v v2, d.u.v v3, ArrayList<d.u.u> arrayList4, ArrayList<d.u.u> arrayList5) {
        long l;
        View view3;
        Object obj;
        int size;
        Object obj4;
        View view2;
        d.u.r size2;
        int contains;
        Object obj2;
        ViewGroup startDelay;
        int equals2;
        d.u.u uVar;
        int equals;
        String dVar;
        Object obj8;
        View view;
        int i;
        boolean z;
        int i2;
        Object obj3;
        final Object obj6 = this;
        startDelay = viewGroup;
        final a aVar2 = o.A();
        SparseIntArray sparseIntArray = new SparseIntArray();
        equals2 = arrayList4.size();
        l = Long.MAX_VALUE;
        equals = 0;
        while (equals < equals2) {
            obj = arrayList4.get(equals);
            obj4 = arrayList5.get(equals);
            if ((u)obj != null && !obj.c.contains(obj6)) {
            }
            if ((u)obj4 != null && !obj4.c.contains(obj6)) {
            }
            if (obj == null && obj4 == null) {
            } else {
            }
            if (obj != null && obj4 != null) {
            } else {
            }
            contains = 1;
            if (contains) {
            } else {
            }
            i = equals2;
            i2 = equals;
            equals = i2 + 1;
            equals2 = i;
            contains = obj6.n(startDelay, obj, obj4);
            if (contains) {
            } else {
            }
            if (obj4 != null) {
            } else {
            }
            i = equals2;
            i2 = equals;
            view = view2;
            equals2 = z;
            contains = 0;
            size2 = obj6.U;
            if (equals2 && size2 != null) {
            }
            size2 = obj6.U;
            if (size2 != null) {
            }
            super(view, x(), this, f0.d(viewGroup), contains);
            aVar2.put(equals2, dVar);
            obj6.T.add(equals2);
            l = uVar;
            obj = size2.c(startDelay, obj6, obj, obj4);
            sparseIntArray.put(obj6.T.size(), (int)obj);
            l = Math.min(obj, obj4);
            view = obj4.b;
            String[] strArr = G();
            if (strArr != null && strArr.length > 0) {
            } else {
            }
            i = equals2;
            i2 = equals;
            view2 = z;
            uVar = 0;
            equals2 = view2;
            contains = uVar;
            if (strArr.length > 0) {
            } else {
            }
            uVar = new u(view);
            i = equals2;
            if ((u)equals2.a.get(view) != null) {
            }
            i2 = equals;
            contains = 0;
            while (contains < aVar2.size()) {
                equals2 = aVar2.get((Animator)aVar2.j(contains));
                contains++;
            }
            view2 = z;
            equals2 = aVar2.get((Animator)aVar2.j(contains));
            if (equals2.c != null) {
            } else {
            }
            contains++;
            if (equals2.a == view) {
            } else {
            }
            if (equals2.b.equals(x())) {
            } else {
            }
            if (equals2.c.equals(uVar)) {
            } else {
            }
            view2 = 0;
            equals2 = 0;
            for (Object str : obj4) {
                uVar.a.put(strArr[equals2], obj2.a.get(str));
                obj8 = arrayList5;
                equals = i2;
                obj2 = obj3;
            }
            uVar.a.put(strArr[equals2], obj2.a.get(strArr[equals2]));
            equals2++;
            obj8 = arrayList5;
            equals = i2;
            obj2 = obj3;
            if (obj4 != null) {
            } else {
            }
            if (obj6.I(obj, obj4)) {
            } else {
            }
            contains = 0;
            if (obj4 == null) {
            } else {
            }
            if (!obj4.c.contains(obj6)) {
            }
            obj4 = 0;
            if (!obj.c.contains(obj6)) {
            }
            obj = 0;
        }
        if (sparseIntArray.size() != 0) {
            uVar = 0;
            while (uVar < sparseIntArray.size()) {
                size = obj6.T.get(sparseIntArray.keyAt(uVar));
                size.setStartDelay(i3 += startDelay);
                uVar++;
            }
        }
    }

    @Override // java.lang.Cloneable
    protected void p() {
        int i5;
        ArrayList clone;
        int i;
        int i2;
        int size;
        int i3;
        int i4;
        Object obj;
        final int i7 = 1;
        i6 -= i7;
        this.P = i5;
        clone = this.S;
        i2 = 0;
        if (i5 == 0 && clone != null && clone.size() > 0) {
            clone = this.S;
            i2 = 0;
            if (clone != null) {
                if (clone.size() > 0) {
                    clone = this.S.clone();
                    i4 = i2;
                    while (i4 < (ArrayList)clone.size()) {
                        (o.f)clone.get(i4).onTransitionEnd(this);
                        i4++;
                    }
                }
            }
            i = i2;
            while (i < vVar.c.n()) {
                size = vVar4.c.o(i);
                if ((View)size != 0) {
                }
                i++;
                u.u0((View)size, i2);
            }
            i5 = i2;
            while (i5 < vVar2.c.n()) {
                i3 = vVar3.c.o(i5);
                if ((View)i3 != 0) {
                }
                i5++;
                u.u0((View)i3, i2);
            }
            this.R = i7;
        }
    }

    @Override // java.lang.Cloneable
    void r(ViewGroup viewGroup) {
        a equals;
        int size;
        a aVar;
        View view;
        Object obj5;
        equals = o.A();
        size = equals.size();
        if (viewGroup != null) {
            if (size == 0) {
            } else {
                obj5 = f0.d(viewGroup);
                aVar = new a(equals);
                equals.clear();
                size--;
                while (size >= 0) {
                    equals = aVar.n(size);
                    if (equals.a != null && obj5 != null && obj5.equals(equals.d)) {
                    }
                    size--;
                    if (obj5 != null) {
                    }
                    if (obj5.equals(equals.d)) {
                    }
                    (Animator)aVar.j(size).end();
                }
            }
        }
    }

    @Override // java.lang.Cloneable
    public long s() {
        return this.c;
    }

    @Override // java.lang.Cloneable
    public Rect t() {
        d.u.o.e eVar = this.V;
        if (eVar == null) {
            return null;
        }
        return eVar.a(this);
    }

    @Override // java.lang.Cloneable
    public String toString() {
        return g0("");
    }

    @Override // java.lang.Cloneable
    public d.u.o.e u() {
        return this.V;
    }

    @Override // java.lang.Cloneable
    public TimeInterpolator v() {
        return this.v;
    }

    @Override // java.lang.Cloneable
    d.u.u w(View view, boolean z2) {
        ArrayList list;
        int i2;
        int i3;
        int i;
        View view2;
        ArrayList obj7;
        d.u.s sVar = this.J;
        if (sVar != null) {
            return sVar.w(view, z2);
        }
        list = z2 ? this.L : this.M;
        i2 = 0;
        if (list == null) {
            return i2;
        }
        i3 = -1;
        i = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            i++;
        }
        if (i3 >= 0) {
            obj7 = z2 ? this.M : this.L;
            i2 = obj7;
        }
        return i2;
    }

    @Override // java.lang.Cloneable
    public String x() {
        return this.a;
    }

    @Override // java.lang.Cloneable
    public d.u.g y() {
        return this.X;
    }

    @Override // java.lang.Cloneable
    public d.u.r z() {
        return this.U;
    }
}
