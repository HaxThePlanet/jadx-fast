package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.t.h0.i.a;
import app.dogo.com.dogo_android.t.h0.l;
import app.dogo.com.dogo_android.t.h0.n;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class n9 extends app.dogo.com.dogo_android.h.m9 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n9.X = sparseIntArray;
        sparseIntArray.put(2131363414, 4);
        sparseIntArray.put(2131362356, 5);
    }

    public n9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, n9.W, n9.X));
    }

    private n9(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (FrameLayout)object3Arr3[2], (Button)object3Arr3[5], (ConstraintLayout)object3Arr3[0], (ProgressBar)object3Arr3[3], (RecyclerView)object3Arr3[1], (TextView)object3Arr3[4]);
        this.V = -1;
        int obj14 = 0;
        this.O.setTag(obj14);
        this.Q.setTag(obj14);
        this.R.setTag(obj14);
        this.S.setTag(obj14);
        N(view2);
        A();
    }

    private boolean X(x<y<n>> x, int i2) {
        if (i2 == 0) {
            this.V = obj3 |= i;
            return 1;
            synchronized (this) {
                this.V = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.m9
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m9
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.m9
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((i.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((l)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.m9
    public void V(i.a i$a) {
        this.U = a;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.U = a;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m9
    public void W(l l) {
        this.T = l;
        this.V = l2 |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = l;
            this.V = l2 |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m9
    protected void m() {
        int cmp2;
        x value;
        int i3;
        int i;
        int i2;
        int cmp;
        long l = this.V;
        final int i5 = 0;
        this.V = i5;
        value = this.T;
        int cmp3 = Long.compare(i7, i5);
        final int i10 = 13;
        i = 0;
        synchronized (this) {
            l = this.V;
            i5 = 0;
            this.V = i5;
            value = this.T;
            cmp3 = Long.compare(i7, i5);
            i10 = 13;
            i = 0;
        }
        try {
            if (cmp3 != 0 && value != null) {
            } else {
            }
            if (value != null) {
            } else {
            }
            i3 = value.r();
            i2 = value.p();
            i2 = i3;
            value = value.s();
        }
        if (Long.compare(i4, i5) != 0) {
            n.z0(this.O, i);
            n.z0(this.R, i);
        }
        if (cmp3 != 0) {
            n.Y(this.S, i3, this.U, i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.m9
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
