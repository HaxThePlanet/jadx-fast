package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0008¢\u0006\u0002\u0010\tJ\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0013\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00060\nH\u0016¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u0008\u0010\u0013\u001a\u00020\u0006H\u0016J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019", d2 = {"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "equals", "", "other", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getOwnerType", "getRawType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ParameterizedTypeImpl implements ParameterizedType, kotlin.reflect.TypeImpl {

    private final Type ownerType;
    private final Class<?> rawType;
    private final Type[] typeArguments;
    public ParameterizedTypeImpl(Class<?> rawType, Type ownerType, List<? extends Type> typeArguments) {
        Intrinsics.checkNotNullParameter(rawType, "rawType");
        Intrinsics.checkNotNullParameter(typeArguments, "typeArguments");
        super();
        this.rawType = rawType;
        this.ownerType = ownerType;
        final int i = 0;
        this.typeArguments = (Type[])(Collection)typeArguments.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.ParameterizedType
    public boolean equals(Object other) {
        boolean equals;
        int i;
        Type actualTypeArguments;
        if (other instanceof ParameterizedType && Intrinsics.areEqual(this.rawType, (ParameterizedType)other.getRawType()) && Intrinsics.areEqual(this.ownerType, (ParameterizedType)other.getOwnerType()) && Arrays.equals(getActualTypeArguments(), (ParameterizedType)other.getActualTypeArguments())) {
            if (Intrinsics.areEqual(this.rawType, (ParameterizedType)other.getRawType())) {
                if (Intrinsics.areEqual(this.ownerType, (ParameterizedType)other.getOwnerType())) {
                    i = Arrays.equals(getActualTypeArguments(), (ParameterizedType)other.getActualTypeArguments()) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.typeArguments;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.ownerType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return (Type)this.rawType;
    }

    @Override // java.lang.reflect.ParameterizedType
    public String getTypeName() {
        String simpleName;
        int iNSTANCE;
        Type[] typeArguments;
        StringBuilder sb;
        int i5;
        String str2;
        String str;
        int i2;
        int i3;
        kotlin.reflect.ParameterizedTypeImpl.getTypeName.1.1 anon;
        int i;
        int i4;
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder sb2 = stringBuilder;
        final int i6 = 0;
        if (this.ownerType != null) {
            sb2.append(TypesJVMKt.access$typeToString(this.ownerType));
            sb2.append("$");
            sb2.append(this.rawType.getSimpleName());
        } else {
            sb2.append(TypesJVMKt.access$typeToString((Type)this.rawType));
        }
        iNSTANCE = typeArguments2.length == 0 ? 1 : 0;
        if (iNSTANCE == null) {
            ArraysKt.joinTo$default(this.typeArguments, (Appendable)sb2, 0, (CharSequence)"<", (CharSequence)">", 0, 0, (Function1)ParameterizedTypeImpl.getTypeName.1.1.INSTANCE, 50, 0);
        }
        String string = stringBuilder.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @Override // java.lang.reflect.ParameterizedType
    public int hashCode() {
        int i;
        Type ownerType = this.ownerType;
        if (ownerType != null) {
            i = ownerType.hashCode();
        } else {
            i = 0;
        }
        return i3 ^= i5;
    }

    @Override // java.lang.reflect.ParameterizedType
    public String toString() {
        return getTypeName();
    }
}
