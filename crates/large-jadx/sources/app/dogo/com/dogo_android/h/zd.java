package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.m.u.k;
import app.dogo.com.dogo_android.n.m.u.n;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import com.google.android.material.appbar.MaterialToolbar;
import d.a.k.a.a;

/* loaded from: classes.dex */
public class zd extends app.dogo.com.dogo_android.h.yd implements b.a {

    private static final ViewDataBinding.g k0;
    private static final SparseIntArray l0;
    private final TextView h0;
    private final View.OnClickListener i0;
    private long j0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zd.l0 = sparseIntArray;
        sparseIntArray.put(2131362568, 14);
        sparseIntArray.put(2131361936, 15);
        sparseIntArray.put(2131362955, 16);
        sparseIntArray.put(2131363331, 17);
        sparseIntArray.put(2131363005, 18);
        sparseIntArray.put(2131362118, 19);
        sparseIntArray.put(2131362126, 20);
        sparseIntArray.put(2131362121, 21);
        sparseIntArray.put(2131362184, 22);
        sparseIntArray.put(2131362185, 23);
        sparseIntArray.put(2131363554, 24);
        sparseIntArray.put(2131362182, 25);
    }

    public zd(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 26, zd.k0, zd.l0));
    }

    private zd(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 2, (AppCompatImageView)object3Arr3[15], (ConstraintLayout)object3Arr3[0], (View)object3Arr3[13], (Barrier)object3Arr3[19], (Guideline)object3Arr3[21], (Barrier)object3Arr3[20], (ClickerSoundMaterialButton)object3Arr3[11], (View)object3Arr3[25], (Guideline)object3Arr3[22], (Guideline)object3Arr3[23], (Space)object3Arr3[12], (Button)object3Arr3[9], (Chip)object3Arr3[14], (FrameLayout)object3Arr3[10], (Chip)object3Arr3[5], (TextView)object3Arr3[16], (ProgressBar)object3Arr3[18], (LottieAnimationView)object3Arr3[7], (TabLayout)object3Arr3[17], (ConstraintLayout)object3Arr3[8], (ConstraintLayout)object3Arr3[4], (MaterialToolbar)object3Arr3[2], (ConstraintLayout)object3Arr3[1], (ViewPager2)object3Arr3[6], (View)object3Arr3[24]);
        Object obj4 = this;
        obj4.j0 = -1;
        int i3 = 0;
        obj4.O.setTag(i3);
        obj4.P.setTag(i3);
        obj4.Q.setTag(i3);
        obj4.R.setTag(i3);
        obj4.S.setTag(i3);
        obj4.U.setTag(i3);
        Object obj2 = object3Arr3[3];
        obj4.h0 = (TextView)obj2;
        obj2.setTag(i3);
        obj4.V.setTag(i3);
        obj4.X.setTag(i3);
        obj4.Z.setTag(i3);
        obj4.a0.setTag(i3);
        obj4.b0.setTag(i3);
        obj4.c0.setTag(i3);
        obj4.d0.setTag(i3);
        obj4.N(view2);
        b bVar = new b(obj4, 1);
        obj4.i0 = bVar;
        A();
    }

    private boolean W(x<y<TrickItem>> x, int i2) {
        if (i2 == 0) {
            this.j0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.j0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.j0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.j0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.yd
    public void A() {
        this.j0 = 16;
        I();
        return;
        synchronized (this) {
            this.j0 = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yd
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return W((x)object2, i3);
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.yd
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((k)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                Y((n)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.yd
    public void V(k k) {
        this.g0 = k;
        this.j0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.g0 = k;
            this.j0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yd
    public void Y(n n) {
        this.f0 = n;
        this.j0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.f0 = n;
            this.j0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yd
    public final void b(int i, View view2) {
        int obj2;
        final n obj1 = this.f0;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.B();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yd
    protected void m() {
        int i15;
        int cmp6;
        int cmp;
        int cmp8;
        int cmp3;
        long l;
        int i25;
        int i28;
        k kVar;
        int valueOf;
        int i17;
        int i21;
        int i18;
        int i26;
        int i23;
        int i;
        int i35;
        int i3;
        android.graphics.drawable.Drawable i34;
        int i32;
        int i30;
        int i27;
        int cmp5;
        int i36;
        int i16;
        boolean z;
        int context;
        int i24;
        int i7;
        Object value;
        int i4;
        int i12;
        x xVar;
        k kVar2;
        int i13;
        int i10;
        int i2;
        int i33;
        int i9;
        int i29;
        int i8;
        int name;
        int i31;
        int i22;
        int i5;
        int i19;
        int i6;
        int i11;
        int cmp2;
        int cmp7;
        int cmp4;
        int i14;
        int i20;
        final Object obj = this;
        l = obj.j0;
        final int i37 = 0;
        obj.j0 = i37;
        k kVar3 = obj.g0;
        n nVar = obj.f0;
        int i48 = 24;
        int i50 = 0;
        synchronized (this) {
            obj = this;
            l = obj.j0;
            i37 = 0;
            obj.j0 = i37;
            kVar3 = obj.g0;
            nVar = obj.f0;
            i48 = 24;
            i50 = 0;
        }
        int cmp10 = Long.compare(i52, i37);
        i12 = 8;
        if (cmp10 != 0) {
            if (nVar != null) {
                try {
                    i7 = xVar;
                    i7 = 0;
                    obj.Q(i50, i7);
                    if (i7 != 0) {
                    } else {
                    }
                    value = i7.getValue();
                    value = 0;
                    z = ViewDataBinding.K(value);
                }
                if (z) {
                    i23 = i50;
                } else {
                    i23 = i12;
                }
            } else {
            }
        } else {
        }
        context = Long.compare(i53, i37);
        int i51 = 1;
        if (context != null) {
            if (nVar != null) {
                i33 = nVar.p();
                i29 = nVar.m();
                i8 = nVar.x();
                i31 = nVar.u();
                i22 = nVar.t();
                i5 = nVar.s();
            } else {
                i33 = 0;
                i29 = 0;
                i8 = 0;
                i31 = 0;
                i22 = 0;
                i5 = 0;
            }
            if (context != null) {
                if (i8 != 0) {
                    l |= i55;
                    i19 = 16384;
                } else {
                    l |= i54;
                    i19 = 8192;
                }
                i28 |= i19;
            }
            context = i33 != 0 ? i51 : 0;
            i19 = i33 == 0 ? i51 : 0;
            i9 = i29 == 0 ? i51 : 0;
            i6 = i8 != 0 ? 0 : 4;
            i11 = i8 != 0 ? i12 : 0;
            if (Long.compare(i56, i37) != 0) {
                cmp7 = context != null ? 65536 : 32768;
                l |= cmp7;
            }
            if (Long.compare(i57, i37) != 0) {
                cmp4 = i19 != 0 ? 1024 : 512;
                l |= cmp4;
            }
            if (Long.compare(i58, i37) != 0) {
                cmp2 = i9 != 0 ? 4096 : 2048;
                l |= cmp2;
            }
            if (i31 != 0) {
                name = i31.getName();
            } else {
                name = 0;
            }
            if (context != null) {
                i34 = a.d(obj.b0.getContext(), 2131231072);
            } else {
                i34 = a.d(obj.b0.getContext(), 2131231056);
            }
            i27 = i19 != 0 ? 0 : i12;
            if (i9 != 0) {
            } else {
                i12 = 0;
            }
            i10 = i6;
        } else {
            i34 = 0;
            i27 = 0;
            i12 = 0;
            i10 = 0;
            i33 = 0;
            i8 = 0;
            name = 0;
            i22 = 0;
            i5 = 0;
            i11 = 0;
        }
        if (Long.compare(i19, i37) != 0) {
            if (nVar != null) {
                i24 = nVar.q();
                i18 = nVar.w();
            } else {
                i18 = 0;
                i24 = 0;
            }
            obj.Q(i51, i24);
            if (i24 != 0) {
                i14 = i18;
                i20 = i23;
                i4 = i27;
                i = i10;
                i26 = name;
                valueOf = i5;
                i35 = i11;
                kVar2 = kVar3;
                i32 = i34;
                i15 = i12;
                i3 = i33;
                i2 = value2;
                i36 = i22;
            } else {
                i14 = i18;
                i20 = i23;
                i4 = i27;
                i = i10;
                i26 = name;
                i36 = i22;
                valueOf = i5;
                i35 = i11;
                kVar2 = kVar3;
                i32 = i34;
                i15 = i12;
                i3 = i33;
                i2 = 0;
            }
        } else {
            i20 = i23;
            i4 = i27;
            i = i10;
            i26 = name;
            i36 = i22;
            valueOf = i5;
            i35 = i11;
            i14 = 0;
        }
        if (Long.compare(i49, i37) != 0) {
            obj.P.setVisibility(i);
            obj.Q.setVisibility(i35);
            obj.R.setVisibility(i35);
            f.t(obj.S, i36, valueOf);
            g.c(obj.h0, i26);
            obj.V.setVisibility(i15);
            f.v(obj.Z, obj.W, i3);
            obj.a0.setVisibility(i4);
            obj.b0.setNavigationIcon(i32);
            f.u(obj.c0, Boolean.valueOf(i8));
        }
        if (Long.compare(i39, i37) != 0) {
            n.z0(obj.U, i2);
        } else {
            i16 = i2;
        }
        if (Long.compare(i17, i37) != 0) {
            obj.V.setOnClickListener(obj.i0);
        }
        if (Long.compare(i42, i37) != 0) {
            obj.X.setVisibility(i20);
        }
        if (Long.compare(i25, i37) != 0) {
            i.t(obj.d0, i16, obj.Y, i14, kVar2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yd
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
