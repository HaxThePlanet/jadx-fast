package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.f;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.p.b0;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentDogEditGenderBindingImpl.java */
/* loaded from: classes.dex */
public class fc extends ec {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout U;
    private androidx.databinding.g V;
    private long W;

    class a implements androidx.databinding.g {

        final /* synthetic */ fc a;
        a() {
            this.a = fcVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.T != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(Integer.valueOf(this.a.O.getValue()));
                }
            }
        }
    }
    static {
        obj.put(2131363433, 4);
    }

    public fc(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, fc.X, fc.Y));
    }

    private boolean X(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.W |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean Y(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.W |= 2;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ec
    public void A() {
        synchronized (this) {
            try {
                this.W = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ec
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ec
    public boolean O(int i, Object object) {
        int i2 = 161;
        boolean z = true;
        i2 = 161;
        if (161 == i) {
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

    @Override // app.dogo.com.dogo_android.h.ec
    public void V(String str) {
        this.S = str;
        synchronized (this) {
            try {
                this.W |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(161);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ec
    public void W(b0 b0Var) {
        this.T = b0Var;
        synchronized (this) {
            try {
                this.W |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ec
    protected void m() {
        int cmp;
        Object obj2;
        y yVar;
        Object obj3;
        Integer num;
        int cmp2;
        int i2 = 0;
        long l;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj.W = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 20L & l2;
        long l6 = 27L & l2;
        final long l7 = 26L;
        int i = 1;
        final long l9 = 25L;
        i2 = 0;
        final android.widget.NumberPicker.OnValueChangeListener onValueChangeListener = null;
        if (l6 != l4) {
            long l10 = l2 & 25L;
            if (l10 != l4) {
                if (obj.T != null) {
                    x xVar2 = obj.T.m();
                } else {
                    int i7 = onValueChangeListener;
                }
                obj.Q(0, obj3);
                Object value2 = obj3 != null ? (Integer)value2 : onValueChangeListener;
                i2 = ViewDataBinding.J(num);
            }
            l = l2 & 26L;
            if (l != l4) {
                if (obj.T != null) {
                    x xVar = obj.T.n();
                } else {
                    int i3 = onValueChangeListener;
                }
                obj.Q(i, obj2);
                Object value = obj.T != null ? (LoadResult)value : onValueChangeListener;
            }
        }
        long l11 = l2 & 16L;
        if (l11 != l4) {
            DogProfileBindingAdapters.setupDogProfileAvatar(obj.O, true);
            f.a(obj.O, onValueChangeListener, obj.V);
        }
        long l8 = l2 & 25L;
        if (obj.V != l4) {
            f.b(obj.O, i2);
        }
        long l3 = l2 & 26L;
        if (obj.W != l4) {
            BindingAdapters.x0(obj.U, yVar);
            BindingAdapters.Z(obj.P, yVar);
        }
        if (l5 != l4) {
            g.c(obj.Q, obj.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ec
    public boolean y() {
        synchronized (this) {
            try {
                if (this.W != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private fc(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (NumberPicker)objectArr[2], (Button)objectArr[3], (TextView)objectArr[1], (MaterialToolbar)objectArr[4]);
        this.V = new fc.a(this);
        this.W = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        Object obj6 = objectArr[0];
        this.U = obj6;
        obj6.setTag(obj5);
        this.P.setTag(obj5);
        this.Q.setTag(obj5);
        N(view);
        A();
    }
}
