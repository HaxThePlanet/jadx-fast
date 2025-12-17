package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.d.c.h;

/* loaded from: classes.dex */
public class ja extends app.dogo.com.dogo_android.h.ia {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(4);
        ja.U = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i7 = 0;
        iArr2[i7] = 2;
        int[] iArr = new int[i3];
        iArr[i7] = 2131558813;
        gVar.a(i7, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        ja.V = sparseIntArray;
        sparseIntArray.put(2131363042, 3);
    }

    public ja(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, ja.U, ja.V));
    }

    private ja(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (TextView)object3Arr3[1], (RecyclerView)object3Arr3[3], (cn)object3Arr3[2]);
        this.T = -1;
        Object obj9 = object3Arr3[0];
        this.S = (ConstraintLayout)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        this.O.setTag(obj11);
        L(this.Q);
        N(view2);
        A();
    }

    private boolean W(app.dogo.com.dogo_android.h.cn cn, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.T = obj3 |= i;
            return 1;
            synchronized (this) {
                this.T = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ia
    public void A() {
        this.T = 8;
        this.Q.A();
        I();
        return;
        synchronized (this) {
            this.T = 8;
            this.Q.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ia
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((x)object2, i3);
        }
        return W((cn)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ia
    public void M(q q) {
        super.M(q);
        this.Q.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ia
    public boolean O(int i, Object object2) {
        int obj2;
        if (183 == i) {
            V((h)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ia
    public void V(h h) {
        this.R = h;
        this.T = l |= i2;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            this.R = h;
            this.T = l |= i2;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ia
    protected void m() {
        long l;
        int cmp;
        h hVar;
        int value;
        int i;
        int i2;
        int i3;
        l = this.T;
        final int i5 = 0;
        this.T = i5;
        hVar = this.R;
        final int i6 = 14;
        int cmp2 = Long.compare(i7, i5);
        i = 0;
        synchronized (this) {
            l = this.T;
            i5 = 0;
            this.T = i5;
            hVar = this.R;
            i6 = 14;
            cmp2 = Long.compare(i7, i5);
            i = 0;
        }
        try {
            if (hVar != null) {
            } else {
            }
            value = hVar.l();
            value = i2;
            Q(1, value);
            if (value != null) {
            }
            i2 = value;
            hVar = ViewDataBinding.K(i2);
        }
        if (hVar) {
        } else {
            i = hVar;
        }
        if (Long.compare(i4, i5) != 0) {
            this.O.setVisibility(i);
        }
        ViewDataBinding.o(this.Q);
    }

    @Override // app.dogo.com.dogo_android.h.ia
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.Q.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
