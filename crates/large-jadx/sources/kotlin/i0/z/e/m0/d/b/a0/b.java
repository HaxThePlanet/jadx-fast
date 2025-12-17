package kotlin.i0.z.e.m0.d.b.a0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.i0.z.e.m0.d.a.y;
import kotlin.i0.z.e.m0.d.b.o.a;
import kotlin.i0.z.e.m0.d.b.o.b;
import kotlin.i0.z.e.m0.d.b.o.c;
import kotlin.i0.z.e.m0.e.a0.b.c;
import kotlin.i0.z.e.m0.e.a0.b.f;
import kotlin.i0.z.e.m0.f.a;
import kotlin.i0.z.e.m0.f.b;
import kotlin.i0.z.e.m0.f.e;
import kotlin.i0.z.e.m0.i.q.f;
import kotlin.reflect.jvm.internal.impl.descriptors.u0;

/* loaded from: classes3.dex */
public class b implements o.c {

    private static final boolean j;
    private static final Map<a, kotlin.i0.z.e.m0.d.b.a0.a.a> k;
    private int[] a = null;
    private c b = null;
    private String c = null;
    private int d = 0;
    private String e = null;
    private String[] f = null;
    private String[] g = null;
    private String[] h = null;
    private kotlin.i0.z.e.m0.d.b.a0.a.a i = null;

    static class a {
    }

    private static abstract class b implements o.b {

        private final List<String> a;
        public b() {
            super();
            ArrayList arrayList = new ArrayList();
            this.a = arrayList;
        }

