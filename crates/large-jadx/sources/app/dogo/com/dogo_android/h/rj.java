package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.g.a0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;

/* compiled from: LayoutDashboardScheduleCardBindingImpl.java */
/* loaded from: classes.dex */
public class rj extends qj implements b.a {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final View.OnClickListener S;
    private long T;
    static {
        obj.put(2131362307, 2);
        obj.put(2131363414, 3);
        obj.put(2131361940, 4);
        obj.put(2131362322, 5);
        obj.put(2131363364, 6);
    }

    public rj(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, rj.U, rj.V));
    }

    @Override // app.dogo.com.dogo_android.h.qj
    public void A() {
        synchronized (this) {
            try {
                this.T = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qj
    public boolean O(int i, Object object) {
        int i2 = 94;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                T(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.qj
    public void T(a0 a0Var) {
        this.R = a0Var;
        synchronized (this) {
            try {
                this.T |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qj
    public void U(PottyProgramProgress pottyProgramProgress) {
        this.Q = pottyProgramProgress;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qj
    public final void b(int i, View view) {
        int i2 = 1;
        int r0 = this.R != null ? 1 : 0;
        if (i2 != 0) {
            this.R.onCheckmarkButtonSelected(this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qj
    protected void m() {
        PottyProgramProgress pottyProgramProgress;
        int cleanDaysStreak;
        Object obj = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        int i4 = 0;
        long l4 = 5L & l;
        if (l4 != l3) {
            cleanDaysStreak = 0;
            if (this.Q != null) {
                cleanDaysStreak = this.Q.getCleanDaysStreak();
            } else {
            }
            int i = 2131886246;
            Object[] arr = new Object[2];
            String string = this.O.getResources().getString(i, new Object[] { Integer.valueOf(cleanDaysStreak), 14 });
        }
        if (l4 != l3) {
            g.c(this.O, obj);
        }
        long l2 = l & 4L;
        if (this.T != l3) {
            this.P.setOnClickListener(this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qj
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

    private rj(e eVar, View view, Object[] objectArr) {
        final b.a eVar3 = this;
        final int i9 = 1;
        super(eVar, view, 0, (TextView)objectArr[i9], (ImageView)objectArr[4], (ImageView)objectArr[2], (ImageView)objectArr[5], (MaterialCardView)objectArr[0], (TextView)objectArr[6], (TextView)objectArr[3]);
        eVar3.T = -1L;
        Object obj8 = null;
        eVar3.O.setTag(obj8);
        eVar3.P.setTag(obj8);
        N(view);
        eVar3.S = new b(this, i9);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.qj
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
