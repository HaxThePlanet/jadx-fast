package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.q;

/* compiled from: FragmentLoadingBindingImpl.java */
/* loaded from: classes.dex */
public class de extends ce {

    private static final ViewDataBinding.g R = new ViewDataBinding$g(2);
    private static final SparseIntArray S = null;
    private final ml P;
    private long Q;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i4 = 0;
        iArr2[i4] = i3;
        int[] iArr = new int[i3];
        iArr[i4] = R.layout.layout_loading_spinner;
        obj.a(i4, new String[] { "layout_loading_spinner" }, iArr2, iArr);
    }

    public de(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, de.R, de.S));
    }

    @Override // app.dogo.com.dogo_android.h.ce
    public void A() {
        synchronized (this) {
            try {
                this.Q = 1L;
            } catch (Throwable th) {
            }
        }
        this.P.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ce
    public void M(q qVar) {
        super.M(qVar);
        this.P.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ce
    protected void m() {
        synchronized (this) {
            try {
                this.Q = 0L;
            } catch (Throwable th) {
            }
        }
        ViewDataBinding.o(this.P);
    }

    @Override // app.dogo.com.dogo_android.h.ce
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.Q != 0) {
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

    private de(e eVar, View view, Object[] objectArr) {
        int i = 0;
        super(eVar, view, i, (ConstraintLayout)objectArr[i]);
        this.Q = -1L;
        this.O.setTag(null);
        Object obj2 = objectArr[1];
        this.P = obj2;
        L(obj2);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ce
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ce
    public boolean O(int i, Object object) {
        return true;
    }
}
