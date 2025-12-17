package zendesk.core;

/* loaded from: classes3.dex */
class BlipsPermissions {

    private boolean behavioural;
    private boolean pathfinder;
    private boolean required;
    BlipsPermissions() {
        final int i = 0;
        super(i, i, i);
    }

    BlipsPermissions(boolean z, boolean z2, boolean z3) {
        super();
        this.required = z;
        this.behavioural = z2;
        this.pathfinder = z3;
    }

    boolean isEnabled(zendesk.core.BlipsGroup blipsGroup) {
        int obj2 = BlipsPermissions.1.$SwitchMap$zendesk$core$BlipsGroup[blipsGroup.ordinal()];
        if (obj2 != 1 && obj2 != 2 && obj2 != 3) {
            if (obj2 != 2) {
                if (obj2 != 3) {
                    return 0;
                }
                return this.pathfinder;
            }
            return this.behavioural;
        }
        return this.required;
    }
}
