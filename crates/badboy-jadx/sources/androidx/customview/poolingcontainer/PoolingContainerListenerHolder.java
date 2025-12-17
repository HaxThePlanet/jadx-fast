package androidx.customview.poolingcontainer;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0008\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0008J\u000e\u0010\u000b\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\u0008\u0012\u0004\u0012\u00020\u0005`\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Landroidx/customview/poolingcontainer/PoolingContainerListenerHolder;", "", "()V", "listeners", "Ljava/util/ArrayList;", "Landroidx/customview/poolingcontainer/PoolingContainerListener;", "Lkotlin/collections/ArrayList;", "addListener", "", "listener", "onRelease", "removeListener", "customview-poolingcontainer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class PoolingContainerListenerHolder {

    private final ArrayList<androidx.customview.poolingcontainer.PoolingContainerListener> listeners;
    public PoolingContainerListenerHolder() {
        super();
        ArrayList arrayList = new ArrayList();
        this.listeners = arrayList;
    }

    public final void addListener(androidx.customview.poolingcontainer.PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.add(listener);
    }

    public final void onRelease() {
        int i;
        Object obj;
        i = CollectionsKt.getLastIndex((List)this.listeners);
        while (-1 < i) {
            (PoolingContainerListener)this.listeners.get(i).onRelease();
            i--;
        }
    }

    public final void removeListener(androidx.customview.poolingcontainer.PoolingContainerListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listeners.remove(listener);
    }
}
