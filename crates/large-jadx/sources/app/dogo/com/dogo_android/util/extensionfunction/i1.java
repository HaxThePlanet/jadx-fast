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

/* compiled from: ContextExtentions.kt */
@Metadata(d1 = "\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0002H\u0086\u0010\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t\u001a*\u0010\u000c\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\t2\n\u0008\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\u0008\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0002¨\u0006\u0015", d2 = {"getActivity", "Landroidx/fragment/app/FragmentActivity;", "Landroid/content/Context;", "getContentUriFromFile", "Landroid/net/Uri;", "file", "Ljava/io/File;", "getInternalStorageFile", "id", "", "fileName", "getInternalStorageFileUri", "getLoginIntent", "Landroid/content/Intent;", "viewSource", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "dogInvite", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "hasChromeBookSystemComponent", "", "app_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class i1 {
    /* renamed from: a, reason: from kotlin metadata */
    public static final e getContentUriFromFile(Context file) {
        int i = 0;
        z = file instanceof e;
        i = 0;
        while (file instanceof e) {
            z = file instanceof ContextWrapper;
            file = file instanceof ContextWrapper ? (ContextWrapper)file : 0;
            if (i == 0) {
                break;
            }
        }
        Object file2 = (file instanceof ContextWrapper ? (ContextWrapper)file : 0);
        return i;
    }

    /* renamed from: b, reason: from kotlin metadata */
    public static final Uri getInternalStorageFile(Context id, File fileName) {
        String absolutePath;
        Throwable th;
        Object[] exists;
        FileOutputStream fileOutputStream;
        n.f(id, "<this>");
        n.f(fileName, "file");
        try {
            a.f("Try get URI for scope storage - content://", new Object[0]);
            Uri uri = FileProvider.e(id, "app.dogo.com.dogo_android.provider", fileName);
            n.e(uri, "getUriForFile(this, authority, file)");
        } catch (Exception e) {
            a.d(e);
            String e2 = Build.VERSION.SDK_INT;
            absolutePath = 29;
        }
        return uri;
    }

    /* renamed from: c, reason: from kotlin metadata */
    public static final File getLoginIntent(Context viewSource, String profilePreview, String dogInvite) throws java.io.IOException {
        n.f(viewSource, "<this>");
        n.f(profilePreview, "id");
        n.f(dogInvite, "fileName");
        File file = new File(viewSource.getFilesDir(), profilePreview);
        if (!file.exists() && file.mkdir() == null) {
            a.d(new Exception("failed to create a new directory "));
            return null;
        }
        return new File(file, dogInvite);
    }

    public static final Uri d(Context context, String str, String str2) {
        int i = 0;
        boolean exists;
        n.f(context, "<this>");
        n.f(str, "id");
        n.f(str2, "fileName");
        File loginIntent = app.dogo.com.dogo_android.util.extensionfunction.i1.getLoginIntent(context, str, str2);
        if (loginIntent == null || !loginIntent.exists()) {
            i = 0;
        } else {
            Uri file = Uri.fromFile(loginIntent);
        }
        return i;
    }

    public static final Intent e(Context context, String str, ProfilePreview profilePreview, DogOwnerInvitation dogOwnerInvitation) {
        n.f(context, "<this>");
        n.f(str, "viewSource");
        Intent intent = new Intent(context, LoginActivity.class);
        intent.putExtra("view_source", str);
        intent.putExtra("profile_preview", profilePreview);
        intent.putExtra("dog_parent_invite", dogOwnerInvitation);
        return intent;
    }

    public static /* synthetic */ Intent f(Context context, String str, ProfilePreview profilePreview, DogOwnerInvitation dogOwnerInvitation, int i, Object object) {
        i = 0;
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return app.dogo.com.dogo_android.util.extensionfunction.i1.e(context, str, profilePreview, dogOwnerInvitation);
    }

    public static final boolean g(Context context) {
        n.f(context, "<this>");
        return context.getPackageManager().hasSystemFeature("org.chromium.arc.device_management");
    }
}
