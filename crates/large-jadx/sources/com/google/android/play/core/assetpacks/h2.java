package com.google.android.play.core.assetpacks;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.google.android.play.core.assetpacks.c.b;
import com.google.android.play.core.common.LocalTestingException;
import com.google.android.play.core.internal.h;
import com.google.android.play.core.internal.j1;
import com.google.android.play.core.internal.n1;
import com.google.android.play.core.tasks.d;
import com.google.android.play.core.tasks.f;
import com.google.android.play.core.tasks.o;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
final class h2 implements com.google.android.play.core.assetpacks.d4 {

    private static final h g;
    private final String a;
    private final com.google.android.play.core.assetpacks.z b;
    private final Context c;
    private final com.google.android.play.core.assetpacks.w2 d;
    private final n1<Executor> e;
    private final Handler f;
    static {
        h hVar = new h("FakeAssetPackService");
        h2.g = hVar;
        AtomicInteger atomicInteger = new AtomicInteger(1);
    }

    h2(File file, com.google.android.play.core.assetpacks.z z2, com.google.android.play.core.assetpacks.k1 k13, Context context4, com.google.android.play.core.assetpacks.w2 w25, n1<Executor> n16, com.google.android.play.core.assetpacks.u2 u27) {
        super();
        Handler obj3 = new Handler(Looper.getMainLooper());
        this.f = obj3;
        this.a = file.getAbsolutePath();
        this.b = z2;
        this.c = context4;
        this.d = w25;
        this.e = n16;
    }

    static long h(int i, long l2) {
        int i2;
        if (i != 2 && i != 3 && i != 4) {
            if (i != 3) {
                if (i != 4) {
                    return 0;
                }
            }
            return l2;
        }
        return l2 /= i4;
    }

    private final Bundle k(int i, String string2, int i3) {
        int i2;
        int i4;
        File file;
        String str;
        String str2;
        Intent data;
        Uri eMPTY;
        Bundle bundle = new Bundle();
        bundle.putInt("app_version_code", this.d.a());
        bundle.putInt("session_id", i);
        File[] obj13 = m(string2);
        ArrayList arrayList = new ArrayList();
        int length = obj13.length;
        final int i7 = 0;
        i2 = 0;
        i4 = i7;
        while (i4 < length) {
            file = obj13[i4];
            i2 += length2;
            ArrayList arrayList3 = new ArrayList();
            if (i3 == 3) {
            } else {
            }
            data = 0;
            arrayList3.add(data);
            str2 = j1.a(file);
            bundle.putParcelableArrayList(b.b("chunk_intents", string2, str2), arrayList3);
            bundle.putString(b.b("uncompressed_hash_sha256", string2, str2), h2.l(file));
            bundle.putLong(b.b("uncompressed_size", string2, str2), file.length());
            arrayList.add(str2);
            i4++;
            Intent intent = new Intent();
            data = intent.setData(Uri.EMPTY);
        }
        bundle.putStringArrayList(b.a("slice_ids", string2), arrayList);
        bundle.putLong(b.a("pack_version", string2), (long)i6);
        bundle.putInt(b.a("status", string2), i3);
        bundle.putInt(b.a("error_code", string2), i7);
        obj13 = "bytes_downloaded";
        bundle.putLong(b.a(obj13, string2), h2.h(i3, i2));
        String str5 = "total_bytes_to_download";
        bundle.putLong(b.a(str5, string2), i2);
        String[] strArr = new String[1];
        strArr[i7] = string2;
        ArrayList arrayList2 = new ArrayList(Arrays.asList(strArr));
        bundle.putStringArrayList("pack_names", arrayList2);
        bundle.putLong(obj13, h2.h(i3, i2));
        bundle.putLong(str5, i2);
        obj13 = new Intent("com.google.android.play.core.assetpacks.receiver.ACTION_SESSION_UPDATE");
        g2 obj15 = new g2(this, obj13.putExtra("com.google.android.play.core.assetpacks.receiver.EXTRA_SESSION_STATE", bundle));
        this.f.post(obj15);
        return bundle;
    }

