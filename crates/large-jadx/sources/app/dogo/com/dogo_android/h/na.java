package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: FragmentClickerHelpBindingImpl.java */
/* loaded from: classes.dex */
public class na extends ma {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S = new SparseIntArray();
    private long Q;
    static {
        obj.put(2131363433, 1);
        obj.put(2131363371, 2);
    }

    public na(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, na.R, na.S));
    }

    @Override // app.dogo.com.dogo_android.h.ma
    public void A() {
        synchronized (this) {
            try {
                this.Q = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ma
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

    @Override // app.dogo.com.dogo_android.h.ma
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

    private na(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ConstraintLayout)objectArr[0], (TextView)objectArr[2], (MaterialToolbar)objectArr[1]);
        this.Q = -1L;
        this.O.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ma
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ma
    public boolean O(int i, Object object) {
        return true;
    }
}
