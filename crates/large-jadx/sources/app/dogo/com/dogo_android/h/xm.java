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

/* loaded from: classes.dex */
public class xm extends app.dogo.com.dogo_android.h.wm {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout P;
    private final ImageView Q;
    private long R;
    static {
    }

    public xm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, xm.S, xm.T));
    }

    private xm(e e, View view2, Object[] object3Arr3) {
        final int i = 1;
        super(e, view2, i);
        this.R = -1;
        Object obj4 = object3Arr3[0];
        this.P = (ConstraintLayout)obj4;
        int i3 = 0;
        obj4.setTag(i3);
        obj4 = object3Arr3[i];
        this.Q = (ImageView)obj4;
        obj4.setTag(i3);
        N(view2);
        A();
    }

    private boolean U(SponsorBannerViewModel sponsorBannerViewModel, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.R = l2 |= i6;
            return obj5;
            synchronized (this) {
                this.R = l2 |= i6;
                return obj5;
            }
        }
        if (i2 == 149) {
            this.R = l |= i5;
            return obj5;
            synchronized (this) {
                this.R = l |= i5;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.wm
    public void A() {
        this.R = 4;
        I();
        return;
        synchronized (this) {
            this.R = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wm
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return U((SponsorBannerViewModel)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.wm
    public boolean O(int i, Object object2) {
        int obj2;
        if (183 == i) {
            T((SponsorBannerViewModel)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.wm
    public void T(SponsorBannerViewModel sponsorBannerViewModel) {
        R(0, sponsorBannerViewModel);
        this.O = sponsorBannerViewModel;
        this.R = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, sponsorBannerViewModel);
            this.O = sponsorBannerViewModel;
            this.R = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wm
    protected void m() {
        int cmp;
        int sponsorImageUrl;
        final int i2 = 0;
        this.R = i2;
        final SponsorBannerViewModel view = this.O;
        sponsorImageUrl = 0;
        cmp = Long.compare(i, i2);
        synchronized (this) {
            i2 = 0;
            this.R = i2;
            view = this.O;
            sponsorImageUrl = 0;
            cmp = Long.compare(i, i2);
        }
        try {
            if (view != null) {
            }
            sponsorImageUrl = view.getSponsorImageUrl();
            if (cmp != 0) {
            }
            n.w(this.Q, sponsorImageUrl);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.wm
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
