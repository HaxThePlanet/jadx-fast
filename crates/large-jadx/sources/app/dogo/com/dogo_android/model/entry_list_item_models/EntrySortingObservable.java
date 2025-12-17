package app.dogo.com.dogo_android.model.entry_list_item_models;

import app.dogo.com.dogo_android.k.b;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.p2;
import app.dogo.com.dogo_android.service.v2;
import app.dogo.com.dogo_android.util.e0.o;
import app.dogo.com.dogo_android.util.n0.h;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import java.util.Set;

/* loaded from: classes.dex */
public class EntrySortingObservable extends o {

    private final h listener;
    private app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.SortingCellModel model;
    private final p2 preferenceService;
    private final o3 tracker;
    private final v2 utilities;
    public EntrySortingObservable(h h) {
        super(App.o(), h, App.p(), App.i());
    }

    public EntrySortingObservable(o3 o3, h h2, v2 v23, p2 p24) {
        super();
        this.tracker = o3;
        this.listener = h2;
        this.preferenceService = p24;
        this.utilities = v23;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public String getCountryCode() {
        return this.preferenceService.p();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public int getLatestTabVisibility() {
        int i;
        i = this.model.hasChallengeExpired() ? 8 : 0;
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public b getSelectedTab() {
        return this.model.getSelectedTab();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public int getYourTabVisibility() {
        int i;
        i = this.model.isYourTabVisible() ? 0 : 8;
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public boolean isCountryTabVisible() {
        app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.SortingCellModel contains;
        int i;
        String selectedTab;
        b pOPULAR_TAB;
        contains = this.model;
        final int i2 = 0;
        if (contains != null && contains.getParticipatingCountries().contains(this.preferenceService.p())) {
            i = contains.getParticipatingCountries().contains(this.preferenceService.p()) ? 1 : i2;
        } else {
        }
        selectedTab = this.model;
        if (i == 0 && selectedTab != null && selectedTab.getSelectedTab() == b.COUNTRY) {
            selectedTab = this.model;
            if (selectedTab != null) {
                if (selectedTab.getSelectedTab() == b.COUNTRY) {
                    this.model.setSelectedTabAs(b.POPULAR_TAB);
                    this.listener.a(i2);
                    refreshView();
                }
            }
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public boolean isHour24TabVisible() {
        boolean countryTabVisible;
        int i;
        if (!isCountryTabVisible() && !this.model.hasChallengeExpired()) {
            i = !this.model.hasChallengeExpired() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public boolean isVisible() {
        return this.model.isVisible();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public boolean isWelcomeTabVisible() {
        app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.SortingCellModel challengeSingleEntryInfinite;
        int i;
        challengeSingleEntryInfinite = this.model;
        if (challengeSingleEntryInfinite != null && challengeSingleEntryInfinite.isChallengeSingleEntryInfinite()) {
            i = challengeSingleEntryInfinite.isChallengeSingleEntryInfinite() ? 1 : 0;
        } else {
        }
        return i;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void on24HourSelect() {
        o3 checkIfCurrentTabIs;
        Object obj;
        int i;
        obj = b.HOURS_24;
        if (!this.model.checkIfCurrentTabIs(obj)) {
            this.listener.a(6);
            this.model.setSelectedTabAs(obj);
            this.tracker.c(u.o);
            refreshView();
        } else {
            triggerBackToTop();
            refreshView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void on7DaySelect() {
        o3 checkIfCurrentTabIs;
        Object dAYS_7;
        int i;
        dAYS_7 = b.DAYS_7;
        if (!this.model.checkIfCurrentTabIs(dAYS_7)) {
            this.listener.a(5);
            this.model.setSelectedTabAs(dAYS_7);
            this.tracker.c(u.p);
            refreshView();
        } else {
            triggerBackToTop();
            refreshView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void onCountrySelect() {
        app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.SortingCellModel checkIfCurrentTabIs;
        int i;
        final b cOUNTRY = b.COUNTRY;
        if (!this.model.checkIfCurrentTabIs(cOUNTRY)) {
            this.tracker.c(u.q);
            this.listener.a(7);
            this.model.setSelectedTabAs(cOUNTRY);
            refreshView();
        } else {
            triggerBackToTop();
            refreshView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void onLatestSelect() {
        o3 checkIfCurrentTabIs;
        Object lATEST_TAB;
        int i;
        lATEST_TAB = b.LATEST_TAB;
        if (!this.model.checkIfCurrentTabIs(lATEST_TAB)) {
            this.listener.a(1);
            this.model.setSelectedTabAs(lATEST_TAB);
            this.tracker.c(u.l);
            refreshView();
        } else {
            triggerBackToTop();
            refreshView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void onPopularSelect() {
        o3 checkIfCurrentTabIs;
        Object pOPULAR_TAB;
        int i;
        pOPULAR_TAB = b.POPULAR_TAB;
        if (!this.model.checkIfCurrentTabIs(pOPULAR_TAB)) {
            this.listener.a(0);
            this.model.setSelectedTabAs(pOPULAR_TAB);
            this.tracker.c(u.k);
            refreshView();
        } else {
            triggerBackToTop();
            refreshView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void onYourSelect() {
        o3 checkIfCurrentTabIs;
        Object yOUR_TAB;
        int i;
        yOUR_TAB = b.YOUR_TAB;
        if (!this.model.checkIfCurrentTabIs(yOUR_TAB)) {
            this.listener.a(2);
            this.model.setSelectedTabAs(yOUR_TAB);
            this.tracker.c(u.m);
            refreshView();
        } else {
            triggerBackToTop();
            refreshView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void refreshView() {
        notifyChangeAll();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void setModel(app.dogo.com.dogo_android.model.entry_list_item_models.EntrySortingTabItem.SortingCellModel entrySortingTabItem$SortingCellModel) {
        this.model = sortingCellModel;
        refreshView();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void triggerBackToTop() {
        this.listener.a(4);
        this.tracker.c(u.n);
    }
}
