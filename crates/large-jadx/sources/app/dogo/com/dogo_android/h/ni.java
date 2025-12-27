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
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.g.n;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.DashboardProgram;
import app.dogo.com.dogo_android.s.b.c1.b;

/* compiled from: LayoutDashboardCombinedProgramCardBindingImpl.java */
/* loaded from: classes.dex */
public class ni extends mi {

    private static final ViewDataBinding.g Y = new ViewDataBinding$g(7);
    private static final SparseIntArray Z = null;
    private final ConstraintLayout W;
    private long X;
    static {
        obj.a(0, new String[] { "layout_dashboard_survey_card", "layout_dashboard_recommended_program_card", "layout_dashboard_recommended_program_card_v2", "layout_dashboard_current_lesson_card", "layout_dashboard_program_complete" }, new int[] { 2, 3, 4, 5, 6 }, new int[] { R.layout.layout_dashboard_survey_card, R.layout.layout_dashboard_recommended_program_card, R.layout.layout_dashboard_recommended_program_card_v2, R.layout.layout_dashboard_current_lesson_card, R.layout.layout_dashboard_program_complete });
    }

    public ni(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, ni.Y, ni.Z));
    }

    private boolean X(gj gjVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(kj kjVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(mj mjVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(si siVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean b0(yj yjVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.mi
    public void A() {
        synchronized (this) {
            try {
                this.X = 128L;
            } catch (Throwable th) {
            }
        }
        this.S.A();
        this.P.A();
        this.Q.A();
        this.R.A();
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.mi
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                if (i != 4) {
                    return false;
                }
                return X(object, i2);
            }
            return a0(object, i2);
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.mi
    public void M(q qVar) {
        super.M(qVar);
        this.S.M(qVar);
        this.P.M(qVar);
        this.Q.M(qVar);
        this.R.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.mi
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

    @Override // app.dogo.com.dogo_android.h.mi
    public void V(o oVar) {
        this.V = oVar;
        synchronized (this) {
            try {
                this.X |= 64;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mi
    public void W(DashboardProgram dashboardProgram) {
        this.U = dashboardProgram;
        synchronized (this) {
            try {
                this.X |= 32;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mi
    protected void m() {
        app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem programDescriptionItem = null;
        app.dogo.com.dogo_android.repository.domain.ProgramLessonItem lessonItem;
        app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary programCompletionSummary;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.X = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 160L & l;
        if (l4 == l3 || this.U == null) {
        } else {
        }
        long l2 = l & 192L;
        if (l4 != l3) {
            this.O.U(programDescriptionItem);
            this.P.U(programDescriptionItem);
            this.Q.U(programDescriptionItem);
            this.R.U(lessonItem);
            this.R.V(programCompletionSummary);
            DashboardBindingAdapters.setMarginsForDashboardCard(this.T, this.U);
        }
        if (this.X != l3) {
            this.O.T(this.V);
            this.P.T(this.V);
            this.Q.T(this.V);
            this.R.T(this.V);
            this.S.T(this.V);
        }
        ViewDataBinding.o(this.S);
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.Q);
        ViewDataBinding.o(this.R);
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.mi
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z6 = true;
                if (this.X != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.S.y()) {
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
        if (this.O.y()) {
            return true;
        }
        return false;
    }

    private ni(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 5, (gj)objectArr[6], (kj)objectArr[3], (mj)objectArr[4], (si)objectArr[5], (yj)objectArr[2], (TextView)objectArr[1]);
        this.X = -1L;
        Object obj7 = objectArr[0];
        this.W = obj7;
        final Object obj8 = null;
        obj7.setTag(obj8);
        L(this.O);
        L(this.P);
        L(this.Q);
        L(this.R);
        L(this.S);
        this.T.setTag(obj8);
        N(view);
        A();
    }
}
