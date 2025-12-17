package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class pk extends app.dogo.com.dogo_android.h.ok {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private final ConstraintLayout O;
    private long P;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        pk.R = sparseIntArray;
        sparseIntArray.put(2131362537, 1);
        sparseIntArray.put(2131363002, 2);
    }

    public pk(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, pk.Q, pk.R));
    }

    private pk(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (FrameLayout)object3Arr3[1], (ProgressBar)object3Arr3[2]);
        this.P = -1;
        Object obj8 = object3Arr3[0];
        this.O = (ConstraintLayout)obj8;
        obj8.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ok
    public void A() {
        this.P = 1;
        I();
        return;
        synchronized (this) {
            this.P = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ok
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ok
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.ok
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ok
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
