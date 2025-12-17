package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.a0.d;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;

/* loaded from: classes.dex */
public class d9 extends app.dogo.com.dogo_android.h.c9 implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout R;
    private final View.OnClickListener S;
    private final View.OnClickListener T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d9.W = sparseIntArray;
        sparseIntArray.put(2131363421, 3);
        sparseIntArray.put(2131362235, 4);
    }

    public d9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, d9.V, d9.W));
    }

    private d9(e e, View view2, Object[] object3Arr3) {
        final int i = 1;
        int i3 = 2;
        super(e, view2, 0, (Button)object3Arr3[i], (TextView)object3Arr3[4], (Button)object3Arr3[i3], (TextView)object3Arr3[3]);
        this.U = -1;
        int i6 = 0;
        this.O.setTag(i6);
        Object obj11 = object3Arr3[0];
        this.R = (ConstraintLayout)obj11;
        obj11.setTag(i6);
        this.P.setTag(i6);
        N(view2);
        obj11 = new b(this, i);
        this.S = obj11;
        obj11 = new b(this, i3);
        this.T = obj11;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c9
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c9
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.c9
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((d)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.c9
    public void V(d d) {
        this.Q = d;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Q = d;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c9
    public final void b(int i, View view2) {
        int i2;
        d obj3;
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
                    obj3.n();
                }
            }
        } else {
            obj3 = this.Q;
            if (obj3 != null) {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.i();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.c9
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

    @Override // app.dogo.com.dogo_android.h.c9
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
