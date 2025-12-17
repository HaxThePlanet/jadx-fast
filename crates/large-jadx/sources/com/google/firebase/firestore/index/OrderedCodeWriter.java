package com.google.firebase.firestore.index;

import com.google.protobuf.j;
import java.math.RoundingMode;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class OrderedCodeWriter {

    private static final int DEFAULT_BUFFER_SIZE = 1024;
    public static final long DOUBLE_ALL_BITS = -1L;
    public static final long DOUBLE_SIGN_MASK = Long.MIN_VALUE;
    public static final byte ESCAPE1 = (byte) 0;
    public static final byte ESCAPE2 = (byte) -1;
    public static final byte FF_BYTE = (byte) 0;
    public static final byte INFINITY = (byte) -1;
    private static final byte[][] LENGTH_TO_HEADER_BITS = null;
    public static final byte NULL_BYTE = (byte) -1;
    public static final byte SEPARATOR = (byte) 1;
    private byte[] buffer;
    private int position = 0;
    static {
        byte[][] bArr = new byte[11];
        int i3 = 2;
        byte[] bArr3 = new byte[i3];
        bArr3 = new byte[]{0, 0};
        byte[] bArr4 = new byte[i3];
        bArr4 = new byte[]{-128, 0};
        byte[] bArr5 = new byte[i3];
        bArr5 = new byte[]{-64, 0};
        bArr[i3] = bArr5;
        byte[] bArr6 = new byte[i3];
        bArr6 = new byte[]{-32, 0};
        bArr[3] = bArr6;
        byte[] bArr7 = new byte[i3];
        bArr7 = new byte[]{-16, 0};
        bArr[4] = bArr7;
        byte[] bArr8 = new byte[i3];
        bArr8 = new byte[]{-8, 0};
        bArr[5] = bArr8;
        byte[] bArr9 = new byte[i3];
        bArr9 = new byte[]{-4, 0};
        bArr[6] = bArr9;
        byte[] bArr10 = new byte[i3];
        bArr10 = new byte[]{-2, 0};
        bArr[7] = bArr10;
        byte[] bArr11 = new byte[i3];
        bArr11 = new byte[]{-1, 0};
        bArr[8] = bArr11;
        byte[] bArr12 = new byte[i3];
        bArr12 = new byte[]{-1, -128};
        bArr[9] = bArr12;
        byte[] bArr2 = new byte[i3];
        bArr2 = new byte[]{-1, -64};
        bArr[10] = bArr2;
        OrderedCodeWriter.LENGTH_TO_HEADER_BITS = bArr;
    }

    public OrderedCodeWriter() {
        super();
        int i = 0;
        this.buffer = new byte[1024];
    }

    private void ensureAvailable(int i) {
        int obj3;
        i += position;
        byte[] buffer = this.buffer;
        if (obj3 <= buffer.length) {
        }
        length2 *= 2;
        if (i2 < obj3) {
        } else {
            obj3 = i2;
        }
        this.buffer = Arrays.copyOf(buffer, obj3);
    }

    private int signedNumLength(long l) {
        int obj3;
        if (Long.compare(l, i) < 0) {
            obj3 = ~l;
        }
        return IntMath.divide(obj3++, 7, RoundingMode.UP);
    }

    private int unsignedNumLength(long l) {
        return IntMath.divide(obj2 - 64, 8, RoundingMode.UP);
    }

    private void writeByteAscending(byte b) {
        final int i = 0;
        final int i2 = -1;
        if (b == 0) {
            writeEscapedByteAscending(i);
            writeEscapedByteAscending(i2);
        } else {
            if (b == i2) {
                writeEscapedByteAscending(i2);
                writeEscapedByteAscending(i);
            } else {
                writeEscapedByteAscending(b);
            }
        }
    }

    private void writeByteDescending(byte b) {
        final int i = 0;
        final int i2 = -1;
        if (b == 0) {
            writeEscapedByteDescending(i);
            writeEscapedByteDescending(i2);
        } else {
            if (b == i2) {
                writeEscapedByteDescending(i2);
                writeEscapedByteDescending(i);
            } else {
                writeEscapedByteDescending(b);
            }
        }
    }

    private void writeEscapedByteAscending(byte b) {
        ensureAvailable(1);
        final int position = this.position;
        this.position = position + 1;
        this.buffer[position] = b;
    }

    private void writeEscapedByteDescending(byte b) {
        ensureAvailable(1);
        final int position = this.position;
        this.position = position + 1;
        this.buffer[position] = (byte)obj4;
    }

    private void writeSeparatorAscending() {
        writeEscapedByteAscending(0);
        writeEscapedByteAscending(1);
    }

    private void writeSeparatorDescending() {
        writeEscapedByteDescending(0);
        writeEscapedByteDescending(1);
    }

    public byte[] encodedBytes() {
        return Arrays.copyOf(this.buffer, this.position);
    }

    public void reset() {
        this.position = 0;
    }

    public void seed(byte[] bArr) {
        int i;
        byte b;
        byte[] buffer;
        int position;
        int i2;
        ensureAvailable(bArr.length);
        i = 0;
        while (i < bArr.length) {
            position = this.position;
            this.position = position + 1;
            this.buffer[position] = bArr[i];
            i++;
        }
    }

    public void writeBytesAscending(j j) {
        int i;
        byte b;
        i = 0;
        while (i < j.size()) {
            writeByteAscending(j.g(i));
            i++;
        }
        writeSeparatorAscending();
    }

    public void writeBytesDescending(j j) {
        int i;
        byte b;
        i = 0;
        while (i < j.size()) {
            writeByteDescending(j.g(i));
            i++;
        }
        writeSeparatorDescending();
    }

    public void writeDoubleAscending(double d) {
        int i;
        long obj3 = Double.doubleToLongBits(d);
        i = Long.compare(obj3, i2) < 0 ? -1 : -9223372036854775808L;
        writeUnsignedLongAscending(obj3 ^= i);
    }

    public void writeDoubleDescending(double d) {
        int i;
        long obj3 = Double.doubleToLongBits(d);
        i = Long.compare(obj3, i2) < 0 ? -1 : -9223372036854775808L;
        writeUnsignedLongDescending(obj3 ^= i);
    }

    public void writeSignedLongAscending(long l) {
        int i4;
        int i2;
        int i5;
        int position;
        int i3;
        byte[] buffer;
        int i;
        int obj9;
        int cmp = Long.compare(l, i6);
        i5 = cmp < 0 ? ~l : l;
        final int i16 = 0;
        final int i17 = 1;
        if (Long.compare(i5, i13) < 0) {
            ensureAvailable(i17);
            int position2 = this.position;
            this.position = position2 + 1;
            this.buffer[position2] = (byte)obj9;
        }
        int signedNumLength = signedNumLength(i5);
        ensureAvailable(signedNumLength);
        if (signedNumLength < 2) {
        } else {
            i4 = cmp < 0 ? -1 : i16;
            position = this.position;
            if (signedNumLength == 10) {
                i3 = position + 2;
                buffer = this.buffer;
                buffer[position] = i4;
                buffer[position + 1] = i4;
            } else {
                if (signedNumLength == 9) {
                    i3 = position + 1;
                    this.buffer[position] = i4;
                } else {
                    i3 = position;
                }
            }
            i7 += position;
            while (i2 >= i3) {
                this.buffer[i2] = (byte)i20;
                obj9 >>= position;
                i2--;
            }
            obj9 = this.buffer;
            int obj10 = this.position;
            byte[][] lENGTH_TO_HEADER_BITS2 = OrderedCodeWriter.LENGTH_TO_HEADER_BITS;
            obj9[obj10] = (byte)i8;
            int i9 = obj10 + 1;
            obj9[i9] = (byte)i12;
            this.position = obj10 += signedNumLength;
        }
        obj10 = new Object[i17];
        obj10[i16] = Integer.valueOf(signedNumLength);
        obj9 = new AssertionError(String.format("Invalid length (%d) returned by signedNumLength", obj10));
        throw obj9;
    }

    public void writeSignedLongDescending(long l) {
        writeSignedLongAscending(~l);
    }

    public void writeUnsignedLongAscending(long l) {
        byte[] buffer;
        int position;
        int i;
        byte b;
        long obj7;
        final int unsignedNumLength = unsignedNumLength(l);
        ensureAvailable(unsignedNumLength + 1);
        position = this.position;
        int i5 = position + 1;
        this.position = i5;
        this.buffer[position] = (byte)unsignedNumLength;
        i6--;
        int position2 = this.position;
        while (i >= position2) {
            this.buffer[i] = (byte)i4;
            obj7 >>>= buffer;
            i--;
            position2 = this.position;
        }
        this.position = position2 += unsignedNumLength;
    }

    public void writeUnsignedLongDescending(long l) {
        byte[] buffer;
        int position;
        int i;
        byte b;
        long obj7;
        final int unsignedNumLength = unsignedNumLength(l);
        ensureAvailable(unsignedNumLength + 1);
        position = this.position;
        int i5 = position + 1;
        this.position = i5;
        this.buffer[position] = (byte)i7;
        i6--;
        int position2 = this.position;
        while (i >= position2) {
            this.buffer[i] = (byte)i4;
            obj7 >>>= buffer;
            i--;
            position2 = this.position;
        }
        this.position = position2 += unsignedNumLength;
    }

    public void writeUtf8Ascending(java.lang.CharSequence charSequence) {
        int i;
        byte b2;
        int i3;
        byte b;
        int i2;
        i = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            i3 = 128;
            if (charAt < i3) {
            } else {
            }
            if (charAt < 2048) {
            } else {
            }
            if (charAt >= 55296) {
            } else {
            }
            writeByteAscending((byte)i20);
            writeByteAscending((byte)i23);
            writeByteAscending((byte)i7);
            i++;
            if (57343 < charAt) {
            } else {
            }
            int codePointAt = Character.codePointAt(charSequence, i);
            i++;
            writeByteAscending((byte)i12);
            writeByteAscending((byte)i15);
            writeByteAscending((byte)i18);
            writeByteAscending((byte)i5);
            writeByteAscending((byte)i25);
            writeByteAscending((byte)i9);
            writeByteAscending((byte)charAt);
        }
        writeSeparatorAscending();
    }

    public void writeUtf8Descending(java.lang.CharSequence charSequence) {
        int i;
        byte b2;
        int i2;
        byte b;
        int i3;
        i = 0;
        while (i < charSequence.length()) {
            char charAt = charSequence.charAt(i);
            i2 = 128;
            if (charAt < i2) {
            } else {
            }
            if (charAt < 2048) {
            } else {
            }
            if (charAt >= 55296) {
            } else {
            }
            writeByteDescending((byte)i20);
            writeByteDescending((byte)i23);
            writeByteDescending((byte)i7);
            i++;
            if (57343 < charAt) {
            } else {
            }
            int codePointAt = Character.codePointAt(charSequence, i);
            i++;
            writeByteDescending((byte)i12);
            writeByteDescending((byte)i15);
            writeByteDescending((byte)i18);
            writeByteDescending((byte)i5);
            writeByteDescending((byte)i25);
            writeByteDescending((byte)i9);
            writeByteDescending((byte)charAt);
        }
        writeSeparatorDescending();
    }
}
