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
import androidx.lifecycle.x;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.y.e.a;
import app.dogo.com.dogo_android.y.y.h;
import java.util.List;

/* loaded from: classes.dex */
public class tf extends app.dogo.com.dogo_android.h.sf implements c.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final SwipeRefreshLayout.j U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        tf.X = sparseIntArray;
        sparseIntArray.put(2131363433, 3);
        sparseIntArray.put(2131362597, 4);
    }

    public tf(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, tf.W, tf.X));
    }

    private tf(e e, View view2, Object[] object3Arr3) {
        int i3 = 1;
        super(e, view2, 1, (ConstraintLayout)object3Arr3[4], (RecyclerView)object3Arr3[2], (SwipeRefreshLayout)object3Arr3[i3], (MaterialToolbar)object3Arr3[3]);
        this.V = -1;
        Object obj10 = object3Arr3[0];
        this.T = (ConstraintLayout)obj10;
        final int obj12 = 0;
        obj10.setTag(obj12);
        this.O.setTag(obj12);
        this.P.setTag(obj12);
        N(view2);
        obj10 = new c(this, i3);
        this.U = obj10;
        A();
    }

    private boolean X(x<y<List<ProgramDescriptionItem>>> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.sf
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sf
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.sf
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((e.a)object2);
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

    @Override // app.dogo.com.dogo_android.h.sf
    public void V(e.a e$a) {
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

    @Override // app.dogo.com.dogo_android.h.sf
    public void W(h h) {
        this.R = h;
        this.V = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.R = h;
            this.V = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sf
    public final void a(int i) {
        int i2;
        final h obj2 = this.R;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.l();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sf
    protected void m() {
        int cmp2;
        SwipeRefreshLayout.j jVar;
        h value;
        int cmp;
        int cmp3;
        int i2;
        int i;
        long l = this.V;
        final int i4 = 0;
        this.V = i4;
        value = this.R;
        cmp3 = Long.compare(i7, i4);
        synchronized (this) {
            l = this.V;
            i4 = 0;
            this.V = i4;
            value = this.R;
            cmp3 = Long.compare(i7, i4);
        }
        try {
            if (value != null) {
            } else {
            }
            value = value.k();
            value = i2;
            Q(0, value);
            if (value != null) {
            }
            i2 = value;
            if (Long.compare(i9, i4) != 0) {
            }
            n.F0(this.T, i2);
            n.y0(this.P, i2);
        }
        if (cmp3 != 0) {
            l.c0(this.O, i2, this.S, 2131558778);
        }
        if (Long.compare(i3, i4) != 0) {
            this.P.setOnRefreshListener(this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.sf
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
