package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
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
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengePagerCardItem;
import app.dogo.com.dogo_android.util.f0.m;

/* compiled from: PageEntryChallengeItemBindingImpl.java */
/* loaded from: classes.dex */
public class rn extends qn {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout U;
    private final TextView V;
    private long W;
    public rn(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, rn.X, rn.Y));
    }

    private boolean W(ChallengePagerCardItem challengePagerCardItem, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.W |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw challengePagerCardItem;
            }
        }
        if (i == 77) {
            synchronized (this) {
                try {
                    this.W |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw challengePagerCardItem;
            }
        }
        if (i == 157) {
            synchronized (this) {
                try {
                    this.W |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw challengePagerCardItem;
            }
        }
        if (i == 159) {
            synchronized (this) {
                try {
                    this.W |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 87) {
            synchronized (this) {
                try {
                    this.W |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 115) {
            synchronized (this) {
                try {
                    this.W |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 62) {
            synchronized (this) {
                try {
                    this.W |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.qn
    public void A() {
        synchronized (this) {
            try {
                this.W = 128L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qn
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.qn
    public boolean O(int i, Object object) {
        boolean z = true;
        if (110 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.qn
    public void V(ChallengePagerCardItem challengePagerCardItem) {
        R(0, challengePagerCardItem);
        this.T = challengePagerCardItem;
        synchronized (this) {
            try {
                this.W |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(110);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qn
    protected void m() {
        java.lang.CharSequence charSequence;
        long l;
        long l2;
        String str;
        int i;
        java.lang.CharSequence charSequence2;
        int i2;
        java.lang.CharSequence charSequence3;
        Object obj2;
        String description;
        int i4 = 2131886324;
        int i5;
        int i6 = 16384;
        long l6;
        final Object obj = this;
        synchronized (this) {
            try {
                long l3 = 0L;
                obj.W = l3;
            } catch (Throwable th) {
            }
        }
        long l16 = 255L & l;
        final long l18 = 193L;
        long l4 = 145L;
        final long l21 = 131L;
        i = 0;
        i2 = 0;
        if (l16 != l3) {
            long l22 = l & 145L;
            if (l22 == l3 || obj.T == null) {
            } else {
                String imageUrl = obj.T.getImageUrl();
            }
            long l23 = l & 131L;
            if (l23 != l3) {
                if (obj.T != null) {
                    boolean hasEnded = obj.T.getHasEnded();
                } else {
                }
                if (l23 != l3) {
                    if (i2 != 0) {
                        l2 = (l | 512L) | 2048L | 8192L;
                        i5 = 131072;
                    } else {
                        l2 = (l | 256L) | 1024L | 4096L;
                        i5 = 65536;
                    }
                    l = l2 | i5;
                }
                if (i2 != 0) {
                    i2 = ViewDataBinding.u(obj.O, 2131099853);
                } else {
                    int i3 = 2131100352;
                    i2 = ViewDataBinding.u(obj.O, i3);
                }
                int r15 = i2 != 0 ? R.string.challenge.previous.week : R.string.challenge.this.week;
                String string = obj.R.getResources().getString((i2 != 0 ? R.string.challenge.previous.week : R.string.challenge.this.week));
                int i15 = 2131099767;
                int i12 = 2131100379;
                if (i2 != 0) {
                    i2 = ViewDataBinding.u(obj.S, i15);
                } else {
                    i2 = ViewDataBinding.u(obj.S, i12);
                }
                if (i2 != 0) {
                    i2 = ViewDataBinding.u(obj.R, i15);
                } else {
                    i2 = ViewDataBinding.u(obj.R, i12);
                }
            } else {
            }
            long l19 = l & 193L;
            if (obj.O == l3 || obj.T == null) {
            } else {
                description = obj.T.getDescription();
            }
            long l24 = l & 161L;
            if (l24 == l3 || obj.T == null) {
            } else {
                String name = obj.T.getName();
            }
            l6 = l & 137L;
            if (l6 != l3 && obj.T != null) {
                boolean timeVisible = obj.T.isTimeVisible();
                if (l6 != l3) {
                    int r25 = i2 != 0 ? 32768 : 16384;
                    l = l | (i2 != 0 ? 32768 : 16384);
                }
                if (i2 == 0) {
                    i2 = 8;
                }
            }
            l5 = l & 133L;
            if (l5 != l3 && obj.T != null) {
                String timeLeft = obj.T.getTimeLeft();
            }
        } else {
        }
        long l20 = l & 131L;
        if (l20 != l3) {
            obj.O.setCardBackgroundColor(i2);
            g.c(obj.R, charSequence3);
            obj.R.setTextColor(i2);
            obj.S.setTextColor(i2);
        }
        long l12 = l & 193L;
        long l17 = 0L;
        if (obj.R != l17) {
            g.c(obj.P, obj2);
        }
        long l13 = 145L & l;
        if (obj.R != l17) {
            app.dogo.com.dogo_android.util.binding.m.o(obj.Q, str);
        }
        long l14 = 161L & l;
        if (obj.R != l17) {
            g.c(obj.S, charSequence);
        }
        long l15 = 133L & l;
        if (obj.R != l17) {
            g.c(obj.V, charSequence2);
        }
        l &= 137;
        if (obj.W != l17) {
            obj.V.setVisibility(i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qn
    public boolean y() {
        synchronized (this) {
            try {
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private rn(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (CardView)objectArr[1], (TextView)objectArr[6], (ImageView)objectArr[3], (TextView)objectArr[4], (TextView)objectArr[5]);
        this.W = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        this.R.setTag(obj6);
        this.S.setTag(obj6);
        Object obj7 = objectArr[0];
        this.U = obj7;
        obj7.setTag(obj6);
        Object obj8 = objectArr[2];
        this.V = obj8;
        obj8.setTag(obj6);
        N(view);
        A();
    }

}
