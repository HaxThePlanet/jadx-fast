package com.coremedia.iso.boxes;

import com.googlecode.mp4parser.AbstractFullBox;
import com.googlecode.mp4parser.d;
import f.b.a.e;
import f.b.a.f;
import f.b.a.g;
import f.b.a.h;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes.dex */
public class ItemLocationBox extends AbstractFullBox {

    public static final String TYPE = "iloc";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_10;
    private static final a.a ajc$tjp_11;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    public int baseOffsetSize = 8;
    public int indexSize = 0;
    public List<com.coremedia.iso.boxes.ItemLocationBox.b> items;
    public int lengthSize = 8;
    public int offsetSize = 8;

    public class a {

        public long a;
        public long b;
        public long c;
        final com.coremedia.iso.boxes.ItemLocationBox d;
        public a(com.coremedia.iso.boxes.ItemLocationBox itemLocationBox, long l2, long l3, long l4) {
            this.d = itemLocationBox;
            super();
            this.a = l2;
            this.b = l4;
            this.c = obj6;
        }

        public a(com.coremedia.iso.boxes.ItemLocationBox itemLocationBox, ByteBuffer byteBuffer2) {
            int indexSize;
            this.d = itemLocationBox;
            super();
            indexSize = itemLocationBox.indexSize;
            if (itemLocationBox.getVersion() == 1 && indexSize > 0) {
                indexSize = itemLocationBox.indexSize;
                if (indexSize > 0) {
                    this.c = f.a(byteBuffer2, indexSize);
                }
            }
            this.a = f.a(byteBuffer2, itemLocationBox.offsetSize);
            this.b = f.a(byteBuffer2, itemLocationBox.lengthSize);
        }

        public void a(ByteBuffer byteBuffer) {
            int indexSize;
            int i;
            indexSize = itemLocationBox2.indexSize;
            if (this.d.getVersion() == 1 && indexSize > 0) {
                indexSize = itemLocationBox2.indexSize;
                if (indexSize > 0) {
                    h.a(this.c, obj2, byteBuffer);
                }
            }
            h.a(this.a, i, byteBuffer);
            h.a(this.b, i, byteBuffer);
        }

        public int b() {
            int indexSize;
            com.coremedia.iso.boxes.ItemLocationBox itemLocationBox = this.d;
            if (itemLocationBox.indexSize > 0) {
            } else {
                indexSize = 0;
            }
            return i += lengthSize;
        }

