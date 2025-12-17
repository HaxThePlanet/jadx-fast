package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class zb extends app.dogo.com.dogo_android.h.yb {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(6);
        zb.T = gVar;
        int i5 = 1;
        final int[] iArr = new int[i5];
        final int i10 = 0;
        iArr[i10] = 2;
        int[] iArr2 = new int[i5];
        iArr2[i10] = 2131558745;
        gVar.a(i5, /* result */, iArr, iArr2);
        SparseIntArray sparseIntArray = new SparseIntArray();
        zb.U = sparseIntArray;
        sparseIntArray.put(2131363240, 3);
        sparseIntArray.put(2131363214, 4);
        sparseIntArray.put(2131363414, 5);
    }

    public zb(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, zb.T, zb.U));
    }

    private zb(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (gi)object3Arr3[2], (FrameLayout)object3Arr3[1], (ImageView)object3Arr3[4], (Button)object3Arr3[3], (TextView)object3Arr3[5]);
        this.S = -1;
        L(this.O);
        Object obj11 = object3Arr3[0];
        this.R = (ConstraintLayout)obj11;
        final int obj13 = 0;
        obj11.setTag(obj13);
        this.P.setTag(obj13);
        N(view2);
        A();
    }

    private boolean V(app.dogo.com.dogo_android.h.gi gi, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.yb
    public void A() {
        this.S = 2;
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.S = 2;
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yb
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return V((gi)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.yb
    public void M(q q) {
        super.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.yb
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.yb
    protected void m() {
        int cmp;
        app.dogo.com.dogo_android.h.gi giVar;
        final int i2 = 0;
        this.S = i2;
        synchronized (this) {
            i2 = 0;
            this.S = i2;
        }
        try {
            n.t0(this.P, this.O);
            ViewDataBinding.o(this.O);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.yb
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.O.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
