package app.dogo.com.dogo_android.util.h0;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import androidx.core.content.FileProvider;
import androidx.fragment.app.e;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.io.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0086\u0010\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a*\u0010\u000c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0002¨\u0006\u0015", d2 = {"getActivity", "Landroidx/fragment/app/FragmentActivity;", "Landroid/content/Context;", "getContentUriFromFile", "Landroid/net/Uri;", "file", "Ljava/io/File;", "getInternalStorageFile", "id", "", "fileName", "getInternalStorageFileUri", "getLoginIntent", "Landroid/content/Intent;", "viewSource", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "dogInvite", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "hasChromeBookSystemComponent", "", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class i1 {
    public static final e a(Context context) {
        boolean z;
        int i;
        Object obj2;
        while (context instanceof e) {
            if (context instanceof ContextWrapper) {
            } else {
            }
            obj2 = i;
            if (obj2.getBaseContext() != null) {
                break;
            }
        }
        i = context;
        return i;
    }

    public static final Uri b(Context context, File file2) {
        String absolutePath;
        Throwable th;
        Object[] exists;
        FileOutputStream outputStream;
        n.f(context, "<this>");
        n.f(file2, "file");
        final String str5 = "IMAGE_CROP_CACHE";
        a.f("Try get URI for scope storage - content://", new Object[0]);
        Uri uri = FileProvider.e(context, "app.dogo.com.dogo_android.provider", file2);
        n.e(uri, "getUriForFile(this, authority, file)");
        return uri;
    }

    public static final File c(Context context, String string2, String string3) {
        boolean obj1;
        n.f(context, "<this>");
        n.f(string2, "id");
        n.f(string3, "fileName");
        File file = new File(context.getFilesDir(), string2);
        if (file.exists() == null && file.mkdir() == null) {
            if (file.mkdir() == null) {
                obj1 = new Exception("failed to create a new directory ");
                a.d(obj1);
                return null;
            }
        }
        obj1 = new File(file, string3);
        return obj1;
    }

    public static final Uri d(Context context, String string2, String string3) {
        int obj1;
        Object obj2;
        n.f(context, "<this>");
        n.f(string2, "id");
        n.f(string3, "fileName");
        obj1 = i1.c(context, string2, string3);
        if (obj1 != null && obj1.exists()) {
            if (obj1.exists()) {
                obj1 = Uri.fromFile(obj1);
            } else {
                obj1 = 0;
            }
        } else {
        }
        return obj1;
    }

    public static final Intent e(Context context, String string2, ProfilePreview profilePreview3, DogOwnerInvitation dogOwnerInvitation4) {
        n.f(context, "<this>");
        n.f(string2, "viewSource");
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("view_source", string2);
        intent.putExtra("profile_preview", profilePreview3);
        intent.putExtra("dog_parent_invite", dogOwnerInvitation4);
        return intent;
    }

    public static Intent f(Context context, String string2, ProfilePreview profilePreview3, DogOwnerInvitation dogOwnerInvitation4, int i5, Object object6) {
        int obj3;
        int obj4;
        final int i = 0;
        if (i5 & 2 != 0) {
            obj3 = i;
        }
        if (i5 &= 4 != 0) {
            obj4 = i;
        }
        return i1.e(context, string2, obj3, obj4);
    }

    public static final boolean g(Context context) {
        n.f(context, "<this>");
        return context.getPackageManager().hasSystemFeature("org.chromium.arc.device_management");
    }
}
