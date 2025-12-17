package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.u.m.t;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class jh extends app.dogo.com.dogo_android.h.ih {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        jh.W = sparseIntArray;
        sparseIntArray.put(2131363433, 2);
        sparseIntArray.put(2131362322, 3);
        sparseIntArray.put(2131362619, 4);
        sparseIntArray.put(2131362954, 5);
        sparseIntArray.put(2131363142, 6);
    }

    public jh(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, jh.V, jh.W));
    }

    private jh(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ConstraintLayout)object3Arr3[0], (ImageView)object3Arr3[3], (ImageView)object3Arr3[4], (TextView)object3Arr3[5], (RecyclerView)object3Arr3[1], (MaterialButton)object3Arr3[6], (MaterialToolbar)object3Arr3[2]);
        this.U = -1;
        int obj15 = 0;
        this.O.setTag(obj15);
        this.Q.setTag(obj15);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ih
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ih
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ih
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((t)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ih
    public void V(t t) {
        this.T = t;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = t;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ih
    protected void m() {
        int cmp;
        int variationTips;
        int valueOf;
        t tVar;
        valueOf = 0;
        this.U = valueOf;
        tVar = this.T;
        cmp = Long.compare(i, valueOf);
        synchronized (this) {
            valueOf = 0;
            this.U = valueOf;
            tVar = this.T;
            cmp = Long.compare(i, valueOf);
        }
        try {
            if (tVar != null) {
            } else {
            }
            valueOf = tVar.h();
            tVar = tVar.i();
            tVar = variationTips;
            if (tVar != 0) {
            }
            variationTips = tVar.getVariationTips();
            if (cmp != 0) {
            }
            f.v(this.O, this.P, Long.valueOf(valueOf));
            l.p0(this.Q, variationTips);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ih
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
