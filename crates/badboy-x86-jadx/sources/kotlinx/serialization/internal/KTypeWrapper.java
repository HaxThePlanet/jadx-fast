package kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\u0008\u0003\u0010\u0004J\u0013\u0010\u0014\u001a\u00020\u00122\u0008\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0096\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0016J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001a\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\tR\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0013¨\u0006\u001b", d2 = {"Lkotlinx/serialization/internal/KTypeWrapper;", "Lkotlin/reflect/KType;", "origin", "<init>", "(Lkotlin/reflect/KType;)V", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "arguments", "Lkotlin/reflect/KTypeProjection;", "getArguments", "classifier", "Lkotlin/reflect/KClassifier;", "getClassifier", "()Lkotlin/reflect/KClassifier;", "isMarkedNullable", "", "()Z", "equals", "other", "", "hashCode", "", "toString", "", "kotlinx-serialization-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
final class KTypeWrapper implements KType {

    private final KType origin;
    public KTypeWrapper(KType origin) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        super();
        this.origin = origin;
    }

    @Override // kotlin.reflect.KType
    public boolean equals(Object other) {
        Object obj;
        KType origin;
        Object obj2;
        int classifier;
        int i = 0;
        if (other == null) {
            return i;
        }
        classifier = 0;
        if (other instanceof KTypeWrapper) {
            obj = other;
        } else {
            obj = classifier;
        }
        origin = obj != null ? obj.origin : classifier;
        if (!Intrinsics.areEqual(this.origin, origin)) {
            return i;
        }
        KClassifier classifier2 = getClassifier();
        if (classifier2 instanceof KClass) {
            if (other instanceof KType) {
                obj2 = other;
            } else {
                obj2 = classifier;
            }
            if (obj2 != null) {
                classifier = obj2.getClassifier();
            }
            if (classifier != 0 && !classifier instanceof KClass) {
                if (!classifier instanceof KClass) {
                }
                return Intrinsics.areEqual(JvmClassMappingKt.getJavaClass((KClass)classifier2), JvmClassMappingKt.getJavaClass((KClass)classifier));
            }
            return i;
        }
        return i;
    }

    public List<Annotation> getAnnotations() {
        return this.origin.getAnnotations();
    }

    public List<KTypeProjection> getArguments() {
        return this.origin.getArguments();
    }

    @Override // kotlin.reflect.KType
    public KClassifier getClassifier() {
        return this.origin.getClassifier();
    }

    @Override // kotlin.reflect.KType
    public int hashCode() {
        return this.origin.hashCode();
    }

    @Override // kotlin.reflect.KType
    public boolean isMarkedNullable() {
        return this.origin.isMarkedNullable();
    }

    @Override // kotlin.reflect.KType
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("KTypeWrapper: ").append(this.origin).toString();
    }
}
