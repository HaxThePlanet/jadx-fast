package com.google.android.datatransport.cct;

import f.c.a.b.b;
import f.c.a.b.i.h;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class c implements h {

    static final String c;
    static final String d;
    private static final String e;
    private static final Set<b> f;
    public static final com.google.android.datatransport.cct.c g;
    private final String a;
    private final String b;
    static {
        c.c = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        String str4 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        c.d = str4;
        String str8 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        c.e = str8;
        b[] arr = new b[2];
        HashSet hashSet = new HashSet(Arrays.asList(b.b("proto"), b.b("json")));
        c.f = Collections.unmodifiableSet(hashSet);
        c cVar = new c(str4, str8);
        c.g = cVar;
    }

    public c(String string, String string2) {
        super();
        this.a = string;
        this.b = string2;
    }

    public static com.google.android.datatransport.cct.c c(byte[] bArr) {
        String str;
        String string = new String(bArr, Charset.forName("UTF-8"));
        if (!string.startsWith("1$")) {
        } else {
            int obj3 = 2;
            String[] split = string.substring(obj3).split(Pattern.quote("\\"), obj3);
            if (split.length != obj3) {
            } else {
                obj3 = split[0];
                if (obj3.isEmpty()) {
                } else {
                    if (split[1].isEmpty()) {
                        str = 0;
                    }
                    c cVar = new c(obj3, str);
                    return cVar;
                }
                obj3 = new IllegalArgumentException("Missing endpoint in CCTDestination extras");
                throw obj3;
            }
            obj3 = new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
            throw obj3;
        }
        obj3 = new IllegalArgumentException("Version marker missing from extras");
        throw obj3;
    }

    public Set<b> a() {
        return c.f;
    }

    @Override // f.c.a.b.i.h
    public byte[] b() {
        String str2;
        String str;
        str2 = this.b;
        if (str2 == null && this.a == null) {
            if (this.a == null) {
                return null;
            }
        }
        Object[] arr = new Object[4];
        if (str2 == null) {
            str2 = "";
        }
        return String.format("%s%s%s%s", "1$", this.a, "\\", str2).getBytes(Charset.forName("UTF-8"));
    }

    @Override // f.c.a.b.i.h
    public String d() {
        return this.b;
    }

    @Override // f.c.a.b.i.h
    public String e() {
        return this.a;
    }

    @Override // f.c.a.b.i.h
    public byte[] getExtras() {
        return b();
    }

    @Override // f.c.a.b.i.h
    public String getName() {
        return "cct";
    }
}
