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

/* loaded from: classes.dex */
public class be extends app.dogo.com.dogo_android.h.ae implements c.a {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final ConstraintLayout U;
    private final SwipeRefreshLayout.j V;
    private g W;
    private long X;

    class a implements g {

        final app.dogo.com.dogo_android.h.be a;
        a(app.dogo.com.dogo_android.h.be be) {
            this.a = be;
            super();
        }

        @Override // androidx.databinding.g
        public void a() {
            int checkedChipId;
            Object rVar;
            int i;
            int i2;
            rVar = beVar2.S;
            final int i3 = 0;
            i2 = rVar != null ? i : i3;
            if (i2 != 0) {
                rVar = rVar.q();
                if (rVar != null) {
                } else {
                    i = i3;
                }
                if (i != 0) {
                    rVar.setValue(Integer.valueOf(beVar.O.getCheckedChipId()));
                }
            }
        }
    }
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        be.Z = sparseIntArray;
        sparseIntArray.put(2131363187, 5);
    }

    public be(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, be.Y, be.Z));
    }

    private be(e e, View view2, Object[] object3Arr3) {
        int i5 = 1;
        super(e, view2, 4, (ChipGroupWithState)object3Arr3[2], (RecyclerView)object3Arr3[4], (HorizontalScrollView)object3Arr3[5], (SwipeRefreshLayout)object3Arr3[3], (MaterialToolbar)object3Arr3[i5]);
        be.a obj11 = new be.a(this);
        this.W = obj11;
        this.X = -1;
        int i7 = 0;
        this.O.setTag(i7);
        obj11 = object3Arr3[0];
        this.U = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        this.P.setTag(i7);
        this.Q.setTag(i7);
        this.R.setTag(i7);
        N(view2);
        obj11 = new c(this, i5);
        this.V = obj11;
        A();
    }

    private boolean X(LiveData<y<LibrarySection>> liveData, int i2) {
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

    private boolean Y(x<Integer> x, int i2) {
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

    private boolean Z(LiveData<List<LibraryTag>> liveData, int i2) {
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

    private boolean a0(LiveData<List<TrickItem>> liveData, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.ae
    public void A() {
        this.X = 64;
        I();
        return;
        synchronized (this) {
            this.X = 64;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ae
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return a0((LiveData)object2, i3);
                }
                return Y((x)object2, i3);
            }
            return Z((LiveData)object2, i3);
        }
        return X((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ae
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((o.a)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((r)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ae
    public void V(o.a o$a) {
        this.T = a;
        this.X = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.T = a;
            this.X = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ae
    public void W(r r) {
        this.S = r;
        this.X = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = r;
            this.X = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ae
    public final void a(int i) {
        int i2;
        final r obj2 = this.S;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.C();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ae
    protected void m() {
        int cmp2;
        int cmp6;
        int value;
        r rVar;
        int cmp;
        int value3;
        LiveData result;
        int i10;
        int value2;
        int cmp4;
        int cmp5;
        int cmp8;
        int i9;
        int i4;
        int i8;
        int value4;
        int i6;
        int cmp7;
        int i;
        int i7;
        int i5;
        int i2;
        int i11;
        int i3;
        int cmp3;
        final Object obj = this;
        long l = obj.X;
        final int i13 = 0;
        obj.X = i13;
        rVar = obj.S;
        cmp = Long.compare(i18, i13);
        int i23 = 98;
        i10 = 0;
        synchronized (this) {
            obj = this;
            l = obj.X;
            i13 = 0;
            obj.X = i13;
            rVar = obj.S;
            cmp = Long.compare(i18, i13);
            i23 = 98;
            i10 = 0;
        }
        if (Long.compare(i27, i13) != 0) {
            if (rVar != null) {
                try {
                    result = rVar.getResult();
                    result = i10;
                    obj.Q(0, result);
                    if (result != null) {
                    } else {
                    }
                    value3 = result.getValue();
                    value3 = i10;
                }
                value2 = i10;
                if (Long.compare(i29, i13) != 0 && rVar != null) {
                    if (rVar != null) {
                        i5 = rVar.k();
                    } else {
                        i5 = i10;
                    }
                } else {
                }
                if (Long.compare(i30, i13) != 0) {
                    if (rVar != null) {
                        i8 = i2;
                    } else {
                        i8 = i10;
                    }
                    obj.Q(2, i8);
                    if (i8 != 0) {
                        value4 = i8.getValue();
                    } else {
                        value4 = i10;
                    }
                    i2 = i4;
                } else {
                    i2 = 0;
                }
                if (cmp != 0) {
                    if (rVar != null) {
                        rVar = rVar.s();
                    } else {
                        rVar = i10;
                    }
                    obj.Q(3, rVar);
                    if (rVar != 0) {
                        value = rVar.getValue();
                    } else {
                        value = i10;
                    }
                } else {
                }
                i9 = i5;
                i = i2;
                if (Long.compare(i26, i13) != 0) {
                    n.a.a(obj.O, i);
                }
                if (Long.compare(i24, i13) != 0) {
                    f.e(obj.O, value2);
                }
                if (Long.compare(i22, i13) != 0) {
                    n.a.b(obj.O, i10, obj.W);
                    obj.Q.setOnRefreshListener(obj.V);
                }
                if (cmp != 0) {
                    i.s(obj.P, value, obj.T);
                }
                if (Long.compare(i15, i13) != 0) {
                    n.y0(obj.Q, value3);
                }
                if (Long.compare(i12, i13) != 0) {
                    f.o(obj.R, i9);
                }
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.ae
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
