package com.zendesk.service;

/* loaded from: classes2.dex */
public class b implements com.zendesk.service.a {

    private final String a;
    public b(String string) {
        super();
        this.a = string;
    }

    @Override // com.zendesk.service.a
    public String a() {
        return "text/plain; charset=UTF8";
    }

    @Override // com.zendesk.service.a
    public String b() {
        return this.a;
    }

    @Override // com.zendesk.service.a
    public boolean c() {
        return 0;
    }

    @Override // com.zendesk.service.a
    public String d() {
        return this.a;
    }

    @Override // com.zendesk.service.a
    public boolean e() {
        return 0;
    }

    @Override // com.zendesk.service.a
    public String getUrl() {
        return "";
    }

    @Override // com.zendesk.service.a
    public int m() {
        return -1;
    }
}
