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

/* compiled from: AlertDialogPermissionExplanationBindingImpl.java */
/* loaded from: classes.dex */
public class t extends s {

    private static final ViewDataBinding.g S;
    private static final SparseIntArray T;
    private final ConstraintLayout Q;
    private long R;
    public t(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, t.S, t.T));
    }

    @Override // app.dogo.com.dogo_android.h.s
    public void A() {
        synchronized (this) {
            try {
                this.R = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.s
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

    @Override // app.dogo.com.dogo_android.h.s
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

    @Override // app.dogo.com.dogo_android.h.s
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

    @Override // app.dogo.com.dogo_android.h.s
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

    private t(e eVar, View view, Object[] objectArr) {
        final int i2 = 0;
        super(eVar, view, i2, (RecyclerView)objectArr[1]);
        this.R = -1L;
        Object obj2 = objectArr[i2];
        this.Q = obj2;
        final Object obj3 = null;
        obj2.setTag(obj3);
        this.O.setTag(obj3);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.s
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
