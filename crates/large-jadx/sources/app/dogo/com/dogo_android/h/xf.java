package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.a0.e.c;
import app.dogo.com.dogo_android.y.a0.h;
import app.dogo.com.dogo_android.y.l;
import f.d.a.a;

/* loaded from: classes.dex */
public class xf extends app.dogo.com.dogo_android.h.wf {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout R;
    private final RecyclerView S;
    private final FrameLayout T;
    private final app.dogo.com.dogo_android.h.ml U;
    private long V;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(5);
        xf.W = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i8 = 0;
        iArr2[i8] = 3;
        int[] iArr = new int[i3];
        iArr[i8] = 2131558788;
        gVar.a(2, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        xf.X = sparseIntArray;
        sparseIntArray.put(2131363433, 4);
    }

    public xf(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, xf.W, xf.X));
    }

    private xf(e e, View view2, Object[] object3Arr3) {
        final int i3 = 1;
        super(e, view2, i3, (MaterialToolbar)object3Arr3[4]);
        this.V = -1;
        Object obj5 = object3Arr3[0];
        this.R = (ConstraintLayout)obj5;
        int i2 = 0;
        obj5.setTag(i2);
        obj5 = object3Arr3[i3];
        this.S = (RecyclerView)obj5;
        obj5.setTag(i2);
        obj5 = object3Arr3[2];
        this.T = (FrameLayout)obj5;
        obj5.setTag(i2);
        obj5 = object3Arr3[3];
        this.U = (ml)obj5;
        L(obj5);
        N(view2);
        A();
    }

    private boolean X(a<y<Boolean>> a, int i2) {
        if (i2 == 0) {
            this.V = obj3 |= i;
            return 1;
            synchronized (this) {
                this.V = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.wf
    public void A() {
        this.V = 8;
        this.U.A();
        I();
        return;
        synchronized (this) {
            this.V = 8;
            this.U.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wf
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((a)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.wf
    public void M(q q) {
        super.M(q);
        this.U.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.wf
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((e.c)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((h)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.wf
    public void V(e.c e$c) {
        this.Q = c;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Q = c;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wf
    public void W(h h) {
        this.P = h;
        this.V = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.P = h;
            this.V = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wf
    protected void m() {
        int cmp2;
        Object hVar;
        int cmp;
        int value;
        int i;
        int i2;
        long l = this.V;
        final int i4 = 0;
        this.V = i4;
        hVar = this.P;
        int cmp3 = Long.compare(i6, i4);
        final int i9 = 13;
        i = 0;
        synchronized (this) {
            l = this.V;
            i4 = 0;
            this.V = i4;
            hVar = this.P;
            cmp3 = Long.compare(i6, i4);
            i9 = 13;
            i = 0;
        }
        try {
            if (Long.compare(i2, i4) != 0) {
            } else {
            }
            if (hVar != null) {
            } else {
            }
            cmp = hVar.n();
            cmp = i;
            Q(0, cmp);
            if (cmp != null) {
            } else {
            }
            value = cmp.getValue();
            value = i;
        }
        if (cmp3 != 0 && hVar != null) {
            if (hVar != null) {
                i = hVar.l();
            }
        }
        if (cmp3 != 0) {
            l.g0(this.S, i, this.Q);
        }
        if (Long.compare(i3, i4) != 0) {
            n.D0(this.T, value);
        }
        ViewDataBinding.o(this.U);
    }

    @Override // app.dogo.com.dogo_android.h.wf
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.U.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
