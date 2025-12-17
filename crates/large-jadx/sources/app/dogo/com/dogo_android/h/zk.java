package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.n.m.o.a;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;

/* loaded from: classes.dex */
public class zk extends app.dogo.com.dogo_android.h.yk implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final View.OnClickListener U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zk.X = sparseIntArray;
        sparseIntArray.put(2131362326, 3);
    }

    public zk(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, zk.W, zk.X));
    }

    private zk(e e, View view2, Object[] object3Arr3) {
        int i3 = 1;
        super(e, view2, 0, (ImageView)object3Arr3[3], (RecyclerView)object3Arr3[2], (Button)object3Arr3[i3]);
        this.V = -1;
        int i5 = 0;
        this.O.setTag(i5);
        Object obj9 = object3Arr3[0];
        this.T = (ConstraintLayout)obj9;
        obj9.setTag(i5);
        this.P.setTag(i5);
        N(view2);
        obj9 = new b(this, i3);
        this.U = obj9;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.yk
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yk
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.yk
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            U((LibrarySection)object2);
            obj2 = 1;
        } else {
            if (100 == i) {
                V((g)object2);
            } else {
                if (29 == i) {
                    T((o.a)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.yk
    public void T(o.a o$a) {
        this.R = a;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.R = a;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yk
    public void U(LibrarySection librarySection) {
        this.Q = librarySection;
        this.V = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = librarySection;
            this.V = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yk
    public void V(g g) {
        this.S = g;
        this.V = l |= i2;
        notifyPropertyChanged(100);
        super.I();
        return;
        synchronized (this) {
            this.S = g;
            this.V = l |= i2;
            notifyPropertyChanged(100);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.yk
    public final void b(int i, View view2) {
        int i2;
        int i3;
        Object obj4;
        obj4 = this.Q;
        final g obj5 = this.S;
        final int i4 = 0;
        i3 = obj5 != null ? i2 : i4;
        if (i3 != 0) {
            if (obj4 != null) {
            } else {
                i2 = i4;
            }
            if (i2 != 0) {
                obj5.X(obj4.getId(), obj4.getName());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.yk
    protected void m() {
        long l;
        int cmp;
        View.OnClickListener list;
        int cmp2;
        int cmp3;
        int cmp4;
        int i3;
        int i;
        int i2;
        l = this.V;
        final int i5 = 0;
        this.V = i5;
        LibrarySection librarySection = this.Q;
        int i8 = 13;
        final int i11 = 9;
        synchronized (this) {
            l = this.V;
            i5 = 0;
            this.V = i5;
            librarySection = this.Q;
            i8 = 13;
            i11 = 9;
        }
        try {
            cmp4 = Long.compare(i, i5);
            if (librarySection != null) {
            } else {
            }
            i = 1;
            i = i3;
            i2 = 32;
        }
        if (Long.compare(i9, i5) != 0) {
            i.r(this.O, librarySection, this.R);
        }
        if (Long.compare(i6, i5) != 0) {
            this.T.setVisibility(i3);
        }
        if (Long.compare(i4, i5) != 0) {
            this.P.setOnClickListener(this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.yk
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
