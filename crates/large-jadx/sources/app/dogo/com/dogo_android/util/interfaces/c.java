package app.dogo.com.dogo_android.util.k0;

import androidx.databinding.h;
import app.dogo.com.dogo_android.util.e0.a0;

/* compiled from: BaseEntryLayoutManager.java */
/* loaded from: classes.dex */
public interface c extends h {
    String getCaption();

    String getCreationDate();

    String getDogAvatar();

    String getDogName();

    boolean getLikeState();

    int getPagePosition();

    int getPhotoCount();

    String getTranslationButtonString();

    String getVoteCount();

    boolean isAdminBadgeVisible();

    boolean isAmbassadorBadgeVisible();

    boolean isBorderVisible();

    boolean isCaptionExapanded();

    boolean isCurrentUserEntriesAuthor();

    boolean isFeatured();

    boolean isPremiumBadgeVisible();

    boolean isShareButtonVisible();

    boolean isSpinnerVisible();

    boolean isTranslateButtonVisible();

    boolean isWinner();

    void onCaptionClick();

    void onEntryAvatarClick(a0 a0Var);

    void onTranslateButtonPress();

    void showEntryFans(a0 a0Var);

    boolean showReportDeleteButton();
}
