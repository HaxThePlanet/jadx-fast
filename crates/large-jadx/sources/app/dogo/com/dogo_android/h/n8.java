package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.k.a;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.a0.g.f.f0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public class n8 extends app.dogo.com.dogo_android.h.m8 implements b.a {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0;
    private final FrameLayout U;
    private final TextView V;
    private final FrameLayout W;
    private final View.OnClickListener X;
    private g Y;
    private g Z;
    private long a0;

    class a implements g {

        final app.dogo.com.dogo_android.h.n8 a;
        a(app.dogo.com.dogo_android.h.n8 n8) {
            this.a = n8;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int i;
            f0 f0Var = n8Var2.S;
            i = f0Var != null ? 1 : 0;
            if (i != 0) {
                f0Var.E(n8Var.O.isChecked());
            }
        }
    }

    class b implements g {

        final app.dogo.com.dogo_android.h.n8 a;
        b(app.dogo.com.dogo_android.h.n8 n8) {
            this.a = n8;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int i;
            f0 f0Var = n8Var2.S;
            i = f0Var != null ? 1 : 0;
            if (i != 0) {
                f0Var.D(n8Var.P.isChecked());
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n8.c0 = sparseIntArray;
        sparseIntArray.put(2131362701, 5);
        sparseIntArray.put(2131362493, 6);
    }

    public n8(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, n8.b0, n8.c0));
    }

    private n8(e e, View view2, Object[] object3Arr3) {
        final int i = 1;
        super(e, view2, 1, (AppCompatCheckBox)object3Arr3[i], (AppCompatCheckBox)object3Arr3[3], (RelativeLayout)object3Arr3[6], (RelativeLayout)object3Arr3[5]);
        n8.a obj11 = new n8.a(this);
        this.Y = obj11;
        obj11 = new n8.b(this);
        this.Z = obj11;
        this.a0 = -1;
        int i6 = 0;
        this.O.setTag(i6);
        this.P.setTag(i6);
        obj11 = object3Arr3[0];
        this.U = (FrameLayout)obj11;
        obj11.setTag(i6);
        obj11 = object3Arr3[2];
        this.V = (TextView)obj11;
        obj11.setTag(i6);
        obj11 = object3Arr3[4];
        this.W = (FrameLayout)obj11;
        obj11.setTag(i6);
        N(view2);
        obj11 = new b(this, i);
        this.X = obj11;
        A();
    }

    private boolean X(f0 f0, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.a0 = l3 |= i9;
            return obj5;
            synchronized (this) {
                this.a0 = l3 |= i9;
                return obj5;
            }
        }
        if (i2 == 98) {
            this.a0 = l2 |= i8;
            return obj5;
            synchronized (this) {
                this.a0 = l2 |= i8;
                return obj5;
            }
        }
        if (i2 == 69) {
            this.a0 = l |= i7;
            return obj5;
            synchronized (this) {
                this.a0 = l |= i7;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.m8
    public void A() {
        this.a0 = 16;
        I();
        return;
        synchronized (this) {
            this.a0 = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m8
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((f0)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.m8
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            W((f0)object2);
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

    @Override // app.dogo.com.dogo_android.h.m8
    public void V(a0 a0) {
        this.T = a0;
        this.a0 = l |= i2;
        notifyPropertyChanged(116);
        super.I();
        return;
        synchronized (this) {
            this.T = a0;
            this.a0 = l |= i2;
            notifyPropertyChanged(116);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m8
    public void W(f0 f0) {
        R(0, f0);
        this.S = f0;
        this.a0 = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, f0);
            this.S = f0;
            this.a0 = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m8
    public final void b(int i, View view2) {
        int i2;
        final f0 obj2 = this.S;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.B(this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.m8
    protected void m() {
        int cmp4;
        int cmp2;
        int cmp3;
        int cmp;
        int format;
        String str;
        int string;
        int featured;
        Object[] cmp5;
        int i3;
        int i;
        int resources;
        int i2;
        final Object obj = this;
        long l = obj.a0;
        final int i5 = 0;
        obj.a0 = i5;
        f0 f0Var = obj.S;
        int i9 = 25;
        final int i17 = 21;
        i = 0;
        final int i18 = 0;
        synchronized (this) {
            obj = this;
            l = obj.a0;
            i5 = 0;
            obj.a0 = i5;
            f0Var = obj.S;
            i9 = 25;
            i17 = 21;
            i = 0;
            i18 = 0;
        }
        if (Long.compare(resources, i5) != 0) {
            if (f0Var != null) {
                try {
                    str = f0Var.y(24);
                    str = i18;
                    cmp5 = new Object[1];
                    cmp5[i] = str;
                    format = String.format(obj.V.getResources().getString(2131886291), cmp5);
                    format = i18;
                    featured = f0Var.isFeatured();
                }
                featured = i;
                if (Long.compare(i2, i5) != 0 && f0Var != null) {
                    if (f0Var != null) {
                        i = f0Var.z();
                    }
                }
                if (Long.compare(i15, i5) != 0) {
                    a.a(obj.O, i);
                }
                if (Long.compare(i3, i5) != 0) {
                    a.b(obj.O, i18, obj.Y);
                    a.b(obj.P, i18, obj.Z);
                    obj.W.setOnClickListener(obj.X);
                }
                if (Long.compare(i10, i5) != 0) {
                    a.a(obj.P, featured);
                }
                if (Long.compare(i4, i5) != 0) {
                    g.c(obj.V, format);
                }
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.m8
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
