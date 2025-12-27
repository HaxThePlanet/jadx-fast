package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.exam.f;

/* compiled from: ActivityExamFlowBindingImpl.java */
/* loaded from: classes.dex */
public class f extends e {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R;
    private long P;
    public f(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 1, f.Q, f.R));
    }

    @Override // app.dogo.com.dogo_android.h.e
    public void A() {
        synchronized (this) {
            try {
                this.P = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.e
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.e
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

    @Override // app.dogo.com.dogo_android.h.e
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

    private f(e eVar, View view, Object[] objectArr) {
        int i = 0;
        super(eVar, view, i, (FrameLayout)objectArr[i]);
        this.P = -1L;
        this.O.setTag(null);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.e
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.e
    public void T(f fVar) {
    }
}
