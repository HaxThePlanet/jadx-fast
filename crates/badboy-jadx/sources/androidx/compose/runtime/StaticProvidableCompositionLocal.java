package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0000\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\u000c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\u001d\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00072\u0006\u0010\u0008\u001a\u00028\u0000H\u0010¢\u0006\u0004\u0008\t\u0010\n¨\u0006\u000b", d2 = {"Landroidx/compose/runtime/StaticProvidableCompositionLocal;", "T", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "defaultFactory", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "defaultProvidedValue", "Landroidx/compose/runtime/ProvidedValue;", "value", "defaultProvidedValue$runtime_release", "(Ljava/lang/Object;)Landroidx/compose/runtime/ProvidedValue;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StaticProvidableCompositionLocal<T>  extends androidx.compose.runtime.ProvidableCompositionLocal<T> {

    public static final int $stable;
    static {
    }

    public StaticProvidableCompositionLocal(Function0<? extends T> defaultFactory) {
        super(defaultFactory);
    }

    public androidx.compose.runtime.ProvidedValue<T> defaultProvidedValue$runtime_release(T value) {
        int i;
        i = value == null ? 1 : 0;
        ProvidedValue providedValue = new ProvidedValue((CompositionLocal)this, value, i, 0, 0, 0, 0);
        return providedValue;
    }
}
