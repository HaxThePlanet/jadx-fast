package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.g.b0;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters;

/* compiled from: LayoutDashboardDiscountCounterBindingImpl.java */
/* loaded from: classes.dex */
public class vi extends ui implements b.a {

    private static final ViewDataBinding.g W = new ViewDataBinding$g(4);
    private static final SparseIntArray X = new SparseIntArray();
    private final View.OnClickListener U;
    private long V;
    static {
        int i3 = 1;
        final int[] iArr = new int[i3];
        final int i6 = 0;
        iArr[i6] = 2;
        int[] iArr2 = new int[i3];
        iArr2[i6] = R.layout.layout_dashboard_timer;
        obj.a(i3, new String[] { "layout_dashboard_timer" }, iArr, iArr2);
        obj.put(2131362318, 3);
    }

    public vi(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, vi.W, vi.X));
    }

    private boolean V(ak akVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ui
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            T(object);
            int i3 = 1;
        } else {
            i2 = 55;
            if (55 == i) {
                U(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public void T(o oVar) {
        this.T = oVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public void U(CouponTimer couponTimer) {
        this.S = couponTimer;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(55);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.T != null ? 1 : 0;
        if (i2 != 0) {
            this.T.onSubscriptionSelected();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ui
    protected void m() {
        int cmp;
        View.OnClickListener onClickListener;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 12L & l;
        long l2 = l & 8L;
        if (this.V != l3) {
            this.Q.setOnClickListener(this.U);
        }
        if (l4 != l3) {
            SubscriptionBindingAdapters.setupTimerDashboard(this.Q, this.S, this.R);
        }
        ViewDataBinding.o(this.R);
    }

    @Override // app.dogo.com.dogo_android.h.ui
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.R.y()) {
            return true;
        }
        return false;
    }

    private vi(e eVar, View view, Object[] objectArr) {
        int i2 = 1;
        super(eVar, view, 1, (TextView)objectArr[3], (ConstraintLayout)objectArr[i2], (ShimmerFrameLayout)objectArr[0], (ak)objectArr[2]);
        this.V = -1L;
        Object obj5 = null;
        this.P.setTag(obj5);
        this.Q.setTag(obj5);
        L(this.R);
        N(view);
        this.U = new b(this, i2);
        A();
    }
}
