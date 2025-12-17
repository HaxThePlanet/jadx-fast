package kotlin.g0;

import java.util.Random;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0008\u0003*\u0001\u0008\u0008\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\n", d2 = {"Lkotlin/random/FallbackThreadLocalRandom;", "Lkotlin/random/AbstractPlatformRandom;", "()V", "impl", "Ljava/util/Random;", "getImpl", "()Ljava/util/Random;", "implStorage", "kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Lkotlin/random/FallbackThreadLocalRandom$implStorage$1;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class b extends kotlin.g0.a {

    private final kotlin.g0.b.a c;

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001J\u0008\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004", d2 = {"kotlin/random/FallbackThreadLocalRandom$implStorage$1", "Ljava/lang/ThreadLocal;", "Ljava/util/Random;", "initialValue", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a extends java.lang.ThreadLocal<Random> {
        @Override // java.lang.ThreadLocal
        protected Random a() {
            Random random = new Random();
            return random;
        }

        @Override // java.lang.ThreadLocal
        public Object initialValue() {
            return a();
        }
    }
    public b() {
        super();
        b.a aVar = new b.a();
        this.c = aVar;
    }

    @Override // kotlin.g0.a
    public Random g() {
        Object obj = this.c.get();
        n.e(obj, "implStorage.get()");
        return (Random)obj;
    }
}
