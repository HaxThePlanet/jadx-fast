package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: LayoutDogCreationLoadingSpinnerBindingImpl.java */
/* loaded from: classes.dex */
public class pk extends ok {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R = new SparseIntArray();
    private final ConstraintLayout O;
    private long P;
    static {
        obj.put(2131362537, 1);
        obj.put(2131363002, 2);
    }

    public pk(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, pk.Q, pk.R));
    }

    @Override // app.dogo.com.dogo_android.h.ok
    public void A() {
        synchronized (this) {
            try {
                this.P = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ok
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

    @Override // app.dogo.com.dogo_android.h.ok
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

    private pk(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (FrameLayout)objectArr[1], (ProgressBar)objectArr[2]);
        this.P = -1L;
        Object obj3 = objectArr[0];
        this.O = obj3;
        obj3.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ok
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ok
    public boolean O(int i, Object object) {
        return true;
    }
}
