package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.g.e0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;

/* loaded from: classes.dex */
public class jk extends app.dogo.com.dogo_android.h.ik implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final CardView R;
    private final View.OnClickListener S;
    private final View.OnClickListener T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        jk.W = sparseIntArray;
        sparseIntArray.put(2131362633, 3);
        sparseIntArray.put(2131362711, 4);
        sparseIntArray.put(2131363414, 5);
        sparseIntArray.put(2131362298, 6);
        sparseIntArray.put(2131363156, 7);
    }

    public jk(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, jk.V, jk.W));
    }

    private jk(e e, View view2, Object[] object3Arr3) {
        final Object obj17 = this;
        final int i10 = 1;
        final int i11 = 2;
        super(e, view2, 0, (TextView)object3Arr3[6], (ImageView)object3Arr3[3], (ImageView)object3Arr3[i10], (ImageView)object3Arr3[4], (ImageView)object3Arr3[7], (Button)object3Arr3[i11], (TextView)object3Arr3[5]);
        obj17.U = -1;
        int i8 = 0;
        obj17.O.setTag(i8);
        Object obj8 = object3Arr3[0];
        obj17.R = (CardView)obj8;
        obj8.setTag(i8);
        obj17.P.setTag(i8);
        N(view2);
        b bVar = new b(this, i10);
        obj17.S = bVar;
        b bVar2 = new b(this, i11);
        obj17.T = bVar2;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ik
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ik
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ik
    public boolean O(int i, Object object2) {
        int obj2;
        if (29 == i) {
            T((e0)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ik
    public void T(e0 e0) {
        this.Q = e0;
        this.U = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Q = e0;
            this.U = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ik
    public final void b(int i, View view2) {
        int i2;
        e0 obj3;
        int obj4;
        obj4 = 0;
        final int i3 = 1;
        if (i != i3) {
            if (i != 2) {
            } else {
                obj3 = this.Q;
                if (obj3 != null) {
                    obj4 = i3;
                }
                if (obj4 != null) {
                    obj3.m0();
                }
            }
        } else {
            obj3 = this.Q;
            if (obj3 != null) {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.f1();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ik
    protected void m() {
        int cmp;
        View.OnClickListener list;
        final int i2 = 0;
        this.U = i2;
        synchronized (this) {
            i2 = 0;
            this.U = i2;
        }
        try {
            this.O.setOnClickListener(this.S);
            this.P.setOnClickListener(this.T);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ik
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
