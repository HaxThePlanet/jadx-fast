package app.dogo.com.dogo_android.h;

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
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class d4 extends app.dogo.com.dogo_android.h.c4 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private long S;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        d4.U = sparseIntArray;
        sparseIntArray.put(2131362211, 3);
        sparseIntArray.put(2131363418, 4);
    }

    public d4(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 5, d4.T, d4.U));
    }

    private d4(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[3], (CardView)object3Arr3[0], (ImageView)object3Arr3[1], (TextView)object3Arr3[2], (Guideline)object3Arr3[4]);
        this.S = -1;
        int obj13 = 0;
        this.O.setTag(obj13);
        this.P.setTag(obj13);
        this.Q.setTag(obj13);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c4
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c4
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.c4
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((ProgramDescriptionItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.c4
    public void V(ProgramDescriptionItem programDescriptionItem) {
        this.R = programDescriptionItem;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = programDescriptionItem;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c4
    protected void m() {
        int cmp;
        int i;
        int i2;
        int i3;
        String str;
        int i5 = 0;
        this.S = i5;
        final ProgramDescriptionItem programDescriptionItem = this.R;
        cmp = Long.compare(i4, i5);
        synchronized (this) {
            i5 = 0;
            this.S = i5;
            programDescriptionItem = this.R;
            cmp = Long.compare(i4, i5);
        }
        try {
            if (programDescriptionItem != null) {
            } else {
            }
            i2 = iconUrl;
            i = cardBackgroundColor;
            i3 = str;
            i3 = i2;
            if (cmp != 0) {
            }
            n.E(this.O, i);
            n.w(this.P, i2);
            g.c(this.Q, i3);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.c4
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
