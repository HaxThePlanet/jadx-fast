package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.e0.e;

/* loaded from: classes.dex */
public class fg extends app.dogo.com.dogo_android.h.eg {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        fg.X = sparseIntArray;
        sparseIntArray.put(2131362628, 4);
        sparseIntArray.put(2131363459, 5);
        sparseIntArray.put(2131362564, 6);
        sparseIntArray.put(2131362721, 7);
        sparseIntArray.put(2131362897, 8);
    }

    public fg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, fg.W, fg.X));
    }

    private fg(e e, View view2, Object[] object3Arr3) {
        final Object obj20 = this;
        super(e, view2, 0, (TextView)object3Arr3[3], (TextView)object3Arr3[6], (ImageView)object3Arr3[4], (MaterialButton)object3Arr3[7], (TextView)object3Arr3[8], (TextView)object3Arr3[1], (TextView)object3Arr3[5], (ImageView)object3Arr3[2]);
        obj20.V = -1;
        int i11 = 0;
        obj20.O.setTag(i11);
        Object obj10 = object3Arr3[0];
        obj20.U = (ConstraintLayout)obj10;
        obj10.setTag(i11);
        obj20.R.setTag(i11);
        obj20.S.setTag(i11);
        View view5 = view2;
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.eg
    public void A() {
        this.V = 2;
        I();
        return;
        synchronized (this) {
            this.V = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.eg
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.eg
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

    @Override // app.dogo.com.dogo_android.h.eg
    public void V(e e) {
        this.T = e;
        this.V = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = e;
            this.V = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.eg
    protected void m() {
        int cmp;
        int i6;
        String str;
        int i7;
        int i;
        int i2;
        int description;
        Object resources;
        int i3;
        Object[] arr;
        int i4;
        int i5;
        int i9 = 0;
        this.V = i9;
        resources = this.T;
        cmp = Long.compare(i8, i9);
        i6 = 0;
        synchronized (this) {
            i9 = 0;
            this.V = i9;
            resources = this.T;
            cmp = Long.compare(i8, i9);
            i6 = 0;
        }
        try {
            if (resources != null) {
            } else {
            }
            i7 = resources.h();
            i7 = i6;
            if (i7 != 0) {
            } else {
            }
            description = i7.getDescription();
            i = imageUrl;
            i6 = i5;
            description = i;
            arr = new Object[1];
            str = string;
            i6 = description;
            i2 = i5;
        }
        if (cmp != 0) {
            g.c(this.O, i6);
            g.c(this.R, str);
            n.n0(this.S, i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.eg
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
