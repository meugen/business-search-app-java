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

import com.vestrel00.business.search.domain.Business;
import com.vestrel00.business.search.domain.BusinessHour;
import com.vestrel00.business.search.domain.BusinessHours;
import com.vestrel00.business.search.domain.BusinessTransactionType;
import com.vestrel00.business.search.domain.Coordinates;
import com.vestrel00.business.search.domain.Location;
import com.vestrel00.business.search.presentation.java.model.BusinessHourModel;
import com.vestrel00.business.search.presentation.java.model.BusinessHoursModel;
import com.vestrel00.business.search.presentation.java.model.BusinessModel;
import com.vestrel00.business.search.presentation.java.model.BusinessTransactionTypeModel;
import com.vestrel00.business.search.presentation.java.model.CoordinatesModel;
import com.vestrel00.business.search.presentation.java.model.LocationModel;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;

/**
 * Provides model mapper dependencies.
 */
@Module
public abstract class ModelMapperModule {

    @Binds
    @Singleton
    abstract ModelMapper<BusinessModel, Business>
    businessModelMapper(BusinessModelMapper businessModelMapper);

    @Binds
    @Singleton
    abstract ModelMapper<BusinessTransactionTypeModel, BusinessTransactionType>
    businessTransactionTypeModelMapper(BusinessTransactionTypeModelMapper
                                               businessTransactionTypeModelMapper);

    @Binds
    @Singleton
    abstract ModelMapper<BusinessHoursModel, BusinessHours>
    businessHoursModelMapper(BusinessHoursModelMapper businessHoursModelMapper);

    @Binds
    @Singleton
    abstract ModelMapper<BusinessHourModel, BusinessHour>
    businessHourModelMapper(BusinessHourModelMapper businessHourModelMapper);

    @Binds
    @Singleton
    abstract ModelMapper<LocationModel, Location>
    locationModelMapper(LocationModelMapper locationModelMapper);

    @Binds
    @Singleton
    abstract ModelMapper<CoordinatesModel, Coordinates>
    coordinatesModelMapper(CoordinatesModelMapper coordinatesModelMapper);
}
