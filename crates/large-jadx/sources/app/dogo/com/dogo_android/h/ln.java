package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;

/* loaded from: classes.dex */
public class ln extends app.dogo.com.dogo_android.h.kn {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = null;
    private final app.dogo.com.dogo_android.h.mn Q;
    private final ConstraintLayout R;
    private final app.dogo.com.dogo_android.h.on S;
    private long T;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(3);
        ln.U = gVar;
        int i4 = 2;
        final int[] iArr2 = new int[i4];
        iArr2 = new int[]{1, 2};
        int[] iArr = new int[i4];
        iArr = new int[]{2131558818, 2131558819};
        gVar.a(0, /* result */, iArr2, iArr);
        int i = 0;
    }

    public ln(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, ln.U, ln.V));
    }

    private ln(e e, View view2, Object[] object3Arr3) {
        int i = 0;
        super(e, view2, i);
        this.T = -1;
        Object obj4 = object3Arr3[1];
        this.Q = (mn)obj4;
        L(obj4);
        obj4 = object3Arr3[i];
        this.R = (ConstraintLayout)obj4;
        obj4.setTag(0);
        obj4 = object3Arr3[2];
        this.S = (on)obj4;
        L(obj4);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public void A() {
        this.T = 4;
        this.Q.A();
        this.S.A();
        I();
        return;
        synchronized (this) {
            this.T = 4;
            this.Q.A();
            this.S.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kn
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public void M(q q) {
        super.M(q);
        this.Q.M(q);
        this.S.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (57 == i) {
            T((Integer)object2);
            obj2 = 1;
        } else {
            if (105 == i) {
                U((Integer)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public void T(Integer integer) {
        this.O = integer;
        this.T = l |= i2;
        notifyPropertyChanged(57);
        super.I();
        return;
        synchronized (this) {
            this.O = integer;
            this.T = l |= i2;
            notifyPropertyChanged(57);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public void U(Integer integer) {
        this.P = integer;
        this.T = l |= i2;
        notifyPropertyChanged(105);
        super.I();
        return;
        synchronized (this) {
            this.P = integer;
            this.T = l |= i2;
            notifyPropertyChanged(105);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kn
    protected void m() {
        long l;
        int cmp;
        int cmp2;
        int i2;
        int i4;
        int i5;
        int i3;
        int i6;
        int i;
        l = this.T;
        final int i8 = 0;
        this.T = i8;
        final Integer num = this.O;
        Integer num2 = this.P;
        int i10 = 6;
        int cmp3 = Long.compare(i12, i8);
        i4 = 0;
        synchronized (this) {
            l = this.T;
            i8 = 0;
            this.T = i8;
            num = this.O;
            num2 = this.P;
            i10 = 6;
            cmp3 = Long.compare(i12, i8);
            i4 = 0;
        }
        try {
            int i14 = ViewDataBinding.J(num2);
            if (i14 == 0) {
            } else {
            }
            i6 = i3;
            i6 = i4;
            if (i14 != 0) {
            } else {
            }
            i3 = i4;
        }
        i = i6 != 0 ? 64 : 32;
        l |= i;
        if (Long.compare(i, i8) != 0) {
            i = i3 != 0 ? 16 : 8;
            l |= i;
        }
        int i13 = 8;
        i5 = i6 != 0 ? i4 : i13;
        if (i3 != 0) {
        } else {
            i4 = i13;
        }
        i2 = i4;
        i4 = i5;
        if (Long.compare(i11, i8) != 0) {
            this.Q.w().setVisibility(i4);
            this.S.w().setVisibility(i2);
            this.S.U(num2);
        }
        if (Long.compare(i7, i8) != 0) {
            this.Q.T(num);
            this.S.T(num);
        }
        ViewDataBinding.o(this.Q);
        ViewDataBinding.o(this.S);
    }

    @Override // app.dogo.com.dogo_android.h.kn
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.Q.y()) {
                }
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
