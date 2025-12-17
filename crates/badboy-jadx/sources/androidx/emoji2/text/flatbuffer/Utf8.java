package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public abstract class Utf8 {

    private static androidx.emoji2.text.flatbuffer.Utf8 DEFAULT;

    static class DecodeUtil {
        static void handleFourBytes(byte byte1, byte byte2, byte byte3, byte byte4, char[] resultArr, int resultPos) throws java.lang.IllegalArgumentException {
            boolean notTrailingByte;
            int i;
            if (Utf8.DecodeUtil.isNotTrailingByte(byte2)) {
            } else {
                if (i3 >>= 30 != 0) {
                } else {
                    if (Utf8.DecodeUtil.isNotTrailingByte(byte3)) {
                    } else {
                        if (Utf8.DecodeUtil.isNotTrailingByte(byte4)) {
                        } else {
                            i7 |= trailingByteValue3;
                            resultArr[resultPos] = Utf8.DecodeUtil.highSurrogate(i8);
                            resultArr[resultPos + 1] = Utf8.DecodeUtil.lowSurrogate(i8);
                        }
                    }
                }
            }
            IllegalArgumentException codepoint = new IllegalArgumentException("Invalid UTF-8");
            throw codepoint;
        }

        static void handleOneByte(byte byte1, char[] resultArr, int resultPos) {
            resultArr[resultPos] = (char)byte1;
        }

        static void handleThreeBytes(byte byte1, byte byte2, byte byte3, char[] resultArr, int resultPos) throws java.lang.IllegalArgumentException {
            boolean notTrailingByte;
            int i;
            if (Utf8.DecodeUtil.isNotTrailingByte(byte2)) {
            } else {
                i = -96;
                if (byte1 == -32 && byte2 >= i) {
                    if (byte2 < i) {
                    } else {
                        if (byte1 == -19 && byte2 < i) {
                            if (byte2 >= i) {
                            } else {
                                if (Utf8.DecodeUtil.isNotTrailingByte(byte3)) {
                                } else {
                                    resultArr[resultPos] = (char)i5;
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid UTF-8");
            throw illegalArgumentException;
        }

        static void handleTwoBytes(byte byte1, byte byte2, char[] resultArr, int resultPos) throws java.lang.IllegalArgumentException {
            if (byte1 < -62) {
            } else {
                if (Utf8.DecodeUtil.isNotTrailingByte(byte2)) {
                } else {
                    resultArr[resultPos] = (char)i4;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid UTF-8: Illegal trailing byte in 2 bytes utf");
                throw illegalArgumentException;
            }
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException("Invalid UTF-8: Illegal leading byte in 2 bytes utf");
            throw illegalArgumentException2;
        }

        private static char highSurrogate(int codePoint) {
            return (char)i2;
        }

        private static boolean isNotTrailingByte(byte b) {
            int i;
            i = b > -65 ? 1 : 0;
            return i;
        }

        static boolean isOneByte(byte b) {
            int i;
            i = b >= 0 ? 1 : 0;
            return i;
        }

        static boolean isThreeBytes(byte b) {
            int i;
            i = b < -16 ? 1 : 0;
            return i;
        }

        static boolean isTwoBytes(byte b) {
            int i;
            i = b < -32 ? 1 : 0;
            return i;
        }

        private static char lowSurrogate(int codePoint) {
            return (char)i2;
        }

        private static int trailingByteValue(byte b) {
            return b & 63;
        }
    }

    static class UnpairedSurrogateException extends java.lang.IllegalArgumentException {
        UnpairedSurrogateException(int index, int length) {
            StringBuilder stringBuilder = new StringBuilder();
            super(stringBuilder.append("Unpaired surrogate at index ").append(index).append(" of ").append(length).toString());
        }
    }
    public static androidx.emoji2.text.flatbuffer.Utf8 getDefault() {
        androidx.emoji2.text.flatbuffer.Utf8 utf8Safe;
        if (Utf8.DEFAULT == null) {
            utf8Safe = new Utf8Safe();
            Utf8.DEFAULT = utf8Safe;
        }
        return Utf8.DEFAULT;
    }

    public static void setDefault(androidx.emoji2.text.flatbuffer.Utf8 instance) {
        Utf8.DEFAULT = instance;
    }

    public abstract String decodeUtf8(ByteBuffer byteBuffer, int i2, int i3);

    public abstract void encodeUtf8(java.lang.CharSequence charSequence, ByteBuffer byteBuffer2);

    public abstract int encodedLength(java.lang.CharSequence charSequence);
}
