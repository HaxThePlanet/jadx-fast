package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import d.a.k.a.a;

/* loaded from: classes.dex */
public class rm extends app.dogo.com.dogo_android.h.qm {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
    }

    public rm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, rm.V, rm.W));
    }

    private rm(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (AppCompatImageView)object3Arr3[4], (SegmentedProgressBar)object3Arr3[3], (AppCompatImageView)object3Arr3[1], (TextView)object3Arr3[2]);
        this.U = -1;
        int i6 = 0;
        this.O.setTag(i6);
        Object obj10 = object3Arr3[0];
        this.T = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        this.P.setTag(i6);
        this.Q.setTag(i6);
        this.R.setTag(i6);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.qm
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qm
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.qm
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            T((TrickItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.qm
    public void T(TrickItem trickItem) {
        this.S = trickItem;
        this.U = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.S = trickItem;
            this.U = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qm
    protected void m() {
        long l;
        int cmp2;
        int i5;
        android.graphics.drawable.Drawable cmp;
        int i7;
        int i6;
        android.graphics.drawable.Drawable i8;
        int i3;
        int i;
        int i2;
        int i4;
        String str;
        l = this.U;
        final int i10 = 0;
        this.U = i10;
        final TrickItem trickItem = this.S;
        final int i11 = 3;
        cmp = Long.compare(i12, i10);
        i8 = 0;
        synchronized (this) {
            l = this.U;
            i10 = 0;
            this.U = i10;
            trickItem = this.S;
            i11 = 3;
            cmp = Long.compare(i12, i10);
            i8 = 0;
        }
        try {
            if (trickItem != null) {
            } else {
            }
            i3 = knowledge;
            i7 = mastered;
            i2 = name;
            i = str;
            i2 = i;
            i3 = i7;
            if (i7 != 0) {
            } else {
            }
            i4 = 8;
            i4 = 4;
        }
        i6 = i7 != 0 ? R.drawable.ic_green_check : R.drawable.arrow_right_green;
        i7 = i3;
        i8 = cmp;
        if (Long.compare(i9, i10) != 0) {
            this.O.setImageDrawable(i8);
            this.P.setActiveSegmentPosition(i7);
            l.n0(this.P, trickItem, 4);
            n.n0(this.Q, i);
            g.c(this.R, i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qm
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
