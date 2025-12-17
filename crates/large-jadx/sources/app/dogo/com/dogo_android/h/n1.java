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
import androidx.databinding.k.b;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.u.n.p.e;
import app.dogo.com.dogo_android.u.n.p.g.a;

/* loaded from: classes.dex */
public class n1 extends app.dogo.com.dogo_android.h.m1 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        n1.V = sparseIntArray;
        sparseIntArray.put(2131362731, 3);
        sparseIntArray.put(2131362345, 4);
    }

    public n1(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, n1.U, n1.V));
    }

    private n1(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (DogLogView)object3Arr3[4], (LinearLayout)object3Arr3[3], (TextView)object3Arr3[1], (TextView)object3Arr3[2]);
        this.T = -1;
        Object obj10 = object3Arr3[0];
        this.S = (ConstraintLayout)obj10;
        final int obj12 = 0;
        obj10.setTag(obj12);
        this.P.setTag(obj12);
        this.Q.setTag(obj12);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.m1
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m1
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.m1
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((g.a)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.m1
    public void V(g.a g$a) {
        this.R = a;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = a;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.m1
    protected void m() {
        long l;
        int cmp;
        int i12;
        Integer valueOf;
        int i;
        int i5;
        String i2;
        int i3;
        int i6;
        int i9;
        int i7;
        StringBuilder stringBuilder;
        int i11;
        int i8;
        int i4;
        int i10;
        l = this.T;
        final int i16 = 0;
        this.T = i16;
        g.a aVar = this.R;
        i2 = 0;
        final int i17 = 3;
        int cmp2 = Long.compare(i18, i16);
        i9 = 0;
        synchronized (this) {
            l = this.T;
            i16 = 0;
            this.T = i16;
            aVar = this.R;
            i2 = 0;
            i17 = 3;
            cmp2 = Long.compare(i18, i16);
            i9 = 0;
        }
        try {
            if (aVar != null) {
            } else {
            }
            i9 = aVar.g();
            i3 = aVar.f();
            i5 = aVar.b();
            i3 = i5;
            if (i9 != 0) {
            } else {
            }
            i14 |= i22;
            stringBuilder = 128;
            i15 |= i24;
            stringBuilder = 64;
        }
        i11 = i9 != 0 ? R.color.calendar_active : R.color.white;
        int i20 = 2131100352;
        i8 = 2131099840;
        TextView view6 = this.Q;
        if (i9 != 0) {
            i4 = ViewDataBinding.u(view6, i20);
        } else {
            i4 = ViewDataBinding.u(view6, i8);
        }
        if (i9 != 0) {
            i7 = ViewDataBinding.u(this.P, i20);
        } else {
            i7 = ViewDataBinding.u(this.P, i8);
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(i5);
        stringBuilder.append("");
        i2 = string;
        i = i7;
        i9 = i19;
        i6 = i10;
        if (Long.compare(i13, i16) != 0) {
            h.a(this.S, b.b(i9));
            this.P.setTextColor(i);
            g.c(this.P, i2);
            this.Q.setTextColor(i4);
            e.s(this.Q, Integer.valueOf(i6));
        }
    }

    @Override // app.dogo.com.dogo_android.h.m1
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
