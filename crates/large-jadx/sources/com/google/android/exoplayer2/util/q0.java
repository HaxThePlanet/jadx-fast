package com.google.android.exoplayer2.util;

import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes2.dex */
public final class q0 {
    public static String a(XmlPullParser xmlPullParser, String string2) {
        int i;
        boolean equals;
        i = 0;
        while (i < xmlPullParser.getAttributeCount()) {
            i++;
        }
        return null;
    }

    public static boolean b(XmlPullParser xmlPullParser) {
        int obj1;
        obj1 = xmlPullParser.getEventType() == 3 ? 1 : 0;
        return obj1;
    }

    public static boolean c(XmlPullParser xmlPullParser, String string2) {
        XmlPullParser obj1;
        if (q0.b(xmlPullParser) && xmlPullParser.getName().equals(string2)) {
            obj1 = xmlPullParser.getName().equals(string2) ? 1 : 0;
        } else {
        }
        return obj1;
    }

    public static boolean d(XmlPullParser xmlPullParser) {
        int obj1;
        obj1 = xmlPullParser.getEventType() == 2 ? 1 : 0;
        return obj1;
    }

    public static boolean e(XmlPullParser xmlPullParser, String string2) {
        XmlPullParser obj1;
        if (q0.d(xmlPullParser) && xmlPullParser.getName().equals(string2)) {
            obj1 = xmlPullParser.getName().equals(string2) ? 1 : 0;
        } else {
        }
        return obj1;
    }
}
