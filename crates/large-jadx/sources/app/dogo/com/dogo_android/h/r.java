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
import app.dogo.com.dogo_android.k.k;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.welcome_v2.p0;

/* loaded from: classes.dex */
public class r extends app.dogo.com.dogo_android.h.q {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout Q;
    private final app.dogo.com.dogo_android.h.ml R;
    private long S;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(8);
        r.T = gVar;
        int i7 = 1;
        final int[] iArr = new int[i7];
        final int i14 = 0;
        iArr[i14] = 2;
        int[] iArr2 = new int[i7];
        iArr2[i14] = 2131558788;
        gVar.a(i7, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        r.U = sparseIntArray;
        sparseIntArray.put(2131362712, 3);
        sparseIntArray.put(2131362713, 4);
        sparseIntArray.put(2131363157, 5);
        sparseIntArray.put(2131363158, 6);
        sparseIntArray.put(2131362533, 7);
    }

    public r(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, r.T, r.U));
    }

    private r(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (FrameLayout)object3Arr3[7], (ImageView)object3Arr3[3], (ImageView)object3Arr3[4], (FrameLayout)object3Arr3[1], (ImageView)object3Arr3[5], (ImageView)object3Arr3[6]);
        this.S = -1;
        Object obj12 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj12;
        int i8 = 0;
        obj12.setTag(i8);
        obj12 = object3Arr3[2];
        this.R = (ml)obj12;
        L(obj12);
        this.O.setTag(i8);
        N(view2);
        A();
    }

    private boolean U(LiveData<y<k>> liveData, int i2) {
        if (i2 == 0) {
            this.S = obj3 |= i;
            return 1;
            synchronized (this) {
                this.S = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean V(LiveData<y<Boolean>> liveData, int i2) {
        if (i2 == 0) {
            this.S = obj3 |= i;
            return 1;
            synchronized (this) {
                this.S = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.q
    public void A() {
        this.S = 8;
        this.R.A();
        I();
        return;
        synchronized (this) {
            this.S = 8;
            this.R.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return V((LiveData)object2, i3);
        }
        return U((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.q
    public void M(q q) {
        super.M(q);
        this.R.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.q
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            T((p0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.q
    public void T(p0 p0) {
        this.P = p0;
        this.S = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.P = p0;
            this.S = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.q
    protected void m() {
        int cmp;
        int value2;
        int i3;
        int value;
        int i2;
        int i;
        long l = this.S;
        final int i5 = 0;
        this.S = i5;
        p0 p0Var = this.P;
        int cmp2 = Long.compare(i7, i5);
        final int i8 = 0;
        synchronized (this) {
            l = this.S;
            i5 = 0;
            this.S = i5;
            p0Var = this.P;
            cmp2 = Long.compare(i7, i5);
            i8 = 0;
        }
        try {
            if (p0Var != null) {
            } else {
            }
            i2 = p0Var.n();
            i3 = p0Var.o();
            i2 = i3;
            Q(0, i2);
            Q(1, i3);
            if (i2 != 0) {
            } else {
            }
            value = i2.getValue();
            value = i8;
        }
        value2 = i3.getValue();
        if (Long.compare(i4, i5) != 0) {
            n.x0(this.Q, value2);
        }
        if (cmp2 != 0) {
            n.E0(this.O, value2, value, i8);
        }
        ViewDataBinding.o(this.R);
    }

    @Override // app.dogo.com.dogo_android.h.q
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
