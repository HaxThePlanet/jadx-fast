package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
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
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.CouponTimer;
import app.dogo.com.dogo_android.repository.domain.SubscriptionOffer;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;
import app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters;
import app.dogo.com.dogo_android.subscription.SubscriptionViewModel;
import app.dogo.com.dogo_android.subscription.benefits.SubscriptionBenefitsOfferAdapter.Callbacks;
import app.dogo.com.dogo_android.subscription.benefits.UserTestimonialsCallback;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* loaded from: classes.dex */
public class tg extends app.dogo.com.dogo_android.h.sg implements b.a {

    private static final ViewDataBinding.g t0;
    private static final SparseIntArray u0;
    private final ConstraintLayout i0;
    private final ConstraintLayout j0;
    private final FrameLayout k0;
    private final TextView l0;
    private final FrameLayout m0;
    private final app.dogo.com.dogo_android.h.ml n0;
    private final app.dogo.com.dogo_android.h.ml o0;
    private final FrameLayout p0;
    private final TextView q0;
    private final View.OnClickListener r0;
    private long s0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(33);
        tg.t0 = gVar;
        int i14 = 2;
        int[] iArr4 = new int[i14];
        iArr4 = new int[]{19, 20};
        int[] iArr = new int[i14];
        iArr = new int[]{2131558811, 2131558746};
        int i27 = 1;
        gVar.a(i27, /* result */, iArr4, iArr);
        int[] iArr2 = new int[i27];
        final int i29 = 0;
        iArr2[i29] = 18;
        int[] iArr5 = new int[i27];
        iArr5[i29] = 2131558773;
        gVar.a(4, /* result */, iArr2, iArr5);
        String str3 = "layout_loading_spinner";
        int[] iArr6 = new int[i27];
        iArr6[i29] = 21;
        int[] iArr8 = new int[i27];
        final int i33 = 2131558788;
        iArr8[i29] = i33;
        gVar.a(16, /* result */, iArr6, iArr8);
        int[] iArr3 = new int[i27];
        iArr3[i29] = 22;
        int[] iArr7 = new int[i27];
        iArr7[i29] = i33;
        gVar.a(17, /* result */, iArr3, iArr7);
        SparseIntArray sparseIntArray = new SparseIntArray();
        tg.u0 = sparseIntArray;
        sparseIntArray.put(2131363185, 23);
        sparseIntArray.put(2131362193, 24);
        sparseIntArray.put(2131362906, 25);
        sparseIntArray.put(2131363416, 26);
        sparseIntArray.put(2131362909, 27);
        sparseIntArray.put(2131362910, 28);
        sparseIntArray.put(2131363286, 29);
        sparseIntArray.put(2131362392, 30);
        sparseIntArray.put(2131362322, 31);
        sparseIntArray.put(2131362956, 32);
    }

    public tg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 33, tg.t0, tg.u0));
    }

    private tg(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 11, (ConstraintLayout)object3Arr3[4], (ym)object3Arr3[19], (ImageView)object3Arr3[24], (ii)object3Arr3[20], (TextView)object3Arr3[10], (TextView)object3Arr3[5], (ImageView)object3Arr3[31], (ImageView)object3Arr3[2], (Guideline)object3Arr3[30], (ViewPager2)object3Arr3[11], (FrameLayout)object3Arr3[17], (MaterialButton)object3Arr3[15], (TextView)object3Arr3[6], (TextView)object3Arr3[25], (RecyclerView)object3Arr3[12], (RecyclerView)object3Arr3[7], (Barrier)object3Arr3[27], (Barrier)object3Arr3[28], (TextView)object3Arr3[32], (ScrollView)object3Arr3[23], (Guideline)object3Arr3[29], (FrameLayout)object3Arr3[3], (kk)object3Arr3[18], (Barrier)object3Arr3[26]);
        Object obj4 = this;
        obj4.s0 = -1;
        int i4 = 0;
        obj4.O.setTag(i4);
        obj4.L(obj4.P);
        obj4.L(obj4.R);
        obj4.S.setTag(i4);
        obj4.T.setTag(i4);
        obj4.U.setTag(i4);
        obj4.V.setTag(i4);
        obj4.W.setTag(i4);
        obj4.X.setTag(i4);
        Object obj2 = object3Arr3[0];
        obj4.i0 = (ConstraintLayout)obj2;
        obj2.setTag(i4);
        int i3 = 1;
        Object obj6 = object3Arr3[i3];
        obj4.j0 = (ConstraintLayout)obj6;
        obj6.setTag(i4);
        Object obj7 = object3Arr3[13];
        obj4.k0 = (FrameLayout)obj7;
        obj7.setTag(i4);
        Object obj8 = object3Arr3[14];
        obj4.l0 = (TextView)obj8;
        obj8.setTag(i4);
        Object obj9 = object3Arr3[16];
        obj4.m0 = (FrameLayout)obj9;
        obj9.setTag(i4);
        Object obj10 = object3Arr3[21];
        obj4.n0 = (ml)obj10;
        obj4.L(obj10);
        Object obj11 = object3Arr3[22];
        obj4.o0 = (ml)obj11;
        obj4.L(obj11);
        Object obj12 = object3Arr3[8];
        obj4.p0 = (FrameLayout)obj12;
        obj12.setTag(i4);
        Object obj13 = object3Arr3[9];
        obj4.q0 = (TextView)obj13;
        obj13.setTag(i4);
        obj4.Y.setTag(i4);
        obj4.a0.setTag(i4);
        obj4.b0.setTag(i4);
        obj4.d0.setTag(i4);
        obj4.L(obj4.e0);
        obj4.N(view2);
        b bVar = new b(obj4, i3);
        obj4.r0 = bVar;
        A();
    }

    private boolean Y(app.dogo.com.dogo_android.h.ym ym, int i2) {
        if (i2 == 0) {
            this.s0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.s0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(app.dogo.com.dogo_android.h.ii ii, int i2) {
        if (i2 == 0) {
            this.s0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.s0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(app.dogo.com.dogo_android.h.kk kk, int i2) {
        if (i2 == 0) {
            this.s0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.s0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.s0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.s0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean c0(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.s0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.s0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean d0(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.s0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.s0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean e0(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.s0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.s0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean f0(LiveData<y<SubscriptionOffer>> liveData, int i2) {
        if (i2 == 0) {
            this.s0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.s0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean g0(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.s0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.s0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean h0(x<List<DogoSkuDetails>> x, int i2) {
        if (i2 == 0) {
            this.s0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.s0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean i0(x<CouponTimer> x, int i2) {
        if (i2 == 0) {
            this.s0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.s0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public void A() {
        this.s0 = 16384;
        this.e0.A();
        this.P.A();
        this.R.A();
        this.n0.A();
        this.o0.A();
        I();
        return;
        synchronized (this) {
            this.s0 = 16384;
            this.e0.A();
            this.P.A();
            this.R.A();
            this.n0.A();
            this.o0.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sg
    protected boolean E(int i, Object object2, int i3) {
        switch (i) {
            case 0:
                return i0((x)object2, i3);
            case 1:
                return c0((x)object2, i3);
            case 2:
                return d0((x)object2, i3);
            case 3:
                return a0((kk)object2, i3);
            case 4:
                return e0((x)object2, i3);
            case 5:
                return f0((LiveData)object2, i3);
            case 6:
                return Z((ii)object2, i3);
            case 7:
                return g0((x)object2, i3);
            case 8:
                return Y((ym)object2, i3);
            case 9:
                return b0((x)object2, i3);
            case 10:
                return h0((x)object2, i3);
            default:
                return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public void M(q q) {
        super.M(q);
        this.e0.M(q);
        this.P.M(q);
        this.R.M(q);
        this.n0.M(q);
        this.o0.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((SubscriptionBenefitsOfferAdapter.Callbacks)object2);
            obj2 = 1;
        } else {
            if (151 == i) {
                W((UserTestimonialsCallback)object2);
            } else {
                if (177 == i) {
                    X((SubscriptionViewModel)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public void V(SubscriptionBenefitsOfferAdapter.Callbacks subscriptionBenefitsOfferAdapter$Callbacks) {
        this.g0 = callbacks;
        this.s0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.g0 = callbacks;
            this.s0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public void W(UserTestimonialsCallback userTestimonialsCallback) {
        this.h0 = userTestimonialsCallback;
        this.s0 = l |= i2;
        notifyPropertyChanged(151);
        super.I();
        return;
        synchronized (this) {
            this.h0 = userTestimonialsCallback;
            this.s0 = l |= i2;
            notifyPropertyChanged(151);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public void X(SubscriptionViewModel subscriptionViewModel) {
        this.f0 = subscriptionViewModel;
        this.s0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.f0 = subscriptionViewModel;
            this.s0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public final void b(int i, View view2) {
        int skuList;
        int obj4;
        final SubscriptionViewModel obj3 = this.f0;
        final int i2 = 0;
        skuList = obj3 != null ? obj4 : i2;
        if (skuList != null) {
            skuList = obj3.getSkuList();
            if (skuList != null) {
            } else {
                obj4 = i2;
            }
            if (obj4 != null) {
                obj3.bestValueItemSelected((List)skuList.getValue());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.sg
    protected void m() {
        int i11;
        int cmp2;
        int cmp8;
        int cmp4;
        int cmp6;
        int cmp10;
        int cmp7;
        int cmp;
        int cmp3;
        int cmp9;
        int cmp11;
        long l;
        int i52;
        int i47;
        int i22;
        int i41;
        int i28;
        int i40;
        int i17;
        int i31;
        int value7;
        int value2;
        int valueOf;
        int value5;
        int i48;
        int i9;
        int i16;
        int i36;
        int i49;
        int i50;
        int discountVisible;
        int i46;
        int i27;
        int i;
        Object value8;
        int i24;
        int i10;
        int i32;
        int i30;
        int i18;
        int i42;
        int value;
        int i4;
        int i7;
        int listOfCustomerExperiences;
        int i25;
        int value3;
        int timer;
        int i5;
        Object value4;
        int i3;
        int i57;
        int cmp5;
        int selected;
        int i34;
        int i15;
        int value6;
        int purchaseUIState;
        int i26;
        int i51;
        int result;
        int selectedSkuDetails;
        int skuList;
        int i53;
        SubscriptionBenefitsOfferAdapter.Callbacks callbacks;
        int i29;
        int i20;
        int i56;
        int i8;
        int i43;
        int customersExperienceEnabled;
        int i21;
        int i54;
        int allPlansTopEnabled;
        UserTestimonialsCallback userTestimonialsCallback;
        int i14;
        int bestValueSelectedNumber;
        int i37;
        int i44;
        x freeTrailAvailable2;
        int i39;
        int freeTrailAvailable;
        int pricePerPeriodType;
        int i33;
        int i6;
        int i23;
        int i45;
        int bestValueProduct;
        int i19;
        int bestValueSavingsPercentString;
        int i2;
        int i35;
        Object obj;
        int i12;
        int i13;
        int i38;
        int i55;
        final Object obj2 = this;
        l = obj2.s0;
        int i59 = 0;
        obj2.s0 = i59;
        SubscriptionBenefitsOfferAdapter.Callbacks callbacks2 = obj2.g0;
        UserTestimonialsCallback userTestimonialsCallback2 = obj2.h0;
        SubscriptionViewModel view9 = obj2.f0;
        final int i81 = 24592;
        final int i82 = 25728;
        final int i83 = 27780;
        final int i84 = 25730;
        final int i85 = 24577;
        int i86 = 25088;
        final int i88 = 24576;
        i = 0;
        synchronized (this) {
            obj2 = this;
            l = obj2.s0;
            i59 = 0;
            obj2.s0 = i59;
            callbacks2 = obj2.g0;
            userTestimonialsCallback2 = obj2.h0;
            view9 = obj2.f0;
            i81 = 24592;
            i82 = 25728;
            i83 = 27780;
            i84 = 25730;
            i85 = 24577;
            i86 = 25088;
            i88 = 24576;
            i = 0;
        }
        if (Long.compare(i89, i59) != 0) {
            if (view9 != null) {
                try {
                    timer = view9.getTimer();
                    timer = 0;
                    obj2.Q(i, timer);
                    if (timer != 0) {
                    } else {
                    }
                    value3 = timer.getValue();
                    value3 = 0;
                }
                listOfCustomerExperiences = 0;
                int cmp17 = Long.compare(i90, i59);
                i56 = 8;
                if (cmp17 != 0) {
                    if (view9 != null) {
                        customersExperienceEnabled = view9.getCustomersExperienceEnabled();
                        allPlansTopEnabled = view9.allPlansTopEnabled();
                    } else {
                        allPlansTopEnabled = customersExperienceEnabled;
                    }
                    if (cmp17 != 0) {
                        i14 = customersExperienceEnabled != 0 ? 262144 : 131072;
                        l |= i14;
                    }
                    if (Long.compare(i14, i59) != 0) {
                        if (allPlansTopEnabled != 0) {
                            l |= i94;
                            i14 = 16777216;
                        } else {
                            l |= i93;
                            i14 = 8388608;
                        }
                        i22 |= i14;
                    }
                    i29 = customersExperienceEnabled != 0 ? i : i56;
                    i43 = allPlansTopEnabled != 0 ? i : i56;
                    i54 = allPlansTopEnabled != 0 ? i56 : i;
                } else {
                    i54 = i43;
                }
                bestValueSelectedNumber = Long.compare(i91, i59);
                if (bestValueSelectedNumber != 0) {
                    if (view9 != null) {
                        i = freeTrailAvailable2;
                    } else {
                        i = 0;
                    }
                    obj2.Q(1, i);
                    if (i != 0) {
                        value8 = i.getValue();
                    } else {
                        value8 = 0;
                    }
                } else {
                }
                if (Long.compare(i96, i59) != 0) {
                    if (view9 != null) {
                        pricePerPeriodType = view9.getPricePerPeriodType();
                        i42 = freeTrailAvailable;
                    } else {
                        i42 = 0;
                        pricePerPeriodType = 0;
                    }
                    obj2.Q(2, i42);
                    if (i42 != 0) {
                        value = i42.getValue();
                    } else {
                        value = 0;
                    }
                } else {
                    value = 0;
                    pricePerPeriodType = 0;
                }
                if (Long.compare(i80, i59) != 0) {
                    if (view9 != null) {
                        purchaseUIState = view9.getPurchaseUIState();
                    } else {
                        purchaseUIState = 0;
                    }
                    obj2.Q(4, purchaseUIState);
                    if (purchaseUIState != 0) {
                        value6 = purchaseUIState.getValue();
                    } else {
                        value6 = 0;
                    }
                } else {
                }
                if (Long.compare(i6, i59) != 0) {
                    if (view9 != null) {
                        result = view9.getResult();
                    } else {
                        result = 0;
                    }
                    obj2.Q(5, result);
                    if (result != null) {
                        value4 = result.getValue();
                    } else {
                        value4 = 0;
                    }
                } else {
                }
                if (Long.compare(i45, i59) != 0) {
                    if (view9 != null) {
                        selected = view9.getSelected();
                        skuList = view9.getSkuList();
                    } else {
                        selected = 0;
                        skuList = 0;
                    }
                    obj2.Q(7, selected);
                    obj2.Q(10, skuList);
                    if (selected != 0) {
                        value2 = selected.getValue();
                    } else {
                        value2 = 0;
                    }
                    if (skuList != null) {
                        value5 = skuList.getValue();
                    } else {
                        value5 = 0;
                    }
                    if (bestValueSelectedNumber != 0) {
                        if (view9 != null) {
                            selectedSkuDetails = view9.getSelectedSkuDetails(ViewDataBinding.J(value2), value5);
                        } else {
                            selectedSkuDetails = 0;
                        }
                    } else {
                        cmp5 = 0;
                    }
                    int cmp19 = Long.compare(i99, i98);
                    if (cmp19 != 0) {
                        if (view9 != null) {
                            bestValueProduct = view9.getBestValueProduct(value5);
                            bestValueSavingsPercentString = view9.bestValueSavingsPercentString(value5);
                        } else {
                            bestValueProduct = 0;
                            bestValueSavingsPercentString = 0;
                        }
                        i35 = value2;
                        i2 = bestValueSavingsPercentString == null ? 1 : 0;
                        obj = value8;
                        i39 = value;
                        Object[] arr2 = new Object[1];
                        i44 = 0;
                        arr2[i44] = bestValueSavingsPercentString;
                        Object[] arr = new Object[1];
                        arr[i44] = bestValueSavingsPercentString;
                        if (cmp19 != 0) {
                            i10 = i2 != 0 ? 67108864 : 33554432;
                            l |= i10;
                        }
                        i32 = i2 != 0 ? i56 : i44;
                        i4 = i32;
                        i24 = string2;
                        i41 = i12;
                    } else {
                        i35 = value2;
                        obj = value8;
                        i39 = value;
                        i4 = i44;
                        i41 = 0;
                        i24 = 0;
                        bestValueProduct = 0;
                    }
                    if (Long.compare(i102, i45) != 0) {
                        if (view9 != null) {
                            i12 = l;
                            i47 = bestValueSelectedNumber;
                        } else {
                            i12 = l;
                            i47 = i44;
                        }
                        i19 = cmp5 == i47 ? 1 : i44;
                        l = i12;
                    } else {
                        i12 = l;
                        i19 = i44;
                    }
                } else {
                    obj = value8;
                    i39 = value;
                    i19 = i4;
                    i41 = 0;
                    value5 = 0;
                    i24 = 0;
                    selectedSkuDetails = 0;
                    bestValueProduct = 0;
                    i35 = 0;
                }
                int cmp15 = Long.compare(i12, i23);
                if (cmp15 != 0) {
                    if (view9 != null) {
                        discountVisible = view9.getDiscountVisible();
                        i37 = i41;
                    } else {
                        i37 = i41;
                        discountVisible = 0;
                    }
                    obj2.Q(9, discountVisible);
                    if (discountVisible != 0) {
                        value7 = discountVisible.getValue();
                    } else {
                        value7 = 0;
                    }
                    boolean z = ViewDataBinding.K(value7);
                    if (cmp15 != 0) {
                        if (z) {
                            l |= i101;
                            i12 = 4194304;
                        } else {
                            l |= i100;
                            i12 = 2097152;
                        }
                        i52 |= i12;
                    }
                    i46 = z ? i44 : i56;
                    if (z) {
                    } else {
                        i56 = i44;
                    }
                    i57 = i24;
                    i13 = value6;
                    i38 = selectedSkuDetails;
                    i41 = i37;
                    i26 = i39;
                    i34 = pricePerPeriodType;
                    userTestimonialsCallback = userTestimonialsCallback2;
                    i27 = i46;
                    i36 = i56;
                    i48 = bestValueProduct;
                    i20 = value5;
                    valueOf = value3;
                    i25 = i43;
                    i8 = obj;
                } else {
                    int i92 = i41;
                    i20 = value5;
                    i57 = i24;
                    valueOf = value3;
                    i13 = value6;
                    i38 = selectedSkuDetails;
                    i25 = i43;
                    i27 = i36;
                    i26 = i39;
                    i34 = pricePerPeriodType;
                    i8 = obj;
                    userTestimonialsCallback = userTestimonialsCallback2;
                    i48 = bestValueProduct;
                }
                callbacks = callbacks2;
                i11 = value4;
                i5 = i4;
                i30 = i54;
                i21 = listOfCustomerExperiences;
                i7 = i55;
                int i95 = 0;
                if (Long.compare(i87, i95) != 0) {
                    i53 = i11;
                    obj2.O.setVisibility(i27);
                    obj2.Y.setVisibility(i36);
                } else {
                    i53 = i11;
                }
                if (Long.compare(i49, i95) != 0) {
                    SubscriptionBindingAdapters.setupTimerSubscribe(obj2.O, valueOf, obj2.e0);
                }
                if (Long.compare(i65, i95) != 0) {
                    obj2.P.w().setVisibility(i30);
                    obj2.P.V(i34);
                    obj2.S.setVisibility(i7);
                    obj2.V.setVisibility(i7);
                    obj2.b0.setVisibility(i25);
                }
                i18 = 0;
                if (Long.compare(i67, i18) != 0) {
                    obj2.P.U(obj2.r0);
                    n.k0(obj2.d0, 0);
                }
                if (Long.compare(i69, i18) != 0) {
                    obj2.P.T(i26);
                }
                if (Long.compare(i70, i18) != 0) {
                    obj2.P.W(Boolean.valueOf(i19));
                }
                if (Long.compare(i50, i18) != 0) {
                    obj2.P.X(i48);
                    obj2.k0.setVisibility(i5);
                    g.c(obj2.l0, i41);
                    obj2.p0.setVisibility(i5);
                    g.c(obj2.q0, i57);
                }
                if (Long.compare(i28, i9) != 0) {
                    i5 = i53;
                    SubscriptionBindingAdapters.setDiscountText(obj2.T, i5, obj2.Z);
                    SubscriptionBindingAdapters.setSubscriptionImage(obj2.U, i5, obj2.d0, obj2.Z, obj2.W);
                }
                i16 = 0;
                if (Long.compare(i40, i16) != 0) {
                    SubscriptionBindingAdapters.setCustomerExperienceList(obj2.V, i21, userTestimonialsCallback);
                }
                if (Long.compare(i17, i16) != 0) {
                    SubscriptionBindingAdapters.setSubscriptionPlanButton(obj2.X, i38, i8);
                }
                if (Long.compare(i31, i16) != 0) {
                    n.D0(obj2.m0, i13);
                }
                if (Long.compare(i58, i16) != 0) {
                    i50 = i20;
                    i27 = callbacks;
                    i18 = i35;
                    i7 = i26;
                    i25 = i34;
                    SubscriptionBindingAdapters.setBenefitListAdapter(obj2.a0, i50, i27, i18, i7, i25);
                    SubscriptionBindingAdapters.setBenefitListAdapter(obj2.b0, i50, i27, i18, i7, i25);
                }
                ViewDataBinding.o(obj2.e0);
                ViewDataBinding.o(obj2.P);
                ViewDataBinding.o(obj2.R);
                ViewDataBinding.o(obj2.n0);
                ViewDataBinding.o(obj2.o0);
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.e0.y()) {
                }
                return i2;
                if (this.P.y()) {
                }
                return i2;
                if (this.R.y()) {
                }
                return i2;
                if (this.n0.y()) {
                }
                return i2;
                if (this.o0.y()) {
                }
                return i2;
                return 0;
            }
        }
    }
}
