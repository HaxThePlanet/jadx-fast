package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class ph extends app.dogo.com.dogo_android.h.oh {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S;
    private long Q;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ph.S = sparseIntArray;
        sparseIntArray.put(2131362536, 1);
        sparseIntArray.put(2131362342, 2);
        sparseIntArray.put(2131363364, 3);
        sparseIntArray.put(2131362979, 4);
    }

    public ph(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, ph.R, ph.S));
    }

    private ph(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ConstraintLayout)object3Arr3[0], (ImageView)object3Arr3[2], (MaterialCardView)object3Arr3[1], (ImageView)object3Arr3[4], (TextView)object3Arr3[3]);
        this.Q = -1;
        this.O.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.oh
    public void A() {
        this.Q = 1;
        I();
        return;
        synchronized (this) {
            this.Q = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oh
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.oh
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.oh
    protected void m() {
        this.Q = 0;
        return;
        synchronized (this) {
            this.Q = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.oh
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
