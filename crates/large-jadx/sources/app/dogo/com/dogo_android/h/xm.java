package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: LayoutSponsorUniversalFeedHeaderBindingImpl.java */
/* loaded from: classes.dex */
public class xm extends wm {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout P;
    private final ImageView Q;
    private long R;
    public xm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, xm.S, xm.T));
    }

    private boolean U(SponsorBannerViewModel sponsorBannerViewModel, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.R |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw sponsorBannerViewModel;
            }
        }
        if (i == 149) {
            synchronized (this) {
                try {
                    this.R |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.wm
    public void A() {
        synchronized (this) {
            try {
                this.R = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.wm
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return U(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.wm
    public boolean O(int i, Object object) {
        boolean z = true;
        if (183 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.wm
    public void T(SponsorBannerViewModel sponsorBannerViewModel) {
        R(0, sponsorBannerViewModel);
        this.O = sponsorBannerViewModel;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wm
    protected void m() {
        String sponsorImageUrl = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        int i = 0;
        long l2 = this.R & 7L;
        if (l2 != l3 && this.O != null) {
            sponsorImageUrl = this.O.getSponsorImageUrl();
        }
        if (l2 != l3) {
            BindingAdapters.w(this.Q, sponsorImageUrl);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wm
    public boolean y() {
        synchronized (this) {
            try {
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private xm(e eVar, View view, Object[] objectArr) {
        final int i = 1;
        super(eVar, view, i);
        this.R = -1L;
        Object obj2 = objectArr[0];
        this.P = obj2;
        Object obj = null;
        obj2.setTag(obj);
        Object obj3 = objectArr[i];
        this.Q = obj3;
        obj3.setTag(obj);
        N(view);
        A();
    }

}
