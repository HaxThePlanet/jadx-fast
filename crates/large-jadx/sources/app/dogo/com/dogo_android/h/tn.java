package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class tn extends app.dogo.com.dogo_android.h.sn {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S;
    private final ConstraintLayout P;
    private long Q;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        tn.S = sparseIntArray;
        sparseIntArray.put(2131362298, 1);
        sparseIntArray.put(2131362093, 2);
    }

    public tn(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, tn.R, tn.S));
    }

    private tn(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (MaterialButton)object3Arr3[2], (TextView)object3Arr3[1]);
        this.Q = -1;
        Object obj8 = object3Arr3[0];
        this.P = (ConstraintLayout)obj8;
        obj8.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.sn
    public void A() {
        this.Q = 1;
        I();
        return;
        synchronized (this) {
            this.Q = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sn
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.sn
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.sn
    protected void m() {
        this.Q = 0;
        return;
        synchronized (this) {
            this.Q = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.sn
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
