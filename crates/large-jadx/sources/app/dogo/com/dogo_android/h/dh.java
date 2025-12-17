package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.k.a;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.a;
import app.dogo.com.dogo_android.l.a.a.a;
import app.dogo.com.dogo_android.r.l;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: classes.dex */
public class dh extends app.dogo.com.dogo_android.h.ch implements a.a {

    private static final ViewDataBinding.g v0;
    private static final SparseIntArray w0;
    private final CoordinatorLayout e0;
    private final Group f0;
    private final FrameLayout g0;
    private final app.dogo.com.dogo_android.h.ok h0;
    private final Group i0;
    private final TextInputEditText j0;
    private final TextInputEditText k0;
    private final CompoundButton.OnCheckedChangeListener l0;
    private final CompoundButton.OnCheckedChangeListener m0;
    private final CompoundButton.OnCheckedChangeListener n0;
    private final CompoundButton.OnCheckedChangeListener o0;
    private final CompoundButton.OnCheckedChangeListener p0;
    private final CompoundButton.OnCheckedChangeListener q0;
    private final CompoundButton.OnCheckedChangeListener r0;
    private g s0;
    private g t0;
    private long u0;

    class a implements g {

        final app.dogo.com.dogo_android.h.dh a;
        a(app.dogo.com.dogo_android.h.dh dh) {
            this.a = dh;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object lVar;
            int i;
            int i2;
            lVar = dhVar2.c0;
            final int i3 = 0;
            i2 = lVar != null ? i : i3;
            if (i2 != 0) {
                lVar = lVar.s();
                if (lVar != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    lVar.setValue(g.a(dh.X(this.a)));
                }
            }
        }
    }

    class b implements g {

        final app.dogo.com.dogo_android.h.dh a;
        b(app.dogo.com.dogo_android.h.dh dh) {
            this.a = dh;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object lVar;
            int i2;
            int i;
            lVar = dhVar2.c0;
            final int i3 = 0;
            i = lVar != null ? i2 : i3;
            if (i != 0) {
                lVar = lVar.t();
                if (lVar != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    lVar.setValue(g.a(dh.Y(this.a)));
                }
            }
        }
    }
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(34);
        dh.v0 = gVar;
        int i18 = 1;
        final int[] iArr2 = new int[i18];
        final int i38 = 0;
        iArr2[i38] = 17;
        int[] iArr = new int[i18];
        iArr[i38] = 2131558775;
        gVar.a(15, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        dh.w0 = sparseIntArray;
        sparseIntArray.put(2131362227, 18);
        sparseIntArray.put(2131363433, 19);
        sparseIntArray.put(2131362876, 20);
        sparseIntArray.put(2131363560, 21);
        sparseIntArray.put(2131363414, 22);
        sparseIntArray.put(2131363565, 23);
        sparseIntArray.put(2131362615, 24);
        sparseIntArray.put(2131362617, 25);
        sparseIntArray.put(2131362805, 26);
        sparseIntArray.put(2131362616, 27);
        sparseIntArray.put(2131362806, 28);
        sparseIntArray.put(2131362282, 29);
        sparseIntArray.put(2131362156, 30);
        sparseIntArray.put(2131363172, 31);
        sparseIntArray.put(2131362715, 32);
        sparseIntArray.put(2131363161, 33);
    }

