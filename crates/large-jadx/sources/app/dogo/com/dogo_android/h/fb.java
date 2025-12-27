package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.databinding.k.c;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.dogcreation.i.f;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentDogCreationBirthdayBindingImpl.java */
/* loaded from: classes.dex */
public class fb extends eb {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0 = new SparseIntArray();
    private final ConstraintLayout U;
    private g V;
    private g W;
    private g X;
    private long Y;

    class a implements g {

        final /* synthetic */ fb a;
        a() {
            this.a = fbVar;
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

    class b implements g {

        final /* synthetic */ fb a;
        b() {
            this.a = fbVar;
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

    class c implements g {

        final /* synthetic */ fb a;
        c() {
            this.a = fbVar;
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
        obj.put(2131363433, 3);
        obj.put(2131363436, 4);
        obj.put(2131363414, 5);
    }

    public fb(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, fb.Z, fb.a0));
    }

    private boolean W(x<Integer> xVar, int i) {
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

    private boolean X(x<Integer> xVar, int i) {
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

    private boolean Y(x<y<Boolean>> xVar, int i) {
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

    private boolean Z(x<Integer> xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.eb
    public void A() {
        synchronized (this) {
            try {
                this.Y = 32L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.eb
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return X(object, i2);
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.eb
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

    @Override // app.dogo.com.dogo_android.h.eb
    public void V(f fVar) {
        this.T = fVar;
        synchronized (this) {
            try {
                this.Y |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.eb
    protected void m() {
        f fVar;
        Object obj2;
        int cmp3;
        Object obj4;
        Integer num;
        Integer num2;
        int i = 0;
        y yVar = null;
        Object obj5;
        Integer num3;
        int cmp4 = 1;
        Object obj;
        final Object obj3 = this;
        synchronized (this) {
            try {
                final long l4 = 0L;
                obj3.Y = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 63L & l2;
        final long l6 = 50L;
        long l7 = 61L;
        cmp3 = 0;
        i = 0;
        if (l5 != l4) {
            long l8 = l2 & 61L;
            if (l8 != l4) {
                if (obj3.T != null) {
                    x xVar2 = obj3.T.l();
                    x xVar3 = obj3.T.n();
                    x xVar4 = obj3.T.p();
                } else {
                }
                obj3.Q(cmp3, obj4);
                obj3.Q(2, obj5);
                obj3.Q(3, obj);
                Object value2 = obj4 != null ? (Integer)value2 : i;
                Object value3 = obj5 != null ? (Integer)value3 : i;
                Object value4 = obj != null ? (Integer)value4 : i;
                cmp3 = ViewDataBinding.J(num);
                cmp3 = ViewDataBinding.J(num2);
                cmp3 = ViewDataBinding.J(num3);
            } else {
            }
            long l9 = l2 & 50L;
            if (l9 != l4) {
                if (obj3.T != null) {
                    x xVar = obj3.T.o();
                } else {
                }
                cmp4 = 1;
                obj3.Q(cmp4, obj2);
                if (obj3.T != null) {
                }
            }
        } else {
        }
        l = 61L & l2;
        if (l != l4) {
            android.widget.DatePicker.OnDateChangedListener onDateChangedListener = null;
            c.a(obj3.O, cmp3, cmp3, cmp3, onDateChangedListener, gVar, gVar2, gVar3);
        }
        long l3 = l2 & 50L;
        if (obj3.Y != l4) {
            BindingAdapters.x0(obj3.U, yVar);
            BindingAdapters.Z(obj3.P, yVar);
        }
    }

    @Override // app.dogo.com.dogo_android.h.eb
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

    private fb(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 4, (DatePicker)objectArr[1], (Button)objectArr[2], (TextView)objectArr[5], (MaterialToolbar)objectArr[3], (TextView)objectArr[4]);
        this.V = new fb.a(this);
        this.W = new fb.b(this);
        this.X = new fb.c(this);
        this.Y = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        Object obj7 = objectArr[0];
        this.U = obj7;
        obj7.setTag(obj6);
        this.P.setTag(obj6);
        N(view);
        A();
    }
}
