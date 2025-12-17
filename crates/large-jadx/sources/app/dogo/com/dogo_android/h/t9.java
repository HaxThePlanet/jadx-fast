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
import app.dogo.com.dogo_android.a0.e;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class t9 extends app.dogo.com.dogo_android.h.s9 implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout S;
    private final View.OnClickListener T;
    private final View.OnClickListener U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        t9.X = sparseIntArray;
        sparseIntArray.put(2131362235, 3);
    }

    public t9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, t9.W, t9.X));
    }

    private t9(e e, View view2, Object[] object3Arr3) {
        final int i = 1;
        int i3 = 2;
        super(e, view2, 0, (Button)object3Arr3[i], (TextView)object3Arr3[3], (Button)object3Arr3[i3]);
        this.V = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj10 = object3Arr3[0];
        this.S = (ConstraintLayout)obj10;
        obj10.setTag(i5);
        this.Q.setTag(i5);
        N(view2);
        obj10 = new b(this, i);
        this.T = obj10;
        obj10 = new b(this, i3);
        this.U = obj10;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s9
    public void A() {
        this.V = 2;
        I();
        return;
        synchronized (this) {
            this.V = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s9
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.s9
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

    @Override // app.dogo.com.dogo_android.h.s9
    public void V(e e) {
        this.R = e;
        this.V = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = e;
            this.V = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s9
    public final void b(int i, View view2) {
        int i2;
        e obj3;
        int obj4;
        obj4 = 0;
        final int i3 = 1;
        if (i != i3) {
            if (i != 2) {
            } else {
                obj3 = this.R;
                if (obj3 != null) {
                    obj4 = i3;
                }
                if (obj4 != null) {
                    obj3.l();
                }
            }
        } else {
            obj3 = this.R;
            if (obj3 != null) {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.h();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.s9
    protected void m() {
        int cmp;
        View.OnClickListener list;
        final int i2 = 0;
        this.V = i2;
        synchronized (this) {
            i2 = 0;
            this.V = i2;
        }
        try {
            this.O.setOnClickListener(this.T);
            n.f0(this.S, this.P);
            this.Q.setOnClickListener(this.U);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.s9
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