    private static String l(File file) {
        File[] arr = new File[1];
        return j2.a(Arrays.asList(file));
    }

    private final File[] m(String string) {
        int i;
        boolean equals;
        File file = new File(this.a);
        final int i2 = 0;
        final int i3 = 1;
        if (file.isDirectory() == null) {
        } else {
            e2 e2Var = new e2(string);
            File[] listFiles = file.listFiles(e2Var);
            if (listFiles == null) {
            } else {
                int length = listFiles.length;
                if (length == 0) {
                } else {
                    i = i2;
                    while (i < length) {
                        i++;
                    }
                    Object[] arr3 = new Object[i3];
                    arr3[i2] = string;
                    LocalTestingException localTestingException2 = new LocalTestingException(String.format("No master slice available for pack '%s'.", arr3));
                    throw localTestingException2;
                }
                Object[] arr4 = new Object[i3];
                arr4[i2] = string;
                LocalTestingException localTestingException3 = new LocalTestingException(String.format("No APKs available for pack '%s'.", arr4));
                throw localTestingException3;
            }
            Object[] arr2 = new Object[i3];
            arr2[i2] = string;
            LocalTestingException localTestingException = new LocalTestingException(String.format("Failed fetching APKs for pack '%s'.", arr2));
            throw localTestingException;
        }
        Object[] arr = new Object[i3];
        arr[i2] = file;
        LocalTestingException obj7 = new LocalTestingException(String.format("Local testing directory '%s' not found.", arr));
        throw obj7;
    }

    @Override // com.google.android.play.core.assetpacks.d4
    public final void a(int i, String string2) {
        h2.g.d("notifyModuleCompleted", new Object[0]);
        f2 f2Var = new f2(this, i, string2);
        (Executor)this.e.zza().execute(f2Var);
    }

    public final d<ParcelFileDescriptor> b(int i, String string2, String string3, int i4) {
        int i2;
        int i3;
        boolean equals;
        int obj7;
        ParcelFileDescriptor obj8;
        Object obj9;
        final String str = "getChunkFileDescriptor failed";
        Object[] arr2 = new Object[4];
        final int i6 = 0;
        arr2[i6] = Integer.valueOf(i);
        obj7 = 1;
        arr2[obj7] = string2;
        arr2[2] = string3;
        arr2[3] = Integer.valueOf(i4);
        h2.g.d("getChunkFileDescriptor(session=%d, %s, %s, %d)", arr2);
        o obj10 = new o();
        obj8 = m(string2);
        i2 = i6;
        while (i2 < obj8.length) {
            i3 = obj8[i2];
            i2++;
        }
        Object[] arr = new Object[obj7];
        arr[i6] = string3;
        obj8 = new LocalTestingException(String.format("Local testing slice for '%s' not found.", arr));
        throw obj8;
    }

    @Override // com.google.android.play.core.assetpacks.d4
    public final void c() {
        h2.g.d("keepAlive", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.d4
    public final void d(int i, String string2, String string3, int i4) {
        h2.g.d("notifyChunkTransferred", new Object[0]);
    }

    @Override // com.google.android.play.core.assetpacks.d4
    public final void e(int i) {
        h2.g.d("notifySessionFailed", new Object[0]);
    }

    public final d<List<String>> f(Map<String, Long> map) {
        h2.g.d("syncPacks()", new Object[0]);
        ArrayList obj3 = new ArrayList();
        return f.c(obj3);
    }

    public final void g(List<String> list) {
        Object[] arr = new Object[1];
        h2.g.d("cancelDownload(%s)", list);
    }

    @Override // com.google.android.play.core.assetpacks.d4
    final void i(Intent intent) {
        this.b.a(this.c, intent);
    }

    @Override // com.google.android.play.core.assetpacks.d4
    final void j(int i, String string2) {
        k(i, string2, 4);
    }
}
