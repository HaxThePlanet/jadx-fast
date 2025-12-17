package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class le extends app.dogo.com.dogo_android.h.ke {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        le.T = sparseIntArray;
        sparseIntArray.put(2131363433, 1);
        sparseIntArray.put(2131362342, 2);
        sparseIntArray.put(2131363414, 3);
        sparseIntArray.put(2131362298, 4);
        sparseIntArray.put(2131362888, 5);
    }

    public le(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, le.S, le.T));
    }

    private le(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[4], (AppCompatImageView)object3Arr3[2], (MaterialButton)object3Arr3[5], (TextView)object3Arr3[3], (MaterialToolbar)object3Arr3[1]);
        this.R = -1;
        Object obj11 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj11;
        obj11.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ke
    public void A() {
        this.R = 1;
        I();
        return;
        synchronized (this) {
            this.R = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ke
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ke
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.ke
    protected void m() {
        this.R = 0;
        return;
        synchronized (this) {
            this.R = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ke
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
