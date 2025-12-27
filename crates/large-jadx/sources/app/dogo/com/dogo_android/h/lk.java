package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.s.b.c1.b;
import app.dogo.com.dogo_android.service.v2.b;

/* compiled from: LayoutDiscountTimerBindingImpl.java */
/* loaded from: classes.dex */
public class lk extends kk {

    private static final ViewDataBinding.g V = new ViewDataBinding$g(5);
    private static final SparseIntArray W = null;
    private final ConstraintLayout T;
    private long U;
    static {
        String str = "layout_discount_timer_square_segment";
        obj.a(0, new String[] { str, str, str, str }, new int[] { 1, 2, 3, 4 }, new int[] { R.layout.layout_discount_timer_square_segment, R.layout.layout_discount_timer_square_segment, R.layout.layout_discount_timer_square_segment, R.layout.layout_discount_timer_square_segment });
    }

    public lk(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, lk.V, lk.W));
    }

    private boolean U(mk mkVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean V(mk mkVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(mk mkVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(mk mkVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.kk
    public void A() {
        synchronized (this) {
            try {
                this.U = 32L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        this.P.A();
        this.Q.A();
        this.R.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.kk
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return X(object, i2);
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.kk
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
        this.P.M(qVar);
        this.Q.M(qVar);
        this.R.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.kk
    public boolean O(int i, Object object) {
        boolean z = true;
        if (54 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.kk
    public void T(CouponTimer couponTimer) {
        this.S = couponTimer;
        synchronized (this) {
            try {
                this.U |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(54);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kk
    protected void m() {
        int i = 1;
        long l;
        long seconds;
        int i2;
        final Object obj = this;
        synchronized (this) {
            try {
                seconds = 0L;
                obj.U = seconds;
            } catch (Throwable th) {
            }
        }
        long l4 = 48L;
        long l5 = l & l4;
        i = 0;
        if (l5 != seconds) {
            if (obj.S != null) {
                seconds = obj.S.getSeconds();
                seconds = obj.S.getHours();
                seconds = obj.S.getMinutes();
                seconds = obj.S.getDays();
            } else {
            }
            Throwable th = seconds > seconds ? 1 : 0;
            if (l5 != seconds) {
                int r18 = obj.S != 0 ? 128 : 64;
                l = l | (obj.S != 0 ? 128 : 64);
            }
            if (obj.S == 0) {
                i = 8;
            }
        } else {
        }
        l3 = 48L & l;
        if (l3 != seconds) {
            obj.O.T(Long.valueOf(seconds));
            obj.O.w().setVisibility(i);
            obj.P.T(Long.valueOf(seconds));
            obj.Q.T(Long.valueOf(seconds));
            obj.R.T(Long.valueOf(seconds));
        }
        l2 = l & 32L;
        if (obj.U != seconds) {
            obj.O.U(Utilities_TimeUnit.DAYS);
            obj.P.U(Utilities_TimeUnit.HOURS);
            obj.Q.U(Utilities_TimeUnit.MINUTES);
            obj.R.U(Utilities_TimeUnit.SECONDS);
        }
        ViewDataBinding.o(obj.O);
        ViewDataBinding.o(obj.P);
        ViewDataBinding.o(obj.Q);
        ViewDataBinding.o(obj.R);
    }

    @Override // app.dogo.com.dogo_android.h.kk
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z5 = true;
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.O.y()) {
            return true;
        }
        if (this.P.y()) {
            return true;
        }
        if (this.Q.y()) {
            return true;
        }
        if (this.R.y()) {
            return true;
        }
        return false;
    }

    private lk(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 4, (mk)objectArr[1], (mk)objectArr[2], (mk)objectArr[3], (mk)objectArr[4]);
        this.U = -1L;
        L(this.O);
        L(this.P);
        Object obj5 = objectArr[0];
        this.T = obj5;
        obj5.setTag(null);
        L(this.Q);
        L(this.R);
        N(view);
        A();
    }
}
