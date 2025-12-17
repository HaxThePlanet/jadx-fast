package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.repository.domain.ProgramCompletionSummary;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class lm extends app.dogo.com.dogo_android.h.km {

    private static final ViewDataBinding.g Z;
    private static final SparseIntArray a0 = null;
    private long Y;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(9);
        lm.Z = gVar;
        String str = "layout_program_module_progress_bar";
        int i3 = 4;
        final int[] iArr2 = new int[i3];
        iArr2 = new int[]{5, 6, 7, 8};
        int[] iArr = new int[i3];
        iArr = new int[]{2131558797, 2131558797, 2131558797, 2131558797};
        gVar.a(0, /* result */, iArr2, iArr);
        int i = 0;
    }

    public lm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 9, lm.Z, lm.a0));
    }

    private lm(e e, View view2, Object[] object3Arr3) {
        final Object obj21 = this;
        super(e, view2, 4, (em)object3Arr3[5], (em)object3Arr3[6], (em)object3Arr3[7], (em)object3Arr3[8], (ImageView)object3Arr3[1], (ImageView)object3Arr3[2], (ImageView)object3Arr3[3], (ImageView)object3Arr3[4], (ConstraintLayout)object3Arr3[0]);
        obj21.Y = -1;
        L(obj21.O);
        L(obj21.P);
        L(obj21.Q);
        L(obj21.R);
        int i11 = 0;
        obj21.S.setTag(i11);
        obj21.T.setTag(i11);
        obj21.U.setTag(i11);
        obj21.V.setTag(i11);
        obj21.W.setTag(i11);
        N(view2);
        A();
    }

    private boolean U(app.dogo.com.dogo_android.h.em em, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean V(app.dogo.com.dogo_android.h.em em, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean W(app.dogo.com.dogo_android.h.em em, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(app.dogo.com.dogo_android.h.em em, int i2) {
        if (i2 == 0) {
            this.Y = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Y = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.km
    public void A() {
        this.Y = 32;
        this.O.A();
        this.P.A();
        this.Q.A();
        this.R.A();
        I();
        return;
        synchronized (this) {
            this.Y = 32;
            this.O.A();
            this.P.A();
            this.Q.A();
            this.R.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.km
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return W((em)object2, i3);
                }
                return U((em)object2, i3);
            }
            return X((em)object2, i3);
        }
        return V((em)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.km
    public void M(q q) {
        super.M(q);
        this.O.M(q);
        this.P.M(q);
        this.Q.M(q);
        this.R.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.km
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            T((ProgramCompletionSummary)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.km
    public void T(ProgramCompletionSummary programCompletionSummary) {
        this.X = programCompletionSummary;
        this.Y = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.X = programCompletionSummary;
            this.Y = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.km
    protected void m() {
        int i3;
        int programBackgroundColor;
        long l;
        int cmp;
        int i2;
        int i13;
        int i7;
        int i14;
        int moduleProgress;
        int i12;
        int i4;
        int i15;
        int i11;
        int i8;
        int i5;
        int i16;
        int i6;
        int i9;
        int i19;
        int i18;
        int i17;
        int i10;
        int i;
        final Object obj = this;
        l = obj.Y;
        final int i21 = 0;
        obj.Y = i21;
        ProgramCompletionSummary programCompletionSummary = obj.X;
        final int i22 = 48;
        int cmp2 = Long.compare(i23, i21);
        i13 = 0;
        i7 = 0;
        synchronized (this) {
            obj = this;
            l = obj.Y;
            i21 = 0;
            obj.Y = i21;
            programCompletionSummary = obj.X;
            i22 = 48;
            cmp2 = Long.compare(i23, i21);
            i13 = 0;
            i7 = 0;
        }
        if (programCompletionSummary != null) {
            moduleProgress = programCompletionSummary.getModuleProgress();
            programBackgroundColor = programCompletionSummary.getProgramBackgroundColor();
        } else {
            try {
                moduleProgress = programBackgroundColor;
                i15 = 1;
                if (moduleProgress != 0) {
                } else {
                }
                i13 = ViewDataBinding.v(moduleProgress, 3);
                i11 = ViewDataBinding.v(moduleProgress, i15);
                i8 = ViewDataBinding.v(moduleProgress, 2);
                i12 = ViewDataBinding.v(moduleProgress, i7);
                i8 = i11;
                if (i13 != 0) {
                } else {
                }
                i16 = i15;
                i16 = i7;
            }
            i9 = i11 != 0 ? i15 : i7;
            i18 = i8 != 0 ? i15 : i7;
            if (i12 != 0) {
            } else {
                i15 = i7;
            }
            if (cmp2 != 0) {
                i17 = i16 != 0 ? 8192 : 4096;
                l |= i17;
            }
            if (Long.compare(i10, i21) != 0) {
                i10 = i9 != 0 ? 2048 : 1024;
                l |= i10;
            }
            if (Long.compare(i, i21) != 0) {
                i = i18 != 0 ? 128 : 64;
                l |= i;
            }
            if (Long.compare(i17, i21) != 0) {
                i17 = i15 != 0 ? 512 : 256;
                l |= i17;
            }
            int i24 = 8;
            i5 = i16 != 0 ? i7 : i24;
            i6 = i9 != 0 ? i7 : i24;
            i19 = i18 != 0 ? i7 : i24;
            if (i15 != 0) {
            } else {
                i7 = i24;
            }
            i2 = programBackgroundColor;
            i3 = i13;
            i13 = i12;
            i14 = i6;
            i4 = i19;
            if (Long.compare(i20, i21) != 0) {
                obj.O.w().setVisibility(i7);
                obj.O.T(i13);
                obj.P.w().setVisibility(i14);
                obj.P.T(i11);
                obj.Q.w().setVisibility(i4);
                obj.Q.T(i8);
                obj.R.w().setVisibility(i5);
                obj.R.T(i3);
                l.C0(obj.S, i13);
                n.j0(obj.S, i2);
                l.C0(obj.T, i11);
                n.j0(obj.T, i2);
                l.C0(obj.U, i8);
                n.j0(obj.U, i2);
                l.C0(obj.V, i3);
                n.j0(obj.V, i2);
            }
            ViewDataBinding.o(obj.O);
            ViewDataBinding.o(obj.P);
            ViewDataBinding.o(obj.Q);
            ViewDataBinding.o(obj.R);
        }
    }

    @Override // app.dogo.com.dogo_android.h.km
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.O.y()) {
                }
                return i2;
                if (this.P.y()) {
                }
                return i2;
                if (this.Q.y()) {
                }
                return i2;
                if (this.R.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
