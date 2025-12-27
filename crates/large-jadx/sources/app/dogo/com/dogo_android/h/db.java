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
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.i.l0;
import app.dogo.com.dogo_android.i.m0;
import app.dogo.com.dogo_android.i.n0.b;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* compiled from: FragmentDebugFeatureEnablerDialogBindingImpl.java */
/* loaded from: classes.dex */
public class db extends cb {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout R;
    private final RecyclerView S;
    private long T;
    static {
        obj.put(2131363433, 2);
    }

    public db(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, db.U, db.V));
    }

    private boolean X(LiveData<y<List<m0>>> liveData, int i) {
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

    @Override // app.dogo.com.dogo_android.h.cb
    public void A() {
        synchronized (this) {
            try {
                this.T = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.cb
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.cb
    public boolean O(int i, Object object) {
        int i2 = 177;
        boolean z = true;
        i2 = 177;
        if (177 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 28;
            if (28 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.cb
    public void V(n0.b bVar) {
        this.Q = bVar;
        synchronized (this) {
            try {
                this.T |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(28);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cb
    public void W(l0 l0Var) {
        this.P = l0Var;
        synchronized (this) {
            try {
                this.T |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cb
    protected void m() {
        y yVar = null;
        LiveData result;
        synchronized (this) {
            try {
                long l = 0L;
                this.T = l;
            } catch (Throwable th) {
            }
        }
        long l3 = this.T & 15L;
        if (l3 != l) {
            if (this.P != null) {
                result = this.P.getResult();
            } else {
            }
            int i2 = 0;
            Q(i2, result);
            if (result != null) {
                Object value = result.getValue();
            }
        }
        if (l3 != l) {
            BindingAdapters.getChangingRatingText(this.S, yVar, this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.cb
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

    private db(e eVar, View view, Object[] objectArr) {
        final int i2 = 1;
        super(eVar, view, i2, (MaterialToolbar)objectArr[2]);
        this.T = -1L;
        Object obj3 = objectArr[0];
        this.R = obj3;
        Object obj2 = null;
        obj3.setTag(obj2);
        Object obj4 = objectArr[i2];
        this.S = obj4;
        obj4.setTag(obj2);
        N(view);
        A();
    }
}
