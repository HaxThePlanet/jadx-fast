package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.d.d.r.f;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.f0.m;

/* compiled from: CellEntryProfileItemBindingImpl.java */
/* loaded from: classes.dex */
public class f2 extends e2 {

    private static final ViewDataBinding.g W = new ViewDataBinding$g(6);
    private static final SparseIntArray X = null;
    private final LinearLayout T;
    private final ConstraintLayout U;
    private long V;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i6 = 0;
        iArr2[i6] = 5;
        int[] iArr = new int[i3];
        iArr[i6] = R.layout.layout_entry_base;
        obj.a(i6, new String[] { "layout_entry_base" }, iArr2, iArr);
    }

    public f2(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, f2.W, f2.X));
    }

    private boolean X(sk skVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(f fVar, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw fVar;
            }
        }
        if (i == 33) {
            synchronized (this) {
                try {
                    this.V |= 8;
                    return true;
                } catch (Throwable unused) {
                }
                throw fVar;
            }
        }
        if (i == 37) {
            synchronized (this) {
                try {
                    this.V |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 34) {
            synchronized (this) {
                try {
                    this.V |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 35) {
            synchronized (this) {
                try {
                    this.V |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.e2
    public void A() {
        synchronized (this) {
            try {
                this.V = 128L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.e2
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.e2
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.e2
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

    @Override // app.dogo.com.dogo_android.h.e2
    public void W(f fVar) {
        R(1, fVar);
        this.S = fVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.e2
    protected void m() {
        String str2 = null;
        long l;
        long l2;
        int i;
        int i3 = 0;
        int i2 = 2131100352;
        java.lang.CharSequence charSequence = null;
        Object obj2 = null;
        long l4;
        int i4 = 4096;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l8 = 0L;
                obj.V = l8;
            } catch (Throwable th) {
            }
        }
        long l9 = 250L & l;
        final long l11 = 194L;
        final long l12 = 146L;
        long l3 = 138L;
        long l13 = 162L;
        i = 0;
        if (l9 != l8) {
            l4 = l & 138L;
            if (l4 != l8) {
                if (obj.S != null) {
                    boolean z = obj.S.l();
                }
                if (l4 != l8 && i != 0) {
                    l2 = (l | 512L) | 2048L;
                    i4 = 8192;
                    l = l2 | i4;
                }
                int i7 = 2131100379;
                if (i != 0) {
                    i = ViewDataBinding.u(obj.R, i7);
                } else {
                    i = ViewDataBinding.u(obj.R, 2131099767);
                }
                if (i != 0) {
                    i = ViewDataBinding.u(obj.P, i7);
                } else {
                    i = ViewDataBinding.u(obj.P, 2131099840);
                }
                int r12 = i != 0 ? R.color.secondary : R.color.lightGray;
                i = ViewDataBinding.u(obj.U, (i != 0 ? R.color.secondary : R.color.lightGray));
            } else {
            }
            long l16 = l & 146L;
            if (l16 == l8 || obj.S == null) {
                i3 = 0;
            } else {
                String str3 = obj.S.j();
            }
            long l17 = l & 194L;
            if (l17 == l8 || obj.S == null) {
                int i13 = 0;
            } else {
                str2 = obj.S.h();
            }
            long l18 = l & 162L;
            if (l18 == l8 || obj.S == null) {
                int i12 = 0;
            } else {
            }
        } else {
            int i5 = 0;
            int i10 = 0;
            int i14 = 0;
        }
        long l14 = 162L & l;
        if (l14 != l8) {
            g.c(obj.P, obj2);
        }
        long l15 = 138L & l;
        if (obj.P != l8) {
            obj.P.setTextColor(i);
            obj.R.setTextColor(i);
            h.a(obj.U, b.b(i));
        }
        long l10 = l & 194L;
        if (obj.U != l8) {
            app.dogo.com.dogo_android.util.binding.m.o(obj.Q, str2);
        }
        l &= l12;
        if (obj.V != l8) {
            g.c(obj.R, charSequence);
        }
        ViewDataBinding.o(obj.O);
    }

    @Override // app.dogo.com.dogo_android.h.e2
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.V != 0) {
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

    private f2(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (sk)objectArr[5], (TextView)objectArr[3], (ImageView)objectArr[4], (TextView)objectArr[2]);
        this.V = -1L;
        L(this.O);
        Object obj5 = null;
        this.P.setTag(obj5);
        this.Q.setTag(obj5);
        this.R.setTag(obj5);
        Object obj6 = objectArr[0];
        this.T = obj6;
        obj6.setTag(obj5);
        Object obj7 = objectArr[1];
        this.U = obj7;
        obj7.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.e2
    public void V(a0 a0Var) {
    }
}
