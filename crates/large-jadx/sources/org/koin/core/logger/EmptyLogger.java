package m.a.c.g;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: EmptyLogger.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u00060\u0008j\u0002`\tH\u0016¨\u0006\n", d2 = {"Lorg/koin/core/logger/EmptyLogger;", "Lorg/koin/core/logger/Logger;", "()V", "log", "", "level", "Lorg/koin/core/logger/Level;", "msg", "", "Lorg/koin/core/logger/MESSAGE;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: a, reason: from kotlin metadata */
public final class EmptyLogger extends c {
    public a() {
        super(Level.NONE);
    }

    @Override // m.a.c.g.c
    /* renamed from: g, reason: from kotlin metadata */
    public void log(b level, String msg) {
        n.f(level, "level");
        n.f(msg, "msg");
    }
}
