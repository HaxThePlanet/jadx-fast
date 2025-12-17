package androidx.activity.result;

import androidx.core.app.ActivityOptionsCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u001a#\u0010\u0000\u001a\u00020\u0001*\u0008\u0012\u0004\u0012\u00020\u00010\u00022\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0002\u0008\u0006¨\u0006\u0007", d2 = {"launch", "", "Landroidx/activity/result/ActivityResultLauncher;", "Ljava/lang/Void;", "options", "Landroidx/core/app/ActivityOptionsCompat;", "launchUnit", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActivityResultLauncherKt {
    public static final void launch(androidx.activity.result.ActivityResultLauncher<Void> $this$launch, ActivityOptionsCompat options) {
        Intrinsics.checkNotNullParameter($this$launch, "<this>");
        $this$launch.launch(0, options);
    }

    public static void launch$default(androidx.activity.result.ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        ActivityResultLauncherKt.launch(activityResultLauncher, obj1);
    }

    public static final void launchUnit(androidx.activity.result.ActivityResultLauncher<Unit> $this$launch, ActivityOptionsCompat options) {
        Intrinsics.checkNotNullParameter($this$launch, "<this>");
        $this$launch.launch(Unit.INSTANCE, options);
    }

    public static void launchUnit$default(androidx.activity.result.ActivityResultLauncher activityResultLauncher, ActivityOptionsCompat activityOptionsCompat2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        ActivityResultLauncherKt.launchUnit(activityResultLauncher, obj1);
    }
}
