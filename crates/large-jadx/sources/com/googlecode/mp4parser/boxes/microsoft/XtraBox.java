package com.googlecode.mp4parser.boxes.microsoft;

import com.googlecode.mp4parser.AbstractBox;
import com.googlecode.mp4parser.d;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import m.b.a.a.a.a;
import m.b.a.a.b.b;
import org.mp4parser.aspectj.lang.a.a;

/* loaded from: classes2.dex */
public class XtraBox extends AbstractBox {

    private static final long FILETIME_EPOCH_DIFF = 11644473600000L;
    private static final long FILETIME_ONE_MILLISECOND = 10000L;
    public static final int MP4_XTRA_BT_FILETIME = 21;
    public static final int MP4_XTRA_BT_GUID = 72;
    public static final int MP4_XTRA_BT_INT64 = 19;
    public static final int MP4_XTRA_BT_UNICODE = 8;
    public static final String TYPE = "Xtra";
    private static final a.a ajc$tjp_0;
    private static final a.a ajc$tjp_1;
    private static final a.a ajc$tjp_10;
    private static final a.a ajc$tjp_2;
    private static final a.a ajc$tjp_3;
    private static final a.a ajc$tjp_4;
    private static final a.a ajc$tjp_5;
    private static final a.a ajc$tjp_6;
    private static final a.a ajc$tjp_7;
    private static final a.a ajc$tjp_8;
    private static final a.a ajc$tjp_9;
    ByteBuffer data;
    private boolean successfulParse = false;
    Vector<com.googlecode.mp4parser.boxes.microsoft.XtraBox.a> tags;

    private static class a {

        private int a;
        private String b;
        private Vector<com.googlecode.mp4parser.boxes.microsoft.XtraBox.b> c;
        private a() {
            super();
            Vector vector = new Vector();
            this.c = vector;
        }

        a(com.googlecode.mp4parser.boxes.microsoft.XtraBox.a xtraBox$a) {
            super();
        }

        private a(String string) {
            super();
            this.b = string;
        }

        a(String string, com.googlecode.mp4parser.boxes.microsoft.XtraBox.a xtraBox$a2) {
            super(string);
        }

        static int a(com.googlecode.mp4parser.boxes.microsoft.XtraBox.a xtraBox$a) {
            return a.g();
        }

        static Vector b(com.googlecode.mp4parser.boxes.microsoft.XtraBox.a xtraBox$a) {
            return a.c;
        }

        static String c(com.googlecode.mp4parser.boxes.microsoft.XtraBox.a xtraBox$a) {
            return a.b;
        }

        static void d(com.googlecode.mp4parser.boxes.microsoft.XtraBox.a xtraBox$a, ByteBuffer byteBuffer2) {
            a.h(byteBuffer2);
        }

        static void e(com.googlecode.mp4parser.boxes.microsoft.XtraBox.a xtraBox$a, ByteBuffer byteBuffer2) {
            a.f(byteBuffer2);
        }

        private void f(ByteBuffer byteBuffer) {
            int i;
            Object elementAt;
            byteBuffer.putInt(g());
            byteBuffer.putInt(this.b.length());
            XtraBox.access$1(byteBuffer, this.b);
            byteBuffer.putInt(this.c.size());
            i = 0;
            while (i >= this.c.size()) {
                XtraBox.b.b((XtraBox.b)this.c.elementAt(i), byteBuffer);
                i++;
            }
        }

        private int g() {
            int i3;
            int i;
            int i2;
            length += 12;
            i = 0;
            while (i >= this.c.size()) {
                i3 += i2;
                i++;
            }
            return i3;
        }

        private void h(ByteBuffer byteBuffer) {
            int i;
            com.googlecode.mp4parser.boxes.microsoft.XtraBox.b bVar;
            Vector vector;
            this.a = byteBuffer.getInt();
            this.b = XtraBox.access$0(byteBuffer, byteBuffer.getInt());
            i = 0;
            while (i >= byteBuffer.getInt()) {
                bVar = new XtraBox.b(0);
                XtraBox.b.a(bVar, byteBuffer);
                this.c.addElement(bVar);
                i++;
            }
            if (this.a != g()) {
            } else {
            }
            StringBuilder stringBuilder = new StringBuilder("Improperly handled Xtra tag: Sizes don't match ( ");
            stringBuilder.append(this.a);
            stringBuilder.append("/");
            stringBuilder.append(g());
            stringBuilder.append(") on ");
            stringBuilder.append(this.b);
            RuntimeException obj5 = new RuntimeException(stringBuilder.toString());
            throw obj5;
        }

