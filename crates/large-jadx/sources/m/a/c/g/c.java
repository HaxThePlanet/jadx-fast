package m.a.c.g;

import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0000\u0008&\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0008\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010\n\u001a\u00020\u000b2\n\u0010\u000c\u001a\u00060\rj\u0002`\u000eJ\u001c\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u000c\u001a\u00060\rj\u0002`\u000eH\u0002J\u0012\u0010\u0010\u001a\u00020\u000b2\n\u0010\u000c\u001a\u00060\rj\u0002`\u000eJ\u0012\u0010\u0011\u001a\u00020\u000b2\n\u0010\u000c\u001a\u00060\rj\u0002`\u000eJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0003J\u001c\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u00032\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0015J\u001c\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\n\u0010\u000c\u001a\u00060\rj\u0002`\u000eH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004¨\u0006\u0016", d2 = {"Lorg/koin/core/logger/Logger;", "", "level", "Lorg/koin/core/logger/Level;", "(Lorg/koin/core/logger/Level;)V", "getLevel", "()Lorg/koin/core/logger/Level;", "setLevel", "canLog", "", "debug", "", "msg", "", "Lorg/koin/core/logger/MESSAGE;", "doLog", "error", "info", "isAt", "lvl", "log", "Lkotlin/Function0;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public abstract class c {

    private m.a.c.g.b a;
    public c(m.a.c.g.b b) {
        n.f(b, "level");
        super();
        this.a = b;
    }

    private final boolean a(m.a.c.g.b b) {
        int obj2;
        obj2 = this.a.compareTo(b) <= 0 ? 1 : 0;
        return obj2;
    }

    private final void c(m.a.c.g.b b, String string2) {
        if (a(b)) {
            g(b, string2);
        }
    }

    public final void b(String string) {
        n.f(string, "msg");
        c(b.DEBUG, string);
    }

    public final void d(String string) {
        n.f(string, "msg");
        c(b.ERROR, string);
    }

    public final void e(String string) {
        n.f(string, "msg");
        c(b.INFO, string);
    }

    public final boolean f(m.a.c.g.b b) {
        int obj2;
        n.f(b, "lvl");
        obj2 = this.a.compareTo(b) <= 0 ? 1 : 0;
        return obj2;
    }

    public abstract void g(m.a.c.g.b b, String string2);

    public final void h(m.a.c.g.b b, a<String> a2) {
        Object obj3;
        n.f(b, "lvl");
        n.f(a2, "msg");
        if (f(b)) {
            c(b, (String)a2.invoke());
        }
    }
}
