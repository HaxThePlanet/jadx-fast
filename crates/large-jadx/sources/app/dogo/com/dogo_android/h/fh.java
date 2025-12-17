package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class fh extends app.dogo.com.dogo_android.h.eh {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        fh.T = sparseIntArray;
        sparseIntArray.put(2131362193, 1);
        sparseIntArray.put(2131362229, 2);
        sparseIntArray.put(2131363414, 3);
        sparseIntArray.put(2131362298, 4);
        sparseIntArray.put(2131363454, 5);
        sparseIntArray.put(2131363310, 6);
    }

    public fh(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, fh.S, fh.T));
    }

    private fh(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[1], (ImageView)object3Arr3[2], (TextView)object3Arr3[4], (MaterialButton)object3Arr3[6], (TextView)object3Arr3[3], (AppCompatImageView)object3Arr3[5]);
        this.R = -1;
        Object obj12 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj12;
        obj12.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.eh
    public void A() {
        this.R = 1;
        I();
        return;
        synchronized (this) {
            this.R = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.eh
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.eh
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.eh
    protected void m() {
        int cmp;
        int i;
        final int i3 = 0;
        this.R = i3;
        synchronized (this) {
            i3 = 0;
            this.R = i3;
        }
        try {
            n.k0(this.Q, 0);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.eh
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
