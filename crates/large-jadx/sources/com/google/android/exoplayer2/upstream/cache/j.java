package com.google.android.exoplayer2.upstream.cache;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.a;
import com.google.android.exoplayer2.database.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.g0;
import com.google.android.exoplayer2.util.h;
import com.google.android.exoplayer2.util.p0;
import com.google.common.collect.t;
import com.google.common.collect.z;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes2.dex */
class j {

    private final HashMap<String, com.google.android.exoplayer2.upstream.cache.i> a;
    private final SparseArray<String> b;
    private final SparseBooleanArray c;
    private final SparseBooleanArray d;
    private com.google.android.exoplayer2.upstream.cache.j.c e = null;
    private com.google.android.exoplayer2.upstream.cache.j.c f = null;

    private interface c {
        public abstract void a(com.google.android.exoplayer2.upstream.cache.i i, boolean z2);

        public abstract void b(HashMap<String, com.google.android.exoplayer2.upstream.cache.i> hashMap);

        public abstract void c(com.google.android.exoplayer2.upstream.cache.i i);

        public abstract boolean d();

        public abstract void delete();

        public abstract void e(HashMap<String, com.google.android.exoplayer2.upstream.cache.i> hashMap);

        public abstract void f(long l);

        public abstract void g(HashMap<String, com.google.android.exoplayer2.upstream.cache.i> hashMap, SparseArray<String> sparseArray2);
    }

    private static final class a implements com.google.android.exoplayer2.upstream.cache.j.c {

        private static final String[] e;
        private final a a;
        private final SparseArray<com.google.android.exoplayer2.upstream.cache.i> b;
        private String c;
        private String d;
        static {
            j.a.e = /* result */;
        }

        public a(a a) {
            super();
            this.a = a;
            SparseArray obj1 = new SparseArray();
            this.b = obj1;
        }

