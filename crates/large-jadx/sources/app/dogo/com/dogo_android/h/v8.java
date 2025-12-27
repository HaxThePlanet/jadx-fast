package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.e.k.a;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;

/* compiled from: DialogClickerSelectBindingImpl.java */
/* loaded from: classes.dex */
public class v8 extends u8 implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final View.OnClickListener T;
    private long U;
    static {
        obj.put(2131363414, 3);
    }

    public v8(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 4, v8.V, v8.W));
    }

    @Override // app.dogo.com.dogo_android.h.u8
    public void A() {
        synchronized (this) {
            try {
                this.U = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.u8
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

    @Override // app.dogo.com.dogo_android.h.u8
    public void V(k.a aVar) {
        this.S = aVar;
        synchronized (this) {
            try {
                this.U |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.u8
    public void W(app.dogo.com.dogo_android.e.n nVar) {
        this.R = nVar;
        synchronized (this) {
            try {
                this.U |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.u8
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.R != null ? 1 : 0;
        if (i2 != 0) {
            this.R.dismissDialog();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u8
    protected void m() {
        int cmp;
        View.OnClickListener onClickListener;
        int i = 0;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.U = l3;
            } catch (Throwable th) {
            }
        }
        i = 0;
        long l4 = 7L & l;
        if (l4 != l3 && this.R != null) {
            i = this.R.j();
        }
        long l2 = l & 4L;
        if (this.U != l3) {
            this.O.setOnClickListener(this.T);
        }
        if (l4 != l3) {
            BindingAdapters.s0(this.Q, Integer.valueOf(i), this.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.u8
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

    private v8(e eVar, View view, Object[] objectArr) {
        int i3 = 1;
        super(eVar, view, 0, (Button)objectArr[2], (ConstraintLayout)objectArr[0], (RecyclerView)objectArr[i3], (TextView)objectArr[3]);
        this.U = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        this.P.setTag(obj5);
        this.Q.setTag(obj5);
        N(view);
        this.T = new b(this, i3);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u8
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
