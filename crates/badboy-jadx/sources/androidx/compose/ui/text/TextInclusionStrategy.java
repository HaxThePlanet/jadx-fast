package androidx.compose.ui.text;

import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008æ\u0080\u0001\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u0008À\u0006\u0001", d2 = {"Landroidx/compose/ui/text/TextInclusionStrategy;", "", "isIncluded", "", "textBounds", "Landroidx/compose/ui/geometry/Rect;", "rect", "Companion", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface TextInclusionStrategy {

    public static final androidx.compose.ui.text.TextInclusionStrategy.Companion Companion;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0006¨\u0006\u000b", d2 = {"Landroidx/compose/ui/text/TextInclusionStrategy$Companion;", "", "()V", "AnyOverlap", "Landroidx/compose/ui/text/TextInclusionStrategy;", "getAnyOverlap", "()Landroidx/compose/ui/text/TextInclusionStrategy;", "ContainsAll", "getContainsAll", "ContainsCenter", "getContainsCenter", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.ui.text.TextInclusionStrategy.Companion $$INSTANCE;
        private static final androidx.compose.ui.text.TextInclusionStrategy AnyOverlap;
        private static final androidx.compose.ui.text.TextInclusionStrategy ContainsAll;
        private static final androidx.compose.ui.text.TextInclusionStrategy ContainsCenter;
        public static boolean $r8$lambda$2X1CuRkunX7FBBmytqSKk6vS6sQ(Rect rect, Rect rect2) {
            return TextInclusionStrategy.Companion.ContainsAll$lambda$1(rect, rect2);
        }

        public static boolean $r8$lambda$SHDbA_wDSJbtBuVzHOW4V5oymjs(Rect rect, Rect rect2) {
            return TextInclusionStrategy.Companion.ContainsCenter$lambda$2(rect, rect2);
        }

        public static boolean $r8$lambda$mp9rjJu0uaONMo14IZlDWVI4Ljc(Rect rect, Rect rect2) {
            return TextInclusionStrategy.Companion.AnyOverlap$lambda$0(rect, rect2);
        }

        static {
            TextInclusionStrategy.Companion companion = new TextInclusionStrategy.Companion();
            TextInclusionStrategy.Companion.$$INSTANCE = companion;
            TextInclusionStrategy.Companion$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new TextInclusionStrategy.Companion$$ExternalSyntheticLambda0();
            TextInclusionStrategy.Companion.AnyOverlap = externalSyntheticLambda0;
            TextInclusionStrategy.Companion$$ExternalSyntheticLambda1 externalSyntheticLambda1 = new TextInclusionStrategy.Companion$$ExternalSyntheticLambda1();
            TextInclusionStrategy.Companion.ContainsAll = externalSyntheticLambda1;
            TextInclusionStrategy.Companion$$ExternalSyntheticLambda2 externalSyntheticLambda2 = new TextInclusionStrategy.Companion$$ExternalSyntheticLambda2();
            TextInclusionStrategy.Companion.ContainsCenter = externalSyntheticLambda2;
        }

        private static final boolean AnyOverlap$lambda$0(Rect textBounds, Rect rect) {
            return textBounds.overlaps(rect);
        }

        private static final boolean ContainsAll$lambda$1(Rect textBounds, Rect rect) {
            int i;
            boolean empty;
            float bottom;
            if (!rect.isEmpty() && Float.compare(left, bottom) >= 0 && Float.compare(right, bottom) <= 0 && Float.compare(top, bottom) >= 0 && Float.compare(bottom2, bottom) <= 0) {
                if (Float.compare(left, bottom) >= 0) {
                    if (Float.compare(right, bottom) <= 0) {
                        if (Float.compare(top, bottom) >= 0) {
                            i = Float.compare(bottom2, bottom) <= 0 ? 1 : 0;
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        private static final boolean ContainsCenter$lambda$2(Rect textBounds, Rect rect) {
            return rect.contains-k-4lQ0M(textBounds.getCenter-F1C5BW0());
        }

        public final androidx.compose.ui.text.TextInclusionStrategy getAnyOverlap() {
            return TextInclusionStrategy.Companion.AnyOverlap;
        }

        public final androidx.compose.ui.text.TextInclusionStrategy getContainsAll() {
            return TextInclusionStrategy.Companion.ContainsAll;
        }

        public final androidx.compose.ui.text.TextInclusionStrategy getContainsCenter() {
            return TextInclusionStrategy.Companion.ContainsCenter;
        }
    }
    static {
        TextInclusionStrategy.Companion = TextInclusionStrategy.Companion.$$INSTANCE;
    }

    public abstract boolean isIncluded(Rect rect, Rect rect2);
}
