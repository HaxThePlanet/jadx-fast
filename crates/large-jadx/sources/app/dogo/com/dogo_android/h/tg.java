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

/* compiled from: FragmentSubscriptionBenefitsBindingImpl.java */
/* loaded from: classes.dex */
public class tg extends sg implements b.a {

    private static final ViewDataBinding.g t0 = new ViewDataBinding$g(33);
    private static final SparseIntArray u0 = new SparseIntArray();
    private final ConstraintLayout i0;
    private final ConstraintLayout j0;
    private final FrameLayout k0;
    private final TextView l0;
    private final FrameLayout m0;
    private final ml n0;
    private final ml o0;
    private final FrameLayout p0;
    private final TextView q0;
    private final View.OnClickListener r0;
    private long s0;
    static {
        int i26 = 1;
        i.a(i26, new String[] { "layout_subscription_plan_information_card", "layout_customer_benefits" }, new int[] { 19, 20 }, new int[] { R.layout.layout_subscription_plan_information_card, R.layout.layout_customer_benefits });
        int[] iArr2 = new int[i26];
        final int i28 = 0;
        iArr2[i28] = 18;
        int[] iArr5 = new int[i26];
        iArr5[i28] = R.layout.layout_discount_timer;
        i.a(4, new String[] { "layout_discount_timer" }, iArr2, iArr5);
        String str3 = "layout_loading_spinner";
        int[] iArr6 = new int[i26];
        iArr6[i28] = 21;
        int[] iArr8 = new int[i26];
        final int i32 = 2131558788;
        iArr8[i28] = i32;
        i.a(16, new String[] { str3 }, iArr6, iArr8);
        int[] iArr3 = new int[i26];
        iArr3[i28] = 22;
        int[] iArr7 = new int[i26];
        iArr7[i28] = i32;
        i.a(17, new String[] { str3 }, iArr3, iArr7);
        i.put(2131363185, 23);
        i.put(2131362193, 24);
        i.put(2131362906, 25);
        i.put(2131363416, 26);
        i.put(2131362909, 27);
        i.put(2131362910, 28);
        i.put(2131363286, 29);
        i.put(2131362392, 30);
        i.put(2131362322, 31);
        i.put(2131362956, 32);
    }

