package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.repository.domain.WorkoutStreakInfo;
import app.dogo.com.dogo_android.util.f0.n;

/* loaded from: classes.dex */
public class lh extends app.dogo.com.dogo_android.h.kh {

    private static final ViewDataBinding.g V;
    private static final SparseIntArray W;
    private final ScrollView T;
    private long U;
    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        lh.W = sparseIntArray;
        sparseIntArray.put(2131362339, 4);
        sparseIntArray.put(2131363421, 5);
        sparseIntArray.put(2131362237, 6);
    }

    public lh(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 7, lh.V, lh.W));
    }

    private lh(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (Button)object3Arr3[6], (LottieAnimationView)object3Arr3[4], (TextView)object3Arr3[3], (ImageView)object3Arr3[2], (TextView)object3Arr3[1], (TextView)object3Arr3[5]);
        this.U = -1;
        int i8 = 0;
        this.P.setTag(i8);
        Object obj12 = object3Arr3[0];
        this.T = (ScrollView)obj12;
        obj12.setTag(i8);
        this.Q.setTag(i8);
        this.R.setTag(i8);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.kh
    public void A() {
        this.U = 2;
        I();
        return;
        synchronized (this) {
            this.U = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kh
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.kh
    public boolean O(int i, Object object2) {
        int obj2;
        if (189 == i) {
            V((WorkoutStreakInfo)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.kh
    public void V(WorkoutStreakInfo workoutStreakInfo) {
        this.S = workoutStreakInfo;
        this.U = l |= i2;
        notifyPropertyChanged(189);
        super.I();
        return;
        synchronized (this) {
            this.S = workoutStreakInfo;
            this.U = l |= i2;
            notifyPropertyChanged(189);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.kh
    protected void m() {
        long l;
        int cmp;
        int longestStreak;
        int i4;
        int i2;
        int i3;
        int currentStreak;
        String string;
        Object[] arr;
        Resources resources;
        int i;
        l = this.U;
        final int i6 = 0;
        this.U = i6;
        final WorkoutStreakInfo workoutStreakInfo = this.S;
        i2 = 0;
        final int i7 = 3;
        int cmp2 = Long.compare(i8, i6);
        i3 = 0;
        synchronized (this) {
            l = this.U;
            i6 = 0;
            this.U = i6;
            workoutStreakInfo = this.S;
            i2 = 0;
            i7 = 3;
            cmp2 = Long.compare(i8, i6);
            i3 = 0;
        }
        try {
            if (workoutStreakInfo != null) {
            } else {
            }
            longestStreak = workoutStreakInfo.getLongestStreak();
            currentStreak = workoutStreakInfo.getCurrentStreak();
            currentStreak = longestStreak;
            int i9 = 1;
            if (longestStreak == 0) {
            } else {
            }
            i4 = i9;
            i4 = i3;
            arr = new Object[i9];
            arr[i3] = Integer.valueOf(currentStreak);
        }
        arr = i4 != 0 ? 8 : 4;
        l |= arr;
        if (i4 != 0) {
            i3 = i4;
        }
        i2 = string;
        if (Long.compare(i5, i6) != 0) {
            n.H(this.P, workoutStreakInfo);
            this.P.setVisibility(i3);
            this.Q.setVisibility(i3);
            g.c(this.R, i2);
        }
    }

    @Override // app.dogo.com.dogo_android.h.kh
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
