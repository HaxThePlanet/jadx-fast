package app.dogo.com.dogo_android.x;

import android.widget.TextView;
import app.dogo.com.dogo_android.g.n;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay;
import app.dogo.com.dogo_android.util.customview.ArcProgressBar;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0016\u0010\u0008\u001a\u00020\u0004*\u00020\t2\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/TrainingMetricsBindingAdapters;", "", "()V", "setupTimeProgressAnimation", "", "Lapp/dogo/com/dogo_android/util/customview/ArcProgressBar;", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "setupTodayTrainedTime", "Landroid/widget/TextView;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class a {
    static {
    }

    public static final void a(ArcProgressBar arcProgressBar, TrainingTimeMetrics trainingTimeMetrics2) {
        String todaySummary;
        int i;
        int obj4;
        n.f(arcProgressBar, "<this>");
        if (trainingTimeMetrics2 != 0 && arcProgressBar.getProgress() == 0) {
            if (arcProgressBar.getProgress() == 0) {
                todaySummary = trainingTimeMetrics2.getTodaySummary();
                if (todaySummary == null) {
                } else {
                    arcProgressBar.setMax(dailyTrainingGoalSec2 *= 100);
                    arcProgressBar.setProgress(obj4 *= 100);
                    arcProgressBar.a(i2 *= 100, 1500);
                }
            }
        }
    }

    public static final void b(TextView textView, TrainingTimeMetrics trainingTimeMetrics2) {
        String next;
        boolean today;
        Integer obj3;
        n.f(textView, "<this>");
        if (trainingTimeMetrics2 != null) {
            obj3 = trainingTimeMetrics2.getWeekTrainingSummary().iterator();
            for (Object next : obj3) {
            }
            next = 0;
            if ((TrainingTimeMetrics.TrainingTimeDay)next == null) {
                obj3 = 0;
            } else {
                obj3 = (TrainingTimeMetrics.TrainingTimeDay)next.getDurationSec();
            }
            n.i(textView, Integer.valueOf(obj3));
        }
    }
}
