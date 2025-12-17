package m.a.c;

import java.util.List;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.w;
import m.a.c.g.b;
import m.a.c.g.c;
import m.a.c.h.a;
import m.a.c.k.a;
import m.a.c.m.a;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004J\u0006\u0010\u000b\u001a\u00020\tJ\u0016\u0010\u000c\u001a\u00020\t2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u001f\u0010\r\u001a\u00020\u00002\u0012\u0010\r\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u000f0\u0012\"\u00020\u000f¢\u0006\u0002\u0010\u0013J\u0014\u0010\r\u001a\u00020\u00002\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0015\u001a\u00020\u0016J\u001a\u0010\u0017\u001a\u00020\u00002\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0\u0019J\u0014\u0010\u001b\u001a\u00020\t2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u001e", d2 = {"Lorg/koin/core/KoinApplication;", "", "()V", "allowOverride", "", "koin", "Lorg/koin/core/Koin;", "getKoin", "()Lorg/koin/core/Koin;", "", "override", "close", "loadModules", "modules", "", "Lorg/koin/core/module/Module;", "logger", "Lorg/koin/core/logger/Logger;", "", "([Lorg/koin/core/module/Module;)Lorg/koin/core/KoinApplication;", "printLogger", "level", "Lorg/koin/core/logger/Level;", "properties", "values", "", "", "unloadModules", "module", "Companion", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class b {

    public static final m.a.c.b.a c;
    private final m.a.c.a a;
    private boolean b;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005", d2 = {"Lorg/koin/core/KoinApplication$Companion;", "", "()V", "init", "Lorg/koin/core/KoinApplication;", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }

        public final m.a.c.b a() {
            b bVar = new b(0);
            return bVar;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class b extends p implements a<w> {

        final List<a> $modules;
        final m.a.c.b this$0;
        b(m.a.c.b b, List<a> list2) {
            this.this$0 = b;
            this.$modules = list2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            b.a(this.this$0, this.$modules);
        }
    }
    static {
        b.a aVar = new b.a(0);
        b.c = aVar;
    }

    private b() {
        super();
        a aVar = new a();
        this.a = aVar;
        this.b = true;
    }

    public b(g g) {
        super();
    }

    public static final void a(m.a.c.b b, List list2) {
        b.c(list2);
    }

    private final void c(List<a> list) {
        this.a.e(list, this.b);
    }

    public final m.a.c.a b() {
        return this.a;
    }

    public final m.a.c.b d(List<a> list) {
        double z;
        c cVar;
        StringBuilder stringBuilder;
        String str;
        Object obj6;
        n.f(list, "modules");
        final b iNFO = b.INFO;
        if (this.a.c().f(iNFO)) {
            b.b bVar = new b.b(this, list);
            stringBuilder = new StringBuilder();
            stringBuilder.append("loaded ");
            stringBuilder.append(this.a.b().h());
            stringBuilder.append(" definitions - ");
            stringBuilder.append(a.a(bVar));
            stringBuilder.append(" ms");
            this.a.c().e(stringBuilder.toString());
        } else {
            c(list);
        }
        return this;
    }
}
