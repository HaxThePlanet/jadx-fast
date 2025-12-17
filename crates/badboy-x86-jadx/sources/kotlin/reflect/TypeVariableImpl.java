package kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J%\u0010\u000b\u001a\u0004\u0018\u0001H\u000c\"\u0008\u0008\u0000\u0010\u000c*\u00020\r2\u000c\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u0002H\u000c0\u000f¢\u0006\u0002\u0010\u0010J\u0011\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u0008\u0012\u0004\u0012\u00020\u00150\u0012H\u0016¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u0008\u0012\u0004\u0012\u00020\r0\u0012¢\u0006\u0002\u0010\u0013J\u0008\u0010\u0018\u001a\u00020\u0002H\u0016J\u0008\u0010\u0019\u001a\u00020\u001aH\u0016J\u0008\u0010\u001b\u001a\u00020\u001aH\u0016J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J\u0008\u0010\u001e\u001a\u00020\u001aH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f", d2 = {"Lkotlin/reflect/TypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lkotlin/reflect/TypeImpl;", "typeParameter", "Lkotlin/reflect/KTypeParameter;", "(Lkotlin/reflect/KTypeParameter;)V", "equals", "", "other", "", "getAnnotation", "T", "", "annotationClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getAnnotations", "", "()[Ljava/lang/annotation/Annotation;", "getBounds", "Ljava/lang/reflect/Type;", "()[Ljava/lang/reflect/Type;", "getDeclaredAnnotations", "getGenericDeclaration", "getName", "", "getTypeName", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class TypeVariableImpl implements TypeVariable<GenericDeclaration>, kotlin.reflect.TypeImpl {

    private final kotlin.reflect.KTypeParameter typeParameter;
    public TypeVariableImpl(kotlin.reflect.KTypeParameter typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        super();
        this.typeParameter = typeParameter;
    }

    @Override // java.lang.reflect.TypeVariable
    public boolean equals(Object other) {
        int i;
        boolean equal;
        Object genericDeclaration;
        if (other instanceof TypeVariable && Intrinsics.areEqual(getName(), (TypeVariable)other.getName()) && Intrinsics.areEqual(getGenericDeclaration(), (TypeVariable)other.getGenericDeclaration())) {
            if (Intrinsics.areEqual(getName(), (TypeVariable)other.getName())) {
                i = Intrinsics.areEqual(getGenericDeclaration(), (TypeVariable)other.getGenericDeclaration()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    public final <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
        Intrinsics.checkNotNullParameter(annotationClass, "annotationClass");
        return 0;
    }

    @Override // java.lang.reflect.TypeVariable
    public final Annotation[] getAnnotations() {
        return new Annotation[0];
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        Object next;
        Type it;
        int i2;
        int i;
        java.util.List upperBounds = this.typeParameter.getUpperBounds();
        int i4 = 0;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)upperBounds, 10));
        final int i7 = 0;
        final Iterator iterator = upperBounds.iterator();
        for (Object next : iterator) {
            i2 = 0;
            (Collection)arrayList.add(TypesJVMKt.access$computeJavaType((KType)next, true));
        }
        int i3 = 0;
        return (Type[])(Collection)(List)arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public final Annotation[] getDeclaredAnnotations() {
        return new Annotation[0];
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        NotImplementedError notImplementedError = new NotImplementedError(stringBuilder2.append("An operation is not implemented: ").append(stringBuilder.append("getGenericDeclaration() is not yet supported for type variables created from KType: ").append(this.typeParameter).toString()).toString());
        throw notImplementedError;
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.typeParameter.getName();
    }

    @Override // java.lang.reflect.TypeVariable
    public String getTypeName() {
        return getName();
    }

    @Override // java.lang.reflect.TypeVariable
    public int hashCode() {
        return i ^= i3;
    }

    @Override // java.lang.reflect.TypeVariable
    public String toString() {
        return getTypeName();
    }
}
