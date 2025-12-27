@Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "offerings", "Lcom/revenuecat/purchases/Offerings;"}, k = 3, mv = {1, 5, 1}, xi = 48)
static final class 2 extends kotlin.d0.d.p implements kotlin.d0.c.l<com.revenuecat.purchases.Offerings, kotlin.w> {

    final /* synthetic */ app.dogo.com.dogo_android.repository.domain.CouponDiscount $discount;
    final /* synthetic */ i.b.c0<app.dogo.com.dogo_android.repository.domain.SubscriptionOffer> $emitter;
    final /* synthetic */ boolean $isFreeTrailAvailable;
    final /* synthetic */ boolean $orderByPricePerDay;
    @Override // kotlin.d0.d.p
    public final void invoke(com.revenuecat.purchases.Offerings offerings) {
        int i;
        int i2 = 1;
        java.util.List availablePackages;
        n.f(offerings, "offerings");
        app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount = null;
        if (this.$discount == null) {
            i = couponDiscount;
        } else {
            String offeringId2 = this.$discount.getOfferingId();
        }
        if (this.$discount != 0) {
            if (offerings.get(this.$discount.getOfferingId()) != null) {
                this.$emitter.onSuccess(new SubscriptionOffer(this.$isFreeTrailAvailable, this.$discount, GetPremiumOfferingsInteractor.this.orderAndMapOfferings(GetPremiumOfferingsInteractor.this.getSpecialOffers(offerings, this.$discount.getOfferingId()), this.$orderByPricePerDay)));
            } else {
                int r0 = GetPremiumOfferingsInteractor.this.getRemoteConfigService().h().length() > 0 ? 1 : 0;
                if (this.$emitter != 0) {
                    if (offerings.get(GetPremiumOfferingsInteractor.this.getRemoteConfigService().h()) != null) {
                        this.$emitter.onSuccess(new SubscriptionOffer(this.$isFreeTrailAvailable, this.$discount, GetPremiumOfferingsInteractor.this.orderAndMapOfferings(GetPremiumOfferingsInteractor.this.getSpecialOffers(offerings, GetPremiumOfferingsInteractor.this.getRemoteConfigService().h()), this.$orderByPricePerDay)));
                    } else {
                        com.revenuecat.purchases.Offering current = offerings.getCurrent();
                        if (current == null) {
                            int i3 = couponDiscount;
                        } else {
                            availablePackages = current.getAvailablePackages();
                        }
                        this.$emitter.onSuccess(new SubscriptionOffer(this.$isFreeTrailAvailable, couponDiscount, GetPremiumOfferingsInteractor.this.orderAndMapOfferings(GetPremiumOfferingsInteractor.this.centerYealySubscriptionIf3Elements(availablePackages), this.$orderByPricePerDay)));
                    }
                }
            }
        }
    }

    2(app.dogo.com.dogo_android.repository.domain.CouponDiscount couponDiscount, GetPremiumOfferingsInteractor getPremiumOfferingsInteractor, i.b.c0<app.dogo.com.dogo_android.repository.domain.SubscriptionOffer> c0Var, boolean z, boolean z2) {
        this.$discount = couponDiscount;
        this.$emitter = c0Var;
        this.$isFreeTrailAvailable = z;
        this.$orderByPricePerDay = z2;
        super(1);
    }
}
