package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.d.a.m;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public class l8 extends app.dogo.com.dogo_android.h.k8 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(3);
        l8.S = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i5 = 0;
        iArr2[i5] = i3;
        int[] iArr = new int[i3];
        iArr[i5] = 2131558813;
        gVar.a(i5, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        l8.T = sparseIntArray;
        sparseIntArray.put(2131363042, 2);
    }

    public l8(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, l8.S, l8.T));
    }

    private l8(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (RecyclerView)object3Arr3[2], (cn)object3Arr3[1]);
        this.R = -1;
        Object obj8 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj8;
        obj8.setTag(0);
        L(this.P);
        N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.cn cn, int i2) {
        if (i2 == 0) {
            this.R = obj3 |= i;
            return 1;
            synchronized (this) {
                this.R = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(m m, int i2) {
        if (i2 == 0) {
            this.R = obj3 |= i;
            return 1;
            synchronized (this) {
                this.R = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public void A() {
        this.R = 8;
        this.P.A();
        I();
        return;
        synchronized (this) {
            this.R = 8;
            this.P.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k8
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((cn)object2, i3);
        }
        return Y((m)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public void M(q q) {
        super.M(q);
        this.P.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            W((m)object2);
            obj2 = 1;
        } else {
            if (116 == i) {
                V((a0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public void V(a0 a0) {
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public void W(m m) {
    }

    @Override // app.dogo.com.dogo_android.h.k8
    protected void m() {
        this.R = 0;
        ViewDataBinding.o(this.P);
        return;
        synchronized (this) {
            this.R = 0;
            ViewDataBinding.o(this.P);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
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
