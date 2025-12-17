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
public class pb extends app.dogo.com.dogo_android.h.ob {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(4);
        pb.V = gVar;
        int i4 = 1;
        final int[] iArr2 = new int[i4];
        final int i7 = 0;
        iArr2[i7] = i4;
        int[] iArr = new int[i4];
        iArr[i7] = 2131558684;
        gVar.a(i7, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        pb.W = sparseIntArray;
        sparseIntArray.put(2131363433, 2);
        sparseIntArray.put(2131363436, 3);
    }

    public pb(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, pb.V, pb.W));
    }

    private pb(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (ge)object3Arr3[1], (MaterialToolbar)object3Arr3[2], (TextView)object3Arr3[3]);
        this.U = -1;
        L(this.O);
        Object obj9 = object3Arr3[0];
        this.T = (ConstraintLayout)obj9;
        obj9.setTag(0);
        N(view2);
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.ge ge, int i2) {
        if (i2 == 0) {
            this.U = obj3 |= i;
            return 1;
            synchronized (this) {
                this.U = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ob
    public void A() {
        this.U = 8;
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.U = 8;
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ob
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((ge)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ob
    public void M(q q) {
        super.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ob
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

    @Override // app.dogo.com.dogo_android.h.ob
    public void V(c0 c0) {
        this.S = c0;
        this.U = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.S = c0;
            this.U = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ob
    public void W(b0 b0) {
        this.R = b0;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = b0;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ob
    protected void m() {
        int cmp;
        long l = this.U;
        final int i2 = 0;
        this.U = i2;
        synchronized (this) {
            l = this.U;
            i2 = 0;
            this.U = i2;
        }
        try {
            this.O.W(this.R);
            if (Long.compare(i4, i2) != 0) {
            }
            this.O.V(this.S);
            ViewDataBinding.o(this.O);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ob
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
