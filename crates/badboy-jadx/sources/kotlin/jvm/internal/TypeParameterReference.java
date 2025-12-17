package kotlin.jvm.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeParameter;
import kotlin.reflect.KVariance;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB'\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0008\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0013\u0010\u0018\u001a\u00020\t2\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0003H\u0096\u0002J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0014\u0010\u001c\u001a\u00020\u001d2\u000c\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000cJ\u0008\u0010\u001e\u001a\u00020\u0005H\u0016R\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0008\u001a\u00020\tX\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010R \u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\r0\u000c8VX\u0096\u0004¢\u0006\u000c\u0012\u0004\u0008\u0012\u0010\u0013\u001a\u0004\u0008\u0014\u0010\u0015R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017¨\u0006 ", d2 = {"Lkotlin/jvm/internal/TypeParameterReference;", "Lkotlin/reflect/KTypeParameter;", "container", "", "name", "", "variance", "Lkotlin/reflect/KVariance;", "isReified", "", "(Ljava/lang/Object;Ljava/lang/String;Lkotlin/reflect/KVariance;Z)V", "bounds", "", "Lkotlin/reflect/KType;", "()Z", "getName", "()Ljava/lang/String;", "upperBounds", "getUpperBounds$annotations", "()V", "getUpperBounds", "()Ljava/util/List;", "getVariance", "()Lkotlin/reflect/KVariance;", "equals", "other", "hashCode", "", "setUpperBounds", "", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TypeParameterReference implements KTypeParameter {

    public static final kotlin.jvm.internal.TypeParameterReference.Companion Companion;
    private volatile List<? extends KType> bounds;
    private final Object container;
    private final boolean isReified;
    private final String name;
    private final KVariance variance;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007", d2 = {"Lkotlin/jvm/internal/TypeParameterReference$Companion;", "", "()V", "toString", "", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(kotlin.jvm.internal.DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final String toString(KTypeParameter typeParameter) {
            String str;
            Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
            StringBuilder stringBuilder = new StringBuilder();
            StringBuilder sb = stringBuilder;
            final int i = 0;
            switch (str) {
                case 1:
                    break;
                case 2:
                    sb.append("in ");
                    break;
                default:
                    sb.append("out ");
            }
            sb.append(typeParameter.getName());
            String string = stringBuilder.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return string;
        }
    }
    static {
        TypeParameterReference.Companion companion = new TypeParameterReference.Companion(0);
        TypeParameterReference.Companion = companion;
    }

    public TypeParameterReference(Object container, String name, KVariance variance, boolean isReified) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(variance, "variance");
        super();
        this.container = container;
        this.name = name;
        this.variance = variance;
        this.isReified = isReified;
    }

    public static void getUpperBounds$annotations() {
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean equals(Object other) {
        int i;
        boolean equal;
        Object container;
        if (other instanceof TypeParameterReference != null && Intrinsics.areEqual(this.container, obj.container) && Intrinsics.areEqual(getName(), (TypeParameterReference)other.getName())) {
            if (Intrinsics.areEqual(this.container, obj.container)) {
                i = Intrinsics.areEqual(getName(), (TypeParameterReference)other.getName()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // kotlin.reflect.KTypeParameter
    public String getName() {
        return this.name;
    }

    public List<KType> getUpperBounds() {
        List listOf;
        List list;
        int i;
        if (this.bounds == null) {
            i = 0;
            this.bounds = CollectionsKt.listOf(Reflection.nullableTypeOf(Object.class));
        }
        return listOf;
    }

    @Override // kotlin.reflect.KTypeParameter
    public KVariance getVariance() {
        return this.variance;
    }

    @Override // kotlin.reflect.KTypeParameter
    public int hashCode() {
        int i;
        Object container = this.container;
        if (container != null) {
            i = container.hashCode();
        } else {
            i = 0;
        }
        return i2 += i4;
    }

    @Override // kotlin.reflect.KTypeParameter
    public boolean isReified() {
        return this.isReified;
    }

    public final void setUpperBounds(List<? extends KType> upperBounds) {
        Intrinsics.checkNotNullParameter(upperBounds, "upperBounds");
        if (this.bounds != null) {
        } else {
            this.bounds = upperBounds;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.append("Upper bounds of type parameter '").append(this).append("' have already been initialized.").toString().toString());
        throw illegalStateException;
    }

    @Override // kotlin.reflect.KTypeParameter
    public String toString() {
        return TypeParameterReference.Companion.toString((KTypeParameter)this);
    }
}
