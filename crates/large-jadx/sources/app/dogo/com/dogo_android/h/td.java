package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.j;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.k.n.b;
import app.dogo.com.dogo_android.n.k.q;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.f0.n.a;
import com.google.android.material.chip.ChipGroup;
import java.util.List;

/* compiled from: FragmentLibraryArticleListBindingImpl.java */
/* loaded from: classes.dex */
public class td extends sd implements c.a {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z = new SparseIntArray();
    private final ConstraintLayout U;
    private final SwipeRefreshLayout.j V;
    private g W;
    private long X;

    class a implements g {

        final /* synthetic */ td a;
        a() {
            this.a = tdVar;
            super();
        }

        public void a() {
            int i = 1;
            i = 1;
            i = 0;
            int r4 = this.a.S != null ? 1 : i;
            if (i != 0 && xVar != null) {
                if (i != 0) {
                    xVar.setValue(Integer.valueOf(this.a.O.getCheckedChipId()));
                }
            }
        }
    }
    static {
        obj.put(2131363433, 4);
        obj.put(2131363187, 5);
    }

    public td(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, td.Y, td.Z));
    }

    private boolean X(LiveData<List<Article>> liveData, int i) {
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

    private boolean Y(LiveData<y<LibrarySection>> liveData, int i) {
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

    private boolean Z(x<Integer> xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 8;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    private boolean a0(LiveData<List<LibraryTag>> liveData, int i) {
        if (i == 0) {
            synchronized (this) {
                try {
                    this.X |= 4;
                    return true;
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        return false;
    }

    @Override // app.dogo.com.dogo_android.h.sd
    public void A() {
        synchronized (this) {
            try {
                this.X = 64L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.sd
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return a0(object, i2);
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.sd
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

    @Override // app.dogo.com.dogo_android.h.sd
    public void V(n.b bVar) {
        this.T = bVar;
        synchronized (this) {
            try {
                this.X |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sd
    public void W(q qVar) {
        this.S = qVar;
        synchronized (this) {
            try {
                this.X |= 32;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.sd
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.S != null ? 1 : 0;
        if (i2 != 0) {
            this.S.w();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sd
    protected void m() {
        Object obj2;
        Integer num;
        int cmp4;
        LiveData liveData;
        int i;
        List list;
        Object value;
        List list2;
        int cmp6;
        LiveData result;
        Object value2;
        y yVar;
        LiveData liveData2;
        int cmp8;
        int i2 = 0;
        int i3 = 0;
        long l4;
        long l5;
        long l6;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l9 = 0L;
                obj.X = l9;
            } catch (Throwable th) {
            }
        }
        long l10 = 113L & l7;
        long l11 = 127L & l7;
        long l = 98L;
        final long l13 = 100L;
        final com.google.android.material.chip.ChipGroup.d dVar = null;
        if (l11 != l9) {
            if (l10 != l9) {
                if (obj.S != null) {
                    liveData = obj.S.n();
                } else {
                    int i9 = dVar;
                }
                obj.Q(0, liveData);
                Object value4 = liveData != null ? (List)value4 : dVar;
            }
            l4 = l7 & 98L;
            if (l4 != l9) {
                if (obj.S != null) {
                    result = obj.S.getResult();
                } else {
                    int i13 = dVar;
                }
                i2 = 1;
                obj.Q(i2, result);
                value2 = result != null ? (LoadResult)value2 : dVar;
            }
            l5 = l7 & 100L;
            if (l5 != l9) {
                if (obj.S != null) {
                    liveData2 = obj.S.s();
                } else {
                    int i15 = dVar;
                }
                obj.Q(2, liveData2);
                value = liveData2 != null ? (List)value : dVar;
            }
            long l3 = 104L;
            l6 = l7 & l3;
            if (l6 != l9) {
                if (obj.S != null) {
                    x xVar = obj.S.r();
                } else {
                    int i5 = dVar;
                }
                cmp6 = 3;
                obj.Q(cmp6, obj2);
                Object value3 = obj.S != null ? (Integer)value3 : dVar;
                i3 = ViewDataBinding.J(num);
            } else {
                i3 = 0;
            }
        } else {
        }
        long l14 = l7 & 104L;
        if (l14 != l9) {
            BindingAdapters_ChipGroupBindingAdapter.a(obj.O, i3);
        }
        long l12 = l7 & 100L;
        if (l12 != l9) {
            LibraryBindingAdapters.e(obj.O, list2);
        }
        l2 = 64L & l7;
        if (l2 != l9) {
            BindingAdapters_ChipGroupBindingAdapter.b(obj.O, dVar, obj.W);
            obj.Q.setOnRefreshListener(obj.V);
        }
        if (l10 != l9) {
            LibraryBindingAdapters.h(obj.P, list, obj.T);
        }
        long l8 = l7 & 98L;
        if (obj.X != l9) {
            BindingAdapters.y0(obj.Q, yVar);
        }
    }

    @Override // app.dogo.com.dogo_android.h.sd
    public boolean y() {
        synchronized (this) {
            try {
                if (this.X != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private td(e eVar, View view, Object[] objectArr) {
        final int i = 1;
        super(eVar, view, 4, (ChipGroupWithState)objectArr[i], (RecyclerView)objectArr[3], (HorizontalScrollView)objectArr[5], (SwipeRefreshLayout)objectArr[2], (MaterialToolbar)objectArr[4]);
        this.W = new td.a(this);
        this.X = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        Object obj7 = objectArr[0];
        this.U = obj7;
        obj7.setTag(obj6);
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        N(view);
        this.V = new c(this, i);
        A();
    }
}
