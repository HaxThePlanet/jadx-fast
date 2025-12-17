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
public class v1 extends app.dogo.com.dogo_android.h.u1 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
    }

    public v1(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, v1.U, v1.V));
    }

    private v1(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[1], (ImageView)object3Arr3[2], (TextView)object3Arr3[3]);
        this.T = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.S = (ConstraintLayout)obj9;
        obj9.setTag(i5);
        this.P.setTag(i5);
        this.Q.setTag(i5);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u1
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u1
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.u1
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((e)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.u1
    public void V(e e) {
        this.R = e;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = e;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u1
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.T = i2;
        final e eVar = this.R;
        synchronized (this) {
            i2 = 0;
            this.T = i2;
            eVar = this.R;
        }
        try {
            e.j(this.O, eVar);
            e.i(this.P, eVar);
            e.o(this.Q, eVar);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.u1
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
