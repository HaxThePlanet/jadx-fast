package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.a;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.a0.g.f.d0;
import app.dogo.com.dogo_android.l.a.a;
import app.dogo.com.dogo_android.l.a.a.a;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.g0.a;

/* loaded from: classes.dex */
public class h8 extends app.dogo.com.dogo_android.h.g8 implements b.a, a.a {

    private static final ViewDataBinding.g q0;
    private static final SparseIntArray r0;
    private final ConstraintLayout c0;
    private final FrameLayout d0;
    private final app.dogo.com.dogo_android.h.gi e0;
    private final FrameLayout f0;
    private final app.dogo.com.dogo_android.h.ok g0;
    private final LinearLayout h0;
    private final TextView i0;
    private final TextView j0;
    private final TextView k0;
    private final RelativeLayout l0;
    private final View.OnClickListener m0;
    private final View.OnClickListener n0;
    private final CompoundButton.OnCheckedChangeListener o0;
    private long p0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(22);
        h8.q0 = gVar;
        String str = "cell_challenge_details_tab";
        int i6 = 3;
        int[] iArr3 = new int[i6];
        iArr3 = new int[]{16, 17, 18};
        int[] iArr = new int[i6];
        iArr = new int[]{2131558465, 2131558465, 2131558465};
        gVar.a(2, /* result */, iArr3, iArr);
        int i7 = 1;
        int[] iArr4 = new int[i7];
        final int i17 = 0;
        iArr4[i17] = 15;
        int[] iArr7 = new int[i7];
        iArr7[i17] = 2131558809;
        gVar.a(7, /* result */, iArr4, iArr7);
        int[] iArr5 = new int[i7];
        iArr5[i17] = 19;
        int[] iArr8 = new int[i7];
        iArr8[i17] = 2131558745;
        gVar.a(11, /* result */, iArr5, iArr8);
        int[] iArr6 = new int[i7];
        iArr6[i17] = 20;
        int[] iArr2 = new int[i7];
        iArr2[i17] = 2131558775;
        gVar.a(12, /* result */, iArr6, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        h8.r0 = sparseIntArray;
        sparseIntArray.put(2131362544, 13);
        sparseIntArray.put(2131362002, 14);
        sparseIntArray.put(2131363182, 21);
    }

