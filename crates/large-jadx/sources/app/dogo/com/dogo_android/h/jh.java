package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.u.m.t;
import app.dogo.com.dogo_android.y.l;

/* compiled from: FragmentVariationTipsScreenBindingImpl.java */
/* loaded from: classes.dex */
public class jh extends ih {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private long U;
    static {
        obj.put(2131363433, 2);
        obj.put(2131362322, 3);
        obj.put(2131362619, 4);
        obj.put(2131362954, 5);
        obj.put(2131363142, 6);
    }

    public jh(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, jh.V, jh.W));
    }

    @Override // app.dogo.com.dogo_android.h.ih
    public void A() {
        synchronized (this) {
            try {
                this.U = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ih
    public boolean O(int i, Object object) {
        boolean z = true;
        if (177 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.ih
    public void V(t tVar) {
        this.T = tVar;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ih
    protected void m() {
        java.util.List variationTips = null;
        long l = 0;
        int i;
        t tVar;
        synchronized (this) {
            try {
                l = 0L;
                this.U = l;
            } catch (Throwable th) {
            }
        }
        long l3 = this.U & 3L;
        if (l3 != l) {
            if (this.T != null) {
                l = this.T.h();
                TrickItem trickItem = this.T.i();
            } else {
            }
            if (this.T != 0) {
                variationTips = i.getVariationTips();
            }
        }
        if (l3 != l) {
            LibraryBindingAdapters.v(this.O, this.P, Long.valueOf(l));
            ProgramBindingAdapters.p0(this.Q, variationTips);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ih
    public boolean y() {
        synchronized (this) {
            try {
                if (this.U != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private jh(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ConstraintLayout)objectArr[0], (ImageView)objectArr[3], (ImageView)objectArr[4], (TextView)objectArr[5], (RecyclerView)objectArr[1], (MaterialButton)objectArr[6], (MaterialToolbar)objectArr[2]);
        this.U = -1L;
        Object obj8 = null;
        this.O.setTag(obj8);
        this.Q.setTag(obj8);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ih
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
