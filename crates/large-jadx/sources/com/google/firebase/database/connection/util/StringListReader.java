package com.google.firebase.database.connection.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class StringListReader extends Reader {

    private int charPos;
    private boolean closed = false;
    private boolean frozen = false;
    private int markedCharPos;
    private int markedStringListPos;
    private int stringListPos;
    private List<String> strings = null;
    public StringListReader() {
        super();
        int i = 0;
        int i2 = 0;
        this.markedCharPos = this.charPos;
        this.markedStringListPos = this.stringListPos;
        ArrayList arrayList = new ArrayList();
        this.strings = arrayList;
    }

    private long advance(long l) {
        int i3;
        int i2;
        int stringListPos;
        int i;
        long l2;
        i3 = 0;
        while (this.stringListPos < this.strings.size()) {
            if (Long.compare(i3, l) < 0) {
            }
            i = l - i3;
            l2 = (long)currentStringRemainingChars;
            if (Long.compare(i, l2) < 0) {
            } else {
            }
            i3 += l2;
            this.charPos = 0;
            this.stringListPos = stringListPos2++;
            this.charPos = (int)l2;
            i3 += i;
        }
        return i3;
    }

    private void checkState() {
        if (this.closed) {
        } else {
            if (!this.frozen) {
            } else {
            }
            IOException iOException = new IOException("Reader needs to be frozen before read operations can be called");
            throw iOException;
        }
        IOException iOException2 = new IOException("Stream already closed");
        throw iOException2;
    }

    private String currentString() {
        Object obj;
        int stringListPos;
        if (this.stringListPos < this.strings.size()) {
            obj = this.strings.get(this.stringListPos);
        } else {
            obj = 0;
        }
        return obj;
    }

    private int currentStringRemainingChars() {
        int i;
        int charPos;
        String currentString = currentString();
        if (currentString == null) {
            i = 0;
        } else {
            length -= charPos;
        }
        return i;
    }

    @Override // java.io.Reader
    public void addString(String string) {
        int strings;
        if (this.frozen) {
        } else {
            if (string.length() > 0) {
                this.strings.add(string);
            }
        }
        IllegalStateException obj2 = new IllegalStateException("Trying to add string after reading");
        throw obj2;
    }

    @Override // java.io.Reader
    public void close() {
        checkState();
        this.closed = true;
    }

    @Override // java.io.Reader
    public void freeze() {
        if (this.frozen) {
        } else {
            this.frozen = true;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Trying to freeze frozen StringListReader");
        throw illegalStateException;
    }

    @Override // java.io.Reader
    public void mark(int i) {
        checkState();
        this.markedCharPos = this.charPos;
        this.markedStringListPos = this.stringListPos;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return 1;
    }

    @Override // java.io.Reader
    public int read() {
        checkState();
        String currentString = currentString();
        if (currentString == null) {
            return -1;
        }
        advance(1);
        return currentString.charAt(this.charPos);
    }

    @Override // java.io.Reader
    public int read(CharBuffer charBuffer) {
        int remaining;
        String currentString;
        int i2;
        long l;
        int charPos;
        int i;
        checkState();
        remaining = charBuffer.remaining();
        currentString = currentString();
        i2 = 0;
        while (remaining > 0) {
            if (currentString != null) {
            }
            int i4 = Math.min(length -= charPos2, remaining);
            charPos = this.charPos;
            charBuffer.put((String)this.strings.get(this.stringListPos), charPos, charPos + i4);
            remaining -= i4;
            i2 += i4;
            advance((long)i4);
            currentString = currentString();
        }
        if (i2 <= 0 && currentString != null) {
            if (currentString != null) {
            }
            return -1;
        }
        return i2;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i2, int i3) {
        String currentString;
        int i4;
        long l;
        int charPos;
        int i5;
        int i;
        checkState();
        currentString = currentString();
        i4 = 0;
        while (currentString != null) {
            if (i4 < i3) {
            }
            int i6 = Math.min(currentStringRemainingChars(), i3 - i4);
            charPos = this.charPos;
            currentString.getChars(charPos, charPos + i6, cArr, i2 + i4);
            i4 += i6;
            advance((long)i6);
            currentString = currentString();
        }
        if (i4 <= 0 && currentString != null) {
            if (currentString != null) {
            }
            return -1;
        }
        return i4;
    }

    @Override // java.io.Reader
    public boolean ready() {
        checkState();
        return 1;
    }

    @Override // java.io.Reader
    public void reset() {
        this.charPos = this.markedCharPos;
        this.stringListPos = this.markedStringListPos;
    }

    @Override // java.io.Reader
    public long skip(long l) {
        checkState();
        return advance(l);
    }

    @Override // java.io.Reader
    public String toString() {
        Object next;
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = this.strings.iterator();
        for (String next : iterator) {
            stringBuilder.append(next);
        }
        return stringBuilder.toString();
    }
}
