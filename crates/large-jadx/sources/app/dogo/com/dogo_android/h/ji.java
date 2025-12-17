package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class ji extends app.dogo.com.dogo_android.h.ii {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private final ConstraintLayout O;
    private long P;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ji.R = sparseIntArray;
        sparseIntArray.put(2131362542, 1);
        sparseIntArray.put(2131362975, 2);
        sparseIntArray.put(2131362022, 3);
        sparseIntArray.put(2131362019, 4);
        sparseIntArray.put(2131362021, 5);
        sparseIntArray.put(2131362018, 6);
        sparseIntArray.put(2131362030, 7);
        sparseIntArray.put(2131362028, 8);
        sparseIntArray.put(2131362025, 9);
        sparseIntArray.put(2131362027, 10);
        sparseIntArray.put(2131362024, 11);
        sparseIntArray.put(2131362035, 12);
        sparseIntArray.put(2131362032, 13);
        sparseIntArray.put(2131362034, 14);
        sparseIntArray.put(2131362031, 15);
        sparseIntArray.put(2131362041, 16);
        sparseIntArray.put(2131362040, 17);
        sparseIntArray.put(2131362038, 18);
        sparseIntArray.put(2131362039, 19);
        sparseIntArray.put(2131362037, 20);
        sparseIntArray.put(2131362045, 21);
        sparseIntArray.put(2131362043, 22);
        sparseIntArray.put(2131362044, 23);
        sparseIntArray.put(2131362042, 24);
        sparseIntArray.put(2131362050, 25);
        sparseIntArray.put(2131362049, 26);
        sparseIntArray.put(2131362047, 27);
        sparseIntArray.put(2131362048, 28);
        sparseIntArray.put(2131362046, 29);
    }

    public ji(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 30, ji.Q, ji.R));
    }

    private ji(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 0, (ImageView)object3Arr3[6], (TextView)object3Arr3[4], (TextView)object3Arr3[5], (TextView)object3Arr3[3], (ImageView)object3Arr3[11], (TextView)object3Arr3[9], (ImageView)object3Arr3[10], (TextView)object3Arr3[8], (ConstraintLayout)object3Arr3[7], (ImageView)object3Arr3[15], (TextView)object3Arr3[13], (ImageView)object3Arr3[14], (TextView)object3Arr3[12], (ImageView)object3Arr3[20], (ImageView)object3Arr3[18], (ImageView)object3Arr3[19], (TextView)object3Arr3[17], (ConstraintLayout)object3Arr3[16], (ImageView)object3Arr3[24], (ImageView)object3Arr3[22], (ImageView)object3Arr3[23], (TextView)object3Arr3[21], (ImageView)object3Arr3[29], (ImageView)object3Arr3[27], (ImageView)object3Arr3[28], (TextView)object3Arr3[26], (ConstraintLayout)object3Arr3[25], (TextView)object3Arr3[1], (TextView)object3Arr3[2]);
        Object obj4 = this;
        obj4.P = -1;
        Object obj2 = object3Arr3[0];
        obj4.O = (ConstraintLayout)obj2;
        obj2.setTag(0);
        obj4.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ii
    public void A() {
        this.P = 1;
        I();
        return;
        synchronized (this) {
            this.P = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ii
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ii
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.ii
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ii
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
