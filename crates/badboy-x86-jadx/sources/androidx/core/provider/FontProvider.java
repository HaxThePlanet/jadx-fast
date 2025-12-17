package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.LruCache;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes5.dex */
class FontProvider {

    private static final Comparator<byte[]> sByteArrayComparator;
    private static final LruCache<androidx.core.provider.FontProvider.ProviderCacheKey, ProviderInfo> sProviderCache;

    private interface ContentQueryWrapper {
        public static androidx.core.provider.FontProvider.ContentQueryWrapper make(Context context, Uri uri) {
            FontProvider.ContentQueryWrapperApi24Impl contentQueryWrapperApi24Impl = new FontProvider.ContentQueryWrapperApi24Impl(context, uri);
            return contentQueryWrapperApi24Impl;
        }

        public abstract void close();

        public abstract Cursor query(Uri uri, String[] string2Arr2, String string3, String[] string4Arr4, String string5, CancellationSignal cancellationSignal6);
    }

    private static class ContentQueryWrapperApi16Impl implements androidx.core.provider.FontProvider.ContentQueryWrapper {

        private final ContentProviderClient mClient;
        ContentQueryWrapperApi16Impl(Context context, Uri uri) {
            super();
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.FontProvider$ContentQueryWrapper
        public void close() {
            ContentProviderClient mClient;
            if (this.mClient != null) {
                this.mClient.release();
            }
        }

        @Override // androidx.core.provider.FontProvider$ContentQueryWrapper
        public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
            Throwable th;
            String str2;
            String str3;
            String[] strArr;
            String str;
            CancellationSignal cancellationSignal2;
            if (this.mClient == null) {
                return null;
            }
            return this.mClient.query(uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
        }
    }

    private static class ContentQueryWrapperApi24Impl implements androidx.core.provider.FontProvider.ContentQueryWrapper {

        private final ContentProviderClient mClient;
        ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            super();
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.FontProvider$ContentQueryWrapper
        public void close() {
            ContentProviderClient mClient;
            if (this.mClient != null) {
                this.mClient.close();
            }
        }

        @Override // androidx.core.provider.FontProvider$ContentQueryWrapper
        public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder, CancellationSignal cancellationSignal) {
            Throwable th;
            String str3;
            String str;
            String[] strArr;
            String str2;
            CancellationSignal cancellationSignal2;
            if (this.mClient == null) {
                return null;
            }
            return this.mClient.query(uri, projection, selection, selectionArgs, sortOrder, cancellationSignal);
        }
    }

    private static class ProviderCacheKey {

        String mAuthority;
        List<List<byte[]>> mCertificates;
        String mPackageName;
        ProviderCacheKey(String authority, String packageName, List<List<byte[]>> list3) {
            super();
            this.mAuthority = authority;
            this.mPackageName = packageName;
            this.mCertificates = list3;
        }

        public boolean equals(Object o) {
            int i;
            boolean equals;
            Object mCertificates;
            if (this == o) {
                return 1;
            }
            final int i2 = 0;
            if (!o instanceof FontProvider.ProviderCacheKey) {
                return i2;
            }
            Object obj = o;
            if (Objects.equals(this.mAuthority, obj.mAuthority) && Objects.equals(this.mPackageName, obj.mPackageName) && Objects.equals(this.mCertificates, obj.mCertificates)) {
                if (Objects.equals(this.mPackageName, obj.mPackageName)) {
                    if (Objects.equals(this.mCertificates, obj.mCertificates)) {
                    } else {
                        i = i2;
                    }
                } else {
                }
            } else {
            }
            return i;
        }

        public int hashCode() {
            return Objects.hash(/* result */);
        }
    }
    static {
        LruCache lruCache = new LruCache(2);
        FontProvider.sProviderCache = lruCache;
        FontProvider$$ExternalSyntheticLambda0 externalSyntheticLambda0 = new FontProvider$$ExternalSyntheticLambda0();
        FontProvider.sByteArrayComparator = externalSyntheticLambda0;
    }