        private static void e(int i) {
            String str;
            String obj5;
            Object[] arr = new Object[3];
            final int i3 = 1;
            int i4 = 0;
            final int i5 = 2;
            if (i != i3) {
                if (i != i5) {
                    arr[i4] = "enumClassId";
                } else {
                    arr[i4] = "classLiteralValue";
                }
            } else {
                arr[i4] = "enumEntryName";
            }
            arr[i3] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$CollectStringArrayAnnotationVisitor";
            if (i != i5) {
                arr[i5] = "visitEnum";
            } else {
                arr[i5] = "visitClassLiteral";
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$b
        public void a() {
            f((String[])this.a.toArray(new String[0]));
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$b
        public void b(Object object) {
            boolean z;
            if (object instanceof String != null) {
                this.a.add((String)object);
            }
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$b
        public void c(a a, e e2) {
            final int i = 0;
            if (a == null) {
            } else {
                if (e2 == null) {
                } else {
                }
                b.b.e(1);
                throw i;
            }
            b.b.e(0);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$b
        public void d(f f) {
            if (f == null) {
            } else {
            }
            b.b.e(2);
            throw 0;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$b
        protected abstract void f(String[] stringArr);
    }

    private class c implements o.a {

        final kotlin.i0.z.e.m0.d.b.a0.b a;
        private c(kotlin.i0.z.e.m0.d.b.a0.b b) {
            this.a = b;
            super();
        }

        c(kotlin.i0.z.e.m0.d.b.a0.b b, kotlin.i0.z.e.m0.d.b.a0.b.a b$a2) {
            super(b);
        }

        private static void g(int i) {
            String str;
            String obj4;
            Object[] arr = new Object[3];
            int i4 = 1;
            int i7 = 0;
            if (i != i4) {
                if (i != 7) {
                    if (i != 4) {
                        if (i != 5) {
                            arr[i7] = "name";
                        } else {
                            arr[i7] = "enumEntryName";
                        }
                    } else {
                        arr[i7] = "enumClassId";
                    }
                } else {
                    arr[i7] = "classId";
                }
            } else {
                arr[i7] = "classLiteralValue";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$KotlinMetadataArgumentVisitor";
            int i5 = 2;
            switch (i) {
                case 2:
                    arr[i5] = "visitArray";
                    break;
                case 3:
                    arr[i5] = "visitEnum";
                    break;
                case 4:
                    arr[i5] = "visitAnnotation";
                    break;
                default:
                    arr[i5] = "visitClassLiteral";
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        private o.b h() {
            b.c.a aVar = new b.c.a(this);
            return aVar;
        }

        private o.b i() {
            b.c.b bVar = new b.c.b(this);
            return bVar;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void a() {
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void b(e e, f f2) {
            final int i = 0;
            if (e == null) {
            } else {
                if (f2 == null) {
                } else {
                }
                b.c.g(1);
                throw i;
            }
            b.c.g(0);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void c(e e, Object object2) {
            boolean cVar;
            boolean obj2;
            Object obj3;
            if (e == null) {
            }
            obj2 = e.c();
            if ("k".equals(obj2)) {
                if (object2 instanceof Integer) {
                    b.e(this.a, a.a.getById((Integer)object2.intValue()));
                }
            } else {
                if ("mv".equals(obj2)) {
                    if (object2 instanceof int[]) {
                        b.f(this.a, (int[])object2);
                    }
                } else {
                    if ("bv".equals(obj2)) {
                        if (object2 instanceof int[]) {
                            cVar = new c((int[])object2);
                            b.h(this.a, cVar);
                        }
                    } else {
                        if ("xs".equals(obj2)) {
                            if (object2 instanceof String != null) {
                                b.i(this.a, (String)object2);
                            }
                        } else {
                            if ("xi".equals(obj2)) {
                                if (object2 instanceof Integer) {
                                    b.j(this.a, (Integer)object2.intValue());
                                }
                            } else {
                                if ("pn".equals(obj2) && object2 instanceof String != null) {
                                    if (object2 instanceof String != null) {
                                        b.k(this.a, (String)object2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void d(e e, a a2, e e3) {
            final int i = 0;
            if (e == null) {
            } else {
                if (a2 == null) {
                } else {
                    if (e3 == null) {
                    } else {
                    }
                    b.c.g(5);
                    throw i;
                }
                b.c.g(4);
                throw i;
            }
            b.c.g(3);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public o.a e(e e, a a2) {
            final int i = 0;
            if (e == null) {
            } else {
                if (a2 == null) {
                } else {
                    return i;
                }
                b.c.g(7);
                throw i;
            }
            b.c.g(6);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public o.b f(e e) {
            final int i = 0;
            if (e == null) {
            } else {
                String obj3 = e.c();
                if ("d1".equals(obj3)) {
                    return h();
                }
                if ("d2".equals(obj3)) {
                    return i();
                }
                return i;
            }
            b.c.g(2);
            throw i;
        }
    }

    private class d implements o.a {

        final kotlin.i0.z.e.m0.d.b.a0.b a;
        private d(kotlin.i0.z.e.m0.d.b.a0.b b) {
            this.a = b;
            super();
        }

        d(kotlin.i0.z.e.m0.d.b.a0.b b, kotlin.i0.z.e.m0.d.b.a0.b.a b$a2) {
            super(b);
        }

        private static void g(int i) {
            String str;
            String obj4;
            Object[] arr = new Object[3];
            int i4 = 1;
            int i7 = 0;
            if (i != i4) {
                if (i != 7) {
                    if (i != 4) {
                        if (i != 5) {
                            arr[i7] = "name";
                        } else {
                            arr[i7] = "enumEntryName";
                        }
                    } else {
                        arr[i7] = "enumClassId";
                    }
                } else {
                    arr[i7] = "classId";
                }
            } else {
                arr[i7] = "classLiteralValue";
            }
            arr[i4] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor$OldDeprecatedAnnotationArgumentVisitor";
            int i5 = 2;
            switch (i) {
                case 2:
                    arr[i5] = "visitArray";
                    break;
                case 3:
                    arr[i5] = "visitEnum";
                    break;
                case 4:
                    arr[i5] = "visitAnnotation";
                    break;
                default:
                    arr[i5] = "visitClassLiteral";
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
            throw illegalArgumentException;
        }

        private o.b h() {
            b.d.a aVar = new b.d.a(this);
            return aVar;
        }

        private o.b i() {
            b.d.b bVar = new b.d.b(this);
            return bVar;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void a() {
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void b(e e, f f2) {
            final int i = 0;
            if (e == null) {
            } else {
                if (f2 == null) {
                } else {
                }
                b.d.g(1);
                throw i;
            }
            b.d.g(0);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void c(e e, Object object2) {
            boolean cVar;
            boolean obj2;
            Object obj3;
            if (e == null) {
            }
            obj2 = e.c();
            if ("version".equals(obj2)) {
                b.f(this.a, (int[])object2);
                if (object2 instanceof int[] && b.g(this.a) == null) {
                    b.f(this.a, (int[])object2);
                    if (b.g(this.a) == null) {
                        cVar = new c(object2);
                        b.h(this.a, cVar);
                    }
                }
            } else {
                if ("multifileClassName".equals(obj2) != null) {
                    if (object2 instanceof String != null) {
                    } else {
                        obj3 = 0;
                    }
                    b.i(this.a, obj3);
                }
            }
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public void d(e e, a a2, e e3) {
            final int i = 0;
            if (e == null) {
            } else {
                if (a2 == null) {
                } else {
                    if (e3 == null) {
                    } else {
                    }
                    b.d.g(5);
                    throw i;
                }
                b.d.g(4);
                throw i;
            }
            b.d.g(3);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public o.a e(e e, a a2) {
            final int i = 0;
            if (e == null) {
            } else {
                if (a2 == null) {
                } else {
                    return i;
                }
                b.d.g(7);
                throw i;
            }
            b.d.g(6);
            throw i;
        }

        @Override // kotlin.i0.z.e.m0.d.b.o$a
        public o.b f(e e) {
            boolean equals;
            final int i = 0;
            if (e == null) {
            } else {
                String obj3 = e.c();
                if (!"data".equals(obj3)) {
                    if ("filePartClassNames".equals(obj3) != null) {
                    } else {
                        if ("strings".equals(obj3)) {
                            return i();
                        }
                    }
                    return i;
                }
                return h();
            }
            b.d.g(2);
            throw i;
        }
    }
    static {
        b.j = "true".equals(System.getProperty("kotlin.ignore.old.metadata"));
        HashMap hashMap = new HashMap();
        b.k = hashMap;
        b bVar = new b("kotlin.jvm.internal.KotlinClass");
        hashMap.put(a.m(bVar), a.a.CLASS);
        b bVar2 = new b("kotlin.jvm.internal.KotlinFileFacade");
        hashMap.put(a.m(bVar2), a.a.FILE_FACADE);
        b bVar3 = new b("kotlin.jvm.internal.KotlinMultifileClass");
        hashMap.put(a.m(bVar3), a.a.MULTIFILE_CLASS);
        b bVar4 = new b("kotlin.jvm.internal.KotlinMultifileClassPart");
        hashMap.put(a.m(bVar4), a.a.MULTIFILE_CLASS_PART);
        b bVar5 = new b("kotlin.jvm.internal.KotlinSyntheticClass");
        hashMap.put(a.m(bVar5), a.a.SYNTHETIC_CLASS);
    }

    public b() {
        super();
        final int i = 0;
        final int i2 = 0;
    }

    private static void d(int i) {
        String obj3;
        Object[] arr = new Object[3];
        int i3 = 0;
        final int i4 = 1;
        if (i != i4) {
            arr[i3] = "classId";
        } else {
            arr[i3] = "source";
        }
        arr[i4] = "kotlin/reflect/jvm/internal/impl/load/kotlin/header/ReadKotlinClassHeaderAnnotationVisitor";
        arr[2] = "visitAnnotation";
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", arr));
        throw illegalArgumentException;
    }

    static kotlin.i0.z.e.m0.d.b.a0.a.a e(kotlin.i0.z.e.m0.d.b.a0.b b, kotlin.i0.z.e.m0.d.b.a0.a.a a$a2) {
        b.i = a2;
        return a2;
    }

    static int[] f(kotlin.i0.z.e.m0.d.b.a0.b b, int[] i2Arr2) {
        b.a = i2Arr2;
        return i2Arr2;
    }

    static c g(kotlin.i0.z.e.m0.d.b.a0.b b) {
        return b.b;
    }

    static c h(kotlin.i0.z.e.m0.d.b.a0.b b, c c2) {
        b.b = c2;
        return c2;
    }

    static String i(kotlin.i0.z.e.m0.d.b.a0.b b, String string2) {
        b.c = string2;
        return string2;
    }

    static int j(kotlin.i0.z.e.m0.d.b.a0.b b, int i2) {
        b.d = i2;
        return i2;
    }

    static String k(kotlin.i0.z.e.m0.d.b.a0.b b, String string2) {
        b.e = string2;
        return string2;
    }

    static String[] l(kotlin.i0.z.e.m0.d.b.a0.b b, String[] string2Arr2) {
        b.f = string2Arr2;
        return string2Arr2;
    }

    static String[] m(kotlin.i0.z.e.m0.d.b.a0.b b, String[] string2Arr2) {
        b.g = string2Arr2;
        return string2Arr2;
    }

    private boolean o() {
        int i;
        kotlin.i0.z.e.m0.d.b.a0.a.a mULTIFILE_CLASS_PART;
        kotlin.i0.z.e.m0.d.b.a0.a.a aVar = this.i;
        if (aVar != a.a.CLASS && aVar != a.a.FILE_FACADE) {
            if (aVar != a.a.FILE_FACADE) {
                if (aVar == a.a.MULTIFILE_CLASS_PART) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // kotlin.i0.z.e.m0.d.b.o$c
    public void a() {
    }

    @Override // kotlin.i0.z.e.m0.d.b.o$c
    public o.a b(a a, u0 u02) {
        final int i = 0;
        if (a == null) {
        } else {
            if (u02 == null) {
            } else {
                if (a.b().equals(y.a)) {
                    b.c obj3 = new b.c(this, i);
                    return obj3;
                }
                if (b.j) {
                    return i;
                }
                if (this.i != null) {
                    return i;
                }
                obj3 = b.k.get(a);
                if ((a.a)obj3 != null) {
                    this.i = (a.a)obj3;
                    obj3 = new b.d(this, i);
                    return obj3;
                }
                return i;
            }
            b.d(1);
            throw i;
        }
        b.d(0);
        throw i;
    }

    @Override // kotlin.i0.z.e.m0.d.b.o$c
    public kotlin.i0.z.e.m0.d.b.a0.a n() {
        String[] strArr;
        kotlin.i0.z.e.m0.d.b.a0.a.a aVar;
        c cVar;
        int i;
        int i2 = 0;
        if (this.i != null) {
            if (this.a == null) {
            } else {
                i = i3 &= 8 != 0 ? 1 : 0;
                f fVar = new f(this.a, i);
                if (!fVar.h()) {
                    this.h = this.f;
                    this.f = i2;
                } else {
                    if (o() && this.f == null) {
                        if (this.f == null) {
                            return i2;
                        }
                    }
                }
                if (this.b != null) {
                } else {
                    cVar = c.f;
                }
            }
            super(this.i, fVar, cVar, this.f, this.h, this.g, this.c, this.d, this.e);
            return aVar2;
        }
        return i2;
    }
}
