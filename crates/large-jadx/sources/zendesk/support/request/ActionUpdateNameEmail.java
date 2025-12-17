package zendesk.support.request;

import f.g.e.g;
import o.b.f;
import o.b.j;
import zendesk.core.AnonymousIdentity;
import zendesk.core.AnonymousIdentity.Builder;
import zendesk.core.AuthenticationProvider;
import zendesk.core.Zendesk;

/* loaded from: classes3.dex */
class ActionUpdateNameEmail implements zendesk.support.request.AsyncMiddleware.AsyncAction {

    private final AuthenticationProvider authenticationProvider;
    private final String email;
    private final String name;
    private final Zendesk zendesk;
    ActionUpdateNameEmail(String string, String string2, AuthenticationProvider authenticationProvider3, Zendesk zendesk4) {
        super();
        this.name = string;
        this.email = string2;
        this.authenticationProvider = authenticationProvider3;
        this.zendesk = zendesk4;
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void actionQueued(f f, j j2) {
    }

    @Override // zendesk.support.request.AsyncMiddleware$AsyncAction
    public void execute(f f, j j2, zendesk.support.request.AsyncMiddleware.Callback asyncMiddleware$Callback3) {
        boolean equals;
        boolean emailIdentifier;
        String email;
        Object obj3;
        boolean obj4;
        obj3 = this.authenticationProvider.getIdentity();
        obj4 = obj3;
        if (obj3 instanceof AnonymousIdentity && g.c(this.email) && !this.email.equals((AnonymousIdentity)obj4.getEmail())) {
            obj4 = obj3;
            if (g.c(this.email)) {
                if (!this.email.equals((AnonymousIdentity)obj4.getEmail())) {
                    AnonymousIdentity.Builder builder = new AnonymousIdentity.Builder();
                    obj4 = builder.withEmailIdentifier(this.email).withNameIdentifier(obj4.getName()).build();
                }
            }
            if (g.c(this.name) && !this.name.equals(obj4.getName())) {
                if (!this.name.equals(obj4.getName())) {
                    AnonymousIdentity.Builder builder2 = new AnonymousIdentity.Builder();
                    obj4 = builder2.withEmailIdentifier(obj4.getEmail()).withNameIdentifier(this.name).build();
                }
            }
            if (obj4 != obj3) {
                this.zendesk.setIdentity(obj4);
            }
        }
        callback3.done();
    }
}