    static void clearProviderCache() {
        FontProvider.sProviderCache.evictAll();
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatures) {
        int i;
        Object obj;
        byte[] byteArray;
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < signatures.length) {
            arrayList.add(signatures[i].toByteArray());
            i++;
        }
        return arrayList;
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        int i;
        int equals;
        Object obj;
        final int i3 = 0;
        if (list.size() != list2.size()) {
            return i3;
        }
        i = 0;
        while (i < list.size()) {
            i++;
        }
        return 1;
    }

    private static List<List<byte[]>> getCertificates(androidx.core.provider.FontRequest request, Resources resources) {
        if (request.getCertificates() != null) {
            return request.getCertificates();
        }
        return FontResourcesParserCompat.readCerts(resources, request.getCertificatesArrayResId());
    }

    static androidx.core.provider.FontsContractCompat.FontFamilyResult getFontFamilyResult(Context context, List<androidx.core.provider.FontRequest> list2, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        int i;
        Object obj;
        ProviderInfo provider;
        androidx.core.provider.FontsContractCompat.FontInfo[] query;
        Trace.beginSection("FontProvider.getFontFamilyResult");
        ArrayList arrayList = new ArrayList();
        i = 0;
        while (i < list2.size()) {
            obj = list2.get(i);
            provider = FontProvider.getProvider(context.getPackageManager(), (FontRequest)obj, context.getResources());
            arrayList.add(FontProvider.query(context, obj, provider.authority, cancellationSignal));
            i++;
        }
        try {
            Trace.endSection();
            return FontsContractCompat.FontFamilyResult.create(0, arrayList);
            Trace.endSection();
            throw queryResults;
        }
    }

    static ProviderInfo getProvider(PackageManager packageManager, androidx.core.provider.FontRequest request, Resources resources) throws PackageManager.NameNotFoundException {
        int i;
        ArrayList arrayList;
        boolean equalsByteArrayList;
        Trace.beginSection("FontProvider.getProvider");
        List certificates = FontProvider.getCertificates(request, resources);
        FontProvider.ProviderCacheKey providerCacheKey = new FontProvider.ProviderCacheKey(request.getProviderAuthority(), request.getProviderPackage(), certificates);
        Object obj = FontProvider.sProviderCache.get(providerCacheKey);
        if ((ProviderInfo)obj != null) {
            Trace.endSection();
            return (ProviderInfo)obj;
        }
        String providerAuthority2 = request.getProviderAuthority();
        ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority2, 0);
        if (resolveContentProvider == null) {
        } else {
            if (!resolveContentProvider.packageName.equals(request.getProviderPackage())) {
            } else {
                List convertToByteArrayList = FontProvider.convertToByteArrayList(packageInfo2.signatures);
                Collections.sort(convertToByteArrayList, FontProvider.sByteArrayComparator);
                i = 0;
                try {
                    while (i < certificates.size()) {
                        arrayList = new ArrayList((Collection)certificates.get(i));
                        Collections.sort(arrayList, FontProvider.sByteArrayComparator);
                        i++;
                    }
                    arrayList = new ArrayList((Collection)certificates.get(i));
                    Collections.sort(arrayList, FontProvider.sByteArrayComparator);
                    if (FontProvider.equalsByteArrayList(convertToByteArrayList, arrayList)) {
                    } else {
                    }
                    FontProvider.sProviderCache.put(providerCacheKey, resolveContentProvider);
                    Trace.endSection();
                    return resolveContentProvider;
                    i++;
                    Trace.endSection();
                    return null;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    PackageManager.NameNotFoundException packageInfo = new PackageManager.NameNotFoundException(stringBuilder2.append("Found content provider ").append(providerAuthority2).append(", but package was not ").append(request.getProviderPackage()).toString());
                    throw packageInfo;
                    StringBuilder stringBuilder = new StringBuilder();
                    PackageManager.NameNotFoundException nameNotFoundException = new PackageManager.NameNotFoundException(stringBuilder.append("No package found for authority: ").append(providerAuthority2).toString());
                    throw nameNotFoundException;
                    Trace.endSection();
                    throw requestCertificatesList;
                }
            }
        }
    }

    static int lambda$static$0(byte[] l, byte[] r) {
        int i;
        int length;
        byte b;
        if (l.length != r.length) {
            return length3 -= length5;
        }
        i = 0;
        for (byte length : l) {
        }
        return 0;
    }

    static androidx.core.provider.FontsContractCompat.FontInfo[] query(Context context, androidx.core.provider.FontRequest request, String authority, CancellationSignal cancellationSignal) {
        int columnIndex;
        int italicColumnIndex3;
        int fileUri;
        Uri id;
        int weight;
        int int2;
        String columnIndex2;
        String columnIndex3;
        String columnIndex4;
        String columnIndex5;
        ArrayList result;
        Object obj;
        ArrayList arrayList;
        int int;
        Cursor moveToNext;
        String[] strArr;
        int int3;
        int italicColumnIndex2;
        int italicColumnIndex;
        int resultCodeColumnIndex;
        Uri appendedId;
        long l;
        String str = authority;
        columnIndex = "result_code";
        weight = "font_italic";
        columnIndex2 = "font_weight";
        columnIndex3 = "font_ttc_index";
        columnIndex4 = "file_id";
        columnIndex5 = "_id";
        String str2 = "content";
        Trace.beginSection("FontProvider.query");
        result = new ArrayList();
        Uri.Builder builder = new Uri.Builder();
        final Uri uri = build2;
        Uri.Builder builder2 = new Uri.Builder();
        int i2 = 0;
        String[] strArr2 = new String[7];
        int i4 = 0;
        strArr2[i4] = columnIndex5;
        int i5 = 1;
        strArr2[i5] = columnIndex4;
        strArr2[2] = columnIndex3;
        strArr2[3] = "font_variation_settings";
        strArr2[4] = columnIndex2;
        strArr2[5] = weight;
        strArr2[6] = columnIndex;
        Trace.beginSection("ContentQueryWrapper.query");
        androidx.core.provider.FontProvider.ContentQueryWrapper contentQueryWrapper = make;
        strArr = new String[i5];
        strArr[i4] = request.getQuery();
        fileUri = i12;
        Cursor cursor = moveToNext;
        Trace.endSection();
        if (cursor != null && cursor.getCount() > 0) {
            if (cursor.getCount() > 0) {
                columnIndex = cursor.getColumnIndex(columnIndex);
                arrayList = new ArrayList();
                columnIndex4 = cursor.getColumnIndex(columnIndex4);
                columnIndex3 = cursor.getColumnIndex(columnIndex3);
                columnIndex2 = cursor.getColumnIndex(columnIndex2);
                weight = cursor.getColumnIndex(weight);
                while (cursor.moveToNext()) {
                    int = -1;
                    if (columnIndex != int) {
                    } else {
                    }
                    strArr = 0;
                    if (columnIndex3 != int) {
                    } else {
                    }
                    int3 = 0;
                    if (columnIndex4 == int) {
                    } else {
                    }
                    italicColumnIndex = weight;
                    id = appendedId;
                    if (columnIndex2 != int) {
                    } else {
                    }
                    int2 = 400;
                    int resultCodeColumnIndex2 = italicColumnIndex;
                    if (resultCodeColumnIndex2 != int) {
                    } else {
                    }
                    italicColumnIndex2 = resultCodeColumnIndex2;
                    italicColumnIndex3 = 1;
                    arrayList = 0;
                    arrayList.add(FontsContractCompat.FontInfo.create(id, int3, int2, arrayList, strArr));
                    weight = italicColumnIndex2;
                    columnIndex = resultCodeColumnIndex;
                    fileUri = 1;
                    italicColumnIndex2 = resultCodeColumnIndex2;
                    italicColumnIndex3 = 1;
                    if (cursor.getInt(resultCodeColumnIndex2) == italicColumnIndex3) {
                    } else {
                    }
                    arrayList = italicColumnIndex3;
                    int2 = cursor.getInt(columnIndex2);
                    italicColumnIndex = weight;
                    id = appendedId;
                    int3 = cursor.getInt(columnIndex3);
                    strArr = cursor.getInt(columnIndex);
                }
                resultCodeColumnIndex = columnIndex;
                italicColumnIndex2 = weight;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        contentQueryWrapper.close();
        Trace.endSection();
        return (FontsContractCompat.FontInfo[])result.toArray(new FontsContractCompat.FontInfo[0]);
    }
}
