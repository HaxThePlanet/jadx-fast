package app.dogo.com.dogo_android.k;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\u0008\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000f¨\u0006\u0010", d2 = {"Lapp/dogo/com/dogo_android/enums/DialogTags;", "", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "tag", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "CHALLENGE_SHARE_DIALOG", "LOADING_DIALOG_FRAGMENT", "CHALLENGE_ENTRY_CREATION", "CHALLENGE_DETAILS_DIALOG", "CHALLENGE_FILTER_DIALOG_FRAGMENT", "INSTAGRAM_INVITE_DIALOG", "TIKTOK_INVITE_DIALOG", "LESSON_INTRODUCTION_DIALOG", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum c implements app.dogo.com.dogo_android.k.q {

    CHALLENGE_SHARE_DIALOG("challenge_share_dialog"),
    LOADING_DIALOG_FRAGMENT("challenge_share_dialog"),
    CHALLENGE_ENTRY_CREATION("challenge_share_dialog"),
    CHALLENGE_DETAILS_DIALOG("challenge_share_dialog"),
    CHALLENGE_FILTER_DIALOG_FRAGMENT("challenge_share_dialog"),
    INSTAGRAM_INVITE_DIALOG("challenge_share_dialog"),
    TIKTOK_INVITE_DIALOG("challenge_share_dialog"),
    LESSON_INTRODUCTION_DIALOG("challenge_share_dialog");

    private final String tag;
    private static final app.dogo.com.dogo_android.k.c[] $values() {
        app.dogo.com.dogo_android.k.c[] arr = new c[8];
        return arr;
    }

    @Override // java.lang.Enum
    public String getTag() {
        return this.tag;
    }
}
