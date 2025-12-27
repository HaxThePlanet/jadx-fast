package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.profile.invitation.g;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: ActivityInviteAcceptBindingImpl.java */
/* loaded from: classes.dex */
public class h extends g {

    private static final ViewDataBinding.g T = new ViewDataBinding$g(5);
    private static final SparseIntArray U = new SparseIntArray();
    private final ml R;
    private long S;
    static {
        int i4 = 1;
        final int[] iArr = new int[i4];
        final int i8 = 0;
        iArr[i8] = 2;
        int[] iArr2 = new int[i4];
        iArr2[i8] = R.layout.layout_loading_spinner;
        obj.a(i4, new String[] { "layout_loading_spinner" }, iArr, iArr2);
        obj.put(2131362533, 3);
        obj.put(2131363244, 4);
    }

    public h(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, h.T, h.U));
    }

    private boolean T(LiveData<y<DogOwnerInvitation>> liveData, int i) {
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

    @Override // app.dogo.com.dogo_android.h.g
    public void A() {
        synchronized (this) {
            try {
                this.S = 4L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.g
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return T(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.g
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.g
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            U(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.g
    public void U(g gVar) {
        this.Q = gVar;
        synchronized (this) {
            try {
                this.S |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.g
    protected void m() {
        y yVar = null;
        LiveData result;
        synchronized (this) {
            try {
                long l = 0L;
                this.S = l;
            } catch (Throwable th) {
            }
        }
        long l3 = this.S & 7L;
        if (l3 != l) {
            if (this.Q != null) {
                result = this.Q.getResult();
            } else {
            }
            int i2 = 0;
            Q(i2, result);
            if (result != null) {
                Object value = result.getValue();
            }
        }
        if (l3 != l) {
            BindingAdapters.x0(this.O, yVar);
            BindingAdapters.setDebugJsonEntryItemAdapter(this.P, yVar);
        }
        ViewDataBinding.o(this.R);
    }

    @Override // app.dogo.com.dogo_android.h.g
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.R.y()) {
            return true;
        }
        return false;
    }

    private h(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (ConstraintLayout)objectArr[0], (FrameLayout)objectArr[3], (FrameLayout)objectArr[1], (CoordinatorLayout)objectArr[4]);
        this.S = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        Object obj6 = objectArr[2];
        this.R = obj6;
        L(obj6);
        this.P.setTag(obj5);
        N(view);
        A();
    }
}
