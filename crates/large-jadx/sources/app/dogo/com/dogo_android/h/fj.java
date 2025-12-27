package app.dogo.com.dogo_android.h;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.g.a0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import java.util.List;

/* compiled from: LayoutDashboardPottyProgramCheckmarksCardBindingImpl.java */
/* loaded from: classes.dex */
public class fj extends ej implements b.a {

    private static final ViewDataBinding.g k0;
    private static final SparseIntArray l0 = new SparseIntArray();
    private final View.OnClickListener c0;
    private final View.OnClickListener d0;
    private final View.OnClickListener e0;
    private final View.OnClickListener f0;
    private final View.OnClickListener g0;
    private final View.OnClickListener h0;
    private final View.OnClickListener i0;
    private long j0;
    static {
        obj.put(2131363414, 12);
        obj.put(2131362322, 13);
        obj.put(2131362156, 14);
    }

    public fj(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 15, fj.k0, fj.l0));
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public void A() {
        synchronized (this) {
            try {
                this.j0 = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 94;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 29;
            if (29 == i) {
                T(object);
            } else {
                i2 = 39;
                if (39 == i) {
                    U(object);
                } else {
                    int i4 = 0;
                }
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public void T(a0 a0Var) {
        this.a0 = a0Var;
        synchronized (this) {
            try {
                this.j0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public void U(List<Boolean> list) {
        this.b0 = list;
        synchronized (this) {
            try {
                this.j0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(39);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public final void b(int i, View view) {
        int view22 = 0;
        view22 = 1;
        view22 = 0;
        switch (i) {
            case 1:
                this.a0.onScheduleSelected("potty_card");
                break;
            case 2:
                this.a0.onCheckmarkCardSelected("calendar");
                break;
            case 3:
                this.a0.onReadHowSelected(ViewDataBinding.v(this.b0, view22).booleanValue());
                break;
            case 4:
                this.a0.onReadHowSelected(ViewDataBinding.v(this.b0, view22).booleanValue());
                break;
            case 5:
                this.a0.onReadHowSelected(ViewDataBinding.v(this.b0, 2).booleanValue());
                break;
            case 6:
                this.a0.onReadHowSelected(ViewDataBinding.v(this.b0, 3).booleanValue());
                break;
            case 7:
                this.a0.onReadHowSelected(ViewDataBinding.v(this.b0, 4).booleanValue());
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.ej
    protected void m() {
        int cmp;
        Boolean bool;
        boolean z;
        Boolean bool2;
        boolean z3 = false;
        Boolean bool3 = null;
        boolean z2;
        Boolean bool4;
        boolean z4;
        Boolean bool5;
        boolean z5;
        int i3 = 1;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.j0 = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 12L & l;
        int i = 0;
        if (l4 != l3) {
            if (this.b0 != null) {
                Object obj3 = ViewDataBinding.v(this.b0, 4);
                Object obj4 = ViewDataBinding.v(this.b0, 2);
                Object obj5 = ViewDataBinding.v(this.b0, 3);
                i3 = 1;
                Object obj2 = ViewDataBinding.v(this.b0, i3);
            } else {
            }
            z4 = ViewDataBinding.K(bool4);
            z5 = ViewDataBinding.K(bool5);
            z = ViewDataBinding.K(bool);
        } else {
        }
        long l2 = l & 8L;
        if (this.j0 != l3) {
            this.O.setOnClickListener(this.g0);
            this.P.setOnClickListener(this.e0);
            this.Q.setOnClickListener(this.f0);
            this.R.setOnClickListener(this.i0);
            this.S.setOnClickListener(this.h0);
            this.T.setOnClickListener(this.d0);
            this.U.setOnClickListener(this.c0);
        }
        if (l4 != l3) {
            a.a(this.V, z3);
            a.a(this.W, z);
            a.a(this.X, z4);
            a.a(this.Y, z5);
            a.a(this.Z, z2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public boolean y() {
        synchronized (this) {
            try {
                if (this.j0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private fj(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (Button)objectArr[1], (ConstraintLayout)objectArr[14], (View)objectArr[7], (View)objectArr[8], (View)objectArr[9], (View)objectArr[10], (View)objectArr[11], (ImageView)objectArr[13], (MaterialCardView)objectArr[0], (TextView)objectArr[12], (CheckBox)objectArr[2], (CheckBox)objectArr[3], (CheckBox)objectArr[4], (CheckBox)objectArr[5], (CheckBox)objectArr[6]);
        Object eVar4 = this;
        eVar4.j0 = -1L;
        Object obj = null;
        eVar4.O.setTag(obj);
        eVar4.P.setTag(obj);
        eVar4.Q.setTag(obj);
        eVar4.R.setTag(obj);
        eVar4.S.setTag(obj);
        eVar4.T.setTag(obj);
        eVar4.U.setTag(obj);
        eVar4.V.setTag(obj);
        eVar4.W.setTag(obj);
        eVar4.X.setTag(obj);
        eVar4.Y.setTag(obj);
        eVar4.Z.setTag(obj);
        eVar4.N(view);
        eVar4.c0 = new b(eVar4, 1);
        eVar4.d0 = new b(eVar4, 7);
        eVar4.e0 = new b(eVar4, 3);
        eVar4.f0 = new b(eVar4, 4);
        eVar4.g0 = new b(eVar4, 2);
        eVar4.h0 = new b(eVar4, 6);
        eVar4.i0 = new b(eVar4, 5);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ej
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public void V(PottyProgramProgress pottyProgramProgress) {
    }
}
