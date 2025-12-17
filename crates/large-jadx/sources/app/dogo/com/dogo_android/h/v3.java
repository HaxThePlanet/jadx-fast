package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public class v3 extends app.dogo.com.dogo_android.h.u3 {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private final MaterialCardView O;
    private long P;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v3.R = sparseIntArray;
        sparseIntArray.put(2131361904, 1);
        sparseIntArray.put(2131361905, 2);
        sparseIntArray.put(2131361940, 3);
    }

    public v3(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, v3.Q, v3.R));
    }

    private v3(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (AppCompatImageView)object3Arr3[1], (TextView)object3Arr3[2], (AppCompatImageView)object3Arr3[3]);
        this.P = -1;
        Object obj9 = object3Arr3[0];
        this.O = (MaterialCardView)obj9;
        obj9.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u3
    public void A() {
        this.P = 1;
        I();
        return;
        synchronized (this) {
            this.P = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u3
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.u3
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.u3
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.u3
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
