package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.q;

/* compiled from: DialogChallengeProfileBindingImpl.java */
/* loaded from: classes.dex */
public class p8 extends o8 {

    private static final ViewDataBinding.g S = new ViewDataBinding$g(3);
    private static final SparseIntArray T = new SparseIntArray();
    private final LinearLayout Q;
    private long R;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i5 = 0;
        iArr2[i5] = i3;
        int[] iArr = new int[i3];
        iArr[i5] = R.layout.layout_top_bar;
        obj.a(i5, new String[] { "layout_top_bar" }, iArr2, iArr);
        obj.put(2131362733, 2);
    }

    public p8(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, p8.S, p8.T));
    }

    private boolean V(cn cnVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.R |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.o8
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        this.P.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.o8
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.o8
    public void M(q qVar) {
        super.M(qVar);
        this.P.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.o8
    protected void m() {
        synchronized (this) {
            try {
                this.R = 0L;
            } catch (Throwable th) {
            }
        }
        ViewDataBinding.o(this.P);
    }

    @Override // app.dogo.com.dogo_android.h.o8
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.R != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.P.y()) {
            return true;
        }
        return false;
    }

    private p8(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (RecyclerView)objectArr[2], (cn)objectArr[1]);
        this.R = -1L;
        Object obj3 = objectArr[0];
        this.Q = obj3;
        obj3.setTag(null);
        L(this.P);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o8
    public boolean O(int i, Object object) {
        return true;
    }
}
