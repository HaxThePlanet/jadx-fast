package app.dogo.com.dogo_android.k;

import java.io.Serializable;
import kotlin.Metadata;

/* compiled from: FragmentTags.kt */
@Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0014\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u00022\u00020\u0003B\u0017\u0008\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011j\u0002\u0008\u0012j\u0002\u0008\u0013j\u0002\u0008\u0014j\u0002\u0008\u0015j\u0002\u0008\u0016j\u0002\u0008\u0017j\u0002\u0008\u0018j\u0002\u0008\u0019j\u0002\u0008\u001a¨\u0006\u001b", d2 = {"Lapp/dogo/com/dogo_android/enums/FragmentTags;", "", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "Ljava/io/Serializable;", "tag", "", "navigationId", "", "(Ljava/lang/String;ILjava/lang/String;I)V", "getNavigationId", "()I", "getTag", "()Ljava/lang/String;", "CHALLENGE_NOTIFICATION_CENTER_FRAGMENT", "CHALLENGE_HOME_FRAGMENT", "DOG_CREATION_NAME_FRAGMENT", "DOG_CREATION_PICTURE_FRAGMENT", "DOG_CREATION_BREED_FRAGMENT", "DOG_CREATION_BIRTHDAY_FRAGMENT", "DOG_CREATION_SIGN_UP_FRAGMENT", "DOG_CREATION_GENDER_FRAGMENT", "EMAIL_AUTHENTICATION_FRAGMENT", "EMAIL_REGISTRATION_FRAGMENT", "SIGN_IN_FRAGMENT", "DAILY_REMINDER_FRAGMENT", "DOG_CREATION_WELCOME_FRAGMENT", "PLACEHOLDER", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public enum FragmentTags implements q, Serializable {

    CHALLENGE_HOME_FRAGMENT,
    CHALLENGE_NOTIFICATION_CENTER_FRAGMENT,
    DAILY_REMINDER_FRAGMENT,
    DOG_CREATION_BIRTHDAY_FRAGMENT,
    DOG_CREATION_BREED_FRAGMENT,
    DOG_CREATION_GENDER_FRAGMENT,
    DOG_CREATION_NAME_FRAGMENT,
    DOG_CREATION_PICTURE_FRAGMENT,
    DOG_CREATION_SIGN_UP_FRAGMENT,
    DOG_CREATION_WELCOME_FRAGMENT,
    EMAIL_AUTHENTICATION_FRAGMENT,
    EMAIL_REGISTRATION_FRAGMENT,
    PLACEHOLDER,
    SIGN_IN_FRAGMENT;

    private final int navigationId;
    private final String tag;
    @Override // java.lang.Enum
    public final int getNavigationId() {
        return this.navigationId;
    }

    @Override // java.lang.Enum
    public String getTag() {
        return this.tag;
    }

    private static final /* synthetic */ i[] $values() {
        app.dogo.com.dogo_android.k.i[] arr = new i[14];
        return new i[] { FragmentTags.CHALLENGE_NOTIFICATION_CENTER_FRAGMENT, FragmentTags.CHALLENGE_HOME_FRAGMENT, FragmentTags.DOG_CREATION_NAME_FRAGMENT, FragmentTags.DOG_CREATION_PICTURE_FRAGMENT, FragmentTags.DOG_CREATION_BREED_FRAGMENT, FragmentTags.DOG_CREATION_BIRTHDAY_FRAGMENT, FragmentTags.DOG_CREATION_SIGN_UP_FRAGMENT, FragmentTags.DOG_CREATION_GENDER_FRAGMENT, FragmentTags.EMAIL_AUTHENTICATION_FRAGMENT, FragmentTags.EMAIL_REGISTRATION_FRAGMENT, FragmentTags.SIGN_IN_FRAGMENT, FragmentTags.DAILY_REMINDER_FRAGMENT, FragmentTags.DOG_CREATION_WELCOME_FRAGMENT, FragmentTags.PLACEHOLDER };
    }
}
