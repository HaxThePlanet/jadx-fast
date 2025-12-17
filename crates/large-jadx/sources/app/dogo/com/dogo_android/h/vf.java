package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramLessonItem;
import app.dogo.com.dogo_android.repository.domain.ProgramOverview;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;
import app.dogo.com.dogo_android.y.z.g;
import f.d.a.a;

/* loaded from: classes.dex */
public class vf extends app.dogo.com.dogo_android.h.uf implements b.a {

    private static final ViewDataBinding.g m0;
    private static final SparseIntArray n0;
    private final Group j0;
    private final View.OnClickListener k0;
    private long l0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        vf.n0 = sparseIntArray;
        sparseIntArray.put(2131363185, 18);
        sparseIntArray.put(2131362420, 19);
        sparseIntArray.put(2131362195, 20);
        sparseIntArray.put(2131363235, 21);
        sparseIntArray.put(2131362323, 22);
        sparseIntArray.put(2131362415, 23);
        sparseIntArray.put(2131362620, 24);
        sparseIntArray.put(2131362324, 25);
        sparseIntArray.put(2131362353, 26);
        sparseIntArray.put(2131363524, 27);
        sparseIntArray.put(2131363457, 28);
        sparseIntArray.put(2131363454, 29);
        sparseIntArray.put(2131362999, 30);
        sparseIntArray.put(2131362061, 31);
        sparseIntArray.put(2131363494, 32);
        sparseIntArray.put(2131363495, 33);
        sparseIntArray.put(2131362092, 34);
    }

    public vf(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 35, vf.m0, vf.n0));
    }

    private vf(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 2, (TextView)object3Arr3[15], (AppCompatImageView)object3Arr3[31], (Button)object3Arr3[17], (View)object3Arr3[34], (AppCompatImageView)object3Arr3[13], (ImageView)object3Arr3[5], (FrameLayout)object3Arr3[20], (TextView)object3Arr3[9], (View)object3Arr3[22], (View)object3Arr3[25], (LinearLayout)object3Arr3[11], (TextView)object3Arr3[26], (AppCompatImageView)object3Arr3[3], (AppCompatImageView)object3Arr3[23], (TextView)object3Arr3[7], (AppCompatImageView)object3Arr3[19], (AppCompatImageView)object3Arr3[6], (View)object3Arr3[1], (AppCompatImageView)object3Arr3[24], (TextView)object3Arr3[30], (RecyclerView)object3Arr3[10], (ConstraintLayout)object3Arr3[0], (NestedScrollView)object3Arr3[18], (AppCompatImageView)object3Arr3[21], (TextView)object3Arr3[8], (AppCompatImageView)object3Arr3[2], (TextView)object3Arr3[4], (AppCompatImageView)object3Arr3[29], (TextView)object3Arr3[28], (View)object3Arr3[32], (TextView)object3Arr3[33], (TextView)object3Arr3[14], (LinearLayout)object3Arr3[12], (TextView)object3Arr3[27]);
        Object obj4 = this;
        obj4.l0 = -1;
        int i3 = 0;
        obj4.O.setTag(i3);
        obj4.P.setTag(i3);
        obj4.Q.setTag(i3);
        obj4.R.setTag(i3);
        obj4.T.setTag(i3);
        obj4.U.setTag(i3);
        obj4.V.setTag(i3);
        obj4.W.setTag(i3);
        obj4.X.setTag(i3);
        obj4.Y.setTag(i3);
        Object obj2 = object3Arr3[16];
        obj4.j0 = (Group)obj2;
        obj2.setTag(i3);
        obj4.Z.setTag(i3);
        obj4.a0.setTag(i3);
        obj4.c0.setTag(i3);
        obj4.d0.setTag(i3);
        obj4.e0.setTag(i3);
        obj4.f0.setTag(i3);
        obj4.g0.setTag(i3);
        obj4.N(view2);
        b bVar = new b(obj4, 1);
        obj4.k0 = bVar;
        A();
    }

    private boolean X(a<y<ProgramLessonItem>> a, int i2) {
        if (i2 == 0) {
            this.l0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.l0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(x<y<ProgramOverview>> x, int i2) {
        if (i2 == 0) {
            this.l0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.l0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.uf
    public void A() {
        this.l0 = 16;
        I();
        return;
        synchronized (this) {
            this.l0 = 16;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uf
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((a)object2, i3);
        }
        return Y((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.uf
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (128 == i) {
            V((String)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((g)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.uf
    public void V(String string) {
        this.i0 = string;
        this.l0 = l |= i2;
        notifyPropertyChanged(128);
        super.I();
        return;
        synchronized (this) {
            this.i0 = string;
            this.l0 = l |= i2;
            notifyPropertyChanged(128);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uf
    public void W(g g) {
        this.h0 = g;
        this.l0 = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.h0 = g;
            this.l0 = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uf
    public final void b(int i, View view2) {
        int obj2;
        final g obj1 = this.h0;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.x();
        }
    }

    @Override // app.dogo.com.dogo_android.h.uf
    protected void m() {
        int cmp3;
        View.OnClickListener list;
        g gVar;
        int value2;
        int cmp5;
        int value;
        int cmp;
        int cmp4;
        int i;
        int cmp2;
        long l = this.l0;
        final int i3 = 0;
        this.l0 = i3;
        final String str = this.i0;
        gVar = this.h0;
        final int i10 = 26;
        int i11 = 25;
        final int i13 = 0;
        synchronized (this) {
            l = this.l0;
            i3 = 0;
            this.l0 = i3;
            str = this.i0;
            gVar = this.h0;
            i10 = 26;
            i11 = 25;
            i13 = 0;
        }
        try {
            if (Long.compare(i, i3) != 0) {
            } else {
            }
            if (gVar != null) {
            } else {
            }
            cmp5 = gVar.t();
            cmp5 = i13;
            Q(0, cmp5);
            if (cmp5 != null) {
            } else {
            }
            value = cmp5.getValue();
            value = i13;
        }
        if (Long.compare(i14, i3) != 0) {
            if (gVar != null) {
                gVar = gVar.s();
            } else {
                gVar = i13;
            }
            Q(1, gVar);
            if (gVar != 0) {
                value2 = gVar.getValue();
            } else {
                value2 = i13;
            }
        } else {
        }
        if (Long.compare(i12, i3) != 0) {
            l.x0(this.O, value);
            n.I0(this.P, value);
            l.y0(this.Q, value);
            l.e0(this.T, value);
            l.r0(this.U, value);
            l.z0(this.V, value);
            l.d0(this.W, value);
            n.w0(this.j0, value);
            l.B0(this.Z, value);
            n.F0(this.a0, value);
            l.f0(this.c0, value);
            l.z0(this.d0, value);
            l.A0(this.e0, value);
            l.w0(this.f0, value);
            l.I0(this.g0, value);
        }
        if (Long.compare(i8, i3) != 0) {
            n.Z(this.P, value2);
        }
        if (Long.compare(i2, i3) != 0) {
            this.P.setOnClickListener(this.k0);
            n.k0(this.R, i13);
            n.k0(this.e0, i13);
        }
        if (Long.compare(i5, i3) != 0) {
            n.j0(this.X, str);
            l.x(this.Y, str);
        }
    }

    @Override // app.dogo.com.dogo_android.h.uf
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
