package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.c;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.q.p.r;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentDogEditBirthdayBindingImpl.java */
/* loaded from: classes.dex */
public class bc extends ac {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0 = new SparseIntArray();
    private final ConstraintLayout U;
    private androidx.databinding.g V;
    private androidx.databinding.g W;
    private androidx.databinding.g X;
    private long Y;

    class a implements androidx.databinding.g {

        final /* synthetic */ bc a;
        a() {
            this.a = bcVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.T != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(Integer.valueOf(this.a.O.getDayOfMonth()));
                }
            }
        }
    }

    class b implements androidx.databinding.g {

        final /* synthetic */ bc a;
        b() {
            this.a = bcVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.T != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(Integer.valueOf(this.a.O.getMonth()));
                }
            }
        }
    }

    class c implements androidx.databinding.g {

        final /* synthetic */ bc a;
        c() {
            this.a = bcVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.T != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(Integer.valueOf(this.a.O.getYear()));
                }
            }
        }
    }
    static {
        obj.put(2131363433, 4);
    }

    public bc(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, bc.Z, bc.a0));
    }

    private boolean X(x<Integer> xVar, int i) {
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

    private boolean Y(x<Integer> xVar, int i) {
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

    private boolean Z(x<y<Boolean>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Y |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.Y |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.ac
    public void A() {
        synchronized (this) {
            try {
                this.Y = 64L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ac
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return Z(object, i2);
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ac
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

    @Override // app.dogo.com.dogo_android.h.ac
    public void V(String str) {
        this.S = str;
        synchronized (this) {
            try {
                this.Y |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(161);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ac
    public void W(r rVar) {
        this.T = rVar;
        synchronized (this) {
            try {
                this.Y |= 32;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ac
    protected void m() {
        int cmp;
        r rVar;
        Object obj2 = null;
        int cmp3;
        Object obj3 = null;
        Integer num = null;
        Integer num2 = null;
        Object obj4 = null;
        Integer num3 = null;
        y yVar = null;
        int cmp4 = 2;
        Object obj5 = null;
        x xVar;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l5 = 0L;
                obj.Y = l5;
            } catch (Throwable th) {
            }
        }
        long l6 = 80L & l3;
        long l7 = 111L & l3;
        final long l8 = 100L;
        long l9 = 107L;
        cmp3 = 0;
        if (l7 != l5) {
            l2 = l3 & 107L;
            if (l2 != l5) {
                if (obj.T != null) {
                    x xVar3 = obj.T.m();
                    x xVar4 = obj.T.o();
                } else {
                    int i4 = 0;
                    int i9 = 0;
                    int i12 = 0;
                }
                obj.Q(cmp3, obj3);
                obj.Q(1, obj5);
                obj.Q(3, obj4);
                Object value2 = obj3 != null ? (Integer)value2 : 0;
                Object value3 = obj5 != null ? (Integer)value3 : 0;
                Object value4 = obj4 != null ? (Integer)value4 : 0;
                cmp3 = ViewDataBinding.J(num);
                cmp3 = ViewDataBinding.J(num2);
                cmp3 = ViewDataBinding.J(num3);
            } else {
            }
            long l10 = l3 & 100L;
            if (l10 != l5) {
                if (obj.T != null) {
                    x xVar2 = obj.T.p();
                } else {
                    int i = 0;
                }
                cmp4 = 2;
                obj.Q(cmp4, obj2);
                if (obj.T != null) {
                } else {
                    int i11 = 0;
                }
            }
        } else {
        }
        l = 107L & l3;
        if (l != l5) {
            android.widget.DatePicker.OnDateChangedListener onDateChangedListener = null;
            c.a(obj.O, cmp3, cmp3, cmp3, onDateChangedListener, gVar, gVar2, gVar3);
        }
        long l4 = l3 & 100L;
        if (obj.Y != l5) {
            BindingAdapters.x0(obj.U, yVar);
            BindingAdapters.Z(obj.P, yVar);
        }
        if (l6 != l5) {
            g.c(obj.Q, obj.S);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ac
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

    private bc(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 4, (DatePicker)objectArr[2], (Button)objectArr[3], (TextView)objectArr[1], (MaterialToolbar)objectArr[4]);
        this.V = new bc.a(this);
        this.W = new bc.b(this);
        this.X = new bc.c(this);
        this.Y = -1L;
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
