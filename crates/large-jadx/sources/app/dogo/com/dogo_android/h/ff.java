package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.u.n.r.d;
import app.dogo.com.dogo_android.u.n.r.h;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.l0.b;

/* compiled from: FragmentPottyTrackerOverviewBindingImpl.java */
/* loaded from: classes.dex */
public class ff extends ef {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout V;
    private long W;
    static {
        obj.put(2131363433, 3);
        obj.put(2131363331, 4);
        obj.put(2131362887, 5);
    }

    public ff(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, ff.X, ff.Y));
    }

    @Override // app.dogo.com.dogo_android.h.ef
    public void A() {
        synchronized (this) {
            try {
                this.W = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ef
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

    @Override // app.dogo.com.dogo_android.h.ef
    public void V(b bVar) {
        this.T = bVar;
        synchronized (this) {
            try {
                this.W |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ef
    public void W(h hVar) {
        this.U = hVar;
        synchronized (this) {
            try {
                this.W |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ef
    protected void m() {
        java.util.List list;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.W = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 7L & l;
        final Boolean bool = null;
        if (l4 == l3 || this.U == null) {
            int i2 = bool;
        } else {
            list = this.U.h();
        }
        if (l4 != l3) {
            PottyTrackerBindingAdapters.b(this.P, this.Q, this.T, list);
        }
        long l2 = l & 4L;
        if (this.W != l3) {
            BindingAdapters.k0(this.S, bool);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ef
    public boolean y() {
        synchronized (this) {
            try {
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private ff(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (MaterialButton)objectArr[5], (ViewPager2)objectArr[2], (TabLayout)objectArr[4], (MaterialToolbar)objectArr[3], (FrameLayout)objectArr[1]);
        this.W = -1L;
        Object obj6 = objectArr[0];
        this.V = obj6;
        final Object obj7 = null;
        obj6.setTag(obj7);
        this.P.setTag(obj7);
        this.S.setTag(obj7);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ef
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
