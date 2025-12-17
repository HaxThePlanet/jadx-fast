package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks;

/* loaded from: classes.dex */
public class jj extends app.dogo.com.dogo_android.h.ij {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        jj.U = sparseIntArray;
        sparseIntArray.put(2131363414, 2);
    }

    public jj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, jj.T, jj.U));
    }

    private jj(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (RecyclerView)object3Arr3[1]);
        this.S = -1;
        Object obj8 = object3Arr3[0];
        this.R = (ConstraintLayout)obj8;
        final int obj10 = 0;
        obj8.setTag(obj10);
        this.O.setTag(obj10);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ij
    public void A() {
        this.S = 4;
        I();
        return;
        synchronized (this) {
            this.S = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ij
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ij
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (131 == i) {
            W((RecentlyViewedTricks)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                V((o.a)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ij
    public void V(o.a o$a) {
        this.Q = a;
        this.S = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Q = a;
            this.S = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ij
    public void W(RecentlyViewedTricks recentlyViewedTricks) {
        this.P = recentlyViewedTricks;
        this.S = l |= i2;
        notifyPropertyChanged(131);
        super.I();
        return;
        synchronized (this) {
            this.P = recentlyViewedTricks;
            this.S = l |= i2;
            notifyPropertyChanged(131);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ij
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.S = i2;
        synchronized (this) {
            i2 = 0;
            this.S = i2;
        }
        try {
            i.o(this.O, this.P, this.Q);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ij
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
