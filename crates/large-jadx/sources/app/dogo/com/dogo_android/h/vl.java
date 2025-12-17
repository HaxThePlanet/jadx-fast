package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem;
import app.dogo.com.dogo_android.repository.domain.SpecialProgramOverviewItem.ProgramData;
import app.dogo.com.dogo_android.u.n.k;
import java.util.List;

/* loaded from: classes.dex */
public class vl extends app.dogo.com.dogo_android.h.ul {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ConstraintLayout U;
    private long V;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(6);
        vl.W = gVar;
        int i4 = 3;
        int[] iArr2 = new int[i4];
        iArr2 = new int[]{1, 2, 3};
        int[] iArr = new int[i4];
        iArr = new int[]{2131558763, 2131558757, 2131558756};
        gVar.a(0, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        vl.X = sparseIntArray;
        sparseIntArray.put(2131363207, 4);
        sparseIntArray.put(2131362301, 5);
    }

    public vl(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, vl.W, vl.X));
    }

    private vl(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 3, (ej)object3Arr3[2], (TextView)object3Arr3[5], (cj)object3Arr3[3], (qj)object3Arr3[1], (TextView)object3Arr3[4]);
        this.V = -1;
        L(this.O);
        Object obj11 = object3Arr3[0];
        this.U = (ConstraintLayout)obj11;
        obj11.setTag(0);
        L(this.P);
        L(this.Q);
        N(view2);
        A();
    }

    private boolean V(app.dogo.com.dogo_android.h.ej ej, int i2) {
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

    private boolean W(app.dogo.com.dogo_android.h.cj cj, int i2) {
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

    private boolean X(app.dogo.com.dogo_android.h.qj qj, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.ul
    public void A() {
        this.V = 64;
        this.Q.A();
        this.O.A();
        this.P.A();
        I();
        return;
        synchronized (this) {
            this.V = 64;
            this.Q.A();
            this.O.A();
            this.P.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ul
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return V((ej)object2, i3);
            }
            return X((qj)object2, i3);
        }
        return W((cj)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ul
    public void M(q q) {
        super.M(q);
        this.Q.M(q);
        this.O.M(q);
        this.P.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ul
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            a0((SpecialProgramOverviewItem)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                Y((k)object2);
            } else {
                if (39 == i) {
                    Z((List)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ul
    public void Y(k k) {
        this.S = k;
        this.V = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.S = k;
            this.V = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    public void Z(List<Boolean> list) {
        this.T = list;
    }

    @Override // app.dogo.com.dogo_android.h.ul
    public void a0(SpecialProgramOverviewItem specialProgramOverviewItem) {
        this.R = specialProgramOverviewItem;
        this.V = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.R = specialProgramOverviewItem;
            this.V = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ul
    protected void m() {
        boolean logs;
        int i5;
        int i6;
        int cmp2;
        long l;
        int i4;
        int cmp;
        int i10;
        int i;
        int cmp3;
        int i2;
        int centerImage;
        int i9;
        int programProgress;
        int i11;
        int pottyTrackerNewUiEnabled;
        int programData;
        int i8;
        int pottyCheckmarks;
        int i3;
        int i7;
        final Object obj = this;
        l = obj.V;
        final int i15 = 0;
        obj.V = i15;
        SpecialProgramOverviewItem specialProgramOverviewItem = obj.R;
        final k kVar = obj.S;
        int i16 = 72;
        int cmp4 = Long.compare(i19, i15);
        int i20 = 16384;
        centerImage = 0;
        i9 = 0;
        synchronized (this) {
            obj = this;
            l = obj.V;
            i15 = 0;
            obj.V = i15;
            specialProgramOverviewItem = obj.R;
            kVar = obj.S;
            i16 = 72;
            cmp4 = Long.compare(i19, i15);
            i20 = 16384;
            centerImage = 0;
            i9 = 0;
        }
        if (specialProgramOverviewItem != null) {
            programProgress = specialProgramOverviewItem.getProgramProgress();
            pottyTrackerNewUiEnabled = specialProgramOverviewItem.getPottyTrackerNewUiEnabled();
            programData = specialProgramOverviewItem.getProgramData();
            pottyCheckmarks = specialProgramOverviewItem.getPottyCheckmarks();
        } else {
            try {
                pottyCheckmarks = programData;
                pottyTrackerNewUiEnabled = i9;
                if (cmp4 != 0) {
                }
                if (pottyTrackerNewUiEnabled != 0) {
                } else {
                }
                i12 |= i20;
                i3 = 65536;
                i13 |= i27;
                i3 = 32768;
                i4 |= i3;
            }
            i10 = 8;
            if (programData != null) {
                centerImage = programData.getCenterImage();
            }
            i8 = pottyTrackerNewUiEnabled;
            i2 = pottyCheckmarks;
            i11 = centerImage;
            centerImage = i7;
            if (Long.compare(i23, i15) != 0) {
                if (specialProgramOverviewItem != null) {
                    logs = specialProgramOverviewItem.hasLogs();
                } else {
                    logs = i9;
                }
                i = Long.compare(i21, i15) != 0 ? logs ^ 1 : i9;
            } else {
                i = logs;
            }
            cmp3 = Long.compare(i24, i15);
            if (cmp3 != 0) {
                if (i8 != 0) {
                } else {
                    logs = i9;
                }
                if (i8 != 0) {
                } else {
                    i = i9;
                }
                if (cmp3 != 0) {
                    i8 = logs != 0 ? 256 : 128;
                    l |= i8;
                }
                if (Long.compare(i8, i15) != 0) {
                    i8 = i != 0 ? 4096 : 2048;
                    l |= i8;
                }
                i5 = logs != 0 ? i9 : 8;
                pottyTrackerNewUiEnabled = i != 0 ? i9 : 8;
                i9 = i5;
                i6 = pottyTrackerNewUiEnabled;
            } else {
                i6 = i9;
            }
            if (Long.compare(i17, i15) != 0) {
                obj.O.w().setVisibility(i9);
                obj.O.V(centerImage);
                obj.O.U(i2);
                obj.P.V(centerImage);
                obj.P.U(i11);
                obj.P.w().setVisibility(i6);
                obj.Q.w().setVisibility(i10);
                obj.Q.U(centerImage);
            }
            if (Long.compare(i14, i15) != 0) {
                obj.O.T(kVar);
                obj.P.T(kVar);
                obj.Q.T(kVar);
            }
            ViewDataBinding.o(obj.Q);
            ViewDataBinding.o(obj.O);
            ViewDataBinding.o(obj.P);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ul
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.Q.y()) {
                }
                return i2;
                if (this.O.y()) {
                }
                return i2;
                if (this.P.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
