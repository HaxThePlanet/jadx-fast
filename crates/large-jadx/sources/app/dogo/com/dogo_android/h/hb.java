package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.util.e0.y;

/* compiled from: FragmentDogCreationBreedBindingImpl.java */
/* loaded from: classes.dex */
public class hb extends gb {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout V;
    private long W;
    static {
        obj.put(2131363433, 2);
        obj.put(2131363436, 3);
        obj.put(2131363421, 4);
        obj.put(2131362081, 5);
    }

    public hb(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, hb.X, hb.Y));
    }

    private boolean X(x<DogBreed> xVar, int i) {
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

    private boolean Y(x<y<Boolean>> xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.gb
    public void A() {
        synchronized (this) {
            try {
                this.W = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.gb
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.gb
    public boolean O(int i, Object object) {
        int i2 = 139;
        boolean z = true;
        i2 = 139;
        if (139 == i) {
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

    @Override // app.dogo.com.dogo_android.h.gb
    public void V(g gVar) {
        this.U = gVar;
        synchronized (this) {
            try {
                this.W |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(139);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gb
    public void W(app.dogo.com.dogo_android.dogcreation.j.n nVar) {
        this.T = nVar;
        synchronized (this) {
            try {
                this.W |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.gb
    protected void m() {
        int cmp;
        Object value;
        long l = 0;
        app.dogo.com.dogo_android.repository.domain.DogProfile dogProfile;
        y yVar = null;
        Object obj;
        DogBreed dogBreed;
        synchronized (this) {
            try {
                l = 0L;
                this.W = l;
            } catch (Throwable th) {
            }
        }
        long l4 = 22L & l2;
        int i = 0;
        if (l4 != l) {
            if (this.U != null) {
                x xVar2 = this.U.k();
                dogProfile = this.U.l();
            } else {
            }
            int i2 = 1;
            Q(i2, obj);
            Object value2 = obj != null ? (DogBreed)value2 : i;
        } else {
        }
        long l3 = l2 & 25L;
        if (this.W != l) {
            if (this.T != null) {
                x xVar = this.T.l();
            } else {
            }
            Q(0, value);
            if (value != null) {
            }
        }
        if (this.W != l) {
            BindingAdapters.x0(this.V, yVar);
            BindingAdapters.Z(this.P, yVar);
        }
        if (l4 != l) {
            DogProfileBindingAdapters.G(this.V, dogBreed, dogProfile, this.Q, this.O);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gb
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

    private hb(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (TextView)objectArr[5], (Button)objectArr[1], (TextView)objectArr[4], (MaterialToolbar)objectArr[2], (TextView)objectArr[3]);
        this.W = -1L;
        Object obj6 = objectArr[0];
        this.V = obj6;
        final Object obj7 = null;
        obj6.setTag(obj7);
        this.P.setTag(obj7);
        N(view);
        A();
    }
}
