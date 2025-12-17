package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.i.h0;

/* loaded from: classes.dex */
public class bb extends app.dogo.com.dogo_android.h.ab {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        bb.T = sparseIntArray;
        sparseIntArray.put(2131363433, 1);
        sparseIntArray.put(2131362762, 2);
    }

    public bb(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, bb.S, bb.T));
    }

    private bb(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (LinearLayout)object3Arr3[2], (MaterialToolbar)object3Arr3[1]);
        this.R = -1;
        Object obj8 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj8;
        obj8.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ab
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ab
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ab
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((h0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ab
    public void V(h0 h0) {
    }

    @Override // app.dogo.com.dogo_android.h.ab
    protected void m() {
        this.R = 0;
        return;
        synchronized (this) {
            this.R = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ab
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
