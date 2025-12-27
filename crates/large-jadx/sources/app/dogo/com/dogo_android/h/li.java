package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
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
import app.dogo.com.dogo_android.g.z;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import java.util.List;

/* compiled from: LayoutDashboardCombinedPottyProgramCardBindingImpl.java */
/* loaded from: classes.dex */
public class li extends ki implements b.a {

    private static final ViewDataBinding.g b0 = new ViewDataBinding$g(9);
    private static final SparseIntArray c0 = new SparseIntArray();
    private final ConstraintLayout Y;
    private final View.OnClickListener Z;
    private long a0;
    static {
        obj.a(0, new String[] { "layout_dashboard_potty_program_card", "layout_dashboard_potty_program_card_v2", "layout_dashboard_schedule_card", "layout_dashboard_potty_program_checkmarks_card" }, new int[] { 3, 4, 5, 6 }, new int[] { R.layout.layout_dashboard_potty_program_card, R.layout.layout_dashboard_potty_program_card_v2, R.layout.layout_dashboard_schedule_card, R.layout.layout_dashboard_potty_program_checkmarks_card });
        obj.put(2131362983, 7);
        obj.put(2131362984, 8);
    }

    public li(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, li.b0, li.c0));
    }

    private boolean Z(ej ejVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(aj ajVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean b0(cj cjVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean c0(qj qjVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public void A() {
        synchronized (this) {
            try {
                this.a0 = 256L;
            } catch (Throwable th) {
            }
        }
        this.P.A();
        this.Q.A();
        this.S.A();
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ki
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return c0(object, i2);
        }
        return b0(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public void M(q qVar) {
        super.M(qVar);
        this.P.M(qVar);
        this.Q.M(qVar);
        this.S.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public boolean O(int i, Object object) {
        int i2 = 134;
        boolean z = false;
        i2 = 94;
        if (94 == i) {
            X(object);
            int i4 = 1;
        } else {
            i2 = 134;
            if (134 == i) {
                Y(object);
            } else {
                i2 = 29;
                if (29 == i) {
                    V(object);
                } else {
                    i2 = 39;
                    if (39 == i) {
                        W(object);
                    } else {
                        int i3 = 0;
                    }
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public void V(o oVar) {
        this.W = oVar;
        synchronized (this) {
            try {
                this.a0 |= 64;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public void W(List<Boolean> list) {
        this.X = list;
        synchronized (this) {
            try {
                this.a0 |= 128;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(39);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public void X(ProgramDescriptionItem programDescriptionItem) {
        this.U = programDescriptionItem;
        synchronized (this) {
            try {
                this.a0 |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public void Y(PottyProgramProgress pottyProgramProgress) {
        this.V = pottyProgramProgress;
        synchronized (this) {
            try {
                this.a0 |= 32;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(134);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public final void b(int i, View view) {
        int i2 = 1;
        i2 = 1;
        i2 = 0;
        int r2 = this.W != null ? 1 : i2;
        if (i2 != 0 && this.U != null) {
            if (i2 != 0) {
                this.W.onSpecialCardSelected(this.U.getId());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ki
    protected void m() {
        PottyProgramProgress pottyProgramProgress;
        String iconUrl = null;
        Object obj;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.a0 = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 272L & l;
        if (l4 == l3 || this.U == null) {
        } else {
            iconUrl = this.U.getIconUrl();
            String name = this.U.getName();
        }
        long l5 = 288L & l;
        long l6 = 320L & l;
        long l7 = 384L & l;
        if (l5 != l3) {
            this.O.V(this.V);
            this.Q.V(this.V);
            this.S.U(this.V);
        }
        if (l6 != l3) {
            this.O.T(this.W);
            this.P.T(this.W);
            this.Q.T(this.W);
            this.S.T(this.W);
        }
        if (l7 != l3) {
            this.O.U(this.X);
        }
        if (l4 != l3) {
            this.P.U(this.U);
            this.Q.U(iconUrl);
            g.c(this.T, obj);
        }
        long l2 = l & 256L;
        if (this.a0 != l3) {
            this.R.setOnClickListener(this.Z);
        }
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.Q);
        ViewDataBinding.o(this.S);
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z5 = true;
                if (this.a0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.P.y()) {
            return true;
        }
        if (this.Q.y()) {
            return true;
        }
        if (this.S.y()) {
            return true;
        }
        if (this.O.y()) {
            return true;
        }
        return false;
    }

    private li(e eVar, View view, Object[] objectArr) {
        final b.a eVar3 = this;
        final int i11 = 1;
        super(eVar, view, 4, (ej)objectArr[6], (TextView)objectArr[7], (ImageView)objectArr[8], (aj)objectArr[3], (cj)objectArr[4], (View)objectArr[2], (qj)objectArr[5], (TextView)objectArr[i11]);
        eVar3.a0 = -1L;
        Object obj9 = objectArr[0];
        eVar3.Y = obj9;
        Object obj10 = null;
        obj9.setTag(obj10);
        L(eVar3.O);
        L(eVar3.P);
        L(eVar3.Q);
        eVar3.R.setTag(obj10);
        L(eVar3.S);
        eVar3.T.setTag(obj10);
        N(view);
        eVar3.Z = new b(this, i11);
        A();
    }
}
