package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.a0.g.f.d0;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: LayoutSponsorUniversalDetailsBannerBindingImpl.java */
/* loaded from: classes.dex */
public class vm extends um {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    public vm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, vm.S, vm.T));
    }

    private boolean U(d0 d0Var, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.R |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw d0Var;
            }
        }
        if (i == 169) {
            synchronized (this) {
                try {
                    this.R |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.um
    public void A() {
        synchronized (this) {
            try {
                this.R = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.um
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return U(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.um
    public boolean O(int i, Object object) {
        boolean z = true;
        if (183 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.um
    public void T(d0 d0Var) {
        R(0, d0Var);
        this.P = d0Var;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.um
    protected void m() {
        String str = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.R & 7L;
        if (l2 != l3 && this.P != null) {
            str = this.P.P();
        }
        if (l2 != l3) {
            BindingAdapters.w(this.O, str);
        }
    }

    @Override // app.dogo.com.dogo_android.h.um
    public boolean y() {
        synchronized (this) {
            try {
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private vm(e eVar, View view, Object[] objectArr) {
        int i = 1;
        super(eVar, view, i, (ImageView)objectArr[i]);
        this.R = -1L;
        Object obj2 = objectArr[0];
        this.Q = obj2;
        final Object obj3 = null;
        obj2.setTag(obj3);
        this.O.setTag(obj3);
        N(view);
        A();
    }

}
