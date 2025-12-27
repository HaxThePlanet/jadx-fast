package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentDogCreationWelcomeBindingImpl.java */
/* loaded from: classes.dex */
public class zb extends yb {

    private static final ViewDataBinding.g T = new ViewDataBinding$g(6);
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout R;
    private long S;
    static {
        int i5 = 1;
        final int[] iArr = new int[i5];
        final int i10 = 0;
        iArr[i10] = 2;
        int[] iArr2 = new int[i5];
        iArr2[i10] = R.layout.layout_custom_fab;
        obj.a(i5, new String[] { "layout_custom_fab" }, iArr, iArr2);
        obj.put(2131363240, 3);
        obj.put(2131363214, 4);
        obj.put(2131363414, 5);
    }

    public zb(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, zb.T, zb.U));
    }

    private boolean V(gi giVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.S |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.yb
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.yb
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.yb
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.yb
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.S & 3L;
        if (l2 != l3) {
            BindingAdapters.t0(this.P, this.O);
        }
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.yb
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.O.y()) {
            return true;
        }
        return false;
    }

    private zb(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (gi)objectArr[2], (FrameLayout)objectArr[1], (ImageView)objectArr[4], (Button)objectArr[3], (TextView)objectArr[5]);
        this.S = -1L;
        L(this.O);
        Object obj6 = objectArr[0];
        this.R = obj6;
        final Object obj7 = null;
        obj6.setTag(obj7);
        this.P.setTag(obj7);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yb
    public boolean O(int i, Object object) {
        return true;
    }
}
