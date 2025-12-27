package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: CellProgramQuestionAnswerItemBindingImpl.java */
/* loaded from: classes.dex */
public class b6 extends a6 {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S = new SparseIntArray();
    private long Q;
    static {
        obj.put(2131361930, 1);
    }

    public b6(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, b6.R, b6.S));
    }

    @Override // app.dogo.com.dogo_android.h.a6
    public void A() {
        synchronized (this) {
            try {
                this.Q = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.a6
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

    @Override // app.dogo.com.dogo_android.h.a6
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

    private b6(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[1], (CardView)objectArr[0]);
        this.Q = -1L;
        this.P.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.a6
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.a6
    public boolean O(int i, Object object) {
        return true;
    }
}
