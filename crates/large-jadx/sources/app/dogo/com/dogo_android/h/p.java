package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class p extends app.dogo.com.dogo_android.h.o {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        p.V = sparseIntArray;
        sparseIntArray.put(2131362232, 3);
    }

    public p(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, p.U, p.V));
    }

    private p(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ConstraintLayout)object3Arr3[3], (MaterialToolbar)object3Arr3[1], (WebView)object3Arr3[2]);
        this.T = -1;
        Object obj9 = object3Arr3[0];
        this.S = (ConstraintLayout)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        this.O.setTag(obj11);
        this.P.setTag(obj11);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o
    public void A() {
        this.T = 4;
        I();
        return;
        synchronized (this) {
            this.T = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.o
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (161 == i) {
            U((String)object2);
            obj2 = 1;
        } else {
            if (79 == i) {
                T((String)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.o
    public void T(String string) {
        this.R = string;
        this.T = l |= i2;
        notifyPropertyChanged(79);
        super.I();
        return;
        synchronized (this) {
            this.R = string;
            this.T = l |= i2;
            notifyPropertyChanged(79);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o
    public void U(String string) {
        this.Q = string;
        this.T = l |= i2;
        notifyPropertyChanged(161);
        super.I();
        return;
        synchronized (this) {
            this.Q = string;
            this.T = l |= i2;
            notifyPropertyChanged(161);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.o
    protected void m() {
        int cmp;
        com.google.android.material.appbar.MaterialToolbar materialToolbar;
        long l = this.T;
        final int i2 = 0;
        this.T = i2;
        synchronized (this) {
            l = this.T;
            i2 = 0;
            this.T = i2;
        }
        try {
            this.O.setTitle(this.Q);
            if (Long.compare(i, i2) != 0) {
            }
            n.l(this.P, this.R);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.o
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
