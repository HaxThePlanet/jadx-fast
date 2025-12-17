package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.d.a.n.e;
import app.dogo.com.dogo_android.util.f0.m;

/* loaded from: classes.dex */
public class t0 extends app.dogo.com.dogo_android.h.s0 {

    private static final ViewDataBinding.g c0;
    private static final SparseIntArray d0;
    private final ConstraintLayout a0;
    private long b0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t0.d0 = sparseIntArray;
        sparseIntArray.put(2131361915, 10);
        sparseIntArray.put(2131361929, 11);
        sparseIntArray.put(2131362723, 12);
        sparseIntArray.put(2131362406, 13);
        sparseIntArray.put(2131362728, 14);
    }

    public t0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 15, t0.c0, t0.d0));
    }

    private t0(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 1, (ImageView)object3Arr3[4], (ImageView)object3Arr3[2], (View)object3Arr3[10], (ImageView)object3Arr3[11], (ViewPager)object3Arr3[5], (TextView)object3Arr3[7], (ConstraintLayout)object3Arr3[13], (FrameLayout)object3Arr3[12], (ImageView)object3Arr3[9], (FrameLayout)object3Arr3[14], (ImageView)object3Arr3[3], (ImageView)object3Arr3[1], (TextView)object3Arr3[6], (TextView)object3Arr3[8]);
        Object obj4 = this;
        obj4.b0 = -1;
        int i3 = 0;
        obj4.O.setTag(i3);
        obj4.P.setTag(i3);
        obj4.R.setTag(i3);
        obj4.S.setTag(i3);
        obj4.T.setTag(i3);
        Object obj2 = object3Arr3[0];
        obj4.a0 = (ConstraintLayout)obj2;
        obj2.setTag(i3);
        obj4.V.setTag(i3);
        obj4.W.setTag(i3);
        obj4.X.setTag(i3);
        obj4.Y.setTag(i3);
        obj4.N(view2);
        A();
    }

    private boolean W(e e, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.b0 = l9 |= i27;
            return obj5;
            synchronized (this) {
                this.b0 = l9 |= i27;
                return obj5;
            }
        }
        if (i2 == 174) {
            this.b0 = l8 |= i26;
            return obj5;
            synchronized (this) {
                this.b0 = l8 |= i26;
                return obj5;
            }
        }
        if (i2 == 11) {
            this.b0 = l7 |= i25;
            return obj5;
            synchronized (this) {
                this.b0 = l7 |= i25;
                return obj5;
            }
        }
        if (i2 == 12) {
            this.b0 = l6 |= i24;
            return obj5;
            synchronized (this) {
                this.b0 = l6 |= i24;
                return obj5;
            }
        }
        if (i2 == 10) {
            this.b0 = l5 |= i23;
            return obj5;
            synchronized (this) {
                this.b0 = l5 |= i23;
                return obj5;
            }
        }
        if (i2 == 65) {
            this.b0 = l4 |= i22;
            return obj5;
            synchronized (this) {
                this.b0 = l4 |= i22;
                return obj5;
            }
        }
        if (i2 == 36) {
            this.b0 = l3 |= i21;
            return obj5;
            synchronized (this) {
                this.b0 = l3 |= i21;
                return obj5;
            }
        }
        try {
            if (i2 == 184) {
            }
            this.b0 = l |= i19;
            return obj5;
            throw e;
            if (i2 == 101) {
            }
            this.b0 = l2 |= i20;
            return obj5;
            throw e;
            return 0;
        } catch (Throwable th) {
        }
    }

    @Override // app.dogo.com.dogo_android.h.s0
    public void A() {
        this.b0 = 512;
        I();
        return;
        synchronized (this) {
            this.b0 = 512;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s0
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((e)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.s0
    public boolean O(int i, Object object2) {
        int obj2;
        if (183 == i) {
            V((e)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.s0
    public void V(e e) {
        R(0, e);
        this.Z = e;
        this.b0 = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, e);
            this.Z = e;
            this.b0 = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s0
    protected void m() {
        int i2;
        int cmp;
        int cmp8;
        int cmp4;
        int cmp2;
        int cmp7;
        int eVar;
        long l;
        int i8;
        int i7;
        int i9;
        int i6;
        int i15;
        int i13;
        int i;
        int cmp6;
        int cmp3;
        int cmp9;
        int i3;
        int i10;
        int i16;
        int i12;
        int i20;
        int likeState;
        int i14;
        int voteCount;
        int i17;
        int i19;
        int i11;
        int cmp5;
        int i4;
        int i5;
        int i18;
        final Object obj = this;
        l = obj.b0;
        final int i21 = 0;
        obj.b0 = i21;
        eVar = obj.Z;
        final int i37 = 577;
        final int i38 = 517;
        final int i39 = 521;
        int i40 = 529;
        i20 = 0;
        likeState = 0;
        synchronized (this) {
            obj = this;
            l = obj.b0;
            i21 = 0;
            obj.b0 = i21;
            eVar = obj.Z;
            i37 = 577;
            i38 = 517;
            i39 = 521;
            i40 = 529;
            i20 = 0;
            likeState = 0;
        }
        int cmp11 = Long.compare(i42, i21);
        i14 = 8;
        if (cmp11 != 0) {
            if (eVar != null) {
                try {
                    voteCount = eVar.g();
                    voteCount = likeState;
                    if (cmp11 != 0) {
                    }
                    if (voteCount != 0) {
                    } else {
                    }
                    i17 = 32768;
                    i17 = 16384;
                    l |= i17;
                }
                if (voteCount != 0) {
                    i9 = likeState;
                } else {
                    i9 = i14;
                }
            } else {
            }
        } else {
        }
        if (Long.compare(i43, i21) != 0 && eVar != null) {
            if (eVar != null) {
                voteCount = eVar.getVoteCount();
            } else {
                voteCount = i20;
            }
        } else {
        }
        int cmp14 = Long.compare(i44, i21);
        if (cmp14 != 0) {
            if (eVar != null) {
                i19 = eVar.e();
            } else {
                i19 = likeState;
            }
            if (cmp14 != 0) {
                i11 = i19 != 0 ? 8192 : 4096;
                l |= i11;
            }
            if (i19 != 0) {
                i17 = likeState;
            } else {
                i17 = i14;
            }
        } else {
        }
        if (Long.compare(i45, i21) != 0 && eVar != null) {
            if (eVar != null) {
                i19 = eVar.a();
            } else {
                i19 = i20;
            }
        } else {
        }
        int cmp16 = Long.compare(i46, i21);
        if (cmp16 != 0) {
            if (eVar != null) {
                cmp5 = eVar.f();
            } else {
                cmp5 = likeState;
            }
            if (cmp16 != 0) {
                i4 = cmp5 ? 2048 : 1024;
                l |= i4;
            }
            if (cmp5) {
                i14 = likeState;
            }
        } else {
        }
        if (Long.compare(i47, i21) != 0 && eVar != null) {
            if (eVar != null) {
                i11 = eVar.b();
            } else {
                i11 = i20;
            }
        } else {
        }
        if (Long.compare(i48, i21) != 0 && eVar != null) {
            if (eVar != null) {
                i20 = eVar.d();
            }
        }
        cmp5 = Long.compare(i49, i21);
        if (cmp5 != 0) {
            if (eVar != null) {
                likeState = eVar.getLikeState();
            }
            if (cmp5 != 0) {
                cmp5 = likeState != 0 ? 131072 : 65536;
                l |= cmp5;
            }
            i12 = likeState != 0 ? R.color.secondary : R.color.icon_gray;
            i13 = eVar;
            i18 = i9;
            i7 = i20;
            i6 = likeState;
        } else {
            i18 = i9;
            i7 = i20;
            i13 = i6;
        }
        i3 = i14;
        i5 = voteCount;
        i = i17;
        i2 = i19;
        i16 = i11;
        if (Long.compare(i41, i21) != 0) {
            obj.O.setVisibility(i);
        }
        if (Long.compare(i36, i21) != 0) {
            obj.P.setVisibility(i3);
        }
        if (Long.compare(i32, i21) != 0) {
            m.l(obj.R, obj.X);
        }
        if (Long.compare(i33, i21) != 0) {
            g.c(obj.S, i2);
        }
        obj.T.setEnabled(i6);
        if (Long.compare(i35, i21) != 0 && ViewDataBinding.t() >= 21) {
            obj.T.setEnabled(i6);
            if (ViewDataBinding.t() >= 21) {
                obj.T.setImageTintList(b.a(i13));
            }
        }
        if (Long.compare(i15, i21) != 0) {
            obj.V.setVisibility(i18);
        }
        if (Long.compare(i29, i21) != 0) {
            m.o(obj.W, i7);
        }
        if (Long.compare(i25, i21) != 0) {
            g.c(obj.X, i16);
        }
        if (Long.compare(i8, i21) != 0) {
            g.c(obj.Y, i5);
        }
    }

    @Override // app.dogo.com.dogo_android.h.s0
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
