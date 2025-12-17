package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class vc extends app.dogo.com.dogo_android.h.uc {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        vc.T = sparseIntArray;
        sparseIntArray.put(2131362557, 1);
        sparseIntArray.put(2131362105, 2);
        sparseIntArray.put(2131362711, 3);
        sparseIntArray.put(2131363156, 4);
        sparseIntArray.put(2131362632, 5);
        sparseIntArray.put(2131363314, 6);
        sparseIntArray.put(2131363414, 7);
        sparseIntArray.put(2131363159, 8);
        sparseIntArray.put(2131362714, 9);
    }

    public vc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 10, vc.S, vc.T));
    }

    private vc(e e, View view2, Object[] object3Arr3) {
        final Object obj22 = this;
        super(e, view2, 0, (TextView)object3Arr3[2], (Button)object3Arr3[1], (ImageView)object3Arr3[5], (ImageView)object3Arr3[3], (Guideline)object3Arr3[9], (ImageView)object3Arr3[4], (Guideline)object3Arr3[8], (TextView)object3Arr3[6], (TextView)object3Arr3[7]);
        obj22.R = -1;
        Object obj11 = object3Arr3[0];
        obj22.Q = (ConstraintLayout)obj11;
        obj11.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.uc
    public void A() {
        this.R = 1;
        I();
        return;
        synchronized (this) {
            this.R = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uc
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.uc
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.uc
    protected void m() {
        this.R = 0;
        return;
        synchronized (this) {
            this.R = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.uc
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
