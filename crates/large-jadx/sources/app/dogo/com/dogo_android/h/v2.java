package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: CellIterableMailboxBindingImpl.java */
/* loaded from: classes.dex */
public class v2 extends u2 {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R = new SparseIntArray();
    private final ConstraintLayout O;
    private long P;
    static {
        obj.put(2131362634, 1);
        obj.put(2131363509, 2);
        obj.put(2131363414, 3);
        obj.put(2131363315, 4);
        obj.put(2131362276, 5);
        obj.put(2131362327, 6);
    }

    public v2(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, v2.Q, v2.R));
    }

    @Override // app.dogo.com.dogo_android.h.u2
    public void A() {
        synchronized (this) {
            try {
                this.P = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.u2
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

    @Override // app.dogo.com.dogo_android.h.u2
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

    private v2(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[5], (Barrier)objectArr[6], (ImageView)objectArr[1], (TextView)objectArr[4], (TextView)objectArr[3], (ImageView)objectArr[2]);
        this.P = -1L;
        Object obj7 = objectArr[0];
        this.O = obj7;
        obj7.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u2
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.u2
    public boolean O(int i, Object object) {
        return true;
    }
}
