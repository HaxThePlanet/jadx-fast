package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class jd extends app.dogo.com.dogo_android.h.id {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S;
    private final ConstraintLayout P;
    private long Q;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        jd.S = sparseIntArray;
        sparseIntArray.put(2131363433, 1);
        sparseIntArray.put(2131363421, 2);
        sparseIntArray.put(2131362301, 3);
        sparseIntArray.put(2131362342, 4);
        sparseIntArray.put(2131362062, 5);
    }

    public jd(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, jd.R, jd.S));
    }

    private jd(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (FrameLayout)object3Arr3[5], (TextView)object3Arr3[3], (ImageView)object3Arr3[4], (TextView)object3Arr3[2], (MaterialToolbar)object3Arr3[1]);
        this.Q = -1;
        Object obj11 = object3Arr3[0];
        this.P = (ConstraintLayout)obj11;
        obj11.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.id
    public void A() {
        this.Q = 1;
        I();
        return;
        synchronized (this) {
            this.Q = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.id
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.id
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.id
    protected void m() {
        this.Q = 0;
        return;
        synchronized (this) {
            this.Q = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.id
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
