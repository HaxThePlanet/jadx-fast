package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.a;
import com.googlecode.mp4parser.h.b;
import f.b.a.b;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
public class FreeBox implements com.coremedia.iso.boxes.a {

    static final boolean $assertionsDisabled = false;
    public static final String TYPE = "free";
    ByteBuffer data;
    private long offset;
    private com.coremedia.iso.boxes.b parent;
    List<com.coremedia.iso.boxes.a> replacers;
    static {
    }

    public FreeBox() {
        super();
        LinkedList linkedList = new LinkedList();
        this.replacers = linkedList;
        this.data = ByteBuffer.wrap(new byte[0]);
    }

    public FreeBox(int i) {
        super();
        LinkedList linkedList = new LinkedList();
        this.replacers = linkedList;
        this.data = ByteBuffer.allocate(i);
    }

    @Override // com.coremedia.iso.boxes.a
    public void addAndReplace(com.coremedia.iso.boxes.a a) {
        this.data.position(b.a(a.getSize()));
        this.data = this.data.slice();
        this.replacers.add(a);
    }

    @Override // com.coremedia.iso.boxes.a
    public boolean equals(Object object) {
        ByteBuffer data;
        Class class;
        Class class2;
        boolean obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (getClass() != object.getClass()) {
            } else {
                if (getData() != null) {
                    if (!getData().equals((FreeBox)object.getData())) {
                        return i2;
                    }
                } else {
                    if (object.getData() != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    @Override // com.coremedia.iso.boxes.a
    public void getBox(WritableByteChannel writableByteChannel) {
        Object next;
        Iterator iterator = this.replacers.iterator();
        for (a next : iterator) {
            next.getBox(writableByteChannel);
        }
        int i = 8;
        ByteBuffer allocate = ByteBuffer.allocate(i);
        g.g(allocate, (long)i2);
        allocate.put("free".getBytes());
        allocate.rewind();
        writableByteChannel.write(allocate);
        allocate.rewind();
        this.data.rewind();
        writableByteChannel.write(this.data);
        this.data.rewind();
    }

    @Override // com.coremedia.iso.boxes.a
    public ByteBuffer getData() {
        ByteBuffer data = this.data;
        if (data != null) {
            return (ByteBuffer)data.duplicate().rewind();
        }
        return null;
    }

    @Override // com.coremedia.iso.boxes.a
    public long getOffset() {
        return this.offset;
    }

    @Override // com.coremedia.iso.boxes.a
    public com.coremedia.iso.boxes.b getParent() {
        return this.parent;
    }

    @Override // com.coremedia.iso.boxes.a
    public long getSize() {
        int i;
        long size;
        Iterator iterator = this.replacers.iterator();
        i = 8;
        for (a next2 : iterator) {
            i += size;
        }
        return i += l;
    }

    @Override // com.coremedia.iso.boxes.a
    public String getType() {
        return "free";
    }

    @Override // com.coremedia.iso.boxes.a
    public int hashCode() {
        int i;
        ByteBuffer data = this.data;
        if (data != null) {
            i = data.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    @Override // com.coremedia.iso.boxes.a
    public void parse(a a, ByteBuffer byteBuffer2, long l3, b b4) {
        int i;
        ByteBuffer obj6;
        this.offset = l -= l5;
        if (Long.compare(l3, i) > 0) {
            this.data = a.f1(a.w0(), obj1);
            a.Z1(l4 += l3);
        } else {
            obj6 = ByteBuffer.allocate(b.a(l3));
            this.data = obj6;
            a.read(obj6);
        }
    }

    @Override // com.coremedia.iso.boxes.a
    public void setData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }

    @Override // com.coremedia.iso.boxes.a
    public void setParent(com.coremedia.iso.boxes.b b) {
        this.parent = b;
    }
}
