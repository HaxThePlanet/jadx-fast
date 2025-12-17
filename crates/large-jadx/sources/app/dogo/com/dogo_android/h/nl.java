package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class nl extends app.dogo.com.dogo_android.h.ml {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private final ConstraintLayout O;
    private long P;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        nl.R = sparseIntArray;
        sparseIntArray.put(2131363002, 1);
    }

    public nl(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, nl.Q, nl.R));
    }

    private nl(e e, View view2, Object[] object3Arr3) {
        final int i2 = 0;
        super(e, view2, i2, (ProgressBar)object3Arr3[1]);
        this.P = -1;
        final Object obj5 = object3Arr3[i2];
        this.O = (ConstraintLayout)obj5;
        obj5.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ml
    public void A() {
        this.P = 1;
        I();
        return;
        synchronized (this) {
            this.P = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ml
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ml
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.ml
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ml
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
