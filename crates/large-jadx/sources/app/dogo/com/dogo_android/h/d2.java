package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoObservable;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class d2 extends app.dogo.com.dogo_android.h.c2 implements b.a {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W = null;
    private final LinearLayout R;
    private final ImageView S;
    private final View.OnClickListener T;
    private long U;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(3);
        d2.V = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i6 = 0;
        iArr2[i6] = 2;
        int[] iArr = new int[i3];
        iArr[i6] = 2131558777;
        gVar.a(i6, /* result */, iArr2, iArr);
        int i = 0;
    }

    public d2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, d2.V, d2.W));
    }

    private d2(e e, View view2, Object[] object3Arr3) {
        int i = 2;
        super(e, view2, i, (sk)object3Arr3[i]);
        this.U = -1;
        L(this.O);
        Object obj3 = object3Arr3[0];
        this.R = (LinearLayout)obj3;
        int i3 = 0;
        obj3.setTag(i3);
        obj3 = 1;
        final Object obj5 = object3Arr3[obj3];
        this.S = (ImageView)obj5;
        obj5.setTag(i3);
        N(view2);
        b obj4 = new b(this, obj3);
        this.T = obj4;
        A();
    }

    private boolean X(app.dogo.com.dogo_android.h.sk sk, int i2) {
        if (i2 == 0) {
            this.U = obj3 |= i;
            return 1;
            synchronized (this) {
                this.U = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean Y(EntryPhotoObservable entryPhotoObservable, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.U = l3 |= i9;
            return obj5;
            synchronized (this) {
                this.U = l3 |= i9;
                return obj5;
            }
        }
        if (i2 == 3) {
            this.U = l2 |= i8;
            return obj5;
            synchronized (this) {
                this.U = l2 |= i8;
                return obj5;
            }
        }
        if (i2 == 2) {
            this.U = l |= i7;
            return obj5;
            synchronized (this) {
                this.U = l |= i7;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public void A() {
        this.U = 32;
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.U = 32;
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c2
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((sk)object2, i3);
        }
        return Y((EntryPhotoObservable)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public void M(q q) {
        super.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            W((EntryPhotoObservable)object2);
            obj2 = 1;
        } else {
            if (116 == i) {
                V((a0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public void V(a0 a0) {
        this.Q = a0;
        this.U = l |= i2;
        notifyPropertyChanged(116);
        super.I();
        return;
        synchronized (this) {
            this.Q = a0;
            this.U = l |= i2;
            notifyPropertyChanged(116);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public void W(EntryPhotoObservable entryPhotoObservable) {
        R(0, entryPhotoObservable);
        this.P = entryPhotoObservable;
        this.U = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(0, entryPhotoObservable);
            this.P = entryPhotoObservable;
            this.U = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public final void b(int i, View view2) {
        int i2;
        final EntryPhotoObservable obj2 = this.P;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.onSponsorBannerClick(this.Q);
        }
    }

    @Override // app.dogo.com.dogo_android.h.c2
    protected void m() {
        int cmp3;
        int cmp4;
        int cmp2;
        int adVisible;
        int adImageUrl;
        int cmp;
        int i;
        long l = this.U;
        final int i3 = 0;
        this.U = i3;
        EntryPhotoObservable entryPhotoObservable = this.P;
        adVisible = 0;
        adImageUrl = 0;
        final int i6 = 49;
        int i7 = 41;
        synchronized (this) {
            l = this.U;
            i3 = 0;
            this.U = i3;
            entryPhotoObservable = this.P;
            adVisible = 0;
            adImageUrl = 0;
            i6 = 49;
            i7 = 41;
        }
        try {
            if (Long.compare(i11, i3) != 0) {
            }
            if (entryPhotoObservable != null) {
            }
            adVisible = entryPhotoObservable.getAdVisible();
            if (Long.compare(i, i3) != 0 && entryPhotoObservable != null) {
            }
            if (entryPhotoObservable != null) {
            }
            adImageUrl = entryPhotoObservable.getAdImageUrl();
        }
        this.S.setOnClickListener(this.T);
        if (Long.compare(i8, i3) != 0) {
            this.S.setVisibility(adVisible);
        }
        if (Long.compare(i2, i3) != 0) {
            n.w(this.S, adImageUrl);
        }
        ViewDataBinding.o(this.O);
    }

    @Override // app.dogo.com.dogo_android.h.c2
    public boolean y() {
        final int i2 = 1;
        synchronized (this) {
            try {
                return i2;
                if (this.O.y()) {
                }
                return i2;
                return 0;
                throw th;
            }
        }
    }
}
