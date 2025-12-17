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
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.n.g;
import app.dogo.com.dogo_android.n.k.n.b;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;

/* loaded from: classes.dex */
public class xk extends app.dogo.com.dogo_android.h.wk implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final View.OnClickListener U;
    private long V;
    static {
    }

    public xk(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, xk.W, xk.X));
    }

    private xk(e e, View view2, Object[] object3Arr3) {
        int i2 = 1;
        super(e, view2, 0, (RecyclerView)object3Arr3[2], (Button)object3Arr3[i2]);
        this.V = -1;
        int i4 = 0;
        this.O.setTag(i4);
        Object obj8 = object3Arr3[0];
        this.T = (ConstraintLayout)obj8;
        obj8.setTag(i4);
        this.P.setTag(i4);
        N(view2);
        obj8 = new b(this, i2);
        this.U = obj8;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.wk
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wk
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.wk
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
                    T((n.b)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.wk
    public void T(n.b n$b) {
        this.R = b;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.R = b;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wk
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

    @Override // app.dogo.com.dogo_android.h.wk
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

    @Override // app.dogo.com.dogo_android.h.wk
    public final void b(int i, View view2) {
        int obj2;
        final g obj1 = this.S;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.E0();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wk
    protected void m() {
        long l;
        int cmp3;
        View.OnClickListener list;
        int cmp2;
        int cmp;
        int cmp4;
        int i2;
        int i;
        int i3;
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
            i = i2;
            i3 = 32;
        }
        if (Long.compare(i9, i5) != 0) {
            f.g(this.O, librarySection, this.R);
        }
        if (Long.compare(i6, i5) != 0) {
            this.T.setVisibility(i2);
        }
        if (Long.compare(i4, i5) != 0) {
            this.P.setOnClickListener(this.U);
        }
    }

    @Override // app.dogo.com.dogo_android.h.wk
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
