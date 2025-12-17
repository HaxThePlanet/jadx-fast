package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.d.b.z.l;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.f0.m;

/* loaded from: classes.dex */
public class l0 extends app.dogo.com.dogo_android.h.k0 implements b.a {

    private static final ViewDataBinding.g i0;
    private static final SparseIntArray j0;
    private final ConstraintLayout e0;
    private final TextView f0;
    private final View.OnClickListener g0;
    private long h0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l0.j0 = sparseIntArray;
        sparseIntArray.put(2131363057, 17);
        sparseIntArray.put(2131361915, 18);
        sparseIntArray.put(2131363062, 19);
    }

    public l0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 20, l0.i0, l0.j0));
    }

    private l0(e e, View view2, Object[] object3Arr3) {
        Object obj6 = this;
        super(e, view2, 1, (ImageView)object3Arr3[8], (ImageView)object3Arr3[6], (View)object3Arr3[18], (TextView)object3Arr3[10], (TextView)object3Arr3[11], (TextView)object3Arr3[9], (FrameLayout)object3Arr3[12], (RelativeLayout)object3Arr3[2], (ImageView)object3Arr3[3], (ProgressBar)object3Arr3[16], (ImageView)object3Arr3[7], (ImageView)object3Arr3[5], (TextView)object3Arr3[17], (FrameLayout)object3Arr3[1], (FrameLayout)object3Arr3[13], (FrameLayout)object3Arr3[19], (TextView)object3Arr3[15], (RelativeLayout)object3Arr3[14]);
        Object obj5 = this;
        obj5.h0 = -1;
        int i4 = 0;
        obj5.O.setTag(i4);
        obj5.P.setTag(i4);
        obj5.Q.setTag(i4);
        obj5.R.setTag(i4);
        obj5.S.setTag(i4);
        obj5.T.setTag(i4);
        obj5.U.setTag(i4);
        obj5.V.setTag(i4);
        Object obj2 = object3Arr3[0];
        obj5.e0 = (ConstraintLayout)obj2;
        obj2.setTag(i4);
        Object obj3 = object3Arr3[4];
        obj5.f0 = (TextView)obj3;
        obj3.setTag(i4);
        obj5.W.setTag(i4);
        obj5.X.setTag(i4);
        obj5.Y.setTag(i4);
        obj5.Z.setTag(i4);
        obj5.a0.setTag(i4);
        obj5.b0.setTag(i4);
        obj5.c0.setTag(i4);
        obj5.N(view2);
        b bVar = new b(obj5, 1);
        obj5.g0 = bVar;
        A();
    }

    private boolean W(l l, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.h0 = l18 |= i51;
            return obj5;
            synchronized (this) {
                this.h0 = l18 |= i51;
                return obj5;
            }
        }
        if (i2 == 132) {
            this.h0 = l17 |= i50;
            return obj5;
            synchronized (this) {
                this.h0 = l17 |= i50;
                return obj5;
            }
        }
        if (i2 == 102) {
            this.h0 = l16 |= i49;
            return obj5;
            synchronized (this) {
                this.h0 = l16 |= i49;
                return obj5;
            }
        }
        if (i2 == 101) {
            this.h0 = l15 |= i48;
            return obj5;
            synchronized (this) {
                this.h0 = l15 |= i48;
                return obj5;
            }
        }
        if (i2 == 185) {
            this.h0 = l14 |= i47;
            return obj5;
            synchronized (this) {
                this.h0 = l14 |= i47;
                return obj5;
            }
        }
        if (i2 == 13) {
            this.h0 = l13 |= i46;
            return obj5;
            synchronized (this) {
                this.h0 = l13 |= i46;
                return obj5;
            }
        }
        if (i2 == 11) {
            this.h0 = l12 |= i45;
            return obj5;
            synchronized (this) {
                this.h0 = l12 |= i45;
                return obj5;
            }
        }
        try {
            if (i2 == 12) {
            }
            this.h0 = l2 |= i35;
            return obj5;
            throw l;
            if (i2 == 10) {
            }
            this.h0 = l3 |= i36;
            return obj5;
            throw l;
            if (i2 == 48) {
            }
            this.h0 = l4 |= i37;
            return obj5;
            throw l;
            if (i2 == 49) {
            }
            this.h0 = l5 |= i38;
            return obj5;
        } catch (Throwable th) {
        }
        if (i2 == 41) {
            this.h0 = l6 |= i39;
            return obj5;
            synchronized (this) {
                this.h0 = l6 |= i39;
                return obj5;
            }
        }
        if (i2 == 61) {
            this.h0 = l7 |= i40;
            return obj5;
            synchronized (this) {
                this.h0 = l7 |= i40;
                return obj5;
            }
        }
        if (i2 == 133) {
            this.h0 = l8 |= i41;
            return obj5;
            synchronized (this) {
                this.h0 = l8 |= i41;
                return obj5;
            }
        }
        if (i2 == 164) {
            this.h0 = l9 |= i42;
            return obj5;
            synchronized (this) {
                this.h0 = l9 |= i42;
                return obj5;
            }
        }
        if (i2 == 165) {
            this.h0 = l10 |= i43;
            return obj5;
            synchronized (this) {
                this.h0 = l10 |= i43;
                return obj5;
            }
        }
        if (i2 == 147) {
            this.h0 = l11 |= i44;
            return obj5;
            synchronized (this) {
                this.h0 = l11 |= i44;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.k0
    public void A() {
        this.h0 = 131072;
        I();
        return;
        synchronized (this) {
            this.h0 = 131072;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k0
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((l)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.k0
    public boolean O(int i, Object object2) {
        int obj2;
        if (183 == i) {
            V((l)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.k0
    public void V(l l) {
        R(0, l);
        this.d0 = l;
        this.h0 = l2 |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, l);
            this.d0 = l;
            this.h0 = l2 |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k0
    public final void b(int i, View view2) {
        int obj2;
        final l obj1 = this.d0;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.onTranslateButtonPress();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k0
    protected void m() {
        int i23;
        int cmp14;
        int cmp6;
        int cmp16;
        int cmp5;
        int cmp10;
        int cmp8;
        int cmp12;
        int cmp17;
        int cmp2;
        int cmp7;
        int cmp11;
        int cmp9;
        int cmp;
        int cmp18;
        int cmp15;
        long l;
        int i43;
        int i36;
        int cmp13;
        int cmp3;
        int i5;
        int i8;
        int i40;
        int i17;
        int i9;
        int i;
        int i20;
        int i3;
        int i10;
        int i27;
        int i2;
        int i18;
        int i45;
        int i21;
        int i31;
        int i38;
        int i25;
        int i37;
        int i6;
        int i11;
        int i28;
        int i32;
        int i7;
        int i12;
        int i46;
        int translationButtonString;
        int i24;
        int i26;
        int i13;
        int i44;
        int i35;
        int i29;
        int i39;
        int likeState;
        int i41;
        int i14;
        int i22;
        int i30;
        int i34;
        int i15;
        int i4;
        int translateButtonVisible;
        int i42;
        int cmp4;
        int spinnerVisible;
        long l2;
        int i16;
        int i19;
        int i33;
        final Object obj = this;
        l = obj.h0;
        i36 = 0;
        obj.h0 = i36;
        l lVar = obj.d0;
        final int i69 = 139265;
        final int i70 = 131089;
        final int i71 = 135169;
        final int i72 = 131081;
        final int i73 = 132097;
        final int i74 = 131105;
        final int i75 = 131585;
        final int i76 = 163841;
        final int i77 = 133121;
        final int i78 = 131077;
        int i79 = 131137;
        final int i81 = 131075;
        int i82 = 131329;
        i7 = 0;
        i12 = 0;
        synchronized (this) {
            obj = this;
            l = obj.h0;
            i36 = 0;
            obj.h0 = i36;
            lVar = obj.d0;
            i69 = 139265;
            i70 = 131089;
            i71 = 135169;
            i72 = 131081;
            i73 = 132097;
            i74 = 131105;
            i75 = 131585;
            i76 = 163841;
            i77 = 133121;
            i78 = 131077;
            i79 = 131137;
            i81 = 131075;
            i82 = 131329;
            i7 = 0;
            i12 = 0;
        }
        int cmp20 = Long.compare(i84, i36);
        if (cmp20 != 0) {
            if (lVar != null) {
                try {
                    translationButtonString = lVar.w();
                    translationButtonString = i12;
                    if (cmp20 != 0) {
                    }
                    if (translationButtonString != null) {
                    } else {
                    }
                    i26 = 8388608;
                    i26 = 4194304;
                    l |= i26;
                }
                if (translationButtonString != null) {
                    i27 = i12;
                } else {
                    i27 = i46;
                }
            } else {
            }
        } else {
        }
        int cmp25 = Long.compare(i85, i36);
        if (cmp25 != 0) {
            if (lVar != null) {
                i26 = lVar.v();
            } else {
                i26 = i12;
            }
            if (cmp25 != 0) {
                i35 = i26 != 0 ? 524288 : 262144;
                l |= i35;
            }
            if (i26 != 0) {
                i46 = i12;
            }
        } else {
        }
        if (Long.compare(i86, i36) != 0 && lVar != null) {
            if (lVar != null) {
                translationButtonString = lVar.getTranslationButtonString();
            } else {
                translationButtonString = i7;
            }
        } else {
        }
        if (Long.compare(i87, i36) != 0 && lVar != null) {
            if (lVar != null) {
                i13 = lVar.d();
            } else {
                i13 = i7;
            }
        } else {
        }
        int cmp28 = Long.compare(i88, i36);
        if (cmp28 != 0) {
            if (lVar != null) {
                likeState = lVar.getLikeState();
            } else {
                likeState = i12;
            }
            if (cmp28 != 0) {
                i41 = likeState != 0 ? 536870912 : 268435456;
                l |= i41;
            }
            i37 = likeState != 0 ? R.color.secondary : R.color.icon_gray;
            i3 = ViewDataBinding.u(obj.V, i37);
        } else {
            likeState = i3;
        }
        if (Long.compare(i67, i36) != 0 && lVar != null) {
            if (lVar != null) {
                i25 = lVar.o();
            } else {
                i25 = i7;
            }
        } else {
        }
        int cmp23 = Long.compare(i89, i36);
        i22 = 8;
        if (cmp23 != 0) {
            if (lVar != null) {
                i30 = lVar.x();
            } else {
                i30 = i12;
            }
            if (cmp23 != 0) {
                i34 = i30 != 0 ? 8589934592L : 4294967296L;
                l |= i34;
            }
            if (i30 != 0) {
                i11 = i12;
            } else {
                i11 = i22;
            }
        } else {
        }
        int cmp29 = Long.compare(i90, i36);
        if (cmp29 != 0) {
            if (lVar != null) {
                i34 = lVar.r();
            } else {
                i34 = i12;
            }
            if (cmp29 != 0) {
                i15 = i34 != 0 ? 137438953472L : 68719476736L;
                l |= i15;
            }
            if (i34 != 0) {
                i30 = i12;
            } else {
                i30 = i22;
            }
        } else {
        }
        int cmp30 = Long.compare(i91, i36);
        if (cmp30 != 0) {
            if (lVar != null) {
                i15 = lVar.p();
            } else {
                i15 = i12;
            }
            if (cmp30 != 0) {
                i4 = i15 != 0 ? 2147483648L : 1073741824;
                l |= i4;
            }
            if (i15 != 0) {
                i34 = i12;
            } else {
                i34 = i22;
            }
        } else {
        }
        int cmp31 = Long.compare(i92, i36);
        if (cmp31 != 0) {
            if (lVar != null) {
                i4 = lVar.q();
            } else {
                i4 = i12;
            }
            if (cmp31 != 0) {
                translateButtonVisible = i4 != 0 ? 134217728 : 67108864;
                l |= translateButtonVisible;
            }
            if (i4 != 0) {
                i15 = i12;
            } else {
                i15 = i22;
            }
        } else {
        }
        int cmp32 = Long.compare(i93, i36);
        if (cmp32 != 0) {
            if (lVar != null) {
                translateButtonVisible = lVar.isTranslateButtonVisible();
            } else {
                translateButtonVisible = i12;
            }
            if (cmp32 != 0) {
                i42 = translateButtonVisible != 0 ? 2097152 : 1048576;
                l |= i42;
            }
            if (translateButtonVisible != 0) {
                i4 = i12;
            } else {
                i4 = i22;
            }
        } else {
        }
        if (Long.compare(i94, i36) != 0 && lVar != null) {
            if (lVar != null) {
                i29 = lVar.h();
            } else {
                i29 = 0;
            }
        } else {
        }
        int cmp34 = Long.compare(i95, i36);
        if (cmp34 != 0) {
            if (lVar != null) {
                i42 = lVar.t();
            } else {
                i42 = i12;
            }
            if (cmp34 != 0) {
                cmp4 = i42 != 0 ? 34359738368L : 17179869184L;
                l |= cmp4;
            }
            if (i42 != 0) {
                translateButtonVisible = i12;
            } else {
                translateButtonVisible = i22;
            }
        } else {
        }
        if (Long.compare(i96, i36) != 0 && lVar != null) {
            if (lVar != null) {
                i42 = lVar.f();
            } else {
                i42 = i7;
            }
        } else {
        }
        int cmp36 = Long.compare(i97, i36);
        if (cmp36 != 0) {
            if (lVar != null) {
                spinnerVisible = lVar.isSpinnerVisible();
            } else {
                spinnerVisible = i12;
            }
            if (cmp36 != 0) {
                l2 = spinnerVisible != 0 ? 549755813888L : 274877906944L;
                l |= l2;
            }
            if (spinnerVisible != 0) {
                i22 = i12;
            }
        } else {
        }
        cmp4 = Long.compare(i98, i36);
        if (cmp4 != 0 && lVar != null) {
            if (lVar != null) {
                i12 = lVar.m();
            }
            if (cmp4 != 0) {
                cmp4 = i12 != 0 ? 33554432 : 0x01000000 /* Unknown resource */;
                l |= cmp4;
            }
            i21 = i12 != 0 ? R.color.light_green : R.color.white;
            i12 = i18;
        }
        if (Long.compare(i65, i36) != 0 && lVar != null) {
            if (lVar != null) {
                i7 = lVar.g();
            }
        }
        i16 = i27;
        i19 = i11;
        i10 = i7;
        i31 = i46;
        i38 = likeState;
        i45 = i22;
        i2 = i30;
        i6 = i34;
        i28 = i15;
        i33 = i4;
        i32 = translateButtonVisible;
        i23 = i42;
        i39 = translationButtonString;
        i14 = i13;
        i24 = i3;
        i20 = i29;
        i44 = i12;
        if (Long.compare(i83, i36) != 0) {
            obj.O.setVisibility(i6);
        }
        int i80 = 0;
        if (Long.compare(i47, i80) != 0) {
            obj.P.setVisibility(i28);
        }
        if (Long.compare(i48, i80) != 0) {
            g.c(obj.Q, i23);
            g.c(obj.R, i23);
        }
        if (Long.compare(i49, i80) != 0) {
            g.c(obj.S, i10);
        }
        if (Long.compare(i50, i80) != 0) {
            g.d(obj.S, i20);
        }
        if (Long.compare(i51, i80) != 0) {
            obj.T.setVisibility(i32);
        }
        if (Long.compare(i52, i80) != 0) {
            obj.U.setVisibility(i31);
        }
        obj.V.setEnabled(i38);
        if (Long.compare(i5, i80) != 0 && ViewDataBinding.t() >= 21) {
            obj.V.setEnabled(i38);
            if (ViewDataBinding.t() >= 21) {
                obj.V.setImageTintList(b.a(i24));
            }
        }
        int i62 = 0;
        if (Long.compare(i8, i62) != 0) {
            h.a(obj.e0, b.b(i44));
        }
        if (Long.compare(i54, i62) != 0) {
            g.c(obj.f0, i25);
        }
        if (Long.compare(i56, i62) != 0) {
            obj.W.setVisibility(i45);
        }
        if (Long.compare(i58, i62) != 0) {
            obj.X.setVisibility(i2);
        }
        if (Long.compare(i40, i62) != 0) {
            m.o(obj.Y, i14);
        }
        if (Long.compare(i17, i62) != 0) {
            obj.Z.setVisibility(i16);
        }
        if (Long.compare(i59, i62) != 0) {
            obj.a0.setVisibility(i19);
        }
        if (Long.compare(i9, i62) != 0) {
            obj.b0.setOnClickListener(obj.g0);
        }
        if (Long.compare(i, i62) != 0) {
            g.c(obj.b0, i39);
        }
        if (Long.compare(i43, i62) != 0) {
            obj.c0.setVisibility(i33);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k0
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
