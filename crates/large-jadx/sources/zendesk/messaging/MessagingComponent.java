package zendesk.messaging;

import android.content.Context;
import android.content.res.Resources;
import com.squareup.picasso.t;
import java.util.List;
import zendesk.belvedere.a;

/* loaded from: classes3.dex */
interface MessagingComponent {

    public interface Builder {
        public abstract zendesk.messaging.MessagingComponent.Builder appContext(Context context);

        public abstract zendesk.messaging.MessagingComponent build();

        public abstract zendesk.messaging.MessagingComponent.Builder engines(List<zendesk.messaging.Engine> list);

        public abstract zendesk.messaging.MessagingComponent.Builder messagingConfiguration(zendesk.messaging.MessagingConfiguration messagingConfiguration);
    }
    public abstract a belvedere();

    public abstract zendesk.messaging.BelvedereMediaHolder belvedereMediaHolder();

    public abstract zendesk.messaging.MessagingConfiguration messagingConfiguration();

    public abstract zendesk.messaging.MessagingViewModel messagingViewModel();

    public abstract t picasso();

    public abstract Resources resources();
}
