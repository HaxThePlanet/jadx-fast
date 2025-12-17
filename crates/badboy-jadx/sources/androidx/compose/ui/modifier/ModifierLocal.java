package androidx.compose.ui.modifier;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0015\u0008\u0004\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005R\u001a\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\u0082\u0001\u0001\u0008¨\u0006\t", d2 = {"Landroidx/compose/ui/modifier/ModifierLocal;", "T", "", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "getDefaultFactory$ui_release", "()Lkotlin/jvm/functions/Function0;", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class ModifierLocal<T>  {

    public static final int $stable;
    private final Function0<T> defaultFactory;
    static {
    }

    private ModifierLocal(Function0<? extends T> defaultFactory) {
        super();
        this.defaultFactory = defaultFactory;
    }

    public ModifierLocal(Function0 function0, DefaultConstructorMarker defaultConstructorMarker2) {
        super(function0);
    }

    public final Function0<T> getDefaultFactory$ui_release() {
        return this.defaultFactory;
    }
}
