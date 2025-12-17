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
public class x7 extends app.dogo.com.dogo_android.h.w7 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        x7.T = sparseIntArray;
        sparseIntArray.put(2131362619, 2);
    }

    public x7(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, x7.S, x7.T));
    }

    private x7(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[2], (TextView)object3Arr3[1]);
        this.R = -1;
        Object obj8 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj8;
        final int obj10 = 0;
        obj8.setTag(obj10);
        this.O.setTag(obj10);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.w7
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w7
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.w7
    public boolean O(int i, Object object2) {
        int obj2;
        if (62 == i) {
            V((String)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.w7
    public void V(String string) {
        this.P = string;
        this.R = l |= i2;
        notifyPropertyChanged(62);
        super.I();
        return;
        synchronized (this) {
            this.P = string;
            this.R = l |= i2;
            notifyPropertyChanged(62);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w7
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.R = i2;
        synchronized (this) {
            i2 = 0;
            this.R = i2;
        }
        try {
            g.c(this.O, this.P);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.w7
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
