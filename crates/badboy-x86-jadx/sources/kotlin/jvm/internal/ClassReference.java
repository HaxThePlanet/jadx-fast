package kotlin.jvm.internal;

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
import java.util.Set;
import kotlin.Function;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KCallable;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVisibility;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0016\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000e\n\u0002\u0008\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0018\u0000 O2\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001OB\u0011\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010F\u001a\u00020\u00122\u0008\u0010G\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0008\u0010H\u001a\u00020IH\u0002J\u0008\u0010J\u001a\u00020KH\u0016J\u0012\u0010L\u001a\u00020\u00122\u0008\u0010M\u001a\u0004\u0018\u00010\u0002H\u0017J\u0008\u0010N\u001a\u000201H\u0016R\u001a\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\n\u0010\u000bR \u0010\u000c\u001a\u000e\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00020\u000e0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0013\u0010\u0014\u001a\u0004\u0008\u0011\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0017\u0010\u0014\u001a\u0004\u0008\u0016\u0010\u0015R\u001a\u0010\u0018\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u0019\u0010\u0014\u001a\u0004\u0008\u0018\u0010\u0015R\u001a\u0010\u001a\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u001b\u0010\u0014\u001a\u0004\u0008\u001a\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u001d\u0010\u0014\u001a\u0004\u0008\u001c\u0010\u0015R\u001a\u0010\u001e\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008\u001f\u0010\u0014\u001a\u0004\u0008\u001e\u0010\u0015R\u001a\u0010 \u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008!\u0010\u0014\u001a\u0004\u0008 \u0010\u0015R\u001a\u0010\"\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008#\u0010\u0014\u001a\u0004\u0008\"\u0010\u0015R\u001a\u0010$\u001a\u00020\u00128VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008%\u0010\u0014\u001a\u0004\u0008$\u0010\u0015R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008&\u0010'R\u001e\u0010(\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030)0\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008*\u0010\u0010R\u001e\u0010+\u001a\u000c\u0012\u0008\u0012\u0006\u0012\u0002\u0008\u00030\u00010\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008,\u0010\u0010R\u0016\u0010-\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008.\u0010/R\u0016\u00100\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00082\u00103R(\u00104\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0008\u0001\u0012\u00020\u00020\u00010\u00088VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u00085\u0010\u0014\u001a\u0004\u00086\u0010\u000bR\u0016\u00107\u001a\u0004\u0018\u0001018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u00088\u00103R \u00109\u001a\u0008\u0012\u0004\u0012\u00020:0\u00088VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008;\u0010\u0014\u001a\u0004\u0008<\u0010\u000bR \u0010=\u001a\u0008\u0012\u0004\u0012\u00020>0\u00088VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008?\u0010\u0014\u001a\u0004\u0008@\u0010\u000bR\u001c\u0010A\u001a\u0004\u0018\u00010B8VX\u0097\u0004¢\u0006\u000c\u0012\u0004\u0008C\u0010\u0014\u001a\u0004\u0008D\u0010E¨\u0006P", d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", "", "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "constructors", "", "Lkotlin/reflect/KFunction;", "getConstructors", "()Ljava/util/Collection;", "isAbstract", "", "isAbstract$annotations", "()V", "()Z", "isCompanion", "isCompanion$annotations", "isData", "isData$annotations", "isFinal", "isFinal$annotations", "isFun", "isFun$annotations", "isInner", "isInner$annotations", "isOpen", "isOpen$annotations", "isSealed", "isSealed$annotations", "isValue", "isValue$annotations", "getJClass", "()Ljava/lang/Class;", "members", "Lkotlin/reflect/KCallable;", "getMembers", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "qualifiedName", "", "getQualifiedName", "()Ljava/lang/String;", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "simpleName", "getSimpleName", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "getTypeParameters", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "equals", "other", "error", "", "hashCode", "", "isInstance", "value", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ClassReference implements KClass<Object>, kotlin.jvm.internal.ClassBasedDeclarationContainer {

    public static final kotlin.jvm.internal.ClassReference.Companion Companion;
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    private static final HashMap<String, String> classFqNames;
    private static final HashMap<String, String> primitiveFqNames;
    private static final HashMap<String, String> primitiveWrapperFqNames;
    private static final Map<String, String> simpleNames;
    private final Class<?> jClass;

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u0005J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u0005J\u001c\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\u0008\u00030\u0005R&\u0010\u0003\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0008\u0001\u0012\u0006\u0012\u0002\u0008\u00030\u00060\u0005\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0008\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000c\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tj\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", "", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lkotlin/Function;", "", "classFqNames", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "primitiveFqNames", "primitiveWrapperFqNames", "simpleNames", "getClassQualifiedName", "jClass", "getClassSimpleName", "isInstance", "", "value", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final String getClassQualifiedName(Class<?> jClass) {
            boolean anonymousClass;
            int canonicalName;
            Object primitive;
            String name;
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            canonicalName = 0;
            if (jClass.isAnonymousClass()) {
            } else {
                if (jClass.isLocalClass()) {
                } else {
                    if (jClass.isArray()) {
                        anonymousClass = jClass.getComponentType();
                        if (anonymousClass.isPrimitive()) {
                            primitive = ClassReference.access$getClassFqNames$cp().get(anonymousClass.getName());
                            if ((String)primitive != null) {
                                StringBuilder stringBuilder = new StringBuilder();
                                canonicalName = stringBuilder.append((String)primitive).append("Array").toString();
                            }
                        } else {
                        }
                        if (canonicalName == 0) {
                            canonicalName = "kotlin.Array";
                        }
                    } else {
                        if ((String)ClassReference.access$getClassFqNames$cp().get(jClass.getName()) == null) {
                            canonicalName = jClass.getCanonicalName();
                        }
                    }
                }
            }
            return canonicalName;
        }

        public final String getClassSimpleName(Class<?> jClass) {
            boolean anonymousClass;
            int substringAfter$default;
            Object method;
            int str;
            String string2;
            int i;
            String string;
            String name;
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            substringAfter$default = 0;
            if (jClass.isAnonymousClass()) {
            } else {
                if (jClass.isLocalClass()) {
                    anonymousClass = jClass.getSimpleName();
                    method = jClass.getEnclosingMethod();
                    str = 2;
                    string2 = 36;
                    if (method != null) {
                        i = 0;
                        Intrinsics.checkNotNull(anonymousClass);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        method = StringsKt.substringAfter$default(anonymousClass, stringBuilder2.append(method.getName()).append(string2).toString(), substringAfter$default, str, substringAfter$default);
                        if (method == null) {
                            method = jClass.getEnclosingConstructor();
                            if (method != null) {
                                i = 0;
                                Intrinsics.checkNotNull(anonymousClass);
                                StringBuilder stringBuilder3 = new StringBuilder();
                                substringAfter$default = StringsKt.substringAfter$default(anonymousClass, stringBuilder3.append(method.getName()).append(string2).toString(), substringAfter$default, str, substringAfter$default);
                            } else {
                                Intrinsics.checkNotNull(anonymousClass);
                                substringAfter$default = StringsKt.substringAfter$default(anonymousClass, string2, substringAfter$default, str, substringAfter$default);
                            }
                        } else {
                            substringAfter$default = method;
                        }
                    } else {
                    }
                } else {
                    if (jClass.isArray()) {
                        anonymousClass = jClass.getComponentType();
                        str = "Array";
                        if (anonymousClass.isPrimitive()) {
                            method = ClassReference.access$getSimpleNames$cp().get(anonymousClass.getName());
                            if ((String)method != null) {
                                StringBuilder stringBuilder = new StringBuilder();
                                substringAfter$default = stringBuilder.append((String)method).append(str).toString();
                            }
                        } else {
                        }
                        if (substringAfter$default == 0) {
                            substringAfter$default = str;
                        }
                    } else {
                        if ((String)ClassReference.access$getSimpleNames$cp().get(jClass.getName()) == null) {
                            substringAfter$default = jClass.getSimpleName();
                        }
                    }
                }
            }
            return substringAfter$default;
        }

        public final boolean isInstance(Object value, Class<?> jClass) {
            Object javaObjectType;
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            Map map = ClassReference.access$getFUNCTION_CLASSES$cp();
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Object obj = map.get(jClass);
            if ((Integer)obj != null) {
                int i = 0;
                return TypeIntrinsics.isFunctionOfArity(value, (Number)(Integer)obj.intValue());
            }
            if (jClass.isPrimitive()) {
                javaObjectType = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(jClass));
            } else {
                javaObjectType = jClass;
            }
            return javaObjectType.isInstance(value);
        }
    }
    static {
        int intValue;
        int i2;
        Iterator iterator;
        String next;
        boolean next3;
        Object next2;
        String second;
        int i;
        String string;
        Object obj;
        String first;
        int i3;
        String it$iv$iv;
        Integer valueOf;
        String fqName;
        String str;
        final int i5 = 0;
        ClassReference.Companion companion = new ClassReference.Companion(i5);
        ClassReference.Companion = companion;
        Class[] arr = new Class[23];
        int i12 = 2;
        arr[i12] = Function2.class;
        arr[3] = Function3.class;
        arr[4] = Function4.class;
        arr[5] = Function5.class;
        arr[6] = Function6.class;
        arr[7] = Function7.class;
        arr[8] = Function8.class;
        arr[9] = Function9.class;
        int i18 = 10;
        arr[i18] = Function10.class;
        arr[11] = Function11.class;
        arr[12] = Function12.class;
        arr[13] = Function13.class;
        arr[14] = Function14.class;
        arr[15] = Function15.class;
        arr[16] = Function16.class;
        arr[17] = Function17.class;
        arr[18] = Function18.class;
        arr[19] = Function19.class;
        arr[20] = Function20.class;
        arr[21] = Function21.class;
        arr[22] = Function22.class;
        List listOf = CollectionsKt.listOf(arr);
        int i10 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)listOf, i18));
        ArrayList list = arrayList;
        int i34 = 0;
        i2 = 0;
        Iterator iterator3 = listOf.iterator();
        while (iterator3.hasNext()) {
            if (i2 < 0) {
            }
            i3 = 0;
            (Collection)list.add(TuplesKt.to((Class)iterator3.next(), Integer.valueOf(i2)));
            i2 = i;
            CollectionsKt.throwIndexOverflow();
        }
        ClassReference.FUNCTION_CLASSES = MapsKt.toMap((Iterable)(List)list);
        HashMap hashMap = new HashMap();
        HashMap map2 = hashMap;
        int i19 = 0;
        String str37 = "kotlin.Boolean";
        map2.put("boolean", str37);
        String str58 = "kotlin.Char";
        map2.put("char", str58);
        next = "kotlin.Byte";
        map2.put("byte", next);
        second = "kotlin.Short";
        map2.put("short", second);
        string = "kotlin.Int";
        map2.put("int", string);
        first = "kotlin.Float";
        map2.put("float", first);
        it$iv$iv = "kotlin.Long";
        map2.put("long", it$iv$iv);
        fqName = "kotlin.Double";
        map2.put("double", fqName);
        ClassReference.primitiveFqNames = hashMap;
        HashMap hashMap2 = new HashMap();
        HashMap map3 = hashMap2;
        int i20 = 0;
        map3.put("java.lang.Boolean", str37);
        map3.put("java.lang.Character", str58);
        map3.put("java.lang.Byte", next);
        map3.put("java.lang.Short", second);
        map3.put("java.lang.Integer", string);
        map3.put("java.lang.Float", first);
        map3.put("java.lang.Long", it$iv$iv);
        map3.put("java.lang.Double", fqName);
        ClassReference.primitiveWrapperFqNames = hashMap2;
        HashMap hashMap3 = new HashMap();
        HashMap map4 = hashMap3;
        int i21 = 0;
        map4.put("java.lang.Object", "kotlin.Any");
        map4.put("java.lang.String", "kotlin.String");
        map4.put("java.lang.CharSequence", "kotlin.CharSequence");
        map4.put("java.lang.Throwable", "kotlin.Throwable");
        map4.put("java.lang.Cloneable", "kotlin.Cloneable");
        map4.put("java.lang.Number", "kotlin.Number");
        map4.put("java.lang.Comparable", "kotlin.Comparable");
        map4.put("java.lang.Enum", "kotlin.Enum");
        map4.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map4.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map4.put("java.util.Iterator", "kotlin.collections.Iterator");
        map4.put("java.util.Collection", "kotlin.collections.Collection");
        map4.put("java.util.List", "kotlin.collections.List");
        map4.put("java.util.Set", "kotlin.collections.Set");
        map4.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map4.put("java.util.Map", "kotlin.collections.Map");
        map4.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map4.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map4.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map4.putAll((Map)ClassReference.primitiveFqNames);
        map4.putAll((Map)ClassReference.primitiveWrapperFqNames);
        Collection values = ClassReference.primitiveFqNames.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        intValue = 0;
        iterator = (Iterable)values.iterator();
        int i38 = 46;
        for (Object next : iterator) {
            String str59 = next;
            it$iv$iv = null;
            StringBuilder stringBuilder2 = new StringBuilder();
            Intrinsics.checkNotNull((String)str59);
            StringBuilder stringBuilder3 = new StringBuilder();
            Pair pair = TuplesKt.to(stringBuilder2.append("kotlin.jvm.internal.").append(StringsKt.substringAfterLast$default(str59, i38, i5, i12, i5)).append("CompanionObject").toString(), stringBuilder3.append(str59).append(".Companion").toString());
            (Map)map4.put(pair.getFirst(), pair.getSecond());
            i38 = 46;
        }
        HashMap $this$associateTo$iv = map4;
        Iterator iterator2 = ClassReference.FUNCTION_CLASSES.entrySet().iterator();
        for (Map.Entry next5 : iterator2) {
            StringBuilder stringBuilder = new StringBuilder();
            map4.put((Class)next5.getKey().getName(), stringBuilder.append("kotlin.Function").append((Number)next5.getValue().intValue()).toString());
        }
        ClassReference.classFqNames = hashMap3;
        HashMap classFqNames = ClassReference.classFqNames;
        int i11 = 0;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity((Map)classFqNames.size()));
        int i35 = 0;
        int i37 = 0;
        Iterator iterator4 = (Iterable)classFqNames.entrySet().iterator();
        for (Object first : iterator4) {
            int i39 = 0;
            str = 0;
            (Map)linkedHashMap.put((Map.Entry)first.getKey(), StringsKt.substringAfterLast$default((String)(Map.Entry)first.getValue(), i38, i5, i12, i5));
        }
        ClassReference.simpleNames = linkedHashMap;
    }

    public ClassReference(Class<?> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        super();
        this.jClass = jClass;
    }

    public static final HashMap access$getClassFqNames$cp() {
        return ClassReference.classFqNames;
    }

    public static final Map access$getFUNCTION_CLASSES$cp() {
        return ClassReference.FUNCTION_CLASSES;
    }

    public static final Map access$getSimpleNames$cp() {
        return ClassReference.simpleNames;
    }

    private final Void error() {
        KotlinReflectionNotSupportedError kotlinReflectionNotSupportedError = new KotlinReflectionNotSupportedError();
        throw kotlinReflectionNotSupportedError;
    }

    public static void getSealedSubclasses$annotations() {
    }

    public static void getSupertypes$annotations() {
    }

    public static void getTypeParameters$annotations() {
    }

    public static void getVisibility$annotations() {
    }

    public static void isAbstract$annotations() {
    }

    public static void isCompanion$annotations() {
    }

    public static void isData$annotations() {
    }

    public static void isFinal$annotations() {
    }

    public static void isFun$annotations() {
    }

    public static void isInner$annotations() {
    }

    public static void isOpen$annotations() {
    }

    public static void isSealed$annotations() {
    }

    public static void isValue$annotations() {
    }

    @Override // kotlin.reflect.KClass
    public boolean equals(Object other) {
        boolean equal;
        int i;
        Class javaObjectType;
        if (other instanceof ClassReference != null && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType((KClass)this), JvmClassMappingKt.getJavaObjectType((KClass)other))) {
            i = Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType((KClass)this), JvmClassMappingKt.getJavaObjectType((KClass)other)) ? 1 : 0;
        } else {
        }
        return i;
    }

    public List<Annotation> getAnnotations() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public Collection<KFunction<Object>> getConstructors() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public Class<?> getJClass() {
        return this.jClass;
    }

    public Collection<KCallable<?>> getMembers() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public Collection<KClass<?>> getNestedClasses() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public Object getObjectInstance() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public String getQualifiedName() {
        return ClassReference.Companion.getClassQualifiedName(getJClass());
    }

    public List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public String getSimpleName() {
        return ClassReference.Companion.getClassSimpleName(getJClass());
    }

    public List<KType> getSupertypes() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    public List<KTypeParameter> getTypeParameters() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public KVisibility getVisibility() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType((KClass)this).hashCode();
    }

    @Override // kotlin.reflect.KClass
    public boolean isAbstract() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public boolean isCompanion() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public boolean isData() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFinal() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public boolean isFun() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public boolean isInner() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public boolean isInstance(Object value) {
        return ClassReference.Companion.isInstance(value, getJClass());
    }

    @Override // kotlin.reflect.KClass
    public boolean isOpen() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public boolean isSealed() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public boolean isValue() {
        error();
        KotlinNothingValueException kotlinNothingValueException = new KotlinNothingValueException();
        throw kotlinNothingValueException;
    }

    @Override // kotlin.reflect.KClass
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(getJClass().toString()).append(" (Kotlin reflection is not available)").toString();
    }
}