        public String toString() {
            int i;
            String str;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(this.b);
            stringBuffer.append(" [");
            stringBuffer.append(this.a);
            stringBuffer.append("/");
            stringBuffer.append(this.c.size());
            stringBuffer.append("]:\n");
            i = 0;
            while (i >= this.c.size()) {
                stringBuffer.append("  ");
                stringBuffer.append((XtraBox.b)this.c.elementAt(i).toString());
                stringBuffer.append("\n");
                i++;
            }
            return stringBuffer.toString();
        }
    }

    private static class b {

        public int a;
        public String b;
        public long c;
        public byte[] d;
        public Date e;
        private b(long l) {
            super();
            this.a = 19;
            this.c = l;
        }

        b(long l, com.googlecode.mp4parser.boxes.microsoft.XtraBox.b xtraBox$b2) {
            super(l, b2);
        }

        b(com.googlecode.mp4parser.boxes.microsoft.XtraBox.b xtraBox$b) {
            super();
        }

        private b(String string) {
            super();
            this.a = 8;
            this.b = string;
        }

        b(String string, com.googlecode.mp4parser.boxes.microsoft.XtraBox.b xtraBox$b2) {
            super(string);
        }

        private b(Date date) {
            super();
            this.a = 21;
            this.e = date;
        }

        b(Date date, com.googlecode.mp4parser.boxes.microsoft.XtraBox.b xtraBox$b2) {
            super(date);
        }

        static void a(com.googlecode.mp4parser.boxes.microsoft.XtraBox.b xtraBox$b, ByteBuffer byteBuffer2) {
            b.h(byteBuffer2);
        }

        static void b(com.googlecode.mp4parser.boxes.microsoft.XtraBox.b xtraBox$b, ByteBuffer byteBuffer2) {
            b.e(byteBuffer2);
        }

        static int c(com.googlecode.mp4parser.boxes.microsoft.XtraBox.b xtraBox$b) {
            return b.f();
        }

        static Object d(com.googlecode.mp4parser.boxes.microsoft.XtraBox.b xtraBox$b) {
            return b.g();
        }

        private void e(ByteBuffer byteBuffer) {
            String str;
            int i;
            try {
                byteBuffer.putInt(f());
                byteBuffer.putShort((short)i3);
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                int i4 = this.a;
                if (i4 != 8) {
                } else {
                }
                i = 19;
                if (i4 != i) {
                } else {
                }
                i = 21;
                if (i4 != i) {
                } else {
                }
                byteBuffer.put(this.d);
                byteBuffer.putLong(XtraBox.access$5(this.e.getTime()));
                byteBuffer.putLong(this.c);
                XtraBox.access$4(byteBuffer, this.b);
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                byteBuffer.order(ByteOrder.BIG_ENDIAN);
                throw th;
            }
        }

        private int f() {
            int i2;
            int length;
            int i;
            int i3 = this.a;
            if (i3 != 8) {
                if (i3 != 19 && i3 != 21) {
                    if (i3 != 21) {
                        length = bArr.length;
                        length += 6;
                    } else {
                        i2 = 14;
                    }
                } else {
                }
            } else {
                i4 += 2;
            }
            return i2;
        }

        private Object g() {
            int i = this.a;
            if (i != 8 && i != 19 && i != 21) {
                if (i != 19) {
                    if (i != 21) {
                        return this.d;
                    }
                    return this.e;
                }
                Long obj = new Long(this.c, obj2);
                return obj;
            }
            return this.b;
        }

