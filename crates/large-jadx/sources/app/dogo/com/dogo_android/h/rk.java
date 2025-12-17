package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.q.p.v;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;

/* loaded from: classes.dex */
public class rk extends app.dogo.com.dogo_android.h.qk implements b.a {

    private static final ViewDataBinding.g b0;
    private static final SparseIntArray c0 = null;
    private final ConstraintLayout X;
    private final View.OnClickListener Y;
    private final View.OnClickListener Z;
    private long a0;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(8);
        rk.b0 = gVar;
        String str = "layout_profile_data_row";
        int i4 = 4;
        final int[] iArr2 = new int[i4];
        iArr2 = new int[]{4, 5, 6, 7};
        int[] iArr = new int[i4];
        iArr = new int[]{2131558794, 2131558794, 2131558794, 2131558794};
        gVar.a(1, /* result */, iArr2, iArr);
        int i = 0;
    }

    public rk(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, rk.b0, rk.c0));
    }

    private rk(e e, View view2, Object[] object3Arr3) {
        final Object obj17 = this;
        final int i10 = 2;
        final int i11 = 1;
        super(e, view2, 4, (yl)object3Arr3[6], (yl)object3Arr3[5], (Button)object3Arr3[3], (Button)object3Arr3[i10], (yl)object3Arr3[7], (LinearLayout)object3Arr3[i11], (yl)object3Arr3[4]);
        obj17.a0 = -1;
        L(obj17.O);
        L(obj17.P);
        int i8 = 0;
        obj17.Q.setTag(i8);
        obj17.R.setTag(i8);
        L(obj17.S);
        obj17.T.setTag(i8);
        Object obj8 = object3Arr3[0];
        obj17.X = (ConstraintLayout)obj8;
        obj8.setTag(i8);
        L(obj17.U);
        N(view2);
        b bVar = new b(this, i10);
        obj17.Y = bVar;
        b bVar2 = new b(this, i11);
        obj17.Z = bVar2;
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.yl yl, int i2) {
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

    private boolean Y(app.dogo.com.dogo_android.h.yl yl, int i2) {
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

    private boolean Z(app.dogo.com.dogo_android.h.yl yl, int i2) {
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

    private boolean a0(app.dogo.com.dogo_android.h.yl yl, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.qk
    public void A() {
        this.a0 = 64;
        this.U.A();
        this.P.A();
        this.O.A();
        this.S.A();
        I();
        return;
        synchronized (this) {
            this.a0 = 64;
            this.U.A();
            this.P.A();
            this.O.A();
            this.S.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qk
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1 && i != 2 && i != 3) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return 0;
                    }
                    return Y((yl)object2, i3);
                }
                return X((yl)object2, i3);
            }
            return a0((yl)object2, i3);
        }
        return Z((yl)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public void M(q q) {
        super.M(q);
        this.U.M(q);
        this.P.M(q);
        this.O.M(q);
        this.S.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (29 == i) {
            V((v)object2);
            obj2 = 1;
        } else {
            if (127 == i) {
                W((ProfilePreview)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public void V(v v) {
        this.V = v;
        this.a0 = l |= i2;
        notifyPropertyChanged(29);
        super.I();
        return;
        synchronized (this) {
            this.V = v;
            this.a0 = l |= i2;
            notifyPropertyChanged(29);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public void W(ProfilePreview profilePreview) {
        this.W = profilePreview;
        this.a0 = l |= i2;
        notifyPropertyChanged(127);
        super.I();
        return;
        synchronized (this) {
            this.W = profilePreview;
            this.a0 = l |= i2;
            notifyPropertyChanged(127);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public final void b(int i, View view2) {
        ProfilePreview profilePreview;
        v obj3;
        int obj4;
        obj4 = 0;
        final int i2 = 1;
        if (i != i2) {
            if (i != 2) {
            } else {
                obj3 = this.V;
                if (obj3 != null) {
                    obj4 = i2;
                }
                if (obj4 != null) {
                    obj3.a1(this.W);
                }
            }
        } else {
            obj3 = this.V;
            if (obj3 != null) {
                obj4 = i2;
            }
            if (obj4 != null) {
                obj3.n(this.W);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.qk
    protected void m() {
        long l;
        int cmp3;
        int cmp2;
        int cmp;
        int i3;
        app.dogo.com.dogo_android.h.yl ylVar;
        int i4;
        app.dogo.com.dogo_android.h.yl ylVar2;
        int i2;
        boolean userDogsCreator;
        int string;
        int i;
        l = this.a0;
        final int i6 = 0;
        this.a0 = i6;
        final ProfilePreview profilePreview = this.W;
        i3 = 112;
        int i8 = 96;
        synchronized (this) {
            l = this.a0;
            i6 = 0;
            this.a0 = i6;
            profilePreview = this.W;
            i3 = 112;
            i8 = 96;
        }
        try {
            cmp3 = Long.compare(userDogsCreator, i6);
            if (profilePreview != null) {
            } else {
            }
            userDogsCreator = profilePreview.isUserDogsCreator();
            userDogsCreator = i2;
            i = 256;
        }
        if (Long.compare(string, i6) != 0) {
            this.O.U(w().getResources().getString(2131886463));
            this.O.V(w().getResources().getString(2131886457));
            this.P.U(w().getResources().getString(2131886481));
            this.P.V(w().getResources().getString(2131886461));
            this.Q.setOnClickListener(this.Y);
            this.R.setOnClickListener(this.Z);
            this.S.U(w().getResources().getString(2131886482));
            this.S.V(w().getResources().getString(2131886465));
            this.U.U(w().getResources().getString(2131886464));
            this.U.V(w().getResources().getString(2131886462));
        }
        if (Long.compare(i4, i6) != 0) {
            this.R.setVisibility(i2);
        }
        if (Long.compare(i5, i6) != 0) {
            o.S(this.T, profilePreview, this.U, this.P, this.O, this.S, this.V);
        }
        ViewDataBinding.o(this.U);
        ViewDataBinding.o(this.P);
        ViewDataBinding.o(this.O);
        ViewDataBinding.o(this.S);
    }

    @Override // app.dogo.com.dogo_android.h.qk
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.U.y()) {
                }
                return i2;
                if (this.P.y()) {
                }
                return i2;
                if (this.O.y()) {
                }
                return i2;
                if (this.S.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
