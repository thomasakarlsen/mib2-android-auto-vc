/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.androidauto.target;

import de.vw.mib.asl.api.navigation.ASLNavigationServices;
import de.vw.mib.asl.api.navigation.AbstractASLNavigationServicesListener;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoGlobalProperties;
import de.vw.mib.asl.internal.androidauto.target.AndroidAutoTarget;
import de.vw.mib.asl.internal.androidauto.target.StartupHandler;

public class NavigationListener
extends AbstractASLNavigationServicesListener {
    private AndroidAutoTarget target;
    private StartupHandler startupHandler;
    private AndroidAutoGlobalProperties properties;
    private ASLNavigationServices navServices;
    private boolean stopGuidancePending = false;

    public NavigationListener(AndroidAutoTarget androidAutoTarget, AndroidAutoGlobalProperties androidAutoGlobalProperties, StartupHandler startupHandler) {
        this.target = androidAutoTarget;
        this.properties = androidAutoGlobalProperties;
        this.startupHandler = startupHandler;
    }

    public void initNavServices(ASLNavigationServices aSLNavigationServices) {
        this.navServices = aSLNavigationServices;
    }

   // @Override
    public void updateGuidanceActive(boolean bl) {
        if (this.target.isTraceEnabled()) {
            this.target.trace(new StringBuffer().append("NavigationHandler::updateGuidanceActive - flag = ").append(bl).toString());
        }
        /*ANDROID AUTO NAVIGATION IGNORE
        if (bl) {
            ServiceManager.aslPropertyManager.valueChangedBoolean(895953920, false);
            this.properties.setAndroidAutoNavigationActive(false);
            if (this.startupHandler.isDSI2Registered() && this.startupHandler.isDeviceConnected()) {
                this.target.getDSIAndroidAuto2().navFocusNotification(1, true);
            }
        }*/
    }

   // @Override
    public void updateServiceAvailable(boolean bl) {
        if (bl && this.stopGuidancePending) {
            this.stopGuidancePending = false;
            this.stopGuidance();
        }
    }

    public void stopGuidance() {
        if (this.target.isTraceEnabled()) {
            this.target.trace("NavigationHandler::stopGuidance");
        }
        /* ANDROID AUTO NAVIGATION IGNORE
        if (this.navServices.isServiceAvailable()) {
            this.navServices.stopGuidance(6);
        } else {
            this.stopGuidancePending = true;
            if (this.target.isTraceEnabled()) {
                this.target.trace("NavigationListener::stopGuidance() = isServiceAvailable false");
            }
        }*/
    }

    public boolean isGuidanceActive() {
        // ANDROID AUTO NAVIGATION IGNORE
        //return this.navServices.isGuidanceActive();
        return false;
    }
}

