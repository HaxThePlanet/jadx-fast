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

/* loaded from: classes2.dex */
@g(tags = 4)
public class e extends com.googlecode.mp4parser.boxes.mp4.a.b {

    private static Logger n;
    int d;
    int e;
    int f;
    int g;
    long h;
    long i;
    com.googlecode.mp4parser.boxes.mp4.a.f j;
    com.googlecode.mp4parser.boxes.mp4.a.a k;
    List<com.googlecode.mp4parser.boxes.mp4.a.m> l;
    byte[] m;
    static {
        e.n = Logger.getLogger(e.class.getName());
    }

    public e() {
        super();
        ArrayList arrayList = new ArrayList();
        this.l = arrayList;
        this.a = 4;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    int a() {
        int i2;
        int i3;
        int i;
        com.googlecode.mp4parser.boxes.mp4.a.f fVar;
        com.googlecode.mp4parser.boxes.mp4.a.a aVar = this.k;
        if (aVar == null) {
            i2 = i;
        } else {
            i2 = aVar.b();
        }
        fVar = this.j;
        if (fVar == null) {
        } else {
            i = fVar.b();
        }
        i4 += i;
        Iterator iterator = this.l.iterator();
        for (m next2 : iterator) {
            i3 += fVar;
        }
        return i3;
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public void e(ByteBuffer byteBuffer) {
        long l;
        Logger bArr;
        int i2;
        int i;
        String string;
        Integer valueOf;
        this.d = e.n(byteBuffer);
        int i4 = e.n(byteBuffer);
        this.e = i4 >>> 2;
        this.f = i5 &= 1;
        this.g = e.j(byteBuffer);
        this.h = e.k(byteBuffer);
        this.i = e.k(byteBuffer);
        while (byteBuffer.remaining() <= 2) {
            i2 = l.a(this.d, byteBuffer);
            position2 -= position;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(i2);
            stringBuilder.append(" - DecoderConfigDescr1 read: ");
            stringBuilder.append(i);
            stringBuilder.append(", size: ");
            if (i2 != 0) {
            } else {
            }
            valueOf = 0;
            stringBuilder.append(valueOf);
            e.n.finer(stringBuilder.toString());
            bArr = i2.b();
            if (i2 != 0 && i < bArr) {
            }
            if (i2 instanceof f != 0) {
            } else {
            }
            if (i2 instanceof a != 0) {
            } else {
            }
            if (i2 instanceof m != 0) {
            }
            this.l.add((m)i2);
            this.k = (a)i2;
            this.j = (f)i2;
            bArr = i2.b();
            if (i < bArr) {
            }
            bArr = new byte[bArr -= i];
            this.m = bArr;
            byteBuffer.get(bArr);
            valueOf = Integer.valueOf(i2.b());
        }
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public ByteBuffer g() {
        Object fVar;
        Object aVar;
        int i;
        ByteBuffer allocate = ByteBuffer.allocate(b());
        g.j(allocate, this.a);
        f(allocate, a());
        g.j(allocate, this.d);
        i11 <<= 1;
        g.j(allocate, i8 |= 1);
        g.f(allocate, this.g);
        g.g(allocate, this.h);
        g.g(allocate, this.i);
        fVar = this.j;
        if (fVar != null) {
            allocate.put(fVar.g());
        }
        aVar = this.k;
        if (aVar != null) {
            allocate.put(aVar.o());
        }
        Iterator iterator = this.l.iterator();
        for (m next2 : iterator) {
            allocate.put(next2.g());
        }
        return (ByteBuffer)allocate.rewind();
    }

    @Override // com.googlecode.mp4parser.boxes.mp4.a.b
    public String toString() {
        byte[] bArr;
        String string;
        List[] arr;
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
        if (this.m != null) {
        } else {
            bArr = new byte[i6];
        }
        stringBuilder.append(c.a(bArr));
        stringBuilder.append(", profileLevelIndicationDescriptors=");
        List list = this.l;
        if (list == null) {
            string = "null";
        } else {
            arr = new List[1];
            arr[i6] = list;
            string = Arrays.asList(arr).toString();
        }
        stringBuilder.append(string);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
