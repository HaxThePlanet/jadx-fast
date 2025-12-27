package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.repository.domain.PermissionDescription;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* compiled from: AlertDialogPermissionMissingBindingImpl.java */
/* loaded from: classes.dex */
public class v extends u {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T = new SparseIntArray();
    private final ConstraintLayout Q;
    private long R;
    static {
        obj.put(2131363374, 2);
    }

    public v(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, v.S, v.T));
    }

    @Override // app.dogo.com.dogo_android.h.u
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.u
    public boolean O(int i, Object object) {
        boolean z = true;
        if (95 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.u
    public void V(List<PermissionDescription> list) {
        this.P = list;
        synchronized (this) {
            try {
                this.R |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(95);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.u
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
            BindingAdapters.I(this.O, this.P);
        }
    }

    @Override // app.dogo.com.dogo_android.h.u
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

    private v(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (RecyclerView)objectArr[1], (TextView)objectArr[2]);
        this.R = -1L;
        Object obj3 = objectArr[0];
        this.Q = obj3;
        final Object obj4 = null;
        obj3.setTag(obj4);
        this.O.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
