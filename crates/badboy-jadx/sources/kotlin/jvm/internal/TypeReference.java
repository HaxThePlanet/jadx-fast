package kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.KVariance;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u001b\n\u0002\u0008\u000e\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0000\n\u0002\u0008\u0004\u0008\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B%\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tB/\u0008\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u000b\u001a\u00020\u000c¢\u0006\u0002\u0010\rJ\u0010\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u0008H\u0002J\u0013\u0010$\u001a\u00020\u00082\u0008\u0010%\u001a\u0004\u0018\u00010&H\u0096\u0002J\u0008\u0010'\u001a\u00020\u000cH\u0016J\u0008\u0010(\u001a\u00020\u001eH\u0016J\u000c\u0010\"\u001a\u00020\u001e*\u00020\u0006H\u0002R\u001a\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u000f0\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0011R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\u0014R\u001c\u0010\u000b\u001a\u00020\u000c8\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0007\u001a\u00020\u00088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0019R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u001a\u0010\u0016\u001a\u0004\u0008\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u00020\u001e*\u0006\u0012\u0002\u0008\u00030\u001f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008 \u0010!¨\u0006*", d2 = {"Lkotlin/jvm/internal/TypeReference;", "Lkotlin/reflect/KType;", "classifier", "Lkotlin/reflect/KClassifier;", "arguments", "", "Lkotlin/reflect/KTypeProjection;", "isMarkedNullable", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "platformTypeUpperBound", "flags", "", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "annotations", "", "getAnnotations", "()Ljava/util/List;", "getArguments", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getFlags$kotlin_stdlib$annotations", "()V", "getFlags$kotlin_stdlib", "()I", "()Z", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "arrayClassName", "", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "asString", "convertPrimitiveToWrapper", "equals", "other", "", "hashCode", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TypeReference implements KType {

    public static final kotlin.jvm.internal.TypeReference.Companion Companion = null;
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;
    private final List<KTypeProjection> arguments;
    private final KClassifier classifier;
    private final int flags;
    private final KType platformTypeUpperBound;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lkotlin/jvm/internal/TypeReference$Companion;", "", "()V", "IS_MARKED_NULLABLE", "", "IS_MUTABLE_COLLECTION_TYPE", "IS_NOTHING_TYPE", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal;
            int ordinal2;
            int ordinal3;
            int[] iArr = new int[values.length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            TypeReference.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        TypeReference.Companion companion = new TypeReference.Companion(0);
        TypeReference.Companion = companion;
    }

    public TypeReference(KClassifier classifier, List<KTypeProjection> arguments, KType platformTypeUpperBound, int flags) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        super();
        this.classifier = classifier;
        this.arguments = arguments;
        this.platformTypeUpperBound = platformTypeUpperBound;
        this.flags = flags;
    }

    public TypeReference(KClassifier classifier, List<KTypeProjection> arguments, boolean isMarkedNullable) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        super(classifier, arguments, 0, isMarkedNullable);
    }

    public static final String access$asString(kotlin.jvm.internal.TypeReference $this, KTypeProjection $receiver) {
        return $this.asString($receiver);
    }

    private final String asString(KTypeProjection $this$asString) {
        KType valueOf;
        boolean z;
        String string;
        String str;
        if ($this$asString.getVariance() == null) {
            return "*";
        }
        if (valueOf instanceof TypeReference != null) {
        } else {
            valueOf = 0;
        }
        if (valueOf != null) {
            if (valueOf.asString(true) == null) {
                valueOf = String.valueOf($this$asString.getType());
            }
        } else {
        }
        switch (i2) {
            case 1:
                string = valueOf;
                break;
            case 2:
                StringBuilder stringBuilder = new StringBuilder();
                string = stringBuilder.append("in ").append(valueOf).toString();
                break;
            case 3:
                StringBuilder stringBuilder2 = new StringBuilder();
                string = stringBuilder2.append("out ").append(valueOf).toString();
                break;
            default:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
        }
        return string;
    }

    private final String asString(boolean convertPrimitiveToWrapper) {
        int classifier;
        String arrayClassName;
        boolean primitive;
        boolean str;
        String joinToString$default;
        int javaClass;
        String str5;
        List list;
        String str3;
        String str4;
        String string2;
        String equal;
        String string;
        int i4;
        int i2;
        kotlin.jvm.internal.TypeReference.asString.args.1 str2;
        int i;
        int i3;
        if (classifier instanceof KClass) {
        } else {
            classifier = javaClass;
        }
        if (classifier != 0) {
            javaClass = JvmClassMappingKt.getJavaClass(classifier);
        }
        if (javaClass == 0) {
            arrayClassName = getClassifier().toString();
        } else {
            if (flags &= 4 != 0) {
                arrayClassName = "kotlin.Nothing";
            } else {
                if (javaClass.isArray()) {
                    arrayClassName = getArrayClassName(javaClass);
                } else {
                    if (convertPrimitiveToWrapper && javaClass.isPrimitive()) {
                        if (javaClass.isPrimitive()) {
                            KClassifier classifier3 = getClassifier();
                            Intrinsics.checkNotNull(classifier3, "null cannot be cast to non-null type kotlin.reflect.KClass<*>");
                            arrayClassName = JvmClassMappingKt.getJavaObjectType((KClass)classifier3).getName();
                        } else {
                            arrayClassName = javaClass.getName();
                        }
                    } else {
                    }
                }
            }
        }
        if (getArguments().isEmpty()) {
            joinToString$default = str5;
        } else {
            TypeReference.asString.args.1 anon = new TypeReference.asString.args.1(this);
            joinToString$default = CollectionsKt.joinToString$default((Iterable)getArguments(), (CharSequence)", ", (CharSequence)"<", (CharSequence)">", 0, 0, (Function1)anon, 24, 0);
        }
        if (isMarkedNullable()) {
            str5 = "?";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = stringBuilder.append(arrayClassName).append(joinToString$default).append(str5).toString();
        KType platformTypeUpperBound = this.platformTypeUpperBound;
        if (platformTypeUpperBound instanceof TypeReference != null) {
            string2 = (TypeReference)platformTypeUpperBound.asString(true);
            if (Intrinsics.areEqual(string2, string3)) {
                string = string3;
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                if (Intrinsics.areEqual(string2, stringBuilder2.append(string3).append('?').toString())) {
                    StringBuilder stringBuilder4 = new StringBuilder();
                    string = stringBuilder4.append(string3).append('!').toString();
                } else {
                    StringBuilder stringBuilder3 = new StringBuilder();
                    string = stringBuilder3.append('(').append(string3).append("..").append(string2).append(')').toString();
                }
            }
        } else {
        }
        return string;
    }

    private final String getArrayClassName(Class<?> $this$arrayClassName) {
        String str;
        str = Intrinsics.areEqual($this$arrayClassName, boolean[].class) ? "kotlin.BooleanArray" : equal2 ? "kotlin.CharArray" : equal3 ? "kotlin.ByteArray" : equal4 ? "kotlin.ShortArray" : equal5 ? "kotlin.IntArray" : equal6 ? "kotlin.FloatArray" : equal7 ? "kotlin.LongArray" : equal8 ? "kotlin.DoubleArray" : "kotlin.Array";
        return str;
    }

    public static void getFlags$kotlin_stdlib$annotations() {
    }

    public static void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    @Override // kotlin.reflect.KType
    public boolean equals(Object other) {
        int i;
        boolean equal;
        KClassifier platformTypeUpperBound;
        if (other instanceof TypeReference != null && Intrinsics.areEqual(getClassifier(), (TypeReference)other.getClassifier()) && Intrinsics.areEqual(getArguments(), (TypeReference)other.getArguments()) && Intrinsics.areEqual(this.platformTypeUpperBound, obj3.platformTypeUpperBound) && this.flags == obj4.flags) {
            if (Intrinsics.areEqual(getClassifier(), (TypeReference)other.getClassifier())) {
                if (Intrinsics.areEqual(getArguments(), (TypeReference)other.getArguments())) {
                    if (Intrinsics.areEqual(this.platformTypeUpperBound, obj3.platformTypeUpperBound)) {
                        i = this.flags == obj4.flags ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    public List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return this.classifier;
    }

    @Override // kotlin.reflect.KType
    public final int getFlags$kotlin_stdlib() {
        return this.flags;
    }

    @Override // kotlin.reflect.KType
    public final KType getPlatformTypeUpperBound$kotlin_stdlib() {
        return this.platformTypeUpperBound;
    }

    @Override // kotlin.reflect.KType
    public int hashCode() {
        return i4 += i7;
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        int i;
        if (flags &= i != 0) {
        } else {
            i = 0;
        }
        return i;
    }

    @Override // kotlin.reflect.KType
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(asString(false)).append(" (Kotlin reflection is not available)").toString();
    }
}
