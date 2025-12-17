package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.Program;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class hm extends app.dogo.com.dogo_android.h.gm {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        hm.U = sparseIntArray;
        sparseIntArray.put(2131361940, 3);
    }

    public hm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, hm.T, hm.U));
    }

    private hm(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[3], (ImageView)object3Arr3[1], (CardView)object3Arr3[0], (TextView)object3Arr3[2]);
        this.S = -1;
        int obj12 = 0;
        this.O.setTag(obj12);
        this.P.setTag(obj12);
        this.Q.setTag(obj12);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.gm
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gm
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.gm
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            T((Program)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.gm
    public void T(Program program) {
        this.R = program;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = program;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gm
    protected void m() {
        long l;
        int cmp;
        String str;
        int i3;
        int cmp2;
        int i5;
        int i2;
        Object[] arr;
        Resources resources;
        int i4;
        int i;
        String str2;
        l = this.S;
        final int i7 = 0;
        this.S = i7;
        Program program = this.R;
        final int i8 = 3;
        cmp2 = Long.compare(i9, i7);
        i5 = 0;
        i2 = 0;
        synchronized (this) {
            l = this.S;
            i7 = 0;
            this.S = i7;
            program = this.R;
            i8 = 3;
            cmp2 = Long.compare(i9, i7);
            i5 = 0;
            i2 = 0;
        }
        try {
            int i10 = 1;
            if (program != null) {
            } else {
            }
            i4 = i10;
            i4 = i2;
            if (i4 != 0) {
            } else {
            }
            i = 8;
            i = 4;
        }
        if (program != null) {
            i5 = name;
            i3 = str2;
        } else {
            i3 = i5;
        }
        cmp2 = i4 != 0 ? i2 : 8;
        arr = new Object[i10];
        arr[i2] = i5;
        i2 = cmp2;
        i5 = i3;
        str = str2;
        if (Long.compare(i6, i7) != 0) {
            n.w(this.O, i5);
            this.P.setVisibility(i2);
            g.c(this.Q, str);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gm
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
