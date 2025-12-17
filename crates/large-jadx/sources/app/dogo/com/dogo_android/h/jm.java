package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* loaded from: classes.dex */
public class jm extends app.dogo.com.dogo_android.h.im {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout P;
    private final TextView Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        jm.T = sparseIntArray;
        sparseIntArray.put(2131362087, 2);
    }

    public jm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, jm.S, jm.T));
    }

    private jm(e e, View view2, Object[] object3Arr3) {
        final int i3 = 0;
        super(e, view2, i3, (AppCompatImageView)object3Arr3[2]);
        this.R = -1;
        Object obj5 = object3Arr3[i3];
        this.P = (ConstraintLayout)obj5;
        int i2 = 0;
        obj5.setTag(i2);
        obj5 = object3Arr3[1];
        this.Q = (TextView)obj5;
        obj5.setTag(i2);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.im
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.im
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.im
    public boolean O(int i, Object object2) {
        int obj2;
        if (124 == i) {
            V((String)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.im
    public void V(String string) {
        this.O = string;
        this.R = l |= i2;
        notifyPropertyChanged(124);
        super.I();
        return;
        synchronized (this) {
            this.O = string;
            this.R = l |= i2;
            notifyPropertyChanged(124);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.im
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.R = i2;
        synchronized (this) {
            i2 = 0;
            this.R = i2;
        }
        try {
            g.c(this.Q, this.O);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.im
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
