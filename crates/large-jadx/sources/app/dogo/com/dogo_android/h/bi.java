package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class bi extends app.dogo.com.dogo_android.h.ai {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        bi.T = sparseIntArray;
        sparseIntArray.put(2131363059, 1);
        sparseIntArray.put(2131362292, 2);
        sparseIntArray.put(2131361935, 3);
    }

    public bi(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, bi.S, bi.T));
    }

    private bi(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (AppCompatImageView)object3Arr3[3], (TextView)object3Arr3[2], (TextView)object3Arr3[1]);
        this.R = -1;
        Object obj9 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj9;
        obj9.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ai
    public void A() {
        this.R = 1;
        I();
        return;
        synchronized (this) {
            this.R = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ai
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ai
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.ai
    protected void m() {
        this.R = 0;
        return;
        synchronized (this) {
            this.R = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ai
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
