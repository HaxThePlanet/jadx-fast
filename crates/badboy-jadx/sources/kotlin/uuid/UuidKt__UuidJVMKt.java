package kotlin.uuid;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.SecureRandom;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u001a\u0008\u0010\u0000\u001a\u00020\u0001H\u0001\u001a\u000c\u0010\u0002\u001a\u00020\u0001*\u00020\u0003H\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u001c\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0007\u001a\r\u0010\u0008\u001a\u00020\t*\u00020\tH\u0080\u0008\u001a\r\u0010\n\u001a\u00020\u000b*\u00020\u0001H\u0087\u0008\u001a\r\u0010\u000c\u001a\u00020\u0001*\u00020\u000bH\u0087\u0008¨\u0006\r", d2 = {"secureRandomUuid", "Lkotlin/uuid/Uuid;", "getUuid", "Ljava/nio/ByteBuffer;", "index", "", "putUuid", "uuid", "reverseBytes", "", "toJavaUuid", "Ljava/util/UUID;", "toKotlinUuid", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/uuid/UuidKt")
class UuidKt__UuidJVMKt {
    public static final kotlin.uuid.Uuid getUuid(ByteBuffer $this$getUuid) {
        long msb;
        long lsb;
        boolean $this$reverseBytes$iv;
        int i;
        Intrinsics.checkNotNullParameter($this$getUuid, "<this>");
        final int limit = $this$getUuid.limit();
        if (position += 15 >= limit) {
        } else {
            final ByteOrder lITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
            if (Intrinsics.areEqual($this$getUuid.order(), lITTLE_ENDIAN)) {
                int i3 = 0;
                msb = $this$reverseBytes$iv2;
                i = 0;
                lsb = $this$reverseBytes$iv;
            }
            return Uuid.Companion.fromLongs(msb, limit);
        }
        BufferUnderflowException msb2 = new BufferUnderflowException();
        throw msb2;
    }

    public static final kotlin.uuid.Uuid getUuid(ByteBuffer $this$getUuid, int index) {
        long msb;
        long lsb;
        boolean $this$reverseBytes$iv;
        int i;
        Intrinsics.checkNotNullParameter($this$getUuid, "<this>");
        if (index < 0) {
        } else {
            int limit = $this$getUuid.limit();
            if (index + 15 >= limit) {
            } else {
                final ByteOrder lITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
                if (Intrinsics.areEqual($this$getUuid.order(), lITTLE_ENDIAN)) {
                    int i5 = 0;
                    msb = $this$reverseBytes$iv2;
                    i = 0;
                    lsb = $this$reverseBytes$iv;
                }
                return Uuid.Companion.fromLongs(msb, limit);
            }
            StringBuilder stringBuilder = new StringBuilder();
            IndexOutOfBoundsException msb2 = new IndexOutOfBoundsException(stringBuilder.append("Not enough bytes to read a uuid at index: ").append(index).append(", with limit: ").append($this$getUuid.limit()).append(' ').toString());
            throw msb2;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder2.append("Negative index: ").append(index).toString());
        throw indexOutOfBoundsException;
    }

    public static final ByteBuffer putUuid(ByteBuffer $this$putUuid, int index, kotlin.uuid.Uuid uuid) {
        ByteBuffer long;
        ByteOrder $this$reverseBytes$iv;
        int i2;
        int i;
        Intrinsics.checkNotNullParameter($this$putUuid, "<this>");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        long mostSignificantBits = uuid.getMostSignificantBits();
        final long leastSignificantBits = uuid.getLeastSignificantBits();
        final int i3 = 0;
        if (index < 0) {
        } else {
            if (index + 15 >= $this$putUuid.limit()) {
            } else {
                $this$reverseBytes$iv = ByteOrder.BIG_ENDIAN;
                if (Intrinsics.areEqual($this$putUuid.order(), $this$reverseBytes$iv)) {
                    $this$putUuid.putLong(index, mostSignificantBits);
                    long = $this$putUuid.putLong(index + 8, leastSignificantBits);
                } else {
                    i2 = 0;
                    $this$putUuid.putLong(index, Long.reverseBytes(mostSignificantBits));
                    i = 0;
                    long = $this$putUuid.putLong(index + 8, Long.reverseBytes(leastSignificantBits));
                }
                Intrinsics.checkNotNullExpressionValue(long, "toLongs(...)");
                return long;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException(stringBuilder2.append("Not enough capacity to write a uuid at index: ").append(index).append(", with limit: ").append($this$putUuid.limit()).append(' ').toString());
            throw indexOutOfBoundsException2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("Negative index: ").append(index).toString());
        throw indexOutOfBoundsException;
    }

    public static final ByteBuffer putUuid(ByteBuffer $this$putUuid, kotlin.uuid.Uuid uuid) {
        ByteBuffer long;
        int i;
        Intrinsics.checkNotNullParameter($this$putUuid, "<this>");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        long mostSignificantBits = uuid.getMostSignificantBits();
        final long leastSignificantBits = uuid.getLeastSignificantBits();
        final int i2 = 0;
        if (position += 15 >= $this$putUuid.limit()) {
        } else {
            ByteOrder bIG_ENDIAN = ByteOrder.BIG_ENDIAN;
            if (Intrinsics.areEqual($this$putUuid.order(), bIG_ENDIAN)) {
                $this$putUuid.putLong(mostSignificantBits);
                long = $this$putUuid.putLong(leastSignificantBits);
            } else {
                int i4 = 0;
                $this$putUuid.putLong(Long.reverseBytes(mostSignificantBits));
                i = 0;
                long = $this$putUuid.putLong(Long.reverseBytes(leastSignificantBits));
            }
            Intrinsics.checkNotNullExpressionValue(long, "toLongs(...)");
            return long;
        }
        BufferOverflowException bufferOverflowException = new BufferOverflowException();
        throw bufferOverflowException;
    }

    public static final long reverseBytes(long $this$reverseBytes) {
        final int i = 0;
        return Long.reverseBytes($this$reverseBytes);
    }

    public static final kotlin.uuid.Uuid secureRandomUuid() {
        byte[] bArr = new byte[16];
        SecureRandomHolder.INSTANCE.getInstance().nextBytes(bArr);
        return UuidKt.uuidFromRandomBytes(bArr);
    }

    public static final UUID toJavaUuid(kotlin.uuid.Uuid $this$toJavaUuid) {
        Intrinsics.checkNotNullParameter($this$toJavaUuid, "<this>");
        int i = 0;
        final int i2 = 0;
        UUID uuid = new UUID($this$toJavaUuid.getMostSignificantBits(), obj2, $this$toJavaUuid.getLeastSignificantBits(), obj4);
        return uuid;
    }

    public static final kotlin.uuid.Uuid toKotlinUuid(UUID $this$toKotlinUuid) {
        Intrinsics.checkNotNullParameter($this$toKotlinUuid, "<this>");
        int i = 0;
        return Uuid.Companion.fromLongs($this$toKotlinUuid.getMostSignificantBits(), obj3);
    }
}
