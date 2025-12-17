package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.k.n;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;
import app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters;
import d.a.k.a.a;

/* loaded from: classes.dex */
public class t7 extends app.dogo.com.dogo_android.h.s7 {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0;
    private final ConstraintLayout Z;
    private final ConstraintLayout a0;
    private long b0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t7.d0 = sparseIntArray;
        sparseIntArray.put(2131362357, 9);
        sparseIntArray.put(2131361923, 10);
    }

    public t7(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 11, t7.c0, t7.d0));
    }

    private t7(e e, View view2, Object[] object3Arr3) {
        final Object obj23 = this;
        super(e, view2, 0, (ImageView)object3Arr3[3], (Guideline)object3Arr3[10], (TextView)object3Arr3[5], (FrameLayout)object3Arr3[9], (ImageView)object3Arr3[4], (TextView)object3Arr3[6], (TextView)object3Arr3[8], (CardView)object3Arr3[1], (TextView)object3Arr3[7]);
        obj23.b0 = -1;
        int i13 = 0;
        obj23.O.setTag(i13);
        obj23.P.setTag(i13);
        obj23.Q.setTag(i13);
        Object obj11 = object3Arr3[0];
        obj23.Z = (ConstraintLayout)obj11;
        obj11.setTag(i13);
        Object obj12 = object3Arr3[2];
        obj23.a0 = (ConstraintLayout)obj12;
        obj12.setTag(i13);
        obj23.R.setTag(i13);
        obj23.S.setTag(i13);
        obj23.T.setTag(i13);
        obj23.U.setTag(i13);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public void A() {
        this.b0 = 16;
        I();
        return;
        synchronized (this) {
            this.b0 = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s7
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (75 == i) {
            V((Boolean)object2);
            obj2 = 1;
        } else {
            if (144 == i) {
                Y((DogoSkuDetails)object2);
            } else {
                if (126 == i) {
                    W((n)object2);
                } else {
                    if (135 == i) {
                        X((Boolean)object2);
                    } else {
                        obj2 = 0;
                    }
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public void V(Boolean boolean) {
        this.X = boolean;
        this.b0 = l |= i2;
        notifyPropertyChanged(75);
        super.I();
        return;
        synchronized (this) {
            this.X = boolean;
            this.b0 = l |= i2;
            notifyPropertyChanged(75);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public void W(n n) {
        this.Y = n;
        this.b0 = l |= i2;
        notifyPropertyChanged(126);
        super.I();
        return;
        synchronized (this) {
            this.Y = n;
            this.b0 = l |= i2;
            notifyPropertyChanged(126);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public void X(Boolean boolean) {
        this.W = boolean;
        this.b0 = l |= i2;
        notifyPropertyChanged(135);
        super.I();
        return;
        synchronized (this) {
            this.W = boolean;
            this.b0 = l |= i2;
            notifyPropertyChanged(135);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public void Y(DogoSkuDetails dogoSkuDetails) {
        this.V = dogoSkuDetails;
        this.b0 = l |= i2;
        notifyPropertyChanged(144);
        super.I();
        return;
        synchronized (this) {
            this.V = dogoSkuDetails;
            this.b0 = l |= i2;
            notifyPropertyChanged(144);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s7
    protected void m() {
        int i9;
        int cmp;
        int cmp6;
        int i5;
        long l;
        boolean z;
        int i8;
        int cmp5;
        int cmp4;
        int priceDescriptionV2;
        int i7;
        int i2;
        int cmp2;
        int i3;
        int i4;
        int i6;
        int i10;
        int cmp3;
        int i;
        final Object obj = this;
        l = obj.b0;
        final int i16 = 0;
        obj.b0 = i16;
        final DogoSkuDetails dogoSkuDetails = obj.V;
        final int i21 = 19;
        synchronized (this) {
            obj = this;
            l = obj.b0;
            i16 = 0;
            obj.b0 = i16;
            dogoSkuDetails = obj.V;
            i21 = 19;
        }
        i9 = ViewDataBinding.K(obj.X);
        try {
            if (Long.compare(i25, i16) != 0 && Long.compare(i10, i16) != 0) {
            } else {
            }
            if (Long.compare(i10, i16) != 0) {
            } else {
            }
            priceDescriptionV2 = DogoSkuDetails.getPriceDescriptionV2(dogoSkuDetails, w().getContext());
            priceDescriptionV2 = 0;
            int i28 = 24;
            cmp3 = Long.compare(i30, i16);
            z = ViewDataBinding.K(obj.W);
        }
        i8 = 0;
        i7 = 0;
        i2 = 0;
        i6 = 0;
        if (Long.compare(i29, i16) != 0) {
            obj.O.setVisibility(i7);
            obj.Q.setVisibility(i8);
            h.a(obj.a0, i2);
            obj.T.setCardBackgroundColor(i6);
        }
        if (Long.compare(i17, i16) != 0) {
            SubscriptionBindingAdapters.subscriptionPerPeriod(obj.P, dogoSkuDetails, i9);
        }
        if (Long.compare(i19, i16) != 0) {
            SubscriptionBindingAdapters.setOldStrikedPrice(obj.R, dogoSkuDetails);
            g.c(obj.U, priceDescriptionV2);
        }
        if (Long.compare(i15, i16) != 0) {
            SubscriptionBindingAdapters.setPerPeriod(obj.S, dogoSkuDetails, obj.Y);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s7
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
