package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.n.k.n.b;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;

/* compiled from: LayoutLibraryArticleListBindingImpl.java */
/* loaded from: classes.dex */
public class xk extends wk implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final View.OnClickListener U;
    private long V;
    public xk(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, xk.W, xk.X));
    }

    @Override // app.dogo.com.dogo_android.h.wk
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.wk
    public boolean O(int i, Object object) {
        int i2 = 100;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 100;
            if (100 == i) {
                V(object);
            } else {
                i2 = 29;
                if (29 == i) {
                    T(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.wk
    public void T(n.b bVar) {
        this.R = bVar;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wk
    public void U(LibrarySection librarySection) {
        this.Q = librarySection;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wk
    public void V(g gVar) {
        this.S = gVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(100);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wk
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.S != null ? 1 : 0;
        if (i2 != 0) {
            this.S.E0();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wk
    protected void m() {
        long l;
        int cmp4 = 0;
        int i;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.V = l4;
            } catch (Throwable th) {
            }
        }
        long l6 = 13L;
        long l8 = l & l6;
        final long l9 = 9L;
        cmp4 = 0;
        if (l8 != l4 && l2 != l4) {
            int r12 = this.Q != null ? 1 : 0;
            if (l2 != l4) {
                int r13 = cmp4 != 0 ? 32 : 16;
                l = l | (cmp4 != 0 ? 32 : 16);
            }
            if (cmp4 == 0) {
                cmp4 = 8;
            }
        }
        long l7 = 13L & l;
        if (l7 != l4) {
            LibraryBindingAdapters.g(this.O, this.Q, this.R);
        }
        long l5 = l & 9L;
        if (this.Q != l4) {
            this.T.setVisibility(cmp4);
        }
        l &= 8;
        if (this.V != l4) {
            this.P.setOnClickListener(this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wk
    public boolean y() {
        synchronized (this) {
            try {
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private xk(e eVar, View view, Object[] objectArr) {
        int i2 = 1;
        super(eVar, view, 0, (RecyclerView)objectArr[2], (Button)objectArr[i2]);
        this.V = -1L;
        Object obj3 = null;
        this.O.setTag(obj3);
        Object obj4 = objectArr[0];
        this.T = obj4;
        obj4.setTag(obj3);
        this.P.setTag(obj3);
        N(view);
        this.U = new b(this, i2);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.wk
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
