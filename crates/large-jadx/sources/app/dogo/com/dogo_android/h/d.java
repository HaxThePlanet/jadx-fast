package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.dogcreation.g;

/* loaded from: classes.dex */
public class d extends app.dogo.com.dogo_android.h.c {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private long P;
    static {
    }

    public d(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 1, d.Q, d.R));
    }

    private d(e e, View view2, Object[] object3Arr3) {
        int i = 0;
        super(e, view2, i, (FrameLayout)object3Arr3[i]);
        this.P = -1;
        this.O.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c
    public void A() {
        this.P = 2;
        I();
        return;
        synchronized (this) {
            this.P = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.c
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            T((g)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.c
    public void T(g g) {
    }

    @Override // app.dogo.com.dogo_android.h.c
    protected void m() {
        this.P = 0;
        return;
        synchronized (this) {
            this.P = 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.c
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
