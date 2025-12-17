package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.g.z;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class bj extends app.dogo.com.dogo_android.h.aj implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final View.OnClickListener T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        bj.W = sparseIntArray;
        sparseIntArray.put(2131363418, 3);
    }

    public bj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, bj.V, bj.W));
    }

    private bj(e e, View view2, Object[] object3Arr3) {
        int i2 = 1;
        super(e, view2, 0, (CardView)object3Arr3[0], (ImageView)object3Arr3[i2], (TextView)object3Arr3[2], (Guideline)object3Arr3[3]);
        this.U = -1;
        int obj12 = 0;
        this.O.setTag(obj12);
        this.P.setTag(obj12);
        this.Q.setTag(obj12);
        N(view2);
        b obj10 = new b(this, i2);
        this.T = obj10;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.aj
    public void A() {
        this.U = 4;
        I();
        return;
        synchronized (this) {
            this.U = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.aj
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.aj
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            U((ProgramDescriptionItem)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                T((o)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.aj
    public void T(o o) {
        this.S = o;
        this.U = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.S = o;
            this.U = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.aj
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.R = programDescriptionItem;
        this.U = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = programDescriptionItem;
            this.U = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.aj
    public final void b(int i, View view2) {
        int i2;
        int i3;
        Object obj4;
        obj4 = this.R;
        final o obj5 = this.S;
        final int i4 = 0;
        i3 = obj5 != null ? i2 : i4;
        if (i3 != 0) {
            if (obj4 != null) {
            } else {
                i2 = i4;
            }
            if (i2 != 0) {
                obj5.L0(obj4.getId());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.aj
    protected void m() {
        int cmp2;
        View.OnClickListener list;
        int i;
        int cmp;
        int i2;
        int name;
        String str;
        long l = this.U;
        final int i4 = 0;
        this.U = i4;
        ProgramDescriptionItem programDescriptionItem = this.R;
        cmp = Long.compare(i7, i4);
        synchronized (this) {
            l = this.U;
            i4 = 0;
            this.U = i4;
            programDescriptionItem = this.R;
            cmp = Long.compare(i7, i4);
        }
        try {
            if (programDescriptionItem != null) {
            } else {
            }
            name = programDescriptionItem.getName();
            i2 = cardBackgroundColor;
            i = str;
            name = i;
            if (cmp != 0) {
            }
            n.E(this.O, i2);
            n.w(this.P, i);
            g.c(this.Q, name);
            if (Long.compare(i3, i4) != 0) {
            }
            this.O.setOnClickListener(this.T);
        }
    }

    @Override // app.dogo.com.dogo_android.h.aj
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
