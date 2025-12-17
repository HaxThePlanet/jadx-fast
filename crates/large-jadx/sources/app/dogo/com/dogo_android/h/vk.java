package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class vk extends app.dogo.com.dogo_android.h.uk {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private long P;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        vk.R = sparseIntArray;
        sparseIntArray.put(2131362536, 1);
        sparseIntArray.put(2131363371, 2);
        sparseIntArray.put(2131362342, 3);
    }

    public vk(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, vk.Q, vk.R));
    }

    private vk(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[3], (MaterialCardView)object3Arr3[1], (ConstraintLayout)object3Arr3[0], (TextView)object3Arr3[2]);
        this.P = -1;
        this.O.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.uk
    public void A() {
        this.P = 1;
        I();
        return;
        synchronized (this) {
            this.P = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uk
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.uk
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.uk
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.uk
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
