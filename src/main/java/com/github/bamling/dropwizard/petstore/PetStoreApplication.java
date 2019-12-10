package com.github.bamling.dropwizard.petstore;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class PetStoreApplication extends Application<PetStoreConfiguration> {

    @Override
    public void run(final PetStoreConfiguration configuration, final Environment environment) {

    }

    public static void main(String[] args) throws Exception {
        new PetStoreApplication().run(args);
    }

}
