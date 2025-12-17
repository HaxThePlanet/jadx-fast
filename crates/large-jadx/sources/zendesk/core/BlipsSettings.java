package zendesk.core;

/* loaded from: classes3.dex */
class BlipsSettings {

    private zendesk.core.BlipsPermissions permissions;
    BlipsSettings(zendesk.core.BlipsPermissions blipsPermissions) {
        super();
        this.permissions = blipsPermissions;
    }

    zendesk.core.BlipsPermissions getBlipsPermissions() {
        return this.permissions;
    }
}
