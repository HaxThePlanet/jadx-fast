package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.a0.g.f.d0;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class vm extends app.dogo.com.dogo_android.h.um {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
    }

    public vm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, vm.S, vm.T));
    }

    private vm(e e, View view2, Object[] object3Arr3) {
        int i = 1;
        super(e, view2, i, (ImageView)object3Arr3[i]);
        this.R = -1;
        Object obj3 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj3;
        final int obj5 = 0;
        obj3.setTag(obj5);
        this.O.setTag(obj5);
        N(view2);
        A();
    }

    private boolean U(d0 d0, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.R = l2 |= i6;
            return obj5;
            synchronized (this) {
                this.R = l2 |= i6;
                return obj5;
            }
        }
        if (i2 == 169) {
            this.R = l |= i5;
            return obj5;
            synchronized (this) {
                this.R = l |= i5;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.um
    public void A() {
        this.R = 4;
        I();
        return;
        synchronized (this) {
            this.R = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.um
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return U((d0)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.um
    public boolean O(int i, Object object2) {
        int obj2;
        if (183 == i) {
            T((d0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.um
    public void T(d0 d0) {
        R(0, d0);
        this.P = d0;
        this.R = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, d0);
            this.P = d0;
            this.R = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.um
    protected void m() {
        int cmp;
        int i;
        final int i3 = 0;
        this.R = i3;
        final d0 d0Var = this.P;
        i = 0;
        cmp = Long.compare(i2, i3);
        synchronized (this) {
            i3 = 0;
            this.R = i3;
            d0Var = this.P;
            i = 0;
            cmp = Long.compare(i2, i3);
        }
        try {
            if (d0Var != null) {
            }
            i = d0Var.P();
            if (cmp != 0) {
            }
            n.w(this.O, i);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.um
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
