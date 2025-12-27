package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: CellBlankScreenRowBindingImpl.java */
/* loaded from: classes.dex */
public class b0 extends a0 {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S;
    private final ConstraintLayout P;
    private long Q;
    public b0(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, b0.R, b0.S));
    }

    @Override // app.dogo.com.dogo_android.h.a0
    public void A() {
        synchronized (this) {
            try {
                this.Q = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.a0
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.Q = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.Q & 1L;
        if (l2 != l3) {
            String str = null;
            BindingAdapters.g0(this.O, str);
        }
    }

    @Override // app.dogo.com.dogo_android.h.a0
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

    private b0(e eVar, View view, Object[] objectArr) {
        final int i2 = 0;
        super(eVar, view, i2, (ImageView)objectArr[1]);
        this.Q = -1L;
        Object obj2 = null;
        this.O.setTag(obj2);
        Object obj3 = objectArr[i2];
        this.P = obj3;
        obj3.setTag(obj2);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.a0
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.a0
    public boolean O(int i, Object object) {
        return true;
    }
}
