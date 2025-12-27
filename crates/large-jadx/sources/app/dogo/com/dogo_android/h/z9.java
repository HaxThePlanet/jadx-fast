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
import app.dogo.com.dogo_android.u.j;
import app.dogo.com.dogo_android.u.m.p;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* compiled from: FragmentBitingProgramOverviewBindingImpl.java */
/* loaded from: classes.dex */
public class z9 extends y9 implements c.a {

    private static final ViewDataBinding.g q0;
    private static final SparseIntArray r0 = new SparseIntArray();
    private final SwipeRefreshLayout k0;
    private final ConstraintLayout l0;
    private final ConstraintLayout m0;
    private final Group n0;
    private final SwipeRefreshLayout.j o0;
    private long p0;
    static {
        obj.put(2131363185, 11);
        obj.put(2131362992, 12);
        obj.put(2131362991, 13);
        obj.put(2131362998, 14);
        obj.put(2131363030, 15);
        obj.put(2131363031, 16);
        obj.put(2131362395, 17);
        obj.put(2131363500, 18);
        obj.put(2131363441, 19);
        obj.put(2131363584, 20);
        obj.put(2131363586, 21);
        obj.put(2131362690, 22);
    }

    public z9(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 23, z9.q0, z9.r0));
    }

    private boolean Y(x<y<SpecialProgramOverviewItem>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.p0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public void A() {
        synchronized (this) {
            try {
                this.p0 = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.y9
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 90;
        if (90 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                V(object);
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

    @Override // app.dogo.com.dogo_android.h.y9
    public void V(j jVar) {
        this.i0 = jVar;
        synchronized (this) {
            try {
                this.p0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public void W(Boolean boolean) {
        this.j0 = boolean;
        synchronized (this) {
            try {
                this.p0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(90);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public void X(p pVar) {
        this.h0 = pVar;
        synchronized (this) {
            try {
                this.p0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.h0 != null ? 1 : 0;
        if (i2 != 0) {
            this.h0.s();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y9
    protected void m() {
        int cmp3;
        long l;
        y yVar = null;
        Object obj2 = null;
        Object value = null;
        boolean z = false;
        long l3;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l5 = 0L;
                obj.p0 = l5;
            } catch (Throwable th) {
            }
        }
        long l6 = 31L & l4;
        if (l6 != l5) {
            if (obj.h0 != null) {
                x xVar = obj.h0.q();
            } else {
                int i2 = 0;
            }
            obj.Q(0, obj2);
            value = obj.h0 != null ? (LoadResult)value : 0;
        } else {
            int i3 = 0;
        }
        l3 = 25L & l4;
        if (l3 != l5) {
            BindingAdapters.Z(obj.O, yVar);
            BindingAdapters.setTrainerAvatar(obj.k0, yVar);
            BindingAdapters.y0(obj.k0, yVar);
            ProgramBindingAdapters.u0(obj.l0, yVar, obj.T, obj.V, obj.P, button, textView, button2);
            BindingAdapters.H0(obj.m0, yVar);
            BindingAdapters.w0(obj.n0, yVar);
            ProgramBindingAdapters.setProgramBubbleColor(obj.a0, yVar);
            BindingAdapters.Z(obj.c0, yVar);
        }
        l2 = 16L & l4;
        if (obj.c0 != l5) {
            Boolean bool2 = null;
            BindingAdapters.a0(obj.k0, bool2);
            obj.k0.setOnRefreshListener(obj.o0);
            BindingAdapters.k0(obj.Z, bool2);
        }
        l = l4 & 29L;
        if (obj.p0 != l5) {
            ProgramBindingAdapters.t0(obj.R, yVar, obj.i0);
            ProgramBindingAdapters.u(obj.S, yVar, obj.W, obj.i0, obj.X);
        }
        if (l6 != l5) {
            ProgramBindingAdapters.setIntroductionSlides(obj.f0, yVar, obj.g0, obj.i0, z);
        }
    }

    @Override // app.dogo.com.dogo_android.h.y9
    public boolean y() {
        synchronized (this) {
            try {
                if (this.p0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private z9(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (Button)objectArr[4], (TextView)objectArr[17], (KonfettiView)objectArr[22], (LinearLayout)objectArr[3], (TextView)objectArr[2], (AppCompatImageView)objectArr[13], (FrameLayout)objectArr[12], (TextView)objectArr[14], (TextView)objectArr[15], (View)objectArr[16], (NestedScrollView)objectArr[11], (FrameLayout)objectArr[7], (TextView)objectArr[9], (MaterialToolbar)objectArr[19], (Button)objectArr[5], (TextView)objectArr[18], (AppCompatImageView)objectArr[20], (View)objectArr[8], (AppCompatImageView)objectArr[21]);
        Object eVar4 = this;
        eVar4.p0 = -1L;
        Object obj2 = null;
        eVar4.O.setTag(obj2);
        Object obj = objectArr[0];
        eVar4.k0 = obj;
        obj.setTag(obj2);
        int i3 = 1;
        Object obj3 = objectArr[i3];
        eVar4.l0 = obj3;
        obj3.setTag(obj2);
        Object obj4 = objectArr[10];
        eVar4.m0 = obj4;
        obj4.setTag(obj2);
        Object obj5 = objectArr[6];
        eVar4.n0 = obj5;
        obj5.setTag(obj2);
        eVar4.R.setTag(obj2);
        eVar4.S.setTag(obj2);
        eVar4.Z.setTag(obj2);
        eVar4.a0.setTag(obj2);
        eVar4.c0.setTag(obj2);
        eVar4.f0.setTag(obj2);
        eVar4.N(view);
        eVar4.o0 = new c(eVar4, i3);
        A();
    }
}
