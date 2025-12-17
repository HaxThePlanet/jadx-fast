package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.i.f0;
import app.dogo.com.dogo_android.i.m0;
import app.dogo.com.dogo_android.util.f0.n;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public class f7 extends app.dogo.com.dogo_android.h.e7 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final MaterialCardView R;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f7.U = sparseIntArray;
        sparseIntArray.put(2131362264, 3);
    }

    public f7(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, f7.T, f7.U));
    }

    private f7(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (TextView)object3Arr3[3], (TextView)object3Arr3[1]);
        this.S = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.R = (MaterialCardView)obj9;
        obj9.setTag(i5);
        this.P.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.e7
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.e7
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.e7
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((m0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.e7
    public void V(m0 m0) {
        this.Q = m0;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = m0;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.e7
    protected void m() {
        int cmp;
        int i;
        final int i3 = 0;
        this.S = i3;
        i = 0;
        final m0 m0Var = this.Q;
        cmp = Long.compare(i2, i3);
        synchronized (this) {
            i3 = 0;
            this.S = i3;
            i = 0;
            m0Var = this.Q;
            cmp = Long.compare(i2, i3);
        }
        try {
            if (m0Var != null) {
            }
            i = m0Var.b();
            if (cmp != 0) {
            }
            n.K(this.O, m0Var);
            g.c(this.P, i);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.e7
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
