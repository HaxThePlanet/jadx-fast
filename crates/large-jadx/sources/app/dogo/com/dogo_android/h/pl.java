package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextSwitcher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.u.n.p.e;

/* loaded from: classes.dex */
public class pl extends app.dogo.com.dogo_android.h.ol {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
    }

    public pl(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, pl.S, pl.T));
    }

    private pl(e e, View view2, Object[] object3Arr3) {
        final int i2 = 0;
        super(e, view2, i2, (TextSwitcher)object3Arr3[1]);
        this.R = -1;
        Object obj5 = object3Arr3[i2];
        this.Q = (ConstraintLayout)obj5;
        final int obj7 = 0;
        obj5.setTag(obj7);
        this.O.setTag(obj7);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ol
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ol
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ol
    public boolean O(int i, Object object2) {
        int obj2;
        if (112 == i) {
            U((Integer)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ol
    public void U(Integer integer) {
        this.P = integer;
        this.R = l |= i2;
        notifyPropertyChanged(112);
        super.I();
        return;
        synchronized (this) {
            this.P = integer;
            this.R = l |= i2;
            notifyPropertyChanged(112);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ol
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.R = i2;
        synchronized (this) {
            i2 = 0;
            this.R = i2;
        }
        try {
            e.r(this.O, this.P);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ol
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
