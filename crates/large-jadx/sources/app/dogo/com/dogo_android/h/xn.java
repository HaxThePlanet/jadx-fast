package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* loaded from: classes.dex */
public class xn extends app.dogo.com.dogo_android.h.wn {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        xn.T = sparseIntArray;
        sparseIntArray.put(2131362298, 2);
        sparseIntArray.put(2131362096, 3);
    }

    public xn(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, xn.S, xn.T));
    }

    private xn(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (MaterialButton)object3Arr3[3], (TextView)object3Arr3[2], (TextView)object3Arr3[1]);
        this.R = -1;
        Object obj9 = object3Arr3[0];
        this.Q = (ConstraintLayout)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        this.P.setTag(obj11);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.wn
    public void A() {
        this.R = 1;
        I();
        return;
        synchronized (this) {
            this.R = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wn
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.wn
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.wn
    protected void m() {
        int cmp;
        String string;
        int i;
        Integer valueOf;
        int arr;
        int i3;
        int i2;
        Integer valueOf2;
        i = 0;
        this.R = i;
        synchronized (this) {
            i = 0;
            this.R = i;
        }
        try {
            cmp = this.P;
            int i5 = 2;
            arr = new Object[i5];
            i2 = 1;
            arr[0] = Integer.valueOf(i2);
            arr[i2] = Integer.valueOf(i5);
            g.c(cmp, cmp.getResources().getString(2131887701, arr));
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.wn
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
