package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellChallengeFanItemBindingImpl.java */
/* loaded from: classes.dex */
public class v0 extends u0 {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout V;
    private long W;
    static {
        obj.put(2131361915, 7);
    }

    public v0(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, v0.X, v0.Y));
    }

    private boolean W(app.dogo.com.dogo_android.d.a.n.e eVar, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.W |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw eVar;
            }
        }
        if (i == 174) {
            synchronized (this) {
                try {
                    this.W |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw eVar;
            }
        }
        if (i == 11) {
            synchronized (this) {
                try {
                    this.W |= 4;
                    return true;
                } catch (Throwable unused) {
                }
                throw eVar;
            }
        }
        if (i == 12) {
            synchronized (this) {
                try {
                    this.W |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 10) {
            synchronized (this) {
                try {
                    this.W |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 65) {
            synchronized (this) {
                try {
                    this.W |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.u0
    public void A() {
        synchronized (this) {
            try {
                this.W = 64L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.u0
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.u0
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

    @Override // app.dogo.com.dogo_android.h.u0
    public void V(app.dogo.com.dogo_android.d.a.n.e eVar) {
        R(0, eVar);
        this.U = eVar;
        synchronized (this) {
            try {
                this.W |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.u0
    protected void m() {
        int i;
        long l;
        int i3;
        java.lang.CharSequence charSequence;
        String str2;
        int i4;
        int i5 = 2048;
        int cmp7;
        int i6 = 512;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj.W = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 127L & l;
        long l6 = 67L;
        long l8 = 73L;
        long l10 = 81L;
        final String str = null;
        i = 0;
        if (l5 != l4) {
            long l14 = l & 97L;
            if (l14 == l4 || obj.U == null) {
                i3 = str;
            } else {
                android.text.SpannableStringBuilder spannableStringBuilder = obj.U.b();
            }
            long l15 = l & 73L;
            i = 8;
            if (l15 != l4) {
                if (obj.U != null) {
                    boolean z2 = obj.U.g();
                } else {
                }
                if (l15 != l4) {
                    int r22 = i != 0 ? 4096 : 2048;
                    l = l | (i != 0 ? 4096 : 2048);
                }
                if (i != 0) {
                } else {
                }
            }
            long l16 = l & 67L;
            if (l16 == l4 || obj.U == null) {
                i4 = str;
            } else {
                String str3 = obj.U.d();
            }
            long l17 = l & 81L;
            if (l17 != l4) {
                if (obj.U != null) {
                    boolean z3 = obj.U.e();
                } else {
                }
                if (l17 != l4) {
                    int r24 = i != 0 ? 1024 : 512;
                    l = l | (i != 0 ? 1024 : 512);
                }
                if (i != 0) {
                } else {
                }
            }
            long l2 = 69L;
            long l18 = l & l2;
            if (l18 != l4) {
                if (obj.U != null) {
                    boolean z = obj.U.f();
                } else {
                }
                if (l18 != l4) {
                    int r23 = obj.U != 0 ? 256 : 128;
                    l = l | (obj.U != 0 ? 256 : 128);
                }
                if (obj.U == 0) {
                }
            }
        } else {
        }
        long l11 = 81L & l;
        if (l11 != l4) {
            obj.O.setVisibility(i);
        }
        long l12 = 69L & l;
        if (obj.O != l4) {
            obj.P.setVisibility(i);
        }
        long l13 = 64L & l;
        if (obj.O != l4) {
            BindingAdapters.g0(obj.Q, str);
        }
        long l9 = 73L & l;
        if (l9 != l4) {
            obj.R.setVisibility(i);
        }
        long l7 = 67L & l;
        if (l7 != l4) {
            app.dogo.com.dogo_android.util.binding.m.o(obj.S, str2);
        }
        l &= 97;
        if (obj.W != l4) {
            g.c(obj.T, charSequence);
        }
    }

    @Override // app.dogo.com.dogo_android.h.u0
    public boolean y() {
        synchronized (this) {
            try {
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private v0(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (ImageView)objectArr[4], (ImageView)objectArr[2], (View)objectArr[7], (ImageView)objectArr[6], (ImageView)objectArr[3], (ImageView)objectArr[1], (TextView)objectArr[5]);
        this.W = -1L;
        Object obj8 = null;
        this.O.setTag(obj8);
        this.P.setTag(obj8);
        this.Q.setTag(obj8);
        Object obj9 = objectArr[0];
        this.V = obj9;
        obj9.setTag(obj8);
        this.R.setTag(obj8);
        this.S.setTag(obj8);
        this.T.setTag(obj8);
        N(view);
        A();
    }
}
