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
public class j5 extends app.dogo.com.dogo_android.h.i5 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final CardView U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        j5.X = sparseIntArray;
        sparseIntArray.put(2131361950, 6);
        sparseIntArray.put(2131362190, 7);
    }

    public j5(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 8, j5.W, j5.X));
    }

    private j5(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ImageView)object3Arr3[6], (ImageView)object3Arr3[1], (ImageView)object3Arr3[2], (ImageView)object3Arr3[7], (TextView)object3Arr3[5], (TextView)object3Arr3[3], (TextView)object3Arr3[4]);
        this.V = -1;
        int i9 = 0;
        this.O.setTag(i9);
        this.P.setTag(i9);
        Object obj13 = object3Arr3[0];
        this.U = (CardView)obj13;
        obj13.setTag(i9);
        this.Q.setTag(i9);
        this.R.setTag(i9);
        this.S.setTag(i9);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.i5
    public void A() {
        this.V = 2;
        I();
        return;
        synchronized (this) {
            this.V = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.i5
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.i5
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

    @Override // app.dogo.com.dogo_android.h.i5
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

    @Override // app.dogo.com.dogo_android.h.i5
    protected void m() {
        long l;
        int cmp2;
        int i4;
        int i9;
        int cmp;
        int cmp3;
        int i5;
        int i6;
        int i2;
        int i;
        int i7;
        int i8;
        int i10;
        LessonCardItem.CardStatus iN_PROGRESS;
        int i3;
        l = this.V;
        final int i12 = 0;
        this.V = i12;
        final LessonCardItem lessonCardItem = this.T;
        final int i13 = 3;
        cmp = Long.compare(i14, i12);
        i5 = 0;
        i2 = 0;
        synchronized (this) {
            l = this.V;
            i12 = 0;
            this.V = i12;
            lessonCardItem = this.T;
            i13 = 3;
            cmp = Long.compare(i14, i12);
            i5 = 0;
            i2 = 0;
        }
        try {
            if (lessonCardItem != null) {
            } else {
            }
            i = description;
            i5 = i3;
            i = i5;
            if (i5 == LessonCardItem.CardStatus.COMPLETED) {
            } else {
            }
            i8 = i10;
            i8 = i2;
        }
        if (cmp != 0) {
            if (i8 != 0) {
                l |= i17;
                cmp = 128;
            } else {
                l |= i18;
                cmp = 64;
            }
            i4 |= cmp;
        }
        if (Long.compare(i15, i12) != 0) {
            cmp3 = i10 != 0 ? 32 : 16;
            l |= cmp3;
        }
        i6 = i8 != 0 ? R.color.lightBackgroundGreen : R.color.white;
        i7 = i8 != 0 ? R.drawable.ic_program_active_checkmark : R.drawable.ic_program_disabled_checkmark;
        i5 = a.d(this.P.getContext(), i7);
        if (i10 != 0) {
        } else {
            i2 = 8;
        }
        i2 = i16;
        i9 = i3;
        if (Long.compare(i11, i12) != 0) {
            l.K(this.O, lessonCardItem);
            h.a(this.P, i5);
            this.U.setCardBackgroundColor(i2);
            g.c(this.Q, i);
            l.L(this.R, lessonCardItem);
            this.S.setVisibility(i9);
        }
    }

    @Override // app.dogo.com.dogo_android.h.i5
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
