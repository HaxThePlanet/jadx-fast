package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.d.b.x;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public class f8 extends app.dogo.com.dogo_android.h.e8 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(4);
        f8.T = gVar;
        int i4 = 2;
        final int[] iArr2 = new int[i4];
        iArr2 = new int[]{1, 2};
        int[] iArr = new int[i4];
        iArr = new int[]{2131558813, 2131558743};
        gVar.a(0, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        f8.U = sparseIntArray;
        sparseIntArray.put(2131363042, 3);
    }

    public f8(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, f8.T, f8.U));
    }

    private f8(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 3, (ci)object3Arr3[2], (RecyclerView)object3Arr3[3], (cn)object3Arr3[1]);
        this.S = -1;
        L(this.O);
        Object obj9 = object3Arr3[0];
        this.R = (ConstraintLayout)obj9;
        obj9.setTag(0);
        L(this.Q);
        N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.ci ci, int i2) {
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

    private boolean Y(app.dogo.com.dogo_android.h.cn cn, int i2) {
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

    private boolean Z(x x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.e8
    public void A() {
        this.S = 16;
        this.Q.A();
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.S = 16;
            this.Q.A();
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.e8
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return X((ci)object2, i3);
            }
            return Y((cn)object2, i3);
        }
        return Z((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.e8
    public void M(q q) {
        super.M(q);
        this.Q.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.e8
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            W((x)object2);
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

    @Override // app.dogo.com.dogo_android.h.e8
    public void V(a0 a0) {
    }

    @Override // app.dogo.com.dogo_android.h.e8
    public void W(x x) {
    }

    @Override // app.dogo.com.dogo_android.h.e8
    protected void m() {
        this.S = 0;
        ViewDataBinding.o(this.Q);
        ViewDataBinding.o(this.O);
        return;
        synchronized (this) {
            this.S = 0;
            ViewDataBinding.o(this.Q);
            ViewDataBinding.o(this.O);
        }
    }

    @Override // app.dogo.com.dogo_android.h.e8
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.Q.y()) {
                }
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
