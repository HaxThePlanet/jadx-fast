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
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.l0.b;
import app.dogo.com.dogo_android.welcome_v2.d0;
import app.dogo.com.dogo_android.welcome_v2.k0;

/* loaded from: classes.dex */
public class te extends app.dogo.com.dogo_android.h.se {

    private static final ViewDataBinding.g a0;
    private static final SparseIntArray b0;
    private final ConstraintLayout Y;
    private long Z;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        te.b0 = sparseIntArray;
        sparseIntArray.put(2131361983, 3);
        sparseIntArray.put(2131361984, 4);
        sparseIntArray.put(2131362571, 5);
        sparseIntArray.put(2131363433, 6);
        sparseIntArray.put(2131363436, 7);
        sparseIntArray.put(2131363331, 8);
        sparseIntArray.put(2131362887, 9);
        sparseIntArray.put(2131362066, 10);
        sparseIntArray.put(2131362586, 11);
    }

    public te(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 12, te.a0, te.b0));
    }

    private te(e e, View view2, Object[] object3Arr3) {
        final Object obj26 = this;
        super(e, view2, 0, (AppCompatImageView)object3Arr3[3], (AppCompatImageView)object3Arr3[4], (Guideline)object3Arr3[10], (AppCompatImageView)object3Arr3[5], (Guideline)object3Arr3[11], (Button)object3Arr3[9], (ViewPager2)object3Arr3[2], (TabLayout)object3Arr3[8], (MaterialToolbar)object3Arr3[6], (TextView)object3Arr3[7], (FrameLayout)object3Arr3[1]);
        obj26.Z = -1;
        Object obj13 = object3Arr3[0];
        obj26.Y = (ConstraintLayout)obj13;
        int i14 = 0;
        obj13.setTag(i14);
        obj26.R.setTag(i14);
        obj26.V.setTag(i14);
        obj26.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.se
    public void A() {
        this.Z = 4;
        I();
        return;
        synchronized (this) {
            this.Z = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.se
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.se
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((b)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((k0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.se
    public void V(b b) {
        this.W = b;
        this.Z = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.W = b;
            this.Z = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.se
    public void W(k0 k0) {
        this.X = k0;
        this.Z = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.X = k0;
            this.Z = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.se
    protected void m() {
        int cmp;
        Object k0Var;
        int cmp2;
        int i;
        androidx.appcompat.widget.AppCompatImageView view;
        int i2;
        long l = this.Z;
        final int i4 = 0;
        this.Z = i4;
        k0Var = this.X;
        cmp2 = Long.compare(i, i4);
        final int i7 = 0;
        synchronized (this) {
            l = this.Z;
            i4 = 0;
            this.Z = i4;
            k0Var = this.X;
            cmp2 = Long.compare(i, i4);
            i7 = 0;
        }
        try {
            if (k0Var != null) {
            } else {
            }
            i2 = k0Var;
            i2 = i7;
            if (cmp2 != 0) {
            }
            d0.e(this.R, this.S, this.W, this.P, this.O, i2);
            if (Long.compare(i3, i4) != 0) {
            }
            n.k0(this.V, i7);
        }
    }

    @Override // app.dogo.com.dogo_android.h.se
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
