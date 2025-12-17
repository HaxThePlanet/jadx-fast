package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.i;
import androidx.databinding.k.g;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.a0.g.f.e0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class j8 extends app.dogo.com.dogo_android.h.i8 implements b.a {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0;
    private final LinearLayout V;
    private final TextView W;
    private final View.OnClickListener X;
    private final View.OnClickListener Y;
    private g Z;
    private long a0;

    class a implements g {

        final app.dogo.com.dogo_android.h.j8 a;
        a(app.dogo.com.dogo_android.h.j8 j8) {
            this.a = j8;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object e0Var;
            int i;
            int i2;
            e0Var = j8Var2.T;
            final int i3 = 0;
            i2 = e0Var != null ? i : i3;
            if (i2 != 0) {
                e0Var = e0Var.I;
                if (e0Var != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    e0Var.e(g.a(j8Var.P));
                }
            }
        }
    }
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(7);
        j8.b0 = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i7 = 0;
        iArr2[i7] = 5;
        int[] iArr = new int[i3];
        iArr[i7] = 2131558813;
        gVar.a(i7, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        j8.c0 = sparseIntArray;
        sparseIntArray.put(2131362108, 6);
    }

    public j8(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, j8.b0, j8.c0));
    }

    private j8(e e, View view2, Object[] object3Arr3) {
        int i3 = 1;
        final int i8 = 2;
        super(e, view2, 3, (FrameLayout)object3Arr3[6], (EditText)object3Arr3[3], (ImageView)object3Arr3[i3], (cn)object3Arr3[5], (ImageView)object3Arr3[i8]);
        j8.a obj12 = new j8.a(this);
        this.Z = obj12;
        this.a0 = -1;
        int i6 = 0;
        this.P.setTag(i6);
        this.Q.setTag(i6);
        obj12 = object3Arr3[0];
        this.V = (LinearLayout)obj12;
        obj12.setTag(i6);
        obj12 = object3Arr3[4];
        this.W = (TextView)obj12;
        obj12.setTag(i6);
        L(this.R);
        this.S.setTag(i6);
        N(view2);
        obj12 = new b(this, i3);
        this.X = obj12;
        obj12 = new b(this, i8);
        this.Y = obj12;
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.cn cn, int i2) {
        if (i2 == 0) {
            this.a0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.a0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(e0 e0, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.a0 = l3 |= i9;
            return obj5;
            synchronized (this) {
                this.a0 = l3 |= i9;
                return obj5;
            }
        }
        if (i2 == 85) {
            this.a0 = l2 |= i8;
            return obj5;
            synchronized (this) {
                this.a0 = l2 |= i8;
                return obj5;
            }
        }
        if (i2 == 63) {
            this.a0 = l |= i7;
            return obj5;
            synchronized (this) {
                this.a0 = l |= i7;
                return obj5;
            }
        }
        return 0;
    }

    private boolean Z(i<String> i, int i2) {
        if (i2 == 0) {
            this.a0 = obj3 |= i3;
            return 1;
            synchronized (this) {
                this.a0 = obj3 |= i3;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public void A() {
        this.a0 = 64;
        this.R.A();
        I();
        return;
        synchronized (this) {
            this.a0 = 64;
            this.R.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i8
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return X((cn)object2, i3);
            }
            return Y((e0)object2, i3);
        }
        return Z((i)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public void M(q q) {
        super.M(q);
        this.R.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            W((e0)object2);
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

    @Override // app.dogo.com.dogo_android.h.i8
    public void V(a0 a0) {
        this.U = a0;
        this.a0 = l |= i2;
        notifyPropertyChanged(116);
        super.I();
        return;
        synchronized (this) {
            this.U = a0;
            this.a0 = l |= i2;
            notifyPropertyChanged(116);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public void W(e0 e0) {
        R(1, e0);
        this.T = e0;
        this.a0 = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(1, e0);
            this.T = e0;
            this.a0 = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public final void b(int i, View view2) {
        a0 a0Var;
        e0 obj3;
        int obj4;
        obj4 = 0;
        final int i2 = 1;
        if (i != i2) {
            if (i != 2) {
            } else {
                obj3 = this.T;
                if (obj3 != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    obj3.R(this.U);
                }
            }
        } else {
            obj3 = this.T;
            if (obj3 != null) {
                obj4 = i2;
            }
            if (obj4 != null) {
                obj3.P(this.U);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.i8
    protected void m() {
        int i2;
        int cmp5;
        int cmp3;
        int cmp2;
        Object e0Var;
        int i;
        int cmp4;
        int i3;
        String dogAvatar;
        int cmp;
        final Object obj = this;
        long l = obj.a0;
        final int i5 = 0;
        obj.a0 = i5;
        e0Var = obj.T;
        final int i8 = 98;
        int i9 = 82;
        int i11 = 67;
        final int i14 = 0;
        synchronized (this) {
            obj = this;
            l = obj.a0;
            i5 = 0;
            obj.a0 = i5;
            e0Var = obj.T;
            i8 = 98;
            i9 = 82;
            i11 = 67;
            i14 = 0;
        }
        if (Long.compare(i15, i5) != 0 && e0Var != null) {
            if (e0Var != null) {
                try {
                    i = e0Var.C();
                    i = i14;
                    if (Long.compare(i16, i5) != 0 && e0Var != null) {
                    } else {
                    }
                    if (e0Var != null) {
                    } else {
                    }
                    dogAvatar = e0Var.getDogAvatar();
                    dogAvatar = i14;
                }
                e0Var = e0Var != null ? e0Var.I : i14;
                obj.R(0, e0Var);
                if (e0Var != null) {
                    i2 = e0Var.d();
                } else {
                    i2 = i14;
                }
                if (Long.compare(i12, i5) != 0) {
                    g.c(obj.P, i2);
                }
                if (Long.compare(i3, i5) != 0) {
                    g.e(obj.P, i14, i14, i14, obj.Z);
                    obj.Q.setOnClickListener(obj.X);
                    obj.W.setOnClickListener(obj.Y);
                }
                if (Long.compare(i10, i5) != 0) {
                    n.y(obj.Q, i);
                }
                if (Long.compare(i4, i5) != 0) {
                    m.o(obj.S, dogAvatar);
                }
                ViewDataBinding.o(obj.R);
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.R.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
