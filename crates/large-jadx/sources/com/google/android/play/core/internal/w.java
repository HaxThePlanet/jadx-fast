package com.google.android.play.core.internal;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.util.Log;
import com.google.android.play.core.splitinstall.f0;
import com.google.android.play.core.splitinstall.h0;
import f.c.a.f.a.d.a;
import f.c.a.f.a.d.f;
import f.c.a.f.a.d.s;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class w implements h0 {

    private final Context a;
    private final f b;
    private final com.google.android.play.core.internal.y c;
    private final Executor d;
    public w(Context context, Executor executor2, com.google.android.play.core.internal.y y3, f f4, s s5, byte[] b6Arr6) {
        super();
        this.a = context;
        this.b = f4;
        this.c = y3;
        this.d = executor2;
    }

    static com.google.android.play.core.internal.y b(com.google.android.play.core.internal.w w) {
        return w.c;
    }

    static void c(com.google.android.play.core.internal.w w, List list2, f0 f03) {
        Integer obj0 = w.e(list2);
        if (obj0 == null) {
        }
        if (obj0.intValue() == 0) {
            f03.zzc();
        }
        f03.a(obj0.intValue());
    }

    static void d(com.google.android.play.core.internal.w w, f0 f02) {
        final String str = "SplitCompat";
        if (!a.f(e1.a(w.a))) {
            Log.e(str, "Emulating splits failed.");
            f02.a(-12);
        }
        Log.i(str, "Splits installed.");
        f02.zza();
    }

    private final Integer e(List<Intent> list) {
        String str;
        int valueOf;
        int i;
        FileLock tryLock;
        int length;
        com.google.android.play.core.internal.y yVar;
        String assetFileDescriptor;
        Object bufferedInputStream;
        File bArr;
        boolean exists;
        long length2;
        Object obj14;
        final String str2 = "SplitCompat";
        final int i2 = -13;
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.b.d(), "rw");
        FileChannel channel = randomAccessFile.getChannel();
        valueOf = 0;
        tryLock = channel.tryLock();
        if (tryLock != null) {
            try {
                Log.i(str2, "Copying splits.");
                obj14 = list.iterator();
                while (obj14.hasNext()) {
                    Object next2 = obj14.next();
                    bufferedInputStream = (Intent)next2.getStringExtra("split_id");
                    assetFileDescriptor = this.a.getContentResolver().openAssetFileDescriptor(next2.getData(), "r");
                    bArr = this.b.e(bufferedInputStream);
                    if (bArr.exists() && Long.compare(length3, length2) != 0) {
                    } else {
                    }
                    if (!bArr.exists() && !this.b.g(bufferedInputStream).exists()) {
                    }
                    if (!this.b.g(bufferedInputStream).exists()) {
                    }
                    bufferedInputStream = new BufferedInputStream(assetFileDescriptor.createInputStream());
                    assetFileDescriptor = new FileOutputStream(bArr);
                    bArr = new byte[4096];
                    exists = bufferedInputStream.read(bArr);
                    while (exists > 0) {
                        assetFileDescriptor.write(bArr, 0, exists);
                        exists = bufferedInputStream.read(bArr);
                    }
                    assetFileDescriptor.close();
                    bufferedInputStream.close();
                    assetFileDescriptor.write(bArr, i, exists);
                    if (Long.compare(length3, length2) != 0) {
                    } else {
                    }
                }
                next2 = obj14.next();
                bufferedInputStream = (Intent)next2.getStringExtra("split_id");
                assetFileDescriptor = this.a.getContentResolver().openAssetFileDescriptor(next2.getData(), "r");
                bArr = this.b.e(bufferedInputStream);
                if (bArr.exists() && Long.compare(length3, length2) != 0) {
                } else {
                }
                if (Long.compare(length3, length2) != 0) {
                } else {
                }
                if (!bArr.exists() && !this.b.g(bufferedInputStream).exists()) {
                }
                if (!this.b.g(bufferedInputStream).exists()) {
                }
                bufferedInputStream = new BufferedInputStream(assetFileDescriptor.createInputStream());
                assetFileDescriptor = new FileOutputStream(bArr);
                bArr = new byte[4096];
                exists = bufferedInputStream.read(bArr);
                while (exists > 0) {
                    assetFileDescriptor.write(bArr, i, exists);
                    exists = bufferedInputStream.read(bArr);
                }
                assetFileDescriptor.write(bArr, i, exists);
                assetFileDescriptor.close();
                bufferedInputStream.close();
                obj6.close();
                throw list;
                obj7.close();
                throw list;
                Log.i(str2, "Splits copied.");
                obj14 = this.b.b().listFiles();
                obj14 = this.b.b().listFiles();
                Arrays.sort(obj14);
                length = obj14.length;
                length--;
            } catch (java.nio.channels.OverlappingFileLockException overlappingFileLock) {
                valueOf = Integer.valueOf(i);
                tryLock.release();
                channel.close();
                return valueOf;
            } catch (Throwable th1) {
                str = "Cannot access directory for unverified splits.";
                Log.e(obj0, str, list);
                str = obj1;
                valueOf = Integer.valueOf(i);
                tryLock.release();
                channel.close();
                return valueOf;
            }
            Log.e(str2, "Split verification failed.");
            i = length;
        }
    }

    public final void a(List<Intent> list, f0 f02) {
        if (!a.g()) {
        } else {
            v vVar = new v(this, list, f02);
            this.d.execute(vVar);
        }
        IllegalStateException obj3 = new IllegalStateException("Ingestion should only be called in SplitCompat mode.");
        throw obj3;
    }
}
