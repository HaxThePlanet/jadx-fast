package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.d.c.h;

/* compiled from: FragmentChallengeNotificationCenterBindingImpl.java */
/* loaded from: classes.dex */
public class ja extends ia {

    private static final ViewDataBinding.g U = new ViewDataBinding$g(4);
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i7 = 0;
        iArr2[i7] = 2;
        int[] iArr = new int[i3];
        iArr[i7] = R.layout.layout_top_bar;
        obj.a(i7, new String[] { "layout_top_bar" }, iArr2, iArr);
        obj.put(2131363042, 3);
    }

    public ja(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, ja.U, ja.V));
    }

    private boolean W(cn cnVar, int i) {
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

    private boolean X(x<Boolean> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.T |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ia
    public void A() {
        synchronized (this) {
            try {
                this.T = 8L;
            } catch (Throwable th) {
            }
        }
        this.Q.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ia
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ia
    public void M(q qVar) {
        super.M(qVar);
        this.Q.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.ia
    public boolean O(int i, Object object) {
        boolean z = true;
        if (183 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ia
    public void V(h hVar) {
        this.R = hVar;
        synchronized (this) {
            try {
                this.T |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ia
    protected void m() {
        long l;
        Object value;
        int i = 0;
        Boolean bool = null;
        int i3 = 16;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        final long l4 = 14L;
        long l5 = l & l4;
        i = 0;
        if (l5 != l3) {
            if (this.R != null) {
                x xVar = this.R.l();
            } else {
            }
            int i4 = 1;
            Q(i4, value);
            if (this.R != null) {
            }
            boolean z = ViewDataBinding.K(bool);
            if (l5 != l3) {
                int r9 = z ? 32 : 16;
                l = l | (z ? 32 : 16);
            }
            if (!(z)) {
            }
        }
        l &= l4;
        if (this.T != l3) {
            this.O.setVisibility(i);
        }
        ViewDataBinding.o(this.Q);
    }

    @Override // app.dogo.com.dogo_android.h.ia
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
        if (this.Q.y()) {
            return true;
        }
        return false;
    }

    private ja(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (TextView)objectArr[1], (RecyclerView)objectArr[3], (cn)objectArr[2]);
        this.T = -1L;
        Object obj4 = objectArr[0];
        this.S = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.O.setTag(obj5);
        L(this.Q);
        N(view);
        A();
    }
}
