package zendesk.support;

import g.b.b;
import g.b.d;

/* loaded from: classes3.dex */
public final class SupportEngineModule_EmailValidatorFactory implements b<zendesk.support.EmailValidator> {

    private final zendesk.support.SupportEngineModule module;
    public SupportEngineModule_EmailValidatorFactory(zendesk.support.SupportEngineModule supportEngineModule) {
        super();
        this.module = supportEngineModule;
    }

    public static zendesk.support.SupportEngineModule_EmailValidatorFactory create(zendesk.support.SupportEngineModule supportEngineModule) {
        SupportEngineModule_EmailValidatorFactory supportEngineModule_EmailValidatorFactory = new SupportEngineModule_EmailValidatorFactory(supportEngineModule);
        return supportEngineModule_EmailValidatorFactory;
    }

    public static zendesk.support.EmailValidator emailValidator(zendesk.support.SupportEngineModule supportEngineModule) {
        final zendesk.support.EmailValidator obj1 = supportEngineModule.emailValidator();
        d.c(obj1, "Cannot return null from a non-@Nullable @Provides method");
        return (EmailValidator)obj1;
    }

    @Override // g.b.b
    public Object get() {
        return get();
    }

    @Override // g.b.b
    public zendesk.support.EmailValidator get() {
        return SupportEngineModule_EmailValidatorFactory.emailValidator(this.module);
    }
}
