package com.google.android.datatransport.cct;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.google.android.datatransport.cct.f.a;
import com.google.android.datatransport.cct.f.a.a;
import com.google.android.datatransport.cct.f.j;
import com.google.android.datatransport.cct.f.k;
import com.google.android.datatransport.cct.f.k.a;
import com.google.android.datatransport.cct.f.k.b;
import com.google.android.datatransport.cct.f.l;
import com.google.android.datatransport.cct.f.l.a;
import com.google.android.datatransport.cct.f.m;
import com.google.android.datatransport.cct.f.m.a;
import com.google.android.datatransport.cct.f.n;
import com.google.android.datatransport.cct.f.o;
import com.google.android.datatransport.cct.f.o.a;
import com.google.android.datatransport.cct.f.o.b;
import com.google.android.datatransport.cct.f.o.c;
import com.google.android.datatransport.cct.f.p;
import com.google.android.datatransport.runtime.backends.f;
import com.google.android.datatransport.runtime.backends.g;
import com.google.android.datatransport.runtime.backends.m;
import com.google.firebase.encoders.DataEncoder;
import f.c.a.b.b;
import f.c.a.b.i.b0.a;
import f.c.a.b.i.i;
import f.c.a.b.i.j;
import f.c.a.b.i.j.a;
import f.c.a.b.i.y.a;
import f.c.a.b.i.z.b;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* loaded from: classes.dex */
final class d implements m {

    private final DataEncoder a;
    private final ConnectivityManager b;
    private final Context c;
    final URL d;
    private final a e;
    private final a f;
    private final int g;

    static final class a {

        final URL a;
        final j b;
        final String c;
        a(URL uRL, j j2, String string3) {
            super();
            this.a = uRL;
            this.b = j2;
            this.c = string3;
        }

        com.google.android.datatransport.cct.d.a a(URL uRL) {
            d.a aVar = new d.a(uRL, this.b, this.c);
            return aVar;
        }
    }

    static final class b {

        final int a;
        final URL b;
        final long c;
        b(int i, URL uRL2, long l3) {
            super();
            this.a = i;
            this.b = uRL2;
            this.c = l3;
        }
    }
    d(Context context, a a2, a a3) {
        super(context, a2, a3, 40000);
    }

    d(Context context, a a2, a a3, int i4) {
        super();
        this.a = j.b();
        this.c = context;
        this.b = (ConnectivityManager)context.getSystemService("connectivity");
        this.d = d.m(c.c);
        this.e = a3;
        this.f = a2;
        this.g = i4;
    }

