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
import app.dogo.com.dogo_android.repository.domain.CertificateInfo;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.n.j;

/* compiled from: FragmentCertificateDetailStateBindingImpl.java */
/* loaded from: classes.dex */
public class fa extends ea {

    private static final ViewDataBinding.g R;
    private static final SparseIntArray S = new SparseIntArray();
    private final ConstraintLayout P;
    private long Q;
    static {
        obj.put(2131363001, 1);
    }

    public fa(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 2, fa.R, fa.S));
    }

    private boolean U(LiveData<y<CertificateInfo>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Q |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ea
    public void A() {
        synchronized (this) {
            try {
                this.Q = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ea
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return U(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ea
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            T(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ea
    public void T(j jVar) {
        this.O = jVar;
        synchronized (this) {
            try {
                this.Q |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ea
    protected void m() {
        y yVar = null;
        LiveData result;
        synchronized (this) {
            try {
                long l = 0L;
                this.Q = l;
            } catch (Throwable th) {
            }
        }
        long l3 = this.Q & 7L;
        if (l3 != l) {
            if (this.O != null) {
                result = this.O.getResult();
            } else {
            }
            int i2 = 0;
            Q(i2, result);
            if (result != null) {
                Object value = result.getValue();
            }
        }
        if (l3 != l) {
            BindingAdapters.setDebugJsonEntryItemAdapter(this.P, yVar);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ea
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Q != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private fa(e eVar, View view, Object[] objectArr) {
        int i = 1;
        super(eVar, view, i, (ContentLoadingProgressBar)objectArr[i]);
        this.Q = -1L;
        Object obj2 = objectArr[0];
        this.P = obj2;
        obj2.setTag(null);
        N(view);
        A();
    }
}
