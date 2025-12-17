package kotlin.d0.d;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d;
import kotlin.d0.a;
import kotlin.d0.b;
import kotlin.i0.d;
import kotlin.k0.l;
import kotlin.o;
import kotlin.u;
import kotlin.y.j0;
import kotlin.y.p;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u0000 O2\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010F\u001a\u00020\u00122\u0008\u0010G\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0008\u0010H\u001a\u00020IH\u0002J\u0008\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020\u00122\u0008\u0010M\u001a\u0004\u0018\u00010\u0002H\u0017J\u0008\u0010N\u001a\u000201H\u0016R\u001a\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR \u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0017\u0010\u0014\u001a\u0004\u0008\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0019\u0010\u0014\u001a\u0004\u0008\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\u0014\u001a\u0004\u0008\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u001d\u0010\u0014\u001a\u0004\u0008\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\u0014\u001a\u0004\u0008\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008!\u0010\u0014\u001a\u0004\u0008 \u0010\u0015R\u001a\u0010\"\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008#\u0010\u0014\u001a\u0004\u0008\"\u0010\u0015R\u001a\u0010$\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008%\u0010\u0014\u001a\u0004\u0008$\u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u001e\u0010(\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030)0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010\u0010R\u001e\u0010+\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008,\u0010\u0010R\u0016\u0010-\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008.\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00082\u00103R(\u00104\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00020\u00010\u00088VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u00085\u0010\u0014\u001a\u0004\u00086\u0010\u000bR\u0016\u00107\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00088\u00103R \u00109\u001a\u0008\u0012\u0004\u0012\u00020:0\u00088VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008;\u0010\u0014\u001a\u0004\u0008<\u0010\u000bR \u0010=\u001a\u0008\u0012\u0004\u0012\u00020>0\u00088VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008?\u0010\u0014\u001a\u0004\u0008@\u0010\u000bR\u001c\u0010A\u001a\u0004\u0018\u00010B8VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008C\u0010\u0014\u001a\u0004\u0008D\u0010E¨\u0006P", d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class e implements d<Object>, kotlin.d0.d.d {

    private static final Map<Class<? extends d<?>>, Integer> b;
    private static final HashMap<String, String> c;
    private static final HashMap<String, String> v;
    private static final HashMap<String, String> w;
    private static final Map<String, String> x;
    public static final kotlin.d0.d.e.a y;
    private final Class<?> a;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0008\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000c\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(kotlin.d0.d.g g) {
            super();
        }

        public final String a(Class<?> class) {
            boolean anonymousClass;
            int canonicalName;
            Object obj3;
            n.f(class, "jClass");
            canonicalName = 0;
            if (class.isAnonymousClass()) {
            } else {
                if (class.isLocalClass()) {
                } else {
                    if (class.isArray()) {
                        obj3 = class.getComponentType();
                        n.e(obj3, "componentType");
                        obj3 = e.j().get(obj3.getName());
                        if (obj3.isPrimitive() && (String)obj3 != null) {
                            obj3 = e.j().get(obj3.getName());
                            if ((String)(String)obj3 != null) {
                                anonymousClass = new StringBuilder();
                                anonymousClass.append((String)(String)obj3);
                                anonymousClass.append("Array");
                                canonicalName = obj3;
                            }
                        }
                        if (canonicalName != 0) {
                        } else {
                            canonicalName = "kotlin.Array";
                        }
                    } else {
                        if ((String)e.j().get(class.getName()) != null) {
                        } else {
                            canonicalName = class.getCanonicalName();
                        }
                    }
                }
            }
            return canonicalName;
        }

        public final String b(Class<?> class) {
            boolean anonymousClass;
            int enclosingMethod;
            int string;
            String str;
            int i;
            String str2;
            StringBuilder stringBuilder;
            Object obj8;
            n.f(class, "jClass");
            string = 0;
            if (class.isAnonymousClass()) {
                enclosingMethod = string;
            } else {
            }
            return enclosingMethod;
        }

        public final boolean c(Object object, Class<?> class2) {
            Object obj4;
            n.f(class2, "jClass");
            Map map = e.r();
            Objects.requireNonNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K, V>");
            Object obj = map.get(class2);
            if ((Integer)obj != null) {
                return g0.k(object, (Integer)obj.intValue());
            }
            if (class2.isPrimitive()) {
                obj4 = a.c(a.e(class2));
            }
            return obj4.isInstance(object);
        }
    }
    static {
        String str2;
        boolean string;
        int i;
        HashMap hashMap;
        int next;
        String str;
        Class<kotlin.d0.c.o> obj;
        String stringBuilder2;
        String stringBuilder;
        String str3;
        final int i3 = 0;
        e.a aVar = new e.a(i3);
        e.y = aVar;
        Class[] arr = new Class[23];
        int i25 = 2;
        arr[i25] = p.class;
        arr[3] = q.class;
        arr[4] = r.class;
        arr[5] = s.class;
        arr[6] = t.class;
        arr[7] = u.class;
        arr[8] = v.class;
        arr[9] = w.class;
        int i26 = 10;
        arr[i26] = b.class;
        arr[11] = c.class;
        arr[12] = d.class;
        arr[13] = e.class;
        arr[14] = f.class;
        arr[15] = g.class;
        arr[16] = h.class;
        arr[17] = i.class;
        arr[18] = j.class;
        arr[19] = k.class;
        arr[20] = m.class;
        arr[21] = n.class;
        arr[22] = o.class;
        List list = p.j(arr);
        ArrayList arrayList = new ArrayList(p.r(list, i26));
        Iterator iterator = list.iterator();
        for (Object next : iterator) {
            arrayList.add(u.a((Class)next, Integer.valueOf(i)));
            i = obj;
        }
        e.b = j0.s(arrayList);
        HashMap hashMap2 = new HashMap();
        String str13 = "kotlin.Boolean";
        hashMap2.put("boolean", str13);
        String str21 = "kotlin.Char";
        hashMap2.put("char", str21);
        String str42 = "kotlin.Byte";
        hashMap2.put("byte", str42);
        stringBuilder = "kotlin.Short";
        hashMap2.put("short", stringBuilder);
        str3 = "kotlin.Int";
        hashMap2.put("int", str3);
        final String str62 = "kotlin.Float";
        hashMap2.put("float", str62);
        final String str63 = "kotlin.Long";
        hashMap2.put("long", str63);
        final String str64 = "kotlin.Double";
        hashMap2.put("double", str64);
        e.c = hashMap2;
        HashMap hashMap3 = new HashMap();
        hashMap3.put("java.lang.Boolean", str13);
        hashMap3.put("java.lang.Character", str21);
        hashMap3.put("java.lang.Byte", str42);
        hashMap3.put("java.lang.Short", stringBuilder);
        hashMap3.put("java.lang.Integer", str3);
        hashMap3.put("java.lang.Float", str62);
        hashMap3.put("java.lang.Long", str63);
        hashMap3.put("java.lang.Double", str64);
        e.v = hashMap3;
        hashMap = new HashMap();
        hashMap.put("java.lang.Object", "kotlin.Any");
        hashMap.put("java.lang.String", "kotlin.String");
        hashMap.put("java.lang.CharSequence", "kotlin.CharSequence");
        hashMap.put("java.lang.Throwable", "kotlin.Throwable");
        hashMap.put("java.lang.Cloneable", "kotlin.Cloneable");
        hashMap.put("java.lang.Number", "kotlin.Number");
        hashMap.put("java.lang.Comparable", "kotlin.Comparable");
        hashMap.put("java.lang.Enum", "kotlin.Enum");
        hashMap.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        hashMap.put("java.lang.Iterable", "kotlin.collections.Iterable");
        hashMap.put("java.util.Iterator", "kotlin.collections.Iterator");
        hashMap.put("java.util.Collection", "kotlin.collections.Collection");
        hashMap.put("java.util.List", "kotlin.collections.List");
        hashMap.put("java.util.Set", "kotlin.collections.Set");
        hashMap.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        hashMap.put("java.util.Map", "kotlin.collections.Map");
        hashMap.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        hashMap.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        hashMap.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        hashMap.putAll(hashMap2);
        hashMap.putAll(hashMap3);
        Collection values = hashMap2.values();
        n.e(values, "primitiveFqNames.values");
        Iterator iterator2 = values.iterator();
        int i27 = 46;
        for (String next2 : iterator2) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("kotlin.jvm.internal.");
            n.e(next2, "kotlinName");
            stringBuilder3.append(l.S0(next2, i27, i3, i25, i3));
            stringBuilder3.append("CompanionObject");
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(next2);
            stringBuilder2.append(".Companion");
            o oVar = u.a(stringBuilder3.toString(), stringBuilder2.toString());
            hashMap.put(oVar.c(), oVar.d());
            i27 = 46;
        }
        Iterator iterator3 = e.b.entrySet().iterator();
        for (Map.Entry next4 : iterator3) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("kotlin.Function");
            stringBuilder.append((Number)next4.getValue().intValue());
            hashMap.put((Class)next4.getKey().getName(), stringBuilder.toString());
        }
        e.w = hashMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap(j0.d(hashMap.size()));
        Iterator iterator4 = hashMap.entrySet().iterator();
        for (Map.Entry next6 : iterator4) {
            linkedHashMap.put(next6.getKey(), l.S0((String)next6.getValue(), i27, i3, i25, i3));
        }
        e.x = linkedHashMap;
    }

    public e(Class<?> class) {
        n.f(class, "jClass");
        super();
        this.a = class;
    }

    public static final HashMap j() {
        return e.w;
    }

    public static final Map r() {
        return e.b;
    }

    public static final Map s() {
        return e.x;
    }

    private final Void t() {
        b bVar = new b();
        throw bVar;
    }

    public Class<?> d() {
        return this.a;
    }

    @Override // kotlin.i0.d
    public boolean equals(Object object) {
        boolean z;
        Object obj2;
        if (object instanceof e && n.b(a.c(this), a.c((d)object))) {
            obj2 = n.b(a.c(this), a.c((d)object)) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    public List<Annotation> getAnnotations() {
        t();
        throw 0;
    }

    @Override // kotlin.i0.d
    public int hashCode() {
        return a.c(this).hashCode();
    }

    @Override // kotlin.i0.d
    public boolean isAbstract() {
        t();
        throw 0;
    }

    @Override // kotlin.i0.d
    public boolean k() {
        t();
        throw 0;
    }

    @Override // kotlin.i0.d
    public boolean m() {
        t();
        throw 0;
    }

    @Override // kotlin.i0.d
    public String n() {
        return e.y.a(d());
    }

    @Override // kotlin.i0.d
    public String o() {
        return e.y.b(d());
    }

    @Override // kotlin.i0.d
    public Object p() {
        t();
        throw 0;
    }

    @Override // kotlin.i0.d
    public boolean q(Object object) {
        return e.y.c(object, d());
    }

    @Override // kotlin.i0.d
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d().toString());
        stringBuilder.append(" (Kotlin reflection is not available)");
        return stringBuilder.toString();
    }
}
