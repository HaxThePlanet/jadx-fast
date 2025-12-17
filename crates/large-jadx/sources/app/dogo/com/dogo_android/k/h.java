package app.dogo.com.dogo_android.k;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000e\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/enums/FragmentMessageAction;", "", "action", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getAction", "()Ljava/lang/String;", "MESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE", "MESSAGE_ACTION_SWITCH_TO_YOUR_TAB", "MESSAGE_ACTION_CHALLENGE_FILTERS", "MESSAGE_ACTION_BACK_TO_TOP", "MESSAGE_ACTION_BREED_SELECTED", "MESSAGE_ACTION_COMMENT_COUNT_CHANGE", "MESSAGE_ACTION_START_ENTRY_CREATION_FLOW", "MESSAGE_ACTION_SET_BUTTON_STATE", "MESSAGE_ACTION_NEW_COMMENT_POSTED", "MESSAGE_ACTION_PUBLISH_ENTRY", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public enum h {

    MESSAGE_ACTION_CHALLENGE_ENTRY_UPLOAD_UPDATE("challenge_entry_upload_update"),
    MESSAGE_ACTION_SWITCH_TO_YOUR_TAB("challenge_entry_upload_update"),
    MESSAGE_ACTION_CHALLENGE_FILTERS("challenge_entry_upload_update"),
    MESSAGE_ACTION_BACK_TO_TOP("challenge_entry_upload_update"),
    MESSAGE_ACTION_BREED_SELECTED("challenge_entry_upload_update"),
    MESSAGE_ACTION_COMMENT_COUNT_CHANGE("challenge_entry_upload_update"),
    MESSAGE_ACTION_START_ENTRY_CREATION_FLOW("challenge_entry_upload_update"),
    MESSAGE_ACTION_SET_BUTTON_STATE("challenge_entry_upload_update"),
    MESSAGE_ACTION_NEW_COMMENT_POSTED("challenge_entry_upload_update"),
    MESSAGE_ACTION_PUBLISH_ENTRY("challenge_entry_upload_update");

    private final String action;
    private static final app.dogo.com.dogo_android.k.h[] $values() {
        app.dogo.com.dogo_android.k.h[] arr = new h[10];
        return arr;
    }

    @Override // java.lang.Enum
    public final String getAction() {
        return this.action;
    }
}
