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
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.k.n;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;
import app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters;

/* compiled from: CellSubscriptionPlanInformationCardBindingImpl.java */
/* loaded from: classes.dex */
public class t7 extends s7 {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0 = new SparseIntArray();
    private final ConstraintLayout Z;
    private final ConstraintLayout a0;
    private long b0;
    static {
        obj.put(2131362357, 9);
        obj.put(2131361923, 10);
    }

    public t7(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 11, t7.c0, t7.d0));
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public void A() {
        synchronized (this) {
            try {
                this.b0 = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public boolean O(int i, Object object) {
        int i2 = 144;
        boolean z = false;
        i2 = 75;
        if (75 == i) {
            V(object);
            int i4 = 1;
        } else {
            i2 = 144;
            if (144 == i) {
                Y(object);
            } else {
                i2 = 126;
                if (126 == i) {
                    W(object);
                } else {
                    i2 = 135;
                    if (135 == i) {
                        X(object);
                    } else {
                        int i3 = 0;
                    }
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public void V(Boolean boolean) {
        this.X = boolean;
        synchronized (this) {
            try {
                this.b0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(75);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public void W(n nVar) {
        this.Y = nVar;
        synchronized (this) {
            try {
                this.b0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(126);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public void X(Boolean boolean) {
        this.W = boolean;
        synchronized (this) {
            try {
                this.b0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(135);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public void Y(DogoSkuDetails dogoSkuDetails) {
        this.V = dogoSkuDetails;
        synchronized (this) {
            try {
                this.b0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(144);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.s7
    protected void m() {
        boolean z = false;
        long l;
        long l2;
        int cmp3 = 0;
        Object obj2 = null;
        android.graphics.drawable.Drawable drawable = null;
        int i = 0;
        int i2 = 2131100379;
        long l3;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l9 = 0L;
                obj.b0 = l9;
            } catch (Throwable th) {
            }
        }
        final long l12 = 19L;
        long l13 = l & l12;
        if (l13 != l9) {
            z = ViewDataBinding.K(obj.X);
        } else {
            int i3 = 0;
        }
        long l14 = 23L & l;
        if (l14 != l9) {
            l3 = l & 18L;
            if (l3 != l9) {
                String priceDescriptionV2 = DogoSkuDetails.getPriceDescriptionV2(obj.V, w().getContext());
            } else {
                int i6 = 0;
            }
        }
        long l15 = 24L;
        long l17 = l & l15;
        if (l17 != l9) {
            boolean z2 = ViewDataBinding.K(obj.W);
            if (l17 != l9 && z2) {
                l2 = (l | 64L) | 256L | 1024L;
                cmp3 = 4096;
                l = l2 | cmp3;
            }
            cmp3 = 8;
            int r19 = z2 ? 8 : 0;
            int r15 = z2 ? R.color.backgroundGreen : R.color.white;
            if (z2) {
                cmp3 = 0;
            }
            if (z2) {
                int i11 = 0;
            } else {
            }
        } else {
            cmp3 = 0;
            cmp3 = 0;
            int i9 = 0;
            i = 0;
        }
        long l16 = l & 24L;
        if (l16 != l9) {
            obj.O.setVisibility(cmp3);
            obj.Q.setVisibility(cmp3);
            h.a(obj.a0, drawable);
            obj.T.setCardBackgroundColor(i);
        }
        long l10 = l & 19L;
        if (obj.W != l9) {
            SubscriptionBindingAdapters.subscriptionPerPeriod(obj.P, obj.V, z);
        }
        long l11 = 18L & l;
        if (obj.W != l9) {
            SubscriptionBindingAdapters.setOldStrikedPrice(obj.R, obj.V);
            g.c(obj.U, obj2);
        }
        l &= 22;
        if (obj.b0 != l9) {
            SubscriptionBindingAdapters.setPerPeriod(obj.S, obj.V, obj.Y);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s7
    public boolean y() {
        synchronized (this) {
            try {
                if (this.b0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private t7(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (ImageView)objectArr[3], (Guideline)objectArr[10], (TextView)objectArr[5], (FrameLayout)objectArr[9], (ImageView)objectArr[4], (TextView)objectArr[6], (TextView)objectArr[8], (CardView)objectArr[1], (TextView)objectArr[7]);
        eVar3.b0 = -1L;
        Object obj12 = null;
        eVar3.O.setTag(obj12);
        eVar3.P.setTag(obj12);
        eVar3.Q.setTag(obj12);
        Object obj10 = objectArr[0];
        eVar3.Z = obj10;
        obj10.setTag(obj12);
        Object obj11 = objectArr[2];
        eVar3.a0 = obj11;
        obj11.setTag(obj12);
        eVar3.R.setTag(obj12);
        eVar3.S.setTag(obj12);
        eVar3.T.setTag(obj12);
        eVar3.U.setTag(obj12);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s7
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