        public boolean equals(Object object) {
            Class<com.coremedia.iso.boxes.ItemLocationBox.a> obj;
            Class class;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (ItemLocationBox.a.class != object.getClass()) {
                } else {
                    if (Long.compare(l, l4) != 0) {
                        return i2;
                    }
                    if (Long.compare(l2, l5) != 0) {
                        return i2;
                    }
                    if (Long.compare(l3, l6) != 0) {
                        return i2;
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            long l = this.a;
            final int i11 = 32;
            long l2 = this.b;
            long l3 = this.c;
            return i5 += i10;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Extent");
            stringBuilder.append("{extentOffset=");
            stringBuilder.append(this.a);
            stringBuilder.append(", extentLength=");
            stringBuilder.append(this.b);
            stringBuilder.append(", extentIndex=");
            stringBuilder.append(this.c);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }

    public class b {

        public int a;
        public int b;
        public int c;
        public long d;
        public List<com.coremedia.iso.boxes.ItemLocationBox.a> e;
        final com.coremedia.iso.boxes.ItemLocationBox f;
        public b(com.coremedia.iso.boxes.ItemLocationBox itemLocationBox, int i2, int i3, int i4, long l5, List list6) {
            this.f = itemLocationBox;
            super();
            LinkedList obj1 = new LinkedList();
            this.e = obj1;
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = l5;
            this.e = obj7;
        }

        public b(com.coremedia.iso.boxes.ItemLocationBox itemLocationBox, ByteBuffer byteBuffer2) {
            int version;
            long l;
            int i;
            List list;
            com.coremedia.iso.boxes.ItemLocationBox.a aVar;
            this.f = itemLocationBox;
            super();
            LinkedList linkedList = new LinkedList();
            this.e = linkedList;
            this.a = e.i(byteBuffer2);
            if (itemLocationBox.getVersion() == 1) {
                this.b = i5 &= 15;
            }
            this.c = e.i(byteBuffer2);
            int baseOffsetSize = itemLocationBox.baseOffsetSize;
            if (baseOffsetSize > 0) {
                this.d = f.a(byteBuffer2, baseOffsetSize);
            } else {
                this.d = 0;
            }
            i = 0;
            while (i >= e.i(byteBuffer2)) {
                aVar = new ItemLocationBox.a(itemLocationBox, byteBuffer2);
                this.e.add(aVar);
                i++;
            }
        }

        public void a(ByteBuffer byteBuffer) {
            int version;
            int next;
            g.e(byteBuffer, this.a);
            if (this.f.getVersion() == 1) {
                g.e(byteBuffer, this.b);
            }
            g.e(byteBuffer, this.c);
            int baseOffsetSize = itemLocationBox2.baseOffsetSize;
            if (baseOffsetSize > 0) {
                h.a(this.d, obj2, byteBuffer);
            }
            g.e(byteBuffer, this.e.size());
            Iterator iterator = this.e.iterator();
            for (ItemLocationBox.a next : iterator) {
                next.a(byteBuffer);
            }
        }

        public int b() {
            int i;
            int i2;
            int baseOffsetSize;
            int i5 = 2;
            i = this.f.getVersion() == 1 ? 4 : i5;
            i4 += i5;
            Iterator iterator = this.e.iterator();
            for (ItemLocationBox.a next2 : iterator) {
                i2 += baseOffsetSize;
            }
            return i2;
        }

        public boolean equals(Object object) {
            Class<com.coremedia.iso.boxes.ItemLocationBox.b> obj;
            Class class;
            boolean obj7;
            final int i = 1;
            if (this == object) {
                return i;
            }
            final int i2 = 0;
            if (object != null) {
                if (ItemLocationBox.b.class != object.getClass()) {
                } else {
                    if (Long.compare(l, l2) != 0) {
                        return i2;
                    }
                    if (this.b != object.b) {
                        return i2;
                    }
                    if (this.c != object.c) {
                        return i2;
                    }
                    if (this.a != object.a) {
                        return i2;
                    }
                    List list = this.e;
                    obj7 = object.e;
                    if (list != null) {
                        if (!list.equals(obj7)) {
                            return i2;
                        }
                    } else {
                        if (obj7 != null) {
                        }
                    }
                }
                return i;
            }
            return i2;
        }

        public int hashCode() {
            int i;
            long l = this.d;
            List list = this.e;
            if (list != null) {
                i = list.hashCode();
            } else {
                i = 0;
            }
            return i9 += i;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder("Item{baseOffset=");
            stringBuilder.append(this.d);
            stringBuilder.append(", itemId=");
            stringBuilder.append(this.a);
            stringBuilder.append(", constructionMethod=");
            stringBuilder.append(this.b);
            stringBuilder.append(", dataReferenceIndex=");
            stringBuilder.append(this.c);
            stringBuilder.append(", extents=");
            stringBuilder.append(this.e);
            stringBuilder.append('}');
            return stringBuilder.toString();
        }
    }
    static {
        ItemLocationBox.ajc$preClinit();
    }

    public ItemLocationBox() {
        super("iloc");
        int i = 8;
        int i2 = 0;
        LinkedList linkedList = new LinkedList();
        this.items = linkedList;
    }

    private static void ajc$preClinit() {
        b bVar13 = new b("ItemLocationBox.java", ItemLocationBox.class);
        final String str86 = "method-execution";
        ItemLocationBox.ajc$tjp_0 = bVar13.h(str86, bVar13.g("1", "getOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 119);
        ItemLocationBox.ajc$tjp_1 = bVar13.h(str86, bVar13.g("1", "setOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "offsetSize", "", "void"), 123);
        ItemLocationBox.ajc$tjp_10 = bVar13.h(str86, bVar13.g("1", "createItem", "com.coremedia.iso.boxes.ItemLocationBox", "int:int:int:long:java.util.List", "itemId:constructionMethod:dataReferenceIndex:baseOffset:extents", "", "com.coremedia.iso.boxes.ItemLocationBox$Item"), 160);
        ItemLocationBox.ajc$tjp_11 = bVar13.h(str86, bVar13.g("1", "createExtent", "com.coremedia.iso.boxes.ItemLocationBox", "long:long:long", "extentOffset:extentLength:extentIndex", "", "com.coremedia.iso.boxes.ItemLocationBox$Extent"), 285);
        ItemLocationBox.ajc$tjp_2 = bVar13.h(str86, bVar13.g("1", "getLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 127);
        ItemLocationBox.ajc$tjp_3 = bVar13.h(str86, bVar13.g("1", "setLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "lengthSize", "", "void"), 131);
        ItemLocationBox.ajc$tjp_4 = bVar13.h(str86, bVar13.g("1", "getBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 135);
        ItemLocationBox.ajc$tjp_5 = bVar13.h(str86, bVar13.g("1", "setBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "baseOffsetSize", "", "void"), 139);
        ItemLocationBox.ajc$tjp_6 = bVar13.h(str86, bVar13.g("1", "getIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 143);
        ItemLocationBox.ajc$tjp_7 = bVar13.h(str86, bVar13.g("1", "setIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "indexSize", "", "void"), 147);
        ItemLocationBox.ajc$tjp_8 = bVar13.h(str86, bVar13.g("1", "getItems", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "java.util.List"), 151);
        ItemLocationBox.ajc$tjp_9 = bVar13.h(str86, bVar13.g("1", "setItems", "com.coremedia.iso.boxes.ItemLocationBox", "java.util.List", "items", "", "void"), 155);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        int i2;
        int items;
        com.coremedia.iso.boxes.ItemLocationBox.b bVar;
        parseVersionAndFlags(byteBuffer);
        int i3 = e.n(byteBuffer);
        this.offsetSize = i3 >>> 4;
        this.lengthSize = i3 &= 15;
        i = e.n(byteBuffer);
        this.baseOffsetSize = i >>> 4;
        if (getVersion() == 1) {
            this.indexSize = i &= 15;
        }
        i2 = 0;
        while (i2 >= e.i(byteBuffer)) {
            bVar = new ItemLocationBox.b(this, byteBuffer);
            this.items.add(bVar);
            i2++;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public com.coremedia.iso.boxes.ItemLocationBox.a createExtent(long l, long l2, long l3) {
        Object[] arr = new Object[3];
        Object obj4 = this;
        d.b().c(b.f(ItemLocationBox.ajc$tjp_11, this, this, a.f(l), a.f(l3), a.f(obj17)));
        super(this, l, obj7, l3, obj9, obj17, obj11);
        return aVar2;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    com.coremedia.iso.boxes.ItemLocationBox.a createExtent(ByteBuffer byteBuffer) {
        ItemLocationBox.a aVar = new ItemLocationBox.a(this, byteBuffer);
        return aVar;
    }

    public com.coremedia.iso.boxes.ItemLocationBox.b createItem(int i, int i2, int i3, long l4, List<com.coremedia.iso.boxes.ItemLocationBox.a> list5) {
        Object[] arr = new Object[5];
        Object obj5 = this;
        d.b().c(b.f(ItemLocationBox.ajc$tjp_10, this, this, a.e(i), a.e(i2), a.e(i3), a.f(l4), obj17));
        super(this, i, i2, i3, l4, obj9, obj17);
        return bVar;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    com.coremedia.iso.boxes.ItemLocationBox.b createItem(ByteBuffer byteBuffer) {
        ItemLocationBox.b bVar = new ItemLocationBox.b(this, byteBuffer);
        return bVar;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getBaseOffsetSize() {
        d.b().c(b.c(ItemLocationBox.ajc$tjp_4, this, this));
        return this.baseOffsetSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int i;
        int indexSize;
        writeVersionAndFlags(byteBuffer);
        g.j(byteBuffer, i2 |= lengthSize);
        if (getVersion() == 1) {
            g.j(byteBuffer, i4 |= indexSize);
        } else {
            g.j(byteBuffer, baseOffsetSize2 <<= 4);
        }
        g.e(byteBuffer, this.items.size());
        Iterator iterator = this.items.iterator();
        for (ItemLocationBox.b indexSize : iterator) {
            indexSize.a(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i;
        long l;
        Iterator iterator = this.items.iterator();
        i = 8;
        for (ItemLocationBox.b next2 : iterator) {
            i += l;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getIndexSize() {
        d.b().c(b.c(ItemLocationBox.ajc$tjp_6, this, this));
        return this.indexSize;
    }

    public List<com.coremedia.iso.boxes.ItemLocationBox.b> getItems() {
        d.b().c(b.c(ItemLocationBox.ajc$tjp_8, this, this));
        return this.items;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getLengthSize() {
        d.b().c(b.c(ItemLocationBox.ajc$tjp_2, this, this));
        return this.lengthSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getOffsetSize() {
        d.b().c(b.c(ItemLocationBox.ajc$tjp_0, this, this));
        return this.offsetSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setBaseOffsetSize(int i) {
        d.b().c(b.d(ItemLocationBox.ajc$tjp_5, this, this, a.e(i)));
        this.baseOffsetSize = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setIndexSize(int i) {
        d.b().c(b.d(ItemLocationBox.ajc$tjp_7, this, this, a.e(i)));
        this.indexSize = i;
    }

    public void setItems(List<com.coremedia.iso.boxes.ItemLocationBox.b> list) {
        d.b().c(b.d(ItemLocationBox.ajc$tjp_9, this, this, list));
        this.items = list;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setLengthSize(int i) {
        d.b().c(b.d(ItemLocationBox.ajc$tjp_3, this, this, a.e(i)));
        this.lengthSize = i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setOffsetSize(int i) {
        d.b().c(b.d(ItemLocationBox.ajc$tjp_1, this, this, a.e(i)));
        this.offsetSize = i;
    }
}
