package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class z0 extends app.dogo.com.dogo_android.h.y0 {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S;
    private long Q;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z0.S = sparseIntArray;
        sparseIntArray.put(2131363371, 1);
        sparseIntArray.put(2131362640, 2);
    }

    public z0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, z0.R, z0.S));
    }

    private z0(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ConstraintLayout)object3Arr3[0], (CardView)object3Arr3[2], (TextView)object3Arr3[1]);
        this.Q = -1;
        this.O.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y0
    public void A() {
        this.Q = 1;
        I();
        return;
        synchronized (this) {
            this.Q = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y0
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.y0
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.y0
    protected void m() {
        this.Q = 0;
        return;
        synchronized (this) {
            this.Q = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.y0
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
