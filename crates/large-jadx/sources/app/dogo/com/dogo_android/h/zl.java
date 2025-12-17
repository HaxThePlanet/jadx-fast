package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* loaded from: classes.dex */
public class zl extends app.dogo.com.dogo_android.h.yl {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
    }

    public zl(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, zl.V, zl.W));
    }

    private zl(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (TextView)object3Arr3[1]);
        this.U = -1;
        int i4 = 0;
        this.O.setTag(i4);
        this.P.setTag(i4);
        Object obj8 = object3Arr3[0];
        this.T = (ConstraintLayout)obj8;
        obj8.setTag(i4);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yl
    public void A() {
        this.U = 8;
        I();
        return;
        synchronized (this) {
            this.U = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yl
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.yl
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (70 == i) {
            U((String)object2);
            obj2 = 1;
        } else {
            if (96 == i) {
                V((String)object2);
            } else {
                if (60 == i) {
                    T((String)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.yl
    public void T(String string) {
        this.Q = string;
        this.U = l |= i2;
        notifyPropertyChanged(60);
        super.I();
        return;
        synchronized (this) {
            this.Q = string;
            this.U = l |= i2;
            notifyPropertyChanged(60);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yl
    public void U(String string) {
        this.S = string;
        this.U = l |= i2;
        notifyPropertyChanged(70);
        super.I();
        return;
        synchronized (this) {
            this.S = string;
            this.U = l |= i2;
            notifyPropertyChanged(70);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yl
    public void V(String string) {
        this.R = string;
        this.U = l |= i2;
        notifyPropertyChanged(96);
        super.I();
        return;
        synchronized (this) {
            this.R = string;
            this.U = l |= i2;
            notifyPropertyChanged(96);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yl
    protected void m() {
        String str2;
        int cmp3;
        int cmp;
        long l;
        int i;
        int i8;
        String str;
        int empty;
        int i5;
        int i4;
        int i6;
        int cmp2;
        int i7;
        int i3;
        int i2;
        final Object obj = this;
        l = obj.U;
        final int i10 = 0;
        obj.U = i10;
        str2 = obj.S;
        i = 0;
        i8 = 0;
        str = obj.Q;
        int i12 = 13;
        int cmp5 = Long.compare(i15, i10);
        int i16 = 16;
        i7 = 0;
        synchronized (this) {
            obj = this;
            l = obj.U;
            i10 = 0;
            obj.U = i10;
            str2 = obj.S;
            i = 0;
            i8 = 0;
            str = obj.Q;
            i12 = 13;
            cmp5 = Long.compare(i15, i10);
            i16 = 16;
            i7 = 0;
        }
        if (str == null) {
            i3 = i5;
        } else {
            try {
                i3 = i7;
                if (cmp5 != 0) {
                }
                if (i3 != 0) {
                } else {
                }
                l |= i2;
                l |= i16;
                i3 = i7;
            }
            if (str != null) {
                empty = str.isEmpty();
            } else {
                empty = i7;
            }
            int i19 = 12;
            if (Long.compare(i18, i10) != 0) {
                if (i3 != 0) {
                } else {
                    i5 = empty;
                }
                if (Long.compare(i4, i10) != 0) {
                    i4 = i5 != 0 ? 128 : 64;
                    l |= i4;
                }
                if (Long.compare(i6, i10) != 0) {
                    i6 = i5 != 0 ? 512 : 256;
                    l |= i6;
                }
                if (Long.compare(cmp2, i10) != 0) {
                    i = i5 != 0 ? 1050253722 : 1065353216;
                }
                i7 = i5;
            }
            int cmp4 = Long.compare(i13, i10);
            if (cmp4 != 0) {
                if (i7 != 0) {
                } else {
                    str2 = str;
                }
                i8 = str2;
            }
            if (Long.compare(i14, i10) != 0 && ViewDataBinding.t() >= 11) {
                if (ViewDataBinding.t() >= 11) {
                    obj.O.setAlpha(i);
                }
            }
            if (cmp4 != 0) {
                g.c(obj.O, i8);
            }
            if (Long.compare(i9, i10) != 0) {
                g.c(obj.P, obj.R);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.yl
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
