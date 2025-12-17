package com.google.android.exoplayer2.m2.j;

import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.m2.d;
import com.google.android.exoplayer2.m2.g;
import com.google.common.base.b;
import com.google.common.base.d;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class a extends g {

    private static final Pattern c;
    private final CharsetDecoder a;
    private final CharsetDecoder b;
    static {
        a.c = Pattern.compile("(.+?)='(.*?)';", 32);
    }

    public a() {
        super();
        this.a = d.c.newDecoder();
        this.b = d.b.newDecoder();
    }

    private String c(ByteBuffer byteBuffer) {
        try {
            this.a.reset();
            byteBuffer.rewind();
            return this.a.decode(byteBuffer).toString();
            CharsetDecoder charsetDecoder2 = this.a;
            charsetDecoder2.reset();
            byteBuffer.rewind();
            throw th;
            Throwable th = this.a;
            th.reset();
            byteBuffer.rewind();
            th = this.b;
            th = th.decode(byteBuffer);
            th = th.toString();
            charsetDecoder2 = this.b;
            charsetDecoder2.reset();
            byteBuffer.rewind();
            return th;
            charsetDecoder2 = this.b;
            charsetDecoder2.reset();
            byteBuffer.rewind();
            throw th;
            th = null;
            charsetDecoder2 = this.b;
            charsetDecoder2.reset();
            byteBuffer.rewind();
            return th;
        } catch (java.nio.charset.CharacterCodingException characterCoding) {
        } catch (Throwable th1) {
        }
    }

    @Override // com.google.android.exoplayer2.m2.g
    protected a b(d d, ByteBuffer byteBuffer2) {
        int i3;
        int i;
        int i2;
        String equals2;
        String group;
        String equals;
        String obj8 = c(byteBuffer2);
        byte[] bArr = new byte[byteBuffer2.limit()];
        byteBuffer2.get(bArr);
        int obj9 = 1;
        final int i4 = 0;
        i3 = 0;
        if (obj8 == null) {
            obj9 = new a.b[obj9];
            b bVar = new b(bArr, i3, i3);
            obj9[i4] = bVar;
            obj8 = new a(obj9);
            return obj8;
        }
        obj8 = a.c.matcher(obj8);
        i2 = i4;
        i = i3;
        while (obj8.find(i2)) {
            equals2 = obj8.group(obj9);
            group = obj8.group(2);
            if (equals2 != null) {
            }
            i2 = obj8.end();
            equals2 = b.c(equals2);
            equals2.hashCode();
            if (!equals2.equals("streamurl")) {
            } else {
            }
            i = group;
            if (!equals2.equals("streamtitle")) {
            } else {
            }
            i3 = group;
        }
        obj9 = new a.b[obj9];
        b bVar2 = new b(bArr, i3, i);
        obj9[i4] = bVar2;
        obj8 = new a(obj9);
        return obj8;
    }
}
