package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class n5 extends app.dogo.com.dogo_android.h.m5 {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private long P;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n5.R = sparseIntArray;
        sparseIntArray.put(2131362996, 1);
    }

    public n5(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, n5.Q, n5.R));
    }

    private n5(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ConstraintLayout)object3Arr3[0], (TextView)object3Arr3[1]);
        this.P = -1;
        this.O.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.m5
    public void A() {
        this.P = 1;
        I();
        return;
        synchronized (this) {
            this.P = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m5
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.m5
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.m5
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.m5
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
