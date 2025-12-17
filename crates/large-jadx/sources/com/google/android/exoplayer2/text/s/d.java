package com.google.android.exoplayer2.text.s;

import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.text.c;
import com.google.android.exoplayer2.text.c.b;
import com.google.android.exoplayer2.util.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* loaded from: classes2.dex */
final class d {

    public final String a;
    public final String b;
    public final boolean c = false;
    public final long d;
    public final long e;
    public final com.google.android.exoplayer2.text.s.g f;
    private final String[] g;
    public final String h;
    public final String i;
    public final com.google.android.exoplayer2.text.s.d j;
    private final HashMap<String, Integer> k;
    private final HashMap<String, Integer> l;
    private List<com.google.android.exoplayer2.text.s.d> m;
    private d(String string, String string2, long l3, long l4, com.google.android.exoplayer2.text.s.g g5, String[] string6Arr6, String string7, String string8, com.google.android.exoplayer2.text.s.d d9) {
        super();
        this.a = string;
        this.b = string2;
        this.i = obj10;
        this.f = string7;
        this.g = string8;
        int obj1 = string2 != null ? 1 : obj1;
        obj1 = 0;
        this.d = l3;
        this.e = g5;
        g.e(d9);
        this.h = (String)d9;
        this.j = obj11;
        obj1 = new HashMap();
        this.k = obj1;
        obj1 = new HashMap();
        this.l = obj1;
    }

    private void b(Map<String, com.google.android.exoplayer2.text.s.g> map, c.b c$b2, int i3, int i4, int i5) {
        Object spannableStringBuilder;
        int i6;
        int i2;
        com.google.android.exoplayer2.text.s.g gVar;
        com.google.android.exoplayer2.text.s.d dVar;
        Map map2;
        int i;
        int obj10;
        int obj12;
        com.google.android.exoplayer2.text.s.g gVar3 = f.f(this.f, this.g, map);
        if ((SpannableStringBuilder)b2.e() == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            b2.o(spannableStringBuilder);
        }
        f.a(spannableStringBuilder, i3, i4, gVar3, this.j, map, i5);
        if (gVar3 != null && "p".equals(this.a) && Float.compare(obj10, obj12) != 0) {
            f.a(charSequence, i3, i4, gVar3, this.j, map, i5);
            if ("p".equals(this.a)) {
                if (Float.compare(obj10, obj12) != 0) {
                    b2.m(obj10 /= obj12);
                }
                if (gVar3.m() != null) {
                    b2.p(gVar3.m());
                }
                if (gVar3.h() != null) {
                    b2.j(gVar3.h());
                }
            }
        }
    }

    public static com.google.android.exoplayer2.text.s.d c(String string, long l2, long l3, com.google.android.exoplayer2.text.s.g g4, String[] string5Arr5, String string6, String string7, com.google.android.exoplayer2.text.s.d d8) {
        super(string, 0, l2, obj4, g4, obj6, string6, string7, d8, obj21, obj22);
        return dVar3;
    }

    public static com.google.android.exoplayer2.text.s.d d(String string) {
        super(0, f.b(string), -9223372036854775807L, obj4, -9223372036854775807L, obj6, 0, 0, "", 0, 0);
        return dVar2;
    }

