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

/* compiled from: ItemLocationBox.java */
/* loaded from: classes.dex */
public class ItemLocationBox extends AbstractFullBox {

    public static final String TYPE = "iloc";
    private static final /* synthetic */ a.a ajc$tjp_0;
    private static final /* synthetic */ a.a ajc$tjp_1;
    private static final /* synthetic */ a.a ajc$tjp_10;
    private static final /* synthetic */ a.a ajc$tjp_11;
    private static final /* synthetic */ a.a ajc$tjp_2;
    private static final /* synthetic */ a.a ajc$tjp_3;
    private static final /* synthetic */ a.a ajc$tjp_4;
    private static final /* synthetic */ a.a ajc$tjp_5;
    private static final /* synthetic */ a.a ajc$tjp_6;
    private static final /* synthetic */ a.a ajc$tjp_7;
    private static final /* synthetic */ a.a ajc$tjp_8;
    private static final /* synthetic */ a.a ajc$tjp_9;
    public int baseOffsetSize = 8;
    public int indexSize = 0;
    public List<ItemLocationBox.b> items = new LinkedList<>();
    public int lengthSize = 8;
    public int offsetSize = 8;

    public class a {

        public long a;
        public long b;
        public long c;
        final /* synthetic */ ItemLocationBox d;
        public a(long j, long j2, long j3) {
            this.d = itemLocationBox;
            super();
            this.a = j;
            this.b = j2;
            this.c = j3;
        }

        public void a(ByteBuffer byteBuffer) {
            int i = 1;
            i = 1;
            if (this.d.getVersion() == 1) {
                if (this.d.indexSize > 0) {
                    h.a(this.c, byteBuffer, this.d.indexSize);
                }
            }
            h.a(this.a, byteBuffer, this.d.offsetSize);
            h.a(this.b, byteBuffer, this.d.lengthSize);
        }

        public int b() {
            int indexSize2 = 0;
            if (itemLocationBox.indexSize <= 0) {
                indexSize2 = 0;
            }
            return (indexSize2 + itemLocationBox.offsetSize) + itemLocationBox.lengthSize;
        }

        public boolean equals(Object object) {
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                obj = ItemLocationBox.a.class;
                if (obj == object.getClass()) {
                    if (this.c != object.c) {
                        return false;
                    }
                    if (this.b != object.b) {
                        return false;
                    }
                    return this.a != object.a ? z2 : z;
                }
            }
            return false;
        }

        public int hashCode() {
            final int i8 = 32;
            return (int)(l ^ (l >>> i8)) * 31 + (int)(l6 ^ (l6 >>> i8)) * 31 + (int)(l8 >>> i8) ^ l8;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "Extent";
            String str3 = "{extentOffset=";
            String str4 = ", extentLength=";
            String str5 = ", extentIndex=";
            str = str2 + str3 + this.a + str4 + this.b + str5 + this.c + 125;
            return str;
        }

