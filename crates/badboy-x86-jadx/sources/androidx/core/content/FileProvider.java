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
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import androidx.core.util.ObjectsCompat;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes5.dex */
public class FileProvider extends ContentProvider {

    private static final String ATTR_NAME = "name";
    private static final String ATTR_PATH = "path";
    private static final String[] COLUMNS = null;
    private static final File DEVICE_ROOT = null;
    private static final String DISPLAYNAME_FIELD = "displayName";
    private static final String META_DATA_FILE_PROVIDER_PATHS = "android.support.FILE_PROVIDER_PATHS";
    private static final String TAG_CACHE_PATH = "cache-path";
    private static final String TAG_EXTERNAL = "external-path";
    private static final String TAG_EXTERNAL_CACHE = "external-cache-path";
    private static final String TAG_EXTERNAL_FILES = "external-files-path";
    private static final String TAG_EXTERNAL_MEDIA = "external-media-path";
    private static final String TAG_FILES_PATH = "files-path";
    private static final String TAG_ROOT_PATH = "root-path";
    private static final HashMap<String, androidx.core.content.FileProvider.PathStrategy> sCache;
    private String mAuthority;
    private androidx.core.content.FileProvider.PathStrategy mLocalPathStrategy;
    private final Object mLock;
    private final int mResourceId;

    static class Api21Impl {
        static File[] getExternalMediaDirs(Context context) {
            return context.getExternalMediaDirs();
        }
    }

    interface PathStrategy {
        public abstract File getFileForUri(Uri uri);

        public abstract Uri getUriForFile(File file);
    }

    static class SimplePathStrategy implements androidx.core.content.FileProvider.PathStrategy {

        private final String mAuthority;
        private final HashMap<String, File> mRoots;
        SimplePathStrategy(String authority) {
            super();
            HashMap hashMap = new HashMap();
            this.mRoots = hashMap;
            this.mAuthority = authority;
        }

        private boolean belongsToRoot(String filePath, String rootPath) {
            StringBuilder stringBuilder = new StringBuilder();
            return FileProvider.access$000(filePath).startsWith(stringBuilder.append(FileProvider.access$000(rootPath)).append('/').toString());
        }

        @Override // androidx.core.content.FileProvider$PathStrategy
        void addRoot(String name, File root) {
            if (TextUtils.isEmpty(name)) {
            } else {
                this.mRoots.put(name, root.getCanonicalFile());
            }
            IllegalArgumentException e = new IllegalArgumentException("Name must not be empty");
            throw e;
        }

