package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class r0 extends app.dogo.com.dogo_android.h.q0 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r0.U = sparseIntArray;
        sparseIntArray.put(2131362980, 1);
        sparseIntArray.put(2131362982, 2);
        sparseIntArray.put(2131362388, 3);
        sparseIntArray.put(2131362157, 4);
    }

    public r0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, r0.T, r0.U));
    }

    private r0(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[4], (ImageView)object3Arr3[3], (ImageView)object3Arr3[1], (TextView)object3Arr3[2]);
        this.S = -1;
        Object obj10 = object3Arr3[0];
        this.R = (ConstraintLayout)obj10;
        obj10.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.q0
    public void A() {
        this.S = 1;
        I();
        return;
        synchronized (this) {
            this.S = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q0
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.q0
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.q0
    protected void m() {
        this.S = 0;
        return;
        synchronized (this) {
            this.S = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.q0
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
