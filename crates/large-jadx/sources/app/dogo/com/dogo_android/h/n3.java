package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.GoodTrickExample;

/* compiled from: CellLoadingVideoBindingImpl.java */
/* loaded from: classes.dex */
public class n3 extends m3 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131362112, 1);
        obj.put(2131362964, 2);
    }

    public n3(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, n3.S, n3.T));
    }

    @Override // app.dogo.com.dogo_android.h.m3
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.m3
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            W(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.m3
    public void W(GoodTrickExample goodTrickExample) {
        this.P = goodTrickExample;
    }

    @Override // app.dogo.com.dogo_android.h.m3
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

    @Override // app.dogo.com.dogo_android.h.m3
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

    private n3(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (CardView)objectArr[1], (PlayerView)objectArr[2]);
        this.R = -1L;
        Object obj3 = objectArr[0];
        this.Q = obj3;
        obj3.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.m3
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
