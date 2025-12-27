package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.b0.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: ActivityLoginBindingImpl.java */
/* loaded from: classes.dex */
public class j extends i {

    private static final ViewDataBinding.g V = new ViewDataBinding$g(6);
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout T;
    private long U;
    static {
        length.a(0, new String[] { "layout_top_bar_v2", "activity_login_state" }, new int[] { 3, 4 }, new int[] { R.layout.layout_top_bar_v2, R.layout.activity_login_state });
        length.put(2131362533, 5);
    }

    public j(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, j.V, j.W));
    }

    private boolean U(k kVar, int i) {
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

    private boolean V(en enVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(x<y<b0.a>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.i
    public void A() {
        synchronized (this) {
            try {
                this.U = 32L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        this.P.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.i
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return W(object, i2);
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.i
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
        this.P.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.i
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.i
    public void T(b0 b0Var) {
        this.S = b0Var;
        synchronized (this) {
            try {
                this.U |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i
    protected void m() {
        Object obj;
        int i;
        y yVar;
        long l = 2;
        Object obj2;
        String str;
        int i3 = 3;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.U = l4;
            } catch (Throwable th) {
            }
        }
        long l6 = 60L & l2;
        final long l7 = 56L;
        long l8 = 52L;
        final Boolean bool = null;
        if (l6 != l4) {
            l = l2 & 52L;
            if (l != l4) {
                if (this.S != null) {
                    x xVar = this.S.q();
                } else {
                    int i6 = bool;
                }
                Q(2, obj);
                Object value = obj != null ? (LoadResult)value : bool;
            }
            long l11 = l2 & 56L;
            if (l11 != l4) {
                if (this.S != null) {
                    x xVar2 = this.S.s();
                } else {
                    int i9 = bool;
                }
                i3 = 3;
                Q(i3, obj2);
                Object value2 = obj2 != null ? (String)value2 : bool;
            }
        } else {
        }
        long l9 = 52L & l2;
        if (l9 != l4) {
            BindingAdapters.setTrainerAvatar(this.O, yVar);
        }
        long l10 = 48L & l2;
        if (this.O != l4) {
            this.P.T(this.S);
        }
        long l5 = 32L & l2;
        if (this.S != l4) {
            BindingAdapters.k0(this.Q, bool);
        }
        long l3 = l2 & 56L;
        if (this.U != l4) {
            this.R.T(str);
        }
        ViewDataBinding.o(this.R);
        ViewDataBinding.o(this.P);
    }

    @Override // app.dogo.com.dogo_android.h.i
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z3 = true;
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.R.y()) {
            return true;
        }
        if (this.P.y()) {
            return true;
        }
        return false;
    }

    private j(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 4, (CoordinatorLayout)objectArr[2], (FrameLayout)objectArr[5], (k)objectArr[4], (FrameLayout)objectArr[1], (en)objectArr[3]);
        this.U = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        Object obj7 = objectArr[0];
        this.T = obj7;
        obj7.setTag(obj6);
        L(this.P);
        this.Q.setTag(obj6);
        L(this.R);
        N(view);
        A();
    }
}
