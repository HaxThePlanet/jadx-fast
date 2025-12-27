package h.a.b;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import d.h.l.u;
import h.a.b.i.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/* compiled from: SelectableAdapter.java */
/* loaded from: classes2.dex */
public abstract class e extends RecyclerView.h {

    c a = new c();
    private final Set<Integer> b;
    private final Set<h.a.c.b> c = new HashSet<>();
    private int d = 0;
    private h.a.b.f.b e;
    protected RecyclerView f;
    protected h.a.a.a g = new a();
    protected boolean h = false;
    public e() {
        super();
        if (b.d == null) {
            str = "FlexibleAdapter";
            b.l(str);
        }
        Object[] arr = new Object[1];
        new c(b.d).c("Running version %s", "5.1.0");
        this.b = Collections.synchronizedSet(new TreeSet());
        HashSet hashSet = new HashSet();
        h.a.a.a aVar = new a();
    }

    private void s(int i, int i2) {
        if (i2 > 0) {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                (b)it.next().toggleActivation();
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
        boolean z3 = false;
        if (q(i)) {
            i = this.b.add(Integer.valueOf(i)) ? 1 : 0;
        }
        return (this.b.add(Integer.valueOf(i)) ? 1 : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void h() {
        int value;
        synchronized (set2) {
            try {
                value = 1;
                Object[] arr = new Object[value];
                value = 0;
                arr[value] = this.b;
                this.a.a("clearSelection %s", arr);
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    value = (Integer)it.next().intValue();
                    it.remove();
                    set = value + value;
                    if (value + value == value) {
                        value = value + 1;
                    } else {
                        s(value, value);
                    }
                }
                s(value, value);
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    void i() {
        this.c.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public Set<h.a.c.b> j() {
        return Collections.unmodifiableSet(this.c);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public h.a.b.f.b l() {
        if (this.e == null) {
            androidx.recyclerview.widget.RecyclerView.p layoutManager = this.f.getLayoutManager();
            z = layoutManager instanceof b;
            if (layoutManager instanceof b) {
                this.e = layoutManager;
            } else {
                if (layoutManager != null) {
                    this.e = new a(this.f);
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
        if (this.g != null) {
            this.g.a(recyclerView);
        }
        this.f = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 e0Var, int i, List list) {
        z2 = e0Var instanceof b;
        if (e0Var instanceof b) {
            Object e0Var2 = e0Var;
            e0Var2.getContentView().setActivated(r(i));
            float activationElevation = 0.0f;
            if (e0Var2.getContentView().isActivated()) {
                float activationElevation2 = e0Var2.getActivationElevation();
                if (activationElevation2 > 0.0f) {
                    u.s0(e0Var2.getContentView(), e0Var2.getActivationElevation());
                } else {
                    float activationElevation3 = e0Var2.getActivationElevation();
                    if (activationElevation3 > 0.0f) {
                        u.s0(e0Var2.getContentView(), 0.0f);
                    }
                }
            }
            i = 2;
            int i3 = 1;
            int i4 = 0;
            int i5 = 3;
            if (e0Var2.isRecyclable()) {
                this.c.add(e0Var2);
                Object[] arr = new Object[i5];
                this.a.d("onViewBound    viewSize=%s %s %s", Integer.valueOf(this.c.size()), a.a(e0Var), e0Var);
            } else {
                Object[] arr2 = new Object[i5];
                this.a.d("onViewBound    recyclable=%s %s %s", Boolean.valueOf(e0Var.isRecyclable()), a.a(e0Var), e0Var);
            }
        } else {
            e0Var.itemView.setActivated(r(i));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        if (this.g != null) {
            this.g.b(recyclerView);
        }
        final RecyclerView recyclerView2 = null;
        this.f = recyclerView2;
        this.e = recyclerView2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onViewRecycled(RecyclerView.e0 e0Var) {
        z = e0Var instanceof b;
        if (e0Var instanceof b) {
            Object[] arr = new Object[4];
            int i = 2;
            arr[i] = e0Var;
            arr[3] = Boolean.valueOf(this.c.remove(e0Var));
            str2 = "onViewRecycled viewSize=%s %s %s recycled=%s";
            this.a.d(str2, arr);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public List<Integer> p() {
        return new ArrayList(this.b);
    }

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
        if (!r(i) || this.r(i2)) {
            if (!r(i) && this.r(i2)) {
                t(i2);
                g(i);
            }
        } else {
            t(i);
            g(i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void v(int i) {
        String str;
        if (i < 0) {
            return;
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
        String r0 = contains ? "removed" : "added";
        this.a.d("toggleSelection %s on position %s, current %s", (contains ? "removed" : "added"), Integer.valueOf(i), (contains ? "removed" : "added"));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public abstract boolean q(int i);
}
