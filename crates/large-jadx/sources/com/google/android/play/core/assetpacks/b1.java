package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.n1;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.io.SequenceInputStream;
import java.util.zip.GZIPInputStream;

/* loaded from: classes2.dex */
final class b1 {

    private static final h g;
    private final byte[] a;
    private final com.google.android.play.core.assetpacks.f0 b;
    private final n1<com.google.android.play.core.assetpacks.d4> c;
    private final n1<com.google.android.play.core.assetpacks.z> d;
    private final com.google.android.play.core.assetpacks.k1 e;
    private final com.google.android.play.core.assetpacks.u2 f;
    static {
        h hVar = new h("ExtractChunkTaskHandler");
        b1.g = hVar;
    }

    b1(com.google.android.play.core.assetpacks.f0 f0, n1<com.google.android.play.core.assetpacks.d4> n12, n1<com.google.android.play.core.assetpacks.z> n13, com.google.android.play.core.assetpacks.k1 k14, com.google.android.play.core.assetpacks.u2 u25) {
        super();
        this.a = new byte[8192];
        this.b = f0;
        this.c = n12;
        this.d = n13;
        this.e = k14;
        this.f = u25;
    }

    private final File b(com.google.android.play.core.assetpacks.a1 a1) {
        final File obj7 = this.b.C(a1.b, a1.c, a1.d, obj4);
        if (!obj7.exists()) {
            obj7.mkdirs();
        }
        return obj7;
    }

