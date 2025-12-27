package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.i.o0.a;
import app.dogo.com.dogo_android.i.q0;
import app.dogo.com.dogo_android.i.s0;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* compiled from: DialogJsonArrayEditBindingImpl.java */
/* loaded from: classes.dex */
public class l9 extends k9 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131363172, 2);
    }

    public l9(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, l9.U, l9.V));
    }

    private boolean X(x<List<q0>> xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.k9
    public void A() {
        synchronized (this) {
            try {
                this.T = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.k9
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.k9
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

    @Override // app.dogo.com.dogo_android.h.k9
    public void V(o0.a aVar) {
        this.R = aVar;
        synchronized (this) {
            try {
                this.T |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.k9
    public void W(s0 s0Var) {
        this.Q = s0Var;
        synchronized (this) {
            try {
                this.T |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.k9
    protected void m() {
        List list = null;
        Object obj;
        synchronized (this) {
            try {
                long l = 0L;
                this.T = l;
            } catch (Throwable th) {
            }
        }
        long l3 = this.T & 15L;
        if (l3 != l) {
            if (this.Q != null) {
                x remoteConfig = this.Q.updateRemoteConfig();
            } else {
            }
            int i2 = 0;
            Q(i2, obj);
            if (obj != null) {
                Object value = obj.getValue();
            }
        }
        if (l3 != l) {
            BindingAdapters.animateRatingText(this.O, list, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k9
    public boolean y() {
        synchronized (this) {
            try {
                if (this.T != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private l9(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (RecyclerView)objectArr[1], (Button)objectArr[2]);
        this.T = -1L;
        Object obj3 = objectArr[0];
        this.S = obj3;
        final Object obj4 = null;
        obj3.setTag(obj4);
        this.O.setTag(obj4);
        N(view);
        A();
    }
}
