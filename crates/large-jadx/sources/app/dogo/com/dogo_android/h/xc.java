package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
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
import app.dogo.com.dogo_android.repository.domain.ProgramExam;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.o.q.a;
import app.dogo.com.dogo_android.y.o.t;
import java.util.List;

/* loaded from: classes.dex */
public class xc extends app.dogo.com.dogo_android.h.wc implements c.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final SwipeRefreshLayout.j U;
    private long V;
    static {
    }

    public xc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, xc.W, xc.X));
    }

    private xc(e e, View view2, Object[] object3Arr3) {
        int i3 = 1;
        super(e, view2, 1, (RecyclerView)object3Arr3[3], (SwipeRefreshLayout)object3Arr3[2], (MaterialToolbar)object3Arr3[i3]);
        this.V = -1;
        Object obj9 = object3Arr3[0];
        this.T = (ConstraintLayout)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        this.O.setTag(obj11);
        this.P.setTag(obj11);
        this.Q.setTag(obj11);
        N(view2);
        obj9 = new c(this, i3);
        this.U = obj9;
        A();
    }

    private boolean X(LiveData<y<List<ProgramExam>>> liveData, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.wc
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wc
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.wc
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((q.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((t)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.wc
    public void V(q.a q$a) {
        this.S = a;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.S = a;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wc
    public void W(t t) {
        this.R = t;
        this.V = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = t;
            this.V = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wc
    public final void a(int i) {
        int i2;
        final t obj2 = this.R;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.v();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wc
    protected void m() {
        int cmp;
        SwipeRefreshLayout.j jVar;
        int i;
        int cmp2;
        int i2;
        int result;
        int value;
        int cmp3;
        long l = this.V;
        final int i4 = 0;
        this.V = i4;
        t tVar = this.R;
        int cmp4 = Long.compare(i7, i4);
        int i8 = 13;
        i2 = 0;
        synchronized (this) {
            l = this.V;
            i4 = 0;
            this.V = i4;
            tVar = this.R;
            cmp4 = Long.compare(i7, i4);
            i8 = 13;
            i2 = 0;
        }
        try {
            if (tVar != null) {
            } else {
            }
            result = tVar.getResult();
            result = i2;
            Q(0, result);
            if (result != null) {
            } else {
            }
            value = result.getValue();
            value = i2;
        }
        if (tVar != null) {
            i2 = tVar.o(value);
        }
        i = i2;
        i2 = value;
        if (Long.compare(i9, i4) != 0) {
            n.F0(this.T, i2);
            n.y0(this.P, i2);
            this.Q.setTitle(i);
        }
        if (cmp4 != 0) {
            l.Z(this.O, i2, this.S);
        }
        if (Long.compare(i3, i4) != 0) {
            this.P.setOnRefreshListener(this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wc
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
