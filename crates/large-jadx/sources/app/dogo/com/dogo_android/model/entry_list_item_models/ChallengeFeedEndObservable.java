package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.util.e0.o;

/* compiled from: ChallengeFeedEndObservable.java */
/* loaded from: classes.dex */
public class ChallengeFeedEndObservable extends o {

    private int backgroundColor;
    private int backgroundDrawable;
    private boolean buttonVisible;
    private int textResource;

    static class AnonymousClass1 {

        static final /* synthetic */ int[] $SwitchMap$app$dogo$com$dogo_android$model$entry_list_item_models$ChallengeFeedEndObservable$LabelState;
        static {
            int[] iArr = new int[ChallengeFeedEndObservable.LabelState.values().length];
            ChallengeFeedEndObservable.AnonymousClass1.$SwitchMap$app$dogo$com$dogo_android$model$entry_list_item_models$ChallengeFeedEndObservable$LabelState = iArr;
            try {
                iArr[ChallengeFeedEndObservable.LabelState.FEED_END.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                ChallengeFeedEndObservable.AnonymousClass1.$SwitchMap$app$dogo$com$dogo_android$model$entry_list_item_models$ChallengeFeedEndObservable$LabelState[ChallengeFeedEndObservable.LabelState.CLEAR_FILTER.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                ChallengeFeedEndObservable.AnonymousClass1.$SwitchMap$app$dogo$com$dogo_android$model$entry_list_item_models$ChallengeFeedEndObservable$LabelState[ChallengeFeedEndObservable.LabelState.ENTRIES_LIST_EMPTY.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    public enum LabelState {

        CLEAR_FILTER,
        ENTRIES_LIST_EMPTY,
        FEED_END;
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
    public void setData(ChallengeFeedEndObservable.LabelState labelState) {
        int i3 = ChallengeFeedEndObservable.AnonymousClass1.$SwitchMap$app$dogo$com$dogo_android$model$entry_list_item_models$ChallengeFeedEndObservable$LabelState[labelState.ordinal()];
        int i = 1;
        final boolean z = false;
        if (i3 == i) {
            this.textResource = 2131886286;
            this.buttonVisible = z;
            i3 = 2131230873;
            this.backgroundDrawable = i3;
            this.backgroundColor = z;
        } else {
            int i2 = 2;
            if (i3 == 2) {
                this.textResource = 2131886275;
                this.buttonVisible = true;
                this.backgroundDrawable = z;
                i3 = 2131100379;
                this.backgroundColor = i3;
            } else {
                i = 3;
                if (i3 == 3) {
                    this.textResource = 2131886292;
                    this.buttonVisible = z;
                    this.backgroundDrawable = z;
                    i3 = 2131100375;
                    this.backgroundColor = i3;
                }
            }
        }
        notifyChangeAll();
    }
}
