package zendesk.core;

/* loaded from: classes3.dex */
public final class AnonymousIdentity implements zendesk.core.Identity {

    private String email;
    private String name;
    private String sdkGuid;

    public static class Builder {

        private String email;
        private String name;
        static String access$000(zendesk.core.AnonymousIdentity.Builder anonymousIdentity$Builder) {
            return builder.email;
        }

        static String access$100(zendesk.core.AnonymousIdentity.Builder anonymousIdentity$Builder) {
            return builder.name;
        }

        public zendesk.core.Identity build() {
            AnonymousIdentity anonymousIdentity = new AnonymousIdentity(this, 0);
            return anonymousIdentity;
        }

        public zendesk.core.AnonymousIdentity.Builder withEmailIdentifier(String string) {
            this.email = string;
            return this;
        }

        public zendesk.core.AnonymousIdentity.Builder withNameIdentifier(String string) {
            this.name = string;
            return this;
        }
    }
    private AnonymousIdentity(zendesk.core.AnonymousIdentity.Builder anonymousIdentity$Builder) {
        super();
        this.email = AnonymousIdentity.Builder.access$000(builder);
        this.name = AnonymousIdentity.Builder.access$100(builder);
    }

    AnonymousIdentity(zendesk.core.AnonymousIdentity.Builder anonymousIdentity$Builder, zendesk.core.AnonymousIdentity.1 anonymousIdentity$12) {
        super(builder);
    }

    @Override // zendesk.core.Identity
    public boolean equals(Object object) {
        boolean equals;
        Class<zendesk.core.AnonymousIdentity> obj;
        Object class;
        boolean obj5;
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (object != null) {
            if (AnonymousIdentity.class != object.getClass()) {
            } else {
                String email = this.email;
                if (email != null) {
                    if (!email.equals(object.email)) {
                        return i2;
                    }
                } else {
                    if (object.email != null) {
                    }
                }
                String name = this.name;
                obj5 = object.name;
                if (name != null) {
                    if (!name.equals(obj5)) {
                        return i2;
                    }
                } else {
                    if (obj5 != null) {
                    }
                }
            }
            return i;
        }
        return i2;
    }

    @Override // zendesk.core.Identity
    public String getEmail() {
        return this.email;
    }

    @Override // zendesk.core.Identity
    public String getName() {
        return this.name;
    }

    @Override // zendesk.core.Identity
    public String getSdkGuid() {
        return this.sdkGuid;
    }

    @Override // zendesk.core.Identity
    public int hashCode() {
        int i;
        int i2;
        String email = this.email;
        if (email != null) {
            i = email.hashCode();
        } else {
            i = i2;
        }
        final String name = this.name;
        if (name != null) {
            i2 = name.hashCode();
        }
        return i3 += i2;
    }

    @Override // zendesk.core.Identity
    void setSdkGuid(String string) {
        this.sdkGuid = string;
    }
}
