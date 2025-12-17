package kotlin.l0;

import kotlin.Metadata;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008g\u0018\u0000 \u00042\u00020\u0001:\u0002\u0004\u0005J\u0008\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0006", d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public interface g {

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003", d2 = {"Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a {

        static final kotlin.l0.g.a a;
        static {
            g.a aVar = new g.a();
            g.a.a = aVar;
        }
    }

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0096\u0001J\u0008\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007", d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource;", "()V", "markNow", "Lkotlin/time/TimeMark;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class b implements kotlin.l0.g {

        public static final kotlin.l0.g.b b;
        private final kotlin.l0.e a;
        static {
            g.b bVar = new g.b();
            g.b.b = bVar;
        }

        private b() {
            super();
            this.a = e.b;
        }

        @Override // kotlin.l0.g
        public kotlin.l0.f a() {
            return this.a.a();
        }

        @Override // kotlin.l0.g
        public String toString() {
            return e.b.toString();
        }
    }
    static {
        final kotlin.l0.g.a aVar = g.a.a;
    }

    public abstract kotlin.l0.f a();
}
