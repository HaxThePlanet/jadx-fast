package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
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

/* compiled from: FragmentLoginRegistrationBindingImpl.java */
/* loaded from: classes.dex */
public class je extends ie implements b.a {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0 = new SparseIntArray();
    private final CoordinatorLayout U;
    private final View.OnClickListener V;
    private androidx.databinding.g W;
    private androidx.databinding.g X;
    private long Y;

    class a implements androidx.databinding.g {

        final /* synthetic */ je a;
        a() {
            this.a = jeVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.S != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(g.a(this.a.O));
                }
            }
        }
    }

    class b implements androidx.databinding.g {

        final /* synthetic */ je a;
        b() {
            this.a = jeVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.S != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(g.a(this.a.P));
                }
            }
        }
    }
    static {
        obj.put(2131363414, 5);
    }

    public je(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, je.Z, je.a0));
    }

    private boolean X(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Y |= 1;
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
                    this.Y |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ie
    public void A() {
        synchronized (this) {
            try {
                this.Y = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ie
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ie
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

    @Override // app.dogo.com.dogo_android.h.ie
    public void V(c0 c0Var) {
        this.T = c0Var;
        synchronized (this) {
            try {
                this.Y |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ie
    public void W(b0 b0Var) {
        this.S = b0Var;
        synchronized (this) {
            try {
                this.Y |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ie
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.S != null ? 1 : 0;
        if (i2 != 0) {
            this.S.U();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ie
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
                this.Y = l5;
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
                if (this.S != null) {
                    x xVar2 = this.S.l();
                } else {
                    int i7 = cVar;
                }
                Q(0, obj2);
                Object value2 = obj2 != null ? (String)value2 : cVar;
            }
            long l11 = l3 & 26L;
            if (l11 != l5) {
                if (this.S != null) {
                    x xVar = this.S.o();
                } else {
                    int i3 = cVar;
                }
                cmp5 = 1;
                Q(cmp5, obj);
                Object value = this.S != null ? (String)value : cVar;
            }
        } else {
        }
        long l10 = 25L & l3;
        if (l10 != l5) {
            g.c(this.O, charSequence2);
        }
        l = 16L & l3;
        if (this.O != l5) {
            g.e(this.O, cVar, cVar, cVar, this.W);
            g.e(this.P, cVar, cVar, cVar, this.X);
            this.Q.setOnClickListener(this.V);
        }
        long l4 = l3 & 26L;
        if (this.Y != l5) {
            g.c(this.P, charSequence);
        }
        if (l6 != l5) {
            BindingAdapters.v0(this.R, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ie
    public boolean y() {
        synchronized (this) {
            try {
                if (this.Y != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private je(e eVar, View view, Object[] objectArr) {
        final int i = 1;
        super(eVar, view, 2, (EditText)objectArr[i], (EditText)objectArr[2], (Button)objectArr[3], (TextView)objectArr[4], (TextView)objectArr[5]);
        this.W = new je.a(this);
        this.X = new je.b(this);
        this.Y = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        Object obj7 = objectArr[0];
        this.U = obj7;
        obj7.setTag(obj6);
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        this.R.setTag(obj6);
        N(view);
        this.V = new b(this, i);
        A();
    }
}
