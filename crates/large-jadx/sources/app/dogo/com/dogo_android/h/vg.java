package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;
import app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters;
import app.dogo.com.dogo_android.subscription.SubscriptionViewModel;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.Callbacks;
import app.dogo.com.dogo_android.util.e0.y;
import java.util.List;

/* loaded from: classes.dex */
public class vg extends app.dogo.com.dogo_android.h.ug {

    private static final ViewDataBinding.g d0;
    private static final SparseIntArray e0;
    private final ConstraintLayout Z;
    private final FrameLayout a0;
    private final TextView b0;
    private long c0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(23);
        vg.d0 = gVar;
        int i14 = 1;
        final int[] iArr2 = new int[i14];
        final int i30 = 0;
        iArr2[i30] = 10;
        int[] iArr = new int[i14];
        iArr[i30] = 2131558773;
        gVar.a(2, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        vg.e0 = sparseIntArray;
        sparseIntArray.put(2131363433, 11);
        sparseIntArray.put(2131362573, 12);
        sparseIntArray.put(2131362572, 13);
        sparseIntArray.put(2131362574, 14);
        sparseIntArray.put(2131362575, 15);
        sparseIntArray.put(2131362577, 16);
        sparseIntArray.put(2131362578, 17);
        sparseIntArray.put(2131362906, 18);
        sparseIntArray.put(2131363416, 19);
        sparseIntArray.put(2131362956, 20);
        sparseIntArray.put(2131363286, 21);
        sparseIntArray.put(2131362392, 22);
    }

