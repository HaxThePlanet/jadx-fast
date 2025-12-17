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
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.s.i.a;
import app.dogo.com.dogo_android.y.s.l;

/* loaded from: classes.dex */
public class jf extends app.dogo.com.dogo_android.h.if implements c.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout S;
    private final RecyclerView T;
    private final SwipeRefreshLayout.j U;
    private long V;
    static {
    }

    public jf(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, jf.W, jf.X));
    }

    private jf(e e, View view2, Object[] object3Arr3) {
        int i2 = 1;
        super(e, view2, 1, (SwipeRefreshLayout)object3Arr3[2], (MaterialToolbar)object3Arr3[i2]);
        this.V = -1;
        Object obj8 = object3Arr3[0];
        this.S = (ConstraintLayout)obj8;
        int i4 = 0;
        obj8.setTag(i4);
        obj8 = object3Arr3[3];
        this.T = (RecyclerView)obj8;
        obj8.setTag(i4);
        this.O.setTag(i4);
        this.P.setTag(i4);
        N(view2);
        obj8 = new c(this, i2);
        this.U = obj8;
        A();
    }

    private boolean Y(LiveData<y<ProgramLessonItem>> liveData, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.if
    public void A() {
        this.V = 16;
        I();
        return;
        synchronized (this) {
            this.V = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.if
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return Y((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.if
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((i.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                X((l)object2);
            } else {
                if (141 == i) {
                    W((l)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.if
    public void V(i.a i$a) {
        this.R = a;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.R = a;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.if
    public void W(l l) {
    }

    @Override // app.dogo.com.dogo_android.h.if
    public void X(l l) {
        this.Q = l;
        this.V = l2 |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Q = l;
            this.V = l2 |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.if
    public final void a(int i) {
        int i2;
        final l obj2 = this.Q;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.u();
        }
    }

    @Override // app.dogo.com.dogo_android.h.if
    protected void m() {
        int cmp2;
        SwipeRefreshLayout.j jVar;
        int cmp;
        l result;
        int i;
        int i2;
        long l = this.V;
        final int i4 = 0;
        this.V = i4;
        result = this.Q;
        int cmp3 = Long.compare(i9, i4);
        synchronized (this) {
            l = this.V;
            i4 = 0;
            this.V = i4;
            result = this.Q;
            cmp3 = Long.compare(i9, i4);
        }
        try {
            if (result != null) {
            } else {
            }
            result = result.getResult();
            result = i;
            Q(0, result);
            if (result != null) {
            }
            i = result;
            if (cmp3 != 0) {
            }
            l.J(this.T, i, this.R);
        }
        if (Long.compare(i6, i4) != 0) {
            n.y0(this.O, i);
            l.Q(this.P, i);
        }
        if (Long.compare(i3, i4) != 0) {
            this.O.setOnRefreshListener(this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.if
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
