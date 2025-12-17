package app.dogo.com.dogo_android.h;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.LessonIntroduction;

/* loaded from: classes.dex */
public class d5 extends app.dogo.com.dogo_android.h.c5 {

    private static final ViewDataBinding.g T;
    private static final SparseIntArray U;
    private final FrameLayout R;
    private long S;
    static {
    }

    public d5(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 3, d5.T, d5.U));
    }

    private d5(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (TextView)object3Arr3[2], (TextView)object3Arr3[1]);
        this.S = -1;
        int i4 = 0;
        this.O.setTag(i4);
        Object obj8 = object3Arr3[0];
        this.R = (FrameLayout)obj8;
        obj8.setTag(i4);
        this.P.setTag(i4);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.c5
    public void A() {
        this.S = 2;
        I();
        return;
        synchronized (this) {
            this.S = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c5
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.c5
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((LessonIntroduction)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.c5
    public void V(LessonIntroduction lessonIntroduction) {
        this.Q = lessonIntroduction;
        this.S = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.Q = lessonIntroduction;
            this.S = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.c5
    protected void m() {
        int cmp;
        int i;
        int i2;
        String str;
        int i4 = 0;
        this.S = i4;
        final LessonIntroduction lessonIntroduction = this.Q;
        cmp = Long.compare(i3, i4);
        synchronized (this) {
            i4 = 0;
            this.S = i4;
            lessonIntroduction = this.Q;
            cmp = Long.compare(i3, i4);
        }
        try {
            if (lessonIntroduction != null) {
            } else {
            }
            i2 = title;
            i = str;
            i2 = i;
            if (cmp != 0) {
            }
            g.c(this.O, i);
            g.c(this.P, i2);
            throw th;
        }
    }

    @Override // app.dogo.com.dogo_android.h.c5
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
