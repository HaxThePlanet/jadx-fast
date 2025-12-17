package androidx.compose.ui.text.platform;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0000\u001a*\u0010\u0002\u001a\u0002H\u0003\"\u0004\u0008\u0000\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00030\u0006H\u0081\u0008¢\u0006\u0002\u0010\u0007¨\u0006\u0008", d2 = {"createSynchronizedObject", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "synchronized", "R", "lock", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/text/platform/SynchronizedObject;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Synchronization_jvmKt {
    public static final androidx.compose.ui.text.platform.SynchronizedObject createSynchronizedObject() {
        SynchronizedObject synchronizedObject = new SynchronizedObject();
        return synchronizedObject;
    }

    public static final <R> R synchronized(androidx.compose.ui.text.platform.SynchronizedObject lock, Function0<? extends R> block) {
        final int i = 0;
        return block.invoke();
        synchronized (lock) {
            i = 0;
            return block.invoke();
        }
    }
}
