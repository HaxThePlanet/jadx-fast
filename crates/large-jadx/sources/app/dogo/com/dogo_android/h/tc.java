package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class tc extends app.dogo.com.dogo_android.h.sc {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private final ConstraintLayout O;
    private long P;
    static {
    }

    public tc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 1, tc.Q, tc.R));
    }

    private tc(e e, View view2, Object[] object3Arr3) {
        final int i = 0;
        super(e, view2, i);
        this.P = -1;
        final Object obj4 = object3Arr3[i];
        this.O = (ConstraintLayout)obj4;
        obj4.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.sc
    public void A() {
        this.P = 1;
        I();
        return;
        synchronized (this) {
            this.P = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sc
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.sc
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.sc
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.sc
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
