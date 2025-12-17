package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.d.d.r.f;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.f0.m;

/* loaded from: classes.dex */
public class f2 extends app.dogo.com.dogo_android.h.e2 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = null;
    private final LinearLayout T;
    private final ConstraintLayout U;
    private long V;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(6);
        f2.W = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i6 = 0;
        iArr2[i6] = 5;
        int[] iArr = new int[i3];
        iArr[i6] = 2131558777;
        gVar.a(i6, /* result */, iArr2, iArr);
        int i = 0;
    }

    public f2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, f2.W, f2.X));
    }

    private f2(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (sk)object3Arr3[5], (TextView)object3Arr3[3], (ImageView)object3Arr3[4], (TextView)object3Arr3[2]);
        this.V = -1;
        L(this.O);
        int i6 = 0;
        this.P.setTag(i6);
        this.Q.setTag(i6);
        this.R.setTag(i6);
        Object obj10 = object3Arr3[0];
        this.T = (LinearLayout)obj10;
        obj10.setTag(i6);
        obj10 = object3Arr3[1];
        this.U = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.sk sk, int i2) {
        if (i2 == 0) {
            this.V = obj3 |= i;
            return 1;
            synchronized (this) {
                this.V = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(f f, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.V = l5 |= i15;
            return obj5;
            synchronized (this) {
                this.V = l5 |= i15;
                return obj5;
            }
        }
        if (i2 == 33) {
            this.V = l4 |= i14;
            return obj5;
            synchronized (this) {
                this.V = l4 |= i14;
                return obj5;
            }
        }
        if (i2 == 37) {
            this.V = l |= i11;
            return obj5;
            synchronized (this) {
                this.V = l |= i11;
                return obj5;
            }
        }
        if (i2 == 34) {
            this.V = l2 |= i12;
            return obj5;
            synchronized (this) {
                this.V = l2 |= i12;
                return obj5;
            }
        }
        if (i2 == 35) {
            this.V = l3 |= i13;
            return obj5;
            synchronized (this) {
                this.V = l3 |= i13;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.e2
    public void A() {
        this.V = 128;
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.V = 128;
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.e2
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Y((f)object2, i3);
        }
        return X((sk)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.e2
    public void M(q q) {
        super.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.e2
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            W((f)object2);
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

    @Override // app.dogo.com.dogo_android.h.e2
    public void V(a0 a0) {
    }

    @Override // app.dogo.com.dogo_android.h.e2
    public void W(f f) {
        R(1, f);
        this.S = f;
        this.V = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(1, f);
            this.S = f;
            this.V = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.e2
    protected void m() {
        String str;
        int cmp4;
        long l;
        int i8;
        int i7;
        int cmp5;
        int i;
        int i5;
        int i12;
        int i9;
        String str2;
        int i6;
        int cmp2;
        int cmp;
        int i3;
        int i11;
        String str3;
        int i2;
        int i13;
        int cmp3;
        int i4;
        int i10;
        final Object obj = this;
        l = obj.V;
        final int i17 = 0;
        obj.V = i17;
        f fVar = obj.S;
        final int i22 = 194;
        final int i23 = 146;
        int i24 = 162;
        i2 = 0;
        synchronized (this) {
            obj = this;
            l = obj.V;
            i17 = 0;
            obj.V = i17;
            fVar = obj.S;
            i22 = 194;
            i23 = 146;
            i24 = 162;
            i2 = 0;
        }
        int cmp7 = Long.compare(i13, i17);
        if (cmp7 != 0) {
            if (fVar != null) {
                try {
                    i2 = fVar.l();
                    if (cmp7 != 0) {
                    }
                    if (i2 != 0) {
                    } else {
                    }
                    i15 |= i29;
                    i13 = 8192;
                    i16 |= i31;
                    i13 = 4096;
                    i8 |= i13;
                    int i21 = 2131100379;
                    TextView view3 = obj.R;
                }
                i11 = ViewDataBinding.u(view3, i21);
                if (i2 != 0) {
                    i7 = ViewDataBinding.u(obj.P, i21);
                } else {
                    i7 = ViewDataBinding.u(obj.P, 2131099840);
                }
                i6 = i2 != 0 ? R.color.secondary : R.color.lightGray;
                i9 = ViewDataBinding.u(obj.U, i6);
                i2 = i11;
            }
        } else {
            i9 = i7;
        }
        if (Long.compare(i32, i17) != 0 && fVar != null) {
            if (fVar != null) {
                str2 = fVar.j();
            } else {
                str2 = 0;
            }
        } else {
        }
        if (Long.compare(i33, i17) != 0 && fVar != null) {
            if (fVar != null) {
                str3 = fVar.h();
            } else {
                str3 = 0;
            }
        } else {
        }
        if (Long.compare(i34, i17) != 0 && fVar != null) {
            if (fVar != null) {
                i3 = str4;
                str = i4;
                i2 = i9;
                i = i10;
            } else {
                str = str3;
                i3 = 0;
                i2 = i9;
                i = i4;
            }
        } else {
        }
        if (Long.compare(i25, i17) != 0) {
            g.c(obj.P, i3);
        }
        if (Long.compare(i27, i17) != 0) {
            obj.P.setTextColor(i7);
            obj.R.setTextColor(i);
            h.a(obj.U, b.b(i2));
        }
        if (Long.compare(i20, i17) != 0) {
            m.o(obj.Q, str);
        }
        if (Long.compare(i14, i17) != 0) {
            g.c(obj.R, str2);
        }
        ViewDataBinding.o(obj.O);
    }

    @Override // app.dogo.com.dogo_android.h.e2
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.O.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
