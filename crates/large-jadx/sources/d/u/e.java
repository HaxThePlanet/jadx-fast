package d.u;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.z;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FragmentTransitionSupport.java */
/* loaded from: classes.dex */
public class e extends z {

    class a extends o.e {

        final /* synthetic */ Rect a;
        a(Rect rect) {
            this.a = rect;
            super();
        }

        @Override // d.u.o$e
        public Rect a(o oVar) {
            return this.a;
        }
    }

    class b implements o.f {

        final /* synthetic */ View a;
        final /* synthetic */ ArrayList b;
        b(View view, ArrayList list) {
            this.a = view;
            this.b = list;
            super();
        }

        public void onTransitionEnd(o oVar) {
            int i;
            oVar.S(this);
            this.a.setVisibility(8);
            i = 0;
            while (i < this.b.size()) {
                (View)this.b.get(i).setVisibility(i);
                i = i + 1;
            }
        }

        public void onTransitionCancel(o oVar) {
        }

        public void onTransitionPause(o oVar) {
        }

        public void onTransitionResume(o oVar) {
        }

        public void onTransitionStart(o oVar) {
        }
    }

    class d extends o.e {

        final /* synthetic */ Rect a;
        d(Rect rect) {
            this.a = rect;
            super();
        }

        @Override // d.u.o$e
        public Rect a(o oVar) {
            return null;
        }
    }

    class c extends p {

        final /* synthetic */ Object a;
        final /* synthetic */ ArrayList b;
        final /* synthetic */ Object c;
        final /* synthetic */ ArrayList d;
        final /* synthetic */ Object e;
        final /* synthetic */ ArrayList f;
        final /* synthetic */ e g;
        c(Object object, ArrayList list, Object object2, ArrayList list2, Object object3, ArrayList list3) {
            this.g = eVar;
            this.a = object;
            this.b = list;
            this.c = object2;
            this.d = list2;
            this.e = object3;
            this.f = list3;
            super();
        }

        @Override // d.u.p
        public void onTransitionEnd(o oVar) {
            oVar.S(this);
        }

        @Override // d.u.p
        public void onTransitionStart(o oVar) {
            d.u.e eVar;
            ArrayList list;
            final ArrayList list2 = null;
            if (this.a != null) {
                this.g.q(this.a, this.b, list2);
            }
            if (this.c != null) {
                this.g.q(this.c, this.d, list2);
            }
            if (this.e != null) {
                this.g.q(this.e, this.f, list2);
            }
        }
    }
    private static boolean C(o oVar) {
        boolean z;
        boolean z3 = false;
        if (z.l(oVar.C())) {
            if (z.l(oVar.D())) {
                if (!z.l(oVar.E())) {
                    int i2 = 1;
                } else {
                    int i = 0;
                }
            }
        }
        return z3;
    }

    @Override // androidx.fragment.app.z
    public void A(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (object != null) {
            object.F().clear();
            object.F().addAll(arrayList2);
            q(object, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.z
    public Object B(Object object) {
        if (object == null) {
            return null;
        }
        final d.u.s sVar = new s();
        sVar.k0(object);
        return sVar;
    }

    @Override // androidx.fragment.app.z
    public void a(Object object, View view) {
        if (object != null) {
            object.b(view);
        }
    }

    @Override // androidx.fragment.app.z
    public void b(Object object, ArrayList<View> arrayList) {
        int i = 0;
        d.u.o oVar;
        Object item;
        if (object == null) {
            return;
        }
        i = 0;
        if (object instanceof s) {
            while (i < object.o0()) {
                b(object.n0(i), arrayList);
                i = i + 1;
            }
        } else {
            if (!e.C(object)) {
                if (z.l(object.F())) {
                    while (i < arrayList.size()) {
                        object.b((View)arrayList.get(i));
                        i = i + 1;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.z
    public void c(ViewGroup viewGroup, Object object) {
        q.a(viewGroup, object);
    }

    @Override // androidx.fragment.app.z
    public boolean e(Object object) {
        return object instanceof o;
    }

    @Override // androidx.fragment.app.z
    public Object g(Object object) {
        d.u.o oVar = null;
        if (object != null) {
            oVar = object.m();
        } else {
            int i = 0;
        }
        return oVar;
    }

    @Override // androidx.fragment.app.z
    public Object m(Object object, Object object2, Object object3) {
        d.u.o object22 = null;
        if (object == null || object2 == null) {
            if (object == null) {
                object = object2 != null ? object2 : 0;
            }
        } else {
            d.u.s sVar = new s();
            sVar.k0(object);
            sVar.k0(object2);
            sVar.u0(1);
        }
        if (object3 != null) {
            final d.u.s sVar2 = new s();
            if (object22 != null) {
                sVar2.k0(object22);
            }
            sVar2.k0(object3);
            return sVar2;
        }
        return object22;
    }

    @Override // androidx.fragment.app.z
    public Object n(Object object, Object object2, Object object3) {
        final d.u.s sVar = new s();
        if (object != null) {
            sVar.k0(object);
        }
        if (object2 != null) {
            sVar.k0(object2);
        }
        if (object3 != null) {
            sVar.k0(object3);
        }
        return sVar;
    }

    @Override // androidx.fragment.app.z
    public void p(Object object, View view) {
        if (object != null) {
            object.T(view);
        }
    }

    @Override // androidx.fragment.app.z
    public void q(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int size;
        d.u.o oVar;
        int size2;
        int i;
        size = 0;
        if (object instanceof s) {
            while (size < object.o0()) {
                q(object.n0(size), arrayList, arrayList2);
                size = size + 1;
            }
        } else {
            if (!e.C(object)) {
                List list = object.F();
                if (list.size() == arrayList.size() && list.containsAll(arrayList) && arrayList2 == null) {
                    while (size < size) {
                        object.b((View)arrayList2.get(size));
                        size = size + 1;
                    }
                    i = arrayList.size() - 1;
                    while (i >= 0) {
                        object.T((View)arrayList.get(i));
                        i = i - 1;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.z
    public void r(Object object, View view, ArrayList<View> arrayList) {
        object.a(new e.b(this, view, arrayList));
    }

    @Override // androidx.fragment.app.z
    public void t(Object object, Object object2, ArrayList<View> arrayList, Object object3, ArrayList<View> arrayList2, Object object4, ArrayList<View> arrayList3) {
        e.c cVar = new e.c(this, object2, arrayList, object3, arrayList2, object4, arrayList3);
        (o)object.a(cVar);
    }

    @Override // androidx.fragment.app.z
    public void u(Object object, Rect rect) {
        if (object != null) {
            object.Z(new e.d(this, rect));
        }
    }

    @Override // androidx.fragment.app.z
    public void v(Object object, View view) {
        if (view != null) {
            Rect rect = new Rect();
            k(view, rect);
            object.Z(new e.a(this, rect));
        }
    }

    @Override // androidx.fragment.app.z
    public void z(Object object, View view, ArrayList<View> arrayList) {
        int i = 0;
        final List list = object.F();
        list.clear();
        i = 0;
        while (i < arrayList.size()) {
            z.d(list, (View)arrayList.get(i));
            i = i + 1;
        }
        list.add(view);
        arrayList.add(view);
        b(object, arrayList);
    }
}
