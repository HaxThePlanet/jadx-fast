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
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.customview.SegmentedProgressBar;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class p7 extends app.dogo.com.dogo_android.h.o7 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p7.W = sparseIntArray;
        sparseIntArray.put(2131363329, 4);
    }

    public p7(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, p7.V, p7.W));
    }

    private p7(e e, View view2, Object[] object3Arr3) {
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

    @Override // app.dogo.com.dogo_android.h.o7
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o7
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.o7
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

    @Override // app.dogo.com.dogo_android.h.o7
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

    @Override // app.dogo.com.dogo_android.h.o7
    protected void m() {
        int cmp;
        TextView view;
        int knowledge;
        int shortDescription;
        final int i2 = 0;
        this.U = i2;
        knowledge = 0;
        final TrickItem trickItem = this.S;
        shortDescription = 0;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.U = i2;
            knowledge = 0;
            trickItem = this.S;
            shortDescription = 0;
            cmp = Long.compare(i, i2);
        }
        try {
            if (trickItem != null) {
            }
            knowledge = trickItem.getKnowledge();
            shortDescription = trickItem.getShortDescription();
            if (cmp != 0) {
            }
            l.K0(this.O, trickItem, this.Q);
            this.P.setActiveSegmentPosition(knowledge);
            g.c(this.R, shortDescription);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.o7
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
