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

/* compiled from: FragmentSubscriptionChoosePlanBindingImpl.java */
/* loaded from: classes.dex */
public class vg extends ug {

    private static final ViewDataBinding.g d0 = new ViewDataBinding$g(23);
    private static final SparseIntArray e0 = new SparseIntArray();
    private final ConstraintLayout Z;
    private final FrameLayout a0;
    private final TextView b0;
    private long c0;
    static {
        int i14 = 1;
        final int[] iArr2 = new int[i14];
        final int i30 = 0;
        iArr2[i30] = 10;
        int[] iArr = new int[i14];
        iArr[i30] = R.layout.layout_discount_timer;
        obj.a(2, new String[] { "layout_discount_timer" }, iArr2, iArr);
        obj.put(2131363433, 11);
        obj.put(2131362573, 12);
        obj.put(2131362572, 13);
        obj.put(2131362574, 14);
        obj.put(2131362575, 15);
        obj.put(2131362577, 16);
        obj.put(2131362578, 17);
        obj.put(2131362906, 18);
        obj.put(2131363416, 19);
        obj.put(2131362956, 20);
        obj.put(2131363286, 21);
        obj.put(2131362392, 22);
    }

    public vg(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 23, vg.d0, vg.e0));
    }

    private boolean X(kk kkVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean b0(LiveData<y<SubscriptionOffer>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean c0(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean d0(x<List<DogoSkuDetails>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 128;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean e0(x<CouponTimer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.c0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public void A() {
        synchronized (this) {
            try {
                this.c0 = 1024L;
            } catch (Throwable th) {
            }
        }
        this.U.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ug
    protected boolean E(int i, Object object, int i2) {
        switch (i) {
            case 0:
                return this.e0(object, i2);
            case 1:
                return this.Z(object, i2);
            case 2:
                return this.a0(object, i2);
            case 3:
                return this.X(object, i2);
            case 4:
                return this.b0(object, i2);
            case 5:
                return this.c0(object, i2);
            case 6:
                return this.Y(object, i2);
            case 7:
                return this.d0(object, i2);
            default:
                return false;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public void M(q qVar) {
        super.M(qVar);
        this.U.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public void V(SubscriptionBenefitsOfferAdapter.Callbacks callbacks) {
        this.Y = callbacks;
        synchronized (this) {
            try {
                this.c0 |= 256;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public void W(SubscriptionViewModel subscriptionViewModel) {
        this.X = subscriptionViewModel;
        synchronized (this) {
            try {
                this.c0 |= 512;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ug
    protected void m() {
        int cmp;
        long l;
        long l2;
        long l3;
        int i;
        Integer num;
        Boolean bool3;
        boolean z;
        List list;
        List list2;
        Boolean bool;
        Object obj4;
        boolean z2 = false;
        Boolean bool2;
        Object obj;
        DogoSkuDetails selectedSkuDetails;
        LiveData result;
        y yVar;
        Object obj5;
        java.lang.CharSequence charSequence;
        Object obj6;
        CouponTimer couponTimer;
        int cmp9 = 2131887435;
        Object obj2;
        DogoSkuDetails dogoSkuDetails;
        Object obj7;
        int cmp10;
        long l7 = 2097152;
        int i3 = 8192;
        long l8;
        int cmp11 = 131072;
        int cmp12;
        long l11;
        int cmp13;
        long l12;
        long l4 = 0;
        long l14;
        int i4 = 0;
        int cmp14;
        int i6 = 524288;
        int i5 = 8388608;
        final Object obj3 = this;
        synchronized (this) {
            try {
                l4 = 0L;
                obj3.c0 = l4;
            } catch (Throwable th) {
            }
        }
        long l24 = 2039L & l;
        long l5 = 4194304L;
        long l6 = 4096L;
        l7 = 2097152L;
        long l9 = 2048L;
        final long l32 = 65536L;
        final long l33 = 1698L;
        final long l34 = 1537L;
        final long l35 = 1556L;
        final long l36 = 1536L;
        final long l37 = 1600L;
        i = 0;
        cmp = 0;
        if (l24 != l4) {
            long l38 = l & 1536L;
            cmp = 4;
            if (l38 != l4) {
                if (obj3.X != null) {
                    boolean showResubscribeLayout = obj3.X.getShowResubscribeLayout();
                } else {
                }
                if (l38 != l4) {
                    l = cmp != 0 ? l20 | l5 : l19 | l7;
                }
                int r6 = cmp;
                int r37 = cmp != 0 ? cmp : 8;
            } else {
            }
            long l39 = l & 1537L;
            if (l39 != l4) {
                x timer = obj3.X != null ? timer : i;
                obj3.Q(cmp, obj6);
                Object value6 = obj6 != null ? (CouponTimer)value6 : i;
            }
            l11 = l & 1698L;
            if (l11 != l4) {
                x freeTrailAvailable2 = obj3.X != null ? freeTrailAvailable2 : i;
                obj3.Q(1, obj7);
                Object value7 = obj7 != null ? (Boolean)value7 : i;
            }
            long l40 = l & 1972L;
            if (l40 != l4) {
                x freeTrailAvailable = obj3.X != null ? freeTrailAvailable : i;
                obj3.Q(2, obj4);
                Object value4 = obj4 != null ? (Boolean)value4 : i;
                l12 = l & 1556L;
                if (l12 != l4) {
                    z2 = ViewDataBinding.K(bool);
                } else {
                    int i16 = 0;
                }
            } else {
            }
            long l41 = l & 1556L;
            if (l41 != l4) {
                result = obj3.X != null ? result : i;
                obj3.Q(cmp, result);
                Object value5 = result != null ? (LoadResult)value5 : i;
            }
            long l25 = 1958L & l;
            if (l25 != l4) {
                if (obj3.X != null) {
                    x selected = obj3.X.getSelected();
                    x skuList = obj3.X.getSkuList();
                } else {
                }
                obj3.Q(5, obj);
                obj3.Q(7, obj5);
                Object value = obj != null ? (Integer)value : i;
                Object value3 = obj5 != null ? (List)value3 : i;
                if (l11 == l4 || obj3.X == null) {
                } else {
                    selectedSkuDetails = obj3.X.getSelectedSkuDetails(ViewDataBinding.J(num), list);
                }
                l14 = l & 1664L;
                long l13 = 0L;
                if (l14 != l13) {
                    if (obj3.X != null) {
                        String bestValueSavingsPercentString = obj3.X.bestValueSavingsPercentString(list);
                    } else {
                    }
                    int r47 = i == 0 ? 1 : 0;
                    int i2 = 1;
                    Object[] arr = new Object[1];
                    cmp = 0;
                    cmp9 = 2131887435;
                    String string = obj3.b0.getResources().getString(2131887435, new Object[] { i });
                    if (l14 != l13) {
                        int r50 = i4 != 0 ? 0x01000000 /* Unknown resource */ : 8388608;
                        l = l | (i4 != 0 ? 0x01000000 /* Unknown resource */ : 8388608);
                    }
                    r6 = i4 != 0 ? 8 : cmp;
                } else {
                    i2 = 1;
                    cmp = 0;
                }
            } else {
                i2 = 1;
                cmp = 0;
            }
            l17 = l & 1600L;
            if (l17 != 0) {
                if (obj3.X != null) {
                    x discountVisible = obj3.X.getDiscountVisible();
                } else {
                }
                obj3.Q(6, obj2);
                Object value2 = obj2 != null ? (Boolean)value2 : i;
                if (l17 != 0 && ViewDataBinding.K(bool3)) {
                    l3 = l | 65536L;
                    i6 = 1048576;
                    l = l3 | i6;
                }
            } else {
            }
            long l10 = 1956L;
            l16 = l & l10;
            l4 = 0L;
            if (l16 == l4 || obj3.X == null) {
            } else {
            }
        } else {
        }
        long l43 = l & 589824L;
        if (l43 != l4) {
            if (obj3.X != null) {
                boolean showResubscribeLayout2 = obj3.X.getShowResubscribeLayout();
            }
            l15 = l & 1536L;
            if (l15 != l4) {
                if (cmp != 0) {
                    l11 = 4096L;
                    l2 = l | l11;
                    int i19 = 4194304;
                } else {
                    l2 = l | 2048L;
                }
                l = l2 | l7;
            }
            l7 = l & 65536L;
            Throwable th = l7 != l4 ? cmp ^ 1 : cmp;
        }
        long l27 = l & 1600L;
        if (l27 != l4) {
            if (cmp == 0) {
            }
            r47 = cmp != 0 ? 1 : cmp;
            if (l27 != l4 && obj3.X != 0) {
                cmp11 = 262144;
                l = l | cmp11;
            }
            l8 = l & 1600L;
            l9 = 0L;
            if (l8 != l9) {
                int r17 = cmp != 0 ? 16384 : 8192;
                l = l | (cmp != 0 ? 16384 : 8192);
            }
            th = obj3.X != 0 ? cmp : 8;
            if (cmp != 0) {
                cmp = 8;
            }
        } else {
        }
        long l26 = l & 1600L;
        final long l28 = 0L;
        if (l26 != l28) {
            obj3.O.setVisibility(cmp);
            obj3.V.setVisibility(cmp);
        } else {
        }
        long l29 = l & 1537L;
        if (l29 != l28) {
            SubscriptionBindingAdapters.setupTimerSubscribe(obj3.O, couponTimer, obj3.U);
        }
        long l30 = l & 1552L;
        if (l30 != l28) {
            SubscriptionBindingAdapters.setSubscriptionPlanTitleText(obj3.P, yVar);
        }
        long l31 = l & 1536L;
        if (l31 != l28) {
            obj3.Q.setVisibility(cmp);
            obj3.S.setVisibility(cmp);
            obj3.T.setVisibility(cmp);
        }
        long l21 = l & 1698L;
        if (obj3.b0 != l28) {
            SubscriptionBindingAdapters.setSubscriptionPlanButton(obj3.Q, dogoSkuDetails, bool2);
        }
        long l22 = 1664L & l;
        if (obj3.b0 != l28) {
            obj3.a0.setVisibility(cmp);
            g.c(obj3.b0, charSequence);
        }
        long l23 = 1956L & l;
        if (obj3.b0 != l28) {
            SubscriptionBindingAdapters.setBenefitListAdapter(obj3.R, list2, obj3.Y, i, i, i);
        }
        l &= l35;
        if (obj3.c0 != 0) {
            SubscriptionBindingAdapters.setSubscriptionBenefitPlanTitle(obj3.V, yVar, cmp);
        }
        ViewDataBinding.o(obj3.U);
    }

    @Override // app.dogo.com.dogo_android.h.ug
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.c0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.U.y()) {
            return true;
        }
        return false;
    }

    private vg(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 8, (ConstraintLayout)objectArr[2], (TextView)objectArr[3], (Guideline)objectArr[22], (ImageView)objectArr[13], (TextView)objectArr[12], (TextView)objectArr[14], (TextView)objectArr[15], (TextView)objectArr[16], (TextView)objectArr[17], (MaterialButton)objectArr[9], (TextView)objectArr[18], (RecyclerView)objectArr[5], (TextView)objectArr[20], (ConstraintLayout)objectArr[1], (MaterialButton)objectArr[8], (Guideline)objectArr[21], (kk)objectArr[10], (Barrier)objectArr[19], (TextView)objectArr[4], (MaterialToolbar)objectArr[11]);
        Object eVar3 = this;
        eVar3.c0 = -1L;
        Object obj4 = null;
        eVar3.O.setTag(obj4);
        eVar3.P.setTag(obj4);
        eVar3.Q.setTag(obj4);
        Object obj = objectArr[0];
        eVar3.Z = obj;
        obj.setTag(obj4);
        Object obj2 = objectArr[6];
        eVar3.a0 = obj2;
        obj2.setTag(obj4);
        Object obj3 = objectArr[7];
        eVar3.b0 = obj3;
        obj3.setTag(obj4);
        eVar3.R.setTag(obj4);
        eVar3.S.setTag(obj4);
        eVar3.T.setTag(obj4);
        eVar3.L(eVar3.U);
        eVar3.V.setTag(obj4);
        eVar3.N(view);
        A();
    }
}
