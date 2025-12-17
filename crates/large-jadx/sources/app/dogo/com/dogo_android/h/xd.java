package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.m.s.i;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class xd extends app.dogo.com.dogo_android.h.wd implements b.a {

    private static final ViewDataBinding.g i0;
    private static final SparseIntArray j0;
    private final TextView f0;
    private final View.OnClickListener g0;
    private long h0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        xd.j0 = sparseIntArray;
        sparseIntArray.put(2131363441, 15);
        sparseIntArray.put(2131362568, 16);
        sparseIntArray.put(2131363004, 17);
        sparseIntArray.put(2131362118, 18);
        sparseIntArray.put(2131362126, 19);
        sparseIntArray.put(2131362121, 20);
        sparseIntArray.put(2131362184, 21);
        sparseIntArray.put(2131362185, 22);
        sparseIntArray.put(2131363554, 23);
        sparseIntArray.put(2131362182, 24);
    }

    public xd(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 25, xd.i0, xd.j0));
    }

    private xd(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 2, (ArcProgressBar)object3Arr3[5], (ConstraintLayout)object3Arr3[0], (View)object3Arr3[14], (Barrier)object3Arr3[18], (Guideline)object3Arr3[20], (Barrier)object3Arr3[19], (ClickerSoundMaterialButton)object3Arr3[12], (View)object3Arr3[24], (Guideline)object3Arr3[21], (Guideline)object3Arr3[22], (Space)object3Arr3[13], (Button)object3Arr3[9], (Button)object3Arr3[11], (Chip)object3Arr3[16], (Chip)object3Arr3[4], (TextView)object3Arr3[8], (Guideline)object3Arr3[17], (TextView)object3Arr3[7], (ConstraintLayout)object3Arr3[3], (MaterialToolbar)object3Arr3[15], (TextView)object3Arr3[6], (ConstraintLayout)object3Arr3[1], (TextView)object3Arr3[10], (View)object3Arr3[23]);
        Object obj4 = this;
        obj4.h0 = -1;
        int i3 = 0;
        obj4.O.setTag(i3);
        obj4.P.setTag(i3);
        obj4.Q.setTag(i3);
        obj4.R.setTag(i3);
        obj4.S.setTag(i3);
        obj4.T.setTag(i3);
        obj4.U.setTag(i3);
        Object obj2 = object3Arr3[2];
        obj4.f0 = (TextView)obj2;
        obj2.setTag(i3);
        obj4.W.setTag(i3);
        obj4.X.setTag(i3);
        obj4.Y.setTag(i3);
        obj4.Z.setTag(i3);
        obj4.b0.setTag(i3);
        obj4.c0.setTag(i3);
        obj4.d0.setTag(i3);
        obj4.N(view2);
        b bVar = new b(obj4, 1);
        obj4.g0 = bVar;
        A();
    }

    private boolean V(x<Long> x, int i2) {
        if (i2 == 0) {
            this.h0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.h0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean W(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.h0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.h0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.wd
    public void A() {
        this.h0 = 8;
        I();
        return;
        synchronized (this) {
            this.h0 = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wd
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return W((x)object2, i3);
        }
        return V((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.wd
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            X((i)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.wd
    public void X(i i) {
        this.e0 = i;
        this.h0 = l |= i3;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.e0 = i;
            this.h0 = l |= i3;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wd
    public final void b(int i, View view2) {
        int obj2;
        final i obj1 = this.e0;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.r();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wd
    protected void m() {
        int i12;
        int cmp;
        int cmp3;
        int iVar;
        long l;
        int i14;
        int i16;
        int i2;
        int i9;
        int i7;
        int valueOf;
        int i4;
        int cmp4;
        int valueOf2;
        Long valueOf3;
        int value;
        int i5;
        int i6;
        int i11;
        int i13;
        int i17;
        int i18;
        int i19;
        int i10;
        int i;
        int i15;
        String name;
        int cmp2;
        int variation;
        int i20;
        int cmp5;
        x xVar;
        int i8;
        int i3;
        final Object obj = this;
        l = obj.h0;
        final int i21 = 0;
        obj.h0 = i21;
        iVar = obj.e0;
        int i29 = 13;
        final int i32 = 12;
        int i33 = 0;
        synchronized (this) {
            obj = this;
            l = obj.h0;
            i21 = 0;
            obj.h0 = i21;
            iVar = obj.e0;
            i29 = 13;
            i32 = 12;
            i33 = 0;
        }
        int cmp7 = Long.compare(i34, i21);
        int i35 = 1;
        if (cmp7 != 0) {
            if (iVar != null) {
                try {
                    i17 = iVar.i();
                    i18 = iVar.q();
                    i10 = iVar.p();
                    i18 = i33;
                    i17 = 0;
                    i10 = 0;
                    if (cmp7 != 0) {
                    }
                    if (i18 != 0) {
                    } else {
                    }
                    l |= i37;
                    i = 2048;
                    l |= i36;
                    i = 1024;
                    i16 |= i;
                }
                i9 = i17 == 0 ? i35 : i33;
                i13 = i18 != 0 ? i33 : 4;
                i = 8;
                i15 = i18 != 0 ? i : i33;
                if (Long.compare(i38, i21) != 0) {
                    cmp2 = i9 != 0 ? 512 : 256;
                    l |= cmp2;
                }
                if (i10 != 0) {
                    name = i10.getName();
                    variation = i10.isVariation();
                } else {
                    variation = i33;
                    name = 0;
                }
                if (Long.compare(i39, i21) != 0) {
                    cmp5 = variation ? 128 : 64;
                    l |= cmp5;
                }
                i7 = i9 != 0 ? i : i33;
                if (variation) {
                } else {
                    i = i33;
                }
            } else {
            }
        } else {
            variation = i15;
            i10 = 0;
            name = 0;
        }
        if (Long.compare(i40, i21) != 0) {
            if (iVar != null) {
                i20 = iVar.o();
                i5 = xVar;
            } else {
                i20 = i21;
                i5 = 0;
            }
            obj.Q(i33, i5);
            if (i5 != 0) {
                value = i5.getValue();
            } else {
                value = 0;
            }
        } else {
            i20 = i21;
        }
        if (Long.compare(i8, i21) != 0) {
            if (iVar != null) {
                iVar = iVar.n();
            } else {
                iVar = 0;
            }
            obj.Q(i35, iVar);
            if (iVar != 0) {
                i6 = value2;
                i4 = i7;
                i11 = i13;
                i2 = i10;
                i3 = i;
                valueOf = i15;
                i12 = name;
            } else {
                i4 = i7;
                i11 = i13;
                i2 = i10;
                i3 = i;
                valueOf = i15;
                i12 = name;
                i6 = 0;
            }
        } else {
        }
        i19 = i18;
        if (Long.compare(i30, i21) != 0) {
            f.a(obj.O, value, Long.valueOf(i20));
            f.s(obj.X, value, Long.valueOf(i20));
            f.l(obj.b0, value, Long.valueOf(i20));
        }
        if (Long.compare(i31, i21) != 0) {
            obj.Q.setVisibility(i11);
            obj.R.setVisibility(valueOf);
            obj.S.setVisibility(valueOf);
            f.k(obj.T, Boolean.valueOf(variation));
            g.c(obj.f0, i12);
            obj.W.setVisibility(i4);
            obj.Z.setVisibility(i3);
            f.u(obj.c0, Boolean.valueOf(i19));
            f.m(obj.d0, i2);
        }
        if (Long.compare(i25, i21) != 0) {
            f.b(obj.U, i6);
            n.J0(obj.Y, i6);
        }
        if (Long.compare(i14, i21) != 0) {
            obj.W.setOnClickListener(obj.g0);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wd
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
