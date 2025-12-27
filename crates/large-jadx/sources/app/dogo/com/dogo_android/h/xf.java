package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.recyclerview.widget.RecyclerView;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.a0.e.c;
import app.dogo.com.dogo_android.y.a0.h;
import app.dogo.com.dogo_android.y.l;

/* compiled from: FragmentProgramQuestionBindingImpl.java */
/* loaded from: classes.dex */
public class xf extends wf {

    private static final ViewDataBinding.g W = new ViewDataBinding$g(5);
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout R;
    private final RecyclerView S;
    private final FrameLayout T;
    private final ml U;
    private long V;
    static {
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i8 = 0;
        iArr2[i8] = 3;
        int[] iArr = new int[i3];
        iArr[i8] = R.layout.layout_loading_spinner;
        obj.a(2, new String[] { "layout_loading_spinner" }, iArr2, iArr);
        obj.put(2131363433, 4);
    }

    public xf(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 5, xf.W, xf.X));
    }

    private boolean X(f.d.a.a<y<Boolean>> aVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.wf
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        this.U.A();
        I();
    }

    @Override // app.dogo.com.dogo_android.h.wf
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.wf
    public void M(q qVar) {
        super.M(qVar);
        this.U.M(qVar);
    }

    @Override // app.dogo.com.dogo_android.h.wf
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

    @Override // app.dogo.com.dogo_android.h.wf
    public void V(e.c cVar) {
        this.Q = cVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wf
    public void W(h hVar) {
        this.P = hVar;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.wf
    protected void m() {
        Object obj;
        int i;
        y yVar;
        app.dogo.com.dogo_android.repository.domain.ProgramQuestion programQuestion = null;
        long l = 0;
        synchronized (this) {
            try {
                final long l4 = 0L;
                this.V = l4;
            } catch (Throwable th) {
            }
        }
        long l5 = 14L & l2;
        long l6 = 15L & l2;
        final long l7 = 13L;
        i = 0;
        if (l6 != l4) {
            l = l2 & 13L;
            if (l != l4) {
                if (this.P != null) {
                    f.d.a.a aVar = this.P.n();
                } else {
                }
                Q(0, obj);
                Object value = obj != null ? (LoadResult)value : i;
            }
            if (l5 != l4 && this.P != null) {
                programQuestion = this.P.l();
            }
        } else {
        }
        if (l5 != l4) {
            ProgramBindingAdapters.g0(this.S, programQuestion, this.Q);
        }
        long l3 = l2 & 13L;
        if (this.V != l4) {
            BindingAdapters.setDebugJsonEntryItemAdapter(this.T, yVar);
        }
        ViewDataBinding.o(this.U);
    }

    @Override // app.dogo.com.dogo_android.h.wf
    public boolean y() {
        synchronized (this) {
            try {
                final boolean z2 = true;
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
        }
        if (this.U.y()) {
            return true;
        }
        return false;
    }

    private xf(e eVar, View view, Object[] objectArr) {
        final int i2 = 1;
        super(eVar, view, i2, (MaterialToolbar)objectArr[4]);
        this.V = -1L;
        Object obj3 = objectArr[0];
        this.R = obj3;
        Object obj2 = null;
        obj3.setTag(obj2);
        Object obj4 = objectArr[i2];
        this.S = obj4;
        obj4.setTag(obj2);
        Object obj5 = objectArr[2];
        this.T = obj5;
        obj5.setTag(obj2);
        Object obj6 = objectArr[3];
        this.U = obj6;
        L(obj6);
        N(view);
        A();
    }
}
