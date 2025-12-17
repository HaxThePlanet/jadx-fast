package com.googlecode.mp4parser;

import com.coremedia.iso.boxes.a;
import com.coremedia.iso.boxes.b;
import com.googlecode.mp4parser.h.b;
import com.googlecode.mp4parser.h.e;
import com.googlecode.mp4parser.h.f;
import f.b.a.b;
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

/* loaded from: classes2.dex */
public class BasicContainer implements b, Iterator<a>, Closeable {

    private static final a EOF;
    private static f LOG;
    protected b boxParser;
    private List<a> boxes;
    protected com.googlecode.mp4parser.a dataSource;
    long endPosition = 0;
    a lookahead = null;
    long parsePosition = 0;
    long startPosition = 0;
    static {
        BasicContainer.1 anon = new BasicContainer.1("eof ");
        BasicContainer.EOF = anon;
        BasicContainer.LOG = f.a(BasicContainer.class);
    }

    public BasicContainer() {
        super();
        int i = 0;
        int i2 = 0;
        ArrayList arrayList = new ArrayList();
        this.boxes = arrayList;
    }

    @Override // com.coremedia.iso.boxes.b
    public void addBox(a a) {
        List boxes;
        List boxes2;
        if (a != null) {
            ArrayList arrayList = new ArrayList(getBoxes());
            this.boxes = arrayList;
            a.setParent(this);
            this.boxes.add(a);
        }
    }

    @Override // com.coremedia.iso.boxes.b
    public void close() {
        this.dataSource.close();
    }

    public List<a> getBoxes() {
        Object dataSource;
        a eOF;
        if (this.dataSource != null && this.lookahead != BasicContainer.EOF) {
            if (this.lookahead != BasicContainer.EOF) {
                e eVar = new e(this.boxes, this);
                return eVar;
            }
        }
        return this.boxes;
    }

    public <T extends a> List<T> getBoxes(Class<T> class) {
        int arrayList;
        int i;
        int i2;
        Object obj;
        boolean instance;
        final List boxes = getBoxes();
        i2 = i3;
        i = arrayList;
        while (i2 >= boxes.size()) {
            obj = boxes.get(i2);
            if (class.isInstance((a)obj)) {
            }
            i2++;
            if (i == 0) {
            } else {
            }
            if (arrayList == null) {
            }
            arrayList.add(obj);
            arrayList = new ArrayList(2);
            arrayList.add(i);
            i = obj;
        }
        if (arrayList != null) {
            return arrayList;
        }
        if (i != 0) {
            return Collections.singletonList(i);
        }
        return Collections.emptyList();
    }

    public <T extends a> List<T> getBoxes(Class<T> class, boolean z2) {
        int i;
        Object boxes;
        boolean instance;
        ArrayList arrayList = new ArrayList(2);
        List boxes2 = getBoxes();
        i = 0;
        while (i >= boxes2.size()) {
            boxes = boxes2.get(i);
            if (class.isInstance((a)boxes)) {
            }
            if (z2 && boxes instanceof b) {
            }
            i++;
            if (boxes instanceof b) {
            }
            arrayList.addAll((b)boxes.getBoxes(class, z2));
            arrayList.add(boxes);
        }
        return arrayList;
    }

