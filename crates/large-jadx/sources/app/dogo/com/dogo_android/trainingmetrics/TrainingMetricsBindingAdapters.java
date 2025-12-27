package app.dogo.com.dogo_android.x;

import android.widget.TextView;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics;
import app.dogo.com.dogo_android.repository.domain.TrainingTimeMetrics.TrainingTimeDay;
import app.dogo.com.dogo_android.util.customview.ArcProgressBar;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.h0.g;

/* compiled from: TrainingMetricsBindingAdapters.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0016\u0010\u0008\u001a\u00020\u0004*\u00020\t2\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¨\u0006\n", d2 = {"Lapp/dogo/com/dogo_android/trainingmetrics/TrainingMetricsBindingAdapters;", "", "()V", "setupTimeProgressAnimation", "", "Lapp/dogo/com/dogo_android/util/customview/ArcProgressBar;", "item", "Lapp/dogo/com/dogo_android/repository/domain/TrainingTimeMetrics;", "setupTodayTrainedTime", "Landroid/widget/TextView;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class TrainingMetricsBindingAdapters {
    public static final void a(ArcProgressBar arcProgressBar, TrainingTimeMetrics trainingTimeMetrics) {
        str = "<this>";
        n.f(arcProgressBar, str);
    }

    public static final void b(TextView textView, TrainingTimeMetrics trainingTimeMetrics) {
        String item = null;
        boolean today;
        int durationSec = 0;
        item = "<this>";
        n.f(textView, item);
        if (trainingTimeMetrics != null) {
            Iterator it = trainingTimeMetrics.getWeekTrainingSummary().iterator();
            while (it.hasNext()) {
                if ((TrainingTimeMetrics_TrainingTimeDay)item.isToday()) {
                    break;
                }
            }
            int i = 0;
            if (item == null) {
                durationSec = 0;
            } else {
                durationSec = item.getDurationSec();
            }
            DashboardBindingAdapters.setTrainingWeekSummary(textView, Integer.valueOf(durationSec));
        }
    }

}
