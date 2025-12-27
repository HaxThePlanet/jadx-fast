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

/* compiled from: EntrySortingObservable.java */
/* loaded from: classes.dex */
public class EntrySortingObservable extends o {

    private final h listener;
    private EntrySortingTabItem.SortingCellModel model;
    private final p2 preferenceService;
    private final o3 tracker;
    private final v2 utilities;
    public EntrySortingObservable(h hVar) {
        this(App.o(), hVar, App.p(), App.i());
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public String getCountryCode() {
        return this.preferenceService.p();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public int getLatestTabVisibility() {
        int i = 8;
        int r0 = this.model.hasChallengeExpired() ? 8 : 0;
        return (this.model.hasChallengeExpired() ? 8 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public b getSelectedTab() {
        return this.model.getSelectedTab();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public int getYourTabVisibility() {
        int i = 0;
        int r0 = this.model.isYourTabVisible() ? 0 : 8;
        return (this.model.isYourTabVisible() ? 0 : 8);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public boolean isCountryTabVisible() {
        boolean z = true;
        String str;
        final int i = 0;
        if (this.model != null) {
            int r0 = this.model.getParticipatingCountries().contains(this.preferenceService.p()) ? 1 : i;
        }
        if (!this.model && this.model != null) {
            if (this.model.getSelectedTab() == ChallengeSortingTab.COUNTRY) {
                this.model.setSelectedTabAs(ChallengeSortingTab.POPULAR_TAB);
                this.listener.a(i);
                refreshView();
            }
        }
        return z;
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public boolean isHour24TabVisible() {
        boolean z = false;
        if (!isCountryTabVisible()) {
            int r0 = !this.model.hasChallengeExpired() ? 1 : 0;
        }
        return (!this.model.hasChallengeExpired() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public boolean isVisible() {
        return this.model.isVisible();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public boolean isWelcomeTabVisible() {
        boolean z = false;
        int r0 = this.model != null && this.model.isChallengeSingleEntryInfinite() ? 1 : 0;
        return (this.model != null && this.model.isChallengeSingleEntryInfinite() ? 1 : 0);
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void on24HourSelect() {
        b hOURS_242 = ChallengeSortingTab.HOURS_24;
        if (!this.model.checkIfCurrentTabIs(hOURS_242)) {
            int i = 6;
            this.listener.a(i);
            this.model.setSelectedTabAs(ChallengeSortingTab.HOURS_24);
            this.tracker.logEvent(E_Challenges.o);
            refreshView();
        } else {
            triggerBackToTop();
            refreshView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void on7DaySelect() {
        b dAYS_72 = ChallengeSortingTab.DAYS_7;
        if (!this.model.checkIfCurrentTabIs(dAYS_72)) {
            int i = 5;
            this.listener.a(i);
            this.model.setSelectedTabAs(ChallengeSortingTab.DAYS_7);
            this.tracker.logEvent(E_Challenges.p);
            refreshView();
        } else {
            triggerBackToTop();
            refreshView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void onCountrySelect() {
        final b cOUNTRY2 = ChallengeSortingTab.COUNTRY;
        if (!this.model.checkIfCurrentTabIs(cOUNTRY2)) {
            this.tracker.logEvent(E_Challenges.q);
            int i = 7;
            this.listener.a(i);
            this.model.setSelectedTabAs(ChallengeSortingTab.COUNTRY);
            refreshView();
        } else {
            triggerBackToTop();
            refreshView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void onLatestSelect() {
        b lATEST_TAB2 = ChallengeSortingTab.LATEST_TAB;
        if (!this.model.checkIfCurrentTabIs(lATEST_TAB2)) {
            int i = 1;
            this.listener.a(i);
            this.model.setSelectedTabAs(ChallengeSortingTab.LATEST_TAB);
            this.tracker.logEvent(E_Challenges.l);
            refreshView();
        } else {
            triggerBackToTop();
            refreshView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void onPopularSelect() {
        b pOPULAR_TAB2 = ChallengeSortingTab.POPULAR_TAB;
        if (!this.model.checkIfCurrentTabIs(pOPULAR_TAB2)) {
            int i = 0;
            this.listener.a(i);
            this.model.setSelectedTabAs(ChallengeSortingTab.POPULAR_TAB);
            this.tracker.logEvent(E_Challenges.k);
            refreshView();
        } else {
            triggerBackToTop();
            refreshView();
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void onYourSelect() {
        b yOUR_TAB2 = ChallengeSortingTab.YOUR_TAB;
        if (!this.model.checkIfCurrentTabIs(yOUR_TAB2)) {
            int i = 2;
            this.listener.a(i);
            this.model.setSelectedTabAs(ChallengeSortingTab.YOUR_TAB);
            this.tracker.logEvent(E_Challenges.m);
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
    public void setModel(EntrySortingTabItem.SortingCellModel sortingCellModel) {
        this.model = sortingCellModel;
        refreshView();
    }

    @Override // app.dogo.com.dogo_android.util.e0.o
    public void triggerBackToTop() {
        this.listener.a(4);
        this.tracker.logEvent(E_Challenges.n);
    }

    public EntrySortingObservable(o3 o3Var, h hVar, v2 v2Var, p2 p2Var) {
        super();
        this.tracker = o3Var;
        this.listener = hVar;
        this.preferenceService = p2Var;
        this.utilities = v2Var;
    }
}
