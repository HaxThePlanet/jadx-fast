package androidx.compose.foundation.content;

import android.net.Uri;
import android.os.Bundle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u00002\u00020\u0001B\u0019\u0008\u0000\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0012", d2 = {"Landroidx/compose/foundation/content/PlatformTransferableContent;", "", "linkUri", "Landroid/net/Uri;", "extras", "Landroid/os/Bundle;", "(Landroid/net/Uri;Landroid/os/Bundle;)V", "getExtras", "()Landroid/os/Bundle;", "getLinkUri", "()Landroid/net/Uri;", "equals", "", "other", "hashCode", "", "toString", "", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PlatformTransferableContent {

    public static final int $stable = 8;
    private final Bundle extras;
    private final Uri linkUri;
    static {
        final int i = 8;
    }

    public PlatformTransferableContent(Uri linkUri, Bundle extras) {
        super();
        this.linkUri = linkUri;
        this.extras = extras;
    }

    public boolean equals(Object other) {
        final int i = 1;
        if (this == other) {
            return i;
        }
        final int i2 = 0;
        if (!other instanceof PlatformTransferableContent) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.linkUri, obj.linkUri)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.extras, obj2.extras)) {
            return i2;
        }
        return i;
    }

    public final Bundle getExtras() {
        return this.extras;
    }

    public final Uri getLinkUri() {
        return this.linkUri;
    }

    public int hashCode() {
        int i;
        Uri linkUri = this.linkUri;
        if (linkUri != null) {
            i = linkUri.hashCode();
        } else {
            i = 0;
        }
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("PlatformTransferableContent(linkUri=").append(this.linkUri).append(", extras=").append(this.extras).append(')').toString();
    }
}
