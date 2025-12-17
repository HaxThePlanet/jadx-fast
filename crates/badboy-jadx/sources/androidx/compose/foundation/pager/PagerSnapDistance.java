package androidx.compose.foundation.pager;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0004\u0008g\u0018\u0000 \n2\u00020\u0001:\u0001\nJ0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0003H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\u000bÀ\u0006\u0001", d2 = {"Landroidx/compose/foundation/pager/PagerSnapDistance;", "", "calculateTargetPage", "", "startPage", "suggestedTargetPage", "velocity", "", "pageSize", "pageSpacing", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface PagerSnapDistance {

    public static final androidx.compose.foundation.pager.PagerSnapDistance.Companion Companion;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/pager/PagerSnapDistance$Companion;", "", "()V", "atMost", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "pages", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {

        static final androidx.compose.foundation.pager.PagerSnapDistance.Companion $$INSTANCE;
        static {
            PagerSnapDistance.Companion companion = new PagerSnapDistance.Companion();
            PagerSnapDistance.Companion.$$INSTANCE = companion;
        }

        public final androidx.compose.foundation.pager.PagerSnapDistance atMost(int pages) {
            int i;
            i = pages >= 0 ? 1 : 0;
            if (i == 0) {
            } else {
                PagerSnapDistanceMaxPages pagerSnapDistanceMaxPages = new PagerSnapDistanceMaxPages(pages);
                return (PagerSnapDistance)pagerSnapDistanceMaxPages;
            }
            int i2 = 0;
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("pages should be greater than or equal to 0. You have used ").append(pages).append('.').toString().toString());
            throw illegalArgumentException;
        }
    }
    static {
        PagerSnapDistance.Companion = PagerSnapDistance.Companion.$$INSTANCE;
    }

    public abstract int calculateTargetPage(int i, int i2, float f3, int i4, int i5);
}