    public dh(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 34, dh.v0, dh.w0));
    }

    private dh(e e, View view2, Object[] object3Arr3) {
        app.dogo.com.dogo_android.h.dh dhVar3 = this;
        super(e, view2, 4, (LinearLayout)object3Arr3[30], (ConstraintLayout)object3Arr3[18], (TextView)object3Arr3[29], (TextView)object3Arr3[1], (TextView)object3Arr3[4], (FocusedBorderTextInput)object3Arr3[24], (TextView)object3Arr3[27], (TextView)object3Arr3[25], (Guideline)object3Arr3[32], (FocusedBorderTextInput)object3Arr3[26], (TextView)object3Arr3[28], (NestedScrollView)object3Arr3[20], (Guideline)object3Arr3[33], (MaterialButton)object3Arr3[31], (TextView)object3Arr3[2], (TextView)object3Arr3[3], (TextView)object3Arr3[22], (CheckBox)object3Arr3[7], (CheckBox)object3Arr3[8], (CheckBox)object3Arr3[9], (CheckBox)object3Arr3[10], (CheckBox)object3Arr3[11], (CheckBox)object3Arr3[12], (CheckBox)object3Arr3[13], (MaterialToolbar)object3Arr3[19], (TextView)object3Arr3[21], (TextView)object3Arr3[23]);
        app.dogo.com.dogo_android.h.dh dhVar2 = this;
        dh.a aVar = new dh.a(dhVar2);
        dhVar2.s0 = aVar;
        dh.b bVar = new dh.b(dhVar2);
        dhVar2.t0 = bVar;
        dhVar2.u0 = -1;
        int i8 = 0;
        dhVar2.P.setTag(i8);
        dhVar2.Q.setTag(i8);
        Object obj = object3Arr3[0];
        dhVar2.e0 = (CoordinatorLayout)obj;
        obj.setTag(i8);
        Object obj2 = object3Arr3[14];
        dhVar2.f0 = (Group)obj2;
        obj2.setTag(i8);
        Object obj3 = object3Arr3[15];
        dhVar2.g0 = (FrameLayout)obj3;
        obj3.setTag(i8);
        Object obj4 = object3Arr3[17];
        dhVar2.h0 = (ok)obj4;
        dhVar2.L(obj4);
        Object obj5 = object3Arr3[16];
        dhVar2.i0 = (Group)obj5;
        obj5.setTag(i8);
        int i6 = 5;
        Object obj7 = object3Arr3[i6];
        dhVar2.j0 = (TextInputEditText)obj7;
        obj7.setTag(i8);
        int i14 = 6;
        Object obj9 = object3Arr3[i14];
        dhVar2.k0 = (TextInputEditText)obj9;
        obj9.setTag(i8);
        dhVar2.S.setTag(i8);
        dhVar2.T.setTag(i8);
        dhVar2.U.setTag(i8);
        dhVar2.V.setTag(i8);
        dhVar2.W.setTag(i8);
        dhVar2.X.setTag(i8);
        dhVar2.Y.setTag(i8);
        dhVar2.Z.setTag(i8);
        dhVar2.a0.setTag(i8);
        dhVar2.N(view2);
        a aVar4 = new a(dhVar2, 4);
        dhVar2.l0 = aVar4;
        a aVar5 = new a(dhVar2, 7);
        dhVar2.m0 = aVar5;
        a aVar6 = new a(dhVar2, 1);
        dhVar2.n0 = aVar6;
        a aVar7 = new a(dhVar2, 2);
        dhVar2.o0 = aVar7;
        a aVar8 = new a(dhVar2, i6);
        dhVar2.p0 = aVar8;
        a aVar2 = new a(dhVar2, 3);
        dhVar2.q0 = aVar2;
        a aVar3 = new a(dhVar2, i14);
        dhVar2.r0 = aVar3;
        A();
    }

    static TextInputEditText X(app.dogo.com.dogo_android.h.dh dh) {
        return dh.j0;
    }

    static TextInputEditText Y(app.dogo.com.dogo_android.h.dh dh) {
        return dh.k0;
    }

    private boolean Z(x<String> x, int i2) {
        if (i2 == 0) {
            this.u0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.u0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.u0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.u0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(x<String> x, int i2) {
        if (i2 == 0) {
            this.u0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.u0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean c0(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.u0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.u0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public void A() {
        this.u0 = 64;
        this.h0.A();
        I();
        return;
        synchronized (this) {
            this.u0 = 64;
            this.h0.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ch
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return Z((x)object2, i3);
                }
                return a0((x)object2, i3);
            }
            return c0((x)object2, i3);
        }
        return b0((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public void M(q q) {
        super.M(q);
        this.h0.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (93 == i) {
            V((Boolean)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((l)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public void V(Boolean boolean) {
        this.d0 = boolean;
        this.u0 = l |= i2;
        notifyPropertyChanged(93);
        super.I();
        return;
        synchronized (this) {
            this.d0 = boolean;
            this.u0 = l |= i2;
            notifyPropertyChanged(93);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public void W(l l) {
        this.c0 = l;
        this.u0 = l2 |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.c0 = l;
            this.u0 = l2 |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public final void c(int i, CompoundButton compoundButton2, boolean z3) {
        l obj2;
        int obj3;
        obj3 = 0;
        final int i3 = 1;
        switch (i) {
            case 1:
                obj2 = this.c0;
                obj3 = i3;
                obj2.o(i3, z3);
                break;
            case 2:
                obj2 = this.c0;
                obj3 = i3;
                obj2.o(2, z3);
                break;
            case 3:
                obj2 = this.c0;
                obj3 = i3;
                obj2.o(3, z3);
                break;
            case 4:
                obj2 = this.c0;
                obj3 = i3;
                obj2.o(4, z3);
                break;
            case 5:
                obj2 = this.c0;
                obj3 = i3;
                obj2.o(5, z3);
                break;
            case 6:
                obj2 = this.c0;
                obj3 = i3;
                obj2.o(6, z3);
                break;
            case 7:
                obj2 = this.c0;
                obj3 = i3;
                obj2.o(7, z3);
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.ch
    protected void m() {
        Boolean bool;
        int i2;
        int cmp5;
        int cmp10;
        int cmp;
        long l;
        Object value4;
        x lVar;
        int cmp3;
        int cmp4;
        Object value2;
        int cmp2;
        int value;
        int cmp9;
        int value3;
        int i5;
        int cmp6;
        int i;
        int i3;
        CompoundButton.OnCheckedChangeListener list;
        int cmp7;
        int cmp8;
        Resources resources;
        int i4;
        final Object obj = this;
        l = obj.u0;
        final int i7 = 0;
        obj.u0 = i7;
        lVar = obj.c0;
        int cmp11 = Long.compare(i11, i7);
        i5 = 0;
        synchronized (this) {
            obj = this;
            l = obj.u0;
            i7 = 0;
            obj.u0 = i7;
            lVar = obj.c0;
            cmp11 = Long.compare(i11, i7);
            i5 = 0;
        }
        bool = ViewDataBinding.K(obj.d0);
        if (cmp11 != 0) {
            if (bool) {
                try {
                    i = 256;
                    i = 128;
                    l |= i;
                    if (bool) {
                    } else {
                    }
                    i2 = 8;
                    i2 = i5;
                }
                final int i30 = 98;
                final int i31 = 97;
                int i9 = 0;
                if (Long.compare(i16, i7) != 0) {
                    if (Long.compare(i10, i7) != 0) {
                        if (lVar != null) {
                            cmp2 = lVar.t();
                        } else {
                            cmp2 = i9;
                        }
                        obj.Q(i5, cmp2);
                        if (cmp2 != 0) {
                            value2 = cmp2.getValue();
                        } else {
                            value2 = i9;
                        }
                    } else {
                    }
                    if (Long.compare(i14, i7) != 0) {
                        if (lVar != null) {
                            cmp9 = lVar.u();
                        } else {
                            cmp9 = i9;
                        }
                        obj.Q(1, cmp9);
                        if (cmp9 != 0) {
                            value = cmp9.getValue();
                        } else {
                            value = i9;
                        }
                    } else {
                    }
                    if (Long.compare(i4, i7) != 0) {
                        if (lVar != null) {
                            cmp6 = lVar.v();
                        } else {
                            cmp6 = i9;
                        }
                        obj.Q(2, cmp6);
                        if (cmp6 != 0) {
                            value3 = cmp6.getValue();
                        } else {
                            value3 = i9;
                        }
                    } else {
                    }
                    if (Long.compare(i29, i7) != 0) {
                        if (lVar != null) {
                            lVar = lVar.s();
                        } else {
                            lVar = i9;
                        }
                        obj.Q(3, lVar);
                        if (lVar != null) {
                            value4 = lVar.getValue();
                        } else {
                            value4 = i9;
                        }
                    } else {
                    }
                } else {
                    value3 = value;
                }
                if (Long.compare(i26, i7) != 0) {
                    TextView view4 = obj.P;
                    n.D(view4, view4.getResources().getString(2131887292));
                    TextView view = obj.Q;
                    n.D(view, view.getResources().getString(2131887295));
                    n.P(obj.j0, 24);
                    g.e(obj.j0, i9, i9, i9, obj.s0);
                    n.P(obj.k0, 59);
                    g.e(obj.k0, i9, i9, i9, obj.t0);
                    TextView view2 = obj.S;
                    n.D(view2, view2.getResources().getString(2131887293));
                    TextView view3 = obj.T;
                    n.D(view3, view3.getResources().getString(2131887294));
                    a.b(obj.U, obj.n0, i9);
                    a.b(obj.V, obj.o0, i9);
                    a.b(obj.W, obj.q0, i9);
                    a.b(obj.X, obj.l0, i9);
                    a.b(obj.Y, obj.p0, i9);
                    a.b(obj.Z, obj.r0, i9);
                    a.b(obj.a0, obj.m0, i9);
                }
                if (Long.compare(i17, i7) != 0) {
                    n.x0(obj.e0, value);
                    n.D0(obj.g0, value);
                }
                if (Long.compare(i19, i7) != 0) {
                    obj.f0.setVisibility(i2);
                }
                if (Long.compare(i21, i7) != 0) {
                    n.J0(obj.i0, value3);
                }
                if (Long.compare(i13, i7) != 0) {
                    g.c(obj.j0, value4);
                }
                if (Long.compare(i6, i7) != 0) {
                    g.c(obj.k0, value2);
                }
                ViewDataBinding.o(obj.h0);
            } else {
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ch
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.h0.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
