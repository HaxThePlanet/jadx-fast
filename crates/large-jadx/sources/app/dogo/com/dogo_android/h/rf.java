package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.repository.domain.Program;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.w.l.b;
import app.dogo.com.dogo_android.y.w.o;

/* compiled from: FragmentProgramLessonsListBindingImpl.java */
/* loaded from: classes.dex */
public class rf extends qf implements c.a {

    private static final ViewDataBinding.g f0 = new ViewDataBinding$g(12);
    private static final SparseIntArray g0 = new SparseIntArray();
    private final SwipeRefreshLayout.j d0;
    private long e0;
    static {
        int i5 = 1;
        final int[] iArr2 = new int[i5];
        final int i12 = 0;
        iArr2[i12] = 8;
        int[] iArr = new int[i5];
        iArr[i12] = R.layout.layout_program_overview_certificate;
        obj.a(2, new String[] { "layout_program_overview_certificate" }, iArr2, iArr);
        obj.put(2131363433, 9);
        obj.put(2131362878, 10);
        obj.put(2131363511, 11);
    }

    public rf(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 12, rf.f0, rf.g0));
    }

    private boolean Y(gm gmVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.e0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.e0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.e0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean b0(LiveData<y<Program>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.e0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public void A() {
        synchronized (this) {
            try {
                this.e0 = 128L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qf
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return a0(object, i2);
        }
        return Z(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public boolean O(int i, Object object) {
        int i2 = 38;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 38;
            if (38 == i) {
                W(object);
            } else {
                i2 = 177;
                if (177 == i) {
                    X(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public void V(l.b bVar) {
        this.b0 = bVar;
        synchronized (this) {
            try {
                this.e0 |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public void W(Boolean boolean) {
        this.c0 = boolean;
        synchronized (this) {
            try {
                this.e0 |= 32;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(38);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public void X(o oVar) {
        this.a0 = oVar;
        synchronized (this) {
            try {
                this.e0 |= 64;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.a0 != null ? 1 : 0;
        if (i2 != 0) {
            this.a0.r();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qf
    protected void m() {
        int i = 8;
        long l;
        boolean z;
        Object obj2;
        y yVar;
        java.lang.CharSequence charSequence2;
        Object value2;
        LiveData result;
        java.lang.CharSequence charSequence;
        Object obj3;
        Object value3;
        int i3 = 1;
        boolean z2 = false;
        int i4;
        long l5 = 193;
        int i2 = 0;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l6 = 0L;
                obj.e0 = l6;
            } catch (Throwable th) {
            }
        }
        long l8 = l & 160L;
        i = 0;
        if (l8 != l6) {
            boolean z3 = ViewDataBinding.K(obj.c0);
            if (l8 != l6) {
                int r12 = z3 ? 512 : 256;
                l = l | (z3 ? 512 : 256);
            }
            if (z3) {
            } else {
                i = 8;
            }
        }
        long l10 = 215L & l;
        long l11 = 196L;
        l5 = 193L;
        final long l14 = 210L;
        final long l15 = 194L;
        i2 = 0;
        if (l10 != l6) {
            long l16 = l & 210L;
            if (l16 != l6) {
                if (obj.a0 != null) {
                    z = obj.a0.p();
                } else {
                }
                i3 = 1;
                obj.Q(i3, result);
                value2 = result != null ? (LoadResult)value2 : i2;
            } else {
            }
            long l17 = l & 193L;
            if (l17 != l6) {
                if (obj.a0 != null) {
                    x xVar2 = obj.a0.n();
                } else {
                }
                obj.Q(i, obj3);
                value3 = obj3 != null ? (String)value3 : i2;
            }
            long l18 = l & 194L;
            if (l18 != l6 && obj.a0 != null) {
                boolean z4 = obj.a0.l();
            }
            long l19 = l & 196L;
            if (l19 != l6) {
                if (obj.a0 != null) {
                    x xVar = obj.a0.o();
                } else {
                }
                obj.Q(2, obj2);
                if (obj.a0 != null) {
                }
            }
        } else {
        }
        long l12 = l & 194L;
        if (l12 != l6) {
            BindingAdapters.w0(obj.P, yVar);
            ProgramBindingAdapters.s0(obj.R, yVar, Boolean.valueOf(z2), obj.O);
            BindingAdapters.setTrainerAvatar(obj.W, yVar);
            BindingAdapters.y0(obj.X, yVar);
        }
        long l13 = 160L & l;
        if (obj.R != l6) {
            obj.Q.setVisibility(i);
        }
        long l9 = l & 196L;
        if (obj.W != l6) {
            g.c(obj.T, charSequence2);
        }
        l4 = 193L & l;
        if (obj.W != l6) {
            g.c(obj.U, charSequence);
        }
        l3 = l & 210L;
        if (l3 != l6) {
            ProgramBindingAdapters.b0(recyclerView, yVar, obj.b0, obj.Z, obj.S, Boolean.valueOf(z));
        }
        l2 = l & 128L;
        if (obj.e0 != l6) {
            obj.X.setOnRefreshListener(obj.d0);
        }
        ViewDataBinding.o(obj.O);
    }

    @Override // app.dogo.com.dogo_android.h.qf
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.e0 != 0) {
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

    private rf(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 4, (gm)objectArr[8], (MaterialButton)objectArr[6], (FrameLayout)objectArr[5], (ConstraintLayout)objectArr[2], (NestedScrollView)objectArr[10], (TextView)objectArr[3], (TextView)objectArr[4], (RecyclerView)objectArr[7], (ConstraintLayout)objectArr[0], (SwipeRefreshLayout)objectArr[1], (MaterialToolbar)obj, (Button)obj2);
        Object eVar4 = this;
        eVar4.e0 = -1L;
        eVar4.L(eVar4.O);
        Object obj13 = null;
        eVar4.P.setTag(obj13);
        eVar4.Q.setTag(obj13);
        eVar4.R.setTag(obj13);
        eVar4.T.setTag(obj13);
        eVar4.U.setTag(obj13);
        eVar4.V.setTag(obj13);
        eVar4.W.setTag(obj13);
        eVar4.X.setTag(obj13);
        eVar4.N(view);
        eVar4.d0 = new c(eVar4, 1);
        A();
    }
}
