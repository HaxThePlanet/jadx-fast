package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.t;
import com.google.android.exoplayer2.drm.t.b;
import com.google.android.exoplayer2.i1;
import com.google.android.exoplayer2.i1.b;
import com.google.android.exoplayer2.l2.u.h;
import com.google.android.exoplayer2.m2.a;
import com.google.android.exoplayer2.source.hls.r;
import com.google.android.exoplayer2.source.hls.r.b;
import com.google.android.exoplayer2.upstream.x.a;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.v;
import com.google.android.exoplayer2.util.z;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.a0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

/* loaded from: classes2.dex */
public final class HlsPlaylistParser implements x.a<com.google.android.exoplayer2.source.hls.playlist.h> {

    private static final Pattern A;
    private static final Pattern B;
    private static final Pattern C;
    private static final Pattern D;
    private static final Pattern E;
    private static final Pattern F;
    private static final Pattern G;
    private static final Pattern H;
    private static final Pattern I;
    private static final Pattern J;
    private static final Pattern K;
    private static final Pattern L;
    private static final Pattern M;
    private static final Pattern N;
    private static final Pattern O;
    private static final Pattern P;
    private static final Pattern Q;
    private static final Pattern R;
    private static final Pattern S;
    private static final Pattern T;
    private static final Pattern U;
    private static final Pattern V;
    private static final Pattern W;
    private static final Pattern X;
    private static final Pattern Y;
    private static final Pattern Z;
    private static final Pattern a0;
    private static final Pattern b0;
    private static final Pattern c;
    private static final Pattern d;
    private static final Pattern e;
    private static final Pattern f;
    private static final Pattern g;
    private static final Pattern h;
    private static final Pattern i;
    private static final Pattern j;
    private static final Pattern k;
    private static final Pattern l;
    private static final Pattern m;
    private static final Pattern n;
    private static final Pattern o;
    private static final Pattern p;
    private static final Pattern q;
    private static final Pattern r;
    private static final Pattern s;
    private static final Pattern t;
    private static final Pattern u;
    private static final Pattern v;
    private static final Pattern w;
    private static final Pattern x;
    private static final Pattern y;
    private static final Pattern z;
    private final com.google.android.exoplayer2.source.hls.playlist.f a;
    private final com.google.android.exoplayer2.source.hls.playlist.g b;

    public static final class DeltaUpdateException extends IOException {
    }

    private static class a {

        private final BufferedReader a;
        private final Queue<String> b;
        private String c;
        public a(Queue<String> queue, BufferedReader bufferedReader2) {
            super();
            this.b = queue;
            this.a = bufferedReader2;
        }

        @EnsuresNonNullIf(expression = "next", result = true)
        public boolean a() {
            boolean empty;
            final int i2 = 1;
            if (this.c != null) {
                return i2;
            }
            if (!this.b.isEmpty()) {
                Object poll = this.b.poll();
                g.e((String)poll);
                this.c = (String)poll;
                return i2;
            }
            String line = this.a.readLine();
            this.c = line;
            while (line != null) {
                String trim = line.trim();
                this.c = trim;
                line = this.a.readLine();
                this.c = line;
            }
            return 0;
        }

        public String b() {
            if (!a()) {
            } else {
                this.c = 0;
                return this.c;
            }
            NoSuchElementException noSuchElementException = new NoSuchElementException();
            throw noSuchElementException;
        }
    }
    static {
        HlsPlaylistParser.c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
        HlsPlaylistParser.d = Pattern.compile("VIDEO=\"(.+?)\"");
        HlsPlaylistParser.e = Pattern.compile("AUDIO=\"(.+?)\"");
        HlsPlaylistParser.f = Pattern.compile("SUBTITLES=\"(.+?)\"");
        HlsPlaylistParser.g = Pattern.compile("CLOSED-CAPTIONS=\"(.+?)\"");
        HlsPlaylistParser.h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
        HlsPlaylistParser.i = Pattern.compile("CHANNELS=\"(.+?)\"");
        HlsPlaylistParser.j = Pattern.compile("CODECS=\"(.+?)\"");
        HlsPlaylistParser.k = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
        HlsPlaylistParser.l = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
        HlsPlaylistParser.m = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
        HlsPlaylistParser.n = Pattern.compile("DURATION=([\\d\\.]+)\\b");
        HlsPlaylistParser.o = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
        HlsPlaylistParser.p = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
        HlsPlaylistParser.q = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
        HlsPlaylistParser.r = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
        HlsPlaylistParser.s = HlsPlaylistParser.c("CAN-SKIP-DATERANGES");
        HlsPlaylistParser.t = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
        HlsPlaylistParser.u = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
        HlsPlaylistParser.v = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
        HlsPlaylistParser.w = HlsPlaylistParser.c("CAN-BLOCK-RELOAD");
        HlsPlaylistParser.x = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
        HlsPlaylistParser.y = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
        HlsPlaylistParser.z = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
        HlsPlaylistParser.A = Pattern.compile("LAST-MSN=(\\d+)\\b");
        HlsPlaylistParser.B = Pattern.compile("LAST-PART=(\\d+)\\b");
        HlsPlaylistParser.C = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
        HlsPlaylistParser.D = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
        HlsPlaylistParser.E = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
        HlsPlaylistParser.F = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
        HlsPlaylistParser.G = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
        HlsPlaylistParser.H = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
        HlsPlaylistParser.I = Pattern.compile("KEYFORMAT=\"(.+?)\"");
        HlsPlaylistParser.J = Pattern.compile("KEYFORMATVERSIONS=\"(.+?)\"");
        HlsPlaylistParser.K = Pattern.compile("URI=\"(.+?)\"");
        HlsPlaylistParser.L = Pattern.compile("IV=([^,.*]+)");
        HlsPlaylistParser.M = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
        HlsPlaylistParser.N = Pattern.compile("TYPE=(PART|MAP)");
        HlsPlaylistParser.O = Pattern.compile("LANGUAGE=\"(.+?)\"");
        HlsPlaylistParser.P = Pattern.compile("NAME=\"(.+?)\"");
        HlsPlaylistParser.Q = Pattern.compile("GROUP-ID=\"(.+?)\"");
        HlsPlaylistParser.R = Pattern.compile("CHARACTERISTICS=\"(.+?)\"");
        HlsPlaylistParser.S = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
        HlsPlaylistParser.T = HlsPlaylistParser.c("AUTOSELECT");
        HlsPlaylistParser.U = HlsPlaylistParser.c("DEFAULT");
        HlsPlaylistParser.V = HlsPlaylistParser.c("FORCED");
        HlsPlaylistParser.W = HlsPlaylistParser.c("INDEPENDENT");
        HlsPlaylistParser.X = HlsPlaylistParser.c("GAP");
        HlsPlaylistParser.Y = HlsPlaylistParser.c("PRECISE");
        HlsPlaylistParser.Z = Pattern.compile("VALUE=\"(.+?)\"");
        HlsPlaylistParser.a0 = Pattern.compile("IMPORT=\"(.+?)\"");
        HlsPlaylistParser.b0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    }

