package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.login_v2.b0;
import app.dogo.com.dogo_android.login_v2.c0;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentLoginProvidersBindingImpl.java */
/* loaded from: classes.dex */
public class he extends ge {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0 = new SparseIntArray();
    private final ConstraintLayout X;
    private long Y;
    static {
        obj.put(2131361912, 8);
    }

    public he(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 9, he.Z, he.a0));
    }

    private boolean X(x<Boolean> xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.ge
    public void A() {
        synchronized (this) {
            try {
                this.Y = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ge
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ge
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

    @Override // app.dogo.com.dogo_android.h.ge
    public void V(c0 c0Var) {
        this.W = c0Var;
        synchronized (this) {
            try {
                this.Y |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ge
    public void W(b0 b0Var) {
        this.V = b0Var;
        synchronized (this) {
            try {
                this.Y |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ge
    protected void m() {
        long l;
        Object value;
        int i2 = 8;
        Boolean bool = null;
        app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation dogOwnerInvitation = null;
        boolean z = false;
        int i;
        int i3;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l3 = 0L;
                obj.Y = l3;
            } catch (Throwable th) {
            }
        }
        final long l6 = 13L;
        long l7 = l & l6;
        final long l8 = 12L;
        i = 0;
        i2 = 0;
        if (l7 != l3) {
            long l9 = l & 12L;
            if (l9 != l3) {
                if (obj.V != null) {
                    app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation dogOwnerInvitation2 = obj.V.k();
                } else {
                }
                int r15 = i != 0 ? 1 : i2;
                if (l9 != l3) {
                    int r16 = i2 != 0 ? 32 : 16;
                    l = l | (i2 != 0 ? 32 : 16);
                }
                if (i2 != 0) {
                } else {
                    i2 = 8;
                }
            } else {
            }
            if (obj.V != null) {
                x xVar = obj.V.j();
            } else {
            }
            obj.Q(i2, value);
            if (obj.V != null) {
            }
            z = ViewDataBinding.K(bool);
        } else {
        }
        long l4 = l & 13L;
        if (obj.V != l3) {
            obj.O.setEnabled(z);
            obj.P.setEnabled(z);
            obj.Q.setEnabled(z);
            obj.R.setEnabled(z);
        }
        long l5 = l & 12L;
        if (obj.V != l3) {
            DogProfileBindingAdapters.u(obj.S, dogOwnerInvitation);
            obj.U.setVisibility(i2);
        }
        l &= 10;
        if (obj.Y != l3) {
            BindingAdapters.v0(obj.T, obj.W);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ge
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

    private he(e eVar, View view, Object[] objectArr) {
        final Object eVar3 = this;
        super(eVar, view, 1, (TextView)objectArr[8], (Button)objectArr[4], (Button)objectArr[3], (Button)objectArr[1], (Button)objectArr[2], (TextView)objectArr[6], (TextView)objectArr[7], (TextView)objectArr[5]);
        eVar3.Y = -1L;
        Object obj10 = null;
        eVar3.O.setTag(obj10);
        eVar3.P.setTag(obj10);
        eVar3.Q.setTag(obj10);
        eVar3.R.setTag(obj10);
        Object obj9 = objectArr[0];
        eVar3.X = obj9;
        obj9.setTag(obj10);
        eVar3.S.setTag(obj10);
        eVar3.T.setTag(obj10);
        eVar3.U.setTag(obj10);
        N(view);
        A();
    }
}
