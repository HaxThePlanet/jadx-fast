package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;

/* loaded from: classes.dex */
public class z3 extends app.dogo.com.dogo_android.h.y3 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout P;
    private final AppCompatImageView Q;
    private long R;
    static {
    }

    public z3(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, z3.S, z3.T));
    }

    private z3(e e, View view2, Object[] object3Arr3) {
        int i = 0;
        super(e, view2, i);
        this.R = -1;
        Object obj4 = object3Arr3[i];
        this.P = (ConstraintLayout)obj4;
        int i2 = 0;
        obj4.setTag(i2);
        obj4 = object3Arr3[1];
        this.Q = (AppCompatImageView)obj4;
        obj4.setTag(i2);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y3
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y3
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.y3
    public boolean O(int i, Object object2) {
        int obj2;
        if (86 == i) {
            V((Integer)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.y3
    public void V(Integer integer) {
        this.O = integer;
        this.R = l |= i2;
        notifyPropertyChanged(86);
        super.I();
        return;
        synchronized (this) {
            this.O = integer;
            this.R = l |= i2;
            notifyPropertyChanged(86);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y3
    protected void m() {
        int cmp;
        int i;
        final int i3 = 0;
        this.R = i3;
        i = 0;
        cmp = Long.compare(i2, i3);
        synchronized (this) {
            i3 = 0;
            this.R = i3;
            i = 0;
            cmp = Long.compare(i2, i3);
        }
        try {
            i = ViewDataBinding.J(this.O);
            if (cmp != 0) {
            }
            this.Q.setImageResource(i);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.y3
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
