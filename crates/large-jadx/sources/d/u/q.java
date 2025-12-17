package d.u;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import d.e.a;
import d.e.g;
import d.h.l.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public class q {

    private static d.u.o a;
    private static java.lang.ThreadLocal<WeakReference<a<ViewGroup, ArrayList<d.u.o>>>> b;
    static ArrayList<ViewGroup> c;

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        d.u.o a;
        ViewGroup b;
        a(d.u.o o, ViewGroup viewGroup2) {
            super();
            this.a = o;
            this.b = viewGroup2;
        }

        private void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.removeOnAttachStateChangeListener(this);
        }

        @Override // android.view.ViewTreeObserver$OnPreDrawListener
        public boolean onPreDraw() {
            Object iterator;
            Object arrayList;
            ViewGroup next;
            int arrayList2;
            ViewGroup size;
            a();
            int i = 1;
            if (!q.c.remove(this.b)) {
                return i;
            }
            a aVar = q.d();
            arrayList = aVar.get(this.b);
            arrayList2 = 0;
            if ((ArrayList)arrayList == null) {
                arrayList = new ArrayList();
                aVar.put(this.b, arrayList);
            } else {
                if ((ArrayList)arrayList.size() > 0) {
                    arrayList2 = new ArrayList(arrayList);
                }
            }
            arrayList.add(this.a);
            q.a.a aVar2 = new q.a.a(this, aVar);
            this.a.a(aVar2);
            this.a.k(this.b, false);
            if (arrayList2 != null) {
                iterator = arrayList2.iterator();
                for (o next : iterator) {
                    next.U(this.b);
                }
            }
            this.a.R(this.b);
            return i;
        }

        @Override // android.view.ViewTreeObserver$OnPreDrawListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.ViewTreeObserver$OnPreDrawListener
        public void onViewDetachedFromWindow(View view) {
            int size;
            ViewGroup view2;
            Object obj3;
            a();
            q.c.remove(this.b);
            obj3 = q.d().get(this.b);
            if (obj3 != null && (ArrayList)obj3.size() > 0) {
                if (obj3.size() > 0) {
                    obj3 = obj3.iterator();
                    for (o size : obj3) {
                        size.U(this.b);
                    }
                }
            }
            this.a.l(true);
        }
    }
    static {
        b bVar = new b();
        q.a = bVar;
        ThreadLocal threadLocal = new ThreadLocal();
        q.b = threadLocal;
        ArrayList arrayList = new ArrayList();
        q.c = arrayList;
    }

    public static void a(ViewGroup viewGroup, d.u.o o2) {
        boolean contains;
        d.u.o obj2;
        q.c.add(viewGroup);
        if (!q.c.contains(viewGroup) && u.R(viewGroup) && o2 == null) {
            if (u.R(viewGroup)) {
                q.c.add(viewGroup);
                if (o2 == null) {
                    obj2 = q.a;
                }
                obj2 = obj2.m();
                q.g(viewGroup, obj2);
                l.f(viewGroup, 0);
                q.f(viewGroup, obj2);
            }
        }
    }

    private static void b(d.u.l l, d.u.o o2) {
        boolean contains;
        ArrayList list;
        d.u.o obj4;
        final ViewGroup view = l.d();
        if (!q.c.contains(view)) {
            contains = l.c(view);
            if (o2 == null) {
                if (contains != null) {
                    contains.b();
                }
                l.a();
            } else {
                q.c.add(view);
                obj4 = o2.m();
                obj4.d0(view);
                if (contains != null && contains.e()) {
                    if (contains.e()) {
                        obj4.X(true);
                    }
                }
                q.g(view, obj4);
                l.a();
                q.f(view, obj4);
            }
        }
    }

    public static void c(ViewGroup viewGroup) {
        int obj;
        boolean arrayList;
        Object obj2;
        q.c.remove(viewGroup);
        obj = q.d().get(viewGroup);
        if (obj != null && !(ArrayList)obj.isEmpty()) {
            if (!obj.isEmpty()) {
                arrayList = new ArrayList(obj);
                size--;
                while (obj >= 0) {
                    (o)arrayList.get(obj).r(viewGroup);
                    obj--;
                }
            }
        }
    }

    static a<ViewGroup, ArrayList<d.u.o>> d() {
        Object obj;
        obj = q.b.get();
        obj = (WeakReference)obj.get();
        if (obj != null && (a)obj != null) {
            obj = obj.get();
            if ((a)(a)obj != null) {
                return (a)(a)obj;
            }
        }
        a aVar = new a();
        WeakReference weakReference = new WeakReference(aVar);
        q.b.set(weakReference);
        return aVar;
    }

    public static void e(d.u.l l, d.u.o o2) {
        q.b(l, o2);
    }

    private static void f(ViewGroup viewGroup, d.u.o o2) {
        d.u.q.a aVar;
        Object obj1;
        if (o2 != null && viewGroup != null) {
            if (viewGroup != null) {
                aVar = new q.a(o2, viewGroup);
                viewGroup.addOnAttachStateChangeListener(aVar);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
            }
        }
    }

    private static void g(ViewGroup viewGroup, d.u.o o2) {
        Object iterator;
        int size;
        iterator = q.d().get(viewGroup);
        if (iterator != null && (ArrayList)iterator.size() > 0) {
            if (iterator.size() > 0) {
                iterator = iterator.iterator();
                for (o size : iterator) {
                    size.Q(viewGroup);
                }
            }
        }
        if (o2 != null) {
            o2.k(viewGroup, true);
        }
        final d.u.l obj2 = l.c(viewGroup);
        if (obj2 != null) {
            obj2.b();
        }
    }
}
