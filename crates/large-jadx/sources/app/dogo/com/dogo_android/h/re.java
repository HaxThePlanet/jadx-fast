package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.welcome_v2.d0;
import app.dogo.com.dogo_android.welcome_v2.g0;
import f.d.a.a;

/* loaded from: classes.dex */
public class re extends app.dogo.com.dogo_android.h.qe {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final ConstraintLayout V;
    private final app.dogo.com.dogo_android.h.ml W;
    private long X;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(9);
        re.Y = gVar;
        int i5 = 1;
        int[] iArr2 = new int[i5];
        final int i13 = 0;
        iArr2[i13] = 4;
        int[] iArr4 = new int[i5];
        iArr4[i13] = 2131558790;
        gVar.a(i13, /* result */, iArr2, iArr4);
        int[] iArr3 = new int[i5];
        iArr3[i13] = 5;
        int[] iArr = new int[i5];
        iArr[i13] = 2131558788;
        gVar.a(2, /* result */, iArr3, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        re.Z = sparseIntArray;
        sparseIntArray.put(2131363421, 6);
        sparseIntArray.put(2131362859, 7);
        sparseIntArray.put(2131362888, 8);
    }

    public re(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, re.Y, re.Z));
    }

    private re(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (TextInputEditText)object3Arr3[1], (FrameLayout)object3Arr3[2], (TextInputLayout)object3Arr3[7], (Button)object3Arr3[8], (CoordinatorLayout)object3Arr3[3], (TextView)object3Arr3[6], (ql)object3Arr3[4]);
        this.X = -1;
        int i9 = 0;
        this.O.setTag(i9);
        this.P.setTag(i9);
        Object obj13 = object3Arr3[0];
        this.V = (ConstraintLayout)obj13;
        obj13.setTag(i9);
        obj13 = object3Arr3[5];
        this.W = (ml)obj13;
        L(obj13);
        this.S.setTag(i9);
        L(this.T);
        N(view2);
        A();
    }

    private boolean W(app.dogo.com.dogo_android.h.ql ql, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(a<y<DogProfile>> a, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.qe
    public void A() {
        this.X = 8;
        this.T.A();
        this.W.A();
        I();
        return;
        synchronized (this) {
            this.X = 8;
            this.T.A();
            this.W.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qe
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((a)object2, i3);
        }
        return W((ql)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.qe
    public void M(q q) {
        super.M(q);
        this.T.M(q);
        this.W.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.qe
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((g0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.qe
    public void V(g0 g0) {
        this.U = g0;
        this.X = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.U = g0;
            this.X = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qe
    protected void m() {
        int cmp;
        Integer valueOf;
        g0 value;
        int i2;
        int i;
        long l = this.X;
        final int i5 = 0;
        this.X = i5;
        value = this.U;
        int cmp2 = Long.compare(i7, i5);
        synchronized (this) {
            l = this.X;
            i5 = 0;
            this.X = i5;
            value = this.U;
            cmp2 = Long.compare(i7, i5);
        }
        try {
            if (value != null) {
            } else {
            }
            value = value.o();
            value = i2;
            Q(1, value);
            if (value != null) {
            }
            i2 = value;
            if (Long.compare(i3, i5) != 0) {
            }
            d0.d(this.O, this.R);
            this.T.U(4);
        }
        if (cmp2 != 0) {
            n.D0(this.P, i2);
            n.F0(this.S, i2);
        }
        ViewDataBinding.o(this.T);
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.qe
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.T.y()) {
                }
                return i2;
                if (this.W.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
