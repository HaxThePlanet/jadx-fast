package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class z6 extends app.dogo.com.dogo_android.h.y6 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z6.T = sparseIntArray;
        sparseIntArray.put(2131362088, 1);
        sparseIntArray.put(2131362692, 2);
    }

    public z6(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, z6.S, z6.T));
    }

    private z6(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (Button)object3Arr3[1], (TextView)object3Arr3[2]);
        this.R = -1;
        Object obj8 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj8;
        obj8.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y6
    public void A() {
        this.R = 1;
        I();
        return;
        synchronized (this) {
            this.R = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y6
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.y6
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.y6
    protected void m() {
        this.R = 0;
        return;
        synchronized (this) {
            this.R = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.y6
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
