package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: LayoutLoadingSpinnerBindingImpl.java */
/* loaded from: classes.dex */
public class nl extends ml {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R = new SparseIntArray();
    private final ConstraintLayout O;
    private long P;
    static {
        obj.put(2131363002, 1);
    }

    public nl(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, nl.Q, nl.R));
    }

    @Override // app.dogo.com.dogo_android.h.ml
    public void A() {
        synchronized (this) {
            try {
                this.P = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ml
    protected void m() {
        synchronized (this) {
            try {
                this.P = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ml
    public boolean y() {
        synchronized (this) {
            try {
                if (this.P != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private nl(e eVar, View view, Object[] objectArr) {
        final int i2 = 0;
        super(eVar, view, i2, (ProgressBar)objectArr[1]);
        this.P = -1L;
        final Object obj2 = objectArr[i2];
        this.O = obj2;
        obj2.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ml
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ml
    public boolean O(int i, Object object) {
        return true;
    }
}
