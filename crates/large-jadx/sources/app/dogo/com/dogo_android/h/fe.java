package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentLoginEmailBindingImpl.java */
/* loaded from: classes.dex */
public class fe extends ee implements b.a {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0 = new SparseIntArray();
    private final ConstraintLayout V;
    private final View.OnClickListener W;
    private final View.OnClickListener X;
    private androidx.databinding.g Y;
    private androidx.databinding.g Z;
    private long a0;

    class a implements androidx.databinding.g {

        final /* synthetic */ fe a;
        a() {
            this.a = feVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.T != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(g.a(this.a.O));
                }
            }
        }
    }

    class b implements androidx.databinding.g {

        final /* synthetic */ fe a;
        b() {
            this.a = feVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.T != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(g.a(this.a.Q));
                }
            }
        }
    }
    static {
        obj.put(2131363414, 6);
    }

    public fe(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, fe.b0, fe.c0));
    }

    private boolean X(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ee
    public void A() {
        synchronized (this) {
            try {
                this.a0 = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ee
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ee
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

    @Override // app.dogo.com.dogo_android.h.ee
    public void V(c0 c0Var) {
        this.U = c0Var;
        synchronized (this) {
            try {
                this.a0 |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ee
    public void W(b0 b0Var) {
        this.T = b0Var;
        synchronized (this) {
            try {
                this.a0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ee
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.T != null) {
            }
            if (i2 != 0) {
                this.T.T();
            }
        } else {
            int i3 = 2;
            if (this.T == 2) {
                if (this.T != null) {
                }
                if (i2 != 0) {
                    this.T.R();
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ee
    protected void m() {
        int cmp;
        Object obj;
        java.lang.CharSequence charSequence;
        Object obj2;
        int i2;
        java.lang.CharSequence charSequence2;
        long l2 = 0;
        int cmp5 = 1;
        synchronized (this) {
            try {
                final long l5 = 0L;
                this.a0 = l5;
            } catch (Throwable th) {
            }
        }
        long l6 = 20L & l3;
        long l7 = 27L & l3;
        final long l8 = 26L;
        long l9 = 25L;
        final androidx.databinding.k.g.c cVar = null;
        if (l7 != l5) {
            l2 = l3 & 25L;
            if (l2 != l5) {
                if (this.T != null) {
                    x xVar2 = this.T.l();
                } else {
                    int i7 = cVar;
                }
                Q(0, obj2);
                Object value2 = obj2 != null ? (String)value2 : cVar;
            }
            long l11 = l3 & 26L;
            if (l11 != l5) {
                if (this.T != null) {
                    x xVar = this.T.o();
                } else {
                    int i3 = cVar;
                }
                cmp5 = 1;
                Q(cmp5, obj);
                Object value = this.T != null ? (String)value : cVar;
            }
        } else {
        }
        long l10 = 25L & l3;
        if (l10 != l5) {
            g.c(this.O, charSequence2);
        }
        l = 16L & l3;
        if (this.O != l5) {
            g.e(this.O, cVar, cVar, cVar, this.Y);
            this.P.setOnClickListener(this.X);
            g.e(this.Q, cVar, cVar, cVar, this.Z);
            this.R.setOnClickListener(this.W);
        }
        long l4 = l3 & 26L;
        if (this.a0 != l5) {
            g.c(this.Q, charSequence);
        }
        if (l6 != l5) {
            BindingAdapters.v0(this.S, this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ee
    public boolean y() {
        synchronized (this) {
            try {
                if (this.a0 != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private fe(e eVar, View view, Object[] objectArr) {
        final int i = 1;
        int i3 = 2;
        super(eVar, view, 2, (EditText)objectArr[i], (Button)objectArr[4], (EditText)objectArr[i3], (Button)objectArr[3], (TextView)objectArr[5], (TextView)objectArr[6]);
        this.Y = new fe.a(this);
        this.Z = new fe.b(this);
        this.a0 = -1L;
        Object obj7 = null;
        this.O.setTag(obj7);
        this.P.setTag(obj7);
        Object obj8 = objectArr[0];
        this.V = obj8;
        obj8.setTag(obj7);
        this.Q.setTag(obj7);
        this.R.setTag(obj7);
        this.S.setTag(obj7);
        N(view);
        this.W = new b(this, i);
        this.X = new b(this, i3);
        A();
    }
}
