package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.m.b;
import app.dogo.com.dogo_android.repository.domain.GoodTrickExample;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* loaded from: classes.dex */
public class ld extends app.dogo.com.dogo_android.h.kd {

    private static final ViewDataBinding.g a0;
    private static final SparseIntArray b0;
    private final ConstraintLayout Y;
    private long Z;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ld.b0 = sparseIntArray;
        sparseIntArray.put(2131363433, 5);
        sparseIntArray.put(2131362346, 6);
        sparseIntArray.put(2131361947, 7);
        sparseIntArray.put(2131363331, 8);
        sparseIntArray.put(2131361948, 9);
        sparseIntArray.put(2131362590, 10);
    }

    public ld(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 11, ld.a0, ld.b0));
    }

    private ld(e e, View view2, Object[] object3Arr3) {
        final Object obj24 = this;
        super(e, view2, 1, (ImageView)object3Arr3[7], (ImageView)object3Arr3[9], (TextView)object3Arr3[6], (ViewPager2)object3Arr3[1], (Guideline)object3Arr3[10], (View)object3Arr3[2], (ProgressBar)object3Arr3[4], (View)object3Arr3[3], (TabLayout)object3Arr3[8], (MaterialToolbar)object3Arr3[5]);
        obj24.Z = -1;
        int i13 = 0;
        obj24.R.setTag(i13);
        obj24.S.setTag(i13);
        Object obj12 = object3Arr3[0];
        obj24.Y = (ConstraintLayout)obj12;
        obj12.setTag(i13);
        obj24.T.setTag(i13);
        obj24.U.setTag(i13);
        N(view2);
        A();
    }

    private boolean W(x<y<List<GoodTrickExample>>> x, int i2) {
        if (i2 == 0) {
            this.Z = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Z = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.kd
    public void A() {
        this.Z = 4;
        I();
        return;
        synchronized (this) {
            this.Z = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kd
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.kd
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((b)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.kd
    public void V(b b) {
        this.X = b;
        this.Z = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.X = b;
            this.Z = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kd
    protected void m() {
        int cmp;
        androidx.viewpager2.widget.ViewPager2 view;
        int bVar;
        int value;
        int i2;
        int i;
        int i3;
        com.google.android.material.tabs.TabLayout tabLayout;
        android.widget.TextView view4;
        android.widget.ImageView view2;
        android.widget.ImageView view3;
        long l = this.Z;
        final int i5 = 0;
        this.Z = i5;
        bVar = this.X;
        int cmp2 = Long.compare(i8, i5);
        value = 0;
        synchronized (this) {
            l = this.Z;
            i5 = 0;
            this.Z = i5;
            bVar = this.X;
            cmp2 = Long.compare(i8, i5);
            value = 0;
        }
        try {
            if (bVar != null) {
            } else {
            }
            i2 = bVar.n();
            bVar = bVar.p();
            i2 = bVar;
            Q(0, i2);
            if (i2 != 0) {
            }
            value = i2.getValue();
            i3 = bVar;
            i3 = value;
        }
        if (cmp2 != 0) {
            i.B(this.R, value, i3, this.V, this.Q, this.O, this.P);
            n.z0(this.T, value);
        }
        if (Long.compare(i4, i5) != 0) {
            i.b(this.S, this.R);
            i.d(this.U, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.kd
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
