package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: CellChallengeFilterListRowBindingImpl.java */
/* loaded from: classes.dex */
public class z0 extends y0 {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S = new SparseIntArray();
    private long Q;
    static {
        obj.put(2131363371, 1);
        obj.put(2131362640, 2);
    }

    public z0(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, z0.R, z0.S));
    }

    @Override // app.dogo.com.dogo_android.h.y0
    public void A() {
        synchronized (this) {
            try {
                this.Q = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.y0
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

    @Override // app.dogo.com.dogo_android.h.y0
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

    private z0(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ConstraintLayout)objectArr[0], (CardView)objectArr[2], (TextView)objectArr[1]);
        this.Q = -1L;
        this.O.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y0
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.y0
    public boolean O(int i, Object object) {
        return true;
    }
}