        private void h(SQLiteDatabase sQLiteDatabase, com.google.android.exoplayer2.upstream.cache.i i2) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            j.c(i2.c(), dataOutputStream);
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(i2.a));
            contentValues.put("key", i2.b);
            contentValues.put("metadata", byteArrayOutputStream.toByteArray());
            String obj6 = this.d;
            g.e(obj6);
            sQLiteDatabase.replaceOrThrow((String)obj6, 0, contentValues);
        }

        private static void i(a a, String string2) {
            try {
                final SQLiteDatabase obj2 = a.getWritableDatabase();
                obj2.beginTransactionNonExclusive();
                c.c(obj2, 1, string2);
                j.a.k(obj2, j.a.m(string2));
                obj2.setTransactionSuccessful();
                obj2.endTransaction();
                a.endTransaction();
                throw string2;
                string2 = new DatabaseIOException(a);
                throw string2;
            } catch (Throwable th) {
            }
        }

        private void j(SQLiteDatabase sQLiteDatabase, int i2) {
            final String str = this.d;
            g.e(str);
            String[] strArr = new String[1];
            sQLiteDatabase.delete((String)str, "id = ?", Integer.toString(i2));
        }

        private static void k(SQLiteDatabase sQLiteDatabase, String string2) {
            String obj3;
            obj3 = String.valueOf(string2);
            final String str = "DROP TABLE IF EXISTS ";
            if (obj3.length() != 0) {
                obj3 = str.concat(obj3);
            } else {
                obj3 = new String(str);
            }
            sQLiteDatabase.execSQL(obj3);
        }

        private Cursor l() {
            String str = this.d;
            g.e(str);
            return this.a.getReadableDatabase().query((String)str, j.a.e, 0, 0, 0, 0, 0);
        }

        private static String m(String string) {
            String obj2;
            obj2 = String.valueOf(string);
            final String str = "ExoPlayerCacheIndex";
            if (obj2.length() != 0) {
                obj2 = str.concat(obj2);
            } else {
                obj2 = new String(str);
            }
            return obj2;
        }

        private void n(SQLiteDatabase sQLiteDatabase) {
            String str = this.c;
            g.e(str);
            int i = 1;
            c.d(sQLiteDatabase, i, (String)str, i);
            String str2 = this.d;
            g.e(str2);
            j.a.k(sQLiteDatabase, (String)str2);
            String str3 = this.d;
            StringBuilder stringBuilder = new StringBuilder(length += 88);
            stringBuilder.append("CREATE TABLE ");
            stringBuilder.append(str3);
            stringBuilder.append(" ");
            stringBuilder.append("(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
            sQLiteDatabase.execSQL(stringBuilder.toString());
        }

        @Override // com.google.android.exoplayer2.upstream.cache.j$c
        public void a(com.google.android.exoplayer2.upstream.cache.i i, boolean z2) {
            int i2;
            int obj2;
            SparseArray obj3;
            if (z2) {
                this.b.delete(i.a);
            } else {
                this.b.put(i.a, 0);
            }
        }

        public void b(HashMap<String, com.google.android.exoplayer2.upstream.cache.i> hashMap) {
            Object next;
            try {
                SQLiteDatabase writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                n(writableDatabase);
                Iterator obj3 = hashMap.values().iterator();
                for (i next : obj3) {
                    h(writableDatabase, next);
                }
                h(writableDatabase, (i)obj3.next());
                writableDatabase.setTransactionSuccessful();
                this.b.clear();
                writableDatabase.endTransaction();
                databaseIOException.endTransaction();
                throw hashMap;
                DatabaseIOException databaseIOException = new DatabaseIOException(hashMap);
                throw databaseIOException;
            } catch (Throwable th) {
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.j$c
        public void c(com.google.android.exoplayer2.upstream.cache.i i) {
            this.b.put(i.a, i);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.j$c
        public boolean d() {
            int i;
            String str = this.c;
            g.e(str);
            if (c.b(this.a.getReadableDatabase(), 1, (String)str) != -1) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.j$c
        public void delete() {
            final String str = this.c;
            g.e(str);
            j.a.i(this.a, (String)str);
        }

        public void e(HashMap<String, com.google.android.exoplayer2.upstream.cache.i> hashMap) {
            int i;
            Object valueAt;
            if (this.b.size() == 0) {
            }
            SQLiteDatabase obj3 = this.a.getWritableDatabase();
            obj3.beginTransactionNonExclusive();
            i = 0;
            while (i < this.b.size()) {
                valueAt = this.b.valueAt(i);
                if ((i)valueAt == null) {
                } else {
                }
                h(obj3, (i)valueAt);
                i++;
                j(obj3, this.b.keyAt(i));
            }
            obj3.setTransactionSuccessful();
            this.b.clear();
            obj3.endTransaction();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.j$c
        public void f(long l) {
            String obj1 = Long.toHexString(l);
            this.c = obj1;
            this.d = j.a.m(obj1);
        }

        public void g(HashMap<String, com.google.android.exoplayer2.upstream.cache.i> hashMap, SparseArray<String> sparseArray2) {
            int i;
            int writableDatabase;
            Throwable th2;
            String str;
            String str2;
            com.google.android.exoplayer2.upstream.cache.m mVar;
            com.google.android.exoplayer2.upstream.cache.i iVar;
            final int i2 = 0;
            final int i3 = 1;
            i = this.b.size() == 0 ? i3 : i2;
            g.f(i);
            str = this.c;
            g.e(str);
            if (c.b(this.a.getReadableDatabase(), i3, (String)str) != i3) {
                writableDatabase = this.a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                n(writableDatabase);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
            Cursor cursor = l();
            while (cursor.moveToNext()) {
                String string = cursor.getString(i3);
                g.e(string);
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(cursor.getBlob(2));
                DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
                iVar = new i(cursor.getInt(i2), (String)string, j.b(dataInputStream));
                hashMap.put(iVar.b, iVar);
                sparseArray2.put(iVar.a, iVar.b);
            }
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    private static class b implements com.google.android.exoplayer2.upstream.cache.j.c {

        private final boolean a;
        private final Cipher b = null;
        private final SecretKeySpec c = null;
        private final SecureRandom d;
        private final h e;
        private boolean f;
        private g0 g;
        public b(File file, byte[] b2Arr2, boolean z3) {
            int i;
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            int i2;
            int secureRandom;
            String str;
            int i3;
            byte[] obj7;
            super();
            int i4 = 1;
            if (b2Arr2 == null) {
                if (z3 == 0) {
                    i2 = i4;
                } else {
                    i2 = i;
                }
            } else {
            }
            g.f(i2);
            if (b2Arr2 != null) {
                i = b2Arr2.length == 16 ? i4 : i;
                g.a(i);
                cipher = j.a();
                secretKeySpec = new SecretKeySpec(b2Arr2, "AES");
            } else {
                g.a(z3 ^ 1);
                secretKeySpec = cipher;
            }
            this.a = z3;
            if (z3 != 0) {
                secureRandom = new SecureRandom();
            }
            this.d = secureRandom;
            obj7 = new h(file);
            this.e = obj7;
        }

        private int h(com.google.android.exoplayer2.upstream.cache.i i, int i2) {
            int i4;
            int i3;
            int obj4;
            i6 += i9;
            if (i2 < 2) {
                obj4 = k.d(i.c());
                i7 *= 31;
                obj4 = (int)obj4;
            } else {
                i7 *= 31;
                obj4 = i.c().hashCode();
            }
            return i4 += obj4;
        }

        private com.google.android.exoplayer2.upstream.cache.i i(int i, DataInputStream dataInputStream2) {
            com.google.android.exoplayer2.upstream.cache.l lVar;
            com.google.android.exoplayer2.upstream.cache.m obj4;
            if (i < 2) {
                lVar = new l();
                l.g(lVar, dataInputStream2.readLong());
                obj4 = m.c.g(lVar);
            } else {
                obj4 = j.b(dataInputStream2);
            }
            i obj5 = new i(dataInputStream2.readInt(), dataInputStream2.readUTF(), obj4);
            return obj5;
        }

        private boolean j(HashMap<String, com.google.android.exoplayer2.upstream.cache.i> hashMap, SparseArray<String> sparseArray2) {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream2;
            DataInputStream dataInputStream;
            int i2;
            CipherInputStream cipherInputStream;
            int i;
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            String str;
            int obj12;
            final int i5 = 1;
            if (!this.e.c()) {
                return i5;
            }
            int i3 = 0;
            final int i6 = 0;
            bufferedInputStream = new BufferedInputStream(this.e.d());
            dataInputStream2 = new DataInputStream(bufferedInputStream);
            int int = dataInputStream2.readInt();
            if (int >= 0) {
                dataInputStream = 2;
                if (int > dataInputStream) {
                } else {
                    if (int3 &= i5 != 0) {
                        if (this.b == null) {
                            p0.m(dataInputStream2);
                            return i6;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream2.readFully(bArr);
                        IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                        secretKeySpec = this.c;
                        p0.i(secretKeySpec);
                        this.b.init(dataInputStream, (Key)secretKeySpec, ivParameterSpec);
                        cipherInputStream = new CipherInputStream(bufferedInputStream, this.b);
                        dataInputStream = new DataInputStream(cipherInputStream);
                        dataInputStream2 = dataInputStream;
                    } else {
                        try {
                            if (this.a) {
                            }
                            this.f = i5;
                            i = i2;
                            while (i2 < dataInputStream2.readInt()) {
                                com.google.android.exoplayer2.upstream.cache.i iVar = i(int, dataInputStream2);
                                hashMap.put(iVar.b, iVar);
                                sparseArray2.put(iVar.a, iVar.b);
                                i += cipher;
                                i2++;
                            }
                            iVar = i(int, dataInputStream2);
                            hashMap.put(iVar.b, iVar);
                            sparseArray2.put(iVar.a, iVar.b);
                            i += cipher;
                            i2++;
                            if (dataInputStream2.read() == -1) {
                            } else {
                            }
                            obj12 = i5;
                            obj12 = i6;
                            if (dataInputStream2.readInt() == i && obj12 == null) {
                            }
                            if (obj12 == null) {
                            }
                            p0.m(dataInputStream2);
                            return i5;
                            p0.m(dataInputStream2);
                            return i6;
                            p0.m(dataInputStream2);
                            return i6;
                            java.io.Closeable closeable = obj4;
                            closeable = obj4;
                        } catch (java.io.IOException ioException) {
                        } catch (Throwable th1) {
                        }
                        if (closeable == null) {
                        } else {
                            p0.m(closeable);
                        }
                        throw hashMap;
                    }
                }
            }
        }

        private void k(com.google.android.exoplayer2.upstream.cache.i i, DataOutputStream dataOutputStream2) {
            dataOutputStream2.writeInt(i.a);
            dataOutputStream2.writeUTF(i.b);
            j.c(i.c(), dataOutputStream2);
        }

        private void l(HashMap<String, com.google.android.exoplayer2.upstream.cache.i> hashMap) {
            int size;
            g0 g0Var;
            DataOutputStream dataOutputStream;
            int i2;
            boolean dataOutputStream2;
            int cipherOutputStream;
            int i;
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            java.io.OutputStream outputStream = this.e.f();
            g0Var = this.g;
            if (g0Var == null) {
                try {
                    g0Var = new g0(outputStream);
                    this.g = g0Var;
                    g0Var.a(outputStream);
                    g0 g0Var2 = this.g;
                    dataOutputStream = new DataOutputStream(g0Var2);
                    final int i4 = 2;
                    dataOutputStream.writeInt(i4);
                    cipherOutputStream = 1;
                    if (this.a) {
                    } else {
                    }
                    i2 = cipherOutputStream;
                    i2 = i;
                    dataOutputStream.writeInt(i2);
                    if (this.a) {
                    }
                    byte[] bArr = new byte[16];
                    SecureRandom secureRandom = this.d;
                    p0.i(secureRandom);
                    (SecureRandom)secureRandom.nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    IvParameterSpec ivParameterSpec = new IvParameterSpec(bArr);
                    Cipher cipher2 = this.b;
                    p0.i(cipher2);
                    secretKeySpec = this.c;
                    p0.i(secretKeySpec);
                    (Cipher)cipher2.init(cipherOutputStream, (Key)secretKeySpec, ivParameterSpec);
                    dataOutputStream.flush();
                    cipherOutputStream = new CipherOutputStream(g0Var2, this.b);
                    dataOutputStream2 = new DataOutputStream(cipherOutputStream);
                    dataOutputStream = dataOutputStream2;
                    IllegalStateException exc = new IllegalStateException(hashMap);
                    throw exc;
                    dataOutputStream.writeInt(hashMap.size());
                    Iterator obj10 = hashMap.values().iterator();
                    for (i next2 : obj10) {
                        k(next2, dataOutputStream);
                        i += size;
                    }
                    Object next2 = obj10.next();
                    k((i)next2, dataOutputStream);
                    i += size;
                    dataOutputStream.writeInt(i);
                    this.e.b(dataOutputStream);
                    p0.m(0);
                    exc = obj2;
                    p0.m(exc);
                    throw hashMap;
                } catch (Throwable th) {
                }
            } else {
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.j$c
        public void a(com.google.android.exoplayer2.upstream.cache.i i, boolean z2) {
            this.f = true;
        }

        public void b(HashMap<String, com.google.android.exoplayer2.upstream.cache.i> hashMap) {
            l(hashMap);
            this.f = false;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.j$c
        public void c(com.google.android.exoplayer2.upstream.cache.i i) {
            this.f = true;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.j$c
        public boolean d() {
            return this.e.c();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.j$c
        public void delete() {
            this.e.a();
        }

        public void e(HashMap<String, com.google.android.exoplayer2.upstream.cache.i> hashMap) {
            if (!this.f) {
            }
            b(hashMap);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.j$c
        public void f(long l) {
        }

        public void g(HashMap<String, com.google.android.exoplayer2.upstream.cache.i> hashMap, SparseArray<String> sparseArray2) {
            Object obj2;
            g.f(z ^= 1);
            if (!j(hashMap, sparseArray2)) {
                hashMap.clear();
                sparseArray2.clear();
                this.e.a();
            }
        }
    }
    public j(a a, File file2, byte[] b3Arr3, boolean z4, boolean z5) {
        int i;
        int bVar;
        com.google.android.exoplayer2.upstream.cache.j.a aVar;
        String str;
        Object obj4;
        super();
        if (a == null) {
            if (file2 != null) {
                i = 1;
            } else {
                i = 0;
            }
        } else {
        }
        g.f(i);
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        SparseArray sparseArray = new SparseArray();
        this.b = sparseArray;
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.c = sparseBooleanArray;
        SparseBooleanArray sparseBooleanArray2 = new SparseBooleanArray();
        this.d = sparseBooleanArray2;
        if (a != null) {
            aVar = new j.a(a);
        } else {
            aVar = bVar;
        }
        if (file2 != null) {
            obj4 = new File(file2, "cached_content_index.exi");
            bVar = new j.b(obj4, b3Arr3, z4);
        }
        if (aVar != null) {
        }
        p0.i(bVar);
        this.e = (j.c)bVar;
    }

    static Cipher a() {
        return j.i();
    }

    static com.google.android.exoplayer2.upstream.cache.m b(DataInputStream dataInputStream) {
        return j.q(dataInputStream);
    }

    static void c(com.google.android.exoplayer2.upstream.cache.m m, DataOutputStream dataOutputStream2) {
        j.t(m, dataOutputStream2);
    }

    private com.google.android.exoplayer2.upstream.cache.i d(String string) {
        int i = j.l(this.b);
        i iVar = new i(i, string);
        this.a.put(string, iVar);
        this.b.put(i, string);
        this.d.put(i, true);
        this.e.c(iVar);
        return iVar;
    }

    private static Cipher i() {
        final String str2 = "AES/CBC/PKCS5PADDING";
        if (p0.a == 18) {
            return Cipher.getInstance(str2, "BC");
        }
        return Cipher.getInstance(str2);
    }

    static int l(SparseArray<String> sparseArray) {
        int i;
        int keyAt;
        final int size = sparseArray.size();
        if (size == 0) {
            keyAt = i;
        } else {
            keyAt2++;
        }
        if (keyAt < 0) {
        }
        return keyAt;
    }

    public static boolean o(String string) {
        return string.startsWith("cached_content_index.exi");
    }

    private static com.google.android.exoplayer2.upstream.cache.m q(DataInputStream dataInputStream) {
        int i5;
        String uTF;
        int int;
        int i;
        int i4;
        byte[] copyOf;
        int i3;
        int i2;
        HashMap hashMap = new HashMap();
        final int i7 = 0;
        i5 = i7;
        while (i5 < dataInputStream.readInt()) {
            int = dataInputStream.readInt();
            i = 10485760;
            i4 = Math.min(int, i);
            copyOf = p0.f;
            i3 = i7;
            while (i3 != int) {
                i2 = i3 + i4;
                dataInputStream.readFully(Arrays.copyOf(copyOf, i2), i3, i4);
                i4 = Math.min(int - i2, i);
                i3 = i2;
            }
            hashMap.put(dataInputStream.readUTF(), copyOf);
            i5++;
            i2 = i3 + i4;
            dataInputStream.readFully(Arrays.copyOf(copyOf, i2), i3, i4);
            i4 = Math.min(int - i2, i);
            i3 = i2;
        }
        m obj11 = new m(hashMap);
        return obj11;
    }

    private static void t(com.google.android.exoplayer2.upstream.cache.m m, DataOutputStream dataOutputStream2) {
        int value;
        int length;
        Set obj2 = m.h();
        dataOutputStream2.writeInt(obj2.size());
        obj2 = obj2.iterator();
        for (Map.Entry next2 : obj2) {
            dataOutputStream2.writeUTF((String)next2.getKey());
            value = next2.getValue();
            dataOutputStream2.writeInt(value.length);
            dataOutputStream2.write((byte[])value);
        }
    }

    public void e(String string, com.google.android.exoplayer2.upstream.cache.l l2) {
        boolean obj2;
        final com.google.android.exoplayer2.upstream.cache.i obj1 = m(string);
        if (obj1.b(l2)) {
            this.e.c(obj1);
        }
    }

    public int f(String string) {
        return obj1.a;
    }

    public com.google.android.exoplayer2.upstream.cache.i g(String string) {
        return (i)this.a.get(string);
    }

    public Collection<com.google.android.exoplayer2.upstream.cache.i> h() {
        return Collections.unmodifiableCollection(this.a.values());
    }

    public com.google.android.exoplayer2.upstream.cache.k j(String string) {
        com.google.android.exoplayer2.upstream.cache.m obj1;
        obj1 = g(string);
        if (obj1 != null) {
            obj1 = obj1.c();
        } else {
            obj1 = m.c;
        }
        return obj1;
    }

    public String k(int i) {
        return (String)this.b.get(i);
    }

    public com.google.android.exoplayer2.upstream.cache.i m(String string) {
        Object obj;
        if ((i)this.a.get(string) == null) {
            obj = d(string);
        }
        return obj;
    }

    public void n(long l) {
        SparseArray sparseArray;
        com.google.android.exoplayer2.upstream.cache.j.c obj2;
        HashMap obj3;
        this.e.f(l);
        com.google.android.exoplayer2.upstream.cache.j.c cVar2 = this.f;
        if (cVar2 != null) {
            cVar2.f(l);
        }
        obj2 = this.f;
        if (!this.e.d() && obj2 != null && obj2.d()) {
            obj2 = this.f;
            if (obj2 != null) {
                if (obj2.d()) {
                    this.f.g(this.a, this.b);
                    this.e.b(this.a);
                } else {
                    this.e.g(this.a, this.b);
                }
            } else {
            }
        } else {
        }
        obj2 = this.f;
        if (obj2 != null) {
            obj2.delete();
            this.f = 0;
        }
    }

    public void p(String string) {
        Object obj;
        boolean z;
        com.google.android.exoplayer2.upstream.cache.j.c cVar;
        Object obj4;
        obj = this.a.get(string);
        if (obj != null && (i)obj.f() && obj.h()) {
            if (obj.f()) {
                if (obj.h()) {
                    this.a.remove(string);
                    obj4 = obj.a;
                    z = this.d.get(obj4);
                    this.e.a(obj, z);
                    if (z) {
                        this.b.remove(obj4);
                        this.d.delete(obj4);
                    } else {
                        this.b.put(obj4, 0);
                        this.c.put(obj4, true);
                    }
                }
            }
        }
    }

    public void r() {
        Object next;
        com.google.common.collect.b1 b1Var = z.s(this.a.keySet()).m();
        for (String next : b1Var) {
            p(next);
        }
    }

    public void s() {
        int i;
        SparseArray sparseArray;
        int keyAt;
        this.e.e(this.a);
        i = 0;
        while (i < this.c.size()) {
            this.b.remove(this.c.keyAt(i));
            i++;
        }
        this.c.clear();
        this.d.clear();
    }
}
