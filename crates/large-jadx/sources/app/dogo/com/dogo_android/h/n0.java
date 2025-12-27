package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.d.b.z.n;

/* compiled from: CellChallengeCommentsTitleBindingImpl.java */
/* loaded from: classes.dex */
public class n0 extends m0 {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final RelativeLayout P;
    private final TextView Q;
    private long R;
    public n0(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, n0.S, n0.T));
    }

    private boolean W(n nVar, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.R |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw nVar;
            }
        }
        if (i == 43) {
            synchronized (this) {
                try {
                    this.R |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.m0
    public void A() {
        synchronized (this) {
            try {
                this.R = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.m0
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.m0
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

    @Override // app.dogo.com.dogo_android.h.m0
    public void V(n nVar) {
        R(0, nVar);
        this.O = nVar;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m0
    protected void m() {
        int i;
        Object obj = null;
        synchronized (this) {
            try {
                long l = 0L;
                this.R = l;
            } catch (Throwable th) {
            }
        }
        int i3 = 0;
        long l2 = 7L;
        long l4 = this.R & l2;
        if (l4 != l) {
            i = 0;
            if (this.O != null) {
                i = this.O.a();
            } else {
            }
            int i2 = 1;
            Object[] arr2 = new Object[i2];
            arr2[i] = Integer.valueOf(i);
            int i4 = 2131755009;
            this.Q.getResources().getQuantityString(i4, i, arr2);
            Object[] arr = new Object[i2];
            arr[i] = Integer.valueOf(i);
            String quantityString = this.Q.getResources().getQuantityString(i4, i, arr);
        }
        if (l4 != l) {
            g.c(this.Q, obj);
        }
    }

    @Override // app.dogo.com.dogo_android.h.m0
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

    private n0(e eVar, View view, Object[] objectArr) {
        final int i = 1;
        super(eVar, view, i);
        this.R = -1L;
        Object obj2 = objectArr[0];
        this.P = obj2;
        Object obj = null;
        obj2.setTag(obj);
        Object obj3 = objectArr[i];
        this.Q = obj3;
        obj3.setTag(obj);
        N(view);
        A();
    }

}
