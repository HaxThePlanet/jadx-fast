package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.GoodTrickExample;

/* loaded from: classes.dex */
public class n3 extends app.dogo.com.dogo_android.h.m3 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n3.T = sparseIntArray;
        sparseIntArray.put(2131362112, 1);
        sparseIntArray.put(2131362964, 2);
    }

    public n3(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, n3.S, n3.T));
    }

    private n3(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (CardView)object3Arr3[1], (PlayerView)object3Arr3[2]);
        this.R = -1;
        Object obj8 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj8;
        obj8.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.m3
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m3
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.m3
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            W((GoodTrickExample)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.m3
    public void W(GoodTrickExample goodTrickExample) {
        this.P = goodTrickExample;
    }

    @Override // app.dogo.com.dogo_android.h.m3
    protected void m() {
        this.R = 0;
        return;
        synchronized (this) {
            this.R = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.m3
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
