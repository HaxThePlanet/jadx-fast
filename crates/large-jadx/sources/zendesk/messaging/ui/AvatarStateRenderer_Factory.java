package zendesk.messaging.ui;

import com.squareup.picasso.t;
import g.b.b;
import j.a.a;

/* loaded from: classes3.dex */
public final class AvatarStateRenderer_Factory implements b<zendesk.messaging.ui.AvatarStateRenderer> {

    private final a<t> picassoProvider;
    public AvatarStateRenderer_Factory(a<t> a) {
        super();
        this.picassoProvider = a;
    }

    public static zendesk.messaging.ui.AvatarStateRenderer_Factory create(a<t> a) {
        AvatarStateRenderer_Factory avatarStateRenderer_Factory = new AvatarStateRenderer_Factory(a);
        return avatarStateRenderer_Factory;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.messaging.ui.AvatarStateRenderer get() {
        AvatarStateRenderer avatarStateRenderer = new AvatarStateRenderer((t)this.picassoProvider.get());
        return avatarStateRenderer;
    }
}
