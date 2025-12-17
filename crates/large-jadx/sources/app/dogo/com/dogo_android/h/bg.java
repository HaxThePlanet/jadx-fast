package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramTasks;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.c0.f;
import app.dogo.com.dogo_android.y.c0.g;
import app.dogo.com.dogo_android.y.l;
import f.d.a.a;
import java.util.List;

/* loaded from: classes.dex */
public class bg extends app.dogo.com.dogo_android.h.ag implements b.a {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final ConstraintLayout R;
    private final LinearLayout S;
    private final Button T;
    private final FrameLayout U;
    private final app.dogo.com.dogo_android.h.ml V;
    private final View.OnClickListener W;
    private long X;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(10);
        bg.Y = gVar;
        int i7 = 1;
        final int[] iArr2 = new int[i7];
        final int i16 = 0;
        iArr2[i16] = 4;
        int[] iArr = new int[i7];
        iArr[i16] = 2131558788;
        gVar.a(3, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        bg.Z = sparseIntArray;
        sparseIntArray.put(2131363433, 5);
        sparseIntArray.put(2131363356, 6);
        sparseIntArray.put(2131363358, 7);
        sparseIntArray.put(2131363355, 8);
        sparseIntArray.put(2131362113, 9);
    }

    public bg(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 10, bg.Y, bg.Z));
    }

    private bg(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (CardView)object3Arr3[9], (TextView)object3Arr3[8], (ImageView)object3Arr3[6], (TextView)object3Arr3[7], (MaterialToolbar)object3Arr3[5]);
        this.X = -1;
        Object obj11 = object3Arr3[0];
        this.R = (ConstraintLayout)obj11;
        int i7 = 0;
        obj11.setTag(i7);
        obj11 = 1;
        Object obj7 = object3Arr3[obj11];
        this.S = (LinearLayout)obj7;
        obj7.setTag(i7);
        Object obj8 = object3Arr3[2];
        this.T = (Button)obj8;
        obj8.setTag(i7);
        Object obj9 = object3Arr3[3];
        this.U = (FrameLayout)obj9;
        obj9.setTag(i7);
        final Object obj13 = object3Arr3[4];
        this.V = (ml)obj13;
        L(obj13);
        N(view2);
        b obj12 = new b(this, obj11);
        this.W = obj12;
        A();
    }

    private boolean X(x<List<ProgramTasks>> x, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(a<y<Boolean>> a, int i2) {
        if (i2 == 0) {
            this.X = obj3 |= i;
            return 1;
            synchronized (this) {
                this.X = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public void A() {
        this.X = 16;
        this.V.A();
        I();
        return;
        synchronized (this) {
            this.X = 16;
            this.V.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ag
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Y((a)object2, i3);
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public void M(q q) {
        super.M(q);
        this.V.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((g)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((f)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public void V(g g) {
        this.Q = g;
        this.X = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Q = g;
            this.X = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public void W(f f) {
        this.P = f;
        this.X = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.P = f;
            this.X = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public final void b(int i, View view2) {
        int obj2;
        final g obj1 = this.Q;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.j1();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ag
    protected void m() {
        int cmp4;
        int cmp5;
        int cmp;
        int i;
        f value;
        int cmp7;
        int i3;
        List cmp6;
        List i2;
        Object value2;
        int cmp2;
        int cmp3;
        final Object obj = this;
        long l = obj.X;
        final int i5 = 0;
        obj.X = i5;
        value = obj.P;
        cmp7 = Long.compare(i7, i5);
        final int i12 = 26;
        final int i13 = 25;
        i2 = 0;
        synchronized (this) {
            obj = this;
            l = obj.X;
            i5 = 0;
            obj.X = i5;
            value = obj.P;
            cmp7 = Long.compare(i7, i5);
            i12 = 26;
            i13 = 25;
            i2 = 0;
        }
        if (cmp7 != 0 && value != null) {
            if (value != null) {
                try {
                    cmp6 = value.o();
                    cmp6 = i2;
                    if (value != null) {
                    } else {
                    }
                    cmp2 = value.m();
                    cmp2 = i2;
                    obj.Q(0, cmp2);
                }
                value2 = i2;
                if (Long.compare(i15, i5) != 0) {
                    if (value != null) {
                        value = value.n();
                    } else {
                        value = i2;
                    }
                    obj.Q(1, value);
                    if (value != null) {
                        i2 = value;
                    }
                }
                i = i2;
                i2 = cmp6;
                if (cmp7 != 0) {
                    l.j0(obj.S, i2, obj.Q);
                }
                if (Long.compare(i8, i5) != 0) {
                    l.G0(obj.T, value2);
                }
                if (Long.compare(i3, i5) != 0) {
                    obj.T.setOnClickListener(obj.W);
                }
                if (Long.compare(i4, i5) != 0) {
                    n.D0(obj.U, i);
                }
                ViewDataBinding.o(obj.V);
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.ag
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.V.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
