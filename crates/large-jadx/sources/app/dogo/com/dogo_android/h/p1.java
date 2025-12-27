package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: CellDogLogDividerBindingImpl.java */
/* loaded from: classes.dex */
public class p1 extends o1 {

    private static final ViewDataBinding.g Q;
    private static final SparseIntArray R = new SparseIntArray();
    private final ConstraintLayout O;
    private long P;
    static {
        obj.put(2131362511, 1);
        obj.put(2131362335, 2);
        obj.put(2131363202, 3);
    }

    public p1(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, p1.Q, p1.R));
    }

    @Override // app.dogo.com.dogo_android.h.o1
    public void A() {
        synchronized (this) {
            try {
                this.P = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.o1
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

    @Override // app.dogo.com.dogo_android.h.o1
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

    private p1(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[2], (ImageView)objectArr[1], (ImageView)objectArr[3]);
        this.P = -1L;
        Object obj4 = objectArr[0];
        this.O = obj4;
        obj4.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o1
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.o1
    public boolean O(int i, Object object) {
        return true;
    }
}
