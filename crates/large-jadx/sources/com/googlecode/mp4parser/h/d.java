package com.googlecode.mp4parser.h;

import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class d extends com.googlecode.mp4parser.h.f {

    Logger a;
    public d(String string) {
        super();
        this.a = Logger.getLogger(string);
    }

    @Override // com.googlecode.mp4parser.h.f
    public void b(String string) {
        this.a.log(Level.FINE, string);
    }

    @Override // com.googlecode.mp4parser.h.f
    public void c(String string) {
        this.a.log(Level.SEVERE, string);
    }

    @Override // com.googlecode.mp4parser.h.f
    public void d(String string) {
        this.a.log(Level.WARNING, string);
    }
}
