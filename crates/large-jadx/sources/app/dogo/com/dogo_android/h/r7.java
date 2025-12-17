package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class r7 extends app.dogo.com.dogo_android.h.q7 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        r7.W = sparseIntArray;
        sparseIntArray.put(2131363329, 4);
    }

    public r7(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, r7.V, r7.W));
    }

    private r7(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (AppCompatImageView)object3Arr3[3], (SegmentedProgressBar)object3Arr3[2], (TextView)object3Arr3[4], (TextView)object3Arr3[1]);
        this.U = -1;
        int i6 = 0;
        this.O.setTag(i6);
        Object obj10 = object3Arr3[0];
        this.T = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        this.P.setTag(i6);
        this.R.setTag(i6);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.q7
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q7
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.q7
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((TrickItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.q7
    public void V(TrickItem trickItem) {
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

    @Override // app.dogo.com.dogo_android.h.q7
    protected void m() {
        Object trickItem;
        long l;
        int i2;
        int cmp;
        int i;
        TextView view;
        int knowledge;
        int notRatedByUser;
        int i5;
        int cmp2;
        int i6;
        int shortDescription;
        int i3;
        int i4;
        final Object obj = this;
        l = obj.U;
        final int i8 = 0;
        obj.U = i8;
        trickItem = obj.S;
        int i9 = 0;
        final int i10 = 3;
        int cmp3 = Long.compare(i11, i8);
        final int i12 = 4;
        int i13 = 4;
        i6 = 0;
        synchronized (this) {
            obj = this;
            l = obj.U;
            i8 = 0;
            obj.U = i8;
            trickItem = obj.S;
            i9 = 0;
            i10 = 3;
            cmp3 = Long.compare(i11, i8);
            i12 = 4;
            i13 = 4;
            i6 = 0;
        }
        if (trickItem != null) {
            knowledge = trickItem.getKnowledge();
            shortDescription = trickItem.getShortDescription();
        } else {
            try {
                shortDescription = i9;
                knowledge = i6;
                if (knowledge >= i12) {
                } else {
                }
                i3 = i5;
                i3 = i6;
                l |= i4;
            }
            if (Long.compare(i14, i8) != 0 && trickItem != null) {
                if (trickItem != null) {
                    notRatedByUser = trickItem.isNotRatedByUser();
                } else {
                    notRatedByUser = i6;
                }
            } else {
            }
            cmp2 = Long.compare(i15, i8);
            if (cmp2 != 0) {
                if (i3 != 0) {
                } else {
                    i5 = notRatedByUser;
                }
                if (cmp2 != 0) {
                    cmp2 = i5 != 0 ? 32 : 16;
                    l |= cmp2;
                }
                i5 = i5 != 0 ? R.color.transparent : R.color.specialty_brown;
                i6 = notRatedByUser;
            }
            if (Long.compare(i7, i8) != 0 && ViewDataBinding.t() >= 21) {
                if (ViewDataBinding.t() >= 21) {
                    obj.O.setImageTintList(b.a(i6));
                }
                l.K0(obj.O, trickItem, obj.Q);
                obj.P.setActiveSegmentPosition(knowledge);
                l.n0(obj.P, trickItem, i12);
                g.c(obj.R, shortDescription);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.q7
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
