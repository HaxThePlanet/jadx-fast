package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.g.w;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class lj extends app.dogo.com.dogo_android.h.kj implements b.a {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0;
    private final ConstraintLayout X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private long a0;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        lj.c0 = sparseIntArray;
        sparseIntArray.put(2131362986, 8);
        sparseIntArray.put(2131362355, 9);
        sparseIntArray.put(2131363036, 10);
        sparseIntArray.put(2131363387, 11);
    }

    public lj(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 12, lj.b0, lj.c0));
    }

    private lj(e e, View view2, Object[] object3Arr3) {
        final Object obj26 = this;
        super(e, view2, 0, (Button)object3Arr3[7], (ImageView)object3Arr3[9], (CardView)object3Arr3[1], (CardView)object3Arr3[8], (ImageView)object3Arr3[2], (TextView)object3Arr3[3], (TextView)object3Arr3[10], (Button)object3Arr3[6], (TextView)object3Arr3[4], (TextView)object3Arr3[11], (TextView)object3Arr3[5]);
        obj26.a0 = -1;
        int i12 = 0;
        obj26.O.setTag(i12);
        Object obj13 = object3Arr3[0];
        obj26.X = (ConstraintLayout)obj13;
        obj13.setTag(i12);
        obj26.P.setTag(i12);
        obj26.Q.setTag(i12);
        obj26.R.setTag(i12);
        obj26.S.setTag(i12);
        obj26.T.setTag(i12);
        obj26.U.setTag(i12);
        obj26.N(view2);
        b bVar = new b(obj26, 1);
        obj26.Y = bVar;
        b bVar2 = new b(obj26, 2);
        obj26.Z = bVar2;
        A();
    }

    @Override // app.dogo.com.dogo_android.h.kj
    public void A() {
        this.a0 = 4;
        I();
        return;
        synchronized (this) {
            this.a0 = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kj
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.kj
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (94 == i) {
            U((ProgramDescriptionItem)object2);
            obj2 = 1;
        } else {
            if (29 == i) {
                T((w)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.kj
    public void T(w w) {
        this.W = w;
        this.a0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.W = w;
            this.a0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kj
    public void U(ProgramDescriptionItem programDescriptionItem) {
        this.V = programDescriptionItem;
        this.a0 = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.V = programDescriptionItem;
            this.a0 = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kj
    public final void b(int i, View view2) {
        w wVar;
        ProgramDescriptionItem obj3;
        int obj4;
        obj4 = 0;
        final int i2 = 1;
        if (i != i2) {
            if (i != 2) {
            } else {
                obj3 = this.W;
                if (obj3 != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    obj3.d("recommended_program_card");
                }
            }
        } else {
            wVar = this.W;
            if (wVar != null) {
                obj4 = i2;
            }
            if (obj4 != null) {
                wVar.A1(this.V);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.kj
    protected void m() {
        int string;
        int modulesCount;
        int cmp;
        View.OnClickListener list;
        int i6;
        int i3;
        int i5;
        int string2;
        int i2;
        int name;
        Resources resources;
        int i4;
        Object[] arr;
        Object[] arr2;
        int i;
        final Object obj = this;
        long l = obj.a0;
        final int i8 = 0;
        obj.a0 = i8;
        ProgramDescriptionItem programDescriptionItem = obj.V;
        int cmp2 = Long.compare(i10, i8);
        i6 = 0;
        synchronized (this) {
            obj = this;
            l = obj.a0;
            i8 = 0;
            obj.a0 = i8;
            programDescriptionItem = obj.V;
            cmp2 = Long.compare(i10, i8);
            i6 = 0;
        }
        i3 = 0;
        if (programDescriptionItem != null) {
            name = programDescriptionItem.getName();
            modulesCount = programDescriptionItem.getModulesCount();
            i5 = iconUrl;
            i6 = cardBackgroundColor;
            i2 = i;
        } else {
            try {
                name = i5;
                i2 = modulesCount;
                int i13 = 1;
                arr2 = new Object[i13];
                arr2[i3] = Integer.valueOf(i2);
                string2 = obj.T.getResources().getString(2131887593, arr2);
                arr = new Object[i13];
                arr[i3] = Integer.valueOf(modulesCount);
                string = obj.U.getResources().getString(2131887581, arr);
                name = string2;
                if (Long.compare(i7, i8) != 0) {
                }
                obj.O.setOnClickListener(obj.Z);
                obj.S.setOnClickListener(obj.Y);
                if (cmp2 != 0) {
                }
                n.E(obj.P, i6);
                n.w(obj.Q, i5);
                g.c(obj.R, name);
                g.c(obj.T, string2);
                g.c(obj.U, string);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.kj
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
