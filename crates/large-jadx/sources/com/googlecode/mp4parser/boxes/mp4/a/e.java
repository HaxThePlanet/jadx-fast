package com.googlecode.mp4parser.boxes.mp4.a;

import f.b.a.c;
import f.b.a.e;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

/* compiled from: DecoderConfigDescriptor.java */
@g(tags = 4)
/* loaded from: classes2.dex */
public class e extends b {

    private static Logger n;
    int d;
    int e;
    int f;
    int g;
    long h;
    long i;
    f j;
    a k;
    List<m> l = new ArrayList<>();
    byte[] m;
    static {
        e.n = Logger.getLogger(e.class.getName());
    }

    public e() {
        super();
        ArrayList arrayList = new ArrayList();
        this.a = 4;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        int i;
        int i2;
        i = 0;
        if (this.k == null) {
        } else {
            i = this.k.b();
        }
        if (this.j != null) {
            i = this.j.b();
        }
        i2 = (i + 13) + i;
        Iterator it = this.l.iterator();
        while (!it.hasNext()) {
            i2 = i2 + (m)it.next().b();
        }
        return i2;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        String str2 = null;
        this.d = e.n(byteBuffer);
        int i4 = e.n(byteBuffer);
        i = i4 >>> 2;
        this.e = i;
        this.f = (i4 >> 1) & 1;
        this.g = e.j(byteBuffer);
        this.h = e.k(byteBuffer);
        this.i = e.k(byteBuffer);
        while (byteBuffer.remaining() <= 2) {
            com.googlecode.mp4parser.boxes.mp4.a.b bVar = l.a(this.d, byteBuffer);
            i2 = byteBuffer.position() - byteBuffer.position();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(bVar);
            stringBuilder.append(" - DecoderConfigDescr1 read: ");
            stringBuilder.append(i2);
            stringBuilder.append(", size: ");
            stringBuilder.append(str2);
            e.n.finer(stringBuilder.toString());
            l = bVar instanceof f;
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public ByteBuffer g() {
        ByteBuffer allocate = ByteBuffer.allocate(b());
        g.j(allocate, this.a);
        f(allocate, a());
        g.j(allocate, this.d);
        i = this.f << 1;
        g.j(allocate, (this.e << 2) | i | 1);
        g.f(allocate, this.g);
        g.g(allocate, this.h);
        g.g(allocate, this.i);
        if (this.j != null) {
            allocate.put(this.j.g());
        }
        if (this.k != null) {
            allocate.put(this.k.o());
        }
        Iterator it = this.l.iterator();
        while (!it.hasNext()) {
            allocate.put((m)it.next().g());
        }
        return (ByteBuffer)allocate.rewind();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public String toString() {
        byte[] bArr;
        String object;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DecoderConfigDescriptor");
        stringBuilder.append("{objectTypeIndication=");
        stringBuilder.append(this.d);
        stringBuilder.append(", streamType=");
        stringBuilder.append(this.e);
        stringBuilder.append(", upStream=");
        stringBuilder.append(this.f);
        stringBuilder.append(", bufferSizeDB=");
        stringBuilder.append(this.g);
        stringBuilder.append(", maxBitRate=");
        stringBuilder.append(this.h);
        stringBuilder.append(", avgBitRate=");
        stringBuilder.append(this.i);
        stringBuilder.append(", decoderSpecificInfo=");
        stringBuilder.append(this.j);
        stringBuilder.append(", audioSpecificInfo=");
        stringBuilder.append(this.k);
        stringBuilder.append(", configDescriptorDeadBytes=");
        final int i6 = 0;
        if (this.m == null) {
            bArr = new byte[i6];
        }
        stringBuilder.append(c.a(bArr));
        stringBuilder.append(", profileLevelIndicationDescriptors=");
        if (this.l == null) {
            object = "null";
        } else {
            List[] arr = new List[1];
            object = Arrays.asList(new List[] { list }).toString();
        }
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
