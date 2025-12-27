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
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;

/* compiled from: LayoutLibraryProgramListBindingImpl.java */
/* loaded from: classes.dex */
public class bl extends al implements app.dogo.com.dogo_android.l.a.b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout T;
    private final View.OnClickListener U;
    private long V;
    static {
        obj.put(2131363206, 3);
        obj.put(2131362326, 4);
    }

    public bl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, bl.W, bl.X));
    }

    @Override // app.dogo.com.dogo_android.h.al
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.al
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

    @Override // app.dogo.com.dogo_android.h.al
    public void T(app.dogo.com.dogo_android.n.l.b.a aVar) {
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

    @Override // app.dogo.com.dogo_android.h.al
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

    @Override // app.dogo.com.dogo_android.h.al
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

    @Override // app.dogo.com.dogo_android.h.al
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.S != null ? 1 : 0;
        if (i2 != 0) {
            this.S.Q();
        }
    }

    @Override // app.dogo.com.dogo_android.h.al
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
            LibraryBindingAdapters.p(this.P, this.Q, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.al
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

    private bl(e eVar, View view, Object[] objectArr) {
        int i3 = 1;
        super(eVar, view, 0, (ImageView)objectArr[4], (TextView)objectArr[3], (Button)objectArr[i3], (ViewPager2)objectArr[2]);
        this.V = -1L;
        Object obj5 = objectArr[0];
        this.T = obj5;
        final Object obj6 = null;
        obj5.setTag(obj6);
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        N(view);
        this.U = new b(this, i3);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.al
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
