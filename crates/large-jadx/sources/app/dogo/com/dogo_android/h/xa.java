package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.g.g0.h;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.RecommendedOrderedPrograms;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class xa extends app.dogo.com.dogo_android.h.wa implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final View.OnClickListener T;
    private long U;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(9);
        xa.V = gVar;
        int i7 = 1;
        final int[] iArr2 = new int[i7];
        final int i15 = 0;
        iArr2[i15] = 3;
        int[] iArr = new int[i7];
        iArr[i15] = 2131558790;
        gVar.a(i15, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        xa.W = sparseIntArray;
        sparseIntArray.put(2131362712, 4);
        sparseIntArray.put(2131362713, 5);
        sparseIntArray.put(2131363157, 6);
        sparseIntArray.put(2131363158, 7);
        sparseIntArray.put(2131361928, 8);
    }

    public xa(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, xa.V, xa.W));
    }

    private xa(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        final int i12 = 1;
        super(e, view2, 2, (AnimatedTextView)object3Arr3[8], (ConstraintLayout)object3Arr3[0], (ImageView)object3Arr3[4], (ImageView)object3Arr3[5], (Button)object3Arr3[2], (ImageView)object3Arr3[6], (ImageView)object3Arr3[7], (ql)object3Arr3[3], (ImageView)object3Arr3[i12]);
        obj20.U = -1;
        int i10 = 0;
        obj20.O.setTag(i10);
        obj20.P.setTag(i10);
        L(obj20.Q);
        obj20.R.setTag(i10);
        N(view2);
        b bVar = new b(this, i12);
        obj20.T = bVar;
        A();
    }

    private boolean W(app.dogo.com.dogo_android.h.ql ql, int i2) {
        if (i2 == 0) {
            this.U = obj3 |= i;
            return 1;
            synchronized (this) {
                this.U = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(LiveData<y<RecommendedOrderedPrograms>> liveData, int i2) {
        if (i2 == 0) {
            this.U = obj3 |= i;
            return 1;
            synchronized (this) {
                this.U = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.wa
    public void A() {
        this.U = 8;
        this.Q.A();
        I();
        return;
        synchronized (this) {
            this.U = 8;
            this.Q.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wa
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((LiveData)object2, i3);
        }
        return W((ql)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.wa
    public void M(q q) {
        super.M(q);
        this.Q.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.wa
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((h)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.wa
    public void V(h h) {
        this.S = h;
        this.U = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = h;
            this.U = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wa
    public final void b(int i, View view2) {
        int obj2;
        final h obj1 = this.S;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.n();
        }
    }

    @Override // app.dogo.com.dogo_android.h.wa
    protected void m() {
        int cmp;
        String str;
        int valueOf;
        h result;
        int i;
        int i2;
        long l = this.U;
        valueOf = 0;
        this.U = valueOf;
        result = this.S;
        int cmp2 = Long.compare(i7, valueOf);
        synchronized (this) {
            l = this.U;
            valueOf = 0;
            this.U = valueOf;
            result = this.S;
            cmp2 = Long.compare(i7, valueOf);
        }
        try {
            if (result != null) {
            } else {
            }
            result = result.getResult();
            result = i;
            Q(1, result);
            if (result != null) {
            }
            i = result;
            if (cmp2 != 0) {
            }
            n.F0(this.O, i);
            n.C0(this.P, i);
        }
        if (Long.compare(i3, valueOf) != 0) {
            this.P.setOnClickListener(this.T);
            int i4 = 4;
            this.Q.T(Integer.valueOf(i4));
            this.Q.U(Integer.valueOf(i4));
            n.B0(this.R, "walking_dog");
        }
        ViewDataBinding.o(this.Q);
    }

    @Override // app.dogo.com.dogo_android.h.wa
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
