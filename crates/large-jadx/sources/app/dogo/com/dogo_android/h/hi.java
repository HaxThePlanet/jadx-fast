package app.dogo.com.dogo_android.h;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.util.f0.m;

/* compiled from: LayoutCustomFabBindingImpl.java */
/* loaded from: classes.dex */
public class hi extends gi {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    public hi(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, hi.S, hi.T));
    }

    private boolean U(app.dogo.com.dogo_android.util.g0.a aVar, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.R |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw aVar;
            }
        }
        if (i == 25) {
            synchronized (this) {
                try {
                    this.R |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw aVar;
            }
        }
        if (i == 17) {
            synchronized (this) {
                try {
                    this.R |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw aVar;
            }
        }
        if (i == 152) {
            synchronized (this) {
                try {
                    this.R |= 8;
                    return true;
                } catch (Throwable unused) {
                }
                throw aVar;
            }
        }
        if (i == 6) {
            synchronized (this) {
                try {
                    this.R |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 153) {
            synchronized (this) {
                try {
                    this.R |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 84) {
            synchronized (this) {
                try {
                    this.R |= 64;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 82) {
            synchronized (this) {
                try {
                    this.R |= 128;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.gi
    public void A() {
        synchronized (this) {
            try {
                this.R = 256L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gi
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return U(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.gi
    public boolean O(int i, Object object) {
        boolean z = true;
        if (178 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.gi
    public void T(app.dogo.com.dogo_android.util.g0.a aVar) {
        R(0, aVar);
        this.P = aVar;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(178);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gi
    protected void m() {
        int i = 0;
        int cmp5;
        long l;
        int color;
        boolean z2;
        String str = null;
        Object obj2 = null;
        View view;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l7 = 0L;
                obj.R = l7;
            } catch (Throwable th) {
            }
        }
        i = 0;
        long l9 = 511L & l;
        long l4 = 273L;
        final long l11 = 265L;
        final long l14 = 257L;
        long l15 = 449L;
        final long l18 = 259L;
        long l19 = 1024L;
        color = 0;
        if (l9 != l7) {
            long l21 = l & 259L;
            if (l21 != l7 && obj.P != null) {
                float f = obj.P.e();
            }
            long l22 = l & 257L;
            if (l22 == l7 || obj.P == null) {
            } else {
                color = obj.P.g();
            }
            long l23 = l & 261L;
            if (l23 != l7) {
                color = obj.P != null ? color : color;
                color = w().getContext().getColor(color);
            } else {
            }
            long l13 = l & 265L;
            if (l13 == l7 || obj.P == null) {
                int i11 = 0;
            } else {
                str = obj.P.h();
            }
            long l24 = l & 289L;
            if (l24 != l7) {
                color = obj.P != null ? color : color;
                color = w().getContext().getColor(color);
            } else {
            }
            long l25 = l & 273L;
            if (l25 == l7 || obj.P == null) {
            } else {
                boolean z = obj.P.j();
            }
            long l26 = l & 449L;
            if (l26 != l7) {
                if (obj.P != null) {
                    boolean z3 = obj.P.k();
                } else {
                }
                if (l26 != l7) {
                    l = color != 0 ? l | l19 : l | l5;
                }
            } else {
            }
        } else {
            int i12 = 0;
        }
        long l20 = l & 1024L;
        if (l20 == l7 || obj.P == null) {
        } else {
            color = obj.P.f();
        }
        long l16 = l & 449L;
        if (l16 != l7 && color != 0) {
        }
        long l17 = l & 259L;
        if (l17 != l7 && ViewDataBinding.t() >= 11) {
            obj.O.setAlpha(i);
        }
        long l10 = l & 257L;
        if (obj.O != l7) {
            obj.O.setMaxLines(color);
        }
        l3 = 261L & l;
        if (l3 != l7 && ViewDataBinding.t() >= 21) {
            obj.O.setBackgroundTintList(b.a(color));
        }
        long l8 = l & 265L;
        if (l8 != l7) {
            g.c(obj.O, obj2);
        }
        l2 = 273L & l;
        if (l2 != l7) {
            if (ViewDataBinding.t() >= 14) {
                obj.O.setAllCaps(z2);
            }
        }
        l &= 289;
        if (obj.R != l7) {
            obj.O.setTextColor(color);
        }
        if (l16 != l7) {
            app.dogo.com.dogo_android.util.binding.m.k(obj.O, color);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gi
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

    private hi(e eVar, View view, Object[] objectArr) {
        int i = 1;
        super(eVar, view, i, (Button)objectArr[i]);
        this.R = -1L;
        Object obj2 = objectArr[0];
        this.Q = obj2;
        final Object obj3 = null;
        obj2.setTag(obj3);
        this.O.setTag(obj3);
        N(view);
        A();
    }

}
