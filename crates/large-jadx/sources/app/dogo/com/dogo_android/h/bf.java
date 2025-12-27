package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
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
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.u.n.k;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.y.l;

/* compiled from: FragmentPottyProgramOverviewBindingImpl.java */
/* loaded from: classes.dex */
public class bf extends af implements c.a {

    private static final ViewDataBinding.g j0;
    private static final SparseIntArray k0 = new SparseIntArray();
    private final SwipeRefreshLayout d0;
    private final ConstraintLayout e0;
    private final Group f0;
    private final ConstraintLayout g0;
    private final SwipeRefreshLayout.j h0;
    private long i0;
    static {
        obj.put(2131363185, 9);
        obj.put(2131362992, 10);
        obj.put(2131362991, 11);
        obj.put(2131362998, 12);
        obj.put(2131362990, 13);
        obj.put(2131362395, 14);
        obj.put(2131363500, 15);
        obj.put(2131363441, 16);
        obj.put(2131362690, 17);
    }

    public bf(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 18, bf.j0, bf.k0));
    }

    private boolean X(x<y<SpecialProgramOverviewItem>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.i0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.af
    public void A() {
        synchronized (this) {
            try {
                this.i0 = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.af
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.af
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

    @Override // app.dogo.com.dogo_android.h.af
    public void V(k kVar) {
        this.c0 = kVar;
        synchronized (this) {
            try {
                this.i0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.af
    public void W(app.dogo.com.dogo_android.u.n.n nVar) {
        this.b0 = nVar;
        synchronized (this) {
            try {
                this.i0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.af
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.b0 != null ? 1 : 0;
        if (i2 != 0) {
            this.b0.u();
        }
    }

    @Override // app.dogo.com.dogo_android.h.af
    protected void m() {
        int cmp;
        Object obj2;
        y yVar;
        int i = 0;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l3 = 0L;
                obj.i0 = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 15L & l;
        final Boolean bool = null;
        if (l4 != l3) {
            if (obj.b0 != null) {
                x xVar = obj.b0.s();
            } else {
                int i2 = bool;
            }
            i = 0;
            obj.Q(i, obj2);
            Object value = obj.b0 != null ? (LoadResult)value : bool;
        }
        long l5 = 13L & l;
        if (l5 != l3) {
            BindingAdapters.Z(obj.O, yVar);
            BindingAdapters.setTrainerAvatar(obj.d0, yVar);
            BindingAdapters.y0(obj.d0, yVar);
            ProgramBindingAdapters.u0(obj.e0, yVar, obj.S, obj.U, obj.P, obj.O, obj.a0, button);
            BindingAdapters.w0(obj.f0, yVar);
            BindingAdapters.H0(obj.g0, yVar);
            ProgramBindingAdapters.setProgramBubbleColor(obj.X, yVar);
            BindingAdapters.Z(obj.Z, yVar);
        }
        long l2 = l & 8L;
        if (obj.i0 != l3) {
            BindingAdapters.a0(obj.d0, bool);
            obj.d0.setOnRefreshListener(obj.h0);
            BindingAdapters.k0(obj.W, bool);
        }
        if (l4 != l3) {
            ProgramBindingAdapters.t0(obj.R, yVar, obj.c0);
        }
    }

    @Override // app.dogo.com.dogo_android.h.af
    public boolean y() {
        synchronized (this) {
            try {
                if (this.i0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private bf(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (Button)objectArr[3], (TextView)objectArr[14], (KonfettiView)objectArr[17], (LinearLayout)objectArr[2], (TextView)objectArr[13], (AppCompatImageView)objectArr[11], (FrameLayout)objectArr[10], (TextView)objectArr[12], (NestedScrollView)objectArr[9], (FrameLayout)objectArr[6], (TextView)objectArr[7], (MaterialToolbar)objectArr[16], (Button)objectArr[4], (TextView)objectArr[15]);
        Object eVar4 = this;
        eVar4.i0 = -1L;
        Object obj2 = null;
        eVar4.O.setTag(obj2);
        Object obj = objectArr[0];
        eVar4.d0 = obj;
        obj.setTag(obj2);
        int i3 = 1;
        Object obj3 = objectArr[i3];
        eVar4.e0 = obj3;
        obj3.setTag(obj2);
        Object obj4 = objectArr[5];
        eVar4.f0 = obj4;
        obj4.setTag(obj2);
        Object obj5 = objectArr[8];
        eVar4.g0 = obj5;
        obj5.setTag(obj2);
        eVar4.R.setTag(obj2);
        eVar4.W.setTag(obj2);
        eVar4.X.setTag(obj2);
        eVar4.Z.setTag(obj2);
        eVar4.N(view);
        eVar4.h0 = new c(eVar4, i3);
        A();
    }
}
