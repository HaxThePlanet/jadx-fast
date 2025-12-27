package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.t.g0.i;
import app.dogo.com.dogo_android.t.g0.j.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* compiled from: FragmentFaqListBindingImpl.java */
/* loaded from: classes.dex */
public class fd extends ed {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = new SparseIntArray();
    private final ConstraintLayout U;
    private long V;
    static {
        obj.put(2131363433, 2);
        obj.put(2131363193, 3);
        obj.put(2131361858, 4);
        obj.put(2131362178, 5);
    }

    public fd(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, fd.W, fd.X));
    }

    private boolean X(LiveData<y<List<Article>>> liveData, int i) {
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

    @Override // app.dogo.com.dogo_android.h.ed
    public void A() {
        synchronized (this) {
            try {
                this.V = 8L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ed
    protected boolean E(int i, Object object, int i2) {
        if (i != 0) {
            return false;
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ed
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

    @Override // app.dogo.com.dogo_android.h.ed
    public void V(j.a aVar) {
        this.T = aVar;
        synchronized (this) {
            try {
                this.V |= 2;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ed
    public void W(i iVar) {
        this.S = iVar;
        synchronized (this) {
            try {
                this.V |= 4;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ed
    protected void m() {
        y yVar = null;
        LiveData result;
        long l = 0;
        int i2 = 0;
        synchronized (this) {
            try {
                l = 0L;
                this.V = l;
            } catch (Throwable th) {
            }
        }
        long l3 = this.V & 15L;
        if (l3 != l) {
            if (this.S != null) {
                result = this.S.getResult();
            } else {
            }
            i2 = 0;
            Q(i2, result);
            if (result != null) {
                Object value = result.getValue();
            }
        }
        if (l3 != l) {
            i2 = 2131558778;
            BindingAdapters.N(this.P, yVar, this.T, this.Q, i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ed
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

    private fd(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 1, (FrameLayout)objectArr[4], (AppCompatImageView)objectArr[5], (RecyclerView)objectArr[1], (EditText)objectArr[3], (MaterialToolbar)objectArr[2]);
        this.V = -1L;
        Object obj6 = objectArr[0];
        this.U = obj6;
        final Object obj7 = null;
        obj6.setTag(obj7);
        this.P.setTag(obj7);
        N(view);
        A();
    }
}
