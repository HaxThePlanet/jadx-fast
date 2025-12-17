package androidx.lifecycle.viewmodel;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B#\u0008\u0000\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0003¢\u0006\u0004\u0008\u0006\u0010\u0007B\u0013\u0008\u0017\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\u0008\u0006\u0010\u0008J*\u0010\t\u001a\u00020\n\"\u0004\u0008\u0000\u0010\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u00042\u0006\u0010\r\u001a\u0002H\u000bH\u0086\u0002¢\u0006\u0002\u0010\u000eJ$\u0010\u000f\u001a\u0004\u0018\u0001H\u000b\"\u0004\u0008\u0000\u0010\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u0002H\u000b0\u0004H\u0096\u0002¢\u0006\u0002\u0010\u0010¨\u0006\u0011", d2 = {"Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "Landroidx/lifecycle/viewmodel/CreationExtras;", "initialExtras", "", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "", "<init>", "(Ljava/util/Map;)V", "(Landroidx/lifecycle/viewmodel/CreationExtras;)V", "set", "", "T", "key", "t", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;Ljava/lang/Object;)V", "get", "(Landroidx/lifecycle/viewmodel/CreationExtras$Key;)Ljava/lang/Object;", "lifecycle-viewmodel_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MutableCreationExtras extends androidx.lifecycle.viewmodel.CreationExtras {
    public MutableCreationExtras() {
        final int i = 0;
        super(i, 1, i);
    }

    public MutableCreationExtras(androidx.lifecycle.viewmodel.CreationExtras initialExtras) {
        Intrinsics.checkNotNullParameter(initialExtras, "initialExtras");
        super(initialExtras.getExtras$lifecycle_viewmodel_release());
    }

    public MutableCreationExtras(androidx.lifecycle.viewmodel.CreationExtras creationExtras, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        androidx.lifecycle.viewmodel.CreationExtras.Empty obj1;
        if (i2 &= 1 != 0) {
            obj1 = CreationExtras.Empty.INSTANCE;
        }
        super(obj1);
    }

    public MutableCreationExtras(Map<androidx.lifecycle.viewmodel.CreationExtras.Key<?>, ? extends Object> initialExtras) {
        Intrinsics.checkNotNullParameter(initialExtras, "initialExtras");
        super();
        getExtras$lifecycle_viewmodel_release().putAll(initialExtras);
    }

    public <T> T get(androidx.lifecycle.viewmodel.CreationExtras.Key<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return getExtras$lifecycle_viewmodel_release().get(key);
    }

    public final <T> void set(androidx.lifecycle.viewmodel.CreationExtras.Key<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        getExtras$lifecycle_viewmodel_release().put(key, t);
    }
}
