package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.s.i.a;

/* compiled from: FragmentProgramLessonBindingImpl.java */
/* loaded from: classes.dex */
public class jf extends if implements c.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout S;
    private final RecyclerView T;
    private final SwipeRefreshLayout.j U;
    private long V;
    public jf(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, jf.W, jf.X));
    }

    private boolean Y(LiveData<y<ProgramLessonItem>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.if
    public void A() {
        synchronized (this) {
            try {
                this.V = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.if
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.if
    public boolean O(int i, Object object) {
        int i2 = 177;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                X(object);
            } else {
                i2 = 141;
                if (141 == i) {
                    W(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.if
    public void V(i.a aVar) {
        this.R = aVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.if
    public void X(app.dogo.com.dogo_android.y.s.l lVar) {
        this.Q = lVar;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.if
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.Q != null ? 1 : 0;
        if (i2 != 0) {
            this.Q.u();
        }
    }

    @Override // app.dogo.com.dogo_android.h.if
    protected void m() {
        LiveData result;
        app.dogo.com.dogo_android.y.s.l lVar;
        y yVar = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l5 = 23L & l;
        if (l5 != l3) {
            if (this.Q != null) {
                result = this.Q.getResult();
            } else {
            }
            int i2 = 0;
            Q(i2, result);
            if (this.Q != null) {
            }
        }
        if (l5 != l3) {
            ProgramBindingAdapters.setHtmlText(this.T, yVar, this.R);
        }
        long l4 = 21L & l;
        if (this.R != l3) {
            BindingAdapters.y0(this.O, yVar);
            ProgramBindingAdapters.setupVariationSymbolIcon(this.P, yVar);
        }
        long l2 = l & 16L;
        if (this.V != l3) {
            this.O.setOnRefreshListener(this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.if
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

    private jf(e eVar, View view, Object[] objectArr) {
        int i2 = 1;
        super(eVar, view, 1, (SwipeRefreshLayout)objectArr[2], (MaterialToolbar)objectArr[i2]);
        this.V = -1L;
        Object obj4 = objectArr[0];
        this.S = obj4;
        Object obj3 = null;
        obj4.setTag(obj3);
        Object obj5 = objectArr[3];
        this.T = obj5;
        obj5.setTag(obj3);
        this.O.setTag(obj3);
        this.P.setTag(obj3);
        N(view);
        this.U = new c(this, i2);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.if
    public void W(app.dogo.com.dogo_android.view.dailytraining.l lVar) {
    }
}
