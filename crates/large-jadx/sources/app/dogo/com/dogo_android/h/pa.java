package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.n.m.u.k;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.z.d;

/* compiled from: FragmentClickerIntroductionDetailsBindingImpl.java */
/* loaded from: classes.dex */
public class pa extends oa {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final TextView U;
    private long V;
    static {
        obj.put(2131363480, 3);
        obj.put(2131363441, 4);
        obj.put(2131363331, 5);
        obj.put(2131362120, 6);
    }

    public pa(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 7, pa.W, pa.X));
    }

    private boolean V(x<y<TrickItem>> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.V |= 1;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.oa
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.oa
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return V(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.oa
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            W(object);
            int i3 = 1;
        } else {
            i2 = 177;
            if (177 == i) {
                X(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.oa
    public void W(k kVar) {
        this.T = kVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.oa
    public void X(d dVar) {
        this.S = dVar;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.oa
    protected void m() {
        int cmp;
        Object obj = null;
        Object obj2;
        y yVar;
        app.dogo.com.dogo_android.util.c0 c0Var;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 15L & l;
        final long l5 = 13L;
        int i = 0;
        if (l4 != l3) {
            if (this.S != null) {
                x xVar = this.S.h();
                c0Var = this.S.j();
            } else {
            }
            Q(0, obj2);
            Object value = obj2 != null ? (LoadResult)value : i;
            long l6 = l & 13L;
            if (l6 != l3 && this.S != null) {
                String str = this.S.i(yVar);
            }
        } else {
        }
        long l2 = l & 13L;
        if (this.V != l3) {
            g.c(this.U, obj);
        }
        if (l4 != l3) {
            TrainingBindingAdapters.t(this.R, yVar, this.P, c0Var, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.oa
    public boolean y() {
        synchronized (this) {
            try {
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private pa(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (Guideline)objectArr[6], (ConstraintLayout)objectArr[0], (TabLayout)objectArr[5], (MaterialToolbar)objectArr[4], (ConstraintLayout)objectArr[3], (ViewPager2)objectArr[2]);
        this.V = -1L;
        Object obj7 = null;
        this.O.setTag(obj7);
        Object obj8 = objectArr[1];
        this.U = obj8;
        obj8.setTag(obj7);
        this.R.setTag(obj7);
        N(view);
        A();
    }
}
