package androidx.lifecycle.viewmodel;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000 \n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004H\u0086\u0002\u001a\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002\u001a\u0015\u0010\u0008\u001a\u00020\t*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0086\u0002¨\u0006\n", d2 = {"contains", "", "Landroidx/lifecycle/viewmodel/CreationExtras;", "key", "Landroidx/lifecycle/viewmodel/CreationExtras$Key;", "plus", "Landroidx/lifecycle/viewmodel/MutableCreationExtras;", "creationExtras", "plusAssign", "", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CreationExtrasKt {
    public static final boolean contains(androidx.lifecycle.viewmodel.CreationExtras $this$contains, androidx.lifecycle.viewmodel.CreationExtras.Key<?> key) {
        Intrinsics.checkNotNullParameter($this$contains, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return $this$contains.getExtras$lifecycle_viewmodel_release().containsKey(key);
    }

    public static final androidx.lifecycle.viewmodel.MutableCreationExtras plus(androidx.lifecycle.viewmodel.CreationExtras $this$plus, androidx.lifecycle.viewmodel.CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(creationExtras, "creationExtras");
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(MapsKt.plus($this$plus.getExtras$lifecycle_viewmodel_release(), creationExtras.getExtras$lifecycle_viewmodel_release()));
        return mutableCreationExtras;
    }

    public static final void plusAssign(androidx.lifecycle.viewmodel.MutableCreationExtras $this$plusAssign, androidx.lifecycle.viewmodel.CreationExtras creationExtras) {
        Intrinsics.checkNotNullParameter($this$plusAssign, "<this>");
        Intrinsics.checkNotNullParameter(creationExtras, "creationExtras");
        $this$plusAssign.getExtras$lifecycle_viewmodel_release().putAll(creationExtras.getExtras$lifecycle_viewmodel_release());
    }
}
