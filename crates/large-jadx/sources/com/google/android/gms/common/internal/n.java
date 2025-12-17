package com.google.android.gms.common.internal;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.util.k;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class n {

    private static final com.google.android.gms.common.internal.j b;
    private static com.google.android.gms.common.internal.n c;
    private ConcurrentHashMap<String, String> a;
    static {
        j jVar = new j("LibraryVersion", "");
        n.b = jVar;
        n nVar = new n();
        n.c = nVar;
    }

    protected n() {
        super();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.a = concurrentHashMap;
    }

    public static com.google.android.gms.common.internal.n a() {
        return n.c;
    }

    public String b(String string) {
        String str;
        Throwable th;
        com.google.android.gms.common.internal.j str2;
        java.io.Closeable closeable2;
        java.io.Closeable closeable3;
        String property;
        String string2;
        String string3;
        StringBuilder stringBuilder;
        java.io.Closeable closeable;
        str = "Failed to get app version for libraryName: ";
        final String str4 = "LibraryVersion";
        r.g(string, "Please provide a valid libraryName");
        if (this.a.containsKey(string)) {
            return (String)this.a.get(string);
        }
        Properties properties = new Properties();
        Object[] arr = new Object[1];
        java.io.InputStream resourceAsStream = n.class.getResourceAsStream(String.format("/%s.properties", string));
        if (resourceAsStream != null) {
            properties.load(resourceAsStream);
            property = properties.getProperty("version", 0);
            stringBuilder = new StringBuilder(i3 += length2);
            stringBuilder.append(string);
            stringBuilder.append(" version is ");
            stringBuilder.append(property);
            n.b.d(str4, stringBuilder.toString());
        } else {
            String valueOf2 = String.valueOf(string);
            if (valueOf2.length() != 0) {
                string2 = str.concat(valueOf2);
            } else {
                string2 = new String(str);
            }
            n.b.e(str4, string2);
        }
        if (resourceAsStream != null) {
            k.a(resourceAsStream);
        }
        if (property == null) {
            n.b.b(str4, ".properties file is dropped during release process. Failure to read app version is expected during Google internal testing where locally-built libraries are used");
            property = "UNKNOWN";
        }
        this.a.put(string, property);
        return property;
    }
}
