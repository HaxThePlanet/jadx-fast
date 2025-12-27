package app.dogo.com.dogo_android.q.p;

import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import kotlin.Metadata;

/* compiled from: DogPreviewCallback.kt */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0008\u0008f\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0008\u0010\u0006\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0008\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0008\u001a\u00020\tH&¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewCallback;", "", "onAddDogClick", "", "profilePreview", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "onAvatarClick", "onBirthdayClick", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "onBreedClick", "onDeleteDogClick", "onDogOwnerClick", "onDogSelectClick", "onGenderClick", "onNameClick", "onParticipateInWelcomeChallengeClick", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: v, reason: from kotlin metadata */
public interface DogPreviewCallback {
    /* renamed from: D0, reason: from kotlin metadata */
    void onAddDogClick(DogProfile profilePreview);

    /* renamed from: I0, reason: from kotlin metadata */
    void onBirthdayClick(DogProfile dogProfile);

    /* renamed from: J, reason: from kotlin metadata */
    void onBreedClick(DogProfile dogProfile);

    /* renamed from: Z0, reason: from kotlin metadata */
    void onDeleteDogClick(DogProfile profilePreview);

    /* renamed from: a1, reason: from kotlin metadata */
    void onDogOwnerClick(ProfilePreview profilePreview);

    /* renamed from: c0, reason: from kotlin metadata */
    void onGenderClick(ProfilePreview dogProfile);

    /* renamed from: n, reason: from kotlin metadata */
    void onNameClick(ProfilePreview dogProfile);

    /* renamed from: t1, reason: from kotlin metadata */
    void onParticipateInWelcomeChallengeClick(DogProfile dogProfile);

    /* renamed from: u, reason: from kotlin metadata */
    void onAvatarClick();

    void z();
}
