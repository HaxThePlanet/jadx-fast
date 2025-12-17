package androidx.lifecycle;

import android.view.View;
import androidx.core.viewtree.ViewTree;
import androidx.lifecycle.runtime.R.id;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0008\u0005\u001a\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0007¢\u0006\u0002\u0008\u0007¨\u0006\u0008", d2 = {"setViewTreeLifecycleOwner", "", "Landroid/view/View;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "set", "findViewTreeLifecycleOwner", "get", "lifecycle-runtime_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ViewTreeLifecycleOwner {
    public static final androidx.lifecycle.LifecycleOwner get(View $this$findViewTreeLifecycleOwner) {
        Object currentView;
        int i;
        Object tag;
        android.view.ViewParent parentOrViewTreeDisjointParent;
        boolean z;
        Intrinsics.checkNotNullParameter($this$findViewTreeLifecycleOwner, "<this>");
        currentView = $this$findViewTreeLifecycleOwner;
        i = 0;
        while (currentView != null) {
            if (tag instanceof LifecycleOwner) {
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

    public static final void set(View $this$setViewTreeLifecycleOwner, androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter($this$setViewTreeLifecycleOwner, "<this>");
        $this$setViewTreeLifecycleOwner.setTag(R.id.view_tree_lifecycle_owner, lifecycleOwner);
    }
}
