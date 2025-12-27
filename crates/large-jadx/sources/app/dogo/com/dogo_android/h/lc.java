package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.u.n.p.f;
import app.dogo.com.dogo_android.u.n.p.g.a;
import app.dogo.com.dogo_android.u.n.p.j;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* compiled from: FragmentDogLogCalanderBindingImpl.java */
/* loaded from: classes.dex */
public class lc extends kc implements c.a {

    private static final ViewDataBinding.g c0 = new ViewDataBinding$g(14);
    private static final SparseIntArray d0 = new SparseIntArray();
    private final CoordinatorLayout Z;
    private final SwipeRefreshLayout.j a0;
    private long b0;
    static {
        int i9 = 1;
        final int[] iArr2 = new int[i9];
        final int i20 = 0;
        iArr2[i20] = 6;
        int[] iArr = new int[i9];
        iArr[i20] = R.layout.layout_month_text_switcher;
        obj.a(2, new String[] { "layout_month_text_switcher" }, iArr2, iArr);
        obj.put(2131363435, 7);
        obj.put(2131362878, 8);
        obj.put(2131362732, 9);
        obj.put(2131362332, 10);
        obj.put(2131362331, 11);
        obj.put(2131363352, 12);
        obj.put(2131363554, 13);
    }

    public lc(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 14, lc.c0, lc.d0));
    }

    private boolean X(ol olVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(x<y<List<g.a>>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.b0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public void A() {
        synchronized (this) {
            try {
                this.b0 = 16L;
            } catch (Throwable th) {
            }
        }
        this.U.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.kc
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public void M(q qVar) {
        super.M(qVar);
        this.U.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public void V(f fVar) {
        this.Y = fVar;
        synchronized (this) {
            try {
                this.b0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public void W(j jVar) {
        this.X = jVar;
        synchronized (this) {
            try {
                this.b0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.X != null ? 1 : 0;
        if (i2 != 0) {
            this.X.r();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kc
    protected void m() {
        List list;
        int i = 0;
        y yVar = null;
        Object obj;
        Object value;
        int cmp4;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.b0 = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 29L & l2;
        final long l6 = 28L;
        i = 0;
        if (l5 != l4) {
            if (this.X != null) {
                x xVar = this.X.m();
            } else {
            }
            Q(0, obj);
            value = obj != null ? (LoadResult)value : i;
            long l8 = l2 & 28L;
            if (l8 != l4 && this.X != null) {
                List list2 = this.X.o();
            }
        } else {
        }
        long l7 = 25L & l2;
        if (l7 != l4) {
            BindingAdapters.setupClickerSelect(this.Z, yVar);
            BindingAdapters.y0(this.R, yVar);
        }
        if (l5 != l4) {
            CalendarBindingAdapters.setButtonDate(this.P, yVar, this.Y, this.U);
        }
        l = 16L & l2;
        if (l != l4) {
            this.R.setOnRefreshListener(this.a0);
        }
        long l3 = l2 & 28L;
        if (this.b0 != l4) {
            CalendarBindingAdapters.m(this.S, list, this.Y);
        }
        ViewDataBinding.o(this.U);
    }

    @Override // app.dogo.com.dogo_android.h.kc
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.b0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.U.y()) {
            return true;
        }
        return false;
    }

    private lc(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (ImageView)objectArr[11], (ImageView)objectArr[10], (LinearLayout)objectArr[9], (ConstraintLayout)objectArr[2], (NestedScrollView)objectArr[8], (RecyclerView)objectArr[3], (ConstraintLayout)objectArr[0], (SwipeRefreshLayout)objectArr[1], (RecyclerView)objectArr[5], (ConstraintLayout)objectArr[12], (ol)objectArr[6], (Toolbar)objectArr[7], (View)objectArr[13]);
        Object eVar4 = this;
        eVar4.b0 = -1L;
        Object obj = objectArr[4];
        eVar4.Z = obj;
        Object obj2 = null;
        obj.setTag(obj2);
        eVar4.O.setTag(obj2);
        eVar4.P.setTag(obj2);
        eVar4.Q.setTag(obj2);
        eVar4.R.setTag(obj2);
        eVar4.S.setTag(obj2);
        eVar4.L(eVar4.U);
        eVar4.N(view);
        eVar4.a0 = new c(eVar4, 1);
        A();
    }
}
