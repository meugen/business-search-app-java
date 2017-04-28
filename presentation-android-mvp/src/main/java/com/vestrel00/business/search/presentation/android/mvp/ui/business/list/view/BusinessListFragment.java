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

import com.vestrel00.business.search.presentation.android.mvp.ui.business.list.presenter.BusinessListPresenter;
import com.vestrel00.business.search.presentation.android.mvp.ui.common.view.LoadDataFragment;
import com.vestrel00.business.search.presentation.java.model.BusinessModel;

import java.util.List;

import javax.inject.Inject;

/**
 * A fragment implementation of {@link BusinessListView}.
 */
public final class BusinessListFragment extends LoadDataFragment<BusinessListPresenter>
        implements BusinessListView {

    @Inject
    BusinessListAdapter businessListAdapter;

    @Override
    public void renderBusinessList(List<BusinessModel> businessModels) {
        businessListAdapter.setBusinessModels(businessModels);
    }

    @Override
    public void viewBusinessDetails(BusinessModel businessModel) {
        // TODO (IMPLEMENTATION) - viewBusinessDetails
    }
}
