package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: FragmentMetricsIntroDailyTimeBindingImpl.java */
/* loaded from: classes.dex */
public class le extends ke {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131363433, 1);
        obj.put(2131362342, 2);
        obj.put(2131363414, 3);
        obj.put(2131362298, 4);
        obj.put(2131362888, 5);
    }

    public le(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, le.S, le.T));
    }

    @Override // app.dogo.com.dogo_android.h.ke
    public void A() {
        synchronized (this) {
            try {
                this.R = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ke
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

    @Override // app.dogo.com.dogo_android.h.ke
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

    private le(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[4], (AppCompatImageView)objectArr[2], (MaterialButton)objectArr[5], (TextView)objectArr[3], (MaterialToolbar)objectArr[1]);
        this.R = -1L;
        Object obj6 = objectArr[0];
        this.Q = obj6;
        obj6.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ke
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ke
    public boolean O(int i, Object object) {
        return true;
    }
}
