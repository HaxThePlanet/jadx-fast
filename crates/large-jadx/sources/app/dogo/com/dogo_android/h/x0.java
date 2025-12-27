package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndObservable;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellChallengeFeedEndCardBindingImpl.java */
/* loaded from: classes.dex */
public class x0 extends w0 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    public x0(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, x0.T, x0.U));
    }

    private boolean W(ChallengeFeedEndObservable challengeFeedEndObservable, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.S |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw challengeFeedEndObservable;
            }
        }
        if (i == 18) {
            synchronized (this) {
                try {
                    this.S |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw challengeFeedEndObservable;
            }
        }
        if (i == 16) {
            synchronized (this) {
                try {
                    this.S |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 108) {
            synchronized (this) {
                try {
                    this.S |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 26) {
            synchronized (this) {
                try {
                    this.S |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.w0
    public void A() {
        synchronized (this) {
            try {
                this.S = 32L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.w0
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.w0
    public boolean O(int i, Object object) {
        boolean z = true;
        if (183 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.w0
    public void V(ChallengeFeedEndObservable challengeFeedEndObservable) {
        R(0, challengeFeedEndObservable);
        this.Q = challengeFeedEndObservable;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.w0
    protected void m() {
        int backgroundDrawable;
        long l;
        long l2;
        int i;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj.S = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 63L & l;
        long l6 = 37L;
        final long l8 = 41L;
        long l9 = 35L;
        long l11 = 49L;
        backgroundDrawable = 0;
        if (l5 != l4) {
            l2 = l & 49L;
            if (l2 != l4) {
                if (obj.Q != null) {
                    boolean buttonVisible = obj.Q.isButtonVisible();
                } else {
                }
                if (l2 != l4) {
                    int r17 = backgroundDrawable != 0 ? 128 : 64;
                    l = l | (backgroundDrawable != 0 ? 128 : 64);
                }
                if (backgroundDrawable != 0) {
                } else {
                    backgroundDrawable = 8;
                }
            }
            long l13 = l & 41L;
            if (l13 == l4 || obj.Q == null) {
            } else {
                backgroundDrawable = obj.Q.getMessageText();
            }
            long l14 = l & 37L;
            if (l14 == l4 || obj.Q == null) {
            } else {
                backgroundDrawable = obj.Q.getBackgroundColor();
            }
            long l15 = l & 35L;
            if (l15 != l4 && obj.Q != null) {
                backgroundDrawable = obj.Q.getBackgroundDrawable();
            }
        } else {
        }
        long l12 = 49L & l;
        if (l12 != l4) {
            obj.O.setVisibility(backgroundDrawable);
        }
        long l10 = 35L & l;
        if (l10 != l4) {
            app.dogo.com.dogo_android.util.binding.m.r(obj.R, backgroundDrawable);
        }
        long l7 = 37L & l;
        if (l7 != l4) {
            BindingAdapters.loadNonCchedImage(obj.R, backgroundDrawable);
        }
        l &= l8;
        if (obj.S != l4) {
            obj.P.setText(backgroundDrawable);
        }
    }

    @Override // app.dogo.com.dogo_android.h.w0
    public boolean y() {
        synchronized (this) {
            try {
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private x0(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (Button)objectArr[2], (TextView)objectArr[1]);
        this.S = -1L;
        Object obj3 = null;
        this.O.setTag(obj3);
        Object obj4 = objectArr[0];
        this.R = obj4;
        obj4.setTag(obj3);
        this.P.setTag(obj3);
        N(view);
        A();
    }

}
