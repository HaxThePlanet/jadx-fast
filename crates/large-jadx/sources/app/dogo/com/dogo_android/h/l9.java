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
import app.dogo.com.dogo_android.i.o0.a;
import app.dogo.com.dogo_android.i.q0;
import app.dogo.com.dogo_android.i.s0;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* loaded from: classes.dex */
public class l9 extends app.dogo.com.dogo_android.h.k9 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        l9.V = sparseIntArray;
        sparseIntArray.put(2131363172, 2);
    }

    public l9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, l9.U, l9.V));
    }

    private l9(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (RecyclerView)object3Arr3[1], (Button)object3Arr3[2]);
        this.T = -1;
        Object obj8 = object3Arr3[0];
        this.S = (ConstraintLayout)obj8;
        final int obj10 = 0;
        obj8.setTag(obj10);
        this.O.setTag(obj10);
        N(view2);
        A();
    }

    private boolean X(x<List<q0>> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.k9
    public void A() {
        this.T = 8;
        I();
        return;
        synchronized (this) {
            this.T = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k9
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.k9
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((o0.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((s0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.k9
    public void V(o0.a o0$a) {
        this.R = a;
        this.T = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.R = a;
            this.T = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k9
    public void W(s0 s0) {
        this.Q = s0;
        this.T = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Q = s0;
            this.T = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k9
    protected void m() {
        int cmp;
        int value;
        int i;
        int i2;
        i = 0;
        this.T = i;
        final s0 s0Var = this.Q;
        cmp = Long.compare(i3, i);
        synchronized (this) {
            i = 0;
            this.T = i;
            s0Var = this.Q;
            cmp = Long.compare(i3, i);
        }
        try {
            if (s0Var != null) {
            } else {
            }
            i = s0Var.h();
            i = value;
            Q(0, i);
            if (i != 0) {
            }
            value = i.getValue();
            if (cmp != 0) {
            }
            n.L(this.O, value, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k9
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
