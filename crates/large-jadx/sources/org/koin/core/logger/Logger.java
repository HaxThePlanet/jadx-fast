package m.a.c.g;

import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;

/* compiled from: Logger.kt */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u0008&\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u000b2\n\u0010\u000c\u001a\u00060\rj\u0002`\u000eJ\u001c\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u000c\u001a\u00060\rj\u0002`\u000eH\u0002J\u0012\u0010\u0010\u001a\u00020\u000b2\n\u0010\u000c\u001a\u00060\rj\u0002`\u000eJ\u0012\u0010\u0011\u001a\u00020\u000b2\n\u0010\u000c\u001a\u00060\rj\u0002`\u000eJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003J\u001c\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00032\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0015J\u001c\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u000c\u001a\u00060\rj\u0002`\u000eH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004¨\u0006\u0016", d2 = {"Lorg/koin/core/logger/Logger;", "", "level", "Lorg/koin/core/logger/Level;", "(Lorg/koin/core/logger/Level;)V", "getLevel", "()Lorg/koin/core/logger/Level;", "setLevel", "canLog", "", "debug", "", "msg", "", "Lorg/koin/core/logger/MESSAGE;", "doLog", "error", "info", "isAt", "lvl", "log", "Lkotlin/Function0;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
/* renamed from: c, reason: from kotlin metadata */
public abstract class Logger {

    private b a;
    public c(b bVar) {
        n.f(bVar, "level");
        super();
        this.a = bVar;
    }

    /* renamed from: a, reason: from kotlin metadata */
    private final boolean canLog(b level) {
        boolean z = true;
        level = this.a.compareTo(level) <= 0 ? 1 : 0;
        return (this.a.compareTo(level) <= 0 ? 1 : 0);
    }

    /* renamed from: c, reason: from kotlin metadata */
    private final void doLog(b level, String msg) {
        if (canLog(level)) {
            log(level, msg);
        }
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final void debug(String msg) {
        n.f(msg, "msg");
        doLog(Level.DEBUG, msg);
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final void error(String msg) {
        n.f(msg, "msg");
        doLog(Level.ERROR, msg);
    }

    /* renamed from: e, reason: from kotlin metadata */
    public final void info(String msg) {
        n.f(msg, "msg");
        doLog(Level.INFO, msg);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final boolean isAt(b lvl) {
        boolean z = true;
        n.f(lvl, "lvl");
        lvl = this.a.compareTo(lvl) <= 0 ? 1 : 0;
        return (this.a.compareTo(lvl) <= 0 ? 1 : 0);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public final void log(b level, a<String> msg) {
        n.f(level, "lvl");
        n.f(msg, "msg");
        if (isAt(level)) {
            doLog(level, (String)msg.invoke());
        }
    }

    /* renamed from: g, reason: from kotlin metadata */
    public abstract void log(b lvl, String msg);
}
