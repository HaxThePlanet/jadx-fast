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
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.welcome_v2.s0;

/* loaded from: classes.dex */
public class xe extends app.dogo.com.dogo_android.h.we {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final ConstraintLayout U;
    private final FrameLayout V;
    private final app.dogo.com.dogo_android.h.ml W;
    private long X;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(12);
        xe.Y = gVar;
        int i10 = 1;
        int[] iArr = new int[i10];
        final int i21 = 0;
        iArr[i21] = 2;
        int[] iArr3 = new int[i10];
        iArr3[i21] = 2131558790;
        gVar.a(i21, /* result */, iArr, iArr3);
        int[] iArr2 = new int[i10];
        iArr2[i21] = 3;
        int[] iArr4 = new int[i10];
        iArr4[i21] = 2131558788;
        gVar.a(i10, /* result */, iArr2, iArr4);
        SparseIntArray sparseIntArray = new SparseIntArray();
        xe.Z = sparseIntArray;
        sparseIntArray.put(2131362540, 4);
        sparseIntArray.put(2131362633, 5);
        sparseIntArray.put(2131363538, 6);
        sparseIntArray.put(2131363421, 7);
        sparseIntArray.put(2131363306, 8);
        sparseIntArray.put(2131362557, 9);
        sparseIntArray.put(2131362752, 10);
        sparseIntArray.put(2131362585, 11);
    }

    public xe(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 12, xe.Y, xe.Z));
    }

    private xe(e e, View view2, Object[] object3Arr3) {
        final Object obj24 = this;
        super(e, view2, 2, (FrameLayout)object3Arr3[4], (Button)object3Arr3[9], (Guideline)object3Arr3[11], (AppCompatImageView)object3Arr3[5], (Button)object3Arr3[10], (TextView)object3Arr3[8], (TextView)object3Arr3[7], (ql)object3Arr3[2], (KonfettiView)object3Arr3[6]);
        obj24.X = -1;
        Object obj11 = object3Arr3[0];
        obj24.U = (ConstraintLayout)obj11;
        int i14 = 0;
        obj11.setTag(i14);
        Object obj12 = object3Arr3[1];
        obj24.V = (FrameLayout)obj12;
        obj12.setTag(i14);
        Object obj13 = object3Arr3[3];
        obj24.W = (ml)obj13;
        L(obj13);
        L(obj24.R);
        N(view2);
        A();
    }

    private boolean V(app.dogo.com.dogo_android.h.ql ql, int i2) {
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

    private boolean W(x<y<Boolean>> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.we
    public void A() {
        this.X = 8;
        this.R.A();
        this.W.A();
        I();
        return;
        synchronized (this) {
            this.X = 8;
            this.R.A();
            this.W.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.we
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return W((x)object2, i3);
        }
        return V((ql)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.we
    public void M(q q) {
        super.M(q);
        this.R.M(q);
        this.W.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.we
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            X((s0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.we
    public void X(s0 s0) {
        this.T = s0;
        this.X = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = s0;
            this.X = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.we
    protected void m() {
        int cmp;
        Integer valueOf2;
        int valueOf;
        s0 value;
        int i2;
        int i;
        long l = this.X;
        valueOf = 0;
        this.X = valueOf;
        value = this.T;
        int cmp2 = Long.compare(i7, valueOf);
        synchronized (this) {
            l = this.X;
            valueOf = 0;
            this.X = valueOf;
            value = this.T;
            cmp2 = Long.compare(i7, valueOf);
        }
        try {
            if (value != null) {
            } else {
            }
            value = value.h();
            value = i2;
            Q(1, value);
            if (value != null) {
            }
            i2 = value;
            if (cmp2 != 0) {
            }
            n.F0(this.U, i2);
            n.D0(this.V, i2);
        }
        if (Long.compare(i3, valueOf) != 0) {
            int i4 = 4;
            this.R.T(Integer.valueOf(i4));
            this.R.U(Integer.valueOf(i4));
        }
        ViewDataBinding.o(this.R);
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.we
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.R.y()) {
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
