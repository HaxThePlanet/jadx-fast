package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem;
import app.dogo.com.dogo_android.repository.domain.LessonCardItem.CardStatus;
import app.dogo.com.dogo_android.y.l;

/* loaded from: classes.dex */
public class z4 extends app.dogo.com.dogo_android.h.y4 {

    private static final ViewDataBinding.g U;
    private static final SparseIntArray V;
    private long T;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        z4.V = sparseIntArray;
        sparseIntArray.put(2131362547, 4);
        sparseIntArray.put(2131362548, 5);
        sparseIntArray.put(2131362549, 6);
    }

    public z4(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, z4.U, z4.V));
    }

    private z4(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (ConstraintLayout)object3Arr3[0], (TextView)object3Arr3[4], (ImageView)object3Arr3[5], (View)object3Arr3[6], (ImageView)object3Arr3[3], (TextView)object3Arr3[2], (TextView)object3Arr3[1]);
        this.T = -1;
        int obj15 = 0;
        this.O.setTag(obj15);
        this.P.setTag(obj15);
        this.Q.setTag(obj15);
        this.R.setTag(obj15);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.y4
    public void A() {
        this.T = 2;
        I();
        return;
        synchronized (this) {
            this.T = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y4
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.y4
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

    @Override // app.dogo.com.dogo_android.h.y4
    public void V(LessonCardItem lessonCardItem) {
        this.S = lessonCardItem;
        this.T = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.S = lessonCardItem;
            this.T = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.y4
    protected void m() {
        Object lessonCardItem;
        long l;
        int cmp;
        int string2;
        int stringBuilder;
        StringBuilder stringBuilder2;
        int cmp2;
        int string;
        int i2;
        int i3;
        int i;
        Resources resources;
        int i5;
        int i6;
        int i4;
        final Object obj = this;
        l = obj.T;
        string2 = 0;
        obj.T = string2;
        lessonCardItem = obj.S;
        final int i9 = 3;
        cmp2 = Long.compare(i10, string2);
        i2 = 0;
        synchronized (this) {
            obj = this;
            l = obj.T;
            string2 = 0;
            obj.T = string2;
            lessonCardItem = obj.S;
            i9 = 3;
            cmp2 = Long.compare(i10, string2);
            i2 = 0;
        }
        if (lessonCardItem != null) {
            i3 = programName;
            string = status;
            i = i4;
        } else {
            try {
                i3 = string;
                i = i2;
                Object[] arr = new Object[1];
                arr[i2] = Integer.valueOf(i);
                if (string == LessonCardItem.CardStatus.COMPLETED) {
                } else {
                }
                i6 = i2;
                cmp2 = 8;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append(obj.R.getResources().getString(2131887594, arr));
            stringBuilder.append(" - ");
            if (i6 != 0) {
            } else {
                i2 = stringBuilder;
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(stringBuilder.toString());
            stringBuilder2.append(i3);
            string = stringBuilder2.toString();
            if (Long.compare(i7, i8) != 0) {
                obj.P.setVisibility(i2);
                l.L(obj.Q, lessonCardItem);
                g.c(obj.R, string);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.y4
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
