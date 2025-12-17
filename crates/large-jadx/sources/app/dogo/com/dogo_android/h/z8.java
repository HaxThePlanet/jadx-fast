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
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.s.b.b;
import app.dogo.com.dogo_android.q.s.f;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class z8 extends app.dogo.com.dogo_android.h.y8 implements b.a {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout U;
    private final View.OnClickListener V;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z8.Y = sparseIntArray;
        sparseIntArray.put(2131363421, 4);
        sparseIntArray.put(2131362612, 5);
        sparseIntArray.put(2131362610, 6);
        sparseIntArray.put(2131362356, 7);
    }

    public z8(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, z8.X, z8.Y));
    }

    private z8(e e, View view2, Object[] object3Arr3) {
        int i6 = 1;
        super(e, view2, 2, (Button)object3Arr3[3], (Button)object3Arr3[7], (ImageView)object3Arr3[6], (ImageView)object3Arr3[5], (RecyclerView)object3Arr3[2], (SwipeRefreshLayout)object3Arr3[i6], (TextView)object3Arr3[4]);
        this.W = -1;
        int i9 = 0;
        this.O.setTag(i9);
        Object obj13 = object3Arr3[0];
        this.U = (ConstraintLayout)obj13;
        obj13.setTag(i9);
        this.Q.setTag(i9);
        this.R.setTag(i9);
        N(view2);
        obj13 = new b(this, i6);
        this.V = obj13;
        A();
    }

    private boolean X(x<y<Boolean>> x, int i2) {
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

    private boolean Y(x<y<DogParentUIState>> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.y8
    public void A() {
        this.W = 16;
        I();
        return;
        synchronized (this) {
            this.W = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y8
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((x)object2, i3);
        }
        return Y((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.y8
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((b.b)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((f)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.y8
    public void V(b.b b$b) {
        this.T = b;
        this.W = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.T = b;
            this.W = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y8
    public void W(f f) {
        this.S = f;
        this.W = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = f;
            this.W = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y8
    public final void b(int i, View view2) {
        int obj2;
        final f obj1 = this.S;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.h();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y8
    protected void m() {
        int cmp2;
        int value2;
        int cmp3;
        int cmp;
        int cmp4;
        int value;
        int i;
        int i2;
        int cmp5;
        long l = this.W;
        final int i4 = 0;
        this.W = i4;
        value2 = this.S;
        int cmp6 = Long.compare(i6, i4);
        int i9 = 26;
        i2 = 0;
        synchronized (this) {
            l = this.W;
            i4 = 0;
            this.W = i4;
            value2 = this.S;
            cmp6 = Long.compare(i6, i4);
            i9 = 26;
            i2 = 0;
        }
        try {
            if (cmp6 != 0) {
            } else {
            }
            if (value2 != null) {
            } else {
            }
            cmp4 = value2.l();
            cmp4 = i2;
            Q(0, cmp4);
            if (cmp4 != null) {
            } else {
            }
            value = cmp4.getValue();
            value = i2;
        }
        if (Long.compare(i13, i4) != 0) {
            if (value2 != null) {
                value2 = value2.j();
            } else {
                value2 = i2;
            }
            Q(1, value2);
            if (value2 != null) {
                i2 = value2;
            }
        }
        if (Long.compare(i10, i4) != 0) {
            n.x0(this.O, i2);
            n.Z(this.O, i2);
        }
        if (Long.compare(i, i4) != 0) {
            this.O.setOnClickListener(this.V);
        }
        if (Long.compare(i3, i4) != 0) {
            n.x0(this.U, value);
            n.y0(this.R, value);
        }
        if (cmp6 != 0) {
            o.x(this.Q, value, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.y8
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
