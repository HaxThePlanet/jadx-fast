package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.q;

/* loaded from: classes.dex */
public class de extends app.dogo.com.dogo_android.h.ce {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S = null;
    private final app.dogo.com.dogo_android.h.ml P;
    private long Q;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(2);
        de.R = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i4 = 0;
        iArr2[i4] = i3;
        int[] iArr = new int[i3];
        iArr[i4] = 2131558788;
        gVar.a(i4, /* result */, iArr2, iArr);
        int i = 0;
    }

    public de(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 2, de.R, de.S));
    }

    private de(e e, View view2, Object[] object3Arr3) {
        int i = 0;
        super(e, view2, i, (ConstraintLayout)object3Arr3[i]);
        this.Q = -1;
        this.O.setTag(0);
        Object obj3 = object3Arr3[1];
        this.P = (ml)obj3;
        L(obj3);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ce
    public void A() {
        this.Q = 1;
        this.P.A();
        I();
        return;
        synchronized (this) {
            this.Q = 1;
            this.P.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ce
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ce
    public void M(q q) {
        super.M(q);
        this.P.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ce
    public boolean O(int i, Object object2) {
        return 1;
    }

    @Override // app.dogo.com.dogo_android.h.ce
    protected void m() {
        this.Q = 0;
        ViewDataBinding.o(this.P);
        return;
        synchronized (this) {
            this.Q = 0;
            ViewDataBinding.o(this.P);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ce
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
