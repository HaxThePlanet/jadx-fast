package kotlin.reflect;

import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.KTypeBase;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\u001a\"\u0010\n\u001a\u00020\u00012\n\u0010\u000b\u001a\u0006\u0012\u0002\u0008\u00030\u000c2\u000c\u0010\r\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u000eH\u0003\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0016\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0008\u0008\u0002\u0010\u0013\u001a\u00020\u0014H\u0003\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0004\u001a\u0004\u0008\u0005\u0010\u0006\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00078BX\u0083\u0004¢\u0006\u000c\u0012\u0004\u0008\u0003\u0010\u0008\u001a\u0004\u0008\u0005\u0010\t¨\u0006\u0015", d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lkotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", "", "typeToString", "", "type", "computeJavaType", "forceWrapper", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class TypesJVMKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal2;
            int ordinal3;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[KVariance.IN.ordinal()] = 1;
            iArr[KVariance.INVARIANT.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            TypesJVMKt.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    public static final Type access$computeJavaType(kotlin.reflect.KType $receiver, boolean forceWrapper) {
        return TypesJVMKt.computeJavaType($receiver, forceWrapper);
    }

    public static final String access$typeToString(Type type) {
        return TypesJVMKt.typeToString(type);
    }

    private static final Type computeJavaType(kotlin.reflect.KType $this$computeJavaType, boolean forceWrapper) {
        Class javaObjectType;
        int javaType$default;
        int ordinal;
        Object genericArrayTypeImpl;
        int i;
        final kotlin.reflect.KClassifier classifier2 = $this$computeJavaType.getClassifier();
        if (classifier2 instanceof KTypeParameter) {
            TypeVariableImpl typeVariableImpl = new TypeVariableImpl((KTypeParameter)classifier2);
            return (Type)typeVariableImpl;
        }
        if (!classifier2 instanceof KClass) {
        } else {
            kotlin.reflect.KClassifier cls = classifier2;
            if (forceWrapper) {
                javaObjectType = JvmClassMappingKt.getJavaObjectType((KClass)cls);
            } else {
                javaObjectType = JvmClassMappingKt.getJavaClass(cls);
            }
            List arguments = $this$computeJavaType.getArguments();
            if (arguments.isEmpty()) {
                return (Type)javaObjectType;
            }
            if (javaObjectType.isArray() && javaObjectType.getComponentType().isPrimitive()) {
                if (javaObjectType.getComponentType().isPrimitive()) {
                    return (Type)javaObjectType;
                }
                Object singleOrNull = CollectionsKt.singleOrNull(arguments);
                if ((KTypeProjection)singleOrNull == null) {
                } else {
                    kotlin.reflect.KVariance component1 = (KTypeProjection)singleOrNull.component1();
                    kotlin.reflect.KType component2 = singleOrNull.component2();
                    if (component1 == null) {
                        javaType$default = -1;
                    } else {
                        javaType$default = TypesJVMKt.WhenMappings.$EnumSwitchMapping$0[component1.ordinal()];
                    }
                    switch (javaType$default) {
                        case -1:
                            genericArrayTypeImpl = javaObjectType;
                            break;
                        case 0:
                            NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                            throw noWhenBranchMatchedException;
                        default:
                            Intrinsics.checkNotNull(component2);
                            javaType$default = TypesJVMKt.computeJavaType$default(component2, false, 1, 0);
                            genericArrayTypeImpl = javaObjectType;
                            genericArrayTypeImpl = new GenericArrayTypeImpl(javaType$default);
                    }
                    return genericArrayTypeImpl;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IllegalArgumentException elementType = new IllegalArgumentException(stringBuilder2.append("kotlin.Array must have exactly one type argument: ").append($this$computeJavaType).toString());
                throw elementType;
            }
            return TypesJVMKt.createPossiblyInnerType(javaObjectType, arguments);
        }
        StringBuilder stringBuilder = new StringBuilder();
        UnsupportedOperationException jClass = new UnsupportedOperationException(stringBuilder.append("Unsupported type classifier: ").append($this$computeJavaType).toString());
        throw jClass;
    }

    static Type computeJavaType$default(kotlin.reflect.KType kType, boolean z2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = 0;
        }
        return TypesJVMKt.computeJavaType(kType, obj1);
    }

    private static final Type createPossiblyInnerType(Class<?> jClass, List<kotlin.reflect.KTypeProjection> arguments) {
        Object next2;
        Type p0;
        Object next;
        Object p03;
        Type p02;
        int i;
        Class declaringClass = jClass.getDeclaringClass();
        int i2 = 10;
        if (declaringClass == null) {
            Iterable iterable = arguments;
            int i3 = 0;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable, i2));
            ArrayList list3 = arrayList;
            int i7 = 0;
            Iterator iterator = iterable.iterator();
            for (Object next2 : iterator) {
                next = 0;
                (Collection)list3.add(TypesJVMKt.getJavaType((KTypeProjection)next2));
            }
            ParameterizedTypeImpl $this$map$iv = new ParameterizedTypeImpl(jClass, 0, (List)list3);
            return (Type)$this$map$iv;
        }
        if (Modifier.isStatic(jClass.getModifiers())) {
            Iterable iterable2 = arguments;
            int i6 = 0;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)iterable2, i2));
            ArrayList list2 = arrayList2;
            int i9 = 0;
            Iterator iterator2 = iterable2.iterator();
            for (Object next : iterator2) {
                p02 = 0;
                (Collection)list2.add(TypesJVMKt.getJavaType((KTypeProjection)next));
            }
            ParameterizedTypeImpl $this$map$iv2 = new ParameterizedTypeImpl(jClass, (Type)declaringClass, (List)list2);
            return (Type)$this$map$iv2;
        }
        int length = typeParameters.length;
        List subList2 = arguments.subList(0, length);
        int i8 = 0;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)subList2, i2));
        ArrayList list = arrayList3;
        int i10 = 0;
        Iterator iterator3 = subList2.iterator();
        for (Object p03 : iterator3) {
            i = 0;
            (Collection)list.add(TypesJVMKt.getJavaType((KTypeProjection)p03));
        }
        ParameterizedTypeImpl $this$map$iv3 = new ParameterizedTypeImpl(jClass, TypesJVMKt.createPossiblyInnerType(declaringClass, arguments.subList(length, arguments.size())), (List)list);
        return (Type)$this$map$iv3;
    }

    public static final Type getJavaType(kotlin.reflect.KType $this$javaType) {
        boolean javaType;
        Intrinsics.checkNotNullParameter($this$javaType, "<this>");
        javaType = (KTypeBase)$this$javaType.getJavaType();
        if ($this$javaType instanceof KTypeBase && javaType != null) {
            javaType = (KTypeBase)$this$javaType.getJavaType();
            if (javaType != null) {
                int i2 = 0;
                return javaType;
            }
        }
        return TypesJVMKt.computeJavaType$default($this$javaType, false, 1, 0);
    }

    private static final Type getJavaType(kotlin.reflect.KTypeProjection $this$javaType) {
        Type wildcardTypeImpl;
        Type javaType;
        kotlin.reflect.KVariance variance2 = $this$javaType.getVariance();
        if (variance2 == null) {
            return (Type)WildcardTypeImpl.Companion.getSTAR();
        }
        final kotlin.reflect.KType type2 = $this$javaType.getType();
        Intrinsics.checkNotNull(type2);
        int i2 = 0;
        javaType = 1;
        switch (i) {
            case 1:
                wildcardTypeImpl = new WildcardTypeImpl(i2, TypesJVMKt.computeJavaType(type2, javaType));
                break;
            case 2:
                wildcardTypeImpl = TypesJVMKt.computeJavaType(type2, javaType);
                break;
            case 3:
                wildcardTypeImpl = new WildcardTypeImpl(TypesJVMKt.computeJavaType(type2, javaType), i2);
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return wildcardTypeImpl;
    }

    public static void getJavaType$annotations(kotlin.reflect.KType kType) {
    }

    private static void getJavaType$annotations(kotlin.reflect.KTypeProjection kTypeProjection) {
    }

    private static final String typeToString(Type type) {
        String unwrap;
        StringBuilder append;
        String repeat;
        int count;
        if (type instanceof Class) {
            if ((Class)type.isArray()) {
                kotlin.sequences.Sequence sequence = SequencesKt.generateSequence(type, (Function1)TypesJVMKt.typeToString.unwrap.1.INSTANCE);
                StringBuilder stringBuilder = new StringBuilder();
                unwrap = stringBuilder.append((Class)SequencesKt.last(sequence).getName()).append(StringsKt.repeat((CharSequence)"[]", SequencesKt.count(sequence))).toString();
            } else {
                unwrap = (Class)type.getName();
            }
            Intrinsics.checkNotNull(unwrap);
        } else {
            unwrap = type.toString();
        }
        return unwrap;
    }
}
