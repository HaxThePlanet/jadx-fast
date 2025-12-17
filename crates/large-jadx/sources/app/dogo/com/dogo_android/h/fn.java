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
public class fn extends app.dogo.com.dogo_android.h.en {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        fn.U = sparseIntArray;
        sparseIntArray.put(2131361978, 2);
        sparseIntArray.put(2131361979, 3);
    }

    public fn(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, fn.T, fn.U));
    }

    private fn(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (FrameLayout)object3Arr3[2], (AppCompatImageView)object3Arr3[3], (ConstraintLayout)object3Arr3[0], (TextView)object3Arr3[1]);
        this.S = -1;
        int obj12 = 0;
        this.P.setTag(obj12);
        this.Q.setTag(obj12);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.en
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.en
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.en
    public boolean O(int i, Object object2) {
        int obj2;
        if (155 == i) {
            T((String)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.en
    public void T(String string) {
        this.R = string;
        this.S = l |= i2;
        notifyPropertyChanged(155);
        super.I();
        return;
        synchronized (this) {
            this.R = string;
            this.S = l |= i2;
            notifyPropertyChanged(155);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.en
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.S = i2;
        synchronized (this) {
            i2 = 0;
            this.S = i2;
        }
        try {
            g.c(this.Q, this.R);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.en
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
