package d.u;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.z;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class e extends z {

    class a extends d.u.o.e {

        final Rect a;
        a(d.u.e e, Rect rect2) {
            this.a = rect2;
            super();
        }

        @Override // d.u.o$e
        public Rect a(d.u.o o) {
            return this.a;
        }
    }

    class b implements d.u.o.f {

        final View a;
        final ArrayList b;
        b(d.u.e e, View view2, ArrayList arrayList3) {
            this.a = view2;
            this.b = arrayList3;
            super();
        }

        @Override // d.u.o$f
        public void onTransitionCancel(d.u.o o) {
        }

        @Override // d.u.o$f
        public void onTransitionEnd(d.u.o o) {
            int i;
            Object obj;
            o.S(this);
            this.a.setVisibility(8);
            int i3 = 0;
            i = i3;
            while (i < this.b.size()) {
                (View)this.b.get(i).setVisibility(i3);
                i++;
            }
        }

        @Override // d.u.o$f
        public void onTransitionPause(d.u.o o) {
        }

        @Override // d.u.o$f
        public void onTransitionResume(d.u.o o) {
        }

        @Override // d.u.o$f
        public void onTransitionStart(d.u.o o) {
        }
    }

    class d extends d.u.o.e {

        final Rect a;
        d(d.u.e e, Rect rect2) {
            this.a = rect2;
            super();
        }

        @Override // d.u.o$e
        public Rect a(d.u.o o) {
            Rect obj1;
            obj1 = this.a;
            if (obj1 != null && obj1.isEmpty()) {
                if (obj1.isEmpty()) {
                }
                return this.a;
            }
            return null;
        }
    }

    class c extends d.u.p {

        final Object a;
        final ArrayList b;
        final Object c;
        final ArrayList d;
        final Object e;
        final ArrayList f;
        final d.u.e g;
        c(d.u.e e, Object object2, ArrayList arrayList3, Object object4, ArrayList arrayList5, Object object6, ArrayList arrayList7) {
            this.g = e;
            this.a = object2;
            this.b = arrayList3;
            this.c = object4;
            this.d = arrayList5;
            this.e = object6;
            this.f = arrayList7;
            super();
        }

        @Override // d.u.p
        public void onTransitionEnd(d.u.o o) {
            o.S(this);
        }

        @Override // d.u.p
        public void onTransitionStart(d.u.o o) {
            d.u.e eVar;
            ArrayList list;
            Object obj4 = this.a;
            final int i = 0;
            if (obj4 != null) {
                this.g.q(obj4, this.b, i);
            }
            obj4 = this.c;
            if (obj4 != null) {
                this.g.q(obj4, this.d, i);
            }
            obj4 = this.e;
            if (obj4 != null) {
                this.g.q(obj4, this.f, i);
            }
        }
    }
    private static boolean C(d.u.o o) {
        boolean z;
        boolean obj1;
        if (z.l(o.C()) && z.l(o.D())) {
            if (z.l(o.D())) {
                if (!z.l(o.E())) {
                    obj1 = 1;
                } else {
                    obj1 = 0;
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    public void A(Object object, ArrayList<View> arrayList2, ArrayList<View> arrayList3) {
        List list;
        if ((s)object != null) {
            (s)object.F().clear();
            object.F().addAll(arrayList3);
            q(object, arrayList2, arrayList3);
        }
    }

    @Override // androidx.fragment.app.z
    public Object B(Object object) {
        if (object == null) {
            return null;
        }
        s sVar = new s();
        sVar.k0((o)object);
        return sVar;
    }

    @Override // androidx.fragment.app.z
    public void a(Object object, View view2) {
        if (object != null) {
            (o)object.b(view2);
        }
    }

    public void b(Object object, ArrayList<View> arrayList2) {
        int size;
        int i;
        d.u.o oVar;
        if ((o)object == null) {
        }
        i = 0;
        if (object instanceof s) {
            while (i < (s)(o)object.o0()) {
                b(object.n0(i), arrayList2);
                i++;
            }
        } else {
            if (!e.C(object) && z.l(object.F())) {
                if (z.l(object.F())) {
                    while (i < arrayList2.size()) {
                        object.b((View)arrayList2.get(i));
                        i++;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.z
    public void c(ViewGroup viewGroup, Object object2) {
        q.a(viewGroup, (o)object2);
    }

    @Override // androidx.fragment.app.z
    public boolean e(Object object) {
        return object instanceof o;
    }

    @Override // androidx.fragment.app.z
    public Object g(Object object) {
        d.u.o obj1;
        if (object != null) {
            obj1 = (o)object.m();
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    @Override // androidx.fragment.app.z
    public Object m(Object object, Object object2, Object object3) {
        d.u.s sVar;
        int obj2;
        if ((o)object != null && (o)object2 != null) {
            if ((o)object2 != null) {
                sVar = new s();
                sVar.k0((o)object);
                sVar.k0((o)object2);
                sVar.u0(1);
                obj2 = sVar;
            } else {
                if (object != null) {
                } else {
                    obj2 = object2 != null ? object2 : 0;
                }
            }
        } else {
        }
        s obj3 = new s();
        if ((o)object3 != null && obj2 != null) {
            obj3 = new s();
            if (obj2 != null) {
                obj3.k0(obj2);
            }
            obj3.k0((o)object3);
            return obj3;
        }
        return obj2;
    }

    @Override // androidx.fragment.app.z
    public Object n(Object object, Object object2, Object object3) {
        s sVar = new s();
        if (object != null) {
            sVar.k0((o)object);
        }
        if (object2 != null) {
            sVar.k0((o)object2);
        }
        if (object3 != null) {
            sVar.k0((o)object3);
        }
        return sVar;
    }

    @Override // androidx.fragment.app.z
    public void p(Object object, View view2) {
        if (object != null) {
            (o)object.T(view2);
        }
    }

    public void q(Object object, ArrayList<View> arrayList2, ArrayList<View> arrayList3) {
        int size;
        int i;
        d.u.o size2;
        int size3;
        int obj7;
        if (object instanceof s) {
            while (i < (s)(o)object.o0()) {
                q(object.n0(i), arrayList2, arrayList3);
                i++;
            }
        } else {
            size = object.F();
            if (!e.C(object) && size.size() == arrayList2.size() && size.containsAll(arrayList2)) {
                size = object.F();
                if (size.size() == arrayList2.size()) {
                    if (size.containsAll(arrayList2)) {
                        if (arrayList3 == null) {
                            size = i;
                        } else {
                            size = arrayList3.size();
                        }
                        while (i < size) {
                            object.b((View)arrayList3.get(i));
                            i++;
                        }
                        obj7--;
                        while (obj7 >= 0) {
                            object.T((View)arrayList2.get(obj7));
                            obj7--;
                        }
                    }
                }
            }
        }
    }

    public void r(Object object, View view2, ArrayList<View> arrayList3) {
        e.b bVar = new e.b(this, view2, arrayList3);
        (o)object.a(bVar);
    }

    public void t(Object object, Object object2, ArrayList<View> arrayList3, Object object4, ArrayList<View> arrayList5, Object object6, ArrayList<View> arrayList7) {
        super(this, object2, arrayList3, object4, arrayList5, object6, arrayList7);
        (o)object.a(cVar2);
    }

    @Override // androidx.fragment.app.z
    public void u(Object object, Rect rect2) {
        d.u.e.d dVar;
        if (object != null) {
            dVar = new e.d(this, rect2);
            (o)object.Z(dVar);
        }
    }

    @Override // androidx.fragment.app.z
    public void v(Object object, View view2) {
        Rect rect;
        Object obj3;
        if (view2 != null) {
            rect = new Rect();
            k(view2, rect);
            obj3 = new e.a(this, rect);
            (o)object.Z(obj3);
        }
    }

    public void z(Object object, View view2, ArrayList<View> arrayList3) {
        int i;
        Object obj;
        final List list = (s)object.F();
        list.clear();
        i = 0;
        while (i < arrayList3.size()) {
            z.d(list, (View)arrayList3.get(i));
            i++;
        }
        list.add(view2);
        arrayList3.add(view2);
        b(object, arrayList3);
    }
}
