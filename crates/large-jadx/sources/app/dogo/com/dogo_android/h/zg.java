package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.f.l.i.b;
import app.dogo.com.dogo_android.f.l.l;
import app.dogo.com.dogo_android.util.f0.m;

/* loaded from: classes.dex */
public class zg extends app.dogo.com.dogo_android.h.yg {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private long X;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zg.Z = sparseIntArray;
        sparseIntArray.put(2131363279, 3);
        sparseIntArray.put(2131363433, 4);
        sparseIntArray.put(2131363005, 5);
        sparseIntArray.put(2131363554, 6);
        sparseIntArray.put(2131362371, 7);
    }

    public zg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, zg.Y, zg.Z));
    }

    private zg(e e, View view2, Object[] object3Arr3) {
        final Object obj19 = this;
        super(e, view2, 0, (ConstraintLayout)object3Arr3[0], (ClickerSoundMaterialButton)object3Arr3[2], (ViewPagerCustomDuration)object3Arr3[1], (View)object3Arr3[7], (SegmentedProgressBar)object3Arr3[5], (Guideline)object3Arr3[3], (MaterialToolbar)object3Arr3[4], (View)object3Arr3[6]);
        obj19.X = -1;
        int i10 = 0;
        obj19.O.setTag(i10);
        obj19.P.setTag(i10);
        obj19.Q.setTag(i10);
        View view3 = view2;
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yg
    public void A() {
        this.X = 4;
        I();
        return;
        synchronized (this) {
            this.X = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yg
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.yg
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (119 == i) {
            V((i.b)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((l)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.yg
    public void V(i.b i$b) {
        this.W = b;
        this.X = l |= i2;
        notifyPropertyChanged(119);
        super.I();
        return;
        synchronized (this) {
            this.W = b;
            this.X = l |= i2;
            notifyPropertyChanged(119);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yg
    public void W(l l) {
        this.V = l;
        this.X = l2 |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.V = l;
            this.X = l2 |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yg
    protected void m() {
        int cmp;
        app.dogo.com.dogo_android.util.ViewPagerCustomDuration view;
        int i;
        long l = this.X;
        final int i3 = 0;
        this.X = i3;
        i = 0;
        final l lVar = this.V;
        int cmp2 = Long.compare(i5, i3);
        synchronized (this) {
            l = this.X;
            i3 = 0;
            this.X = i3;
            i = 0;
            lVar = this.V;
            cmp2 = Long.compare(i5, i3);
        }
        try {
            if (lVar != null) {
            }
            i = lVar.r();
            if (Long.compare(i2, i3) != 0) {
            }
            m.c(this.P, this.Q);
            if (cmp2 != 0) {
            }
            i.y(this.Q, i, this.W, this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yg
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
