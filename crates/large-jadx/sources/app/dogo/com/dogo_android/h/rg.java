package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* loaded from: classes.dex */
public class rg extends app.dogo.com.dogo_android.h.qg {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        rg.U = sparseIntArray;
        sparseIntArray.put(2131363433, 2);
    }

    public rg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, rg.T, rg.U));
    }

    private rg(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ConstraintLayout)object3Arr3[0], (TextView)object3Arr3[1], (MaterialToolbar)object3Arr3[2]);
        this.S = -1;
        int obj11 = 0;
        this.O.setTag(obj11);
        this.P.setTag(obj11);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.qg
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qg
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.qg
    public boolean O(int i, Object object2) {
        int obj2;
        if (51 == i) {
            V((String)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.qg
    public void V(String string) {
        this.R = string;
        this.S = l |= i2;
        notifyPropertyChanged(51);
        super.I();
        return;
        synchronized (this) {
            this.R = string;
            this.S = l |= i2;
            notifyPropertyChanged(51);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qg
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.S = i2;
        synchronized (this) {
            i2 = 0;
            this.S = i2;
        }
        try {
            g.c(this.P, this.R);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.qg
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
