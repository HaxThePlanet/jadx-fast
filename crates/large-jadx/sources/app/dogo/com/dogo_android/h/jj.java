package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.repository.domain.RecentlyViewedTricks;

/* compiled from: LayoutDashboardRecentlyViewedTricksBindingImpl.java */
/* loaded from: classes.dex */
public class jj extends ij {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout R;
    private long S;
    static {
        obj.put(2131363414, 2);
    }

    public jj(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, jj.T, jj.U));
    }

    @Override // app.dogo.com.dogo_android.h.ij
    public void A() {
        synchronized (this) {
            try {
                this.S = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ij
    public boolean O(int i, Object object) {
        int i2 = 131;
        boolean z = true;
        i2 = 131;
        if (131 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ij
    public void V(o.a aVar) {
        this.Q = aVar;
        synchronized (this) {
            try {
                this.S |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ij
    public void W(RecentlyViewedTricks recentlyViewedTricks) {
        this.P = recentlyViewedTricks;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(131);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ij
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.S & 7L;
        if (l2 != l3) {
            TrainingBindingAdapters.o(this.O, this.P, this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ij
    public boolean y() {
        synchronized (this) {
            try {
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private jj(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[2], (RecyclerView)objectArr[1]);
        this.S = -1L;
        Object obj3 = objectArr[0];
        this.R = obj3;
        final Object obj4 = null;
        obj3.setTag(obj4);
        this.O.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ij
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
