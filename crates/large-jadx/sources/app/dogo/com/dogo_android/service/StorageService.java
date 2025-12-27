package app.dogo.com.dogo_android.service;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.TransitionDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.ImageView;
import app.dogo.com.dogo_android.util.h0.i1;
import com.google.android.gms.tasks.j;
import com.google.android.gms.tasks.k;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import n.a.a;

/* compiled from: StorageService.kt */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u000c\u0018\u0000 +2\u00020\u0001:\u0002*+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u001f\u001a\u00020 J\"\u0010!\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0010H\u0007J\u0018\u0010#\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003J\u001e\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0010J&\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/service/StorageService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentResolver", "Landroid/content/ContentResolver;", "fileDr", "Ljava/io/File;", "asyncSaveBitmapToExternalFile", "Lcom/google/android/gms/tasks/Task;", "Landroid/net/Uri;", "bmp", "Landroid/graphics/Bitmap;", "createUriForFile", "id", "", "fileName", "fileExist", "", "getBitmap", "imageView", "Landroid/widget/ImageView;", "getBitmapSize", "", "path", "getContactBitmapFromURI", "uri", "getFile", "getFileUri", "getRecordingFile", "timestamp", "", "saveBitmapIntoInternalStorage", "content", "saveBitmapsToExternalFile", "transferFile", "sourceFolder", "targetFolder", "filename", "sourceFileName", "targetFileName", "AsyncBitmapSaver", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: t2, reason: from kotlin metadata */
public final class StorageService {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final t2.b INSTANCE = new t2$b(0);
    /* renamed from: a, reason: from kotlin metadata */
    private final Context contentResolver;
    /* renamed from: b, reason: from kotlin metadata */
    private final File context;
    /* renamed from: c, reason: from kotlin metadata */
    private final ContentResolver fileDr;

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ'\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0011\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00020\u0012\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0014R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/service/StorageService$AsyncBitmapSaver;", "Landroid/os/AsyncTask;", "Landroid/graphics/Bitmap;", "Ljava/lang/Void;", "Landroid/net/Uri;", "service", "Lapp/dogo/com/dogo_android/service/StorageService;", "appContext", "Landroid/content/Context;", "(Lapp/dogo/com/dogo_android/service/StorageService;Landroid/content/Context;)V", "task", "Lcom/google/android/gms/tasks/Task;", "getTask", "()Lcom/google/android/gms/tasks/Task;", "taskSource", "Lcom/google/android/gms/tasks/TaskCompletionSource;", "doInBackground", "bitmaps", "", "([Landroid/graphics/Bitmap;)Landroid/net/Uri;", "onPostExecute", "", "uri", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class a extends AsyncTask<Bitmap, Void, Uri> {

        /* renamed from: a, reason: from kotlin metadata */
        private final Context appContext;
        /* renamed from: b, reason: from kotlin metadata */
        private final k<Uri> service = new k<>();
        private final t2 c;
        public a(Context context) {
            n.f(t2Var, "service");
            n.f(context, "appContext");
            super();
            this.appContext = context;
            final k kVar = new k();
            this.c = t2Var;
        }

        @Override // android.os.AsyncTask
        /* renamed from: a, reason: from kotlin metadata */
        protected Uri doInBackground(Bitmap... bitmaps) {
            Uri bitmapsToExternalFile;
            n.f(bitmaps, "bitmaps");
            try {
                Object obj = bitmaps[0];
                n.d(obj);
                bitmapsToExternalFile = this.c.saveBitmapsToExternalFile(obj, this.appContext);
            } catch (Exception e) {
                this.service.d(e);
                e = null;
            }
            return bitmapsToExternalFile;
        }

        @Override // android.os.AsyncTask
        public final j<Uri> b() {
            j jVar = this.service.a();
            n.e(jVar, "taskSource.task");
            return jVar;
        }

        @Override // android.os.AsyncTask
        /* renamed from: c, reason: from kotlin metadata */
        protected void onPostExecute(Uri uri) {
            super.onPostExecute(uri);
            this.service.e(uri);
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/service/StorageService$Companion;", "", "()V", "CHALLENGE_FAILED", "", "CHALLENGE_PENDING", "CHALLENGE_SUCCESSFUL", "DOG_AVATAR_FILE_NAME", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        private b() {
            super();
        }

