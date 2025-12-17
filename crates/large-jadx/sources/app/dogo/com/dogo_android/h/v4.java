package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import androidx.databinding.k.h;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus;
import app.dogo.com.dogo_android.y.l;
import d.a.k.a.a;

/* loaded from: classes.dex */
public class v4 extends app.dogo.com.dogo_android.h.u4 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final CardView U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        v4.X = sparseIntArray;
        sparseIntArray.put(2131363013, 6);
    }

    public v4(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, v4.W, v4.X));
    }

    private v4(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[1], (ImageView)object3Arr3[2], (ImageView)object3Arr3[6], (TextView)object3Arr3[5], (TextView)object3Arr3[3], (TextView)object3Arr3[4]);
        this.V = -1;
        int i8 = 0;
        this.O.setTag(i8);
        this.P.setTag(i8);
        Object obj12 = object3Arr3[0];
        this.U = (CardView)obj12;
        obj12.setTag(i8);
        this.Q.setTag(i8);
        this.R.setTag(i8);
        this.S.setTag(i8);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.u4
    public void A() {
        this.V = 2;
        I();
        return;
        synchronized (this) {
            this.V = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u4
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.u4
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((LessonCardItem)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.u4
    public void V(LessonCardItem lessonCardItem) {
        this.T = lessonCardItem;
        this.V = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.T = lessonCardItem;
            this.V = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.u4
    protected void m() {
        long l;
        int cmp3;
        int i8;
        int i9;
        int cmp;
        int cmp2;
        int i;
        int i10;
        int i6;
        int i7;
        int i5;
        int i4;
        int i2;
        LessonCardItem.CardStatus iN_PROGRESS;
        int i3;
        l = this.V;
        final int i12 = 0;
        this.V = i12;
        final LessonCardItem lessonCardItem = this.T;
        final int i13 = 3;
        cmp = Long.compare(i14, i12);
        i = 0;
        i6 = 0;
        synchronized (this) {
            l = this.V;
            i12 = 0;
            this.V = i12;
            lessonCardItem = this.T;
            i13 = 3;
            cmp = Long.compare(i14, i12);
            i = 0;
            i6 = 0;
        }
        try {
            if (lessonCardItem != null) {
            } else {
            }
            i7 = description;
            i = i3;
            i7 = i;
            if (i == LessonCardItem.CardStatus.COMPLETED) {
            } else {
            }
            i4 = i2;
            i4 = i6;
        }
        if (cmp != 0) {
            if (i4 != 0) {
                l |= i17;
                cmp = 128;
            } else {
                l |= i18;
                cmp = 64;
            }
            i8 |= cmp;
        }
        if (Long.compare(i15, i12) != 0) {
            cmp2 = i2 != 0 ? 32 : 16;
            l |= cmp2;
        }
        i10 = i4 != 0 ? R.color.lightBackgroundGreen : R.color.white;
        i5 = i4 != 0 ? R.drawable.ic_program_active_checkmark : R.drawable.ic_program_disabled_checkmark;
        i = a.d(this.P.getContext(), i5);
        if (i2 != 0) {
        } else {
            i6 = 8;
        }
        i6 = i16;
        i9 = i3;
        if (Long.compare(i11, i12) != 0) {
            l.K(this.O, lessonCardItem);
            h.a(this.P, i);
            this.U.setCardBackgroundColor(i6);
            g.c(this.Q, i7);
            l.L(this.R, lessonCardItem);
            this.S.setVisibility(i9);
        }
    }

    @Override // app.dogo.com.dogo_android.h.u4
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
