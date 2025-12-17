package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.util.Properties;

/* loaded from: classes2.dex */
final class g3 {

    private static final h h;
    private final byte[] a;
    private final com.google.android.play.core.assetpacks.f0 b;
    private final String c;
    private final int d;
    private final long e;
    private final String f;
    private int g = -1;
    static {
        h hVar = new h("SliceMetadataManager");
        g3.h = hVar;
    }

    g3(com.google.android.play.core.assetpacks.f0 f0, String string2, int i3, long l4, String string5) {
        super();
        this.a = new byte[8192];
        this.b = f0;
        this.c = string2;
        this.d = i3;
        this.e = l4;
        this.f = obj7;
        final int obj2 = -1;
    }

    private final File n() {
        File file = this.b.B(this.c, this.d, this.e, obj4);
        if (file.exists() == null) {
            file.mkdirs();
        }
        return file;
    }

    private final File o() {
        File file = this.b.A(this.c, this.d, this.e, obj4);
        file.getParentFile().mkdirs();
        file.createNewFile();
        return file;
    }

    final int a() {
        File file = this.b.A(this.c, this.d, this.e, obj4);
        if (file.exists() == null) {
            return 0;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        fileInputStream.close();
        if (Integer.parseInt(properties.getProperty("fileStatus", "-1")) == 4) {
            return -1;
        }
        String str3 = "previousChunk";
        if (properties.getProperty(str3) == null) {
        } else {
            return int++;
        }
        g1 g1Var = new g1("Slice checkpoint file corrupt.");
        throw g1Var;
    }

    final com.google.android.play.core.assetpacks.f3 b() {
        String property2;
        String property;
        String str = "-1";
        File file = this.b.A(this.c, this.d, this.e, obj5);
        if (file.exists() == null) {
        } else {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream(file);
            properties.load(fileInputStream);
            fileInputStream.close();
            String str4 = "fileStatus";
            if (properties.getProperty(str4) == null) {
            } else {
                property2 = "previousChunk";
                if (properties.getProperty(property2) == null) {
                } else {
                    this.g = Integer.parseInt(properties.getProperty("metadataFileCounter", "0"));
                    super(Integer.parseInt(properties.getProperty(str4)), properties.getProperty("fileName"), Long.parseLong(properties.getProperty("fileOffset", str)), obj9, Long.parseLong(properties.getProperty("remainingBytes", str)), obj11, Integer.parseInt(properties.getProperty(property2)));
                    return m0Var;
                }
            }
            g1 g1Var2 = new g1("Slice checkpoint file corrupt.");
            throw g1Var2;
        }
        g1 g1Var = new g1("Slice checkpoint file does not exist.");
        throw g1Var;
    }

    final File c() {
        Object[] arr = new Object[1];
        File file = new File(n(), String.format("%s-NAM.dat", Integer.valueOf(this.g)));
        return file;
    }

    final void d(InputStream inputStream, long l2) {
        File file;
        long obj5;
        int obj6;
        RandomAccessFile randomAccessFile = new RandomAccessFile(c(), "rw");
        randomAccessFile.seek(l2);
        obj5 = inputStream.read(this.a);
        do {
            obj5 = inputStream.read(this.a);
            if (obj5 == 8192) {
            }
            randomAccessFile.write(this.a, 0, obj5);
        } while (obj5 > 0);
        randomAccessFile.close();
    }

    final void e(long l, byte[] b2Arr2, int i3, int i4) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(c(), "rw");
        randomAccessFile.seek(l);
        randomAccessFile.write(i3, i4, obj8);
        randomAccessFile.close();
    }

    final void f(int i) {
        Properties properties = new Properties();
        String str4 = "3";
        properties.put("fileStatus", str4);
        properties.put("fileOffset", String.valueOf(c().length()));
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream obj4 = new FileOutputStream(o());
        properties.store(obj4, 0);
        obj4.close();
    }

    final void g(String string, long l2, long l3, int i4) {
        Properties properties = new Properties();
        properties.put("fileStatus", "1");
        properties.put("fileName", string);
        properties.put("fileOffset", String.valueOf(l2));
        properties.put("remainingBytes", String.valueOf(i4));
        properties.put("previousChunk", String.valueOf(obj9));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream obj4 = new FileOutputStream(o());
        properties.store(obj4, 0);
        obj4.close();
    }

    final void h(byte[] bArr, int i2) {
        Properties properties = new Properties();
        properties.put("fileStatus", "2");
        properties.put("previousChunk", String.valueOf(i2));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream obj10 = new FileOutputStream(o());
        properties.store(obj10, 0);
        obj10.close();
        obj10 = this.b.z(this.c, this.d, this.e, obj6);
        if (obj10.exists()) {
            obj10.delete();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(obj10);
        fileOutputStream.write(bArr);
        fileOutputStream.close();
    }

    final void i(int i) {
        Properties properties = new Properties();
        properties.put("fileStatus", "4");
        properties.put("previousChunk", String.valueOf(i));
        properties.put("metadataFileCounter", String.valueOf(this.g));
        FileOutputStream obj4 = new FileOutputStream(o());
        properties.store(obj4, 0);
        obj4.close();
    }

    final void j(byte[] bArr) {
        int i3 = 1;
        this.g = i += i3;
        Object[] arr = new Object[i3];
        arr[0] = Integer.valueOf(this.g);
        File file = new File(n(), String.format("%s-LFH.dat", arr));
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(bArr);
        fileOutputStream.close();
    }

    final void k(byte[] bArr, InputStream inputStream2) {
        File file;
        int i;
        int obj4;
        this.g = i2++;
        FileOutputStream fileOutputStream = new FileOutputStream(c());
        fileOutputStream.write(bArr);
        obj4 = inputStream2.read(this.a);
        while (obj4 > 0) {
            fileOutputStream.write(this.a, 0, obj4);
            obj4 = inputStream2.read(this.a);
        }
        fileOutputStream.close();
    }

    final void l(byte[] bArr, int i2, int i3) {
        this.g = obj3++;
        FileOutputStream fileOutputStream = new FileOutputStream(c());
        fileOutputStream.write(bArr, 0, i3);
        fileOutputStream.close();
    }

    final boolean m() {
        File file = this.b.A(this.c, this.d, this.e, obj4);
        int i3 = 0;
        if (file.exists() == null) {
            return i3;
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        fileInputStream.close();
        String str3 = "fileStatus";
        if (properties.getProperty(str3) == null) {
            g3.h.b("Slice checkpoint file corrupt while checking if extraction finished.", new Object[i3]);
            return i3;
        }
        if (Integer.parseInt(properties.getProperty(str3)) == 4) {
            return 1;
        }
        return i3;
    }
}
