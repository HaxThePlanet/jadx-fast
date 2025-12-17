package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.f.n.e;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;

/* loaded from: classes.dex */
public class ta extends app.dogo.com.dogo_android.h.sa implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final CoordinatorLayout R;
    private final View.OnClickListener S;
    private final View.OnClickListener T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ta.W = sparseIntArray;
        sparseIntArray.put(2131362339, 3);
        sparseIntArray.put(2131363414, 4);
        sparseIntArray.put(2131362298, 5);
    }

    public ta(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, ta.V, ta.W));
    }

    private ta(e e, View view2, Object[] object3Arr3) {
        int i3 = 2;
        final int i8 = 1;
        super(e, view2, 0, (TextView)object3Arr3[5], (LottieAnimationView)object3Arr3[3], (Button)object3Arr3[i3], (TextView)object3Arr3[4], (Button)object3Arr3[i8]);
        this.U = -1;
        int i6 = 0;
        this.O.setTag(i6);
        Object obj12 = object3Arr3[0];
        this.R = (CoordinatorLayout)obj12;
        obj12.setTag(i6);
        this.P.setTag(i6);
        N(view2);
        obj12 = new b(this, i3);
        this.S = obj12;
        obj12 = new b(this, i8);
        this.T = obj12;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.sa
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sa
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.sa
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((e)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.sa
    public void V(e e) {
        this.Q = e;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Q = e;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sa
    public final void b(int i, View view2) {
        int i2;
        e obj3;
        int obj4;
        obj4 = 0;
        final int i3 = 1;
        if (i != i3) {
            if (i != 2) {
            } else {
                obj3 = this.Q;
                if (obj3 != null) {
                    obj4 = i3;
                }
                if (obj4 != null) {
                    obj3.j();
                }
            }
        } else {
            obj3 = this.Q;
            if (obj3 != null) {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.k();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.sa
    protected void m() {
        int cmp;
        View.OnClickListener list;
        final int i2 = 0;
        this.U = i2;
        synchronized (this) {
            i2 = 0;
            this.U = i2;
        }
        try {
            this.O.setOnClickListener(this.S);
            this.P.setOnClickListener(this.T);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.sa
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
