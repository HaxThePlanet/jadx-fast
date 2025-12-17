package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.a0.g.e;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.view.dailytraining.l;
import f.d.a.a;

/* loaded from: classes.dex */
public class n extends app.dogo.com.dogo_android.h.m {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final app.dogo.com.dogo_android.h.ml S;
    private long T;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(7);
        n.U = gVar;
        int i6 = 1;
        final int[] iArr = new int[i6];
        final int i12 = 0;
        iArr[i12] = 2;
        int[] iArr2 = new int[i6];
        iArr2[i12] = 2131558788;
        gVar.a(i6, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        n.V = sparseIntArray;
        sparseIntArray.put(2131362533, 3);
        sparseIntArray.put(2131363244, 4);
        sparseIntArray.put(2131362866, 5);
        sparseIntArray.put(2131362551, 6);
    }

    public n(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, n.U, n.V));
    }

    private n(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 3, (ConstraintLayout)object3Arr3[0], (FrameLayout)object3Arr3[3], (FrameLayout)object3Arr3[6], (BottomNavigationView)object3Arr3[5], (FrameLayout)object3Arr3[1], (CoordinatorLayout)object3Arr3[4]);
        this.T = -1;
        int i8 = 0;
        this.O.setTag(i8);
        Object obj12 = object3Arr3[2];
        this.S = (ml)obj12;
        L(obj12);
        this.P.setTag(i8);
        N(view2);
        A();
    }

    private boolean V(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean W(a<y<Boolean>> a, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(a<y<Boolean>> a, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.m
    public void A() {
        this.T = 32;
        this.S.A();
        I();
        return;
        synchronized (this) {
            this.T = 32;
            this.S.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return W((a)object2, i3);
            }
            return X((a)object2, i3);
        }
        return V((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.m
    public void M(q q) {
        super.M(q);
        this.S.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.m
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (138 == i) {
            T((l)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                U((e)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.m
    public void T(l l) {
        this.R = l;
        this.T = l2 |= i2;
        notifyPropertyChanged(138);
        super.I();
        return;
        synchronized (this) {
            this.R = l;
            this.T = l2 |= i2;
            notifyPropertyChanged(138);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m
    public void U(e e) {
        this.Q = e;
        this.T = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Q = e;
            this.T = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m
    protected void m() {
        int cmp;
        int i2;
        int i;
        Object value3;
        int value;
        Object i3;
        int value2;
        int i5;
        int i4;
        int i6;
        long l = this.T;
        final int i8 = 0;
        this.T = i8;
        l lVar = this.R;
        value = this.Q;
        int cmp2 = Long.compare(i10, i8);
        i3 = 0;
        synchronized (this) {
            l = this.T;
            i8 = 0;
            this.T = i8;
            lVar = this.R;
            value = this.Q;
            cmp2 = Long.compare(i10, i8);
            i3 = 0;
        }
        try {
            if (lVar != null) {
            } else {
            }
            i5 = lVar.B();
            i = lVar.D();
            i5 = i;
            Q(0, i5);
            Q(2, i);
            if (value != null) {
            } else {
            }
            value = value.s();
            value = i3;
            Q(1, value);
        }
        value2 = i5.getValue();
        if (i != 0) {
            value3 = i.getValue();
        } else {
            value3 = i3;
        }
        if (value != null) {
            i3 = value;
        }
        i3 = value3;
        i2 = i6;
        if (Long.compare(i7, i8) != 0) {
            n.x0(this.P, i3);
        }
        if (cmp2 != 0) {
            n.E0(this.P, i2, i3, value2);
        }
        ViewDataBinding.o(this.S);
    }

    @Override // app.dogo.com.dogo_android.h.m
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.S.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
