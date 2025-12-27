package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.g.z;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: LayoutDashboardPottyProgramCardBindingImpl.java */
/* loaded from: classes.dex */
public class bj extends aj implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final View.OnClickListener T;
    private long U;
    static {
        obj.put(2131363418, 3);
    }

    public bj(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, bj.V, bj.W));
    }

    @Override // app.dogo.com.dogo_android.h.aj
    public void A() {
        synchronized (this) {
            try {
                this.U = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.aj
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

    @Override // app.dogo.com.dogo_android.h.aj
    public void T(o oVar) {
        this.S = oVar;
        synchronized (this) {
            try {
                this.U |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.aj
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.R = programDescriptionItem;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.aj
    public final void b(int i, View view) {
        int i2 = 1;
        i2 = 1;
        i2 = 0;
        int r2 = this.S != null ? 1 : i2;
        if (i2 != 0 && this.R != null) {
            if (i2 != 0) {
                this.S.onProgramOverviewSelected(this.R.getId());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.aj
    protected void m() {
        String iconUrl;
        String cardBackgroundColor = null;
        Object obj;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 5L & l;
        if (l4 == l3 || this.R == null) {
        } else {
            String name = this.R.getName();
        }
        if (l4 != l3) {
            BindingAdapters.setRatingChange(this.O, cardBackgroundColor);
            BindingAdapters.w(this.P, iconUrl);
            g.c(this.Q, obj);
        }
        long l2 = l & 4L;
        if (this.U != l3) {
            this.O.setOnClickListener(this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.aj
    public boolean y() {
        synchronized (this) {
            try {
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private bj(e eVar, View view, Object[] objectArr) {
        int i2 = 1;
        super(eVar, view, 0, (CardView)objectArr[0], (ImageView)objectArr[i2], (TextView)objectArr[2], (Guideline)objectArr[3]);
        this.U = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        this.P.setTag(obj5);
        this.Q.setTag(obj5);
        N(view);
        this.T = new b(this, i2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.aj
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
