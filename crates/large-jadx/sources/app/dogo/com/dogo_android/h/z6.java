package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: CellSimpleButtonBindingImpl.java */
/* loaded from: classes.dex */
public class z6 extends y6 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131362088, 1);
        obj.put(2131362692, 2);
    }

    public z6(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, z6.S, z6.T));
    }

    @Override // app.dogo.com.dogo_android.h.y6
    public void A() {
        synchronized (this) {
            try {
                this.R = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.y6
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

    @Override // app.dogo.com.dogo_android.h.y6
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

    private z6(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (Button)objectArr[1], (TextView)objectArr[2]);
        this.R = -1L;
        Object obj3 = objectArr[0];
        this.Q = obj3;
        obj3.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y6
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.y6
    public boolean O(int i, Object object) {
        return true;
    }
}
