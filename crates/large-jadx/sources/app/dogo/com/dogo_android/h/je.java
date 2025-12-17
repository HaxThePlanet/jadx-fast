package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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
public class je extends app.dogo.com.dogo_android.h.ie implements b.a {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0;
    private final CoordinatorLayout U;
    private final View.OnClickListener V;
    private g W;
    private g X;
    private long Y;

    class a implements g {

        final app.dogo.com.dogo_android.h.je a;
        a(app.dogo.com.dogo_android.h.je je) {
            this.a = je;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object b0Var;
            int i;
            int i2;
            b0Var = jeVar2.S;
            final int i3 = 0;
            i2 = b0Var != null ? i : i3;
            if (i2 != 0) {
                b0Var = b0Var.l();
                if (b0Var != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    b0Var.setValue(g.a(jeVar.O));
                }
            }
        }
    }

    class b implements g {

        final app.dogo.com.dogo_android.h.je a;
        b(app.dogo.com.dogo_android.h.je je) {
            this.a = je;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object b0Var;
            int i2;
            int i;
            b0Var = jeVar2.S;
            final int i3 = 0;
            i = b0Var != null ? i2 : i3;
            if (i != 0) {
                b0Var = b0Var.o();
                if (b0Var != null) {
                } else {
                    i2 = i3;
                }
                if (i2 != 0) {
                    b0Var.setValue(g.a(jeVar.P));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        je.a0 = sparseIntArray;
        sparseIntArray.put(2131363414, 5);
    }

    public je(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, je.Z, je.a0));
    }

    private je(e e, View view2, Object[] object3Arr3) {
        final int i = 1;
        super(e, view2, 2, (EditText)object3Arr3[i], (EditText)object3Arr3[2], (Button)object3Arr3[3], (TextView)object3Arr3[4], (TextView)object3Arr3[5]);
        je.a obj12 = new je.a(this);
        this.W = obj12;
        obj12 = new je.b(this);
        this.X = obj12;
        this.Y = -1;
        int i7 = 0;
        this.O.setTag(i7);
        obj12 = object3Arr3[0];
        this.U = (CoordinatorLayout)obj12;
        obj12.setTag(i7);
        this.P.setTag(i7);
        this.Q.setTag(i7);
        this.R.setTag(i7);
        N(view2);
        obj12 = new b(this, i);
        this.V = obj12;
        A();
    }

    private boolean X(x<String> x, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(x<String> x, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ie
    public void A() {
        this.Y = 16;
        I();
        return;
        synchronized (this) {
            this.Y = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ie
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Y((x)object2, i3);
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ie
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

    @Override // app.dogo.com.dogo_android.h.ie
    public void V(c0 c0) {
        this.T = c0;
        this.Y = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.T = c0;
            this.Y = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ie
    public void W(b0 b0) {
        this.S = b0;
        this.Y = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = b0;
            this.Y = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ie
    public final void b(int i, View view2) {
        int obj2;
        final b0 obj1 = this.S;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.U();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ie
    protected void m() {
        int cmp;
        b0 b0Var;
        int value2;
        int cmp4;
        int value;
        int cmp5;
        int cmp3;
        int i;
        int i2;
        int cmp2;
        long l = this.Y;
        final int i4 = 0;
        this.Y = i4;
        b0Var = this.S;
        final int i9 = 26;
        int i10 = 25;
        final int i13 = 0;
        synchronized (this) {
            l = this.Y;
            i4 = 0;
            this.Y = i4;
            b0Var = this.S;
            i9 = 26;
            i10 = 25;
            i13 = 0;
        }
        try {
            if (Long.compare(i2, i4) != 0) {
            } else {
            }
            if (b0Var != null) {
            } else {
            }
            cmp4 = b0Var.l();
            cmp4 = i13;
            Q(0, cmp4);
            if (cmp4 != null) {
            } else {
            }
            value = cmp4.getValue();
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
        if (Long.compare(i, i4) != 0) {
            g.e(this.O, i13, i13, i13, this.W);
            g.e(this.P, i13, i13, i13, this.X);
            this.Q.setOnClickListener(this.V);
        }
        if (Long.compare(i3, i4) != 0) {
            g.c(this.P, value2);
        }
        if (Long.compare(i6, i4) != 0) {
            n.v0(this.R, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ie
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
