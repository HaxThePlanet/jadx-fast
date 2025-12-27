package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* compiled from: LayoutTopBarV2BindingImpl.java */
/* loaded from: classes.dex */
public class fn extends en {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private long S;
    static {
        obj.put(2131361978, 2);
        obj.put(2131361979, 3);
    }

    public fn(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, fn.T, fn.U));
    }

    @Override // app.dogo.com.dogo_android.h.en
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.en
    public boolean O(int i, Object object) {
        boolean z = true;
        if (155 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.en
    public void T(String str) {
        this.R = str;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(155);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.en
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.S & 3L;
        if (l2 != l3) {
            g.c(this.Q, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.en
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

    private fn(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (FrameLayout)objectArr[2], (AppCompatImageView)objectArr[3], (ConstraintLayout)objectArr[0], (TextView)objectArr[1]);
        this.S = -1L;
        Object obj5 = null;
        this.P.setTag(obj5);
        this.Q.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.en
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
