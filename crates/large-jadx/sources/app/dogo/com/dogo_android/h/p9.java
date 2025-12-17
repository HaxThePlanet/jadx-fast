package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.v.d.a;
import app.dogo.com.dogo_android.y.v.e;

/* loaded from: classes.dex */
public class p9 extends app.dogo.com.dogo_android.h.o9 {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final CardView U;
    private final ConstraintLayout V;
    private long W;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(6);
        p9.X = gVar;
        int i4 = 1;
        final int[] iArr = new int[i4];
        final int i8 = 0;
        iArr[i8] = 3;
        int[] iArr2 = new int[i4];
        iArr2[i8] = 2131558526;
        gVar.a(i4, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        p9.Y = sparseIntArray;
        sparseIntArray.put(2131363331, 4);
        sparseIntArray.put(2131362887, 5);
    }

    public p9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, p9.X, p9.Y));
    }

    private p9(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (ViewPager2)object3Arr3[2], (Button)object3Arr3[5], (TabLayout)object3Arr3[4], (e5)object3Arr3[3]);
        this.W = -1;
        int i6 = 0;
        this.O.setTag(i6);
        Object obj10 = object3Arr3[0];
        this.U = (CardView)obj10;
        obj10.setTag(i6);
        obj10 = object3Arr3[1];
        this.V = (ConstraintLayout)obj10;
        obj10.setTag(i6);
        L(this.R);
        N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.e5 e5, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.o9
    public void A() {
        this.W = 8;
        this.R.A();
        I();
        return;
        synchronized (this) {
            this.W = 8;
            this.R.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o9
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((e5)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.o9
    public void M(q q) {
        super.M(q);
        this.R.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.o9
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (4 == i) {
            V((d.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((e)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.o9
    public void V(d.a d$a) {
        this.T = a;
        this.W = l |= i2;
        notifyPropertyChanged(4);
        super.I();
        return;
        synchronized (this) {
            this.T = a;
            this.W = l |= i2;
            notifyPropertyChanged(4);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o9
    public void W(e e) {
        this.S = e;
        this.W = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = e;
            this.W = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o9
    protected void m() {
        int i;
        Object eVar;
        int i2;
        android.widget.Button button;
        app.dogo.com.dogo_android.h.e5 e5Var;
        final int i4 = 0;
        this.W = i4;
        i = 0;
        eVar = this.S;
        int cmp = Long.compare(i3, i4);
        synchronized (this) {
            i4 = 0;
            this.W = i4;
            i = 0;
            eVar = this.S;
            cmp = Long.compare(i3, i4);
        }
        try {
            if (eVar != null) {
            }
            i = eVar.h();
            if (cmp != 0) {
            }
            l.H(this.O, this.T, this.Q, i, this.P, this.R);
            ViewDataBinding.o(this.R);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.o9
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
