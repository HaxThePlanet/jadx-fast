package m.a.c.c;

import kotlin.Metadata;
import kotlin.d0.d.n;
import m.a.c.d.c;

/* compiled from: KoinComponent.kt */
@Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008f\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"Lorg/koin/core/component/KoinComponent;", "", "getKoin", "Lorg/koin/core/Koin;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: a, reason: from kotlin metadata */
public interface KoinComponent {

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public static m.a.c.a a(a aVar) {
            n.f(aVar, "this");
            return KoinPlatformTools.a.defaultContext().get();
        }
    }
    m.a.c.a getKoin();
}
