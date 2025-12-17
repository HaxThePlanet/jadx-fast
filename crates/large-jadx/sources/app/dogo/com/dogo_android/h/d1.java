package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.d.c.j.b;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class d1 extends app.dogo.com.dogo_android.h.c1 {

    private static final ViewDataBinding.g i0;
    private static final SparseIntArray j0;
    private final FrameLayout c0;
    private final LinearLayout d0;
    private final TextView e0;
    private final TextView f0;
    private final FrameLayout g0;
    private long h0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d1.j0 = sparseIntArray;
        sparseIntArray.put(2131363033, 17);
        sparseIntArray.put(2131362582, 18);
        sparseIntArray.put(2131362344, 19);
    }

    public d1(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 20, d1.i0, d1.j0));
    }

    private d1(e e, View view2, Object[] object3Arr3) {
        Object obj9 = this;
        super(e, view2, 0, (ImageView)object3Arr3[13], (ImageView)object3Arr3[10], (ImageView)object3Arr3[7], (ImageView)object3Arr3[12], (RelativeLayout)object3Arr3[11], (RelativeLayout)object3Arr3[19], (ImageView)object3Arr3[2], (ConstraintLayout)object3Arr3[1], (FrameLayout)object3Arr3[18], (ImageView)object3Arr3[16], (TextView)object3Arr3[15], (FrameLayout)object3Arr3[6], (TextView)object3Arr3[14], (RelativeLayout)object3Arr3[17], (ImageView)object3Arr3[9]);
        Object obj8 = this;
        obj8.h0 = -1;
        int i7 = 0;
        obj8.O.setTag(i7);
        obj8.P.setTag(i7);
        obj8.Q.setTag(i7);
        obj8.R.setTag(i7);
        obj8.S.setTag(i7);
        obj8.T.setTag(i7);
        obj8.U.setTag(i7);
        obj8.V.setTag(i7);
        Object obj2 = object3Arr3[0];
        obj8.c0 = (FrameLayout)obj2;
        obj2.setTag(i7);
        Object obj3 = object3Arr3[3];
        obj8.d0 = (LinearLayout)obj3;
        obj3.setTag(i7);
        Object obj4 = object3Arr3[4];
        obj8.e0 = (TextView)obj4;
        obj4.setTag(i7);
        Object obj5 = object3Arr3[5];
        obj8.f0 = (TextView)obj5;
        obj5.setTag(i7);
        Object obj6 = object3Arr3[8];
        obj8.g0 = (FrameLayout)obj6;
        obj6.setTag(i7);
        obj8.W.setTag(i7);
        obj8.X.setTag(i7);
        obj8.Y.setTag(i7);
        obj8.a0.setTag(i7);
        obj8.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c1
    public void A() {
        this.h0 = 2;
        I();
        return;
        synchronized (this) {
            this.h0 = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c1
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.c1
    public boolean O(int i, Object object2) {
        int obj2;
        if (118 == i) {
            V((b)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.c1
    public void V(b b) {
        this.b0 = b;
        this.h0 = l |= i2;
        notifyPropertyChanged(118);
        super.I();
        return;
        synchronized (this) {
            this.b0 = b;
            this.h0 = l |= i2;
            notifyPropertyChanged(118);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c1
    protected void m() {
        int i14;
        long l;
        int cmp;
        int i9;
        int i15;
        android.graphics.drawable.ColorDrawable colorDrawable;
        int i6;
        int i2;
        int i19;
        int i20;
        int i3;
        int i39;
        int i12;
        int i26;
        int i30;
        int i16;
        int i27;
        int i4;
        int i29;
        int i13;
        int i7;
        int i36;
        int i10;
        int i5;
        int i31;
        int i18;
        int i38;
        b bVar;
        int i17;
        int i21;
        int i32;
        int i28;
        int i8;
        int i22;
        int i23;
        int i34;
        int i11;
        int i33;
        int i35;
        int i24;
        int i37;
        int i;
        int cmp2;
        int i25;
        final Object obj = this;
        l = obj.h0;
        int i43 = 0;
        obj.h0 = i43;
        b bVar2 = obj.b0;
        int i44 = 3;
        int cmp3 = Long.compare(i46, i43);
        i39 = 0;
        synchronized (this) {
            obj = this;
            l = obj.h0;
            i43 = 0;
            obj.h0 = i43;
            bVar2 = obj.b0;
            i44 = 3;
            cmp3 = Long.compare(i46, i43);
            i39 = 0;
        }
        if (bVar2 != null) {
            i12 = bVar2.p();
            i4 = bVar2.k();
            i13 = bVar2.q();
            i36 = bVar2.o();
            i5 = bVar2.d();
            i18 = bVar2.a();
            i17 = bVar2.n();
            i28 = bVar2.g();
            i8 = bVar2.h();
            i22 = bVar2.b();
            i23 = bVar2.l();
        } else {
            try {
                i23 = i22;
                i12 = 0;
                i13 = 0;
                i36 = 0;
                i18 = 0;
                i17 = 0;
                if (cmp3 != 0) {
                }
                if (i12 != 0) {
                } else {
                }
                i41 |= i51;
                i11 = 2048;
                i42 |= i53;
                i11 = 1024;
                i9 |= i11;
            }
            i33 = i13 != 0 ? 512 : 256;
            l |= i33;
            if (Long.compare(i35, i43) != 0) {
                if (i36 != 0) {
                    l |= i55;
                    i35 = 131072;
                } else {
                    l |= i54;
                    i35 = 65536;
                }
                i15 |= i35;
            }
            if (Long.compare(i24, i43) != 0) {
                i24 = i17 != 0 ? 32768 : 16384;
                l |= i24;
            }
            int i47 = 2131099857;
            int i49 = 17170443;
            FrameLayout frameLayout2 = obj.g0;
            if (i12 != 0) {
                i2 = ViewDataBinding.u(frameLayout2, i47);
            } else {
                i2 = ViewDataBinding.u(frameLayout2, i49);
            }
            androidx.constraintlayout.widget.ConstraintLayout constraintLayout2 = obj.U;
            if (i12 != 0) {
                i20 = ViewDataBinding.u(constraintLayout2, i47);
            } else {
                i20 = ViewDataBinding.u(constraintLayout2, i49);
            }
            int i48 = 8;
            i26 = i12 != 0 ? 0 : i48;
            i16 = i13 != 0 ? 0 : i48;
            i29 = i36 != 0 ? i48 : 0;
            i10 = i36 != 0 ? 0 : i48;
            i38 = i18 > 0 ? 1 : 0;
            i21 = i17 != 0 ? 0 : i48;
            if (Long.compare(i56, i) != 0) {
                cmp2 = i38 != 0 ? 8192 : 4096;
                l |= cmp2;
            }
            i37 = i38 != 0 ? 0 : i48;
            i31 = i16;
            i25 = i10;
            i30 = i28;
            i3 = i22;
            i32 = i2;
            i7 = i26;
            i39 = i4;
            i27 = i21;
            i6 = i8;
            bVar = bVar2;
            i14 = i37;
            i34 = i20;
            i19 = i23;
            obj.O.setVisibility(i27);
            obj.P.setVisibility(i27);
            m.o(obj.Q, i39);
            m.o(obj.R, i5);
            obj.S.setVisibility(i29);
            n.w(obj.T, i6);
            h.a(obj.U, b.b(i34));
            obj.V.setVisibility(i7);
            obj.d0.setVisibility(i31);
            g.c(obj.e0, i19);
            g.c(obj.f0, i3);
            obj.f0.setVisibility(i14);
            g.c(obj.W, i30);
            obj.X.setVisibility(i25);
            n.Q(obj.Y, bVar);
            m.o(obj.a0, i5);
            if (Long.compare(i40, i45) != 0 && ViewDataBinding.t() >= 21) {
                obj.O.setVisibility(i27);
                obj.P.setVisibility(i27);
                m.o(obj.Q, i39);
                m.o(obj.R, i5);
                obj.S.setVisibility(i29);
                n.w(obj.T, i6);
                h.a(obj.U, b.b(i34));
                obj.V.setVisibility(i7);
                obj.d0.setVisibility(i31);
                g.c(obj.e0, i19);
                g.c(obj.f0, i3);
                obj.f0.setVisibility(i14);
                g.c(obj.W, i30);
                obj.X.setVisibility(i25);
                n.Q(obj.Y, bVar);
                m.o(obj.a0, i5);
                if (ViewDataBinding.t() >= 21) {
                    obj.g0.setBackgroundTintList(b.a(i32));
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.c1
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
