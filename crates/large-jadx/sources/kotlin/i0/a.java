package kotlin.i0;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\tH\u0096\u0002J\u0008\u0010\n\u001a\u00020\u0004H\u0016J\u0008\u0010\u000b\u001a\u00020\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u000cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010", d2 = {"Lkotlin/reflect/GenericArrayTypeImpl;", "Ljava/lang/reflect/GenericArrayType;", "Lkotlin/reflect/TypeImpl;", "elementType", "Ljava/lang/reflect/Type;", "(Ljava/lang/reflect/Type;)V", "equals", "", "other", "", "getGenericComponentType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class a implements GenericArrayType, Type {

    private final Type a;
    public a(Type type) {
        n.f(type, "elementType");
        super();
        this.a = type;
    }

    @Override // java.lang.reflect.GenericArrayType
    public boolean equals(Object object) {
        boolean genericComponentType;
        Object obj2;
        if (object instanceof GenericArrayType && n.b(getGenericComponentType(), (GenericArrayType)object.getGenericComponentType())) {
            obj2 = n.b(getGenericComponentType(), (GenericArrayType)object.getGenericComponentType()) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.a;
    }

    @Override // java.lang.reflect.GenericArrayType
    public String getTypeName() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x.b(this.a));
        stringBuilder.append("[]");
        return stringBuilder.toString();
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
