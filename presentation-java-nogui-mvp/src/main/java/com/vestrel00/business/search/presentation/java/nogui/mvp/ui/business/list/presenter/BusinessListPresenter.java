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

package com.vestrel00.business.search.presentation.java.nogui.mvp.ui.business.list.presenter;

import com.vestrel00.business.search.domain.Coordinates;
import com.vestrel00.business.search.domain.Location;
import com.vestrel00.business.search.domain.executor.UseCaseHandler;
import com.vestrel00.business.search.domain.interactor.GetBusinessesAroundCoordinates;
import com.vestrel00.business.search.domain.interactor.GetBusinessesAroundLocation;
import com.vestrel00.business.search.presentation.java.model.CoordinatesModel;
import com.vestrel00.business.search.presentation.java.model.LocationModel;
import com.vestrel00.business.search.presentation.java.model.mapper.ModelMapperProvider;
import com.vestrel00.business.search.presentation.java.nogui.mvp.ui.business.list.view.BusinessListView;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.annotations.NonNull;

/**
 * Presents the business list.
 */
@Singleton
public final class BusinessListPresenter {

    private final GetBusinessesAroundLocation getBusinessesAroundLocation;
    private final GetBusinessesAroundCoordinates getBusinessesAroundCoordinates;
    private final ModelMapperProvider modelMapperProvider;
    private final BusinessListObserverFactory businessListObserverFactory;
    private final UseCaseHandler useCaseHandler;

    @NonNull
    private BusinessListView view;

    @Inject
    BusinessListPresenter(GetBusinessesAroundLocation getBusinessesAroundLocation,
                          GetBusinessesAroundCoordinates getBusinessesAroundCoordinates,
                          ModelMapperProvider modelMapperProvider,
                          BusinessListObserverFactory businessListObserverFactory,
                          UseCaseHandler useCaseHandler) {
        this.getBusinessesAroundLocation = getBusinessesAroundLocation;
        this.getBusinessesAroundCoordinates = getBusinessesAroundCoordinates;
        this.modelMapperProvider = modelMapperProvider;
        this.businessListObserverFactory = businessListObserverFactory;
        this.useCaseHandler = useCaseHandler;
    }

    public void setView(@NonNull BusinessListView view) {
        this.view = view;
    }

    public void showBusinessesAroundLocation() {
        LocationModel locationModel = view.getLocation();
        showBusinessesAroundLocation(locationModel);
    }

    public void showBusinessesAroundCoordinates() {
        CoordinatesModel coordinatesModel = view.getCoordinates();
        showBusinessesAroundCoordinates(coordinatesModel);
    }

    private void showBusinessesAroundLocation(LocationModel locationModel) {
        Location location = modelMapperProvider.locationModelMapper()
                .map(locationModel);
        BusinessListObserver observer = businessListObserverFactory.create(view);
        useCaseHandler.execute(getBusinessesAroundLocation, location, observer);
    }

    private void showBusinessesAroundCoordinates(CoordinatesModel coordinatesModel) {
        Coordinates coordinates = modelMapperProvider.coordinatesModelMapper()
                .map(coordinatesModel);
        BusinessListObserver observer = businessListObserverFactory.create(view);
        useCaseHandler.execute(getBusinessesAroundCoordinates, coordinates, observer);
    }
}
