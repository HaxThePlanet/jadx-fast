package androidx.core.content.e;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import d.h.d;
import d.h.i.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class c {

    public interface a {
    }

    public static final class c {

        private final String a;
        private int b;
        private boolean c;
        private String d;
        private int e;
        private int f;
        public c(String string, int i2, boolean z3, String string4, int i5, int i6) {
            super();
            this.a = string;
            this.b = i2;
            this.c = z3;
            this.d = string4;
            this.e = i5;
            this.f = i6;
        }

        public String a() {
            return this.a;
        }

        public int b() {
            return this.f;
        }

        public int c() {
            return this.e;
        }

        public String d() {
            return this.d;
        }

        public int e() {
            return this.b;
        }

        public boolean f() {
            return this.c;
        }
    }

    public static final class b implements androidx.core.content.e.c.a {

        private final androidx.core.content.e.c.c[] a;
        public b(androidx.core.content.e.c.c[] c$cArr) {
            super();
            this.a = cArr;
        }

        @Override // androidx.core.content.e.c$a
        public androidx.core.content.e.c.c[] a() {
            return this.a;
        }
    }

    public static final class d implements androidx.core.content.e.c.a {

        private final d a;
        private final int b;
        private final int c;
        private final String d;
        public d(d d, int i2, int i3, String string4) {
            super();
            this.a = d;
            this.c = i2;
            this.b = i3;
            this.d = string4;
        }

        @Override // androidx.core.content.e.c$a
        public int a() {
            return this.c;
        }

        @Override // androidx.core.content.e.c$a
        public d b() {
            return this.a;
        }

        @Override // androidx.core.content.e.c$a
        public String c() {
            return this.d;
        }

        @Override // androidx.core.content.e.c$a
        public int d() {
            return this.b;
        }
    }
    private static int a(TypedArray typedArray, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i2);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i2, typedValue);
        return typedValue.type;
    }

    public static androidx.core.content.e.c.a b(XmlPullParser xmlPullParser, Resources resources2) {
        int i;
        final int next = xmlPullParser.next();
        final int i2 = 2;
        while (next != i2) {
            if (next != 1) {
            }
            next = xmlPullParser.next();
            i2 = 2;
        }
        if (next != i2) {
        } else {
            return c.d(xmlPullParser, resources2);
        }
        XmlPullParserException obj3 = new XmlPullParserException("No start tag found");
        throw obj3;
    }

    public static List<List<byte[]>> c(Resources resources, int i2) {
        int resourceId;
        List obj5;
        int obj6;
        if (i2 == 0) {
            return Collections.emptyList();
        }
        final TypedArray typedArray = resources.obtainTypedArray(i2);
        if (typedArray.length() == 0) {
            typedArray.recycle();
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        final int i = 0;
        if (c.a(typedArray, i) == 1) {
            obj6 = i;
            while (obj6 < typedArray.length()) {
                resourceId = typedArray.getResourceId(obj6, i);
                if (resourceId != 0) {
                }
                obj6++;
                arrayList.add(c.h(resources.getStringArray(resourceId)));
            }
        } else {
            arrayList.add(c.h(resources.getStringArray(i2)));
        }
        try {
            typedArray.recycle();
            return arrayList;
            obj0.recycle();
            throw resources;
        }
    }

    private static androidx.core.content.e.c.a d(XmlPullParser xmlPullParser, Resources resources2) {
        final int i2 = 0;
        final String str = "font-family";
        xmlPullParser.require(2, i2, str);
        if (xmlPullParser.getName().equals(str)) {
            return c.e(xmlPullParser, resources2);
        }
        c.g(xmlPullParser);
        return i2;
    }

    private static androidx.core.content.e.c.a e(XmlPullParser xmlPullParser, Resources resources2) {
        String eventType;
        String string;
        int next;
        TypedArray attributes = resources2.obtainAttributes(Xml.asAttributeSet(xmlPullParser), d.e);
        String string2 = attributes.getString(d.f);
        eventType = attributes.getString(d.j);
        string = attributes.getString(d.k);
        attributes.recycle();
        int i = 3;
        if (string2 != null && eventType != null && string != null) {
            if (eventType != null) {
                if (string != null) {
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        while (xmlPullParser.next() != i) {
            if (xmlPullParser.getEventType() != 2) {
            } else {
            }
            if (xmlPullParser.getName().equals("font") != null) {
            } else {
            }
            c.g(xmlPullParser);
            arrayList.add(c.f(xmlPullParser, resources2));
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        c.b obj9 = new c.b((c.c[])arrayList.toArray(new c.c[arrayList.size()]));
        return obj9;
    }

    private static androidx.core.content.e.c.c f(XmlPullParser xmlPullParser, Resources resources2) {
        int i;
        int i5;
        int i4;
        int i2;
        int i6;
        int i3;
        TypedArray obj10;
        obj10 = resources2.obtainAttributes(Xml.asAttributeSet(xmlPullParser), d.m);
        if (obj10.hasValue(d.v)) {
        } else {
            i = d.o;
        }
        if (obj10.hasValue(d.t)) {
        } else {
            i5 = d.p;
        }
        int i8 = 0;
        int i9 = 1;
        i3 = i9 == obj10.getInt(i5, i8) ? i9 : i8;
        if (obj10.hasValue(d.w)) {
        } else {
            i4 = d.q;
        }
        if (obj10.hasValue(d.u)) {
        } else {
            i6 = d.r;
        }
        if (obj10.hasValue(d.s)) {
        } else {
            i2 = d.n;
        }
        obj10.recycle();
        while (xmlPullParser.next() != 3) {
            c.g(xmlPullParser);
        }
        super(obj10.getString(i2), obj10.getInt(i, 400), i3, obj10.getString(i6), obj10.getInt(i4, i8), obj10.getResourceId(i2, i8));
        return obj9;
    }

    private static void g(XmlPullParser xmlPullParser) {
        int i2;
        int next;
        int i;
        i2 = 1;
        while (i2 > 0) {
            next = xmlPullParser.next();
            if (next != 2) {
            } else {
            }
            i2++;
            if (next != 3) {
            } else {
            }
            i2--;
        }
    }

    private static List<byte[]> h(String[] stringArr) {
        int i;
        byte[] decode;
        ArrayList arrayList = new ArrayList();
        final int i2 = 0;
        i = i2;
        while (i < stringArr.length) {
            arrayList.add(Base64.decode(stringArr[i], i2));
            i++;
        }
        return arrayList;
    }
}
