package kotlin.io.encoding;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u000f\u0008\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0002J(\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0010\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0002J\u0008\u0010\u001d\u001a\u00020\tH\u0016J \u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\tH\u0016J\u0008\u0010 \u001a\u00020\tH\u0002J\u0008\u0010!\u001a\u00020\u0014H\u0002J\u0008\u0010\"\u001a\u00020\u0014H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#", d2 = {"Lkotlin/io/encoding/DecodeInputStream;", "Ljava/io/InputStream;", "input", "base64", "Lkotlin/io/encoding/Base64;", "(Ljava/io/InputStream;Lkotlin/io/encoding/Base64;)V", "byteBuffer", "", "byteBufferEndIndex", "", "byteBufferLength", "getByteBufferLength", "()I", "byteBufferStartIndex", "isClosed", "", "isEOF", "singleByteBuffer", "symbolBuffer", "close", "", "copyByteBufferInto", "dst", "dstOffset", "length", "decodeSymbolBufferInto", "dstEndIndex", "symbolBufferLength", "handlePaddingSymbol", "read", "destination", "offset", "readNextSymbol", "resetByteBufferIfEmpty", "shiftByteBufferToStartIfNeeded", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class DecodeInputStream extends InputStream {

    private final kotlin.io.encoding.Base64 base64;
    private final byte[] byteBuffer;
    private int byteBufferEndIndex;
    private int byteBufferStartIndex;
    private final InputStream input;
    private boolean isClosed;
    private boolean isEOF;
    private final byte[] singleByteBuffer;
    private final byte[] symbolBuffer;
    public DecodeInputStream(InputStream input, kotlin.io.encoding.Base64 base64) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(base64, "base64");
        super();
        this.input = input;
        this.base64 = base64;
        this.singleByteBuffer = new byte[1];
        int i2 = 1024;
        this.symbolBuffer = new byte[i2];
        this.byteBuffer = new byte[i2];
    }

    private final void copyByteBufferInto(byte[] dst, int dstOffset, int length) {
        ArraysKt.copyInto(this.byteBuffer, dst, dstOffset, this.byteBufferStartIndex, byteBufferStartIndex3 += length);
        this.byteBufferStartIndex = byteBufferStartIndex += length;
        resetByteBufferIfEmpty();
    }

    private final int decodeSymbolBufferInto(byte[] dst, int dstOffset, int dstEndIndex, int symbolBufferLength) {
        this.byteBufferEndIndex = byteBufferEndIndex += obj11;
        int obj11 = Math.min(getByteBufferLength(), dstEndIndex - dstOffset);
        copyByteBufferInto(dst, dstOffset, obj11);
        shiftByteBufferToStartIfNeeded();
        return obj11;
    }

    private final int getByteBufferLength() {
        return byteBufferEndIndex -= byteBufferStartIndex;
    }

    private final int handlePaddingSymbol(int symbolBufferLength) {
        int secondPad;
        int symbolBuffer;
        int i;
        byte b;
        this.symbolBuffer[symbolBufferLength] = 61;
        if (symbolBufferLength & 3 == 2) {
            int nextSymbol = readNextSymbol();
            if (nextSymbol >= 0) {
                this.symbolBuffer[symbolBufferLength + 1] = (byte)nextSymbol;
            }
            secondPad = symbolBufferLength + 2;
        } else {
            secondPad = symbolBufferLength + 1;
        }
        return secondPad;
    }

    private final int readNextSymbol() {
        int read;
        boolean inMimeAlphabet;
        if (!this.base64.isMimeScheme$kotlin_stdlib()) {
            return this.input.read();
        }
        read = 0;
        read = this.input.read();
        while (read != -1) {
            if (!Base64Kt.isInMimeAlphabet(read)) {
            }
            read = this.input.read();
        }
        return read;
    }

    private final void resetByteBufferIfEmpty() {
        int byteBufferStartIndex;
        if (this.byteBufferStartIndex == this.byteBufferEndIndex) {
            byteBufferStartIndex = 0;
            this.byteBufferStartIndex = byteBufferStartIndex;
            this.byteBufferEndIndex = byteBufferStartIndex;
        }
    }

    private final void shiftByteBufferToStartIfNeeded() {
        int i2;
        int byteBufferStartIndex2;
        int byteBufferStartIndex;
        int byteBufferEndIndex;
        int i;
        if (i4 *= 3 > length -= byteBufferEndIndex2) {
            i = 0;
            ArraysKt.copyInto(this.byteBuffer, this.byteBuffer, i, this.byteBufferStartIndex, this.byteBufferEndIndex);
            this.byteBufferEndIndex = byteBufferEndIndex3 -= byteBufferStartIndex2;
            this.byteBufferStartIndex = i;
        }
    }

    @Override // java.io.InputStream
    public void close() {
        boolean isClosed;
        if (!this.isClosed) {
            this.isClosed = true;
            this.input.close();
        }
    }

    @Override // java.io.InputStream
    public int read() {
        int i;
        final int i6 = 1;
        if (this.byteBufferStartIndex < this.byteBufferEndIndex) {
            this.byteBufferStartIndex = byteBufferStartIndex3 += i6;
            resetByteBufferIfEmpty();
            return b &= 255;
        }
        int i5 = 0;
        switch (read) {
            case -1:
                i = -1;
                break;
            case 0:
                IllegalStateException illegalStateException = new IllegalStateException("Unreachable".toString());
                throw illegalStateException;
            default:
                b2 &= 255;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] destination, int offset, int length) {
        String str;
        int isEOF;
        int length2;
        int i2;
        int symbolsNeeded;
        int dstOffset;
        int symbolBufferLength;
        int i;
        int decodeSymbolBufferInto;
        int i3;
        byte[] symbolBuffer;
        byte b;
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (offset < 0) {
        } else {
            if (length < 0) {
            } else {
                if (offset + length > destination.length) {
                } else {
                    if (this.isClosed) {
                    } else {
                        if (this.isEOF) {
                            return -1;
                        }
                        isEOF = 0;
                        if (length == 0) {
                            return isEOF;
                        }
                        if (getByteBufferLength() >= length) {
                            copyByteBufferInto(destination, offset, length);
                            return length;
                        }
                        final int i9 = 1;
                        symbolsNeeded = i8 * 4;
                        dstOffset = offset;
                        while (!this.isEOF) {
                            if (symbolsNeeded > 0) {
                            }
                            symbolBufferLength = 0;
                            i = Math.min(symbolBuffer2.length, symbolsNeeded);
                            while (!this.isEOF) {
                                if (symbolBufferLength < i) {
                                }
                                decodeSymbolBufferInto = readNextSymbol();
                                this.symbolBuffer[symbolBufferLength] = (byte)decodeSymbolBufferInto;
                                symbolBufferLength++;
                                symbolBufferLength = handlePaddingSymbol(symbolBufferLength);
                                this.isEOF = i9;
                                this.isEOF = i9;
                            }
                            if (!this.isEOF) {
                            } else {
                            }
                            i3 = i9;
                            symbolsNeeded -= symbolBufferLength;
                            dstOffset += decodeSymbolBufferInto;
                            if (symbolBufferLength == i) {
                            } else {
                            }
                            i3 = isEOF;
                            if (symbolBufferLength < i) {
                            }
                            decodeSymbolBufferInto = readNextSymbol();
                            this.symbolBuffer[symbolBufferLength] = (byte)decodeSymbolBufferInto;
                            symbolBufferLength++;
                            symbolBufferLength = handlePaddingSymbol(symbolBufferLength);
                            this.isEOF = i9;
                            this.isEOF = i9;
                        }
                        if (dstOffset == offset && this.isEOF) {
                            if (this.isEOF) {
                            } else {
                                i2 = dstOffset - offset;
                            }
                        } else {
                        }
                        return i2;
                    }
                    IOException iOException = new IOException("The input stream is closed.");
                    throw iOException;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(stringBuilder.append("offset: ").append(offset).append(", length: ").append(length).append(", buffer size: ").append(destination.length).toString());
        throw indexOutOfBoundsException;
    }
}
