package androidx.core.app;

import android.app.PendingIntent;
import android.app.RemoteAction;
import android.graphics.drawable.Icon;
import androidx.core.graphics.drawable.IconCompat;
import androidx.core.util.Preconditions;
import androidx.versionedparcelable.VersionedParcelable;

/* loaded from: classes5.dex */
public final class RemoteActionCompat implements VersionedParcelable {

    public PendingIntent mActionIntent;
    public java.lang.CharSequence mContentDescription;
    public boolean mEnabled;
    public IconCompat mIcon;
    public boolean mShouldShowIcon;
    public java.lang.CharSequence mTitle;

    static class Api26Impl {
        static RemoteAction createRemoteAction(Icon icon, java.lang.CharSequence title, java.lang.CharSequence contentDescription, PendingIntent intent) {
            RemoteAction remoteAction = new RemoteAction(icon, title, contentDescription, intent);
            return remoteAction;
        }

        static PendingIntent getActionIntent(RemoteAction remoteAction) {
            return remoteAction.getActionIntent();
        }

        static java.lang.CharSequence getContentDescription(RemoteAction remoteAction) {
            return remoteAction.getContentDescription();
        }

        static Icon getIcon(RemoteAction remoteAction) {
            return remoteAction.getIcon();
        }

        static java.lang.CharSequence getTitle(RemoteAction remoteAction) {
            return remoteAction.getTitle();
        }

        static boolean isEnabled(RemoteAction remoteAction) {
            return remoteAction.isEnabled();
        }

        static void setEnabled(RemoteAction remoteAction, boolean enabled) {
            remoteAction.setEnabled(enabled);
        }
    }

    static class Api28Impl {
        static void setShouldShowIcon(RemoteAction remoteAction, boolean shouldShowIcon) {
            remoteAction.setShouldShowIcon(shouldShowIcon);
        }

        static boolean shouldShowIcon(RemoteAction remoteAction) {
            return remoteAction.shouldShowIcon();
        }
    }
    public RemoteActionCompat(androidx.core.app.RemoteActionCompat other) {
        super();
        Preconditions.checkNotNull(other);
        this.mIcon = other.mIcon;
        this.mTitle = other.mTitle;
        this.mContentDescription = other.mContentDescription;
        this.mActionIntent = other.mActionIntent;
        this.mEnabled = other.mEnabled;
        this.mShouldShowIcon = other.mShouldShowIcon;
    }

    public RemoteActionCompat(IconCompat icon, java.lang.CharSequence title, java.lang.CharSequence contentDescription, PendingIntent intent) {
        super();
        this.mIcon = (IconCompat)Preconditions.checkNotNull(icon);
        this.mTitle = (CharSequence)Preconditions.checkNotNull(title);
        this.mContentDescription = (CharSequence)Preconditions.checkNotNull(contentDescription);
        this.mActionIntent = (PendingIntent)Preconditions.checkNotNull(intent);
        int i = 1;
        this.mEnabled = i;
        this.mShouldShowIcon = i;
    }

    public static androidx.core.app.RemoteActionCompat createFromRemoteAction(RemoteAction remoteAction) {
        Preconditions.checkNotNull(remoteAction);
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat(IconCompat.createFromIcon(RemoteActionCompat.Api26Impl.getIcon(remoteAction)), RemoteActionCompat.Api26Impl.getTitle(remoteAction), RemoteActionCompat.Api26Impl.getContentDescription(remoteAction), RemoteActionCompat.Api26Impl.getActionIntent(remoteAction));
        remoteActionCompat.setEnabled(RemoteActionCompat.Api26Impl.isEnabled(remoteAction));
        remoteActionCompat.setShouldShowIcon(RemoteActionCompat.Api28Impl.shouldShowIcon(remoteAction));
        return remoteActionCompat;
    }

    @Override // androidx.versionedparcelable.VersionedParcelable
    public PendingIntent getActionIntent() {
        return this.mActionIntent;
    }

    @Override // androidx.versionedparcelable.VersionedParcelable
    public java.lang.CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    @Override // androidx.versionedparcelable.VersionedParcelable
    public IconCompat getIcon() {
        return this.mIcon;
    }

    @Override // androidx.versionedparcelable.VersionedParcelable
    public java.lang.CharSequence getTitle() {
        return this.mTitle;
    }

    @Override // androidx.versionedparcelable.VersionedParcelable
    public boolean isEnabled() {
        return this.mEnabled;
    }

    @Override // androidx.versionedparcelable.VersionedParcelable
    public void setEnabled(boolean enabled) {
        this.mEnabled = enabled;
    }

    @Override // androidx.versionedparcelable.VersionedParcelable
    public void setShouldShowIcon(boolean shouldShowIcon) {
        this.mShouldShowIcon = shouldShowIcon;
    }

    @Override // androidx.versionedparcelable.VersionedParcelable
    public boolean shouldShowIcon() {
        return this.mShouldShowIcon;
    }

    @Override // androidx.versionedparcelable.VersionedParcelable
    public RemoteAction toRemoteAction() {
        RemoteAction remoteAction = RemoteActionCompat.Api26Impl.createRemoteAction(this.mIcon.toIcon(), this.mTitle, this.mContentDescription, this.mActionIntent);
        RemoteActionCompat.Api26Impl.setEnabled(remoteAction, isEnabled());
        RemoteActionCompat.Api28Impl.setShouldShowIcon(remoteAction, shouldShowIcon());
        return remoteAction;
    }
}
