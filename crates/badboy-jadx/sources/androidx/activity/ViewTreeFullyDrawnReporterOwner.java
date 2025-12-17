package androidx.activity;

import android.view.View;
import androidx.core.viewtree.ViewTree;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0008\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0008\u0007¨\u0006\u0008", d2 = {"findViewTreeFullyDrawnReporterOwner", "Landroidx/activity/FullyDrawnReporterOwner;", "Landroid/view/View;", "get", "setViewTreeFullyDrawnReporterOwner", "", "fullyDrawnReporterOwner", "set", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ViewTreeFullyDrawnReporterOwner {
    public static final androidx.activity.FullyDrawnReporterOwner get(View $this$findViewTreeFullyDrawnReporterOwner) {
        Object currentView;
        int i;
        Object tag;
        android.view.ViewParent parentOrViewTreeDisjointParent;
        boolean z;
        Intrinsics.checkNotNullParameter($this$findViewTreeFullyDrawnReporterOwner, "<this>");
        currentView = $this$findViewTreeFullyDrawnReporterOwner;
        i = 0;
        while (currentView != null) {
            if (tag instanceof FullyDrawnReporterOwner) {
            } else {
            }
            tag = i;
            parentOrViewTreeDisjointParent = ViewTree.getParentOrViewTreeDisjointParent(currentView);
            if (parentOrViewTreeDisjointParent instanceof View != null) {
            }
            currentView = i;
            i = 0;
            i = parentOrViewTreeDisjointParent;
        }
        return i;
    }

    public static final void set(View $this$setViewTreeFullyDrawnReporterOwner, androidx.activity.FullyDrawnReporterOwner fullyDrawnReporterOwner) {
        Intrinsics.checkNotNullParameter($this$setViewTreeFullyDrawnReporterOwner, "<this>");
        Intrinsics.checkNotNullParameter(fullyDrawnReporterOwner, "fullyDrawnReporterOwner");
        $this$setViewTreeFullyDrawnReporterOwner.setTag(R.id.report_drawn, fullyDrawnReporterOwner);
    }
}
