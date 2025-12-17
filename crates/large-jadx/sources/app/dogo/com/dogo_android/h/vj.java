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
import app.dogo.com.dogo_android.g.z;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class vj extends app.dogo.com.dogo_android.h.uj implements b.a {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout S;
    private final View.OnClickListener T;
    private final View.OnClickListener U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        vj.X = sparseIntArray;
        sparseIntArray.put(2131362790, 3);
        sparseIntArray.put(2131363414, 4);
        sparseIntArray.put(2131362711, 5);
        sparseIntArray.put(2131362298, 6);
        sparseIntArray.put(2131363156, 7);
    }

    public vj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, vj.W, vj.X));
    }

    private vj(e e, View view2, Object[] object3Arr3) {
        final Object obj17 = this;
        final int i10 = 1;
        final int i11 = 2;
        super(e, view2, 0, (TextView)object3Arr3[6], (ImageView)object3Arr3[5], (ImageView)object3Arr3[3], (CardView)object3Arr3[i10], (Button)object3Arr3[i11], (ImageView)object3Arr3[7], (TextView)object3Arr3[4]);
        obj17.V = -1;
        Object obj8 = object3Arr3[0];
        obj17.S = (ConstraintLayout)obj8;
        int i8 = 0;
        obj8.setTag(i8);
        obj17.O.setTag(i8);
        obj17.P.setTag(i8);
        N(view2);
        b bVar = new b(this, i10);
        obj17.T = bVar;
        b bVar2 = new b(this, i11);
        obj17.U = bVar2;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.uj
    public void A() {
        this.V = 4;
        I();
        return;
        synchronized (this) {
            this.V = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uj
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.uj
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

    @Override // app.dogo.com.dogo_android.h.uj
    public void T(o o) {
        this.R = o;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.R = o;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uj
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.Q = programDescriptionItem;
        this.V = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = programDescriptionItem;
            this.V = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uj
    public final void b(int i, View view2) {
        o oVar;
        int i2;
        ProgramDescriptionItem obj4;
        int obj5;
        obj5 = 0;
        final int i3 = 1;
        if (i != i3) {
            if (i != 2) {
            } else {
                obj4 = this.Q;
                oVar = this.R;
                i2 = oVar != null ? i3 : obj5;
                if (i2 != 0 && obj4 != null) {
                    if (obj4 != null) {
                        obj5 = i3;
                    }
                    if (obj5 != null) {
                        oVar.L0(obj4.getId());
                    }
                }
            }
        } else {
            obj4 = this.Q;
            oVar = this.R;
            i2 = oVar != null ? i3 : obj5;
            if (i2 != 0 && obj4 != null) {
                if (obj4 != null) {
                    obj5 = i3;
                }
                if (obj5 != null) {
                    oVar.L0(obj4.getId());
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.uj
    protected void m() {
        int cmp;
        View.OnClickListener list;
        int cardBackgroundColor;
        long l = this.V;
        final int i2 = 0;
        this.V = i2;
        final ProgramDescriptionItem programDescriptionItem = this.Q;
        cardBackgroundColor = 0;
        int cmp2 = Long.compare(i4, i2);
        synchronized (this) {
            l = this.V;
            i2 = 0;
            this.V = i2;
            programDescriptionItem = this.Q;
            cardBackgroundColor = 0;
            cmp2 = Long.compare(i4, i2);
        }
        try {
            if (programDescriptionItem != null) {
            }
            cardBackgroundColor = programDescriptionItem.getCardBackgroundColor();
            if (Long.compare(i, i2) != 0) {
            }
            this.O.setOnClickListener(this.T);
            this.P.setOnClickListener(this.U);
            if (cmp2 != 0) {
            }
            n.E(this.O, cardBackgroundColor);
        }
    }

    @Override // app.dogo.com.dogo_android.h.uj
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
