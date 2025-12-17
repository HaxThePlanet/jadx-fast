package d.h.i;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
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

/* loaded from: classes.dex */
class c {

    private static final Comparator<byte[]> a;

    class a implements Comparator<byte[]> {
        @Override // java.util.Comparator
        public int a(byte[] bArr, byte[] b2Arr2) {
            int length;
            int length2;
            byte b2;
            byte b;
            int obj5;
            int obj6;
            if (bArr.length != b2Arr2.length) {
                obj5 = bArr.length;
                obj6 = b2Arr2.length;
                return obj5 -= obj6;
            } else {
                length = 0;
                length2 = length;
                for (byte b2 : bArr) {
                }
            }
            return length;
        }

        @Override // java.util.Comparator
        public int compare(Object object, Object object2) {
            return a((byte[])object, (byte[])object2);
        }
    }
    static {
        c.a aVar = new c.a();
        c.a = aVar;
    }

    private static List<byte[]> a(Signature[] signatureArr) {
        int i;
        byte[] byteArray;
        ArrayList arrayList = new ArrayList();
        i = 0;
        for (Object obj : signatureArr) {
            arrayList.add(obj.toByteArray());
        }
        return arrayList;
    }

    private static boolean b(List<byte[]> list, List<byte[]> list2) {
        int i;
        int equals;
        Object obj;
        final int i2 = 0;
        if (list.size() != list2.size()) {
            return i2;
        }
        i = i2;
        while (i < list.size()) {
            i++;
        }
        return 1;
    }

    private static List<List<byte[]>> c(d.h.i.d d, Resources resources2) {
        if (d.b() != null) {
            return d.b();
        }
        return c.c(resources2, d.c());
    }

    static d.h.i.f.a d(Context context, d.h.i.d d2, CancellationSignal cancellationSignal3) {
        ProviderInfo providerInfo = c.e(context.getPackageManager(), d2, context.getResources());
        if (providerInfo == null) {
            return f.a.a(1, 0);
        }
        return f.a.a(0, c.f(context, d2, providerInfo.authority, cancellationSignal3));
    }

    static ProviderInfo e(PackageManager packageManager, d.h.i.d d2, Resources resources3) {
        Comparator comparator;
        int i;
        Resources obj7;
        String str = d2.e();
        final ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
        if (resolveContentProvider == null) {
        } else {
            if (!resolveContentProvider.packageName.equals(d2.f())) {
            } else {
                List obj5 = c.a(obj5.signatures);
                Collections.sort(obj5, c.a);
                List obj6 = c.c(d2, resources3);
                while (i < obj6.size()) {
                    obj7 = new ArrayList((Collection)obj6.get(i));
                    Collections.sort(obj7, c.a);
                    i++;
                }
                return null;
            }
            obj7 = new StringBuilder();
            obj7.append("Found content provider ");
            obj7.append(str);
            obj7.append(", but package was not ");
            obj7.append(d2.f());
            obj5 = new PackageManager.NameNotFoundException(obj7.toString());
            throw obj5;
        }
        obj6 = new StringBuilder();
        obj6.append("No package found for authority: ");
        obj6.append(str);
        obj5 = new PackageManager.NameNotFoundException(obj6.toString());
        throw obj5;
    }

    static d.h.i.f.b[] f(Context context, d.h.i.d d2, String string3, CancellationSignal cancellationSignal4) {
        ArrayList arrayList;
        Cursor query;
        ContentResolver contentResolver;
        android.net.Uri columnIndex4;
        String[] columnIndex5;
        String columnIndex;
        String[] columnIndex3;
        int columnIndex2;
        Object moveToNext;
        int int4;
        int i;
        int i3;
        android.net.Uri appendedId;
        int int;
        int int3;
        int int2;
        int i2;
        int obj16;
        String str = string3;
        arrayList = new ArrayList();
        Uri.Builder builder = new Uri.Builder();
        String str3 = "content";
        android.net.Uri build2 = builder.scheme(str3).authority(str).build();
        Uri.Builder builder2 = new Uri.Builder();
        int i5 = 0;
        columnIndex5 = /* result */;
        final int i7 = 1;
        i3 = 0;
        if (Build.VERSION.SDK_INT > 16) {
            columnIndex3 = new String[i7];
            columnIndex3[i3] = d2.g();
            query = context.getContentResolver().query(build2, columnIndex5, "query = ?", columnIndex3, 0, cancellationSignal4);
        } else {
            columnIndex3 = new String[i7];
            columnIndex3[i3] = d2.g();
            query = context.getContentResolver().query(build2, columnIndex5, "query = ?", columnIndex3, 0);
        }
        if (query != null && query.getCount() > 0) {
            if (query.getCount() > 0) {
                int columnIndex6 = query.getColumnIndex("result_code");
                contentResolver = new ArrayList();
                columnIndex5 = query.getColumnIndex("file_id");
                columnIndex = query.getColumnIndex("font_ttc_index");
                columnIndex3 = query.getColumnIndex("font_weight");
                columnIndex2 = query.getColumnIndex("font_italic");
                while (query.moveToNext()) {
                    int4 = -1;
                    if (columnIndex6 != int4) {
                    } else {
                    }
                    int3 = i3;
                    if (columnIndex != int4) {
                    } else {
                    }
                    int2 = i3;
                    if (columnIndex5 == int4) {
                    } else {
                    }
                    obj16 = int3;
                    appendedId = ContentUris.withAppendedId(builder2.scheme(str3).authority(str).appendPath("file").build(), query.getLong(columnIndex5));
                    if (columnIndex3 != int4) {
                    } else {
                    }
                    int = 400;
                    if (columnIndex2 != int4 && query.getInt(columnIndex2) == i7) {
                    } else {
                    }
                    i2 = 0;
                    i = obj16;
                    contentResolver.add(f.b.a(appendedId, int2, int, i2, i));
                    i3 = 0;
                    if (query.getInt(columnIndex2) == i7) {
                    } else {
                    }
                    i = obj16;
                    i2 = i7;
                    int = query.getInt(columnIndex3);
                    obj16 = int3;
                    appendedId = ContentUris.withAppendedId(build2, query.getLong(query.getColumnIndex("_id")));
                    int2 = query.getInt(columnIndex);
                    int3 = query.getInt(columnIndex6);
                }
                arrayList = contentResolver;
            }
        }
        if (query != null) {
            query.close();
        }
        return (f.b[])arrayList.toArray(new f.b[0]);
    }
}
