package io.github.seniorzhai.ottodemo;

import com.squareup.otto.Bus;

/**
 * Created by zhaitao on 15/8/12.
 */
public final class BusProvider {
    private static final Bus bus = new Bus();

    public static Bus getInstance() {
        return bus;
    }

    private BusProvider() {
    }
}

