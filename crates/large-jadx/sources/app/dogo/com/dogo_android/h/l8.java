package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.d.a.m;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: DialogChallengeFanListBindingImpl.java */
/* loaded from: classes.dex */
public class l8 extends k8 {

    private static final ViewDataBinding.g S = new ViewDataBinding$g(3);
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i5 = 0;
        iArr2[i5] = i3;
        int[] iArr = new int[i3];
        iArr[i5] = R.layout.layout_top_bar;
        obj.a(i5, new String[] { "layout_top_bar" }, iArr2, iArr);
        obj.put(2131363042, 2);
    }

    public l8(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, l8.S, l8.T));
    }

    private boolean X(cn cnVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.R |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(m mVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.R |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public void A() {
        synchronized (this) {
            try {
                this.R = 8L;
            } catch (Throwable th) {
            }
        }
        this.P.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.k8
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public void M(q qVar) {
        super.M(qVar);
        this.P.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public boolean O(int i, Object object) {
        int i2 = 183;
        boolean z = true;
        i2 = 183;
        if (183 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 116;
            if (116 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.k8
    protected void m() {
        synchronized (this) {
            try {
                this.R = 0L;
            } catch (Throwable th) {
            }
        }
        ViewDataBinding.o(this.P);
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.P.y()) {
            return true;
        }
        return false;
    }

    private l8(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (RecyclerView)objectArr[2], (cn)objectArr[1]);
        this.R = -1L;
        Object obj3 = objectArr[0];
        this.Q = obj3;
        obj3.setTag(null);
        L(this.P);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public void V(a0 a0Var) {
    }

    @Override // app.dogo.com.dogo_android.h.k8
    public void W(m mVar) {
    }
}
