package h.a.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import d.h.l.u;
import h.a.a.a;
import h.a.b.f.a;
import h.a.b.f.b;
import h.a.b.i.a;
import h.a.b.i.b;
import h.a.b.i.c;
import h.a.c.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* loaded from: classes2.dex */
public abstract class e extends RecyclerView.h {

    c a;
    private final Set<Integer> b;
    private final Set<b> c;
    private int d = 0;
    private b e;
    protected RecyclerView f;
    protected a g;
    protected boolean h = false;
    public e() {
        String str;
        super();
        if (b.d == null) {
            b.l("FlexibleAdapter");
        }
        c cVar = new c(b.d);
        this.a = cVar;
        Object[] arr = new Object[1];
        cVar.c("Running version %s", "5.1.0");
        TreeSet treeSet = new TreeSet();
        this.b = Collections.synchronizedSet(treeSet);
        HashSet hashSet = new HashSet();
        this.c = hashSet;
        a aVar = new a();
        this.g = aVar;
    }

    private void s(int i, int i2) {
        boolean sELECTION;
        Object next;
        if (i2 > 0) {
            Iterator iterator = this.c.iterator();
            for (b next : iterator) {
                next.toggleActivation();
            }
            if (this.c.isEmpty()) {
                notifyItemRangeChanged(i, i2, d.SELECTION);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    final boolean f(int i) {
        return this.b.add(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final boolean g(int i) {
        boolean z;
        int obj2;
        if (q(i) && this.b.add(Integer.valueOf(i))) {
            obj2 = this.b.add(Integer.valueOf(i)) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h() {
        int i2;
        Object[] intValue;
        Set set;
        int i;
        final Set set2 = this.b;
        final int i3 = 1;
        intValue = new Object[i3];
        i = 0;
        intValue[i] = this.b;
        this.a.a("clearSelection %s", intValue);
        Iterator iterator = this.b.iterator();
        i2 = i;
        synchronized (set2) {
            while (iterator.hasNext()) {
                intValue = (Integer)iterator.next().intValue();
                iterator.remove();
                if (i + i2 == intValue) {
                } else {
                }
                s(i, i2);
                i2 = i3;
                i = intValue;
                i2++;
            }
            s(i, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    void i() {
        this.c.clear();
    }

    public Set<b> j() {
        return Collections.unmodifiableSet(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public b l() {
        Object layoutManager;
        boolean view;
        if (this.e == null) {
            layoutManager = this.f.getLayoutManager();
            if (layoutManager instanceof b) {
                this.e = (b)layoutManager;
            } else {
                if (layoutManager != null) {
                    layoutManager = new a(this.f);
                    this.e = layoutManager;
                }
            }
        }
        return this.e;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int m() {
        return this.d;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView n() {
        return this.f;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int o() {
        return this.b.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        final a aVar = this.g;
        if (aVar != null) {
            aVar.a(recyclerView);
        }
        this.f = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2, List list3) {
        int i;
        float activationElevation;
        int i3;
        String str;
        Object valueOf;
        Object obj5;
        boolean obj6;
        boolean obj7;
        if (e0 instanceof b) {
            obj7 = e0;
            (b)obj7.getContentView().setActivated(r(i2));
            activationElevation = 0;
            if (obj7.getContentView().isActivated() && Float.compare(obj6, activationElevation) > 0) {
                if (Float.compare(obj6, activationElevation) > 0) {
                    u.s0(obj7.getContentView(), obj7.getActivationElevation());
                } else {
                    if (Float.compare(obj6, activationElevation) > 0) {
                        u.s0(obj7.getContentView(), activationElevation);
                    }
                }
            } else {
            }
            i = 2;
            i3 = 1;
            int i4 = 0;
            int i5 = 3;
            if (obj7.isRecyclable()) {
                this.c.add(obj7);
                obj7 = new Object[i5];
                obj7[i4] = Integer.valueOf(this.c.size());
                obj7[i3] = a.a(e0);
                obj7[i] = e0;
                this.a.d("onViewBound    viewSize=%s %s %s", obj7);
            } else {
                obj7 = new Object[i5];
                obj7[i4] = Boolean.valueOf(e0.isRecyclable());
                obj7[i3] = a.a(e0);
                obj7[i] = e0;
                this.a.d("onViewBound    recyclable=%s %s %s", obj7);
            }
        } else {
            e0.itemView.setActivated(r(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        final a aVar = this.g;
        if (aVar != null) {
            aVar.b(recyclerView);
        }
        final int obj2 = 0;
        this.f = obj2;
        this.e = obj2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onViewRecycled(RecyclerView.e0 recyclerView$e0) {
        boolean valueOf;
        c cVar;
        Object[] arr;
        int i;
        String str;
        Object obj6;
        if (e0 instanceof b) {
            arr = new Object[4];
            this.a.d("onViewRecycled viewSize=%s %s %s recycled=%s", Integer.valueOf(this.c.size()), a.a(e0), e0, Boolean.valueOf(this.c.remove(e0)));
        }
    }

    public List<Integer> p() {
        ArrayList arrayList = new ArrayList(this.b);
        return arrayList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public abstract boolean q(int i);

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public boolean r(int i) {
        return this.b.contains(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final boolean t(int i) {
        return this.b.remove(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    protected void u(int i, int i2) {
        boolean z;
        if (r(i) && !r(i2)) {
            if (!r(i2)) {
                t(i);
                g(i2);
            } else {
                if (!r(i) && r(i2)) {
                    if (r(i2)) {
                        t(i2);
                        g(i);
                    }
                }
            }
        } else {
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void v(int i) {
        String str;
        if (i < 0) {
        }
        final int i3 = 1;
        if (this.d == i3) {
            h();
        }
        boolean contains = this.b.contains(Integer.valueOf(i));
        if (contains) {
            t(i);
        } else {
            g(i);
        }
        Object[] arr = new Object[3];
        str = contains ? "removed" : "added";
        arr[i3] = Integer.valueOf(i);
        arr[2] = this.b;
        this.a.d("toggleSelection %s on position %s, current %s", arr);
    }
}
