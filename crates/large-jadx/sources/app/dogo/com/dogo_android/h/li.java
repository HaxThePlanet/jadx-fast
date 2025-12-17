package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
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
import app.dogo.com.dogo_android.g.z;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import java.util.List;

/* loaded from: classes.dex */
public class li extends app.dogo.com.dogo_android.h.ki implements b.a {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0;
    private final ConstraintLayout Y;
    private final View.OnClickListener Z;
    private long a0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(9);
        li.b0 = gVar;
        int i4 = 4;
        int[] iArr2 = new int[i4];
        iArr2 = new int[]{3, 4, 5, 6};
        int[] iArr = new int[i4];
        iArr = new int[]{2131558755, 2131558756, 2131558763, 2131558757};
        gVar.a(0, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        li.c0 = sparseIntArray;
        sparseIntArray.put(2131362983, 7);
        sparseIntArray.put(2131362984, 8);
    }

    public li(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, li.b0, li.c0));
    }

    private li(e e, View view2, Object[] object3Arr3) {
        final Object obj19 = this;
        final int i12 = 1;
        super(e, view2, 4, (ej)object3Arr3[6], (TextView)object3Arr3[7], (ImageView)object3Arr3[8], (aj)object3Arr3[3], (cj)object3Arr3[4], (View)object3Arr3[2], (qj)object3Arr3[5], (TextView)object3Arr3[i12]);
        obj19.a0 = -1;
        Object obj9 = object3Arr3[0];
        obj19.Y = (ConstraintLayout)obj9;
        int i10 = 0;
        obj9.setTag(i10);
        L(obj19.O);
        L(obj19.P);
        L(obj19.Q);
        obj19.R.setTag(i10);
        L(obj19.S);
        obj19.T.setTag(i10);
        N(view2);
        b bVar = new b(this, i12);
        obj19.Z = bVar;
        A();
    }

    private boolean Z(app.dogo.com.dogo_android.h.ej ej, int i2) {
        if (i2 == 0) {
            this.a0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.a0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(app.dogo.com.dogo_android.h.aj aj, int i2) {
        if (i2 == 0) {
            this.a0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.a0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(app.dogo.com.dogo_android.h.cj cj, int i2) {
        if (i2 == 0) {
            this.a0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.a0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean c0(app.dogo.com.dogo_android.h.qj qj, int i2) {
        if (i2 == 0) {
            this.a0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.a0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public void A() {
        this.a0 = 256;
        this.P.A();
        this.Q.A();
        this.S.A();
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.a0 = 256;
            this.P.A();
            this.Q.A();
            this.S.A();
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ki
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return a0((aj)object2, i3);
                }
                return c0((qj)object2, i3);
            }
            return Z((ej)object2, i3);
        }
        return b0((cj)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public void M(q q) {
        super.M(q);
        this.P.M(q);
        this.Q.M(q);
        this.S.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            X((ProgramDescriptionItem)object2);
            obj2 = 1;
        } else {
            if (134 == i) {
                Y((PottyProgramProgress)object2);
            } else {
                if (29 == i) {
                    V((o)object2);
                } else {
                    if (39 == i) {
                        W((List)object2);
                    } else {
                        obj2 = 0;
                    }
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public void V(o o) {
        this.W = o;
        this.a0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.W = o;
            this.a0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    public void W(List<Boolean> list) {
        this.X = list;
        this.a0 = l |= i2;
        notifyPropertyChanged(39);
        super.I();
        return;
        synchronized (this) {
            this.X = list;
            this.a0 = l |= i2;
            notifyPropertyChanged(39);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public void X(ProgramDescriptionItem programDescriptionItem) {
        this.U = programDescriptionItem;
        this.a0 = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.U = programDescriptionItem;
            this.a0 = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public void Y(PottyProgramProgress pottyProgramProgress) {
        this.V = pottyProgramProgress;
        this.a0 = l |= i2;
        notifyPropertyChanged(134);
        super.I();
        return;
        synchronized (this) {
            this.V = pottyProgramProgress;
            this.a0 = l |= i2;
            notifyPropertyChanged(134);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public final void b(int i, View view2) {
        int i2;
        int i3;
        Object obj4;
        obj4 = this.U;
        final o obj5 = this.W;
        final int i4 = 0;
        i3 = obj5 != null ? i2 : i4;
        if (i3 != 0) {
            if (obj4 != null) {
            } else {
                i2 = i4;
            }
            if (i2 != 0) {
                obj5.x0(obj4.getId());
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.ki
    protected void m() {
        int cmp2;
        View.OnClickListener list;
        Object programDescriptionItem;
        Object pottyProgramProgress;
        int iconUrl;
        int name;
        int cmp;
        long l = this.a0;
        final int i2 = 0;
        this.a0 = i2;
        programDescriptionItem = this.U;
        pottyProgramProgress = this.V;
        final o oVar = this.W;
        int cmp3 = Long.compare(i5, i2);
        synchronized (this) {
            l = this.a0;
            i2 = 0;
            this.a0 = i2;
            programDescriptionItem = this.U;
            pottyProgramProgress = this.V;
            oVar = this.W;
            cmp3 = Long.compare(i5, i2);
        }
        try {
            if (programDescriptionItem != null) {
            } else {
            }
            iconUrl = programDescriptionItem.getIconUrl();
            name = programDescriptionItem.getName();
            name = iconUrl;
            if (Long.compare(i7, i2) != 0) {
            }
            this.O.V(pottyProgramProgress);
            this.Q.V(pottyProgramProgress);
            this.S.U(pottyProgramProgress);
            if (Long.compare(i9, i2) != 0) {
            }
            this.O.T(oVar);
            this.P.T(oVar);
            this.Q.T(oVar);
            this.S.T(oVar);
        }
        if (Long.compare(i11, i2) != 0) {
            this.O.U(this.X);
        }
        if (cmp3 != 0) {
            this.P.U(programDescriptionItem);
            this.Q.U(iconUrl);
            g.c(this.T, name);
        }
        if (Long.compare(i, i2) != 0) {
            this.R.setOnClickListener(this.Z);
        }
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.Q);
        ViewDataBinding.o(this.S);
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.ki
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.P.y()) {
                }
                return i2;
                if (this.Q.y()) {
                }
                return i2;
                if (this.S.y()) {
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
