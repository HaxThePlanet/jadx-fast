package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: CellProgramQuestionItemBindingImpl.java */
/* loaded from: classes.dex */
public class d6 extends c6 {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S = new SparseIntArray();
    private final ConstraintLayout P;
    private long Q;
    static {
        obj.put(2131363016, 1);
        obj.put(2131363414, 2);
        obj.put(2131363012, 3);
    }

    public d6(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, d6.R, d6.S));
    }

    @Override // app.dogo.com.dogo_android.h.c6
    public void A() {
        synchronized (this) {
            try {
                this.Q = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.c6
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

    @Override // app.dogo.com.dogo_android.h.c6
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

    private d6(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[3], (ImageView)objectArr[1], (TextView)objectArr[2]);
        this.Q = -1L;
        Object obj4 = objectArr[0];
        this.P = obj4;
        obj4.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c6
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.c6
    public boolean O(int i, Object object) {
        return true;
    }
}
