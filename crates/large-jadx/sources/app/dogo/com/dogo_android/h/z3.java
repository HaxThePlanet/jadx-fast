package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;

/* compiled from: CellPottyTrackerOverviewBindingImpl.java */
/* loaded from: classes.dex */
public class z3 extends y3 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout P;
    private final AppCompatImageView Q;
    private long R;
    public z3(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, z3.S, z3.T));
    }

    @Override // app.dogo.com.dogo_android.h.y3
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.y3
    public boolean O(int i, Object object) {
        boolean z = true;
        if (86 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.y3
    public void V(Integer integer) {
        this.O = integer;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(86);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.y3
    protected void m() {
        int i = 0;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        i = 0;
        long l2 = this.R & 3L;
        if (l2 != l3) {
            i = ViewDataBinding.J(this.O);
        }
        if (l2 != l3) {
            this.Q.setImageResource(i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.y3
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

    private z3(e eVar, View view, Object[] objectArr) {
        int i = 0;
        super(eVar, view, i);
        this.R = -1L;
        Object obj2 = objectArr[i];
        this.P = obj2;
        Object obj = null;
        obj2.setTag(obj);
        Object obj3 = objectArr[1];
        this.Q = obj3;
        obj3.setTag(obj);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.y3
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
