package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class Utf8Safe extends androidx.emoji2.text.flatbuffer.Utf8 {

    static class UnpairedSurrogateException extends java.lang.IllegalArgumentException {
        UnpairedSurrogateException(int index, int length) {
            StringBuilder stringBuilder = new StringBuilder();
            super(stringBuilder.append("Unpaired surrogate at index ").append(index).append(" of ").append(length).toString());
        }
    }
    private static int computeEncodedLength(java.lang.CharSequence sequence) {
        int utf8Length;
        int i;
        char charAt;
        int encodedLengthGeneral;
        final int length = sequence.length();
        utf8Length = length;
        i = 0;
        while (i < length) {
            if (sequence.charAt(i) < 128) {
            }
            i++;
        }
        while (i < length) {
            charAt = sequence.charAt(i);
            if (charAt >= 2048) {
                break;
            } else {
            }
            utf8Length += encodedLengthGeneral;
            i++;
        }
        if (utf8Length < length) {
        } else {
            return utf8Length;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.append("UTF-8 length does not fit in int: ").append(l += l2).toString());
        throw illegalArgumentException;
    }

    public static String decodeUtf8Array(byte[] bytes, int index, int size) {
        int offset2;
        int i;
        int i4;
        byte offset;
        int oneByte;
        boolean oneByte2;
        int i3;
        int i2;
        int resultPos;
        if (i5 |= i12 < 0) {
        } else {
            int i13 = offset2 + size;
            final char[] cArr = new char[size];
            i4 = 0;
            while (offset2 < i13) {
                offset = bytes[offset2];
                if (!Utf8.DecodeUtil.isOneByte(offset)) {
                    break;
                } else {
                }
                offset2++;
                Utf8.DecodeUtil.handleOneByte(offset, cArr, i4);
                i4 = oneByte;
            }
            i3 = i4;
            while (offset2 < i13) {
                offset = i14;
                i4 = bytes[offset2];
                String str2 = "Invalid UTF-8";
                int i10 = offset + 1;
                int i16 = i10 + 1;
                Utf8.DecodeUtil.handleFourBytes(i4, bytes[offset], bytes[i10], bytes[i16], cArr, i3);
                offset2 = i2;
                i3 = resultPos;
                int i8 = offset + 1;
                Utf8.DecodeUtil.handleThreeBytes(i4, bytes[offset], bytes[i8], cArr, i3);
                offset2 = oneByte;
                i3 = oneByte2;
                offset2 = offset + 1;
                Utf8.DecodeUtil.handleTwoBytes(i4, bytes[offset], cArr, i3);
                i3 = oneByte;
                i = i3 + 1;
                Utf8.DecodeUtil.handleOneByte(i4, cArr, i3);
                while (offset < i13) {
                    oneByte = bytes[offset];
                    if (!Utf8.DecodeUtil.isOneByte(oneByte)) {
                        break loop_10;
                    } else {
                    }
                    offset++;
                    Utf8.DecodeUtil.handleOneByte(oneByte, cArr, i);
                    i = oneByte2;
                }
                i3 = i;
                offset2 = offset;
                oneByte = bytes[offset];
                if (!Utf8.DecodeUtil.isOneByte(oneByte)) {
                } else {
                }
                offset++;
                Utf8.DecodeUtil.handleOneByte(oneByte, cArr, i);
                i = oneByte2;
            }
            String byte1 = new String(cArr, 0, i3);
            return byte1;
        }
        ArrayIndexOutOfBoundsException offset3 = new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", /* result */));
        throw offset3;
    }

    public static String decodeUtf8Buffer(ByteBuffer buffer, int offset, int length) {
        int i2;
        byte offset2;
        int oneByte;
        boolean oneByte2;
        int i;
        int i3;
        int resultPos;
        int obj10;
        if (i4 |= i8 < 0) {
        } else {
            int i6 = offset + length;
            final char[] cArr = new char[length];
            i2 = 0;
            while (obj10 < i6) {
                offset2 = buffer.get(obj10);
                if (!Utf8.DecodeUtil.isOneByte(offset2)) {
                    break;
                } else {
                }
                obj10++;
                Utf8.DecodeUtil.handleOneByte(offset2, cArr, i2);
                i2 = oneByte;
            }
            i = i2;
            while (obj10 < i6) {
                offset2 = i9;
                i2 = buffer.get(obj10);
                String str2 = "Invalid UTF-8";
                obj10 = offset2 + 1;
                int i11 = obj10 + 1;
                Utf8.DecodeUtil.handleFourBytes(i2, buffer.get(offset2), buffer.get(obj10), buffer.get(i11), cArr, i);
                obj10 = i3;
                i = resultPos;
                obj10 = offset2 + 1;
                Utf8.DecodeUtil.handleThreeBytes(i2, buffer.get(offset2), buffer.get(obj10), cArr, i);
                obj10 = oneByte;
                i = oneByte2;
                obj10 = offset2 + 1;
                Utf8.DecodeUtil.handleTwoBytes(i2, buffer.get(offset2), cArr, i);
                i = oneByte;
                obj10 = i + 1;
                Utf8.DecodeUtil.handleOneByte(i2, cArr, i);
                while (offset2 < i6) {
                    oneByte = buffer.get(offset2);
                    if (!Utf8.DecodeUtil.isOneByte(oneByte)) {
                        break loop_10;
                    } else {
                    }
                    offset2++;
                    Utf8.DecodeUtil.handleOneByte(oneByte, cArr, obj10);
                    obj10 = oneByte2;
                }
                i = obj10;
                obj10 = offset2;
                oneByte = buffer.get(offset2);
                if (!Utf8.DecodeUtil.isOneByte(oneByte)) {
                } else {
                }
                offset2++;
                Utf8.DecodeUtil.handleOneByte(oneByte, cArr, obj10);
                obj10 = oneByte2;
            }
            String byte1 = new String(cArr, 0, i);
            return byte1;
        }
        ArrayIndexOutOfBoundsException limit = new ArrayIndexOutOfBoundsException(String.format("buffer limit=%d, index=%d, limit=%d", /* result */));
        throw limit;
    }

    private static int encodeUtf8Array(java.lang.CharSequence in, byte[] out, int offset, int length) {
        int j;
        int i3;
        int i;
        int surrogatePair;
        byte charAt;
        char codePoint;
        int j2;
        int length3;
        int surrogatePair2;
        byte length2;
        int i2;
        byte b;
        final int length4 = in.length();
        int i4 = offset;
        i3 = 0;
        final int i7 = offset + length;
        surrogatePair = 128;
        while (i3 < length4) {
            if (i3 + i4 < i7) {
            }
            charAt = in.charAt(i3);
            if (charAt < surrogatePair) {
            }
            out[i4 + i3] = (byte)codePoint;
            i3++;
            surrogatePair = 128;
        }
        if (i3 == length4) {
            return i4 + length4;
        }
        i4 += i3;
        while (i3 < length4) {
            charAt = in.charAt(i3);
            length3 = 57343;
            int i12 = 55296;
            char charAt3 = in.charAt(i3++);
            codePoint = Character.toCodePoint(charAt, charAt3);
            int i25 = j + 1;
            out[j] = (byte)i27;
            int i6 = i25 + 1;
            out[i25] = (byte)i30;
            i2 = i6 + 1;
            out[i6] = (byte)i33;
            j = i2 + 1;
            out[i2] = (byte)i35;
            i3++;
            int i10 = j + 1;
            out[j] = (byte)i14;
            int i5 = i10 + 1;
            out[i10] = (byte)i17;
            out[i5] = (byte)i19;
            j = codePoint;
            codePoint = j + 1;
            out[j] = (byte)i21;
            j = codePoint + 1;
            out[codePoint] = (byte)i23;
            out[j] = (byte)charAt;
            j = codePoint;
        }
        return j;
    }

    private static void encodeUtf8Buffer(java.lang.CharSequence in, ByteBuffer out) {
        int i;
        int outIx;
        int inIx;
        Throwable th;
        int charAt;
        int arrayIndexOutOfBoundsException;
        int outIx2;
        int surrogatePair;
        byte string;
        int str;
        byte b;
        final int length = in.length();
        int position = out.position();
        inIx = 0;
        int i7 = 128;
        while (inIx < length) {
            charAt = in.charAt(inIx);
            if (charAt < i7) {
            }
            out.put(position + inIx, (byte)arrayIndexOutOfBoundsException);
            inIx++;
            i7 = 128;
        }
        if (inIx == length) {
            out.position(position + inIx);
        }
        position += inIx;
        while (inIx < length) {
            charAt = in.charAt(inIx);
            int i10 = outIx + 1;
            out.put(outIx, (byte)i14);
            out.put(i10, (byte)i17);
            out.put(i10 + 1, (byte)i12);
            inIx++;
            outIx++;
            char charAt2 = in.charAt(inIx++);
            arrayIndexOutOfBoundsException = Character.toCodePoint(charAt, charAt2);
            int i20 = outIx + 1;
            out.put(outIx, (byte)i22);
            int i2 = i20 + 1;
            out.put(i20, (byte)i25);
            str = i2 + 1;
            out.put(i2, (byte)i28);
            out.put(str, (byte)i4);
            outIx = str;
            arrayIndexOutOfBoundsException = outIx + 1;
            out.put(outIx, (byte)i19);
            out.put(arrayIndexOutOfBoundsException, (byte)i6);
            outIx = arrayIndexOutOfBoundsException;
            out.put(outIx, (byte)charAt);
        }
        out.position(outIx);
    }

    private static int encodedLengthGeneral(java.lang.CharSequence sequence, int start) {
        int utf8Length;
        int i2;
        char charAt;
        int codePointAt;
        int i;
        final int length = sequence.length();
        utf8Length = 0;
        i2 = start;
        while (i2 < length) {
            charAt = sequence.charAt(i2);
            utf8Length += 2;
            i2++;
            i2++;
            utf8Length += codePointAt;
        }
        return utf8Length;
    }

    public String decodeUtf8(ByteBuffer buffer, int offset, int length) throws java.lang.IllegalArgumentException {
        if (buffer.hasArray()) {
            return Utf8Safe.decodeUtf8Array(buffer.array(), arrayOffset += offset, length);
        }
        return Utf8Safe.decodeUtf8Buffer(buffer, offset, length);
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public void encodeUtf8(java.lang.CharSequence in, ByteBuffer out) {
        int arrayOffset;
        int encodeUtf8Array;
        int i;
        int remaining;
        if (out.hasArray()) {
            arrayOffset = out.arrayOffset();
            out.position(encodeUtf8Array - arrayOffset);
        } else {
            Utf8Safe.encodeUtf8Buffer(in, out);
        }
    }

    @Override // androidx.emoji2.text.flatbuffer.Utf8
    public int encodedLength(java.lang.CharSequence in) {
        return Utf8Safe.computeEncodedLength(in);
    }
}
