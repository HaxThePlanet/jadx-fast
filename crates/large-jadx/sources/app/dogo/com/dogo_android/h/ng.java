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
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.f.m.e;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* loaded from: classes.dex */
public class ng extends app.dogo.com.dogo_android.h.mg implements c.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final SwipeRefreshLayout.j U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ng.X = sparseIntArray;
        sparseIntArray.put(2131363433, 3);
    }

    public ng(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, ng.W, ng.X));
    }

    private ng(e e, View view2, Object[] object3Arr3) {
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

    private boolean X(LiveData<y<List<TrickItem>>> liveData, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.mg
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mg
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.mg
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((o.a)object2);
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

    @Override // app.dogo.com.dogo_android.h.mg
    public void V(o.a o$a) {
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

    @Override // app.dogo.com.dogo_android.h.mg
    public void W(e e) {
        this.R = e;
        this.V = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = e;
            this.V = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mg
    public final void a(int i) {
        int i2;
        final e obj2 = this.R;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.s();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mg
    protected void m() {
        int cmp2;
        SwipeRefreshLayout.j jVar;
        int cmp;
        e result;
        int i;
        int i2;
        long l = this.V;
        final int i4 = 0;
        this.V = i4;
        result = this.R;
        int cmp3 = Long.compare(i9, i4);
        synchronized (this) {
            l = this.V;
            i4 = 0;
            this.V = i4;
            result = this.R;
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
            i.w(this.O, this.S, i);
        }
        if (Long.compare(i6, i4) != 0) {
            n.y0(this.P, i);
        }
        if (Long.compare(i3, i4) != 0) {
            this.P.setOnRefreshListener(this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.mg
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
