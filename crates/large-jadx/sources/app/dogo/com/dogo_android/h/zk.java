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
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;

/* compiled from: LayoutLibraryGameListBindingImpl.java */
/* loaded from: classes.dex */
public class zk extends yk implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout T;
    private final View.OnClickListener U;
    private long V;
    static {
        obj.put(2131362326, 3);
    }

    public zk(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, zk.W, zk.X));
    }

    @Override // app.dogo.com.dogo_android.h.yk
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.yk
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

    @Override // app.dogo.com.dogo_android.h.yk
    public void T(o.a aVar) {
        this.R = aVar;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.yk
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

    @Override // app.dogo.com.dogo_android.h.yk
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

    @Override // app.dogo.com.dogo_android.h.yk
    public final void b(int i, View view) {
        int i2 = 1;
        i2 = 1;
        i2 = 0;
        int r2 = this.S != null ? 1 : i2;
        if (i2 != 0 && this.Q != null) {
            if (i2 != 0) {
                this.S.X(this.Q.getId(), this.Q.getName());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.yk
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
            TrainingBindingAdapters.r(this.O, this.Q, this.R);
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

    @Override // app.dogo.com.dogo_android.h.yk
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

    private zk(e eVar, View view, Object[] objectArr) {
        int i3 = 1;
        super(eVar, view, 0, (ImageView)objectArr[3], (RecyclerView)objectArr[2], (Button)objectArr[i3]);
        this.V = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        Object obj5 = objectArr[0];
        this.T = obj5;
        obj5.setTag(obj4);
        this.P.setTag(obj4);
        N(view);
        this.U = new b(this, i3);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yk
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
