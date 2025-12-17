package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.x.a;

/* loaded from: classes.dex */
public class bh extends app.dogo.com.dogo_android.h.ah {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private final ScrollView U;
    private long V;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        bh.X = sparseIntArray;
        sparseIntArray.put(2131362339, 4);
        sparseIntArray.put(2131363421, 5);
        sparseIntArray.put(2131362322, 6);
        sparseIntArray.put(2131362190, 7);
        sparseIntArray.put(2131363467, 8);
        sparseIntArray.put(2131363299, 9);
        sparseIntArray.put(2131363302, 10);
        sparseIntArray.put(2131363300, 11);
        sparseIntArray.put(2131362328, 12);
        sparseIntArray.put(2131362336, 13);
        sparseIntArray.put(2131362337, 14);
        sparseIntArray.put(2131362329, 15);
        sparseIntArray.put(2131362237, 16);
    }

    public bh(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 17, bh.W, bh.X));
    }

    private bh(e e, View view2, Object[] object3Arr3) {
        Object obj5 = this;
        super(e, view2, 0, (AppCompatImageView)object3Arr3[7], (Button)object3Arr3[16], (AppCompatImageView)object3Arr3[6], (Barrier)object3Arr3[12], (Space)object3Arr3[15], (Barrier)object3Arr3[13], (Space)object3Arr3[14], (LottieAnimationView)object3Arr3[4], (TextView)object3Arr3[3], (FrameLayout)object3Arr3[9], (TextView)object3Arr3[11], (AppCompatImageView)object3Arr3[10], (TextView)object3Arr3[1], (TextView)object3Arr3[5], (TextView)object3Arr3[2], (TextView)object3Arr3[8]);
        Object obj4 = this;
        obj4.V = -1;
        Object obj2 = object3Arr3[0];
        obj4.U = (ScrollView)obj2;
        int i3 = 0;
        obj2.setTag(i3);
        obj4.P.setTag(i3);
        obj4.Q.setTag(i3);
        obj4.R.setTag(i3);
        obj4.N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.ah
    public void A() {
        this.V = 4;
        I();
        return;
        synchronized (this) {
            this.V = 4;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ah
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.ah
    public boolean O(int i, Object object2) {
        int i2;
        int obj2;
        if (109 == i) {
            W((TrainingTimeMetrics)object2);
            obj2 = 1;
        } else {
            if (65 == i) {
                V((String)object2);
            } else {
                obj2 = 0;
            }
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.ah
    public void V(String string) {
        this.T = string;
        this.V = l |= i2;
        notifyPropertyChanged(65);
        super.I();
        return;
        synchronized (this) {
            this.T = string;
            this.V = l |= i2;
            notifyPropertyChanged(65);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ah
    public void W(TrainingTimeMetrics trainingTimeMetrics) {
        this.S = trainingTimeMetrics;
        this.V = l |= i2;
        notifyPropertyChanged(109);
        super.I();
        return;
        synchronized (this) {
            this.S = trainingTimeMetrics;
            this.V = l |= i2;
            notifyPropertyChanged(109);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.ah
    protected void m() {
        int cmp;
        Resources resources2;
        int i;
        Object[] arr;
        int string;
        int quantityString;
        int currentStreak;
        Resources resources;
        Object[] arr2;
        int i2;
        Integer valueOf;
        long l = this.V;
        i = 0;
        this.V = i;
        final TrainingTimeMetrics time = this.S;
        int cmp2 = Long.compare(i5, i);
        final int i6 = 1;
        final int i7 = 0;
        synchronized (this) {
            l = this.V;
            i = 0;
            this.V = i;
            time = this.S;
            cmp2 = Long.compare(i5, i);
            i6 = 1;
            i7 = 0;
        }
        try {
            if (time != null) {
            } else {
            }
            currentStreak = time.getCurrentStreak();
            currentStreak = i7;
            Object[] arr3 = new Object[i6];
            arr3[i7] = Integer.valueOf(currentStreak);
            i2 = 2131755026;
            this.P.getResources().getQuantityString(i2, currentStreak, arr3);
            arr2 = new Object[i6];
            arr2[i7] = Integer.valueOf(currentStreak);
            quantityString = this.P.getResources().getQuantityString(i2, currentStreak, arr2);
            quantityString = string;
            cmp = Long.compare(i3, i);
            if (cmp != 0) {
            }
            arr = new Object[i6];
            arr[i7] = this.T;
            string = this.Q.getResources().getString(2131887509, arr);
        }
        if (cmp2 != 0) {
            g.c(this.P, quantityString);
            a.b(this.R, time);
        }
        if (cmp != 0) {
            g.c(this.Q, string);
        }
    }

    @Override // app.dogo.com.dogo_android.h.ah
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
