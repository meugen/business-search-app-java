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

import android.app.Fragment;

import com.vestrel00.business.search.presentation.android.inject.PerFragment;
import com.vestrel00.business.search.presentation.android.mvp.ui.business.common.view.BusinessCommonViewModule;
import com.vestrel00.business.search.presentation.android.mvp.ui.business.list.presenter.BusinessListPresenterModule;
import com.vestrel00.business.search.presentation.android.mvp.ui.common.view.BaseFragmentModule;
import com.vestrel00.business.search.presentation.android.mvp.ui.common.view.OnItemClickListener;
import com.vestrel00.business.search.presentation.java.model.BusinessModel;

import java.util.ArrayList;
import java.util.List;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

/**
 * Provides business list fragment dependencies.
 */
@Module(includes = {
        BaseFragmentModule.class,
        BusinessCommonViewModule.class,
        BusinessListPresenterModule.class
})
abstract class BusinessListFragmentModule {

    @Binds
    @PerFragment
    abstract Fragment fragment(BusinessListFragment businessListFragment);

    @Binds
    @PerFragment
    abstract BusinessListView businessListView(BusinessListFragment businessListFragment);

    @Binds
    @PerFragment
    abstract OnItemClickListener<BusinessModel>
    businessListItemClickListener(BusinessListItemClickListener businessListItemClickListener);

    @Provides
    static List<BusinessModel> businessModels() {
        return new ArrayList<>();
    }
}
