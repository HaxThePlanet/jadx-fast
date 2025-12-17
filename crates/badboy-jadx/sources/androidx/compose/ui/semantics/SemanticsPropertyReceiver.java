package androidx.compose.ui.semantics;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008f\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u0003\"\u0004\u0008\u0000\u0010\u00042\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u0002H\u00040\u00062\u0006\u0010\u0007\u001a\u0002H\u0004H¦\u0002¢\u0006\u0002\u0010\u0008ø\u0001\u0000\u0082\u0002\u0006\n\u0004\u0008!0\u0001¨\u0006\tÀ\u0006\u0001", d2 = {"Landroidx/compose/ui/semantics/SemanticsPropertyReceiver;", "", "set", "", "T", "key", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "value", "(Landroidx/compose/ui/semantics/SemanticsPropertyKey;Ljava/lang/Object;)V", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface SemanticsPropertyReceiver {
    public abstract <T> void set(androidx.compose.ui.semantics.SemanticsPropertyKey<T> semanticsPropertyKey, T t2);
}
