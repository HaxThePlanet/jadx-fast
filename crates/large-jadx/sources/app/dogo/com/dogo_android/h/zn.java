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
public class zn extends app.dogo.com.dogo_android.h.yn {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zn.T = sparseIntArray;
        sparseIntArray.put(2131362298, 2);
        sparseIntArray.put(2131362093, 3);
    }

    public zn(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, zn.S, zn.T));
    }

    private zn(e e, View view2, Object[] object3Arr3) {
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

    @Override // app.dogo.com.dogo_android.h.yn
    public void A() {
        this.R = 1;
        I();
        return;
        synchronized (this) {
            this.R = 1;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yn
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.yn
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.yn
    protected void m() {
        int cmp;
        String string;
        int i2;
        Integer valueOf;
        int arr;
        int i;
        Integer valueOf2;
        i2 = 0;
        this.R = i2;
        synchronized (this) {
            i2 = 0;
            this.R = i2;
        }
        try {
            cmp = this.P;
            int i4 = 2;
            arr = new Object[i4];
            arr[0] = Integer.valueOf(i4);
            arr[1] = Integer.valueOf(i4);
            g.c(cmp, cmp.getResources().getString(2131887701, arr));
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.yn
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
