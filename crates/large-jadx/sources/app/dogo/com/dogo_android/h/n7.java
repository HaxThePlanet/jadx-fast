package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations;
import app.dogo.com.dogo_android.u.l.a;
import app.dogo.com.dogo_android.y.l;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public class n7 extends app.dogo.com.dogo_android.h.m7 {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final MaterialCardView V;
    private final ConstraintLayout W;
    private long X;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(9);
        n7.Y = gVar;
        int i5 = 1;
        final int[] iArr = new int[i5];
        final int i10 = 0;
        iArr[i10] = 5;
        int[] iArr2 = new int[i5];
        iArr2[i10] = 2131558804;
        gVar.a(i5, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        n7.Z = sparseIntArray;
        sparseIntArray.put(2131363483, 6);
        sparseIntArray.put(2131363490, 7);
        sparseIntArray.put(2131363525, 8);
    }

    public n7(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, n7.Y, n7.Z));
    }

    private n7(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (qm)object3Arr3[5], (RecyclerView)object3Arr3[4], (ImageView)object3Arr3[6], (View)object3Arr3[7], (ImageView)object3Arr3[8], (TextView)object3Arr3[2], (TextView)object3Arr3[3]);
        this.X = -1;
        L(this.O);
        Object obj13 = object3Arr3[0];
        this.V = (MaterialCardView)obj13;
        int i9 = 0;
        obj13.setTag(i9);
        obj13 = object3Arr3[1];
        this.W = (ConstraintLayout)obj13;
        obj13.setTag(i9);
        this.P.setTag(i9);
        this.R.setTag(i9);
        this.S.setTag(i9);
        N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.qm qm, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.m7
    public void A() {
        this.X = 8;
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.X = 8;
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m7
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((qm)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.m7
    public void M(q q) {
        super.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.m7
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            W((TrickItemWithVariations)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                V((l.a)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.m7
    public void V(l.a l$a) {
        this.U = a;
        this.X = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.U = a;
            this.X = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m7
    public void W(TrickItemWithVariations trickItemWithVariations) {
        this.T = trickItemWithVariations;
        this.X = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.T = trickItemWithVariations;
            this.X = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m7
    protected void m() {
        int i2;
        int cmp3;
        int mastered;
        long l;
        int variations;
        int cmp;
        Boolean valueOf;
        int coreTrick;
        int i3;
        int cmp2;
        int i;
        final Object obj = this;
        l = obj.X;
        final int i6 = 0;
        obj.X = i6;
        TrickItemWithVariations trickItemWithVariations = obj.T;
        final int i7 = 14;
        int i9 = 10;
        coreTrick = 0;
        i3 = 0;
        synchronized (this) {
            obj = this;
            l = obj.X;
            i6 = 0;
            obj.X = i6;
            trickItemWithVariations = obj.T;
            i7 = 14;
            i9 = 10;
            coreTrick = 0;
            i3 = 0;
        }
        if (trickItemWithVariations != null) {
            variations = trickItemWithVariations.getVariations();
        } else {
            try {
                variations = coreTrick;
                cmp2 = Long.compare(i11, i6);
                if (trickItemWithVariations != null) {
                }
                coreTrick = trickItemWithVariations.getCoreTrick();
                if (coreTrick != 0) {
                } else {
                }
                mastered = coreTrick.isMastered();
                mastered = i3;
            }
            i2 = i3;
            if (Long.compare(i10, i6) != 0) {
                obj.O.T(coreTrick);
                l.T(obj.R, Boolean.valueOf(i3));
                obj.S.setVisibility(i2);
            }
            if (Long.compare(i5, i6) != 0) {
                l.F0(obj.P, variations, obj.U);
            }
            ViewDataBinding.o(obj.O);
        }
    }

    @Override // app.dogo.com.dogo_android.h.m7
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.O.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
