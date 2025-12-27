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
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay.StreakStatus;
import com.google.android.material.progressindicator.b;

/* compiled from: CellDashboardWeekSumaryDayBindingImpl.java */
/* loaded from: classes.dex */
public class l1 extends k1 {

    private static final ViewDataBinding.g W;
    private static final SparseIntArray X;
    private long V;
    public l1(e eVar, View view) {
        this(eVar, view, ViewDataBinding.D(eVar, view, 6, l1.W, l1.X));
    }

    @Override // app.dogo.com.dogo_android.h.k1
    public void A() {
        synchronized (this) {
            try {
                this.V = 2L;
            } catch (Throwable th) {
            }
        }
        I();
    }

    @Override // app.dogo.com.dogo_android.h.k1
    public boolean O(int i, Object object) {
        boolean z = true;
        if (94 == i) {
            V(object);
            int i3 = 1;
        } else {
            int i4 = 0;
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.h.k1
    public void V(TrainingTimeMetrics.TrainingTimeDay trainingTimeDay) {
        this.U = trainingTimeDay;
        synchronized (this) {
            try {
                this.V |= 1;
            } catch (Throwable th) {
            }
        }
        notifyPropertyChanged(94);
        super.I();
    }

    @Override // app.dogo.com.dogo_android.h.k1
    protected void m() {
        String weekdayText = null;
        Object obj = null;
        long l;
        long l2;
        long l3;
        Object[] arr;
        float dimension;
        int i = 0;
        int i2 = 2131165930;
        int durationSec = 0;
        int i3 = 0;
        int i4 = 0;
        int i6 = 0;
        int i7 = 0;
        int dailyTrainingGoalSec = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 2131099849;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        app.dogo.com.dogo_android.k.g rOBOTO2 = null;
        int i17 = 0;
        TrainingTimeMetrics.TrainingTimeDay.StreakStatus streakStatus;
        long l5;
        int i18 = 4194304;
        int i19 = 131072;
        long l6;
        int i20 = 16;
        int i21 = 3;
        long l9;
        int i22 = 16384;
        final Object obj2 = this;
        synchronized (this) {
            try {
                long l19 = 0L;
                obj2.V = l19;
            } catch (Throwable th) {
            }
        }
        long l4 = 3L;
        long l20 = l & l4;
        if (l20 != l19) {
            if (obj2.U != null) {
                durationSec = obj2.U.getDurationSec();
                dailyTrainingGoalSec = obj2.U.getDailyTrainingGoalSec();
                boolean today = obj2.U.isToday();
            } else {
                durationSec = 0;
                i8 = 0;
                dailyTrainingGoalSec = 0;
                i17 = 0;
            }
            if (l20 != l19) {
                if (i17 != 0) {
                    l5 = 524288L;
                    l = (l | 128L) | 8192L | l5;
                } else {
                    l5 = 4096L;
                    l = (l | 64L) | l5 | 262144L;
                }
            }
            int r9 = durationSec > 0 ? 1 : 0;
            int i29 = 2131099767;
            if (i17 != 0) {
                i15 = ViewDataBinding.u(obj2.T, i29);
            } else {
                int i16 = 2131099840;
                i15 = ViewDataBinding.u(obj2.T, i16);
            }
            app.dogo.com.dogo_android.k.g r15 = i17 != 0 ? FontFamily.ROBOTO_MEDIUM : FontFamily.ROBOTO;
            int r11 = i8 == TrainingTimeMetrics_TrainingTimeDay_StreakStatus.NONE ? 1 : 0;
            int r10 = i8 == TrainingTimeMetrics_TrainingTimeDay_StreakStatus.ACTIVE ? 1 : 0;
            l7 = l & 3L;
            if (l7 != l19) {
                int r23 = i6 != 0 ? 32 : 16;
                l = l | (i6 != 0 ? 32 : 16);
            }
            l8 = l & 3L;
            if (l8 != l19) {
                if (TrainingTimeMetrics_TrainingTimeDay_StreakStatus.NONE != 0) {
                    l2 = (l | 8L) | 2097152L;
                    i18 = 8388608;
                } else {
                    l2 = (l | 4L) | 1048576L;
                    i18 = 4194304;
                }
                l = l2 | i18;
            }
            l6 = l & 3L;
            if (l6 != l19) {
                if (i9 != 0) {
                    l3 = (l | 512L) | 2048L;
                    i19 = 131072;
                } else {
                    l3 = (l | 256L) | 1024L;
                    i19 = 65536;
                }
                l = l3 | i19;
            }
            int r12 = TrainingTimeMetrics_TrainingTimeDay_StreakStatus.NONE != 0 ? 0 : 4;
            int r5 = TrainingTimeMetrics_TrainingTimeDay_StreakStatus.NONE != 0 ? R.dimen.text_10_dp : R.dimen.text_8_dp;
            dimension = obj2.Q.getResources().getDimension((TrainingTimeMetrics_TrainingTimeDay_StreakStatus.NONE != 0 ? R.dimen.text_10_dp : R.dimen.text_8_dp));
            r5 = TrainingTimeMetrics_TrainingTimeDay_StreakStatus.NONE != 0 ? 8 : 0;
            int i11 = 2131099706;
            if (i9 != 0) {
                i14 = ViewDataBinding.u(obj2.Q, i11);
            } else {
                i14 = ViewDataBinding.u(obj2.Q, i29);
            }
            if (i9 != 0) {
                i3 = ViewDataBinding.u(obj2.S, i11);
            } else {
                int i5 = 2131099772;
                i3 = ViewDataBinding.u(obj2.S, i5);
            }
            r10 = i9 != 0 ? R.color.konfetti2 : R.color.grayscale_gray_3;
            i4 = ViewDataBinding.u(obj2.O, (i9 != 0 ? R.color.konfetti2 : R.color.grayscale_gray_3));
            i21 = 3;
        } else {
            int i27 = 0;
            i = 0;
            durationSec = 0;
            i3 = 0;
            i4 = 0;
            i6 = 0;
            dailyTrainingGoalSec = 0;
            i13 = 0;
            i14 = 0;
            i15 = 0;
            int i30 = 0;
            i17 = 0;
        }
        l9 = l & i21;
        if (l9 != 0) {
            int r19 = i6 != 0 ? 1 : i17;
            if (l9 != 0) {
                int r27 = i17 != 0 ? 32768 : 16384;
                l = l | (i17 != 0 ? 32768 : 16384);
            }
            int r18 = i17 != 0 ? 0 : 8;
            i7 = (i17 != 0 ? 0 : 8);
        } else {
            i7 = 0;
        }
        long l22 = l & 262144L;
        final long l23 = 0L;
        if (l22 == l23 || obj2.U == null) {
            int i24 = 0;
        } else {
            weekdayText = obj2.U.getWeekdayText();
        }
        l &= 3;
        if (obj2.V == l23) {
            int i23 = 0;
        } else {
            if (i17 != 0) {
                String formatted = String.format(obj2.T.getResources().getString(2131887537), new Object[0]);
            }
        }
        if (obj2.V != l23) {
            BindingAdapters.i0(obj2.O, Integer.valueOf(i4));
            DashboardBindingAdapters.setTrainingWeekSummary(obj2.Q, Integer.valueOf(durationSec));
            obj2.Q.setTextColor(i14);
            g.d(obj2.Q, dimension);
            obj2.Q.setVisibility(i7);
            obj2.R.setMax(dailyTrainingGoalSec);
            obj2.R.setProgress(durationSec);
            obj2.R.setVisibility(i13);
            BindingAdapters.i0(obj2.S, Integer.valueOf(i3));
            obj2.S.setVisibility(i);
            BindingAdapters.f(obj2.T, rOBOTO2);
            g.c(obj2.T, obj);
            obj2.T.setTextColor(i15);
        }
    }

    @Override // app.dogo.com.dogo_android.h.k1
    public boolean y() {
        synchronized (this) {
            try {
                if (this.V != 0) {
                    return true;
                }
            } catch (Throwable th) {
            }
            throw th;
        }
    }

    private l1(e eVar, View view, Object[] objectArr) {
        super(eVar, view, 0, (AppCompatImageView)objectArr[2], (ConstraintLayout)objectArr[0], (TextView)objectArr[4], (CircularProgressIndicator)objectArr[5], (AppCompatImageView)objectArr[3], (TextView)objectArr[1]);
        this.V = -1L;
        Object obj7 = null;
        this.O.setTag(obj7);
        this.P.setTag(obj7);
        this.Q.setTag(obj7);
        this.R.setTag(obj7);
        this.S.setTag(obj7);
        this.T.setTag(obj7);
        N(view);
        A();
    }


    @Override // app.dogo.com.dogo_android.h.k1
    protected boolean E(int i, Object object, int i2) {
        return false;
    }
}
