package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.u.n.p.e;
import app.dogo.com.dogo_android.u.n.p.m.b.a;
import app.dogo.com.dogo_android.u.n.p.m.e;

/* loaded from: classes.dex */
public class x8 extends app.dogo.com.dogo_android.h.w8 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final ConstraintLayout R;
    private long S;
    static {
    }

    public x8(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, x8.T, x8.U));
    }

    private x8(e e, View view2, Object[] object3Arr3) {
        final int i2 = 0;
        super(e, view2, i2, (RecyclerView)object3Arr3[1]);
        this.S = -1;
        Object obj5 = object3Arr3[i2];
        this.R = (ConstraintLayout)obj5;
        final int obj7 = 0;
        obj5.setTag(obj7);
        this.O.setTag(obj7);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.w8
    public void A() {
        this.S = 4;
        I();
        return;
        synchronized (this) {
            this.S = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w8
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.w8
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((b.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((e)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.w8
    public void V(b.a b$a) {
        this.Q = a;
        this.S = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Q = a;
            this.S = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w8
    public void W(e e) {
        this.P = e;
        this.S = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.P = e;
            this.S = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w8
    protected void m() {
        int cmp;
        int i;
        final int i3 = 0;
        this.S = i3;
        i = 0;
        final e eVar = this.P;
        cmp = Long.compare(i2, i3);
        synchronized (this) {
            i3 = 0;
            this.S = i3;
            i = 0;
            eVar = this.P;
            cmp = Long.compare(i2, i3);
        }
        try {
            if (eVar != null) {
            }
            i = eVar.h();
            if (cmp != 0) {
            }
            e.f(this.O, i, this.Q);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.w8
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