    public final void a(com.google.android.play.core.assetpacks.a1 a1) {
        InputStream inputStream2;
        int i9;
        Object obj2;
        boolean r0Var;
        boolean z2;
        int i8;
        int i2;
        GZIPInputStream sequenceInputStream;
        String str5;
        boolean z;
        File file;
        String randomAccessFile;
        String str3;
        Object[] length;
        long l;
        int i3;
        boolean read;
        boolean z3;
        long fileOutputStream;
        String str4;
        Object obj;
        int i10;
        Object obj6;
        GZIPInputStream inputStream;
        com.google.android.play.core.assetpacks.f0 f0Var;
        long l2;
        int i5;
        int i7;
        int i6;
        int i11;
        String str;
        int i4;
        int i;
        String str2;
        final Object obj4 = this;
        obj2 = a1;
        f0Var = obj4.b;
        String str34 = obj2.b;
        int i35 = obj2.c;
        long l8 = obj2.d;
        String str35 = obj2.f;
        fileOutputStream = l8;
        super(f0Var, str34, i35, fileOutputStream, obj8, str35);
        File file2 = f0Var.B(str34, i35, l8, fileOutputStream);
        if (file2.exists() == null) {
            file2.mkdirs();
        }
        i5 = 3;
        i7 = 2;
        i6 = 1;
        final int i36 = 0;
        InputStream inputStream3 = obj2.l;
        int i37 = 8192;
        if (obj2.g != i6) {
            obj = inputStream3;
        } else {
            sequenceInputStream = new GZIPInputStream(inputStream3, i37);
            obj = sequenceInputStream;
        }
        if (obj2.h > 0) {
            r0Var = g3Var.b();
            int i26 = obj2.h;
            if (r0Var.b() != i26 + -1) {
            } else {
                int i17 = r0Var.a();
                if (i17 != i6 && i17 != i7) {
                    if (i17 != i7) {
                        if (i17 != i5) {
                        } else {
                            sequenceInputStream = b1.g;
                            sequenceInputStream.a("Resuming central directory from last chunk.", new Object[i36]);
                            g3Var.d(obj, r0Var.c());
                            if (!a1.a()) {
                            } else {
                                inputStream = obj;
                                i10 = i11;
                                if (i10 != 0) {
                                    r0Var = new r0(i10);
                                    randomAccessFile = r0Var.c();
                                    while (randomAccessFile.e() == null) {
                                        if (!r0Var.e()) {
                                        }
                                        if (!r0Var.f()) {
                                        }
                                        if (r0Var.e() == null) {
                                        }
                                        randomAccessFile = r0Var.c();
                                        if (randomAccessFile.h() != null && randomAccessFile.g() == null) {
                                        } else {
                                        }
                                        g3Var.k(randomAccessFile.f(), r0Var);
                                        if (randomAccessFile.g() == null) {
                                        } else {
                                        }
                                        g3Var.j(randomAccessFile.f());
                                        File file4 = new File(b(a1), randomAccessFile.c());
                                        file4.getParentFile().mkdirs();
                                        fileOutputStream = new FileOutputStream(file4);
                                        read = r0Var.read(obj4.a, i36, i37);
                                        while (read > 0) {
                                            fileOutputStream.write(obj4.a, i36, read);
                                            read = r0Var.read(obj4.a, i36, i37);
                                        }
                                        fileOutputStream.close();
                                        fileOutputStream.write(obj4.a, i36, read);
                                        read = r0Var.read(obj4.a, i36, i37);
                                    }
                                    if (r0Var.e()) {
                                        b1.g.a("Writing central directory metadata.", new Object[i36]);
                                        g3Var.k(randomAccessFile.f(), i10);
                                    }
                                    if (!a1.a()) {
                                        try {
                                            if (randomAccessFile.e() != null) {
                                            } else {
                                            }
                                            b1.g.a("Writing slice checkpoint for partial local file header.", new Object[i36]);
                                            g3Var.h(randomAccessFile.f(), obj2.h);
                                            if (r0Var.e()) {
                                            } else {
                                            }
                                            b1.g.a("Writing slice checkpoint for central directory.", new Object[i36]);
                                            g3Var.f(obj2.h);
                                            b1.g.a("Writing slice checkpoint for partial file.", new Object[i36]);
                                            file = new File(b(a1), randomAccessFile.c());
                                            g1 g1Var6 = new g1("Partial file is of unexpected size.");
                                            throw g1Var6;
                                            b1.g.a("Writing slice checkpoint for partial unextractable file.", new Object[i36]);
                                            randomAccessFile = g3Var.c().length();
                                            g3Var.g(file.getCanonicalPath(), randomAccessFile, length, r0Var.a());
                                            inputStream.close();
                                            if (a1.a()) {
                                            }
                                            g3Var.i(obj2.h);
                                            h g1Var7 = b1.g;
                                            Object[] format3 = new Object[obj13];
                                            String str22 = th.getMessage();
                                            format3[obj14] = str22;
                                            str22 = "Writing extraction finished checkpoint failed with %s.";
                                            g1Var7.b(str22, format3);
                                            Object obj5 = obj5.a;
                                            format3 = "Writing extraction finished checkpoint failed.";
                                            g1Var7 = new g1(format3, th, obj5);
                                            throw g1Var7;
                                            Object[] arr = new Object[4];
                                            arr[i36] = Integer.valueOf(obj2.h);
                                            arr[i6] = obj2.f;
                                            arr[i7] = obj2.b;
                                            arr[3] = Integer.valueOf(obj2.a);
                                            b1.g.d("Extraction finished for chunk %s of slice %s of pack %s of session %s.", arr);
                                            (d4)obj4.c.zza().d(obj2.a, obj2.b, obj2.f, obj2.h);
                                            obj2.l.close();
                                        } catch (Throwable th) {
                                        }
                                        obj6.close();
                                        throw th;
                                    }
                                }
                            }
                            g1 g1Var3 = new g1("Chunk has ended twice during central directory. This should not be possible with chunk sizes of 50MB.", obj2.a);
                            throw g1Var3;
                        }
                        Object[] arr2 = new Object[i6];
                        arr2[i36] = Integer.valueOf(r0Var.a());
                        g1 g1Var4 = new g1(String.format("Slice checkpoint file corrupt. Unexpected FileExtractionStatus %s.", arr2), obj2.a);
                        throw g1Var4;
                    }
                    b1.g.a("Resuming zip entry from last chunk during local file header.", new Object[i36]);
                    r0Var = obj4.b.z(obj2.b, obj2.c, obj2.d, obj20);
                    if (!r0Var.exists()) {
                    } else {
                        randomAccessFile = new FileInputStream(r0Var);
                        sequenceInputStream = new SequenceInputStream(randomAccessFile, obj);
                        inputStream = obj;
                        i10 = sequenceInputStream;
                    }
                    g1 g1Var5 = new g1("Checkpoint extension file not found.", obj2.a);
                    throw g1Var5;
                }
                Object[] arr3 = new Object[i6];
                arr3[i36] = r0Var.e();
                b1.g.a("Resuming zip entry from last chunk during file %s.", arr3);
                sequenceInputStream = new File(r0Var.e());
                if (!sequenceInputStream.exists()) {
                } else {
                    randomAccessFile = new RandomAccessFile(sequenceInputStream, "rw");
                    randomAccessFile.seek(r0Var.c());
                    l = r0Var.d();
                    r0Var = (int)l2;
                    str4 = Math.max(obj.read(obj4.a, i36, r0Var), i36);
                    while (str4 > 0) {
                        randomAccessFile.write(obj4.a, i36, str4);
                        f0Var = l - l7;
                        if (Long.compare(f0Var, i33) > 0) {
                            break;
                        }
                        if (str4 <= 0) {
                            break;
                        } else {
                        }
                        l = f0Var;
                        r0Var = (int)l2;
                        str4 = Math.max(obj.read(obj4.a, i36, r0Var), i36);
                    }
                    length = randomAccessFile.length();
                    randomAccessFile.close();
                    if (str4 != r0Var) {
                    } else {
                    }
                }
                GZIPInputStream inputStream5 = obj;
                g1 g1Var2 = new g1("Partial file specified in checkpoint does not exist. Corrupt directory.", obj2.a);
                throw g1Var2;
            }
            GZIPInputStream inputStream4 = obj;
            Object[] arr5 = new Object[i7];
            arr5[i36] = Integer.valueOf(i26);
            arr5[i6] = Integer.valueOf(r0Var.b());
            g1 g1Var = new g1(String.format("Trying to resume with chunk number %s when previously processed chunk was number %s.", arr5), obj2.a);
            throw g1Var;
        }
        i10 = inputStream;
    }
}
