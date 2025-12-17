package kotlin.i0;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0019\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0013\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000cH\u0016¢\u0006\u0002\u0010\rJ\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000cH\u0016¢\u0006\u0002\u0010\rJ\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lkotlin/reflect/WildcardTypeImpl;", "Ljava/lang/reflect/WildcardType;", "Lkotlin/reflect/TypeImpl;", "upperBound", "Ljava/lang/reflect/Type;", "lowerBound", "(Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;)V", "equals", "", "other", "", "getLowerBounds", "", "()[Ljava/lang/reflect/Type;", "getTypeName", "", "getUpperBounds", "hashCode", "", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class y implements WildcardType, Type {

    private static final kotlin.i0.y c;
    public static final kotlin.i0.y.a v;
    private final Type a;
    private final Type b;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlin/reflect/WildcardTypeImpl$Companion;", "", "()V", "STAR", "Lkotlin/reflect/WildcardTypeImpl;", "getSTAR", "()Lkotlin/reflect/WildcardTypeImpl;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.y a() {
            return y.a();
        }
    }
    static {
        final int i = 0;
        y.a aVar = new y.a(i);
        y.v = aVar;
        y yVar = new y(i, i);
        y.c = yVar;
    }

    public y(Type type, Type type2) {
        super();
        this.a = type;
        this.b = type2;
    }

    public static final kotlin.i0.y a() {
        return y.c;
    }

    @Override // java.lang.reflect.WildcardType
    public boolean equals(Object object) {
        Type[] lowerBounds;
        Type[] upperBounds;
        int obj3;
        if (object instanceof WildcardType && Arrays.equals(getUpperBounds(), (WildcardType)object.getUpperBounds()) && Arrays.equals(getLowerBounds(), object.getLowerBounds())) {
            if (Arrays.equals(getUpperBounds(), (WildcardType)object.getUpperBounds())) {
                obj3 = Arrays.equals(getLowerBounds(), object.getLowerBounds()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type[] arr;
        Type[] arr2;
        Type type = this.b;
        final int i = 0;
        if (type == null) {
            arr = new Type[i];
        } else {
            arr2 = new Type[1];
            arr2[i] = type;
            arr = arr2;
        }
        return arr;
    }

    @Override // java.lang.reflect.WildcardType
    public String getTypeName() {
        String string;
        Type type;
        String str;
        if (this.b != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("? super ");
            stringBuilder.append(x.b(this.b));
            string = stringBuilder.toString();
        } else {
            type = this.a;
            if (type != null && z ^= 1 != 0) {
                if (z ^= 1 != 0) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append("? extends ");
                    stringBuilder2.append(x.b(this.a));
                    string = stringBuilder2.toString();
                } else {
                    string = "?";
                }
            } else {
            }
        }
        return string;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getUpperBounds() {
        Type type;
        Type[] arr = new Type[1];
        if (this.a != null) {
        } else {
            type = Object.class;
        }
        return arr;
    }

    @Override // java.lang.reflect.WildcardType
    public int hashCode() {
        return i ^= i3;
    }

    @Override // java.lang.reflect.WildcardType
    public String toString() {
        return getTypeName();
    }
}
