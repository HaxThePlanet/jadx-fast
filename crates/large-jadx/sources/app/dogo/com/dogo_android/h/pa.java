package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.n.m.u.k;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.z.d;

/* loaded from: classes.dex */
public class pa extends app.dogo.com.dogo_android.h.oa {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final TextView U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        pa.X = sparseIntArray;
        sparseIntArray.put(2131363480, 3);
        sparseIntArray.put(2131363441, 4);
        sparseIntArray.put(2131363331, 5);
        sparseIntArray.put(2131362120, 6);
    }

    public pa(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, pa.W, pa.X));
    }

    private pa(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 1, (Guideline)object3Arr3[6], (ConstraintLayout)object3Arr3[0], (TabLayout)object3Arr3[5], (MaterialToolbar)object3Arr3[4], (ConstraintLayout)object3Arr3[3], (ViewPager2)object3Arr3[2]);
        this.V = -1;
        int i8 = 0;
        this.O.setTag(i8);
        Object obj12 = object3Arr3[1];
        this.U = (TextView)obj12;
        obj12.setTag(i8);
        this.R.setTag(i8);
        N(view2);
        A();
    }

    private boolean V(x<y<TrickItem>> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.oa
    public void A() {
        this.V = 8;
        I();
        return;
        synchronized (this) {
            this.V = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oa
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0) {
            return 0;
        }
        return V((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.oa
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            W((k)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                X((d)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.oa
    public void W(k k) {
        this.T = k;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.T = k;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oa
    public void X(d d) {
        this.S = d;
        this.V = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.S = d;
            this.V = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oa
    protected void m() {
        int cmp;
        com.google.android.material.tabs.TabLayout tabLayout;
        int i3;
        int value;
        int i;
        int i2;
        int cmp2;
        long l = this.V;
        final int i5 = 0;
        this.V = i5;
        final d dVar = this.S;
        int cmp3 = Long.compare(i7, i5);
        final int i8 = 13;
        i3 = 0;
        synchronized (this) {
            l = this.V;
            i5 = 0;
            this.V = i5;
            dVar = this.S;
            cmp3 = Long.compare(i7, i5);
            i8 = 13;
            i3 = 0;
        }
        try {
            if (dVar != null) {
            } else {
            }
            i = dVar.h();
            i2 = dVar.j();
            i2 = i;
            Q(0, i);
            if (i != 0) {
            } else {
            }
            value = i.getValue();
            value = i3;
        }
        if (dVar != null) {
            i3 = dVar.i(value);
        }
        if (Long.compare(i4, i5) != 0) {
            g.c(this.U, i3);
        }
        if (cmp3 != 0) {
            i.t(this.R, value, this.P, i2, this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.oa
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
