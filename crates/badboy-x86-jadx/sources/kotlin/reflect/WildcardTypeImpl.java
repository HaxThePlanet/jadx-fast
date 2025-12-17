package kotlin.reflect;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0003\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0014B\u0019\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\nH\u0096\u0002J\u0013\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000cH\u0016¢\u0006\u0002\u0010\rJ\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0013\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000cH\u0016¢\u0006\u0002\u0010\rJ\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u000fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lkotlin/reflect/WildcardTypeImpl;", "Ljava/lang/reflect/WildcardType;", "Lkotlin/reflect/TypeImpl;", "upperBound", "Ljava/lang/reflect/Type;", "lowerBound", "(Ljava/lang/reflect/Type;Ljava/lang/reflect/Type;)V", "equals", "", "other", "", "getLowerBounds", "", "()[Ljava/lang/reflect/Type;", "getTypeName", "", "getUpperBounds", "hashCode", "", "toString", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class WildcardTypeImpl implements WildcardType, kotlin.reflect.TypeImpl {

    public static final kotlin.reflect.WildcardTypeImpl.Companion Companion;
    private static final kotlin.reflect.WildcardTypeImpl STAR;
    private final Type lowerBound;
    private final Type upperBound;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlin/reflect/WildcardTypeImpl$Companion;", "", "()V", "STAR", "Lkotlin/reflect/WildcardTypeImpl;", "getSTAR", "()Lkotlin/reflect/WildcardTypeImpl;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.reflect.WildcardTypeImpl getSTAR() {
            return WildcardTypeImpl.access$getSTAR$cp();
        }
    }
    static {
        final int i = 0;
        WildcardTypeImpl.Companion companion = new WildcardTypeImpl.Companion(i);
        WildcardTypeImpl.Companion = companion;
        WildcardTypeImpl wildcardTypeImpl = new WildcardTypeImpl(i, i);
        WildcardTypeImpl.STAR = wildcardTypeImpl;
    }

    public WildcardTypeImpl(Type upperBound, Type lowerBound) {
        super();
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }

    public static final kotlin.reflect.WildcardTypeImpl access$getSTAR$cp() {
        return WildcardTypeImpl.STAR;
    }

    @Override // java.lang.reflect.WildcardType
    public boolean equals(Object other) {
        int i;
        boolean equals;
        Type[] upperBounds;
        if (other instanceof WildcardType && Arrays.equals(getUpperBounds(), (WildcardType)other.getUpperBounds()) && Arrays.equals(getLowerBounds(), (WildcardType)other.getLowerBounds())) {
            if (Arrays.equals(getUpperBounds(), (WildcardType)other.getUpperBounds())) {
                i = Arrays.equals(getLowerBounds(), (WildcardType)other.getLowerBounds()) ? 1 : 0;
            } else {
            }
        } else {
        }
        return i;
    }

    @Override // java.lang.reflect.WildcardType
    public Type[] getLowerBounds() {
        Type[] arr;
        Type lowerBound;
        final int i2 = 0;
        if (this.lowerBound == null) {
            arr = new Type[i2];
        } else {
            new Type[1][i2] = this.lowerBound;
        }
        return arr;
    }

    @Override // java.lang.reflect.WildcardType
    public String getTypeName() {
        String string;
        Type upperBound;
        String str;
        if (this.lowerBound != null) {
            StringBuilder stringBuilder = new StringBuilder();
            string = stringBuilder.append("? super ").append(TypesJVMKt.access$typeToString(this.lowerBound)).toString();
        } else {
            if (this.upperBound != null && !Intrinsics.areEqual(this.upperBound, Object.class)) {
                if (!Intrinsics.areEqual(this.upperBound, Object.class)) {
                    StringBuilder stringBuilder2 = new StringBuilder();
                    string = stringBuilder2.append("? extends ").append(TypesJVMKt.access$typeToString(this.upperBound)).toString();
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
        Type upperBound;
        Type[] arr = new Type[1];
        if (this.upperBound == null) {
            upperBound = Object.class;
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