    public tg(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 33, tg.t0, tg.u0));
    }

    private boolean Y(ym ymVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.s0 |= 256;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(ii iiVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.s0 |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(kk kkVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.s0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean b0(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.s0 |= 512;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean c0(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.s0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean d0(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.s0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean e0(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.s0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean f0(LiveData<y<SubscriptionOffer>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.s0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean g0(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.s0 |= 128;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean h0(x<List<DogoSkuDetails>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.s0 |= 1024;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean i0(x<CouponTimer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.s0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public void A() {
        synchronized (this) {
            try {
                this.s0 = 16384L;
            } catch (Throwable th) {
            }
        }
        this.e0.A();
        this.P.A();
        this.R.A();
        this.n0.A();
        this.o0.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.sg
    protected boolean E(int i, Object object, int i2) {
        switch (i) {
            case 0:
                return this.i0(object, i2);
            case 1:
                return this.c0(object, i2);
            case 2:
                return this.d0(object, i2);
            case 3:
                return this.a0(object, i2);
            case 4:
                return this.e0(object, i2);
            case 5:
                return this.f0(object, i2);
            case 6:
                return this.Z(object, i2);
            case 7:
                return this.g0(object, i2);
            case 8:
                return this.Y(object, i2);
            case 9:
                return this.b0(object, i2);
            case 10:
                return this.h0(object, i2);
            default:
                return false;
        }
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public void M(q qVar) {
        super.M(qVar);
        this.e0.M(qVar);
        this.P.M(qVar);
        this.R.M(qVar);
        this.n0.M(qVar);
        this.o0.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public boolean O(int i, Object object) {
        int i2 = 151;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 151;
            if (151 == i) {
                W(object);
            } else {
                i2 = 177;
                if (177 == i) {
                    X(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public void V(SubscriptionBenefitsOfferAdapter.Callbacks callbacks) {
        this.g0 = callbacks;
        synchronized (this) {
            try {
                this.s0 |= 2048;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public void W(UserTestimonialsCallback userTestimonialsCallback) {
        this.h0 = userTestimonialsCallback;
        synchronized (this) {
            try {
                this.s0 |= 4096;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(151);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public void X(SubscriptionViewModel subscriptionViewModel) {
        this.f0 = subscriptionViewModel;
        synchronized (this) {
            try {
                this.s0 |= 8192;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public final void b(int i, View view) {
        int view22;
        view22 = 1;
        view22 = 0;
        int r1 = this.f0 != null ? 1 : view22;
        if (view22 != null && skuList != null) {
            if (view22 != null) {
                this.f0.bestValueItemSelected((List)skuList.getValue());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.sg
    protected void m() {
        int i = 0;
        long l;
        long l2;
        long l3;
        int bestValueSelectedNumber;
        java.lang.CharSequence charSequence = null;
        int i2 = 0;
        Boolean bool2 = null;
        Integer num = null;
        CouponTimer couponTimer = null;
        int i3 = 0;
        int i4;
        List list = null;
        DogoSkuDetails dogoSkuDetails2 = null;
        int i5;
        Object obj2 = null;
        int i6 = 0;
        int i7 = 0;
        int i8 = 33554432;
        Object obj3 = null;
        Object obj4 = null;
        Object value2 = null;
        List listOfCustomerExperiences = null;
        Object obj5 = null;
        Object value = null;
        java.lang.CharSequence charSequence2 = null;
        Object obj6 = null;
        int cmp12;
        app.dogo.com.dogo_android.k.n nVar = null;
        int i10 = 0;
        int i11;
        Object obj7 = null;
        Boolean bool = null;
        LiveData result = null;
        int i13 = 0;
        Object obj8 = null;
        int cmp14;
        int i12 = 4;
        SubscriptionBenefitsOfferAdapter.Callbacks callbacks;
        int i14 = 0;
        UserTestimonialsCallback userTestimonialsCallback;
        int i16 = 16777216;
        long l14;
        int i15 = 131072;
        x freeTrailAvailable;
        int cmp15;
        long l15 = 25600;
        boolean z2;
        int i17 = 0;
        int i18;
        int i19 = 0;
        long l19;
        int i20 = 2097152;
        final Object obj = this;
        synchronized (this) {
            try {
                long l21 = 0L;
                obj.s0 = l21;
            } catch (Throwable th) {
            }
        }
        long l26 = l & 28672L;
        long l27 = 32439L & l;
        long l13 = 24608L;
        final long l29 = 24592L;
        final long l30 = 25728L;
        final long l31 = 27780L;
        final long l32 = 25730L;
        final long l33 = 24577L;
        long l34 = 25088L;
        final long l36 = 24576L;
        bestValueSelectedNumber = 0;
        if (l27 != l21) {
            long l37 = l & 24577L;
            if (l37 != l21) {
                if (obj.f0 != null) {
                    x timer = obj.f0.getTimer();
                } else {
                    int i47 = 0;
                }
                obj.Q(bestValueSelectedNumber, obj5);
                Object value7 = obj5 != null ? (CouponTimer)value7 : 0;
            }
            if (l26 == l21 || obj.f0 == null) {
                int i45 = 0;
            } else {
                listOfCustomerExperiences = obj.f0.listOfCustomerExperiences();
            }
            long l38 = l & 24576L;
            bestValueSelectedNumber = 8;
            if (l38 != l21) {
                if (obj.f0 != null) {
                    boolean customersExperienceEnabled = obj.f0.getCustomersExperienceEnabled();
                    boolean allPlansTopEnabled = obj.f0.allPlansTopEnabled();
                } else {
                }
                if (l38 != l21) {
                    int r34 = bestValueSelectedNumber != 0 ? 262144 : 131072;
                    l = l | (bestValueSelectedNumber != 0 ? 262144 : 131072);
                }
                l14 = l & 24576L;
                if (l14 != l21) {
                    if (bestValueSelectedNumber != 0) {
                        l2 = l | 65536L;
                        i16 = 16777216;
                    } else {
                        l2 = l | 32768L;
                        i16 = 8388608;
                    }
                    l = l2 | i16;
                }
                int r30 = bestValueSelectedNumber;
                int r32 = bestValueSelectedNumber;
                int r33 = bestValueSelectedNumber;
            } else {
            }
            long l39 = l & 25730L;
            if (l39 != l21) {
                freeTrailAvailable = obj.f0 != null ? freeTrailAvailable : 0;
                obj.Q(1, obj3);
                Object value6 = obj3 != null ? (Boolean)value6 : 0;
            }
            long l41 = l & 27780L;
            if (l41 != l21) {
                if (obj.f0 != null) {
                    app.dogo.com.dogo_android.k.n pricePerPeriodType = obj.f0.getPricePerPeriodType();
                } else {
                    int i43 = 0;
                    i11 = 0;
                }
                int i9 = 2;
                obj.Q(i9, obj4);
                value2 = obj4 != null ? (Boolean)value2 : 0;
            } else {
                int i44 = 0;
                i11 = 0;
            }
            long l28 = l & 24592L;
            if (l28 != l21) {
                if (obj.f0 != null) {
                    x purchaseUIState = obj.f0.getPurchaseUIState();
                } else {
                    int i53 = 0;
                }
                i12 = 4;
                obj.Q(i12, obj7);
                Object value8 = obj7 != null ? (LoadResult)value8 : 0;
            }
            l16 = l & 24608L;
            if (l16 != l21) {
                if (obj.f0 != null) {
                    result = obj.f0.getResult();
                } else {
                    int i55 = 0;
                }
                obj.Q(5, result);
                value = result != null ? (LoadResult)value : 0;
            }
            l18 = l & 27782L;
            if (l18 != l21) {
                if (obj.f0 != null) {
                    x selected = obj.f0.getSelected();
                    x skuList = obj.f0.getSkuList();
                } else {
                    int i51 = 0;
                    int i56 = 0;
                }
                obj.Q(7, obj6);
                obj.Q(10, obj8);
                Object value4 = obj6 != null ? (Integer)value4 : 0;
                Object value5 = obj8 != null ? (List)value5 : 0;
                if (l39 == l21) {
                    cmp12 = 0;
                } else {
                    if (obj.f0 != null) {
                        DogoSkuDetails selectedSkuDetails = obj.f0.getSelectedSkuDetails(ViewDataBinding.J(num), list);
                    } else {
                        i13 = 0;
                    }
                }
                l15 = 25600L;
                long l42 = l & l15;
                if (l42 != 0) {
                    if (obj.f0 != null) {
                        DogoSkuDetails bestValueProduct = obj.f0.getBestValueProduct(list);
                        String bestValueSavingsPercentString = obj.f0.bestValueSavingsPercentString(list);
                    } else {
                        i5 = 0;
                        i17 = 0;
                    }
                    int r47 = i17 == 0 ? 1 : 0;
                    Object[] arr2 = new Object[1];
                    bestValueSelectedNumber = 0;
                    Object[] arr = new Object[1];
                    i8 = 2131887435;
                    if (l42 != 0) {
                        int r8 = i18 != 0 ? 67108864 : 33554432;
                        l = l | (i18 != 0 ? 67108864 : 33554432);
                    }
                    r8 = bestValueSelectedNumber;
                    bestValueSelectedNumber = bestValueSelectedNumber;
                } else {
                    bestValueSelectedNumber = 0;
                    i2 = 0;
                    i7 = 0;
                    i5 = 0;
                }
                long l43 = l & 25728L;
                long l18 = 0L;
                if (l43 != l18) {
                    if (obj.f0 != null) {
                    } else {
                    }
                    int r46 = cmp12 == obj.s0 ? 1 : bestValueSelectedNumber;
                } else {
                }
            } else {
                bestValueSelectedNumber = 0;
                i2 = 0;
                i3 = 0;
                i7 = 0;
                i13 = 0;
                i5 = 0;
                i19 = 0;
            }
            l19 = l & 25088L;
            long l17 = 0L;
            if (l19 != l17) {
                if (obj.f0 != null) {
                    x discountVisible = obj.f0.getDiscountVisible();
                } else {
                    int i35 = 0;
                }
                obj.Q(9, obj2);
                Object value3 = obj.f0 != null ? (Boolean)value3 : 0;
                boolean z = ViewDataBinding.K(bool2);
                if (l19 != l17) {
                    if (z) {
                        l3 = l | 1048576L;
                        i20 = 4194304;
                    } else {
                        l3 = l | 524288L;
                        i20 = 2097152;
                    }
                    l = l3 | i20;
                }
                int r7 = bestValueSelectedNumber;
                if (!(z)) {
                }
            } else {
            }
        } else {
            i = 0;
            int i23 = 0;
            int i29 = 0;
            int i31 = 0;
            int i50 = 0;
            int i52 = 0;
            int i54 = 0;
            i3 = 0;
            i6 = 0;
            i14 = 0;
            i19 = 0;
            i10 = 0;
            i13 = 0;
        }
        long l35 = l & 25088L;
        long l40 = 0L;
        if (l35 != l40) {
            obj.O.setVisibility(bestValueSelectedNumber);
            obj.Y.setVisibility(bestValueSelectedNumber);
        } else {
        }
        l10 = l & 24577L;
        if (obj.f0 != l40) {
            SubscriptionBindingAdapters.setupTimerSubscribe(obj.O, couponTimer, obj.e0);
        }
        long l22 = l & 24576L;
        if (obj.f0 != l40) {
            obj.P.w().setVisibility(bestValueSelectedNumber);
            obj.P.V(nVar);
            obj.S.setVisibility(bestValueSelectedNumber);
            obj.V.setVisibility(bestValueSelectedNumber);
            obj.b0.setVisibility(bestValueSelectedNumber);
        }
        long l23 = 16384L & l;
        long l12 = 0L;
        if (obj.f0 != l12) {
            obj.P.U(obj.r0);
            BindingAdapters.k0(obj.d0, null);
        }
        long l24 = 24580L & l;
        if (obj.f0 != l12) {
            obj.P.T(bool);
        }
        long l25 = l & 25728L;
        if (obj.f0 != l12) {
            obj.P.W(Boolean.valueOf(z2));
        }
        l11 = 25600L & l;
        if (obj.f0 != l12) {
            obj.P.X(dogoSkuDetails2);
            obj.k0.setVisibility(bestValueSelectedNumber);
            g.c(obj.l0, charSequence);
            obj.p0.setVisibility(bestValueSelectedNumber);
            g.c(obj.q0, charSequence2);
        }
        l4 = 24608L & l;
        long l8 = 0L;
        if (obj.l0 != l8) {
            y yVar2 = i;
            SubscriptionBindingAdapters.setDiscountText(obj.T, yVar2, obj.Z);
            SubscriptionBindingAdapters.setSubscriptionImage(obj.U, yVar2, obj.d0, obj.Z, obj.W);
        }
        l5 = 28672L & l;
        long l9 = 0L;
        if (obj.d0 != l9) {
            SubscriptionBindingAdapters.setCustomerExperienceList(obj.V, i14, userTestimonialsCallback);
        }
        l6 = l & 25730L;
        if (obj.d0 != l9) {
            SubscriptionBindingAdapters.setSubscriptionPlanButton(obj.X, i13, i6);
        }
        l7 = l & 24592L;
        if (obj.d0 != l9) {
            BindingAdapters.setDebugJsonEntryItemAdapter(obj.m0, i10);
        }
        l &= l31;
        if (obj.s0 != l9) {
            List list2 = i3;
            Integer num2 = i19;
            SubscriptionBindingAdapters.setBenefitListAdapter(obj.a0, list2, callbacks, num2, bool, nVar);
            SubscriptionBindingAdapters.setBenefitListAdapter(obj.b0, list2, callbacks, num2, bool, nVar);
        }
        ViewDataBinding.o(obj.e0);
        ViewDataBinding.o(obj.P);
        ViewDataBinding.o(obj.R);
        ViewDataBinding.o(obj.n0);
        ViewDataBinding.o(obj.o0);
    }

    @Override // app.dogo.com.dogo_android.h.sg
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z6 = true;
                if (this.s0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.e0.y()) {
            return true;
        }
        if (this.P.y()) {
            return true;
        }
        if (this.R.y()) {
            return true;
        }
        if (this.n0.y()) {
            return true;
        }
        if (this.o0.y()) {
            return true;
        }
        return false;
    }

    private tg(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 11, (ConstraintLayout)objectArr[4], (ym)objectArr[19], (ImageView)objectArr[24], (ii)objectArr[20], (TextView)objectArr[10], (TextView)objectArr[5], (ImageView)objectArr[31], (ImageView)objectArr[2], (Guideline)objectArr[30], (ViewPager2)objectArr[11], (FrameLayout)objectArr[17], (MaterialButton)objectArr[15], (TextView)objectArr[6], (TextView)objectArr[25], (RecyclerView)objectArr[12], (RecyclerView)objectArr[7], (Barrier)objectArr[27], (Barrier)objectArr[28], (TextView)objectArr[32], (ScrollView)objectArr[23], (Guideline)objectArr[29], (FrameLayout)objectArr[3], (kk)objectArr[18], (Barrier)objectArr[26]);
        Object eVar4 = this;
        eVar4.s0 = -1L;
        Object obj2 = null;
        eVar4.O.setTag(obj2);
        eVar4.L(eVar4.P);
        eVar4.L(eVar4.R);
        eVar4.S.setTag(obj2);
        eVar4.T.setTag(obj2);
        eVar4.U.setTag(obj2);
        eVar4.V.setTag(obj2);
        eVar4.W.setTag(obj2);
        eVar4.X.setTag(obj2);
        Object obj = objectArr[0];
        eVar4.i0 = obj;
        obj.setTag(obj2);
        int i3 = 1;
        Object obj3 = objectArr[i3];
        eVar4.j0 = obj3;
        obj3.setTag(obj2);
        Object obj4 = objectArr[13];
        eVar4.k0 = obj4;
        obj4.setTag(obj2);
        Object obj5 = objectArr[14];
        eVar4.l0 = obj5;
        obj5.setTag(obj2);
        Object obj6 = objectArr[16];
        eVar4.m0 = obj6;
        obj6.setTag(obj2);
        Object obj7 = objectArr[21];
        eVar4.n0 = obj7;
        eVar4.L(obj7);
        Object obj8 = objectArr[22];
        eVar4.o0 = obj8;
        eVar4.L(obj8);
        Object obj9 = objectArr[8];
        eVar4.p0 = obj9;
        obj9.setTag(obj2);
        Object obj10 = objectArr[9];
        eVar4.q0 = obj10;
        obj10.setTag(obj2);
        eVar4.Y.setTag(obj2);
        eVar4.a0.setTag(obj2);
        eVar4.b0.setTag(obj2);
        eVar4.d0.setTag(obj2);
        eVar4.L(eVar4.e0);
        eVar4.N(view);
        eVar4.r0 = new b(eVar4, i3);
        A();
    }
}
