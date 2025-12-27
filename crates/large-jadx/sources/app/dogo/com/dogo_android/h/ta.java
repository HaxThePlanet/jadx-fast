package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;

/* compiled from: FragmentDailyWorkoutUnlockedBindingImpl.java */
/* loaded from: classes.dex */
public class ta extends sa implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final CoordinatorLayout R;
    private final View.OnClickListener S;
    private final View.OnClickListener T;
    private long U;
    static {
        obj.put(2131362339, 3);
        obj.put(2131363414, 4);
        obj.put(2131362298, 5);
    }

    public ta(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, ta.V, ta.W));
    }

    @Override // app.dogo.com.dogo_android.h.sa
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.sa
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.sa
    public void V(app.dogo.com.dogo_android.f.n.e eVar) {
        this.Q = eVar;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sa
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.Q != null) {
            }
            if (i2 != 0) {
                this.Q.k();
            }
        } else {
            int i3 = 2;
            if (this.Q == 2) {
                if (this.Q != null) {
                }
                if (i2 != 0) {
                    this.Q.j();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.sa
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.U & 2L;
        if (l2 != l3) {
            this.O.setOnClickListener(this.S);
            this.P.setOnClickListener(this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.sa
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

    private ta(androidx.databinding.e eVar, View view, Object[] objectArr) {
        int i3 = 2;
        final int i7 = 1;
        super(eVar, view, 0, (TextView)objectArr[5], (LottieAnimationView)objectArr[3], (Button)objectArr[i3], (TextView)objectArr[4], (Button)objectArr[i7]);
        this.U = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        Object obj7 = objectArr[0];
        this.R = obj7;
        obj7.setTag(obj6);
        this.P.setTag(obj6);
        N(view);
        this.S = new b(this, i3);
        this.T = new b(this, i7);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.sa
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
