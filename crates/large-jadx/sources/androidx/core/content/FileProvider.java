package androidx.core.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FileProvider extends ContentProvider {

    private static final String[] b;
    private static final File c;
    private static HashMap<String, androidx.core.content.FileProvider.a> v;
    private androidx.core.content.FileProvider.a a;

    interface a {
        public abstract File a(Uri uri);

        public abstract Uri b(File file);
    }

    static class b implements androidx.core.content.FileProvider.a {

        private final String a;
        private final HashMap<String, File> b;
        b(String string) {
            super();
            HashMap hashMap = new HashMap();
            this.b = hashMap;
            this.a = string;
        }

        @Override // androidx.core.content.FileProvider$a
        public File a(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int i3 = 1;
            int indexOf = encodedPath.indexOf(47, i3);
            Object obj = this.b.get(Uri.decode(encodedPath.substring(i3, indexOf)));
            if ((File)obj == null) {
            } else {
                File obj5 = new File((File)obj, Uri.decode(encodedPath.substring(indexOf += i3)));
                obj5 = obj5.getCanonicalFile();
                if (!obj5.getPath().startsWith(obj.getPath())) {
                } else {
                    return obj5;
                }
                obj5 = new SecurityException("Resolved path jumped beyond configured root");
                throw obj5;
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Unable to find configured root for ");
            stringBuilder2.append(uri);
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString());
            throw illegalArgumentException2;
        }

        @Override // androidx.core.content.FileProvider$a
        public Uri b(File file) {
            int i;
            int length;
            Object next;
            String length2;
            boolean startsWith;
            String obj6;
            try {
                obj6 = file.getCanonicalPath();
                i = 0;
                Iterator iterator = this.b.entrySet().iterator();
                next = iterator.next();
                length2 = (File)(Map.Entry)next.getValue().getPath();
            }
            if (i == 0) {
            } else {
                String path = (File)i.getValue().getPath();
                String str4 = "/";
                if (path.endsWith(str4)) {
                    obj6 = obj6.substring(path.length());
                } else {
                    obj6 = obj6.substring(length3++);
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(Uri.encode((String)i.getKey()));
                stringBuilder3.append('/');
                stringBuilder3.append(Uri.encode(obj6, str4));
                Uri.Builder builder = new Uri.Builder();
                return builder.scheme("content").authority(this.a).encodedPath(stringBuilder3.toString()).build();
            }
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Failed to find configured root that contains ");
            stringBuilder2.append(obj6);
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(stringBuilder2.toString());
            throw illegalArgumentException2;
        }

        @Override // androidx.core.content.FileProvider$a
        void c(String string, File file2) {
            if (TextUtils.isEmpty(string)) {
            } else {
                this.b.put(string, file2.getCanonicalFile());
            }
            IllegalArgumentException obj4 = new IllegalArgumentException("Name must not be empty");
            throw obj4;
        }
    }
    static {
        FileProvider.b = /* result */;
        File file = new File("/");
        FileProvider.c = file;
        HashMap hashMap = new HashMap();
        FileProvider.v = hashMap;
    }

    private static File a(File file, String... string2Arr2) {
        int i;
        Object obj;
        File file2;
        File obj4;
        i = 0;
        while (i < string2Arr2.length) {
            obj = string2Arr2[i];
            if (obj != null) {
            }
            i++;
            file2 = new File(obj4, obj);
            obj4 = file2;
        }
        return obj4;
    }

    private static Object[] b(Object[] objectArr, int i2) {
        final Object[] arr = new Object[i2];
        final int i = 0;
        System.arraycopy(objectArr, i, arr, i, i2);
        return arr;
    }

    private static String[] c(String[] stringArr, int i2) {
        final String[] strArr = new String[i2];
        final int i = 0;
        System.arraycopy(stringArr, i, strArr, i, i2);
        return strArr;
    }

    private static androidx.core.content.FileProvider.a d(Context context, String string2) {
        Object obj;
        Object obj2;
        final HashMap map = FileProvider.v;
        synchronized (map) {
            FileProvider.v.put(string2, FileProvider.g(context, string2));
            return obj;
        }
    }

    public static Uri e(Context context, String string2, File file3) {
        return FileProvider.d(context, string2).b(file3);
    }

    private static int f(String string) {
        boolean equals;
        int obj3;
        if ("r".equals(string)) {
            obj3 = 268435456;
        } else {
            if (!"w".equals(string)) {
                if ("wt".equals(string)) {
                } else {
                    if ("wa".equals(string)) {
                        obj3 = 704643072;
                    } else {
                        if ("rw".equals(string)) {
                            obj3 = 939524096;
                        } else {
                            if (!"rwt".equals(string)) {
                            } else {
                                obj3 = 1006632960;
                            }
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Invalid mode: ");
                stringBuilder.append(string);
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(stringBuilder.toString());
                throw illegalArgumentException;
            }
            obj3 = 738197504;
        }
        return obj3;
    }

    private static androidx.core.content.FileProvider.a g(Context context, String string2) {
        ProviderInfo resolveContentProvider;
        String str;
        int externalStorageDirectory;
        String attributeValue2;
        String attributeValue;
        boolean sDK_INT;
        int i2;
        int i;
        FileProvider.b bVar = new FileProvider.b(string2);
        resolveContentProvider = context.getPackageManager().resolveContentProvider(string2, 128);
        if (resolveContentProvider == null) {
        } else {
            XmlResourceParser obj10 = resolveContentProvider.loadXmlMetaData(context.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
            if (obj10 == null) {
            }
            IllegalArgumentException obj9 = new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            throw obj9;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't find meta-data for provider with authority ");
        stringBuilder.append(string2);
        obj9 = new IllegalArgumentException(stringBuilder.toString());
        throw obj9;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo2) {
        super.attachInfo(context, providerInfo2);
        if (providerInfo2.exported) {
        } else {
            if (!providerInfo2.grantUriPermissions) {
            } else {
                this.a = FileProvider.d(context, providerInfo2.authority.split(";")[0]);
            }
            SecurityException obj2 = new SecurityException("Provider must grant uri permissions");
            throw obj2;
        }
        obj2 = new SecurityException("Provider must not be exported");
        throw obj2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String string2, String[] string3Arr3) {
        return this.a.a(uri).delete();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int lastIndexOf;
        Object obj3;
        obj3 = this.a.a(uri);
        lastIndexOf = obj3.getName().lastIndexOf(46);
        obj3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(obj3.getName().substring(lastIndexOf++));
        if (lastIndexOf >= 0 && obj3 != null) {
            obj3 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(obj3.getName().substring(lastIndexOf++));
            if (obj3 != null) {
                return obj3;
            }
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues2) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("No external inserts");
        throw obj1;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return 1;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String string2) {
        return ParcelFileDescriptor.open(this.a.a(uri), FileProvider.f(string2));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] string2Arr2, String string3, String[] string4Arr4, String string5) {
        int i;
        int i2;
        int equals2;
        Long valueOf;
        boolean equals;
        String[] obj8;
        File obj9 = this.a.a(uri);
        String obj7 = uri.getQueryParameter("displayName");
        if (string2Arr2 == null) {
            obj8 = FileProvider.b;
        }
        String[] obj10 = new String[obj8.length];
        Object[] obj11 = new Object[obj8.length];
        i2 = i;
        while (i < obj8.length) {
            String str = obj8[i];
            String str2 = "_display_name";
            equals = str2.equals(str);
            if (equals) {
            } else {
            }
            valueOf = "_size";
            if (valueOf.equals(str)) {
            }
            i++;
            obj10[i2] = valueOf;
            equals2 = i2 + 1;
            obj11[i2] = Long.valueOf(obj9.length());
            i2 = equals2;
            obj10[i2] = str2;
            equals2 = i2 + 1;
            if (obj7 == null) {
            } else {
            }
            valueOf = obj7;
            obj11[i2] = valueOf;
            valueOf = obj9.getName();
        }
        obj9 = new MatrixCursor(FileProvider.c(obj10, i2), 1);
        obj9.addRow(FileProvider.b(obj11, i2));
        return obj9;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues2, String string3, String[] string4Arr4) {
        UnsupportedOperationException obj1 = new UnsupportedOperationException("No external updates");
        throw obj1;
    }
}
