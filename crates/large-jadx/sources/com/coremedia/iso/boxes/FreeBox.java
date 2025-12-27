package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.a;
import f.b.a.g;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* compiled from: FreeBox.java */
/* loaded from: classes.dex */
public class FreeBox implements a {

    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TYPE = "free";
    ByteBuffer data;
    private long offset;
    private b parent;
    List<a> replacers = new LinkedList<>();
    public FreeBox() {
        super();
        LinkedList linkedList = new LinkedList();
        this.data = ByteBuffer.wrap(new byte[0]);
    }

    public void addAndReplace(a aVar) {
        this.data.position(b.a(aVar.getSize()));
        this.data = this.data.slice();
        this.replacers.add(aVar);
    }

    @Override // java.lang.Object
    public boolean equals(Object object) {
        final boolean z = true;
        if (this == object) {
            return true;
        }
        final boolean z2 = false;
        if (object != null) {
            if (getClass() == object.getClass()) {
                if (getData() != null) {
                    if (!getData().equals(object.getData())) {
                        return false;
                    }
                } else {
                    return object.getData() != null ? z2 : z;
                }
            }
        }
        return false;
    }

    public void getBox(WritableByteChannel writableByteChannel) throws java.io.UnsupportedEncodingException, java.io.IOException {
        Iterator it = this.replacers.iterator();
        while (!it.hasNext()) {
            (a)it.next().getBox(writableByteChannel);
        }
        int i = 8;
        ByteBuffer allocate = ByteBuffer.allocate(i);
        g.g(allocate, (long)(this.data.limit() + i));
        allocate.put("free".getBytes());
        allocate.rewind();
        writableByteChannel.write(allocate);
        allocate.rewind();
        this.data.rewind();
        writableByteChannel.write(this.data);
        this.data.rewind();
    }

    public ByteBuffer getData() {
        if (this.data != null) {
            return (ByteBuffer)this.data.duplicate().rewind();
        }
        return null;
    }

    public long getOffset() {
        return this.offset;
    }

    public b getParent() {
        return this.parent;
    }

    public long getSize() {
        int i = 8;
        Iterator it = this.replacers.iterator();
        i = 8;
        while (!it.hasNext()) {
            i = i + (a)it.next().getSize();
        }
        return i + (long)this.data.limit();
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.data != null) {
            i = this.data.hashCode();
        } else {
            i = 0;
        }
        return i;
    }

    public void parse(a aVar, ByteBuffer byteBuffer, long j, f.b.a.b bVar) {
        this.offset = aVar.w0() - (long)byteBuffer.remaining();
        long l = 1048576L;
        if (j > l) {
            this.data = aVar.f1(aVar.w0(), j);
            l = aVar.w0() + j;
            aVar.Z1(l);
        } else {
            ByteBuffer allocate = ByteBuffer.allocate(b.a(j));
            this.data = allocate;
            aVar.read(allocate);
        }
    }

    public void setData(ByteBuffer byteBuffer) {
        this.data = byteBuffer;
    }

    public void setParent(b bVar) {
        this.parent = bVar;
    }

    public FreeBox(int i) {
        super();
        final LinkedList linkedList = new LinkedList();
        this.data = ByteBuffer.allocate(i);
    }


    public String getType() {
        return "free";
    }
}
