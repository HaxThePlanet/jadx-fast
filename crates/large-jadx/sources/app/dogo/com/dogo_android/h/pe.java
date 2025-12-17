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
import app.dogo.com.dogo_android.o.e;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class pe extends app.dogo.com.dogo_android.h.oe {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout R;
    private final ConstraintLayout S;
    private final FrameLayout T;
    private final app.dogo.com.dogo_android.h.ok U;
    private long V;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(18);
        pe.W = gVar;
        int i16 = 1;
        final int[] iArr2 = new int[i16];
        final int i34 = 0;
        iArr2[i34] = 3;
        int[] iArr = new int[i16];
        iArr[i34] = 2131558775;
        gVar.a(2, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        pe.X = sparseIntArray;
        sparseIntArray.put(2131363433, 4);
        sparseIntArray.put(2131362886, 5);
        sparseIntArray.put(2131363414, 6);
        sparseIntArray.put(2131362020, 7);
        sparseIntArray.put(2131362023, 8);
        sparseIntArray.put(2131362022, 9);
        sparseIntArray.put(2131362026, 10);
        sparseIntArray.put(2131362029, 11);
        sparseIntArray.put(2131362028, 12);
        sparseIntArray.put(2131362033, 13);
        sparseIntArray.put(2131362036, 14);
        sparseIntArray.put(2131362035, 15);
        sparseIntArray.put(2131362322, 16);
        sparseIntArray.put(2131361903, 17);
    }

    public pe(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 18, pe.W, pe.X));
    }

    private pe(e e, View view2, Object[] object3Arr3) {
        Object obj8 = this;
        super(e, view2, 1, (Button)object3Arr3[17], (ImageView)object3Arr3[7], (TextView)object3Arr3[9], (TextView)object3Arr3[8], (ImageView)object3Arr3[10], (TextView)object3Arr3[12], (TextView)object3Arr3[11], (ImageView)object3Arr3[13], (TextView)object3Arr3[15], (TextView)object3Arr3[14], (ImageView)object3Arr3[16], (ImageView)object3Arr3[5], (TextView)object3Arr3[6], (MaterialToolbar)object3Arr3[4]);
        Object obj7 = this;
        obj7.V = -1;
        Object obj2 = object3Arr3[0];
        obj7.R = (ConstraintLayout)obj2;
        int i6 = 0;
        obj2.setTag(i6);
        Object obj3 = object3Arr3[1];
        obj7.S = (ConstraintLayout)obj3;
        obj3.setTag(i6);
        Object obj4 = object3Arr3[2];
        obj7.T = (FrameLayout)obj4;
        obj4.setTag(i6);
        Object obj5 = object3Arr3[3];
        obj7.U = (ok)obj5;
        obj7.L(obj5);
        obj7.N(view2);
        A();
    }

    private boolean W(LiveData<y<Boolean>> liveData, int i2) {
        if (i2 == 0) {
            this.V = obj3 |= i;
            return 1;
            synchronized (this) {
                this.V = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.oe
    public void A() {
        this.V = 4;
        this.U.A();
        I();
        return;
        synchronized (this) {
            this.V = 4;
            this.U.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oe
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.oe
    public void M(q q) {
        super.M(q);
        this.U.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.oe
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((e)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.oe
    public void V(e e) {
        this.Q = e;
        this.V = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Q = e;
            this.V = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oe
    protected void m() {
        int cmp2;
        int value;
        e eVar;
        int cmp;
        int i;
        long l = this.V;
        final int i3 = 0;
        this.V = i3;
        eVar = this.Q;
        cmp = Long.compare(i6, i3);
        final int i7 = 0;
        synchronized (this) {
            l = this.V;
            i3 = 0;
            this.V = i3;
            eVar = this.Q;
            cmp = Long.compare(i6, i3);
            i7 = 0;
        }
        try {
            if (eVar != null) {
            } else {
            }
            eVar = eVar.i();
            eVar = i7;
            Q(0, eVar);
            if (eVar != 0) {
            } else {
            }
            value = eVar.getValue();
            value = i7;
        }
        n.F0(this.R, value);
        n.D0(this.T, value);
        if (Long.compare(i2, i3) != 0) {
            n.k0(this.S, i7);
        }
        ViewDataBinding.o(this.U);
    }

    @Override // app.dogo.com.dogo_android.h.oe
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.U.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
