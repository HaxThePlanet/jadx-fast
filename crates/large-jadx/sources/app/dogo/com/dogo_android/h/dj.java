package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.g.a0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: LayoutDashboardPottyProgramCardV2BindingImpl.java */
/* loaded from: classes.dex */
public class dj extends cj implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final View.OnClickListener T;
    private final View.OnClickListener U;
    private long V;
    static {
        obj.put(2131363414, 3);
        obj.put(2131362322, 4);
    }

    public dj(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, dj.W, dj.X));
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public boolean O(int i, Object object) {
        int i2 = 83;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 83;
            if (83 == i) {
                U(object);
            } else {
                i2 = 29;
                if (29 == i) {
                    T(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public void T(a0 a0Var) {
        this.R = a0Var;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public void U(String str) {
        this.S = str;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(83);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.R != null) {
            }
            if (i2 != 0) {
                this.R.onCalendarSelected("potty_card");
            }
        } else {
            int i3 = 2;
            if (this.R == 2) {
                if (this.R != null) {
                }
                if (i2 != 0) {
                    this.R.onCalendarSelected("read");
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.cj
    protected void m() {
        int cmp;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 10L & l;
        long l2 = l & 8L;
        if (this.V != l3) {
            this.O.setOnClickListener(this.T);
            this.Q.setOnClickListener(this.U);
        }
        if (l4 != l3) {
            BindingAdapters.w(this.P, this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public boolean y() {
        synchronized (this) {
            try {
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private dj(e eVar, View view, Object[] objectArr) {
        int i3 = 1;
        final int i7 = 2;
        super(eVar, view, 0, (ImageView)objectArr[4], (MaterialCardView)objectArr[0], (ImageView)objectArr[i3], (Button)objectArr[i7], (TextView)objectArr[3]);
        this.V = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        N(view);
        this.T = new b(this, i3);
        this.U = new b(this, i7);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.cj
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.cj
    public void V(PottyProgramProgress pottyProgramProgress) {
    }
}
