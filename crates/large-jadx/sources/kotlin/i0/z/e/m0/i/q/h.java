package kotlin.i0.z.e.m0.i.q;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.d0.c.l;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.i0.z.e.m0.b.h;
import kotlin.i0.z.e.m0.b.i;
import kotlin.i0.z.e.m0.l.b0;
import kotlin.reflect.jvm.internal.impl.descriptors.c0;
import kotlin.y.i;
import kotlin.y.p;

/* loaded from: classes3.dex */
public final class h {

    public static final kotlin.i0.z.e.m0.i.q.h a;

    static final class a extends p implements l<c0, b0> {

        final b0 $type;
        a(b0 b0) {
            this.$type = b0;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final b0 a(c0 c0) {
            n.f(c0, "it");
            return this.$type;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((c0)object);
        }
    }

    static final class b extends p implements l<c0, b0> {

        final i $componentType;
        b(i i) {
            this.$componentType = i;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final b0 a(c0 c0) {
            n.f(c0, "module");
            kotlin.i0.z.e.m0.l.i0 obj2 = c0.m().N(this.$componentType);
            n.e(obj2, "module.builtIns.getPrimitiveArrayKotlinType(componentType)");
            return obj2;
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            return a((c0)object);
        }
    }
    static {
        h hVar = new h();
        h.a = hVar;
    }

    private final kotlin.i0.z.e.m0.i.q.b a(List<?> list, i i2) {
        kotlin.i0.z.e.m0.i.q.g gVar;
        ArrayList arrayList = new ArrayList();
        Iterator obj3 = p.L0(list).iterator();
        while (obj3.hasNext()) {
            gVar = c(obj3.next());
            if (gVar != null) {
            }
            arrayList.add(gVar);
        }
        obj3 = new h.b(i2);
        b obj4 = new b(arrayList, obj3);
        return obj4;
    }

    public final kotlin.i0.z.e.m0.i.q.b b(List<? extends kotlin.i0.z.e.m0.i.q.g<?>> list, b0 b02) {
        n.f(list, "value");
        n.f(b02, "type");
        h.a aVar = new h.a(b02);
        b bVar = new b(list, aVar);
        return bVar;
    }

    public final kotlin.i0.z.e.m0.i.q.g<?> c(Object object) {
        kotlin.i0.z.e.m0.i.q.u uVar;
        double doubleValue;
        short obj4;
        if (object instanceof Byte) {
            uVar = new d((Number)object.byteValue());
        } else {
            if (object instanceof Short) {
                uVar = new u((Number)object.shortValue());
            } else {
                if (object instanceof Integer) {
                    uVar = new m((Number)object.intValue());
                } else {
                    if (object instanceof Long) {
                        uVar = new r((Number)object.longValue(), obj2);
                    } else {
                        if (object instanceof Character) {
                            uVar = new e((Character)object.charValue());
                        } else {
                            if (object instanceof Float) {
                                uVar = new l((Number)object.floatValue());
                            } else {
                                if (object instanceof Double) {
                                    uVar = new i((Number)object.doubleValue(), obj2);
                                } else {
                                    if (object instanceof Boolean) {
                                        uVar = new c((Boolean)object.booleanValue());
                                    } else {
                                        if (object instanceof String != null) {
                                            uVar = new v((String)object);
                                        } else {
                                            if (object instanceof byte[]) {
                                                uVar = a(i.U((byte[])object), i.BYTE);
                                            } else {
                                                if (object instanceof short[]) {
                                                    uVar = a(i.b0((short[])object), i.SHORT);
                                                } else {
                                                    if (object instanceof int[]) {
                                                        uVar = a(i.Y((int[])object), i.INT);
                                                    } else {
                                                        if (object instanceof long[]) {
                                                            uVar = a(i.Z((long[])object), i.LONG);
                                                        } else {
                                                            if (object instanceof char[]) {
                                                                uVar = a(i.V((char[])object), i.CHAR);
                                                            } else {
                                                                if (object instanceof float[]) {
                                                                    uVar = a(i.X((float[])object), i.FLOAT);
                                                                } else {
                                                                    if (object instanceof double[]) {
                                                                        uVar = a(i.W((double[])object), i.DOUBLE);
                                                                    } else {
                                                                        if (object instanceof boolean[]) {
                                                                            uVar = a(i.c0((boolean[])object), i.BOOLEAN);
                                                                        } else {
                                                                            if (object == null) {
                                                                                uVar = new s();
                                                                            } else {
                                                                                uVar = 0;
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return uVar;
    }
}
