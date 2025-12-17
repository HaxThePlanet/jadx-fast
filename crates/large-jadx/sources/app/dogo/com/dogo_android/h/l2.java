package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.lifecycle.q;
import app.dogo.com.dogo_android.l.a.b;
import app.dogo.com.dogo_android.l.a.b.a;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryPhotoBaseObservable;
import app.dogo.com.dogo_android.model.entry_list_item_models.EntryUserPhotoObservable;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public class l2 extends app.dogo.com.dogo_android.h.k2 implements b.a {

    private static final ViewDataBinding.g a0;
    private static final SparseIntArray b0;
    private final LinearLayout W;
    private final LinearLayout X;
    private final View.OnClickListener Y;
    private long Z;
    static {
        ViewDataBinding.g gVar = new ViewDataBinding.g(8);
        l2.a0 = gVar;
        int i3 = 1;
        final int[] iArr2 = new int[i3];
        final int i7 = 0;
        iArr2[i7] = 6;
        int[] iArr = new int[i3];
        iArr[i7] = 2131558777;
        gVar.a(i7, /* result */, iArr2, iArr);
        SparseIntArray sparseIntArray = new SparseIntArray();
        l2.b0 = sparseIntArray;
        sparseIntArray.put(2131362485, 7);
    }

    public l2(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, l2.a0, l2.b0));
    }

    private l2(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 2, (sk)object3Arr3[6], (TextView)object3Arr3[5], (LinearLayout)object3Arr3[7], (ConstraintLayout)object3Arr3[4], (TextView)object3Arr3[3], (TextView)object3Arr3[2]);
        this.Z = -1;
        L(this.O);
        int i8 = 0;
        this.P.setTag(i8);
        this.R.setTag(i8);
        Object obj12 = object3Arr3[0];
        this.W = (LinearLayout)obj12;
        obj12.setTag(i8);
        obj12 = 1;
        Object obj14 = object3Arr3[obj12];
        this.X = (LinearLayout)obj14;
        obj14.setTag(i8);
        this.S.setTag(i8);
        this.T.setTag(i8);
        N(view2);
        b obj13 = new b(this, obj12);
        this.Y = obj13;
        A();
    }

    private boolean Y(app.dogo.com.dogo_android.h.sk sk, int i2) {
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

    private boolean Z(EntryUserPhotoObservable entryUserPhotoObservable, int i2) {
        int obj5 = 1;
        if (i2 == 0) {
            this.Z = l4 |= i12;
            return obj5;
            synchronized (this) {
                this.Z = l4 |= i12;
                return obj5;
            }
        }
        if (i2 == 130) {
            this.Z = l3 |= i11;
            return obj5;
            synchronized (this) {
                this.Z = l3 |= i11;
                return obj5;
            }
        }
        if (i2 == 114) {
            this.Z = l |= i9;
            return obj5;
            synchronized (this) {
                this.Z = l |= i9;
                return obj5;
            }
        }
        if (i2 == 129) {
            this.Z = l2 |= i10;
            return obj5;
            synchronized (this) {
                this.Z = l2 |= i10;
                return obj5;
            }
        }
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public void A() {
        this.Z = 64;
        this.O.A();
        I();
        return;
        synchronized (this) {
            this.Z = 64;
            this.O.A();
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k2
    protected boolean E(int i, Object object2, int i3) {
        if (i != 0 && i != 1) {
            if (i != 1) {
                return 0;
            }
            return Z((EntryUserPhotoObservable)object2, i3);
        }
        return Y((sk)object2, i3);
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public void M(q q) {
        super.M(q);
        this.O.M(q);
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (183 == i) {
            X((EntryUserPhotoObservable)object2);
            obj2 = 1;
        } else {
            if (116 == i) {
                W((a0)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public void W(a0 a0) {
        this.V = a0;
        this.Z = l |= i2;
        notifyPropertyChanged(116);
        super.I();
        return;
        synchronized (this) {
            this.V = a0;
            this.Z = l |= i2;
            notifyPropertyChanged(116);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public void X(EntryUserPhotoObservable entryUserPhotoObservable) {
        R(1, entryUserPhotoObservable);
        this.U = entryUserPhotoObservable;
        this.Z = l |= i3;
        notifyPropertyChanged(183);
        super.I();
        return;
        synchronized (this) {
            R(1, entryUserPhotoObservable);
            this.U = entryUserPhotoObservable;
            this.Z = l |= i3;
            notifyPropertyChanged(183);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k2
    public final void b(int i, View view2) {
        int i2;
        final EntryUserPhotoObservable obj2 = this.U;
        i2 = obj2 != null ? 1 : 0;
        if (i2 != 0) {
            obj2.showEntryFans(this.V);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k2
    protected void m() {
        int i6;
        int cmp5;
        int cmp4;
        long l;
        int rankText;
        int cmp;
        int i5;
        int cmp3;
        String string;
        int i7;
        Object[] arr;
        int cmp2;
        int i;
        int i2;
        Resources resources;
        int i3;
        Integer valueOf;
        int fanCount;
        int rankVisibility;
        int i8;
        int i4;
        final Object obj = this;
        l = obj.Z;
        final int i10 = 0;
        obj.Z = i10;
        EntryUserPhotoObservable entryUserPhotoObservable = obj.U;
        int i13 = 98;
        int i16 = 82;
        int i21 = 66;
        i3 = 0;
        synchronized (this) {
            obj = this;
            l = obj.Z;
            i10 = 0;
            obj.Z = i10;
            entryUserPhotoObservable = obj.U;
            i13 = 98;
            i16 = 82;
            i21 = 66;
            i3 = 0;
        }
        if (Long.compare(i24, i10) != 0 && entryUserPhotoObservable != null) {
            if (entryUserPhotoObservable != null) {
                try {
                    rankText = entryUserPhotoObservable.getRankText();
                    rankText = 0;
                    if (entryUserPhotoObservable != null) {
                    } else {
                    }
                    fanCount = entryUserPhotoObservable.getFanCount();
                    rankVisibility = entryUserPhotoObservable.getRankVisibility();
                    rankVisibility = fanCount;
                    arr = new Object[1];
                    arr[i3] = Integer.valueOf(fanCount);
                    string = obj.P.getResources().getString(2131886283, arr);
                }
                rankVisibility = i3;
                string = 0;
                int cmp8 = Long.compare(i4, i10);
                if (cmp8 != 0) {
                    if (entryUserPhotoObservable != null) {
                        resources = entryUserPhotoObservable.isPublished();
                    } else {
                        resources = i3;
                    }
                    if (cmp8 != 0) {
                        i4 = resources != 0 ? 256 : 128;
                        l |= i4;
                    }
                    if (resources != 0) {
                    } else {
                        i3 = 8;
                    }
                }
                if (Long.compare(i8, i10) != 0 && entryUserPhotoObservable != null) {
                    if (entryUserPhotoObservable != null) {
                        i6 = motivationalText;
                        i7 = i3;
                        i2 = string;
                        i5 = rankVisibility;
                    } else {
                        i2 = string;
                        i7 = i3;
                        i5 = rankVisibility;
                        i6 = 0;
                    }
                } else {
                }
                if (Long.compare(i22, i10) != 0) {
                    g.c(obj.P, i2);
                    obj.X.setVisibility(i5);
                }
                if (Long.compare(i, i10) != 0) {
                    obj.R.setOnClickListener(obj.Y);
                }
                if (Long.compare(i17, i10) != 0) {
                    g.c(obj.S, i6);
                }
                if (Long.compare(i14, i10) != 0) {
                    obj.S.setVisibility(i7);
                }
                if (Long.compare(i9, i10) != 0) {
                    g.c(obj.T, rankText);
                }
                ViewDataBinding.o(obj.O);
            } else {
            }
        } else {
        }
    }

    @Override // app.dogo.com.dogo_android.h.k2
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