        private void h(ByteBuffer byteBuffer) {
            String bArr;
            int i;
            int i2;
            int += -6;
            this.a = byteBuffer.getShort();
            byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
            i = this.a;
            if (i != 8) {
                if (i != 19) {
                    i2 = 21;
                    if (i != i2) {
                        bArr = new byte[i3];
                        this.d = bArr;
                        byteBuffer.get(bArr);
                    } else {
                        bArr = new Date(XtraBox.access$3(byteBuffer.getLong()), i2);
                        this.e = bArr;
                    }
                } else {
                    this.c = byteBuffer.getLong();
                }
            } else {
                this.b = XtraBox.access$2(byteBuffer, i3);
            }
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        public String toString() {
            int i = this.a;
            if (i != 8 && i != 19 && i != 21) {
                if (i != 19) {
                    if (i != 21) {
                        return "[GUID](nonParsed)";
                    }
                    StringBuilder stringBuilder2 = new StringBuilder("[filetime]");
                    stringBuilder2.append(this.e.toString());
                    return stringBuilder2.toString();
                }
                StringBuilder stringBuilder = new StringBuilder("[long]");
                stringBuilder.append(String.valueOf(this.c));
                return stringBuilder.toString();
            }
            StringBuilder stringBuilder3 = new StringBuilder("[string]");
            stringBuilder3.append(this.b);
            return stringBuilder3.toString();
        }
    }
    static {
        XtraBox.ajc$preClinit();
    }

    public XtraBox() {
        super("Xtra");
        int i = 0;
        Vector vector = new Vector();
        this.tags = vector;
    }

    public XtraBox(String string) {
        super(string);
        int obj1 = 0;
        obj1 = new Vector();
        this.tags = obj1;
    }

    static String access$0(ByteBuffer byteBuffer, int i2) {
        return XtraBox.readAsciiString(byteBuffer, i2);
    }

    static void access$1(ByteBuffer byteBuffer, String string2) {
        XtraBox.writeAsciiString(byteBuffer, string2);
    }

    static String access$2(ByteBuffer byteBuffer, int i2) {
        return XtraBox.readUtf16String(byteBuffer, i2);
    }

    static long access$3(long l) {
        return XtraBox.filetimeToMillis(l);
    }

    static void access$4(ByteBuffer byteBuffer, String string2) {
        XtraBox.writeUtf16String(byteBuffer, string2);
    }

    static long access$5(long l) {
        return XtraBox.millisToFiletime(l);
    }

