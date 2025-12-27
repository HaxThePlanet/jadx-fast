package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: FragmentEmptyBindingImpl.java */
/* loaded from: classes.dex */
public class tc extends sc {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private final ConstraintLayout O;
    private long P;
    public tc(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 1, tc.Q, tc.R));
    }

    @Override // app.dogo.com.dogo_android.h.sc
    public void A() {
        synchronized (this) {
            try {
                this.P = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.sc
    protected void m() {
        synchronized (this) {
            try {
                this.P = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.sc
    public boolean y() {
        synchronized (this) {
            try {
                if (this.P != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private tc(e eVar, View view, Object[] objectArr) {
        final int i = 0;
        super(eVar, view, i);
        this.P = -1L;
        final Object obj = objectArr[i];
        this.O = obj;
        obj.setTag(null);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.sc
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.sc
    public boolean O(int i, Object object) {
        return true;
    }
}
