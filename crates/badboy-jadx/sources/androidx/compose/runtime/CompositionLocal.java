package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u00087\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u0015\u0008\u0004\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J1\u0010\u000f\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000c2\u000c\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000cH ¢\u0006\u0002\u0008\u0013R\u0018\u0010\u0006\u001a\u00028\u00008Ç\u0002¢\u0006\u000c\u0012\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\t\u0010\nR\u001a\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u000cX\u0090\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e\u0082\u0001\u0001\u0014¨\u0006\u0015", d2 = {"Landroidx/compose/runtime/CompositionLocal;", "T", "", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "current", "getCurrent$annotations", "()V", "getCurrent", "(Landroidx/compose/runtime/Composer;I)Ljava/lang/Object;", "defaultValueHolder", "Landroidx/compose/runtime/ValueHolder;", "getDefaultValueHolder$runtime_release", "()Landroidx/compose/runtime/ValueHolder;", "updatedStateOf", "value", "Landroidx/compose/runtime/ProvidedValue;", "previous", "updatedStateOf$runtime_release", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public abstract class CompositionLocal<T>  {

    public static final int $stable;
    private final androidx.compose.runtime.ValueHolder<T> defaultValueHolder;
    static {
    }

    private CompositionLocal(Function0<? extends T> defaultFactory) {
        super();
        LazyValueHolder lazyValueHolder = new LazyValueHolder(defaultFactory);
        this.defaultValueHolder = (ValueHolder)lazyValueHolder;
    }

    public CompositionLocal(Function0 function0, DefaultConstructorMarker defaultConstructorMarker2) {
        super(function0);
    }

    public static void getCurrent$annotations() {
    }

    public final T getCurrent(androidx.compose.runtime.Composer $composer, int $changed) {
        final int i = 0;
        ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        ComposerKt.sourceInformationMarkerEnd($composer);
        return $composer.consume(this);
    }

    public androidx.compose.runtime.ValueHolder<T> getDefaultValueHolder$runtime_release() {
        return this.defaultValueHolder;
    }

    public abstract androidx.compose.runtime.ValueHolder<T> updatedStateOf$runtime_release(androidx.compose.runtime.ProvidedValue<T> providedValue, androidx.compose.runtime.ValueHolder<T> valueHolder2);
}
