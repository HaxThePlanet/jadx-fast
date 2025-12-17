package androidx.compose.foundation.pager;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J0\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011", d2 = {"Landroidx/compose/foundation/pager/PagerSnapDistanceMaxPages;", "Landroidx/compose/foundation/pager/PagerSnapDistance;", "pagesLimit", "", "(I)V", "calculateTargetPage", "startPage", "suggestedTargetPage", "velocity", "", "pageSize", "pageSpacing", "equals", "", "other", "", "hashCode", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PagerSnapDistanceMaxPages implements androidx.compose.foundation.pager.PagerSnapDistance {

    public static final int $stable;
    private final int pagesLimit;
    static {
    }

    public PagerSnapDistanceMaxPages(int pagesLimit) {
        super();
        this.pagesLimit = pagesLimit;
    }

    @Override // androidx.compose.foundation.pager.PagerSnapDistance
    public int calculateTargetPage(int startPage, int suggestedTargetPage, float velocity, int pageSize, int pageSpacing) {
        int i = 0;
        long $i$f$debugLog = (long)startPage;
        int i6 = 0;
        return RangesKt.coerceIn(suggestedTargetPage, (int)coerceAtLeast, (int)coerceAtMost);
    }

    @Override // androidx.compose.foundation.pager.PagerSnapDistance
    public boolean equals(Object other) {
        boolean pagesLimit;
        int i;
        int pagesLimit2;
        i = 0;
        if (other instanceof PagerSnapDistanceMaxPages) {
            if (this.pagesLimit == obj.pagesLimit) {
                i = 1;
            }
        } else {
        }
        return i;
    }

    @Override // androidx.compose.foundation.pager.PagerSnapDistance
    public int hashCode() {
        return Integer.hashCode(this.pagesLimit);
    }
}
