package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.b0.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class j extends app.dogo.com.dogo_android.h.i {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(6);
        j.V = gVar;
        int i4 = 2;
        final int[] iArr2 = new int[i4];
        iArr2 = new int[]{3, 4};
        int[] iArr = new int[i4];
        iArr = new int[]{2131558814, 2131558433};
        gVar.a(0, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        j.W = sparseIntArray;
        sparseIntArray.put(2131362533, 5);
    }

    public j(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, j.V, j.W));
    }

    private j(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 4, (CoordinatorLayout)object3Arr3[2], (FrameLayout)object3Arr3[5], (k)object3Arr3[4], (FrameLayout)object3Arr3[1], (en)object3Arr3[3]);
        this.U = -1;
        int i7 = 0;
        this.O.setTag(i7);
        Object obj11 = object3Arr3[0];
        this.T = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        L(this.P);
        this.Q.setTag(i7);
        L(this.R);
        N(view2);
        A();
    }

    private boolean U(app.dogo.com.dogo_android.h.k k, int i2) {
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

    private boolean V(app.dogo.com.dogo_android.h.en en, int i2) {
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

    private boolean W(x<y<b0.a>> x, int i2) {
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

    private boolean X(x<String> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.i
    public void A() {
        this.U = 32;
        this.R.A();
        this.P.A();
        I();
        return;
        synchronized (this) {
            this.U = 32;
            this.R.A();
            this.P.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return X((x)object2, i3);
                }
                return W((x)object2, i3);
            }
            return U((k)object2, i3);
        }
        return V((en)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.i
    public void M(q q) {
        super.M(q);
        this.R.M(q);
        this.P.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.i
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            T((b0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.i
    public void T(b0 b0) {
        this.S = b0;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = b0;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i
    protected void m() {
        int cmp2;
        int cmp6;
        int cmp3;
        int value;
        int cmp5;
        int cmp;
        int i2;
        int cmp4;
        int value2;
        int i;
        long l = this.U;
        final int i4 = 0;
        this.U = i4;
        b0 b0Var = this.S;
        final int i9 = 56;
        int i10 = 52;
        final int i14 = 0;
        synchronized (this) {
            l = this.U;
            i4 = 0;
            this.U = i4;
            b0Var = this.S;
            i9 = 56;
            i10 = 52;
            i14 = 0;
        }
        try {
            if (Long.compare(i2, i4) != 0) {
            } else {
            }
            if (b0Var != null) {
            } else {
            }
            cmp3 = b0Var.q();
            cmp3 = i14;
            Q(2, cmp3);
            if (cmp3 != null) {
            } else {
            }
            value = cmp3.getValue();
            value = i14;
        }
        if (Long.compare(i15, i4) != 0) {
            if (b0Var != null) {
                cmp4 = b0Var.s();
            } else {
                cmp4 = i14;
            }
            Q(3, cmp4);
            if (cmp4 != 0) {
                value2 = cmp4.getValue();
            } else {
                value2 = i14;
            }
        } else {
        }
        if (Long.compare(i11, i4) != 0) {
            n.F0(this.O, value);
        }
        if (Long.compare(i13, i4) != 0) {
            this.P.T(b0Var);
        }
        if (Long.compare(i6, i4) != 0) {
            n.k0(this.Q, i14);
        }
        if (Long.compare(i3, i4) != 0) {
            this.R.T(value2);
        }
        ViewDataBinding.o(this.R);
        ViewDataBinding.o(this.P);
    }

    @Override // app.dogo.com.dogo_android.h.i
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.R.y()) {
                }
                return i2;
                if (this.P.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
