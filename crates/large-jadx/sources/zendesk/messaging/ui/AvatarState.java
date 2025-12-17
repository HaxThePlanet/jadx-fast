package zendesk.messaging.ui;

/* loaded from: classes3.dex */
class AvatarState {

    private final String avatarLetter;
    private final Integer avatarRes;
    private final String avatarUrl;
    private final Object uniqueIdentifier;
    public AvatarState(Object object, String string2, String string3, Integer integer4) {
        super();
        this.uniqueIdentifier = object;
        this.avatarLetter = string2;
        this.avatarUrl = string3;
        this.avatarRes = integer4;
    }

    String getAvatarLetter() {
        return this.avatarLetter;
    }

    Integer getAvatarRes() {
        return this.avatarRes;
    }

    String getAvatarUrl() {
        return this.avatarUrl;
    }

    Object getUniqueIdentifier() {
        return this.uniqueIdentifier;
    }
}
