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
public class v extends app.dogo.com.dogo_android.h.u {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v.T = sparseIntArray;
        sparseIntArray.put(2131363374, 2);
    }

    public v(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, v.S, v.T));
    }

    private v(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (RecyclerView)object3Arr3[1], (TextView)object3Arr3[2]);
        this.R = -1;
        Object obj8 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj8;
        final int obj10 = 0;
        obj8.setTag(obj10);
        this.O.setTag(obj10);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.u
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

    @Override // app.dogo.com.dogo_android.h.u
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

    @Override // app.dogo.com.dogo_android.h.u
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
