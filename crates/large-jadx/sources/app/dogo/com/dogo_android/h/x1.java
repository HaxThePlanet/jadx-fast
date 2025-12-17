package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent;

/* loaded from: classes.dex */
public class x1 extends app.dogo.com.dogo_android.h.w1 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private long R;
    static {
    }

    public x1(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, x1.S, x1.T));
    }

    private x1(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ConstraintLayout)object3Arr3[0], (TextView)object3Arr3[1]);
        this.R = -1;
        int obj10 = 0;
        this.O.setTag(obj10);
        this.P.setTag(obj10);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.w1
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w1
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.w1
    public boolean O(int i, Object object2) {
        int obj2;
        if (66 == i) {
            W((DogParentUIState.DogParent)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.w1
    public void W(DogParentUIState.DogParent dogParentUIState$DogParent) {
        this.Q = dogParent;
        this.R = l |= i2;
        notifyPropertyChanged(66);
        super.I();
        return;
        synchronized (this) {
            this.Q = dogParent;
            this.R = l |= i2;
            notifyPropertyChanged(66);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w1
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.R = i2;
        synchronized (this) {
            i2 = 0;
            this.R = i2;
        }
        try {
            o.w(this.P, this.Q);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.w1
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
