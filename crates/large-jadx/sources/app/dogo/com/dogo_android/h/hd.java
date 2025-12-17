package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.r.e;
import d.a.k.a.a;

/* loaded from: classes.dex */
public class hd extends app.dogo.com.dogo_android.h.gd {

    private static final ViewDataBinding.g d0;
    private static final SparseIntArray e0;
    private long c0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        hd.e0 = sparseIntArray;
        sparseIntArray.put(2131362193, 5);
        sparseIntArray.put(2131361872, 6);
        sparseIntArray.put(2131363456, 7);
        sparseIntArray.put(2131363314, 8);
        sparseIntArray.put(2131362510, 9);
        sparseIntArray.put(2131363201, 10);
        sparseIntArray.put(2131362530, 11);
        sparseIntArray.put(2131362496, 12);
        sparseIntArray.put(2131361927, 13);
        sparseIntArray.put(2131363037, 14);
        sparseIntArray.put(2131363534, 15);
        sparseIntArray.put(2131363154, 16);
    }

    public hd(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 17, hd.d0, hd.e0));
    }

    private hd(e e, View view2, Object[] object3Arr3) {
        Object obj4 = this;
        super(e, view2, 0, (ImageView)object3Arr3[6], (AnimatedTextView)object3Arr3[13], (ImageView)object3Arr3[5], (TextView)object3Arr3[12], (TextView)object3Arr3[9], (TextView)object3Arr3[11], (ConstraintLayout)object3Arr3[0], (CardView)object3Arr3[14], (ImageView)object3Arr3[16], (TextView)object3Arr3[10], (TextView)object3Arr3[8], (TextView)object3Arr3[2], (TextView)object3Arr3[7], (ImageView)object3Arr3[1], (ImageView)object3Arr3[3], (TextView)object3Arr3[15], (TextView)object3Arr3[4]);
        Object obj3 = this;
        obj3.c0 = -1;
        int i2 = 0;
        obj3.T.setTag(i2);
        obj3.X.setTag(i2);
        obj3.Y.setTag(i2);
        obj3.Z.setTag(i2);
        obj3.a0.setTag(i2);
        obj3.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.gd
    public void A() {
        this.c0 = 4;
        I();
        return;
        synchronized (this) {
            this.c0 = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gd
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.gd
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (166 == i) {
            V((TrickItem)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((e)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.gd
    public void V(TrickItem trickItem) {
        this.b0 = trickItem;
        this.c0 = l |= i2;
        notifyPropertyChanged(166);
        super.I();
        return;
        synchronized (this) {
            this.b0 = trickItem;
            this.c0 = l |= i2;
            notifyPropertyChanged(166);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gd
    public void W(e e) {
    }

    @Override // app.dogo.com.dogo_android.h.gd
    protected void m() {
        int cmp2;
        android.graphics.drawable.Drawable drawable;
        int i4;
        int i6;
        int cmp;
        int i5;
        int i;
        int i2;
        Object[] arr;
        int i3;
        String str;
        long l = this.c0;
        i4 = 0;
        this.c0 = i4;
        TrickItem trickItem = this.b0;
        cmp = Long.compare(i10, i4);
        i5 = 0;
        synchronized (this) {
            l = this.c0;
            i4 = 0;
            this.c0 = i4;
            trickItem = this.b0;
            cmp = Long.compare(i10, i4);
            i5 = 0;
        }
        try {
            if (trickItem != null) {
            } else {
            }
            i5 = name;
            i6 = str;
            i6 = i5;
            arr = new Object[1];
            i = i5;
            i5 = str;
            i = i6;
            if (cmp != 0) {
            }
            g.c(this.X, i5);
            n.n0(this.Z, i6);
            g.c(this.a0, i);
        }
        if (Long.compare(i7, i4) != 0) {
            cmp2 = this.Y;
            n.z(cmp2, a.d(cmp2.getContext(), 2131231318));
        }
    }

    @Override // app.dogo.com.dogo_android.h.gd
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
