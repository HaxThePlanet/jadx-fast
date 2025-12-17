package kotlin.i0.z.e.m0.b;

import java.util.Set;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.j;
import kotlin.m;
import kotlin.y.q0;

/* loaded from: classes3.dex */
public enum i {

    BOOLEAN("Boolean"),
    CHAR("Char"),
    BYTE("Byte"),
    SHORT("Short"),
    INT("Int"),
    FLOAT("Float"),
    LONG("Long"),
    DOUBLE(5);

    private final h arrayTypeFqName$delegate;
    private final e arrayTypeName;
    private final h typeFqName$delegate;
    private final e typeName;

    public static final class a {
        public a(g g) {
            super();
        }
    }

    static final class b extends p implements a<b> {

        final kotlin.i0.z.e.m0.b.i this$0;
        b(kotlin.i0.z.e.m0.b.i i) {
            this.this$0 = i;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final b a() {
            b bVar2 = k.l.c(this.this$0.getArrayTypeName());
            n.e(bVar2, "BUILT_INS_PACKAGE_FQ_NAME.child(arrayTypeName)");
            return bVar2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    static final class c extends p implements a<b> {

        final kotlin.i0.z.e.m0.b.i this$0;
        c(kotlin.i0.z.e.m0.b.i i) {
            this.this$0 = i;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final b a() {
            b bVar2 = k.l.c(this.this$0.getTypeName());
            n.e(bVar2, "BUILT_INS_PACKAGE_FQ_NAME.child(this.typeName)");
            return bVar2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }
    @Override // java.lang.Enum
    public final b getArrayTypeFqName() {
        return (b)this.arrayTypeFqName$delegate.getValue();
    }

    @Override // java.lang.Enum
    public final e getArrayTypeName() {
        return this.arrayTypeName;
    }

    @Override // java.lang.Enum
    public final b getTypeFqName() {
        return (b)this.typeFqName$delegate.getValue();
    }

    @Override // java.lang.Enum
    public final e getTypeName() {
        return this.typeName;
    }
}
