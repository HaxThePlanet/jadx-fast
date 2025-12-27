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
import app.dogo.com.dogo_android.g.e0;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.s.b.c1.b;
import java.util.List;

/* compiled from: LayoutDashboardCombinedWorkoutCardBindingImpl.java */
/* loaded from: classes.dex */
public class ri extends qi {

    private static final ViewDataBinding.g U = new ViewDataBinding$g(4);
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.a(0, new String[] { "layout_dashboard_workout_locked_card", "layout_dashboard_workout_card" }, new int[] { 1, 2 }, new int[] { R.layout.layout_dashboard_workout_locked_card, R.layout.layout_dashboard_workout_card });
        obj.put(2131363468, 3);
    }

    public ri(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, ri.U, ri.V));
    }

    private boolean X(ik ikVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(gk gkVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.qi
    public void A() {
        synchronized (this) {
            try {
                this.T = 16L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        this.P.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qi
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.qi
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
        this.P.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.qi
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

    @Override // app.dogo.com.dogo_android.h.qi
    public void V(e0 e0Var) {
        this.R = e0Var;
        synchronized (this) {
            try {
                this.T |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qi
    public void W(WorkoutSession workoutSession) {
        this.Q = workoutSession;
        synchronized (this) {
            try {
                this.T |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qi
    protected void m() {
        long l;
        long l2;
        int cmp2 = 0;
        int cmp4 = 512;
        int i = 32;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.T = l4;
            } catch (Throwable th) {
            }
        }
        cmp2 = 0;
        final long l5 = 20L;
        long l6 = l & l5;
        cmp2 = 0;
        if (l6 != l4) {
            int r11 = this.Q != null ? 1 : cmp2;
            if (l6 != l4) {
                int r12 = cmp2 != 0 ? 64 : 32;
                l = l | (cmp2 != 0 ? 64 : 32);
            }
            if (this.Q != null) {
                List trainingTricksList = this.Q.getTrainingTricksList();
            }
            cmp2 = 8;
            r11 = cmp2;
            if (cmp2 != 0) {
                boolean empty = cmp2.isEmpty();
            } else {
            }
            long l7 = l & 20L;
            if (l7 != l4) {
                if (cmp2 != 0) {
                    l2 = l | 256L;
                    cmp4 = 1024;
                } else {
                    l2 = l | 128L;
                    cmp4 = 512;
                }
                l = l2 | cmp4;
            }
            r12 = cmp2;
            if (cmp2 == 0) {
            }
        } else {
        }
        long l8 = 24L & l;
        if (l8 != l4) {
            this.O.T(this.R);
            this.P.T(this.R);
        }
        l &= l5;
        if (this.T != l4) {
            this.O.w().setVisibility(cmp2);
            this.S.setVisibility(cmp2);
            this.P.U(this.Q);
            this.P.w().setVisibility(cmp2);
        }
        ViewDataBinding.o(this.O);
        ViewDataBinding.o(this.P);
    }

    @Override // app.dogo.com.dogo_android.h.qi
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
        if (this.O.y()) {
            return true;
        }
        if (this.P.y()) {
            return true;
        }
        return false;
    }

    private ri(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (ik)objectArr[1], (TextView)objectArr[3], (gk)objectArr[2]);
        this.T = -1L;
        L(this.O);
        Object obj4 = objectArr[0];
        this.S = obj4;
        obj4.setTag(null);
        L(this.P);
        N(view);
        A();
    }
}
