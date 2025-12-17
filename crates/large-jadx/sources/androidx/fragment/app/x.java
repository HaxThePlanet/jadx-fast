package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.app.p;
import androidx.core.os.b;
import d.e.a;
import d.e.g;
import d.h.l.r;
import d.h.l.u;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: classes.dex */
class x {

    private static final int[] a;
    static final androidx.fragment.app.z b = null;
    static final androidx.fragment.app.z c;

    class a implements Runnable {

        final androidx.fragment.app.x.g a;
        final androidx.fragment.app.Fragment b;
        final b c;
        a(androidx.fragment.app.x.g x$g, androidx.fragment.app.Fragment fragment2, b b3) {
            this.a = g;
            this.b = fragment2;
            this.c = b3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.c);
        }
    }

    class b implements Runnable {

        final ArrayList a;
        b(ArrayList arrayList) {
            this.a = arrayList;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            x.B(this.a, 4);
        }
    }

    class c implements Runnable {

        final androidx.fragment.app.x.g a;
        final androidx.fragment.app.Fragment b;
        final b c;
        c(androidx.fragment.app.x.g x$g, androidx.fragment.app.Fragment fragment2, b b3) {
            this.a = g;
            this.b = fragment2;
            this.c = b3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.a(this.b, this.c);
        }
    }

    class d implements Runnable {

        final Object a;
        final androidx.fragment.app.z b;
        final View c;
        final androidx.fragment.app.Fragment v;
        final ArrayList w;
        final ArrayList x;
        final ArrayList y;
        final Object z;
        d(Object object, androidx.fragment.app.z z2, View view3, androidx.fragment.app.Fragment fragment4, ArrayList arrayList5, ArrayList arrayList6, ArrayList arrayList7, Object object8) {
            this.a = object;
            this.b = z2;
            this.c = view3;
            this.v = fragment4;
            this.w = arrayList5;
            this.x = arrayList6;
            this.y = arrayList7;
            this.z = object8;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            Object arrayList;
            ArrayList list2;
            ArrayList list3;
            androidx.fragment.app.Fragment fragment;
            ArrayList list;
            View view;
            obj = this.a;
            if (obj != null) {
                this.b.p(obj, this.c);
                this.x.addAll(x.k(this.b, this.a, this.v, this.w, this.c));
            }
            if (this.y != null && this.z != null) {
                if (this.z != null) {
                    arrayList = new ArrayList();
                    arrayList.add(this.c);
                    this.b.q(this.z, this.y, arrayList);
                }
                this.y.clear();
                this.y.add(this.c);
            }
        }
    }

    class e implements Runnable {

        final androidx.fragment.app.Fragment a;
        final androidx.fragment.app.Fragment b;
        final boolean c;
        final a v;
        final View w;
        final androidx.fragment.app.z x;
        final Rect y;
        e(androidx.fragment.app.Fragment fragment, androidx.fragment.app.Fragment fragment2, boolean z3, a a4, View view5, androidx.fragment.app.z z6, Rect rect7) {
            this.a = fragment;
            this.b = fragment2;
            this.c = z3;
            this.v = a4;
            this.w = view5;
            this.x = z6;
            this.y = rect7;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object fragment;
            boolean z;
            x.f(this.a, this.b, this.c, this.v, false);
            View view = this.w;
            if (view != null) {
                this.x.k(view, this.y);
            }
        }
    }

    class f implements Runnable {

        final boolean A;
        final ArrayList B;
        final Object C;
        final Rect D;
        final androidx.fragment.app.z a;
        final a b;
        final Object c;
        final androidx.fragment.app.x.h v;
        final ArrayList w;
        final View x;
        final androidx.fragment.app.Fragment y;
        final androidx.fragment.app.Fragment z;
        f(androidx.fragment.app.z z, a a2, Object object3, androidx.fragment.app.x.h x$h4, ArrayList arrayList5, View view6, androidx.fragment.app.Fragment fragment7, androidx.fragment.app.Fragment fragment8, boolean z9, ArrayList arrayList10, Object object11, Rect rect12) {
            this.a = z;
            this.b = a2;
            this.c = object3;
            this.v = h4;
            this.w = arrayList5;
            this.x = view6;
            this.y = fragment7;
            this.z = fragment8;
            this.A = z9;
            this.B = arrayList10;
            this.C = object11;
            this.D = rect12;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            Object aVar2;
            Object aVar;
            Object obj2;
            Object obj;
            Object fragment;
            boolean z;
            int i;
            aVar2 = x.h(this.a, this.b, this.c, this.v);
            if (aVar2 != null) {
                this.w.addAll(aVar2.values());
                this.w.add(this.x);
            }
            x.f(this.y, this.z, this.A, aVar2, false);
            obj2 = this.c;
            this.a.A(obj2, this.B, this.w);
            aVar2 = x.t(aVar2, this.v, this.C, this.A);
            if (obj2 != null && aVar2 != null) {
                this.a.A(obj2, this.B, this.w);
                aVar2 = x.t(aVar2, this.v, this.C, this.A);
                if (aVar2 != null) {
                    this.a.k(aVar2, this.D);
                }
            }
        }
    }

    interface g {
        public abstract void a(androidx.fragment.app.Fragment fragment, b b2);

        public abstract void b(androidx.fragment.app.Fragment fragment, b b2);
    }

    static class h {

        public androidx.fragment.app.Fragment a;
        public boolean b;
        public androidx.fragment.app.a c;
        public androidx.fragment.app.Fragment d;
        public boolean e;
        public androidx.fragment.app.a f;
    }
    static {
        int[] iArr = new int[11];
        iArr = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
        x.a = iArr;
        if (Build.VERSION.SDK_INT >= 21) {
            y yVar = new y();
        }
        int i2 = 0;
        x.c = x.x();
    }

    private static void A(androidx.fragment.app.z z, Object object2, Object object3, a<String, View> a4, boolean z5, androidx.fragment.app.a a6) {
        ArrayList empty;
        Object obj4;
        Object obj5;
        empty = a6.n;
        if (empty != null && !empty.isEmpty()) {
            if (!empty.isEmpty()) {
                empty = 0;
                if (z5 != null) {
                    obj5 = a6.o.get(empty);
                } else {
                    obj5 = a6.n.get(empty);
                }
                obj4 = a4.get(obj5);
                z.v(object2, (View)obj4);
                if (object3 != null) {
                    z.v(object3, obj4);
                }
            }
        }
    }

    static void B(ArrayList<View> arrayList, int i2) {
        int i;
        Object obj;
        if (arrayList == null) {
        }
        size--;
        while (i >= 0) {
            (View)arrayList.get(i).setVisibility(i2);
            i--;
        }
    }

    static void C(Context context, androidx.fragment.app.g g2, ArrayList<androidx.fragment.app.a> arrayList3, ArrayList<Boolean> arrayList4, int i5, int i6, boolean z7, androidx.fragment.app.x.g x$g8) {
        int i;
        int size;
        Object obj;
        boolean booleanValue;
        a aVar;
        Object valueAt;
        boolean z;
        Context obj7;
        SparseArray sparseArray = new SparseArray();
        i = i5;
        while (i < i6) {
            obj = arrayList3.get(i);
            if ((Boolean)arrayList4.get(i).booleanValue()) {
            } else {
            }
            x.c((a)obj, sparseArray, z7);
            i++;
            x.e(obj, sparseArray, z7);
        }
        if (sparseArray.size() != 0) {
            size = new View(context);
            obj = 0;
            while (obj < sparseArray.size()) {
                booleanValue = sparseArray.keyAt(obj);
                aVar = x.d(booleanValue, arrayList3, arrayList4, i5, i6);
                valueAt = sparseArray.valueAt(obj);
                if (g2.d()) {
                }
                obj++;
                booleanValue = g2.c(booleanValue);
                if ((ViewGroup)booleanValue == null) {
                } else {
                }
                if (z7) {
                } else {
                }
                x.n((ViewGroup)booleanValue, (x.h)valueAt, size, aVar, g8);
                x.o(booleanValue, valueAt, size, aVar, g8);
            }
        }
    }

    private static void a(ArrayList<View> arrayList, a<String, View> a2, Collection<String> collection3) {
        int i;
        Object obj;
        boolean contains;
        size--;
        while (i >= 0) {
            obj = a2.n(i);
            if (collection3.contains(u.J((View)obj))) {
            }
            i--;
            arrayList.add(obj);
        }
    }

    private static void b(androidx.fragment.app.a a, androidx.fragment.app.w.a w$a2, SparseArray<androidx.fragment.app.x.h> sparseArray3, boolean z4, boolean z5) {
        int[] iArr;
        int i;
        int i2;
        int i5;
        int i4;
        int i3;
        Object obj;
        androidx.fragment.app.u uVar;
        androidx.fragment.app.v vVar;
        Object obj8;
        int obj9;
        final androidx.fragment.app.Fragment fragment = a2.b;
        if (fragment == null) {
        }
        final int mContainerId = fragment.mContainerId;
        if (mContainerId == 0) {
        }
        if (z4) {
            obj9 = x.a[a2.a];
        } else {
            obj9 = a2.a;
        }
        i = 0;
        i2 = 1;
        if (obj9 != i2) {
            if (obj9 != 3) {
                if (obj9 != 4) {
                    if (obj9 != 5) {
                        if (obj9 != 6) {
                            if (obj9 != 7) {
                                i4 = i2;
                            } else {
                                if (z5) {
                                    obj9 = fragment.mIsNewlyAdded;
                                } else {
                                    if (!fragment.mAdded && !fragment.mHidden) {
                                        obj9 = !fragment.mHidden ? i2 : i;
                                    } else {
                                    }
                                }
                                i = obj9;
                                obj9 = i4;
                            }
                        } else {
                            if (z5) {
                                obj9 = fragment.mView;
                                if (!fragment.mAdded && obj9 != null && obj9.getVisibility() == 0 && Float.compare(obj9, i3) >= 0) {
                                    obj9 = fragment.mView;
                                    if (obj9 != null) {
                                        if (obj9.getVisibility() == 0) {
                                            obj9 = Float.compare(obj9, i3) >= 0 ? i2 : i;
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                            i4 = obj9;
                            obj9 = i2;
                            i2 = i;
                        }
                    } else {
                        if (z5) {
                            if (fragment.mHiddenChanged && !fragment.mHidden && fragment.mAdded) {
                                if (!fragment.mHidden) {
                                    if (fragment.mAdded) {
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                            obj9 = fragment.mHidden;
                        }
                    }
                } else {
                    if (z5) {
                        if (fragment.mHiddenChanged && fragment.mAdded && fragment.mHidden) {
                            if (fragment.mAdded) {
                                if (fragment.mHidden) {
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                }
            } else {
            }
        } else {
        }
        if (i != 0) {
            obj = x.p((x.h)sparseArray3.get(mContainerId), sparseArray3, mContainerId);
            obj.a = fragment;
            obj.b = z4;
            obj.c = a;
        }
        int i6 = 0;
        if (!z5 && i2 != 0 && obj != null && obj.d == fragment) {
            if (i2 != 0) {
                if (obj != null) {
                    if (obj.d == fragment) {
                        obj.d = i6;
                    }
                }
                if (!a.p) {
                    i2 = a.r;
                    i2.u0().p(i2.x(fragment));
                    i2.U0(fragment);
                }
            }
        }
        if (i4 != 0) {
            if (obj != null) {
                if (obj.d == null) {
                    obj = x.p(obj, sparseArray3, mContainerId);
                    obj.d = fragment;
                    obj.e = z4;
                    obj.f = a;
                }
            } else {
            }
        }
        if (!z5 && obj9 != null && obj != null && obj.a == fragment) {
            if (obj9 != null) {
                if (obj != null) {
                    if (obj.a == fragment) {
                        obj.a = i6;
                    }
                }
            }
        }
    }

    public static void c(androidx.fragment.app.a a, SparseArray<androidx.fragment.app.x.h> sparseArray2, boolean z3) {
        int i;
        Object obj;
        final int i2 = 0;
        i = i2;
        while (i < a.a.size()) {
            x.b(a, (w.a)a.a.get(i), sparseArray2, i2, z3);
            i++;
        }
    }

    private static a<String, String> d(int i, ArrayList<androidx.fragment.app.a> arrayList2, ArrayList<Boolean> arrayList3, int i4, int i5) {
        Object obj2;
        boolean booleanValue;
        ArrayList size;
        int i2;
        Object obj;
        Object obj3;
        Object remove;
        ArrayList list;
        int obj13;
        a aVar = new a();
        i5--;
        while (obj13 >= i4) {
            obj2 = arrayList2.get(obj13);
            if (!(a)obj2.B(i)) {
            } else {
            }
            size = obj2.n;
            if (size != null) {
            }
            obj13--;
            if ((Boolean)arrayList3.get(obj13).booleanValue()) {
            } else {
            }
            booleanValue = list2;
            obj2 = list;
            i2 = 0;
            while (i2 < size.size()) {
                obj = obj2.get(i2);
                obj3 = booleanValue.get(i2);
                remove = aVar.remove((String)obj3);
                if ((String)remove != null) {
                } else {
                }
                aVar.put((String)obj, obj3);
                i2++;
                aVar.put(obj, (String)remove);
            }
            obj = obj2.get(i2);
            obj3 = booleanValue.get(i2);
            remove = aVar.remove((String)obj3);
            if ((String)remove != null) {
            } else {
            }
            aVar.put((String)obj, obj3);
            i2++;
            aVar.put(obj, (String)remove);
            booleanValue = obj2.n;
            obj2 = obj2.o;
        }
        return aVar;
    }

    public static void e(androidx.fragment.app.a a, SparseArray<androidx.fragment.app.x.h> sparseArray2, boolean z3) {
        int i;
        Object obj;
        if (!a.r.r0().d()) {
        }
        final int i2 = 1;
        size -= i2;
        while (i >= 0) {
            x.b(a, (w.a)a.a.get(i), sparseArray2, i2, z3);
            i--;
        }
    }

    static void f(androidx.fragment.app.Fragment fragment, androidx.fragment.app.Fragment fragment2, boolean z3, a<String, View> a4, boolean z5) {
        int i;
        int size;
        Object obj;
        p obj3;
        ArrayList obj4;
        ArrayList obj5;
        int obj6;
        if (z3 != null) {
            obj3 = fragment2.getEnterTransitionCallback();
        } else {
            obj3 = fragment.getEnterTransitionCallback();
        }
        if (obj3 != null) {
            obj4 = new ArrayList();
            obj5 = new ArrayList();
            if (a4 == 0) {
                size = i;
            } else {
                size = a4.size();
            }
            while (i < size) {
                obj5.add(a4.j(i));
                obj4.add(a4.n(i));
                i++;
            }
            obj6 = 0;
            if (z5) {
                obj3.f(obj5, obj4, obj6);
            } else {
                obj3.e(obj5, obj4, obj6);
            }
        }
    }

    private static boolean g(androidx.fragment.app.z z, List<Object> list2) {
        int i;
        boolean z2;
        final int i2 = 0;
        i = i2;
        while (i < list2.size()) {
            i++;
        }
        return 1;
    }

    static a<String, View> h(androidx.fragment.app.z z, a<String, String> a2, Object object3, androidx.fragment.app.x.h x$h4) {
        Object values;
        View view;
        boolean equals;
        ArrayList obj3;
        p obj6;
        values = h4.a;
        view = values.getView();
        if (!a2.isEmpty() && object3 != null) {
            if (object3 != null) {
                if (view == null) {
                } else {
                    a obj5 = new a();
                    z.j(obj5, view);
                    obj3 = h4.c;
                    if (h4.b) {
                        obj6 = values.getExitTransitionCallback();
                        obj3 = obj3.n;
                    } else {
                        obj6 = values.getEnterTransitionCallback();
                        obj3 = obj3.o;
                    }
                    if (obj3 != null) {
                        obj5.p(obj3);
                        obj5.p(a2.values());
                    }
                    if (obj6 != null) {
                        obj6.c(obj3, obj5);
                        obj6--;
                        while (obj6 >= 0) {
                            values = obj3.get(obj6);
                            view = obj5.get((String)values);
                            if ((View)view == null) {
                            } else {
                            }
                            values = x.q(a2, values);
                            if (!values.equals(u.J((View)view)) && values != null) {
                            }
                            obj6--;
                            values = x.q(a2, values);
                            if (values != null) {
                            }
                            a2.put(values, u.J(view));
                            values = x.q(a2, values);
                            if (values != null) {
                            }
                            a2.remove(values);
                        }
                    } else {
                        x.y(a2, obj5);
                    }
                }
                return obj5;
            }
        }
        a2.clear();
        return 0;
    }

    private static a<String, View> i(androidx.fragment.app.z z, a<String, String> a2, Object object3, androidx.fragment.app.x.h x$h4) {
        View requireView;
        boolean equals;
        ArrayList obj3;
        p obj5;
        boolean obj6;
        if (!a2.isEmpty()) {
            if (object3 == null) {
            } else {
                obj5 = h4.d;
                a aVar = new a();
                z.j(aVar, obj5.requireView());
                obj3 = h4.f;
                if (h4.e) {
                    obj5 = obj5.getEnterTransitionCallback();
                    obj3 = obj3.o;
                } else {
                    obj5 = obj5.getExitTransitionCallback();
                    obj3 = obj3.n;
                }
                if (obj3 != null) {
                    aVar.p(obj3);
                }
                if (obj5 != null) {
                    obj5.c(obj3, aVar);
                    obj5--;
                    while (obj5 >= 0) {
                        obj6 = obj3.get(obj5);
                        requireView = aVar.get((String)obj6);
                        if ((View)requireView == null) {
                        } else {
                        }
                        if (!obj6.equals(u.J((View)requireView))) {
                        }
                        obj5--;
                        a2.put(u.J(requireView), (String)a2.remove(obj6));
                        a2.remove(obj6);
                    }
                } else {
                    a2.p(aVar.keySet());
                }
            }
            return aVar;
        }
        a2.clear();
        return 0;
    }

    private static androidx.fragment.app.z j(androidx.fragment.app.Fragment fragment, androidx.fragment.app.Fragment fragment2) {
        ArrayList arrayList;
        Object returnTransition;
        Object obj2;
        arrayList = new ArrayList();
        Object exitTransition = fragment.getExitTransition();
        if (fragment != null && exitTransition != null) {
            exitTransition = fragment.getExitTransition();
            if (exitTransition != null) {
                arrayList.add(exitTransition);
            }
            returnTransition = fragment.getReturnTransition();
            if (returnTransition != null) {
                arrayList.add(returnTransition);
            }
            obj2 = fragment.getSharedElementReturnTransition();
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        }
        obj2 = fragment2.getEnterTransition();
        if (fragment2 != null && obj2 != null) {
            obj2 = fragment2.getEnterTransition();
            if (obj2 != null) {
                arrayList.add(obj2);
            }
            obj2 = fragment2.getReenterTransition();
            if (obj2 != null) {
                arrayList.add(obj2);
            }
            obj2 = fragment2.getSharedElementEnterTransition();
            if (obj2 != null) {
                arrayList.add(obj2);
            }
        }
        int obj3 = 0;
        if (arrayList.isEmpty()) {
            return obj3;
        }
        obj2 = x.b;
        if (obj2 != null && x.g(obj2, arrayList)) {
            if (x.g(obj2, arrayList)) {
                return obj2;
            }
        }
        androidx.fragment.app.z zVar = x.c;
        if (zVar != null && x.g(zVar, arrayList)) {
            if (x.g(zVar, arrayList)) {
                return zVar;
            }
        }
        if (obj2 != null) {
        } else {
            if (zVar != null) {
            } else {
                return obj3;
            }
        }
        obj2 = new IllegalArgumentException("Invalid Transition types");
        throw obj2;
    }

    static ArrayList<View> k(androidx.fragment.app.z z, Object object2, androidx.fragment.app.Fragment fragment3, ArrayList<View> arrayList4, View view5) {
        int arrayList;
        boolean obj3;
        if (object2 != null) {
            arrayList = new ArrayList();
            obj3 = fragment3.getView();
            if (obj3 != null) {
                z.f(arrayList, obj3);
            }
            if (arrayList4 != null) {
                arrayList.removeAll(arrayList4);
            }
            if (!arrayList.isEmpty()) {
                arrayList.add(view5);
                z.b(object2, arrayList);
            }
        } else {
            arrayList = 0;
        }
        return arrayList;
    }

    private static Object l(androidx.fragment.app.z z, ViewGroup viewGroup2, View view3, a<String, String> a4, androidx.fragment.app.x.h x$h5, ArrayList<View> arrayList6, ArrayList<View> arrayList7, Object object8, Object object9) {
        androidx.fragment.app.z i2;
        int i3;
        int i4;
        boolean values;
        boolean z2;
        androidx.fragment.app.a aVar2;
        a aVar;
        int i;
        Rect rect;
        androidx.fragment.app.a aVar3;
        androidx.fragment.app.z zVar2 = z;
        Object obj = h5;
        ArrayList list2 = arrayList6;
        Object obj2 = object8;
        androidx.fragment.app.Fragment fragment2 = obj.a;
        androidx.fragment.app.Fragment fragment4 = obj.d;
        i2 = 0;
        if (fragment2 != null) {
            if (fragment4 == null) {
            } else {
                boolean z4 = obj.b;
                if (a4.isEmpty()) {
                    aVar = a4;
                    i3 = i2;
                } else {
                    i3 = x.u(zVar2, fragment2, fragment4, z4);
                    aVar = a4;
                }
                a aVar6 = x.i(zVar2, aVar, i3, obj);
                if (a4.isEmpty()) {
                    i = i2;
                } else {
                    list2.addAll(aVar6.values());
                    i = i3;
                }
                if (obj2 == null && object9 == null && i == 0) {
                    if (object9 == null) {
                        if (i == 0) {
                            return i2;
                        }
                    }
                }
                x.f(fragment2, fragment4, z4, aVar6, true);
                if (i != 0) {
                    rect = new Rect();
                    zVar2.z(i, view3, list2);
                    x.A(z, i, object9, aVar6, obj.e, obj.f);
                    if (obj2 != null) {
                        zVar2.u(obj2, rect);
                    }
                } else {
                    rect = i2;
                }
            }
            super(z, a4, i, h5, arrayList7, view3, fragment2, fragment4, z4, arrayList6, object8, rect);
            r.a(viewGroup2, fVar2);
            return i;
        }
        return i2;
    }

    private static Object m(androidx.fragment.app.z z, ViewGroup viewGroup2, View view3, a<String, String> a4, androidx.fragment.app.x.h x$h5, ArrayList<View> arrayList6, ArrayList<View> arrayList7, Object object8, Object object9) {
        Object rect;
        Object values;
        View i;
        Object list;
        Object list2;
        View requireView;
        boolean i5;
        int i2;
        int i4;
        View view;
        Rect rect2;
        int i3;
        androidx.fragment.app.z zVar2 = z;
        rect = view3;
        values = a4;
        Object obj = h5;
        list = arrayList6;
        list2 = arrayList7;
        Object obj2 = object8;
        final androidx.fragment.app.Fragment fragment3 = obj.a;
        final androidx.fragment.app.Fragment fragment4 = obj.d;
        if (fragment3 != null) {
            fragment3.requireView().setVisibility(0);
        }
        i5 = 0;
        if (fragment3 != null) {
            if (fragment4 == null) {
            } else {
                final boolean z3 = obj.b;
                if (a4.isEmpty()) {
                    i4 = i5;
                } else {
                    i4 = x.u(z, fragment3, fragment4, z3);
                }
                final a aVar3 = x.i(z, values, i4, obj);
                final a aVar4 = x.h(z, values, i4, obj);
                if (a4.isEmpty()) {
                    if (aVar3 != null) {
                        aVar3.clear();
                    }
                    if (aVar4 != null) {
                        aVar4.clear();
                    }
                    i3 = i5;
                } else {
                    x.a(list, aVar3, a4.keySet());
                    x.a(list2, aVar4, a4.values());
                    i3 = i4;
                }
                if (obj2 == null && object9 == null && i3 == 0) {
                    if (object9 == null) {
                        if (i3 == 0) {
                            return i5;
                        }
                    }
                }
                x.f(fragment3, fragment4, z3, aVar3, true);
                if (i3 != 0) {
                    list2.add(rect);
                    z.z(i3, rect, list);
                    x.A(z, i3, object9, aVar3, obj.e, obj.f);
                    rect = new Rect();
                    i = x.t(aVar4, obj, obj2, z3);
                    if (i != null) {
                        z.u(obj2, rect);
                    }
                    rect2 = rect;
                    view = i;
                } else {
                    rect2 = view;
                }
            }
            super(fragment3, fragment4, z3, aVar4, view, z, rect2);
            r.a(viewGroup2, eVar2);
            return i3;
        }
        return i5;
    }

    private static void n(ViewGroup viewGroup, androidx.fragment.app.x.h x$h2, View view3, a<String, String> a4, androidx.fragment.app.x.g x$g5) {
        Object obj;
        int bVar;
        ViewGroup empty;
        Object cVar;
        int i;
        Object obj4;
        Object fragment;
        boolean z;
        Object obj3;
        ArrayList list;
        Object obj2;
        Object arrayList;
        ViewGroup view4 = viewGroup;
        Object obj10 = h2;
        final View view5 = view3;
        final java.util.Map map = a4;
        arrayList = g5;
        final androidx.fragment.app.Fragment fragment3 = obj10.a;
        final androidx.fragment.app.Fragment fragment4 = obj10.d;
        androidx.fragment.app.z zVar3 = x.j(fragment4, fragment3);
        if (zVar3 == null) {
        }
        Object obj8 = x.r(zVar3, fragment3, obj10.b);
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList list6 = arrayList2;
        Object obj12 = obj7;
        androidx.fragment.app.z zVar4 = zVar3;
        obj3 = x.l(zVar3, viewGroup, view3, a4, h2, arrayList3, list6, obj8, obj12);
        obj2 = obj13;
        if (obj2 == null && obj3 == null) {
            if (obj3 == null) {
                if (obj12 == null) {
                }
            } else {
                obj = obj12;
            }
        } else {
        }
        list = list7;
        ArrayList list8 = x.k(zVar4, obj, fragment4, list, view5);
        if (list8 != null) {
            if (list8.isEmpty()) {
                obj = 0;
            }
        } else {
        }
        int i3 = obj;
        zVar4.a(obj2, view5);
        Object obj11 = x.v(zVar4, obj2, i3, obj3, fragment3, obj10.b);
        if (fragment4 != null && list8 != null) {
            if (list8 != null) {
                if (list8.size() <= 0) {
                    if (list.size() > 0) {
                        bVar = new b();
                        arrayList.b(fragment4, bVar);
                        cVar = new x.c(arrayList, fragment4, bVar);
                        zVar4.w(fragment4, obj11, bVar, cVar);
                    }
                } else {
                }
            }
        }
        if (obj11 != null) {
            arrayList = new ArrayList();
            androidx.fragment.app.z zVar2 = zVar4;
            zVar2.t(obj11, obj2, arrayList, i3, list8, obj3, list6);
            x.z(zVar2, viewGroup, fragment3, view3, list6, obj2, arrayList, i3, list8);
            bVar = viewGroup;
            cVar = zVar4;
            i = list6;
            cVar.x(bVar, i, map);
            cVar.c(bVar, obj11);
            cVar.s(bVar, i, map);
        }
    }

    private static void o(ViewGroup viewGroup, androidx.fragment.app.x.h x$h2, View view3, a<String, String> a4, androidx.fragment.app.x.g x$g5) {
        androidx.fragment.app.z bVar;
        Object obj2;
        Object aVar;
        Object obj3;
        Object fragment2;
        boolean z;
        Object obj4;
        Object obj;
        Object fragment;
        Object obj7 = h2;
        View view4 = view3;
        androidx.fragment.app.x.g gVar = g5;
        androidx.fragment.app.Fragment fragment3 = obj7.a;
        fragment = obj7.d;
        final androidx.fragment.app.z zVar3 = x.j(fragment, fragment3);
        if (zVar3 == null) {
        }
        boolean z3 = obj7.b;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList = new ArrayList();
        Object obj10 = x.r(zVar3, fragment3, z3);
        final Object obj18 = obj9;
        ArrayList list7 = arrayList;
        Object obj12 = x.m(zVar3, viewGroup, view3, a4, h2, arrayList, arrayList2, obj10, obj18);
        obj4 = obj14;
        if (obj4 == null && obj12 == null) {
            if (obj12 == null) {
                if (obj18 == null) {
                }
            } else {
                obj = obj18;
            }
        } else {
        }
        ArrayList list6 = x.k(zVar3, obj4, fragment3, arrayList2, view4);
        x.B(list6, 4);
        ArrayList list8 = list3;
        Object obj13 = x.v(zVar3, obj4, obj, obj12, fragment3, z3);
        if (fragment != null && list8 != null) {
            if (list8 != null) {
                if (list8.size() <= 0) {
                    if (list7.size() > 0) {
                        bVar = new b();
                        obj2 = g5;
                        obj2.b(fragment, bVar);
                        aVar = new x.a(obj2, fragment, bVar);
                        zVar3.w(fragment, obj13, bVar, aVar);
                    }
                } else {
                }
            }
        }
        if (obj13 != null) {
            x.w(zVar3, obj, fragment, list8);
            androidx.fragment.app.z zVar2 = zVar3;
            zVar2.t(obj13, obj4, list6, obj, list8, obj12, arrayList2);
            obj2 = viewGroup;
            zVar3.c(obj2, obj13);
            zVar2.y(obj2, list7, arrayList2, zVar3.o(arrayList2), a4);
            x.B(list6, 0);
            zVar3.A(obj12, list7, arrayList2);
        }
    }

    private static androidx.fragment.app.x.h p(androidx.fragment.app.x.h x$h, SparseArray<androidx.fragment.app.x.h> sparseArray2, int i3) {
        androidx.fragment.app.x.h obj0;
        if (h == null) {
            obj0 = new x.h();
            sparseArray2.put(i3, obj0);
        }
        return obj0;
    }

    static String q(a<String, String> a, String string2) {
        int i;
        boolean equals;
        i = 0;
        while (i < a.size()) {
            i++;
        }
        return null;
    }

    private static Object r(androidx.fragment.app.z z, androidx.fragment.app.Fragment fragment2, boolean z3) {
        Object obj1;
        if (fragment2 == null) {
            return null;
        }
        if (z3) {
            obj1 = fragment2.getReenterTransition();
        } else {
            obj1 = fragment2.getEnterTransition();
        }
        return z.g(obj1);
    }

    private static Object s(androidx.fragment.app.z z, androidx.fragment.app.Fragment fragment2, boolean z3) {
        Object obj1;
        if (fragment2 == null) {
            return null;
        }
        if (z3) {
            obj1 = fragment2.getReturnTransition();
        } else {
            obj1 = fragment2.getExitTransition();
        }
        return z.g(obj1);
    }

    static View t(a<String, View> a, androidx.fragment.app.x.h x$h2, Object object3, boolean z4) {
        Object obj1;
        ArrayList obj2;
        obj1 = h2.c;
        obj2 = obj1.n;
        if (object3 != null && a != null && obj2 != null && !obj2.isEmpty()) {
            if (a != null) {
                obj2 = obj1.n;
                if (obj2 != null) {
                    if (!obj2.isEmpty()) {
                        obj2 = 0;
                        if (z4) {
                            obj1 = obj1.n.get(obj2);
                        } else {
                            obj1 = obj1.o.get(obj2);
                        }
                        return (View)a.get(obj1);
                    }
                }
            }
        }
        return null;
    }

    private static Object u(androidx.fragment.app.z z, androidx.fragment.app.Fragment fragment2, androidx.fragment.app.Fragment fragment3, boolean z4) {
        Object obj1;
        if (fragment2 != null) {
            if (fragment3 == null) {
            } else {
                if (z4) {
                    obj1 = fragment3.getSharedElementReturnTransition();
                } else {
                    obj1 = fragment2.getSharedElementEnterTransition();
                }
            }
            return z.B(z.g(obj1));
        }
        return null;
    }

    private static Object v(androidx.fragment.app.z z, Object object2, Object object3, Object object4, androidx.fragment.app.Fragment fragment5, boolean z6) {
        Object obj0;
        int obj4;
        if (object2 != null && object3 != null && fragment5 != null) {
            if (object3 != null) {
                if (fragment5 != null) {
                    if (z6) {
                        obj4 = fragment5.getAllowReturnTransitionOverlap();
                    } else {
                        obj4 = fragment5.getAllowEnterTransitionOverlap();
                    }
                } else {
                    obj4 = 1;
                }
            } else {
            }
        } else {
        }
        if (obj4 != null) {
            obj0 = z.n(object3, object2, object4);
        } else {
            obj0 = z.m(object3, object2, object4);
        }
        return obj0;
    }

    private static void w(androidx.fragment.app.z z, Object object2, androidx.fragment.app.Fragment fragment3, ArrayList<View> arrayList4) {
        boolean mHiddenChanged;
        ViewGroup obj1;
        Object obj2;
        if (fragment3 != null && object2 != null && fragment3.mAdded && fragment3.mHidden && fragment3.mHiddenChanged) {
            if (object2 != null) {
                if (fragment3.mAdded) {
                    if (fragment3.mHidden) {
                        if (fragment3.mHiddenChanged) {
                            fragment3.setHideReplaced(true);
                            z.r(object2, fragment3.getView(), arrayList4);
                            obj2 = new x.b(arrayList4);
                            r.a(fragment3.mContainer, obj2);
                        }
                    }
                }
            }
        }
    }

    private static androidx.fragment.app.z x() {
        try {
            int i2 = 0;
            return (z)Class.forName("d.u.e").getDeclaredConstructor(new Class[i2]).newInstance(new Object[i2]);
            return null;
        }
    }

    static void y(a<String, String> a, a<String, View> a2) {
        int i;
        boolean key;
        size--;
        while (i >= 0) {
            if (!a2.containsKey((String)a.n(i))) {
            }
            i--;
            a.l(i);
        }
    }

    private static void z(androidx.fragment.app.z z, ViewGroup viewGroup2, androidx.fragment.app.Fragment fragment3, View view4, ArrayList<View> arrayList5, Object object6, ArrayList<View> arrayList7, Object object8, ArrayList<View> arrayList9) {
        super(object6, z, view4, fragment3, arrayList5, arrayList7, arrayList9, object8);
        View view = viewGroup2;
        r.a(viewGroup2, dVar2);
    }
}
