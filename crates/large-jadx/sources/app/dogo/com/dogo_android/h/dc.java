package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.dogcreation.j.i.b;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.p.u;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import java.util.List;

/* loaded from: classes.dex */
public class dc extends app.dogo.com.dogo_android.h.cc {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final ConstraintLayout U;
    private final FrameLayout V;
    private final app.dogo.com.dogo_android.h.ok W;
    private long X;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(8);
        dc.Y = gVar;
        int i6 = 1;
        final int[] iArr2 = new int[i6];
        final int i14 = 0;
        iArr2[i14] = 3;
        int[] iArr = new int[i6];
        iArr[i14] = 2131558775;
        gVar.a(2, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        dc.Z = sparseIntArray;
        sparseIntArray.put(2131363433, 4);
        sparseIntArray.put(2131363193, 5);
        sparseIntArray.put(2131361858, 6);
        sparseIntArray.put(2131362178, 7);
    }

    public dc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, dc.Y, dc.Z));
    }

    private dc(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (FrameLayout)object3Arr3[6], (RecyclerView)object3Arr3[1], (ImageView)object3Arr3[7], (EditText)object3Arr3[5], (MaterialToolbar)object3Arr3[4]);
        this.X = -1;
        int i7 = 0;
        this.P.setTag(i7);
        Object obj11 = object3Arr3[0];
        this.U = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        obj11 = object3Arr3[2];
        this.V = (FrameLayout)obj11;
        obj11.setTag(i7);
        obj11 = object3Arr3[3];
        this.W = (ok)obj11;
        L(obj11);
        N(view2);
        A();
    }

    private boolean X(x<y<List<DogBreed>>> x, int i2) {
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

    private boolean Y(x<y<Boolean>> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.cc
    public void A() {
        this.X = 16;
        this.W.A();
        I();
        return;
        synchronized (this) {
            this.X = 16;
            this.W.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cc
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Y((x)object2, i3);
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.cc
    public void M(q q) {
        super.M(q);
        this.W.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.cc
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((i.b)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((u)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.cc
    public void V(i.b i$b) {
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

    @Override // app.dogo.com.dogo_android.h.cc
    public void W(u u) {
        this.S = u;
        this.X = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = u;
            this.X = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.cc
    protected void m() {
        int cmp;
        u value;
        int i;
        int cmp3;
        int value2;
        int i2;
        int cmp2;
        long l = this.X;
        final int i4 = 0;
        this.X = i4;
        value = this.S;
        cmp3 = Long.compare(i6, i4);
        final int i9 = 26;
        i2 = 0;
        synchronized (this) {
            l = this.X;
            i4 = 0;
            this.X = i4;
            value = this.S;
            cmp3 = Long.compare(i6, i4);
            i9 = 26;
            i2 = 0;
        }
        try {
            if (cmp3 != 0) {
            } else {
            }
            if (value != null) {
            } else {
            }
            value2 = value.l();
            value2 = i2;
            Q(0, value2);
            if (value2 != null) {
            } else {
            }
            value2 = value2.getValue();
            value2 = i2;
        }
        if (Long.compare(i10, i4) != 0) {
            if (value != null) {
                value = value.m();
            } else {
                value = i2;
            }
            Q(1, value);
            if (value != null) {
                i2 = value;
            }
        }
        i = i2;
        i2 = value2;
        if (cmp3 != 0) {
            o.s(this.P, i2, this.T, this.Q, 2131558778);
        }
        if (Long.compare(i3, i4) != 0) {
            n.x0(this.U, i);
            n.D0(this.V, i);
        }
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.cc
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.W.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
