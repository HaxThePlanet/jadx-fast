package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.g.b0;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;

/* loaded from: classes.dex */
public class xj extends app.dogo.com.dogo_android.h.wj implements b.a {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final CardView Q;
    private final View.OnClickListener R;
    private final View.OnClickListener S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        xj.V = sparseIntArray;
        sparseIntArray.put(2131363222, 2);
        sparseIntArray.put(2131363414, 3);
        sparseIntArray.put(2131362298, 4);
    }

    public xj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, xj.U, xj.V));
    }

    private xj(e e, View view2, Object[] object3Arr3) {
        int i2 = 2;
        final int i6 = 1;
        super(e, view2, 0, (TextView)object3Arr3[4], (ShimmerFrameLayout)object3Arr3[i2], (MaterialButton)object3Arr3[i6], (TextView)object3Arr3[3]);
        this.T = -1;
        Object obj11 = object3Arr3[0];
        this.Q = (CardView)obj11;
        final int obj13 = 0;
        obj11.setTag(obj13);
        this.O.setTag(obj13);
        N(view2);
        obj11 = new b(this, i2);
        this.R = obj11;
        obj11 = new b(this, i6);
        this.S = obj11;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.wj
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wj
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.wj
    public boolean O(int i, Object object2) {
        int obj2;
        if (29 == i) {
            V((o)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.wj
    public void V(o o) {
        this.P = o;
        this.T = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.P = o;
            this.T = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wj
    public final void b(int i, View view2) {
        int i2;
        o obj3;
        int obj4;
        obj4 = 0;
        final int i3 = 1;
        if (i != i3) {
            if (i != 2) {
            } else {
                obj3 = this.P;
                if (obj3 != null) {
                    obj4 = i3;
                }
                if (obj4 != null) {
                    obj3.c();
                }
            }
        } else {
            obj3 = this.P;
            if (obj3 != null) {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.c();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.wj
    protected void m() {
        int cmp;
        View.OnClickListener list;
        final int i2 = 0;
        this.T = i2;
        synchronized (this) {
            i2 = 0;
            this.T = i2;
        }
        try {
            this.Q.setOnClickListener(this.S);
            this.O.setOnClickListener(this.R);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.wj
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
