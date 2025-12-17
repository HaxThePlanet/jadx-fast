package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.e0.d;
import d.h.l.u;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class v extends a {

    final androidx.recyclerview.widget.RecyclerView d;
    private final androidx.recyclerview.widget.v.a e;

    public static class a extends a {

        final androidx.recyclerview.widget.v d;
        private Map<View, a> e;
        public a(androidx.recyclerview.widget.v v) {
            super();
            WeakHashMap weakHashMap = new WeakHashMap();
            this.e = weakHashMap;
            this.d = v;
        }

        @Override // d.h.l.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent2) {
            Object obj = this.e.get(view);
            if ((a)obj != null) {
                return (a)obj.a(view, accessibilityEvent2);
            }
            return super.a(view, accessibilityEvent2);
        }

        @Override // d.h.l.a
        public d b(View view) {
            Object obj = this.e.get(view);
            if ((a)obj != null) {
                return (a)obj.b(view);
            }
            return super.b(view);
        }

        @Override // d.h.l.a
        public void f(View view, AccessibilityEvent accessibilityEvent2) {
            Object obj = this.e.get(view);
            if ((a)obj != null) {
                (a)obj.f(view, accessibilityEvent2);
            } else {
                super.f(view, accessibilityEvent2);
            }
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            boolean layoutManager;
            if (!this.d.o() && vVar2.d.getLayoutManager() != null) {
                if (vVar2.d.getLayoutManager() != null) {
                    vVar3.d.getLayoutManager().i1(view, c2);
                    layoutManager = this.e.get(view);
                    if ((a)layoutManager != null) {
                        (a)layoutManager.g(view, c2);
                    } else {
                        super.g(view, c2);
                    }
                } else {
                    super.g(view, c2);
                }
            } else {
            }
        }

        @Override // d.h.l.a
        public void h(View view, AccessibilityEvent accessibilityEvent2) {
            Object obj = this.e.get(view);
            if ((a)obj != null) {
                (a)obj.h(view, accessibilityEvent2);
            } else {
                super.h(view, accessibilityEvent2);
            }
        }

        @Override // d.h.l.a
        public boolean i(ViewGroup viewGroup, View view2, AccessibilityEvent accessibilityEvent3) {
            Object obj = this.e.get(viewGroup);
            if ((a)obj != null) {
                return (a)obj.i(viewGroup, view2, accessibilityEvent3);
            }
            return super.i(viewGroup, view2, accessibilityEvent3);
        }

        @Override // d.h.l.a
        public boolean j(View view, int i2, Bundle bundle3) {
            boolean z;
            boolean layoutManager;
            if (!this.d.o() && vVar2.d.getLayoutManager() != null) {
                if (vVar2.d.getLayoutManager() != null) {
                    Object obj = this.e.get(view);
                    final int i = 1;
                    if ((a)obj != null) {
                        if ((a)obj.j(view, i2, bundle3)) {
                            return i;
                        }
                    } else {
                        if (super.j(view, i2, bundle3)) {
                            return i;
                        }
                    }
                    return vVar3.d.getLayoutManager().C1(view, i2, bundle3);
                }
            }
            return super.j(view, i2, bundle3);
        }

        @Override // d.h.l.a
        public void l(View view, int i2) {
            Object obj = this.e.get(view);
            if ((a)obj != null) {
                (a)obj.l(view, i2);
            } else {
                super.l(view, i2);
            }
        }

        @Override // d.h.l.a
        public void m(View view, AccessibilityEvent accessibilityEvent2) {
            Object obj = this.e.get(view);
            if ((a)obj != null) {
                (a)obj.m(view, accessibilityEvent2);
            } else {
                super.m(view, accessibilityEvent2);
            }
        }

        @Override // d.h.l.a
        a n(View view) {
            return (a)this.e.remove(view);
        }

        @Override // d.h.l.a
        void o(View view) {
            Map map;
            final a aVar = u.l(view);
            if (aVar != null && aVar != this) {
                if (aVar != this) {
                    this.e.put(view, aVar);
                }
            }
        }
    }
    public v(androidx.recyclerview.widget.RecyclerView recyclerView) {
        boolean z;
        a obj2;
        super();
        this.d = recyclerView;
        obj2 = n();
        if (obj2 != null && obj2 instanceof v.a) {
            if (obj2 instanceof v.a) {
                this.e = (v.a)obj2;
            } else {
                obj2 = new v.a(this);
                this.e = obj2;
            }
        } else {
        }
    }

    @Override // d.h.l.a
    public void f(View view, AccessibilityEvent accessibilityEvent2) {
        boolean layoutManager;
        Object obj2;
        super.f(view, accessibilityEvent2);
        if (view instanceof RecyclerView != null && !o() && (RecyclerView)view.getLayoutManager() != null) {
            if (!o()) {
                if ((RecyclerView)view.getLayoutManager() != null) {
                    view.getLayoutManager().e1(accessibilityEvent2);
                }
            }
        }
    }

    @Override // d.h.l.a
    public void g(View view, c c2) {
        boolean obj1;
        super.g(view, c2);
        if (!o() && this.d.getLayoutManager() != null) {
            if (this.d.getLayoutManager() != null) {
                this.d.getLayoutManager().g1(c2);
            }
        }
    }

    @Override // d.h.l.a
    public boolean j(View view, int i2, Bundle bundle3) {
        boolean obj1;
        if (super.j(view, i2, bundle3)) {
            return 1;
        }
        if (!o() && this.d.getLayoutManager() != null) {
            if (this.d.getLayoutManager() != null) {
                return this.d.getLayoutManager().A1(i2, bundle3);
            }
        }
        return 0;
    }

    @Override // d.h.l.a
    public a n() {
        return this.e;
    }

    @Override // d.h.l.a
    boolean o() {
        return this.d.s0();
    }
}
