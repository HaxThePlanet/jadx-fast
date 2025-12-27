package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: ActivityCustomInboxBindingImpl.java */
/* loaded from: classes.dex */
public class b extends a {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S = new SparseIntArray();
    private final ConstraintLayout P;
    private long Q;
    static {
        obj.put(2131363433, 1);
        obj.put(2131362533, 2);
    }

    public b(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, b.R, b.S));
    }

    @Override // app.dogo.com.dogo_android.h.a
    public void A() {
        synchronized (this) {
            try {
                this.Q = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.a
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

    @Override // app.dogo.com.dogo_android.h.a
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

    private b(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (FrameLayout)objectArr[2], (MaterialToolbar)objectArr[1]);
        this.Q = -1L;
        Object obj3 = objectArr[0];
        this.P = obj3;
        obj3.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.a
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.a
    public boolean O(int i, Object object) {
        return true;
    }
}
