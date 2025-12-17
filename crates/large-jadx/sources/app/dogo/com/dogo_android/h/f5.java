package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class f5 extends app.dogo.com.dogo_android.h.e5 {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f5.Y = sparseIntArray;
        sparseIntArray.put(2131363448, 1);
        sparseIntArray.put(2131362111, 2);
        sparseIntArray.put(2131362119, 3);
        sparseIntArray.put(2131362167, 4);
        sparseIntArray.put(2131362124, 5);
        sparseIntArray.put(2131362190, 6);
        sparseIntArray.put(2131362117, 7);
        sparseIntArray.put(2131361940, 8);
        sparseIntArray.put(2131362068, 9);
        sparseIntArray.put(2131362646, 10);
    }

    public f5(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 11, f5.X, f5.Y));
    }

    private f5(e e, View view2, Object[] object3Arr3) {
        final Object obj25 = this;
        super(e, view2, 0, (ImageView)object3Arr3[8], (ImageView)object3Arr3[9], (CardView)object3Arr3[2], (TextView)object3Arr3[7], (ImageView)object3Arr3[3], (TextView)object3Arr3[5], (ConstraintLayout)object3Arr3[0], (ImageView)object3Arr3[4], (ImageView)object3Arr3[6], (ImageView)object3Arr3[10], (ImageView)object3Arr3[1]);
        obj25.W = -1;
        obj25.S.setTag(0);
        obj25.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.e5
    public void A() {
        this.W = 1;
        I();
        return;
        synchronized (this) {
            this.W = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.e5
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.e5
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.e5
    protected void m() {
        this.W = 0;
        return;
        synchronized (this) {
            this.W = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.e5
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
