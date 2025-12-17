package f.c.a.d.b.h;

import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* loaded from: classes2.dex */
public final class d implements Configurator {

    public static final Configurator a;
    static {
        d dVar = new d();
        d.a = dVar;
    }

    public final void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(e.class, c.a);
        encoderConfig.registerEncoder(MessagingClientEventExtension.class, b.a);
        encoderConfig.registerEncoder(MessagingClientEvent.class, a.a);
    }
}
