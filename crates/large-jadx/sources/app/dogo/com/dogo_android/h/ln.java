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

/* compiled from: LayoutWorkoutStreaksCombinedBindingImpl.java */
/* loaded from: classes.dex */
public class ln extends kn {

    private static final ViewDataBinding.g U = new ViewDataBinding$g(3);
    private static final SparseIntArray V = null;
    private final mn Q;
    private final ConstraintLayout R;
    private final on S;
    private long T;
    static {
        obj.a(0, new String[] { "layout_workout_streaks_just_current", "layout_workout_streaks_with_longest" }, new int[] { 1, 2 }, new int[] { R.layout.layout_workout_streaks_just_current, R.layout.layout_workout_streaks_with_longest });
    }

    public ln(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, ln.U, ln.V));
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public void A() {
        synchronized (this) {
            try {
                this.T = 4L;
            } catch (Throwable th) {
            }
        }
        this.Q.A();
        this.S.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public void M(q qVar) {
        super.M(qVar);
        this.Q.M(qVar);
        this.S.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public boolean O(int i, Object object) {
        int i2 = 57;
        boolean z = true;
        i2 = 57;
        if (57 == i) {
            T(object);
            int i3 = 1;
        } else {
            i2 = 105;
            if (105 == i) {
                U(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public void T(Integer integer) {
        this.O = integer;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(57);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public void U(Integer integer) {
        this.P = integer;
        synchronized (this) {
            try {
                this.T |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(105);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kn
    protected void m() {
        long l;
        int i;
        int i3 = 8;
        long l2;
        int i2 = 32;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.T = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 6L;
        long l7 = l & l5;
        i = 0;
        if (l7 != l4) {
            int i5 = ViewDataBinding.J(this.P);
            i = 1;
            int r12 = i5 == 0 ? 1 : i;
            if (i5 == 0) {
            }
            if (l7 != l4) {
                int r13 = i != 0 ? 64 : 32;
                l = l | (i != 0 ? 64 : 32);
            }
            l2 = l & 6L;
            if (l2 != l4 && i != 0) {
                i3 = 16;
                l = l | i3;
            }
            i = 8;
            int r10 = i;
            if (i == 0) {
            }
        } else {
        }
        long l6 = 6L & l;
        if (l6 != l4) {
            this.Q.w().setVisibility(i);
            this.S.w().setVisibility(i);
            this.S.U(this.P);
        }
        l &= 5;
        if (this.T != l4) {
            this.Q.T(this.O);
            this.S.T(this.O);
        }
        ViewDataBinding.o(this.Q);
        ViewDataBinding.o(this.S);
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z3 = true;
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.Q.y()) {
            return true;
        }
        if (this.S.y()) {
            return true;
        }
        return false;
    }

    private ln(e eVar, View view, Object[] objectArr) {
        int i = 0;
        super(eVar, view, i);
        this.T = -1L;
        Object obj = objectArr[1];
        this.Q = obj;
        L(obj);
        Object obj2 = objectArr[i];
        this.R = obj2;
        obj2.setTag(null);
        Object obj3 = objectArr[2];
        this.S = obj3;
        L(obj3);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.kn
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
