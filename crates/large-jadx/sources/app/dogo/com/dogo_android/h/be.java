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
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.l.a.c;
import app.dogo.com.dogo_android.l.a.c.a;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.n.m.r;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;
import app.dogo.com.dogo_android.repository.domain.LibraryTag;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.f0.n.a;
import com.google.android.material.chip.ChipGroup;
import java.util.List;

/* compiled from: FragmentLibraryTrickListBindingImpl.java */
/* loaded from: classes.dex */
public class be extends ae implements c.a {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z = new SparseIntArray();
    private final ConstraintLayout U;
    private final SwipeRefreshLayout.j V;
    private g W;
    private long X;

    class a implements g {

        final /* synthetic */ be a;
        a() {
            this.a = beVar;
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
        obj.put(2131363187, 5);
    }

    public be(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, be.Y, be.Z));
    }

    private boolean X(LiveData<y<LibrarySection>> liveData, int i) {
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

    private boolean Y(x<Integer> xVar, int i) {
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

    private boolean Z(LiveData<List<LibraryTag>> liveData, int i) {
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

    private boolean a0(LiveData<List<TrickItem>> liveData, int i) {
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

    @Override // app.dogo.com.dogo_android.h.ae
    public void A() {
        synchronized (this) {
            try {
                this.X = 64L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.ae
    protected boolean E(int i, Object object, int i2) {
        if (i != 0 && i != 1) {
            if (i != 2 && i != 3) {
                return false;
            }
            return Y(object, i2);
        }
        return X(object, i2);
    }

    @Override // app.dogo.com.dogo_android.h.ae
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

    @Override // app.dogo.com.dogo_android.h.ae
    public void V(o.a aVar) {
        this.T = aVar;
        synchronized (this) {
            try {
                this.X |= 16;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(29);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ae
    public void W(r rVar) {
        this.S = rVar;
        synchronized (this) {
            try {
                this.X |= 32;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(177);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.ae
    public final void a(int i) {
        int i2 = 1;
        int r0 = this.S != null ? 1 : 0;
        if (i2 != 0) {
            this.S.C();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ae
    protected void m() {
        LiveData liveData;
        Object value;
        List list;
        LiveData result;
        int i2;
        y yVar;
        LiveData liveData2;
        Object value2;
        List list2;
        int cmp7;
        Object obj2;
        Integer num;
        int i3 = 97;
        app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory trickCategory;
        int i4 = 2;
        int i5 = 0;
        final Object obj = this;
        synchronized (this) {
            try {
                final long l5 = 0L;
                obj.X = l5;
            } catch (Throwable th) {
            }
        }
        long l7 = 120L & l3;
        long l8 = 127L & l3;
        long l10 = 98L;
        i5 = 0;
        com.google.android.material.chip.ChipGroup.d dVar = null;
        if (l8 != l5) {
            long l14 = l3 & 97L;
            if (l14 != l5) {
                if (obj.S != null) {
                    result = obj.S.getResult();
                } else {
                    int i12 = dVar;
                }
                obj.Q(0, result);
                Object value3 = result != null ? (LoadResult)value3 : dVar;
            }
            long l15 = l3 & 98L;
            if (l15 != l5) {
                if (obj.S != null) {
                    liveData2 = obj.S.r();
                } else {
                    int i13 = dVar;
                }
                i5 = 1;
                obj.Q(i5, liveData2);
                value2 = liveData2 != null ? (List)value2 : dVar;
            }
            long l2 = 96L;
            long l16 = l3 & l2;
            if (l16 == l5 || obj.S == null) {
                int i18 = dVar;
            } else {
                trickCategory = obj.S.k();
            }
            long l = 100L;
            long l17 = l3 & l;
            if (l17 != l5) {
                x xVar = obj.S != null ? xVar : dVar;
                i4 = 2;
                obj.Q(i4, obj2);
                Object value4 = obj2 != null ? (Integer)value4 : dVar;
            } else {
                i3 = 0;
            }
            if (l7 != l5) {
                if (obj.S != null) {
                    liveData = obj.S.s();
                } else {
                    int i6 = dVar;
                }
                i3 = 3;
                obj.Q(i3, liveData);
                value = obj.S != null ? (List)value : dVar;
            }
        } else {
            i3 = 0;
        }
        long l13 = l3 & 100L;
        if (l13 != l5) {
            BindingAdapters_ChipGroupBindingAdapter.a(obj.O, i3);
        }
        long l11 = 98L & l3;
        if (l11 != l5) {
            LibraryBindingAdapters.setArticleListTab(obj.O, list2);
        }
        long l9 = 64L & l3;
        if (l9 != l5) {
            BindingAdapters_ChipGroupBindingAdapter.b(obj.O, dVar, obj.W);
            obj.Q.setOnRefreshListener(obj.V);
        }
        if (l7 != l5) {
            TrainingBindingAdapters.s(obj.P, list, obj.T);
        }
        long l6 = 97L & l3;
        if (obj.S != l5) {
            BindingAdapters.y0(obj.Q, yVar);
        }
        long l4 = l3 & 96L;
        if (obj.X != l5) {
            LibraryBindingAdapters.setupTrickDetailsPauseTime(obj.R, trickCategory);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ae
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

    private be(e eVar, View view, Object[] objectArr) {
        int i5 = 1;
        super(eVar, view, 4, (ChipGroupWithState)objectArr[2], (RecyclerView)objectArr[4], (HorizontalScrollView)objectArr[5], (SwipeRefreshLayout)objectArr[3], (MaterialToolbar)objectArr[i5]);
        this.W = new be.a(this);
        this.X = -1L;
        Object obj6 = null;
        this.O.setTag(obj6);
        Object obj7 = objectArr[0];
        this.U = obj7;
        obj7.setTag(obj6);
        this.P.setTag(obj6);
        this.Q.setTag(obj6);
        this.R.setTag(obj6);
        N(view);
        this.V = new c(this, i5);
        A();
    }
}
