package app.dogo.com.dogo_android.h;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.RemindersModel;
import app.dogo.com.dogo_android.repository.domain.SettingsResults;
import app.dogo.com.dogo_android.t.a0;
import app.dogo.com.dogo_android.t.b0;
import app.dogo.com.dogo_android.t.e0;
import app.dogo.com.dogo_android.t.f0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.view.dailytraining.l;

/* compiled from: FragmentSettingsBindingImpl.java */
/* loaded from: classes.dex */
public class lg extends kg implements b.a {

    private static final ViewDataBinding.g N0 = new ViewDataBinding$g(34);
    private static final SparseIntArray O0 = new SparseIntArray();
    private final View.OnClickListener A0;
    private final View.OnClickListener B0;
    private final View.OnClickListener C0;
    private final View.OnClickListener D0;
    private final View.OnClickListener E0;
    private final View.OnClickListener F0;
    private final View.OnClickListener G0;
    private final View.OnClickListener H0;
    private final View.OnClickListener I0;
    private final View.OnClickListener J0;
    private final View.OnClickListener K0;
    private final View.OnClickListener L0;
    private long M0;
    private final ConstraintLayout p0;
    private final TextView q0;
    private final ml r0;
    private final TextView s0;
    private final View.OnClickListener t0;
    private final View.OnClickListener u0;
    private final View.OnClickListener v0;
    private final View.OnClickListener w0;
    private final View.OnClickListener x0;
    private final View.OnClickListener y0;
    private final View.OnClickListener z0;
    static {
        int i11 = 1;
        final int[] iArr2 = new int[i11];
        final int i24 = 0;
        iArr2[i24] = 24;
        int[] iArr = new int[i11];
        iArr[i24] = R.layout.layout_loading_spinner;
        obj.a(23, new String[] { "layout_loading_spinner" }, iArr2, iArr);
        obj.put(2131363185, 25);
        obj.put(2131363433, 26);
        obj.put(2131362753, 27);
        obj.put(2131363054, 28);
        obj.put(2131363050, 29);
        obj.put(2131363052, 30);
        obj.put(2131363053, 31);
        obj.put(2131362271, 32);
        obj.put(2131363464, 33);
    }