        @Override // androidx.core.content.FileProvider$PathStrategy
        public File getFileForUri(Uri uri) {
            String encodedPath = uri.getEncodedPath();
            int i2 = 1;
            int indexOf = encodedPath.indexOf(47, i2);
            if (indexOf == -1) {
            } else {
                Object obj = this.mRoots.get(Uri.decode(encodedPath.substring(i2, indexOf)));
                if ((File)obj == null) {
                } else {
                    File file2 = new File((File)obj, Uri.decode(encodedPath.substring(indexOf + 1)));
                    File canonicalFile = file2.getCanonicalFile();
                    if (belongsToRoot(canonicalFile.getPath(), obj.getPath()) == null) {
                    } else {
                        return canonicalFile;
                    }
                    SecurityException securityException = new SecurityException("Resolved path jumped beyond configured root");
                    throw securityException;
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                IllegalArgumentException file = new IllegalArgumentException(stringBuilder2.append("Unable to find configured root for ").append(uri).toString());
                throw file;
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException tag = new IllegalArgumentException(stringBuilder.append("Unable to find path from root: ").append(uri).toString());
            throw tag;
        }

        @Override // androidx.core.content.FileProvider$PathStrategy
        public Uri getUriForFile(File file) {
            String path2;
            int mostSpecific;
            Object next;
            String path;
            int length;
            boolean belongsToRoot;
            int length2;
            try {
                String canonicalPath = file.getCanonicalPath();
                mostSpecific = 0;
                Iterator iterator = this.mRoots.entrySet().iterator();
                next = iterator.next();
                path = (File)(Map.Entry)next.getValue().getPath();
            }
            if (mostSpecific == 0) {
            } else {
                String path5 = (File)mostSpecific.getValue().getPath();
                String str = "/";
                if (path5.endsWith(str)) {
                    path2 = canonicalPath.substring(path5.length());
                } else {
                    path2 = canonicalPath.substring(length3++);
                }
                StringBuilder stringBuilder2 = new StringBuilder();
                Uri.Builder builder = new Uri.Builder();
                return builder.scheme("content").authority(this.mAuthority).encodedPath(stringBuilder2.append(Uri.encode((String)mostSpecific.getKey())).append('/').append(Uri.encode(path2, str)).toString()).build();
            }
            StringBuilder stringBuilder = new StringBuilder();
            IllegalArgumentException rootPath = new IllegalArgumentException(stringBuilder.append("Failed to find configured root that contains ").append(canonicalPath).toString());
            throw rootPath;
        }
    }
    static {
        String[] strArr = new String[2];
        FileProvider.COLUMNS = strArr;
        File file = new File("/");
        FileProvider.DEVICE_ROOT = file;
        HashMap hashMap = new HashMap();
        FileProvider.sCache = hashMap;
    }

    public FileProvider() {
        super(0);
    }

    protected FileProvider(int resourceId) {
        super();
        Object object = new Object();
        this.mLock = object;
        this.mResourceId = resourceId;
    }

    static String access$000(String x0) {
        return FileProvider.removeTrailingSlash(x0);
    }

    private static File buildPath(File base, String... segments) {
        File cur;
        int i;
        Object obj;
        File file;
        cur = base;
        i = 0;
        while (i < segments.length) {
            obj = segments[i];
            if (obj != null) {
            }
            i++;
            file = new File(cur, obj);
            cur = file;
        }
        return cur;
    }

    private static Object[] copyOf(Object[] original, int newLength) {
        final Object[] arr = new Object[newLength];
        final int i = 0;
        System.arraycopy(original, i, arr, i, newLength);
        return arr;
    }

    private static String[] copyOf(String[] original, int newLength) {
        final String[] strArr = new String[newLength];
        final int i = 0;
        System.arraycopy(original, i, strArr, i, newLength);
        return strArr;
    }

    static XmlResourceParser getFileProviderPathsMetaData(Context context, String authority, ProviderInfo info, int resourceId) {
        Bundle metaData;
        int i;
        if (info == null) {
        } else {
            String str = "android.support.FILE_PROVIDER_PATHS";
            if (info.metaData == null && resourceId != 0) {
                if (resourceId != 0) {
                    Bundle bundle = new Bundle(1);
                    info.metaData = bundle;
                    info.metaData.putInt(str, resourceId);
                }
            }
            XmlResourceParser xmlMetaData = info.loadXmlMetaData(context.getPackageManager(), str);
            if (xmlMetaData == null) {
            } else {
                return xmlMetaData;
            }
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
            throw illegalArgumentException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        IllegalArgumentException in = new IllegalArgumentException(stringBuilder.append("Couldn't find meta-data for provider with authority ").append(authority).toString());
        throw in;
    }

    private androidx.core.content.FileProvider.PathStrategy getLocalPathStrategy() {
        androidx.core.content.FileProvider.PathStrategy mLocalPathStrategy;
        String mAuthority;
        int mResourceId;
        final Object mLock = this.mLock;
        ObjectsCompat.requireNonNull(this.mAuthority, "mAuthority is null. Did you override attachInfo and did not call super.attachInfo()?");
        synchronized (mLock) {
            this.mLocalPathStrategy = FileProvider.getPathStrategy(getContext(), this.mAuthority, this.mResourceId);
            return this.mLocalPathStrategy;
        }
    }

    private static androidx.core.content.FileProvider.PathStrategy getPathStrategy(Context context, String authority, int resourceId) {
        Object strat;
        Object e;
        final HashMap sCache = FileProvider.sCache;
        synchronized (sCache) {
            FileProvider.sCache.put(authority, FileProvider.parsePathStrategy(context, authority, resourceId));
            return strat;
        }
    }

    public static Uri getUriForFile(Context context, String authority, File file) {
        return FileProvider.getPathStrategy(context, authority, 0).getUriForFile(file);
    }

    public static Uri getUriForFile(Context context, String authority, File file, String displayName) {
        return FileProvider.getUriForFile(context, authority, file).buildUpon().appendQueryParameter("displayName", displayName).build();
    }

    private static int modeToMode(String mode) {
        boolean equals;
        int i;
        if ("r".equals(mode)) {
            i = 268435456;
        } else {
            if (!"w".equals(mode)) {
                if ("wt".equals(mode)) {
                } else {
                    if ("wa".equals(mode)) {
                        i = 704643072;
                    } else {
                        if ("rw".equals(mode)) {
                            i = 939524096;
                        } else {
                            if (!"rwt".equals(mode)) {
                            } else {
                                i = 1006632960;
                            }
                        }
                    }
                }
                StringBuilder stringBuilder = new StringBuilder();
                IllegalArgumentException modeBits4 = new IllegalArgumentException(stringBuilder.append("Invalid mode: ").append(mode).toString());
                throw modeBits4;
            }
            i = 738197504;
        }
        return i;
    }

    private static androidx.core.content.FileProvider.PathStrategy parsePathStrategy(Context context, String authority, int resourceId) throws IOException, XmlPullParserException {
        int name;
        int i2;
        int path;
        String attributeValue;
        int externalFilesDirs;
        String attributeValue2;
        File target;
        boolean equals;
        int i;
        FileProvider.SimplePathStrategy simplePathStrategy = new FileProvider.SimplePathStrategy(authority);
        XmlResourceParser fileProviderPathsMetaData = FileProvider.getFileProviderPathsMetaData(context, authority, context.getPackageManager().resolveContentProvider(authority, 128), resourceId);
        int next = fileProviderPathsMetaData.next();
        path = 1;
        while (next != path) {
            if (next == 2) {
            }
            next = fileProviderPathsMetaData.next();
            path = 1;
            name = fileProviderPathsMetaData.getName();
            externalFilesDirs = 0;
            target = 0;
            i = 0;
            if ("root-path".equals(name)) {
            } else {
            }
            if ("files-path".equals(name) != null) {
            } else {
            }
            if ("cache-path".equals(name)) {
            } else {
            }
            if ("external-path".equals(name)) {
            } else {
            }
            if ("external-files-path".equals(name) != null) {
            } else {
            }
            if ("external-cache-path".equals(name)) {
            } else {
            }
            externalFilesDirs = FileProvider.Api21Impl.getExternalMediaDirs(context);
            if ("external-media-path".equals(name) && externalFilesDirs.length > 0) {
            }
            if (target != null) {
            }
            String[] strArr = new String[path];
            strArr[i] = fileProviderPathsMetaData.getAttributeValue(externalFilesDirs, "path");
            simplePathStrategy.addRoot(fileProviderPathsMetaData.getAttributeValue(externalFilesDirs, "name"), FileProvider.buildPath(target, strArr));
            externalFilesDirs = FileProvider.Api21Impl.getExternalMediaDirs(context);
            if (externalFilesDirs.length > 0) {
            }
            target = externalFilesDirs[i];
            externalFilesDirs = ContextCompat.getExternalCacheDirs(context);
            if (externalFilesDirs.length > 0) {
            }
            target = externalFilesDirs[i];
            externalFilesDirs = ContextCompat.getExternalFilesDirs(context, externalFilesDirs);
            if (externalFilesDirs.length > 0) {
            }
            target = externalFilesDirs[i];
            target = Environment.getExternalStorageDirectory();
            target = context.getCacheDir();
            target = context.getFilesDir();
            target = FileProvider.DEVICE_ROOT;
        }
        return simplePathStrategy;
    }

    private static String removeTrailingSlash(String path) {
        int charAt;
        int i;
        if (path.length() > 0 && path.charAt(length--) == 47) {
            if (path.charAt(length--) == 47) {
                return path.substring(0, length2--);
            }
        }
        return path;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo info) {
        String authority;
        super.attachInfo(context, info);
        if (info.exported) {
        } else {
            if (!info.grantUriPermissions) {
            } else {
                if (info.authority == null) {
                } else {
                    if (info.authority.trim().isEmpty()) {
                    } else {
                        String str = info.authority.split(";")[0];
                        Object mLock = this.mLock;
                        this.mAuthority = str;
                        final HashMap sCache2 = FileProvider.sCache;
                        FileProvider.sCache.remove(str);
                        return;
                        synchronized (mLock) {
                            str = info.authority.split(";")[0];
                            mLock = this.mLock;
                            this.mAuthority = str;
                            sCache2 = FileProvider.sCache;
                            FileProvider.sCache.remove(str);
                        }
                    }
                }
                SecurityException authority2 = new SecurityException("Provider must have a non-empty authority");
                throw authority2;
            }
            SecurityException securityException2 = new SecurityException("Provider must grant uri permissions");
            throw securityException2;
        }
        SecurityException securityException = new SecurityException("Provider must not be exported");
        throw securityException;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return getLocalPathStrategy().getFileForUri(uri).delete();
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        int substring;
        String mimeTypeFromExtension;
        File fileForUri = getLocalPathStrategy().getFileForUri(uri);
        int lastIndexOf = fileForUri.getName().lastIndexOf(46);
        mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(lastIndexOf + 1));
        if (lastIndexOf >= 0 && mimeTypeFromExtension != null) {
            mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileForUri.getName().substring(lastIndexOf + 1));
            if (mimeTypeFromExtension != null) {
                return mimeTypeFromExtension;
            }
        }
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public String getTypeAnonymous(Uri uri) {
        return "application/octet-stream";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues values) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("No external inserts");
        throw unsupportedOperationException;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return 1;
    }

