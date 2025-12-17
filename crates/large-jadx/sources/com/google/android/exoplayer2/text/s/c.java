package com.google.android.exoplayer2.text.s;

import android.accounts.Account;
import android.animation.TimeInterpolator;
import android.text.Layout.Alignment;
import com.google.android.exoplayer2.l2.v.r;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.d;
import com.google.android.exoplayer2.text.f;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.k;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.q0;
import com.google.android.exoplayer2.util.v;
import com.google.common.base.b;
import com.google.zxing.g.b;
import com.googlecode.mp4parser.boxes.microsoft.XtraBox;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public final class c extends d {

    private static final Pattern o;
    private static final Pattern p;
    private static final Pattern q;
    static final Pattern r;
    static final Pattern s;
    private static final Pattern t;
    private static final Pattern u;
    private static final com.google.android.exoplayer2.text.s.c.b v;
    private static final com.google.android.exoplayer2.text.s.c.a w;
    private final XmlPullParserFactory n;

    private static final class a {

        final int a;
        a(int i, int i2) {
            super();
            this.a = i2;
        }
    }

    private static final class b {

        final float a;
        final int b;
        final int c;
        b(float f, int i2, int i3) {
            super();
            this.a = f;
            this.b = i2;
            this.c = i3;
        }
    }

    private static final class c {

        final int a;
        final int b;
        c(int i, int i2) {
            super();
            this.a = i;
            this.b = i2;
        }
    }
    static {
        c.o = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
        c.p = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
        c.q = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
        c.r = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
        c.s = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
        c.t = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");
        c.u = Pattern.compile("^(\\d+) (\\d+)$");
        int i3 = 1;
        c.b bVar = new c.b(1106247680, i3, i3);
        c.v = bVar;
        c.a aVar = new c.a(32, 15);
        c.w = aVar;
    }

    public c() {
        super("TtmlDecoder");
        XmlPullParserFactory instance = XmlPullParserFactory.newInstance();
        this.n = instance;
        instance.setNamespaceAware(true);
    }

    private static com.google.android.exoplayer2.text.s.g C(com.google.android.exoplayer2.text.s.g g) {
        com.google.android.exoplayer2.text.s.g obj0;
        if (g == null) {
            obj0 = new g();
        }
        return obj0;
    }

    private static boolean D(String string) {
        boolean equals;
        boolean obj1;
        if (!string.equals("tt") && !string.equals("head") && !string.equals("body") && !string.equals("div") && !string.equals("p") && !string.equals("span") && !string.equals("br") && !string.equals("style") && !string.equals("styling") && !string.equals("layout") && !string.equals("region") && !string.equals("metadata") && !string.equals("image") && !string.equals("data")) {
            if (!string.equals("head")) {
                if (!string.equals("body")) {
                    if (!string.equals("div")) {
                        if (!string.equals("p")) {
                            if (!string.equals("span")) {
                                if (!string.equals("br")) {
                                    if (!string.equals("style")) {
                                        if (!string.equals("styling")) {
                                            if (!string.equals("layout")) {
                                                if (!string.equals("region")) {
                                                    if (!string.equals("metadata")) {
                                                        if (!string.equals("image")) {
                                                            if (!string.equals("data")) {
                                                                if (string.equals("information")) {
                                                                    obj1 = 1;
                                                                } else {
                                                                    obj1 = 0;
                                                                }
                                                            } else {
                                                            }
                                                        } else {
                                                        }
                                                    } else {
                                                    }
                                                } else {
                                                }
                                            } else {
                                            }
                                        } else {
                                        }
                                    } else {
                                    }
                                } else {
                                }
                            } else {
                            }
                        } else {
                        }
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj1;
    }

    private static Layout.Alignment E(String string) {
        String str;
        int i;
        boolean obj2;
        obj2 = b.c(string);
        obj2.hashCode();
        i = -1;
        switch (obj2) {
            case "center":
                i = 0;
                break;
            case "end":
                i = 1;
                break;
            case "left":
                i = 2;
                break;
            case "right":
                i = 3;
                break;
            case "start":
                i = 4;
                break;
            default:
        }
        switch (i) {
            case 0:
                return Layout.Alignment.ALIGN_CENTER;
            case 1:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 2:
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    private static com.google.android.exoplayer2.text.s.c.a F(XmlPullParser xmlPullParser, com.google.android.exoplayer2.text.s.c.a c$a2) {
        String obj7;
        obj7 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (obj7 == null) {
            return a2;
        }
        Matcher matcher = c.u.matcher(obj7);
        final String str4 = "Ignoring malformed cell resolution: ";
        if (!matcher.matches()) {
            obj7 = String.valueOf(obj7);
            if (obj7.length() != 0) {
                obj7 = str4.concat(obj7);
            } else {
                obj7 = new String(str4);
            }
            v.h("TtmlDecoder", obj7);
            return a2;
        }
        String group2 = matcher.group(1);
        g.e(group2);
        int int2 = Integer.parseInt((String)group2);
        String group = matcher.group(2);
        g.e(group);
        int int = Integer.parseInt((String)group);
        if (int2 == 0) {
        } else {
            if (int == 0) {
            } else {
                c.a aVar = new c.a(int2, int);
                return aVar;
            }
        }
        StringBuilder stringBuilder = new StringBuilder(47);
        stringBuilder.append("Invalid cell resolution ");
        stringBuilder.append(int2);
        stringBuilder.append(" ");
        stringBuilder.append(int);
        SubtitleDecoderException subtitleDecoderException = new SubtitleDecoderException(stringBuilder.toString());
        throw subtitleDecoderException;
    }

    private static void G(String string, com.google.android.exoplayer2.text.s.g g2) {
        Matcher matcher;
        int length;
        String str;
        int i;
        int equals;
        String[] strArr = p0.C0(string, "\\s+");
        final int i4 = 2;
        final int i5 = 1;
        if (strArr.length == i5) {
            matcher = c.q.matcher(string);
            String str6 = "'.";
            if (!matcher.matches()) {
            } else {
                int obj7 = 3;
                String group = matcher.group(obj7);
                g.e(group);
                (String)group.hashCode();
                i = -1;
                switch (group) {
                    case "%":
                        i = 0;
                        break;
                    case "em":
                        i = i5;
                        break;
                    case "px":
                        i = i4;
                        break;
                    default:
                }
                switch (i) {
                    case 0:
                        g2.z(obj7);
                        break;
                    case 1:
                        g2.z(i4);
                        break;
                    case 2:
                        g2.z(i5);
                        break;
                    default:
                        StringBuilder stringBuilder = new StringBuilder(obj8 += 30);
                        stringBuilder.append("Invalid unit for fontSize: '");
                        stringBuilder.append(group);
                        stringBuilder.append(str6);
                        obj7 = new SubtitleDecoderException(stringBuilder.toString());
                        throw obj7;
                }
                obj7 = matcher.group(i5);
                g.e(obj7);
                g2.y(Float.parseFloat((String)obj7));
            }
            StringBuilder stringBuilder2 = new StringBuilder(length2 += 36);
            stringBuilder2.append("Invalid expression for fontSize: '");
            stringBuilder2.append(string);
            stringBuilder2.append(str6);
            SubtitleDecoderException obj8 = new SubtitleDecoderException(stringBuilder2.toString());
            throw obj8;
        } else {
            if (strArr.length != i4) {
            } else {
                matcher = c.q.matcher(strArr[i5]);
                v.h("TtmlDecoder", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
            }
        }
        StringBuilder stringBuilder3 = new StringBuilder(52);
        stringBuilder3.append("Invalid number of entries for fontSize: ");
        stringBuilder3.append(strArr.length);
        stringBuilder3.append(".");
        obj7 = new SubtitleDecoderException(stringBuilder3.toString());
        throw obj7;
    }

    private static com.google.android.exoplayer2.text.s.c.b H(XmlPullParser xmlPullParser) {
        int int3;
        int i;
        String attributeValue;
        int int;
        int i2;
        int int2;
        String str = "http://www.w3.org/ns/ttml#parameter";
        String attributeValue2 = xmlPullParser.getAttributeValue(str, "frameRate");
        if (attributeValue2 != null) {
            int3 = Integer.parseInt(attributeValue2);
        } else {
            int3 = 30;
        }
        i = 1065353216;
        attributeValue = xmlPullParser.getAttributeValue(str, "frameRateMultiplier");
        if (attributeValue != null) {
            String[] strArr = p0.C0(attributeValue, " ");
            if (strArr.length != 2) {
            } else {
                i = attributeValue / f2;
            }
            SubtitleDecoderException obj6 = new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            throw obj6;
        }
        com.google.android.exoplayer2.text.s.c.b bVar = c.v;
        int2 = bVar.b;
        String attributeValue3 = xmlPullParser.getAttributeValue(str, "subFrameRate");
        if (attributeValue3 != null) {
            int2 = Integer.parseInt(attributeValue3);
        }
        int = bVar.c;
        obj6 = xmlPullParser.getAttributeValue(str, "tickRate");
        if (obj6 != null) {
            int = Integer.parseInt(obj6);
        }
        obj6 = new c.b(f *= i, int2, int);
        return obj6;
    }

    private static Map<String, com.google.android.exoplayer2.text.s.g> I(XmlPullParser xmlPullParser, Map<String, com.google.android.exoplayer2.text.s.g> map2, com.google.android.exoplayer2.text.s.c.a c$a3, com.google.android.exoplayer2.text.s.c.c c$c4, Map<String, com.google.android.exoplayer2.text.s.e> map5, Map<String, String> map6) {
        String str;
        boolean z2;
        boolean z;
        int length;
        int i;
        Object obj;
        xmlPullParser.next();
        String str2 = "style";
        do {
            xmlPullParser.next();
            str2 = "style";
            if (q0.e(xmlPullParser, "region")) {
            } else {
            }
            if (q0.e(xmlPullParser, "metadata")) {
            }
            if (!q0.c(xmlPullParser, "head")) {
            }
            c.J(xmlPullParser, map6);
            z2 = c.L(xmlPullParser, a3, c4);
            if (z2 != null) {
            }
            map5.put(z2.a, z2);
            str = q0.a(xmlPullParser, str2);
            g gVar = new g();
            z = c.N(xmlPullParser, gVar);
            if (str != null) {
            }
            z2 = z.g();
            if (z2 != null) {
            }
            map2.put(z2, z);
            str = c.O(str);
            i = 0;
            while (i < str.length) {
                z.a((g)map2.get(str[i]));
                i++;
            }
            z.a((g)map2.get(str[i]));
            i++;
        } while (q0.e(xmlPullParser, str2));
        return map2;
    }

    private static void J(XmlPullParser xmlPullParser, Map<String, String> map2) {
        boolean z;
        String nextText;
        xmlPullParser.next();
        do {
            xmlPullParser.next();
            if (!q0.c(xmlPullParser, "metadata")) {
            }
            z = q0.a(xmlPullParser, "id");
            if (z != null) {
            }
            map2.put(z, xmlPullParser.nextText());
        } while (q0.e(xmlPullParser, "image"));
    }

    private static com.google.android.exoplayer2.text.s.d K(XmlPullParser xmlPullParser, com.google.android.exoplayer2.text.s.d d2, Map<String, com.google.android.exoplayer2.text.s.e> map3, com.google.android.exoplayer2.text.s.c.b c$b4) {
        long bVar;
        int i5;
        long cmp2;
        int i;
        com.google.android.exoplayer2.text.s.g gVar;
        String attributeName;
        long attributeValue;
        int cmp;
        int key;
        int i2;
        String str;
        int substring;
        long l2;
        int i6;
        long l3;
        long l;
        int i4;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj = d2;
        bVar = b4;
        final int attributeCount = xmlPullParser.getAttributeCount();
        int i7 = 0;
        str = str4;
        l2 = -9223372036854775807L;
        l3 = -9223372036854775807L;
        l = -9223372036854775807L;
        i2 = substring;
        i5 = 0;
        while (i5 < attributeCount) {
            attributeName = xmlPullParser2.getAttributeName(i5);
            attributeValue = xmlPullParser2.getAttributeValue(i5);
            attributeName.hashCode();
            key = -1;
            gVar = map3;
            i5++;
            if (attributeValue.startsWith("#")) {
            }
            substring = attributeValue.substring(1);
            attributeName = c.O(attributeValue);
            if (attributeName.length > 0) {
            }
            i2 = attributeName;
            l2 = c.P(attributeValue, bVar);
            l3 = c.P(attributeValue, bVar);
            l = c.P(attributeValue, bVar);
            if (map3.containsKey(attributeValue)) {
            }
            str = attributeValue;
            if (attributeName.equals("backgroundImage") == null) {
            } else {
            }
            key = 5;
            if (attributeName.equals("style") == null) {
            } else {
            }
            key = 4;
            if (attributeName.equals("begin") == null) {
            } else {
            }
            key = 3;
            if (attributeName.equals("end") == null) {
            } else {
            }
            key = 2;
            if (attributeName.equals("dur") == null) {
            } else {
            }
            key = 1;
            if (attributeName.equals("region") == null) {
            } else {
            }
            key = 0;
        }
        if (obj != null) {
            bVar = obj.d;
            cmp2 = -9223372036854775807L;
            if (Long.compare(bVar, cmp2) != 0 && Long.compare(l2, cmp2) != 0) {
                if (Long.compare(l2, cmp2) != 0) {
                    l2 += bVar;
                }
                if (Long.compare(l3, cmp2) != 0) {
                    l3 += bVar;
                }
            }
        } else {
            cmp2 = -9223372036854775807L;
        }
        long l4 = l2;
        if (Long.compare(l3, cmp2) == 0) {
            if (Long.compare(l, cmp2) != 0) {
                i = l;
            } else {
                cmp = obj.e;
                if (obj != null && Long.compare(cmp, cmp2) != 0) {
                    cmp = obj.e;
                    i = Long.compare(cmp, cmp2) != 0 ? cmp : l3;
                } else {
                }
            }
        } else {
        }
        return d.c(xmlPullParser.getName(), l4, attributeCount, i, gVar, c.N(xmlPullParser2, i7), i2, str);
    }

    private static com.google.android.exoplayer2.text.s.e L(XmlPullParser xmlPullParser, com.google.android.exoplayer2.text.s.c.a c$a2, com.google.android.exoplayer2.text.s.c.c c$c3) {
        String concat3;
        String concat;
        String equals2;
        String string;
        String concat2;
        String valueOf;
        int i8;
        String valueOf2;
        int i2;
        boolean equals3;
        int str3;
        String equals;
        String str;
        String group;
        int i6;
        int i;
        Matcher matcher;
        int i3;
        int str4;
        float matches;
        int i4;
        int i5;
        int i7;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj = c3;
        final String str14 = q0.a(xmlPullParser2, "id");
        i2 = 0;
        if (str14 == null) {
            return i2;
        }
        String str13 = q0.a(xmlPullParser2, "origin");
        equals = "TtmlDecoder";
        if (str13 != null) {
            Pattern pattern = c.s;
            Matcher matcher3 = pattern.matcher(str13);
            Pattern pattern2 = c.t;
            Matcher matcher4 = pattern2.matcher(str13);
            String str18 = "Ignoring region with malformed origin: ";
            String str20 = "Ignoring region with missing tts:extent: ";
            int i25 = 1120403456;
            final int i26 = 2;
            final int i27 = 1;
            if (matcher3.matches()) {
                String group8 = matcher3.group(i27);
                g.e(group8);
                String group5 = matcher3.group(i26);
                g.e(group5);
                str4 = i16;
                i = i7;
                String str17 = q0.a(xmlPullParser2, "extent");
                if (str17 != null) {
                    Matcher matcher2 = pattern.matcher(str17);
                    matcher = pattern2.matcher(str17);
                    String str19 = "Ignoring region with malformed extent: ";
                    if (matcher2.matches()) {
                        String group2 = matcher2.group(i27);
                        g.e(group2);
                        float /= i25;
                        group = matcher2.group(i26);
                        g.e(group);
                        i4 = i2;
                        equals3 = q0.a(xmlPullParser2, "displayAlign");
                        if (equals3 != null) {
                            String str11 = b.c(equals3);
                            str11.hashCode();
                            if (!str11.equals("center")) {
                                if (!str11.equals("after")) {
                                    i3 = str3;
                                    i6 = str4;
                                } else {
                                    i6 = str4;
                                    i3 = i26;
                                }
                            } else {
                                i6 = str4;
                                i3 = i27;
                            }
                        } else {
                        }
                        equals2 = q0.a(xmlPullParser2, "writingMode");
                        if (equals2 != null) {
                            equals2 = b.c(equals2);
                            equals2.hashCode();
                            switch (equals2) {
                                case "tb":
                                    str3 = str;
                                    break;
                                case "tblr":
                                    str3 = str;
                                    str3 = i27;
                                    break;
                                case "tbrl":
                                    str3 = str;
                                    str3 = i26;
                                    break;
                                default:
                                    str3 = str;
                            }
                            switch (str3) {
                                case 0:
                                    i5 = i26;
                                    break;
                                case 1:
                                    i5 = i27;
                                    break;
                                default:
                                    i5 = i12;
                            }
                        } else {
                        }
                        super(str14, i, i6, 0, i3, i8, i4, 1, i11 / f2, i5);
                        return eVar;
                    } else {
                        if (matcher.matches() && obj == null) {
                            if (obj == null) {
                                String valueOf4 = String.valueOf(str13);
                                if (valueOf4.length() != 0) {
                                    string = str20.concat(valueOf4);
                                } else {
                                    string = new String(str20);
                                }
                                v.h(equals, string);
                                return i2;
                            }
                            String group3 = matcher.group(i27);
                            g.e(group3);
                            String group6 = matcher.group(i26);
                            g.e(group6);
                            i8 = group;
                            i4 = matcher;
                        }
                    }
                    String str7 = "Ignoring region with unsupported extent: ";
                    valueOf2 = String.valueOf(str13);
                    if (valueOf2.length() != 0) {
                        concat2 = str7.concat(valueOf2);
                    } else {
                        valueOf2 = new String(str7);
                        concat2 = valueOf2;
                    }
                    v.h(equals, concat2);
                    return i2;
                }
                v.h(equals, "Ignoring region without an extent");
                return i2;
            } else {
                if (matcher4.matches() && obj == null) {
                    if (obj == null) {
                        String valueOf3 = String.valueOf(str13);
                        if (valueOf3.length() != 0) {
                            concat = str20.concat(valueOf3);
                        } else {
                            concat = new String(str20);
                        }
                        v.h(equals, concat);
                        return i2;
                    }
                    String group4 = matcher4.group(i27);
                    g.e(group4);
                    String group7 = matcher4.group(i26);
                    g.e(group7);
                    f4 /= f7;
                    f6 /= matches;
                }
            }
            String str5 = "Ignoring region with unsupported origin: ";
            valueOf = String.valueOf(str13);
            if (valueOf.length() != 0) {
                concat3 = str5.concat(valueOf);
            } else {
                valueOf = new String(str5);
                concat3 = valueOf;
            }
            v.h(equals, concat3);
            return i2;
        }
        v.h(equals, "Ignoring region without an origin");
        return i2;
    }

    private static float M(String string) {
        String obj5;
        Matcher matcher = c.r.matcher(string);
        if (!matcher.matches()) {
            String str = "Invalid value for shear: ";
            obj5 = String.valueOf(string);
            if (obj5.length() != 0) {
                obj5 = str.concat(obj5);
            } else {
                obj5 = new String(str);
            }
            v.h("TtmlDecoder", obj5);
            return 2139095039;
        }
        String group = matcher.group(1);
        g.e(group);
        return Math.min(1120403456, Math.max(-1027080192, Float.parseFloat((String)group)));
    }

    private static com.google.android.exoplayer2.text.s.g N(XmlPullParser xmlPullParser, com.google.android.exoplayer2.text.s.g g2) {
        String d;
        int i;
        int i6;
        Object equalsIgnoreCase;
        String equals;
        String attributeName;
        String str2;
        int str;
        int i3;
        long l;
        int i2;
        Object obj2;
        Object obj;
        int i4;
        com.google.android.exoplayer2.text.s.g obj13;
        final int i7 = 0;
        i6 = i7;
        while (i6 < xmlPullParser.getAttributeCount()) {
            equalsIgnoreCase = xmlPullParser.getAttributeValue(i6);
            attributeName = xmlPullParser.getAttributeName(i6);
            attributeName.hashCode();
            l = 4;
            i2 = -1;
            obj2 = 3;
            obj = 2;
            i4 = 1;
            equals = i2;
            str2 = "TtmlDecoder";
            i6++;
            c.C(obj13).D(c.E(equalsIgnoreCase));
            c.C(obj13).u(k.c(equalsIgnoreCase));
            equalsIgnoreCase = b.c(equalsIgnoreCase);
            equalsIgnoreCase.hashCode();
            if (!equalsIgnoreCase.equals("before")) {
            } else {
            }
            c.C(obj13).E(i4);
            if (!equalsIgnoreCase.equals("after")) {
            } else {
            }
            c.C(obj13).E(obj);
            c.C(obj13).J(b.a(equalsIgnoreCase));
            c.G(equalsIgnoreCase, c.C(obj13));
            equalsIgnoreCase = b.c(equalsIgnoreCase);
            equalsIgnoreCase.hashCode();
            if (!equalsIgnoreCase.equals("all")) {
            } else {
            }
            c.C(obj13).I(i4);
            if (!equalsIgnoreCase.equals("none")) {
            } else {
            }
            c.C(obj13).I(i7);
            c.C(obj13).G(c.M(equalsIgnoreCase));
            c.C(obj13).w(k.c(equalsIgnoreCase));
            equalsIgnoreCase = b.c(equalsIgnoreCase);
            equalsIgnoreCase.hashCode();
            i3 = i2;
            c.C(obj13).F(obj2);
            c.C(obj13).F(l);
            c.C(obj13).F(i4);
            c.C(obj13).F(obj);
            if (equalsIgnoreCase.equals("text") == null) {
            }
            if (equalsIgnoreCase.equals("base") == null) {
            } else {
            }
            i3 = l;
            if (equalsIgnoreCase.equals("textContainer") == null) {
            } else {
            }
            i3 = obj2;
            if (equalsIgnoreCase.equals("delimiter") == null) {
            } else {
            }
            i3 = obj;
            if (equalsIgnoreCase.equals("container") == null) {
            } else {
            }
            i3 = i4;
            if (equalsIgnoreCase.equals("baseContainer") == null) {
            } else {
            }
            i3 = i7;
            if ("style".equals(xmlPullParser.getName())) {
            }
            c.C(obj13).A(equalsIgnoreCase);
            c.C(obj13).v("bold".equalsIgnoreCase(equalsIgnoreCase));
            equalsIgnoreCase = b.c(equalsIgnoreCase);
            equalsIgnoreCase.hashCode();
            c.C(obj13).C(i4);
            c.C(obj13).C(i7);
            c.C(obj13).K(i4);
            c.C(obj13).K(i7);
            if (!equalsIgnoreCase.equals("linethrough")) {
            } else {
            }
            i2 = obj2;
            if (!equalsIgnoreCase.equals("nolinethrough")) {
            } else {
            }
            i2 = obj;
            if (!equalsIgnoreCase.equals("underline")) {
            } else {
            }
            i2 = i4;
            if (!equalsIgnoreCase.equals("nounderline")) {
            } else {
            }
            i2 = i7;
            c.C(obj13).H(c.E(equalsIgnoreCase));
            c.C(obj13).x(equalsIgnoreCase);
            c.C(obj13).B("italic".equalsIgnoreCase(equalsIgnoreCase));
            if (attributeName.equals("multiRowAlign") == null) {
            } else {
            }
            equals = 14;
            if (attributeName.equals("backgroundColor") == null) {
            } else {
            }
            equals = 13;
            if (attributeName.equals("rubyPosition") == null) {
            } else {
            }
            equals = 12;
            if (attributeName.equals("textEmphasis") == null) {
            } else {
            }
            equals = 11;
            if (attributeName.equals("fontSize") == null) {
            } else {
            }
            equals = 10;
            if (attributeName.equals("textCombine") == null) {
            } else {
            }
            equals = 9;
            if (attributeName.equals("shear") == null) {
            } else {
            }
            equals = 8;
            if (attributeName.equals("color") == null) {
            } else {
            }
            equals = 7;
            if (attributeName.equals("ruby") == null) {
            } else {
            }
            equals = 6;
            if (attributeName.equals("id") == null) {
            } else {
            }
            equals = i3;
            if (attributeName.equals("fontWeight") == null) {
            } else {
            }
            equals = l;
            if (attributeName.equals("textDecoration") == null) {
            } else {
            }
            equals = obj2;
            if (attributeName.equals("textAlign") == null) {
            } else {
            }
            equals = obj;
            if (attributeName.equals("fontFamily") == null) {
            } else {
            }
            equals = i4;
            if (attributeName.equals("fontStyle") == null) {
            } else {
            }
            equals = i7;
            equals = "Failed parsing background value: ";
            equalsIgnoreCase = String.valueOf(equalsIgnoreCase);
            i3 = equalsIgnoreCase.length();
            if (i3 != 0) {
            } else {
            }
            equalsIgnoreCase = equals.concat(equalsIgnoreCase);
            equalsIgnoreCase = new String(equals);
            v.h(str2, equalsIgnoreCase);
            equals = "Failed parsing fontSize value: ";
            equalsIgnoreCase = String.valueOf(equalsIgnoreCase);
            i3 = equalsIgnoreCase.length();
            if (i3 != 0) {
            } else {
            }
            equalsIgnoreCase = equals.concat(equalsIgnoreCase);
            equalsIgnoreCase = new String(equals);
            v.h(str2, equalsIgnoreCase);
            equals = "Failed parsing color value: ";
            equalsIgnoreCase = String.valueOf(equalsIgnoreCase);
            i3 = equalsIgnoreCase.length();
            if (i3 != 0) {
            } else {
            }
            equalsIgnoreCase = equals.concat(equalsIgnoreCase);
            equalsIgnoreCase = new String(equals);
            v.h(str2, equalsIgnoreCase);
        }
        return obj13;
    }

    private static String[] O(String string) {
        boolean empty;
        String[] obj1;
        obj1 = string.trim();
        if (obj1.isEmpty()) {
            obj1 = new String[0];
        } else {
            obj1 = p0.C0(obj1, "\\s+");
        }
        return obj1;
    }

    private static long P(String string, com.google.android.exoplayer2.text.s.c.b c$b2) {
        Matcher matcher;
        boolean matches;
        int str;
        int i3;
        int i2;
        double double2;
        int double;
        int i;
        String obj13;
        matcher = c.o.matcher(string);
        final long l = 4696837146684686336L;
        int i5 = 3;
        final int i6 = 2;
        int i7 = 1;
        if (matcher.matches()) {
            obj13 = matcher.group(i7);
            g.e(obj13);
            obj13 = matcher.group(i6);
            g.e(obj13);
            obj13 = matcher.group(i5);
            g.e(obj13);
            obj13 = matcher.group(4);
            i3 = 0;
            if (obj13 != null) {
                double = Double.parseDouble(obj13);
            } else {
                double = i3;
            }
            obj13 = matcher.group(5);
            if (obj13 != null) {
                i = (double)obj13;
            } else {
                i = i3;
            }
            obj13 = matcher.group(6);
            if (obj13 != null) {
                i3 = matcher / obj13;
            }
            return (long)i14;
        }
        Matcher matcher2 = c.p.matcher(string);
        if (matcher2.matches()) {
            obj13 = matcher2.group(i7);
            g.e(obj13);
            double2 = Double.parseDouble((String)obj13);
            obj13 = matcher2.group(i6);
            g.e(obj13);
            (String)obj13.hashCode();
            switch (obj13) {
                case "f":
                    i2 = i4;
                    i2 = 0;
                    break;
                case "h":
                    i2 = i4;
                    i2 = i7;
                    break;
                case "m":
                    i2 = i4;
                    i2 = i6;
                    break;
                case "t":
                    i2 = i4;
                    i2 = i5;
                    break;
                case "ms":
                    i2 = i4;
                    break;
                default:
                    i2 = i4;
            }
            switch (i2) {
                case 0:
                    double2 /= obj13;
                    obj13 = (double)obj13;
                    break;
                case 1:
                    obj13 = 4660134898793709568L;
                    double2 *= obj13;
                    break;
                case 2:
                    obj13 = 4633641066610819072L;
                    double2 *= obj13;
                    break;
                case 3:
                    double2 /= obj13;
                    obj13 = (double)obj13;
                    break;
                case 4:
                    obj13 = 4652007308841189376L;
                    double2 /= obj13;
                    break;
                default:
            }
            return (long)i15;
        }
        String str2 = "Malformed time expression: ";
        obj13 = String.valueOf(string);
        if (obj13.length() != 0) {
            obj13 = str2.concat(obj13);
        } else {
            obj13 = new String(str2);
        }
        SubtitleDecoderException obj14 = new SubtitleDecoderException(obj13);
        throw obj14;
    }

    private static com.google.android.exoplayer2.text.s.c.c Q(XmlPullParser xmlPullParser) {
        String obj5;
        obj5 = q0.a(xmlPullParser, "extent");
        int i = 0;
        if (obj5 == null) {
            return i;
        }
        Matcher matcher = c.t.matcher(obj5);
        if (!matcher.matches()) {
            String str3 = "Ignoring non-pixel tts extent: ";
            obj5 = String.valueOf(obj5);
            if (obj5.length() != 0) {
                obj5 = str3.concat(obj5);
            } else {
                obj5 = new String(str3);
            }
            v.h("TtmlDecoder", obj5);
            return i;
        }
        String group2 = matcher.group(1);
        g.e(group2);
        String group = matcher.group(2);
        g.e(group);
        c.c cVar = new c.c(Integer.parseInt((String)group2), Integer.parseInt((String)group));
        return cVar;
    }

    @Override // com.google.android.exoplayer2.text.d
    protected f z(byte[] bArr, int i2, boolean z3) {
        int eventType;
        boolean equals;
        int valueOf;
        int i;
        Object str2;
        com.google.android.exoplayer2.text.s.c.b bVar;
        com.google.android.exoplayer2.text.s.c.a aVar;
        String str;
        int i3;
        int i4;
        int hVar;
        String name;
        int i5;
        com.google.android.exoplayer2.text.s.c.a aVar2;
        String str3 = "";
        XmlPullParser pullParser = obj.n.newPullParser();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        e eVar = new e(str3);
        hashMap2.put(str3, eVar);
        valueOf = 0;
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, valueOf, i2);
        i = 0;
        pullParser.setInput(byteArrayInputStream, i);
        ArrayDeque arrayDeque = new ArrayDeque();
        eventType = pullParser.getEventType();
        bVar = c.v;
        aVar = c.w;
        i4 = valueOf;
        hVar = i;
        while (eventType != 1) {
            valueOf = arrayDeque.peek();
            i3 = 2;
            if (i4 == 0) {
            } else {
            }
            if (eventType == i3) {
            } else {
            }
            if (eventType == 3) {
            }
            pullParser.next();
            eventType = pullParser.getEventType();
            i4--;
            i4++;
            name = pullParser.getName();
            str = "tt";
            if (eventType == i3) {
            } else {
            }
            if (eventType == 4) {
            } else {
            }
            if (eventType == 3 && pullParser.getName().equals(str)) {
            }
            if (pullParser.getName().equals(str)) {
            }
            arrayDeque.pop();
            eventType = arrayDeque.peek();
            g.e((d)eventType);
            hVar = new h((d)eventType, hashMap, hashMap2, hashMap3);
            g.e((d)valueOf);
            (d)valueOf.a(d.d(pullParser.getText()));
            if (str.equals(name)) {
            }
            i5 = i;
            i3 = bVar;
            aVar2 = aVar;
            if (!c.D(name)) {
            } else {
            }
            if ("head".equals(name)) {
            } else {
            }
            eventType = c.K(pullParser, valueOf, hashMap2, i3);
            arrayDeque.push(eventType);
            if (valueOf != null) {
            }
            bVar = name;
            i = i5;
            aVar = aVar2;
            valueOf.a(eventType);
            name = i3;
            c.I(pullParser, hashMap, aVar2, i5, hashMap2, hashMap3);
            String str5 = "Ignoring unsupported tag: ";
            valueOf = String.valueOf(pullParser.getName());
            if (valueOf.length() != 0) {
            } else {
            }
            valueOf = new String(str5);
            eventType = valueOf;
            v.f("TtmlDecoder", eventType);
            i4++;
            bVar = i3;
            eventType = str5.concat(valueOf);
            bVar = c.H(pullParser);
            aVar = c.F(pullParser, c.w);
            i = c.Q(pullParser);
            String str7 = "Suppressing parser error";
            v.i(obj4, str7, th);
        }
        if (hVar == 0) {
        } else {
            return hVar;
        }
        SubtitleDecoderException subtitleDecoderException = new SubtitleDecoderException("No TTML subtitles found");
        throw subtitleDecoderException;
    }
}
