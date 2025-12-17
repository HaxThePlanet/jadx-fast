package zendesk.belvedere;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import androidx.core.content.FileProvider;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
class z {
    private File a(File file, String string2, String string3) {
        Object obj5;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        if (!TextUtils.isEmpty(string3)) {
        } else {
            obj5 = "";
        }
        stringBuilder.append(obj5);
        File file2 = new File(file, stringBuilder.toString());
        return file2;
    }

    private File b(Context context, String string2) {
        boolean stringBuilder;
        int file;
        String obj5;
        if (!TextUtils.isEmpty(string2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(File.separator);
            obj5 = stringBuilder.toString();
        } else {
            obj5 = "";
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(k(context));
        String obj4 = File.separator;
        stringBuilder2.append(obj4);
        stringBuilder2.append("belvedere-data-v2");
        stringBuilder2.append(obj4);
        stringBuilder2.append(obj5);
        file = new File(stringBuilder2.toString());
        if (file.isDirectory() == null) {
            file.mkdirs();
        }
        if (file.isDirectory() != null) {
        } else {
            file = 0;
        }
        return file;
    }

    private static String c(Context context, Uri uri2, boolean z3) {
        int singleton;
        String obj4;
        int obj5;
        Object[] obj6;
        final String scheme = uri2.getScheme();
        final int i = 1;
        if ("content".equals(scheme)) {
            obj4 = MimeTypeMap.getSingleton().getExtensionFromMimeType(context.getContentResolver().getType(uri2));
        } else {
            obj4 = uri2.getLastPathSegment();
            obj5 = obj4.lastIndexOf(".");
            if ("file".equals(scheme) != null && obj5 != -1) {
                obj4 = uri2.getLastPathSegment();
                obj5 = obj4.lastIndexOf(".");
                if (obj5 != -1) {
                    obj4 = obj4.substring(obj5 += i, obj4.length());
                } else {
                    obj4 = "tmp";
                }
            } else {
            }
        }
        if (z3 != null) {
            obj6 = new Object[i];
            obj6[0] = obj4;
            obj4 = String.format(Locale.US, ".%s", obj6);
        }
        return obj4;
    }

    private static String g(Context context, Uri uri2) {
        String scheme;
        String lastPathSegment;
        ContentResolver contentResolver;
        Uri uri;
        String[] strArr;
        int i3;
        int i;
        int i2;
        boolean obj9;
        boolean obj10;
        scheme = uri2.getScheme();
        lastPathSegment = "";
        if ("content".equals(scheme)) {
            obj9 = context.getContentResolver().query(uri2, /* result */, 0, 0, 0);
            if (obj9 != null && obj9.moveToFirst()) {
                if (obj9.moveToFirst()) {
                    lastPathSegment = obj9.getString(0);
                }
                obj9.close();
            }
        } else {
            if ("file".equals(scheme) != null) {
                lastPathSegment = uri2.getLastPathSegment();
            }
        }
        return lastPathSegment;
    }

    static zendesk.belvedere.s j(Context context, Uri uri2) {
        String equals;
        String str3;
        int i3;
        String str;
        Cursor query;
        Uri uri;
        String type;
        int moveToFirst;
        int i2;
        int i;
        ContentResolver contentResolver;
        String str4;
        String str2;
        int i4;
        long l;
        if ("content".equals(uri2.getScheme())) {
            equals = "_size";
            str = "_display_name";
            contentResolver = context.getContentResolver();
            uri = uri2;
            query = contentResolver.query(uri, /* result */, 0, 0, 0);
            if (query != null && query.moveToFirst()) {
                if (query.moveToFirst()) {
                    str3 = string;
                    i3 = l;
                }
                query.close();
            }
            str4 = str3;
            i4 = i3;
            str2 = type;
        } else {
            uri = uri2;
            str2 = str4;
            i4 = i3;
        }
        super(0, uri2, uri2, str4, str2, i4, obj19, -1, obj21, -1, obj23);
        return sVar;
    }

    private String k(Context context) {
        return context.getCacheDir().getAbsolutePath();
    }

    File d(Context context, String string2, String string3) {
        boolean stringBuilder;
        String string;
        if (!TextUtils.isEmpty(string2)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("user");
            stringBuilder.append(File.separator);
            stringBuilder.append(string2);
            string = stringBuilder.toString();
        }
        File obj3 = b(context, string);
        final int obj4 = 0;
        if (obj3 == null) {
            q.e("Belvedere", "Error creating cache directory");
            return obj4;
        }
        return a(obj3, string3, obj4);
    }

    File e(Context context) {
        File obj8 = b(context, "media");
        if (obj8 == null) {
            q.e("Belvedere", "Error creating cache directory");
            return null;
        }
        Locale uS = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS", uS);
        Object[] arr = new Object[1];
        Date date = new Date(System.currentTimeMillis(), obj6);
        return a(obj8, String.format(uS, "camera_image_%s", simpleDateFormat.format(date)), ".jpg");
    }

    File f(Context context, Uri uri2, String string3) {
        boolean stringBuilder;
        int i2;
        String separator;
        String format;
        boolean empty;
        Object[] arr;
        int i;
        Date date;
        long currentTimeMillis;
        String obj11;
        if (!TextUtils.isEmpty(string3)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("user");
            stringBuilder.append(File.separator);
            stringBuilder.append(string3);
            obj11 = stringBuilder.toString();
        } else {
            obj11 = "media";
        }
        obj11 = b(context, obj11);
        if (obj11 == null) {
            q.e("Belvedere", "Error creating cache directory");
            return null;
        }
        if (TextUtils.isEmpty(z.g(context, uri2))) {
            Locale uS = Locale.US;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS", uS);
            empty = 1;
            arr = new Object[empty];
            date = new Date(System.currentTimeMillis(), obj7);
            arr[0] = simpleDateFormat.format(date);
            format = String.format(uS, "attachment_%s", arr);
            i2 = z.c(context, uri2, empty);
        }
        return a(obj11, format, i2);
    }

    String h(Context context) {
        Object[] arr = new Object[2];
        return String.format(Locale.US, "%s%s", context.getPackageName(), context.getString(x.a));
    }

    Uri i(Context context, File file2) {
        final String str = "Belvedere";
        final int i = 0;
        final int i2 = 1;
        return FileProvider.e(context, h(context), file2);
    }

    void l(Context context, Intent intent2, Uri uri3, int i4) {
        int sDK_INT;
        PackageManager packageManager;
        int i;
        Object obj4;
        if (Build.VERSION.SDK_INT >= 23) {
            intent2.addFlags(i4);
        } else {
            obj4 = context.getPackageManager().queryIntentActivities(intent2, 65536).iterator();
            for (ResolveInfo next : obj4) {
                context.grantUriPermission(activityInfo.packageName, uri3, i4);
            }
        }
    }

    void m(Context context, Uri uri2, int i3) {
        context.revokeUriPermission(uri2, i3);
    }
}
