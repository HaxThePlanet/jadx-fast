package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: CellProgramListHeaderBindingImpl.java */
/* loaded from: classes.dex */
public class n5 extends m5 {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R = new SparseIntArray();
    private long P;
    static {
        obj.put(2131362996, 1);
    }

    public n5(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, n5.Q, n5.R));
    }

    @Override // app.dogo.com.dogo_android.h.m5
    public void A() {
        synchronized (this) {
            try {
                this.P = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.m5
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

    @Override // app.dogo.com.dogo_android.h.m5
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

    private n5(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ConstraintLayout)objectArr[0], (TextView)objectArr[1]);
        this.P = -1L;
        this.O.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.m5
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.m5
    public boolean O(int i, Object object) {
        return true;
    }
}
