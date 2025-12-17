package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.a0.g.f.g0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryFilterViewModel;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public class b1 extends app.dogo.com.dogo_android.h.a1 implements b.a {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final ConstraintLayout T;
    private final FrameLayout U;
    private final View.OnClickListener V;
    private final View.OnClickListener W;
    private long X;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        b1.Z = sparseIntArray;
        sparseIntArray.put(2131362733, 3);
    }

    public b1(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, b1.Y, b1.Z));
    }

    private b1(e e, View view2, Object[] object3Arr3) {
        final int i = 2;
        super(e, view2, 2, (LinearLayout)object3Arr3[i], (RecyclerView)object3Arr3[3]);
        this.X = -1;
        int i4 = 0;
        this.O.setTag(i4);
        Object obj9 = object3Arr3[0];
        this.T = (ConstraintLayout)obj9;
        obj9.setTag(i4);
        obj9 = 1;
        final Object obj11 = object3Arr3[obj9];
        this.U = (FrameLayout)obj11;
        obj11.setTag(i4);
        N(view2);
        b obj10 = new b(this, obj9);
        this.V = obj10;
        obj9 = new b(this, i);
        this.W = obj9;
        A();
    }

    private boolean Y(g0 g0, int i2) {
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

    private boolean Z(EntryFilterViewModel entryFilterViewModel, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.X = l2 |= i6;
            return obj5;
            synchronized (this) {
                this.X = l2 |= i6;
                return obj5;
            }
        }
        if (i2 == 104) {
            this.X = l |= i5;
            return obj5;
            synchronized (this) {
                this.X = l |= i5;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public void A() {
        this.X = 16;
        I();
        return;
        synchronized (this) {
            this.X = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a1
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Z((EntryFilterViewModel)object2, i3);
        }
        return Y((g0)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (176 == i) {
            W((g0)object2);
            obj2 = 1;
        } else {
            if (183 == i) {
                X((EntryFilterViewModel)object2);
            } else {
                if (116 == i) {
                    V((a0)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public void V(a0 a0) {
        this.S = a0;
        this.X = l |= i2;
        notifyPropertyChanged(116);
        super.I();
        return;
        synchronized (this) {
            this.S = a0;
            this.X = l |= i2;
            notifyPropertyChanged(116);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public void W(g0 g0) {
        R(0, g0);
        this.R = g0;
        this.X = l |= i3;
        notifyPropertyChanged(176);
        super.I();
        return;
        synchronized (this) {
            R(0, g0);
            this.R = g0;
            this.X = l |= i3;
            notifyPropertyChanged(176);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public void X(EntryFilterViewModel entryFilterViewModel) {
        R(1, entryFilterViewModel);
        this.Q = entryFilterViewModel;
        this.X = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(1, entryFilterViewModel);
            this.Q = entryFilterViewModel;
            this.X = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a1
    public final void b(int i, View view2) {
        a0 a0Var;
        g0 obj3;
        int obj4;
        obj4 = 0;
        final int i2 = 1;
        if (i != i2) {
            if (i != 2) {
            } else {
                obj3 = this.R;
                if (obj3 != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    obj3.B(this.S);
                }
            }
        } else {
            obj3 = this.R;
            if (obj3 != null) {
                obj4 = i2;
            }
            if (obj4 != null) {
                obj3.B(this.S);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.a1
    protected void m() {
        long l;
        int cmp3;
        int listEmpty;
        int cmp2;
        int cmp;
        int i;
        int i2;
        l = this.X;
        final int i4 = 0;
        this.X = i4;
        listEmpty = this.Q;
        final int i5 = 26;
        cmp = Long.compare(i6, i4);
        synchronized (this) {
            l = this.X;
            i4 = 0;
            this.X = i4;
            listEmpty = this.Q;
            i5 = 26;
            cmp = Long.compare(i6, i4);
        }
        try {
            if (listEmpty != null) {
            } else {
            }
            listEmpty = listEmpty.isListEmpty();
            listEmpty = i;
            if (listEmpty != 0) {
            } else {
            }
            i2 = 64;
            i2 = 32;
        }
        if (listEmpty != 0) {
        } else {
            i = listEmpty;
        }
        if (Long.compare(i8, i4) != 0) {
            this.O.setOnClickListener(this.W);
            this.U.setOnClickListener(this.V);
        }
        if (Long.compare(i3, i4) != 0) {
            this.U.setVisibility(i);
        }
    }

    @Override // app.dogo.com.dogo_android.h.a1
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
