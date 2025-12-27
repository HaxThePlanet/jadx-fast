package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.g.r;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.repository.domain.Dashboard;
import app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.view.dailytraining.l;

/* compiled from: FragmentDashboardBindingImpl.java */
/* loaded from: classes.dex */
public class va extends ua implements c.a {

    private static final ViewDataBinding.g d0 = new ViewDataBinding$g(9);
    private static final SparseIntArray e0 = null;
    private final ConstraintLayout Z;
    private final ConstraintLayout a0;
    private final SwipeRefreshLayout.j b0;
    private long c0;
    static {
        int i3 = 1;
        int[] iArr3 = new int[i3];
        final int i8 = 0;
        iArr3[i8] = 6;
        int[] iArr = new int[i3];
        iArr[i8] = R.layout.layout_current_dog_view_v2;
        obj.a(i8, new String[] { "layout_current_dog_view_v2" }, iArr3, iArr);
        obj.a(3, new String[] { "layout_dashboard_discount_counter", "layout_dashboard_resubscribe" }, new int[] { 7, 8 }, new int[] { R.layout.layout_dashboard_discount_counter, R.layout.layout_dashboard_resubscribe });
    }

    public va(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, va.d0, va.e0));
    }

    private boolean Z(ei eiVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(oj ojVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean b0(ui uiVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean c0(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean d0(LiveData<y<Dashboard>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean e0(x<CouponTimer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void A() {
        synchronized (this) {
            try {
                this.c0 = 1024L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        this.U.A();
        this.S.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ua
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                if (i != 4 && i != 5) {
                    return false;
                }
                return b0(object, i2);
            }
            return d0(object, i2);
        }
        return e0(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
        this.U.M(qVar);
        this.S.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = false;
        i2 = 64;
        if (64 == i) {
            W(object);
            int i4 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                V(object);
            } else {
                i2 = 177;
                if (177 == i) {
                    Y(object);
                } else {
                    i2 = 141;
                    if (141 == i) {
                        X(object);
                    } else {
                        int i3 = 0;
                    }
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void V(o oVar) {
        this.W = oVar;
        synchronized (this) {
            try {
                this.c0 |= 128;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void W(app.dogo.com.dogo_android.util.k0.e eVar) {
        this.X = eVar;
        synchronized (this) {
            try {
                this.c0 |= 64;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(64);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void X(l lVar) {
        this.Y = lVar;
        synchronized (this) {
            try {
                this.c0 |= 512;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(141);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public void Y(r rVar) {
        this.V = rVar;
        synchronized (this) {
            try {
                this.c0 |= 256;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.V != null ? 1 : 0;
        if (i2 != 0) {
            this.V.N();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ua
    protected void m() {
        Object value;
        int cmp5;
        int i;
        Boolean bool = null;
        boolean z;
        Object obj;
        LiveData liveData;
        y yVar;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.c0 = l4;
            } catch (Throwable th) {
            }
        }
        long l8 = 1088L & l2;
        long l9 = 1445L & l2;
        int i2 = 0;
        i = 0;
        if (l9 != l4) {
            if (this.V != null) {
                x timer = this.V.getTimer();
                liveData = this.V.F();
                x discountVisible = this.V.getDiscountVisible();
            } else {
            }
            Q(i2, obj);
            Q(2, liveData);
            Q(5, value);
            Object value2 = obj != null ? (CouponTimer)value2 : i;
            Object value3 = liveData != null ? (LoadResult)value3 : i;
            if (this.V != null) {
            }
        } else {
        }
        l = 1536L & l2;
        if (l != l4) {
            this.O.U(this.Y);
        }
        if (l8 != l4) {
            this.O.T(this.X);
        }
        long l5 = 1284L & l2;
        if (this.X != l4) {
            BindingAdapters.setTrainerAvatar(this.Z, yVar);
            BindingAdapters.H0(this.a0, yVar);
            BindingAdapters.y0(this.T, yVar);
        }
        if (l9 != l4) {
            SubscriptionBindingAdapters.setupTimerDashboard(this.Q, this.U, i, oVar, z, yVar, this.S, this.O);
        }
        long l6 = 1412L & l2;
        if (this.a0 != l4) {
            DashboardBindingAdapters.f(this.R, yVar, this.W);
        }
        long l7 = 1152L & l2;
        if (this.a0 != l4) {
            this.S.T(this.W);
        }
        long l3 = l2 & 1024L;
        if (this.c0 != l4) {
            this.T.setOnRefreshListener(this.b0);
        }
        ViewDataBinding.o(this.O);
        ViewDataBinding.o(this.U);
        ViewDataBinding.o(this.S);
    }

    @Override // app.dogo.com.dogo_android.h.ua
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z4 = true;
                if (this.c0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.O.y()) {
            return true;
        }
        if (this.U.y()) {
            return true;
        }
        if (this.S.y()) {
            return true;
        }
        return false;
    }

    private va(androidx.databinding.e eVar, View view, Object[] objectArr) {
        int i6 = 1;
        super(eVar, view, 6, (ei)objectArr[6], (ConstraintLayout)objectArr[3], (NestedScrollView)objectArr[2], (LinearLayout)objectArr[4], (oj)objectArr[8], (SwipeRefreshLayout)objectArr[i6], (ui)objectArr[7]);
        this.c0 = -1L;
        L(this.O);
        Object obj8 = null;
        this.P.setTag(obj8);
        Object obj9 = objectArr[0];
        this.Z = obj9;
        obj9.setTag(obj8);
        Object obj10 = objectArr[5];
        this.a0 = obj10;
        obj10.setTag(obj8);
        this.Q.setTag(obj8);
        this.R.setTag(obj8);
        L(this.S);
        this.T.setTag(obj8);
        L(this.U);
        N(view);
        this.b0 = new c(this, i6);
        A();
    }
}