    public lg(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 34, lg.N0, lg.O0));
    }

    private boolean Y(x<e0> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.M0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(f.d.a.a<y<Boolean>> aVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.M0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(f.d.a.a<y<Boolean>> aVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.M0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean b0(x<y<SettingsResults>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.M0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean c0(x<y<RemindersModel>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.M0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public void A() {
        synchronized (this) {
            try {
                this.M0 = 256L;
            } catch (Throwable th) {
            }
        }
        this.r0.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.kg
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                if (i != 4) {
                    return false;
                }
                return Z(object, i2);
            }
            return a0(object, i2);
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public void M(q qVar) {
        super.M(qVar);
        this.r0.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public boolean O(int i, Object object) {
        int i2 = 141;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 141;
            if (141 == i) {
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

    @Override // app.dogo.com.dogo_android.h.kg
    public void V(b0 b0Var) {
        this.o0 = b0Var;
        synchronized (this) {
            try {
                this.M0 |= 32;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public void X(f0 f0Var) {
        this.n0 = f0Var;
        synchronized (this) {
            try {
                this.M0 |= 128;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public final void b(int i, View view) {
        int view22;
        view22 = 1;
        view22 = 0;
        switch (i) {
            case 1:
                this.n0.l();
                break;
            case 2:
                this.n0.a0();
                break;
            case 3:
                this.n0.Z();
                break;
            case 4:
                x xVar = this.n0.M();
                this.n0.j0((LoadResult)xVar.getValue());
                break;
            case 5:
                this.n0.g0();
                break;
            case 6:
                this.n0.h0();
                break;
            case 7:
                this.n0.d0();
                break;
            case 8:
                this.n0.k();
                break;
            case 9:
                this.n0.f0();
                break;
            case 10:
                this.n0.q();
                break;
            case 11:
                this.n0.R();
                break;
            case 12:
                this.n0.T();
                break;
            case 13:
                this.n0.m();
                break;
            case 14:
                this.n0.c0();
                break;
            case 15:
                this.n0.p();
                break;
            case 16:
                this.n0.S();
                break;
            case 17:
                this.n0.p0();
                break;
            case 18:
                this.n0.k0();
                break;
            case 19:
                this.n0.o();
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.kg
    protected void m() {
        Object obj = null;
        int cmp;
        long l;
        long l2;
        long l3;
        Object obj3 = null;
        int i = 0;
        y yVar5 = null;
        int i2 = 0;
        Object obj4 = null;
        int i3 = 0;
        Object value2 = null;
        Object obj5 = null;
        int i4 = 0;
        y yVar = null;
        int i5 = 1;
        Object obj6 = null;
        y yVar2 = null;
        int cmp9;
        int i6 = 0;
        int i7;
        x xVar;
        int i8 = 0;
        int i9 = 16384;
        int i10 = 32768;
        long l11;
        final Object obj2 = this;
        synchronized (this) {
            try {
                long l4 = 0L;
                obj2.M0 = l4;
            } catch (Throwable th) {
            }
        }
        long l18 = 447L & l;
        long l9 = 386L;
        long l19 = 384L;
        final long l21 = 385L;
        cmp = 0;
        if (l18 != l4) {
            long l22 = l & 384L;
            cmp = 8;
            if (l22 != l4) {
                if (obj2.n0 != null) {
                    String str = obj2.n0.o0();
                    boolean z = obj2.n0.V();
                } else {
                    i6 = 0;
                }
                if (l22 != l4) {
                    if (cmp != 0) {
                        l2 = l | 1024L;
                        i7 = 262144;
                    } else {
                        l2 = l | 512L;
                        i7 = 131072;
                    }
                    l = l2 | i7;
                }
                int r6 = cmp;
                int r22 = cmp;
            } else {
                i6 = 0;
            }
            long l24 = l & 385L;
            if (l24 != l4) {
                xVar = obj2.n0 != null ? xVar : 0;
                obj2.Q(cmp, obj3);
                Object value3 = obj3 != null ? (SettingsScreenConfiguration)value3 : 0;
                if (i != 0) {
                    boolean z2 = i.b();
                    String str2 = i.c();
                    boolean component1 = i.component1();
                } else {
                    i8 = 0;
                }
                if (l24 != l4) {
                    if (cmp != 0) {
                        l3 = l | 4096L;
                        i9 = 16384;
                    } else {
                        l3 = l | 2048L;
                        i9 = 8192;
                    }
                    l = l3 | i9;
                }
                l11 = l & 385L;
                if (l11 != l4) {
                    int r27 = cmp != 0 ? 65536 : 32768;
                    l = l | (cmp != 0 ? 65536 : 32768);
                }
                int r23 = cmp;
                int r25 = cmp;
                if (cmp == 0) {
                }
            } else {
                i8 = 0;
            }
            l12 = l & 386L;
            if (l12 != l4) {
                x xVar2 = obj2.n0 != null ? xVar2 : 0;
                i5 = 1;
                obj2.Q(i5, obj5);
                Object value5 = obj5 != null ? (LoadResult)value5 : 0;
            }
            l13 = l & 404L;
            if (l13 != l4) {
                if (obj2.n0 != null) {
                    f.d.a.a aVar = obj2.n0.t();
                } else {
                    int i21 = 0;
                    int i28 = 0;
                }
                obj2.Q(2, obj6);
                obj2.Q(4, obj4);
                value2 = obj6 != null ? (LoadResult)value2 : 0;
                Object value4 = obj4 != null ? (LoadResult)value4 : 0;
            } else {
                i2 = 0;
                i3 = 0;
            }
            long l10 = 424L;
            l14 = l & l10;
            if (l14 != l4) {
                if (obj2.n0 != null) {
                    x xVar3 = obj2.n0.P();
                } else {
                    int i11 = 0;
                }
                int cmp8 = 3;
                obj2.Q(cmp8, obj);
                if (obj2.n0 != null) {
                } else {
                    int i18 = 0;
                }
            }
        } else {
            int i17 = 0;
            int i25 = 0;
            int i27 = 0;
            i4 = 0;
            i6 = 0;
            i8 = 0;
        }
        long l23 = l & 256L;
        if (l23 != l4) {
            obj2.O.setOnClickListener(obj2.H0);
            obj2.P.setOnClickListener(obj2.B0);
            obj2.Q.setOnClickListener(obj2.t0);
            obj2.R.setOnClickListener(obj2.y0);
            obj2.S.setOnClickListener(obj2.E0);
            obj2.T.setOnClickListener(obj2.G0);
            obj2.U.setOnClickListener(obj2.J0);
            obj2.q0.setOnClickListener(obj2.z0);
            obj2.W.setOnClickListener(obj2.C0);
            obj2.X.setOnClickListener(obj2.F0);
            obj2.Y.setOnClickListener(obj2.w0);
            obj2.Z.setOnClickListener(obj2.K0);
            obj2.b0.setOnClickListener(obj2.x0);
            obj2.c0.setOnClickListener(obj2.A0);
            obj2.h0.setOnClickListener(obj2.v0);
            obj2.i0.setOnClickListener(obj2.u0);
            obj2.j0.setOnClickListener(obj2.I0);
            obj2.k0.setOnClickListener(obj2.D0);
            obj2.l0.setOnClickListener(obj2.L0);
        }
        long l16 = l & 384L;
        long l20 = 0L;
        if (obj2.S != l20) {
            obj2.Q.setVisibility(cmp);
            obj2.R.setVisibility(cmp);
            g.c(obj2.q0, i6);
        }
        l5 = l & 385L;
        if (obj2.S != l20) {
            obj2.T.setVisibility(cmp);
            g.c(obj2.s0, i8);
            obj2.i0.setVisibility(cmp);
            obj2.l0.setVisibility(cmp);
        }
        l6 = 386L & l;
        long l8 = 0L;
        if (obj2.S != l8) {
            y yVar4 = i4;
            BindingAdapters.setTrainerAvatar(obj2.p0, yVar4);
            BindingAdapters.z0(obj2.a0, yVar4);
        }
        long l17 = 392L & l;
        if (obj2.S != l8) {
            BindingAdapters.x0(obj2.p0, yVar5);
        }
        l7 = 404L & l;
        if (obj2.S != l8) {
            BindingAdapters.setAdapter(obj2.V, yVar, yVar2, null);
        }
        l &= 424;
        if (obj2.M0 != l8) {
            SettingsBindingAdapters.c(obj2.d0, yVar5, obj2.e0, obj2.j0, obj2.m0, obj2.o0, obj2.f0, obj2.g0);
        }
        ViewDataBinding.o(obj2.r0);
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.M0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.r0.y()) {
            return true;
        }
        return false;
    }

    private lg(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 5, (RelativeLayout)objectArr[15], (RelativeLayout)objectArr[1], (TextView)objectArr[32], (RelativeLayout)objectArr[12], (RelativeLayout)objectArr[13], (RelativeLayout)objectArr[9], (RelativeLayout)objectArr[2], (TextView)objectArr[27], (RelativeLayout)objectArr[5], (FrameLayout)objectArr[23], (RelativeLayout)objectArr[17], (RelativeLayout)objectArr[18], (RelativeLayout)objectArr[20], (RelativeLayout)objectArr[19], (LinearLayout)objectArr[22], (RelativeLayout)objectArr[16], (RelativeLayout)objectArr[8], (RelativeLayout)objectArr[10], (SwitchCompat)objectArr[29], (CircularProgressIndicator)objectArr[30], (TextView)objectArr[31], (TextView)objectArr[28], (RelativeLayout)objectArr[6], (RelativeLayout)objectArr[7], (ScrollView)objectArr[25], (RelativeLayout)objectArr[11], (RelativeLayout)objectArr[14], (RelativeLayout)objectArr[3], (MaterialToolbar)objectArr[26], (TextView)objectArr[33]);
        Object eVar4 = this;
        eVar4.M0 = -1L;
        Object obj4 = null;
        eVar4.O.setTag(obj4);
        eVar4.P.setTag(obj4);
        eVar4.Q.setTag(obj4);
        eVar4.R.setTag(obj4);
        eVar4.S.setTag(obj4);
        eVar4.T.setTag(obj4);
        eVar4.U.setTag(obj4);
        Object obj = objectArr[0];
        eVar4.p0 = obj;
        obj.setTag(obj4);
        Object obj2 = objectArr[21];
        eVar4.q0 = obj2;
        obj2.setTag(obj4);
        Object obj3 = objectArr[24];
        eVar4.r0 = obj3;
        eVar4.L(obj3);
        int i5 = 4;
        Object obj5 = objectArr[i5];
        eVar4.s0 = obj5;
        obj5.setTag(obj4);
        eVar4.V.setTag(obj4);
        eVar4.W.setTag(obj4);
        eVar4.X.setTag(obj4);
        eVar4.Y.setTag(obj4);
        eVar4.Z.setTag(obj4);
        eVar4.a0.setTag(obj4);
        eVar4.b0.setTag(obj4);
        eVar4.c0.setTag(obj4);
        eVar4.d0.setTag(obj4);
        eVar4.h0.setTag(obj4);
        eVar4.i0.setTag(obj4);
        eVar4.j0.setTag(obj4);
        eVar4.k0.setTag(obj4);
        eVar4.l0.setTag(obj4);
        eVar4.N(view);
        eVar4.t0 = new b(eVar4, 10);
        eVar4.u0 = new b(eVar4, 6);
        eVar4.v0 = new b(eVar4, 5);
        eVar4.w0 = new b(eVar4, 18);
        eVar4.x0 = new b(eVar4, 14);
        eVar4.y0 = new b(eVar4, 11);
        eVar4.z0 = new b(eVar4, 19);
        eVar4.A0 = new b(eVar4, 7);
        eVar4.B0 = new b(eVar4, 1);
        eVar4.C0 = new b(eVar4, 15);
        eVar4.D0 = new b(eVar4, 12);
        eVar4.E0 = new b(eVar4, 8);
        eVar4.F0 = new b(eVar4, 16);
        eVar4.G0 = new b(eVar4, 2);
        eVar4.H0 = new b(eVar4, 13);
        eVar4.I0 = new b(eVar4, 9);
        eVar4.J0 = new b(eVar4, i5);
        eVar4.K0 = new b(eVar4, 17);
        eVar4.L0 = new b(eVar4, 3);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public void W(l lVar) {
    }
}
