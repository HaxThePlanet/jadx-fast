package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.NumberPicker;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: FragmentDogCreationGenderBindingImpl.java */
/* loaded from: classes.dex */
public class lb extends kb {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout U;
    private g V;
    private long W;

    class a implements g {

        final /* synthetic */ lb a;
        a() {
            this.a = lbVar;
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
        obj.put(2131363433, 3);
        obj.put(2131363436, 4);
        obj.put(2131363424, 5);
    }

    public lb(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, lb.X, lb.Y));
    }

    private boolean W(x<Integer> xVar, int i) {
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

    private boolean X(x<y<Boolean>> xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.kb
    public void A() {
        synchronized (this) {
            try {
                this.W = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.kb
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return W(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.kb
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

    @Override // app.dogo.com.dogo_android.h.kb
    public void V(app.dogo.com.dogo_android.dogcreation.k.f fVar) {
        this.T = fVar;
        synchronized (this) {
            try {
                this.W |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.kb
    protected void m() {
        Object obj;
        y yVar;
        Object obj2;
        Integer num;
        int cmp2;
        int i2 = 0;
        long l;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.W = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 15L & l2;
        final long l6 = 14L;
        int i = 1;
        final long l8 = 13L;
        i2 = 0;
        final android.widget.NumberPicker.OnValueChangeListener onValueChangeListener = null;
        if (l5 != l4) {
            long l9 = l2 & 13L;
            if (l9 != l4) {
                if (this.T != null) {
                    x xVar2 = this.T.l();
                } else {
                    int i6 = onValueChangeListener;
                }
                Q(0, obj2);
                Object value2 = obj2 != null ? (Integer)value2 : onValueChangeListener;
                i2 = ViewDataBinding.J(num);
            }
            l = l2 & 14L;
            if (l != l4) {
                if (this.T != null) {
                    x xVar = this.T.m();
                } else {
                    int i3 = onValueChangeListener;
                }
                Q(i, obj);
                Object value = this.T != null ? (LoadResult)value : onValueChangeListener;
            }
        }
        long l10 = 8L & l2;
        if (l10 != l4) {
            DogProfileBindingAdapters.setupDogProfileAvatar(this.O, true);
            f.a(this.O, onValueChangeListener, this.V);
        }
        long l7 = l2 & 13L;
        if (this.V != l4) {
            f.b(this.O, i2);
        }
        long l3 = l2 & 14L;
        if (this.W != l4) {
            BindingAdapters.x0(this.U, yVar);
            BindingAdapters.Z(this.P, yVar);
        }
    }

    @Override // app.dogo.com.dogo_android.h.kb
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

    private lb(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (NumberPicker)objectArr[1], (Button)objectArr[2], (TextView)objectArr[5], (MaterialToolbar)objectArr[3], (TextView)objectArr[4]);
        this.V = new lb.a(this);
        this.W = -1L;
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
