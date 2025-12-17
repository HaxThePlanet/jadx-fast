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
import androidx.databinding.a;
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
import f.d.a.a;

/* loaded from: classes.dex */
public class lg extends app.dogo.com.dogo_android.h.kg implements b.a {

    private static final ViewDataBinding.g N0;
    private static final SparseIntArray O0;
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
    private final app.dogo.com.dogo_android.h.ml r0;
    private final TextView s0;
    private final View.OnClickListener t0;
    private final View.OnClickListener u0;
    private final View.OnClickListener v0;
    private final View.OnClickListener w0;
    private final View.OnClickListener x0;
    private final View.OnClickListener y0;
    private final View.OnClickListener z0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(34);
        lg.N0 = gVar;
        int i11 = 1;
        final int[] iArr2 = new int[i11];
        final int i24 = 0;
        iArr2[i24] = 24;
        int[] iArr = new int[i11];
        iArr[i24] = 2131558788;
        gVar.a(23, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        lg.O0 = sparseIntArray;
        sparseIntArray.put(2131363185, 25);
        sparseIntArray.put(2131363433, 26);
        sparseIntArray.put(2131362753, 27);
        sparseIntArray.put(2131363054, 28);
        sparseIntArray.put(2131363050, 29);
        sparseIntArray.put(2131363052, 30);
        sparseIntArray.put(2131363053, 31);
        sparseIntArray.put(2131362271, 32);
        sparseIntArray.put(2131363464, 33);
    }

