package kotlin.i0;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.a;
import kotlin.d0.c.l;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.d0.d.o;
import kotlin.j0.i;
import kotlin.k0.l;
import kotlin.y.p;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0008\u001a\u0004\u0008\u0005\u0010\t¨\u0006\u0015", d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
public final class x {

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0010\u0000\u001a\u0012\u0012\u0002\u0008\u0003 \u0002*\u0008\u0012\u0002\u0008\u0003\u0018\u00010\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0001¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "Ljava/lang/Class;", "kotlin.jvm.PlatformType", "p1", "invoke"}, k = 3, mv = {1, 5, 1})
    static final class a extends k implements l<Class<? extends Object>, Class<?>> {

        public static final kotlin.i0.x.a a;
        static {
            x.a aVar = new x.a();
            x.a.a = aVar;
        }

        a() {
            super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object) {
            return l((Class)object);
        }

        public final Class<?> l(Class<?> class) {
            n.f(class, "p1");
            return class.getComponentType();
        }
    }
    public static final Type a(kotlin.i0.o o, boolean z2) {
        return x.c(o, z2);
    }

    public static final String b(Type type) {
        return x.h(type);
    }

    private static final Type c(kotlin.i0.o o, boolean z2) {
        kotlin.i0.o oVar;
        int primitive;
        int i;
        String str;
        int obj3;
        Class obj4;
        kotlin.i0.e eVar = o.c();
        if (eVar instanceof p) {
            obj3 = new v((p)eVar);
            return obj3;
        }
        if (!eVar instanceof d) {
        } else {
            if (z2) {
                obj4 = a.c((d)eVar);
            } else {
                obj4 = a.b(eVar);
            }
            List list = o.b();
            if (list.isEmpty()) {
                return obj4;
            }
            Class componentType = obj4.getComponentType();
            n.e(componentType, "jClass.componentType");
            if (obj4.isArray() && componentType.isPrimitive()) {
                componentType = obj4.getComponentType();
                n.e(componentType, "jClass.componentType");
                if (componentType.isPrimitive()) {
                    return obj4;
                }
                Object obj = p.B0(list);
                if ((q)obj == null) {
                } else {
                    obj3 = (q)obj.a();
                    oVar = obj.b();
                    if (obj3 == null) {
                    } else {
                        obj3 = w.a[obj3.ordinal()];
                        primitive = 1;
                        if (obj3 != primitive && obj3 != 2) {
                            if (obj3 != 2) {
                                if (obj3 != 3) {
                                } else {
                                }
                                obj3 = new NoWhenBranchMatchedException();
                                throw obj3;
                            }
                            n.d(oVar);
                            obj3 = x.d(oVar, false, primitive, 0);
                            if (obj3 instanceof Class) {
                            } else {
                                obj4 = new a(obj3);
                            }
                        }
                    }
                    return obj4;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("kotlin.Array must have exactly one type argument: ");
                stringBuilder.append(o);
                obj4 = new IllegalArgumentException(stringBuilder.toString());
                throw obj4;
            }
            return x.e(obj4, list);
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Unsupported type classifier: ");
        stringBuilder2.append(o);
        obj4 = new UnsupportedOperationException(stringBuilder2.toString());
        throw obj4;
    }

    static Type d(kotlin.i0.o o, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return x.c(o, obj1);
    }

    private static final Type e(Class<?> class, List<kotlin.i0.q> list2) {
        int i2;
        int i;
        int i3;
        Class declaringClass = class.getDeclaringClass();
        int i5 = 10;
        if (declaringClass != null && Modifier.isStatic(class.getModifiers())) {
            if (Modifier.isStatic(class.getModifiers())) {
                ArrayList arrayList3 = new ArrayList(p.r(list2, i5));
                Iterator obj5 = list2.iterator();
                for (q next6 : obj5) {
                    arrayList3.add(x.g(next6));
                }
                obj5 = new u(class, declaringClass, arrayList3);
                return obj5;
            }
            int length = typeParameters.length;
            obj5 = list2.subList(0, length);
            ArrayList arrayList2 = new ArrayList(p.r(obj5, i5));
            obj5 = obj5.iterator();
            for (q next4 : obj5) {
                arrayList2.add(x.g(next4));
            }
            obj5 = new u(class, x.e(declaringClass, list2.subList(length, list2.size())), arrayList2);
            return obj5;
        }
        ArrayList arrayList = new ArrayList(p.r(list2, i5));
        obj5 = list2.iterator();
        for (q next2 : obj5) {
            arrayList.add(x.g(next2));
        }
        obj5 = new u(class, 0, arrayList);
        return obj5;
    }

    public static final Type f(kotlin.i0.o o) {
        boolean z;
        n.f(o, "$this$javaType");
        z = (o)o.a();
        if (o instanceof o && z != null) {
            z = (o)o.a();
            if (z != null) {
                return z;
            }
        }
        return x.d(o, false, 1, 0);
    }

    private static final Type g(kotlin.i0.q q) {
        Type yVar;
        int i2;
        int i;
        Object obj4;
        kotlin.i0.s sVar = q.d();
        if (sVar != null) {
            obj4 = q.c();
            n.d(obj4);
            int i3 = w.b[sVar.ordinal()];
            int i4 = 1;
            if (i3 != i4) {
                i = 0;
                if (i3 != 2) {
                    if (i3 != 3) {
                    } else {
                        yVar = new y(x.c(obj4, i4), i);
                    }
                    obj4 = new NoWhenBranchMatchedException();
                    throw obj4;
                }
                yVar = new y(i, x.c(obj4, i4));
            } else {
                yVar = x.c(obj4, i4);
            }
            return yVar;
        }
        return y.v.a();
    }

    private static final String h(Type type) {
        Object stringBuilder;
        boolean str;
        boolean array;
        String obj2;
        if (type instanceof Class) {
            stringBuilder = type;
            if ((Class)stringBuilder.isArray()) {
                obj2 = i.f(type, x.a.a);
                stringBuilder = new StringBuilder();
                stringBuilder.append((Class)i.t(obj2).getName());
                stringBuilder.append(l.C("[]", i.j(obj2)));
                obj2 = stringBuilder.toString();
            } else {
                obj2 = stringBuilder.getName();
            }
            n.e(obj2, "if (type.isArray) {\n    …\n        } else type.name");
        } else {
            obj2 = type.toString();
        }
        return obj2;
    }
}
