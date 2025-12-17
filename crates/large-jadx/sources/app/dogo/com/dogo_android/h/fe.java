package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class fe extends app.dogo.com.dogo_android.h.ee implements b.a {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0;
    private final ConstraintLayout V;
    private final View.OnClickListener W;
    private final View.OnClickListener X;
    private g Y;
    private g Z;
    private long a0;

    class a implements g {

        final app.dogo.com.dogo_android.h.fe a;
        a(app.dogo.com.dogo_android.h.fe fe) {
            this.a = fe;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object b0Var;
            int i2;
            int i;
            b0Var = feVar2.T;
            final int i3 = 0;
            i = b0Var != null ? i2 : i3;
            if (i != 0) {
                b0Var = b0Var.l();
                if (b0Var != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    b0Var.setValue(g.a(feVar.O));
                }
            }
        }
    }

    class b implements g {

        final app.dogo.com.dogo_android.h.fe a;
        b(app.dogo.com.dogo_android.h.fe fe) {
            this.a = fe;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object b0Var;
            int i;
            int i2;
            b0Var = feVar2.T;
            final int i3 = 0;
            i2 = b0Var != null ? i : i3;
            if (i2 != 0) {
                b0Var = b0Var.o();
                if (b0Var != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    b0Var.setValue(g.a(feVar.Q));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        fe.c0 = sparseIntArray;
        sparseIntArray.put(2131363414, 6);
    }

    public fe(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, fe.b0, fe.c0));
    }

    private fe(e e, View view2, Object[] object3Arr3) {
        final int i = 1;
        int i3 = 2;
        super(e, view2, 2, (EditText)object3Arr3[i], (Button)object3Arr3[4], (EditText)object3Arr3[i3], (Button)object3Arr3[3], (TextView)object3Arr3[5], (TextView)object3Arr3[6]);
        fe.a obj13 = new fe.a(this);
        this.Y = obj13;
        obj13 = new fe.b(this);
        this.Z = obj13;
        this.a0 = -1;
        int i8 = 0;
        this.O.setTag(i8);
        this.P.setTag(i8);
        obj13 = object3Arr3[0];
        this.V = (ConstraintLayout)obj13;
        obj13.setTag(i8);
        this.Q.setTag(i8);
        this.R.setTag(i8);
        this.S.setTag(i8);
        N(view2);
        obj13 = new b(this, i);
        this.W = obj13;
        obj13 = new b(this, i3);
        this.X = obj13;
        A();
    }

    private boolean X(x<String> x, int i2) {
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

    private boolean Y(x<String> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.ee
    public void A() {
        this.a0 = 16;
        I();
        return;
        synchronized (this) {
            this.a0 = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ee
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Y((x)object2, i3);
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ee
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((c0)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((b0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ee
    public void V(c0 c0) {
        this.U = c0;
        this.a0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.U = c0;
            this.a0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ee
    public void W(b0 b0) {
        this.T = b0;
        this.a0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = b0;
            this.a0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ee
    public final void b(int i, View view2) {
        int i2;
        b0 obj3;
        int obj4;
        obj4 = 0;
        final int i3 = 1;
        if (i != i3) {
            if (i != 2) {
            } else {
                obj3 = this.T;
                if (obj3 != null) {
                    obj4 = i3;
                }
                if (obj4 != null) {
                    obj3.R();
                }
            }
        } else {
            obj3 = this.T;
            if (obj3 != null) {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.T();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ee
    protected void m() {
        int cmp4;
        b0 b0Var;
        int value2;
        int cmp2;
        int value;
        int cmp;
        int cmp5;
        int i2;
        int i;
        int cmp3;
        long l = this.a0;
        final int i4 = 0;
        this.a0 = i4;
        b0Var = this.T;
        final int i9 = 26;
        int i10 = 25;
        final int i13 = 0;
        synchronized (this) {
            l = this.a0;
            i4 = 0;
            this.a0 = i4;
            b0Var = this.T;
            i9 = 26;
            i10 = 25;
            i13 = 0;
        }
        try {
            if (Long.compare(i, i4) != 0) {
            } else {
            }
            if (b0Var != null) {
            } else {
            }
            cmp2 = b0Var.l();
            cmp2 = i13;
            Q(0, cmp2);
            if (cmp2 != null) {
            } else {
            }
            value = cmp2.getValue();
            value = i13;
        }
        if (Long.compare(i14, i4) != 0) {
            if (b0Var != null) {
                b0Var = b0Var.o();
            } else {
                b0Var = i13;
            }
            Q(1, b0Var);
            if (b0Var != 0) {
                value2 = b0Var.getValue();
            } else {
                value2 = i13;
            }
        } else {
        }
        if (Long.compare(i11, i4) != 0) {
            g.c(this.O, value);
        }
        if (Long.compare(i2, i4) != 0) {
            g.e(this.O, i13, i13, i13, this.Y);
            this.P.setOnClickListener(this.X);
            g.e(this.Q, i13, i13, i13, this.Z);
            this.R.setOnClickListener(this.W);
        }
        if (Long.compare(i3, i4) != 0) {
            g.c(this.Q, value2);
        }
        if (Long.compare(i6, i4) != 0) {
            n.v0(this.S, this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ee
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
