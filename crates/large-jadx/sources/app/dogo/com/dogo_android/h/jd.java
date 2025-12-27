package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;

/* compiled from: FragmentGoodExampleNotAvailableBindingImpl.java */
/* loaded from: classes.dex */
public class jd extends id {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S = new SparseIntArray();
    private final ConstraintLayout P;
    private long Q;
    static {
        obj.put(2131363433, 1);
        obj.put(2131363421, 2);
        obj.put(2131362301, 3);
        obj.put(2131362342, 4);
        obj.put(2131362062, 5);
    }

    public jd(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, jd.R, jd.S));
    }

    @Override // app.dogo.com.dogo_android.h.id
    public void A() {
        synchronized (this) {
            try {
                this.Q = 1L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.id
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

    @Override // app.dogo.com.dogo_android.h.id
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

    private jd(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (FrameLayout)objectArr[5], (TextView)objectArr[3], (ImageView)objectArr[4], (TextView)objectArr[2], (MaterialToolbar)objectArr[1]);
        this.Q = -1L;
        Object obj6 = objectArr[0];
        this.P = obj6;
        obj6.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.id
    protected boolean E(int i, Object object, int i2) {
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.id
    public boolean O(int i, Object object) {
        return true;
    }
}
