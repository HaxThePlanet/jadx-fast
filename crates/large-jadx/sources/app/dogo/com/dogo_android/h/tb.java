package app.dogo.com.dogo_android.h;

import android.net.Uri;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import app.dogo.com.dogo_android.dogcreation.h.g;
import app.dogo.com.dogo_android.q.o;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class tb extends app.dogo.com.dogo_android.h.sb {

    private static final ViewDataBinding.g Y;
    private static final SparseIntArray Z;
    private final ConstraintLayout U;
    private final FrameLayout V;
    private final app.dogo.com.dogo_android.h.ok W;
    private long X;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(8);
        tb.Y = gVar;
        int i5 = 1;
        final int[] iArr2 = new int[i5];
        final int i12 = 0;
        iArr2[i12] = 4;
        int[] iArr = new int[i5];
        iArr[i12] = 2131558775;
        gVar.a(3, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        tb.Z = sparseIntArray;
        sparseIntArray.put(2131363433, 5);
        sparseIntArray.put(2131363436, 6);
        sparseIntArray.put(2131363414, 7);
    }

    public tb(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, tb.Y, tb.Z));
    }

    private tb(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (ImageView)object3Arr3[2], (Button)object3Arr3[1], (TextView)object3Arr3[7], (MaterialToolbar)object3Arr3[5], (TextView)object3Arr3[6]);
        this.X = -1;
        int i7 = 0;
        this.O.setTag(i7);
        Object obj11 = object3Arr3[0];
        this.U = (ConstraintLayout)obj11;
        obj11.setTag(i7);
        obj11 = object3Arr3[3];
        this.V = (FrameLayout)obj11;
        obj11.setTag(i7);
        obj11 = object3Arr3[4];
        this.W = (ok)obj11;
        L(obj11);
        this.P.setTag(i7);
        N(view2);
        A();
    }

    private boolean W(x<Uri> x, int i2) {
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

    private boolean X(x<y<DogProfile>> x, int i2) {
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

    @Override // app.dogo.com.dogo_android.h.sb
    public void A() {
        this.X = 8;
        this.W.A();
        I();
        return;
        synchronized (this) {
            this.X = 8;
            this.W.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sb
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return W((x)object2, i3);
        }
        return X((x)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.sb
    public void M(q q) {
        super.M(q);
        this.W.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.sb
    public boolean O(int i, Object object2) {
        int obj2;
        if (177 == i) {
            V((g)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.sb
    public void V(g g) {
        this.T = g;
        this.X = l |= i2;
        notifyPropertyChanged(177);
        super.I();
        return;
        synchronized (this) {
            this.T = g;
            this.X = l |= i2;
            notifyPropertyChanged(177);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.sb
    protected void m() {
        int cmp;
        int value2;
        int cmp3;
        int cmp4;
        int value;
        int i;
        int i2;
        int cmp2;
        long l = this.X;
        final int i4 = 0;
        this.X = i4;
        value2 = this.T;
        final int i7 = 13;
        int i8 = 14;
        i = 0;
        synchronized (this) {
            l = this.X;
            i4 = 0;
            this.X = i4;
            value2 = this.T;
            i7 = 13;
            i8 = 14;
            i = 0;
        }
        try {
            if (Long.compare(i2, i4) != 0) {
            } else {
            }
            if (value2 != null) {
            } else {
            }
            cmp4 = value2.s();
            cmp4 = i;
            Q(0, cmp4);
            if (cmp4 != null) {
            } else {
            }
            value = cmp4.getValue();
            value = i;
        }
        if (Long.compare(i10, i4) != 0) {
            if (value2 != null) {
                value2 = value2.q();
            } else {
                value2 = i;
            }
            Q(1, value2);
            if (value2 != null) {
                i = value2;
            }
        }
        if (Long.compare(i9, i4) != 0) {
            o.P(this.O, i);
        }
        if (Long.compare(i3, i4) != 0) {
            n.x0(this.U, value);
            n.D0(this.V, value);
            n.Z(this.P, value);
        }
        ViewDataBinding.o(this.W);
    }

    @Override // app.dogo.com.dogo_android.h.sb
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.W.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
