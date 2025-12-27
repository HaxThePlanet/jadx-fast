package com.googlecode.mp4parser.boxes;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import com.mp4parser.iso23001.part7.a;
import com.mp4parser.iso23001.part7.a.j;
import f.b.a.e;
import f.b.a.g;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* compiled from: AbstractSampleEncryptionBox.java */
/* loaded from: classes2.dex */
public abstract class AbstractSampleEncryptionBox extends AbstractFullBox {

    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    protected int algorithmId = -1;
    List<a> entries;
    protected int ivSize = -1;
    protected byte[] kid;
    static {
        AbstractSampleEncryptionBox.ajc$preClinit();
    }

    protected AbstractSampleEncryptionBox(String str) {
        super(str);
        this.kid = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
        this.entries = Collections.emptyList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("AbstractSampleEncryptionBox.java", AbstractSampleEncryptionBox.class);
        final String str44 = "method-execution";
        AbstractSampleEncryptionBox.ajc$tjp_0 = bVar.h(str44, bVar.g("1", "getOffsetToFirstIV", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 29);
        AbstractSampleEncryptionBox.ajc$tjp_1 = bVar.h(str44, bVar.g("1", "getEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 89);
        AbstractSampleEncryptionBox.ajc$tjp_2 = bVar.h(str44, bVar.g("1", "setEntries", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.util.List", "entries", "", "void"), 93);
        AbstractSampleEncryptionBox.ajc$tjp_3 = bVar.h(str44, bVar.g("1", "equals", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "java.lang.Object", "o", "", "boolean"), 173);
        AbstractSampleEncryptionBox.ajc$tjp_4 = bVar.h(str44, bVar.g("1", "hashCode", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "int"), 200);
        AbstractSampleEncryptionBox.ajc$tjp_5 = bVar.h(str44, bVar.g("1", "getEntrySizes", "com.googlecode.mp4parser.boxes.AbstractSampleEncryptionBox", "", "", "", "java.util.List"), 208);
    }

    private int getNonEmptyEntriesNum() {
        int i = 0;
        Iterator it = this.entries.iterator();
        i = 0;
        while (!it.hasNext()) {
        }
        return i;
    }

    private List<a> parseEntries(ByteBuffer byteBuffer, long j, int i) {
        long l2 = 0;
        int length;
        long l3;
        long l;
        final ArrayList arrayList = new ArrayList();
        l = l - 1L;
        l2 = 0L;
        while (l <= l2) {
            try {
                a aVar = new a();
                byte[] bArr = new byte[i];
                aVar.a = bArr;
                byteBuffer.get(bArr);
                i = getFlags() & 2;
                arrayList.add(aVar);
            } catch (java.nio.BufferUnderflowException unused) {
                byteBuffer = null;
                return byteBuffer;
            }
        }
        return arrayList;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        parseVersionAndFlags(byteBuffer);
        i = getFlags() & 1;
        int i5 = 16;
        if (this.getFlags() & 1 > 0) {
            this.algorithmId = e.j(byteBuffer);
            this.ivSize = e.n(byteBuffer);
            byte[] bArr = new byte[i5];
            this.kid = bArr;
            byteBuffer.get(bArr);
        }
        long l = e.k(byteBuffer);
        ByteBuffer duplicate = byteBuffer.duplicate();
        final ByteBuffer duplicate2 = byteBuffer.duplicate();
        List entries2 = parseEntries(duplicate, l, 8);
        this.entries = entries2;
        if (entries2 == null) {
            this.entries = parseEntries(duplicate2, l, i5);
            remaining = (byteBuffer.position() + byteBuffer.remaining()) - duplicate2.remaining();
            byteBuffer.position(remaining);
        } else {
            remaining2 = (byteBuffer.position() + byteBuffer.remaining()) - duplicate.remaining();
            byteBuffer.position(remaining2);
        }
        if (this.entries == null) {
            throw new RuntimeException("Cannot parse SampleEncryptionBox");
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean equals(Object object) {
        d.b().c(b.d(AbstractSampleEncryptionBox.ajc$tjp_3, this, this, object));
        boolean z = true;
        if (this == object) {
            return true;
        }
        boolean z2 = false;
        if (object != null) {
            if (getClass() == object.getClass()) {
                if (this.algorithmId != object.algorithmId) {
                    return false;
                }
                if (this.ivSize != object.ivSize) {
                    return false;
                }
                if (this.entries != null) {
                    if (!this.entries.equals(object.entries)) {
                        return false;
                    }
                }
                return !Arrays.equals(this.kid, object.kid) ? z2 : z;
            }
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void getBox(WritableByteChannel writableByteChannel) {
        super.getBox(writableByteChannel);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int length2;
        int i;
        int clear;
        writeVersionAndFlags(byteBuffer);
        if (isOverrideTrackEncryptionBoxParameters()) {
            g.f(byteBuffer, this.algorithmId);
            g.j(byteBuffer, this.ivSize);
            byteBuffer.put(this.kid);
        }
        g.g(byteBuffer, (long)getNonEmptyEntriesNum());
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            if (item.b() > 0) {
                length2 = bArr.length;
                i = 8;
            }
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        long l2;
        long l3;
        long l = 4L;
        if (isOverrideTrackEncryptionBoxParameters()) {
            length = this.kid.length;
            l4 = (long)length;
            l2 = 8L + l4;
        } else {
            int i3 = l;
        }
        l3 = l2 + 4L;
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            l = (long)(a)it.next().b();
            l3 = l3 + l;
        }
        return l3;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<a> getEntries() {
        d.b().c(b.c(AbstractSampleEncryptionBox.ajc$tjp_1, this, this));
        return this.entries;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<Short> getEntrySizes() {
        short s;
        d.b().c(b.c(AbstractSampleEncryptionBox.ajc$tjp_5, this, this));
        ArrayList arrayList = new ArrayList(this.entries.size());
        Iterator it = this.entries.iterator();
        while (!it.hasNext()) {
            Object item = it.next();
            s = (short)item.a.length;
            arrayList.add(Short.valueOf(s));
        }
        return arrayList;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getOffsetToFirstIV() {
        int i = 16;
        int i2 = 0;
        d.b().c(b.c(AbstractSampleEncryptionBox.ajc$tjp_0, this, this));
        long size = getSize();
        int r0 = size > 4294967296L ? 16 : 8;
        if (this.isOverrideTrackEncryptionBoxParameters()) {
            i2 = this.kid.length + 4;
        } else {
            i2 = 0;
        }
        return (i + i2) + 4;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int hashCode() {
        int i;
        d.b().c(b.c(AbstractSampleEncryptionBox.ajc$tjp_4, this, this));
        i = 0;
        if (this.kid != null) {
            i = Arrays.hashCode(this.kid);
        } else {
        }
        if (this.entries != null) {
            i = this.entries.hashCode();
        }
        return (this.algorithmId * 31) + this.ivSize * 31 + i * 31 + i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected boolean isOverrideTrackEncryptionBoxParameters() {
        final boolean z = true;
        if (getFlags() & z > 0) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public boolean isSubSampleEncryption() {
        if (getFlags() & 2 > 0) {
            return true;
        }
        return false;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setEntries(List<a> list) {
        d.b().c(b.d(AbstractSampleEncryptionBox.ajc$tjp_2, this, this, list));
        this.entries = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setSubSampleEncryption(boolean z) {
        if (z) {
            i2 = getFlags() | 2;
            setFlags(i2);
        } else {
            int i = 16777213;
            i2 = getFlags() & i;
            setFlags(i2);
        }
    }
}
