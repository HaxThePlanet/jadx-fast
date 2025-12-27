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

/* compiled from: TransitionManager.java */
/* loaded from: classes.dex */
public class q {

    private static o a;
    private static java.lang.ThreadLocal<WeakReference<a<ViewGroup, ArrayList<o>>>> b;
    static ArrayList<ViewGroup> c;

    private static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        o a;
        ViewGroup b;
        a(o oVar, ViewGroup viewGroup) {
            super();
            this.a = oVar;
            this.b = viewGroup;
        }

        private void a() {
            this.b.getViewTreeObserver().removeOnPreDrawListener(this);
            this.b.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            ArrayList arrayList;
            int i = 0;
            a();
            boolean z = true;
            if (!q.c.remove(this.b)) {
                return true;
            }
            a aVar = q.d();
            Object obj = aVar.get(this.b);
            i = 0;
            if (obj == null) {
                aVar.put(this.b, new ArrayList());
            } else {
                if (obj.size() > 0) {
                    ArrayList arrayList2 = new ArrayList(obj);
                }
            }
            arrayList.add(this.a);
            this.a.a(new q.a.a(this, aVar));
            this.a.k(this.b, false);
            if (i != 0) {
                Iterator it = i.iterator();
                while (it.hasNext()) {
                    (o)it.next().U(this.b);
                }
            }
            this.a.R(this.b);
            return true;
        }

        public void onViewDetachedFromWindow(View view) {
            ViewGroup viewGroup2;
            a();
            q.c.remove(this.b);
            Object obj = q.d().get(this.b);
            if (obj != null && obj.size() > 0) {
                Iterator it = obj.iterator();
                while (it.hasNext()) {
                    (o)it.next().U(this.b);
                }
            }
            this.a.l(true);
        }

        public void onViewAttachedToWindow(View view) {
        }
    }
    static {
        q.a = new b();
        q.b = new ThreadLocal();
        q.c = new ArrayList();
    }

    public static void a(ViewGroup viewGroup, o oVar) {
        if (!q.c.contains(viewGroup) && u.R(viewGroup)) {
            q.c.add(viewGroup);
            if (oVar == null) {
                oVar = q.a;
            }
            d.u.o oVar3 = oVar.m();
            q.g(viewGroup, oVar3);
            l.f(viewGroup, null);
            q.f(viewGroup, oVar3);
        }
    }

    private static void b(l lVar, o oVar) {
        d.u.l lVar2;
        final ViewGroup viewGroup = lVar.d();
        if (!q.c.contains(viewGroup) && oVar == null && lVar2 != null) {
            lVar2.b();
            lVar.a();
        }
    }

    public static void c(ViewGroup viewGroup) {
        int i;
        Object item;
        q.c.remove(viewGroup);
        Object obj = q.d().get(viewGroup);
        if (obj != null && !obj.isEmpty()) {
            ArrayList arrayList = new ArrayList(obj);
            i = arrayList.size() - 1;
            while (q.c >= 0) {
                (o)arrayList.get(i).r(viewGroup);
                i = i - 1;
            }
        }
    }

    static a<ViewGroup, ArrayList<o>> d() {
        Object obj = q.b.get();
        if (obj != null) {
            obj = obj.get();
            if (obj != null) {
                return obj;
            }
        }
        a aVar = new a();
        q.b.set(new WeakReference(aVar));
        return aVar;
    }

    public static void e(l lVar, o oVar) {
        q.b(lVar, oVar);
    }

    private static void f(ViewGroup viewGroup, o oVar) {
        if (oVar != null && viewGroup != null) {
            d.u.q.a aVar = new q.a(oVar, viewGroup);
            viewGroup.addOnAttachStateChangeListener(aVar);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
        }
    }

    private static void g(ViewGroup viewGroup, o oVar) {
        Object obj;
        obj = q.d().get(viewGroup);
        if (obj != null && obj.size() > 0) {
            Iterator it = obj.iterator();
            while (it.hasNext()) {
                (o)it.next().Q(viewGroup);
            }
        }
        if (oVar != null) {
            oVar.k(viewGroup, true);
        }
        final d.u.l lVar = l.c(viewGroup);
        if (lVar != null) {
            lVar.b();
        }
    }
}
