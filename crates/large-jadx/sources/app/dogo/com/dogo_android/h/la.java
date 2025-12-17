package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class la extends app.dogo.com.dogo_android.h.ka {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        la.U = sparseIntArray;
        sparseIntArray.put(2131363433, 1);
        sparseIntArray.put(2131363441, 2);
        sparseIntArray.put(2131363024, 3);
        sparseIntArray.put(2131362711, 4);
        sparseIntArray.put(2131363156, 5);
        sparseIntArray.put(2131362585, 6);
        sparseIntArray.put(2131362181, 7);
        sparseIntArray.put(2131362091, 8);
        sparseIntArray.put(2131362089, 9);
        sparseIntArray.put(2131363026, 10);
        sparseIntArray.put(2131363025, 11);
    }

    public la(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 12, la.T, la.U));
    }

    private la(e e, View view2, Object[] object3Arr3) {
        Object obj27 = this;
        super(e, view2, 0, (Guideline)object3Arr3[9], (Guideline)object3Arr3[8], (ClickerSoundMaterialButton)object3Arr3[7], (ConstraintLayout)object3Arr3[0], (Guideline)object3Arr3[6], (ImageView)object3Arr3[4], (ImageView)object3Arr3[3], (Guideline)object3Arr3[11], (Guideline)object3Arr3[10], (ImageView)object3Arr3[5], (AppBarLayout)object3Arr3[1], (MaterialToolbar)object3Arr3[2]);
        Object obj15 = this;
        obj15.S = -1;
        obj15.P.setTag(0);
        obj15.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ka
    public void A() {
        this.S = 1;
        I();
        return;
        synchronized (this) {
            this.S = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ka
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ka
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.ka
    protected void m() {
        this.S = 0;
        return;
        synchronized (this) {
            this.S = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ka
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
