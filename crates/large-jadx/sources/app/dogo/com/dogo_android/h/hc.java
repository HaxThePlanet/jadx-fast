package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.q.p.e0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class hc extends app.dogo.com.dogo_android.h.gc {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout S;
    private g T;
    private long U;

    class a implements g {

        final app.dogo.com.dogo_android.h.hc a;
        a(app.dogo.com.dogo_android.h.hc hc) {
            this.a = hc;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            Object e0Var;
            int i;
            int i2;
            e0Var = hcVar2.R;
            final int i3 = 0;
            i2 = e0Var != null ? i : i3;
            if (i2 != 0) {
                e0Var = e0Var.m();
                if (e0Var != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    e0Var.setValue(g.a(hcVar.O));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        hc.W = sparseIntArray;
        sparseIntArray.put(2131363433, 3);
        sparseIntArray.put(2131363414, 4);
    }

    public hc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, hc.V, hc.W));
    }

    private hc(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (EditText)object3Arr3[1], (Button)object3Arr3[2], (TextView)object3Arr3[4], (MaterialToolbar)object3Arr3[3]);
        hc.a obj10 = new hc.a(this);
        this.T = obj10;
        this.U = -1;
        int i6 = 0;
        this.O.setTag(i6);
        obj10 = object3Arr3[0];
        this.S = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        this.P.setTag(i6);
        N(view2);
        A();
    }

    private boolean W(x<String> x, int i2) {
        if (i2 == 0) {
            this.U = obj3 |= i;
            return 1;
            synchronized (this) {
                this.U = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.U = obj3 |= i;
            return 1;
            synchronized (this) {
                this.U = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.gc
    public void A() {
        this.U = 8;
        I();
        return;
        synchronized (this) {
            this.U = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gc
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((x)object2, i3);
        }
        return W((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.gc
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((e0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.gc
    public void V(e0 e0) {
        this.R = e0;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = e0;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gc
    protected void m() {
        int cmp;
        e0 e0Var;
        int value2;
        int cmp3;
        int value;
        int cmp4;
        int cmp5;
        int i;
        int i2;
        int cmp2;
        long l = this.U;
        final int i4 = 0;
        this.U = i4;
        e0Var = this.R;
        final int i7 = 14;
        int i8 = 13;
        final int i11 = 0;
        synchronized (this) {
            l = this.U;
            i4 = 0;
            this.U = i4;
            e0Var = this.R;
            i7 = 14;
            i8 = 13;
            i11 = 0;
        }
        try {
            if (Long.compare(i2, i4) != 0) {
            } else {
            }
            if (e0Var != null) {
            } else {
            }
            cmp3 = e0Var.m();
            cmp3 = i11;
            Q(0, cmp3);
            if (cmp3 != null) {
            } else {
            }
            value = cmp3.getValue();
            value = i11;
        }
        if (Long.compare(i12, i4) != 0) {
            if (e0Var != null) {
                e0Var = e0Var.n();
            } else {
                e0Var = i11;
            }
            Q(1, e0Var);
            if (e0Var != 0) {
                value2 = e0Var.getValue();
            } else {
                value2 = i11;
            }
        } else {
        }
        if (Long.compare(i9, i4) != 0) {
            g.c(this.O, value);
        }
        if (Long.compare(i, i4) != 0) {
            g.e(this.O, i11, i11, i11, this.T);
        }
        if (Long.compare(i3, i4) != 0) {
            n.x0(this.S, value2);
            n.Z(this.P, value2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gc
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
