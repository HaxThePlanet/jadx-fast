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
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.g.y;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;

/* loaded from: classes.dex */
public class pj extends app.dogo.com.dogo_android.h.oj implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final CardView R;
    private final View.OnClickListener S;
    private final View.OnClickListener T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        pj.W = sparseIntArray;
        sparseIntArray.put(2131363414, 3);
        sparseIntArray.put(2131362298, 4);
        sparseIntArray.put(2131362572, 5);
        sparseIntArray.put(2131362574, 6);
        sparseIntArray.put(2131362575, 7);
        sparseIntArray.put(2131362577, 8);
        sparseIntArray.put(2131362578, 9);
        sparseIntArray.put(2131362478, 10);
    }

    public pj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 11, pj.V, pj.W));
    }

    private pj(e e, View view2, Object[] object3Arr3) {
        final Object obj24 = this;
        final int i15 = 1;
        super(e, view2, 0, (ImageView)object3Arr3[i15], (TextView)object3Arr3[4], (TextView)object3Arr3[10], (ImageView)object3Arr3[5], (TextView)object3Arr3[6], (TextView)object3Arr3[7], (TextView)object3Arr3[8], (TextView)object3Arr3[9], (MaterialButton)object3Arr3[2], (TextView)object3Arr3[3]);
        obj24.U = -1;
        int i11 = 0;
        obj24.O.setTag(i11);
        Object obj12 = object3Arr3[0];
        obj24.R = (CardView)obj12;
        obj12.setTag(i11);
        obj24.P.setTag(i11);
        obj24.N(view2);
        b bVar = new b(obj24, i15);
        obj24.S = bVar;
        b bVar2 = new b(obj24, 2);
        obj24.T = bVar2;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.oj
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oj
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.oj
    public boolean O(int i, Object object2) {
        int obj2;
        if (29 == i) {
            T((o)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.oj
    public void T(o o) {
        this.Q = o;
        this.U = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Q = o;
            this.U = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oj
    public final void b(int i, View view2) {
        int i2;
        o obj3;
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
                    obj3.a0();
                }
            }
        } else {
            obj3 = this.Q;
            if (obj3 != null) {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.A();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.oj
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

    @Override // app.dogo.com.dogo_android.h.oj
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
