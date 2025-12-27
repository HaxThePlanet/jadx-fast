package f.c.a.d.b.h;

import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;

/* compiled from: com.google.firebase:firebase-messaging@@23.0.0 */
/* loaded from: classes2.dex */
public final class d implements Configurator {

    public static final Configurator a = new d();
    public final void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder(e.class, c.a);
        encoderConfig.registerEncoder(MessagingClientEventExtension.class, b.a);
        encoderConfig.registerEncoder(MessagingClientEvent.class, a.a);
    }


    private d() {
        super();
    }
}
