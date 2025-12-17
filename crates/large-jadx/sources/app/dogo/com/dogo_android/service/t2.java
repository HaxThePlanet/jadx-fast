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
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0008\u0007\n\u0002\u0010\t\n\u0002\u0008\u000c\u0018\u0000 +2\u00020\u0001:\u0002*+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u0008\u0012\u0004\u0012\u00020\u000b0\n2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\r2\u0008\u0010\u001b\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00082\u0006\u0010\u001f\u001a\u00020 J\"\u0010!\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0011\u001a\u00020\u0010H\u0007J\u0018\u0010#\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u0003J\u001e\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0010J&\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,", d2 = {"Lapp/dogo/com/dogo_android/service/StorageService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentResolver", "Landroid/content/ContentResolver;", "fileDr", "Ljava/io/File;", "asyncSaveBitmapToExternalFile", "Lcom/google/android/gms/tasks/Task;", "Landroid/net/Uri;", "bmp", "Landroid/graphics/Bitmap;", "createUriForFile", "id", "", "fileName", "fileExist", "", "getBitmap", "imageView", "Landroid/widget/ImageView;", "getBitmapSize", "", "path", "getContactBitmapFromURI", "uri", "getFile", "getFileUri", "getRecordingFile", "timestamp", "", "saveBitmapIntoInternalStorage", "content", "saveBitmapsToExternalFile", "transferFile", "sourceFolder", "targetFolder", "filename", "sourceFileName", "targetFileName", "AsyncBitmapSaver", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class t2 {

    public static final app.dogo.com.dogo_android.service.t2.b Companion;
    private final Context a;
    private final File b;
    private final ContentResolver c;

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\u0008\u0002\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ'\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0016\u0010\u0011\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010\u00020\u0012\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0004H\u0014R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000b8F¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\rR\u0014\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017", d2 = {"Lapp/dogo/com/dogo_android/service/StorageService$AsyncBitmapSaver;", "Landroid/os/AsyncTask;", "Landroid/graphics/Bitmap;", "Ljava/lang/Void;", "Landroid/net/Uri;", "service", "Lapp/dogo/com/dogo_android/service/StorageService;", "appContext", "Landroid/content/Context;", "(Lapp/dogo/com/dogo_android/service/StorageService;Landroid/content/Context;)V", "task", "Lcom/google/android/gms/tasks/Task;", "getTask", "()Lcom/google/android/gms/tasks/Task;", "taskSource", "Lcom/google/android/gms/tasks/TaskCompletionSource;", "doInBackground", "bitmaps", "", "([Landroid/graphics/Bitmap;)Landroid/net/Uri;", "onPostExecute", "", "uri", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private static final class a extends AsyncTask<Bitmap, Void, Uri> {

        private final Context a;
        private final k<Uri> b;
        private final app.dogo.com.dogo_android.service.t2 c;
        public a(app.dogo.com.dogo_android.service.t2 t2, Context context2) {
            n.f(t2, "service");
            n.f(context2, "appContext");
            super();
            this.a = context2;
            k obj3 = new k();
            this.b = obj3;
            this.c = t2;
        }

        @Override // android.os.AsyncTask
        protected Uri a(Bitmap... bitmapArr) {
            app.dogo.com.dogo_android.service.t2 t2Var;
            Uri obj3;
            n.f(bitmapArr, "bitmaps");
            obj3 = bitmapArr[0];
            n.d(obj3);
            obj3 = this.c.l(obj3, this.a);
            return obj3;
        }

        public final j<Uri> b() {
            j jVar = this.b.a();
            n.e(jVar, "taskSource.task");
            return jVar;
        }

        @Override // android.os.AsyncTask
        protected void c(Uri uri) {
            super.onPostExecute(uri);
            this.b.e(uri);
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object[] objectArr) {
            return a((Bitmap[])objectArr);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object object) {
            c((Uri)object);
        }
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0008", d2 = {"Lapp/dogo/com/dogo_android/service/StorageService$Companion;", "", "()V", "CHALLENGE_FAILED", "", "CHALLENGE_PENDING", "CHALLENGE_SUCCESSFUL", "DOG_AVATAR_FILE_NAME", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b {
        public b(g g) {
            super();
        }
    }
    static {
        t2.b bVar = new t2.b(0);
        t2.Companion = bVar;
    }

    public t2(Context context) {
        n.f(context, "context");
        super();
        this.a = context;
        File filesDir = context.getFilesDir();
        n.e(filesDir, "context.filesDir");
        this.b = filesDir;
        final ContentResolver obj3 = context.getContentResolver();
        n.e(obj3, "context.contentResolver");
        this.c = obj3;
    }

    private final File g(String string, String string2) {
        boolean obj3;
        File file = new File(this.b, string);
        if (file.exists() == null && file.mkdir() == null) {
            if (file.mkdir() == null) {
                obj3 = new Exception("failed to create a new directory ");
                a.d(obj3);
                return null;
            }
        }
        obj3 = new File(file, string2);
        return obj3;
    }

    public static boolean k(app.dogo.com.dogo_android.service.t2 t2, String string2, Uri uri3, String string4, int i5, Object object6) {
        String obj3;
        if (i5 &= 4 != 0) {
            obj3 = "avatar.jpg";
        }
        return t2.j(string2, uri3, obj3);
    }

    public final j<Uri> a(Bitmap bitmap) {
        t2.a aVar = new t2.a(this, this.a);
        Bitmap[] arr = new Bitmap[1];
        aVar.execute(bitmap);
        return aVar.b();
    }

    public final Uri b(String string, String string2) {
        Uri obj2;
        n.f(string, "id");
        n.f(string2, "fileName");
        obj2 = g(string, string2);
        if (obj2 != null) {
            obj2 = Uri.fromFile(obj2);
        } else {
            obj2 = 0;
        }
        return obj2;
    }

    public final boolean c(String string, String string2) {
        n.f(string, "id");
        n.f(string2, "fileName");
        File file = new File(this.b, string);
        File obj3 = new File(file, string2);
        return obj3.exists();
    }

    public final Bitmap d(ImageView imageView) {
        Bitmap obj4;
        n.f(imageView, "imageView");
        android.graphics.drawable.Drawable drawable = imageView.getDrawable();
        final String str2 = "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable";
        if (drawable instanceof BitmapDrawable) {
            obj4 = imageView.getDrawable();
            Objects.requireNonNull(obj4, str2);
            obj4 = (BitmapDrawable)obj4.getBitmap();
        } else {
            obj4 = 0;
        }
        if (drawable instanceof TransitionDrawable) {
            obj4 = (TransitionDrawable)drawable.getDrawable(1);
            Objects.requireNonNull(obj4, str2);
            obj4 = (BitmapDrawable)obj4.getBitmap();
        }
        return obj4;
    }

    public final int[] e(Uri uri) {
        int i;
        int width;
        Bitmap obj4;
        obj4 = f(uri);
        int[] iArr = new int[2];
        iArr = new int[]{0, 0};
        if (obj4 != null) {
        }
        return iArr;
    }

    public final Bitmap f(Uri uri) {
        final int i = 0;
        if (uri == null) {
            return i;
        }
        java.io.InputStream obj3 = this.c.openInputStream(uri);
        if (obj3 == null) {
            return i;
        }
        try {
            return BitmapFactory.decodeStream(obj3);
            a.d(uri);
            return obj0;
        }
    }

    public final Uri h(String string, String string2) {
        int obj2;
        Object obj3;
        n.f(string, "id");
        n.f(string2, "fileName");
        obj2 = g(string, string2);
        if (obj2 != null && obj2.exists()) {
            if (obj2.exists()) {
                obj2 = Uri.fromFile(obj2);
            } else {
                obj2 = 0;
            }
        } else {
        }
        return obj2;
    }

    public final File i(long l) {
        int file;
        Exception obj6;
        String obj7;
        File externalFilesDir = this.a.getExternalFilesDir(Environment.DIRECTORY_MOVIES);
        if (externalFilesDir == null) {
        } else {
            externalFilesDir.mkdirs();
        }
        f0 f0Var = f0.a;
        int i = 1;
        final Object[] arr = new Object[i];
        arr[0] = Long.valueOf(l);
        obj6 = String.format("dogo_%d.mp4", Arrays.copyOf(arr, i));
        n.e(obj6, "java.lang.String.format(format, *args)");
        file = new File(externalFilesDir, obj6);
        if (n.b(Environment.getExternalStorageState(file), "mounted") != null) {
        } else {
            obj6 = new Exception("External storage not mounted");
            a.d(obj6);
            file = 0;
        }
        return file;
    }

    public final boolean j(String string, Uri uri2, String string3) {
        boolean obj4;
        n.f(string, "id");
        n.f(uri2, "content");
        n.f(string3, "fileName");
        Bitmap obj5 = f(uri2);
        int i = 0;
        if (obj5 == null) {
            obj4 = new Exception("No bitmap created");
            a.d(obj4);
            return i;
        }
        File file = new File(this.b, string);
        if (file.exists() == null && file.mkdir() == null) {
            if (file.mkdir() == null) {
                obj4 = new Exception("Failed to create a new directory for bitmap");
                a.d(obj4);
                return i;
            }
        }
        obj4 = new File(file, string3);
        if (obj4.exists() && !obj4.delete()) {
            if (!obj4.delete()) {
                obj4 = new Exception("Could't delete a previous bitmap file");
                a.d(obj4);
                return i;
            }
            obj4 = new File(file, string3);
        }
        FileOutputStream obj6 = new FileOutputStream(obj4);
        obj5.compress(Bitmap.CompressFormat.JPEG, 90, obj6);
        obj6.flush();
        obj6.close();
        return 1;
    }

    public final Uri l(Bitmap bitmap, Context context2) {
        Uri obj6;
        n.f(bitmap, "bmp");
        n.f(context2, "context");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("share_image_");
        stringBuilder.append(System.currentTimeMillis());
        stringBuilder.append(".png");
        File file = new File(context2.getExternalFilesDir(Environment.DIRECTORY_PICTURES), stringBuilder.toString());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        fileOutputStream.close();
        obj6 = i1.b(context2, file);
        return obj6;
    }

    public final boolean m(String string, String string2, String string3) {
        n.f(string, "sourceFolder");
        n.f(string2, "targetFolder");
        n.f(string3, "filename");
        return n(string, string2, string3, string3);
    }

    public final boolean n(String string, String string2, String string3, String string4) {
        boolean obj4;
        n.f(string, "sourceFolder");
        n.f(string2, "targetFolder");
        n.f(string3, "sourceFileName");
        n.f(string4, "targetFileName");
        File file = new File(this.b, string2);
        int i = 0;
        if (file.exists() == null && file.mkdir() == null) {
            if (file.mkdir() == null) {
                Exception obj3 = new Exception("failed to create a new directory for file transfer");
                a.d(obj3);
                return i;
            }
        }
        obj4 = new File(file, string4);
        File obj6 = new File(this.b, string);
        obj3 = new File(obj6, string3);
        if (!obj3.renameTo(obj4)) {
            obj3 = new Exception("failed to rename a file after transferring");
            a.d(obj3);
            return i;
        }
        obj3.delete();
        return 1;
    }
}
