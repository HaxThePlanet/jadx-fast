package androidx.core.app;

import android.content.res.Configuration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\u0018\u00002\u00020\u0001B\u0017\u0008\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0002\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000¨\u0006\u000c", d2 = {"Landroidx/core/app/PictureInPictureModeChangedInfo;", "", "isInPictureInPictureMode", "", "newConfig", "Landroid/content/res/Configuration;", "(ZLandroid/content/res/Configuration;)V", "(Z)V", "()Z", "getNewConfig", "()Landroid/content/res/Configuration;", "newConfiguration", "core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PictureInPictureModeChangedInfo {

    private final boolean isInPictureInPictureMode;
    private Configuration newConfiguration;
    public PictureInPictureModeChangedInfo(boolean isInPictureInPictureMode) {
        super();
        this.isInPictureInPictureMode = isInPictureInPictureMode;
    }

    public PictureInPictureModeChangedInfo(boolean isInPictureInPictureMode, Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super(isInPictureInPictureMode);
        this.newConfiguration = newConfig;
    }

    public final Configuration getNewConfig() {
        Configuration newConfiguration = this.newConfiguration;
        if (newConfiguration == null) {
        } else {
            return newConfiguration;
        }
        int i = 0;
        IllegalStateException $i$a$CheckNotNullPictureInPictureModeChangedInfo$newConfig$1 = new IllegalStateException("PictureInPictureModeChangedInfo must be constructed with the constructor that takes a Configuration to access the newConfig. Are you running on an API 26 or higher device that makes this information available?".toString());
        throw $i$a$CheckNotNullPictureInPictureModeChangedInfo$newConfig$1;
    }

    public final boolean isInPictureInPictureMode() {
        return this.isInPictureInPictureMode;
    }
}
