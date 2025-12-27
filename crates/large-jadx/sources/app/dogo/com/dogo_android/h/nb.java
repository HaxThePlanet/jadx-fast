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
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;

/* compiled from: FragmentDogCreationLoginBindingImpl.java */
/* loaded from: classes.dex */
public class nb extends mb {

    private static final ViewDataBinding.g U = new ViewDataBinding$g(3);
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i5 = 0;
        iArr2[i5] = i3;
        int[] iArr = new int[i3];
        iArr[i5] = R.layout.fragment_login_email;
        obj.a(i5, new String[] { "fragment_login_email" }, iArr2, iArr);
        obj.put(2131363433, 2);
    }

    public nb(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, nb.U, nb.V));
    }

    private boolean X(ee eeVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.mb
    public void A() {
        synchronized (this) {
            try {
                this.T = 8L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.mb
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.mb
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.mb
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            V(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                W(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.mb
    public void V(c0 c0Var) {
        this.R = c0Var;
        synchronized (this) {
            try {
                this.T |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mb
    public void W(b0 b0Var) {
        this.Q = b0Var;
        synchronized (this) {
            try {
                this.T |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mb
    protected void m() {
        int cmp;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 10L & l;
        long l2 = l & 12L;
        if (this.T != l3) {
            this.O.W(this.Q);
        }
        if (l4 != l3) {
            this.O.V(this.R);
        }
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.mb
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.O.y()) {
            return true;
        }
        return false;
    }

    private nb(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (ee)objectArr[1], (MaterialToolbar)objectArr[2]);
        this.T = -1L;
        L(this.O);
        Object obj3 = objectArr[0];
        this.S = obj3;
        obj3.setTag(null);
        N(view);
        A();
    }
}
