package com.google.android.exoplayer2.upstream.cache;

import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.p0;
import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
final class p extends com.google.android.exoplayer2.upstream.cache.h {

    private static final Pattern A;
    private static final Pattern y;
    private static final Pattern z;
    static {
        final int i = 32;
        p.y = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v1\\.exo$", i);
        p.z = Pattern.compile("^(.+)\\.(\\d+)\\.(\\d+)\\.v2\\.exo$", i);
        p.A = Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.v3\\.exo$", i);
    }

    private p(String string, long l2, long l3, long l4, File file5) {
        super(string, l2, l3, l4, file5, obj6, obj7, obj8);
    }

    public static com.google.android.exoplayer2.upstream.cache.p i(File file, long l2, long l3, com.google.android.exoplayer2.upstream.cache.j j4) {
        long long;
        String name;
        Object name2;
        int length;
        int i;
        long l;
        File file2;
        com.google.android.exoplayer2.upstream.cache.j jVar = obj18;
        final int i5 = 0;
        if (file.getName().endsWith(".v3.exo") == null) {
            File file4 = file;
            File file3 = p.o(file, jVar);
            if (file3 == null) {
                return i5;
            }
            file2 = file3;
            name = name2;
        } else {
            file2 = name2;
        }
        Matcher matcher = p.A.matcher(name);
        if (!matcher.matches()) {
            return i5;
        }
        String group3 = matcher.group(1);
        g.e(group3);
        final String str2 = jVar.k(Integer.parseInt((String)group3));
        if (str2 == null) {
            return i5;
        }
        if (Long.compare(l2, length) == 0) {
            i = length;
        } else {
            i = l2;
        }
        if (Long.compare(i, i6) == 0) {
            return i5;
        }
        String group = matcher.group(2);
        g.e(group);
        if (Long.compare(j4, l4) == 0) {
            String group2 = matcher.group(3);
            g.e(group2);
            l = long;
        } else {
            l = j4;
        }
        super(str2, Long.parseLong((String)group), obj7, i, obj9, l, obj11, file2);
        return pVar;
    }

    public static com.google.android.exoplayer2.upstream.cache.p j(File file, long l2, com.google.android.exoplayer2.upstream.cache.j j3) {
        return p.i(file, l2, obj2, -9223372036854775807L);
    }

    public static com.google.android.exoplayer2.upstream.cache.p k(String string, long l2, long l3) {
        super(string, l2, obj3, obj13, obj5, -9223372036854775807L, obj7, 0);
        return pVar2;
    }

    public static com.google.android.exoplayer2.upstream.cache.p m(String string, long l2) {
        super(string, l2, obj3, -1, obj5, -9223372036854775807L, obj7, 0);
        return pVar2;
    }

    public static File n(File file, int i2, long l3, long l4) {
        StringBuilder stringBuilder = new StringBuilder(60);
        stringBuilder.append(i2);
        String obj4 = ".";
        stringBuilder.append(obj4);
        stringBuilder.append(l3);
        stringBuilder.append(obj4);
        stringBuilder.append(obj7);
        stringBuilder.append(".v3.exo");
        File file2 = new File(file, stringBuilder.toString());
        return file2;
    }

    private static File o(File file, com.google.android.exoplayer2.upstream.cache.j j2) {
        String group;
        Matcher matcher;
        String name = file.getName();
        matcher = p.z.matcher(name);
        final int i = 1;
        final int i2 = 0;
        if (matcher.matches()) {
            String group2 = matcher.group(i);
            g.e(group2);
            group = p0.K0((String)group2);
        } else {
            matcher = p.y.matcher(name);
            if (matcher.matches()) {
                g.e(matcher.group(i));
            } else {
                group = i2;
            }
        }
        if (group == null) {
            return i2;
        }
        File parentFile = file.getParentFile();
        g.h(parentFile);
        String obj12 = matcher.group(2);
        g.e(obj12);
        obj12 = matcher.group(3);
        g.e(obj12);
        obj12 = p.n((File)parentFile, j2.f(group), Long.parseLong((String)obj12), obj8);
        if (file.renameTo(obj12) == null) {
            return i2;
        }
        return obj12;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.h
    public com.google.android.exoplayer2.upstream.cache.p f(File file, long l2) {
        g.f(this.v);
        super(this.a, this.b, obj4, this.c, obj6, l2, obj8, file);
        return pVar;
    }
}
