package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
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
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.q.r.d;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentUserInformationBindingImpl.java */
/* loaded from: classes.dex */
public class hh extends gh implements b.a {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z = new SparseIntArray();
    private final ConstraintLayout T;
    private final View.OnClickListener U;
    private androidx.databinding.g V;
    private androidx.databinding.g W;
    private long X;

    class a implements androidx.databinding.g {

        final /* synthetic */ hh a;
        a() {
            this.a = hhVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.S != null ? 1 : i;
            if (i != 0 && userInformation != null) {
                if (i != 0) {
                    userInformation.setValue(g.a(this.a.O));
                }
            }
        }
    }

    class b implements androidx.databinding.g {

        final /* synthetic */ hh a;
        b() {
            this.a = hhVar;
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
        obj.put(2131363433, 4);
        obj.put(2131362401, 5);
        obj.put(2131362860, 6);
        obj.put(2131362400, 7);
        obj.put(2131362385, 8);
    }

    public hh(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, hh.Y, hh.Z));
    }

    private boolean W(x<String> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 2;
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
                    this.X |= 4;
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
                    this.X |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.gh
    public void A() {
        synchronized (this) {
            try {
                this.X = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gh
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return X(object, i2);
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.gh
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

    @Override // app.dogo.com.dogo_android.h.gh
    public void V(d dVar) {
        this.S = dVar;
        synchronized (this) {
            try {
                this.X |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gh
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.S != null ? 1 : 0;
        if (i2 != 0) {
            this.S.m();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gh
    protected void m() {
        Object obj2;
        y yVar;
        Object obj4;
        int i2;
        java.lang.CharSequence charSequence;
        Object value;
        java.lang.CharSequence charSequence2;
        int cmp5 = 2;
        int cmp6;
        Object obj;
        int cmp7;
        final Object obj3 = this;
        synchronized (this) {
            try {
                final long l5 = 0L;
                obj3.X = l5;
            } catch (Throwable th) {
            }
        }
        long l6 = 31L & l3;
        int i3 = 0;
        final long l8 = 28L;
        long l = 25L;
        final long l11 = 26L;
        final androidx.databinding.k.g.c cVar = null;
        if (l6 != l5) {
            long l12 = l3 & 25L;
            if (l12 != l5) {
                if (obj3.S != null) {
                    x xVar2 = obj3.S.k();
                } else {
                    int i7 = cVar;
                }
                obj3.Q(i3, obj4);
                Object value3 = obj4 != null ? (String)value3 : cVar;
            }
            long l13 = l3 & 26L;
            if (l13 != l5) {
                if (obj3.S != null) {
                    x userInformation = obj3.S.saveUserInformation();
                } else {
                    int i12 = cVar;
                }
                obj3.Q(1, obj);
                value = obj != null ? (String)value : cVar;
            }
            l2 = l3 & 28L;
            if (l2 != l5) {
                if (obj3.S != null) {
                    x xVar = obj3.S.j();
                } else {
                    int i4 = cVar;
                }
                cmp5 = 2;
                obj3.Q(cmp5, obj2);
                Object value2 = obj3.S != null ? (LoadResult)value2 : cVar;
            }
        } else {
        }
        long l10 = l3 & 26L;
        if (l10 != l5) {
            g.c(obj3.O, charSequence2);
        }
        long l9 = 16L & l3;
        if (l9 != l5) {
            g.e(obj3.O, cVar, cVar, cVar, obj3.V);
            g.e(obj3.P, cVar, cVar, cVar, obj3.W);
            cmp6 = 6;
            app.dogo.com.dogo_android.util.binding.m.q(obj3.P, cmp6, i3);
            obj3.Q.setOnClickListener(obj3.U);
        }
        long l7 = l3 & 28L;
        if (obj3.Q != l5) {
            BindingAdapters.x0(obj3.T, yVar);
            BindingAdapters.Z(obj3.Q, yVar);
        }
        long l4 = l3 & 25L;
        if (obj3.X != l5) {
            g.c(obj3.P, charSequence);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gh
    public boolean y() {
        synchronized (this) {
            try {
                if (this.X != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private hh(e eVar, View view, Object[] objectArr) {
        final app.dogo.com.dogo_android.h.hh eVar3 = this;
        final int i11 = 1;
        super(eVar, view, 3, (TextInputEditText)objectArr[2], (TextView)objectArr[8], (TextInputLayout)objectArr[7], (TextInputLayout)objectArr[5], (TextInputEditText)objectArr[i11], (TextView)objectArr[6], (Button)objectArr[3], (MaterialToolbar)objectArr[4]);
        eVar3.V = new hh.a(this);
        eVar3.W = new hh.b(this);
        eVar3.X = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        Object obj9 = objectArr[0];
        eVar3.T = obj9;
        obj9.setTag(obj10);
        eVar3.P.setTag(obj10);
        eVar3.Q.setTag(obj10);
        N(view);
        eVar3.U = new b(this, i11);
        A();
    }
}
