package kotlin.uuid;

import java.io.Serializable;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.HexExtensionsKt;
import kotlin.text.StringsKt;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u0000 !2\u00060\u0001j\u0002`\u0002:\u0001!B\u0017\u0008\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\\\u0010\u0017\u001a\u0002H\u0018\"\u0004\u0008\u0000\u0010\u001826\u0010\u0019\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u001b\u0012\u0008\u0008\u001c\u0012\u0004\u0008\u0008(\u0003\u0012\u0013\u0012\u00110\u0004¢\u0006\u000c\u0008\u001b\u0012\u0008\u0008\u001c\u0012\u0004\u0008\u0008(\u0005\u0012\u0004\u0012\u0002H\u00180\u001aH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001dJ\u0008\u0010\u001e\u001a\u00020\u0016H\u0016J\\\u0010\u001f\u001a\u0002H\u0018\"\u0004\u0008\u0000\u0010\u001826\u0010\u0019\u001a2\u0012\u0013\u0012\u00110 ¢\u0006\u000c\u0008\u001b\u0012\u0008\u0008\u001c\u0012\u0004\u0008\u0008(\u0003\u0012\u0013\u0012\u00110 ¢\u0006\u000c\u0008\u001b\u0012\u0008\u0008\u001c\u0012\u0004\u0008\u0008(\u0005\u0012\u0004\u0012\u0002H\u00180\u001aH\u0087\u0008ø\u0001\u0000\u0082\u0002\n\n\u0008\u0008\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u001dR\u001c\u0010\u0005\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u0007\u0010\u0008\u001a\u0004\u0008\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008\u000b\u0010\u0008\u001a\u0004\u0008\u000c\u0010\n\u0082\u0002\u0007\n\u0005\u0008\u009920\u0001¨\u0006\"", d2 = {"Lkotlin/uuid/Uuid;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "mostSignificantBits", "", "leastSignificantBits", "(JJ)V", "getLeastSignificantBits$annotations", "()V", "getLeastSignificantBits", "()J", "getMostSignificantBits$annotations", "getMostSignificantBits", "equals", "", "other", "", "hashCode", "", "toByteArray", "", "toHexString", "", "toLongs", "T", "action", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toString", "toULongs", "Lkotlin/ULong;", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Uuid implements Serializable {

    public static final kotlin.uuid.Uuid.Companion Companion = null;
    private static final Comparator<kotlin.uuid.Uuid> LEXICAL_ORDER = null;
    private static final kotlin.uuid.Uuid NIL = null;
    public static final int SIZE_BITS = 128;
    public static final int SIZE_BYTES = 16;
    private final long leastSignificantBits;
    private final long mostSignificantBits;

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0012\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u001d\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u0017¢\u0006\u0004\u0008\u0018\u0010\u0019J\u000e\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001cJ\u0006\u0010\u001f\u001a\u00020\u0005R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\u0008\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006 ", d2 = {"Lkotlin/uuid/Uuid$Companion;", "", "()V", "LEXICAL_ORDER", "Ljava/util/Comparator;", "Lkotlin/uuid/Uuid;", "Lkotlin/Comparator;", "getLEXICAL_ORDER", "()Ljava/util/Comparator;", "NIL", "getNIL", "()Lkotlin/uuid/Uuid;", "SIZE_BITS", "", "SIZE_BYTES", "fromByteArray", "byteArray", "", "fromLongs", "mostSignificantBits", "", "leastSignificantBits", "fromULongs", "Lkotlin/ULong;", "fromULongs-eb3DHEI", "(JJ)Lkotlin/uuid/Uuid;", "parse", "uuidString", "", "parseHex", "hexString", "random", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public final kotlin.uuid.Uuid fromByteArray(byte[] byteArray) {
            int i;
            Intrinsics.checkNotNullParameter(byteArray, "byteArray");
            int i3 = 16;
            int i4 = 0;
            i = byteArray.length == i3 ? 1 : i4;
            if (i == 0) {
            } else {
                return fromLongs(UuidKt__UuidKt.access$toLong(byteArray, i4), i3);
            }
            int i2 = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Expected exactly 16 bytes".toString());
            throw illegalArgumentException;
        }

        public final kotlin.uuid.Uuid fromLongs(long mostSignificantBits, long leastSignificantBits) {
            int cmp;
            kotlin.uuid.Uuid nIL;
            cmp = 0;
            if (Long.compare(mostSignificantBits, cmp) == 0 && Long.compare(obj6, cmp) == 0) {
                if (Long.compare(obj6, cmp) == 0) {
                    nIL = getNIL();
                } else {
                    nIL = new Uuid(mostSignificantBits, leastSignificantBits, obj6, obj7);
                }
            } else {
            }
            return nIL;
        }

        public final kotlin.uuid.Uuid fromULongs-eb3DHEI(long mostSignificantBits, long leastSignificantBits) {
            return fromLongs(mostSignificantBits, leastSignificantBits);
        }

        public final Comparator<kotlin.uuid.Uuid> getLEXICAL_ORDER() {
            return Uuid.access$getLEXICAL_ORDER$cp();
        }

        public final kotlin.uuid.Uuid getNIL() {
            return Uuid.access$getNIL$cp();
        }

        public final kotlin.uuid.Uuid parse(String uuidString) {
            int i;
            Object obj = uuidString;
            Intrinsics.checkNotNullParameter(obj, "uuidString");
            i = obj.length() == 36 ? 1 : 0;
            if (i == 0) {
            } else {
                final int i25 = 4;
                int i26 = 0;
                int i21 = 0;
                UuidKt__UuidKt.access$checkHyphenAt(obj, 8);
                UuidKt__UuidKt.access$checkHyphenAt(obj, 13);
                UuidKt__UuidKt.access$checkHyphenAt(obj, 18);
                UuidKt__UuidKt.access$checkHyphenAt(obj, 23);
                return this.fromLongs(i23 |= hexToLong$default4, i25);
            }
            Object obj2 = this;
            int i5 = 0;
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Expected a 36-char string in the standard uuid format.".toString());
            throw illegalArgumentException;
        }

        public final kotlin.uuid.Uuid parseHex(String hexString) {
            int i;
            Intrinsics.checkNotNullParameter(hexString, "hexString");
            i = hexString.length() == 32 ? 1 : 0;
            if (i == 0) {
            } else {
                final int i4 = 16;
                Object obj = hexString;
                return fromLongs(HexExtensionsKt.hexToLong$default(obj, 0, i4, 0, 4, 0), i4);
            }
            Object hexString2 = hexString;
            int obj11 = 0;
            obj11 = new IllegalArgumentException("Expected a 32-char hexadecimal string.".toString());
            throw obj11;
        }

        public final kotlin.uuid.Uuid random() {
            return UuidKt.secureRandomUuid();
        }
    }
    public static int $r8$lambda$hY_iFluWdHz7H_4hiindXk95oZw(kotlin.uuid.Uuid uuid, kotlin.uuid.Uuid uuid2) {
        return Uuid.LEXICAL_ORDER$lambda$2(uuid, uuid2);
    }

    static {
        Uuid.Companion companion = new Uuid.Companion(0);
        Uuid.Companion = companion;
        int i2 = 0;
        Uuid uuid = new Uuid(i2, obj2, i2, obj2);
        Uuid.NIL = uuid;
        Uuid$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new Uuid$$ExternalSyntheticLambda0();
        Uuid.LEXICAL_ORDER = externalSyntheticLambda0;
    }

    public Uuid(long mostSignificantBits, long leastSignificantBits) {
        super();
        this.mostSignificantBits = mostSignificantBits;
        this.leastSignificantBits = obj3;
    }

    private static final int LEXICAL_ORDER$lambda$2(kotlin.uuid.Uuid a, kotlin.uuid.Uuid b) {
        int compareUnsigned;
        long constructor-impl;
        if (Long.compare(mostSignificantBits, mostSignificantBits3) != 0) {
            compareUnsigned = Long.compareUnsigned(ULong.constructor-impl(a.mostSignificantBits), obj1);
        } else {
            compareUnsigned = Long.compareUnsigned(ULong.constructor-impl(a.leastSignificantBits), obj1);
        }
        return compareUnsigned;
    }

    public static final Comparator access$getLEXICAL_ORDER$cp() {
        return Uuid.LEXICAL_ORDER;
    }

    public static final kotlin.uuid.Uuid access$getNIL$cp() {
        return Uuid.NIL;
    }

    public static void getLeastSignificantBits$annotations() {
    }

    public static void getMostSignificantBits$annotations() {
    }

    private final <T> T toLongs(Function2<? super Long, ? super Long, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(Long.valueOf(getMostSignificantBits()), Long.valueOf(getLeastSignificantBits()));
    }

    private final <T> T toULongs(Function2<? super ULong, ? super ULong, ? extends T> action) {
        Intrinsics.checkNotNullParameter(action, "action");
        return action.invoke(ULong.box-impl(ULong.constructor-impl(getMostSignificantBits())), ULong.box-impl(ULong.constructor-impl(getLeastSignificantBits())));
    }

    @Override // java.io.Serializable
    public boolean equals(Object other) {
        int i;
        int cmp;
        long leastSignificantBits;
        long leastSignificantBits2;
        if (this == other) {
            return 1;
        }
        final int i2 = 0;
        if (!other instanceof Uuid) {
            return i2;
        }
        if (Long.compare(leastSignificantBits, leastSignificantBits2) == 0 && Long.compare(leastSignificantBits, leastSignificantBits2) == 0) {
            if (Long.compare(leastSignificantBits, leastSignificantBits2) == 0) {
            } else {
                i = i2;
            }
        } else {
        }
        return i;
    }

    @Override // java.io.Serializable
    public final long getLeastSignificantBits() {
        return this.leastSignificantBits;
    }

    @Override // java.io.Serializable
    public final long getMostSignificantBits() {
        return this.mostSignificantBits;
    }

    @Override // java.io.Serializable
    public int hashCode() {
        mostSignificantBits ^= leastSignificantBits;
        return i4 ^= i6;
    }

    @Override // java.io.Serializable
    public final byte[] toByteArray() {
        byte[] bArr = new byte[16];
        UuidKt__UuidKt.access$toByteArray(this.mostSignificantBits, obj2, bArr);
        UuidKt__UuidKt.access$toByteArray(this.leastSignificantBits, obj2, bArr);
        return bArr;
    }

    @Override // java.io.Serializable
    public final String toHexString() {
        byte[] bArr = new byte[32];
        final int i4 = 8;
        UuidKt__UuidKt.access$formatBytesInto(this.leastSignificantBits, obj2, bArr, 16);
        UuidKt__UuidKt.access$formatBytesInto(this.mostSignificantBits, obj2, bArr, 0);
        return StringsKt.decodeToString(bArr);
    }

    @Override // java.io.Serializable
    public String toString() {
        byte[] bArr = new byte[36];
        int i18 = 6;
        UuidKt__UuidKt.access$formatBytesInto(this.leastSignificantBits, obj2, bArr, 24);
        final int i12 = 45;
        final int i20 = 2;
        UuidKt__UuidKt.access$formatBytesInto(leastSignificantBits2 >>>= i3, i18, bArr, 19);
        UuidKt__UuidKt.access$formatBytesInto(this.mostSignificantBits, i18, bArr, 14);
        UuidKt__UuidKt.access$formatBytesInto(mostSignificantBits3 >>>= i8, i18, bArr, 9);
        UuidKt__UuidKt.access$formatBytesInto(mostSignificantBits >>>= i16, i12, bArr, 0);
        return StringsKt.decodeToString(bArr);
    }
}
