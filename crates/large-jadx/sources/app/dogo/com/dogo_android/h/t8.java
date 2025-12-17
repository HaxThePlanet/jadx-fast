package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class t8 extends app.dogo.com.dogo_android.h.s8 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final FrameLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t8.U = sparseIntArray;
        sparseIntArray.put(2131363421, 1);
        sparseIntArray.put(2131362611, 2);
        sparseIntArray.put(2131362673, 3);
        sparseIntArray.put(2131362927, 4);
        sparseIntArray.put(2131362105, 5);
    }

    public t8(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, t8.T, t8.U));
    }

    private t8(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (Button)object3Arr3[5], (ImageView)object3Arr3[2], (RelativeLayout)object3Arr3[3], (RelativeLayout)object3Arr3[4], (TextView)object3Arr3[1]);
        this.S = -1;
        Object obj11 = object3Arr3[0];
        this.R = (FrameLayout)obj11;
        obj11.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s8
    public void A() {
        this.S = 1;
        I();
        return;
        synchronized (this) {
            this.S = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s8
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.s8
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.s8
    protected void m() {
        this.S = 0;
        return;
        synchronized (this) {
            this.S = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.s8
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
