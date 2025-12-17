package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.u.n.p.e;
import app.dogo.com.dogo_android.u.n.p.l.g;
import app.dogo.com.dogo_android.u.n.p.l.i;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class nc extends app.dogo.com.dogo_android.h.mc implements b.a {

    private static final ViewDataBinding.g e0;
    private static final SparseIntArray f0;
    private final ConstraintLayout a0;
    private final View.OnClickListener b0;
    private final View.OnClickListener c0;
    private long d0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        nc.f0 = sparseIntArray;
        sparseIntArray.put(2131362278, 11);
        sparseIntArray.put(2131362322, 12);
        sparseIntArray.put(2131363403, 13);
        sparseIntArray.put(2131363444, 14);
        sparseIntArray.put(2131362064, 15);
    }

    public nc(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 16, nc.e0, nc.f0));
    }

    private nc(e e, View view2, Object[] object3Arr3) {
        Object obj4 = this;
        super(e, view2, 7, (Guideline)object3Arr3[15], (TextView)object3Arr3[9], (TextView)object3Arr3[11], (MaterialButton)object3Arr3[6], (MaterialButton)object3Arr3[10], (ImageView)object3Arr3[12], (MaterialButton)object3Arr3[8], (ScrollView)object3Arr3[0], (RecyclerView)object3Arr3[4], (TextView)object3Arr3[13], (MaterialButton)object3Arr3[7], (ConstraintLayout)object3Arr3[5], (TextView)object3Arr3[3], (Toolbar)object3Arr3[2], (Barrier)object3Arr3[14]);
        Object obj3 = this;
        obj3.d0 = -1;
        int i3 = 0;
        obj3.O.setTag(i3);
        obj3.P.setTag(i3);
        obj3.Q.setTag(i3);
        int i2 = 1;
        Object obj5 = object3Arr3[i2];
        obj3.a0 = (ConstraintLayout)obj5;
        obj5.setTag(i3);
        obj3.R.setTag(i3);
        obj3.S.setTag(i3);
        obj3.T.setTag(i3);
        obj3.U.setTag(i3);
        obj3.V.setTag(i3);
        obj3.W.setTag(i3);
        obj3.X.setTag(i3);
        obj3.N(view2);
        b bVar2 = new b(obj3, i2);
        obj3.b0 = bVar2;
        b bVar = new b(obj3, 2);
        obj3.c0 = bVar;
        A();
    }

    private boolean X(x<Boolean> x, int i2) {
        if (i2 == 0) {
            this.d0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.d0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(x<Long> x, int i2) {
        if (i2 == 0) {
            this.d0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.d0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Z(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.d0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.d0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean a0(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.d0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.d0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean b0(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.d0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.d0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean c0(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.d0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.d0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean d0(x<y<Boolean>> x, int i2) {
        if (i2 == 0) {
            this.d0 = obj3 |= i;
            return 1;
            synchronized (this) {
                this.d0 = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.mc
    public void A() {
        this.d0 = 512;
        I();
        return;
        synchronized (this) {
            this.d0 = 512;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mc
    protected boolean E(int i, Object object2, int i3) {
        switch (i) {
            case 0:
                return b0((x)object2, i3);
            case 1:
                return Z((x)object2, i3);
            case 2:
                return X((x)object2, i3);
            case 3:
                return a0((x)object2, i3);
            case 4:
                return c0((x)object2, i3);
            case 5:
                return d0((x)object2, i3);
            case 6:
                return Y((x)object2, i3);
            default:
                return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.mc
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((g)object2);
            obj2 = 1;
        } else {
            if (177 == i) {
                W((i)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.mc
    public void V(g g) {
        this.Z = g;
        this.d0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.Z = g;
            this.d0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mc
    public void W(i i) {
        this.Y = i;
        this.d0 = l |= i3;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.Y = i;
            this.d0 = l |= i3;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.mc
    public final void b(int i, View view2) {
        int i2;
        i obj3;
        int obj4;
        obj4 = 0;
        final int i3 = 1;
        if (i != i3) {
            if (i != 2) {
            } else {
                obj3 = this.Y;
                if (obj3 != null) {
                    obj4 = i3;
                }
                if (obj4 != null) {
                    obj3.j();
                }
            }
        } else {
            obj3 = this.Y;
            if (obj3 != null) {
                obj4 = i3;
            }
            if (obj4 != null) {
                obj3.x();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.mc
    protected void m() {
        Object gVar2;
        int cmp;
        int cmp2;
        int cmp4;
        int cmp7;
        int cmp6;
        int cmp10;
        int cmp12;
        int cmp15;
        long l;
        int i25;
        int i12;
        int value4;
        int i4;
        int i27;
        int i32;
        int cmp13;
        int value;
        int value2;
        int iVar;
        int i33;
        int i22;
        int value6;
        int i29;
        int string;
        int i24;
        int i17;
        int i10;
        int i28;
        int i18;
        int i23;
        Object value3;
        int value7;
        int i13;
        int cmp5;
        int i14;
        int i8;
        int value5;
        int i3;
        int i2;
        int i5;
        int i7;
        int cmp9;
        int i30;
        int i6;
        int cmp11;
        g gVar;
        int i26;
        int i9;
        int cmp14;
        int cmp8;
        int i20;
        int cmp3;
        x xVar;
        int i11;
        int i21;
        int i;
        int i16;
        int i31;
        int i15;
        int i19;
        final Object obj = this;
        l = obj.d0;
        int i37 = 0;
        obj.d0 = i37;
        gVar2 = obj.Z;
        iVar = obj.Y;
        final int i60 = 785;
        final int i61 = 832;
        int i62 = 776;
        final int i64 = 768;
        int i51 = 0;
        synchronized (this) {
            obj = this;
            l = obj.d0;
            i37 = 0;
            obj.d0 = i37;
            gVar2 = obj.Z;
            iVar = obj.Y;
            i60 = 785;
            i61 = 832;
            i62 = 776;
            i64 = 768;
            i51 = 0;
        }
        if (Long.compare(i54, i37) != 0) {
            if (iVar != null) {
                try {
                    i17 = iVar.r();
                    i26 = iVar.u();
                    i9 = iVar.w();
                    i9 = i51;
                    i17 = 0;
                    i26 = 0;
                    if (Long.compare(i66, i37) != 0) {
                    }
                    if (i9 != 0) {
                    } else {
                    }
                    i36 |= i70;
                    cmp8 = 131072;
                    i35 |= i68;
                    cmp8 = 65536;
                    i25 |= cmp8;
                }
                if (Long.compare(i71, i37) != 0) {
                    i28 = i9 != 0 ? R.string.new.log.header : R.string.edit.potty.log;
                    string = obj.X.getResources().getString(i28);
                    i10 = i9 != 0 ? 8 : i51;
                    i20 = i9 != 0 ? i51 : 8;
                } else {
                    i20 = i10;
                    string = 0;
                }
            } else {
            }
        } else {
            i20 = i9;
            string = 0;
            i17 = 0;
            i26 = 0;
        }
        if (Long.compare(i72, i37) != 0) {
            if (iVar != null) {
                i23 = cmp3;
                i13 = xVar;
            } else {
                i23 = 0;
                i13 = 0;
            }
            obj.Q(i51, i23);
            obj.Q(4, i13);
            if (i23 != 0) {
                value6 = i23.getValue();
            } else {
                value6 = 0;
            }
            if (i13 != 0) {
                value3 = i13.getValue();
            } else {
                value3 = 0;
            }
        } else {
            value6 = 0;
        }
        i6 = 1;
        if (Long.compare(i21, i37) != 0) {
            if (iVar != null) {
                cmp5 = iVar.m();
            } else {
                cmp5 = 0;
            }
            obj.Q(i6, cmp5);
            if (cmp5 != 0) {
                value7 = cmp5.getValue();
            } else {
                value7 = 0;
            }
        } else {
        }
        if (Long.compare(i, i37) != 0) {
            if (iVar != null) {
                i8 = cmp11;
            } else {
                i8 = 0;
            }
            obj.Q(2, i8);
            if (i8 != 0) {
                value5 = i8.getValue();
            } else {
                value5 = 0;
            }
            i14 = ViewDataBinding.K(value5);
        } else {
            i14 = 0;
        }
        int cmp18 = Long.compare(i73, i37);
        if (cmp18 != 0) {
            if (iVar != null) {
                i4 = cmp11;
            } else {
                i4 = 0;
            }
            obj.Q(3, i4);
            if (i4 != 0) {
                value4 = i4.getValue();
            } else {
                value4 = 0;
            }
            if (ViewDataBinding.J(value4) > i6) {
            } else {
                i6 = 0;
            }
            if (cmp18 != 0) {
                i31 = i6 != 0 ? 8192 : 4096;
                l |= i31;
            }
            i11 = i6 != 0 ? 0 : 8;
            i5 = 800;
        } else {
            value4 = 0;
            i5 = 800;
            i11 = 0;
        }
        if (Long.compare(i31, i7) != 0) {
            if (iVar != null) {
                cmp13 = iVar.s();
            } else {
                cmp13 = 0;
            }
            obj.Q(5, cmp13);
            if (cmp13 != 0) {
                value = cmp13.getValue();
            } else {
                value = 0;
            }
        } else {
        }
        if (Long.compare(i58, i16) != 0) {
            if (iVar != null) {
                iVar = iVar.l();
            } else {
                iVar = 0;
            }
            obj.Q(6, iVar);
            if (iVar != 0) {
                value2 = iVar.getValue();
                i15 = value6;
                i30 = i17;
                i19 = value3;
                i3 = i26;
                i33 = i11;
            } else {
                i15 = value6;
                i30 = i17;
                i19 = value3;
                i3 = i26;
                i33 = i11;
                value2 = 0;
            }
        } else {
        }
        i18 = value;
        i24 = string;
        i27 = i9;
        i29 = value4;
        i12 = i20;
        int i65 = 0;
        if (Long.compare(i63, i65) != 0) {
            gVar = gVar2;
            obj.O.setVisibility(i33);
            e.k(obj.O, i29, obj.R);
        } else {
            gVar = gVar2;
        }
        if (Long.compare(i22, i65) != 0) {
            e.c(obj.P, value2);
        }
        if (Long.compare(i40, i65) != 0) {
            n.Z(obj.Q, value7);
        }
        if (Long.compare(i41, i65) != 0) {
            obj.Q.setVisibility(i10);
            obj.W.setVisibility(i12);
            obj.X.setTitle(i24);
        }
        int i53 = 0;
        if (Long.compare(i43, i53) != 0) {
            obj.Q.setOnClickListener(obj.c0);
            obj.R.setOnClickListener(obj.b0);
        }
        if (Long.compare(i45, i53) != 0) {
            n.F0(obj.a0, i18);
            n.Z(obj.R, i18);
            n.F0(obj.V, i18);
        }
        if (Long.compare(i47, i53) != 0) {
            obj.R.setEnabled(i14);
        }
        if (Long.compare(i49, i53) != 0) {
            e.b(obj.T, i3, gVar, i30, i27);
        }
        if (Long.compare(i34, i53) != 0) {
            e.d(obj.U, i15, i19);
        }
    }

    @Override // app.dogo.com.dogo_android.h.mc
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
