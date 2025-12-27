package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: DialogVideoPlaybackBindingImpl.java */
/* loaded from: classes.dex */
public class x9 extends w9 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout R;
    private long S;
    static {
        obj.put(2131362105, 1);
        obj.put(2131362857, 2);
        obj.put(2131362747, 3);
    }

    public x9(androidx.databinding.e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, x9.T, x9.U));
    }

    private boolean X(app.dogo.com.dogo_android.y.q.e eVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.S |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.w9
    public void A() {
        synchronized (this) {
            try {
                this.S = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.w9
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.w9
    public boolean O(int i, Object object) {
        int i2 = 183;
        boolean z = true;
        i2 = 183;
        if (183 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 116;
            if (116 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.w9
    protected void m() {
        synchronized (this) {
            try {
                this.S = 0L;
                return;
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.w9
    public boolean y() {
        synchronized (this) {
            try {
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private x9(androidx.databinding.e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (ImageButton)objectArr[1], (ContentLoadingProgressBar)objectArr[3], (VideoView)objectArr[2]);
        this.S = -1L;
        Object obj4 = objectArr[0];
        this.R = obj4;
        obj4.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.w9
    public void V(a0 a0Var) {
    }

    @Override // app.dogo.com.dogo_android.h.w9
    public void W(app.dogo.com.dogo_android.y.q.e eVar) {
    }
}
