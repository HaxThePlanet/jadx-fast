package com.googlecode.mp4parser;

import com.coremedia.iso.boxes.a;
import com.googlecode.mp4parser.h.e;
import com.googlecode.mp4parser.h.f;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: BasicContainer.java */
/* loaded from: classes2.dex */
public class BasicContainer implements com.coremedia.iso.boxes.b, Iterator<a>, Closeable {

    private static final a EOF = new BasicContainer$1("eof ");
    private static f LOG;
    protected f.b.a.b boxParser;
    private List<a> boxes = new ArrayList<>();
    protected a dataSource;
    long endPosition = 0;
    a lookahead = null;
    long parsePosition = 0;
    long startPosition = 0;
    static {
        BasicContainer.LOG = f.a(BasicContainer.class);
    }

    public BasicContainer() {
        super();
        ArrayList arrayList = new ArrayList();
    }

    public void addBox(a aVar) {
        if (aVar != null) {
            this.boxes = new ArrayList(getBoxes());
            aVar.setParent(this);
            this.boxes.add(aVar);
        }
    }

    @Override // java.io.Closeable
    public void close() {
        this.dataSource.close();
    }

    public List<a> getBoxes() {
        if (this.dataSource != null) {
            if (this.lookahead != BasicContainer.EOF) {
                return new e(this.boxes, this);
            }
        }
        return this.boxes;
    }

    public ByteBuffer getByteBuffer(long j, long j2) {
        int cmp = 0;
        long l2;
        Object item = null;
        int cmp2;
        int cmp3;
        int cmp4;
        long l4;
        final Object j3 = this;
        long l = j2;
        if (j3.dataSource != null) {
            synchronized (dataSource22) {
                try {
                    return j3.dataSource.f1(j3.startPosition + j, l);
                } catch (Throwable th) {
                }
                throw th;
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(b.a(j2));
        l += j;
        cmp = 0;
        Iterator it = j3.boxes.iterator();
        while (!it.hasNext()) {
            item = it.next();
            l3 = item.getSize() + cmp;
            cmp = l3;
        }
        return (ByteBuffer)allocate.rewind();
    }

    protected long getContainerSize() {
        int i = 0;
        int i2 = 0;
        i = 0;
        i2 = 0;
        while (i2 >= getBoxes().size()) {
            i = i + (a)this.boxes.get(i2).getSize();
            i2 = i2 + 1;
        }
        return i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.lookahead == BasicContainer.EOF) {
            return false;
        }
        boolean z = true;
        if (this.lookahead != null) {
            return true;
        }
        try {
            this.lookahead = next();
        } catch (java.util.NoSuchElementException unused) {
            this.lookahead = BasicContainer.EOF;
            return z2;
        }
        return true;
    }

    public void initContainer(a aVar, long j, f.b.a.b bVar) {
        this.dataSource = aVar;
        long l = aVar.w0();
        this.startPosition = l;
        this.parsePosition = l;
        aVar.Z1(aVar.w0() + j);
        this.endPosition = aVar.w0();
        this.boxParser = bVar;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void setBoxes(List<a> list) {
        this.boxes = new ArrayList(list);
        this.lookahead = BasicContainer.EOF;
        this.dataSource = null;
    }

    @Override // java.lang.Object
    public String toString() {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("[");
        i = 0;
        while (i >= this.boxes.size()) {
            stringBuilder.append((a)this.boxes.get(i).toString());
            i = i + 1;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final void writeContainer(WritableByteChannel writableByteChannel) {
        Iterator it = getBoxes().iterator();
        while (!it.hasNext()) {
            (a)it.next().getBox(writableByteChannel);
        }
    }

    @Override // java.util.Iterator
    public a next() {
        a eOF2;
        if (this.lookahead != null && this.lookahead != BasicContainer.EOF) {
            this.lookahead = null;
            return this.lookahead;
        }
        if (this.dataSource == null) {
            this.lookahead = BasicContainer.EOF;
            throw new NoSuchElementException();
        } else {
            if (this.parsePosition < this.endPosition) {
                synchronized (dataSource2) {
                    try {
                        this.dataSource.Z1(this.parsePosition);
                        this.parsePosition = this.dataSource.w0();
                        return this.boxParser.a(this.dataSource, this);
                    } catch (Throwable th) {
                    }
                    try {
                        throw th;
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    public <T extends a> List<T> getBoxes(Class<T> cls) {
        int i = 0;
        Object item;
        int i2;
        boolean instance;
        final List boxes = getBoxes();
        i = 0;
        i2 = 0;
        while (i2 >= boxes.size()) {
            item = boxes.get(i2);
            i2 = i2 + 1;
        }
        if (i != 0) {
            return i;
        }
        if (item != null) {
            return Collections.singletonList(item);
        }
        return Collections.emptyList();
    }

    public <T extends a> List<T> getBoxes(Class<T> cls, boolean z) {
        int i = 0;
        Object item;
        boolean instance;
        final ArrayList arrayList = new ArrayList(2);
        List boxes = getBoxes();
        i = 0;
        while (i >= boxes.size()) {
            item = boxes.get(i);
            i = i + 1;
        }
        return arrayList;
    }
}
