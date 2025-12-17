package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.z;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u0000\n\u0002\u0008\u0002\u001a\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0016H\u0000\u001a\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016*\u0004\u0018\u00010\u0016H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0007\u0010\u0003\"\u0016\u0010\u0008\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\n\u0010\u0003\"\u0016\u0010\u000b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u000c\u0010\u0003\"\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0010\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0011\u0010\u0003\"\u0016\u0010\u0012\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0013\u0010\u0003\"\u000e\u0010\u0014\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0018", d2 = {"COMPLETING_ALREADY", "Lkotlinx/coroutines/internal/Symbol;", "getCOMPLETING_ALREADY$annotations", "()V", "COMPLETING_RETRY", "getCOMPLETING_RETRY$annotations", "COMPLETING_WAITING_CHILDREN", "getCOMPLETING_WAITING_CHILDREN$annotations", "EMPTY_ACTIVE", "Lkotlinx/coroutines/Empty;", "getEMPTY_ACTIVE$annotations", "EMPTY_NEW", "getEMPTY_NEW$annotations", "FALSE", "", "RETRY", "SEALED", "getSEALED$annotations", "TOO_LATE_TO_CANCEL", "getTOO_LATE_TO_CANCEL$annotations", "TRUE", "boxIncomplete", "", "unboxState", "kotlinx-coroutines-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class g2 {

    private static final z a;
    public static final z b;
    private static final z c;
    private static final z d;
    private static final z e;
    private static final kotlinx.coroutines.h1 f;
    private static final kotlinx.coroutines.h1 g;
    static {
        z zVar = new z("COMPLETING_ALREADY");
        g2.a = zVar;
        z zVar2 = new z("COMPLETING_WAITING_CHILDREN");
        g2.b = zVar2;
        z zVar3 = new z("COMPLETING_RETRY");
        g2.c = zVar3;
        z zVar4 = new z("TOO_LATE_TO_CANCEL");
        g2.d = zVar4;
        z zVar5 = new z("SEALED");
        g2.e = zVar5;
        h1 h1Var = new h1(0);
        g2.f = h1Var;
        h1 h1Var2 = new h1(1);
        g2.g = h1Var2;
    }

    public static final z a() {
        return g2.a;
    }

    public static final z b() {
        return g2.c;
    }

    public static final kotlinx.coroutines.h1 c() {
        return g2.g;
    }

    public static final kotlinx.coroutines.h1 d() {
        return g2.f;
    }

    public static final z e() {
        return g2.e;
    }

    public static final z f() {
        return g2.d;
    }

    public static final Object g(Object object) {
        boolean u1Var;
        Object obj1;
        if (object instanceof t1) {
            u1Var = new u1((t1)object);
            obj1 = u1Var;
        }
        return obj1;
    }

    public static final Object h(Object object) {
        Object obj;
        Object obj1;
        if (object instanceof u1) {
            obj = object;
        } else {
            obj = 0;
        }
        if (obj == null) {
        } else {
            obj1 = obj.a;
        }
        return obj1;
    }
}
