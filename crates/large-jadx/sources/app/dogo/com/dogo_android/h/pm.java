package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.n.m.t.g;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class pm extends app.dogo.com.dogo_android.h.om implements b.a {

    private static final ViewDataBinding.g a0;
    private static final SparseIntArray b0;
    private final ConstraintLayout X;
    private final View.OnClickListener Y;
    private long Z;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(17);
        pm.a0 = gVar;
        int i12 = 1;
        final int[] iArr2 = new int[i12];
        final int i25 = 0;
        iArr2[i25] = 6;
        int[] iArr = new int[i12];
        iArr[i25] = 2131558812;
        gVar.a(i25, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        pm.b0 = sparseIntArray;
        sparseIntArray.put(2131363441, 7);
        sparseIntArray.put(2131361941, 8);
        sparseIntArray.put(2131361942, 9);
        sparseIntArray.put(2131361943, 10);
        sparseIntArray.put(2131361944, 11);
        sparseIntArray.put(2131361945, 12);
        sparseIntArray.put(2131363479, 13);
        sparseIntArray.put(2131362334, 14);
        sparseIntArray.put(2131362562, 15);
        sparseIntArray.put(2131362330, 16);
    }

    public pm(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 17, pm.a0, pm.b0));
    }

    private pm(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 3, (ImageView)object3Arr3[8], (ImageView)object3Arr3[9], (ImageView)object3Arr3[10], (ImageView)object3Arr3[11], (ImageView)object3Arr3[12], (LinearLayout)object3Arr3[4], (MaterialTextView)object3Arr3[3], (ImageView)object3Arr3[16], (ImageView)object3Arr3[14], (TextView)object3Arr3[15], (an)object3Arr3[6], (TextView)object3Arr3[5], (MaterialToolbar)object3Arr3[7], (ImageView)object3Arr3[1], (TrickRatingBar)object3Arr3[13], (TextView)object3Arr3[2]);
        Object obj4 = this;
        obj4.Z = -1;
        int i3 = 0;
        obj4.O.setTag(i3);
        obj4.P.setTag(i3);
        obj4.L(obj4.Q);
        Object obj2 = object3Arr3[0];
        obj4.X = (ConstraintLayout)obj2;
        obj2.setTag(i3);
        obj4.R.setTag(i3);
        obj4.T.setTag(i3);
        obj4.V.setTag(i3);
        obj4.N(view2);
        b bVar = new b(obj4, 1);
        obj4.Y = bVar;
        A();
    }

    private boolean U(app.dogo.com.dogo_android.h.an an, int i2) {
        if (i2 == 0) {
            this.Z = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Z = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean V(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.Z = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Z = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean W(x<Integer> x, int i2) {
        if (i2 == 0) {
            this.Z = obj3 |= i;
            return 1;
            synchronized (this) {
                this.Z = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    @Override // app.dogo.com.dogo_android.h.om
    public void A() {
        this.Z = 16;
        this.Q.A();
        I();
        return;
        synchronized (this) {
            this.Z = 16;
            this.Q.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.om
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2) {
            if (i != 1) {
                if (i != 2) {
                    return 0;
                }
                return U((an)object2, i3);
            }
            return W((x)object2, i3);
        }
        return V((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.om
    public void M(q q) {
        super.M(q);
        this.Q.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.om
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            T((g)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.om
    public void T(g g) {
        this.W = g;
        this.Z = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.W = g;
            this.Z = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.om
    public final void b(int i, View view2) {
        int obj2;
        final g obj1 = this.W;
        obj2 = obj1 != null ? 1 : 0;
        if (obj2 != null) {
            obj1.F();
        }
    }

    @Override // app.dogo.com.dogo_android.h.om
    protected void m() {
        int i11;
        TrickItem trickItem;
        int i8;
        long l;
        int cmp3;
        int i3;
        x xVar;
        Object value;
        int i9;
        int i12;
        int i2;
        int cmp5;
        int cmp4;
        LinearLayout linearLayout;
        int cmp2;
        com.google.android.material.textview.MaterialTextView view;
        int i10;
        int i5;
        int value2;
        x cmp;
        int i6;
        int name;
        DogProfile dogProfile;
        int description;
        int i;
        Long num;
        int i4;
        int i7;
        String str;
        final Object obj = this;
        l = obj.Z;
        final int i14 = 0;
        obj.Z = i14;
        g gVar = obj.W;
        int i19 = 25;
        int i24 = 26;
        i10 = 0;
        synchronized (this) {
            obj = this;
            l = obj.Z;
            i14 = 0;
            obj.Z = i14;
            gVar = obj.W;
            i19 = 25;
            i24 = 26;
            i10 = 0;
        }
        if (Long.compare(i27, i14) != 0) {
            if (gVar != null) {
                try {
                    xVar = gVar.q();
                    xVar = 0;
                    obj.Q(i10, xVar);
                    if (xVar != null) {
                    } else {
                    }
                    value = xVar.getValue();
                    value = 0;
                    i9 = ViewDataBinding.J(value);
                    i9 = i10;
                }
            } else {
            }
        } else {
        }
        int i26 = 1;
        if (Long.compare(i28, i14) != 0) {
            if (gVar != null) {
                cmp = gVar.v();
            } else {
                cmp = 0;
            }
            obj.Q(i26, cmp);
            if (cmp != null) {
                value2 = cmp.getValue();
            } else {
                value2 = 0;
            }
        } else {
        }
        if (gVar != null) {
            dogProfile = gVar.s();
        } else {
            dogProfile = 0;
        }
        if (dogProfile != null) {
            name = dogProfile.getName();
        } else {
            name = 0;
        }
        description = Long.compare(i29, i14);
        if (description != 0) {
            if (gVar != null) {
                num = gVar.r();
                trickItem = gVar.C();
            } else {
                trickItem = 0;
                num = 0;
            }
            i4 = num == null ? i26 : i10;
            if (description != 0) {
                i7 = i4 != 0 ? 64 : 32;
                l |= i7;
            }
            if (trickItem != null) {
                description = trickItem.getDescription();
                i6 = name2;
                i8 = str;
            } else {
                i8 = 0;
                i6 = 0;
                description = 0;
            }
            i = i4 != 0 ? 8 : i10;
            Object[] arr = new Object[i26];
            arr[i10] = i6;
            i12 = i8;
            i10 = i9;
            i2 = string;
            i5 = name;
            i3 = description;
            i11 = i;
        } else {
            i11 = i10;
            i5 = name;
            i12 = 0;
            i2 = 0;
            i10 = i9;
            i3 = 0;
        }
        if (Long.compare(i25, i14) != 0) {
            cmp2 = obj.O;
            n.A(cmp2, cmp2, obj.P, i5, value2);
        }
        if (Long.compare(i20, i14) != 0) {
            n.h0(obj.P, i10, obj.O, i5);
        }
        if (Long.compare(i22, i14) != 0) {
            obj.Q.w().setOnClickListener(obj.Y);
        }
        if (Long.compare(i13, i14) != 0) {
            obj.Q.w().setVisibility(i11);
            l.w(obj.R, i3);
            n.n0(obj.T, i12);
            g.c(obj.V, i2);
        }
        ViewDataBinding.o(obj.Q);
    }

    @Override // app.dogo.com.dogo_android.h.om
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.Q.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
