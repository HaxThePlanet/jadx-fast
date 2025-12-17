package app.dogo.com.dogo_android.h;

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
import app.dogo.com.dogo_android.f.i;
import app.dogo.com.dogo_android.n.f;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class h3 extends app.dogo.com.dogo_android.h.g3 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private final ConstraintLayout S;
    private long T;
    static {
    }

    public h3(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, h3.U, h3.V));
    }

    private h3(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[2], (ImageView)object3Arr3[1], (TextView)object3Arr3[3]);
        this.T = -1;
        Object obj9 = object3Arr3[0];
        this.S = (ConstraintLayout)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        this.O.setTag(obj11);
        this.P.setTag(obj11);
        this.Q.setTag(obj11);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.g3
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g3
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.g3
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            W((TrickItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.g3
    public void W(TrickItem trickItem) {
        this.R = trickItem;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = trickItem;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.g3
    protected void m() {
        long l;
        int cmp;
        int imageUrl;
        int i;
        int cmp2;
        int i3;
        int knowledge;
        int ratingBarVisible;
        int i2;
        l = this.T;
        final int i5 = 0;
        this.T = i5;
        imageUrl = 0;
        final TrickItem trickItem = this.R;
        final int i6 = 3;
        cmp2 = Long.compare(i7, i5);
        i3 = 0;
        synchronized (this) {
            l = this.T;
            i5 = 0;
            this.T = i5;
            imageUrl = 0;
            trickItem = this.R;
            i6 = 3;
            cmp2 = Long.compare(i7, i5);
            i3 = 0;
        }
        try {
            if (trickItem != null) {
            } else {
            }
            imageUrl = trickItem.getImageUrl();
            knowledge = trickItem.getKnowledge();
            ratingBarVisible = trickItem.getRatingBarVisible();
            ratingBarVisible = knowledge;
            if (ratingBarVisible != 0) {
            } else {
            }
            i2 = 8;
            i2 = 4;
        }
        if (ratingBarVisible != 0) {
        } else {
            i3 = cmp2;
        }
        i = i3;
        i3 = knowledge;
        if (Long.compare(i4, i5) != 0) {
            i.F(this.O, i3);
            this.O.setVisibility(i);
            n.n0(this.P, imageUrl);
            f.r(this.Q, trickItem);
        }
    }

    @Override // app.dogo.com.dogo_android.h.g3
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
