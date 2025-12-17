package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0096\u0002J\u0008\u0010\n\u001a\u00020\u0004H\u0016J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u000cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lkotlin/reflect/GenericArrayTypeImpl;", "Ljava/lang/reflect/GenericArrayType;", "Lkotlin/reflect/TypeImpl;", "elementType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "equals", "", "other", "", "getGenericComponentType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class GenericArrayTypeImpl implements GenericArrayType, kotlin.reflect.TypeImpl {

    private final Type elementType;
    public GenericArrayTypeImpl(Type elementType) {
        Intrinsics.checkNotNullParameter(elementType, "elementType");
        super();
        this.elementType = elementType;
    }

    @Override // java.lang.reflect.GenericArrayType
    public boolean equals(Object other) {
        boolean equal;
        int i;
        Type genericComponentType;
        if (other instanceof GenericArrayType && Intrinsics.areEqual(getGenericComponentType(), (GenericArrayType)other.getGenericComponentType())) {
            i = Intrinsics.areEqual(getGenericComponentType(), (GenericArrayType)other.getGenericComponentType()) ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.elementType;
    }

    @Override // java.lang.reflect.GenericArrayType
    public String getTypeName() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(TypesJVMKt.access$typeToString(this.elementType)).append("[]").toString();
    }

    @Override // java.lang.reflect.GenericArrayType
    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    @Override // java.lang.reflect.GenericArrayType
    public String toString() {
        return getTypeName();
    }
}
