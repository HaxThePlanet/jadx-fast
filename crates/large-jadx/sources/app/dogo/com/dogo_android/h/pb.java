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

/* compiled from: FragmentDogCreationLoginProvidersBindingImpl.java */
/* loaded from: classes.dex */
public class pb extends ob {

    private static final ViewDataBinding.g V = new ViewDataBinding$g(4);
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout T;
    private long U;
    static {
        int i4 = 1;
        final int[] iArr2 = new int[i4];
        final int i7 = 0;
        iArr2[i7] = i4;
        int[] iArr = new int[i4];
        iArr[i7] = R.layout.fragment_login_providers;
        obj.a(i7, new String[] { "fragment_login_providers" }, iArr2, iArr);
        obj.put(2131363433, 2);
        obj.put(2131363436, 3);
    }

    public pb(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, pb.V, pb.W));
    }

    private boolean X(ge geVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ob
    public void A() {
        synchronized (this) {
            try {
                this.U = 8L;
            } catch (Throwable th) {
            }
        }
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ob
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ob
    public void M(q qVar) {
        super.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ob
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

    @Override // app.dogo.com.dogo_android.h.ob
    public void V(c0 c0Var) {
        this.S = c0Var;
        synchronized (this) {
            try {
                this.U |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ob
    public void W(b0 b0Var) {
        this.R = b0Var;
        synchronized (this) {
            try {
                this.U |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ob
    protected void m() {
        int cmp;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 10L & l;
        long l2 = l & 12L;
        if (this.U != l3) {
            this.O.W(this.R);
        }
        if (l4 != l3) {
            this.O.V(this.S);
        }
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.ob
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.U != 0) {
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

    private pb(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (ge)objectArr[1], (MaterialToolbar)objectArr[2], (TextView)objectArr[3]);
        this.U = -1L;
        L(this.O);
        Object obj4 = objectArr[0];
        this.T = obj4;
        obj4.setTag(null);
        N(view);
        A();
    }
}
