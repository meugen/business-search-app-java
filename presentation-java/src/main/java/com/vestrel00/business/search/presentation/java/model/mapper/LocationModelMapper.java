/*
 * Copyright 2017 Vandolf Estrellado
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.vestrel00.business.search.presentation.java.model.mapper;

import com.vestrel00.business.search.domain.Location;
import com.vestrel00.business.search.presentation.java.model.LocationModel;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Maps {@link LocationModel} to {@link Location} and vice versa.
 */
@Singleton
final class LocationModelMapper implements ModelMapper<LocationModel, Location> {

    @Inject
    LocationModelMapper() {
    }

    @Override
    public Location map(LocationModel locationModel) {
        return Location.builder()
                .address(locationModel.address())
                .city(locationModel.city())
                .state(locationModel.state())
                .zipCode(locationModel.zipCode())
                .country(locationModel.country())
                .build();
    }

    @Override
    public LocationModel map(Location location) {
        return LocationModel.builder()
                .address(location.address())
                .city(location.city())
                .state(location.state())
                .zipCode(location.zipCode())
                .country(location.country())
                .build();
    }
}
