package m.a.c.i;

import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.i;

/* compiled from: ParametersHolder.kt */
@Metadata(d1 = "\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001\u001a#\u0010\u0002\u001a\u00020\u00012\u0016\u0010\u0003\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00050\u0004\"\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006*\u0016\u0010\u0007\"\u0008\u0012\u0004\u0012\u00020\u00010\u00082\u0008\u0012\u0004\u0012\u00020\u00010\u0008¨\u0006\t", d2 = {"emptyParametersHolder", "Lorg/koin/core/parameter/ParametersHolder;", "parametersOf", "parameters", "", "", "([Ljava/lang/Object;)Lorg/koin/core/parameter/ParametersHolder;", "ParametersDefinition", "Lkotlin/Function0;", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* typealias ParametersDefinition = kotlin.Function0<org.koin.core.parameter.ParametersHolder> */
public final class b {
    /* renamed from: a, reason: from kotlin metadata */
    public static final a emptyParametersHolder() {
        final java.util.List list = null;
        return new ParametersHolder(list, 1, list);
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final a parametersOf(Object... parameters) {
        n.f(parameters, "parameters");
        return new ParametersHolder(m.j0(parameters));
    }
}
