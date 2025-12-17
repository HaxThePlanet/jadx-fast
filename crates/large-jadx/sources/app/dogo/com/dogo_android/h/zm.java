package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
public class zm extends app.dogo.com.dogo_android.h.ym {

    private static final ViewDataBinding.g f0;
    private static final SparseIntArray g0;
    private final ConstraintLayout b0;
    private final ConstraintLayout c0;
    private app.dogo.com.dogo_android.h.zm.a d0;
    private long e0;

    public static class a implements View.OnClickListener {

        private View.OnClickListener a;
        @Override // android.view.View$OnClickListener
        public app.dogo.com.dogo_android.h.zm.a a(View.OnClickListener view$OnClickListener) {
            int obj1;
            this.a = onClickListener;
            obj1 = onClickListener == null ? 0 : this;
            return obj1;
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            this.a.onClick(view);
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zm.g0 = sparseIntArray;
        sparseIntArray.put(2131362357, 10);
        sparseIntArray.put(2131361923, 11);
    }

    public zm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 12, zm.f0, zm.g0));
    }

    private zm(e e, View view2, Object[] object3Arr3) {
        final Object obj25 = this;
        super(e, view2, 0, (ImageView)object3Arr3[3], (Guideline)object3Arr3[11], (TextView)object3Arr3[5], (FrameLayout)object3Arr3[10], (ImageView)object3Arr3[4], (TextView)object3Arr3[6], (TextView)object3Arr3[8], (ProgressBar)object3Arr3[9], (CardView)object3Arr3[1], (TextView)object3Arr3[7]);
        obj25.e0 = -1;
        int i14 = 0;
        obj25.O.setTag(i14);
        obj25.P.setTag(i14);
        obj25.Q.setTag(i14);
        Object obj12 = object3Arr3[0];
        obj25.b0 = (ConstraintLayout)obj12;
        obj12.setTag(i14);
        Object obj13 = object3Arr3[2];
        obj25.c0 = (ConstraintLayout)obj13;
        obj13.setTag(i14);
        obj25.R.setTag(i14);
        obj25.S.setTag(i14);
        obj25.T.setTag(i14);
        obj25.U.setTag(i14);
        obj25.V.setTag(i14);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void A() {
        this.e0 = 32;
        I();
        return;
        synchronized (this) {
            this.e0 = 32;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ym
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (120 == i) {
            U((View.OnClickListener)object2);
            obj2 = 1;
        } else {
            if (75 == i) {
                T((Boolean)object2);
            } else {
                if (144 == i) {
                    X((DogoSkuDetails)object2);
                } else {
                    if (126 == i) {
                        V((n)object2);
                    } else {
                        if (135 == i) {
                            W((Boolean)object2);
                        } else {
                            obj2 = 0;
                        }
                    }
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void T(Boolean boolean) {
        this.Z = boolean;
        this.e0 = l |= i2;
        notifyPropertyChanged(75);
        super.I();
        return;
        synchronized (this) {
            this.Z = boolean;
            this.e0 = l |= i2;
            notifyPropertyChanged(75);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void U(View.OnClickListener view$OnClickListener) {
        this.X = onClickListener;
        this.e0 = l |= i2;
        notifyPropertyChanged(120);
        super.I();
        return;
        synchronized (this) {
            this.X = onClickListener;
            this.e0 = l |= i2;
            notifyPropertyChanged(120);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void V(n n) {
        this.a0 = n;
        this.e0 = l |= i2;
        notifyPropertyChanged(126);
        super.I();
        return;
        synchronized (this) {
            this.a0 = n;
            this.e0 = l |= i2;
            notifyPropertyChanged(126);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void W(Boolean boolean) {
        this.Y = boolean;
        this.e0 = l |= i2;
        notifyPropertyChanged(135);
        super.I();
        return;
        synchronized (this) {
            this.Y = boolean;
            this.e0 = l |= i2;
            notifyPropertyChanged(135);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void X(DogoSkuDetails dogoSkuDetails) {
        this.W = dogoSkuDetails;
        this.e0 = l |= i2;
        notifyPropertyChanged(144);
        super.I();
        return;
        synchronized (this) {
            this.W = dogoSkuDetails;
            this.e0 = l |= i2;
            notifyPropertyChanged(144);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ym
    protected void m() {
        int i8;
        long l;
        int cmp5;
        int i5;
        int i10;
        int cmp2;
        int cmp4;
        android.graphics.drawable.Drawable drawable2;
        int cmp7;
        android.graphics.drawable.Drawable z;
        int i3;
        int i9;
        int i;
        int aVar;
        int cmp;
        int i2;
        int priceDescriptionV2;
        int i11;
        int cmp6;
        int i4;
        int i12;
        int cmp3;
        android.graphics.drawable.Drawable drawable;
        int i6;
        int i7;
        final Object obj = this;
        l = obj.e0;
        final int i18 = 0;
        obj.e0 = i18;
        View.OnClickListener list = obj.X;
        final DogoSkuDetails dogoSkuDetails = obj.W;
        synchronized (this) {
            obj = this;
            l = obj.e0;
            i18 = 0;
            obj.e0 = i18;
            list = obj.X;
            dogoSkuDetails = obj.W;
        }
        if (list != null) {
            if (obj.d0 == null) {
                try {
                    aVar = new zm.a();
                    obj.d0 = aVar;
                    i8 = aVar.a(list);
                    i8 = 0;
                    i4 = 0;
                    if (Long.compare(i30, i18) != 0) {
                    } else {
                    }
                    i10 = ViewDataBinding.K(obj.Z);
                    i10 = i4;
                    int i33 = 36;
                    final int i34 = 8;
                }
                cmp = Long.compare(i12, i18);
                if (cmp != 0) {
                    priceDescriptionV2 = DogoSkuDetails.getPriceDescriptionV2(dogoSkuDetails, w().getContext());
                    i12 = dogoSkuDetails == null ? 1 : i4;
                    if (cmp != 0) {
                        i6 = i12 != 0 ? 512 : 256;
                        l |= i6;
                    }
                    i2 = i12 != 0 ? i4 : i34;
                } else {
                    i2 = i4;
                    priceDescriptionV2 = 0;
                }
                int i35 = 48;
                cmp3 = Long.compare(i7, i18);
                if (cmp3 != 0) {
                    z = ViewDataBinding.K(obj.Y);
                    if (cmp3 != 0) {
                        if (z) {
                            i17 |= i41;
                            i7 = 32768;
                        } else {
                            i15 |= i38;
                            i7 = 16384;
                        }
                        i5 |= i7;
                    }
                    cmp3 = z ? i34 : i4;
                    i = z ? R.color.backgroundGreen : R.color.white;
                    if (z) {
                    } else {
                        i4 = i34;
                    }
                    if (z) {
                        drawable = 0;
                    } else {
                        drawable = z;
                    }
                    i11 = i26;
                    i3 = i4;
                    i9 = cmp3;
                    drawable2 = drawable;
                } else {
                    i11 = i9;
                    drawable2 = 0;
                }
                if (Long.compare(i29, i18) != 0) {
                    obj.O.setVisibility(i3);
                    obj.Q.setVisibility(i9);
                    h.a(obj.c0, drawable2);
                    obj.U.setCardBackgroundColor(i11);
                }
                if (Long.compare(i21, i18) != 0) {
                    SubscriptionBindingAdapters.subscriptionPerPeriod(obj.P, dogoSkuDetails, i10);
                }
                if (Long.compare(i22, i18) != 0) {
                    SubscriptionBindingAdapters.setOldStrikedPrice(obj.R, dogoSkuDetails);
                    obj.T.setVisibility(i2);
                    g.c(obj.V, priceDescriptionV2);
                }
                if (Long.compare(i24, i18) != 0) {
                    SubscriptionBindingAdapters.setPerPeriod(obj.S, dogoSkuDetails, obj.a0);
                }
                if (Long.compare(i13, i18) != 0) {
                    obj.U.setOnClickListener(i8);
                }
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.ym
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
