package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.repository.domain.ProgramExamList;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.o.u.b;
import app.dogo.com.dogo_android.y.o.x;

/* loaded from: classes.dex */
public class nf extends app.dogo.com.dogo_android.h.mf implements c.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final SwipeRefreshLayout.j U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        nf.X = sparseIntArray;
        sparseIntArray.put(2131363433, 3);
    }

    public nf(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, nf.W, nf.X));
    }

    private nf(e e, View view2, Object[] object3Arr3) {
        int i2 = 1;
        super(e, view2, 1, (RecyclerView)object3Arr3[2], (SwipeRefreshLayout)object3Arr3[i2], (MaterialToolbar)object3Arr3[3]);
        this.V = -1;
        Object obj9 = object3Arr3[0];
        this.T = (ConstraintLayout)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        this.O.setTag(obj11);
        this.P.setTag(obj11);
        N(view2);
        obj9 = new c(this, i2);
        this.U = obj9;
        A();
    }

    private boolean X(LiveData<y<ProgramExamList>> liveData, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.mf
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mf
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.mf
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((u.b)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((x)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.mf
    public void V(u.b u$b) {
        this.S = b;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.S = b;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mf
    public void W(x x) {
        this.R = x;
        this.V = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = x;
            this.V = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mf
    public final void a(int i) {
        int i2;
        final x obj2 = this.R;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.z();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mf
    protected void m() {
        int cmp;
        int cmp2;
        x result;
        int valueOf;
        int i;
        int i2;
        int i3;
        long l = this.V;
        final int i5 = 0;
        this.V = i5;
        result = this.R;
        valueOf = Long.compare(i10, i5);
        i = 0;
        synchronized (this) {
            l = this.V;
            i5 = 0;
            this.V = i5;
            result = this.R;
            valueOf = Long.compare(i10, i5);
            i = 0;
        }
        try {
            if (result != null) {
            } else {
            }
            i3 = result.u();
            result = result.getResult();
            i3 = i;
            result = i2;
            Q(i, result);
            if (result != null) {
            }
            i2 = result;
            i = i3;
        }
        l.a0(this.O, i2, this.S, Boolean.valueOf(i));
        if (Long.compare(i7, i5) != 0) {
            this.P.setOnRefreshListener(this.U);
        }
        if (Long.compare(i4, i5) != 0) {
            n.y0(this.P, i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.mf
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
