package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.c.i;

/* loaded from: classes.dex */
public class jg extends app.dogo.com.dogo_android.h.ig {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private final ConstraintLayout O;
    private long P;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        jg.R = sparseIntArray;
        sparseIntArray.put(2131363547, 1);
        sparseIntArray.put(2131362931, 2);
        sparseIntArray.put(2131362110, 3);
    }

    public jg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, jg.Q, jg.R));
    }

    private jg(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageButton)object3Arr3[3], (View)object3Arr3[2], (SurfaceView)object3Arr3[1]);
        this.P = -1;
        Object obj9 = object3Arr3[0];
        this.O = (ConstraintLayout)obj9;
        obj9.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ig
    public void A() {
        this.P = 2;
        I();
        return;
        synchronized (this) {
            this.P = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ig
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ig
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((i)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ig
    public void V(i i) {
    }

    @Override // app.dogo.com.dogo_android.h.ig
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ig
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
