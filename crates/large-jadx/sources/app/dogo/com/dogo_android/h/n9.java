package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.t.h0.i.a;
import app.dogo.com.dogo_android.t.h0.l;
import app.dogo.com.dogo_android.util.e0.y;

/* compiled from: DialogLanguageSelectBindingImpl.java */
/* loaded from: classes.dex */
public class n9 extends m9 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private long V;
    static {
        obj.put(2131363414, 4);
        obj.put(2131362356, 5);
    }

    public n9(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, n9.W, n9.X));
    }

    private boolean X(x<y<app.dogo.com.dogo_android.t.h0.n>> xVar, int i) {
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

    @Override // app.dogo.com.dogo_android.h.m9
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.m9
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.m9
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

    @Override // app.dogo.com.dogo_android.h.m9
    public void V(i.a aVar) {
        this.U = aVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m9
    public void W(l lVar) {
        this.T = lVar;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.m9
    protected void m() {
        int cmp;
        Object obj;
        int i;
        java.util.List list2;
        y yVar = null;
        String str2;
        synchronized (this) {
            try {
                final long l3 = 0L;
                this.V = l3;
            } catch (Throwable th) {
            }
        }
        long l4 = 14L & l;
        long l5 = 15L & l;
        final long l6 = 13L;
        i = 0;
        if (l5 != l3) {
            if (l4 == l3 || this.T == null) {
            } else {
                java.util.List list = this.T.r();
                String str = this.T.p();
            }
            long l7 = l & 13L;
            if (l7 != l3) {
                if (this.T != null) {
                    x xVar = this.T.s();
                } else {
                }
                int cmp2 = 0;
                Q(cmp2, obj);
                if (this.T != null) {
                }
            }
        } else {
        }
        long l2 = l & 13L;
        if (this.V != l3) {
            BindingAdapters.z0(this.O, yVar);
            BindingAdapters.z0(this.R, yVar);
        }
        if (l4 != l3) {
            BindingAdapters.Y(this.S, list2, this.U, str2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.m9
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

    private n9(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (FrameLayout)objectArr[2], (Button)objectArr[5], (ConstraintLayout)objectArr[0], (ProgressBar)objectArr[3], (RecyclerView)objectArr[1], (TextView)objectArr[4]);
        this.V = -1L;
        Object obj7 = null;
        this.O.setTag(obj7);
        this.Q.setTag(obj7);
        this.R.setTag(obj7);
        this.S.setTag(obj7);
        N(view);
        A();
    }
}
