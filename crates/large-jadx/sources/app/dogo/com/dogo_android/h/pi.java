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
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData;

/* compiled from: LayoutDashboardCombinedSpecialProgramCardBindingImpl.java */
/* loaded from: classes.dex */
public class pi extends oi {

    private static final ViewDataBinding.g W = new ViewDataBinding$g(4);
    private static final SparseIntArray X = null;
    private final ConstraintLayout U;
    private long V;
    static {
        obj.a(0, new String[] { "layout_dashboard_special_program_card", "layout_dashboard_special_program_completed" }, new int[] { 2, 3 }, new int[] { R.layout.layout_dashboard_special_program_card, R.layout.layout_dashboard_special_program_completed });
    }

    public pi(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, pi.W, pi.X));
    }

    private boolean Y(uj ujVar, int i) {
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

    private boolean Z(sj sjVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public void A() {
        synchronized (this) {
            try {
                this.V = 32L;
            } catch (Throwable th) {
            }
        }
        this.P.A();
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.oi
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public void M(q qVar) {
        super.M(qVar);
        this.P.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 50;
        if (50 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 94;
            if (94 == i) {
                X(object);
            } else {
                i2 = 29;
                if (29 == i) {
                    V(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public void V(o oVar) {
        this.T = oVar;
        synchronized (this) {
            try {
                this.V |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public void W(SpecialProgramOverviewItem.ProgramProgressData programProgressData) {
        this.S = programProgressData;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(50);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public void X(ProgramDescriptionItem programDescriptionItem) {
        this.R = programDescriptionItem;
        synchronized (this) {
            try {
                this.V |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.oi
    protected void m() {
        int cmp;
        Object obj = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l4 = 36L & l;
        long l5 = 40L & l;
        if (l5 != l3 && this.R != null) {
            String name = this.R.getName();
        }
        long l2 = l & 48L;
        if (l5 != l3) {
            this.O.U(this.R);
            this.P.V(this.R);
            g.c(this.Q, obj);
        }
        if (this.V != l3) {
            this.O.T(this.T);
            this.P.T(this.T);
        }
        if (l4 != l3) {
            this.P.U(this.S);
        }
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z3 = true;
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.P.y()) {
            return true;
        }
        if (this.O.y()) {
            return true;
        }
        return false;
    }

    private pi(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (uj)objectArr[3], (sj)objectArr[2], (TextView)objectArr[1]);
        this.V = -1L;
        L(this.O);
        Object obj4 = objectArr[0];
        this.U = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        L(this.P);
        this.Q.setTag(obj5);
        N(view);
        A();
    }
}
