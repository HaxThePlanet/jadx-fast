package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class b0 extends app.dogo.com.dogo_android.h.a0 {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S;
    private final ConstraintLayout P;
    private long Q;
    static {
    }

    public b0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, b0.R, b0.S));
    }

    private b0(e e, View view2, Object[] object3Arr3) {
        final int i3 = 0;
        super(e, view2, i3, (ImageView)object3Arr3[1]);
        this.Q = -1;
        int i2 = 0;
        this.O.setTag(i2);
        Object obj5 = object3Arr3[i3];
        this.P = (ConstraintLayout)obj5;
        obj5.setTag(i2);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.a0
    public void A() {
        this.Q = 1;
        I();
        return;
        synchronized (this) {
            this.Q = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a0
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.a0
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.a0
    protected void m() {
        int cmp;
        int i;
        final int i3 = 0;
        this.Q = i3;
        synchronized (this) {
            i3 = 0;
            this.Q = i3;
        }
        try {
            n.g0(this.O, 0);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.a0
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
