package app.dogo.com.dogo_android.h;

import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.g0.a;

/* loaded from: classes.dex */
public class hi extends app.dogo.com.dogo_android.h.gi {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
    }

    public hi(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, hi.S, hi.T));
    }

    private hi(e e, View view2, Object[] object3Arr3) {
        int i = 1;
        super(e, view2, i, (Button)object3Arr3[i]);
        this.R = -1;
        Object obj3 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj3;
        final int obj5 = 0;
        obj3.setTag(obj5);
        this.O.setTag(obj5);
        N(view2);
        A();
    }

    private boolean U(a a, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.R = l8 |= i24;
            return obj5;
            synchronized (this) {
                this.R = l8 |= i24;
                return obj5;
            }
        }
        if (i2 == 25) {
            this.R = l7 |= i23;
            return obj5;
            synchronized (this) {
                this.R = l7 |= i23;
                return obj5;
            }
        }
        if (i2 == 17) {
            this.R = l6 |= i22;
            return obj5;
            synchronized (this) {
                this.R = l6 |= i22;
                return obj5;
            }
        }
        if (i2 == 152) {
            this.R = l5 |= i21;
            return obj5;
            synchronized (this) {
                this.R = l5 |= i21;
                return obj5;
            }
        }
        if (i2 == 6) {
            this.R = l4 |= i20;
            return obj5;
            synchronized (this) {
                this.R = l4 |= i20;
                return obj5;
            }
        }
        if (i2 == 153) {
            this.R = l3 |= i19;
            return obj5;
            synchronized (this) {
                this.R = l3 |= i19;
                return obj5;
            }
        }
        if (i2 == 84) {
            this.R = l2 |= i18;
            return obj5;
            synchronized (this) {
                this.R = l2 |= i18;
                return obj5;
            }
        }
        try {
            if (i2 == 82) {
            }
            this.R = l |= i17;
            return obj5;
            throw a;
            return 0;
        } catch (Throwable th) {
        }
    }

    @Override // app.dogo.com.dogo_android.h.gi
    public void A() {
        this.R = 256;
        I();
        return;
        synchronized (this) {
            this.R = 256;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gi
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return U((a)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.gi
    public boolean O(int i, Object object2) {
        int obj2;
        if (178 == i) {
            T((a)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.gi
    public void T(a a) {
        R(0, a);
        this.P = a;
        this.R = l |= i3;
        notifyPropertyChanged(178);
        super.I();
        return;
        synchronized (this) {
            R(0, a);
            this.P = a;
            this.R = l |= i3;
            notifyPropertyChanged(178);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gi
    protected void m() {
        int i5;
        int cmp4;
        int cmp6;
        int cmp3;
        int cmp;
        int cmp2;
        long l;
        int i3;
        int i10;
        int color2;
        int i2;
        int i9;
        int i11;
        int i12;
        int i7;
        int color;
        int i6;
        Context context;
        boolean i4;
        Context context2;
        int i;
        int cmp5;
        int cmp7;
        int i8;
        int cmp8;
        int i13;
        View view;
        int i14;
        final Object obj = this;
        l = obj.R;
        final int i16 = 0;
        obj.R = i16;
        i5 = 0;
        a aVar = obj.P;
        final int i26 = 265;
        final int i28 = 257;
        int i29 = 449;
        final int i32 = 259;
        int i33 = 1024;
        i8 = 0;
        synchronized (this) {
            obj = this;
            l = obj.R;
            i16 = 0;
            obj.R = i16;
            i5 = 0;
            aVar = obj.P;
            i26 = 265;
            i28 = 257;
            i29 = 449;
            i32 = 259;
            i33 = 1024;
            i8 = 0;
        }
        if (Long.compare(i35, i16) != 0 && aVar != null) {
            if (aVar != null) {
                try {
                    i5 = aVar.e();
                    if (Long.compare(i36, i16) != 0 && aVar != null) {
                    } else {
                    }
                    if (aVar != null) {
                    } else {
                    }
                    i9 = aVar.g();
                    i9 = i8;
                }
                color2 = i8;
                if (Long.compare(i27, i16) != 0 && aVar != null) {
                    if (aVar != null) {
                        i = aVar.h();
                    } else {
                        i = 0;
                    }
                } else {
                }
                if (Long.compare(i38, i16) != 0) {
                    if (aVar != null) {
                        i6 = cmp5;
                    } else {
                        i6 = i8;
                    }
                    color = w().getContext().getColor(i6);
                } else {
                    color = i8;
                }
                if (Long.compare(i39, i16) != 0 && aVar != null) {
                    if (aVar != null) {
                        i4 = aVar.j();
                    } else {
                        i4 = i8;
                    }
                } else {
                }
                cmp7 = Long.compare(i40, i16);
                if (cmp7 != 0) {
                    if (aVar != null) {
                        i13 = aVar.k();
                    } else {
                        i13 = i8;
                    }
                    if (cmp7 != 0) {
                        l = i13 != 0 ? l | i33 : l | i14;
                    }
                } else {
                    i13 = i8;
                }
                if (Long.compare(i34, i16) != 0 && aVar != null) {
                    if (aVar != null) {
                        i3 = aVar.f();
                    } else {
                        i3 = i8;
                    }
                } else {
                }
                int cmp15 = Long.compare(i30, i16);
                if (cmp15 != 0 && i13 != 0) {
                    if (i13 != 0) {
                        i8 = i3;
                    }
                }
                if (Long.compare(i31, i16) != 0 && ViewDataBinding.t() >= 11) {
                    if (ViewDataBinding.t() >= 11) {
                        obj.O.setAlpha(i5);
                    }
                }
                if (Long.compare(i24, i16) != 0) {
                    obj.O.setMaxLines(i9);
                }
                if (Long.compare(i11, i16) != 0 && ViewDataBinding.t() >= 21) {
                    if (ViewDataBinding.t() >= 21) {
                        obj.O.setBackgroundTintList(b.a(color2));
                    }
                }
                if (Long.compare(i18, i16) != 0) {
                    g.c(obj.O, i);
                }
                if (Long.compare(i2, i16) != 0 && ViewDataBinding.t() >= 14) {
                    if (ViewDataBinding.t() >= 14) {
                        obj.O.setAllCaps(i4);
                    }
                }
                if (Long.compare(i15, i16) != 0) {
                    obj.O.setTextColor(color);
                }
                if (cmp15 != 0) {
                    m.k(obj.O, i8);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.gi
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
