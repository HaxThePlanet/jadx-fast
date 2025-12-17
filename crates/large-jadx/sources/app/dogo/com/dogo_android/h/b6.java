package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class b6 extends app.dogo.com.dogo_android.h.a6 {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S;
    private long Q;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        b6.S = sparseIntArray;
        sparseIntArray.put(2131361930, 1);
    }

    public b6(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, b6.R, b6.S));
    }

    private b6(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[1], (CardView)object3Arr3[0]);
        this.Q = -1;
        this.P.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.a6
    public void A() {
        this.Q = 1;
        I();
        return;
        synchronized (this) {
            this.Q = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a6
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.a6
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.a6
    protected void m() {
        this.Q = 0;
        return;
        synchronized (this) {
            this.Q = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.a6
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
