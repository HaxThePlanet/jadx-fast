package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.u.n.q.m.a;
import app.dogo.com.dogo_android.u.n.q.p;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class h9 extends app.dogo.com.dogo_android.h.g9 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        h9.V = sparseIntArray;
        sparseIntArray.put(2131363414, 2);
        sparseIntArray.put(2131362105, 3);
    }

    public h9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, h9.U, h9.V));
    }

    private h9(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (Button)object3Arr3[3], (ConstraintLayout)object3Arr3[0], (RecyclerView)object3Arr3[1], (TextView)object3Arr3[2]);
        this.T = -1;
        int obj12 = 0;
        this.P.setTag(obj12);
        this.Q.setTag(obj12);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.g9
    public void A() {
        this.T = 4;
        I();
        return;
        synchronized (this) {
            this.T = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g9
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.g9
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((m.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((p)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.g9
    public void V(m.a m$a) {
        this.S = a;
        this.T = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.S = a;
            this.T = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g9
    public void W(p p) {
        this.R = p;
        this.T = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = p;
            this.T = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g9
    protected void m() {
        int cmp;
        int i;
        final int i3 = 0;
        this.T = i3;
        i = 0;
        final p pVar = this.R;
        cmp = Long.compare(i2, i3);
        synchronized (this) {
            i3 = 0;
            this.T = i3;
            i = 0;
            pVar = this.R;
            cmp = Long.compare(i2, i3);
        }
        try {
            if (pVar != null) {
            }
            i = pVar.h();
            if (cmp != 0) {
            }
            n.e0(this.Q, i, this.S);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.g9
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
