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
import androidx.databinding.k.g;

/* compiled from: LayoutProgramOverviewPointBindingImpl.java */
/* loaded from: classes.dex */
public class jm extends im {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout P;
    private final TextView Q;
    private long R;
    static {
        obj.put(2131362087, 2);
    }

    public jm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, jm.S, jm.T));
    }

    @Override // app.dogo.com.dogo_android.h.im
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.im
    public boolean O(int i, Object object) {
        boolean z = true;
        if (124 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.im
    public void V(String str) {
        this.O = str;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(124);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.im
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.R & 3L;
        if (l2 != l3) {
            g.c(this.Q, this.O);
        }
    }

    @Override // app.dogo.com.dogo_android.h.im
    public boolean y() {
        synchronized (this) {
            try {
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private jm(e eVar, View view, Object[] objectArr) {
        final int i2 = 0;
        super(eVar, view, i2, (AppCompatImageView)objectArr[2]);
        this.R = -1L;
        Object obj3 = objectArr[i2];
        this.P = obj3;
        Object obj2 = null;
        obj3.setTag(obj2);
        Object obj4 = objectArr[1];
        this.Q = obj4;
        obj4.setTag(obj2);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.im
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
