package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* loaded from: classes.dex */
public class x6 extends app.dogo.com.dogo_android.h.w6 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
    }

    public x6(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, x6.S, x6.T));
    }

    private x6(e e, View view2, Object[] object3Arr3) {
        final int i2 = 0;
        super(e, view2, i2, (CheckedTextView)object3Arr3[1]);
        this.R = -1;
        Object obj5 = object3Arr3[i2];
        this.Q = (ConstraintLayout)obj5;
        final int obj7 = 0;
        obj5.setTag(obj7);
        this.O.setTag(obj7);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.w6
    public void A() {
        this.R = 2;
        I();
        return;
        synchronized (this) {
            this.R = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w6
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.w6
    public boolean O(int i, Object object2) {
        int obj2;
        if (97 == i) {
            V((String)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.w6
    public void V(String string) {
        this.P = string;
        this.R = l |= i2;
        notifyPropertyChanged(97);
        super.I();
        return;
        synchronized (this) {
            this.P = string;
            this.R = l |= i2;
            notifyPropertyChanged(97);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.w6
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

    @Override // app.dogo.com.dogo_android.h.w6
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
