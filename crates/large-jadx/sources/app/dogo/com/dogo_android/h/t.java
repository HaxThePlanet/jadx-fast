package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.PermissionDescription;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* loaded from: classes.dex */
public class t extends app.dogo.com.dogo_android.h.s {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
    }

    public t(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, t.S, t.T));
    }

    private t(e e, View view2, Object[] object3Arr3) {
        final int i2 = 0;
        super(e, view2, i2, (RecyclerView)object3Arr3[1]);
        this.R = -1;
        Object obj5 = object3Arr3[i2];
        this.Q = (ConstraintLayout)obj5;
        final int obj7 = 0;
        obj5.setTag(obj7);
        this.O.setTag(obj7);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.s
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.s
    public boolean O(int i, Object object2) {
        int obj2;
        if (95 == i) {
            V((List)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public void V(List<PermissionDescription> list) {
        this.P = list;
        this.R = l |= i2;
        notifyPropertyChanged(95);
        super.I();
        return;
        synchronized (this) {
            this.P = list;
            this.R = l |= i2;
            notifyPropertyChanged(95);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.s
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.R = i2;
        synchronized (this) {
            i2 = 0;
            this.R = i2;
        }
        try {
            n.I(this.O, this.P);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.s
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
