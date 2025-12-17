package androidx.fragment.app;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.b;
import d.h.l.r;
import d.h.l.u;
import d.h.l.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class z {

    class a implements Runnable {

        final int a;
        final ArrayList b;
        final ArrayList c;
        final ArrayList v;
        final ArrayList w;
        a(androidx.fragment.app.z z, int i2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, ArrayList arrayList6) {
            this.a = i2;
            this.b = arrayList3;
            this.c = arrayList4;
            this.v = arrayList5;
            this.w = arrayList6;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Object obj2;
            Object obj;
            i = 0;
            while (i < this.a) {
                u.B0((View)this.b.get(i), (String)this.c.get(i));
                u.B0((View)this.v.get(i), (String)this.w.get(i));
                i++;
            }
        }
    }

    class b implements Runnable {

        final ArrayList a;
        final Map b;
        b(androidx.fragment.app.z z, ArrayList arrayList2, Map map3) {
            this.a = arrayList2;
            this.b = map3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Object obj;
            String str;
            Map map;
            i = 0;
            while (i < this.a.size()) {
                obj = this.a.get(i);
                str = u.J((View)obj);
                if (str != null) {
                }
                i++;
                u.B0(obj, z.i(this.b, str));
            }
        }
    }

    class c implements Runnable {

        final ArrayList a;
        final Map b;
        c(androidx.fragment.app.z z, ArrayList arrayList2, Map map3) {
            this.a = arrayList2;
            this.b = map3;
            super();
        }

        @Override // java.lang.Runnable
        public void run() {
            int i;
            Object obj2;
            Object obj;
            Map map;
            i = 0;
            while (i < this.a.size()) {
                obj2 = this.a.get(i);
                u.B0(obj2, (String)this.b.get(u.J((View)obj2)));
                i++;
            }
        }
    }
    protected static void d(List<View> list, View view2) {
        String str;
        boolean childCount;
        int i;
        View childAt;
        boolean z;
        int obj7;
        final int size = list.size();
        if (z.h(list, view2, size)) {
        }
        if (u.J(view2) != null) {
            list.add(view2);
        }
        obj7 = size;
        while (obj7 < list.size()) {
            str = list.get(obj7);
            if (str instanceof ViewGroup) {
            }
            obj7++;
            i = 0;
            while (i < (ViewGroup)(View)str.getChildCount()) {
                childAt = str.getChildAt(i);
                if (!z.h(list, childAt, size) && u.J(childAt) != null) {
                }
                i++;
                if (u.J(childAt) != null) {
                }
                list.add(childAt);
            }
            childAt = str.getChildAt(i);
            if (!z.h(list, childAt, size) && u.J(childAt) != null) {
            }
            i++;
            if (u.J(childAt) != null) {
            }
            list.add(childAt);
        }
    }

    private static boolean h(List<View> list, View view2, int i3) {
        int i;
        Object obj;
        final int i2 = 0;
        i = i2;
        while (i < i3) {
            i++;
        }
        return i2;
    }

    static String i(Map<String, String> map, String string2) {
        Object next;
        boolean equals;
        Iterator obj2 = map.entrySet().iterator();
        for (Map.Entry next : obj2) {
        }
        return null;
    }

    protected static boolean l(List list) {
        int obj0;
        if (list != null) {
            if (list.isEmpty()) {
                obj0 = 1;
            } else {
                obj0 = 0;
            }
        } else {
        }
        return obj0;
    }

    public abstract void A(Object object, ArrayList<View> arrayList2, ArrayList<View> arrayList3);

    public abstract Object B(Object object);

    public abstract void a(Object object, View view2);

    public abstract void b(Object object, ArrayList<View> arrayList2);

    public abstract void c(ViewGroup viewGroup, Object object2);

    public abstract boolean e(Object object);

    void f(ArrayList<View> arrayList, View view2) {
        int childCount;
        int i;
        View childAt;
        if (view2.getVisibility() == 0) {
            if (view2 instanceof ViewGroup) {
                if (w.a((ViewGroup)view2)) {
                    arrayList.add(view2);
                } else {
                    i = 0;
                    while (i < view2.getChildCount()) {
                        f(arrayList, view2.getChildAt(i));
                        i++;
                    }
                }
            } else {
                arrayList.add(view2);
            }
        }
    }

    public abstract Object g(Object object);

    void j(Map<String, View> map, View view2) {
        int childCount;
        int i;
        View childAt;
        String str = u.J(view2);
        if (view2.getVisibility() == 0 && str != null) {
            str = u.J(view2);
            if (str != null) {
                map.put(str, view2);
            }
            if (view2 instanceof ViewGroup) {
                i = 0;
                while (i < (ViewGroup)view2.getChildCount()) {
                    j(map, view2.getChildAt(i));
                    i++;
                }
            }
        }
    }

    protected void k(View view, Rect rect2) {
        android.view.ViewParent parent;
        float f;
        int i;
        if (!u.Q(view)) {
        }
        RectF rectF = new RectF();
        i = 0;
        rectF.set(i, i, (float)width, (float)height);
        view.getMatrix().mapRect(rectF);
        rectF.offset((float)left, (float)top2);
        parent = view.getParent();
        while (parent instanceof View != null) {
            rectF.offset((float)i5, (float)i6);
            parent.getMatrix().mapRect(rectF);
            rectF.offset((float)left2, (float)top3);
            parent = parent.getParent();
        }
        int[] iArr = new int[2];
        view.getRootView().getLocationOnScreen(iArr);
        rectF.offset((float)obj5, (float)i3);
        rect2.set(Math.round(rectF.left), Math.round(rectF.top), Math.round(rectF.right), Math.round(rectF.bottom));
    }

    public abstract Object m(Object object, Object object2, Object object3);

    public abstract Object n(Object object, Object object2, Object object3);

    ArrayList<String> o(ArrayList<View> arrayList) {
        int i2;
        Object obj;
        int i;
        ArrayList arrayList2 = new ArrayList();
        i2 = 0;
        while (i2 < arrayList.size()) {
            obj = arrayList.get(i2);
            arrayList2.add(u.J((View)obj));
            u.B0(obj, 0);
            i2++;
        }
        return arrayList2;
    }

    public abstract void p(Object object, View view2);

    public abstract void q(Object object, ArrayList<View> arrayList2, ArrayList<View> arrayList3);

    public abstract void r(Object object, View view2, ArrayList<View> arrayList3);

    void s(ViewGroup viewGroup, ArrayList<View> arrayList2, Map<String, String> map3) {
        z.c cVar = new z.c(this, arrayList2, map3);
        r.a(viewGroup, cVar);
    }

    public abstract void t(Object object, Object object2, ArrayList<View> arrayList3, Object object4, ArrayList<View> arrayList5, Object object6, ArrayList<View> arrayList7);

    public abstract void u(Object object, Rect rect2);

    public abstract void v(Object object, View view2);

    public void w(androidx.fragment.app.Fragment fragment, Object object2, b b3, Runnable runnable4) {
        runnable4.run();
    }

    void x(View view, ArrayList<View> arrayList2, Map<String, String> map3) {
        z.b bVar = new z.b(this, arrayList2, map3);
        r.a(view, bVar);
    }

    void y(View view, ArrayList<View> arrayList2, ArrayList<View> arrayList3, ArrayList<String> arrayList4, Map<String, String> map5) {
        int i2;
        Object obj;
        String str;
        int i;
        boolean equals;
        final int size = arrayList3.size();
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        i2 = i3;
        while (i2 < size) {
            obj = arrayList2.get(i2);
            str = u.J((View)obj);
            arrayList.add(str);
            if (str == null) {
            } else {
            }
            u.B0(obj, 0);
            i = i3;
            while (i < size) {
                if ((String)map5.get(str).equals(arrayList4.get(i))) {
                    break loop_5;
                } else {
                }
                i++;
            }
            i2++;
            if (obj.equals(arrayList4.get(i))) {
            } else {
            }
            i++;
            u.B0((View)arrayList3.get(i), str);
        }
        super(this, size, arrayList3, arrayList4, arrayList2, arrayList);
        r.a(view, obj13);
    }

    public abstract void z(Object object, View view2, ArrayList<View> arrayList3);
}
