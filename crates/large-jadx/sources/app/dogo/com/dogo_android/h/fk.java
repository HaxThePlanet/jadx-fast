package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.g.d0;
import app.dogo.com.dogo_android.g.n;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;

/* compiled from: LayoutDashboardWeekSummaryBindingImpl.java */
/* loaded from: classes.dex */
public class fk extends ek {

    private static final ViewDataBinding.g X = new ViewDataBinding$g(7);
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout V;
    private long W;
    static {
        int i4 = 1;
        final int[] iArr2 = new int[i4];
        final int i9 = 0;
        iArr2[i9] = 4;
        int[] iArr = new int[i4];
        iArr[i9] = R.layout.layout_dashboard_metric_tooltip;
        obj.a(i9, new String[] { "layout_dashboard_metric_tooltip" }, iArr2, iArr);
        obj.put(2131363421, 5);
        obj.put(2131363299, 6);
    }

    public fk(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, fk.X, fk.Y));
    }

    private boolean X(yi yiVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.W |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public void A() {
        synchronized (this) {
            try {
                this.W = 8L;
            } catch (Throwable th) {
            }
        }
        this.S.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ek
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public void M(q qVar) {
        super.M(qVar);
        this.S.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public void V(d0 d0Var) {
        this.T = d0Var;
        synchronized (this) {
            try {
                this.W |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public void W(TrainingTimeMetrics trainingTimeMetrics) {
        this.U = trainingTimeMetrics;
        synchronized (this) {
            try {
                this.W |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ek
    protected void m() {
        long l;
        int currentStreak;
        Object obj2 = null;
        int i = 32;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj.W = l4;
            } catch (Throwable th) {
            }
        }
        int i2 = 0;
        long l5 = 14L;
        long l7 = l & l5;
        final long l8 = 10L;
        currentStreak = 0;
        if (l7 != l4 && l2 != l4) {
            if (obj.U != null) {
                currentStreak = obj.U.getCurrentStreak();
            } else {
            }
            int r14 = currentStreak > 0 ? 1 : currentStreak;
            String integer = Integer.toString(currentStreak);
            if (l2 != l4) {
                int r15 = currentStreak != 0 ? 32 : 16;
                l = l | (currentStreak != 0 ? 32 : 16);
            }
            if (currentStreak == 0) {
                currentStreak = 8;
            }
        }
        long l6 = 14L & l;
        if (l6 != l4) {
            DashboardBindingAdapters.m(obj.O, obj.S, obj.R, obj.T, obj.U);
            DashboardBindingAdapters.k(obj.P, obj.U, obj.T);
        }
        l &= l8;
        if (obj.W != l4) {
            obj.V.setVisibility(currentStreak);
            g.c(obj.Q, obj2);
        }
        ViewDataBinding.o(obj.S);
    }

    @Override // app.dogo.com.dogo_android.h.ek
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.S.y()) {
            return true;
        }
        return false;
    }

    private fk(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (ConstraintLayout)objectArr[0], (RecyclerView)objectArr[3], (AppCompatImageView)objectArr[6], (TextView)objectArr[2], (TextView)objectArr[5], (yi)objectArr[4]);
        this.W = -1L;
        Object obj7 = null;
        this.O.setTag(obj7);
        Object obj8 = objectArr[1];
        this.V = obj8;
        obj8.setTag(obj7);
        this.P.setTag(obj7);
        this.Q.setTag(obj7);
        L(this.S);
        N(view);
        A();
    }
}
