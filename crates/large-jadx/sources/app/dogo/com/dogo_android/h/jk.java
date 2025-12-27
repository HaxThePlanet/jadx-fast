package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.g.e0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;

/* compiled from: LayoutDashboardWorkoutLockedCardBindingImpl.java */
/* loaded from: classes.dex */
public class jk extends ik implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final CardView R;
    private final View.OnClickListener S;
    private final View.OnClickListener T;
    private long U;
    static {
        obj.put(2131362633, 3);
        obj.put(2131362711, 4);
        obj.put(2131363414, 5);
        obj.put(2131362298, 6);
        obj.put(2131363156, 7);
    }

    public jk(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, jk.V, jk.W));
    }

    @Override // app.dogo.com.dogo_android.h.ik
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ik
    public boolean O(int i, Object object) {
        boolean z = true;
        if (29 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ik
    public void T(e0 e0Var) {
        this.Q = e0Var;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ik
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.Q != null) {
            }
            if (i2 != 0) {
                this.Q.onExploreTricksSelected();
            }
        } else {
            int i3 = 2;
            if (this.Q == 2) {
                if (this.Q != null) {
                }
                if (i2 != 0) {
                    this.Q.m0();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ik
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

    @Override // app.dogo.com.dogo_android.h.ik
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

    private jk(e eVar, View view, Object[] objectArr) {
        final b.a eVar3 = this;
        final int i9 = 1;
        final int i10 = 2;
        super(eVar, view, 0, (TextView)objectArr[6], (ImageView)objectArr[3], (ImageView)objectArr[i9], (ImageView)objectArr[4], (ImageView)objectArr[7], (Button)objectArr[i10], (TextView)objectArr[5]);
        eVar3.U = -1L;
        Object obj9 = null;
        eVar3.O.setTag(obj9);
        Object obj8 = objectArr[0];
        eVar3.R = obj8;
        obj8.setTag(obj9);
        eVar3.P.setTag(obj9);
        N(view);
        eVar3.S = new b(this, i9);
        eVar3.T = new b(this, i10);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ik
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
