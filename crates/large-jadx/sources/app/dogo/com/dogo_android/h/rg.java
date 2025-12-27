package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;

/* compiled from: FragmentSpecialProgramDescriptionBindingImpl.java */
/* loaded from: classes.dex */
public class rg extends qg {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private long S;
    static {
        obj.put(2131363433, 2);
    }

    public rg(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 3, rg.T, rg.U));
    }

    @Override // app.dogo.com.dogo_android.h.qg
    public void A() {
        synchronized (this) {
            try {
                this.S = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.qg
    public boolean O(int i, Object object) {
        boolean z = true;
        if (51 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.qg
    public void V(String str) {
        this.R = str;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(51);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.qg
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.S & 3L;
        if (l2 != l3) {
            g.c(this.P, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qg
    public boolean y() {
        synchronized (this) {
            try {
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private rg(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ConstraintLayout)objectArr[0], (TextView)objectArr[1], (MaterialToolbar)objectArr[2]);
        this.S = -1L;
        Object obj4 = null;
        this.O.setTag(obj4);
        this.P.setTag(obj4);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.qg
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
