package androidx.activity.result;

import androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia;
import androidx.activity.result.contract.ActivityResultContracts.PickMultipleVisualMedia.Companion;
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.DefaultTab;
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab;
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.ImageAndVideo;
import androidx.activity.result.contract.ActivityResultContracts.PickVisualMedia.VisualMediaType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001:\u0001#B\u0007\u0008\u0000¢\u0006\u0002\u0010\u0002R$\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007\"\u0004\u0008\u0008\u0010\tR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u0010@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0015\u0010\u0012\"\u0004\u0008\u0016\u0010\u0014R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0017@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0019\u0010\u001a\"\u0004\u0008\u001b\u0010\u001cR$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0003\u001a\u00020\u001d@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001f\u0010 \"\u0004\u0008!\u0010\"¨\u0006$", d2 = {"Landroidx/activity/result/PickVisualMediaRequest;", "", "()V", "<set-?>", "", "accentColor", "getAccentColor", "()J", "setAccentColor$activity_release", "(J)V", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "defaultTab", "getDefaultTab", "()Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "setDefaultTab$activity_release", "(Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;)V", "", "isCustomAccentColorApplied", "()Z", "setCustomAccentColorApplied$activity_release", "(Z)V", "isOrderedSelection", "setOrderedSelection$activity_release", "", "maxItems", "getMaxItems", "()I", "setMaxItems$activity_release", "(I)V", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "mediaType", "getMediaType", "()Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "setMediaType$activity_release", "(Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;)V", "Builder", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PickVisualMediaRequest {

    private long accentColor;
    private ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab;
    private boolean isCustomAccentColorApplied;
    private boolean isOrderedSelection;
    private int maxItems;
    private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType;

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u00002\u0008\u0008\u0001\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000c\u001a\u00020\rJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0008R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Landroidx/activity/result/PickVisualMediaRequest$Builder;", "", "()V", "accentColor", "", "defaultTab", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$DefaultTab;", "isCustomAccentColorApplied", "", "isOrderedSelection", "maxItems", "", "mediaType", "Landroidx/activity/result/contract/ActivityResultContracts$PickVisualMedia$VisualMediaType;", "build", "Landroidx/activity/result/PickVisualMediaRequest;", "setAccentColor", "setDefaultTab", "setMaxItems", "setMediaType", "setOrderedSelection", "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Builder {

        private long accentColor;
        private ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab;
        private boolean isCustomAccentColorApplied;
        private boolean isOrderedSelection;
        private int maxItems;
        private ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType;
        public Builder() {
            super();
            this.mediaType = (ActivityResultContracts.PickVisualMedia.VisualMediaType)ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
            this.maxItems = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
            this.defaultTab = (ActivityResultContracts.PickVisualMedia.DefaultTab)ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
        }

        public final androidx.activity.result.PickVisualMediaRequest build() {
            PickVisualMediaRequest pickVisualMediaRequest = new PickVisualMediaRequest();
            final androidx.activity.result.PickVisualMediaRequest request = pickVisualMediaRequest;
            final int i = 0;
            request.setMediaType$activity_release(this.mediaType);
            request.setMaxItems$activity_release(this.maxItems);
            request.setOrderedSelection$activity_release(this.isOrderedSelection);
            request.setDefaultTab$activity_release(this.defaultTab);
            request.setCustomAccentColorApplied$activity_release(this.isCustomAccentColorApplied);
            request.setAccentColor$activity_release(this.accentColor);
            return pickVisualMediaRequest;
        }

        public final androidx.activity.result.PickVisualMediaRequest.Builder setAccentColor(long accentColor) {
            this.accentColor = accentColor;
            this.isCustomAccentColorApplied = true;
            return this;
        }

        public final androidx.activity.result.PickVisualMediaRequest.Builder setDefaultTab(ActivityResultContracts.PickVisualMedia.DefaultTab defaultTab) {
            Intrinsics.checkNotNullParameter(defaultTab, "defaultTab");
            this.defaultTab = defaultTab;
            return this;
        }

        public final androidx.activity.result.PickVisualMediaRequest.Builder setMaxItems(int maxItems) {
            this.maxItems = maxItems;
            return this;
        }

        public final androidx.activity.result.PickVisualMediaRequest.Builder setMediaType(ActivityResultContracts.PickVisualMedia.VisualMediaType mediaType) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            this.mediaType = mediaType;
            return this;
        }

        public final androidx.activity.result.PickVisualMediaRequest.Builder setOrderedSelection(boolean isOrderedSelection) {
            this.isOrderedSelection = isOrderedSelection;
            return this;
        }
    }
    public PickVisualMediaRequest() {
        super();
        this.mediaType = (ActivityResultContracts.PickVisualMedia.VisualMediaType)ActivityResultContracts.PickVisualMedia.ImageAndVideo.INSTANCE;
        this.maxItems = ActivityResultContracts.PickMultipleVisualMedia.Companion.getMaxItems$activity_release();
        this.defaultTab = (ActivityResultContracts.PickVisualMedia.DefaultTab)ActivityResultContracts.PickVisualMedia.DefaultTab.PhotosTab.INSTANCE;
    }

    public final long getAccentColor() {
        return this.accentColor;
    }

    public final ActivityResultContracts.PickVisualMedia.DefaultTab getDefaultTab() {
        return this.defaultTab;
    }

    public final int getMaxItems() {
        return this.maxItems;
    }

    public final ActivityResultContracts.PickVisualMedia.VisualMediaType getMediaType() {
        return this.mediaType;
    }

    public final boolean isCustomAccentColorApplied() {
        return this.isCustomAccentColorApplied;
    }

    public final boolean isOrderedSelection() {
        return this.isOrderedSelection;
    }

    public final void setAccentColor$activity_release(long <set-?>) {
        this.accentColor = <set-?>;
    }

    public final void setCustomAccentColorApplied$activity_release(boolean <set-?>) {
        this.isCustomAccentColorApplied = <set-?>;
    }

    public final void setDefaultTab$activity_release(ActivityResultContracts.PickVisualMedia.DefaultTab <set-?>) {
        Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
        this.defaultTab = <set-?>;
    }

    public final void setMaxItems$activity_release(int <set-?>) {
        this.maxItems = <set-?>;
    }

    public final void setMediaType$activity_release(ActivityResultContracts.PickVisualMedia.VisualMediaType <set-?>) {
        Intrinsics.checkNotNullParameter(<set-?>, "<set-?>");
        this.mediaType = <set-?>;
    }

    public final void setOrderedSelection$activity_release(boolean <set-?>) {
        this.isOrderedSelection = <set-?>;
    }
}
