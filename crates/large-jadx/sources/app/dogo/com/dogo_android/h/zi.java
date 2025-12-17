package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class zi extends app.dogo.com.dogo_android.h.yi {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zi.T = sparseIntArray;
        sparseIntArray.put(2131361924, 1);
        sparseIntArray.put(2131361982, 2);
        sparseIntArray.put(2131362829, 3);
        sparseIntArray.put(2131362298, 4);
    }

    public zi(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, zi.S, zi.T));
    }

    private zi(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (AppCompatImageView)object3Arr3[1], (FrameLayout)object3Arr3[2], (TextView)object3Arr3[4], (Button)object3Arr3[3]);
        this.R = -1;
        Object obj10 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj10;
        obj10.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yi
    public void A() {
        this.R = 1;
        I();
        return;
        synchronized (this) {
            this.R = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yi
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.yi
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.yi
    protected void m() {
        this.R = 0;
        return;
        synchronized (this) {
            this.R = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.yi
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
