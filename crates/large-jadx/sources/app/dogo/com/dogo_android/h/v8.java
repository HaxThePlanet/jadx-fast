package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.e.k.a;
import app.dogo.com.dogo_android.e.n;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class v8 extends app.dogo.com.dogo_android.h.u8 implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final View.OnClickListener T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v8.W = sparseIntArray;
        sparseIntArray.put(2131363414, 3);
    }

    public v8(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, v8.V, v8.W));
    }

    private v8(e e, View view2, Object[] object3Arr3) {
        int i3 = 1;
        super(e, view2, 0, (Button)object3Arr3[2], (ConstraintLayout)object3Arr3[0], (RecyclerView)object3Arr3[i3], (TextView)object3Arr3[3]);
        this.U = -1;
        int obj12 = 0;
        this.O.setTag(obj12);
        this.P.setTag(obj12);
        this.Q.setTag(obj12);
        N(view2);
        b obj10 = new b(this, i3);
        this.T = obj10;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u8
    public void A() {
        this.U = 4;
        I();
        return;
        synchronized (this) {
            this.U = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u8
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.u8
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((k.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((n)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.u8
    public void V(k.a k$a) {
        this.S = a;
        this.U = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.S = a;
            this.U = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u8
    public void W(n n) {
        this.R = n;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = n;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u8
    public final void b(int i, View view2) {
        int obj2;
        final n obj1 = this.R;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.i();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u8
    protected void m() {
        int cmp;
        View.OnClickListener valueOf;
        int i;
        long l = this.U;
        final int i3 = 0;
        this.U = i3;
        i = 0;
        final n nVar = this.R;
        int cmp2 = Long.compare(i5, i3);
        synchronized (this) {
            l = this.U;
            i3 = 0;
            this.U = i3;
            i = 0;
            nVar = this.R;
            cmp2 = Long.compare(i5, i3);
        }
        try {
            if (nVar != null) {
            }
            i = nVar.j();
            if (Long.compare(i2, i3) != 0) {
            }
            this.O.setOnClickListener(this.T);
            if (cmp2 != 0) {
            }
            n.s0(this.Q, Integer.valueOf(i), this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.u8
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
