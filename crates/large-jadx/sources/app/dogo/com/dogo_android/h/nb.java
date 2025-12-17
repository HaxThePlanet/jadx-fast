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
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;

/* loaded from: classes.dex */
public class nb extends app.dogo.com.dogo_android.h.mb {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(3);
        nb.U = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i5 = 0;
        iArr2[i5] = i3;
        int[] iArr = new int[i3];
        iArr[i5] = 2131558683;
        gVar.a(i5, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        nb.V = sparseIntArray;
        sparseIntArray.put(2131363433, 2);
    }

    public nb(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, nb.U, nb.V));
    }

    private nb(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (ee)object3Arr3[1], (MaterialToolbar)object3Arr3[2]);
        this.T = -1;
        L(this.O);
        Object obj8 = object3Arr3[0];
        this.S = (ConstraintLayout)obj8;
        obj8.setTag(0);
        N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.ee ee, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.mb
    public void A() {
        this.T = 8;
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.T = 8;
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mb
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((ee)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.mb
    public void M(q q) {
        super.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.mb
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((c0)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((b0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.mb
    public void V(c0 c0) {
        this.R = c0;
        this.T = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.R = c0;
            this.T = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mb
    public void W(b0 b0) {
        this.Q = b0;
        this.T = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Q = b0;
            this.T = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mb
    protected void m() {
        int cmp;
        long l = this.T;
        final int i2 = 0;
        this.T = i2;
        synchronized (this) {
            l = this.T;
            i2 = 0;
            this.T = i2;
        }
        try {
            this.O.W(this.Q);
            if (Long.compare(i4, i2) != 0) {
            }
            this.O.V(this.R);
            ViewDataBinding.o(this.O);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.mb
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
