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

/* compiled from: LayoutLibrarySkillListBindingImpl.java */
/* loaded from: classes.dex */
public class hl extends gl implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout T;
    private final View.OnClickListener U;
    private long V;
    static {
        obj.put(2131362326, 3);
    }

    public hl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, hl.W, hl.X));
    }

    @Override // app.dogo.com.dogo_android.h.gl
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gl
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

    @Override // app.dogo.com.dogo_android.h.gl
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

    @Override // app.dogo.com.dogo_android.h.gl
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

    @Override // app.dogo.com.dogo_android.h.gl
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

    @Override // app.dogo.com.dogo_android.h.gl
    public final void b(int i, View view) {
        int i2 = 1;
        i2 = 1;
        i2 = 0;
        int r2 = this.S != null ? 1 : i2;
        if (i2 != 0 && this.Q != null) {
            if (i2 != 0) {
                this.S.onTrickListSelected(this.Q.getId(), this.Q.getName());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.gl
    protected void m() {
        long l;
        int cmp2 = 0;
        int i;
        synchronized (this) {
            try {
                final long l5 = 0L;
                this.V = l5;
            } catch (Throwable th) {
            }
        }
        final long l6 = 13L;
        long l7 = l & l6;
        long l2 = 9L;
        cmp2 = 0;
        if (l7 != l5 && l3 != l5) {
            int r12 = this.Q != null ? 1 : 0;
            if (l3 != l5) {
                int r13 = cmp2 != 0 ? 32 : 16;
                l = l | (cmp2 != 0 ? 32 : 16);
            }
            if (cmp2 == 0) {
                cmp2 = 8;
            }
        }
        long l8 = l & 9L;
        if (l8 != l5) {
            this.T.setVisibility(cmp2);
        }
        long l9 = 8L & l;
        if (this.T != l5) {
            this.O.setOnClickListener(this.U);
        }
        l &= l6;
        if (this.V != l5) {
            TrainingBindingAdapters.r(this.P, this.Q, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gl
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

    private hl(e eVar, View view, Object[] objectArr) {
        int i2 = 1;
        super(eVar, view, 0, (ImageView)objectArr[3], (Button)objectArr[i2], (RecyclerView)objectArr[2]);
        this.V = -1L;
        Object obj4 = objectArr[0];
        this.T = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.O.setTag(obj5);
        this.P.setTag(obj5);
        N(view);
        this.U = new b(this, i2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.gl
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
