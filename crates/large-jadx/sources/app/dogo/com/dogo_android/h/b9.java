package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.q.f.a;
import app.dogo.com.dogo_android.q.q.j;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class b9 extends app.dogo.com.dogo_android.h.a9 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        b9.V = sparseIntArray;
        sparseIntArray.put(2131362591, 3);
        sparseIntArray.put(2131362876, 4);
        sparseIntArray.put(2131362322, 5);
        sparseIntArray.put(2131362336, 6);
        sparseIntArray.put(2131362965, 7);
        sparseIntArray.put(2131362884, 8);
    }

    public b9(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, b9.U, b9.V));
    }

    private b9(e e, View view2, Object[] object3Arr3) {
        final Object obj21 = this;
        super(e, view2, 1, (View)object3Arr3[2], (ConstraintLayout)object3Arr3[0], (ImageView)object3Arr3[5], (ImageView)object3Arr3[6], (Guideline)object3Arr3[3], (NestedScrollView)object3Arr3[4], (TextView)object3Arr3[8], (ImageView)object3Arr3[7], (RecyclerView)object3Arr3[1]);
        obj21.T = -1;
        int i11 = 0;
        obj21.O.setTag(i11);
        obj21.P.setTag(i11);
        obj21.Q.setTag(i11);
        N(view2);
        A();
    }

    private boolean X(LiveData<y<Boolean>> liveData, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.a9
    public void A() {
        this.T = 8;
        I();
        return;
        synchronized (this) {
            this.T = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a9
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return X((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.a9
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            W((j)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                V((f.a)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.a9
    public void V(f.a f$a) {
        this.S = a;
        this.T = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.S = a;
            this.T = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a9
    public void W(j j) {
        this.R = j;
        this.T = l |= i2;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            this.R = j;
            this.T = l |= i2;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a9
    protected void m() {
        int cmp2;
        int i2;
        int cmp;
        int cmp3;
        int i;
        int result;
        int value;
        int cmp4;
        long l = this.T;
        final int i4 = 0;
        this.T = i4;
        j jVar = this.R;
        final f.a aVar = this.S;
        cmp = Long.compare(i6, i4);
        final int i7 = 14;
        i = 0;
        synchronized (this) {
            l = this.T;
            i4 = 0;
            this.T = i4;
            jVar = this.R;
            aVar = this.S;
            cmp = Long.compare(i6, i4);
            i7 = 14;
            i = 0;
        }
        try {
            if (jVar != null) {
            } else {
            }
            result = jVar.getResult();
            result = i;
            Q(0, result);
            if (result != null) {
            } else {
            }
            value = result.getValue();
            value = i;
        }
        if (jVar != null) {
            i = jVar.j();
        }
        i2 = i;
        i = value;
        if (cmp != 0) {
            o.C(this.O, i, aVar);
        }
        if (Long.compare(i9, i4) != 0) {
            n.F0(this.P, i);
        }
        if (Long.compare(i3, i4) != 0) {
            o.y(this.Q, i2, aVar);
        }
    }

    @Override // app.dogo.com.dogo_android.h.a9
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
