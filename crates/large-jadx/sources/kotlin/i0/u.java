package kotlin.i0;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.k;
import kotlin.d0.d.n;
import kotlin.y.i;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0003\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\u0008¢\u0006\u0002\u0010\tJ\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0013\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00060\nH\u0016¢\u0006\u0002\u0010\u0011J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u0008\u0010\u0013\u001a\u00020\u0006H\u0016J\u0008\u0010\u0014\u001a\u00020\u0015H\u0016J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0015H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\u0008\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\u00060\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u0019", d2 = {"Lkotlin/reflect/ParameterizedTypeImpl;", "Ljava/lang/reflect/ParameterizedType;", "Lkotlin/reflect/TypeImpl;", "rawType", "Ljava/lang/Class;", "ownerType", "Ljava/lang/reflect/Type;", "typeArguments", "", "(Ljava/lang/Class;Ljava/lang/reflect/Type;Ljava/util/List;)V", "", "[Ljava/lang/reflect/Type;", "equals", "", "other", "", "getActualTypeArguments", "()[Ljava/lang/reflect/Type;", "getOwnerType", "getRawType", "getTypeName", "", "hashCode", "", "toString", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class u implements ParameterizedType, Type {

    private final Type[] a;
    private final Class<?> b;
    private final Type c;

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0008\u0004", d2 = {"<anonymous>", "", "p1", "Ljava/lang/reflect/Type;", "invoke"}, k = 3, mv = {1, 5, 1})
    static final class a extends k implements l<Type, String> {

        public static final kotlin.i0.u.a a;
        static {
            u.a aVar = new u.a();
            u.a.a = aVar;
        }

        a() {
            super(1, x.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
        }

        @Override // kotlin.d0.d.k
        public Object invoke(Object object) {
            return l((Type)object);
        }

        @Override // kotlin.d0.d.k
        public final String l(Type type) {
            n.f(type, "p1");
            return x.b(type);
        }
    }
    public u(Class<?> class, Type type2, List<? extends Type> list3) {
        n.f(class, "rawType");
        n.f(list3, "typeArguments");
        super();
        this.b = class;
        this.c = type2;
        Object[] obj2 = list3.toArray(new Type[0]);
        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Array<T>");
        this.a = (Type[])obj2;
    }

    @Override // java.lang.reflect.ParameterizedType
    public boolean equals(Object object) {
        boolean actualTypeArguments;
        Type ownerType;
        Object obj3;
        if (object instanceof ParameterizedType && n.b(this.b, (ParameterizedType)object.getRawType()) && n.b(this.c, object.getOwnerType()) && Arrays.equals(getActualTypeArguments(), object.getActualTypeArguments())) {
            if (n.b(this.b, (ParameterizedType)object.getRawType())) {
                if (n.b(this.c, object.getOwnerType())) {
                    obj3 = Arrays.equals(getActualTypeArguments(), object.getActualTypeArguments()) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public String getTypeName() {
        String simpleName;
        int i;
        int i5;
        int i6;
        String str;
        String str2;
        int i2;
        int i4;
        kotlin.i0.u.a aVar;
        int i7;
        int i3;
        StringBuilder stringBuilder = new StringBuilder();
        Type type = this.c;
        if (type != null) {
            stringBuilder.append(x.b(type));
            stringBuilder.append("$");
            stringBuilder.append(this.b.getSimpleName());
        } else {
            stringBuilder.append(x.b(this.b));
        }
        Type[] objArr = this.a;
        i6 = 1;
        i = objArr.length == 0 ? i6 : 0;
        if (i ^= i6 != 0) {
            i.G(objArr, stringBuilder, 0, "<", ">", 0, 0, u.a.a, 50, 0);
        }
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // java.lang.reflect.ParameterizedType
    public int hashCode() {
        int i;
        Type type = this.c;
        if (type != null) {
            i = type.hashCode();
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
