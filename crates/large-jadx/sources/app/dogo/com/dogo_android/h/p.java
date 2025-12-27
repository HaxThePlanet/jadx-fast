package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: ActivityWebviewBindingImpl.java */
/* loaded from: classes.dex */
public class p extends o {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V = new SparseIntArray();
    private final ConstraintLayout S;
    private long T;
    static {
        obj.put(2131362232, 3);
    }

    public p(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, p.U, p.V));
    }

    @Override // app.dogo.com.dogo_android.h.o
    public void A() {
        synchronized (this) {
            try {
                this.T = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.o
    public boolean O(int i, Object object) {
        int i2 = 161;
        boolean z = true;
        i2 = 161;
        if (161 == i) {
            U(object);
            int i3 = 1;
        } else {
            i2 = 79;
            if (79 == i) {
                T(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.o
    public void T(String str) {
        this.R = str;
        synchronized (this) {
            try {
                this.T |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(79);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.o
    public void U(String str) {
        this.Q = str;
        synchronized (this) {
            try {
                this.T |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(161);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.o
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.T = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 5L & l;
        long l2 = l & 6L;
        if (l4 != l3) {
            this.O.setTitle(this.Q);
        }
        if (this.T != l3) {
            BindingAdapters.l(this.P, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.o
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

    private p(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (ConstraintLayout)objectArr[3], (MaterialToolbar)objectArr[1], (WebView)objectArr[2]);
        this.T = -1L;
        Object obj4 = objectArr[0];
        this.S = obj4;
        final Object obj5 = null;
        obj4.setTag(obj5);
        this.O.setTag(obj5);
        this.P.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.o
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