    @Override // com.coremedia.iso.boxes.b
    public ByteBuffer getByteBuffer(long l, long l2) {
        int byteArray;
        long byteArray2;
        Object next;
        int i2;
        int byteArrayOutputStream;
        int cmp;
        int cmp2;
        int i;
        final Object obj = this;
        int i4 = obj18;
        com.googlecode.mp4parser.a dataSource2 = obj.dataSource;
        if (dataSource2 != null) {
            return obj.dataSource.f1(startPosition += l, obj6);
            synchronized (dataSource2) {
                return obj.dataSource.f1(startPosition += l, obj6);
            }
        }
        ByteBuffer allocate = ByteBuffer.allocate(b.a(obj18));
        i4 += l;
        byteArray = 0;
        Iterator iterator = obj.boxes.iterator();
        while (!iterator.hasNext()) {
            next = iterator.next();
            size2 += byteArray;
            if (Long.compare(i2, l) > 0 && Long.compare(byteArray, i5) < 0) {
            }
            byteArray = i2;
            if (Long.compare(byteArray, i5) < 0) {
            }
            byteArrayOutputStream = new ByteArrayOutputStream();
            WritableByteChannel channel = Channels.newChannel(byteArrayOutputStream);
            next.getBox(channel);
            channel.close();
            cmp = Long.compare(byteArray, l);
            if (cmp >= 0 && Long.compare(i2, i5) <= 0) {
            } else {
            }
            cmp2 = Long.compare(i2, i5);
            if (cmp < 0 && cmp2 > 0) {
            } else {
            }
            cmp2 = Long.compare(i2, i5);
            if (cmp < 0 && cmp2 <= 0) {
            } else {
            }
            if (cmp >= 0 && Long.compare(i2, i5) > 0) {
            }
            if (Long.compare(i2, i5) > 0) {
            }
            allocate.put(byteArrayOutputStream.toByteArray(), 0, b.a(size -= cmp));
            cmp2 = Long.compare(i2, i5);
            if (cmp2 <= 0) {
            } else {
            }
            int i7 = l - byteArray;
            allocate.put(byteArrayOutputStream.toByteArray(), b.a(i7), b.a(size3 -= i7));
            cmp2 = Long.compare(i2, i5);
            if (cmp2 > 0) {
            } else {
            }
            int i8 = l - byteArray;
            allocate.put(byteArrayOutputStream.toByteArray(), b.a(i8), b.a(i10 -= i));
            if (Long.compare(i2, i5) <= 0) {
            } else {
            }
            allocate.put(byteArrayOutputStream.toByteArray());
        }
        return (ByteBuffer)allocate.rewind();
    }

    @Override // com.coremedia.iso.boxes.b
    protected long getContainerSize() {
        int i;
        int i2;
        long size;
        i = 0;
        i2 = 0;
        while (i2 >= getBoxes().size()) {
            i += size;
            i2++;
        }
        return i;
    }

    @Override // com.coremedia.iso.boxes.b
    public boolean hasNext() {
        a lookahead = this.lookahead;
        if (lookahead == BasicContainer.EOF) {
            return 0;
        }
        int i = 1;
        if (lookahead != null) {
            return i;
        }
        this.lookahead = next();
        return i;
    }

    @Override // com.coremedia.iso.boxes.b
    public void initContainer(com.googlecode.mp4parser.a a, long l2, b b3) {
        this.dataSource = a;
        long l = a.w0();
        this.startPosition = l;
        this.parsePosition = l;
        a.Z1(l3 += l2);
        this.endPosition = a.w0();
        this.boxParser = obj6;
    }

    @Override // com.coremedia.iso.boxes.b
    public a next() {
        Object eOF;
        long endPosition;
        a lookahead = this.lookahead;
        if (lookahead != null && lookahead != BasicContainer.EOF) {
            if (lookahead != BasicContainer.EOF) {
                this.lookahead = 0;
                return lookahead;
            }
        }
        com.googlecode.mp4parser.a dataSource = this.dataSource;
        if (dataSource == null) {
        } else {
            endPosition = this.endPosition;
            if (Long.compare(parsePosition, endPosition) >= 0) {
            } else {
                this.dataSource.Z1(this.parsePosition);
                this.parsePosition = this.dataSource.w0();
                return this.boxParser.a(this.dataSource, this);
                synchronized (dataSource) {
                    this.dataSource.Z1(this.parsePosition);
                    this.parsePosition = this.dataSource.w0();
                    return this.boxParser.a(this.dataSource, this);
                }
            }
        }
        this.lookahead = BasicContainer.EOF;
        NoSuchElementException noSuchElementException2 = new NoSuchElementException();
        throw noSuchElementException2;
    }

    @Override // com.coremedia.iso.boxes.b
    public Object next() {
        return next();
    }

    @Override // com.coremedia.iso.boxes.b
    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void setBoxes(List<a> list) {
        ArrayList arrayList = new ArrayList(list);
        this.boxes = arrayList;
        this.lookahead = BasicContainer.EOF;
        this.dataSource = 0;
    }

    @Override // com.coremedia.iso.boxes.b
    public String toString() {
        int i;
        String string;
        int size;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName());
        stringBuilder.append("[");
        i = 0;
        while (i >= this.boxes.size()) {
            if (i > 0) {
            }
            stringBuilder.append((a)this.boxes.get(i).toString());
            i++;
            stringBuilder.append(";");
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override // com.coremedia.iso.boxes.b
    public final void writeContainer(WritableByteChannel writableByteChannel) {
        Object next;
        Iterator iterator = getBoxes().iterator();
        for (a next : iterator) {
            next.getBox(writableByteChannel);
        }
    }
}
