package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.util.e0.o;

/* loaded from: classes.dex */
public class ChallengeFeedEndObservable extends o {

    private int backgroundColor;
    private int backgroundDrawable;
    private boolean buttonVisible;
    private int textResource;

    public static enum LabelState {

        FEED_END,
        CLEAR_FILTER,
        ENTRIES_LIST_EMPTY;
    }
    @Override // app.dogo.com.dogo_android.util.e0.o
    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public int getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public int getMessageText() {
        return this.textResource;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public boolean isButtonVisible() {
        return this.buttonVisible;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void setData(app.dogo.com.dogo_android.model.entry_list_item_models.ChallengeFeedEndObservable.LabelState challengeFeedEndObservable$LabelState) {
        int i;
        int i2;
        int obj4;
        obj4 = ChallengeFeedEndObservable.1.$SwitchMap$app$dogo$com$dogo_android$model$entry_list_item_models$ChallengeFeedEndObservable$LabelState[labelState.ordinal()];
        i = 1;
        final int i3 = 0;
        if (obj4 != i) {
            if (obj4 != 2) {
                if (obj4 != 3) {
                } else {
                    this.textResource = 2131886292;
                    this.buttonVisible = i3;
                    this.backgroundDrawable = i3;
                    this.backgroundColor = 2131100375;
                }
            } else {
                this.textResource = 2131886275;
                this.buttonVisible = i;
                this.backgroundDrawable = i3;
                this.backgroundColor = 2131100379;
            }
        } else {
            this.textResource = 2131886286;
            this.buttonVisible = i3;
            this.backgroundDrawable = 2131230873;
            this.backgroundColor = i3;
        }
        notifyChangeAll();
    }
}