    public ParcelFileDescriptor openFile(Uri uri, String mode) throws FileNotFoundException {
        return ParcelFileDescriptor.open(getLocalPathStrategy().getFileForUri(uri), FileProvider.modeToMode(mode));
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int i2;
        int i;
        String str;
        String i3;
        boolean valueOf;
        String[] obj13;
        File fileForUri = getLocalPathStrategy().getFileForUri(uri);
        String queryParameter = uri.getQueryParameter("displayName");
        if (projection == null) {
            obj13 = FileProvider.COLUMNS;
        }
        String[] strArr = new String[obj13.length];
        Object[] arr = new Object[obj13.length];
        i2 = 0;
        i = 0;
        while (i < obj13.length) {
            str = obj13[i];
            String str3 = "_display_name";
            if (str3.equals(str)) {
            } else {
            }
            i3 = "_size";
            if (i3.equals(str)) {
            }
            i++;
            strArr[i2] = i3;
            arr[i2] = Long.valueOf(fileForUri.length());
            i2 = i3;
            strArr[i2] = str3;
            if (queryParameter == null) {
            } else {
            }
            valueOf = queryParameter;
            arr[i2] = valueOf;
            i2 = i3;
            valueOf = fileForUri.getName();
        }
        MatrixCursor matrixCursor = new MatrixCursor(FileProvider.copyOf(strArr, i2), 1);
        matrixCursor.addRow(FileProvider.copyOf(arr, i2));
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("No external updates");
        throw unsupportedOperationException;
    }
}
