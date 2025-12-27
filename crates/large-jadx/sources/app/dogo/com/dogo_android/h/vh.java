package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.u.h;

/* compiled from: LayoutBitingProgramProgressBindingImpl.java */
/* loaded from: classes.dex */
public class vh extends uh {

    private static final ViewDataBinding.g S = new ViewDataBinding$g(3);
    private static final SparseIntArray T = new SparseIntArray();
    private final wh P;
    private final ConstraintLayout Q;
    private long R;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i5 = 0;
        iArr2[i5] = i3;
        int[] iArr = new int[i3];
        iArr[i5] = R.layout.layout_biting_program_progress_display;
        obj.a(i5, new String[] { "layout_biting_program_progress_display" }, iArr2, iArr);
        obj.put(2131363414, 2);
    }

    public vh(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, vh.S, vh.T));
    }

    @Override // app.dogo.com.dogo_android.h.uh
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

    @Override // app.dogo.com.dogo_android.h.uh
    public void M(q qVar) {
        super.M(qVar);
        this.P.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.uh
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.uh
    public void V(h hVar) {
        this.O = hVar;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.uh
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.R = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.R & 3L;
        if (l2 != l3) {
            this.P.T(this.O);
        }
        ViewDataBinding.o(this.P);
    }

    @Override // app.dogo.com.dogo_android.h.uh
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

    private vh(e eVar, View view, Object[] objectArr) {
        final int i2 = 0;
        super(eVar, view, i2, (TextView)objectArr[2]);
        this.R = -1L;
        Object obj2 = objectArr[1];
        this.P = obj2;
        L(obj2);
        Object obj3 = objectArr[i2];
        this.Q = obj3;
        obj3.setTag(null);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.uh
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
