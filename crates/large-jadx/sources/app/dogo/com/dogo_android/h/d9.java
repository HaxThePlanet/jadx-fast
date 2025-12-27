package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.a0.d;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;

/* compiled from: DialogInAppRateBindingImpl.java */
/* loaded from: classes.dex */
public class d9 extends c9 implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout R;
    private final View.OnClickListener S;
    private final View.OnClickListener T;
    private long U;
    static {
        obj.put(2131363421, 3);
        obj.put(2131362235, 4);
    }

    public d9(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, d9.V, d9.W));
    }

    @Override // app.dogo.com.dogo_android.h.c9
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.c9
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

    @Override // app.dogo.com.dogo_android.h.c9
    public void V(d dVar) {
        this.Q = dVar;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.c9
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.Q != null) {
            }
            if (i2 != 0) {
                this.Q.i();
            }
        } else {
            int i3 = 2;
            if (this.Q == 2) {
                if (this.Q != null) {
                }
                if (i2 != 0) {
                    this.Q.n();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.c9
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

    @Override // app.dogo.com.dogo_android.h.c9
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

    private d9(e eVar, View view, Object[] objectArr) {
        final int i = 1;
        int i3 = 2;
        super(eVar, view, 0, (Button)objectArr[i], (TextView)objectArr[4], (Button)objectArr[i3], (TextView)objectArr[3]);
        this.U = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        Object obj6 = objectArr[0];
        this.R = obj6;
        obj6.setTag(obj5);
        this.P.setTag(obj5);
        N(view);
        this.S = new b(this, i);
        this.T = new b(this, i3);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c9
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
