package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.f.k.h;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.WorkoutSession;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class ra extends app.dogo.com.dogo_android.h.qa implements b.a {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final CoordinatorLayout T;
    private final ConstraintLayout U;
    private final View.OnClickListener V;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        ra.Y = sparseIntArray;
        sparseIntArray.put(2131363433, 4);
        sparseIntArray.put(2131362649, 5);
        sparseIntArray.put(2131362645, 6);
        sparseIntArray.put(2131362338, 7);
        sparseIntArray.put(2131362111, 8);
        sparseIntArray.put(2131362662, 9);
        sparseIntArray.put(2131363414, 10);
        sparseIntArray.put(2131362298, 11);
        sparseIntArray.put(2131363421, 12);
        sparseIntArray.put(2131362063, 13);
    }

    public ra(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 14, ra.X, ra.Y));
    }

    private ra(e e, View view2, Object[] object3Arr3) {
        Object obj29 = this;
        super(e, view2, 1, (Space)object3Arr3[13], (ConstraintLayout)object3Arr3[8], (TextView)object3Arr3[11], (ImageView)object3Arr3[7], (Guideline)object3Arr3[6], (Guideline)object3Arr3[5], (ImageView)object3Arr3[9], (Button)object3Arr3[2], (TextView)object3Arr3[10], (TextView)object3Arr3[12], (MaterialToolbar)object3Arr3[4], (RecyclerView)object3Arr3[3]);
        Object obj16 = this;
        obj16.W = -1;
        Object obj14 = object3Arr3[0];
        obj16.T = (CoordinatorLayout)obj14;
        int i16 = 0;
        obj14.setTag(i16);
        int i15 = 1;
        Object obj17 = object3Arr3[i15];
        obj16.U = (ConstraintLayout)obj17;
        obj17.setTag(i16);
        obj16.P.setTag(i16);
        obj16.R.setTag(i16);
        obj16.N(view2);
        b bVar = new b(obj16, i15);
        obj16.V = bVar;
        A();
    }

    private boolean W(LiveData<y<WorkoutSession>> liveData, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.qa
    public void A() {
        this.W = 4;
        I();
        return;
        synchronized (this) {
            this.W = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qa
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return W((LiveData)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.qa
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

    @Override // app.dogo.com.dogo_android.h.qa
    public void V(h h) {
        this.S = h;
        this.W = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = h;
            this.W = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qa
    public final void b(int i, View view2) {
        int i2;
        int obj4;
        final h obj3 = this.S;
        final int i3 = 0;
        i2 = obj3 != null ? obj4 : i3;
        if (i2 != 0) {
            i2 = obj3.i();
            if (i2 != null) {
            } else {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.o((y)i2.getValue());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.qa
    protected void m() {
        int cmp2;
        View.OnClickListener list;
        int value;
        h hVar;
        int cmp;
        int i;
        long l = this.W;
        final int i3 = 0;
        this.W = i3;
        hVar = this.S;
        cmp = Long.compare(i6, i3);
        final int i7 = 0;
        synchronized (this) {
            l = this.W;
            i3 = 0;
            this.W = i3;
            hVar = this.S;
            cmp = Long.compare(i6, i3);
            i7 = 0;
        }
        try {
            if (hVar != null) {
            } else {
            }
            hVar = hVar.i();
            hVar = i7;
            Q(0, hVar);
            if (hVar != 0) {
            } else {
            }
            value = hVar.getValue();
            value = i7;
        }
        n.F0(this.T, value);
        i.E(this.R, value);
        if (Long.compare(i2, i3) != 0) {
            n.k0(this.U, i7);
            this.P.setOnClickListener(this.V);
        }
    }

    @Override // app.dogo.com.dogo_android.h.qa
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
