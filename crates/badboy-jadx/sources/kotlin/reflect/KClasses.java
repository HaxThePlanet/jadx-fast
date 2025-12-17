package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0010\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u001a+\u0010\u0000\u001a\u0002H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0012\u0004\u0012\u0002H\u00010\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0006\u001a\u0004\u0018\u0001H\u0001\"\u0008\u0008\u0000\u0010\u0001*\u00020\u0002*\u0008\u0012\u0004\u0012\u0002H\u00010\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\u0007", d2 = {"cast", "T", "", "Lkotlin/reflect/KClass;", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class KClasses {
    public static final <T> T cast(kotlin.reflect.KClass<T> $this$cast, Object value) {
        Intrinsics.checkNotNullParameter($this$cast, "<this>");
        if (!$this$cast.isInstance(value)) {
        } else {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.cast");
            return value;
        }
        StringBuilder stringBuilder = new StringBuilder();
        final int i = 0;
        ClassCastException classCastException = new ClassCastException(stringBuilder.append("Value cannot be cast to ").append($this$cast.getQualifiedName()).toString());
        throw classCastException;
    }

    public static final <T> T safeCast(kotlin.reflect.KClass<T> $this$safeCast, Object value) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$safeCast, "<this>");
        if ($this$safeCast.isInstance(value)) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type T of kotlin.reflect.KClasses.safeCast");
            obj = value;
        } else {
            obj = 0;
        }
        return obj;
    }
}
