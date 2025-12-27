package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.i;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.a0.g.f.e0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: DialogChallengeEntryCreationBindingImpl.java */
/* loaded from: classes.dex */
public class j8 extends i8 implements b.a {

    private static final ViewDataBinding.g b0 = new ViewDataBinding$g(7);
    private static final SparseIntArray c0 = new SparseIntArray();
    private final LinearLayout V;
    private final TextView W;
    private final View.OnClickListener X;
    private final View.OnClickListener Y;
    private androidx.databinding.g Z;
    private long a0;

    class a implements androidx.databinding.g {

        final /* synthetic */ j8 a;
        a() {
            this.a = j8Var;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.T != null ? 1 : i;
            if (i != 0 && e0Var.entryId != null) {
                if (i != 0) {
                    e0Var.entryId.e(g.a(this.a.P));
                }
            }
        }
    }
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i7 = 0;
        iArr2[i7] = 5;
        int[] iArr = new int[i3];
        iArr[i7] = R.layout.layout_top_bar;
        obj.a(i7, new String[] { "layout_top_bar" }, iArr2, iArr);
        obj.put(2131362108, 6);
    }

    public j8(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, j8.b0, j8.c0));
    }

    private boolean X(cn cnVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(e0 e0Var, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 2;
                    return true;
                } catch (Throwable unused) {
                }
                throw e0Var;
            }
        }
        if (i == 85) {
            synchronized (this) {
                try {
                    this.a0 |= 16;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 63) {
            synchronized (this) {
                try {
                    this.a0 |= 32;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Z(i<String> iVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.i8
    public void A() {
        synchronized (this) {
            try {
                this.a0 = 64L;
            } catch (Throwable th) {
            }
        }
        this.R.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.i8
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2) {
                return false;
            }
            return X(object, i2);
        }
        return Z(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public void M(q qVar) {
        super.M(qVar);
        this.R.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public boolean O(int i, Object object) {
        int i2 = 183;
        boolean z = true;
        i2 = 183;
        if (183 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 116;
            if (116 == i) {
                V(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public void V(a0 a0Var) {
        this.U = a0Var;
        synchronized (this) {
            try {
                this.a0 |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(116);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public void W(e0 e0Var) {
        R(1, e0Var);
        this.T = e0Var;
        synchronized (this) {
            try {
                this.a0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public final void b(int i, View view) {
        int i2 = 0;
        i2 = 0;
        i2 = 1;
        if (i == i2) {
            if (this.T != null) {
            }
            if (i2 != 0) {
                this.T.onTermsClick(this.U);
            }
        } else {
            if (this.T == 2) {
                if (this.T != null) {
                }
                if (i2 != 0) {
                    this.T.openPolicyAcceptWindow(this.U);
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.i8
    protected void m() {
        Object obj;
        java.lang.CharSequence charSequence;
        int i2;
        String str2;
        int i3;
        String str3;
        int cmp5 = 0;
        final Object obj3 = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj3.a0 = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 115L & l2;
        final long l6 = 98L;
        long l7 = 82L;
        long l9 = 67L;
        final androidx.databinding.k.g.c cVar = null;
        if (l5 != l4) {
            long l11 = l2 & 82L;
            if (l11 == l4 || obj3.T == null) {
                i2 = cVar;
            } else {
                String str = obj3.T.C();
            }
            long l12 = l2 & 98L;
            if (l12 == l4 || obj3.T == null) {
                i3 = cVar;
            } else {
                String dogAvatar = obj3.T.getDogAvatar();
            }
            long l13 = l2 & 67L;
            if (l13 != l4) {
                Throwable th = obj3.T != null ? e0Var.entryId : cVar;
                cmp5 = 0;
                obj3.R(0, th);
                Object obj2 = th != null ? (String)obj2 : cVar;
            }
        } else {
        }
        long l10 = 67L & l2;
        if (l10 != l4) {
            g.c(obj3.P, charSequence);
        }
        l = 64L & l2;
        if (obj3.P != l4) {
            g.e(obj3.P, cVar, cVar, cVar, obj3.Z);
            obj3.Q.setOnClickListener(obj3.X);
            obj3.W.setOnClickListener(obj3.Y);
        }
        long l8 = 82L & l2;
        if (l8 != l4) {
            BindingAdapters.y(obj3.Q, str2);
        }
        long l3 = l2 & 98L;
        if (obj3.a0 != l4) {
            app.dogo.com.dogo_android.util.binding.m.o(obj3.S, str3);
        }
        ViewDataBinding.o(obj3.R);
    }

    @Override // app.dogo.com.dogo_android.h.i8
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.a0 != 0) {
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

    private j8(e eVar, View view, Object[] objectArr) {
        int i3 = 1;
        final int i7 = 2;
        super(eVar, view, 3, (FrameLayout)objectArr[6], (EditText)objectArr[3], (ImageView)objectArr[i3], (cn)objectArr[5], (ImageView)objectArr[i7]);
        this.Z = new j8.a(this);
        this.a0 = -1L;
        Object obj6 = null;
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        Object obj7 = objectArr[0];
        this.V = obj7;
        obj7.setTag(obj6);
        Object obj8 = objectArr[4];
        this.W = obj8;
        obj8.setTag(obj6);
        L(this.R);
        this.S.setTag(obj6);
        N(view);
        this.X = new b(this, i3);
        this.Y = new b(this, i7);
        A();
    }
}
