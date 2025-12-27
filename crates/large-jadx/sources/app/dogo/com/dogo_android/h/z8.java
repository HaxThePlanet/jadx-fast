package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.s.b.b;
import app.dogo.com.dogo_android.q.s.f;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* compiled from: DialogDogParentsBindingImpl.java */
/* loaded from: classes.dex */
public class z8 extends y8 implements b.a {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y = new SparseIntArray();
    private final ConstraintLayout U;
    private final View.OnClickListener V;
    private long W;
    static {
        obj.put(2131363421, 4);
        obj.put(2131362612, 5);
        obj.put(2131362610, 6);
        obj.put(2131362356, 7);
    }

    public z8(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 8, z8.X, z8.Y));
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

    private boolean Y(x<y<DogParentUIState>> xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.y8
    public void A() {
        synchronized (this) {
            try {
                this.W = 16L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.y8
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            return false;
        }
        return Y(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.y8
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

    @Override // app.dogo.com.dogo_android.h.y8
    public void V(b.b bVar) {
        this.T = bVar;
        synchronized (this) {
            try {
                this.W |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.y8
    public void W(f fVar) {
        this.S = fVar;
        synchronized (this) {
            try {
                this.W |= 8;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.y8
    public final void b(int i, View view) {
        int i2 = 1;
        view = this.S != null ? 1 : 0;
        if (i2 != 0) {
            this.S.createInvite();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y8
    protected void m() {
        int cmp;
        Object obj;
        Object obj2;
        int i;
        y yVar;
        y yVar2 = null;
        int i2 = 0;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.W = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 29L & l2;
        long l6 = 31L & l2;
        long l7 = 26L;
        i = 0;
        if (l6 != l4) {
            if (l5 != l4) {
                if (this.S != null) {
                    x xVar2 = this.S.l();
                } else {
                }
                i2 = 0;
                Q(i2, obj2);
                Object value2 = obj2 != null ? (LoadResult)value2 : i;
            }
            long l9 = l2 & 26L;
            if (l9 != l4) {
                if (this.S != null) {
                    x xVar = this.S.j();
                } else {
                }
                int cmp5 = 1;
                Q(cmp5, obj);
                if (this.S != null) {
                }
            }
        } else {
        }
        long l8 = 26L & l2;
        if (l8 != l4) {
            BindingAdapters.x0(this.O, yVar2);
            BindingAdapters.Z(this.O, yVar2);
        }
        l = 16L & l2;
        if (l != l4) {
            this.O.setOnClickListener(this.V);
        }
        long l3 = l2 & 25L;
        if (this.W != l4) {
            BindingAdapters.x0(this.U, yVar);
            BindingAdapters.y0(this.R, yVar);
        }
        if (l5 != l4) {
            DogProfileBindingAdapters.x(this.Q, yVar, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.y8
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

    private z8(e eVar, View view, Object[] objectArr) {
        int i6 = 1;
        super(eVar, view, 2, (Button)objectArr[3], (Button)objectArr[7], (ImageView)objectArr[6], (ImageView)objectArr[5], (RecyclerView)objectArr[2], (SwipeRefreshLayout)objectArr[i6], (TextView)objectArr[4]);
        this.W = -1L;
        Object obj8 = null;
        this.O.setTag(obj8);
        Object obj9 = objectArr[0];
        this.U = obj9;
        obj9.setTag(obj8);
        this.Q.setTag(obj8);
        this.R.setTag(obj8);
        N(view);
        this.V = new b(this, i6);
        A();
    }
}
