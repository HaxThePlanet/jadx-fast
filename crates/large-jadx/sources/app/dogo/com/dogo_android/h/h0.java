package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.entry_list_item_models.SponsorBannerViewModel;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public class h0 extends app.dogo.com.dogo_android.h.g0 implements b.a {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final View.OnClickListener V;
    private long W;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(4);
        h0.X = gVar;
        int i4 = 1;
        final int[] iArr = new int[i4];
        final int i7 = 0;
        iArr[i7] = 3;
        int[] iArr2 = new int[i4];
        iArr2[i7] = 2131558810;
        gVar.a(i7, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        h0.Y = sparseIntArray;
        sparseIntArray.put(2131362543, i4);
        sparseIntArray.put(2131362001, 2);
    }

    public h0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, h0.X, h0.Y));
    }

    private h0(e e, View view2, Object[] object3Arr3) {
        int i2 = 1;
        super(e, view2, 3, (View)object3Arr3[2], (View)object3Arr3[i2], (FrameLayout)object3Arr3[0], (wm)object3Arr3[3]);
        this.W = -1;
        this.Q.setTag(0);
        L(this.R);
        N(view2);
        b obj10 = new b(this, i2);
        this.V = obj10;
        A();
    }

    private boolean Y(g0 g0, int i2) {
        if (i2 == 0) {
            this.W = obj3 |= i;
            return 1;
            synchronized (this) {
                this.W = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(app.dogo.com.dogo_android.h.wm wm, int i2) {
        if (i2 == 0) {
            this.W = obj3 |= i;
            return 1;
            synchronized (this) {
                this.W = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(SponsorBannerViewModel sponsorBannerViewModel, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.W = l5 |= i15;
            return obj5;
            synchronized (this) {
                this.W = l5 |= i15;
                return obj5;
            }
        }
        if (i2 == 19) {
            this.W = l4 |= i14;
            return obj5;
            synchronized (this) {
                this.W = l4 |= i14;
                return obj5;
            }
        }
        if (i2 == 76) {
            this.W = l |= i11;
            return obj5;
            synchronized (this) {
                this.W = l |= i11;
                return obj5;
            }
        }
        if (i2 == 21) {
            this.W = l2 |= i12;
            return obj5;
            synchronized (this) {
                this.W = l2 |= i12;
                return obj5;
            }
        }
        if (i2 == 168) {
            this.W = l3 |= i13;
            return obj5;
            synchronized (this) {
                this.W = l3 |= i13;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public void A() {
        this.W = 256;
        this.R.A();
        I();
        return;
        synchronized (this) {
            this.W = 256;
            this.R.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g0
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return a0((SponsorBannerViewModel)object2, i3);
            }
            return Z((wm)object2, i3);
        }
        return Y((g0)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public void M(q q) {
        super.M(q);
        this.R.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (74 == i) {
            V((g0)object2);
            obj2 = 1;
        } else {
            if (183 == i) {
                X((SponsorBannerViewModel)object2);
            } else {
                if (116 == i) {
                    W((a0)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public void V(g0 g0) {
        R(0, g0);
        this.T = g0;
        this.W = l |= i3;
        notifyPropertyChanged(74);
        super.I();
        return;
        synchronized (this) {
            R(0, g0);
            this.T = g0;
            this.W = l |= i3;
            notifyPropertyChanged(74);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public void W(a0 a0) {
        this.U = a0;
        this.W = l |= i2;
        notifyPropertyChanged(116);
        super.I();
        return;
        synchronized (this) {
            this.U = a0;
            this.W = l |= i2;
            notifyPropertyChanged(116);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public void X(SponsorBannerViewModel sponsorBannerViewModel) {
        R(2, sponsorBannerViewModel);
        this.S = sponsorBannerViewModel;
        this.W = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(2, sponsorBannerViewModel);
            this.S = sponsorBannerViewModel;
            this.W = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public final void b(int i, View view2) {
        int i2;
        final SponsorBannerViewModel obj3 = this.S;
        i2 = obj3 != null ? 1 : 0;
        if (i2 != 0) {
            obj3.onSponsorBannerClick(this.U, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.g0
    protected void m() {
        int i2;
        int cmp3;
        int cmp;
        int cmp4;
        int friendlyCollarVisible;
        long l;
        int i7;
        int cmp5;
        int i5;
        int cmp2;
        int i4;
        int i3;
        int bannerVisible;
        int barkboxVisible;
        int universalBannerVisible;
        int i6;
        int i;
        final Object obj = this;
        l = obj.W;
        final int i9 = 0;
        obj.W = i9;
        friendlyCollarVisible = obj.S;
        final int i12 = 388;
        int i13 = 292;
        final int i17 = 276;
        int i18 = 324;
        i4 = 0;
        synchronized (this) {
            obj = this;
            l = obj.W;
            i9 = 0;
            obj.W = i9;
            friendlyCollarVisible = obj.S;
            i12 = 388;
            i13 = 292;
            i17 = 276;
            i18 = 324;
            i4 = 0;
        }
        int cmp7 = Long.compare(i20, i9);
        i3 = 8;
        if (cmp7 != 0) {
            if (friendlyCollarVisible != null) {
                try {
                    bannerVisible = friendlyCollarVisible.isBannerVisible();
                    bannerVisible = i4;
                    if (cmp7 != 0) {
                    }
                    if (bannerVisible != 0) {
                    } else {
                    }
                    barkboxVisible = 16384;
                    barkboxVisible = 8192;
                    l |= barkboxVisible;
                }
                if (bannerVisible != 0) {
                    i7 = i4;
                } else {
                    i7 = i3;
                }
            } else {
            }
        } else {
        }
        int cmp8 = Long.compare(i21, i9);
        if (cmp8 != 0) {
            if (friendlyCollarVisible != null) {
                barkboxVisible = friendlyCollarVisible.isBarkboxVisible();
            } else {
                barkboxVisible = i4;
            }
            if (cmp8 != 0) {
                universalBannerVisible = barkboxVisible != 0 ? 1024 : 512;
                l |= universalBannerVisible;
            }
            if (barkboxVisible != 0) {
                bannerVisible = i4;
            } else {
                bannerVisible = i3;
            }
        } else {
        }
        int cmp9 = Long.compare(i22, i9);
        if (cmp9 != 0) {
            if (friendlyCollarVisible != null) {
                universalBannerVisible = friendlyCollarVisible.isUniversalBannerVisible();
            } else {
                universalBannerVisible = i4;
            }
            if (cmp9 != 0) {
                i6 = universalBannerVisible != 0 ? 4096 : 2048;
                l |= i6;
            }
            if (universalBannerVisible != 0) {
                barkboxVisible = i4;
            } else {
                barkboxVisible = i3;
            }
        } else {
        }
        universalBannerVisible = Long.compare(i23, i9);
        if (universalBannerVisible != 0) {
            if (friendlyCollarVisible != null) {
                friendlyCollarVisible = friendlyCollarVisible.isFriendlyCollarVisible();
            } else {
                friendlyCollarVisible = i4;
            }
            if (universalBannerVisible != 0) {
                universalBannerVisible = friendlyCollarVisible != 0 ? 65536 : 32768;
                l |= universalBannerVisible;
            }
            if (friendlyCollarVisible != 0) {
            } else {
                i4 = i3;
            }
        }
        i2 = i4;
        i4 = bannerVisible;
        i = barkboxVisible;
        if (Long.compare(i19, i9) != 0) {
            obj.O.setVisibility(i4);
        }
        if (Long.compare(i14, i9) != 0) {
            obj.P.setVisibility(i2);
        }
        if (Long.compare(i5, i9) != 0) {
            obj.Q.setOnClickListener(obj.V);
        }
        if (Long.compare(i16, i9) != 0) {
            obj.Q.setVisibility(i7);
        }
        if (Long.compare(i8, i9) != 0) {
            obj.R.w().setVisibility(i);
        }
        ViewDataBinding.o(obj.R);
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.R.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
