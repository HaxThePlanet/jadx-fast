package com.google.android.exoplayer2.util;

import android.graphics.Color;
import android.text.TextUtils;
import com.google.common.base.b;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class k {

    private static final Pattern a;
    private static final Pattern b;
    private static final Pattern c;
    private static final Map<String, Integer> d;
    static {
        k.a = Pattern.compile("^rgb\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        k.b = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d{1,3})\\)$");
        k.c = Pattern.compile("^rgba\\((\\d{1,3}),(\\d{1,3}),(\\d{1,3}),(\\d*\\.?\\d*?)\\)$");
        HashMap hashMap = new HashMap();
        k.d = hashMap;
        hashMap.put("aliceblue", -984833);
        hashMap.put("antiquewhite", -332841);
        Integer valueOf3 = -16711681;
        hashMap.put("aqua", valueOf3);
        hashMap.put("aquamarine", -8388652);
        hashMap.put("azure", -983041);
        hashMap.put("beige", -657956);
        hashMap.put("bisque", -6972);
        hashMap.put("black", -16777216);
        hashMap.put("blanchedalmond", -5171);
        hashMap.put("blue", -16776961);
        hashMap.put("blueviolet", -7722014);
        hashMap.put("brown", -5952982);
        hashMap.put("burlywood", -2180985);
        hashMap.put("cadetblue", -10510688);
        hashMap.put("chartreuse", -8388864);
        hashMap.put("chocolate", -2987746);
        hashMap.put("coral", -32944);
        hashMap.put("cornflowerblue", -10185235);
        hashMap.put("cornsilk", -1828);
        hashMap.put("crimson", -2354116);
        hashMap.put("cyan", valueOf3);
        hashMap.put("darkblue", -16777077);
        hashMap.put("darkcyan", -16741493);
        hashMap.put("darkgoldenrod", -4684277);
        Integer valueOf7 = -5658199;
        hashMap.put("darkgray", valueOf7);
        hashMap.put("darkgreen", -16751616);
        hashMap.put("darkgrey", valueOf7);
        hashMap.put("darkkhaki", -4343957);
        hashMap.put("darkmagenta", -7667573);
        hashMap.put("darkolivegreen", -11179217);
        hashMap.put("darkorange", -29696);
        hashMap.put("darkorchid", -6737204);
        hashMap.put("darkred", -7667712);
        hashMap.put("darksalmon", -1468806);
        hashMap.put("darkseagreen", -7357297);
        hashMap.put("darkslateblue", -12042869);
        Integer valueOf17 = -13676721;
        hashMap.put("darkslategray", valueOf17);
        hashMap.put("darkslategrey", valueOf17);
        hashMap.put("darkturquoise", -16724271);
        hashMap.put("darkviolet", -7077677);
        hashMap.put("deeppink", -60269);
        hashMap.put("deepskyblue", -16728065);
        Integer valueOf22 = -9868951;
        hashMap.put("dimgray", valueOf22);
        hashMap.put("dimgrey", valueOf22);
        hashMap.put("dodgerblue", -14774017);
        hashMap.put("firebrick", -5103070);
        hashMap.put("floralwhite", -1296);
        hashMap.put("forestgreen", -14513374);
        Integer valueOf27 = -65281;
        hashMap.put("fuchsia", valueOf27);
        hashMap.put("gainsboro", -2302756);
        hashMap.put("ghostwhite", -460545);
        hashMap.put("gold", -10496);
        hashMap.put("goldenrod", -2448096);
        Integer valueOf112 = -8355712;
        hashMap.put("gray", valueOf112);
        hashMap.put("green", -16744448);
        hashMap.put("greenyellow", -5374161);
        hashMap.put("grey", valueOf112);
        hashMap.put("honeydew", -983056);
        hashMap.put("hotpink", -38476);
        hashMap.put("indianred", -3318692);
        hashMap.put("indigo", -11861886);
        hashMap.put("ivory", -16);
        hashMap.put("khaki", -989556);
        hashMap.put("lavender", -1644806);
        hashMap.put("lavenderblush", -3851);
        hashMap.put("lawngreen", -8586240);
        hashMap.put("lemonchiffon", -1331);
        hashMap.put("lightblue", -5383962);
        hashMap.put("lightcoral", -1015680);
        hashMap.put("lightcyan", -2031617);
        hashMap.put("lightgoldenrodyellow", -329006);
        Integer valueOf127 = -2894893;
        hashMap.put("lightgray", valueOf127);
        hashMap.put("lightgreen", -7278960);
        hashMap.put("lightgrey", valueOf127);
        hashMap.put("lightpink", -18751);
        hashMap.put("lightsalmon", -24454);
        hashMap.put("lightseagreen", -14634326);
        hashMap.put("lightskyblue", -7876870);
        Integer valueOf132 = -8943463;
        hashMap.put("lightslategray", valueOf132);
        hashMap.put("lightslategrey", valueOf132);
        hashMap.put("lightsteelblue", -5192482);
        hashMap.put("lightyellow", -32);
        hashMap.put("lime", -16711936);
        hashMap.put("limegreen", -13447886);
        hashMap.put("linen", -331546);
        hashMap.put("magenta", valueOf27);
        hashMap.put("maroon", -8388608);
        hashMap.put("mediumaquamarine", -10039894);
        hashMap.put("mediumblue", -16777011);
        hashMap.put("mediumorchid", -4565549);
        hashMap.put("mediumpurple", -7114533);
        hashMap.put("mediumseagreen", -12799119);
        hashMap.put("mediumslateblue", -8689426);
        hashMap.put("mediumspringgreen", -16713062);
        hashMap.put("mediumturquoise", -12004916);
        hashMap.put("mediumvioletred", -3730043);
        hashMap.put("midnightblue", -15132304);
        hashMap.put("mintcream", -655366);
        hashMap.put("mistyrose", -6943);
        hashMap.put("moccasin", -6987);
        hashMap.put("navajowhite", -8531);
        hashMap.put("navy", -16777088);
        hashMap.put("oldlace", -133658);
        hashMap.put("olive", -8355840);
        hashMap.put("olivedrab", -9728477);
        hashMap.put("orange", -23296);
        hashMap.put("orangered", -47872);
        hashMap.put("orchid", -2461482);
        hashMap.put("palegoldenrod", -1120086);
        hashMap.put("palegreen", -6751336);
        hashMap.put("paleturquoise", -5247250);
        hashMap.put("palevioletred", -2396013);
        hashMap.put("papayawhip", -4139);
        hashMap.put("peachpuff", -9543);
        hashMap.put("peru", -3308225);
        hashMap.put("pink", -16181);
        hashMap.put("plum", -2252579);
        hashMap.put("powderblue", -5185306);
        hashMap.put("purple", -8388480);
        hashMap.put("rebeccapurple", -10079335);
        hashMap.put("red", -65536);
        hashMap.put("rosybrown", -4419697);
        hashMap.put("royalblue", -12490271);
        hashMap.put("saddlebrown", -7650029);
        hashMap.put("salmon", -360334);
        hashMap.put("sandybrown", -744352);
        hashMap.put("seagreen", -13726889);
        hashMap.put("seashell", -2578);
        hashMap.put("sienna", -6270419);
        hashMap.put("silver", -4144960);
        hashMap.put("skyblue", -7876885);
        hashMap.put("slateblue", -9807155);
        Integer valueOf74 = -9404272;
        hashMap.put("slategray", valueOf74);
        hashMap.put("slategrey", valueOf74);
        hashMap.put("snow", -1286);
        hashMap.put("springgreen", -16711809);
        hashMap.put("steelblue", -12156236);
        hashMap.put("tan", -2968436);
        hashMap.put("teal", -16744320);
        hashMap.put("thistle", -2572328);
        hashMap.put("tomato", -40121);
        hashMap.put("transparent", 0);
        hashMap.put("turquoise", -12525360);
        hashMap.put("violet", -1146130);
        hashMap.put("wheat", -663885);
        hashMap.put("white", -1);
        hashMap.put("whitesmoke", -657931);
        hashMap.put("yellow", -256);
        hashMap.put("yellowgreen", -6632142);
    }

    private static int a(String string, boolean z2) {
        int length;
        boolean startsWith;
        Pattern pattern;
        int i;
        int obj5;
        int obj6;
        int i5 = 1;
        g.a(empty ^= i5);
        obj5 = string.replace(" ", "");
        if (obj5.charAt(0) == 35) {
            obj6 = (int)long;
            if (obj5.length() == 7) {
                obj5 |= obj6;
                return obj5;
            } else {
                if (obj5.length() != 9) {
                } else {
                    obj5 |= obj6;
                }
            }
            obj5 = new IllegalArgumentException();
            throw obj5;
        }
        int i8 = 3;
        final int i9 = 2;
        final int i10 = 10;
        if (obj5.startsWith("rgba")) {
            pattern = z2 ? k.c : k.b;
            obj5 = pattern.matcher(obj5);
            if (!obj5.matches()) {
            } else {
                i = 4;
                if (z2) {
                    String group3 = obj5.group(i);
                    g.e(group3);
                    obj6 = (int)i;
                } else {
                    obj6 = obj5.group(i);
                    g.e(obj6);
                    obj6 = Integer.parseInt(obj6, i10);
                }
                String group2 = obj5.group(i5);
                g.e(group2);
                String group4 = obj5.group(i9);
                g.e(group4);
                obj5 = obj5.group(i8);
                g.e(obj5);
                return Color.argb(obj6, Integer.parseInt(group2, i10), Integer.parseInt(group4, i10), Integer.parseInt(obj5, i10));
            }
        } else {
            if (obj5.startsWith("rgb")) {
                obj5 = k.a.matcher(obj5);
                if (!obj5.matches()) {
                } else {
                    obj6 = obj5.group(i5);
                    g.e(obj6);
                    String group = obj5.group(i9);
                    g.e(group);
                    obj5 = obj5.group(i8);
                    g.e(obj5);
                    return Color.rgb(Integer.parseInt(obj6, i10), Integer.parseInt(group, i10), Integer.parseInt(obj5, i10));
                }
            } else {
                obj5 = k.d.get(b.c(obj5));
                if ((Integer)obj5 == null) {
                } else {
                    return (Integer)obj5.intValue();
                }
            }
        }
        obj5 = new IllegalArgumentException();
        throw obj5;
    }

    public static int b(String string) {
        return k.a(string, true);
    }

    public static int c(String string) {
        return k.a(string, false);
    }
}
