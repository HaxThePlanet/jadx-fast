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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.repository.domain.ProgramExamList;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.o.u.b;
import app.dogo.com.dogo_android.y.o.x;

/* compiled from: FragmentProgramLessonExamListBindingImpl.java */
/* loaded from: classes.dex */
public class nf extends mf implements c.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout T;
    private final SwipeRefreshLayout.j U;
    private long V;
    static {
        obj.put(2131363433, 3);
    }

    public nf(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, nf.W, nf.X));
    }

    private boolean X(LiveData<y<ProgramExamList>> liveData, int i) {
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

    @Override // app.dogo.com.dogo_android.h.mf
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.mf
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.mf
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.mf
    public void V(u.b bVar) {
        this.S = bVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mf
    public void W(x xVar) {
        this.R = xVar;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mf
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.R != null ? 1 : 0;
        if (i2 != 0) {
            this.R.z();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mf
    protected void m() {
        LiveData result;
        x xVar;
        boolean z = false;
        int i = 0;
        y yVar = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l5 = 15L & l;
        int i2 = 0;
        if (l5 != l3) {
            if (this.R != null) {
                z = this.R.u();
                result = this.R.getResult();
            } else {
            }
            Q(i2, result);
            if (this.R != null) {
            }
        }
        if (l5 != l3) {
            ProgramBindingAdapters.loadCertificate(this.O, yVar, this.S, Boolean.valueOf(z));
        }
        long l4 = 8L & l;
        if (this.S != l3) {
            this.P.setOnRefreshListener(this.U);
        }
        long l2 = l & 13L;
        if (this.V != l3) {
            BindingAdapters.y0(this.P, yVar);
        }
    }

    @Override // app.dogo.com.dogo_android.h.mf
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

    private nf(e eVar, View view, Object[] objectArr) {
        int i2 = 1;
        super(eVar, view, 1, (RecyclerView)objectArr[2], (SwipeRefreshLayout)objectArr[i2], (MaterialToolbar)objectArr[3]);
        this.V = -1L;
        Object obj4 = objectArr[0];
        this.T = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.O.setTag(obj5);
        this.P.setTag(obj5);
        N(view);
        this.U = new c(this, i2);
        A();
    }
}
