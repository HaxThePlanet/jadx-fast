package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia;
import androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia.Companion;
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.DefaultTab;
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab;
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageAndVideo;
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.VisualMediaType;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0003\u0010\u0004\u001a\u00020\u0005H\u0007\u001a.\u0010\u0000\u001a\u00020\u00012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0003\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u000b2\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0003\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00072\u0008\u0008\u0002\u0010\u0008\u001a\u00020\t¨\u0006\u000c", d2 = {"PickVisualMediaRequest", "Landroidx/activity/result/PickVisualMediaRequest;", "mediaType", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "maxItems", "", "isOrderedSelection", "", "defaultTab", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "accentColor", "", "activity_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PickVisualMediaRequestKt {
    public static final androidx.activity.result.PickVisualMediaRequest PickVisualMediaRequest(long accentColor, ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, int maxItems, boolean isOrderedSelection, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        Intrinsics.checkNotNullParameter(maxItems, "mediaType");
        Intrinsics.checkNotNullParameter(obj6, "defaultTab");
        PickVisualMediaRequest.Builder builder = new PickVisualMediaRequest.Builder();
        return builder.setMediaType(maxItems).setMaxItems(isOrderedSelection).setOrderedSelection(defaultTab).setDefaultTab(obj6).setAccentColor(accentColor).build();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by PickVisualMediaRequest that takes an optional maxItems")
    public static final androidx.activity.result.PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        PickVisualMediaRequest.Builder builder = new PickVisualMediaRequest.Builder();
        return builder.setMediaType(mediaType).build();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Superseded by PickVisualMediaRequest that take optional isOrderedSelection and defaultTab")
    public static final androidx.activity.result.PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, int maxItems) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        PickVisualMediaRequest.Builder builder = new PickVisualMediaRequest.Builder();
        return builder.setMediaType(mediaType).setMaxItems(maxItems).build();
    }

    public static final androidx.activity.result.PickVisualMediaRequest PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType, int maxItems, boolean isOrderedSelection, ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(defaultTab, "defaultTab");
        PickVisualMediaRequest.Builder builder = new PickVisualMediaRequest.Builder();
        return builder.setMediaType(mediaType).setMaxItems(maxItems).setOrderedSelection(isOrderedSelection).setDefaultTab(defaultTab).build();
    }

    public static androidx.activity.result.PickVisualMediaRequest PickVisualMediaRequest$default(long l, ActivityResultContracts.PickVisualMedia.VisualMediaType activityResultContracts$PickVisualMedia$VisualMediaType2, int i3, boolean z4, ActivityResultContracts.PickVisualMedia.DefaultTab activityResultContracts$PickVisualMedia$DefaultTab5, int i6, Object object7) {
        ActivityResultContracts.PickVisualMedia.ImageAndVideo activity2;
        int i;
        int i2;
        ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab activity;
        ActivityResultContracts.PickVisualMedia.ImageAndVideo obj8;
        int obj9;
        int obj10;
        ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab obj11;
        if (object7 & 2 != 0) {
            activity2 = obj8;
        } else {
            activity2 = i3;
        }
        if (object7 & 4 != 0) {
            i = obj9;
        } else {
            i = z4;
        }
        i2 = object7 & 8 != 0 ? obj10 : defaultTab5;
        if (object7 & 16 != 0) {
            activity = obj11;
        } else {
            activity = i6;
        }
        return PickVisualMediaRequestKt.PickVisualMediaRequest(l, obj1, activity2, i, i2);
    }

    public static androidx.activity.result.PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType activityResultContracts$PickVisualMedia$VisualMediaType, int i2, int i3, Object object4) {
        ActivityResultContracts.PickVisualMedia.ImageAndVideo obj0;
        int obj1;
        if (i3 & 1 != 0) {
            obj0 = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        if (i3 &= 2 != 0) {
            obj1 = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        }
        return PickVisualMediaRequestKt.PickVisualMediaRequest(obj0, obj1);
    }

    public static androidx.activity.result.PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType activityResultContracts$PickVisualMedia$VisualMediaType, int i2, Object object3) {
        ActivityResultContracts.PickVisualMedia.ImageAndVideo obj0;
        if (i2 &= 1 != 0) {
            obj0 = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        return PickVisualMediaRequestKt.PickVisualMediaRequest(obj0);
    }

    public static androidx.activity.result.PickVisualMediaRequest PickVisualMediaRequest$default(ActivityResultContracts.PickVisualMedia.VisualMediaType activityResultContracts$PickVisualMedia$VisualMediaType, int i2, boolean z3, ActivityResultContracts.PickVisualMedia.DefaultTab activityResultContracts$PickVisualMedia$DefaultTab4, int i5, Object object6) {
        ActivityResultContracts.PickVisualMedia.ImageAndVideo obj0;
        int obj1;
        int obj2;
        ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab obj3;
        if (i5 & 1 != 0) {
            obj0 = ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        }
        if (i5 & 2 != 0) {
            obj1 = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        }
        if (i5 & 4 != 0) {
            obj2 = 0;
        }
        if (i5 &= 8 != 0) {
            obj3 = ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }
        return PickVisualMediaRequestKt.PickVisualMediaRequest(obj0, obj1, obj2, obj3);
    }
}
