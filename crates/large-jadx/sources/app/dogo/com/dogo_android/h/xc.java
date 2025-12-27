package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
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
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.o.q.a;
import app.dogo.com.dogo_android.y.o.t;
import java.util.List;

/* compiled from: FragmentExamHistoryBindingImpl.java */
/* loaded from: classes.dex */
public class xc extends wc implements c.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final SwipeRefreshLayout.j U;
    private long V;
    public xc(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, xc.W, xc.X));
    }

    private boolean X(LiveData<y<List<ProgramExam>>> liveData, int i) {
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

    @Override // app.dogo.com.dogo_android.h.wc
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.wc
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.wc
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

    @Override // app.dogo.com.dogo_android.h.wc
    public void V(q.a aVar) {
        this.S = aVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wc
    public void W(t tVar) {
        this.R = tVar;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wc
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.R != null ? 1 : 0;
        if (i2 != 0) {
            this.R.v();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wc
    protected void m() {
        java.lang.CharSequence charSequence;
        int i = 0;
        y yVar = null;
        LiveData result;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 15L & l;
        long l5 = 13L;
        i = 0;
        if (l4 != l3) {
            if (this.R != null) {
                result = this.R.getResult();
            } else {
            }
            Q(0, result);
            Object value = result != null ? (LoadResult)value : i;
            long l7 = l & 13L;
            if (l7 != l3 && this.R != null) {
                String str = this.R.o(yVar);
            }
        } else {
        }
        long l6 = 13L & l;
        if (l6 != l3) {
            BindingAdapters.setTrainerAvatar(this.T, yVar);
            BindingAdapters.y0(this.P, yVar);
            this.Q.setTitle(charSequence);
        }
        if (l4 != l3) {
            ProgramBindingAdapters.Z(this.O, yVar, this.S);
        }
        long l2 = l & 8L;
        if (this.V != l3) {
            this.P.setOnRefreshListener(this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wc
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

    private xc(e eVar, View view, Object[] objectArr) {
        int i3 = 1;
        super(eVar, view, 1, (RecyclerView)objectArr[3], (SwipeRefreshLayout)objectArr[2], (MaterialToolbar)objectArr[i3]);
        this.V = -1L;
        Object obj4 = objectArr[0];
        this.T = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.O.setTag(obj5);
        this.P.setTag(obj5);
        this.Q.setTag(obj5);
        N(view);
        this.U = new c(this, i3);
        A();
    }

}
