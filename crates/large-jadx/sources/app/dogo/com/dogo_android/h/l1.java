package app.dogo.com.dogo_android.h;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.ViewDataBinding.g;
import androidx.databinding.a;
import androidx.databinding.e;
import androidx.databinding.k.g;
import app.dogo.com.dogo_android.g.n;
import app.dogo.com.dogo_android.k.g;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus;
import app.dogo.com.dogo_android.util.f0.n;
import com.google.android.material.progressindicator.b;

/* loaded from: classes.dex */
public class l1 extends app.dogo.com.dogo_android.h.k1 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private long V;
    static {
    }

    public l1(e e, View view2) {
        super(e, view2, ViewDataBinding.D(e, view2, 6, l1.W, l1.X));
    }

    private l1(e e, View view2, Object[] object3Arr3) {
        super(e, view2, 0, (AppCompatImageView)object3Arr3[2], (ConstraintLayout)object3Arr3[0], (TextView)object3Arr3[4], (CircularProgressIndicator)object3Arr3[5], (AppCompatImageView)object3Arr3[3], (TextView)object3Arr3[1]);
        this.V = -1;
        int obj14 = 0;
        this.O.setTag(obj14);
        this.P.setTag(obj14);
        this.Q.setTag(obj14);
        this.R.setTag(obj14);
        this.S.setTag(obj14);
        this.T.setTag(obj14);
        N(view2);
        A();
    }

    @Override // app.dogo.com.dogo_android.h.k1
    public void A() {
        this.V = 2;
        I();
        return;
        synchronized (this) {
            this.V = 2;
            I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k1
    protected boolean E(int i, Object object2, int i3) {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.h.k1
    public boolean O(int i, Object object2) {
        int obj2;
        if (94 == i) {
            V((TrainingTimeMetrics.TrainingTimeDay)object2);
            obj2 = 1;
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    @Override // app.dogo.com.dogo_android.h.k1
    public void V(TrainingTimeMetrics.TrainingTimeDay trainingTimeMetrics$TrainingTimeDay) {
        this.U = trainingTimeDay;
        this.V = l |= i2;
        notifyPropertyChanged(94);
        super.I();
        return;
        synchronized (this) {
            this.U = trainingTimeDay;
            this.V = l |= i2;
            notifyPropertyChanged(94);
            super.I();
        }
    }

    @Override // app.dogo.com.dogo_android.h.k1
    protected void m() {
        int weekdayText;
        long l;
        int cmp;
        int i2;
        int i13;
        Object[] valueOf;
        float dimension;
        int i16;
        int i10;
        int durationSec;
        int i23;
        TextView i8;
        int i12;
        int i26;
        int i3;
        int i22;
        int i25;
        int i11;
        int i20;
        int i17;
        int i9;
        int i18;
        int i;
        int i19;
        int i6;
        g rOBOTO_MEDIUM;
        int i21;
        int dailyTrainingGoalSec;
        int today;
        TrainingTimeMetrics.TrainingTimeDay.StreakStatus streakStatus;
        int i24;
        int i4;
        int i5;
        int i14;
        int i15;
        int i7;
        final Object obj = this;
        l = obj.V;
        int i38 = 0;
        obj.V = i38;
        TrainingTimeMetrics.TrainingTimeDay time = obj.U;
        i8 = 3;
        int cmp2 = Long.compare(i40, i38);
        synchronized (this) {
            obj = this;
            l = obj.V;
            i38 = 0;
            obj.V = i38;
            time = obj.U;
            i8 = 3;
            cmp2 = Long.compare(i40, i38);
        }
        if (time != null) {
            durationSec = time.getDurationSec();
            dailyTrainingGoalSec = time.getDailyTrainingGoalSec();
            today = time.isToday();
            i11 = streakStatus;
        } else {
            try {
                durationSec = 0;
                i11 = 0;
                dailyTrainingGoalSec = 0;
                today = 0;
                if (cmp2 != 0) {
                }
                if (today != 0) {
                } else {
                }
                i29 |= i24;
                i31 |= i9;
                i3 = 1;
            }
            i3 = 0;
            int i41 = 2131099767;
            TextView view14 = obj.T;
            if (today != 0) {
                i6 = ViewDataBinding.u(view14, i41);
            } else {
                i6 = ViewDataBinding.u(view14, 2131099840);
            }
            rOBOTO_MEDIUM = today != 0 ? g.ROBOTO_MEDIUM : g.ROBOTO;
            i18 = i11 == TrainingTimeMetrics.TrainingTimeDay.StreakStatus.NONE ? 1 : 0;
            i20 = i11 == TrainingTimeMetrics.TrainingTimeDay.StreakStatus.ACTIVE ? 1 : 0;
            if (Long.compare(i5, i38) != 0) {
                i5 = i3 != 0 ? 32 : 16;
                l |= i5;
            }
            if (Long.compare(i14, i38) != 0) {
                if (i18 != 0) {
                    i33 |= i53;
                    i14 = 8388608;
                } else {
                    i32 |= i51;
                    i14 = 4194304;
                }
                i2 |= i14;
            }
            if (Long.compare(i4, i38) != 0) {
                if (i20 != 0) {
                    i35 |= i57;
                    i4 = 131072;
                } else {
                    i34 |= i55;
                    i4 = 65536;
                }
                i13 |= i4;
            }
            i = i18 != 0 ? 0 : 4;
            i10 = i18 != 0 ? R.dimen.text_10_dp : R.dimen.text_8_dp;
            dimension = obj.Q.getResources().getDimension(i10);
            i16 = i18 != 0 ? 8 : 0;
            i9 = 2131099706;
            if (i20 != 0) {
                i19 = ViewDataBinding.u(obj.Q, i9);
            } else {
                i19 = ViewDataBinding.u(obj.Q, i41);
            }
            androidx.appcompat.widget.AppCompatImageView view11 = obj.S;
            if (i20 != 0) {
                i23 = ViewDataBinding.u(view11, i9);
            } else {
                i23 = ViewDataBinding.u(view11, 2131099772);
            }
            i17 = i20 != 0 ? R.color.konfetti2 : R.color.grayscale_gray_3;
            i12 = ViewDataBinding.u(obj.O, i17);
            i25 = dailyTrainingGoalSec;
            i15 = 3;
            int cmp3 = Long.compare(i7, i49);
            if (cmp3 != 0) {
                i24 = i3 != 0 ? 1 : today;
                if (cmp3 != 0) {
                    i7 = i24 != 0 ? 32768 : 16384;
                    l |= i7;
                }
                streakStatus = i24 != 0 ? 0 : 8;
                i22 = streakStatus;
            } else {
                i22 = 0;
            }
            final int i48 = 0;
            if (Long.compare(i43, i48) != 0 && time != null) {
                if (time != null) {
                    weekdayText = time.getWeekdayText();
                } else {
                    weekdayText = 0;
                }
            } else {
            }
            cmp = Long.compare(i27, i48);
            if (cmp != 0) {
                if (today != 0) {
                    weekdayText = String.format(obj.T.getResources().getString(2131887537), new Object[0]);
                }
            } else {
                weekdayText = 0;
            }
            if (cmp != 0) {
                n.i0(obj.O, Integer.valueOf(i12));
                n.i(obj.Q, Integer.valueOf(durationSec));
                obj.Q.setTextColor(i19);
                g.d(obj.Q, dimension);
                obj.Q.setVisibility(i22);
                obj.R.setMax(i25);
                obj.R.setProgress(durationSec);
                obj.R.setVisibility(i);
                n.i0(obj.S, Integer.valueOf(i23));
                obj.S.setVisibility(i16);
                n.f(obj.T, rOBOTO_MEDIUM);
                g.c(obj.T, weekdayText);
                obj.T.setTextColor(i6);
            }
        }
    }

    @Override // app.dogo.com.dogo_android.h.k1
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
