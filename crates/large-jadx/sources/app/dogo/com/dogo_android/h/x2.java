package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.a;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.i.q0;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes.dex */
public class x2 extends app.dogo.com.dogo_android.h.w2 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final MaterialCardView R;
    private long S;
    static {
    }

    public x2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, x2.T, x2.U));
    }

    private x2(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (CheckBox)object3Arr3[1], (TextView)object3Arr3[2]);
        this.S = -1;
        int i4 = 0;
        this.O.setTag(i4);
        Object obj8 = object3Arr3[0];
        this.R = (MaterialCardView)obj8;
        obj8.setTag(i4);
        this.P.setTag(i4);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.w2
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w2
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.w2
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((q0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.w2
    public void V(q0 q0) {
        this.Q = q0;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = q0;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w2
    protected void m() {
        int cmp;
        int i2;
        int i;
        final int i4 = 0;
        this.S = i4;
        i2 = 0;
        final q0 q0Var = this.Q;
        i = 0;
        cmp = Long.compare(i3, i4);
        synchronized (this) {
            i4 = 0;
            this.S = i4;
            i2 = 0;
            q0Var = this.Q;
            i = 0;
            cmp = Long.compare(i3, i4);
        }
        try {
            if (q0Var != null) {
            }
            i2 = q0Var.a();
            i = q0Var.b();
            if (cmp != 0) {
            }
            a.a(this.O, i);
            g.c(this.P, i2);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.w2
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
