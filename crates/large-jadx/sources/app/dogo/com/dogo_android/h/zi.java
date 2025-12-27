package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: LayoutDashboardMetricTooltipBindingImpl.java */
/* loaded from: classes.dex */
public class zi extends yi {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131361924, 1);
        obj.put(2131361982, 2);
        obj.put(2131362829, 3);
        obj.put(2131362298, 4);
    }

    public zi(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, zi.S, zi.T));
    }

    @Override // app.dogo.com.dogo_android.h.yi
    public void A() {
        synchronized (this) {
            try {
                this.R = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.yi
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

    @Override // app.dogo.com.dogo_android.h.yi
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

    private zi(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (AppCompatImageView)objectArr[1], (FrameLayout)objectArr[2], (TextView)objectArr[4], (Button)objectArr[3]);
        this.R = -1L;
        Object obj5 = objectArr[0];
        this.Q = obj5;
        obj5.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yi
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.yi
    public boolean O(int i, Object object) {
        return true;
    }
}
