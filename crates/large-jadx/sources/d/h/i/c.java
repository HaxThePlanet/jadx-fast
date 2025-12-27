package d.h.i;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import androidx.core.content.e.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: FontProvider.java */
/* loaded from: classes.dex */
class c {

    private static final Comparator<byte[]> a = new c$a<>();

    class a implements Comparator<byte[]> {
        a() {
            super();
        }

        public int a(byte[] bArr, byte[] bArr2) {
            int length2;
            int length3;
            int length4;
            length = bArr.length;
            length2 = bArr2.length;
            if (bArr.length != bArr2.length) {
                length3 = bArr.length;
                length4 = bArr2.length;
                return length3 - length4;
            }
            return length;
        }
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        int i = 0;
        final ArrayList arrayList = new ArrayList();
        i = 0;
        for (Object obj : signatureArr) {
            arrayList.add(obj.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        int i;
        i = 0;
        if (list.size() != list2.size()) {
            return false;
        }
        while (i < list.size()) {
            if (!Arrays.equals((byte[])list.get(i), (byte[])list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> c(d dVar, Resources resources) {
        if (dVar.b() != null) {
            return dVar.b();
        }
        return c.c(resources, dVar.c());
    }

    static f.a d(Context context, d dVar, CancellationSignal cancellationSignal) {
        ProviderInfo providerInfo = c.e(context.getPackageManager(), dVar, context.getResources());
        if (providerInfo == null) {
            return f.a.a(1, null);
        }
        return f.a.a(0, c.f(context, dVar, providerInfo.authority, cancellationSignal));
    }

    static ProviderInfo e(PackageManager packageManager, d dVar, Resources resources) throws PackageManager.NameNotFoundException {
        int i = 0;
        String str = dVar.e();
        i = 0;
        final ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, i);
        if (resolveContentProvider == null) {
            StringBuilder stringBuilder = new StringBuilder();
            String str6 = "No package found for authority: ";
            dVar = str6 + str;
            throw new PackageManager.NameNotFoundException(dVar);
        } else {
            if (!resolveContentProvider.packageName.equals(dVar.f())) {
                StringBuilder stringBuilder2 = new StringBuilder();
                String str3 = "Found content provider ";
                String str2 = ", but package was not ";
                String str5 = dVar.f();
                dVar = str3 + str + str2 + str5;
                throw new PackageManager.NameNotFoundException(dVar);
            } else {
                List list = c.a(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
                Collections.sort(list, c.a);
                List list2 = c.c(dVar, resources);
                while (i < list2.size()) {
                    ArrayList arrayList = new ArrayList((Collection)list2.get(i));
                    Collections.sort(arrayList, c.a);
                    if (c.b(list, arrayList)) {
                        return resolveContentProvider;
                    }
                }
                return null;
            }
        }
    }

    static f.b[] f(Context context, d dVar, String str, CancellationSignal cancellationSignal) {
        ArrayList arrayList;
        Cursor query;
        ContentResolver contentResolver;
        android.net.Uri builder;
        String[] strArr2;
        String str2 = null;
        String str4;
        int context2;
        android.net.Uri appendedId;
        int _int2;
        boolean z;
        String str32 = str;
        arrayList = new ArrayList();
        String str6 = "content";
        builder = new Uri.Builder().scheme(str6).authority(str32).build();
        try {
            str4 = "result_code";
            String[] strArr = new String[] {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", str4};
            final int i = 1;
            context2 = 0;
            if (Build.VERSION.SDK_INT > 16) {
                str = "query = ?";
                strArr2 = new String[i];
                str2 = null;
                query = context.getContentResolver().query(builder, strArr, str, new String[] { dVar.g() }, str2, cancellationSignal);
            } else {
                str = "query = ?";
                strArr2 = new String[i];
                str2 = null;
                query = context.getContentResolver().query(builder, strArr, str, new String[] { dVar.g() }, str2);
            }
            int columnIndex = query.getColumnIndex("result_code");
            arrayList = new ArrayList();
            int columnIndex3 = query.getColumnIndex("file_id");
            int columnIndex4 = query.getColumnIndex("font_ttc_index");
            int columnIndex5 = query.getColumnIndex("font_weight");
            int columnIndex6 = query.getColumnIndex("font_italic");
            int _int = -1;
            if (columnIndex != _int) {
                context2 = query.getInt(columnIndex);
            } else {
            }
            if (columnIndex4 != _int) {
                context2 = query.getInt(columnIndex4);
            } else {
            }
            if (columnIndex3 == _int) {
                appendedId = ContentUris.withAppendedId(builder, query.getLong(query.getColumnIndex("_id")));
            } else {
                appendedId = ContentUris.withAppendedId(new Uri.Builder().scheme(str6).authority(str32).appendPath("file").build(), query.getLong(columnIndex3));
            }
            if (columnIndex5 != _int) {
                _int2 = query.getInt(columnIndex5);
            } else {
                _int2 = 400;
            }
            if (columnIndex6 == _int || query.getInt(columnIndex6) != i) {
                int i5 = 0;
            } else {
            }
            arrayList.add(f.b.a(appendedId, context2, _int2, z, context2));
        } catch (Throwable th) {
        }
        if (query != null) {
            query.close();
        }
        return (f.b[])arrayList.toArray(new f.b[0]);
    }
}
