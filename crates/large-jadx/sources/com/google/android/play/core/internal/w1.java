package com.google.android.play.core.internal;

import android.util.Pair;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.security.DigestException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class w1 {
    public static X509Certificate[][] a(String string) {
        int cmp;
        int cmp3;
        int i;
        int limit;
        Object first;
        int position;
        int cmp2;
        ByteOrder order;
        int i2;
        int cmp4;
        long long;
        int str;
        long i3;
        long l2;
        long l;
        RandomAccessFile randomAccessFile = new RandomAccessFile(string, "r");
        Pair pair = x1.c(randomAccessFile);
        if (pair == null) {
        } else {
            final Object obj = first2;
            final long longValue = (Long)pair.second.longValue();
            i9 += longValue;
            int i22 = 0;
            if (Long.compare(i, i22) < 0) {
                long l5 = x1.a((ByteBuffer)obj);
                if (Long.compare(l5, longValue) >= 0) {
                } else {
                    if (Long.compare(i10, longValue) != 0) {
                    } else {
                        if (Long.compare(l5, i11) < 0) {
                        } else {
                            ByteBuffer allocate = ByteBuffer.allocate(24);
                            ByteOrder lITTLE_ENDIAN = ByteOrder.LITTLE_ENDIAN;
                            allocate.order(lITTLE_ENDIAN);
                            randomAccessFile.seek(l5 - l6);
                            randomAccessFile.readFully(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                            if (Long.compare(long, l2) != 0) {
                            } else {
                                if (Long.compare(long, l2) != 0) {
                                } else {
                                    try {
                                        i2 = 0;
                                        long long4 = allocate.getLong(i2);
                                        if (Long.compare(long4, i3) < 0) {
                                        } else {
                                        }
                                        if (Long.compare(long4, i3) > 0) {
                                        } else {
                                        }
                                        int i5 = (int)i34;
                                        str = l5 - l7;
                                        if (Long.compare(str, i22) < 0) {
                                        } else {
                                        }
                                        ByteBuffer allocate2 = ByteBuffer.allocate(i5);
                                        allocate2.order(lITTLE_ENDIAN);
                                        randomAccessFile.seek(str);
                                        byte[] array2 = allocate2.array();
                                        randomAccessFile.readFully(array2, allocate2.arrayOffset(), allocate2.capacity());
                                        long long3 = allocate2.getLong(i2);
                                        if (Long.compare(long3, long4) != 0) {
                                        } else {
                                        }
                                        Pair create = Pair.create(allocate2, Long.valueOf(str));
                                        first = create.first;
                                        if ((ByteBuffer)first.order() != lITTLE_ENDIAN) {
                                        } else {
                                        }
                                        capacity2 += -24;
                                        if (i6 < 8) {
                                        } else {
                                        }
                                        if (i6 > first.capacity()) {
                                        } else {
                                        }
                                        first.position(i2);
                                        first.limit(i6);
                                        first.position(8);
                                        ByteBuffer slice = first.slice();
                                        slice.order(first.order());
                                        first.position(i2);
                                        first.limit(first.limit());
                                        first.position(first.position());
                                        while (slice.hasRemaining()) {
                                            i2++;
                                            int i17 = 8;
                                            long long2 = slice.getLong();
                                            String str23 = " size out of range: ";
                                            str = "APK Signing Block entry #";
                                            limit = (int)long2;
                                            slice.position(position2 += limit);
                                        }
                                        i2++;
                                        i17 = 8;
                                        if (slice.remaining() < i17) {
                                        } else {
                                        }
                                        long2 = slice.getLong();
                                        str23 = " size out of range: ";
                                        str = "APK Signing Block entry #";
                                        if (Long.compare(long2, i24) < 0) {
                                        } else {
                                        }
                                        if (Long.compare(long2, l) > 0) {
                                        } else {
                                        }
                                        limit = (int)long2;
                                        if (limit > slice.remaining()) {
                                        } else {
                                        }
                                        if (slice.getInt() == 1896449818) {
                                        } else {
                                        }
                                        super(w1.e(slice, limit += -4), (Long)create.second.longValue(), i2, l5, obj8, longValue, obj10, obj, 0);
                                        randomAccessFile.close();
                                        randomAccessFile.close();
                                        return w1.l(randomAccessFile.getChannel(), t1Var);
                                        slice.position(position2 += limit);
                                        StringBuilder stringBuilder9 = new StringBuilder(91);
                                        stringBuilder9.append(str);
                                        stringBuilder9.append(i2);
                                        stringBuilder9.append(str23);
                                        stringBuilder9.append(limit);
                                        stringBuilder9.append(", available: ");
                                        stringBuilder9.append(slice.remaining());
                                        zzf zzf13 = new zzf(stringBuilder9.toString());
                                        throw zzf13;
                                        StringBuilder stringBuilder10 = new StringBuilder(76);
                                        stringBuilder10.append(str);
                                        stringBuilder10.append(i2);
                                        stringBuilder10.append(str23);
                                        stringBuilder10.append(long2);
                                        zzf zzf6 = new zzf(stringBuilder10.toString());
                                        throw zzf6;
                                        StringBuilder stringBuilder3 = new StringBuilder(70);
                                        stringBuilder3.append("Insufficient data to read size of APK Signing Block entry #");
                                        stringBuilder3.append(i2);
                                        zzf zzf5 = new zzf(stringBuilder3.toString());
                                        throw zzf5;
                                        zzf zzf4 = new zzf("No APK Signature Scheme v2 block in APK Signing Block");
                                        throw zzf4;
                                        obj3.position(obj6);
                                        obj3.limit(obj2);
                                        obj3.position(obj4);
                                        throw th;
                                        StringBuilder stringBuilder8 = new StringBuilder(41);
                                        stringBuilder8.append("end > capacity: ");
                                        stringBuilder8.append(i6);
                                        stringBuilder8.append(" > ");
                                        stringBuilder8.append(first.capacity());
                                        IllegalArgumentException illegalArgumentException3 = new IllegalArgumentException(stringBuilder8.toString());
                                        throw illegalArgumentException3;
                                        StringBuilder stringBuilder7 = new StringBuilder(38);
                                        stringBuilder7.append("end < start: ");
                                        stringBuilder7.append(i6);
                                        stringBuilder7.append(" < ");
                                        stringBuilder7.append(8);
                                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder7.toString());
                                        throw illegalArgumentException2;
                                        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("ByteBuffer byte order must be little endian");
                                        throw illegalArgumentException;
                                        StringBuilder stringBuilder2 = new StringBuilder(103);
                                        stringBuilder2.append("APK Signing Block sizes in header and footer do not match: ");
                                        stringBuilder2.append(long3);
                                        stringBuilder2.append(" vs ");
                                        stringBuilder2.append(long4);
                                        zzf zzf3 = new zzf(stringBuilder2.toString());
                                        throw zzf3;
                                        StringBuilder stringBuilder4 = new StringBuilder(59);
                                        stringBuilder4.append("APK Signing Block offset out of range: ");
                                        stringBuilder4.append(str);
                                        zzf zzf7 = new zzf(stringBuilder4.toString());
                                        throw zzf7;
                                        StringBuilder stringBuilder5 = new StringBuilder(57);
                                        stringBuilder5.append("APK Signing Block size out of range: ");
                                        stringBuilder5.append(long4);
                                        zzf zzf8 = new zzf(stringBuilder5.toString());
                                        throw zzf8;
                                        zzf zzf9 = new zzf("No APK Signing Block before ZIP Central Directory");
                                        throw zzf9;
                                        StringBuilder stringBuilder = new StringBuilder(87);
                                        stringBuilder.append("APK too small for APK Signing Block. ZIP Central Directory offset: ");
                                        stringBuilder.append(l5);
                                        zzf zzf2 = new zzf(stringBuilder.toString());
                                        throw zzf2;
                                        zzf zzf10 = new zzf("ZIP Central Directory is not immediately followed by End of Central Directory");
                                        throw zzf10;
                                        StringBuilder stringBuilder6 = new StringBuilder(122);
                                        stringBuilder6.append("ZIP Central Directory offset out of range: ");
                                        stringBuilder6.append(l5);
                                        stringBuilder6.append(". ZIP End of Central Directory offset: ");
                                        stringBuilder6.append(longValue);
                                        zzf zzf11 = new zzf(stringBuilder6.toString());
                                        throw zzf11;
                                        zzf zzf = new zzf("ZIP64 APK not supported");
                                        throw zzf;
                                        StringBuilder stringBuilder11 = new StringBuilder(102);
                                        stringBuilder11.append("Not an APK file: ZIP End of Central Directory record not found in file with ");
                                        stringBuilder11.append(randomAccessFile.length());
                                        stringBuilder11.append(" bytes");
                                        zzf zzf12 = new zzf(stringBuilder11.toString());
                                        throw zzf12;
                                        obj1.close();
                                        throw th;
                                    } catch (Throwable th) {
                                    }
                                }
                            }
                        }
                    }
                }
            } else {
                randomAccessFile.seek(i);
                if (randomAccessFile.readInt() == 1347094023) {
                } else {
                }
            }
        }
    }

    private static int b(int i) {
        if (i != 1) {
            if (i != 2) {
            } else {
                return 64;
            }
            StringBuilder stringBuilder = new StringBuilder(44);
            stringBuilder.append("Unknown content digest algorthm: ");
            stringBuilder.append(i);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        return 32;
    }

    private static int c(int i) {
        int i2;
        String obj3;
        if (i != 513 && i != 514 && i != 769) {
            if (i != 514) {
                if (i != 769) {
                    switch (i) {
                        case 257:
                            return 1;
                        case 258:
                            return 2;
                        default:
                            obj3 = String.valueOf(Long.toHexString((long)i));
                            String str = "Unknown signature algorithm: 0x";
                            obj3 = str.concat(obj3);
                            obj3 = new String(str);
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(obj3);
                    throw illegalArgumentException;
                }
            }
        }
    }

    private static String d(int i) {
        if (i != 1) {
            if (i != 2) {
            } else {
                return "SHA-512";
            }
            StringBuilder stringBuilder = new StringBuilder(44);
            stringBuilder.append("Unknown content digest algorthm: ");
            stringBuilder.append(i);
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
            throw illegalArgumentException;
        }
        return "SHA-256";
    }

    private static ByteBuffer e(ByteBuffer byteBuffer, int i2) {
        if (i2 < 0) {
        } else {
            int limit = byteBuffer.limit();
            int position = byteBuffer.position();
            i2 += position;
            if (obj4 < position) {
            } else {
                if (obj4 > limit) {
                } else {
                    byteBuffer.limit(obj4);
                    ByteBuffer slice = byteBuffer.slice();
                    slice.order(byteBuffer.order());
                    byteBuffer.position(obj4);
                    byteBuffer.limit(limit);
                    return slice;
                }
            }
            BufferUnderflowException obj3 = new BufferUnderflowException();
            throw obj3;
        }
        StringBuilder stringBuilder = new StringBuilder(17);
        stringBuilder.append("size: ");
        stringBuilder.append(i2);
        obj3 = new IllegalArgumentException(stringBuilder.toString());
        throw obj3;
    }

    private static ByteBuffer f(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() < 4) {
        } else {
            int int = byteBuffer.getInt();
            if (int < 0) {
            } else {
                if (int > byteBuffer.remaining()) {
                } else {
                    return w1.e(byteBuffer, int);
                }
                StringBuilder stringBuilder2 = new StringBuilder(101);
                stringBuilder2.append("Length-prefixed field longer than remaining buffer. Field length: ");
                stringBuilder2.append(int);
                stringBuilder2.append(", remaining: ");
                stringBuilder2.append(byteBuffer.remaining());
                IOException iOException2 = new IOException(stringBuilder2.toString());
                throw iOException2;
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("Negative length");
            throw obj4;
        }
        StringBuilder stringBuilder = new StringBuilder(93);
        stringBuilder.append("Remaining buffer too short to contain length of length-prefixed field. Remaining: ");
        stringBuilder.append(byteBuffer.remaining());
        IOException iOException = new IOException(stringBuilder.toString());
        throw iOException;
    }

    private static void g(int i, byte[] b2Arr2, int i3) {
        b2Arr2[1] = (byte)obj3;
        b2Arr2[2] = (byte)obj3;
        b2Arr2[3] = (byte)obj3;
        b2Arr2[4] = (byte)obj1;
    }

    private static void h(Map<Integer, byte[]> map, FileChannel fileChannel2, long l3, long l4, long l5, ByteBuffer byteBuffer6) {
        com.google.android.play.core.internal.s1 s1Var;
        com.google.android.play.core.internal.a0 a0Var;
        com.google.android.play.core.internal.z0[] arr;
        int i;
        int i3;
        long intValue;
        int i2;
        if (map.isEmpty()) {
        } else {
            super(fileChannel2, 0, obj4, l3, obj6);
            super(fileChannel2, l5, obj8, obj17 - l5, obj10);
            ByteBuffer duplicate = obj19.duplicate();
            duplicate.order(ByteOrder.LITTLE_ENDIAN);
            ByteBuffer byteBuffer = l3;
            x1.d(duplicate, l3);
            a0Var = new a0(duplicate);
            int size = map.size();
            final int[] iArr = new int[size];
            Iterator iterator = map.keySet().iterator();
            i = 0;
            i3 = i;
            i2 = 1;
            for (Integer next2 : iterator) {
                iArr[i3] = next2.intValue();
                i3 += i2;
                i2 = 1;
            }
            arr = new z0[3];
            arr[i] = s1Var2;
            arr[i2] = s1Var;
            arr[2] = a0Var;
            while (i < size) {
                s1Var = iArr[i];
                arr = map;
                i++;
            }
        }
        SecurityException securityException = new SecurityException("No digests provided");
        throw securityException;
    }

    private static byte[] i(ByteBuffer byteBuffer) {
        int int = byteBuffer.getInt();
        if (int < 0) {
        } else {
            if (int > byteBuffer.remaining()) {
            } else {
                byte[] bArr = new byte[int];
                byteBuffer.get(bArr);
                return bArr;
            }
            StringBuilder stringBuilder = new StringBuilder(90);
            stringBuilder.append("Underflow while reading length-prefixed value. Length: ");
            stringBuilder.append(int);
            stringBuilder.append(", available: ");
            stringBuilder.append(byteBuffer.remaining());
            IOException iOException = new IOException(stringBuilder.toString());
            throw iOException;
        }
        IOException obj4 = new IOException("Negative length");
        throw obj4;
    }

    private static X509Certificate[] j(ByteBuffer byteBuffer, Map<Integer, byte[]> map2, CertificateFactory certificateFactory3) {
        String concat;
        Pair create;
        String concat2;
        String valueOf3;
        String valueOf;
        Object equal;
        int i8;
        String str3;
        byte[] bArr;
        String str4;
        int certificate;
        int i9;
        int u1Var;
        int i7;
        Signature instance;
        int int;
        ByteBuffer byteBuffer2;
        boolean valueOf2;
        Integer valueOf4;
        int i2;
        int i3;
        int i5;
        int i;
        PSSParameterSpec pSSParameterSpec;
        String str;
        String str2;
        MGF1ParameterSpec mGF1ParameterSpec;
        int i6;
        int i4;
        ByteBuffer byteBuffer3 = w1.f(byteBuffer);
        ByteBuffer byteBuffer5 = w1.f(byteBuffer);
        byte[] bArr2 = w1.i(byteBuffer);
        ArrayList arrayList2 = new ArrayList();
        int i12 = -1;
        i9 = 0;
        u1Var = i12;
        int = i9;
        i7 = 0;
        int i13 = 8;
        i2 = 769;
        i3 = 514;
        i5 = 513;
        i = 1;
        while (byteBuffer5.hasRemaining()) {
            i7++;
            byteBuffer2 = w1.f(byteBuffer5);
            str4 = byteBuffer2.getInt();
            arrayList2.add(Integer.valueOf(str4));
            if (str4 != i5 && str4 != i3 && str4 != i2) {
            } else {
            }
            if (u1Var != i12) {
            } else {
            }
            int = bArr3;
            u1Var = str4;
            i13 = 8;
            i2 = 769;
            i3 = 514;
            i5 = 513;
            i = 1;
            if (w1.c(str4) != i) {
            }
            if (w1.c(u1Var) != i) {
            } else {
            }
            if (str4 != i3) {
            } else {
            }
            if (str4 != i2) {
            } else {
            }
            if (/* condition */) {
            } else {
            }
        }
        if (u1Var == i12 && i7 == 0) {
            if (i7 == 0) {
                SecurityException securityException2 = new SecurityException("No signatures found");
                throw securityException2;
            }
            SecurityException securityException = new SecurityException("No supported signatures found");
            throw securityException;
        }
        String str7 = "Unknown signature algorithm: 0x";
        if (u1Var != i5 && u1Var != i3) {
            if (u1Var != i3) {
                if (u1Var != i2) {
                    if (/* condition */) {
                        str3 = "RSA";
                    } else {
                        valueOf3 = String.valueOf(Long.toHexString((long)u1Var));
                        if (valueOf3.length() != 0) {
                            concat = str7.concat(valueOf3);
                        } else {
                            valueOf3 = new String(str7);
                            concat = valueOf3;
                        }
                    }
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(concat);
                    throw illegalArgumentException;
                }
                str3 = "DSA";
            } else {
                str3 = "EC";
            }
        } else {
        }
        if (u1Var != i5) {
            if (u1Var != i3) {
                if (u1Var != i2) {
                    switch (u1Var) {
                        case 257:
                            super("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1);
                            create = Pair.create("SHA256withRSA/PSS", pSSParameterSpec2);
                            Object first = create.first;
                            Object second = create.second;
                            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(bArr2);
                            instance = Signature.getInstance((String)first);
                            instance.initVerify(KeyFactory.getInstance(str3).generatePublic(x509EncodedKeySpec));
                            instance.setParameter((AlgorithmParameterSpec)second);
                            instance.update(byteBuffer3);
                            byteBuffer3.clear();
                            ByteBuffer byteBuffer6 = w1.f(byteBuffer3);
                            ArrayList arrayList3 = new ArrayList();
                            certificate = 0;
                            certificate += i;
                            instance = w1.f(byteBuffer6);
                            int = instance.getInt();
                            arrayList3.add(Integer.valueOf(int));
                            i9 = w1.i(instance);
                            IOException iOException = new IOException("Record too short");
                            throw iOException;
                            int i11 = w1.c(u1Var);
                            equal = map2.put(Integer.valueOf(i11), i9);
                            SecurityException securityException4 = new SecurityException(w1.d(i11).concat(" contents digest does not match the digest specified by a preceding signer"));
                            throw securityException4;
                            ByteBuffer byteBuffer4 = w1.f(byteBuffer3);
                            ArrayList arrayList = new ArrayList();
                            i8 = 0;
                            i8 += i;
                            bArr = w1.i(byteBuffer4);
                            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                            u1Var = new u1((X509Certificate)certificateFactory3.generateCertificate(byteArrayInputStream), bArr);
                            arrayList.add(u1Var);
                            return (X509Certificate[])arrayList.toArray(new X509Certificate[arrayList.size()]);
                            SecurityException securityException5 = new SecurityException("Public key mismatch between certificate and signature record");
                            throw securityException5;
                            SecurityException securityException6 = new SecurityException("No certificates listed");
                            throw securityException6;
                            SecurityException securityException3 = new SecurityException("Signature algorithms don't match between digests and signatures records");
                            throw securityException3;
                            SecurityException securityException7 = new SecurityException(String.valueOf(first).concat(" signature did not verify"));
                            throw securityException7;
                        case 258:
                            super("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1);
                            create = Pair.create("SHA512withRSA/PSS", pSSParameterSpec3);
                            first = create.first;
                            second = create.second;
                            x509EncodedKeySpec = new X509EncodedKeySpec(bArr2);
                            instance = Signature.getInstance((String)first);
                            instance.initVerify(KeyFactory.getInstance(str3).generatePublic(x509EncodedKeySpec));
                            instance.setParameter((AlgorithmParameterSpec)second);
                            instance.update(byteBuffer3);
                            byteBuffer3.clear();
                            byteBuffer6 = w1.f(byteBuffer3);
                            arrayList3 = new ArrayList();
                            certificate = 0;
                            certificate += i;
                            instance = w1.f(byteBuffer6);
                            int = instance.getInt();
                            arrayList3.add(Integer.valueOf(int));
                            i9 = w1.i(instance);
                            iOException = new IOException("Record too short");
                            throw iOException;
                            i11 = w1.c(u1Var);
                            equal = map2.put(Integer.valueOf(i11), i9);
                            securityException4 = new SecurityException(w1.d(i11).concat(" contents digest does not match the digest specified by a preceding signer"));
                            throw securityException4;
                            byteBuffer4 = w1.f(byteBuffer3);
                            arrayList = new ArrayList();
                            i8 = 0;
                            i8 += i;
                            bArr = w1.i(byteBuffer4);
                            byteArrayInputStream = new ByteArrayInputStream(bArr);
                            u1Var = new u1((X509Certificate)certificateFactory3.generateCertificate(byteArrayInputStream), bArr);
                            arrayList.add(u1Var);
                            return (X509Certificate[])arrayList.toArray(new X509Certificate[arrayList.size()]);
                            securityException5 = new SecurityException("Public key mismatch between certificate and signature record");
                            throw securityException5;
                            securityException6 = new SecurityException("No certificates listed");
                            throw securityException6;
                            securityException3 = new SecurityException("Signature algorithms don't match between digests and signatures records");
                            throw securityException3;
                            securityException7 = new SecurityException(String.valueOf(first).concat(" signature did not verify"));
                            throw securityException7;
                        case 259:
                            create = Pair.create("SHA256withRSA", i9);
                            first = create.first;
                            second = create.second;
                            x509EncodedKeySpec = new X509EncodedKeySpec(bArr2);
                            instance = Signature.getInstance((String)first);
                            instance.initVerify(KeyFactory.getInstance(str3).generatePublic(x509EncodedKeySpec));
                            instance.setParameter((AlgorithmParameterSpec)second);
                            instance.update(byteBuffer3);
                            byteBuffer3.clear();
                            byteBuffer6 = w1.f(byteBuffer3);
                            arrayList3 = new ArrayList();
                            certificate = 0;
                            certificate += i;
                            instance = w1.f(byteBuffer6);
                            int = instance.getInt();
                            arrayList3.add(Integer.valueOf(int));
                            i9 = w1.i(instance);
                            iOException = new IOException("Record too short");
                            throw iOException;
                            i11 = w1.c(u1Var);
                            equal = map2.put(Integer.valueOf(i11), i9);
                            securityException4 = new SecurityException(w1.d(i11).concat(" contents digest does not match the digest specified by a preceding signer"));
                            throw securityException4;
                            byteBuffer4 = w1.f(byteBuffer3);
                            arrayList = new ArrayList();
                            i8 = 0;
                            i8 += i;
                            bArr = w1.i(byteBuffer4);
                            byteArrayInputStream = new ByteArrayInputStream(bArr);
                            u1Var = new u1((X509Certificate)certificateFactory3.generateCertificate(byteArrayInputStream), bArr);
                            arrayList.add(u1Var);
                            return (X509Certificate[])arrayList.toArray(new X509Certificate[arrayList.size()]);
                            securityException5 = new SecurityException("Public key mismatch between certificate and signature record");
                            throw securityException5;
                            securityException6 = new SecurityException("No certificates listed");
                            throw securityException6;
                            securityException3 = new SecurityException("Signature algorithms don't match between digests and signatures records");
                            throw securityException3;
                            securityException7 = new SecurityException(String.valueOf(first).concat(" signature did not verify"));
                            throw securityException7;
                        case 260:
                            create = Pair.create("SHA512withRSA", i9);
                            first = create.first;
                            second = create.second;
                            x509EncodedKeySpec = new X509EncodedKeySpec(bArr2);
                            instance = Signature.getInstance((String)first);
                            instance.initVerify(KeyFactory.getInstance(str3).generatePublic(x509EncodedKeySpec));
                            instance.setParameter((AlgorithmParameterSpec)second);
                            instance.update(byteBuffer3);
                            byteBuffer3.clear();
                            byteBuffer6 = w1.f(byteBuffer3);
                            arrayList3 = new ArrayList();
                            certificate = 0;
                            certificate += i;
                            instance = w1.f(byteBuffer6);
                            int = instance.getInt();
                            arrayList3.add(Integer.valueOf(int));
                            i9 = w1.i(instance);
                            iOException = new IOException("Record too short");
                            throw iOException;
                            i11 = w1.c(u1Var);
                            equal = map2.put(Integer.valueOf(i11), i9);
                            securityException4 = new SecurityException(w1.d(i11).concat(" contents digest does not match the digest specified by a preceding signer"));
                            throw securityException4;
                            byteBuffer4 = w1.f(byteBuffer3);
                            arrayList = new ArrayList();
                            i8 = 0;
                            i8 += i;
                            bArr = w1.i(byteBuffer4);
                            byteArrayInputStream = new ByteArrayInputStream(bArr);
                            u1Var = new u1((X509Certificate)certificateFactory3.generateCertificate(byteArrayInputStream), bArr);
                            arrayList.add(u1Var);
                            return (X509Certificate[])arrayList.toArray(new X509Certificate[arrayList.size()]);
                            securityException5 = new SecurityException("Public key mismatch between certificate and signature record");
                            throw securityException5;
                            securityException6 = new SecurityException("No certificates listed");
                            throw securityException6;
                            securityException3 = new SecurityException("Signature algorithms don't match between digests and signatures records");
                            throw securityException3;
                            securityException7 = new SecurityException(String.valueOf(first).concat(" signature did not verify"));
                            throw securityException7;
                        default:
                            valueOf = String.valueOf(Long.toHexString((long)u1Var));
                            concat2 = str7.concat(valueOf);
                            valueOf = new String(str7);
                            concat2 = valueOf;
                    }
                    try {
                        IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(concat2);
                        throw illegalArgumentException2;
                        create = Pair.create("SHA512withRSA", i9);
                        create = Pair.create("SHA256withRSA", i9);
                        super("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1);
                        create = Pair.create("SHA512withRSA/PSS", pSSParameterSpec3);
                        super("SHA-256", "MGF1", MGF1ParameterSpec.SHA256, 32, 1);
                        create = Pair.create("SHA256withRSA/PSS", pSSParameterSpec2);
                        create = Pair.create("SHA256withDSA", i9);
                        create = Pair.create("SHA512withECDSA", i9);
                        create = Pair.create("SHA256withECDSA", i9);
                        first = create.first;
                        second = create.second;
                        x509EncodedKeySpec = new X509EncodedKeySpec(bArr2);
                        instance = Signature.getInstance((String)first);
                        instance.initVerify(KeyFactory.getInstance(str3).generatePublic(x509EncodedKeySpec));
                        if ((AlgorithmParameterSpec)second != null) {
                        }
                        instance.setParameter((AlgorithmParameterSpec)second);
                        instance.update(byteBuffer3);
                        if (!instance.verify(int)) {
                        } else {
                        }
                        byteBuffer3.clear();
                        byteBuffer6 = w1.f(byteBuffer3);
                        arrayList3 = new ArrayList();
                        certificate = 0;
                        while (byteBuffer6.hasRemaining()) {
                            certificate += i;
                            instance = w1.f(byteBuffer6);
                            int = instance.getInt();
                            arrayList3.add(Integer.valueOf(int));
                            if (int == u1Var) {
                            }
                            i9 = w1.i(instance);
                        }
                        certificate += i;
                        instance = w1.f(byteBuffer6);
                        if (instance.remaining() < i13) {
                        } else {
                        }
                        int = instance.getInt();
                        arrayList3.add(Integer.valueOf(int));
                        if (int == u1Var) {
                        }
                        i9 = w1.i(instance);
                        iOException = new IOException("Record too short");
                        throw iOException;
                        int stringBuilder = 42;
                        StringBuilder string = new StringBuilder(stringBuilder);
                        stringBuilder = "Failed to parse digest record #";
                        string.append(stringBuilder);
                        string.append(obj5);
                        string = string.toString();
                        IOException exc = new IOException(string, cmp);
                        throw exc;
                        if (!arrayList2.equals(arrayList3)) {
                        } else {
                        }
                        i11 = w1.c(u1Var);
                        equal = map2.put(Integer.valueOf(i11), i9);
                        if ((byte[])equal != null) {
                        }
                        if (!MessageDigest.isEqual((byte[])equal, i9)) {
                        } else {
                        }
                        securityException4 = new SecurityException(w1.d(i11).concat(" contents digest does not match the digest specified by a preceding signer"));
                        throw securityException4;
                        byteBuffer4 = w1.f(byteBuffer3);
                        arrayList = new ArrayList();
                        i8 = 0;
                        while (byteBuffer4.hasRemaining()) {
                            i8 += i;
                            bArr = w1.i(byteBuffer4);
                            byteArrayInputStream = new ByteArrayInputStream(bArr);
                            u1Var = new u1((X509Certificate)certificateFactory3.generateCertificate(byteArrayInputStream), bArr);
                            arrayList.add(u1Var);
                        }
                        i8 += i;
                        bArr = w1.i(byteBuffer4);
                        byteArrayInputStream = new ByteArrayInputStream(bArr);
                        u1Var = new u1((X509Certificate)certificateFactory3.generateCertificate(byteArrayInputStream), bArr);
                        arrayList.add(u1Var);
                        int str21 = 41;
                        string = new StringBuilder(str21);
                        str21 = "Failed to decode certificate #";
                        string.append(str21);
                        string.append(stringBuilder);
                        string = string.toString();
                        exc = new SecurityException(string, cmp);
                        throw exc;
                        if (arrayList.isEmpty()) {
                        } else {
                        }
                        if (!Arrays.equals(bArr2, (X509Certificate)arrayList.get(0).getPublicKey().getEncoded())) {
                        } else {
                        }
                        return (X509Certificate[])arrayList.toArray(new X509Certificate[arrayList.size()]);
                        securityException5 = new SecurityException("Public key mismatch between certificate and signature record");
                        throw securityException5;
                        securityException6 = new SecurityException("No certificates listed");
                        throw securityException6;
                        securityException3 = new SecurityException("Signature algorithms don't match between digests and signatures records");
                        throw securityException3;
                        securityException7 = new SecurityException(String.valueOf(first).concat(" signature did not verify"));
                        throw securityException7;
                        string = String.valueOf(obj5);
                        string = string.length();
                        string += 27;
                        stringBuilder = new StringBuilder(string);
                        string = "Failed to verify ";
                        stringBuilder.append(string);
                        stringBuilder.append(obj5);
                        string = " signature";
                        stringBuilder.append(string);
                        string = stringBuilder.toString();
                        exc = new SecurityException(string, cmp);
                        throw exc;
                        Throwable cmp = cmp;
                        exc = cmp;
                        cmp = cmp;
                        cmp = cmp;
                        cmp = cmp;
                        cmp = cmp;
                        cmp = cmp;
                        exc = cmp;
                        cmp = new byte[cmp];
                        cmp = new byte[cmp];
                        cmp = new byte[cmp];
                        cmp = new byte[cmp];
                        cmp = cmp;
                        exc = cmp;
                        cmp = cmp[cmp];
                        cmp = Long.compare(cmp, cmp);
                    } catch (java.security.NoSuchAlgorithmException noSuchAlgorithm) {
                    } catch (java.security.spec.InvalidKeySpecException invalidKeySpec1) {
                    } catch (java.security.InvalidKeyException invalidKey2) {
                    } catch (java.security.InvalidAlgorithmParameterException invalidAlgorithmParameter3) {
                    } catch (java.security.SignatureException signature4) {
                    }
                }
            } else {
            }
        } else {
        }
    }

    private static byte[][] k(int[] iArr, com.google.android.play.core.internal.z0[] z02Arr2) {
        int i11;
        String concat;
        int i4;
        int i21;
        int i14;
        int i;
        byte[] bArr;
        int i17;
        int i7;
        MessageDigest[] arr;
        int i2;
        int i6;
        int i10;
        Object obj;
        int bArr3;
        int length;
        int i15;
        int i13;
        long l2;
        int i9;
        int i12;
        int i20;
        int i16;
        int i18;
        String str;
        MessageDigest instance;
        int i3;
        long l;
        byte[] bArr2;
        int i19;
        Object obj2;
        int cmp;
        int i8;
        int i5;
        MessageDigest[] objArr;
        int[] iArr2 = iArr;
        i21 = 0;
        i17 = i11;
        i = i21;
        while (i < 3) {
            i17 += i6;
            i++;
        }
        if (Long.compare(i17, bArr3) >= 0) {
        } else {
            int i27 = (int)i17;
            byte[][] bArr5 = new byte[iArr2.length];
            i7 = i21;
            length = iArr2.length;
            i13 = 5;
            for (int i34 : runtimeException) {
                bArr3 = new byte[i36 += i13];
                bArr3[i21] = 90;
                w1.g(i27, bArr3, 1);
                bArr5[i7] = bArr3;
                length = iArr2.length;
                i13 = 5;
            }
            new byte[i13][i21] = -91;
            i12 = i21;
            str = " digest not supported";
            for (int i38 : runtimeException) {
                new MessageDigest[length][i12] = MessageDigest.getInstance(w1.d(i38));
                str = " digest not supported";
            }
            i18 = i20;
            while (i20 < i10) {
                i19 = i11;
                l2 = l;
                while (Long.compare(l2, i11) > 0) {
                    int i22 = (int)l3;
                    w1.g(i22, bArr, 1);
                    i4 = 0;
                    while (i4 < length) {
                        arr[i4].update(bArr);
                        i4++;
                        i2 = 1048576;
                    }
                    int i32 = i19;
                    obj.a(arr, i32, obj8);
                    concat = 0;
                    for (int i28 : runtimeException) {
                        bArr = w1.b(i28);
                        MessageDigest messageDigest2 = arr[concat];
                        l = 5L;
                        int digest = messageDigest2.digest(bArr5[concat], i5 + 5, bArr);
                        obj = obj2;
                        length = i8;
                        arr = objArr;
                    }
                    obj2 = obj;
                    i8 = length;
                    l = 5L;
                    long l4 = (long)i22;
                    l2 -= l4;
                    i18++;
                    bArr = bArr7;
                    i11 = 0;
                    i19 = i31;
                    arr = objArr;
                    i2 = 1048576;
                    bArr = w1.b(iArr2[concat]);
                    messageDigest2 = arr[concat];
                    l = 5L;
                    digest = messageDigest2.digest(bArr5[concat], i5 + 5, bArr);
                    concat++;
                    obj = obj2;
                    length = i8;
                    arr = objArr;
                    arr[i4].update(bArr);
                    i4++;
                    i2 = 1048576;
                }
                bArr2 = bArr;
                objArr = arr;
                i8 = length;
                i21++;
                i20++;
                i13 = i3;
                i11 = 0;
                i2 = 1048576;
                i10 = 3;
                i9 = 1;
                i22 = (int)l3;
                w1.g(i22, bArr, 1);
                i4 = 0;
                while (i4 < length) {
                    arr[i4].update(bArr);
                    i4++;
                    i2 = 1048576;
                }
                i32 = i19;
                obj.a(arr, i32, obj8);
                concat = 0;
                for (int i28 : runtimeException) {
                    bArr = w1.b(i28);
                    messageDigest2 = arr[concat];
                    l = 5L;
                    digest = messageDigest2.digest(bArr5[concat], i5 + 5, bArr);
                    obj = obj2;
                    length = i8;
                    arr = objArr;
                }
                obj2 = obj;
                i8 = length;
                l = 5L;
                l4 = (long)i22;
                l2 -= l4;
                i18++;
                bArr = bArr7;
                i11 = 0;
                i19 = i31;
                arr = objArr;
                i2 = 1048576;
                bArr = w1.b(iArr2[concat]);
                messageDigest2 = arr[concat];
                l = 5L;
                digest = messageDigest2.digest(bArr5[concat], i5 + 5, bArr);
                concat++;
                obj = obj2;
                length = i8;
                arr = objArr;
                arr[i4].update(bArr);
                i4++;
                i2 = 1048576;
            }
            byte[][] bArr4 = new byte[iArr2.length];
            i14 = 0;
            for (int i24 : runtimeException) {
                bArr4[i14] = MessageDigest.getInstance(w1.d(i24)).digest(bArr5[i14]);
            }
            return bArr4;
        }
        StringBuilder stringBuilder = new StringBuilder(37);
        stringBuilder.append("Too many chunks: ");
        stringBuilder.append(i17);
        DigestException digestException = new DigestException(stringBuilder.toString());
        throw digestException;
    }

    private static X509Certificate[][] l(FileChannel fileChannel, com.google.android.play.core.internal.t1 t12) {
        int i;
        X509Certificate[] objArr;
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        ByteBuffer byteBuffer2 = w1.f(t1.d(t12));
        i = 0;
        while (byteBuffer2.hasRemaining()) {
            i++;
            arrayList.add(w1.j(w1.f(byteBuffer2), hashMap, CertificateFactory.getInstance("X.509")));
        }
        if (i <= 0) {
        } else {
            if (hashMap.isEmpty()) {
            } else {
                w1.h(hashMap, fileChannel, t1.a(t12), i, t1.b(t12), obj5);
                return (X509Certificate[][])arrayList.toArray(new X509Certificate[arrayList.size()]);
            }
            try {
                SecurityException obj10 = new SecurityException("No content digests found");
                throw obj10;
                obj10 = new SecurityException("No signers found");
                throw obj10;
                StringBuilder str = "Failed to read list of signers";
                t12 = new SecurityException(str, fileChannel);
                throw t12;
                str = "Failed to obtain X.509 CertificateFactory";
                t12 = new RuntimeException(str, fileChannel);
                throw t12;
            } catch (java.io.IOException ioException) {
            }
        }
    }
}