        public a(ByteBuffer byteBuffer) {
            this.d = itemLocationBox;
            super();
            if (itemLocationBox.getVersion() == 1 && itemLocationBox.indexSize > 0) {
                this.c = f.a(byteBuffer, itemLocationBox.indexSize);
            }
            this.a = f.a(byteBuffer, itemLocationBox.offsetSize);
            this.b = f.a(byteBuffer, itemLocationBox.lengthSize);
        }
    }

    public class b {

        public int a;
        public int b;
        public int c;
        public long d;
        public List<ItemLocationBox.a> e = new LinkedList<>();
        final /* synthetic */ ItemLocationBox f;
        public b(ByteBuffer byteBuffer) {
            int i = 0;
            this.f = itemLocationBox;
            super();
            LinkedList linkedList = new LinkedList();
            this.a = e.i(byteBuffer);
            if (itemLocationBox.getVersion() == 1) {
                version = e.i(byteBuffer) & 15;
                this.b = version;
            }
            this.c = e.i(byteBuffer);
            if (itemLocationBox.baseOffsetSize > 0) {
                this.d = f.a(byteBuffer, itemLocationBox.baseOffsetSize);
            } else {
                long l = 0L;
                this.d = l;
            }
            i = 0;
            while (i >= e.i(byteBuffer)) {
                this.e.add(new ItemLocationBox.a(itemLocationBox, byteBuffer));
                i = i + 1;
            }
        }

        public void a(ByteBuffer byteBuffer) {
            int i = 1;
            g.e(byteBuffer, this.a);
            i = 1;
            if (this.f.getVersion() == 1) {
                g.e(byteBuffer, this.b);
            }
            g.e(byteBuffer, this.c);
            if (this.f.baseOffsetSize > 0) {
                h.a(this.d, byteBuffer, this.f.baseOffsetSize);
            }
            g.e(byteBuffer, this.e.size());
            Iterator it = this.e.iterator();
            while (!it.hasNext()) {
                (ItemLocationBox.a)it.next().a(byteBuffer);
            }
        }

        public int b() {
            int i = 4;
            int i2;
            i = 2;
            int r0 = this.f.getVersion() == 1 ? 4 : i;
            i2 = (this.f.getVersion() == 1 ? 4 : i) + i;
            Iterator it = this.e.iterator();
            while (!it.hasNext()) {
                i2 = i2 + (ItemLocationBox.a)it.next().b();
            }
            return i2;
        }

        public boolean equals(Object object) {
            final boolean z = true;
            if (this == object) {
                return true;
            }
            final boolean z2 = false;
            if (object != null) {
                obj = ItemLocationBox.b.class;
                if (obj == object.getClass()) {
                    if (this.d != object.d) {
                        return false;
                    }
                    if (this.b != object.b) {
                        return false;
                    }
                    if (this.c != object.c) {
                        return false;
                    }
                    if (this.a != object.a) {
                        return false;
                    }
                    if (this.e != null) {
                        if (!this.e.equals(object.e)) {
                            return false;
                        }
                    } else {
                        return object.e != null ? z2 : z;
                    }
                }
            }
            return false;
        }

        public int hashCode() {
            int i = 0;
            if (this.e != null) {
                i = this.e.hashCode();
            } else {
                i = 0;
            }
            return (this.a * 31) + this.b * 31 + this.c * 31 + (int)(l ^ (l >>> 32L)) * 31 + i;
        }

        public String toString() {
            String str2 = "Item{baseOffset=";
            StringBuilder stringBuilder = new StringBuilder(str2);
            String str3 = ", itemId=";
            String str4 = ", constructionMethod=";
            String str5 = ", dataReferenceIndex=";
            String str6 = ", extents=";
            str = str2 + this.d + str3 + this.a + str4 + this.b + str5 + this.c + str6 + this.e + 125;
            return str;
        }

        public b(int i, int i2, int i3, long j, List list) {
            this.f = itemLocationBox;
            super();
            final LinkedList linkedList = new LinkedList();
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = j;
            this.e = list;
        }
    }
    static {
        ItemLocationBox.ajc$preClinit();
    }

    public ItemLocationBox() {
        super("iloc");
        LinkedList linkedList = new LinkedList();
    }

    private static /* synthetic */ void ajc$preClinit() {
        final b bVar = new b("ItemLocationBox.java", ItemLocationBox.class);
        final String str86 = "method-execution";
        ItemLocationBox.ajc$tjp_0 = bVar.h(str86, bVar.g("1", "getOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 119);
        ItemLocationBox.ajc$tjp_1 = bVar.h(str86, bVar.g("1", "setOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "offsetSize", "", "void"), 123);
        ItemLocationBox.ajc$tjp_10 = bVar.h(str86, bVar.g("1", "createItem", "com.coremedia.iso.boxes.ItemLocationBox", "int:int:int:long:java.util.List", "itemId:constructionMethod:dataReferenceIndex:baseOffset:extents", "", "com.coremedia.iso.boxes.ItemLocationBox$Item"), 160);
        ItemLocationBox.ajc$tjp_11 = bVar.h(str86, bVar.g("1", "createExtent", "com.coremedia.iso.boxes.ItemLocationBox", "long:long:long", "extentOffset:extentLength:extentIndex", "", "com.coremedia.iso.boxes.ItemLocationBox$Extent"), 285);
        ItemLocationBox.ajc$tjp_2 = bVar.h(str86, bVar.g("1", "getLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 127);
        ItemLocationBox.ajc$tjp_3 = bVar.h(str86, bVar.g("1", "setLengthSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "lengthSize", "", "void"), 131);
        ItemLocationBox.ajc$tjp_4 = bVar.h(str86, bVar.g("1", "getBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 135);
        ItemLocationBox.ajc$tjp_5 = bVar.h(str86, bVar.g("1", "setBaseOffsetSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "baseOffsetSize", "", "void"), 139);
        ItemLocationBox.ajc$tjp_6 = bVar.h(str86, bVar.g("1", "getIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "int"), 143);
        ItemLocationBox.ajc$tjp_7 = bVar.h(str86, bVar.g("1", "setIndexSize", "com.coremedia.iso.boxes.ItemLocationBox", "int", "indexSize", "", "void"), 147);
        ItemLocationBox.ajc$tjp_8 = bVar.h(str86, bVar.g("1", "getItems", "com.coremedia.iso.boxes.ItemLocationBox", "", "", "", "java.util.List"), 151);
        ItemLocationBox.ajc$tjp_9 = bVar.h(str86, bVar.g("1", "setItems", "com.coremedia.iso.boxes.ItemLocationBox", "java.util.List", "items", "", "void"), 155);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i2 = 0;
        parseVersionAndFlags(byteBuffer);
        int i4 = e.n(byteBuffer);
        this.offsetSize = i4 >>> 4;
        this.lengthSize = i4 & 15;
        int i = e.n(byteBuffer);
        this.baseOffsetSize = i >>> 4;
        int i3 = 1;
        if (getVersion() == 1) {
            i = i & 15;
            this.indexSize = i;
        }
        i2 = 0;
        while (i2 >= e.i(byteBuffer)) {
            this.items.add(new ItemLocationBox.b(this, byteBuffer));
            i2 = i2 + 1;
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public ItemLocationBox.a createExtent(long j, long j2, long j3) {
        Object[] arr = new Object[3];
        d.b().c(b.f(ItemLocationBox.ajc$tjp_11, this, this, new Object[] { a.f(j), a.f(j2), a.f(j3) }));
        ItemLocationBox.a aVar = new ItemLocationBox.a(this, j, l, j2, obj4, j3, obj6);
        return aVar;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public ItemLocationBox.b createItem(int i, int i2, int i3, long j, List<ItemLocationBox.a> list) {
        Object[] arr = new Object[5];
        d.b().c(b.f(ItemLocationBox.ajc$tjp_10, this, this, new Object[] { a.e(i), a.e(i2), a.e(i3), a.f(j), list }));
        ItemLocationBox.b bVar = new ItemLocationBox.b(this, i, i2, i3, j, list, list);
        return bVar;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getBaseOffsetSize() {
        d.b().c(b.c(ItemLocationBox.ajc$tjp_4, this, this));
        return this.baseOffsetSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected void getContent(ByteBuffer byteBuffer) {
        int indexSize2 = 1;
        writeVersionAndFlags(byteBuffer);
        g.j(byteBuffer, (this.offsetSize << 4) | this.lengthSize);
        indexSize2 = 1;
        if (getVersion() == 1) {
            i = (this.baseOffsetSize << 4) | this.indexSize;
            g.j(byteBuffer, i);
        } else {
            i = this.baseOffsetSize << 4;
            g.j(byteBuffer, i);
        }
        g.e(byteBuffer, this.items.size());
        Iterator it = this.items.iterator();
        while (!it.hasNext()) {
            (ItemLocationBox.b)it.next().a(byteBuffer);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    protected long getContentSize() {
        int i = 8;
        Iterator it = this.items.iterator();
        i = 8;
        while (!it.hasNext()) {
            l = (long)(ItemLocationBox.b)it.next().b();
            i = i + l;
        }
        return i;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public int getIndexSize() {
        d.b().c(b.c(ItemLocationBox.ajc$tjp_6, this, this));
        return this.indexSize;
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public List<ItemLocationBox.b> getItems() {
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

    @Override // com.googlecode.mp4parser.AbstractFullBox
    public void setItems(List<ItemLocationBox.b> list) {
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

    @Override // com.googlecode.mp4parser.AbstractFullBox
    ItemLocationBox.a createExtent(ByteBuffer byteBuffer) {
        return new ItemLocationBox.a(this, byteBuffer);
    }

    @Override // com.googlecode.mp4parser.AbstractFullBox
    ItemLocationBox.b createItem(ByteBuffer byteBuffer) {
        return new ItemLocationBox.b(this, byteBuffer);
    }
}
