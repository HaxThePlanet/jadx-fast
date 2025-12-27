package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.p.v;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;

/* compiled from: LayoutDogProfileDetailsBindingImpl.java */
/* loaded from: classes.dex */
public class rk extends qk implements b.a {

    private static final ViewDataBinding.g b0 = new ViewDataBinding$g(8);
    private static final SparseIntArray c0 = null;
    private final ConstraintLayout X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private long a0;
    static {
        String str = "layout_profile_data_row";
        obj.a(1, new String[] { str, str, str, str }, new int[] { 4, 5, 6, 7 }, new int[] { R.layout.layout_profile_data_row, R.layout.layout_profile_data_row, R.layout.layout_profile_data_row, R.layout.layout_profile_data_row });
    }

    public rk(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, rk.b0, rk.c0));
    }

    private boolean X(yl ylVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(yl ylVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(yl ylVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(yl ylVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public void A() {
        synchronized (this) {
            try {
                this.a0 = 64L;
            } catch (Throwable th) {
            }
        }
        this.U.A();
        this.P.A();
        this.O.A();
        this.S.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qk
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return X(object, i2);
        }
        return Z(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public void M(q qVar) {
        super.M(qVar);
        this.U.M(qVar);
        this.P.M(qVar);
        this.O.M(qVar);
        this.S.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 127;
            if (127 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public void V(v vVar) {
        this.V = vVar;
        synchronized (this) {
            try {
                this.a0 |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public void W(ProfilePreview profilePreview) {
        this.W = profilePreview;
        synchronized (this) {
            try {
                this.a0 |= 32;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(127);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.V != null) {
            }
            if (i2 != 0) {
                this.V.n(this.W);
            }
        } else {
            if (this.V == 2) {
                if (this.V != null) {
                }
                if (i2 != 0) {
                    this.V.a1(this.W);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.qk
    protected void m() {
        long l;
        int cmp3;
        int cmp = 0;
        int i;
        synchronized (this) {
            try {
                final long l7 = 0L;
                this.a0 = l7;
            } catch (Throwable th) {
            }
        }
        long l2 = 112L;
        long l8 = l & l2;
        long l9 = 96L;
        cmp = 0;
        if (l8 != l7) {
            l4 = l & 96L;
            if (l4 != l7 && this.W != null) {
                boolean userDogsCreator = this.W.isUserDogsCreator();
                if (l4 != l7) {
                    int r13 = cmp != 0 ? 256 : 128;
                    l = l | (cmp != 0 ? 256 : 128);
                }
                if (cmp == 0) {
                    cmp = 8;
                }
            }
        }
        l5 = 64L & l;
        if (l5 != l7) {
            this.O.U(w().getResources().getString(2131886463));
            this.O.V(w().getResources().getString(2131886457));
            this.P.U(w().getResources().getString(2131886481));
            this.P.V(w().getResources().getString(2131886461));
            this.Q.setOnClickListener(this.Y);
            this.R.setOnClickListener(this.Z);
            this.S.U(w().getResources().getString(2131886482));
            this.S.V(w().getResources().getString(2131886465));
            this.U.U(w().getResources().getString(2131886464));
            i = 2131886462;
            this.U.V(w().getResources().getString(i));
        }
        l3 = 96L & l;
        if (l3 != l7) {
            this.R.setVisibility(cmp);
        }
        l &= l2;
        if (this.a0 != l7) {
            DogProfileBindingAdapters.S(this.T, this.W, this.U, this.P, this.O, this.S, this.V);
        }
        ViewDataBinding.o(this.U);
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.O);
        ViewDataBinding.o(this.S);
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z5 = true;
                if (this.a0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.U.y()) {
            return true;
        }
        if (this.P.y()) {
            return true;
        }
        if (this.O.y()) {
            return true;
        }
        if (this.S.y()) {
            return true;
        }
        return false;
    }

    private rk(e eVar, View view, Object[] objectArr) {
        final b.a eVar3 = this;
        final int i9 = 2;
        final int i10 = 1;
        super(eVar, view, 4, (yl)objectArr[6], (yl)objectArr[5], (Button)objectArr[3], (Button)objectArr[i9], (yl)objectArr[7], (LinearLayout)objectArr[i10], (yl)objectArr[4]);
        eVar3.a0 = -1L;
        L(eVar3.O);
        L(eVar3.P);
        Object obj9 = null;
        eVar3.Q.setTag(obj9);
        eVar3.R.setTag(obj9);
        L(eVar3.S);
        eVar3.T.setTag(obj9);
        Object obj8 = objectArr[0];
        eVar3.X = obj8;
        obj8.setTag(obj9);
        L(eVar3.U);
        N(view);
        eVar3.Y = new b(this, i9);
        eVar3.Z = new b(this, i10);
        A();
    }
}
