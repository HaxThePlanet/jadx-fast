package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.service.v2.b;
import app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters;

/* loaded from: classes.dex */
public class nk extends app.dogo.com.dogo_android.h.mk {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        nk.W = sparseIntArray;
        sparseIntArray.put(2131363412, 2);
        sparseIntArray.put(2131363413, 3);
    }

    public nk(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, nk.V, nk.W));
    }

    private nk(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[1], (TextView)object3Arr3[2], (TextView)object3Arr3[3]);
        this.U = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.T = (ConstraintLayout)obj9;
        obj9.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.mk
    public void A() {
        this.U = 4;
        I();
        return;
        synchronized (this) {
            this.U = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mk
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.mk
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (156 == i) {
            T((Long)object2);
            obj2 = 1;
        } else {
            if (158 == i) {
                U((v2.b)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.mk
    public void T(Long long) {
        this.S = long;
        this.U = l |= i2;
        notifyPropertyChanged(156);
        super.I();
        return;
        synchronized (this) {
            this.S = long;
            this.U = l |= i2;
            notifyPropertyChanged(156);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mk
    public void U(v2.b v2$b) {
        this.R = b;
        this.U = l |= i2;
        notifyPropertyChanged(158);
        super.I();
        return;
        synchronized (this) {
            this.R = b;
            this.U = l |= i2;
            notifyPropertyChanged(158);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mk
    protected void m() {
        int cmp;
        TextView view;
        int i;
        long l = this.U;
        i = 0;
        this.U = i;
        synchronized (this) {
            l = this.U;
            i = 0;
            this.U = i;
        }
        try {
            SubscriptionBindingAdapters.setDiscountTimerLabel(this.O, this.R);
            if (Long.compare(i4, i) != 0) {
            }
            SubscriptionBindingAdapters.setupTimerSegment(this.T, this.S, this.Q, this.P);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.mk
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
