package zendesk.messaging.ui;

import android.view.View;

/* loaded from: classes3.dex */
class MessagingCellProps {

    private final int avatarVisibility;
    private final int cellSpacing;
    private final int labelVisibility;
    MessagingCellProps(int i, int i2, int i3) {
        super();
        this.labelVisibility = i;
        this.cellSpacing = i2;
        this.avatarVisibility = i3;
    }

    void apply(View view) {
        final int i = 0;
        apply(view, i, i);
    }

    void apply(View view, View view2) {
        apply(view, view2, 0);
    }

    void apply(View view, View view2, View view3) {
        int labelVisibility;
        int obj3;
        if (view2 != null) {
            view2.setVisibility(this.labelVisibility);
        }
        if (view3 != null) {
            view3.setVisibility(this.avatarVisibility);
        }
        obj3.bottomMargin = this.cellSpacing;
        view.requestLayout();
    }

    public boolean equals(Object object) {
        int i;
        Class<zendesk.messaging.ui.MessagingCellProps> obj;
        Class class;
        if (this == object) {
            return 1;
        }
        final int i2 = 0;
        if (object != null) {
            if (MessagingCellProps.class != object.getClass()) {
            } else {
                if (this.labelVisibility != object.labelVisibility) {
                    return i2;
                }
                if (this.cellSpacing == object.cellSpacing) {
                } else {
                    i = i2;
                }
            }
            return i;
        }
        return i2;
    }

    public int hashCode() {
        return i += cellSpacing;
    }
}
