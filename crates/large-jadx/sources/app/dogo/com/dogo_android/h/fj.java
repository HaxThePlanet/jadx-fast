package app.dogo.com.dogo_android.h;

import android.app.ActivityManager.ProcessErrorStateInfo;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.a;
import app.dogo.com.dogo_android.g.a0;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.PottyProgramProgress;
import java.util.List;

/* loaded from: classes.dex */
public class fj extends app.dogo.com.dogo_android.h.ej implements b.a {

    private static final ViewDataBinding.g k0;
    private static final SparseIntArray l0;
    private final View.OnClickListener c0;
    private final View.OnClickListener d0;
    private final View.OnClickListener e0;
    private final View.OnClickListener f0;
    private final View.OnClickListener g0;
    private final View.OnClickListener h0;
    private final View.OnClickListener i0;
    private long j0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        fj.l0 = sparseIntArray;
        sparseIntArray.put(2131363414, 12);
        sparseIntArray.put(2131362322, 13);
        sparseIntArray.put(2131362156, 14);
    }

    public fj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 15, fj.k0, fj.l0));
    }

    private fj(e e, View view2, Object[] object3Arr3) {
        Object obj4 = this;
        super(e, view2, 0, (Button)object3Arr3[1], (ConstraintLayout)object3Arr3[14], (View)object3Arr3[7], (View)object3Arr3[8], (View)object3Arr3[9], (View)object3Arr3[10], (View)object3Arr3[11], (ImageView)object3Arr3[13], (MaterialCardView)object3Arr3[0], (TextView)object3Arr3[12], (CheckBox)object3Arr3[2], (CheckBox)object3Arr3[3], (CheckBox)object3Arr3[4], (CheckBox)object3Arr3[5], (CheckBox)object3Arr3[6]);
        Object obj3 = this;
        obj3.j0 = -1;
        int i2 = 0;
        obj3.O.setTag(i2);
        obj3.P.setTag(i2);
        obj3.Q.setTag(i2);
        obj3.R.setTag(i2);
        obj3.S.setTag(i2);
        obj3.T.setTag(i2);
        obj3.U.setTag(i2);
        obj3.V.setTag(i2);
        obj3.W.setTag(i2);
        obj3.X.setTag(i2);
        obj3.Y.setTag(i2);
        obj3.Z.setTag(i2);
        obj3.N(view2);
        b bVar = new b(obj3, 1);
        obj3.c0 = bVar;
        b bVar2 = new b(obj3, 7);
        obj3.d0 = bVar2;
        b bVar3 = new b(obj3, 3);
        obj3.e0 = bVar3;
        b bVar4 = new b(obj3, 4);
        obj3.f0 = bVar4;
        b bVar5 = new b(obj3, 2);
        obj3.g0 = bVar5;
        b bVar6 = new b(obj3, 6);
        obj3.h0 = bVar6;
        b bVar7 = new b(obj3, 5);
        obj3.i0 = bVar7;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public void A() {
        this.j0 = 8;
        I();
        return;
        synchronized (this) {
            this.j0 = 8;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ej
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            V((PottyProgramProgress)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                T((a0)object2);
            } else {
                if (39 == i) {
                    U((List)object2);
                } else {
                    obj2 = 0;
                }
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public void T(a0 a0) {
        this.a0 = a0;
        this.j0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.a0 = a0;
            this.j0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    public void U(List<Boolean> list) {
        this.b0 = list;
        this.j0 = l |= i2;
        notifyPropertyChanged(39);
        super.I();
        return;
        synchronized (this) {
            this.b0 = list;
            this.j0 = l |= i2;
            notifyPropertyChanged(39);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public void V(PottyProgramProgress pottyProgramProgress) {
    }

    @Override // app.dogo.com.dogo_android.h.ej
    public final void b(int i, View view2) {
        int i3;
        List list;
        int i2;
        a0 obj4;
        int obj5;
        obj5 = 1;
        i3 = 0;
        switch (i) {
            case 1:
                obj4 = this.a0;
                obj5 = i3;
                obj4.u1("potty_card");
                break;
            case 2:
                obj4 = this.a0;
                obj5 = i3;
                obj4.O("calendar");
                break;
            case 3:
                obj4 = this.a0;
                list = this.b0;
                i2 = obj5;
                i2 = i3;
                obj5 = i3;
                obj4.Y0((Boolean)ViewDataBinding.v(list, i3).booleanValue());
                break;
            case 4:
                obj4 = this.a0;
                list = this.b0;
                i2 = obj5;
                i2 = i3;
                i3 = obj5;
                obj4.Y0((Boolean)ViewDataBinding.v(list, obj5).booleanValue());
                break;
            case 5:
                obj4 = this.a0;
                list = this.b0;
                i2 = obj5;
                i2 = i3;
                obj5 = i3;
                obj4.Y0((Boolean)ViewDataBinding.v(list, 2).booleanValue());
                break;
            case 6:
                obj4 = this.a0;
                list = this.b0;
                i2 = obj5;
                i2 = i3;
                obj5 = i3;
                obj4.Y0((Boolean)ViewDataBinding.v(list, 3).booleanValue());
                break;
            case 7:
                obj4 = this.a0;
                list = this.b0;
                i2 = obj5;
                i2 = i3;
                obj5 = i3;
                obj4.Y0((Boolean)ViewDataBinding.v(list, 4).booleanValue());
                break;
            default:
        }
    }

    @Override // app.dogo.com.dogo_android.h.ej
    protected void m() {
        int cmp;
        View.OnClickListener list;
        int i11;
        int i5;
        int i9;
        int i8;
        int i10;
        int i2;
        int i7;
        int i4;
        int i;
        int i6;
        int i3;
        boolean z;
        long l = this.j0;
        final int i13 = 0;
        this.j0 = i13;
        List list8 = this.b0;
        int cmp2 = Long.compare(i15, i13);
        i9 = 0;
        synchronized (this) {
            l = this.j0;
            i13 = 0;
            this.j0 = i13;
            list8 = this.b0;
            cmp2 = Long.compare(i15, i13);
            i9 = 0;
        }
        try {
            if (list8 != null) {
            } else {
            }
            i2 = obj;
            i8 = ViewDataBinding.v(list8, 4);
            i4 = ViewDataBinding.v(list8, 2);
            i6 = ViewDataBinding.v(list8, 3);
            i5 = ViewDataBinding.v(list8, 1);
            i6 = i4;
            i7 = ViewDataBinding.K(i4);
            i = ViewDataBinding.K(i6);
            i11 = ViewDataBinding.K(i5);
            i10 = z2;
            i9 = z;
            i = i7;
            if (Long.compare(i12, i13) != 0) {
            }
            this.O.setOnClickListener(this.g0);
            this.P.setOnClickListener(this.e0);
            this.Q.setOnClickListener(this.f0);
            this.R.setOnClickListener(this.i0);
            this.S.setOnClickListener(this.h0);
            this.T.setOnClickListener(this.d0);
            this.U.setOnClickListener(this.c0);
        }
        if (cmp2 != 0) {
            a.a(this.V, i9);
            a.a(this.W, i11);
            a.a(this.X, i7);
            a.a(this.Y, i);
            a.a(this.Z, i10);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ej
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
