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

/* loaded from: classes.dex */
public class td extends app.dogo.com.dogo_android.h.sd implements c.a {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final ConstraintLayout U;
    private final SwipeRefreshLayout.j V;
    private g W;
    private long X;

    class a implements g {

        final app.dogo.com.dogo_android.h.td a;
        a(app.dogo.com.dogo_android.h.td td) {
            this.a = td;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int checkedChipId;
            Object qVar;
            int i;
            int i2;
            qVar = tdVar2.S;
            final int i3 = 0;
            i2 = qVar != null ? i : i3;
            if (i2 != 0) {
                qVar = qVar.r();
                if (qVar != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    qVar.setValue(Integer.valueOf(tdVar.O.getCheckedChipId()));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        td.Z = sparseIntArray;
        sparseIntArray.put(2131363433, 4);
        sparseIntArray.put(2131363187, 5);
    }

    public td(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, td.Y, td.Z));
    }

    private td(e e, View view2, Object[] object3Arr3) {
        final int i = 1;
        super(e, view2, 4, (ChipGroupWithState)object3Arr3[i], (RecyclerView)object3Arr3[3], (HorizontalScrollView)object3Arr3[5], (SwipeRefreshLayout)object3Arr3[2], (MaterialToolbar)object3Arr3[4]);
        td.a obj12 = new td.a(this);
        this.W = obj12;
        this.X = -1;
        int i7 = 0;
        this.O.setTag(i7);
        obj12 = object3Arr3[0];
        this.U = (ConstraintLayout)obj12;
        obj12.setTag(i7);
        this.P.setTag(i7);
        this.Q.setTag(i7);
        N(view2);
        obj12 = new c(this, i);
        this.V = obj12;
        A();
    }

    private boolean X(LiveData<List<Article>> liveData, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(LiveData<y<LibrarySection>> liveData, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(LiveData<List<LibraryTag>> liveData, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.sd
    public void A() {
        this.X = 64;
        I();
        return;
        synchronized (this) {
            this.X = 64;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sd
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return Z((x)object2, i3);
                }
                return a0((LiveData)object2, i3);
            }
            return Y((LiveData)object2, i3);
        }
        return X((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.sd
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((n.b)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((q)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.sd
    public void V(n.b n$b) {
        this.T = b;
        this.X = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.T = b;
            this.X = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sd
    public void W(q q) {
        this.S = q;
        this.X = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = q;
            this.X = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sd
    public final void a(int i) {
        int i2;
        final q obj2 = this.S;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.w();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sd
    protected void m() {
        int cmp4;
        int i;
        int value3;
        int cmp;
        int cmp3;
        int cmp7;
        int value4;
        LiveData cmp2;
        int value;
        int i4;
        int i3;
        int cmp6;
        int value2;
        int result;
        int i6;
        int cmp5;
        int i2;
        int i5;
        int i8;
        int i7;
        final Object obj = this;
        long l = obj.X;
        final int i10 = 0;
        obj.X = i10;
        value3 = obj.S;
        int cmp8 = Long.compare(i13, i10);
        final int i18 = 100;
        final int i19 = 0;
        synchronized (this) {
            obj = this;
            l = obj.X;
            i10 = 0;
            obj.X = i10;
            value3 = obj.S;
            cmp8 = Long.compare(i13, i10);
            i18 = 100;
            i19 = 0;
        }
        if (cmp8 != 0) {
            if (value3 != null) {
                try {
                    cmp2 = value3.n();
                    cmp2 = i19;
                    obj.Q(0, cmp2);
                    if (cmp2 != null) {
                    } else {
                    }
                    value4 = cmp2.getValue();
                    value4 = i19;
                }
                value2 = i19;
                if (Long.compare(i8, i10) != 0) {
                    if (value3 != null) {
                        cmp5 = value3.s();
                    } else {
                        cmp5 = i19;
                    }
                    obj.Q(2, cmp5);
                    if (cmp5 != 0) {
                        value = cmp5.getValue();
                    } else {
                        value = i19;
                    }
                } else {
                }
                if (Long.compare(i7, i10) != 0) {
                    if (value3 != null) {
                        i = value3.r();
                    } else {
                        i = i19;
                    }
                    obj.Q(3, i);
                    if (i != 0) {
                        value3 = i.getValue();
                    } else {
                        value3 = i19;
                    }
                    i2 = ViewDataBinding.J(value3);
                } else {
                    i2 = 0;
                }
                if (Long.compare(i21, i10) != 0) {
                    n.a.a(obj.O, i2);
                }
                if (Long.compare(i17, i10) != 0) {
                    f.e(obj.O, value);
                }
                if (Long.compare(i3, i10) != 0) {
                    n.a.b(obj.O, i19, obj.W);
                    obj.Q.setOnRefreshListener(obj.V);
                }
                if (cmp8 != 0) {
                    f.h(obj.P, value4, obj.T);
                }
                if (Long.compare(i9, i10) != 0) {
                    n.y0(obj.Q, value2);
                }
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.sd
    public boolean y() {
        synchronized (this) {
            try {
                return 1;
                return 0;
                throw th;
            }
        }
    }
}
