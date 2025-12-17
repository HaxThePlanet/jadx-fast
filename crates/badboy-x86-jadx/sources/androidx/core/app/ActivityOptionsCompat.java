package androidx.core.app;

import android.app.Activity;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import androidx.core.util.Pair;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes5.dex */
public class ActivityOptionsCompat {

    public static final String EXTRA_USAGE_TIME_REPORT = "android.activity.usage_time";
    public static final String EXTRA_USAGE_TIME_REPORT_PACKAGES = "android.usage_time_packages";

    private static class ActivityOptionsCompatImpl extends androidx.core.app.ActivityOptionsCompat {

        private final ActivityOptions mActivityOptions;
        ActivityOptionsCompatImpl(ActivityOptions activityOptions) {
            super();
            this.mActivityOptions = activityOptions;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Rect getLaunchBounds() {
            return this.mActivityOptions.getLaunchBounds();
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public int getLaunchDisplayId() {
            return this.mActivityOptions.getLaunchDisplayId();
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void requestUsageTimeReport(PendingIntent receiver) {
            this.mActivityOptions.requestUsageTimeReport(receiver);
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public androidx.core.app.ActivityOptionsCompat setLaunchBounds(Rect screenSpacePixelRect) {
            ActivityOptionsCompat.ActivityOptionsCompatImpl activityOptionsCompatImpl = new ActivityOptionsCompat.ActivityOptionsCompatImpl(this.mActivityOptions.setLaunchBounds(screenSpacePixelRect));
            return activityOptionsCompatImpl;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public androidx.core.app.ActivityOptionsCompat setLaunchDisplayId(int launchDisplayId) {
            this.mActivityOptions.setLaunchDisplayId(launchDisplayId);
            return this;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public androidx.core.app.ActivityOptionsCompat setPendingIntentBackgroundActivityStartMode(int state) {
            int mActivityOptions;
            int mActivityOptions2;
            if (Build.VERSION.SDK_INT >= 34) {
                this.mActivityOptions.setPendingIntentBackgroundActivityStartMode(state);
            } else {
                if (Build.VERSION.SDK_INT >= 33) {
                    mActivityOptions = state != 2 ? 1 : 0;
                    this.mActivityOptions.setPendingIntentBackgroundActivityLaunchAllowed(mActivityOptions);
                }
            }
            return this;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public androidx.core.app.ActivityOptionsCompat setShareIdentityEnabled(boolean shareIdentity) {
            if (Build.VERSION.SDK_INT < 34) {
                return this;
            }
            ActivityOptionsCompat.ActivityOptionsCompatImpl activityOptionsCompatImpl = new ActivityOptionsCompat.ActivityOptionsCompatImpl(this.mActivityOptions.setShareIdentityEnabled(shareIdentity));
            return activityOptionsCompatImpl;
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public Bundle toBundle() {
            return this.mActivityOptions.toBundle();
        }

        @Override // androidx.core.app.ActivityOptionsCompat
        public void update(androidx.core.app.ActivityOptionsCompat otherOptions) {
            boolean z;
            ActivityOptions mActivityOptions;
            ActivityOptions mActivityOptions2;
            if (otherOptions instanceof ActivityOptionsCompat.ActivityOptionsCompatImpl) {
                this.mActivityOptions.update(z.mActivityOptions);
            }
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface BackgroundActivityStartMode {
    }
    public static androidx.core.app.ActivityOptionsCompat makeBasic() {
        ActivityOptionsCompat.ActivityOptionsCompatImpl activityOptionsCompatImpl = new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeBasic());
        return activityOptionsCompatImpl;
    }

    public static androidx.core.app.ActivityOptionsCompat makeClipRevealAnimation(View source, int startX, int startY, int width, int height) {
        ActivityOptionsCompat.ActivityOptionsCompatImpl activityOptionsCompatImpl = new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeClipRevealAnimation(source, startX, startY, width, height));
        return activityOptionsCompatImpl;
    }

    public static androidx.core.app.ActivityOptionsCompat makeCustomAnimation(Context context, int enterResId, int exitResId) {
        ActivityOptionsCompat.ActivityOptionsCompatImpl activityOptionsCompatImpl = new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeCustomAnimation(context, enterResId, exitResId));
        return activityOptionsCompatImpl;
    }

    public static androidx.core.app.ActivityOptionsCompat makeScaleUpAnimation(View source, int startX, int startY, int startWidth, int startHeight) {
        ActivityOptionsCompat.ActivityOptionsCompatImpl activityOptionsCompatImpl = new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeScaleUpAnimation(source, startX, startY, startWidth, startHeight));
        return activityOptionsCompatImpl;
    }

    public static androidx.core.app.ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, View sharedElement, String sharedElementName) {
        ActivityOptionsCompat.ActivityOptionsCompatImpl activityOptionsCompatImpl = new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(activity, sharedElement, sharedElementName));
        return activityOptionsCompatImpl;
    }

    public static androidx.core.app.ActivityOptionsCompat makeSceneTransitionAnimation(Activity activity, Pair<View, String>... pair2Arr2) {
        int pairs;
        int i;
        Pair length;
        Object second;
        pairs = 0;
        if (pair2Arr2 != null) {
            i = 0;
            for (Object obj2 : pair2Arr2) {
                new Pair[pair2Arr2.length][i] = Pair.create((View)obj.first, (String)obj2.second);
            }
        }
        ActivityOptionsCompat.ActivityOptionsCompatImpl i2 = new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeSceneTransitionAnimation(activity, pairs));
        return i2;
    }

    public static androidx.core.app.ActivityOptionsCompat makeTaskLaunchBehind() {
        ActivityOptionsCompat.ActivityOptionsCompatImpl activityOptionsCompatImpl = new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeTaskLaunchBehind());
        return activityOptionsCompatImpl;
    }

    public static androidx.core.app.ActivityOptionsCompat makeThumbnailScaleUpAnimation(View source, Bitmap thumbnail, int startX, int startY) {
        ActivityOptionsCompat.ActivityOptionsCompatImpl activityOptionsCompatImpl = new ActivityOptionsCompat.ActivityOptionsCompatImpl(ActivityOptions.makeThumbnailScaleUpAnimation(source, thumbnail, startX, startY));
        return activityOptionsCompatImpl;
    }

    public Rect getLaunchBounds() {
        return null;
    }

    public int getLaunchDisplayId() {
        return -1;
    }

    public void requestUsageTimeReport(PendingIntent receiver) {
    }

    public androidx.core.app.ActivityOptionsCompat setLaunchBounds(Rect screenSpacePixelRect) {
        return this;
    }

    public androidx.core.app.ActivityOptionsCompat setLaunchDisplayId(int launchDisplayId) {
        return this;
    }

    public androidx.core.app.ActivityOptionsCompat setPendingIntentBackgroundActivityStartMode(int state) {
        return this;
    }

    public androidx.core.app.ActivityOptionsCompat setShareIdentityEnabled(boolean shareIdentity) {
        return this;
    }

    public Bundle toBundle() {
        return null;
    }

    public void update(androidx.core.app.ActivityOptionsCompat otherOptions) {
    }
}