    public HlsPlaylistParser() {
        super(f.n, 0);
    }

    public HlsPlaylistParser(com.google.android.exoplayer2.source.hls.playlist.f f, com.google.android.exoplayer2.source.hls.playlist.g g2) {
        super();
        this.a = f;
        this.b = g2;
    }

    private static String A(String string, Map<String, String> map2) {
        String quoteReplacement;
        boolean key;
        Matcher obj3 = HlsPlaylistParser.b0.matcher(string);
        StringBuffer stringBuffer = new StringBuffer();
        while (obj3.find()) {
            quoteReplacement = obj3.group(1);
            if (map2.containsKey(quoteReplacement)) {
            }
            obj3.appendReplacement(stringBuffer, Matcher.quoteReplacement((String)map2.get(quoteReplacement)));
        }
        obj3.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    private static int B(BufferedReader bufferedReader, boolean z2, int i3) {
        boolean whitespace;
        while (i3 != -1) {
            if (Character.isWhitespace(i3)) {
            }
            if (!z2) {
            } else {
            }
            final int obj3 = bufferedReader.read();
            if (!p0.h0(i3)) {
            }
        }
        return i3;
    }

    private static boolean b(BufferedReader bufferedReader) {
        int read;
        int read2;
        int read3;
        int i;
        int i2;
        char charAt;
        final int i3 = 0;
        if (bufferedReader.read() == 239 && bufferedReader.read() == 187 && bufferedReader.read() != 191) {
            if (bufferedReader.read() == 187) {
                if (bufferedReader.read() != 191) {
                }
                read = bufferedReader.read();
            }
            return i3;
        }
        read2 = HlsPlaylistParser.B(bufferedReader, true, read);
        i2 = i3;
        while (i2 < 7) {
            read2 = bufferedReader.read();
            i2++;
        }
        return p0.h0(HlsPlaylistParser.B(bufferedReader, i3, read2));
    }

    private static Pattern c(String string) {
        StringBuilder stringBuilder = new StringBuilder(length += 9);
        stringBuilder.append(string);
        stringBuilder.append("=(");
        stringBuilder.append("NO");
        stringBuilder.append("|");
        stringBuilder.append("YES");
        stringBuilder.append(")");
        return Pattern.compile(stringBuilder.toString());
    }

    private static t d(String string, t.b[] t$b2Arr2) {
        int i;
        t.b bVar;
        int i2;
        t.b[] arr = new t.b[b2Arr2.length];
        i = 0;
        for (Object obj : b2Arr2) {
            arr[i] = obj.a(0);
        }
        t obj5 = new t(string, arr);
        return obj5;
    }

    private static String e(long l, String string2, String string3) {
        if (string3 == null) {
            return null;
        }
        if (obj3 != null) {
            return obj3;
        }
        return Long.toHexString(l);
    }

    private static com.google.android.exoplayer2.source.hls.playlist.f.b f(ArrayList<com.google.android.exoplayer2.source.hls.playlist.f.b> arrayList, String string2) {
        int i;
        Object obj;
        boolean equals;
        i = 0;
        while (i < arrayList.size()) {
            obj = arrayList.get(i);
            i++;
        }
        return null;
    }

    private static com.google.android.exoplayer2.source.hls.playlist.f.b g(ArrayList<com.google.android.exoplayer2.source.hls.playlist.f.b> arrayList, String string2) {
        int i;
        Object obj;
        boolean equals;
        i = 0;
        while (i < arrayList.size()) {
            obj = arrayList.get(i);
            i++;
        }
        return null;
    }

    private static com.google.android.exoplayer2.source.hls.playlist.f.b h(ArrayList<com.google.android.exoplayer2.source.hls.playlist.f.b> arrayList, String string2) {
        int i;
        Object obj;
        boolean equals;
        i = 0;
        while (i < arrayList.size()) {
            obj = arrayList.get(i);
            i++;
        }
        return null;
    }

    private static double j(String string, Pattern pattern2) {
        return Double.parseDouble(HlsPlaylistParser.z(string, pattern2, Collections.emptyMap()));
    }

    private static t.b k(String string, String string2, Map<String, String> map3) {
        boolean obj7;
        final String str3 = "1";
        final int i = 0;
        final int i2 = 44;
        final String str7 = "video/mp4";
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(string2)) {
            String obj6 = HlsPlaylistParser.z(string, HlsPlaylistParser.K, map3);
            obj7 = new t.b(w0.d, str7, Base64.decode(obj6.substring(obj6.indexOf(i2)), i));
            return obj7;
        }
        if ("com.widevine".equals(string2)) {
            obj7 = new t.b(w0.d, "hls", p0.d0(string));
            return obj7;
        }
        if ("com.microsoft.playready".equals(string2) && str3.equals(HlsPlaylistParser.u(string, HlsPlaylistParser.J, str3, map3))) {
            if (str3.equals(str)) {
                obj6 = HlsPlaylistParser.z(string, HlsPlaylistParser.K, map3);
                obj7 = w0.e;
                t.b obj8 = new t.b(obj7, str7, h.a(obj7, Base64.decode(obj6.substring(obj6.indexOf(i2)), i)));
                return obj8;
            }
        }
        return null;
    }

    private static String l(String string) {
        String equals;
        String obj1;
        if (!"SAMPLE-AES-CENC".equals(string)) {
            if ("SAMPLE-AES-CTR".equals(string)) {
                obj1 = "cenc";
            } else {
                obj1 = "cbcs";
            }
        } else {
        }
        return obj1;
    }

