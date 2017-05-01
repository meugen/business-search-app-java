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

package com.vestrel00.business.search.presentation.android.mvp.ui.business.list.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vestrel00.business.search.presentation.android.mvp.R;
import com.vestrel00.business.search.presentation.android.mvp.ui.business.list.presenter.BusinessListPresenter;
import com.vestrel00.business.search.presentation.android.mvp.ui.common.view.LoadDataFragment;
import com.vestrel00.business.search.presentation.java.model.BusinessModel;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * A fragment implementation of {@link BusinessListView} that allows listing businesses around
 * a given location or current location.
 */
public final class BusinessListFragment extends LoadDataFragment<BusinessListPresenter>
        implements BusinessListView {

    @Inject
    BusinessListAdapter businessListAdapter;

    @Inject
    BusinessListFragmentListener listener;

    @BindView(R.id.business_list)
    RecyclerView businessListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.business_list_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        businessListView.setAdapter(businessListAdapter);
        businessListAdapter.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        businessListAdapter.onSaveInstanceState(outState);
    }

    @Override
    public void renderBusinessList(List<BusinessModel> businessModels) {
        businessListAdapter.setBusinessModels(businessModels);
    }

    @Override
    public void viewBusinessDetails(BusinessModel businessModel) {
        listener.onShowBusinessDetails(businessModel);
    }

    public void showBusinessesAroundLocation(String location) {
        presenter.onListBusinessesAroundLocation(location);
    }

    public void showBusinessesAroundCurrentLocation() {
        presenter.onListBusinessesAroundCurrentLocation();
    }
}
