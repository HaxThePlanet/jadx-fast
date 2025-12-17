package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.dogcreation.g;
import app.dogo.com.dogo_android.dogcreation.j.n;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class hb extends app.dogo.com.dogo_android.h.gb {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout V;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        hb.Y = sparseIntArray;
        sparseIntArray.put(2131363433, 2);
        sparseIntArray.put(2131363436, 3);
        sparseIntArray.put(2131363421, 4);
        sparseIntArray.put(2131362081, 5);
    }

    public hb(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, hb.X, hb.Y));
    }

    private hb(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (TextView)object3Arr3[5], (Button)object3Arr3[1], (TextView)object3Arr3[4], (MaterialToolbar)object3Arr3[2], (TextView)object3Arr3[3]);
        this.W = -1;
        Object obj11 = object3Arr3[0];
        this.V = (ConstraintLayout)obj11;
        final int obj13 = 0;
        obj11.setTag(obj13);
        this.P.setTag(obj13);
        N(view2);
        A();
    }

    private boolean X(x<DogBreed> x, int i2) {
        if (i2 == 0) {
            this.W = obj3 |= i;
            return 1;
            synchronized (this) {
                this.W = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.W = obj3 |= i;
            return 1;
            synchronized (this) {
                this.W = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.gb
    public void A() {
        this.W = 16;
        I();
        return;
        synchronized (this) {
            this.W = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gb
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((x)object2, i3);
        }
        return Y((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.gb
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (139 == i) {
            V((g)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((n)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.gb
    public void V(g g) {
        this.U = g;
        this.W = l |= i2;
        notifyPropertyChanged(139);
        super.I();
        return;
        synchronized (this) {
            this.U = g;
            this.W = l |= i2;
            notifyPropertyChanged(139);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gb
    public void W(n n) {
        this.T = n;
        this.W = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = n;
            this.W = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gb
    protected void m() {
        int cmp;
        int value;
        int i5;
        int i2;
        int i;
        int i3;
        int value2;
        int i4;
        long l = this.W;
        i5 = 0;
        this.W = i5;
        g gVar = this.U;
        final n nVar = this.T;
        int cmp2 = Long.compare(i8, i5);
        i = 0;
        synchronized (this) {
            l = this.W;
            i5 = 0;
            this.W = i5;
            gVar = this.U;
            nVar = this.T;
            cmp2 = Long.compare(i8, i5);
            i = 0;
        }
        try {
            if (gVar != null) {
            } else {
            }
            i3 = gVar.k();
            i2 = gVar.l();
            i3 = i2;
            Q(1, i3);
            if (i3 != 0) {
            } else {
            }
            value2 = i3.getValue();
            value2 = i;
            value2 = i2;
        }
        cmp = Long.compare(i6, i5);
        if (cmp != 0) {
            if (nVar != null) {
                value = nVar.l();
            } else {
                value = i;
            }
            Q(0, value);
            if (value != null) {
                i = value;
            }
        }
        if (cmp != 0) {
            n.x0(this.V, i);
            n.Z(this.P, i);
        }
        if (cmp2 != 0) {
            o.G(this.V, value2, i2, this.Q, this.O);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gb
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
