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
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.k.n;
import app.dogo.com.dogo_android.subscription.DogoSkuDetails;
import app.dogo.com.dogo_android.subscription.SubscriptionBindingAdapters;

/* compiled from: LayoutSubscriptionPlanInformationCardBindingImpl.java */
/* loaded from: classes.dex */
public class zm extends ym {

    private static final ViewDataBinding.g f0;
    private static final SparseIntArray g0 = new SparseIntArray();
    private final ConstraintLayout b0;
    private final ConstraintLayout c0;
    private zm.a d0;
    private long e0;

    public static class a implements View.OnClickListener {

        private View.OnClickListener a;
        public zm.a a(View.OnClickListener list) {
            int i = 0;
            this.a = list;
            list = list == null ? 0 : this;
            return (list == null ? 0 : this);
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            this.a.onClick(view);
        }
    }
    static {
        obj.put(2131362357, 10);
        obj.put(2131361923, 11);
    }

    public zm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 12, zm.f0, zm.g0));
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void A() {
        synchronized (this) {
            try {
                this.e0 = 32L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public boolean O(int i, Object object) {
        int i2 = 75;
        boolean z = true;
        i2 = 120;
        if (120 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 75;
            if (75 == i) {
                T(object);
            } else {
                i2 = 144;
                if (144 == i) {
                    X(object);
                } else {
                    i2 = 126;
                    if (126 == i) {
                        V(object);
                    } else {
                        i2 = 135;
                        if (135 == i) {
                            W(object);
                        } else {
                            int i4 = 0;
                        }
                    }
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void T(Boolean boolean) {
        this.Z = boolean;
        synchronized (this) {
            try {
                this.e0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(75);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void U(View.OnClickListener list) {
        this.X = list;
        synchronized (this) {
            try {
                this.e0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(120);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void V(n nVar) {
        this.a0 = nVar;
        synchronized (this) {
            try {
                this.e0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(126);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void W(Boolean boolean) {
        this.Y = boolean;
        synchronized (this) {
            try {
                this.e0 |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(135);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public void X(DogoSkuDetails dogoSkuDetails) {
        this.W = dogoSkuDetails;
        synchronized (this) {
            try {
                this.e0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(144);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ym
    protected void m() {
        app.dogo.com.dogo_android.h.zm.a aVar = null;
        long l;
        long l2;
        boolean z;
        android.graphics.drawable.Drawable drawable = null;
        int cmp4;
        int i = 2131100379;
        app.dogo.com.dogo_android.h.zm.a aVar2;
        Object obj2 = null;
        long l3;
        int i2;
        long l4;
        int i3 = 32768;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l10 = 0L;
                obj.e0 = l10;
            } catch (Throwable th) {
            }
        }
        long l14 = l & 33L;
        if (l14 == l10 || obj.X == null) {
            int i4 = 0;
        } else {
            if (obj.d0 == null) {
                obj.d0 = new zm.a();
            }
            aVar = aVar2.a(obj.X);
        }
        long l16 = l & 38L;
        cmp4 = 0;
        if (l16 != l10) {
            z = ViewDataBinding.K(obj.Z);
        } else {
        }
        long l17 = l & 46L;
        long l18 = 36L;
        cmp4 = 8;
        if (l17 != l10) {
            l3 = l & 36L;
            if (l3 != l10) {
                String priceDescriptionV2 = DogoSkuDetails.getPriceDescriptionV2(obj.W, w().getContext());
                int r20 = obj.W == null ? 1 : cmp4;
                if (l3 != l10) {
                    int r22 = cmp4 != 0 ? 512 : 256;
                    l = l | (cmp4 != 0 ? 512 : 256);
                }
                int r12 = cmp4;
            } else {
                int i10 = 0;
            }
        }
        long l19 = 48L;
        l4 = l & 48L;
        if (l4 != l10) {
            boolean z2 = ViewDataBinding.K(obj.Y);
            if (l4 != l10) {
                if (z2) {
                    l2 = (l | 128L) | 2048L | 8192L;
                    i3 = 32768;
                } else {
                    l2 = (l | 64L) | 1024L | 4096L;
                    i3 = 16384;
                }
                l = l2 | i3;
            }
            r20 = cmp4;
            int r11 = z2 ? R.color.backgroundGreen : R.color.white;
            if (!(z2)) {
            }
            if (z2) {
                int i13 = 0;
            } else {
                i = 2131231308;
            }
        } else {
            int i6 = 0;
        }
        long l15 = l & 48L;
        if (l15 != l10) {
            obj.O.setVisibility(cmp4);
            obj.Q.setVisibility(cmp4);
            h.a(obj.c0, drawable);
            obj.U.setCardBackgroundColor(cmp4);
        }
        long l11 = 38L & l;
        if (obj.c0 != l10) {
            SubscriptionBindingAdapters.subscriptionPerPeriod(obj.P, obj.W, z);
        }
        long l12 = l & 36L;
        if (obj.c0 != l10) {
            SubscriptionBindingAdapters.setOldStrikedPrice(obj.R, obj.W);
            obj.T.setVisibility(cmp4);
            g.c(obj.V, obj2);
        }
        long l13 = 44L & l;
        if (obj.c0 != l10) {
            SubscriptionBindingAdapters.setPerPeriod(obj.S, obj.W, obj.a0);
        }
        l &= 33;
        if (obj.e0 != l10) {
            obj.U.setOnClickListener(aVar);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ym
    public boolean y() {
        synchronized (this) {
            try {
                if (this.e0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private zm(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 0, (ImageView)objectArr[3], (Guideline)objectArr[11], (TextView)objectArr[5], (FrameLayout)objectArr[10], (ImageView)objectArr[4], (TextView)objectArr[6], (TextView)objectArr[8], (ProgressBar)objectArr[9], (CardView)objectArr[1], (TextView)objectArr[7]);
        eVar3.e0 = -1L;
        Object obj13 = null;
        eVar3.O.setTag(obj13);
        eVar3.P.setTag(obj13);
        eVar3.Q.setTag(obj13);
        Object obj11 = objectArr[0];
        eVar3.b0 = obj11;
        obj11.setTag(obj13);
        Object obj12 = objectArr[2];
        eVar3.c0 = obj12;
        obj12.setTag(obj13);
        eVar3.R.setTag(obj13);
        eVar3.S.setTag(obj13);
        eVar3.T.setTag(obj13);
        eVar3.U.setTag(obj13);
        eVar3.V.setTag(obj13);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ym
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
