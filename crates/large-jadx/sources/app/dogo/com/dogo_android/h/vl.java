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
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData;
import app.dogo.com.dogo_android.u.n.k;
import java.util.List;

/* compiled from: LayoutPottyOverviewLogsBindingImpl.java */
/* loaded from: classes.dex */
public class vl extends ul {

    private static final ViewDataBinding.g W = new ViewDataBinding$g(6);
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout U;
    private long V;
    static {
        obj.a(0, new String[] { "layout_dashboard_schedule_card", "layout_dashboard_potty_program_checkmarks_card", "layout_dashboard_potty_program_card_v2" }, new int[] { 1, 2, 3 }, new int[] { R.layout.layout_dashboard_schedule_card, R.layout.layout_dashboard_potty_program_checkmarks_card, R.layout.layout_dashboard_potty_program_card_v2 });
        obj.put(2131363207, 4);
        obj.put(2131362301, 5);
    }

    public vl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, vl.W, vl.X));
    }

    private boolean V(ej ejVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(cj cjVar, int i) {
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

    private boolean X(qj qjVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.ul
    public void A() {
        synchronized (this) {
            try {
                this.V = 64L;
            } catch (Throwable th) {
            }
        }
        this.Q.A();
        this.O.A();
        this.P.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ul
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return V(object, i2);
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ul
    public void M(q qVar) {
        super.M(qVar);
        this.Q.M(qVar);
        this.O.M(qVar);
        this.P.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ul
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            a0(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                Y(object);
            } else {
                i2 = 39;
                if (39 == i) {
                    Z(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ul
    public void Y(k kVar) {
        this.S = kVar;
        synchronized (this) {
            try {
                this.V |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ul
    public void Z(List<Boolean> list) {
        this.T = list;
    }

    @Override // app.dogo.com.dogo_android.h.ul
    public void a0(SpecialProgramOverviewItem specialProgramOverviewItem) {
        this.R = specialProgramOverviewItem;
        synchronized (this) {
            try {
                this.V |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ul
    protected void m() {
        int i;
        long l;
        long l2;
        List list;
        int i2 = 0;
        app.dogo.com.dogo_android.repository.domain.PottyProgramProgress pottyProgramProgress = null;
        String str;
        long l3;
        int i3 = 4096;
        int i4;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l7 = 0L;
                obj.V = l7;
            } catch (Throwable th) {
            }
        }
        long l8 = 72L;
        long l10 = l & l8;
        long l11 = 16384L;
        i2 = 0;
        i = 0;
        if (l10 != l7) {
            if (obj.R != null) {
                app.dogo.com.dogo_android.repository.domain.PottyProgramProgress programProgress = obj.R.getProgramProgress();
                boolean pottyTrackerNewUiEnabled = obj.R.getPottyTrackerNewUiEnabled();
                SpecialProgramOverviewItem.ProgramData programData = obj.R.getProgramData();
                List pottyCheckmarks = obj.R.getPottyCheckmarks();
            } else {
            }
            if (l10 != l7) {
                if (i != 0) {
                    l2 = (l | 1024L) | 16384L;
                    i4 = 65536;
                } else {
                    l2 = (l | 512L) | 8192L;
                    i4 = 32768;
                }
                l = l2 | i4;
            }
            int r9 = i != 0 ? 8 : i;
            if (i2 != 0) {
                String centerImage = i2.getCenterImage();
            }
        } else {
        }
        long l13 = l & 17408L;
        if (l13 != l7) {
            if (obj.R != null) {
                boolean logs = obj.R.hasLogs();
            } else {
            }
            long l12 = 16384L & l;
            int r10 = l12 != l7 ? i ^ 1 : i;
        } else {
        }
        long l14 = l & 72L;
        if (l14 != l7) {
            if (i == 0) {
            }
            if (i == 0) {
            }
            if (l14 != l7) {
                int r17 = obj.R != 0 ? 256 : 128;
                l = l | (obj.R != 0 ? 256 : 128);
            }
            l3 = l & 72L;
            if (l3 != l7) {
                r17 = i != 0 ? 4096 : 2048;
                l = l | (i != 0 ? 4096 : 2048);
            }
            Throwable th = obj.R != 0 ? i : 8;
            int r16 = i != 0 ? i : 8;
            i = (i != 0 ? i : 8);
        } else {
        }
        long l9 = 72L & l;
        if (l9 != l7) {
            obj.O.w().setVisibility(i);
            obj.O.V(pottyProgramProgress);
            obj.O.U(list);
            obj.P.V(pottyProgramProgress);
            obj.P.U(str);
            obj.P.w().setVisibility(i);
            obj.Q.w().setVisibility(i);
            obj.Q.U(pottyProgramProgress);
        }
        l &= 80;
        if (obj.V != l7) {
            obj.O.T(obj.S);
            obj.P.T(obj.S);
            obj.Q.T(obj.S);
        }
        ViewDataBinding.o(obj.Q);
        ViewDataBinding.o(obj.O);
        ViewDataBinding.o(obj.P);
    }

    @Override // app.dogo.com.dogo_android.h.ul
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z4 = true;
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.Q.y()) {
            return true;
        }
        if (this.O.y()) {
            return true;
        }
        if (this.P.y()) {
            return true;
        }
        return false;
    }

    private vl(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 3, (ej)objectArr[2], (TextView)objectArr[5], (cj)objectArr[3], (qj)objectArr[1], (TextView)objectArr[4]);
        this.V = -1L;
        L(this.O);
        Object obj6 = objectArr[0];
        this.U = obj6;
        obj6.setTag(null);
        L(this.P);
        L(this.Q);
        N(view);
        A();
    }
}
