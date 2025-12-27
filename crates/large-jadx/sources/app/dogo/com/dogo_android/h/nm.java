package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.y.d0.n.a;
import java.util.List;

/* compiled from: LayoutProgramTrainingPlanBindingImpl.java */
/* loaded from: classes.dex */
public class nm extends mm {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U = new SparseIntArray();
    private final CardView R;
    private long S;
    static {
        obj.put(2131363414, 2);
        obj.put(2131362379, 3);
        obj.put(2131362298, 4);
    }

    public nm(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, nm.T, nm.U));
    }

    @Override // app.dogo.com.dogo_android.h.mm
    public void A() {
        synchronized (this) {
            try {
                this.S = 4L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.mm
    public boolean O(int i, Object object) {
        int i2 = 29;
        boolean z = true;
        i2 = 29;
        if (29 == i) {
            T(object);
            int i3 = 1;
        } else {
            i2 = 103;
            if (103 == i) {
                U(object);
            } else {
                int i4 = 0;
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.mm
    public void T(n.a aVar) {
        this.P = aVar;
        synchronized (this) {
            try {
                this.S |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mm
    public void U(List<TrickItem> list) {
        this.Q = list;
        synchronized (this) {
            try {
                this.S |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(103);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.mm
    protected void m() {
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.S = l3;
            } catch (Throwable th) {
            }
        }
        long l2 = this.S & 7L;
        if (l2 != l3) {
            TrainingBindingAdapters.x(this.O, this.Q, this.P);
        }
    }

    @Override // app.dogo.com.dogo_android.h.mm
    public boolean y() {
        synchronized (this) {
            try {
                if (this.S != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private nm(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (TextView)objectArr[4], (TextView)objectArr[3], (RecyclerView)objectArr[1], (TextView)objectArr[2]);
        this.S = -1L;
        Object obj5 = null;
        this.O.setTag(obj5);
        Object obj6 = objectArr[0];
        this.R = obj6;
        obj6.setTag(obj5);
        N(view);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.mm
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
