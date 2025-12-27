package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.dogcreation.j.i.b;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.p.u;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* compiled from: FragmentDogEditBreedBindingImpl.java */
/* loaded from: classes.dex */
public class dc extends cc {

    private static final ViewDataBinding.g Y = new ViewDataBinding$g(8);
    private static final SparseIntArray Z = new SparseIntArray();
    private final ConstraintLayout U;
    private final FrameLayout V;
    private final ok W;
    private long X;
    static {
        int i6 = 1;
        final int[] iArr2 = new int[i6];
        final int i14 = 0;
        iArr2[i14] = 3;
        int[] iArr = new int[i6];
        iArr[i14] = R.layout.layout_dog_creation_loading_spinner;
        obj.a(2, new String[] { "layout_dog_creation_loading_spinner" }, iArr2, iArr);
        obj.put(2131363433, 4);
        obj.put(2131363193, 5);
        obj.put(2131361858, 6);
        obj.put(2131362178, 7);
    }

    public dc(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, dc.Y, dc.Z));
    }

    private boolean X(x<y<List<DogBreed>>> xVar, int i) {
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

    private boolean Y(x<y<Boolean>> xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.cc
    public void A() {
        synchronized (this) {
            try {
                this.X = 16L;
            } catch (Throwable th) {
            }
        }
        this.W.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.cc
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.cc
    public void M(q qVar) {
        super.M(qVar);
        this.W.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.cc
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

    @Override // app.dogo.com.dogo_android.h.cc
    public void V(i.b bVar) {
        this.T = bVar;
        synchronized (this) {
            try {
                this.X |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cc
    public void W(u uVar) {
        this.S = uVar;
        synchronized (this) {
            try {
                this.X |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.cc
    protected void m() {
        Object obj;
        y yVar;
        Object obj2;
        int cmp2;
        y yVar2 = null;
        int i = 0;
        int cmp4 = 1;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.X = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 29L & l;
        long l5 = 31L & l;
        final long l6 = 26L;
        cmp2 = 0;
        if (l5 != l3) {
            if (l4 != l3) {
                if (this.S != null) {
                    x xVar2 = this.S.l();
                } else {
                }
                i = 0;
                Q(i, obj2);
                Object value2 = obj2 != null ? (LoadResult)value2 : cmp2;
            }
            long l7 = l & 26L;
            if (l7 != l3) {
                if (this.S != null) {
                    x xVar = this.S.m();
                } else {
                }
                cmp4 = 1;
                Q(cmp4, obj);
                if (this.S != null) {
                }
            }
        } else {
        }
        if (l4 != l3) {
            cmp4 = 2131558778;
            DogProfileBindingAdapters.s(this.P, yVar2, this.T, this.Q, cmp4);
        }
        long l2 = l & 26L;
        if (this.X != l3) {
            BindingAdapters.x0(this.U, yVar);
            BindingAdapters.setDebugJsonEntryItemAdapter(this.V, yVar);
        }
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.cc
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.X != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.W.y()) {
            return true;
        }
        return false;
    }

    private dc(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 2, (FrameLayout)objectArr[6], (RecyclerView)objectArr[1], (ImageView)objectArr[7], (EditText)objectArr[5], (MaterialToolbar)objectArr[4]);
        this.X = -1L;
        Object obj6 = null;
        this.P.setTag(obj6);
        Object obj7 = objectArr[0];
        this.U = obj7;
        obj7.setTag(obj6);
        Object obj8 = objectArr[2];
        this.V = obj8;
        obj8.setTag(obj6);
        Object obj9 = objectArr[3];
        this.W = obj9;
        L(obj9);
        N(view);
        A();
    }
}
