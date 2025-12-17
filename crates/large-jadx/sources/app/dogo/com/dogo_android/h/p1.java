package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class p1 extends app.dogo.com.dogo_android.h.o1 {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private final ConstraintLayout O;
    private long P;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p1.R = sparseIntArray;
        sparseIntArray.put(2131362511, 1);
        sparseIntArray.put(2131362335, 2);
        sparseIntArray.put(2131363202, 3);
    }

    public p1(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, p1.Q, p1.R));
    }

    private p1(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (ImageView)object3Arr3[1], (ImageView)object3Arr3[3]);
        this.P = -1;
        Object obj9 = object3Arr3[0];
        this.O = (ConstraintLayout)obj9;
        obj9.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o1
    public void A() {
        this.P = 1;
        I();
        return;
        synchronized (this) {
            this.P = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o1
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.o1
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.o1
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.o1
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
