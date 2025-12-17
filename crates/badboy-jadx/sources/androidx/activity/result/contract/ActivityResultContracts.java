package androidx.activity.result.contract;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import androidx.activity.result.PickVisualMediaRequest;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0013\u0018\u00002\u00020\u0001:\u0011\u0003\u0004\u0005\u0006\u0007\u0008\t\n\u000b\u000c\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0014", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts;", "", "()V", "CaptureVideo", "CreateDocument", "GetContent", "GetMultipleContents", "OpenDocument", "OpenDocumentTree", "OpenMultipleDocuments", "PickContact", "PickMultipleVisualMedia", "PickVisualMedia", "RequestMultiplePermissions", "RequestPermission", "StartActivityForResult", "StartIntentSenderForResult", "TakePicture", "TakePicturePreview", "TakeVideo", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActivityResultContracts {

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0017J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002J\u001d\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010¨\u0006\u0011", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CaptureVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class CaptureVideo extends androidx.activity.result.contract.ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            Intent extra = intent.putExtra("output", (Parcelable)input);
            Intrinsics.checkNotNullExpressionValue(extra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return extra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (Uri)input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (Uri)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Boolean parseResult(int resultCode, Intent intent) {
            int i;
            i = resultCode == -1 ? 1 : 0;
            return Boolean.valueOf(i);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0007\u0008\u0017¢\u0006\u0002\u0010\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0017J \u0010\u000c\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0008R\u000e\u0010\u0005\u001a\u00020\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$CreateDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", "mimeType", "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class CreateDocument extends androidx.activity.result.contract.ActivityResultContract<String, Uri> {

        private final String mimeType;
        @Deprecated(message = "Using a wildcard mime type with CreateDocument is not recommended as it breaks the automatic handling of file extensions. Instead, specify the mime type by using the constructor that takes an concrete mime type (e.g.., CreateDocument(\"image/png\")).", replaceWith = @ReplaceWith(...))
        public CreateDocument() {
            super("*/*");
        }

        public CreateDocument(String mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            super();
            this.mimeType = mimeType;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (String)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
            Intent extra = intent.setType(this.mimeType).putExtra("android.intent.extra.TITLE", input);
            Intrinsics.checkNotNullExpressionValue(extra, "Intent(Intent.ACTION_CRE…ntent.EXTRA_TITLE, input)");
            return extra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (String)input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int resultCode, Intent intent) {
            int it;
            int i2;
            int i;
            int i3 = intent;
            int i4 = 0;
            i = resultCode == -1 ? 1 : 0;
            i2 = i != 0 ? intent : it;
            if (i2 != 0) {
                it = i2.getData();
            }
            return it;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0016\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\u000c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetContent;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class GetContent extends androidx.activity.result.contract.ActivityResultContract<String, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (String)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            Intent type = intent.addCategory("android.intent.category.OPENABLE").setType(input);
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_GET…          .setType(input)");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (String)input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int resultCode, Intent intent) {
            int it;
            int i;
            int i2;
            int i3 = intent;
            int i4 = 0;
            i2 = resultCode == -1 ? 1 : 0;
            i = i2 != 0 ? intent : it;
            if (i != 0) {
                it = i.getData();
            }
            return it;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0016\u0018\u0000 \u00122\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\u0008\u00050\u00030\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0017J$\u0010\u000c\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002J\u001e\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0008¨\u0006\u0013", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$GetMultipleContents;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class GetMultipleContents extends androidx.activity.result.contract.ActivityResultContract<String, List<Uri>> {

        public static final androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion Companion;
        static {
            ActivityResultContracts.GetMultipleContents.Companion companion = new ActivityResultContracts.GetMultipleContents.Companion(0);
            ActivityResultContracts.GetMultipleContents.Companion = companion;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (String)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            Intent extra = intent.addCategory("android.intent.category.OPENABLE").setType(input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            Intrinsics.checkNotNullExpressionValue(extra, "Intent(Intent.ACTION_GET…TRA_ALLOW_MULTIPLE, true)");
            return extra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (String)input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }

        public final List<Uri> parseResult(int resultCode, Intent intent) {
            int clipDataUris$activity_release;
            androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion companion;
            int i;
            int i2 = intent;
            companion = 0;
            i = resultCode == -1 ? 1 : 0;
            clipDataUris$activity_release = i != 0 ? intent : 0;
            if (clipDataUris$activity_release != 0) {
                if (ActivityResultContracts.GetMultipleContents.Companion.getClipDataUris$activity_release(clipDataUris$activity_release) == null) {
                    clipDataUris$activity_release = CollectionsKt.emptyList();
                }
            } else {
            }
            return clipDataUris$activity_release;
        }
    }

    @Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0016\u0018\u00002\u0016\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\u000bJ+\u0010\u000c\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\r2\u0006\u0010\u0008\u001a\u00020\t2\u000c\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0007¨\u0006\u0013", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocument;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class OpenDocument extends androidx.activity.result.contract.ActivityResultContract<String[], Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (String[])input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String[] input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            Intent type = intent.putExtra("android.intent.extra.MIME_TYPES", input).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (String[])input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, String[] input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int resultCode, Intent intent) {
            int it;
            int i2;
            int i;
            int i3 = intent;
            int i4 = 0;
            i = resultCode == -1 ? 1 : 0;
            i2 = i != 0 ? intent : it;
            if (i2 != 0) {
                it = i2.getData();
            }
            return it;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0017\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0002H\u0017J\"\u0010\t\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0005¨\u0006\u000f", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenDocumentTree;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class OpenDocumentTree extends androidx.activity.result.contract.ActivityResultContract<Uri, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Uri input) {
            String str;
            android.os.Parcelable parcelable;
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
            if (input != null) {
                intent.putExtra("android.provider.extra.INITIAL_URI", (Parcelable)input);
            }
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (Uri)input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (Uri)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int resultCode, Intent intent) {
            int it;
            int i;
            int i2;
            int i3 = intent;
            int i4 = 0;
            i2 = resultCode == -1 ? 1 : 0;
            i = i2 != 0 ? intent : it;
            if (i != 0) {
                it = i.getData();
            }
            return it;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0016\u0018\u00002\u001f\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0005¢\u0006\u0002\u0008\u00060\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0007J#\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\u0017¢\u0006\u0002\u0010\rJ/\u0010\u000e\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0010J\u001e\u0010\u0011\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\t¨\u0006\u0015", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$OpenMultipleDocuments;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class OpenMultipleDocuments extends androidx.activity.result.contract.ActivityResultContract<String[], List<Uri>> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (String[])input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String[] input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
            Intent type = intent.putExtra("android.intent.extra.MIME_TYPES", input).putExtra("android.intent.extra.ALLOW_MULTIPLE", true).setType("*/*");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_OPE…          .setType(\"*/*\")");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (String[])input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, String[] input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }

        public final List<Uri> parseResult(int resultCode, Intent intent) {
            int clipDataUris$activity_release;
            androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion companion;
            int i;
            int i2 = intent;
            companion = 0;
            i = resultCode == -1 ? 1 : 0;
            clipDataUris$activity_release = i != 0 ? intent : 0;
            if (clipDataUris$activity_release != 0) {
                if (ActivityResultContracts.GetMultipleContents.Companion.getClipDataUris$activity_release(clipDataUris$activity_release) == null) {
                    clipDataUris$activity_release = CollectionsKt.emptyList();
                }
            } else {
            }
            return clipDataUris$activity_release;
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\n\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000e", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickContact;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PickContact extends androidx.activity.result.contract.ActivityResultContract<Void, Uri> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (Void)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Void input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("android.intent.action.PICK");
            Intent type = intent.setType("vnd.android.cursor.dir/contact");
            Intrinsics.checkNotNullExpressionValue(type, "Intent(Intent.ACTION_PIC…ct.Contacts.CONTENT_TYPE)");
            return type;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Uri parseResult(int resultCode, Intent intent) {
            int it;
            int i;
            int i2;
            int i3 = intent;
            int i4 = 0;
            i2 = resultCode == -1 ? 1 : 0;
            i = i2 != 0 ? intent : it;
            if (i != 0) {
                it = i.getData();
            }
            return it;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0016\u0018\u0000 \u00132\u0019\u0012\u0004\u0012\u00020\u0002\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\u0008\u00050\u00030\u0001:\u0001\u0013B\u000f\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0002H\u0017J)\u0010\u000e\u001a\u0015\u0012\u000f\u0012\r\u0012\t\u0012\u00070\u0004¢\u0006\u0002\u0008\u00050\u0003\u0018\u00010\u000f2\u0006\u0010\u000b\u001a\u00020\u000c2\u0006\u0010\r\u001a\u00020\u0002J\u001e\u0010\u0010\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u00072\u0008\u0010\u0012\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickMultipleVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "", "Landroid/net/Uri;", "Lkotlin/jvm/JvmSuppressWildcards;", "maxItems", "", "(I)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class PickMultipleVisualMedia extends androidx.activity.result.contract.ActivityResultContract<PickVisualMediaRequest, List<Uri>> {

        public static final androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia.Companion Companion;
        private final int maxItems;
        static {
            ActivityResultContracts.PickMultipleVisualMedia.Companion companion = new ActivityResultContracts.PickMultipleVisualMedia.Companion(0);
            ActivityResultContracts.PickMultipleVisualMedia.Companion = companion;
        }

        public PickMultipleVisualMedia() {
            super(0, 1, 0);
        }

        public PickMultipleVisualMedia(int maxItems) {
            int i;
            super();
            this.maxItems = maxItems;
            if (this.maxItems > 1) {
            } else {
                i = 0;
            }
            if (i == 0) {
            } else {
            }
            int i2 = 0;
            IllegalArgumentException $i$a$RequireActivityResultContracts$PickMultipleVisualMedia$1 = new IllegalArgumentException("Max items must be higher than 1".toString());
            throw $i$a$RequireActivityResultContracts$PickMultipleVisualMedia$1;
        }

        public PickMultipleVisualMedia(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
            int obj1;
            if (i2 &= 1 != 0) {
                obj1 = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
            }
            super(obj1);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, PickVisualMediaRequest input) {
            Intent fallbackPicker;
            boolean customAccentColorApplied;
            boolean orderedSelection;
            Intent intent2;
            Intent intent;
            int strArr;
            int pickImagesMaxLimit;
            int accentColor;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            orderedSelection = 1;
            fallbackPicker = new Intent("android.provider.action.PICK_IMAGES");
            intent2 = fallbackPicker;
            intent = 0;
            intent2.setType(ActivityResultContracts.PickVisualMedia.Companion.getVisualMimeType$activity_release(input.getMediaType()));
            strArr = Math.min(this.maxItems, input.getMaxItems());
            if (ActivityResultContracts.PickVisualMedia.Companion.isSystemPickerAvailable$activity_release() && strArr > orderedSelection && strArr <= MediaStore.getPickImagesMaxLimit()) {
                fallbackPicker = new Intent("android.provider.action.PICK_IMAGES");
                intent2 = fallbackPicker;
                intent = 0;
                intent2.setType(ActivityResultContracts.PickVisualMedia.Companion.getVisualMimeType$activity_release(input.getMediaType()));
                strArr = Math.min(this.maxItems, input.getMaxItems());
                if (strArr > orderedSelection) {
                    if (strArr <= MediaStore.getPickImagesMaxLimit()) {
                        customAccentColorApplied = orderedSelection;
                    }
                }
                if (customAccentColorApplied == 0) {
                } else {
                    intent2.putExtra("android.provider.extra.PICK_IMAGES_MAX", strArr);
                    intent2.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", input.getDefaultTab().getValue());
                    intent2.putExtra("android.provider.extra.PICK_IMAGES_IN_ORDER", input.isOrderedSelection());
                    if (input.isCustomAccentColorApplied()) {
                        intent2.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", input.getAccentColor());
                    }
                    return fallbackPicker;
                }
                int i = 0;
                IllegalArgumentException $i$a$RequireActivityResultContracts$PickMultipleVisualMedia$createIntent$1$1 = new IllegalArgumentException("Max items must be greater than 1 and lesser than or equal to MediaStore.getPickImagesMaxLimit()".toString());
                throw $i$a$RequireActivityResultContracts$PickMultipleVisualMedia$createIntent$1$1;
            }
            if (ActivityResultContracts.PickVisualMedia.Companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                ResolveInfo systemFallbackPicker$activity_release = ActivityResultContracts.PickVisualMedia.Companion.getSystemFallbackPicker$activity_release(context);
                if (systemFallbackPicker$activity_release == null) {
                } else {
                    android.content.pm.ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                    intent2 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                    intent = intent2;
                    strArr = 0;
                    intent.setClassName(applicationInfo.packageName, activityInfo.name);
                    intent.setType(ActivityResultContracts.PickVisualMedia.Companion.getVisualMimeType$activity_release(input.getMediaType()));
                    pickImagesMaxLimit = Math.min(this.maxItems, input.getMaxItems());
                    if (pickImagesMaxLimit > orderedSelection) {
                        customAccentColorApplied = orderedSelection;
                    }
                    if (customAccentColorApplied == 0) {
                    } else {
                        intent.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_MAX", pickImagesMaxLimit);
                        intent.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", input.getDefaultTab().getValue());
                        intent.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER", input.isOrderedSelection());
                        if (input.isCustomAccentColorApplied()) {
                            intent.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR", input.getAccentColor());
                        }
                        fallbackPicker = intent2;
                    }
                    int i2 = 0;
                    IllegalArgumentException $i$a$RequireActivityResultContracts$PickMultipleVisualMedia$createIntent$2$1 = new IllegalArgumentException("Max items must be greater than 1".toString());
                    throw $i$a$RequireActivityResultContracts$PickMultipleVisualMedia$createIntent$2$1;
                }
                IllegalStateException fallbackPicker2 = new IllegalStateException("Required value was null.".toString());
                throw fallbackPicker2;
            }
            fallbackPicker = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent2 = fallbackPicker;
            intent = 0;
            intent2.setType(ActivityResultContracts.PickVisualMedia.Companion.getVisualMimeType$activity_release(input.getMediaType()));
            intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", orderedSelection);
            if (intent2.getType() == null) {
                intent2.setType("*/*");
                strArr = new String[2];
                strArr[orderedSelection] = "video/*";
                intent2.putExtra("android.intent.extra.MIME_TYPES", strArr);
            }
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (PickVisualMediaRequest)input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<List<Uri>> getSynchronousResult(Context context, PickVisualMediaRequest input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (PickVisualMediaRequest)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }

        public final List<Uri> parseResult(int resultCode, Intent intent) {
            int clipDataUris$activity_release;
            androidx.activity.result.contract.ActivityResultContracts.GetMultipleContents.Companion companion;
            int i;
            int i2 = intent;
            companion = 0;
            i = resultCode == -1 ? 1 : 0;
            clipDataUris$activity_release = i != 0 ? intent : 0;
            if (clipDataUris$activity_release != 0) {
                if (ActivityResultContracts.GetMultipleContents.Companion.getClipDataUris$activity_release(clipDataUris$activity_release) == null) {
                    clipDataUris$activity_release = CollectionsKt.emptyList();
                }
            } else {
            }
            return clipDataUris$activity_release;
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\t\u0008\u0016\u0018\u0000 \u00102\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001:\u0007\u0010\u0011\u0012\u0013\u0014\u0015\u0016B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\u000c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0017", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/PickVisualMediaRequest;", "Landroid/net/Uri;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "DefaultTab", "ImageAndVideo", "ImageOnly", "SingleMimeType", "VideoOnly", "VisualMediaType", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class PickVisualMedia extends androidx.activity.result.contract.ActivityResultContract<PickVisualMediaRequest, Uri> {

        public static final String ACTION_SYSTEM_FALLBACK_PICK_IMAGES = "androidx.activity.result.contract.action.PICK_IMAGES";
        public static final androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.Companion Companion = null;
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_ACCENT_COLOR = "androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR";
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_IN_ORDER = "androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER";
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_LAUNCH_TAB = "androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB";
        public static final String EXTRA_SYSTEM_FALLBACK_PICK_IMAGES_MAX = "androidx.activity.result.contract.extra.PICK_IMAGES_MAX";
        public static final String GMS_ACTION_PICK_IMAGES = "com.google.android.gms.provider.action.PICK_IMAGES";
        public static final String GMS_EXTRA_PICK_IMAGES_MAX = "com.google.android.gms.provider.extra.PICK_IMAGES_MAX";
        static {
            ActivityResultContracts.PickVisualMedia.Companion companion = new ActivityResultContracts.PickVisualMedia.Companion(0);
            ActivityResultContracts.PickVisualMedia.Companion = companion;
        }

        @JvmStatic
        public static final ResolveInfo getSystemFallbackPicker$activity_release(Context context) {
            return ActivityResultContracts.PickVisualMedia.Companion.getSystemFallbackPicker$activity_release(context);
        }

        @Deprecated(message = "This method is deprecated in favor of isPhotoPickerAvailable(context) to support the picker provided by updatable system apps", replaceWith = @ReplaceWith(...))
        @JvmStatic
        public static final boolean isPhotoPickerAvailable() {
            return ActivityResultContracts.PickVisualMedia.Companion.isPhotoPickerAvailable();
        }

        @JvmStatic
        public static final boolean isPhotoPickerAvailable(Context context) {
            return ActivityResultContracts.PickVisualMedia.Companion.isPhotoPickerAvailable(context);
        }

        @JvmStatic
        public static final boolean isSystemFallbackPickerAvailable$activity_release(Context context) {
            return ActivityResultContracts.PickVisualMedia.Companion.isSystemFallbackPickerAvailable$activity_release(context);
        }

        @JvmStatic
        public static final boolean isSystemPickerAvailable$activity_release() {
            return ActivityResultContracts.PickVisualMedia.Companion.isSystemPickerAvailable$activity_release();
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, PickVisualMediaRequest input) {
            Intent fallbackPicker;
            Intent intent;
            int i;
            boolean customAccentColorApplied;
            String customAccentColorApplied2;
            String accentColor;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            if (ActivityResultContracts.PickVisualMedia.Companion.isSystemPickerAvailable$activity_release()) {
                fallbackPicker = new Intent("android.provider.action.PICK_IMAGES");
                intent = fallbackPicker;
                i = 0;
                intent.setType(ActivityResultContracts.PickVisualMedia.Companion.getVisualMimeType$activity_release(input.getMediaType()));
                intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", input.getDefaultTab().getValue());
                if (input.isCustomAccentColorApplied()) {
                    intent.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", input.getAccentColor());
                }
            } else {
                if (ActivityResultContracts.PickVisualMedia.Companion.isSystemFallbackPickerAvailable$activity_release(context)) {
                    ResolveInfo systemFallbackPicker$activity_release = ActivityResultContracts.PickVisualMedia.Companion.getSystemFallbackPicker$activity_release(context);
                    if (systemFallbackPicker$activity_release == null) {
                    } else {
                        android.content.pm.ActivityInfo activityInfo = systemFallbackPicker$activity_release.activityInfo;
                        intent = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
                        i = intent;
                        customAccentColorApplied = 0;
                        i.setClassName(applicationInfo.packageName, activityInfo.name);
                        i.setType(ActivityResultContracts.PickVisualMedia.Companion.getVisualMimeType$activity_release(input.getMediaType()));
                        i.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", input.getDefaultTab().getValue());
                        if (input.isCustomAccentColorApplied()) {
                            i.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR", input.getAccentColor());
                        }
                        fallbackPicker = intent;
                    }
                    IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
                    throw illegalStateException;
                }
                fallbackPicker = new Intent("android.intent.action.OPEN_DOCUMENT");
                intent = fallbackPicker;
                i = 0;
                intent.setType(ActivityResultContracts.PickVisualMedia.Companion.getVisualMimeType$activity_release(input.getMediaType()));
                if (intent.getType() == null) {
                    intent.setType("*/*");
                    customAccentColorApplied = new String[2];
                    intent.putExtra("android.intent.extra.MIME_TYPES", "image/*", "video/*");
                }
            }
            return fallbackPicker;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (PickVisualMediaRequest)input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<Uri> getSynchronousResult(Context context, PickVisualMediaRequest input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (PickVisualMediaRequest)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Uri parseResult(int resultCode, Intent intent) {
            int it;
            int i;
            int firstOrNull;
            int i2 = intent;
            int i4 = 0;
            firstOrNull = resultCode == -1 ? 1 : 0;
            i = firstOrNull != 0 ? intent : it;
            int i3 = 0;
            if (i != 0 && i.getData() == null) {
                i3 = 0;
                if (i.getData() == null) {
                    firstOrNull = CollectionsKt.firstOrNull(ActivityResultContracts.GetMultipleContents.Companion.getClipDataUris$activity_release(i));
                }
                it = firstOrNull;
            }
            return it;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u0000 \u00152%\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\u0003\u0012\t\u0012\u00070\u0005¢\u0006\u0002\u0008\u00060\u00040\u0001:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0007J#\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\rJ7\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0002\u0010\u0010J&\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0016¨\u0006\u0016", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "", "", "Lkotlin/jvm/JvmSuppressWildcards;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;[Ljava/lang/String;)Landroid/content/Intent;", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "(Landroid/content/Context;[Ljava/lang/String;)Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RequestMultiplePermissions extends androidx.activity.result.contract.ActivityResultContract<String[], Map<String, Boolean>> {

        public static final String ACTION_REQUEST_PERMISSIONS = "androidx.activity.result.contract.action.REQUEST_PERMISSIONS";
        public static final androidx.activity.result.contract.ActivityResultContracts.RequestMultiplePermissions.Companion Companion = null;
        public static final String EXTRA_PERMISSIONS = "androidx.activity.result.contract.extra.PERMISSIONS";
        public static final String EXTRA_PERMISSION_GRANT_RESULTS = "androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS";
        static {
            ActivityResultContracts.RequestMultiplePermissions.Companion companion = new ActivityResultContracts.RequestMultiplePermissions.Companion(0);
            ActivityResultContracts.RequestMultiplePermissions.Companion = companion;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (String[])input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String[] input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return ActivityResultContracts.RequestMultiplePermissions.Companion.createIntent$activity_release(input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (String[])input);
        }

        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult<Map<String, Boolean>> getSynchronousResult(Context context, String[] input) {
            int i3;
            int $this$all$iv;
            androidx.activity.result.contract.ActivityResultContract.SynchronousResult synchronousResult;
            int i;
            int i4;
            int length;
            int coerceAtLeast;
            Object linkedHashMap;
            Object obj;
            int i2;
            int length2;
            Object obj2;
            Object second;
            Object first;
            Boolean valueOf;
            final Object obj3 = context;
            final Object obj4 = input;
            Intrinsics.checkNotNullParameter(obj3, "context");
            Intrinsics.checkNotNullParameter(obj4, "input");
            i = 0;
            final int i5 = 1;
            i3 = obj4.length == 0 ? i5 : i;
            if (i3 != 0) {
                ActivityResultContract.SynchronousResult synchronousResult2 = new ActivityResultContract.SynchronousResult(MapsKt.emptyMap());
                return synchronousResult2;
            }
            Object obj5 = input;
            i4 = 0;
            coerceAtLeast = i;
            while (coerceAtLeast < obj5.length) {
                i2 = 0;
                if (ContextCompat.checkSelfPermission(obj3, obj5[coerceAtLeast]) == 0) {
                } else {
                }
                length2 = i;
                coerceAtLeast++;
                length2 = i5;
            }
            $this$all$iv = i5;
            if ($this$all$iv != 0) {
                i4 = input;
                length = 0;
                linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(i4.length), 16));
                obj = i4;
                i2 = 0;
                while (i < obj.length) {
                    int i7 = 0;
                    Pair it = TuplesKt.to(obj[i], Boolean.valueOf(i5));
                    (Map)linkedHashMap.put(it.getFirst(), it.getSecond());
                    i++;
                }
                synchronousResult = new ActivityResultContract.SynchronousResult(linkedHashMap);
            } else {
                synchronousResult = 0;
            }
            return synchronousResult;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }

        public Map<String, Boolean> parseResult(int resultCode, Intent intent) {
            int i;
            int i2;
            Boolean valueOf;
            int i4;
            int i3;
            final Object obj = intent;
            if (resultCode != -1) {
                return MapsKt.emptyMap();
            }
            if (obj == null) {
                return MapsKt.emptyMap();
            }
            String[] stringArrayExtra = obj.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = obj.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra != null) {
                if (stringArrayExtra == null) {
                } else {
                    int[] iArr = intArrayExtra;
                    int i7 = 0;
                    ArrayList arrayList = new ArrayList(iArr.length);
                    int[] iArr2 = iArr;
                    final int i8 = 0;
                    final int i9 = 0;
                    i = i9;
                    while (i < iArr2.length) {
                        i4 = 0;
                        if (iArr2[i] == 0) {
                        } else {
                        }
                        i3 = i9;
                        (Collection)arrayList.add(Boolean.valueOf(i3));
                        i++;
                        i3 = 1;
                    }
                }
                return MapsKt.toMap((Iterable)CollectionsKt.zip((Iterable)ArraysKt.filterNotNull(stringArrayExtra), (Iterable)(List)arrayList));
            }
            return MapsKt.emptyMap();
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0016J \u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001f\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0002\u0010\u0010¨\u0006\u0011", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$RequestPermission;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class RequestPermission extends androidx.activity.result.contract.ActivityResultContract<String, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (String)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, String input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            String[] strArr = new String[1];
            return ActivityResultContracts.RequestMultiplePermissions.Companion.createIntent$activity_release(strArr);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (String)input);
        }

        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, String input) {
            int i;
            int valueOf;
            int synchronousResult;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            valueOf = 1;
            i = ContextCompat.checkSelfPermission(context, input) == 0 ? valueOf : 0;
            if (i != 0) {
                synchronousResult = new ActivityResultContract.SynchronousResult(Boolean.valueOf(valueOf));
            } else {
                synchronousResult = 0;
            }
            return synchronousResult;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Boolean parseResult(int resultCode, Intent intent) {
            int i;
            int i7;
            int $this$any$iv;
            int i2;
            int length;
            int i3;
            int i6;
            int i5;
            int result;
            int i4;
            i = 0;
            if (intent != null) {
                if (resultCode != -1) {
                } else {
                    int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                    if (intArrayExtra != null) {
                        int[] iArr = intArrayExtra;
                        i2 = 0;
                        i3 = i;
                        i6 = 1;
                        while (i3 < iArr.length) {
                            i4 = 0;
                            if (iArr[i3] == 0) {
                            } else {
                            }
                            result = i;
                            i3++;
                            i6 = 1;
                            result = i6;
                        }
                        $this$any$iv = i;
                        if ($this$any$iv == i6) {
                            i = i6;
                        }
                    }
                }
                return Boolean.valueOf(i);
            }
            return Boolean.valueOf(i);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u000e", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartActivityForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/content/Intent;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StartActivityForResult extends androidx.activity.result.contract.ActivityResultContract<Intent, ActivityResult> {

        public static final androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult.Companion Companion = null;
        public static final String EXTRA_ACTIVITY_OPTIONS_BUNDLE = "androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE";
        static {
            ActivityResultContracts.StartActivityForResult.Companion companion = new ActivityResultContracts.StartActivityForResult.Companion(0);
            ActivityResultContracts.StartActivityForResult.Companion = companion;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Intent input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return input;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (Intent)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int resultCode, Intent intent) {
            ActivityResult activityResult = new ActivityResult(resultCode, intent);
            return activityResult;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0018\u0000 \u000e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u000f", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$StartIntentSenderForResult;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroidx/activity/result/IntentSenderRequest;", "Landroidx/activity/result/ActivityResult;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "parseResult", "resultCode", "", "intent", "Companion", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class StartIntentSenderForResult extends androidx.activity.result.contract.ActivityResultContract<IntentSenderRequest, ActivityResult> {

        public static final String ACTION_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.action.INTENT_SENDER_REQUEST";
        public static final androidx.activity.result.contract.ActivityResultContracts.StartIntentSenderForResult.Companion Companion = null;
        public static final String EXTRA_INTENT_SENDER_REQUEST = "androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST";
        public static final String EXTRA_SEND_INTENT_EXCEPTION = "androidx.activity.result.contract.extra.SEND_INTENT_EXCEPTION";
        static {
            ActivityResultContracts.StartIntentSenderForResult.Companion companion = new ActivityResultContracts.StartIntentSenderForResult.Companion(0);
            ActivityResultContracts.StartIntentSenderForResult.Companion = companion;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, IntentSenderRequest input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
            Intent extra = intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", (Parcelable)input);
            Intrinsics.checkNotNullExpressionValue(extra, "Intent(ACTION_INTENT_SEN…NT_SENDER_REQUEST, input)");
            return extra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (IntentSenderRequest)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public ActivityResult parseResult(int resultCode, Intent intent) {
            ActivityResult activityResult = new ActivityResult(resultCode, intent);
            return activityResult;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0017J\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002J\u001d\u0010\u000c\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0010¨\u0006\u0011", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicture;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Boolean;", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class TakePicture extends androidx.activity.result.contract.ActivityResultContract<Uri, Boolean> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            Intent extra = intent.putExtra("output", (Parcelable)input);
            Intrinsics.checkNotNullExpressionValue(extra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return extra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (Uri)input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<Boolean> getSynchronousResult(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (Uri)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Boolean parseResult(int resultCode, Intent intent) {
            int i;
            i = resultCode == -1 ? 1 : 0;
            return Boolean.valueOf(i);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0016\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0017J\"\u0010\n\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\t\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u000c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakePicturePreview;", "Landroidx/activity/result/contract/ActivityResultContract;", "Ljava/lang/Void;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class TakePicturePreview extends androidx.activity.result.contract.ActivityResultContract<Void, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (Void)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Void input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            return intent;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (Void)input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Void input) {
            Intrinsics.checkNotNullParameter(context, "context");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Bitmap parseResult(int resultCode, Intent intent) {
            int it;
            int i;
            int i2;
            int i3 = intent;
            int i4 = 0;
            i2 = resultCode == -1 ? 1 : 0;
            i = i2 != 0 ? intent : it;
            if (i != 0) {
                it = i.getParcelableExtra("data");
            }
            return it;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }

    @Deprecated(message = "The thumbnail bitmap is rarely returned and is not a good signal to determine\n      whether the video was actually successfully captured. Use {@link CaptureVideo} instead.")
    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0017\u0018\u00002\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002H\u0017J \u0010\n\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\u0002J\u001a\u0010\u000c\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0006¨\u0006\u0010", d2 = {"Landroidx/activity/result/contract/ActivityResultContracts$TakeVideo;", "Landroidx/activity/result/contract/ActivityResultContract;", "Landroid/net/Uri;", "Landroid/graphics/Bitmap;", "()V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static class TakeVideo extends androidx.activity.result.contract.ActivityResultContract<Uri, Bitmap> {
        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            Intent extra = intent.putExtra("output", (Parcelable)input);
            Intrinsics.checkNotNullExpressionValue(extra, "Intent(MediaStore.ACTION…tore.EXTRA_OUTPUT, input)");
            return extra;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Object input) {
            return createIntent(context, (Uri)input);
        }

        public final androidx.activity.result.contract.ActivityResultContract.SynchronousResult<Bitmap> getSynchronousResult(Context context, Uri input) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(input, "input");
            return 0;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public androidx.activity.result.contract.ActivityResultContract.SynchronousResult getSynchronousResult(Context context, Object input) {
            return getSynchronousResult(context, (Uri)input);
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public final Bitmap parseResult(int resultCode, Intent intent) {
            int it;
            int i;
            int i2;
            int i3 = intent;
            int i4 = 0;
            i2 = resultCode == -1 ? 1 : 0;
            i = i2 != 0 ? intent : it;
            if (i != 0) {
                it = i.getParcelableExtra("data");
            }
            return it;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Object parseResult(int resultCode, Intent intent) {
            return parseResult(resultCode, intent);
        }
    }
}
