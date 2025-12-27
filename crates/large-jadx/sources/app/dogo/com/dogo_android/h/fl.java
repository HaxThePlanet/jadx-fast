package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.q;
import d.a.k.a.a;

/* compiled from: LayoutLibraryShortcutsBindingImpl.java */
/* loaded from: classes.dex */
public class fl extends el {

    private static final ViewDataBinding.g U = new ViewDataBinding$g(5);
    private static final SparseIntArray V = null;
    private final ConstraintLayout S;
    private long T;
    static {
        String str = "layout_library_shortcut";
        i.a(0, new String[] { str, str, str, str }, new int[] { 1, 2, 3, 4 }, new int[] { R.layout.layout_library_shortcut, R.layout.layout_library_shortcut, R.layout.layout_library_shortcut, R.layout.layout_library_shortcut });
    }

    public fl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, fl.U, fl.V));
    }

    private boolean T(cl clVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean U(cl clVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean V(cl clVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean W(cl clVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.el
    public void A() {
        synchronized (this) {
            try {
                this.T = 16L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        this.Q.A();
        this.P.A();
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.el
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return V(object, i2);
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.el
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
        this.Q.M(qVar);
        this.P.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.el
    protected void m() {
        synchronized (this) {
            try {
                long l = 0L;
                this.T = l;
            } catch (Throwable th) {
            }
        }
        long l3 = this.T & 16L;
        if (l3 != l) {
            this.O.T(a.d(w().getContext(), 2131230836));
            this.O.U(Boolean.FALSE);
            this.O.V(w().getResources().getString(2131886146));
            this.P.T(a.d(w().getContext(), 2131231059));
            Boolean tRUE2 = Boolean.TRUE;
            this.P.U(tRUE2);
            this.P.V(w().getResources().getString(2131886727));
            this.Q.T(a.d(w().getContext(), 2131231101));
            this.Q.U(tRUE2);
            this.Q.V(w().getResources().getString(2131886667));
            int i = 2131231172;
            this.R.T(a.d(w().getContext(), i));
            this.R.U(tRUE2);
            this.R.V(w().getResources().getString(2131887623));
        }
        ViewDataBinding.o(this.R);
        ViewDataBinding.o(this.Q);
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.el
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z5 = true;
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.R.y()) {
            return true;
        }
        if (this.Q.y()) {
            return true;
        }
        if (this.P.y()) {
            return true;
        }
        if (this.O.y()) {
            return true;
        }
        return false;
    }

    private fl(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 4, (cl)objectArr[4], (cl)objectArr[3], (cl)objectArr[2], (cl)objectArr[1]);
        this.T = -1L;
        L(this.O);
        L(this.P);
        L(this.Q);
        Object obj5 = objectArr[0];
        this.S = obj5;
        obj5.setTag(null);
        L(this.R);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.el
    public boolean O(int i, Object object) {
        return true;
    }
}
