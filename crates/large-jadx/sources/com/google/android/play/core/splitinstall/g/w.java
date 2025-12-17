package com.google.android.play.core.splitinstall.g;

import com.google.android.play.core.internal.h;
import com.google.android.play.core.splitinstall.f.a;
import java.io.File;
import java.io.FileReader;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public final class w {

    private static final h c;
    private final XmlPullParser a;
    private final com.google.android.play.core.splitinstall.g.q b;
    static {
        h hVar = new h("LocalTestingConfigParser");
        w.c = hVar;
    }

    w(XmlPullParser xmlPullParser) {
        super();
        this.a = xmlPullParser;
        this.b = r.c();
    }

    public static com.google.android.play.core.splitinstall.g.r a(File file) {
        File file2 = new File(file, "local_testing_config.xml");
        if (file2.exists() == null) {
            return r.a;
        }
        FileReader obj4 = new FileReader(file2);
        XmlPullParser pullParser = XmlPullParserFactory.newInstance().newPullParser();
        pullParser.setInput(obj4);
        w wVar = new w(pullParser);
        s sVar = new s(wVar);
        wVar.e("local-testing-config", sVar);
        obj4.close();
        return wVar.b.e();
    }

    public static void b(com.google.android.play.core.splitinstall.g.w w) {
        int i;
        boolean equals;
        String str;
        i = 0;
        while (i < w.a.getAttributeCount()) {
            if ("defaultErrorCode".equals(w.a.getAttributeName(i))) {
            }
            i++;
            w.b.a(a.a(w.a.getAttributeValue(i)));
        }
        u uVar = new u(w);
        w.e("split-install-error", uVar);
    }

    public static void c(com.google.android.play.core.splitinstall.g.w w) {
        Map next;
        Integer valueOf;
        int i;
        int attributeValue2;
        int attributeValue;
        boolean equals;
        String str;
        int i2 = 0;
        int i3 = 0;
        i = i2;
        attributeValue = attributeValue2;
        while (i < w.a.getAttributeCount()) {
            if ("module".equals(w.a.getAttributeName(i))) {
            }
            if ("errorCode".equals(w.a.getAttributeName(i))) {
            }
            i++;
            attributeValue = w.a.getAttributeValue(i);
            attributeValue2 = w.a.getAttributeValue(i);
        }
        if (attributeValue2 == 0) {
        } else {
            if (attributeValue == 0) {
            } else {
                w.b.d().put(attributeValue2, Integer.valueOf(a.a(attributeValue)));
                while (w.a.next() == 3) {
                }
            }
        }
        Object[] arr = new Object[1];
        arr[i2] = "split-install-error";
        XmlPullParserException xmlPullParserException = new XmlPullParserException(String.format("'%s' element does not contain 'module'/'errorCode' attributes.", arr), w.a, i3);
        throw xmlPullParserException;
    }

    private final void e(String string, com.google.android.play.core.splitinstall.g.v v2) {
        int eventType;
        int i2;
        int i;
        int next = this.a.next();
        while (next != 3) {
            i2 = 1;
            i = 2;
            next = this.a.next();
            v2.zza();
        }
    }

    final void d() {
        t tVar = new t(this);
        e("split-install-errors", tVar);
    }
}