    public lg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 34, lg.N0, lg.O0));
    }

    private lg(e e, View view2, Object[] object3Arr3) {
        Object obj7 = this;
        super(e, view2, 5, (RelativeLayout)object3Arr3[15], (RelativeLayout)object3Arr3[1], (TextView)object3Arr3[32], (RelativeLayout)object3Arr3[12], (RelativeLayout)object3Arr3[13], (RelativeLayout)object3Arr3[9], (RelativeLayout)object3Arr3[2], (TextView)object3Arr3[27], (RelativeLayout)object3Arr3[5], (FrameLayout)object3Arr3[23], (RelativeLayout)object3Arr3[17], (RelativeLayout)object3Arr3[18], (RelativeLayout)object3Arr3[20], (RelativeLayout)object3Arr3[19], (LinearLayout)object3Arr3[22], (RelativeLayout)object3Arr3[16], (RelativeLayout)object3Arr3[8], (RelativeLayout)object3Arr3[10], (SwitchCompat)object3Arr3[29], (CircularProgressIndicator)object3Arr3[30], (TextView)object3Arr3[31], (TextView)object3Arr3[28], (RelativeLayout)object3Arr3[6], (RelativeLayout)object3Arr3[7], (ScrollView)object3Arr3[25], (RelativeLayout)object3Arr3[11], (RelativeLayout)object3Arr3[14], (RelativeLayout)object3Arr3[3], (MaterialToolbar)object3Arr3[26], (TextView)object3Arr3[33]);
        Object obj6 = this;
        obj6.M0 = -1;
        int i6 = 0;
        obj6.O.setTag(i6);
        obj6.P.setTag(i6);
        obj6.Q.setTag(i6);
        obj6.R.setTag(i6);
        obj6.S.setTag(i6);
        obj6.T.setTag(i6);
        obj6.U.setTag(i6);
        Object obj2 = object3Arr3[0];
        obj6.p0 = (ConstraintLayout)obj2;
        obj2.setTag(i6);
        Object obj3 = object3Arr3[21];
        obj6.q0 = (TextView)obj3;
        obj3.setTag(i6);
        Object obj4 = object3Arr3[24];
        obj6.r0 = (ml)obj4;
        obj6.L(obj4);
        int i5 = 4;
        Object obj8 = object3Arr3[i5];
        obj6.s0 = (TextView)obj8;
        obj8.setTag(i6);
        obj6.V.setTag(i6);
        obj6.W.setTag(i6);
        obj6.X.setTag(i6);
        obj6.Y.setTag(i6);
        obj6.Z.setTag(i6);
        obj6.a0.setTag(i6);
        obj6.b0.setTag(i6);
        obj6.c0.setTag(i6);
        obj6.d0.setTag(i6);
        obj6.h0.setTag(i6);
        obj6.i0.setTag(i6);
        obj6.j0.setTag(i6);
        obj6.k0.setTag(i6);
        obj6.l0.setTag(i6);
        obj6.N(view2);
        b bVar3 = new b(obj6, 10);
        obj6.t0 = bVar3;
        b bVar4 = new b(obj6, 6);
        obj6.u0 = bVar4;
        b bVar5 = new b(obj6, 5);
        obj6.v0 = bVar5;
        b bVar6 = new b(obj6, 18);
        obj6.w0 = bVar6;
        b bVar7 = new b(obj6, 14);
        obj6.x0 = bVar7;
        b bVar8 = new b(obj6, 11);
        obj6.y0 = bVar8;
        b bVar9 = new b(obj6, 19);
        obj6.z0 = bVar9;
        b bVar10 = new b(obj6, 7);
        obj6.A0 = bVar10;
        b bVar11 = new b(obj6, 1);
        obj6.B0 = bVar11;
        b bVar12 = new b(obj6, 15);
        obj6.C0 = bVar12;
        b bVar13 = new b(obj6, 12);
        obj6.D0 = bVar13;
        b bVar14 = new b(obj6, 8);
        obj6.E0 = bVar14;
        b bVar15 = new b(obj6, 16);
        obj6.F0 = bVar15;
        b bVar16 = new b(obj6, 2);
        obj6.G0 = bVar16;
        b bVar17 = new b(obj6, 13);
        obj6.H0 = bVar17;
        b bVar18 = new b(obj6, 9);
        obj6.I0 = bVar18;
        b bVar19 = new b(obj6, i5);
        obj6.J0 = bVar19;
        b bVar = new b(obj6, 17);
        obj6.K0 = bVar;
        b bVar2 = new b(obj6, 3);
        obj6.L0 = bVar2;
        A();
    }

    private boolean Y(x<e0> x, int i2) {
        if (i2 == 0) {
            this.M0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.M0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(a<y<Boolean>> a, int i2) {
        if (i2 == 0) {
            this.M0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.M0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(a<y<Boolean>> a, int i2) {
        if (i2 == 0) {
            this.M0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.M0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(x<y<SettingsResults>> x, int i2) {
        if (i2 == 0) {
            this.M0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.M0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean c0(x<y<RemindersModel>> x, int i2) {
        if (i2 == 0) {
            this.M0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.M0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public void A() {
        this.M0 = 256;
        this.r0.A();
        I();
        return;
        synchronized (this) {
            this.M0 = 256;
            this.r0.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kg
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3 && i != 4) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return 0;
                        }
                        return Z((a)object2, i3);
                    }
                    return c0((x)object2, i3);
                }
                return a0((a)object2, i3);
            }
            return b0((x)object2, i3);
        }
        return Y((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public void M(q q) {
        super.M(q);
        this.r0.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((b0)object2);
            obj2 = 1;
        } else {
            if (141 == i) {
                W((l)object2);
            } else {
                if (177 == i) {
                    X((f0)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public void V(b0 b0) {
        this.o0 = b0;
        this.M0 = m0 |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.o0 = b0;
            this.M0 = m0 |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public void W(l l) {
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public void X(f0 f0) {
        this.n0 = f0;
        this.M0 = m0 |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.n0 = f0;
            this.M0 = m0 |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public final void b(int i, View view2) {
        int i3;
        f0 obj3;
        int obj4;
        final int i4 = 0;
        switch (i) {
            case 1:
                obj3 = this.n0;
                obj4 = i4;
                obj3.l();
                break;
            case 2:
                obj3 = this.n0;
                obj4 = i4;
                obj3.a0();
                break;
            case 3:
                obj3 = this.n0;
                obj4 = i4;
                obj3.Z();
                break;
            case 4:
                obj3 = this.n0;
                i3 = obj4;
                i3 = i4;
                i3 = obj3.M();
                obj4 = i4;
                obj3.j0((y)i3.getValue());
                break;
            case 5:
                obj3 = this.n0;
                obj4 = i4;
                obj3.g0();
                break;
            case 6:
                obj3 = this.n0;
                obj4 = i4;
                obj3.h0();
                break;
            case 7:
                obj3 = this.n0;
                obj4 = i4;
                obj3.d0();
                break;
            case 8:
                obj3 = this.n0;
                obj4 = i4;
                obj3.k();
                break;
            case 9:
                obj3 = this.n0;
                obj4 = i4;
                obj3.f0();
                break;
            case 10:
                obj3 = this.n0;
                obj4 = i4;
                obj3.q();
                break;
            case 11:
                obj3 = this.n0;
                obj4 = i4;
                obj3.R();
                break;
            case 12:
                obj3 = this.n0;
                obj4 = i4;
                obj3.T();
                break;
            case 13:
                obj3 = this.n0;
                obj4 = i4;
                obj3.m();
                break;
            case 14:
                obj3 = this.n0;
                obj4 = i4;
                obj3.c0();
                break;
            case 15:
                obj3 = this.n0;
                obj4 = i4;
                obj3.p();
                break;
            case 16:
                obj3 = this.n0;
                obj4 = i4;
                obj3.S();
                break;
            case 17:
                obj3 = this.n0;
                obj4 = i4;
                obj3.p0();
                break;
            case 18:
                obj3 = this.n0;
                obj4 = i4;
                obj3.k0();
                break;
            case 19:
                obj3 = this.n0;
                obj4 = i4;
                obj3.o();
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.kg
    protected void m() {
        int i31;
        int cmp;
        int cmp2;
        int cmp8;
        int cmp4;
        int f0Var;
        long l;
        int i25;
        int i24;
        int i20;
        int cmp5;
        int i26;
        int i16;
        int i21;
        View.OnClickListener list;
        int i29;
        int i2;
        int i32;
        int i8;
        int value3;
        boolean z2;
        int i28;
        int i5;
        int i15;
        int i10;
        int i18;
        int value;
        int i3;
        int value2;
        int i6;
        x i9;
        Object value4;
        int i19;
        int i13;
        int cmp7;
        int cmp6;
        int i22;
        Object purchaseRestored;
        int i11;
        int i30;
        int i;
        int cmp3;
        x xVar;
        int i23;
        boolean z;
        String str;
        int i27;
        int i4;
        int i14;
        int i12;
        int i7;
        int i17;
        final Object obj = this;
        l = obj.M0;
        i20 = 0;
        obj.M0 = i20;
        f0Var = obj.n0;
        int i45 = 384;
        final int i47 = 385;
        i5 = 0;
        synchronized (this) {
            obj = this;
            l = obj.M0;
            i20 = 0;
            obj.M0 = i20;
            f0Var = obj.n0;
            i45 = 384;
            i47 = 385;
            i5 = 0;
        }
        int cmp11 = Long.compare(i50, i20);
        int i51 = 8;
        if (cmp11 != 0) {
            if (f0Var != null) {
                try {
                    i11 = f0Var.o0();
                    i = f0Var.V();
                    i = i5;
                    i11 = 0;
                    if (cmp11 != 0) {
                    }
                    if (i != 0) {
                    } else {
                    }
                    l |= i54;
                    cmp3 = 262144;
                    l |= i53;
                    cmp3 = 131072;
                    i24 |= cmp3;
                }
                i2 = i != 0 ? i51 : i5;
                i30 = i != 0 ? i5 : i51;
            } else {
            }
        } else {
            i30 = i2;
            i11 = 0;
        }
        cmp3 = Long.compare(i52, i20);
        if (cmp3 != 0) {
            if (f0Var != null) {
                i8 = xVar;
            } else {
                i8 = 0;
            }
            obj.Q(i5, i8);
            if (i8 != 0) {
                value3 = i8.getValue();
            } else {
                value3 = 0;
            }
            if (value3 != null) {
                z = value3.b();
                str = value3.c();
                z2 = value3.a();
            } else {
                z = z2;
                str = 0;
            }
            if (cmp3 != 0) {
                if (z) {
                    l |= i56;
                    i27 = 16384;
                } else {
                    l |= i55;
                    i27 = 8192;
                }
                i25 |= i27;
            }
            if (Long.compare(i27, i20) != 0) {
                i27 = z2 ? 65536 : 32768;
                l |= i27;
            }
            cmp3 = z ? i5 : i51;
            i23 = z ? i51 : i5;
            if (z2) {
            } else {
                i5 = i51;
            }
            i28 = i5;
            i5 = cmp3;
        } else {
            i23 = i28;
            str = 0;
        }
        if (Long.compare(i27, i20) != 0) {
            if (f0Var != null) {
                i9 = purchaseRestored;
            } else {
                i9 = 0;
            }
            obj.Q(1, i9);
            if (i9 != null) {
                value4 = i9.getValue();
            } else {
                value4 = 0;
            }
        } else {
        }
        if (Long.compare(i4, i20) != 0) {
            if (f0Var != null) {
                cmp7 = f0Var.t();
                i18 = purchaseRestored;
            } else {
                i18 = 0;
                cmp7 = 0;
            }
            obj.Q(2, cmp7);
            obj.Q(4, i18);
            if (cmp7 != 0) {
                value2 = cmp7.getValue();
            } else {
                value2 = 0;
            }
            if (i18 != 0) {
                value = i18.getValue();
            } else {
                value = 0;
            }
        } else {
            value = 0;
            value2 = 0;
        }
        if (Long.compare(i14, i20) != 0) {
            if (f0Var != null) {
                f0Var = f0Var.P();
            } else {
                f0Var = 0;
            }
            obj.Q(3, f0Var);
            if (f0Var != 0) {
                i19 = value2;
                i12 = value4;
                i7 = i11;
                i17 = str;
                i3 = i5;
                i6 = value;
                i5 = i2;
                i10 = i28;
                i29 = i23;
                i32 = value5;
                i31 = i30;
            } else {
                i19 = value2;
                i12 = value4;
                i7 = i11;
                i31 = i30;
                i17 = str;
                i3 = i5;
                i6 = value;
                i5 = i2;
                i10 = i28;
                i29 = i23;
                i32 = 0;
            }
        } else {
        }
        if (Long.compare(i49, i20) != 0) {
            obj.O.setOnClickListener(obj.H0);
            obj.P.setOnClickListener(obj.B0);
            obj.Q.setOnClickListener(obj.t0);
            obj.R.setOnClickListener(obj.y0);
            obj.S.setOnClickListener(obj.E0);
            obj.T.setOnClickListener(obj.G0);
            obj.U.setOnClickListener(obj.J0);
            obj.q0.setOnClickListener(obj.z0);
            obj.W.setOnClickListener(obj.C0);
            obj.X.setOnClickListener(obj.F0);
            obj.Y.setOnClickListener(obj.w0);
            obj.Z.setOnClickListener(obj.K0);
            obj.b0.setOnClickListener(obj.x0);
            obj.c0.setOnClickListener(obj.A0);
            obj.h0.setOnClickListener(obj.v0);
            obj.i0.setOnClickListener(obj.u0);
            obj.j0.setOnClickListener(obj.I0);
            obj.k0.setOnClickListener(obj.D0);
            obj.l0.setOnClickListener(obj.L0);
        }
        int i46 = 0;
        if (Long.compare(i34, i46) != 0) {
            obj.Q.setVisibility(i5);
            obj.R.setVisibility(i31);
            g.c(obj.q0, i7);
        }
        if (Long.compare(i26, i46) != 0) {
            obj.T.setVisibility(i29);
            g.c(obj.s0, i17);
            obj.i0.setVisibility(i10);
            obj.l0.setVisibility(i3);
        }
        i15 = 0;
        if (Long.compare(i16, i15) != 0) {
            i16 = i12;
            n.F0(obj.p0, i16);
            n.z0(obj.a0, i16);
        }
        if (Long.compare(i37, i15) != 0) {
            n.x0(obj.p0, i32);
        }
        if (Long.compare(i21, i15) != 0) {
            n.E0(obj.V, i6, i19, 0);
        }
        if (Long.compare(i33, i15) != 0) {
            a0.c(obj.d0, i32, obj.e0, obj.j0, obj.m0, obj.o0, obj.f0, obj.g0);
        }
        ViewDataBinding.o(obj.r0);
    }

    @Override // app.dogo.com.dogo_android.h.kg
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.r0.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
