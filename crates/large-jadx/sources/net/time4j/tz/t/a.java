package net.time4j.tz.t;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.time4j.engine.f0;
import net.time4j.f1.a;
import net.time4j.f1.d;
import net.time4j.g0;
import net.time4j.i1.c;
import net.time4j.tz.m;
import net.time4j.tz.r;
import net.time4j.tz.s;

/* compiled from: TimezoneRepositoryProviderSPI.java */
/* loaded from: classes3.dex */
public class a implements r, c {

    private final String a;
    private final String b;
    private final Map<String, byte[]> c;
    private final Map<String, String> d;
    private final g0 e;
    private final Map<a, Integer> f;
    public a() {
        int i;
        String str;
        int i2 = 0;
        String uTF;
        net.time4j.engine.i0 i0Var;
        int i3 = 0;
        int i4 = 0;
        InputStream inputStream;
        boolean z = false;
        int i5 = 0;
        java.lang.IllegalStateException illegalStateException;
        URI uRI;
        String str2;
        Class cls;
        String message;
        StringBuilder stringBuilder;
        int i7 = 0;
        int _int;
        ArrayList arrayList;
        StringBuilder sb;
        final Object obj = this;
        str = "";
        super();
        final HashMap hashMap = new HashMap();
        final HashMap hashMap2 = new HashMap();
        boolean z2 = true;
        z = false;
        Throwable th = System.getProperty("net.time4j.scale.leapseconds.path") != null ? z2 : z;
        if ("net.time4j.scale.leapseconds.path" != 0) {
            obj.f = Collections.emptyMap();
        } else {
            int i6 = 50;
            obj.f = new LinkedHashMap(i6);
        }
        String property2 = System.getProperty("net.time4j.tz.repository.path");
        String property3 = System.getProperty("net.time4j.tz.repository.version");
        str3 = "tzdata";
        if (property3 == null) {
            str2 = "tzdata.repository";
        } else {
            stringBuilder = new StringBuilder();
            String str10 = ".repository";
            str2 = str3 + property3 + str10;
        }
        try {
            StringBuilder stringBuilder5 = new StringBuilder();
            file = "tzrepo/";
            str11 = file + str2;
        } catch (java.io.IOException ioException) {
        } catch (Throwable th1) {
            message = null;
        }
        if (property2 == null) {
            try {
                uRI = d.c().f(str3, a.k(), str11);
            } catch (java.io.IOException ioException) {
            } catch (Throwable th1) {
                message = null;
            }
            message = null;
            try {
                sb = new StringBuilder();
                message = "[ERROR] TZ-repository not available. => ";
                sb.append(message);
                message = th1.getMessage();
                sb.append(message);
                sb = sb.toString();
                illegalStateException = new IllegalStateException(sb, (System.getProperty("net.time4j.scale.leapseconds.path") != null ? z2 : z));
            } catch (Throwable th) {
            }
            if (message != null) {
                try {
                    message.close();
                } catch (java.io.IOException unused) {
                    message = illegalStateException;
                }
                if (i7 != 0) {
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i7;
                } else {
                    obj.a = uTF;
                    obj.b = str;
                    obj.c = Collections.unmodifiableMap(hashMap);
                    obj.d = Collections.unmodifiableMap(hashMap2);
                    obj.e = i0Var;
                    return;
                }
            }
        } else {
            try {
                File file2 = new File(property2, str2);
                uRI = file2.toURI();
                StringBuilder stringBuilder3 = new StringBuilder();
                String str6 = "Path to tz-repository not found: ";
                r6 = str6 + file2;
                throw new FileNotFoundException(r6);
            } catch (java.io.IOException unused) {
                throw th;
            }
        }
        if ("net.time4j.tz.repository.path" != null) {
            try {
                InputStream inputStream2 = d.c().e(uRI, z2);
            } catch (java.io.IOException unused) {
                throw th;
            }
            try {
                str = uRI.toString();
            } catch (java.io.IOException ioException) {
            } catch (Throwable th1) {
            }
        } else {
            i4 = 0;
        }
        if (i4 == 0) {
            try {
                URL resource = a.k().getClassLoader().getResource(str11);
                Object instrument = FirebasePerfUrlConnection.instrument(resource.openConnection());
                instrument.setUseCaches(z);
                instrument.connect();
                inputStream = instrument.getInputStream();
                str = resource.toString();
                StringBuilder stringBuilder4 = new StringBuilder();
                String str9 = "Classloader cannot access tz-repository: ";
                r7 = str9 + str11;
                throw new FileNotFoundException(r7);
            } catch (Throwable th) {
            } catch (java.io.IOException ioException1) {
            }
            i3 = 0;
            while (i3 < dataInputStream.readShort()) {
                hashMap2.put(dataInputStream.readUTF(), (String)arrayList.get(dataInputStream.readShort()));
                i3 = i3 + 1;
            }
            if ("net.time4j.scale.leapseconds.path" == 0) {
                i5 = 0;
                while (i5 < dataInputStream.readShort()) {
                    obj.f.put(g0.K0(dataInputStream.readShort(), dataInputStream.readByte(), dataInputStream.readByte()), Integer.valueOf(dataInputStream.readByte()));
                    i5 = i5 + 1;
                }
                g0 g0Var2 = g0.K0(dataInputStream.readShort(), dataInputStream.readByte(), dataInputStream.readByte());
            } else {
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (java.io.IOException unused) {
                    i7 = 0;
                    obj.a = uTF;
                    obj.b = str;
                    obj.c = Collections.unmodifiableMap(hashMap);
                    obj.d = Collections.unmodifiableMap(hashMap2);
                    obj.e = i0Var;
                    return;
                }
            }
        }
    }

    private static void i(DataInputStream dataInputStream, String str) throws IOException {
        if (dataInputStream.readByte() != 116) {
            StringBuilder stringBuilder = new StringBuilder();
            str = "Invalid tz-repository: ";
            str = str + str;
            throw new IOException(str);
        } else {
            byte _byte = (byte) 122;
            if (dataInputStream.readByte() == (byte) 122) {
                _byte = (byte) 114;
                if (dataInputStream.readByte() == (byte) 114) {
                    _byte = (byte) 101;
                    if (dataInputStream.readByte() == (byte) 101) {
                        _byte = (byte) 112;
                        if (dataInputStream.readByte() == (byte) 112) {
                            _byte = (byte) 111;
                            if (dataInputStream.readByte() == (byte) 111) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private static Class<?> k() {
        if (Boolean.getBoolean("test.environment")) {
            try {
            } catch (java.lang.ClassNotFoundException classNotFound) {
                throw new AssertionError(classNotFound);
            }
            return Class.forName("net.time4j.tz.spi.RepositoryTest");
        }
        return a.class;
    }

    public boolean a() {
        return !this.f.isEmpty();
    }

    public Set<String> b() {
        return this.c.keySet();
    }

    public Map<String, String> e() {
        return this.d;
    }

    public Map<a, Integer> g() {
        return Collections.unmodifiableMap(this.f);
    }

    public String getLocation() {
        return this.b;
    }

    public String getVersion() {
        return this.a;
    }

    public m h(String str) {
        try {
            Object value = this.c.get(str);
        } catch (java.lang.ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        } catch (java.io.IOException ioException1) {
            ioException1.printStackTrace();
        }
        return null;
    }

    public g0 j() {
        return this.e;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TZ-REPOSITORY(";
        String str4 = ")";
        str = str2 + this.a + str4;
        return str;
    }

    public String c() {
        return "";
    }

    public s d() {
        return null;
    }

    public String getName() {
        return "TZDB";
    }
}
