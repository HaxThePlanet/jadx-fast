package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.q.p.e0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentDogEditNameBindingImpl.java */
/* loaded from: classes.dex */
public class hc extends gc {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = new SparseIntArray();
    private final ConstraintLayout S;
    private androidx.databinding.g T;
    private long U;

    class a implements androidx.databinding.g {

        final /* synthetic */ hc a;
        a() {
            this.a = hcVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.R != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(g.a(this.a.O));
                }
            }
        }
    }
    static {
        obj.put(2131363433, 3);
        obj.put(2131363414, 4);
    }

    public hc(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, hc.V, hc.W));
    }

    private boolean W(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean X(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.U |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.gc
    public void A() {
        synchronized (this) {
            try {
                this.U = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gc
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.gc
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

    @Override // app.dogo.com.dogo_android.h.gc
    public void V(e0 e0Var) {
        this.R = e0Var;
        synchronized (this) {
            try {
                this.U |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gc
    protected void m() {
        Object obj;
        y yVar;
        Object obj2;
        int i2;
        java.lang.CharSequence charSequence;
        long l2 = 0;
        int cmp5 = 1;
        synchronized (this) {
            try {
                final long l5 = 0L;
                this.U = l5;
            } catch (Throwable th) {
            }
        }
        long l6 = 15L & l3;
        final long l7 = 14L;
        long l8 = 13L;
        final androidx.databinding.k.g.c cVar = null;
        if (l6 != l5) {
            l2 = l3 & 13L;
            if (l2 != l5) {
                if (this.R != null) {
                    x xVar2 = this.R.m();
                } else {
                    int i6 = cVar;
                }
                Q(0, obj2);
                Object value2 = obj2 != null ? (String)value2 : cVar;
            }
            long l10 = l3 & 14L;
            if (l10 != l5) {
                if (this.R != null) {
                    x xVar = this.R.n();
                } else {
                    int i3 = cVar;
                }
                cmp5 = 1;
                Q(cmp5, obj);
                Object value = this.R != null ? (LoadResult)value : cVar;
            }
        } else {
        }
        long l9 = 13L & l3;
        if (l9 != l5) {
            g.c(this.O, charSequence);
        }
        l = 8L & l3;
        if (this.O != l5) {
            g.e(this.O, cVar, cVar, cVar, this.T);
        }
        long l4 = l3 & 14L;
        if (this.U != l5) {
            BindingAdapters.x0(this.S, yVar);
            BindingAdapters.Z(this.P, yVar);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gc
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

    private hc(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (EditText)objectArr[1], (Button)objectArr[2], (TextView)objectArr[4], (MaterialToolbar)objectArr[3]);
        this.T = new hc.a(this);
        this.U = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        Object obj6 = objectArr[0];
        this.S = obj6;
        obj6.setTag(obj5);
        this.P.setTag(obj5);
        N(view);
        A();
    }
}
