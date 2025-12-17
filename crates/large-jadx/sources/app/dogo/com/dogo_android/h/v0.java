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
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.d.a.n.e;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class v0 extends app.dogo.com.dogo_android.h.u0 {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout V;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v0.Y = sparseIntArray;
        sparseIntArray.put(2131361915, 7);
    }

    public v0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, v0.X, v0.Y));
    }

    private v0(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (ImageView)object3Arr3[4], (ImageView)object3Arr3[2], (View)object3Arr3[7], (ImageView)object3Arr3[6], (ImageView)object3Arr3[3], (ImageView)object3Arr3[1], (TextView)object3Arr3[5]);
        this.W = -1;
        int i9 = 0;
        this.O.setTag(i9);
        this.P.setTag(i9);
        this.Q.setTag(i9);
        Object obj13 = object3Arr3[0];
        this.V = (ConstraintLayout)obj13;
        obj13.setTag(i9);
        this.R.setTag(i9);
        this.S.setTag(i9);
        this.T.setTag(i9);
        N(view2);
        A();
    }

    private boolean W(e e, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.W = l6 |= i18;
            return obj5;
            synchronized (this) {
                this.W = l6 |= i18;
                return obj5;
            }
        }
        if (i2 == 174) {
            this.W = l5 |= i17;
            return obj5;
            synchronized (this) {
                this.W = l5 |= i17;
                return obj5;
            }
        }
        if (i2 == 11) {
            this.W = l |= i13;
            return obj5;
            synchronized (this) {
                this.W = l |= i13;
                return obj5;
            }
        }
        if (i2 == 12) {
            this.W = l2 |= i14;
            return obj5;
            synchronized (this) {
                this.W = l2 |= i14;
                return obj5;
            }
        }
        if (i2 == 10) {
            this.W = l3 |= i15;
            return obj5;
            synchronized (this) {
                this.W = l3 |= i15;
                return obj5;
            }
        }
        if (i2 == 65) {
            this.W = l4 |= i16;
            return obj5;
            synchronized (this) {
                this.W = l4 |= i16;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.u0
    public void A() {
        this.W = 64;
        I();
        return;
        synchronized (this) {
            this.W = 64;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u0
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((e)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.u0
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

    @Override // app.dogo.com.dogo_android.h.u0
    public void V(e e) {
        R(0, e);
        this.U = e;
        this.W = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, e);
            this.U = e;
            this.W = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u0
    protected void m() {
        int i7;
        int cmp2;
        int cmp6;
        int cmp7;
        int cmp;
        boolean eVar;
        long l;
        int i6;
        int i10;
        int cmp5;
        int i;
        int i9;
        int cmp3;
        int i3;
        int i11;
        int i4;
        int i8;
        int i2;
        int cmp4;
        int i5;
        final Object obj = this;
        l = obj.W;
        final int i13 = 0;
        obj.W = i13;
        eVar = obj.U;
        int i16 = 67;
        int i19 = 73;
        int i23 = 81;
        final int i21 = 0;
        i10 = 0;
        synchronized (this) {
            obj = this;
            l = obj.W;
            i13 = 0;
            obj.W = i13;
            eVar = obj.U;
            i16 = 67;
            i19 = 73;
            i23 = 81;
            i21 = 0;
            i10 = 0;
        }
        if (Long.compare(i29, i13) != 0 && eVar != null) {
            if (eVar != null) {
                try {
                    i6 = eVar.b();
                    i6 = i21;
                    int cmp10 = Long.compare(i30, i13);
                    i4 = 8;
                    if (eVar != null) {
                    } else {
                    }
                    i8 = eVar.g();
                    i8 = i10;
                }
                i11 = i10;
                if (Long.compare(i31, i13) != 0 && eVar != null) {
                    if (eVar != null) {
                        i8 = eVar.d();
                    } else {
                        i8 = i21;
                    }
                } else {
                }
                int cmp12 = Long.compare(i32, i13);
                if (cmp12 != 0) {
                    if (eVar != null) {
                        cmp4 = eVar.e();
                    } else {
                        cmp4 = i10;
                    }
                    if (cmp12 != 0) {
                        i5 = cmp4 != 0 ? 1024 : 512;
                        l |= i5;
                    }
                    if (cmp4 != 0) {
                        i2 = i10;
                    } else {
                        i2 = i4;
                    }
                } else {
                }
                cmp4 = Long.compare(i33, i13);
                if (cmp4 != 0) {
                    if (eVar != null) {
                        eVar = eVar.f();
                    } else {
                        eVar = i10;
                    }
                    if (cmp4 != 0) {
                        cmp4 = eVar ? 256 : 128;
                        l |= cmp4;
                    }
                    if (eVar) {
                    } else {
                        i10 = i4;
                    }
                }
                i7 = i10;
                i = i11;
                i9 = i8;
                i10 = i2;
                if (Long.compare(i24, i13) != 0) {
                    obj.O.setVisibility(i10);
                }
                if (Long.compare(i26, i13) != 0) {
                    obj.P.setVisibility(i7);
                }
                if (Long.compare(i28, i13) != 0) {
                    n.g0(obj.Q, i21);
                }
                if (Long.compare(i20, i13) != 0) {
                    obj.R.setVisibility(i);
                }
                if (Long.compare(i17, i13) != 0) {
                    m.o(obj.S, i9);
                }
                if (Long.compare(i12, i13) != 0) {
                    g.c(obj.T, i6);
                }
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.u0
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
