package com.googlecode.mp4parser.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.mp4parser.iso23001.part7.a;
import com.mp4parser.iso23001.part7.a.j;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public abstract class AbstractSampleEncryptionBox extends AbstractFullBox {

    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    protected int algorithmId = -1;
    List<a> entries;
    protected int ivSize = -1;
    protected byte[] kid;
    static {
        AbstractSampleEncryptionBox.ajc$preClinit();
    }

    protected AbstractSampleEncryptionBox(String string) {
        super(string);
        int obj1 = -1;
        obj1 = new byte[16];
        obj1 = new byte[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        this.kid = obj1;
        this.entries = Collections.emptyList();
    }

    private static void ajc$preClinit() {
        b bVar7 = new b("AbstractSampleEncryptionBox.java", AbstractSampleEncryptionBox.class);
        final String str44 = "method-execution";
        AbstractSampleEncryptionBox.ajc$tjp_0 = bVar7.h(str44, bVar7.g("1", "getOffsetToFirstIV", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 29);
        AbstractSampleEncryptionBox.ajc$tjp_1 = bVar7.h(str44, bVar7.g("1", "getEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 89);
        AbstractSampleEncryptionBox.ajc$tjp_2 = bVar7.h(str44, bVar7.g("1", "setEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.util.List", "entries", "", "void"), 93);
        AbstractSampleEncryptionBox.ajc$tjp_3 = bVar7.h(str44, bVar7.g("1", "equals", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.lang.Object", "o", "", "boolean"), 173);
        AbstractSampleEncryptionBox.ajc$tjp_4 = bVar7.h(str44, bVar7.g("1", "hashCode", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 200);
        AbstractSampleEncryptionBox.ajc$tjp_5 = bVar7.h(str44, bVar7.g("1", "getEntrySizes", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 208);
    }

    private int getNonEmptyEntriesNum() {
        int i2;
        int i;
        Iterator iterator = this.entries.iterator();
        i2 = 0;
        while (!iterator.hasNext()) {
            if ((a)iterator.next().b() > 0) {
            }
            i2++;
        }
        return i2;
    }

    private List<a> parseEntries(ByteBuffer byteBuffer, long l2, int i3) {
        int i2;
        int i;
        int length;
        long l;
        int obj9;
        int obj10;
        ArrayList arrayList = new ArrayList();
        while (Long.compare(obj9, i) <= 0) {
            obj9 = new a();
            obj10 = new byte[obj11];
            obj9.a = obj10;
            byteBuffer.get(obj10);
            if (obj10 &= 2 > 0) {
            }
            arrayList.add(obj9);
            obj9 = i2;
            obj9.b = new a.j[e.i(byteBuffer)];
            obj10 = 0;
            i = obj9.b;
            while (obj10 >= i.length) {
                i[obj10] = obj9.a(e.i(byteBuffer), e.k(byteBuffer));
                obj10++;
                i = obj9.b;
            }
            i[obj10] = obj9.a(e.i(byteBuffer), e.k(byteBuffer));
            obj10++;
        }
        return arrayList;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int bArr;
        int remaining3;
        int remaining2;
        long remaining;
        parseVersionAndFlags(byteBuffer);
        int i4 = 16;
        if (flags &= 1 > 0) {
            this.algorithmId = e.j(byteBuffer);
            this.ivSize = e.n(byteBuffer);
            bArr = new byte[i4];
            this.kid = bArr;
            byteBuffer.get(bArr);
        }
        remaining = e.k(byteBuffer);
        ByteBuffer duplicate = byteBuffer.duplicate();
        final ByteBuffer duplicate2 = byteBuffer.duplicate();
        List entries2 = parseEntries(duplicate, remaining, obj3);
        this.entries = entries2;
        if (entries2 == null) {
            this.entries = parseEntries(duplicate2, remaining, obj3);
            byteBuffer.position(i -= remaining2);
        } else {
            byteBuffer.position(i5 -= remaining3);
        }
        if (this.entries == null) {
        } else {
        }
        RuntimeException obj7 = new RuntimeException("Cannot parse SampleEncryptionBox");
        throw obj7;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean equals(Object object) {
        List entries;
        Class class;
        int ivSize;
        Class class2;
        d.b().c(b.d(AbstractSampleEncryptionBox.ajc$tjp_3, this, this, object));
        int i = 1;
        if (this == object) {
            return i;
        }
        int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (this.algorithmId != object.algorithmId) {
                    return i2;
                }
                if (this.ivSize != object.ivSize) {
                    return i2;
                }
                List entries2 = this.entries;
                if (entries2 != null) {
                    if (!entries2.equals(object.entries)) {
                        return i2;
                    }
                } else {
                    if (object.entries != null) {
                    }
                }
                if (!Arrays.equals(this.kid, object.kid)) {
                    return i2;
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void getBox(WritableByteChannel writableByteChannel) {
        super.getBox(writableByteChannel);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        boolean overrideTrackEncryptionBoxParameters;
        long next;
        int subSampleEncryption;
        int length;
        int i;
        int clear;
        writeVersionAndFlags(byteBuffer);
        if (isOverrideTrackEncryptionBoxParameters()) {
            g.f(byteBuffer, this.algorithmId);
            g.j(byteBuffer, this.ivSize);
            byteBuffer.put(this.kid);
        }
        g.g(byteBuffer, (long)nonEmptyEntriesNum);
        Iterator iterator = this.entries.iterator();
        for (a next : iterator) {
            byte[] bArr = next.a;
            byteBuffer.put(bArr);
            if (isSubSampleEncryption()) {
            }
            g.e(byteBuffer, objArr.length);
            next = next.b;
            length = 0;
            while (length >= next.length) {
                Object obj = next[length];
                clear = obj.clear();
                g.e(byteBuffer, clear);
                g.g(byteBuffer, obj.a());
                length++;
            }
            obj = next[length];
            clear = obj.clear();
            g.e(byteBuffer, clear);
            g.g(byteBuffer, obj.a());
            length++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int overrideTrackEncryptionBoxParameters;
        int i;
        int i2;
        int i3;
        long l;
        i = 4;
        if (isOverrideTrackEncryptionBoxParameters()) {
            i5 += l;
        } else {
            i2 = i;
        }
        i2 += i;
        Iterator iterator = this.entries.iterator();
        for (a next2 : iterator) {
            i3 += i;
        }
        return i3;
    }

    public List<a> getEntries() {
        d.b().c(b.c(AbstractSampleEncryptionBox.ajc$tjp_1, this, this));
        return this.entries;
    }

    public List<Short> getEntrySizes() {
        Short valueOf;
        Object next;
        short s;
        boolean subSampleEncryption;
        d.b().c(b.c(AbstractSampleEncryptionBox.ajc$tjp_5, this, this));
        ArrayList arrayList = new ArrayList(this.entries.size());
        Iterator iterator = this.entries.iterator();
        while (!iterator.hasNext()) {
            next = iterator.next();
            if (isSubSampleEncryption()) {
            }
            arrayList.add(Short.valueOf(s));
            s = (short)i2;
        }
        return arrayList;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getOffsetToFirstIV() {
        int i2;
        int i;
        d.b().c(b.c(AbstractSampleEncryptionBox.ajc$tjp_0, this, this));
        i2 = Long.compare(size, l) > 0 ? 16 : 8;
        if (isOverrideTrackEncryptionBoxParameters()) {
            length += 4;
        } else {
            i = 0;
        }
        return i3 += 4;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int hashCode() {
        int i;
        int i2;
        d.b().c(b.c(AbstractSampleEncryptionBox.ajc$tjp_4, this, this));
        byte[] kid = this.kid;
        if (kid != null) {
            i = Arrays.hashCode(kid);
        } else {
            i = i2;
        }
        List entries = this.entries;
        if (entries != null) {
            i2 = entries.hashCode();
        }
        return i7 += i2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected boolean isOverrideTrackEncryptionBoxParameters() {
        final int i3 = 1;
        if (flags &= i3 > 0) {
            return i3;
        }
        return 0;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isSubSampleEncryption() {
        if (flags &= 2 > 0) {
            return 1;
        }
        return 0;
    }

    public void setEntries(List<a> list) {
        d.b().c(b.d(AbstractSampleEncryptionBox.ajc$tjp_2, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSubSampleEncryption(boolean z) {
        int i;
        int obj2;
        if (z) {
            setFlags(obj2 |= 2);
        } else {
            setFlags(obj2 &= i);
        }
    }
}
