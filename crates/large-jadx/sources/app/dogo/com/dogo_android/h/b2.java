package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryOldPhotoObservable;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class b2 extends app.dogo.com.dogo_android.h.a2 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X = null;
    private final ConstraintLayout S;
    private final TextView T;
    private final TextView U;
    private long V;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(6);
        b2.W = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i6 = 0;
        iArr2[i6] = 5;
        int[] iArr = new int[i3];
        iArr[i6] = 2131558777;
        gVar.a(i6, /* result */, iArr2, iArr);
        int i = 0;
    }

    public b2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, b2.W, b2.X));
    }

    private b2(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (sk)object3Arr3[5], (ImageView)object3Arr3[4], (RelativeLayout)object3Arr3[1]);
        this.V = -1;
        L(this.O);
        Object obj9 = object3Arr3[0];
        this.S = (ConstraintLayout)obj9;
        int i5 = 0;
        obj9.setTag(i5);
        obj9 = object3Arr3[2];
        this.T = (TextView)obj9;
        obj9.setTag(i5);
        obj9 = object3Arr3[3];
        this.U = (TextView)obj9;
        obj9.setTag(i5);
        this.P.setTag(i5);
        this.Q.setTag(i5);
        N(view2);
        A();
    }

    private boolean W(app.dogo.com.dogo_android.h.sk sk, int i2) {
        if (i2 == 0) {
            this.V = obj3 |= i;
            return 1;
            synchronized (this) {
                this.V = obj3 |= i;
                return 1;
            }
        }
        try {
            return 0;
        }
    }

    private boolean X(EntryOldPhotoObservable entryOldPhotoObservable, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.V = l5 |= i15;
            return obj5;
            synchronized (this) {
                this.V = l5 |= i15;
                return obj5;
            }
        }
        if (i2 == 187) {
            this.V = l4 |= i14;
            return obj5;
            synchronized (this) {
                this.V = l4 |= i14;
                return obj5;
            }
        }
        if (i2 == 71) {
            this.V = l |= i11;
            return obj5;
            synchronized (this) {
                this.V = l |= i11;
                return obj5;
            }
        }
        if (i2 == 188) {
            this.V = l2 |= i12;
            return obj5;
            synchronized (this) {
                this.V = l2 |= i12;
                return obj5;
            }
        }
        if (i2 == 107) {
            this.V = l3 |= i13;
            return obj5;
            synchronized (this) {
                this.V = l3 |= i13;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.a2
    public void A() {
        this.V = 64;
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.V = 64;
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a2
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return X((EntryOldPhotoObservable)object2, i3);
        }
        return W((sk)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.a2
    public void M(q q) {
        super.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.a2
    public boolean O(int i, Object object2) {
        int obj2;
        if (183 == i) {
            V((EntryOldPhotoObservable)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.a2
    public void V(EntryOldPhotoObservable entryOldPhotoObservable) {
        R(1, entryOldPhotoObservable);
        this.R = entryOldPhotoObservable;
        this.V = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(1, entryOldPhotoObservable);
            this.R = entryOldPhotoObservable;
            this.V = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.a2
    protected void m() {
        EntryOldPhotoObservable cmp5;
        int i4;
        long l;
        int cmp8;
        int winnerString;
        int cmp3;
        int cmp2;
        int cmp6;
        int i;
        int cmp4;
        int i6;
        int firstRunnerUp;
        int cmp;
        int medalUrl;
        int i3;
        int i2;
        int firstRunnerUp2;
        int cmp7;
        int winner;
        int i7;
        int i5;
        int i8;
        int i9;
        final Object obj = this;
        l = obj.V;
        final int i11 = 0;
        obj.V = i11;
        cmp5 = obj.R;
        int i18 = 4096;
        final int i20 = 2048;
        final int i22 = 82;
        int i23 = 128;
        medalUrl = 0;
        i3 = 8;
        final int i25 = 70;
        final int i26 = 74;
        final int i27 = 78;
        final int i28 = 0;
        synchronized (this) {
            obj = this;
            l = obj.V;
            i11 = 0;
            obj.V = i11;
            cmp5 = obj.R;
            i18 = 4096;
            i20 = 2048;
            i22 = 82;
            i23 = 128;
            medalUrl = 0;
            i3 = 8;
            i25 = 70;
            i26 = 74;
            i27 = 78;
            i28 = 0;
        }
        if (Long.compare(i29, i11) != 0 && cmp5 != null) {
            if (cmp5 != null) {
                try {
                    winnerString = cmp5.getWinnerString();
                    winnerString = medalUrl;
                    int cmp12 = Long.compare(i30, i11);
                    if (cmp5 != null) {
                    } else {
                    }
                    firstRunnerUp2 = cmp5.isFirstRunnerUp();
                    firstRunnerUp2 = i28;
                }
                firstRunnerUp2 = i2;
                if (Long.compare(i31, i11) != 0 && cmp5 != null) {
                    if (cmp5 != null) {
                        medalUrl = cmp5.getMedalUrl();
                    }
                }
                cmp7 = Long.compare(i32, i11);
                if (cmp7 != 0) {
                    if (cmp5 != null) {
                        winner = cmp5.isWinner();
                    } else {
                        winner = i28;
                    }
                    if (cmp7 != 0) {
                        l = winner != 0 ? l | i7 : l | i23;
                    }
                    if (Long.compare(i5, i11) != 0) {
                        i5 = winner != 0 ? 1024 : 512;
                        l |= i5;
                    }
                    if (Long.compare(i7, i11) != 0) {
                        cmp7 = winner != 0 ? i28 : i3;
                        i8 = medalUrl;
                        i6 = i2;
                        firstRunnerUp = firstRunnerUp2;
                        i9 = cmp7;
                    } else {
                        i8 = medalUrl;
                        i9 = i28;
                        i6 = i2;
                        firstRunnerUp = firstRunnerUp2;
                    }
                } else {
                    i8 = medalUrl;
                    i9 = winner;
                }
                if (Long.compare(i24, i11) != 0 && cmp5 != null) {
                    if (cmp5 != null) {
                        firstRunnerUp = cmp5.isFirstRunnerUp();
                    }
                    if (Long.compare(cmp, i11) != 0) {
                        l = firstRunnerUp != 0 ? l | i18 : l | i20;
                    }
                }
                int cmp9 = Long.compare(i, i11);
                if (cmp9 != 0) {
                    if (winner != 0) {
                        firstRunnerUp = 1;
                    }
                    if (cmp9 != 0) {
                        i = firstRunnerUp != 0 ? 16384 : 8192;
                        l |= i;
                    }
                    if (firstRunnerUp != 0) {
                        i3 = i28;
                    }
                    i4 = i3;
                } else {
                    i4 = i28;
                }
                if (Long.compare(i19, i11) != 0) {
                    g.c(obj.T, winnerString);
                }
                if (Long.compare(i14, i11) != 0) {
                    cmp4 = i9;
                    obj.T.setVisibility(cmp4);
                    obj.P.setVisibility(cmp4);
                }
                if (Long.compare(i15, i11) != 0) {
                    obj.U.setVisibility(i6);
                }
                if (Long.compare(i17, i11) != 0) {
                    n.w(obj.P, i8);
                }
                if (Long.compare(i10, i11) != 0) {
                    obj.Q.setVisibility(i4);
                }
                ViewDataBinding.o(obj.O);
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.a2
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
