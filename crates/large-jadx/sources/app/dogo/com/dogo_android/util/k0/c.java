package app.dogo.com.dogo_android.util.k0;

import androidx.databinding.h;
import app.dogo.com.dogo_android.util.e0.a0;

/* loaded from: classes.dex */
public interface c extends h {
    @Override // androidx.databinding.h
    public abstract String getCaption();

    @Override // androidx.databinding.h
    public abstract String getCreationDate();

    @Override // androidx.databinding.h
    public abstract String getDogAvatar();

    @Override // androidx.databinding.h
    public abstract String getDogName();

    @Override // androidx.databinding.h
    public abstract boolean getLikeState();

    @Override // androidx.databinding.h
    public abstract int getPagePosition();

    @Override // androidx.databinding.h
    public abstract int getPhotoCount();

    @Override // androidx.databinding.h
    public abstract String getTranslationButtonString();

    @Override // androidx.databinding.h
    public abstract String getVoteCount();

    @Override // androidx.databinding.h
    public abstract boolean isAdminBadgeVisible();

    @Override // androidx.databinding.h
    public abstract boolean isAmbassadorBadgeVisible();

    @Override // androidx.databinding.h
    public abstract boolean isBorderVisible();

    @Override // androidx.databinding.h
    public abstract boolean isCaptionExapanded();

    @Override // androidx.databinding.h
    public abstract boolean isCurrentUserEntriesAuthor();

    @Override // androidx.databinding.h
    public abstract boolean isFeatured();

    @Override // androidx.databinding.h
    public abstract boolean isPremiumBadgeVisible();

    @Override // androidx.databinding.h
    public abstract boolean isShareButtonVisible();

    @Override // androidx.databinding.h
    public abstract boolean isSpinnerVisible();

    @Override // androidx.databinding.h
    public abstract boolean isTranslateButtonVisible();

    @Override // androidx.databinding.h
    public abstract boolean isWinner();

    @Override // androidx.databinding.h
    public abstract void onCaptionClick();

    @Override // androidx.databinding.h
    public abstract void onEntryAvatarClick(a0 a0);

    @Override // androidx.databinding.h
    public abstract void onTranslateButtonPress();

    @Override // androidx.databinding.h
    public abstract void showEntryFans(a0 a0);

    @Override // androidx.databinding.h
    public abstract boolean showReportDeleteButton();
}