    private static void e(SpannableStringBuilder spannableStringBuilder) {
        int i5;
        int charAt5;
        int i2;
        int charAt3;
        int charAt2;
        int charAt;
        int length;
        int i;
        int i3;
        int spanEnd;
        int i4;
        int charAt4;
        int spanStart;
        String str;
        i = 0;
        Object[] spans = spannableStringBuilder.getSpans(i, spannableStringBuilder.length(), a.class);
        i3 = i;
        while (i3 < spans.length) {
            Object obj2 = (a[])spans[i3];
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(obj2), spannableStringBuilder.getSpanEnd(obj2), "");
            i3++;
        }
        i5 = i;
        i3 = 32;
        while (i5 < spannableStringBuilder.length()) {
            if (spannableStringBuilder.charAt(i5) == i3) {
            }
            i5++;
            i3 = 32;
            charAt = i5 + 1;
            i4 = charAt;
            while (i4 < spannableStringBuilder.length()) {
                if (spannableStringBuilder.charAt(i4) == i3) {
                }
                i4++;
            }
            i4 -= charAt;
            if (spanEnd > 0) {
            }
            spannableStringBuilder.delete(i5, spanEnd += i5);
            if (spannableStringBuilder.charAt(i4) == i3) {
            }
            i4++;
        }
        length = 1;
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(i) == i3) {
            if (spannableStringBuilder.charAt(i) == i3) {
                spannableStringBuilder.delete(i, length);
            }
        }
        i2 = i;
        spanStart = 10;
        while (i2 < length9 -= length) {
            spanEnd = i2 + 1;
            if (spannableStringBuilder.charAt(i2) == spanStart && spannableStringBuilder.charAt(spanEnd) == i3) {
            }
            i2++;
            spanStart = 10;
            spanEnd = i2 + 1;
            if (spannableStringBuilder.charAt(spanEnd) == i3) {
            }
            spannableStringBuilder.delete(spanEnd, i2 + 2);
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(length6 -= length) == i3) {
            if (spannableStringBuilder.charAt(length6 -= length) == i3) {
                spannableStringBuilder.delete(length7 -= length, spannableStringBuilder.length());
            }
        }
        while (i < length3 -= length) {
            charAt3 = i + 1;
            if (spannableStringBuilder.charAt(i) == i3 && spannableStringBuilder.charAt(charAt3) == spanStart) {
            }
            i++;
            charAt3 = i + 1;
            if (spannableStringBuilder.charAt(charAt3) == spanStart) {
            }
            spannableStringBuilder.delete(i, charAt3);
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(length4 -= length) == spanStart) {
            if (spannableStringBuilder.charAt(length4 -= length) == spanStart) {
                spannableStringBuilder.delete(length5 -= length, spannableStringBuilder.length());
            }
        }
    }

    private void i(TreeSet<Long> treeSet, boolean z2) {
        boolean valueOf;
        long valueOf2;
        int i;
        int cmp;
        int i2;
        int cmp2;
        boolean equals = "p".equals(this.a);
        String str4 = "div";
        if (!z2 && !equals) {
            if (!equals) {
                valueOf2 = this.d;
                long l = -9223372036854775807L;
                if (str4.equals(this.a) && this.i != null && Long.compare(valueOf2, l) != 0) {
                    if (this.i != null) {
                        valueOf2 = this.d;
                        l = -9223372036854775807L;
                        if (Long.compare(valueOf2, l) != 0) {
                            treeSet.add(Long.valueOf(valueOf2));
                        }
                        valueOf = this.e;
                        if (Long.compare(valueOf, l) != 0) {
                            treeSet.add(Long.valueOf(valueOf));
                        }
                    }
                }
            } else {
            }
        } else {
        }
        if (this.m == null) {
        }
        int i3 = 0;
        i = i3;
        while (i < this.m.size()) {
            if (!z2) {
            } else {
            }
            i2 = 1;
            (d)this.m.get(i).i(treeSet, i2);
            i++;
            if (equals) {
            } else {
            }
            i2 = i3;
        }
    }

    private static SpannableStringBuilder k(String string, Map<String, c.b> map2) {
        boolean bVar;
        SpannableStringBuilder spannableStringBuilder;
        if (!map2.containsKey(string)) {
            bVar = new c.b();
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.o(spannableStringBuilder);
            map2.put(string, bVar);
        }
        java.lang.CharSequence obj2 = (c.b)map2.get(string).e();
        g.e(obj2);
        return (SpannableStringBuilder)obj2;
    }

    private void n(long l, String string2, List<Pair<String, String>> list3) {
        boolean equals;
        int i;
        String str;
        String obj5;
        if ("".equals(this.h)) {
        } else {
            obj5 = this.h;
        }
        if (m(l) && "div".equals(this.a) && this.i != null) {
            if ("div".equals(this.a)) {
                if (this.i != null) {
                    Pair obj3 = new Pair(obj5, this.i);
                    obj6.add(obj3);
                }
            }
        }
        i = 0;
        while (i < g()) {
            f(i).n(l, string2, obj5);
            i++;
        }
    }

    private void o(long l, Map<String, com.google.android.exoplayer2.text.s.g> map2, Map<String, com.google.android.exoplayer2.text.s.e> map3, String string4, Map<String, c.b> map5) {
        boolean equals;
        Set entrySet;
        boolean next;
        String intValue;
        Object key;
        String str;
        int intValue2;
        int i;
        Iterator iterator;
        long l2;
        String str3;
        String str6;
        String str7;
        String str4;
        String str2;
        String str5;
        Object obj6;
        final Object obj4 = this;
        if (!m(l)) {
        }
        str5 = "".equals(obj4.h) ? map5 : equals;
        iterator = obj4.l.entrySet().iterator();
        intValue = 0;
        while (iterator.hasNext()) {
            Object next2 = iterator.next();
            key = (Map.Entry)next2.getKey();
            if (obj4.k.containsKey((String)key)) {
            }
            str = intValue;
            intValue2 = (Integer)next2.getValue().intValue();
            if (str != intValue2) {
            } else {
            }
            str4 = string4;
            obj6 = obj22;
            intValue = 0;
            Object obj = obj22.get(key);
            g.e((c.b)obj);
            Object obj2 = string4.get(str5);
            g.e((e)obj2);
            this.b(map3, (c.b)obj, str, intValue2, obj2.j);
            intValue = (Integer)obj4.k.get(key).intValue();
        }
        str2 = string4;
        Object obj7 = obj22;
        while (intValue < g()) {
            obj4.f(intValue).o(l, obj9, map3, string4, str5);
            intValue++;
            str2 = string4;
        }
    }

    private void p(long l, boolean z2, String string3, Map<String, c.b> map4) {
        boolean equals;
        String str;
        String valueOf;
        boolean z;
        Object key;
        String str2;
        Map map;
        boolean equals2;
        int i;
        int i2;
        SpannableStringBuilder obj10;
        String obj11;
        HashMap obj12;
        String obj13;
        this.k.clear();
        this.l.clear();
        if ("metadata".equals(this.a)) {
        }
        if ("".equals(this.h)) {
        } else {
            obj13 = this.h;
        }
        if (this.c && string3 != null) {
            if (string3 != null) {
                obj11 = this.b;
                g.e(obj11);
                d.k(obj13, obj14).append((CharSequence)obj11);
            } else {
                if ("br".equals(this.a) && string3 != null) {
                    if (string3 != null) {
                        d.k(obj13, obj14).append('\n');
                    } else {
                        if (m(l)) {
                            Iterator iterator = obj14.entrySet().iterator();
                            for (Map.Entry next2 : iterator) {
                                java.lang.CharSequence charSequence = (c.b)next2.getValue().e();
                                g.e(charSequence);
                                this.k.put((String)next2.getKey(), Integer.valueOf((CharSequence)charSequence.length()));
                            }
                            equals2 = "p".equals(this.a);
                            i = 0;
                            i2 = i;
                            while (i2 < g()) {
                                if (string3 == null) {
                                } else {
                                }
                                key = valueOf;
                                f(i2).p(l, z, key, obj13);
                                i2++;
                                if (equals2) {
                                } else {
                                }
                                key = i;
                            }
                            if (equals2) {
                                f.c(d.k(obj13, obj14));
                            }
                            obj10 = obj14.entrySet().iterator();
                            for (Map.Entry obj11 : obj10) {
                                obj11 = (c.b)obj11.getValue().e();
                                g.e(obj11);
                                this.l.put((String)obj11.getKey(), Integer.valueOf((CharSequence)obj11.length()));
                            }
                        }
                    }
                } else {
                }
            }
        } else {
        }
    }

    public void a(com.google.android.exoplayer2.text.s.d d) {
        Object arrayList;
        if (this.m == null) {
            arrayList = new ArrayList();
            this.m = arrayList;
        }
        this.m.add(d);
    }

    public com.google.android.exoplayer2.text.s.d f(int i) {
        final List list = this.m;
        if (list == null) {
        } else {
            return (d)list.get(i);
        }
        IndexOutOfBoundsException obj2 = new IndexOutOfBoundsException();
        throw obj2;
    }

    public int g() {
        int size;
        List list = this.m;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        return size;
    }

    public List<c> h(long l, Map<String, com.google.android.exoplayer2.text.s.g> map2, Map<String, com.google.android.exoplayer2.text.s.e> map3, Map<String, String> map4) {
        ArrayList arrayList;
        TreeMap treeMap;
        Object obj;
        long bVar;
        Object obj12;
        int obj14;
        arrayList = new ArrayList();
        n(l, map2, this.h);
        treeMap = new TreeMap();
        obj = this;
        bVar = l;
        obj.p(bVar, obj4, 0, this.h);
        obj.o(bVar, obj4, map3, map4, this.h);
        ArrayList obj10 = new ArrayList();
        Iterator obj11 = arrayList.iterator();
        while (obj11.hasNext()) {
            obj12 = obj11.next();
            arrayList = obj14.get(obj12.second);
            if ((String)arrayList == null) {
            } else {
            }
            obj = null;
            byte[] decode = Base64.decode((String)arrayList, obj);
            obj12 = map4.get(obj12.first);
            g.e((e)obj12);
            bVar = new c.b();
            bVar.f(BitmapFactory.decodeByteArray(decode, obj, decode.length));
            bVar.k(obj12.b);
            bVar.l(obj);
            bVar.h(obj12.c, obj);
            bVar.i(obj12.e);
            bVar.n(obj12.f);
            bVar.g(obj12.g);
            bVar.r(obj12.j);
            obj10.add(bVar.a());
        }
        obj11 = treeMap.entrySet().iterator();
        for (Map.Entry obj12 : obj11) {
            obj14 = map4.get(obj12.getKey());
            g.e((e)obj14);
            obj12 = obj12.getValue();
            java.lang.CharSequence charSequence = (c.b)obj12.e();
            g.e(charSequence);
            d.e((SpannableStringBuilder)charSequence);
            obj12.h(obj14.c, obj14.d);
            obj12.i(obj14.e);
            obj12.k(obj14.b);
            obj12.n(obj14.f);
            obj12.q(obj14.i, obj14.h);
            obj12.r(obj14.j);
            obj10.add(obj12.a());
        }
        return obj10;
    }

    public long[] j() {
        int i;
        long longValue;
        int i2;
        TreeSet treeSet = new TreeSet();
        i(treeSet, false);
        long[] lArr = new long[treeSet.size()];
        Iterator iterator = treeSet.iterator();
        for (Long next2 : iterator) {
            lArr[i] = next2.longValue();
            i = i2;
        }
        return lArr;
    }

    public String[] l() {
        return this.g;
    }

    public boolean m(long l) {
        int cmp2;
        int cmp3;
        int cmp;
        int obj7;
        cmp2 = this.d;
        cmp3 = -9223372036854775807L;
        if (Long.compare(cmp2, cmp3) == 0) {
            if (Long.compare(l4, cmp3) != 0) {
                if (Long.compare(cmp2, l) <= 0) {
                    if (Long.compare(l3, cmp3) != 0) {
                        if (Long.compare(cmp2, cmp3) == 0) {
                            if (Long.compare(l, l2) >= 0) {
                                if (Long.compare(cmp2, l) <= 0 && Long.compare(l, cmp2) < 0) {
                                    obj7 = Long.compare(l, cmp2) < 0 ? 1 : 0;
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
        return obj7;
    }
}
