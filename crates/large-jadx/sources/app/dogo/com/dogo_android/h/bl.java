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
import app.dogo.com.dogo_android.n.l.b.a;
import app.dogo.com.dogo_android.repository.domain.LibrarySection;

/* loaded from: classes.dex */
public class bl extends app.dogo.com.dogo_android.h.al implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout T;
    private final View.OnClickListener U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        bl.X = sparseIntArray;
        sparseIntArray.put(2131363206, 3);
        sparseIntArray.put(2131362326, 4);
    }

    public bl(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, bl.W, bl.X));
    }

    private bl(e e, View view2, Object[] object3Arr3) {
        int i3 = 1;
        super(e, view2, 0, (ImageView)object3Arr3[4], (TextView)object3Arr3[3], (Button)object3Arr3[i3], (ViewPager2)object3Arr3[2]);
        this.V = -1;
        Object obj10 = object3Arr3[0];
        this.T = (ConstraintLayout)obj10;
        final int obj12 = 0;
        obj10.setTag(obj12);
        this.O.setTag(obj12);
        this.P.setTag(obj12);
        N(view2);
        obj10 = new b(this, i3);
        this.U = obj10;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.al
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.al
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.al
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
                    T((b.a)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.al
    public void T(b.a b$a) {
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

    @Override // app.dogo.com.dogo_android.h.al
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

    @Override // app.dogo.com.dogo_android.h.al
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

    @Override // app.dogo.com.dogo_android.h.al
    public final void b(int i, View view2) {
        int obj2;
        final g obj1 = this.S;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.Q();
        }
    }

    @Override // app.dogo.com.dogo_android.h.al
    protected void m() {
        long l;
        int cmp;
        int cmp2;
        int cmp3;
        int cmp4;
        int i;
        int i4;
        int i2;
        int i3;
        l = this.V;
        final int i6 = 0;
        this.V = i6;
        final LibrarySection librarySection = this.Q;
        final int i7 = 13;
        i = 9;
        synchronized (this) {
            l = this.V;
            i6 = 0;
            this.V = i6;
            librarySection = this.Q;
            i7 = 13;
            i = 9;
        }
        try {
            cmp2 = Long.compare(i2, i6);
            if (librarySection != null) {
            } else {
            }
            i2 = 1;
            i2 = i4;
            i3 = 32;
        }
        if (Long.compare(i9, i6) != 0) {
            this.T.setVisibility(i4);
        }
        if (Long.compare(i11, i6) != 0) {
            this.O.setOnClickListener(this.U);
        }
        if (Long.compare(i5, i6) != 0) {
            f.p(this.P, librarySection, this.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.al
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
