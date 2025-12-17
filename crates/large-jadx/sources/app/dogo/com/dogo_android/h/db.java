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
import app.dogo.com.dogo_android.i.l0;
import app.dogo.com.dogo_android.i.m0;
import app.dogo.com.dogo_android.i.n0.b;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* loaded from: classes.dex */
public class db extends app.dogo.com.dogo_android.h.cb {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout R;
    private final RecyclerView S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        db.V = sparseIntArray;
        sparseIntArray.put(2131363433, 2);
    }

    public db(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, db.U, db.V));
    }

    private db(e e, View view2, Object[] object3Arr3) {
        final int i3 = 1;
        super(e, view2, i3, (MaterialToolbar)object3Arr3[2]);
        this.T = -1;
        Object obj5 = object3Arr3[0];
        this.R = (ConstraintLayout)obj5;
        int i2 = 0;
        obj5.setTag(i2);
        obj5 = object3Arr3[i3];
        this.S = (RecyclerView)obj5;
        obj5.setTag(i2);
        N(view2);
        A();
    }

    private boolean X(LiveData<y<List<m0>>> liveData, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.cb
    public void A() {
        this.T = 8;
        I();
        return;
        synchronized (this) {
            this.T = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cb
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.cb
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (177 == i) {
            W((l0)object2);
            obj2 = 1;
        } else {
            if (28 == i) {
                V((n0.b)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.cb
    public void V(n0.b n0$b) {
        this.Q = b;
        this.T = l |= i2;
        notifyPropertyChanged(28);
        super.I();
        return;
        synchronized (this) {
            this.Q = b;
            this.T = l |= i2;
            notifyPropertyChanged(28);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cb
    public void W(l0 l0) {
        this.P = l0;
        this.T = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.P = l0;
            this.T = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cb
    protected void m() {
        int cmp;
        int value;
        int result;
        int i;
        result = 0;
        this.T = result;
        final l0 l0Var = this.P;
        cmp = Long.compare(i2, result);
        synchronized (this) {
            result = 0;
            this.T = result;
            l0Var = this.P;
            cmp = Long.compare(i2, result);
        }
        try {
            if (l0Var != null) {
            } else {
            }
            result = l0Var.getResult();
            result = value;
            Q(0, result);
            if (result != null) {
            }
            value = result.getValue();
            if (cmp != 0) {
            }
            n.J(this.S, value, this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.cb
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
