package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public class JsonReader implements Closeable {

    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 17;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 15;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 16;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final char[] buffer;
    private final Reader in;
    private boolean lenient = false;
    private int limit = 0;
    private int lineNumber = 0;
    private int lineStart = 0;
    private int[] pathIndices;
    private String[] pathNames;
    int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private int pos = 0;
    private int[] stack;
    private int stackSize = 0;
    static {
        JsonReader.1 anon = new JsonReader.1();
        JsonReaderInternalAccess.INSTANCE = anon;
    }

    public JsonReader(Reader reader) {
        super();
        int i = 0;
        this.buffer = new char[1024];
        int i3 = 32;
        final int[] iArr2 = new int[i3];
        this.stack = iArr2;
        this.stackSize = i + 1;
        iArr2[i] = 6;
        this.pathNames = new String[i3];
        this.pathIndices = new int[i3];
        Objects.requireNonNull(reader, "in == null");
        this.in = reader;
    }

    private void checkLenient() {
        if (!this.lenient) {
        } else {
        }
        throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private void consumeNonExecutePrefix() {
        int fillBuffer;
        char[] buffer;
        int i2;
        char c;
        int i;
        int i3 = 1;
        nextNonWhitespace(i3);
        pos2 -= i3;
        this.pos = i2;
        final int i8 = 5;
        if (i2 + 5 > this.limit && !fillBuffer(i8)) {
            if (!fillBuffer(i8)) {
            }
        }
        buffer = this.buffer;
        if (buffer[i2] == 41 && buffer[i2 + 1] == 93 && buffer[i2 + 2] == 125 && buffer[i2 + 3] == 39) {
            if (buffer[i2 + 1] == 93) {
                if (buffer[i2 + 2] == 125) {
                    if (buffer[i2 + 3] == 39) {
                        if (buffer[i2 += 4] != 10) {
                        } else {
                            this.pos = pos += i8;
                        }
                    }
                }
            }
        }
    }

    private boolean fillBuffer(int i) {
        int lineNumber;
        int pos;
        int i2;
        char c;
        int i3;
        int obj8;
        final char[] buffer = this.buffer;
        pos = this.pos;
        this.lineStart = lineStart -= pos;
        lineNumber = this.limit;
        final int i6 = 0;
        if (lineNumber != pos) {
            lineNumber -= pos;
            this.limit = lineNumber;
            System.arraycopy(buffer, pos, buffer, i6, lineNumber);
        } else {
            this.limit = i6;
        }
        this.pos = i6;
        int limit = this.limit;
        int read = this.in.read(buffer, limit, length -= limit);
        while (read != -1) {
            limit2 += read;
            this.limit = pos;
            i2 = 1;
            lineNumber = this.lineStart;
            if (this.lineNumber == 0 && lineNumber == 0 && pos > 0 && buffer[i6] == 65279) {
            }
            limit = this.limit;
            read = this.in.read(buffer, limit, length -= limit);
            lineNumber = this.lineStart;
            if (lineNumber == 0) {
            }
            if (pos > 0) {
            }
            if (buffer[i6] == 65279) {
            }
            this.pos = pos2 += i2;
            this.lineStart = lineNumber++;
            obj8++;
        }
        return i6;
    }

    private boolean isLiteral(char c) {
        int i;
        if (c != 9 && c != 10 && c != 12 && c != 13 && c != 32) {
            if (c != 10) {
                if (c != 12) {
                    if (c != 13) {
                        if (c != 32) {
                            if (c != 35) {
                                if (c != 44) {
                                    if (c != 47 && c != 61) {
                                        if (c != 61) {
                                            if (c != 123 && c != 125 && c != 58 && c != 59) {
                                                if (c != 125) {
                                                    if (c != 58) {
                                                        if (c != 59) {
                                                            switch (c) {
                                                                case 91:
                                                                    return 0;
                                                                case 92:
                                                                    checkLenient();
                                                                    return 0;
                                                                default:
                                                                    return 1;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                }
                            } else {
                            }
                        }
                    }
                }
            }
        }
    }

    private int nextNonWhitespace(boolean z) {
        int pos;
        char c;
        int fillBuffer;
        char c2;
        int i3;
        int i;
        int i2;
        char[] buffer = this.buffer;
        pos = this.pos;
        fillBuffer = this.limit;
        c2 = 1;
        while (pos == fillBuffer) {
            this.pos = pos;
            pos = this.pos;
            fillBuffer = this.limit;
            i3 = pos + 1;
            c = buffer[pos];
            pos = i3;
            c2 = 1;
            i = 47;
            this.pos = i3;
            checkLenient();
            skipToEndOfLine();
            pos = this.pos;
            fillBuffer = this.limit;
            this.pos = i3;
            i2 = 2;
            checkLenient();
            int pos3 = this.pos;
            c2 = buffer[pos3];
            this.pos = pos3++;
            pos2 += i2;
            fillBuffer = this.limit;
            this.pos = pos3++;
            skipToEndOfLine();
            pos = this.pos;
            fillBuffer = this.limit;
            this.pos = i3--;
            this.pos = pos4 += c2;
            this.lineNumber = lineNumber += c2;
            this.lineStart = i3;
        }
        if (z) {
        } else {
            return -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("End of input");
        stringBuilder.append(locationString());
        EOFException obj8 = new EOFException(stringBuilder.toString());
        throw obj8;
    }

    private String nextQuotedValue(char c) {
        int i3;
        boolean fillBuffer;
        int pos;
        char stringBuilder2;
        int i6;
        int limit;
        int stringBuilder;
        int i2;
        int i4;
        int i5;
        int i;
        final char[] buffer = this.buffer;
        i3 = 0;
        while (/* condition */) {
            while (/* condition */) {
                i2 = 16;
                i4 = 1;
                while (pos < stringBuilder) {
                    i5 = pos + 1;
                    stringBuilder2 = buffer[pos];
                    if (stringBuilder2 == 92) {
                        break loop_3;
                    } else {
                    }
                    if (stringBuilder2 == 10) {
                    }
                    pos = i5;
                    i2 = 16;
                    i4 = 1;
                    this.lineNumber = lineNumber += i4;
                    this.lineStart = i5;
                }
                i5 = pos + 1;
                stringBuilder2 = buffer[pos];
                if (stringBuilder2 == 92) {
                } else {
                }
                if (stringBuilder2 == 10) {
                }
                pos = i5;
                this.lineNumber = lineNumber += i4;
                this.lineStart = i5;
                this.pos = i5;
                i15 -= i4;
                if (i3 == 0) {
                }
                i3.append(buffer, i6, i5);
                i3.append(readEscapeCharacter());
                pos = this.pos;
                limit = this.limit;
                i6 = pos;
                stringBuilder2 = new StringBuilder(Math.max(i10 *= 2, i2));
                i3 = stringBuilder2;
            }
            i2 = 16;
            i4 = 1;
            while (pos < limit) {
                i5 = pos + 1;
                stringBuilder2 = buffer[pos];
                if (stringBuilder2 == 92) {
                    break loop_3;
                } else {
                }
                if (stringBuilder2 == 10) {
                }
                pos = i5;
                i2 = 16;
                i4 = 1;
                this.lineNumber = lineNumber += i4;
                this.lineStart = i5;
            }
            if (i3 == 0) {
            }
            i3.append(buffer, i6, pos - i6);
            this.pos = pos;
            pos = this.pos;
            limit = this.limit;
            stringBuilder = new StringBuilder(Math.max(i7 *= 2, i2));
            i3 = stringBuilder;
            i5 = pos + 1;
            stringBuilder2 = buffer[pos];
            if (stringBuilder2 == 92) {
            } else {
            }
            if (stringBuilder2 == 10) {
            }
            pos = i5;
            this.lineNumber = lineNumber += i4;
            this.lineStart = i5;
            this.pos = i5;
            i15 -= i4;
            if (i3 == 0) {
            }
            i3.append(buffer, i6, i5);
            i3.append(readEscapeCharacter());
            pos = this.pos;
            limit = this.limit;
            stringBuilder2 = new StringBuilder(Math.max(i10 *= 2, i2));
            i3 = stringBuilder2;
        }
        this.pos = i5;
        i13 -= i4;
        if (i3 == 0) {
            String obj10 = new String(buffer, i6, i14);
            return obj10;
        }
        i3.append(buffer, i6, i14);
        return i3.toString();
    }

    private String nextUnquotedValue() {
        int i;
        int stringBuilder;
        String string;
        boolean fillBuffer2;
        char[] buffer;
        int fillBuffer;
        int pos2;
        int length;
        int pos;
        int limit;
        stringBuilder = 0;
        while (/* condition */) {
            int pos4 = this.pos;
            while (pos4 + fillBuffer2 < this.limit) {
                fillBuffer = this.buffer[pos4 += fillBuffer2];
                fillBuffer2++;
                pos4 = this.pos;
            }
            if (stringBuilder == null) {
            }
            stringBuilder.append(this.buffer, this.pos, fillBuffer2);
            this.pos = pos5 += fillBuffer2;
            if (fillBuffer(1)) {
            }
            fillBuffer2 = i;
            stringBuilder = new StringBuilder(Math.max(fillBuffer2, 16));
            fillBuffer = this.buffer[pos4 += fillBuffer2];
            fillBuffer2++;
        }
        i = fillBuffer2;
        if (stringBuilder == null) {
            string = new String(this.buffer, this.pos, i);
        } else {
            stringBuilder.append(this.buffer, this.pos, i);
            string = stringBuilder.toString();
        }
        this.pos = pos3 += i;
        return string;
    }

    private int peekKeyword() {
        int i;
        int i4;
        int i5;
        int i2;
        String str;
        boolean fillBuffer;
        String str2;
        int limit;
        int i3;
        char c;
        int fillBuffer2;
        char charAt;
        char c2 = this.buffer[this.pos];
        int i6 = 0;
        if (c2 != 116) {
            if (c2 == 84) {
                i = 5;
                str = "true";
                str2 = "TRUE";
            } else {
                if (c2 != 102) {
                    if (c2 == 70) {
                        i = 6;
                        str = "false";
                        str2 = "FALSE";
                    } else {
                        if (c2 != 110 && c2 == 78) {
                            if (c2 == 78) {
                            }
                            return i6;
                        }
                        i = 7;
                        str = "null";
                        str2 = "NULL";
                    }
                } else {
                }
            }
        } else {
        }
        final int length = str.length();
        i3 = 1;
        while (i3 < length) {
            c = this.buffer[pos6 += i3];
            i3++;
        }
        if (pos3 += length >= this.limit) {
            if (fillBuffer(length + 1) && isLiteral(this.buffer[pos4 += length])) {
                if (isLiteral(this.buffer[pos4 += length])) {
                    return i6;
                }
            }
        } else {
        }
        this.pos = pos2 += length;
        this.peeked = i;
        return i;
    }

    private int peekNumber() {
        char[] literal;
        int fillBuffer;
        int limit;
        int i2;
        int i;
        int i7;
        int i11;
        int cmp;
        int i5;
        int i9;
        int i10;
        int i8;
        int i6;
        char c;
        int i3;
        int i4;
        final Object obj = this;
        literal = obj.buffer;
        fillBuffer = obj.pos;
        limit = obj.limit;
        final int i19 = 1;
        i10 = i19;
        i6 = i9;
        i8 = 0;
        i3 = 2;
        while (fillBuffer + i5 == limit) {
            fillBuffer = obj.pos;
            limit = obj.limit;
            c = literal[fillBuffer + i5];
            i = 5;
            i2 = 6;
            i4 = 0;
            i9 = i2;
            i5++;
            i3 = 2;
            i4 = 0;
            i9 = i;
            i2 = 6;
            i4 = 0;
            i6 = i9;
            i4 = 0;
            i8 = (long)i2;
            i9 = i3;
            i7 = 0;
            i4 = 0;
            if (i9 == 3) {
            } else {
            }
            if (i9 != i) {
            } else {
            }
            i7 = 0;
            i9 = 7;
            if (i9 == 6) {
            } else {
            }
            i7 = 0;
            i9 = 4;
            i17 -= l2;
            cmp = Long.compare(i8, c);
            if (cmp <= 0) {
            } else {
            }
            i7 = i19;
            i10 &= i7;
            i8 = i2;
            if (cmp == 0 && Long.compare(i2, i8) < 0) {
            } else {
            }
            i7 = 0;
            if (Long.compare(i2, i8) < 0) {
            } else {
            }
        }
        return i7;
    }

    private void push(int i) {
        int stackSize;
        int[] pathNames;
        stackSize = this.stackSize;
        pathNames = this.stack;
        if (stackSize == pathNames.length) {
            stackSize *= 2;
            this.stack = Arrays.copyOf(pathNames, i2);
            this.pathIndices = Arrays.copyOf(this.pathIndices, i2);
            this.pathNames = (String[])Arrays.copyOf(this.pathNames, i2);
        }
        int stackSize2 = this.stackSize;
        this.stackSize = stackSize2 + 1;
        this.stack[stackSize2] = i;
    }

    private char readEscapeCharacter() {
        int fillBuffer2;
        int i3;
        int i2;
        int i6;
        int fillBuffer;
        int pos;
        int i5;
        int i;
        int i4;
        String str2 = "Unterminated escape sequence";
        i6 = 1;
        if (this.pos == this.limit) {
            if (!fillBuffer(i6)) {
            } else {
            }
            throw syntaxError(str2);
        }
        int pos2 = this.pos;
        int i17 = pos2 + 1;
        this.pos = i17;
        char c = this.buffer[pos2];
        i3 = 10;
        if (c != i3) {
            int i16 = 102;
            if (c != 34 && c != 39 && c != 47 && c != 92 && c != 98 && c != i16 && c != 110 && c != 114 && c != 116) {
                if (c != 39) {
                    if (c != 47) {
                        if (c != 92) {
                            if (c != 98) {
                                i16 = 102;
                                if (c != i16) {
                                    if (c != 110) {
                                        if (c != 114) {
                                            if (c != 116) {
                                                if (c != 117) {
                                                } else {
                                                    int i10 = 4;
                                                    if (i17 += i10 > this.limit) {
                                                        if (!fillBuffer(i10)) {
                                                        } else {
                                                        }
                                                        throw syntaxError(str2);
                                                    }
                                                    i2 = 0;
                                                    while (pos < pos + 4) {
                                                        char c3 = this.buffer[pos];
                                                        c3 += -65;
                                                        i += i3;
                                                        i2 = (char)i14;
                                                        pos++;
                                                        c3 += -97;
                                                        c3 += -48;
                                                    }
                                                    this.pos = pos3 += i10;
                                                    return i2;
                                                }
                                                throw syntaxError("Invalid escape sequence");
                                            }
                                            return 9;
                                        }
                                        return 13;
                                    }
                                    return i3;
                                }
                                return 12;
                            }
                            return 8;
                        }
                    }
                }
            }
        } else {
            this.lineNumber = lineNumber += i6;
            this.lineStart = i17;
        }
        return c;
    }

    private void skipQuotedValue(char c) {
        boolean fillBuffer;
        int pos;
        char c2;
        int limit;
        int i2;
        int i;
        int i3;
        while (/* condition */) {
            i2 = 1;
            while (pos < limit) {
                i = pos + 1;
                c2 = this.buffer[pos];
                if (c2 == 92) {
                } else {
                }
                if (c2 == 10) {
                }
                pos = i;
                i2 = 1;
                this.lineNumber = lineNumber += i2;
                this.lineStart = i;
                this.pos = i;
                readEscapeCharacter();
                pos = this.pos;
                limit = this.limit;
            }
            this.pos = pos;
            pos = this.pos;
            limit = this.limit;
            i = pos + 1;
            c2 = buffer[pos];
            if (c2 == 92) {
            } else {
            }
            if (c2 == 10) {
            }
            pos = i;
            this.lineNumber = lineNumber += i2;
            this.lineStart = i;
            this.pos = i;
            readEscapeCharacter();
            pos = this.pos;
            limit = this.limit;
        }
        this.pos = i;
    }

    private boolean skipTo(String string) {
        int i;
        int fillBuffer;
        char c;
        int charAt;
        int i2;
        int i3;
        int i4;
        final int length = string.length();
        while (pos += length > this.limit) {
            if (fillBuffer(length)) {
            }
            charAt = this.pos;
            i4 = 1;
            while (i2 < length) {
                i2++;
            }
            i2++;
            this.pos = pos2 += i4;
            this.lineNumber = lineNumber += i4;
            this.lineStart = charAt++;
        }
        return 0;
    }

    private void skipToEndOfLine() {
        boolean fillBuffer;
        int limit;
        int i;
        final int i2 = 1;
        while (this.pos >= this.limit) {
            if (fillBuffer(i2)) {
                break;
            }
            int pos = this.pos;
            i = pos + 1;
            this.pos = i;
            fillBuffer = this.buffer[pos];
            if (fillBuffer == 10) {
                break;
            } else {
            }
            if (fillBuffer != 13) {
                break;
            }
            i2 = 1;
        }
    }

    private void skipUnquotedValue() {
        int i;
        char c;
        int i2;
        int limit;
        while (/* condition */) {
            int pos = this.pos;
            while (pos + i < this.limit) {
                c = this.buffer[pos += i];
                i++;
                pos = this.pos;
            }
            this.pos = pos += i;
            i = 0;
            c = this.buffer[pos += i];
            i++;
        }
        this.pos = pos2 += i;
    }

    private IOException syntaxError(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(locationString());
        MalformedJsonException malformedJsonException = new MalformedJsonException(stringBuilder.toString());
        throw malformedJsonException;
    }

    @Override // java.io.Closeable
    public void beginArray() {
        int doPeek;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        if (doPeek != 3) {
        } else {
            int i = 1;
            push(i);
            int i2 = 0;
            this.pathIndices[stackSize -= i] = i2;
            this.peeked = i2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_ARRAY but was ");
        stringBuilder.append(peek());
        stringBuilder.append(locationString());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // java.io.Closeable
    public void beginObject() {
        int doPeek;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        if (doPeek != 1) {
        } else {
            push(3);
            this.peeked = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected BEGIN_OBJECT but was ");
        stringBuilder.append(peek());
        stringBuilder.append(locationString());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // java.io.Closeable
    public void close() {
        int i = 0;
        this.peeked = i;
        this.stack[i] = 8;
        this.stackSize = 1;
        this.in.close();
    }

    @Override // java.io.Closeable
    int doPeek() {
        int nextNonWhitespace;
        int stackSize;
        int nextNonWhitespace2;
        int i;
        nextNonWhitespace = this.stack;
        stackSize = this.stackSize;
        int i17 = nextNonWhitespace[stackSize + -1];
        int i18 = 8;
        final int i19 = 39;
        final int i20 = 34;
        final int i21 = 93;
        final int i22 = 3;
        final int i23 = 7;
        final int i24 = 59;
        final int i25 = 44;
        final int i26 = 4;
        final int i27 = 2;
        final int i28 = 1;
        if (i17 == i28) {
            nextNonWhitespace[stackSize -= i28] = i27;
            int nextNonWhitespace3 = nextNonWhitespace(i28);
            this.pos = pos2 -= i28;
            int peekKeyword = peekKeyword();
            if (nextNonWhitespace3 != i20 && nextNonWhitespace3 != i19 && nextNonWhitespace3 != i25 && nextNonWhitespace3 != i24 && nextNonWhitespace3 != 91 && nextNonWhitespace3 != i21 && nextNonWhitespace3 != 123 && peekKeyword != 0) {
                if (nextNonWhitespace3 != i19) {
                    if (nextNonWhitespace3 != i25) {
                        if (nextNonWhitespace3 != i24) {
                            if (nextNonWhitespace3 != 91) {
                                if (nextNonWhitespace3 != i21) {
                                    if (nextNonWhitespace3 != 123) {
                                        this.pos = pos2 -= i28;
                                        peekKeyword = peekKeyword();
                                        if (peekKeyword != 0) {
                                            return peekKeyword;
                                        }
                                        int peekNumber = peekNumber();
                                        if (peekNumber != 0) {
                                            return peekNumber;
                                        }
                                        if (!isLiteral(this.buffer[this.pos])) {
                                        } else {
                                            checkLenient();
                                            int i4 = 10;
                                            this.peeked = i4;
                                            return i4;
                                        }
                                        throw syntaxError("Expected value");
                                    }
                                    this.peeked = i28;
                                    return i28;
                                }
                                if (i17 == i28) {
                                    this.peeked = i26;
                                    return i26;
                                }
                            }
                            this.peeked = i22;
                            return i22;
                        }
                    }
                    if (i17 != i28) {
                        if (i17 != i27) {
                        } else {
                        }
                        throw syntaxError("Unexpected value");
                    }
                    checkLenient();
                    this.pos = pos -= i28;
                    this.peeked = i23;
                    return i23;
                }
                checkLenient();
                this.peeked = i18;
                return i18;
            }
            int i5 = 9;
            this.peeked = i5;
            return i5;
        } else {
            if (i17 == i27) {
                nextNonWhitespace = nextNonWhitespace(i28);
                if (nextNonWhitespace != i25 && nextNonWhitespace != i24) {
                    if (nextNonWhitespace != i24) {
                        if (nextNonWhitespace != i21) {
                        } else {
                            this.peeked = i26;
                            return i26;
                        }
                        throw syntaxError("Unterminated array");
                    }
                    checkLenient();
                }
            } else {
                i = 5;
                if (i17 != i22) {
                    if (i17 == i) {
                    } else {
                        if (i17 == i26) {
                            nextNonWhitespace[stackSize -= i28] = i;
                            nextNonWhitespace = nextNonWhitespace(i28);
                            if (nextNonWhitespace != 58) {
                                if (nextNonWhitespace != 61) {
                                } else {
                                    checkLenient();
                                    if (this.pos >= this.limit) {
                                        stackSize = this.pos;
                                        if (fillBuffer(i28) && this.buffer[stackSize] == 62) {
                                            stackSize = this.pos;
                                            if (this.buffer[stackSize] == 62) {
                                                this.pos = stackSize += i28;
                                            }
                                        }
                                    } else {
                                    }
                                }
                                throw syntaxError("Expected ':'");
                            }
                        } else {
                            if (i17 == 6) {
                                if (this.lenient) {
                                    consumeNonExecutePrefix();
                                }
                                this.stack[stackSize2 -= i28] = i23;
                            } else {
                                if (i17 == i23) {
                                    if (nextNonWhitespace(false) == -1) {
                                        int i12 = 17;
                                        this.peeked = i12;
                                        return i12;
                                    }
                                    checkLenient();
                                    this.pos = pos4 -= i28;
                                } else {
                                    if (i17 == i18) {
                                    } else {
                                    }
                                }
                            }
                        }
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("JsonReader is closed");
                    throw illegalStateException;
                }
            }
        }
        nextNonWhitespace[stackSize -= i28] = i26;
        int i6 = 125;
        nextNonWhitespace2 = nextNonWhitespace(i28);
        if (i17 == i && nextNonWhitespace2 != i25 && nextNonWhitespace2 != i24) {
            nextNonWhitespace2 = nextNonWhitespace(i28);
            if (nextNonWhitespace2 != i25) {
                if (nextNonWhitespace2 != i24) {
                    if (nextNonWhitespace2 != i6) {
                    } else {
                        this.peeked = i27;
                        return i27;
                    }
                    throw syntaxError("Unterminated object");
                }
                checkLenient();
            }
        }
        int nextNonWhitespace5 = nextNonWhitespace(i28);
        String str7 = "Expected name";
        if (nextNonWhitespace5 != i20 && nextNonWhitespace5 != i19 && nextNonWhitespace5 != i6) {
            if (nextNonWhitespace5 != i19) {
                str7 = "Expected name";
                if (nextNonWhitespace5 != i6) {
                    checkLenient();
                    this.pos = pos3 -= i28;
                    if (!isLiteral((char)nextNonWhitespace5)) {
                    } else {
                        int i10 = 14;
                        this.peeked = i10;
                        return i10;
                    }
                    throw syntaxError(str7);
                }
                if (i17 == i) {
                } else {
                    this.peeked = i27;
                    return i27;
                }
                throw syntaxError(str7);
            }
            checkLenient();
            int i8 = 12;
            this.peeked = i8;
            return i8;
        }
        int i7 = 13;
        this.peeked = i7;
        return i7;
    }

    @Override // java.io.Closeable
    public void endArray() {
        int doPeek;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        if (doPeek != 4) {
        } else {
            stackSize--;
            this.stackSize = i;
            int[] pathIndices = this.pathIndices;
            i--;
            pathIndices[i2] = i5++;
            this.peeked = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_ARRAY but was ");
        stringBuilder.append(peek());
        stringBuilder.append(locationString());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // java.io.Closeable
    public void endObject() {
        int doPeek;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        if (doPeek != 2) {
        } else {
            stackSize--;
            this.stackSize = i;
            this.pathNames[i] = 0;
            int[] pathIndices = this.pathIndices;
            i--;
            pathIndices[i2] = i6++;
            this.peeked = 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected END_OBJECT but was ");
        stringBuilder.append(peek());
        stringBuilder.append(locationString());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // java.io.Closeable
    public String getPath() {
        int i;
        int pathNames;
        int i2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('$');
        i = 0;
        while (i < this.stackSize) {
            pathNames = this.stack[i];
            if (pathNames != 1 && pathNames != 2) {
            } else {
            }
            stringBuilder.append('[');
            stringBuilder.append(this.pathIndices[i]);
            stringBuilder.append(']');
            i++;
            if (pathNames != 2) {
            } else {
            }
            if (pathNames != 3 && pathNames != 4 && pathNames != 5) {
            } else {
            }
            stringBuilder.append('.');
            pathNames = this.pathNames;
            if (pathNames[i] != null) {
            }
            stringBuilder.append(pathNames[i]);
            if (pathNames != 4) {
            } else {
            }
            if (pathNames != 5) {
            } else {
            }
        }
        return stringBuilder.toString();
    }

    @Override // java.io.Closeable
    public boolean hasNext() {
        int doPeek;
        int i;
        int i2;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        if (doPeek != 2 && doPeek != 4) {
            i = doPeek != 4 ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // java.io.Closeable
    public final boolean isLenient() {
        return this.lenient;
    }

    @Override // java.io.Closeable
    String locationString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" at line ");
        stringBuilder.append(lineNumber++);
        stringBuilder.append(" column ");
        stringBuilder.append(i2++);
        stringBuilder.append(" path ");
        stringBuilder.append(getPath());
        return stringBuilder.toString();
    }

    @Override // java.io.Closeable
    public boolean nextBoolean() {
        int doPeek;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        int i5 = 0;
        final int i8 = 1;
        if (doPeek == 5) {
            this.peeked = i5;
            int[] pathIndices = this.pathIndices;
            stackSize -= i8;
            pathIndices[i2] = i6 += i8;
            return i8;
        }
        if (doPeek != 6) {
        } else {
            this.peeked = i5;
            int[] pathIndices2 = this.pathIndices;
            stackSize2 -= i8;
            pathIndices2[i4] = i9 += i8;
            return i5;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a boolean but was ");
        stringBuilder.append(peek());
        stringBuilder.append(locationString());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // java.io.Closeable
    public double nextDouble() {
        int nextUnquotedValue;
        int i;
        int peekedNumberLength2;
        boolean naN;
        int pos;
        int peekedNumberLength;
        if (this.peeked == 0) {
            nextUnquotedValue = doPeek();
        }
        int i5 = 0;
        if (nextUnquotedValue == 15) {
            this.peeked = i5;
            int[] pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[i3] = i6++;
            return (double)peekedLong;
        }
        int i8 = 11;
        if (nextUnquotedValue == 16) {
            String string2 = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.peekedString = string2;
            this.pos = pos2 += peekedNumberLength2;
        } else {
            peekedNumberLength2 = 8;
            if (nextUnquotedValue != peekedNumberLength2) {
                if (nextUnquotedValue == 9) {
                } else {
                    if (nextUnquotedValue == 10) {
                        this.peekedString = nextUnquotedValue();
                    } else {
                        if (nextUnquotedValue != i8) {
                        } else {
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Expected a double but was ");
                stringBuilder.append(peek());
                stringBuilder.append(locationString());
                IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                throw illegalStateException;
            }
            i = nextUnquotedValue == peekedNumberLength2 ? 39 : 34;
            this.peekedString = nextQuotedValue(i);
        }
        this.peeked = i8;
        double double = Double.parseDouble(this.peekedString);
        if (!this.lenient) {
            if (Double.isNaN(double)) {
            } else {
                if (Double.isInfinite(double)) {
                } else {
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("JSON forbids NaN and infinities: ");
            stringBuilder2.append(double);
            stringBuilder2.append(locationString());
            MalformedJsonException malformedJsonException = new MalformedJsonException(stringBuilder2.toString());
            throw malformedJsonException;
        }
        this.peekedString = 0;
        this.peeked = i5;
        int[] pathIndices2 = this.pathIndices;
        stackSize2--;
        pathIndices2[i10] = i11++;
        return double;
    }

    @Override // java.io.Closeable
    public int nextInt() {
        int doPeek;
        int i2;
        String nextUnquotedValue;
        int i;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        String str = "Expected an int but was ";
        final int i15 = 0;
        if (doPeek == 15) {
            long peekedLong = this.peekedLong;
            int i16 = (int)peekedLong;
            if (Long.compare(peekedLong, l) != 0) {
            } else {
                this.peeked = i15;
                int[] pathIndices = this.pathIndices;
                stackSize--;
                pathIndices[i7] = i11++;
                return i16;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(this.peekedLong);
            stringBuilder.append(locationString());
            NumberFormatException numberFormatException = new NumberFormatException(stringBuilder.toString());
            throw numberFormatException;
        }
        if (doPeek == 16) {
            String string = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.peekedString = string;
            this.pos = pos += peekedNumberLength;
            this.peeked = 11;
            double double = Double.parseDouble(this.peekedString);
            int i17 = (int)double;
            if (Double.compare(d, double) != 0) {
            } else {
                this.peekedString = 0;
                this.peeked = i15;
                int[] pathIndices2 = this.pathIndices;
                stackSize2--;
                pathIndices2[i9] = i13++;
                return i17;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(this.peekedString);
            stringBuilder2.append(locationString());
            NumberFormatException numberFormatException2 = new NumberFormatException(stringBuilder2.toString());
            throw numberFormatException2;
        } else {
            int i10 = 10;
            int i18 = 8;
            if (doPeek != i18 && doPeek != 9) {
                if (doPeek != 9) {
                    if (doPeek != i10) {
                    } else {
                    }
                    StringBuilder stringBuilder3 = new StringBuilder();
                    stringBuilder3.append(str);
                    stringBuilder3.append(peek());
                    stringBuilder3.append(locationString());
                    IllegalStateException illegalStateException = new IllegalStateException(stringBuilder3.toString());
                    throw illegalStateException;
                }
            }
            if (doPeek == i10) {
                this.peekedString = nextUnquotedValue();
            } else {
                i2 = doPeek == i18 ? 39 : 34;
                this.peekedString = nextQuotedValue(i2);
            }
        }
        this.peeked = i15;
        int[] pathIndices3 = this.pathIndices;
        stackSize3--;
        pathIndices3[i19] = i20++;
        return Integer.parseInt(this.peekedString);
    }

    @Override // java.io.Closeable
    public long nextLong() {
        int doPeek;
        String nextUnquotedValue;
        int i;
        int i2;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        int i11 = 0;
        if (doPeek == 15) {
            this.peeked = i11;
            int[] pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[i7] = i12++;
            return this.peekedLong;
        }
        final String str = "Expected a long but was ";
        if (doPeek == 16) {
            String string = new String(this.buffer, this.pos, this.peekedNumberLength);
            this.peekedString = string;
            this.pos = pos += peekedNumberLength;
            this.peeked = 11;
            double double = Double.parseDouble(this.peekedString);
            long l = (long)double;
            if (Double.compare(d, double) != 0) {
            } else {
                this.peekedString = 0;
                this.peeked = i11;
                int[] pathIndices2 = this.pathIndices;
                stackSize2--;
                pathIndices2[i10] = i14++;
                return l;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(str);
            stringBuilder2.append(this.peekedString);
            stringBuilder2.append(locationString());
            NumberFormatException numberFormatException = new NumberFormatException(stringBuilder2.toString());
            throw numberFormatException;
        } else {
            int i9 = 10;
            int i16 = 8;
            if (doPeek != i16 && doPeek != 9) {
                if (doPeek != 9) {
                    if (doPeek != i9) {
                    } else {
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str);
                    stringBuilder.append(peek());
                    stringBuilder.append(locationString());
                    IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
                    throw illegalStateException;
                }
            }
            if (doPeek == i9) {
                this.peekedString = nextUnquotedValue();
            } else {
                i = doPeek == i16 ? 39 : 34;
                this.peekedString = nextQuotedValue(i);
            }
        }
        this.peeked = i11;
        int[] pathIndices3 = this.pathIndices;
        stackSize3--;
        pathIndices3[i17] = i18++;
        return Long.parseLong(this.peekedString);
    }

    @Override // java.io.Closeable
    public String nextName() {
        int doPeek;
        String nextUnquotedValue;
        int i;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        if (doPeek == 14) {
            nextUnquotedValue = nextUnquotedValue();
            this.peeked = 0;
            this.pathNames[stackSize--] = nextUnquotedValue;
            return nextUnquotedValue;
        } else {
            if (doPeek == 12) {
                nextUnquotedValue = nextQuotedValue('\'');
            } else {
                if (doPeek != 13) {
                } else {
                    nextUnquotedValue = nextQuotedValue('"');
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a name but was ");
        stringBuilder.append(peek());
        stringBuilder.append(locationString());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // java.io.Closeable
    public void nextNull() {
        int doPeek;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        if (doPeek != 7) {
        } else {
            this.peeked = 0;
            int[] pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[i3] = i4++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected null but was ");
        stringBuilder.append(peek());
        stringBuilder.append(locationString());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // java.io.Closeable
    public String nextString() {
        int doPeek;
        String nextUnquotedValue;
        int i;
        int peekedNumberLength;
        int peekedNumberLength2;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        if (doPeek == 10) {
            nextUnquotedValue = nextUnquotedValue();
            this.peeked = 0;
            int[] pathIndices = this.pathIndices;
            stackSize--;
            pathIndices[i7] = i8++;
            return nextUnquotedValue;
        } else {
            if (doPeek == 8) {
                nextUnquotedValue = nextQuotedValue('\'');
            } else {
                if (doPeek == 9) {
                    nextUnquotedValue = nextQuotedValue('"');
                } else {
                    if (doPeek == 11) {
                        nextUnquotedValue = this.peekedString;
                        this.peekedString = 0;
                    } else {
                        i = 15;
                        if (doPeek == i) {
                            nextUnquotedValue = Long.toString(this.peekedLong);
                        } else {
                            if (doPeek != 16) {
                            } else {
                                nextUnquotedValue = new String(this.buffer, this.pos, this.peekedNumberLength);
                                this.pos = pos += peekedNumberLength;
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected a string but was ");
        stringBuilder.append(peek());
        stringBuilder.append(locationString());
        IllegalStateException illegalStateException = new IllegalStateException(stringBuilder.toString());
        throw illegalStateException;
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonToken peek() {
        int doPeek;
        if (this.peeked == 0) {
            doPeek = doPeek();
        }
        switch (doPeek) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
                return JsonToken.BOOLEAN;
            case 6:
                return JsonToken.NULL;
            case 7:
                return JsonToken.STRING;
            case 8:
                return JsonToken.NAME;
            case 9:
                return JsonToken.NUMBER;
            case 10:
                return JsonToken.END_DOCUMENT;
            default:
                AssertionError assertionError = new AssertionError();
                throw assertionError;
        }
    }

    @Override // java.io.Closeable
    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    @Override // java.io.Closeable
    public void skipValue() {
        int i;
        int doPeek;
        int peekedNumberLength;
        int i2;
        int i3 = 0;
        i = i3;
        do {
            peekedNumberLength = 3;
            i2 = 1;
            if (doPeek == peekedNumberLength) {
            } else {
            }
            if (doPeek == i2) {
            } else {
            }
            if (doPeek == 4) {
            } else {
            }
            if (doPeek == 2) {
            } else {
            }
            if (doPeek != 14) {
            } else {
            }
            skipUnquotedValue();
            this.peeked = i3;
            if (i != 0) {
            }
            if (doPeek == 10) {
            } else {
            }
            if (doPeek != 8) {
            } else {
            }
            skipQuotedValue('\'');
            if (doPeek == 12) {
            } else {
            }
            if (doPeek != 9) {
            } else {
            }
            skipQuotedValue('"');
            if (doPeek == 13) {
            } else {
            }
            if (doPeek == 16) {
            }
            this.pos = pos += peekedNumberLength;
            this.stackSize = stackSize3 -= i2;
            i--;
            this.stackSize = stackSize2 -= i2;
            push(peekedNumberLength);
            i++;
            push(i2);
            doPeek = doPeek();
        } while (this.peeked == 0);
        int[] pathIndices = this.pathIndices;
        int stackSize = this.stackSize;
        int i5 = stackSize + -1;
        pathIndices[i5] = i6 += i2;
        this.pathNames[stackSize -= i2] = "null";
    }

    @Override // java.io.Closeable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append(locationString());
        return stringBuilder.toString();
    }
}