    public h8(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 22, h8.q0, h8.r0));
    }

    private h8(e e, View view2, Object[] object3Arr3) {
        Object obj37 = this;
        super(e, view2, 7, (View)object3Arr3[14], (ImageView)object3Arr3[3], (CheckBox)object3Arr3[9], (FrameLayout)object3Arr3[11], (View)object3Arr3[13], (o0)object3Arr3[18], (o0)object3Arr3[16], (o0)object3Arr3[17], (ScrollView)object3Arr3[21], (FrameLayout)object3Arr3[7], (MaterialToolbar)object3Arr3[1], (um)object3Arr3[15]);
        Object obj20 = this;
        obj20.p0 = -1;
        int i18 = 0;
        obj20.P.setTag(i18);
        obj20.Q.setTag(i18);
        obj20.R.setTag(i18);
        Object obj14 = object3Arr3[0];
        obj20.c0 = (ConstraintLayout)obj14;
        obj14.setTag(i18);
        Object obj15 = object3Arr3[10];
        obj20.d0 = (FrameLayout)obj15;
        obj15.setTag(i18);
        Object obj16 = object3Arr3[19];
        obj20.e0 = (gi)obj16;
        obj20.L(obj16);
        Object obj17 = object3Arr3[12];
        obj20.f0 = (FrameLayout)obj17;
        obj17.setTag(i18);
        Object obj18 = object3Arr3[20];
        obj20.g0 = (ok)obj18;
        obj20.L(obj18);
        int i17 = 2;
        Object obj21 = object3Arr3[i17];
        obj20.h0 = (LinearLayout)obj21;
        obj21.setTag(i18);
        Object obj22 = object3Arr3[4];
        obj20.i0 = (TextView)obj22;
        obj22.setTag(i18);
        Object obj23 = object3Arr3[5];
        obj20.j0 = (TextView)obj23;
        obj23.setTag(i18);
        Object obj24 = object3Arr3[6];
        obj20.k0 = (TextView)obj24;
        obj24.setTag(i18);
        Object obj25 = object3Arr3[8];
        obj20.l0 = (RelativeLayout)obj25;
        obj25.setTag(i18);
        obj20.L(obj20.T);
        obj20.L(obj20.U);
        obj20.L(obj20.V);
        obj20.X.setTag(i18);
        obj20.Y.setTag(i18);
        obj20.L(obj20.Z);
        obj20.N(view2);
        b bVar = new b(obj20, 3);
        obj20.m0 = bVar;
        b bVar2 = new b(obj20, 1);
        obj20.n0 = bVar2;
        a aVar = new a(obj20, i17);
        obj20.o0 = aVar;
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.o0 o0, int i2) {
        if (i2 == 0) {
            this.p0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.p0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(app.dogo.com.dogo_android.h.o0 o0, int i2) {
        if (i2 == 0) {
            this.p0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.p0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(app.dogo.com.dogo_android.h.o0 o0, int i2) {
        if (i2 == 0) {
            this.p0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.p0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(app.dogo.com.dogo_android.h.um um, int i2) {
        if (i2 == 0) {
            this.p0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.p0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(d0 d0, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.p0 = l6 |= i18;
            return obj5;
            synchronized (this) {
                this.p0 = l6 |= i18;
                return obj5;
            }
        }
        if (i2 == 148) {
            this.p0 = l5 |= i17;
            return obj5;
            synchronized (this) {
                this.p0 = l5 |= i17;
                return obj5;
            }
        }
        if (i2 == 76) {
            this.p0 = l |= i13;
            return obj5;
            synchronized (this) {
                this.p0 = l |= i13;
                return obj5;
            }
        }
        if (i2 == 20) {
            this.p0 = l2 |= i14;
            return obj5;
            synchronized (this) {
                this.p0 = l2 |= i14;
                return obj5;
            }
        }
        if (i2 == 168) {
            this.p0 = l3 |= i15;
            return obj5;
            synchronized (this) {
                this.p0 = l3 |= i15;
                return obj5;
            }
        }
        if (i2 == 26) {
            this.p0 = l4 |= i16;
            return obj5;
            synchronized (this) {
                this.p0 = l4 |= i16;
                return obj5;
            }
        }
        return 0;
    }

    private boolean c0(a a, int i2) {
        if (i2 == 0) {
            this.p0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.p0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean d0(LiveData<y<Boolean>> liveData, int i2) {
        if (i2 == 0) {
            this.p0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.p0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public void A() {
        this.p0 = 8192;
        this.Z.A();
        this.U.A();
        this.V.A();
        this.T.A();
        this.e0.A();
        this.g0.A();
        I();
        return;
        synchronized (this) {
            this.p0 = 8192;
            this.Z.A();
            this.U.A();
            this.V.A();
            this.T.A();
            this.e0.A();
            this.g0.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g8
    protected boolean E(int i, Object object2, int i3) {
        switch (i) {
            case 0:
                return Y((o0)object2, i3);
            case 1:
                return b0((d0)object2, i3);
            case 2:
                return c0((a)object2, i3);
            case 3:
                return X((o0)object2, i3);
            case 4:
                return Z((o0)object2, i3);
            case 5:
                return a0((um)object2, i3);
            case 6:
                return d0((LiveData)object2, i3);
            default:
                return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public void M(q q) {
        super.M(q);
        this.Z.M(q);
        this.U.M(q);
        this.V.M(q);
        this.T.M(q);
        this.e0.M(q);
        this.g0.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            W((d0)object2);
            obj2 = 1;
        } else {
            if (116 == i) {
                V((a0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public void V(a0 a0) {
        this.b0 = a0;
        this.p0 = l |= i2;
        notifyPropertyChanged(116);
        super.I();
        return;
        synchronized (this) {
            this.b0 = a0;
            this.p0 = l |= i2;
            notifyPropertyChanged(116);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public void W(d0 d0) {
        R(1, d0);
        this.a0 = d0;
        this.p0 = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(1, d0);
            this.a0 = d0;
            this.p0 = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public final void b(int i, View view2) {
        a0 a0Var;
        d0 obj3;
        int obj4;
        obj4 = 0;
        final int i2 = 1;
        if (i != i2) {
            if (i != 3) {
            } else {
                obj3 = this.a0;
                if (obj3 != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    obj3.b0(this.b0);
                }
            }
        } else {
            obj3 = this.a0;
            if (obj3 != null) {
                obj4 = i2;
            }
            if (obj4 != null) {
                obj3.c0(this.b0);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public final void c(int i, CompoundButton compoundButton2, boolean z3) {
        int obj2;
        final d0 obj1 = this.a0;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.d0(z3);
        }
    }

    @Override // app.dogo.com.dogo_android.h.g8
    protected void m() {
        int i7;
        int cmp9;
        int cmp10;
        int cmp6;
        int cmp4;
        int cmp7;
        int cmp;
        int cmp3;
        int i14;
        long l;
        int i8;
        int i31;
        int i5;
        int value;
        int i25;
        int i9;
        int i24;
        int i3;
        int cmp8;
        int cmp2;
        int i10;
        int i17;
        int i26;
        int i16;
        int i15;
        int i22;
        int i11;
        int cmp11;
        int i18;
        int i27;
        int i28;
        int i4;
        int i23;
        int i13;
        int i12;
        int i21;
        int i;
        int cmp5;
        int i29;
        int i30;
        int i2;
        int i19;
        int i6;
        int i20;
        final Object obj = this;
        l = obj.p0;
        final int i33 = 0;
        obj.p0 = i33;
        d0 d0Var = obj.a0;
        final int i51 = 12290;
        int i52 = 9218;
        final int i55 = 8194;
        final int i49 = 0;
        synchronized (this) {
            obj = this;
            l = obj.p0;
            i33 = 0;
            obj.p0 = i33;
            d0Var = obj.a0;
            i51 = 12290;
            i52 = 9218;
            i55 = 8194;
            i49 = 0;
        }
        int cmp13 = Long.compare(i56, i33);
        i27 = 8;
        if (cmp13 != 0) {
            if (d0Var != null) {
                try {
                    i28 = d0Var.S();
                    i28 = 0;
                    if (cmp13 != 0) {
                    }
                    if (i28 != 0) {
                    } else {
                    }
                    i4 = 134217728;
                    i4 = 67108864;
                    l |= i4;
                }
                if (i28 != 0) {
                    i5 = 0;
                } else {
                    i5 = i27;
                }
            } else {
            }
        } else {
        }
        int cmp16 = Long.compare(i57, i33);
        if (cmp16 != 0) {
            if (d0Var != null) {
                i4 = d0Var.Q();
                i23 = d0Var.H();
                i13 = d0Var.O();
                i12 = d0Var.F();
                i21 = d0Var.I();
            } else {
                i12 = i13;
                i4 = 0;
                i21 = 0;
            }
            if (cmp16 != 0) {
                i = i4 != 0 ? 33554432 : 0x01000000 /* Unknown resource */;
                l |= i;
            }
            if (Long.compare(i, i33) != 0) {
                i = i21 != 0 ? 131072 : 65536;
                l |= i;
            }
            i28 = i4 != 0 ? i27 : 0;
            if (i21 != 0) {
                i4 = 0;
            } else {
                i4 = i27;
            }
        } else {
            i12 = i13;
            i28 = 0;
        }
        int cmp18 = Long.compare(i58, i33);
        if (cmp18 != 0) {
            if (d0Var != null) {
                i = d0Var.R();
            } else {
                i = 0;
            }
            if (cmp18 != 0) {
                cmp5 = i != 0 ? 32768 : 16384;
                l |= cmp5;
            }
            if (i != 0) {
                i21 = 0;
            } else {
                i21 = i27;
            }
        } else {
        }
        int cmp19 = Long.compare(i59, i33);
        if (cmp19 != 0) {
            if (d0Var != null) {
                cmp5 = d0Var.W();
            } else {
                cmp5 = 0;
            }
            if (cmp19 != 0) {
                i29 = cmp5 != 0 ? 524288 : 262144;
                l |= i29;
            }
            if (cmp5 != 0) {
                i = 0;
            } else {
                i = i27;
            }
        } else {
        }
        if (Long.compare(i60, i33) != 0) {
            if (d0Var != null) {
                i16 = cmp5;
            } else {
                i16 = i49;
            }
            obj.R(2, i16);
        } else {
            i16 = i49;
        }
        int cmp15 = Long.compare(i50, i33);
        if (cmp15 != 0) {
            if (d0Var != null) {
                cmp11 = d0Var.X();
            } else {
                cmp11 = 0;
            }
            if (cmp15 != 0) {
                i30 = cmp11 != 0 ? 2097152 : 1048576;
                l |= i30;
            }
            if (cmp11 != 0) {
                i11 = 0;
            } else {
                i11 = i27;
            }
        } else {
        }
        if (Long.compare(i30, i33) != 0) {
            if (d0Var != null) {
                i25 = cmp11;
            } else {
                i25 = i49;
            }
            obj.Q(6, i25);
            if (i25 != 0) {
                value = i25.getValue();
            } else {
                value = i49;
            }
        } else {
        }
        int cmp14 = Long.compare(i2, i33);
        if (cmp14 != 0) {
            if (d0Var != null) {
                i14 = d0Var.V();
            } else {
                i14 = 0;
            }
            if (cmp14 != 0) {
                i2 = i14 != 0 ? 8388608 : 4194304;
                l |= i2;
            }
            cmp5 = i14 != 0 ? 0 : i27;
            i9 = i5;
            i19 = i16;
            i20 = i11;
            i7 = i28;
            i8 = i4;
            i10 = i23;
            i17 = i13;
            i3 = i12;
            i26 = i21;
            i6 = i;
            i15 = cmp5;
        } else {
            i9 = i5;
            i19 = i16;
            i20 = i11;
            i7 = i28;
            i8 = i4;
            i10 = i23;
            i17 = i13;
            i3 = i12;
            i26 = i21;
            i6 = i;
            i15 = 0;
        }
        if (Long.compare(i53, i33) != 0) {
            obj.O.setVisibility(i26);
        }
        if (Long.compare(i54, i33) != 0) {
            n.w(obj.P, i10);
            obj.i0.setVisibility(i7);
            g.c(obj.j0, i17);
            g.c(obj.k0, i3);
            obj.l0.setVisibility(i8);
            obj.Y.setTitle(i17);
        }
        if (Long.compare(i46, i33) != 0) {
            a.b(obj.Q, obj.o0, i49);
            obj.R.setOnClickListener(obj.m0);
            obj.X.setOnClickListener(obj.n0);
        }
        if (Long.compare(i47, i33) != 0) {
            obj.R.setVisibility(i9);
            obj.d0.setVisibility(i9);
        }
        if (Long.compare(i41, i33) != 0) {
            obj.S.setVisibility(i15);
        }
        if (Long.compare(i43, i33) != 0) {
            n.F0(obj.c0, value);
            n.D0(obj.f0, value);
        }
        if (Long.compare(i37, i33) != 0) {
            obj.e0.T(i19);
        }
        if (Long.compare(i31, i33) != 0) {
            i31 = i6;
            obj.U.w().setVisibility(i31);
            obj.X.setVisibility(i31);
        }
        if (Long.compare(i32, i33) != 0) {
            obj.Z.w().setVisibility(i20);
        }
        ViewDataBinding.o(obj.Z);
        ViewDataBinding.o(obj.U);
        ViewDataBinding.o(obj.V);
        ViewDataBinding.o(obj.T);
        ViewDataBinding.o(obj.e0);
        ViewDataBinding.o(obj.g0);
    }

    @Override // app.dogo.com.dogo_android.h.g8
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.Z.y()) {
                }
                return i2;
                if (this.U.y()) {
                }
                return i2;
                if (this.V.y()) {
                }
                return i2;
                if (this.T.y()) {
                }
                return i2;
                if (this.e0.y()) {
                }
                return i2;
            }
            return i2;
        }
    }
}
