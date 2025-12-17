package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.k.e;
import app.dogo.com.dogo_android.u.n.p.e;

/* loaded from: classes.dex */
public class t1 extends app.dogo.com.dogo_android.h.s1 {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ConstraintLayout T;
    private long U;
    static {
    }

    public t1(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, t1.V, t1.W));
    }

    private t1(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[1], (ImageView)object3Arr3[2], (TextView)object3Arr3[3]);
        this.U = -1;
        int i5 = 0;
        this.O.setTag(i5);
        this.P.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.T = (ConstraintLayout)obj9;
        obj9.setTag(i5);
        this.Q.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s1
    public void A() {
        this.U = 4;
        I();
        return;
        synchronized (this) {
            this.U = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s1
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.s1
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            V((e)object2);
            obj2 = 1;
        } else {
            if (135 == i) {
                W((Boolean)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.s1
    public void V(e e) {
        this.R = e;
        this.U = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = e;
            this.U = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s1
    public void W(Boolean boolean) {
        this.S = boolean;
        this.U = l |= i2;
        notifyPropertyChanged(135);
        super.I();
        return;
        synchronized (this) {
            this.S = boolean;
            this.U = l |= i2;
            notifyPropertyChanged(135);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s1
    protected void m() {
        int cmp;
        int cmp2;
        long l = this.U;
        final int i2 = 0;
        this.U = i2;
        final e eVar = this.R;
        synchronized (this) {
            l = this.U;
            i2 = 0;
            this.U = i2;
            eVar = this.R;
        }
        try {
            e.h(this.O, eVar, this.S);
            if (Long.compare(i, i2) != 0) {
            }
            e.n(this.P, eVar);
            e.o(this.Q, eVar);
            e.p(this.Q, eVar);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.s1
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