        public /* synthetic */ b(g gVar) {
            this();
        }
    }
    public t2(Context context) throws IOException {
        n.f(context, "context");
        super();
        this.contentResolver = context;
        File filesDir = context.getFilesDir();
        n.e(filesDir, "context.filesDir");
        this.context = filesDir;
        final ContentResolver contentResolver = context.getContentResolver();
        n.e(contentResolver, "context.contentResolver");
        this.fileDr = contentResolver;
    }

    /* renamed from: g, reason: from kotlin metadata */
    private final File createUriForFile(String id, String fileName) {
        final File file = new File(this.context, id);
        if (!file.exists() && file.mkdir() == null) {
            a.d(new Exception("failed to create a new directory "));
            return null;
        }
        return new File(file, fileName);
    }

    public static /* synthetic */ boolean k(t2 t2Var, String str, Uri uri, String str2, int i, Object object) {
        if (i & 4 != 0) {
            str = "avatar.jpg";
        }
        return t2Var.saveBitmapIntoInternalStorage(str, uri, str);
    }

    /* renamed from: a, reason: from kotlin metadata */
    public final j<Uri> asyncSaveBitmapToExternalFile(Bitmap bmp) {
        final app.dogo.com.dogo_android.service.t2.a storageService_AsyncBitmapSaver = new StorageService_AsyncBitmapSaver(this, this.contentResolver);
        Bitmap[] arr = new Bitmap[1];
        storageService_AsyncBitmapSaver.execute(new Bitmap[] { bmp });
        return storageService_AsyncBitmapSaver.b();
    }

    /* renamed from: b, reason: from kotlin metadata */
    public final Uri fileExist(String id, String fileName) {
        Uri file = null;
        n.f(id, "id");
        n.f(fileName, "fileName");
        File uriForFile = createUriForFile(id, fileName);
        if (uriForFile != null) {
            file = Uri.fromFile(uriForFile);
        } else {
            int i = 0;
        }
        return file;
    }

    /* renamed from: c, reason: from kotlin metadata */
    public final boolean getFile(String id, String fileName) {
        n.f(id, "id");
        n.f(fileName, "fileName");
        return new File(new File(this.context, id), fileName).exists();
    }

    /* renamed from: d, reason: from kotlin metadata */
    public final Bitmap getBitmap(ImageView imageView) {
        Bitmap bitmap = null;
        n.f(imageView, "imageView");
        android.graphics.drawable.Drawable drawable = imageView.getDrawable();
        final String str2 = "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable";
        if (drawable instanceof BitmapDrawable) {
            android.graphics.drawable.Drawable drawable3 = imageView.getDrawable();
            Objects.requireNonNull(drawable3, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            bitmap = drawable3.getBitmap();
        } else {
            int i2 = 0;
        }
        if (drawable instanceof TransitionDrawable) {
            android.graphics.drawable.Drawable drawable2 = drawable.getDrawable(1);
            Objects.requireNonNull(drawable2, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            bitmap = drawable2.getBitmap();
        }
        return bitmap;
    }

    /* renamed from: e, reason: from kotlin metadata */
    public final int[] getBitmapSize(Uri path) {
        Bitmap contactBitmapFromURI = getContactBitmapFromURI(path);
        int[] iArr = new int[] {0, 0};
        if (contactBitmapFromURI != null) {
            iArr[0] = contactBitmapFromURI.getWidth();
            int i = 1;
            iArr[i] = contactBitmapFromURI.getHeight();
        }
        return iArr;
    }

    /* renamed from: f, reason: from kotlin metadata */
    public final Bitmap getContactBitmapFromURI(Uri uri) throws IOException {
        final int i = 0;
        if (uri == null) {
            return null;
        }
        try {
            java.io.InputStream inputStream = this.fileDr.openInputStream(uri);
            if (inputStream == null) {
                return i;
            }
        } catch (java.io.FileNotFoundException fileNotFound) {
            a.d(fileNotFound);
            return obj;
        }
        return BitmapFactory.decodeStream(inputStream);
    }

    /* renamed from: h, reason: from kotlin metadata */
    public final Uri getFileUri(String id, String fileName) {
        int i = 0;
        boolean exists;
        n.f(id, "id");
        n.f(fileName, "fileName");
        File uriForFile = createUriForFile(id, fileName);
        if (uriForFile == null || !uriForFile.exists()) {
            i = 0;
        } else {
            Uri file = Uri.fromFile(uriForFile);
        }
        return i;
    }

    /* renamed from: i, reason: from kotlin metadata */
    public final File getRecordingFile(long timestamp) throws IOException {
        int i = 0;
        File externalFilesDir = this.contentResolver.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (externalFilesDir != null) {
            externalFilesDir.mkdirs();
        }
        int i2 = 1;
        final Object[] arr = new Object[i2];
        arr[0] = Long.valueOf(timestamp);
        String formatted = String.format("dogo_%d.mp4", Arrays.copyOf(arr, i2));
        n.e(formatted, "java.lang.String.format(format, *args)");
        str = "mounted";
        if (n.b(Environment.getExternalStorageState(new File(externalFilesDir, formatted)), str) == null) {
            str = "External storage not mounted";
            a.d(new Exception(str));
            i = 0;
        }
        return i;
    }

    /* renamed from: j, reason: from kotlin metadata */
    public final boolean saveBitmapIntoInternalStorage(String id, Uri content, String fileName) throws IOException, FileNotFoundException {
        File file;
        n.f(id, "id");
        n.f(content, "content");
        n.f(fileName, "fileName");
        Bitmap contactBitmapFromURI = getContactBitmapFromURI(content);
        boolean z2 = false;
        if (contactBitmapFromURI == null) {
            a.d(new Exception("No bitmap created"));
            return false;
        }
        File file2 = new File(this.context, id);
        if (!file2.exists() && file2.mkdir() == null) {
            a.d(new Exception("Failed to create a new directory for bitmap"));
            return false;
        }
        file = new File(file2, fileName);
        if (file.exists() && file.delete() == null) {
            a.d(new Exception("Could't delete a previous bitmap file"));
            return false;
        }
        try {
            final FileOutputStream fileOutputStream = new FileOutputStream(file);
            contactBitmapFromURI.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            a.d(e);
            return z;
        }
        return true;
    }

    /* renamed from: l, reason: from kotlin metadata */
    public final Uri saveBitmapsToExternalFile(Bitmap bmp, Context context) throws FileNotFoundException {
        Uri internalStorageFile;
        n.f(bmp, "bmp");
        n.f(context, "context");
        try {
            StringBuilder stringBuilder = new StringBuilder();
            String str3 = "share_image_";
            long time = System.currentTimeMillis();
            String str4 = ".png";
            r2 = str3 + time + str4;
            File file = new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), r2);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.close();
            internalStorageFile = app.dogo.com.dogo_android.util.extensionfunction.i1.getInternalStorageFile(context, file);
        } catch (java.io.IOException ioException) {
            ioException.printStackTrace();
            ioException = null;
        }
        return internalStorageFile;
    }

    /* renamed from: m, reason: from kotlin metadata */
    public final boolean transferFile(String sourceFolder, String targetFolder, String filename) {
        n.f(sourceFolder, "sourceFolder");
        n.f(targetFolder, "targetFolder");
        n.f(filename, "filename");
        return transferFile(sourceFolder, targetFolder, filename, filename);
    }

    /* renamed from: n, reason: from kotlin metadata */
    public final boolean transferFile(String sourceFolder, String targetFolder, String sourceFileName, String targetFileName) {
        n.f(sourceFolder, "sourceFolder");
        n.f(targetFolder, "targetFolder");
        n.f(sourceFileName, "sourceFileName");
        n.f(targetFileName, "targetFileName");
        File file = new File(this.context, targetFolder);
        boolean z = false;
        if (!file.exists() && file.mkdir() == null) {
            a.d(new Exception("failed to create a new directory for file transfer"));
            return false;
        }
        File file2 = new File(new File(this.context, sourceFolder), sourceFileName);
        if (file2.renameTo(new File(file, targetFileName)) == null) {
            a.d(new Exception("failed to rename a file after transferring"));
            return false;
        }
        file2.delete();
        return true;
    }

}
