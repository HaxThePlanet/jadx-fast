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
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: DialogSharePromptBindingImpl.java */
/* loaded from: classes.dex */
public class t9 extends s9 implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout S;
    private final View.OnClickListener T;
    private final View.OnClickListener U;
    private long V;
    static {
        obj.put(2131362235, 3);
    }

    public t9(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, t9.W, t9.X));
    }

    @Override // app.dogo.com.dogo_android.h.s9
    public void A() {
        synchronized (this) {
            try {
                this.V = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.s9
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

    @Override // app.dogo.com.dogo_android.h.s9
    public void V(app.dogo.com.dogo_android.a0.e eVar) {
        this.R = eVar;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s9
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.R != null) {
            }
            if (i2 != 0) {
                this.R.h();
            }
        } else {
            int i3 = 2;
            if (this.R == 2) {
                if (this.R != null) {
                }
                if (i2 != 0) {
                    this.R.l();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.s9
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.V & 2L;
        if (l2 != l3) {
            this.O.setOnClickListener(this.T);
            BindingAdapters.f0(this.S, this.P);
            this.Q.setOnClickListener(this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s9
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

    private t9(androidx.databinding.e eVar, View view, Object[] objectArr) {
        final int i = 1;
        int i3 = 2;
        super(eVar, view, 0, (Button)objectArr[i], (TextView)objectArr[3], (Button)objectArr[i3]);
        this.V = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.S = obj5;
        obj5.setTag(obj4);
        this.Q.setTag(obj4);
        N(view);
        this.T = new b(this, i);
        this.U = new b(this, i3);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s9
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