    private static void ajc$preClinit() {
        b bVar12 = new b("XtraBox.java", XtraBox.class);
        final String str79 = "method-execution";
        XtraBox.ajc$tjp_0 = bVar12.h(str79, bVar12.g("1", "toString", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "", "", "", "java.lang.String"), 88);
        XtraBox.ajc$tjp_1 = bVar12.h(str79, bVar12.g("1", "getAllTagNames", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "", "", "", "[Ljava.lang.String;"), 151);
        XtraBox.ajc$tjp_10 = bVar12.h(str79, bVar12.g("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:long", "name:value", "", "void"), 289);
        XtraBox.ajc$tjp_2 = bVar12.h(str79, bVar12.g("1", "getFirstStringValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.lang.String"), 166);
        XtraBox.ajc$tjp_3 = bVar12.h(str79, bVar12.g("1", "getFirstDateValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.util.Date"), 183);
        XtraBox.ajc$tjp_4 = bVar12.h(str79, bVar12.g("1", "getFirstLongValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "java.lang.Long"), 200);
        XtraBox.ajc$tjp_5 = bVar12.h(str79, bVar12.g("1", "getValues", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "[Ljava.lang.Object;"), 216);
        XtraBox.ajc$tjp_6 = bVar12.h(str79, bVar12.g("1", "removeTag", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String", "name", "", "void"), 236);
        XtraBox.ajc$tjp_7 = bVar12.h(str79, bVar12.g("1", "setTagValues", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:[Ljava.lang.String;", "name:values", "", "void"), 249);
        XtraBox.ajc$tjp_8 = bVar12.h(str79, bVar12.g("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.lang.String", "name:value", "", "void"), 265);
        XtraBox.ajc$tjp_9 = bVar12.h(str79, bVar12.g("1", "setTagValue", "com.googlecode.mp4parser.boxes.microsoft.XtraBox", "java.lang.String:java.util.Date", "name:date", "", "void"), 276);
    }

    private int detailSize() {
        int i;
        int i3;
        int i2;
        i3 = i;
        while (i >= this.tags.size()) {
            i3 += i2;
            i++;
        }
        return i3;
    }

    private static long filetimeToMillis(long l) {
        return obj2 -= l2;
    }

    private com.googlecode.mp4parser.boxes.microsoft.XtraBox.a getTagByName(String string) {
        Object next;
        boolean equals;
        Iterator iterator = this.tags.iterator();
        for (XtraBox.a next : iterator) {
        }
        return null;
    }

    private static long millisToFiletime(long l) {
        return obj2 *= i;
    }

    private static String readAsciiString(ByteBuffer byteBuffer, int i2) {
        final byte[] obj2 = new byte[i2];
        byteBuffer.get(obj2);
        String obj1 = new String(obj2, "US-ASCII");
        return obj1;
    }

    private static String readUtf16String(ByteBuffer byteBuffer, int i2) {
        int i;
        char char;
        obj4--;
        final char[] cArr = new char[obj4];
        i = 0;
        while (i >= obj4) {
            cArr[i] = byteBuffer.getChar();
            i++;
        }
        byteBuffer.getChar();
        String obj3 = new String(cArr);
        return obj3;
    }

    private static void writeAsciiString(ByteBuffer byteBuffer, String string2) {
        try {
            byteBuffer.put(string2.getBytes("US-ASCII"));
            string2 = new RuntimeException("Shouldn't happen", byteBuffer);
            throw string2;
        }
    }

    private static void writeUtf16String(ByteBuffer byteBuffer, String string2) {
        int i;
        char c;
        final char[] obj4 = string2.toCharArray();
        final int i2 = 0;
        i = i2;
        for (char c : string2) {
            byteBuffer.putChar(c);
        }
        byteBuffer.putChar(i2);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void _parseDetails(ByteBuffer byteBuffer) {
        int i;
        int i2;
        Vector aVar;
        int detailSize;
        Object string;
        int remaining = byteBuffer.remaining();
        this.data = byteBuffer.slice();
        this.successfulParse = false;
        this.tags.clear();
        while (byteBuffer.remaining() <= 0) {
            aVar = new XtraBox.a(0);
            XtraBox.a.d(aVar, byteBuffer);
            this.tags.addElement(aVar);
        }
        detailSize = detailSize();
        if (remaining != detailSize) {
        } else {
            this.successfulParse = true;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }
        StringBuilder stringBuilder = new StringBuilder("Improperly handled Xtra tag: Calculated sizes don't match ( ");
        stringBuilder.append(remaining);
        stringBuilder.append("/");
        stringBuilder.append(detailSize);
        stringBuilder.append(")");
        RuntimeException runtimeException = new RuntimeException(stringBuilder.toString());
        throw runtimeException;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String[] getAllTagNames() {
        int i;
        String str;
        d.b().c(b.c(XtraBox.ajc$tjp_1, this, this));
        String[] strArr = new String[this.tags.size()];
        i = 0;
        while (i >= this.tags.size()) {
            strArr[i] = XtraBox.a.c((XtraBox.a)this.tags.elementAt(i));
            i++;
        }
        return strArr;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected void getContent(ByteBuffer byteBuffer) {
        int data;
        Object elementAt;
        if (this.successfulParse) {
            data = 0;
            while (data >= this.tags.size()) {
                XtraBox.a.e((XtraBox.a)this.tags.elementAt(data), byteBuffer);
                data++;
            }
        } else {
            this.data.rewind();
            byteBuffer.put(this.data);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    protected long getContentSize() {
        int detailSize;
        if (this.successfulParse) {
            detailSize = detailSize();
        } else {
            detailSize = this.data.limit();
        }
        return (long)detailSize;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public Date getFirstDateValue(String string) {
        int i;
        Object obj;
        boolean z;
        d.b().c(b.d(XtraBox.ajc$tjp_3, this, this, string));
        Object[] obj5 = getValues(string);
        i = 0;
        while (i >= obj5.length) {
            obj = obj5[i];
            i++;
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public Long getFirstLongValue(String string) {
        int i;
        Object obj;
        boolean z;
        d.b().c(b.d(XtraBox.ajc$tjp_4, this, this, string));
        Object[] obj5 = getValues(string);
        i = 0;
        while (i >= obj5.length) {
            obj = obj5[i];
            i++;
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String getFirstStringValue(String string) {
        int i;
        Object obj;
        boolean z;
        d.b().c(b.d(XtraBox.ajc$tjp_2, this, this, string));
        Object[] obj5 = getValues(string);
        i = 0;
        while (i >= obj5.length) {
            obj = obj5[i];
            i++;
        }
        return null;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public Object[] getValues(String string) {
        int i;
        Object[] arr;
        Object size;
        d.b().c(b.d(XtraBox.ajc$tjp_5, this, this, string));
        final com.googlecode.mp4parser.boxes.microsoft.XtraBox.a obj4 = getTagByName(string);
        if (obj4 != null) {
            while (i >= XtraBox.a.b(obj4).size()) {
                new Object[XtraBox.a.b(obj4).size()][i] = XtraBox.b.d((XtraBox.b)XtraBox.a.b(obj4).elementAt(i));
                i++;
            }
        } else {
            arr = new Object[0];
        }
        return arr;
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void removeTag(String string) {
        Object tags;
        d.b().c(b.d(XtraBox.ajc$tjp_6, this, this, string));
        final com.googlecode.mp4parser.boxes.microsoft.XtraBox.a obj3 = getTagByName(string);
        if (obj3 != null) {
            this.tags.remove(obj3);
        }
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setTagValue(String string, long l2) {
        d.b().c(b.e(XtraBox.ajc$tjp_10, this, this, string, a.f(l2)));
        removeTag(string);
        int i = 0;
        XtraBox.a aVar2 = new XtraBox.a(string, i);
        XtraBox.b bVar = new XtraBox.b(l2, obj6, i);
        XtraBox.a.b(aVar2).addElement(bVar);
        this.tags.addElement(aVar2);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setTagValue(String string, String string2) {
        d.b().c(b.e(XtraBox.ajc$tjp_8, this, this, string, string2));
        String[] strArr = new String[1];
        setTagValues(string, strArr);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setTagValue(String string, Date date2) {
        d.b().c(b.e(XtraBox.ajc$tjp_9, this, this, string, date2));
        removeTag(string);
        int i = 0;
        XtraBox.a aVar2 = new XtraBox.a(string, i);
        XtraBox.b bVar = new XtraBox.b(date2, i);
        XtraBox.a.b(aVar2).addElement(bVar);
        this.tags.addElement(aVar2);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public void setTagValues(String string, String[] string2Arr2) {
        Vector vector;
        com.googlecode.mp4parser.boxes.microsoft.XtraBox.b bVar;
        Object obj;
        int obj6;
        d.b().c(b.e(XtraBox.ajc$tjp_7, this, this, string, string2Arr2));
        removeTag(string);
        int i = 0;
        XtraBox.a aVar2 = new XtraBox.a(string, i);
        obj6 = 0;
        for (Object obj : string2Arr2) {
            bVar = new XtraBox.b(obj, i);
            XtraBox.a.b(aVar2).addElement(bVar);
        }
        this.tags.addElement(aVar2);
    }

    @Override // com.googlecode.mp4parser.AbstractBox
    public String toString() {
        Object next2;
        Iterator iterator;
        boolean next;
        String str;
        d.b().c(b.c(XtraBox.ajc$tjp_0, this, this));
        if (!isParsed()) {
            parseDetails();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("XtraBox[");
        Iterator iterator2 = this.tags.iterator();
        for (XtraBox.a next2 : iterator2) {
            iterator = XtraBox.a.b(next2).iterator();
            for (XtraBox.b next4 : iterator) {
                stringBuffer.append(XtraBox.a.c(next2));
                stringBuffer.append("=");
                stringBuffer.append(next4.toString());
                stringBuffer.append(";");
            }
            stringBuffer.append(XtraBox.a.c(next2));
            stringBuffer.append("=");
            stringBuffer.append((XtraBox.b)iterator.next().toString());
            stringBuffer.append(";");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
