package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.k.f;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.p.b0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class fc extends app.dogo.com.dogo_android.h.ec {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout U;
    private g V;
    private long W;

    class a implements g {

        final app.dogo.com.dogo_android.h.fc a;
        a(app.dogo.com.dogo_android.h.fc fc) {
            this.a = fc;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int valueOf;
            Object b0Var;
            int i;
            int i2;
            b0Var = fcVar2.T;
            final int i3 = 0;
            i2 = b0Var != null ? i : i3;
            if (i2 != 0) {
                b0Var = b0Var.m();
                if (b0Var != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    b0Var.setValue(Integer.valueOf(fcVar.O.getValue()));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        fc.Y = sparseIntArray;
        sparseIntArray.put(2131363433, 4);
    }

    public fc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, fc.X, fc.Y));
    }

    private fc(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (NumberPicker)object3Arr3[2], (Button)object3Arr3[3], (TextView)object3Arr3[1], (MaterialToolbar)object3Arr3[4]);
        fc.a obj10 = new fc.a(this);
        this.V = obj10;
        this.W = -1;
        int i6 = 0;
        this.O.setTag(i6);
        obj10 = object3Arr3[0];
        this.U = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        this.P.setTag(i6);
        this.Q.setTag(i6);
        N(view2);
        A();
    }

    private boolean X(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.W = obj3 |= i;
            return 1;
            synchronized (this) {
                this.W = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.W = obj3 |= i;
            return 1;
            synchronized (this) {
                this.W = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ec
    public void A() {
        this.W = 16;
        I();
        return;
        synchronized (this) {
            this.W = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ec
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Y((x)object2, i3);
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ec
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (161 == i) {
            V((String)object2);
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

    @Override // app.dogo.com.dogo_android.h.ec
    public void V(String string) {
        this.S = string;
        this.W = l |= i2;
        notifyPropertyChanged(161);
        super.I();
        return;
        synchronized (this) {
            this.S = string;
            this.W = l |= i2;
            notifyPropertyChanged(161);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ec
    public void W(b0 b0) {
        this.T = b0;
        this.W = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = b0;
            this.W = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ec
    protected void m() {
        int cmp3;
        x b0Var;
        Object value;
        int value2;
        x xVar;
        int cmp2;
        int cmp;
        int cmp4;
        int i2;
        int i;
        int i3;
        final Object obj = this;
        long l = obj.W;
        final int i5 = 0;
        obj.W = i5;
        b0Var = obj.T;
        final int i10 = 26;
        i2 = 1;
        final int i12 = 25;
        final int i13 = 0;
        synchronized (this) {
            obj = this;
            l = obj.W;
            i5 = 0;
            obj.W = i5;
            b0Var = obj.T;
            i10 = 26;
            i2 = 1;
            i12 = 25;
            i13 = 0;
        }
        if (Long.compare(i14, i5) != 0) {
            if (b0Var != null) {
                try {
                    xVar = b0Var.m();
                    xVar = i13;
                    obj.Q(0, xVar);
                    if (xVar != null) {
                    } else {
                    }
                    value2 = xVar.getValue();
                    value2 = i13;
                    i = ViewDataBinding.J(value2);
                }
                if (b0Var != null) {
                    b0Var = b0Var.n();
                } else {
                    b0Var = i13;
                }
                obj.Q(i2, b0Var);
                if (b0Var != null) {
                    value = b0Var.getValue();
                } else {
                    value = i13;
                }
                if (Long.compare(i16, i5) != 0) {
                    o.Y(obj.O, i2);
                    f.a(obj.O, i13, obj.V);
                }
                if (Long.compare(i11, i5) != 0) {
                    f.b(obj.O, i);
                }
                if (Long.compare(i4, i5) != 0) {
                    n.x0(obj.U, value);
                    n.Z(obj.P, value);
                }
                if (Long.compare(i7, i5) != 0) {
                    g.c(obj.Q, obj.S);
                }
            } else {
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ec
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
