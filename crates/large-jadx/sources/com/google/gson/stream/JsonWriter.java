package com.google.gson.stream;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public class JsonWriter implements Closeable, Flushable {

    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final String[] REPLACEMENT_CHARS;
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls = true;
    private int[] stack;
    private int stackSize = 0;
    static {
        int i;
        String[] rEPLACEMENT_CHARS;
        String format;
        String str;
        JsonWriter.REPLACEMENT_CHARS = new String[128];
        int i3 = 0;
        i = i3;
        while (i <= 31) {
            Object[] arr = new Object[1];
            arr[i3] = Integer.valueOf(i);
            JsonWriter.REPLACEMENT_CHARS[i] = String.format("\\u%04x", arr);
            i++;
        }
        String[] rEPLACEMENT_CHARS2 = JsonWriter.REPLACEMENT_CHARS;
        rEPLACEMENT_CHARS2[34] = "\\\"";
        rEPLACEMENT_CHARS2[92] = "\\\\";
        rEPLACEMENT_CHARS2[9] = "\\t";
        rEPLACEMENT_CHARS2[8] = "\\b";
        rEPLACEMENT_CHARS2[10] = "\\n";
        rEPLACEMENT_CHARS2[13] = "\\r";
        rEPLACEMENT_CHARS2[12] = "\\f";
        Object clone = rEPLACEMENT_CHARS2.clone();
        JsonWriter.HTML_SAFE_REPLACEMENT_CHARS = (String[])clone;
        clone[60] = "\\u003c";
        clone[62] = "\\u003e";
        clone[38] = "\\u0026";
        clone[61] = "\\u003d";
        clone[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        super();
        this.stack = new int[32];
        int i2 = 0;
        push(6);
        this.separator = ":";
        int i4 = 1;
        Objects.requireNonNull(writer, "out == null");
        this.out = writer;
    }

    private void beforeName() {
        Writer peek;
        int i;
        peek = peek();
        if (peek == 5) {
            this.out.write(44);
            newline();
            replaceTop(4);
        } else {
            if (peek != 3) {
            } else {
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("Nesting problem.");
        throw illegalStateException;
    }

    private void beforeValue() {
        Writer lenient;
        int separator;
        int i;
        lenient = peek();
        i = 2;
        if (lenient != 1) {
            if (lenient != i) {
                if (lenient != 4) {
                    i = 7;
                    if (lenient != 6) {
                        if (lenient != i) {
                        } else {
                            if (!this.lenient) {
                            } else {
                            }
                            IllegalStateException illegalStateException = new IllegalStateException("JSON must have only one top-level value.");
                            throw illegalStateException;
                        }
                        IllegalStateException illegalStateException2 = new IllegalStateException("Nesting problem.");
                        throw illegalStateException2;
                    }
                    replaceTop(i);
                } else {
                    this.out.append(this.separator);
                    replaceTop(5);
                }
            } else {
                this.out.append(',');
                newline();
            }
        } else {
            replaceTop(i);
            newline();
        }
    }

    private com.google.gson.stream.JsonWriter close(int i, int i2, char c3) {
        final int peek = peek();
        if (peek != i2) {
            if (peek != i) {
            } else {
            }
            IllegalStateException obj2 = new IllegalStateException("Nesting problem.");
            throw obj2;
        }
        if (this.deferredName != null) {
        } else {
            this.stackSize = obj2--;
            if (peek == i2) {
                newline();
            }
            this.out.write(c3);
            return this;
        }
        StringBuilder obj3 = new StringBuilder();
        obj3.append("Dangling name: ");
        obj3.append(this.deferredName);
        obj2 = new IllegalStateException(obj3.toString());
        throw obj2;
    }

    private void newline() {
        int i;
        Writer out;
        String indent;
        if (this.indent == null) {
        }
        this.out.write(10);
        i = 1;
        while (i < this.stackSize) {
            this.out.write(this.indent);
            i++;
        }
    }

    private com.google.gson.stream.JsonWriter open(int i, char c2) {
        beforeValue();
        push(i);
        this.out.write(c2);
        return this;
    }

    private int peek() {
        int stackSize = this.stackSize;
        if (stackSize == 0) {
        } else {
            return this.stack[stackSize--];
        }
        IllegalStateException illegalStateException = new IllegalStateException("JsonWriter is closed.");
        throw illegalStateException;
    }

    private void push(int i) {
        int stackSize;
        stackSize = this.stackSize;
        int[] stack2 = this.stack;
        if (stackSize == stack2.length) {
            this.stack = Arrays.copyOf(stack2, stackSize *= 2);
        }
        int stackSize2 = this.stackSize;
        this.stackSize = stackSize2 + 1;
        this.stack[stackSize2] = i;
    }

    private void replaceTop(int i) {
        this.stack[stackSize--] = i;
    }

    private void string(String string) {
        String[] hTML_SAFE_REPLACEMENT_CHARS;
        int length;
        int i3;
        int i2;
        String charAt;
        int out;
        int i;
        hTML_SAFE_REPLACEMENT_CHARS = this.htmlSafe ? JsonWriter.HTML_SAFE_REPLACEMENT_CHARS : JsonWriter.REPLACEMENT_CHARS;
        final int i4 = 34;
        this.out.write(i4);
        length = string.length();
        i2 = i3;
        while (i3 < length) {
            charAt = string.charAt(i3);
            if (charAt < 128) {
            } else {
            }
            if (charAt == 8232) {
            } else {
            }
            if (charAt == 8233) {
            }
            i3++;
            charAt = "\\u2029";
            if (i2 < i3) {
            }
            this.out.write(charAt);
            i2 = i3 + 1;
            this.out.write(string, i2, i3 - i2);
            charAt = "\\u2028";
            if (hTML_SAFE_REPLACEMENT_CHARS[charAt] == null) {
            } else {
            }
        }
        if (i2 < length) {
            this.out.write(string, i2, length -= i2);
        }
        this.out.write(i4);
    }

    private void writeDeferredName() {
        String deferredName;
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = 0;
        }
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter beginArray() {
        writeDeferredName();
        return open(1, '[');
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter beginObject() {
        writeDeferredName();
        return open(3, '{');
    }

    @Override // java.io.Closeable
    public void close() {
        int stackSize;
        int i;
        int[] stack;
        this.out.close();
        stackSize = this.stackSize;
        i = 1;
        if (stackSize > i) {
        } else {
            if (stackSize == i) {
                if (this.stack[stackSize -= i] != 7) {
                } else {
                }
            }
            this.stackSize = 0;
        }
        IOException iOException = new IOException("Incomplete document");
        throw iOException;
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter endArray() {
        return close(1, 2, ']');
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter endObject() {
        return close(3, 5, '}');
    }

    @Override // java.io.Closeable
    public void flush() {
        if (this.stackSize == 0) {
        } else {
            this.out.flush();
        }
        IllegalStateException illegalStateException = new IllegalStateException("JsonWriter is closed.");
        throw illegalStateException;
    }

    @Override // java.io.Closeable
    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    @Override // java.io.Closeable
    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    @Override // java.io.Closeable
    public boolean isLenient() {
        return this.lenient;
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter jsonValue(String string) {
        if (string == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.append(string);
        return this;
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter name(String string) {
        Objects.requireNonNull(string, "name == null");
        if (this.deferredName != null) {
        } else {
            if (this.stackSize == 0) {
            } else {
                this.deferredName = string;
                return this;
            }
            IllegalStateException obj2 = new IllegalStateException("JsonWriter is closed.");
            throw obj2;
        }
        obj2 = new IllegalStateException();
        throw obj2;
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter nullValue() {
        String serializeNulls;
        if (this.deferredName != null && this.serializeNulls) {
            if (this.serializeNulls) {
                writeDeferredName();
            }
            this.deferredName = 0;
            return this;
        }
        beforeValue();
        this.out.write("null");
        return this;
    }

    @Override // java.io.Closeable
    public final void setHtmlSafe(boolean z) {
        this.htmlSafe = z;
    }

    @Override // java.io.Closeable
    public final void setIndent(String string) {
        String obj2;
        if (string.length() == 0) {
            this.indent = 0;
            this.separator = ":";
        } else {
            this.indent = string;
            this.separator = ": ";
        }
    }

    @Override // java.io.Closeable
    public final void setLenient(boolean z) {
        this.lenient = z;
    }

    @Override // java.io.Closeable
    public final void setSerializeNulls(boolean z) {
        this.serializeNulls = z;
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter value(double d) {
        boolean naN;
        writeDeferredName();
        if (!this.lenient) {
            if (Double.isNaN(d)) {
            } else {
                if (Double.isInfinite(d)) {
                } else {
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Numeric values must be finite, but was ");
            stringBuilder.append(d);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        beforeValue();
        this.out.append(Double.toString(d));
        return this;
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter value(long l) {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(l));
        return this;
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter value(Boolean boolean) {
        String obj2;
        if (boolean == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        obj2 = boolean.booleanValue() ? "true" : "false";
        this.out.write(obj2);
        return this;
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter value(Number number) {
        boolean lenient;
        if (number == null) {
            return nullValue();
        }
        writeDeferredName();
        String string = number.toString();
        if (!this.lenient) {
            if (string.equals("-Infinity")) {
            } else {
                if (string.equals("Infinity")) {
                } else {
                    if (string.equals("NaN")) {
                    } else {
                    }
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Numeric values must be finite, but was ");
            stringBuilder.append(number);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        beforeValue();
        this.out.append(string);
        return this;
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter value(String string) {
        if (string == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        string(string);
        return this;
    }

    @Override // java.io.Closeable
    public com.google.gson.stream.JsonWriter value(boolean z) {
        String obj2;
        writeDeferredName();
        beforeValue();
        obj2 = z ? "true" : "false";
        this.out.write(obj2);
        return this;
    }
}
