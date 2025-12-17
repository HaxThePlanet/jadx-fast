package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.u.n.r.d;
import app.dogo.com.dogo_android.u.n.r.h;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.l0.b;

/* loaded from: classes.dex */
public class ff extends app.dogo.com.dogo_android.h.ef {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout V;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ff.Y = sparseIntArray;
        sparseIntArray.put(2131363433, 3);
        sparseIntArray.put(2131363331, 4);
        sparseIntArray.put(2131362887, 5);
    }

    public ff(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, ff.X, ff.Y));
    }

    private ff(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (MaterialButton)object3Arr3[5], (ViewPager2)object3Arr3[2], (TabLayout)object3Arr3[4], (MaterialToolbar)object3Arr3[3], (FrameLayout)object3Arr3[1]);
        this.W = -1;
        Object obj11 = object3Arr3[0];
        this.V = (ConstraintLayout)obj11;
        final int obj13 = 0;
        obj11.setTag(obj13);
        this.P.setTag(obj13);
        this.S.setTag(obj13);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ef
    public void A() {
        this.W = 4;
        I();
        return;
        synchronized (this) {
            this.W = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ef
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ef
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((b)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((h)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ef
    public void V(b b) {
        this.T = b;
        this.W = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.T = b;
            this.W = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ef
    public void W(h h) {
        this.U = h;
        this.W = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.U = h;
            this.W = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ef
    protected void m() {
        int cmp;
        int i;
        int cmp2;
        com.google.android.material.tabs.TabLayout tabLayout;
        long l = this.W;
        final int i3 = 0;
        this.W = i3;
        h hVar = this.U;
        cmp2 = Long.compare(i6, i3);
        final int i7 = 0;
        synchronized (this) {
            l = this.W;
            i3 = 0;
            this.W = i3;
            hVar = this.U;
            cmp2 = Long.compare(i6, i3);
            i7 = 0;
        }
        try {
            if (hVar != null) {
            } else {
            }
            i = hVar.h();
            i = i7;
            if (cmp2 != 0) {
            }
            d.b(this.P, this.Q, this.T, i);
            if (Long.compare(i2, i3) != 0) {
            }
            n.k0(this.S, i7);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ef
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