    private com.google.android.datatransport.cct.d.b c(com.google.android.datatransport.cct.d.a d$a) {
        int i;
        String str;
        String str2 = "CctTransportBackend";
        a.a(str2, "Making request to: %s", a.a);
        java.net.URLConnection connection = a.a.openConnection();
        (HttpURLConnection)connection.setConnectTimeout(30000);
        connection.setReadTimeout(this.g);
        int i5 = 1;
        connection.setDoOutput(i5);
        int i6 = 0;
        connection.setInstanceFollowRedirects(i6);
        connection.setRequestMethod("POST");
        Object[] arr = new Object[i5];
        arr[i6] = "3.1.0";
        connection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", arr));
        String str5 = "Content-Encoding";
        String str8 = "gzip";
        connection.setRequestProperty(str5, str8);
        String str12 = "Content-Type";
        connection.setRequestProperty(str12, "application/json");
        connection.setRequestProperty("Accept-Encoding", str8);
        String str9 = a.c;
        if (str9 != null) {
            connection.setRequestProperty("X-Goog-Api-Key", str9);
        }
        int i8 = 0;
        int i7 = 0;
        OutputStream outputStream = connection.getOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(gZIPOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        this.a.encode(a.b, bufferedWriter);
        gZIPOutputStream.close();
        if (outputStream != null) {
            outputStream.close();
        }
        int obj13 = connection.getResponseCode();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Status Code: ");
        stringBuilder2.append(obj13);
        a.e(str2, stringBuilder2.toString());
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append("Content-Type: ");
        stringBuilder3.append(connection.getHeaderField(str12));
        a.e(str2, stringBuilder3.toString());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Content-Encoding: ");
        stringBuilder.append(connection.getHeaderField(str5));
        a.e(str2, stringBuilder.toString());
        if (obj13 != 302 && obj13 != 301) {
            if (obj13 != 301) {
                if (obj13 == 307) {
                } else {
                    if (obj13 != 200) {
                        d.b bVar = new d.b(obj13, i7, i8, obj6);
                        return bVar;
                    }
                    InputStream inputStream2 = connection.getInputStream();
                    InputStream inputStream = d.l(inputStream2, connection.getHeaderField(str5));
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    d.b bVar3 = new d.b(obj13, i7, n.b(bufferedReader).c(), i8);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                }
                return bVar3;
            }
        }
        URL url3 = new URL(connection.getHeaderField("Location"));
        d.b bVar2 = new d.b(obj13, url3, i8, obj6);
        return bVar2;
    }

    private static int d(NetworkInfo networkInfo) {
        int obj1;
        if (networkInfo == null) {
            return o.b.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        obj1 = networkInfo.getSubtype();
        if (obj1 == -1) {
            return o.b.COMBINED.getValue();
        }
        if (o.b.forNumber(obj1) != null) {
        } else {
            obj1 = 0;
        }
        return obj1;
    }

    private static int e(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return o.c.NONE.getValue();
        }
        return networkInfo.getType();
    }

    private static int f(Context context) {
        try {
            return obj2.versionCode;
            a.c("CctTransportBackend", "Unable to find version code for package", context);
            context = -1;
            return context;
        }
    }

    private j g(f f) {
        Object next4;
        boolean next3;
        Object arrayList2;
        int int;
        ArrayList arrayList;
        boolean next2;
        k.a str;
        Object next;
        a.a str2;
        String string;
        o.b forNumber;
        boolean forName;
        HashMap hashMap = new HashMap();
        Iterator obj9 = f.b().iterator();
        while (obj9.hasNext()) {
            next4 = obj9.next();
            arrayList2 = (j)next4.j();
            if (!hashMap.containsKey(arrayList2)) {
            } else {
            }
            (List)hashMap.get(arrayList2).add(next4);
            arrayList = new ArrayList();
            arrayList.add(next4);
            hashMap.put(arrayList2, arrayList);
        }
        obj9 = new ArrayList();
        Iterator iterator = hashMap.entrySet().iterator();
        for (Map.Entry next6 : iterator) {
            Object obj = (List)next6.getValue().get(0);
            arrayList = m.a();
            arrayList.f(p.DEFAULT);
            arrayList.g(this.f.getTime());
            arrayList.h(this.e.getTime());
            str = k.a();
            str.c(k.b.ANDROID_FIREBASE);
            str2 = a.a();
            str2.m(Integer.valueOf((j)obj.g("sdk-version")));
            str2.j(obj.b("model"));
            str2.f(obj.b("hardware"));
            str2.d(obj.b("device"));
            str2.l(obj.b("product"));
            str2.k(obj.b("os-uild"));
            str2.h(obj.b("manufacturer"));
            str2.e(obj.b("fingerprint"));
            str2.c(obj.b("country"));
            str2.g(obj.b("locale"));
            str2.i(obj.b("mcc_mnc"));
            str2.b(obj.b("application_build"));
            str.b(str2.a());
            arrayList.b(str.a());
            arrayList.i(Integer.parseInt((String)next6.getKey()));
            arrayList2 = new ArrayList();
            Iterator iterator2 = (List)next6.getValue().iterator();
            while (iterator2.hasNext()) {
                next = iterator2.next();
                i iVar = (j)next.e();
                string = iVar.b();
                if (string.equals(b.b("proto"))) {
                } else {
                }
                if (string.equals(b.b("json"))) {
                } else {
                }
                a.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", string);
                string = new String(iVar.a(), Charset.forName("UTF-8"));
                str2 = l.i(string);
                str2.c(next.f());
                str2.d(next.k());
                str2.h(next.h("tz-offset"));
                o.a aVar4 = o.a();
                aVar4.c(o.c.forNumber(next.g("net-type")));
                aVar4.b(o.b.forNumber(next.g("mobile-subtype")));
                str2.e(aVar4.a());
                if (next.d() != null) {
                }
                arrayList2.add(str2.a());
                str2.b(next.d());
                str2 = l.j(iVar.a());
            }
            arrayList.c(arrayList2);
            obj9.add(arrayList.a());
            next = iterator2.next();
            iVar = (j)next.e();
            string = iVar.b();
            if (string.equals(b.b("proto"))) {
            } else {
            }
            if (string.equals(b.b("json"))) {
            } else {
            }
            a.f("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", string);
            string = new String(iVar.a(), Charset.forName("UTF-8"));
            str2 = l.i(string);
            str2.c(next.f());
            str2.d(next.k());
            str2.h(next.h("tz-offset"));
            aVar4 = o.a();
            aVar4.c(o.c.forNumber(next.g("net-type")));
            aVar4.b(o.b.forNumber(next.g("mobile-subtype")));
            str2.e(aVar4.a());
            if (next.d() != null) {
            }
            arrayList2.add(str2.a());
            str2.b(next.d());
            str2 = l.j(iVar.a());
            obj3.j((String)obj1.getKey());
        }
        return j.a(obj9);
    }

    private static TelephonyManager h(Context context) {
        return (TelephonyManager)context.getSystemService("phone");
    }

    static long i() {
        Calendar.getInstance();
        return (long)i;
    }

    public static com.google.android.datatransport.cct.d.b j(com.google.android.datatransport.cct.d d, com.google.android.datatransport.cct.d.a d$a2) {
        return d.c(a2);
    }

    static com.google.android.datatransport.cct.d.a k(com.google.android.datatransport.cct.d.a d$a, com.google.android.datatransport.cct.d.b d$b2) {
        final URL url = b2.b;
        if (url != null) {
            a.a("CctTransportBackend", "Following redirect to: %s", url);
            return a.a(b2.b);
        }
        return null;
    }

    private static InputStream l(InputStream inputStream, String string2) {
        if ("gzip".equals(string2)) {
            GZIPInputStream obj2 = new GZIPInputStream(inputStream);
            return obj2;
        }
        return inputStream;
    }

    private static URL m(String string) {
        try {
            URL url = new URL(string);
            return url;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid url: ");
            stringBuilder.append(string);
            string = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string, th);
            throw illegalArgumentException;
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.m
    public g a(f f) {
        URL url;
        byte[] bArr;
        String str;
        int i;
        Object obj5;
        url = this.d;
        i = 0;
        obj5 = c.c(f.c());
        if (f.c() != null && obj5.d() != null) {
            obj5 = c.c(f.c());
            if (obj5.d() != null) {
                i = str;
            }
            if (obj5.e() != null) {
                url = obj5;
            }
        }
        d.a aVar2 = new d.a(url, g(f), i);
        b bVar = new b(this);
        obj5 = b.a(5, aVar2, bVar, a.a);
        int i2 = obj5.a;
        int i3 = 200;
        if (i2 == i3) {
            return g.e(obj5.c);
        }
        if (i2 < 500) {
            if (i2 == 404) {
            } else {
                if (i2 == 400) {
                    return g.d();
                }
            }
            try {
                return g.a();
                return g.f();
                a.c("CctTransportBackend", "Could not make request to the backend", f);
                f = g.f();
                return f;
            } catch (java.io.IOException ioException) {
            }
        }
    }

    @Override // com.google.android.datatransport.runtime.backends.m
    public j b(j j) {
        NetworkInfo activeNetworkInfo = this.b.getActiveNetworkInfo();
        j.a obj5 = j.l();
        obj5.a("sdk-version", Build.VERSION.SDK_INT);
        obj5.c("model", Build.MODEL);
        obj5.c("hardware", Build.HARDWARE);
        obj5.c("device", Build.DEVICE);
        obj5.c("product", Build.PRODUCT);
        obj5.c("os-uild", Build.ID);
        obj5.c("manufacturer", Build.MANUFACTURER);
        String str13 = "fingerprint";
        obj5.c(str13, Build.FINGERPRINT);
        obj5.b("tz-offset", d.i());
        obj5.a("net-type", d.e(activeNetworkInfo));
        obj5.a("mobile-subtype", d.d(activeNetworkInfo));
        obj5.c("country", Locale.getDefault().getCountry());
        obj5.c("locale", Locale.getDefault().getLanguage());
        obj5.c("mcc_mnc", d.h(this.c).getSimOperator());
        obj5.c("application_build", Integer.toString(d.f(this.c)));
        return obj5.d();
    }
}
