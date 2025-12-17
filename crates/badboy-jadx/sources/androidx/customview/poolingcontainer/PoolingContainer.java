package androidx.customview.poolingcontainer;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import androidx.core.view.ViewKt;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00006\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0014\u0010\u000f\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\n\u0010\u0013\u001a\u00020\u0010*\u00020\u0006\u001a\n\u0010\u0014\u001a\u00020\u0010*\u00020\u0015\u001a\u0014\u0010\u0016\u001a\u00020\u0010*\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008\u0005\u0010\u0007\"\u0004\u0008\u0008\u0010\t\"\u0015\u0010\n\u001a\u00020\u0004*\u00020\u00068F¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u0007\"\u0018\u0010\u000b\u001a\u00020\u000c*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\r\u0010\u000e¨\u0006\u0017", d2 = {"IsPoolingContainerTag", "", "PoolingContainerListenerHolderTag", "value", "", "isPoolingContainer", "Landroid/view/View;", "(Landroid/view/View;)Z", "setPoolingContainer", "(Landroid/view/View;Z)V", "isWithinPoolingContainer", "poolingContainerListenerHolder", "Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "getPoolingContainerListenerHolder", "(Landroid/view/View;)Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "addPoolingContainerListener", "", "listener", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "callPoolingContainerOnRelease", "callPoolingContainerOnReleaseForChildren", "Landroid/view/ViewGroup;", "removePoolingContainerListener", "customview-poolingcontainer_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PoolingContainer {

    private static final int IsPoolingContainerTag;
    private static final int PoolingContainerListenerHolderTag;
    static {
        PoolingContainer.PoolingContainerListenerHolderTag = R.id.pooling_container_listener_holder_tag;
        PoolingContainer.IsPoolingContainerTag = R.id.is_pooling_container_tag;
    }

    public static final void addPoolingContainerListener(View $this$addPoolingContainerListener, androidx.customview.poolingcontainer.PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter($this$addPoolingContainerListener, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        PoolingContainer.getPoolingContainerListenerHolder($this$addPoolingContainerListener).addListener(listener);
    }

    public static final void callPoolingContainerOnRelease(View $this$callPoolingContainerOnRelease) {
        Object next;
        Object obj;
        int i;
        androidx.customview.poolingcontainer.PoolingContainerListenerHolder poolingContainerListenerHolder;
        Intrinsics.checkNotNullParameter($this$callPoolingContainerOnRelease, "<this>");
        final int i2 = 0;
        final Iterator iterator = ViewKt.getAllViews($this$callPoolingContainerOnRelease).iterator();
        for (Object next : iterator) {
            i = 0;
            PoolingContainer.getPoolingContainerListenerHolder((View)next).onRelease();
        }
    }

    public static final void callPoolingContainerOnReleaseForChildren(ViewGroup $this$callPoolingContainerOnReleaseForChildren) {
        Object next;
        Object obj;
        int i;
        androidx.customview.poolingcontainer.PoolingContainerListenerHolder poolingContainerListenerHolder;
        Intrinsics.checkNotNullParameter($this$callPoolingContainerOnReleaseForChildren, "<this>");
        final int i2 = 0;
        final Iterator iterator = ViewGroupKt.getChildren($this$callPoolingContainerOnReleaseForChildren).iterator();
        for (Object next : iterator) {
            i = 0;
            PoolingContainer.getPoolingContainerListenerHolder((View)next).onRelease();
        }
    }

    private static final androidx.customview.poolingcontainer.PoolingContainerListenerHolder getPoolingContainerListenerHolder(View $this$poolingContainerListenerHolder) {
        Object lifecycle;
        int poolingContainerListenerHolderTag;
        if ((PoolingContainerListenerHolder)$this$poolingContainerListenerHolder.getTag(PoolingContainer.PoolingContainerListenerHolderTag) == null) {
            PoolingContainerListenerHolder poolingContainerListenerHolder = new PoolingContainerListenerHolder();
            $this$poolingContainerListenerHolder.setTag(PoolingContainer.PoolingContainerListenerHolderTag, poolingContainerListenerHolder);
        }
        return lifecycle;
    }

    public static final boolean isPoolingContainer(View $this$isPoolingContainer) {
        Object tag;
        int booleanValue;
        Intrinsics.checkNotNullParameter($this$isPoolingContainer, "<this>");
        if (tag instanceof Boolean) {
        } else {
            tag = 0;
        }
        if (tag != null) {
            booleanValue = tag.booleanValue();
        } else {
            booleanValue = 0;
        }
        return booleanValue;
    }

    public static final boolean isWithinPoolingContainer(View $this$isWithinPoolingContainer) {
        Object next;
        Object obj;
        int i;
        boolean poolingContainer;
        Intrinsics.checkNotNullParameter($this$isWithinPoolingContainer, "<this>");
        final int i2 = 0;
        Iterator iterator = ViewKt.getAncestors($this$isWithinPoolingContainer).iterator();
        for (Object next : iterator) {
            obj = next;
            i = 0;
        }
        return 0;
    }

    public static final void removePoolingContainerListener(View $this$removePoolingContainerListener, androidx.customview.poolingcontainer.PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter($this$removePoolingContainerListener, "<this>");
        Intrinsics.checkNotNullParameter(listener, "listener");
        PoolingContainer.getPoolingContainerListenerHolder($this$removePoolingContainerListener).removeListener(listener);
    }

    public static final void setPoolingContainer(View $this$isPoolingContainer, boolean value) {
        Intrinsics.checkNotNullParameter($this$isPoolingContainer, "<this>");
        $this$isPoolingContainer.setTag(PoolingContainer.IsPoolingContainerTag, Boolean.valueOf(value));
    }
}
