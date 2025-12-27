package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import app.dogo.com.dogo_android.a0.g.f.f0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: DialogChallengeFilterBindingImpl.java */
/* loaded from: classes.dex */
public class n8 extends m8 implements b.a {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0 = new SparseIntArray();
    private final FrameLayout U;
    private final TextView V;
    private final FrameLayout W;
    private final View.OnClickListener X;
    private androidx.databinding.g Y;
    private androidx.databinding.g Z;
    private long a0;

    class a implements androidx.databinding.g {

        final /* synthetic */ n8 a;
        a() {
            this.a = n8Var;
            super();
        }

        public void a() {
            int i = 1;
            int r2 = this.a.S != null ? 1 : 0;
            if (i != 0) {
                this.a.S.E(this.a.O.isChecked());
            }
        }
    }

    class b implements androidx.databinding.g {

        final /* synthetic */ n8 a;
        b() {
            this.a = n8Var;
            super();
        }

        public void a() {
            int i = 1;
            int r2 = this.a.S != null ? 1 : 0;
            if (i != 0) {
                this.a.S.D(this.a.P.isChecked());
            }
        }
    }
    static {
        obj.put(2131362701, 5);
        obj.put(2131362493, 6);
    }

    public n8(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, n8.b0, n8.c0));
    }

    private boolean X(f0 f0Var, int i) {
        boolean z = true;
        if (i == 0) {
            synchronized (this) {
                try {
                    this.a0 |= 1;
                    return true;
                } catch (Throwable unused) {
                }
                throw f0Var;
            }
        }
        if (i == 98) {
            synchronized (this) {
                try {
                    this.a0 |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        if (i == 69) {
            synchronized (this) {
                try {
                    this.a0 |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.m8
    public void A() {
        synchronized (this) {
            try {
                this.a0 = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.m8
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.m8
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

    @Override // app.dogo.com.dogo_android.h.m8
    public void V(a0 a0Var) {
        this.T = a0Var;
        synchronized (this) {
            try {
                this.a0 |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(116);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m8
    public void W(f0 f0Var) {
        R(0, f0Var);
        this.S = f0Var;
        synchronized (this) {
            try {
                this.a0 |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(183);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m8
    public final void b(int i, View view) {
        int i2 = 1;
        int r0 = this.S != null ? 1 : 0;
        if (i2 != 0) {
            this.S.B(this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.m8
    protected void m() {
        String formatted;
        int i;
        Object obj2;
        int i2;
        boolean z2;
        boolean z = false;
        Resources resources;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l5 = 0L;
                obj.a0 = l5;
            } catch (Throwable th) {
            }
        }
        long l6 = 29L & l3;
        long l7 = 25L;
        final long l12 = 21L;
        i2 = 0;
        final android.widget.CompoundButton.OnCheckedChangeListener onCheckedChangeListener = null;
        if (l6 != l5) {
            long l13 = l3 & 17L;
            if (l13 != l5) {
                if (obj.S != null) {
                    String str = obj.S.y(24);
                } else {
                    i = onCheckedChangeListener;
                }
                Object[] arr = new Object[1];
                formatted = String.format(obj.V.getResources().getString(2131886291), new Object[] { i });
            } else {
                int i5 = onCheckedChangeListener;
            }
            long l10 = l3 & 25L;
            if (l10 == l5 || obj.S == null) {
            } else {
                boolean featured = obj.S.isFeatured();
            }
            l2 = l3 & 21L;
            if (l2 != l5 && obj.S != null) {
                z = obj.S.z();
            }
        } else {
            int i6 = onCheckedChangeListener;
        }
        long l11 = l3 & 21L;
        if (l11 != l5) {
            a.a(obj.O, z);
        }
        l = 16L & l3;
        if (l != l5) {
            a.b(obj.O, onCheckedChangeListener, obj.Y);
            a.b(obj.P, onCheckedChangeListener, obj.Z);
            obj.W.setOnClickListener(obj.X);
        }
        long l8 = 25L & l3;
        if (l8 != l5) {
            a.a(obj.P, z2);
        }
        long l4 = l3 & 17L;
        if (obj.a0 != l5) {
            g.c(obj.V, obj2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.m8
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

    private n8(e eVar, View view, Object[] objectArr) {
        final int i = 1;
        super(eVar, view, 1, (AppCompatCheckBox)objectArr[i], (AppCompatCheckBox)objectArr[3], (RelativeLayout)objectArr[6], (RelativeLayout)objectArr[5]);
        this.Y = new n8.a(this);
        this.Z = new n8.b(this);
        this.a0 = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        this.P.setTag(obj5);
        Object obj6 = objectArr[0];
        this.U = obj6;
        obj6.setTag(obj5);
        Object obj7 = objectArr[2];
        this.V = obj7;
        obj7.setTag(obj5);
        Object obj8 = objectArr[4];
        this.W = obj8;
        obj8.setTag(obj5);
        N(view);
        this.X = new b(this, i);
        A();
    }
}