    public vg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 23, vg.d0, vg.e0));
    }

    private vg(e e, View view2, Object[] object3Arr3) {
        Object obj7 = this;
        super(e, view2, 8, (ConstraintLayout)object3Arr3[2], (TextView)object3Arr3[3], (Guideline)object3Arr3[22], (ImageView)object3Arr3[13], (TextView)object3Arr3[12], (TextView)object3Arr3[14], (TextView)object3Arr3[15], (TextView)object3Arr3[16], (TextView)object3Arr3[17], (MaterialButton)object3Arr3[9], (TextView)object3Arr3[18], (RecyclerView)object3Arr3[5], (TextView)object3Arr3[20], (ConstraintLayout)object3Arr3[1], (MaterialButton)object3Arr3[8], (Guideline)object3Arr3[21], (kk)object3Arr3[10], (Barrier)object3Arr3[19], (TextView)object3Arr3[4], (MaterialToolbar)object3Arr3[11]);
        Object obj6 = this;
        obj6.c0 = -1;
        int i5 = 0;
        obj6.O.setTag(i5);
        obj6.P.setTag(i5);
        obj6.Q.setTag(i5);
        Object obj2 = object3Arr3[0];
        obj6.Z = (ConstraintLayout)obj2;
        obj2.setTag(i5);
        Object obj3 = object3Arr3[6];
        obj6.a0 = (FrameLayout)obj3;
        obj3.setTag(i5);
        Object obj4 = object3Arr3[7];
        obj6.b0 = (TextView)obj4;
        obj4.setTag(i5);
        obj6.R.setTag(i5);
        obj6.S.setTag(i5);
        obj6.T.setTag(i5);
        obj6.L(obj6.U);
        obj6.V.setTag(i5);
        obj6.N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.kk kk, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(LiveData<y<SubscriptionOffer>> liveData, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean c0(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean d0(x<List<DogoSkuDetails>> x, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean e0(x<CouponTimer> x, int i2) {
        if (i2 == 0) {
            this.c0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.c0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public void A() {
        this.c0 = 1024;
        this.U.A();
        I();
        return;
        synchronized (this) {
            this.c0 = 1024;
            this.U.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ug
    protected boolean E(int i, Object object2, int i3) {
        switch (i) {
            case 0:
                return e0((x)object2, i3);
            case 1:
                return Z((x)object2, i3);
            case 2:
                return a0((x)object2, i3);
            case 3:
                return X((kk)object2, i3);
            case 4:
                return b0((LiveData)object2, i3);
            case 5:
                return c0((x)object2, i3);
            case 6:
                return Y((x)object2, i3);
            case 7:
                return d0((x)object2, i3);
            default:
                return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public void M(q q) {
        super.M(q);
        this.U.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((SubscriptionBenefitsOfferAdapter.Callbacks)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((SubscriptionViewModel)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public void V(SubscriptionBenefitsOfferAdapter.Callbacks subscriptionBenefitsOfferAdapter$Callbacks) {
        this.Y = callbacks;
        this.c0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Y = callbacks;
            this.c0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public void W(SubscriptionViewModel subscriptionViewModel) {
        this.X = subscriptionViewModel;
        this.c0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.X = subscriptionViewModel;
            this.c0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ug
    protected void m() {
        int i24;
        int i19;
        int cmp11;
        int cmp4;
        int cmp6;
        int cmp8;
        int cmp3;
        int cmp9;
        SubscriptionViewModel cmp2;
        long l;
        int i4;
        int i13;
        int i;
        int value2;
        int string;
        int i18;
        int i29;
        int value5;
        int i14;
        int value7;
        int i22;
        int i28;
        int i12;
        int value3;
        int i6;
        int i30;
        boolean z;
        int cmp;
        int i11;
        int value;
        int i25;
        int i36;
        x selected;
        int selectedSkuDetails;
        int i10;
        x skuList;
        int cmp7;
        int i37;
        int value4;
        int i20;
        int i21;
        int bestValueSavingsPercentString;
        int discountVisible;
        int i31;
        x i27;
        Object value6;
        int i34;
        int i38;
        int freeTrailAvailable;
        int i32;
        int cmp5;
        int i7;
        int i26;
        int i33;
        int i15;
        int showResubscribeLayout;
        int showResubscribeLayout2;
        int i3;
        int timer;
        x freeTrailAvailable2;
        int i23;
        int i16;
        int result;
        int i5;
        int i8;
        int i17;
        int i39;
        int cmp10;
        int i35;
        int i2;
        int i9;
        Object obj2;
        Object obj;
        final Object obj3 = this;
        l = obj3.c0;
        int i43 = 0;
        obj3.c0 = i43;
        cmp2 = obj3.X;
        i7 = 2048;
        final int i67 = 65536;
        final int i68 = 1698;
        final int i69 = 1537;
        final int i70 = 1556;
        final int i71 = 1536;
        final int i72 = 1600;
        int i73 = 0;
        cmp = 0;
        synchronized (this) {
            obj3 = this;
            l = obj3.c0;
            i43 = 0;
            obj3.c0 = i43;
            cmp2 = obj3.X;
            i7 = 2048;
            i67 = 65536;
            i68 = 1698;
            i69 = 1537;
            i70 = 1556;
            i71 = 1536;
            i72 = 1600;
            i73 = 0;
            cmp = 0;
        }
        int cmp16 = Long.compare(i74, i43);
        int i57 = 4;
        if (cmp16 != 0) {
            if (cmp2 != null) {
                try {
                    showResubscribeLayout = cmp2.getShowResubscribeLayout();
                    showResubscribeLayout = cmp;
                    if (cmp16 != 0) {
                    }
                    if (showResubscribeLayout != 0) {
                    } else {
                    }
                    i42 |= i20;
                    i41 |= i32;
                }
                i28 = i57;
                i3 = showResubscribeLayout != 0 ? cmp : 8;
            } else {
            }
        } else {
            i3 = showResubscribeLayout;
        }
        if (Long.compare(i75, i43) != 0) {
            if (cmp2 != null) {
                i20 = timer;
            } else {
                i20 = i73;
            }
            obj3.Q(cmp, i20);
            if (i20 != 0) {
                value4 = i20.getValue();
            } else {
                value4 = i73;
            }
        } else {
        }
        discountVisible = Long.compare(freeTrailAvailable2, i43);
        if (discountVisible != 0) {
            if (cmp2 != null) {
                i27 = freeTrailAvailable2;
            } else {
                i27 = i73;
            }
            obj3.Q(1, i27);
            if (i27 != null) {
                value6 = i27.getValue();
            } else {
                value6 = i73;
            }
        } else {
        }
        if (Long.compare(i77, i43) != 0) {
            if (cmp2 != null) {
                i30 = freeTrailAvailable;
            } else {
                i30 = i73;
            }
            obj3.Q(2, i30);
            if (i30 != 0) {
                value3 = i30.getValue();
            } else {
                value3 = i73;
            }
            if (Long.compare(result, i43) != 0) {
                z = ViewDataBinding.K(value3);
            } else {
                z = 0;
            }
        } else {
            value3 = i73;
        }
        if (Long.compare(i78, i43) != 0) {
            if (cmp2 != null) {
                i36 = result;
            } else {
                i36 = i73;
            }
            obj3.Q(i57, i36);
            if (i36 != 0) {
                value = i36.getValue();
            } else {
                value = i73;
            }
        } else {
        }
        if (Long.compare(i59, i43) != 0) {
            if (cmp2 != null) {
                selected = cmp2.getSelected();
                skuList = cmp2.getSkuList();
            } else {
                skuList = selected;
            }
            obj3.Q(5, selected);
            obj3.Q(7, skuList);
            if (selected != null) {
                value2 = selected.getValue();
            } else {
                value2 = i73;
            }
            if (skuList != null) {
                value5 = skuList.getValue();
            } else {
                value5 = i73;
            }
            if (discountVisible != 0 && cmp2 != null) {
                if (cmp2 != null) {
                    selectedSkuDetails = cmp2.getSelectedSkuDetails(ViewDataBinding.J(value2), value5);
                } else {
                    selectedSkuDetails = i73;
                }
            } else {
            }
            cmp7 = Long.compare(i17, i8);
            if (cmp7 != 0) {
                if (cmp2 != null) {
                    bestValueSavingsPercentString = cmp2.bestValueSavingsPercentString(value5);
                } else {
                    bestValueSavingsPercentString = i73;
                }
                i39 = value2;
                i17 = bestValueSavingsPercentString == null ? 1 : 0;
                i35 = value5;
                i16 = i28;
                Object[] arr = new Object[1];
                i34 = 0;
                arr[i34] = bestValueSavingsPercentString;
                string = obj3.b0.getResources().getString(2131887435, arr);
                if (cmp7 != 0) {
                    i2 = i17 != 0 ? 0x01000000 /* Unknown resource */ : 8388608;
                    l |= i2;
                }
                i22 = i17 != 0 ? 8 : i34;
            } else {
                i39 = value2;
                i35 = value5;
                i16 = i28;
                i14 = 1;
                i22 = i34;
                string = i73;
            }
        } else {
            i16 = i28;
            i14 = 1;
            i22 = i34;
            i35 = i39;
        }
        int cmp18 = Long.compare(i9, i79);
        if (cmp18 != 0) {
            if (cmp2 != null) {
                discountVisible = cmp2.getDiscountVisible();
            } else {
                discountVisible = i73;
            }
            obj3.Q(6, discountVisible);
            if (discountVisible != 0) {
                value7 = discountVisible.getValue();
            } else {
                value7 = i73;
            }
            if (cmp18 != 0) {
                if (ViewDataBinding.K(value7)) {
                    l |= i67;
                    i9 = 1048576;
                } else {
                    l |= i82;
                    i9 = 524288;
                }
                i13 |= i9;
            }
        } else {
            i18 = i34;
        }
        if (Long.compare(i2, i5) != 0 && cmp2 != null) {
            if (cmp2 != null) {
                i26 = z;
                i21 = value4;
                i6 = i39;
                i37 = string;
                i = i16;
                i23 = value3;
                i12 = i35;
                i10 = value;
                i11 = i3;
                showResubscribeLayout2 = showResubscribeLayout;
                i15 = obj2;
                i31 = selectedSkuDetails;
                i25 = obj;
            } else {
                i10 = value;
                i21 = value4;
                i11 = i3;
                i37 = string;
                showResubscribeLayout2 = showResubscribeLayout;
                i = i16;
                i23 = value3;
                i15 = i73;
                i12 = i35;
                i26 = z;
                i6 = i39;
                i31 = selectedSkuDetails;
                i25 = obj2;
            }
        } else {
        }
        if (Long.compare(i81, i5) != 0) {
            if (cmp2 != null) {
                showResubscribeLayout2 = cmp2.getShowResubscribeLayout();
            }
            if (Long.compare(cmp10, i5) != 0) {
                if (showResubscribeLayout2 != 0) {
                    l |= freeTrailAvailable2;
                    i32 = 4194304;
                } else {
                    l |= i7;
                }
                i4 |= i32;
            }
            i24 = Long.compare(i32, i5) != 0 ? showResubscribeLayout2 ^ 1 : i34;
        } else {
        }
        cmp5 = Long.compare(i61, i5);
        if (cmp5 != 0) {
            if (i18 != 0) {
            } else {
                i24 = i34;
            }
            i17 = i18 != 0 ? 1 : showResubscribeLayout2;
            if (cmp5 != 0) {
                cmp5 = i24 != 0 ? 262144 : 131072;
                l |= cmp5;
            }
            if (Long.compare(cmp5, i7) != 0) {
                cmp5 = i17 != 0 ? 16384 : 8192;
                l |= cmp5;
            }
            i19 = i24 != 0 ? i34 : 8;
            if (i17 != 0) {
                i34 = 8;
            }
            i29 = i34;
        } else {
            i29 = i19;
        }
        final int i62 = 0;
        if (Long.compare(i60, i62) != 0) {
            i38 = i6;
            obj3.O.setVisibility(i19);
            obj3.V.setVisibility(i29);
        } else {
            i38 = i6;
        }
        if (Long.compare(i63, i62) != 0) {
            SubscriptionBindingAdapters.setupTimerSubscribe(obj3.O, i21, obj3.U);
        }
        if (Long.compare(i65, i62) != 0) {
            SubscriptionBindingAdapters.setSubscriptionPlanTitleText(obj3.P, i10);
        }
        if (Long.compare(i66, i62) != 0) {
            obj3.Q.setVisibility(i);
            obj3.S.setVisibility(i11);
            obj3.T.setVisibility(i11);
        }
        if (Long.compare(i44, i62) != 0) {
            SubscriptionBindingAdapters.setSubscriptionPlanButton(obj3.Q, i31, i25);
        }
        if (Long.compare(i46, i62) != 0) {
            obj3.a0.setVisibility(i22);
            g.c(obj3.b0, i37);
        }
        if (Long.compare(i48, i62) != 0) {
            SubscriptionBindingAdapters.setBenefitListAdapter(obj3.R, i12, obj3.Y, i38, i23, i15);
        }
        if (Long.compare(i40, i49) != 0) {
            SubscriptionBindingAdapters.setSubscriptionBenefitPlanTitle(obj3.V, i10, i26);
        }
        ViewDataBinding.o(obj3.U);
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.U.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
