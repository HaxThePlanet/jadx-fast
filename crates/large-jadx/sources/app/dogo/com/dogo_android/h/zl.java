package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* compiled from: LayoutProfileDataRowBindingImpl.java */
/* loaded from: classes.dex */
public class zl extends yl {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    public zl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, zl.V, zl.W));
    }

    @Override // app.dogo.com.dogo_android.h.yl
    public void A() {
        synchronized (this) {
            try {
                this.U = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.yl
    public boolean O(int i, Object object) {
        int i2 = 96;
        boolean z = true;
        i2 = 70;
        if (70 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 96;
            if (96 == i) {
                V(object);
            } else {
                i2 = 60;
                if (60 == i) {
                    T(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.yl
    public void T(String str) {
        this.Q = str;
        synchronized (this) {
            try {
                this.U |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(60);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yl
    public void U(String str) {
        this.S = str;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(70);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yl
    public void V(String str) {
        this.R = str;
        synchronized (this) {
            try {
                this.U |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(96);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yl
    protected void m() {
        int cmp;
        String str;
        long l;
        int i = 0;
        Object obj2 = null;
        boolean empty;
        int i3 = 256;
        int i4 = 64;
        int i2 = 0;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l6 = 0L;
                obj.U = l6;
            } catch (Throwable th) {
            }
        }
        i = 0;
        int i6 = 0;
        long l7 = 13L;
        long l10 = l & l7;
        i2 = 1;
        long l11 = 16L;
        i2 = 0;
        if (l10 != l6) {
            int r17 = obj.Q == null ? 1 : i2;
            if (l10 != l6) {
                l = i2 != 0 ? l | l4 : l | l11;
            }
        } else {
        }
        long l12 = 16L & l;
        if (l12 == l6 || obj.Q == null) {
        } else {
            empty = obj.Q.isEmpty();
        }
        long l13 = l & 13L;
        long l15 = 12L;
        if (l13 != l6) {
            if (i2 == 0) {
            }
            l2 = l & 12L;
            if (l2 != l6) {
                int r14 = empty ? 128 : 64;
                l = l | (empty ? 128 : 64);
            }
            l3 = l & 13L;
            if (l3 != l6) {
                r14 = empty ? 512 : 256;
                l = l | (empty ? 512 : 256);
            }
            long l14 = l & 12L;
            if (l14 != l6) {
                int r7 = empty ? 1050253722 : 1065353216;
            }
        }
        long l8 = 13L & l;
        if (l8 != l6) {
            if (i2 == 0) {
            }
        }
        final long l9 = l & 12L;
        if (l9 != l6 && ViewDataBinding.t() >= 11) {
            obj.O.setAlpha(i);
        }
        if (l8 != l6) {
            g.c(obj.O, obj2);
        }
        l &= 10;
        if (obj.U != l6) {
            g.c(obj.P, obj.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yl
    public boolean y() {
        synchronized (this) {
            try {
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private zl(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[2], (TextView)objectArr[1]);
        this.U = -1L;
        Object obj3 = null;
        this.O.setTag(obj3);
        this.P.setTag(obj3);
        Object obj4 = objectArr[0];
        this.T = obj4;
        obj4.setTag(obj3);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.yl
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
