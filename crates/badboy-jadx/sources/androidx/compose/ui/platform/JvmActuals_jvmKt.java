package androidx.compose.ui.platform;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0000\u001a*\u0010\u0005\u001a\u0002H\u0006\"\u0004\u0008\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u00032\u000c\u0010\u0008\u001a\u0008\u0012\u0004\u0012\u0002H\u00060\tH\u0081\u0008¢\u0006\u0002\u0010\n\u001a\u000c\u0010\u000b\u001a\u00020\u0003*\u00020\u0003H\u0000*\u000c\u0008\u0000\u0010\u000c\"\u00020\r2\u00020\r¨\u0006\u000e", d2 = {"simpleIdentityToString", "", "obj", "", "name", "synchronized", "R", "lock", "block", "Lkotlin/Function0;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "nativeClass", "AtomicInt", "Ljava/util/concurrent/atomic/AtomicInteger;", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class JvmActuals_jvmKt {
    public static void AtomicInt$annotations() {
    }

    public static final Object nativeClass(Object $this$nativeClass) {
        return $this$nativeClass.getClass();
    }

    public static final String simpleIdentityToString(Object obj, String name) {
        String simpleName;
        if (name == null) {
            if (obj.getClass().isAnonymousClass()) {
                simpleName = obj.getClass().getName();
            } else {
                simpleName = obj.getClass().getSimpleName();
            }
        } else {
            simpleName = name;
        }
        StringBuilder stringBuilder = new StringBuilder();
        StringCompanionObject iNSTANCE = StringCompanionObject.INSTANCE;
        String format = String.format("%07x", Arrays.copyOf(/* result */, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return stringBuilder.append(simpleName).append('@').append(format).toString();
    }

    public static final <R> R synchronized(Object lock, Function0<? extends R> block) {
        final int i = 0;
        return block.invoke();
        synchronized (lock) {
            i = 0;
            return block.invoke();
        }
    }
}
