package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.u.h;

/* loaded from: classes.dex */
public class vh extends app.dogo.com.dogo_android.h.uh {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final app.dogo.com.dogo_android.h.wh P;
    private final ConstraintLayout Q;
    private long R;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(3);
        vh.S = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i5 = 0;
        iArr2[i5] = i3;
        int[] iArr = new int[i3];
        iArr[i5] = 2131558740;
        gVar.a(i5, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        vh.T = sparseIntArray;
        sparseIntArray.put(2131363414, 2);
    }

    public vh(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, vh.S, vh.T));
    }

    private vh(e e, View view2, Object[] object3Arr3) {
        final int i2 = 0;
        super(e, view2, i2, (TextView)object3Arr3[2]);
        this.R = -1;
        Object obj5 = object3Arr3[1];
        this.P = (wh)obj5;
        L(obj5);
        obj5 = object3Arr3[i2];
        this.Q = (ConstraintLayout)obj5;
        obj5.setTag(0);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.uh
    public void A() {
        this.R = 2;
        this.P.A();
        I();
        return;
        synchronized (this) {
            this.R = 2;
            this.P.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uh
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.uh
    public void M(q q) {
        super.M(q);
        this.P.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.uh
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((h)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.uh
    public void V(h h) {
        this.O = h;
        this.R = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.O = h;
            this.R = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uh
    protected void m() {
        int cmp;
        final int i2 = 0;
        this.R = i2;
        synchronized (this) {
            i2 = 0;
            this.R = i2;
        }
        try {
            this.P.T(this.O);
            ViewDataBinding.o(this.P);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.uh
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.P.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
