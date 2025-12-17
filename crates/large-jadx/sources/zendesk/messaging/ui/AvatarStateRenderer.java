package zendesk.messaging.ui;

import com.squareup.picasso.t;
import f.g.e.g;
import zendesk.messaging.R.drawable;

/* loaded from: classes3.dex */
class AvatarStateRenderer {

    private static final int DEFAULT_AVATAR_DRAWABLE;
    private final t picasso;
    static {
        AvatarStateRenderer.DEFAULT_AVATAR_DRAWABLE = R.drawable.zui_ic_default_avatar_16;
    }

    public AvatarStateRenderer(t t) {
        super();
        this.picasso = t;
    }

    void render(zendesk.messaging.ui.AvatarState avatarState, zendesk.messaging.ui.AvatarView avatarView2) {
        boolean matches;
        Integer dEFAULT_AVATAR_DRAWABLE;
        String str;
        int obj3;
        if (g.c(avatarState.getAvatarUrl())) {
            avatarView2.showImage(this.picasso, avatarState.getAvatarUrl());
        } else {
            if (avatarState.getAvatarRes() != null) {
                avatarView2.showDrawable(avatarState.getAvatarRes().intValue());
            } else {
                if (g.c(avatarState.getAvatarLetter()) && avatarState.getAvatarLetter().matches("[a-zA-Z]")) {
                    if (avatarState.getAvatarLetter().matches("[a-zA-Z]")) {
                        avatarView2.showLetter(avatarState.getAvatarLetter(), avatarState.getUniqueIdentifier());
                    } else {
                        avatarView2.showDefault(AvatarStateRenderer.DEFAULT_AVATAR_DRAWABLE, avatarState.getUniqueIdentifier());
                    }
                } else {
                }
            }
        }
    }
}
