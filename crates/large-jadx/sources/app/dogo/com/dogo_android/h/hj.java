package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.g.v;
import app.dogo.com.dogo_android.g.w;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class hj extends app.dogo.com.dogo_android.h.gj implements b.a {

    private static final ViewDataBinding.g X;
    private static final SparseIntArray Y;
    private final ConstraintLayout T;
    private final View.OnClickListener U;
    private final View.OnClickListener V;
    private long W;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        hj.Y = sparseIntArray;
        sparseIntArray.put(2131362711, 4);
        sparseIntArray.put(2131361988, 5);
        sparseIntArray.put(2131363156, 6);
        sparseIntArray.put(2131363421, 7);
        sparseIntArray.put(2131363306, 8);
    }

    public hj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, hj.X, hj.Y));
    }

    private hj(e e, View view2, Object[] object3Arr3) {
        final Object obj19 = this;
        final int i11 = 1;
        final int i12 = 2;
        super(e, view2, 0, (ImageView)object3Arr3[5], (Button)object3Arr3[3], (ImageView)object3Arr3[4], (CardView)object3Arr3[i11], (ImageView)object3Arr3[6], (TextView)object3Arr3[8], (TextView)object3Arr3[7], (Button)object3Arr3[i12]);
        obj19.W = -1;
        int i9 = 0;
        obj19.O.setTag(i9);
        obj19.P.setTag(i9);
        Object obj9 = object3Arr3[0];
        obj19.T = (ConstraintLayout)obj9;
        obj9.setTag(i9);
        obj19.Q.setTag(i9);
        N(view2);
        b bVar = new b(this, i11);
        obj19.U = bVar;
        b bVar2 = new b(this, i12);
        obj19.V = bVar2;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.gj
    public void A() {
        this.W = 4;
        I();
        return;
        synchronized (this) {
            this.W = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gj
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.gj
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

    @Override // app.dogo.com.dogo_android.h.gj
    public void T(o o) {
        this.S = o;
        this.W = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.S = o;
            this.W = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gj
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.R = programDescriptionItem;
        this.W = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = programDescriptionItem;
            this.W = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.gj
    public final void b(int i, View view2) {
        o oVar;
        ProgramDescriptionItem obj3;
        int obj4;
        obj4 = 0;
        final int i2 = 1;
        if (i != i2) {
            if (i != 2) {
            } else {
                obj3 = this.S;
                if (obj3 != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    obj3.d("program_completion");
                }
            }
        } else {
            oVar = this.S;
            if (oVar != null) {
                obj4 = i2;
            }
            if (obj4 != null) {
                oVar.A1(this.R);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.gj
    protected void m() {
        int cmp;
        View.OnClickListener list;
        int cardBackgroundColor;
        long l = this.W;
        final int i2 = 0;
        this.W = i2;
        final ProgramDescriptionItem programDescriptionItem = this.R;
        cardBackgroundColor = 0;
        int cmp2 = Long.compare(i4, i2);
        synchronized (this) {
            l = this.W;
            i2 = 0;
            this.W = i2;
            programDescriptionItem = this.R;
            cardBackgroundColor = 0;
            cmp2 = Long.compare(i4, i2);
        }
        try {
            if (programDescriptionItem != null) {
            }
            cardBackgroundColor = programDescriptionItem.getCardBackgroundColor();
            if (Long.compare(i, i2) != 0) {
            }
            this.O.setOnClickListener(this.V);
            this.Q.setOnClickListener(this.U);
            if (cmp2 != 0) {
            }
            n.E(this.P, cardBackgroundColor);
        }
    }

    @Override // app.dogo.com.dogo_android.h.gj
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
