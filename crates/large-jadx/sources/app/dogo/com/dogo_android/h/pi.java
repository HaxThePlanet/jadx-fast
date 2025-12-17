package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.g.o;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramProgressData;

/* loaded from: classes.dex */
public class pi extends app.dogo.com.dogo_android.h.oi {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = null;
    private final ConstraintLayout U;
    private long V;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(4);
        pi.W = gVar;
        int i3 = 2;
        final int[] iArr2 = new int[i3];
        iArr2 = new int[]{2, 3};
        int[] iArr = new int[i3];
        iArr = new int[]{2131558764, 2131558765};
        gVar.a(0, /* result */, iArr2, iArr);
        int i = 0;
    }

    public pi(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 4, pi.W, pi.X));
    }

    private pi(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (uj)object3Arr3[3], (sj)object3Arr3[2], (TextView)object3Arr3[1]);
        this.V = -1;
        L(this.O);
        Object obj9 = object3Arr3[0];
        this.U = (ConstraintLayout)obj9;
        final int obj11 = 0;
        obj9.setTag(obj11);
        L(this.P);
        this.Q.setTag(obj11);
        N(view2);
        A();
    }

    private boolean Y(app.dogo.com.dogo_android.h.uj uj, int i2) {
        if (i2 == 0) {
            this.V = obj3 |= i;
            return 1;
            synchronized (this) {
                this.V = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(app.dogo.com.dogo_android.h.sj sj, int i2) {
        if (i2 == 0) {
            this.V = obj3 |= i;
            return 1;
            synchronized (this) {
                this.V = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public void A() {
        this.V = 32;
        this.P.A();
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.V = 32;
            this.P.A();
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oi
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Z((sj)object2, i3);
        }
        return Y((uj)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public void M(q q) {
        super.M(q);
        this.P.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (50 == i) {
            W((SpecialProgramOverviewItem.ProgramProgressData)object2);
            obj2 = 1;
        } else {
            if (94 == i) {
                X((ProgramDescriptionItem)object2);
            } else {
                if (29 == i) {
                    V((o)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public void V(o o) {
        this.T = o;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.T = o;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public void W(SpecialProgramOverviewItem.ProgramProgressData specialProgramOverviewItem$ProgramProgressData) {
        this.S = programProgressData;
        this.V = l |= i2;
        notifyPropertyChanged(50);
        super.I();
        return;
        synchronized (this) {
            this.S = programProgressData;
            this.V = l |= i2;
            notifyPropertyChanged(50);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public void X(ProgramDescriptionItem programDescriptionItem) {
        this.R = programDescriptionItem;
        this.V = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = programDescriptionItem;
            this.V = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.oi
    protected void m() {
        int cmp;
        TextView view;
        int name;
        long l = this.V;
        final int i2 = 0;
        this.V = i2;
        name = 0;
        final ProgramDescriptionItem programDescriptionItem = this.R;
        final o oVar = this.T;
        int cmp3 = Long.compare(i6, i2);
        synchronized (this) {
            l = this.V;
            i2 = 0;
            this.V = i2;
            name = 0;
            programDescriptionItem = this.R;
            oVar = this.T;
            cmp3 = Long.compare(i6, i2);
        }
        try {
            if (programDescriptionItem != null) {
            }
            name = programDescriptionItem.getName();
            if (cmp3 != 0) {
            }
            this.O.U(programDescriptionItem);
            this.P.V(programDescriptionItem);
            g.c(this.Q, name);
            if (Long.compare(i, i2) != 0) {
            }
            this.O.T(oVar);
            this.P.T(oVar);
        }
        this.P.U(this.S);
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.oi
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.P.y()) {
                }
                return i2;
                if (this.O.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