    private static int m(String string, Pattern pattern2) {
        return Integer.parseInt(HlsPlaylistParser.z(string, pattern2, Collections.emptyMap()));
    }

    private static long n(String string, Pattern pattern2) {
        return Long.parseLong(HlsPlaylistParser.z(string, pattern2, Collections.emptyMap()));
    }

    private static com.google.android.exoplayer2.source.hls.playlist.f o(com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.a hlsPlaylistParser$a, String string2) {
        HashMap hashMap;
        int emptyList;
        String str6;
        HashMap map;
        int arrayList8;
        ArrayList arrayList;
        ArrayList arrayList4;
        int aVar;
        int str2;
        int int;
        String equals;
        ArrayList arrayList6;
        int endsWith;
        ArrayList arrayList2;
        int i9;
        int int2;
        int i11;
        ArrayList arrayList5;
        ArrayList arrayList3;
        int i12;
        Uri startsWith;
        int i7;
        ArrayList list;
        boolean equals2;
        int bVar;
        int i2;
        String startsWith2;
        int i;
        ArrayList arrayList7;
        int i10;
        int tVar;
        boolean z;
        int str5;
        String str8;
        int str3;
        int i13;
        int i6;
        int float;
        int i5;
        int i8;
        int i4;
        Object obj;
        int i3;
        int i14;
        String str9;
        String str7;
        String str;
        String str4;
        ArrayList list4;
        ArrayList list7;
        ArrayList list11;
        ArrayList list6;
        ArrayList list3;
        ArrayList list2;
        ArrayList list12;
        ArrayList list10;
        ArrayList list9;
        ArrayList list5;
        ArrayList list8;
        HashMap map2;
        str6 = string2;
        hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        ArrayList arrayList9 = new ArrayList();
        arrayList4 = new ArrayList();
        arrayList6 = new ArrayList();
        arrayList2 = new ArrayList();
        arrayList5 = new ArrayList();
        arrayList = new ArrayList();
        arrayList7 = new ArrayList();
        arrayList3 = new ArrayList();
        bVar = 0;
        i10 = 0;
        while (a.a()) {
            tVar = a.b();
            if (tVar.startsWith("#EXT")) {
            }
            startsWith = tVar.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            i8 = bVar;
            i10 |= contains;
            if (startsWith) {
            } else {
            }
            i4 = i32;
            i2 = 0;
            int i33 = HlsPlaylistParser.m(tVar, HlsPlaylistParser.h);
            list4 = arrayList7;
            list7 = arrayList5;
            arrayList7 = HlsPlaylistParser.s(tVar, HlsPlaylistParser.c, -1);
            list11 = arrayList3;
            String str24 = HlsPlaylistParser.v(tVar, HlsPlaylistParser.k, hashMap2);
            if (str24 != null) {
            } else {
            }
            list6 = arrayList2;
            i9 = -1;
            arrayList3 = -1;
            float = -1082130432;
            list2 = arrayList6;
            String str16 = HlsPlaylistParser.v(tVar, HlsPlaylistParser.l, hashMap2);
            if (str16 != null) {
            }
            list10 = arrayList4;
            arrayList4 = HlsPlaylistParser.v(tVar, HlsPlaylistParser.d, hashMap2);
            list5 = arrayList;
            arrayList = HlsPlaylistParser.v(tVar, HlsPlaylistParser.e, hashMap2);
            i6 = str10;
            hashMap = HlsPlaylistParser.v(tVar, HlsPlaylistParser.g, hashMap2);
            startsWith = o0.d(str6, HlsPlaylistParser.A(a.b(), hashMap2));
            tVar = new i1.b();
            tVar.R(arrayList9.size());
            tVar.K("application/x-mpegURL");
            tVar.I(HlsPlaylistParser.v(tVar, HlsPlaylistParser.j, hashMap2));
            tVar.G(arrayList7);
            tVar.Z(i33);
            tVar.j0(i9);
            tVar.Q(arrayList3);
            tVar.P(float);
            tVar.c0(i2);
            super(startsWith, tVar.E(), arrayList4, arrayList, i6, hashMap);
            arrayList9.add(bVar2);
            map = map2;
            if ((ArrayList)map.get(startsWith) == null) {
            }
            super(arrayList7, i33, arrayList4, arrayList, i6, hashMap);
            arrayList6.add(arrayList2);
            bVar = i8;
            i10 = i4;
            hashMap = map;
            arrayList7 = list4;
            arrayList5 = list7;
            arrayList3 = list11;
            arrayList2 = list6;
            arrayList6 = list2;
            arrayList4 = list10;
            arrayList = list5;
            str6 = string2;
            arrayList6 = new ArrayList();
            map.put(startsWith, arrayList6);
            startsWith = o0.d(str6, HlsPlaylistParser.z(tVar, HlsPlaylistParser.K, hashMap2));
            float = Float.parseFloat(str16);
            list6 = arrayList2;
            String[] strArr = p0.C0(str24, "x");
            int int3 = Integer.parseInt(strArr[0]);
            if (int3 > 0) {
            } else {
            }
            int2 = -1;
            i6 = -1;
            arrayList3 = int2;
            i9 = i6;
            if (Integer.parseInt(strArr[1]) <= 0) {
            } else {
            }
            i6 = int3;
            i2 = 16384;
            i4 = i32;
            map = hashMap;
            list5 = arrayList;
            list10 = arrayList4;
            list2 = arrayList6;
            list6 = arrayList2;
            list7 = arrayList5;
            list11 = arrayList3;
            list4 = arrayList7;
            bVar = i8;
            startsWith = HlsPlaylistParser.k(tVar, HlsPlaylistParser.u(tVar, HlsPlaylistParser.I, "identity", hashMap2), hashMap2);
            if (startsWith != null) {
            }
            str8 = new t.b[1];
            tVar = new t(HlsPlaylistParser.l(HlsPlaylistParser.z(tVar, HlsPlaylistParser.H, hashMap2)), str8);
            arrayList7.add(tVar);
            arrayList.add(tVar);
            map = hashMap;
            list5 = arrayList;
            list10 = arrayList4;
            list2 = arrayList6;
            list6 = arrayList2;
            list7 = arrayList5;
            list11 = arrayList3;
            list4 = arrayList7;
            bVar = 1;
            hashMap2.put(HlsPlaylistParser.z(tVar, HlsPlaylistParser.P, hashMap2), HlsPlaylistParser.z(tVar, HlsPlaylistParser.Z, hashMap2));
            arrayList3.add(tVar);
        }
        list8 = arrayList;
        list9 = arrayList4;
        list12 = arrayList6;
        list3 = arrayList2;
        ArrayList arrayList10 = new ArrayList();
        HashSet hashSet = new HashSet();
        aVar = 0;
        while (aVar < arrayList9.size()) {
            arrayList6 = arrayList9.get(aVar);
            if (hashSet.add(arrayList6.a)) {
            } else {
            }
            arrayList3 = 0;
            aVar++;
            if (i1Var3.B == null) {
            } else {
            }
            i11 = 0;
            g.f(i11);
            Object obj3 = hashMap.get(arrayList6.a);
            g.e((ArrayList)obj3);
            arrayList3 = 0;
            r rVar2 = new r(arrayList3, arrayList3, (List)obj3);
            bVar = new a.b[1];
            arrayList5 = new a(bVar);
            i1.b bVar4 = arrayList6.b.a();
            bVar4.X(arrayList5);
            arrayList10.add((f.b)arrayList6.a(bVar4.E()));
            i11 = 1;
        }
        i7 = arrayList8;
        emptyList = 0;
        while (emptyList < list8.size()) {
            ArrayList list14 = list8;
            endsWith = list14.get(emptyList);
            String str23 = HlsPlaylistParser.z((String)endsWith, HlsPlaylistParser.Q, hashMap2);
            arrayList5 = HlsPlaylistParser.z(endsWith, HlsPlaylistParser.P, hashMap2);
            bVar = new i1.b();
            StringBuilder stringBuilder = new StringBuilder(i28 += length2);
            stringBuilder.append(str23);
            stringBuilder.append(":");
            stringBuilder.append(arrayList5);
            bVar.S(stringBuilder.toString());
            bVar.U(arrayList5);
            bVar.K(str8);
            bVar.g0(HlsPlaylistParser.x(endsWith));
            bVar.c0(HlsPlaylistParser.w(endsWith, hashMap2));
            bVar.V(HlsPlaylistParser.v(endsWith, HlsPlaylistParser.O, hashMap2));
            String str43 = HlsPlaylistParser.v(endsWith, HlsPlaylistParser.K, hashMap2);
            if (str43 == null) {
            } else {
            }
            arrayList7 = o0.d(string2, str43);
            list8 = list14;
            com.google.android.exoplayer2.m2.a.b[] arr2 = new a.b[1];
            r rVar = new r(str23, arrayList5, Collections.emptyList());
            a aVar3 = new a(arr2);
            equals = HlsPlaylistParser.z(endsWith, HlsPlaylistParser.M, hashMap2);
            equals.hashCode();
            str3 = 2;
            aVar = -1;
            obj = i7;
            arrayList2 = list3;
            list = list12;
            z = list9;
            i13 = 0;
            emptyList++;
            list3 = arrayList2;
            list12 = list;
            list9 = z;
            str8 = i4;
            i7 = obj;
            i12 = 0;
            aVar = HlsPlaylistParser.h(arrayList9, str23);
            if (aVar != null) {
            }
            if (arrayList7 == null) {
            } else {
            }
            bVar.X(aVar3);
            aVar = new f.a(arrayList7, bVar.E(), str23, arrayList5);
            list9.add(aVar);
            obj = i7;
            arrayList2 = list3;
            list = list12;
            i1 i1Var2 = aVar.b;
            String str19 = p0.F(i1Var2.A, str3);
            bVar.I(str19);
            bVar.e0(z.g(str19));
            bVar.j0(i1Var2.I);
            bVar.Q(i1Var2.J);
            bVar.P(i1Var2.K);
            z = list9;
            aVar = HlsPlaylistParser.f(arrayList9, str23);
            if (aVar != null) {
            } else {
            }
            obj = i7;
            str3 = 0;
            endsWith = HlsPlaylistParser.v(endsWith, HlsPlaylistParser.i, hashMap2);
            if (endsWith != null) {
            } else {
            }
            i13 = 0;
            bVar.e0(str3);
            if (arrayList7 != null) {
            } else {
            }
            list = list12;
            if (aVar != null) {
            }
            arrayList2 = list3;
            obj = aVar;
            bVar.X(aVar3);
            aVar = new f.a(arrayList7, bVar.E(), str23, arrayList5);
            list12.add(aVar);
            bVar.H(Integer.parseInt(p0.D0(endsWith, "/")[0]));
            if ("audio/eac3".equals(str3) && endsWith.endsWith("/JOC")) {
            }
            if (endsWith.endsWith("/JOC")) {
            }
            bVar.I("ec+3");
            str3 = "audio/eac3-joc";
            obj = i7;
            String str46 = p0.F(i1Var5.A, 1);
            bVar.I(str46);
            str3 = z.g(str46);
            obj = i7;
            list = list12;
            z = list9;
            i13 = 0;
            String str15 = HlsPlaylistParser.z(endsWith, HlsPlaylistParser.S, hashMap2);
            if (str15.startsWith("CC")) {
            } else {
            }
            int = Integer.parseInt(str15.substring(7));
            endsWith = "application/cea-708";
            if (arrayList8 == null) {
            }
            bVar.e0(endsWith);
            bVar.F(int);
            arrayList8.add(bVar.E());
            arrayList8 = new ArrayList();
            int = Integer.parseInt(str15.substring(str3));
            endsWith = "application/cea-608";
            obj = i7;
            list = list12;
            z = list9;
            i13 = 0;
            com.google.android.exoplayer2.source.hls.playlist.f.b bVar3 = HlsPlaylistParser.g(arrayList9, str23);
            if (bVar3 != null) {
            } else {
            }
            str2 = 0;
            if (str2 == null) {
            }
            bVar.e0(str2);
            bVar.X(aVar3);
            if (arrayList7 != null) {
            } else {
            }
            arrayList2 = list3;
            v.h("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
            aVar = new f.a(arrayList7, bVar.E(), str23, arrayList5);
            list3.add(aVar);
            str2 = "text/vtt";
            String str14 = p0.F(i1Var.A, 3);
            bVar.I(str14);
            str2 = z.g(str14);
            if (equals.equals("VIDEO") == null) {
            } else {
            }
            aVar = 3;
            if (equals.equals("AUDIO") == null) {
            } else {
            }
            aVar = str3;
            if (equals.equals("CLOSED-CAPTIONS") == null) {
            } else {
            }
            aVar = 1;
            if (equals.equals("SUBTITLES") == null) {
            } else {
            }
            aVar = 0;
            arrayList7 = i12;
        }
        if (i10 != 0) {
            i = emptyList;
        } else {
            i = arrayList8;
        }
        super(string2, arrayList3, arrayList10, list9, list12, list3, arrayList5, i7, i, bVar, hashMap2, arrayList7);
        return fVar2;
    }

    private static com.google.android.exoplayer2.source.hls.playlist.g p(com.google.android.exoplayer2.source.hls.playlist.f f, com.google.android.exoplayer2.source.hls.playlist.g g2, com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser.a hlsPlaylistParser$a3, String string4) {
        Object obj2;
        int i18;
        String equals;
        boolean equals5;
        long bVar;
        String[] substring;
        Object obj4;
        ArrayList list3;
        String str9;
        int array2;
        int equals3;
        int i14;
        int i3;
        int str10;
        Object obj3;
        boolean equals2;
        Object obj5;
        int i19;
        int tVar2;
        int pattern;
        ArrayList arrayList3;
        int startsWith3;
        int length;
        ArrayList arrayList2;
        int cmp3;
        String equals4;
        int i9;
        int i34;
        String str3;
        int i2;
        boolean startsWith;
        String str2;
        int i35;
        int cmp;
        String empty3;
        Object[] array;
        int dVar;
        String values;
        int startsWith2;
        HashMap hashMap;
        int values2;
        int cmp2;
        ArrayList list;
        ArrayList arrayList;
        int i16;
        com.google.android.exoplayer2.source.hls.playlist.g.f fVar2;
        long l;
        long l5;
        int i46;
        int i15;
        int int;
        int i20;
        int i10;
        long l4;
        long l3;
        boolean z;
        int i23;
        int i4;
        int empty;
        String str4;
        int i27;
        Object obj;
        String str7;
        long empty2;
        String str11;
        int i28;
        long l2;
        int i33;
        String str;
        int i8;
        int i38;
        int i22;
        int i24;
        int i32;
        ArrayList list4;
        com.google.android.exoplayer2.source.hls.playlist.g.f fVar;
        int i37;
        HashMap map;
        com.google.android.exoplayer2.source.hls.playlist.g.b bVar2;
        String str6;
        int i39;
        int i36;
        int i5;
        int i40;
        t tVar;
        int i29;
        String str8;
        int i17;
        int i30;
        int i6;
        int i7;
        int i41;
        int i42;
        int long2;
        int i11;
        int i43;
        int i;
        int i44;
        int i25;
        int i21;
        int i12;
        int i13;
        int dVar2;
        int i31;
        int long;
        int i45;
        ArrayList list2;
        String str5;
        int i26;
        obj4 = g2;
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        arrayList = new ArrayList();
        arrayList3 = new ArrayList();
        hashMap = new HashMap();
        arrayList2 = new ArrayList();
        final long l18 = -9223372036854775807L;
        final long l21 = -9223372036854775807L;
        super(l18, obj18, 0, -9223372036854775807L, obj21, l21, obj23, 0);
        TreeMap treeMap = new TreeMap();
        int i73 = 0;
        z = z2;
        fVar = fVar3;
        str7 = str3;
        long = i31;
        i3 = 0;
        startsWith3 = 0;
        l5 = -9223372036854775807L;
        i15 = 0;
        int = 0;
        i10 = 1;
        l4 = -9223372036854775807L;
        l3 = -9223372036854775807L;
        i23 = 0;
        i4 = 0;
        i27 = 0;
        i32 = 0;
        i37 = 0;
        i42 = 0;
        long2 = -1;
        i11 = 0;
        i43 = 0;
        i44 = 0;
        i13 = 0;
        dVar2 = 0;
        while (a3.a()) {
            values = a3.b();
            if (values.startsWith("#EXT")) {
            }
            empty2 = 4696837146684686336L;
            dVar = "@";
            startsWith = i42;
            startsWith2 = i11;
            l = 0L;
            int i85 = i3;
            str10 = startsWith;
            l2 = 1;
            list2 = arrayList2;
            str5 = str3;
            if (values.startsWith("#EXT-X-KEY")) {
            } else {
            }
            i2 = i43;
            if (values.startsWith("#EXT-X-BYTERANGE")) {
            } else {
            }
            equals3 = 58;
            if (values.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
            } else {
            }
            if (values.equals("#EXT-X-DISCONTINUITY")) {
            } else {
            }
            if (values.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
            } else {
            }
            if (values.equals("#EXT-X-GAP")) {
            } else {
            }
            if (values.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
            } else {
            }
            if (values.equals("#EXT-X-ENDLIST")) {
            } else {
            }
            if (values.startsWith("#EXT-X-RENDITION-REPORT")) {
            } else {
            }
            i34 = str10;
            fVar2 = -9223372036854775807L;
            if (values.startsWith("#EXT-X-PRELOAD-HINT")) {
            } else {
            }
            bVar = i37;
            i14 = i21;
            map = hashMap;
            if (values.startsWith("#EXT-X-PART")) {
            } else {
            }
            i11 = arrayList;
            if (!values.startsWith("#")) {
            } else {
            }
            list = i11;
            int i71 = 0;
            i21 = i14;
            i11 = startsWith2;
            arrayList = list;
            hashMap = map;
            i3 = i85;
            startsWith3 = i;
            obj4 = g2;
            i37 = bVar;
            i42 = i34;
            i43 = i2;
            arrayList2 = list2;
            str3 = str5;
            obj2 = f;
            i14 += l2;
            startsWith = HlsPlaylistParser.A(values, hashMap2);
            values = Long.compare(long2, values2);
            if (values == 0) {
            } else {
            }
            if (i13 != 0 && dVar2 == 0 && (g.d)hashMap3.get(startsWith) == null) {
            }
            bVar2 = empty;
            if (i27 == 0 && !treeMap.isEmpty()) {
            } else {
            }
            i39 = array2;
            i16 = 0;
            tVar2 = i27;
            if (dVar2 != 0) {
            } else {
            }
            obj = dVar;
            super(startsWith, obj, str7, i31, str11, i44, i25, i33, tVar2, i34, HlsPlaylistParser.e(i14, str10, i34), bVar2, obj50, long2, obj52, i32, arrayList3);
            ArrayList list10 = i11;
            list10.add(dVar4);
            arrayList3 = new ArrayList();
            if (values != 0) {
            }
            empty = bVar2;
            obj4 = g2;
            i27 = tVar2;
            i11 = startsWith2;
            i32 = i16;
            i31 = i73;
            i25 = i22;
            i21 = i39;
            i3 = i85;
            startsWith3 = i;
            long2 = -1;
            i42 = i34;
            i43 = i2;
            arrayList = list10;
            hashMap = map;
            arrayList2 = list2;
            str3 = str7;
            i37 = bVar;
            bVar2 += long2;
            obj = dVar2;
            if (!treeMap.isEmpty()) {
            } else {
            }
            i39 = array2;
            array2 = treeMap.values().toArray(new t.b[0]);
            tVar2 = new t(i2, (t.b[])array2);
            if (i4 == 0) {
            }
            i4 = HlsPlaylistParser.d(i2, array2);
            if (dVar2 == 0) {
            }
            if ((g.d)hashMap3.get(startsWith) == null) {
            }
            super(startsWith, 0, l2, empty, str, 0, 0);
            hashMap3.put(startsWith, dVar);
            bVar2 = i73;
            long l17 = (long)i68;
            length = 0;
            if (z && arrayList3.isEmpty()) {
            } else {
            }
            i45 = length;
            empty3 = HlsPlaylistParser.v(values, HlsPlaylistParser.E, hashMap2);
            if (empty3 != null) {
            } else {
            }
            dVar = 1;
            empty2 = -1;
            int cmp6 = Long.compare(empty2, i28);
            if (cmp6 == 0) {
            }
            empty3 = treeMap.values().toArray(new t.b[0]);
            dVar = new t(i2, (t.b[])empty3);
            if (i27 == 0 && !treeMap.isEmpty() && i4 == 0) {
            }
            super(HlsPlaylistParser.z(values, HlsPlaylistParser.K, hashMap2), dVar2, l17, obj61, i44, i22, obj64, i27, i34, HlsPlaylistParser.e(i14, str10, i34), long, obj69, empty2, obj71, HlsPlaylistParser.q(values, HlsPlaylistParser.X, length), z3 | i45, 0);
            arrayList3.add(startsWith);
            i22 += l17;
            if (cmp6 != 0) {
            }
            i21 = i14;
            hashMap = map;
            i3 = i85;
            arrayList = list13;
            startsWith3 = i87;
            obj4 = g2;
            i37 = bVar;
            i42 = i34;
            i43 = i2;
            i11 = startsWith2;
            long += empty2;
            if (!treeMap.isEmpty()) {
            }
            empty3 = treeMap.values().toArray(new t.b[0]);
            dVar = new t(i2, (t.b[])empty3);
            if (i4 == 0) {
            }
            i27 = dVar;
            i4 = HlsPlaylistParser.d(i2, empty3);
            long = i73;
            empty3 = p0.C0(empty3, dVar);
            empty2 = long3;
            dVar = 1;
            if (empty3.length > dVar) {
            }
            long = Long.parseLong(empty3[dVar]);
            if (arrayList3.isEmpty()) {
            } else {
            }
            i45 = 1;
            if (i37 != 0) {
            } else {
            }
            if ("PART".equals(HlsPlaylistParser.z(values, HlsPlaylistParser.N, hashMap2)) == 0) {
            } else {
            }
            int i61 = -1;
            long l9 = HlsPlaylistParser.t(values, HlsPlaylistParser.F, i61);
            i30 = HlsPlaylistParser.t(values, HlsPlaylistParser.G, i61);
            array = i21;
            if (i27 == 0 && !treeMap.isEmpty()) {
            } else {
            }
            empty2 = array;
            startsWith = -1;
            values = Long.compare(l9, startsWith);
            if (values != 0) {
            } else {
            }
            if (values != 0) {
            } else {
            }
            i17 = i73;
            super(HlsPlaylistParser.z(values, HlsPlaylistParser.K, hashMap2), dVar2, 0, obj61, i44, i22, obj64, i27, i34, HlsPlaylistParser.e(array, dVar, i34), i17, obj69, i30, obj71, 0, 0, 1);
            obj4 = g2;
            i43 = i2;
            i11 = startsWith2;
            i21 = empty2;
            hashMap = map6;
            i3 = i85;
            str3 = str5;
            i37 = bVar;
            i42 = i34;
            arrayList2 = list2;
            i17 = l9;
            if (Long.compare(i30, startsWith) != 0) {
            }
            if (!treeMap.isEmpty()) {
            } else {
            }
            empty2 = array;
            array = treeMap.values().toArray(new t.b[0]);
            dVar = new t(i2, (t.b[])array);
            if (i4 == 0) {
            }
            i27 = dVar;
            i4 = HlsPlaylistParser.d(i2, array);
            i = startsWith3;
            map = hashMap;
            list = arrayList;
            i14 = i21;
            i34 = str10;
            long l8 = (long)empty4;
            if (arrayList3.isEmpty()) {
            } else {
            }
            obj5 = arrayList3;
            if (Long.compare(l3, fVar2) != 0) {
            } else {
            }
            i19 = -1;
            dVar = Uri.parse(o0.c(string4, HlsPlaylistParser.z(values, HlsPlaylistParser.K, hashMap2)));
            startsWith = new g.c(dVar, HlsPlaylistParser.t(values, HlsPlaylistParser.A, i59 -= l8), l8, HlsPlaylistParser.s(values, HlsPlaylistParser.B, i19));
            hashMap.put(dVar, startsWith);
            i = startsWith3;
            bVar = i37;
            i14 = i21;
            map = hashMap;
            list = arrayList;
            size2 -= cmp;
            obj5 = obj6.E;
            obj2 = f;
            obj4 = g2;
            i43 = i2;
            i11 = startsWith2;
            arrayList2 = list2;
            str3 = str5;
            i23 = 1;
            i42 = str10;
            i3 = i26;
            obj2 = f;
            obj4 = g2;
            i43 = i2;
            i11 = startsWith2;
            arrayList2 = list2;
            str3 = str5;
            z = true;
            obj2 = f;
            obj4 = g2;
            i43 = i2;
            i11 = startsWith2;
            arrayList2 = list2;
            str3 = str5;
            i32 = 1;
            if (Long.compare(i46, i73) == 0) {
            } else {
            }
            i34 = str10;
            i = startsWith3;
            bVar = i37;
            i14 = i21;
            fVar2 = -9223372036854775807L;
            i46 = startsWith - i25;
            obj2 = f;
            obj4 = g2;
            i43 = i2;
            i11 = startsWith2;
            arrayList2 = list2;
            str3 = str5;
            i44++;
            int = Integer.parseInt(values.substring(indexOf2 += i9));
            obj2 = f;
            obj4 = g2;
            i43 = i2;
            i11 = startsWith2;
            arrayList2 = list2;
            str3 = str5;
            i15 = 1;
            substring = p0.C0(HlsPlaylistParser.z(values, HlsPlaylistParser.D, hashMap2), dVar);
            long2 = Long.parseLong(substring[0]);
            i9 = 1;
            if (substring.length > i9) {
            }
            empty = Long.parseLong(substring[i9]);
            String str15 = HlsPlaylistParser.z(values, HlsPlaylistParser.H, hashMap2);
            equals2 = "identity";
            str9 = HlsPlaylistParser.u(values, HlsPlaylistParser.I, equals2, hashMap2);
            if ("NONE".equals(str15)) {
            } else {
            }
            equals4 = HlsPlaylistParser.v(values, HlsPlaylistParser.L, hashMap2);
            if (equals2.equals(str9) && "AES-128".equals(str15)) {
            } else {
            }
            str3 = i43;
            if (str3 == null) {
            } else {
            }
            i43 = str3;
            equals5 = HlsPlaylistParser.k(values, str9, hashMap2);
            if (equals5 != null) {
            } else {
            }
            i11 = equals4;
            bVar = l;
            obj4 = g2;
            i3 = i85;
            arrayList2 = list2;
            str3 = str5;
            i42 = bVar;
            treeMap.put(str9, equals5);
            i11 = equals4;
            i27 = bVar;
            i43 = HlsPlaylistParser.l(str15);
            if ("AES-128".equals(str15)) {
            } else {
            }
            bVar = HlsPlaylistParser.z(values, HlsPlaylistParser.K, hashMap2);
            i11 = equals4;
            treeMap.clear();
            i11 = i27;
            if (obj4 != null && arrayList.isEmpty()) {
            } else {
            }
            i35 = 0;
            g.f(i35);
            p0.i(g2);
            startsWith = (int)i58;
            i11 = startsWith2;
            dVar = i25;
            while (startsWith < i18) {
                obj3 = obj4.r.get(startsWith);
                if (Long.compare(i20, l10) != 0) {
                }
                arrayList.add(obj3);
                long l12 = obj3.B;
                if (Long.compare(l12, i82) != 0) {
                }
                startsWith2 = obj3.z;
                if (startsWith2 != 0) {
                } else {
                }
                i11 = equals;
                i21 += l2;
                startsWith++;
                dVar2 = dVar3;
                str10 = str37;
                i22 = dVar;
                i44 = i81;
                i18 = empty2;
                str3 = str5;
                obj4 = g2;
                i27 = tVar3;
                arrayList2 = list2;
                if (!startsWith2.equals(Long.toHexString(i21))) {
                }
                empty = i18;
                obj3 = (g.d)obj3.c(dVar, values);
            }
            obj2 = f;
            obj4 = g2;
            i25 = dVar;
            obj3 = obj4.r.get(startsWith);
            if (Long.compare(i20, l10) != 0) {
            }
            arrayList.add(obj3);
            l12 = obj3.B;
            if (Long.compare(l12, i82) != 0) {
            }
            startsWith2 = obj3.z;
            if (startsWith2 != 0) {
            } else {
            }
            i11 = equals;
            i21 += l2;
            startsWith++;
            dVar2 = dVar3;
            str10 = str37;
            i22 = dVar;
            i44 = i81;
            i18 = empty2;
            str3 = str5;
            obj4 = g2;
            i27 = tVar3;
            arrayList2 = list2;
            if (!startsWith2.equals(Long.toHexString(i21))) {
            }
            empty = i18;
            obj3 = (g.d)obj3.c(dVar, values);
            if (arrayList.isEmpty()) {
            } else {
            }
            i35 = 1;
            str10 = startsWith;
            str7 = HlsPlaylistParser.u(values, HlsPlaylistParser.z, str3, hashMap2);
            obj2 = f;
            i31 = startsWith;
            i11 = startsWith2;
            str10 = HlsPlaylistParser.v(values, HlsPlaylistParser.a0, hashMap2);
            if (str10 != null) {
            } else {
            }
            hashMap2.put(HlsPlaylistParser.z(values, HlsPlaylistParser.P, hashMap2), HlsPlaylistParser.z(values, HlsPlaylistParser.Z, hashMap2));
            list2 = arrayList2;
            str5 = str3;
            i34 = startsWith;
            bVar = i37;
            i2 = i43;
            i14 = i21;
            fVar2 = -9223372036854775807L;
            i = startsWith3;
            dVar = obj2.l.get(str10);
            if ((String)dVar != null) {
            }
            hashMap2.put(str10, (String)dVar);
            i10 = HlsPlaylistParser.m(values, HlsPlaylistParser.p);
            i11 = startsWith2;
            i3 = i85;
            i42 = startsWith;
            i11 = startsWith2;
            i3 = i85;
            i20 = i21;
            i80 *= dVar;
            str2 = HlsPlaylistParser.v(values, HlsPlaylistParser.E, hashMap2);
            str2 = p0.C0(str2, dVar);
            long2 = Long.parseLong(str2[0]);
            values = 1;
            if (str2 != null && str2.length > values) {
            }
            values = Long.compare(long2, i57);
            if (values == 0) {
            }
            startsWith = i42;
            dVar = i11;
            l = 0L;
            super(HlsPlaylistParser.z(values, HlsPlaylistParser.K, hashMap2), empty, l2, long2, str, startsWith, dVar);
            if (values != 0) {
            }
            i42 = startsWith;
            i11 = dVar;
            long2 = -1;
            empty += long2;
            empty = i73;
            str2 = p0.C0(str2, dVar);
            long2 = Long.parseLong(str2[0]);
            values = 1;
            if (str2.length > values) {
            }
            empty = Long.parseLong(str2[values]);
            l3 = startsWith;
            fVar = HlsPlaylistParser.y(values);
            i3 = HlsPlaylistParser.q(values, HlsPlaylistParser.Y, false);
            l5 = startsWith;
            i13 = 1;
            values = HlsPlaylistParser.z(values, HlsPlaylistParser.q, hashMap2);
            if ("VOD".equals(values)) {
            } else {
            }
            if ("EVENT".equals(values)) {
            }
            startsWith3 = 2;
            startsWith3 = 1;
            arrayList2.add(values);
        }
        int i47 = i37;
        if (i47 != 0) {
            arrayList3.add(i47);
        }
        i12 = Long.compare(i46, i73) != 0 ? 1 : i69;
        super(startsWith3, string4, arrayList2, l5, startsWith, i3, i46, startsWith2, i15, int, i20, l18, i10, l4, l, l3, l21, z, i23, i12, i4, arrayList, list3, fVar, hashMap);
        return gVar;
    }

    private static boolean q(String string, Pattern pattern2, boolean z3) {
        Matcher obj0 = pattern2.matcher(string);
        if (obj0.find()) {
            return "YES".equals(obj0.group(1));
        }
        return z3;
    }

    private static double r(String string, Pattern pattern2, double d3) {
        Matcher obj0 = pattern2.matcher(string);
        if (obj0.find()) {
            obj0 = obj0.group(1);
            g.e(obj0);
            return Double.parseDouble((String)obj0);
        }
        return d3;
    }

    private static int s(String string, Pattern pattern2, int i3) {
        Matcher obj0 = pattern2.matcher(string);
        if (obj0.find()) {
            obj0 = obj0.group(1);
            g.e(obj0);
            return Integer.parseInt((String)obj0);
        }
        return i3;
    }

    private static long t(String string, Pattern pattern2, long l3) {
        Matcher obj0 = pattern2.matcher(string);
        if (obj0.find()) {
            obj0 = obj0.group(1);
            g.e(obj0);
            return Long.parseLong((String)obj0);
        }
        return l3;
    }

    private static String u(String string, Pattern pattern2, String string3, Map<String, String> map4) {
        Object obj0;
        boolean obj1;
        String obj2;
        obj0 = pattern2.matcher(string);
        if (obj0.find()) {
            obj0 = obj0.group(1);
            g.e(obj0);
            obj2 = obj0;
        }
        if (!map4.isEmpty()) {
            if (obj2 == null) {
            } else {
                obj2 = HlsPlaylistParser.A(obj2, map4);
            }
        }
        return obj2;
    }

    private static String v(String string, Pattern pattern2, Map<String, String> map3) {
        return HlsPlaylistParser.u(string, pattern2, 0, map3);
    }

    private static int w(String string, Map<String, String> map2) {
        int i;
        String obj1 = HlsPlaylistParser.v(string, HlsPlaylistParser.R, map2);
        if (TextUtils.isEmpty(obj1)) {
            return 0;
        }
        obj1 = p0.C0(obj1, ",");
        if (p0.r(obj1, "public.accessibility.describes-video")) {
            i = 512;
        }
        if (p0.r(obj1, "public.accessibility.transcribes-spoken-dialog")) {
            i |= 4096;
        }
        if (p0.r(obj1, "public.accessibility.describes-music-and-sound")) {
            i |= 1024;
        }
        if (p0.r(obj1, "public.easy-to-read")) {
            i |= 8192;
        }
        return i;
    }

    private static int x(String string) {
        int i;
        final int i2 = 0;
        i = HlsPlaylistParser.q(string, HlsPlaylistParser.U, i2) ? 1 : i2;
        if (HlsPlaylistParser.q(string, HlsPlaylistParser.V, i2)) {
            i |= 2;
        }
        if (HlsPlaylistParser.q(string, HlsPlaylistParser.T, i2)) {
            i |= 4;
        }
        return i;
    }

    private static com.google.android.exoplayer2.source.hls.playlist.g.f y(String string) {
        int cmp;
        long d;
        long l3;
        long l2;
        long l;
        String str = string;
        final long l4 = -4332462841530417152L;
        d = HlsPlaylistParser.r(str, HlsPlaylistParser.r, l4);
        l3 = -9223372036854775807L;
        final long l5 = 4696837146684686336L;
        if (Double.compare(d, l4) == 0) {
            l2 = l3;
        } else {
            l2 = d;
        }
        int i = 0;
        double d2 = HlsPlaylistParser.r(str, HlsPlaylistParser.u, l4);
        l = Double.compare(d2, l4) == 0 ? l3 : (long)i3;
        double d3 = HlsPlaylistParser.r(str, HlsPlaylistParser.v, l4);
        if (Double.compare(d3, l4) == 0) {
        } else {
            l3 = (long)cmp;
        }
        super(l2, obj12, HlsPlaylistParser.q(str, HlsPlaylistParser.s, i), l, obj15, l3, obj17, HlsPlaylistParser.q(str, HlsPlaylistParser.w, i));
        return fVar;
    }

    private static String z(String string, Pattern pattern2, Map<String, String> map3) {
        String obj3 = HlsPlaylistParser.v(string, pattern2, map3);
        if (obj3 == null) {
        } else {
            return obj3;
        }
        String obj2 = pattern2.pattern();
        StringBuilder stringBuilder = new StringBuilder(obj3 += length);
        stringBuilder.append("Couldn't match ");
        stringBuilder.append(obj2);
        stringBuilder.append(" in ");
        stringBuilder.append(string);
        throw ParserException.c(stringBuilder.toString(), 0);
    }

    @Override // com.google.android.exoplayer2.upstream.x$a
    public Object a(Uri uri, InputStream inputStream2) {
        return i(uri, inputStream2);
    }

    @Override // com.google.android.exoplayer2.upstream.x$a
    public com.google.android.exoplayer2.source.hls.playlist.h i(Uri uri, InputStream inputStream2) {
        boolean trim;
        boolean startsWith;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream2);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ArrayDeque obj6 = new ArrayDeque();
        int i = 0;
        if (!HlsPlaylistParser.b(bufferedReader)) {
        }
        throw ParserException.c("Input does not start with the #EXTM3U header.", i);
    }
}
