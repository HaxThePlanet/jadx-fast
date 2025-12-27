package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.d.b.x;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: DialogChallengeCommentsBindingImpl.java */
/* loaded from: classes.dex */
public class f8 extends e8 {

    private static final ViewDataBinding.g T = new ViewDataBinding$g(4);
    private static final SparseIntArray U = new SparseIntArray();
    private final ConstraintLayout R;
    private long S;
    static {
        obj.a(0, new String[] { "layout_top_bar", "layout_comment_input" }, new int[] { 1, 2 }, new int[] { R.layout.layout_top_bar, R.layout.layout_comment_input });
        obj.put(2131363042, 3);
    }

    public f8(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, f8.T, f8.U));
    }

    private boolean X(ci ciVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.S |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(cn cnVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.S |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(x xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.e8
    public void A() {
        synchronized (this) {
            try {
                this.S = 16L;
            } catch (Throwable th) {
            }
        }
        this.Q.A();
        this.O.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.e8
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return X(object, i2);
        }
        return Z(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.e8
    public void M(q qVar) {
        super.M(qVar);
        this.Q.M(qVar);
        this.O.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.e8
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

    @Override // app.dogo.com.dogo_android.h.e8
    protected void m() {
        synchronized (this) {
            try {
                this.S = 0L;
            } catch (Throwable th) {
            }
        }
        ViewDataBinding.o(this.Q);
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.e8
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z3 = true;
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.Q.y()) {
            return true;
        }
        if (this.O.y()) {
            return true;
        }
        return false;
    }

    private f8(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 3, (ci)objectArr[2], (RecyclerView)objectArr[3], (cn)objectArr[1]);
        this.S = -1L;
        L(this.O);
        Object obj4 = objectArr[0];
        this.R = obj4;
        obj4.setTag(null);
        L(this.Q);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.e8
    public void V(a0 a0Var) {
    }

    @Override // app.dogo.com.dogo_android.h.e8
    public void W(x xVar) {
    }
}
