package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: CellSimpleTextBindingImpl.java */
/* loaded from: classes.dex */
public class b7 extends a7 {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S = new SparseIntArray();
    private final ConstraintLayout P;
    private long Q;
    static {
        obj.put(2131363364, 1);
    }

    public b7(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, b7.R, b7.S));
    }

    @Override // app.dogo.com.dogo_android.h.a7
    public void A() {
        synchronized (this) {
            try {
                this.Q = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.a7
    protected void m() {
        synchronized (this) {
            try {
                this.Q = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.a7
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Q != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private b7(e eVar, View view, Object[] objectArr) {
        final int i2 = 0;
        super(eVar, view, i2, (TextView)objectArr[1]);
        this.Q = -1L;
        final Object obj2 = objectArr[i2];
        this.P = obj2;
        obj2.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.a7
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.a7
    public boolean O(int i, Object object) {
        return true;
    }
}
