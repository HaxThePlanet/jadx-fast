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
import androidx.lifecycle.x;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.y.e.a;
import app.dogo.com.dogo_android.y.y.h;
import java.util.List;

/* compiled from: FragmentProgramListBindingImpl.java */
/* loaded from: classes.dex */
public class tf extends sf implements c.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout T;
    private final SwipeRefreshLayout.j U;
    private long V;
    static {
        obj.put(2131363433, 3);
        obj.put(2131362597, 4);
    }

    public tf(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, tf.W, tf.X));
    }

    private boolean X(x<y<List<ProgramDescriptionItem>>> xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.sf
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.sf
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.sf
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

    @Override // app.dogo.com.dogo_android.h.sf
    public void V(e.a aVar) {
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

    @Override // app.dogo.com.dogo_android.h.sf
    public void W(h hVar) {
        this.R = hVar;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sf
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.R != null ? 1 : 0;
        if (i2 != 0) {
            this.R.l();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sf
    protected void m() {
        Object obj;
        int cmp2;
        y yVar = null;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 15L & l;
        if (l4 != l3 && this.R != null) {
            x list = this.R.loadList();
            int i2 = 0;
            Q(i2, obj);
            if (this.R != null) {
            }
        }
        long l5 = 13L & l;
        if (l5 != l3) {
            BindingAdapters.setTrainerAvatar(this.T, yVar);
            BindingAdapters.y0(this.P, yVar);
        }
        if (l4 != l3) {
            int cmp3 = 2131558778;
            ProgramBindingAdapters.setupZendeskClickArea(this.O, yVar, this.S, cmp3);
        }
        long l2 = l & 8L;
        if (this.V != l3) {
            this.P.setOnRefreshListener(this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.sf
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

    private tf(e eVar, View view, Object[] objectArr) {
        int i3 = 1;
        super(eVar, view, 1, (ConstraintLayout)objectArr[4], (RecyclerView)objectArr[2], (SwipeRefreshLayout)objectArr[i3], (MaterialToolbar)objectArr[3]);
        this.V = -1L;
        Object obj5 = objectArr[0];
        this.T = obj5;
        final Object obj6 = null;
        obj5.setTag(obj6);
        this.O.setTag(obj6);
        this.P.setTag(obj6);
        N(view);
        this.U = new c(this, i3);
        A();
    }
}
