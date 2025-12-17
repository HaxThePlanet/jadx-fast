package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.d.b.z.n;

/* loaded from: classes.dex */
public class n0 extends app.dogo.com.dogo_android.h.m0 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final RelativeLayout P;
    private final TextView Q;
    private long R;
    static {
    }

    public n0(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, n0.S, n0.T));
    }

    private n0(e e, View view2, Object[] object3Arr3) {
        final int i = 1;
        super(e, view2, i);
        this.R = -1;
        Object obj4 = object3Arr3[0];
        this.P = (RelativeLayout)obj4;
        int i3 = 0;
        obj4.setTag(i3);
        obj4 = object3Arr3[i];
        this.Q = (TextView)obj4;
        obj4.setTag(i3);
        N(view2);
        A();
    }

    private boolean W(n n, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.R = l2 |= i6;
            return obj5;
            synchronized (this) {
                this.R = l2 |= i6;
                return obj5;
            }
        }
        if (i2 == 43) {
            this.R = l |= i5;
            return obj5;
            synchronized (this) {
                this.R = l |= i5;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.m0
    public void A() {
        this.R = 4;
        I();
        return;
        synchronized (this) {
            this.R = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m0
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((n)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.m0
    public boolean O(int i, Object object2) {
        int obj2;
        if (183 == i) {
            V((n)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.m0
    public void V(n n) {
        R(0, n);
        this.O = n;
        this.R = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, n);
            this.O = n;
            this.R = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m0
    protected void m() {
        int cmp;
        int i2;
        int i3;
        Resources resources;
        n arr;
        int quantityString;
        int i;
        i3 = 0;
        this.R = i3;
        arr = this.O;
        quantityString = 0;
        cmp = Long.compare(i4, i3);
        synchronized (this) {
            i3 = 0;
            this.R = i3;
            arr = this.O;
            quantityString = 0;
            cmp = Long.compare(i4, i3);
        }
        try {
            i2 = 0;
            if (arr != null) {
            } else {
            }
            i3 = arr.a();
            i3 = i2;
            int i5 = 1;
            Object[] arr2 = new Object[i5];
            arr2[i2] = Integer.valueOf(i3);
            i = 2131755009;
            this.Q.getResources().getQuantityString(i, i3, arr2);
            arr = new Object[i5];
            arr[i2] = Integer.valueOf(i3);
            quantityString = this.Q.getResources().getQuantityString(i, i3, arr);
            if (cmp != 0) {
            }
            g.c(this.Q, quantityString);
        }
    }

    @Override // app.dogo.com.dogo_android.h.m0
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
