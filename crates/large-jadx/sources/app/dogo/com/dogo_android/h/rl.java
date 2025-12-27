package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;

/* compiled from: LayoutOnboardingToolBarBindingImpl.java */
/* loaded from: classes.dex */
public class rl extends ql {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final FrameLayout S;
    private long T;
    static {
        obj.put(2131361976, 3);
    }

    public rl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, rl.U, rl.V));
    }

    @Override // app.dogo.com.dogo_android.h.ql
    public void A() {
        synchronized (this) {
            try {
                this.T = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ql
    public boolean O(int i, Object object) {
        int i2 = 180;
        boolean z = true;
        i2 = 180;
        if (180 == i) {
            T(object);
            int i3 = 1;
        } else {
            i2 = 181;
            if (181 == i) {
                U(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ql
    public void T(Integer integer) {
        this.R = integer;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(180);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ql
    public void U(Integer integer) {
        this.Q = integer;
        synchronized (this) {
            try {
                this.T |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(181);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ql
    protected void m() {
        Integer num;
        int cmp;
        long l;
        int value;
        int i = 32;
        int i2 = 16;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj.T = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 5L;
        long l7 = l & l5;
        value = 1;
        value = 0;
        if (l7 != l4) {
            int r12 = obj.R == null ? 1 : value;
            if (l7 != l4 && value != null) {
                i = 64;
                l = l | i;
            }
        } else {
        }
        long l8 = 6L;
        l3 = l & l8;
        if (l3 != l4) {
            if (obj.Q != null) {
            }
            if (l3 != l4) {
                int r15 = value != null ? 16 : 8;
                l = l | (value != null ? 16 : 8);
            }
        } else {
        }
        long l9 = 6L & l;
        if (l9 == l4 || value != null) {
        }
        long l6 = 5L & l;
        if (l6 != l4) {
            if (value == null) {
            }
        }
        if (l6 != l4) {
            obj.O.setVisibility(value);
        }
        l2 = l & 4L;
        if (obj.T != l4 && ViewDataBinding.t() >= 21) {
            obj.S.setStateListAnimator(null);
        }
        if (l9 != l4) {
            obj.P.setVisibility(value);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ql
    public boolean y() {
        synchronized (this) {
            try {
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private rl(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ConstraintLayout)objectArr[2], (AppCompatImageView)objectArr[3], (ConstraintLayout)objectArr[1]);
        this.T = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.S = obj5;
        obj5.setTag(obj4);
        this.P.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ql
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
