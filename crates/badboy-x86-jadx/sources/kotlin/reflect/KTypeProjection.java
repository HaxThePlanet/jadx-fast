package kotlin.reflect;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0016", d2 = {"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class KTypeProjection {

    public static final kotlin.reflect.KTypeProjection.Companion Companion;
    public static final kotlin.reflect.KTypeProjection star;
    private final kotlin.reflect.KType type;
    private final kotlin.reflect.KVariance variance;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u000c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0008\u0010\u0002¨\u0006\u000e", d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "star", "getStar$annotations", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getStar$annotations() {
        }

        @JvmStatic
        public final kotlin.reflect.KTypeProjection contravariant(kotlin.reflect.KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            KTypeProjection kTypeProjection = new KTypeProjection(KVariance.IN, type);
            return kTypeProjection;
        }

        @JvmStatic
        public final kotlin.reflect.KTypeProjection covariant(kotlin.reflect.KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            KTypeProjection kTypeProjection = new KTypeProjection(KVariance.OUT, type);
            return kTypeProjection;
        }

        public final kotlin.reflect.KTypeProjection getSTAR() {
            return KTypeProjection.star;
        }

        @JvmStatic
        public final kotlin.reflect.KTypeProjection invariant(kotlin.reflect.KType type) {
            Intrinsics.checkNotNullParameter(type, "type");
            KTypeProjection kTypeProjection = new KTypeProjection(KVariance.INVARIANT, type);
            return kTypeProjection;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public class WhenMappings {

        public static final int[] $EnumSwitchMapping$0;
        static {
            int ordinal3;
            int ordinal2;
            int ordinal;
            int[] iArr = new int[values.length];
            iArr[KVariance.INVARIANT.ordinal()] = 1;
            iArr[KVariance.IN.ordinal()] = 2;
            iArr[KVariance.OUT.ordinal()] = 3;
            KTypeProjection.WhenMappings.$EnumSwitchMapping$0 = iArr;
        }
    }
    static {
        final int i = 0;
        KTypeProjection.Companion companion = new KTypeProjection.Companion(i);
        KTypeProjection.Companion = companion;
        KTypeProjection kTypeProjection = new KTypeProjection(i, i);
        KTypeProjection.star = kTypeProjection;
    }

    public KTypeProjection(kotlin.reflect.KVariance variance, kotlin.reflect.KType type) {
        int i2;
        int i3;
        String string;
        int str;
        int i;
        super();
        this.variance = variance;
        this.type = type;
        i3 = 1;
        str = 0;
        i2 = this.variance == null ? i3 : str;
        i = this.type == null ? i3 : str;
        if (i2 == i) {
        } else {
            i3 = str;
        }
        if (i3 == 0) {
            int i4 = 0;
            if (this.variance == null) {
                string = "Star projection must have no type specified.";
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                string = stringBuilder.append("The projection variance ").append(this.variance).append(" requires type to be specified.").toString();
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string.toString());
            throw illegalArgumentException;
        }
    }

    @JvmStatic
    public static final kotlin.reflect.KTypeProjection contravariant(kotlin.reflect.KType type) {
        return KTypeProjection.Companion.contravariant(type);
    }

    public static kotlin.reflect.KTypeProjection copy$default(kotlin.reflect.KTypeProjection kTypeProjection, kotlin.reflect.KVariance kVariance2, kotlin.reflect.KType kType3, int i4, Object object5) {
        kotlin.reflect.KVariance obj1;
        kotlin.reflect.KType obj2;
        if (i4 & 1 != 0) {
            obj1 = kTypeProjection.variance;
        }
        if (i4 &= 2 != 0) {
            obj2 = kTypeProjection.type;
        }
        return kTypeProjection.copy(obj1, obj2);
    }

    @JvmStatic
    public static final kotlin.reflect.KTypeProjection covariant(kotlin.reflect.KType type) {
        return KTypeProjection.Companion.covariant(type);
    }

    @JvmStatic
    public static final kotlin.reflect.KTypeProjection invariant(kotlin.reflect.KType type) {
        return KTypeProjection.Companion.invariant(type);
    }

    public final kotlin.reflect.KVariance component1() {
        return this.variance;
    }

    public final kotlin.reflect.KType component2() {
        return this.type;
    }

    public final kotlin.reflect.KTypeProjection copy(kotlin.reflect.KVariance kVariance, kotlin.reflect.KType kType2) {
        KTypeProjection kTypeProjection = new KTypeProjection(kVariance, kType2);
        return kTypeProjection;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof KTypeProjection) {
            return i2;
        }
        Object obj = object;
        if (this.variance != obj.variance) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.type, obj.type)) {
            return i2;
        }
        return i;
    }

    public final kotlin.reflect.KType getType() {
        return this.type;
    }

    public final kotlin.reflect.KVariance getVariance() {
        return this.variance;
    }

    public int hashCode() {
        int i2;
        int i;
        if (this.variance == null) {
            i2 = i;
        } else {
            i2 = this.variance.hashCode();
        }
        if (this.type == null) {
        } else {
            i = this.type.hashCode();
        }
        return i3 += i;
    }

    public String toString() {
        int i;
        String valueOf;
        int[] type;
        kotlin.reflect.KVariance variance = this.variance;
        if (variance == null) {
            i = -1;
        } else {
            i = KTypeProjection.WhenMappings.$EnumSwitchMapping$0[variance.ordinal()];
        }
        switch (i) {
            case -1:
                valueOf = "*";
                break;
            case 0:
                NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                throw noWhenBranchMatchedException;
            case 1:
                valueOf = String.valueOf(this.type);
                break;
            case 2:
                StringBuilder stringBuilder = new StringBuilder();
                valueOf = stringBuilder.append("in ").append(this.type).toString();
                break;
            default:
                StringBuilder stringBuilder2 = new StringBuilder();
                valueOf = stringBuilder2.append("out ").append(this.type).toString();
        }
        return valueOf;
    }
}
