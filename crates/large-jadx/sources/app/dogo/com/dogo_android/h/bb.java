package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.i.h0;

/* compiled from: FragmentDebugDataDialogBindingImpl.java */
/* loaded from: classes.dex */
public class bb extends ab {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131363433, 1);
        obj.put(2131362762, 2);
    }

    public bb(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, bb.S, bb.T));
    }

    @Override // app.dogo.com.dogo_android.h.ab
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ab
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ab
    protected void m() {
        synchronized (this) {
            try {
                this.R = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ab
    public boolean y() {
        synchronized (this) {
            try {
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private bb(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (LinearLayout)objectArr[2], (MaterialToolbar)objectArr[1]);
        this.R = -1L;
        Object obj3 = objectArr[0];
        this.Q = obj3;
        obj3.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ab
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ab
    public void V(h0 h0Var) {
    }
}
