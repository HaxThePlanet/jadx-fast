package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoObservable;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellEntryPhotoItemBindingImpl.java */
/* loaded from: classes.dex */
public class d2 extends c2 implements b.a {

    private static final ViewDataBinding.g V = new ViewDataBinding$g(3);
    private static final SparseIntArray W = null;
    private final LinearLayout R;
    private final ImageView S;
    private final View.OnClickListener T;
    private long U;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i6 = 0;
        iArr2[i6] = 2;
        int[] iArr = new int[i3];
        iArr[i6] = R.layout.layout_entry_base;
        obj.a(i6, new String[] { "layout_entry_base" }, iArr2, iArr);
    }

    public d2(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, d2.V, d2.W));
    }

    private boolean X(sk skVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(EntryPhotoObservable entryPhotoObservable, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw entryPhotoObservable;
            }
        }
        if (i == 3) {
            synchronized (this) {
                try {
                    this.U |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 2) {
            synchronized (this) {
                try {
                    this.U |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public void A() {
        synchronized (this) {
            try {
                this.U = 32L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.c2
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public boolean O(int i, Object object) {
        int i2 = 183;
        boolean z = true;
        i2 = 183;
        if (183 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 116;
            if (116 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public void V(a0 a0Var) {
        this.Q = a0Var;
        synchronized (this) {
            try {
                this.U |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(116);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public void W(EntryPhotoObservable entryPhotoObservable) {
        R(0, entryPhotoObservable);
        this.P = entryPhotoObservable;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public final void b(int i, View view) {
        int i2 = 1;
        int r0 = this.P != null ? 1 : 0;
        if (i2 != 0) {
            this.P.onSponsorBannerClick(this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.c2
    protected void m() {
        int adVisible = 0;
        String adImageUrl = null;
        int cmp4;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.U = l4;
            } catch (Throwable th) {
            }
        }
        adVisible = 0;
        int i = 0;
        long l5 = 57L & l2;
        final long l6 = 49L;
        long l7 = 41L;
        if (l5 != l4) {
            long l9 = l2 & 41L;
            if (l9 != l4 && this.P != null) {
                adVisible = this.P.getAdVisible();
            }
            l = l2 & 49L;
            if (l != l4 && this.P != null) {
                adImageUrl = this.P.getAdImageUrl();
            }
        }
        long l10 = 32L & l2;
        if (l10 != l4) {
            this.S.setOnClickListener(this.T);
        }
        long l8 = 41L & l2;
        if (l8 != l4) {
            this.S.setVisibility(adVisible);
        }
        long l3 = l2 & 49L;
        if (this.U != l4) {
            BindingAdapters.w(this.S, adImageUrl);
        }
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.O.y()) {
            return true;
        }
        return false;
    }

    private d2(e eVar, View view, Object[] objectArr) {
        int i = 2;
        super(eVar, view, i, (sk)objectArr[i]);
        this.U = -1L;
        L(this.O);
        Object obj3 = objectArr[0];
        this.R = obj3;
        Object obj = null;
        obj3.setTag(obj);
        int i4 = 1;
        final Object obj4 = objectArr[i4];
        this.S = obj4;
        obj4.setTag(obj);
        N(view);
        this.T = new b(this, i4);
        A();
    }
}
