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

/* loaded from: classes3.dex */
public class a implements r, c {

    private final String a;
    private final String b;
    private final Map<String, byte[]> c;
    private final Map<String, String> d;
    private final g0 e;
    private final Map<a, Integer> f;
    public a() {
        int short;
        java.lang.IllegalStateException exc;
        String str;
        int i3;
        short short2;
        String str3;
        StringBuilder sb2;
        net.time4j.engine.i0 i0Var2;
        int valueOf;
        net.time4j.engine.i0 i0Var3;
        StringBuilder message;
        InputStream inputStream;
        int uTF;
        java.lang.IllegalStateException exc3;
        Object linkedHashMap;
        URI uRI;
        String string2;
        int i;
        String resource;
        Object instrument;
        StringBuilder stringBuilder;
        int i4;
        int byte;
        Object string;
        ArrayList arrayList;
        int i2;
        String uTF2;
        java.lang.IllegalStateException exc2;
        String str2;
        StringBuilder sb;
        net.time4j.engine.i0 i0Var;
        final Object obj = this;
        super();
        i0Var2 = i0Var4;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i6 = 1;
        uTF = 0;
        short = System.getProperty("net.time4j.scale.leapseconds.path") != null ? i6 : uTF;
        if (short != 0) {
            obj.f = Collections.emptyMap();
        } else {
            linkedHashMap = new LinkedHashMap(50);
            obj.f = linkedHashMap;
        }
        String property2 = System.getProperty("net.time4j.tz.repository.path");
        String property3 = System.getProperty("net.time4j.tz.repository.version");
        instrument = "tzdata";
        if (property3 == null) {
            resource = "tzdata.repository";
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(instrument);
            stringBuilder.append(property3);
            stringBuilder.append(".repository");
            resource = stringBuilder.toString();
        }
        StringBuilder stringBuilder5 = new StringBuilder();
        stringBuilder5.append("tzrepo/");
        stringBuilder5.append(resource);
        String string6 = stringBuilder5.toString();
        if (property2 != null) {
            string = new File(property2, resource);
            if (string.isAbsolute()) {
                if (!string.exists()) {
                } else {
                    uRI = string.toURI();
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append("Path to tz-repository not found: ");
                stringBuilder3.append(string);
                FileNotFoundException fileNotFoundException2 = new FileNotFoundException(stringBuilder3.toString());
                throw fileNotFoundException2;
            }
            uRI = d.c().f(instrument, a.k(), string.toString());
        } else {
            uRI = d.c().f(instrument, a.k(), string6);
        }
        if (uRI != null) {
            inputStream = d.c().e(uRI, i6);
            string2 = uRI.toString();
        } else {
            string2 = str;
            inputStream = 0;
        }
        if (inputStream == null) {
            resource = a.k().getClassLoader().getResource(string6);
            if (resource == null) {
            } else {
                instrument = FirebasePerfUrlConnection.instrument(resource.openConnection());
                (URLConnection)instrument.setUseCaches(uTF);
                instrument.connect();
                inputStream = instrument.getInputStream();
                string2 = resource.toString();
            }
            StringBuilder stringBuilder4 = new StringBuilder();
            stringBuilder4.append("Classloader cannot access tz-repository: ");
            stringBuilder4.append(string6);
            FileNotFoundException fileNotFoundException = new FileNotFoundException(stringBuilder4.toString());
            throw fileNotFoundException;
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        a.i(dataInputStream, string2);
        byte = dataInputStream.readInt();
        arrayList = new ArrayList(byte);
        i2 = uTF;
        while (i2 < byte) {
            uTF2 = dataInputStream.readUTF();
            int int = dataInputStream.readInt();
            stringBuilder = new byte[int];
            i3 = 0;
            i3 += read;
            while (i3 != -1) {
                if (int <= i3) {
                    break loop_28;
                } else {
                }
                i3 += read;
            }
            if (int <= i3) {
                break;
            } else {
            }
            arrayList.add(uTF2);
            hashMap.put(uTF2, stringBuilder);
            i2++;
            str = exc2;
            i0Var2 = sb;
            uTF = 0;
        }
        str2 = str;
        valueOf = 0;
        while (valueOf < dataInputStream.readShort()) {
            hashMap2.put(dataInputStream.readUTF(), (String)arrayList.get(dataInputStream.readShort()));
            valueOf++;
        }
        if (short == 0) {
            uTF = 0;
            while (uTF < dataInputStream.readShort()) {
                obj.f.put(g0.K0(dataInputStream.readShort(), dataInputStream.readByte(), dataInputStream.readByte()), Integer.valueOf(dataInputStream.readByte()));
                uTF++;
            }
            i0Var3 = g0.K0(dataInputStream.readShort(), dataInputStream.readByte(), dataInputStream.readByte());
        } else {
            i0Var3 = i0Var;
        }
        if (inputStream != null) {
            inputStream.close();
        }
        str3 = uTF3;
        i4 = 0;
        if (i4 != 0) {
        } else {
            obj.a = str3;
            obj.b = string2;
            obj.c = Collections.unmodifiableMap(hashMap);
            obj.d = Collections.unmodifiableMap(hashMap2);
            obj.e = i0Var3;
        }
        throw i4;
    }

    private static void i(DataInputStream dataInputStream, String string2) {
        byte byte;
        if (dataInputStream.readByte() != 116) {
        } else {
            if (dataInputStream.readByte() != 122) {
            } else {
                if (dataInputStream.readByte() != 114) {
                } else {
                    if (dataInputStream.readByte() != 101) {
                    } else {
                        if (dataInputStream.readByte() != 112) {
                        } else {
                            if (dataInputStream.readByte() != 111) {
                            } else {
                            }
                        }
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid tz-repository: ");
        stringBuilder.append(string2);
        IOException obj6 = new IOException(stringBuilder.toString());
        throw obj6;
    }

    private static Class<?> k() {
        if (Boolean.getBoolean("test.environment")) {
            return Class.forName("net.time4j.tz.spi.RepositoryTest");
        }
        return a.class;
    }

    @Override // net.time4j.tz.r
    public boolean a() {
        return empty ^= 1;
    }

    public Set<String> b() {
        return this.c.keySet();
    }

    @Override // net.time4j.tz.r
    public String c() {
        return "";
    }

    @Override // net.time4j.tz.r
    public s d() {
        return null;
    }

    public Map<String, String> e() {
        return this.d;
    }

    @Override // net.time4j.tz.r
    public a f() {
        return j();
    }

    public Map<a, Integer> g() {
        return Collections.unmodifiableMap(this.f);
    }

    @Override // net.time4j.tz.r
    public String getLocation() {
        return this.b;
    }

    @Override // net.time4j.tz.r
    public String getName() {
        return "TZDB";
    }

    @Override // net.time4j.tz.r
    public String getVersion() {
        return this.a;
    }

    @Override // net.time4j.tz.r
    public m h(String string) {
        Object obj3;
        try {
            obj3 = this.c.get(string);
            if ((byte[])obj3 != null) {
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream((byte[])obj3);
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (m)objectInputStream.readObject();
            string.printStackTrace();
            string.printStackTrace();
            return null;
        }
    }

    @Override // net.time4j.tz.r
    public g0 j() {
        return this.e;
    }

    @Override // net.time4j.tz.r
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TZ-REPOSITORY(");
        stringBuilder.append(this.a);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
