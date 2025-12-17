package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class v2 extends app.dogo.com.dogo_android.h.u2 {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private final ConstraintLayout O;
    private long P;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v2.R = sparseIntArray;
        sparseIntArray.put(2131362634, 1);
        sparseIntArray.put(2131363509, 2);
        sparseIntArray.put(2131363414, 3);
        sparseIntArray.put(2131363315, 4);
        sparseIntArray.put(2131362276, 5);
        sparseIntArray.put(2131362327, 6);
    }

    public v2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, v2.Q, v2.R));
    }

    private v2(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[5], (Barrier)object3Arr3[6], (ImageView)object3Arr3[1], (TextView)object3Arr3[4], (TextView)object3Arr3[3], (ImageView)object3Arr3[2]);
        this.P = -1;
        Object obj12 = object3Arr3[0];
        this.O = (ConstraintLayout)obj12;
        obj12.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u2
    public void A() {
        this.P = 1;
        I();
        return;
        synchronized (this) {
            this.P = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u2
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.u2
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.u2
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.u2
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
