package androidx.compose.ui.platform;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0008\u001a\u00020\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0003", d2 = {"Landroidx/compose/ui/platform/AccessibilityManager;", "", "calculateRecommendedTimeoutMillis", "", "originalTimeoutMillis", "containsIcons", "", "containsText", "containsControls", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface AccessibilityManager {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public static final class DefaultImpls {
        public static long calculateRecommendedTimeoutMillis$default(androidx.compose.ui.platform.AccessibilityManager accessibilityManager, long l2, boolean z3, boolean z4, boolean z5, int i6, Object object7) {
            return AccessibilityManager.calculateRecommendedTimeoutMillis$default(accessibilityManager, l2, z3, z4, z5, i6, object7);
        }
    }
    public static long calculateRecommendedTimeoutMillis$default(androidx.compose.ui.platform.AccessibilityManager accessibilityManager, long l2, boolean z3, boolean z4, boolean z5, int i6, Object object7) {
        int obj4;
        int obj5;
        int obj6;
        if (obj8 != null) {
        } else {
            final int i = 0;
            if (object7 & 2 != 0) {
                obj4 = i;
            }
            if (object7 & 4 != 0) {
                obj5 = i;
            }
            if (object7 &= 8 != 0) {
                obj6 = i;
            }
            return accessibilityManager.calculateRecommendedTimeoutMillis(l2, z3, obj4, obj5);
        }
        UnsupportedOperationException obj1 = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateRecommendedTimeoutMillis");
        throw obj1;
    }

    public abstract long calculateRecommendedTimeoutMillis(long l, boolean z2, boolean z3, boolean z4);
}
