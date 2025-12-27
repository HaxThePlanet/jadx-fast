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

/* compiled from: CellChallengeBannerItemBindingImpl.java */
/* loaded from: classes.dex */
public class h0 extends g0 implements b.a {

    private static final ViewDataBinding.g X = new ViewDataBinding$g(4);
    private static final SparseIntArray Y = new SparseIntArray();
    private final View.OnClickListener V;
    private long W;
    static {
        int i4 = 1;
        final int[] iArr = new int[i4];
        final int i7 = 0;
        iArr[i7] = 3;
        int[] iArr2 = new int[i4];
        iArr2[i7] = R.layout.layout_sponsor_universal_feed_header;
        obj.a(i7, new String[] { "layout_sponsor_universal_feed_header" }, iArr, iArr2);
        obj.put(2131362543, i4);
        obj.put(2131362001, 2);
    }

    public h0(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, h0.X, h0.Y));
    }

    private boolean Y(g0 g0Var, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.W |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(wm wmVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.W |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(SponsorBannerViewModel sponsorBannerViewModel, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.W |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw sponsorBannerViewModel;
            }
        }
        if (i == 19) {
            synchronized (this) {
                try {
                    this.W |= 16;
                    return true;
                } catch (Throwable unused) {
                }
                throw sponsorBannerViewModel;
            }
        }
        if (i == 76) {
            synchronized (this) {
                try {
                    this.W |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 21) {
            synchronized (this) {
                try {
                    this.W |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 168) {
            synchronized (this) {
                try {
                    this.W |= 128;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public void A() {
        synchronized (this) {
            try {
                this.W = 256L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.g0
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return a0(object, i2);
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public boolean O(int i, Object object) {
        int i2 = 183;
        boolean z = true;
        i2 = 74;
        if (74 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 183;
            if (183 == i) {
                X(object);
            } else {
                i2 = 116;
                if (116 == i) {
                    W(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public void V(g0 g0Var) {
        R(0, g0Var);
        this.T = g0Var;
        synchronized (this) {
            try {
                this.W |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(74);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public void W(a0 a0Var) {
        this.U = a0Var;
        synchronized (this) {
            try {
                this.W |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(116);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public void X(SponsorBannerViewModel sponsorBannerViewModel) {
        R(2, sponsorBannerViewModel);
        this.S = sponsorBannerViewModel;
        synchronized (this) {
            try {
                this.W |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public final void b(int i, View view) {
        int i2 = 1;
        int r1 = this.S != null ? 1 : 0;
        if (i2 != 0) {
            this.S.onSponsorBannerClick(this.U, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.g0
    protected void m() {
        int i;
        boolean friendlyCollarVisible;
        long l;
        int i2;
        boolean barkboxVisible;
        int i3;
        boolean universalBannerVisible;
        int cmp6 = 32768;
        int i4 = 2048;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj.W = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 500L & l;
        final long l6 = 388L;
        long l7 = 292L;
        final long l10 = 276L;
        long l11 = 324L;
        i = 0;
        if (l5 != l4) {
            long l13 = l & 276L;
            i = 8;
            if (l13 != l4) {
                if (obj.S != null) {
                    boolean bannerVisible = obj.S.isBannerVisible();
                } else {
                }
                if (l13 != l4) {
                    int r18 = i != 0 ? 16384 : 8192;
                    l = l | (i != 0 ? 16384 : 8192);
                }
                if (i != 0) {
                } else {
                }
            }
            long l14 = l & 324L;
            if (l14 != l4) {
                if (obj.S != null) {
                    barkboxVisible = obj.S.isBarkboxVisible();
                } else {
                }
                if (l14 != l4) {
                    int r19 = barkboxVisible ? 1024 : 512;
                    l = l | (barkboxVisible ? 1024 : 512);
                }
                if (barkboxVisible) {
                } else {
                }
            }
            long l15 = l & 388L;
            if (l15 != l4) {
                if (obj.S != null) {
                    universalBannerVisible = obj.S.isUniversalBannerVisible();
                } else {
                }
                if (l15 != l4) {
                    int r20 = universalBannerVisible ? 4096 : 2048;
                    l = l | (universalBannerVisible ? 4096 : 2048);
                }
                if (universalBannerVisible) {
                } else {
                }
            }
            long l16 = l & 292L;
            if (l16 != l4) {
                if (obj.S != null) {
                    friendlyCollarVisible = obj.S.isFriendlyCollarVisible();
                } else {
                }
                if (l16 != l4) {
                    r19 = obj.S ? 65536 : 32768;
                    l = l | (obj.S ? 65536 : 32768);
                }
                if (!(obj.S)) {
                }
            }
        } else {
        }
        long l12 = 324L & l;
        if (l12 != l4) {
            obj.O.setVisibility(i);
        }
        long l8 = 292L & l;
        if (l8 != l4) {
            obj.P.setVisibility(i);
        }
        l2 = 256L & l;
        if (obj.P != l4) {
            obj.Q.setOnClickListener(obj.V);
        }
        long l9 = l & 276L;
        if (obj.P != l4) {
            obj.Q.setVisibility(i);
        }
        l &= l6;
        if (obj.W != l4) {
            obj.R.w().setVisibility(i);
        }
        ViewDataBinding.o(obj.R);
    }

    @Override // app.dogo.com.dogo_android.h.g0
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.R.y()) {
            return true;
        }
        return false;
    }

    private h0(e eVar, View view, Object[] objectArr) {
        int i2 = 1;
        super(eVar, view, 3, (View)objectArr[2], (View)objectArr[i2], (FrameLayout)objectArr[0], (wm)objectArr[3]);
        this.W = -1L;
        this.Q.setTag(null);
        L(this.R);
        N(view);
        this.V = new b(this, i2);
        A();
    }
}
