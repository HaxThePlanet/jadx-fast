package androidx.lifecycle.viewmodel.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\"*\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0008\u0008\u0000\u0010\u0002*\u00020\u0003*\u0008\u0012\u0004\u0012\u0002H\u00020\u00048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"canonicalName", "", "T", "", "Lkotlin/reflect/KClass;", "getCanonicalName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "lifecycle-viewmodel_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ViewModelProviders_jvmKt {
    public static final <T> String getCanonicalName(KClass<T> $this$canonicalName) {
        Intrinsics.checkNotNullParameter($this$canonicalName, "<this>");
        return $this$canonicalName.getQualifiedName();
    }
}
