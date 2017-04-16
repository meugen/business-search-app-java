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

package com.vestrel00.business.search.data.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.auto.value.AutoValue;

import java.util.List;

/**
 * Contains business information.
 */
@AutoValue
@JsonDeserialize(builder = AutoValue_BusinessEntity.Builder.class)
public abstract class BusinessEntity {

    /**
     * @return a new {@link Builder}
     */
    public static Builder builder() {
        return new AutoValue_BusinessEntity.Builder();
    }

    public abstract String id();

    @JsonProperty("name")
    public abstract String name();

    @JsonProperty("display_phone")
    public abstract String phoneNumber();

    @JsonProperty("image_url")
    public abstract String imageUrl();

    @JsonProperty("price")
    public abstract String price();

    @JsonProperty("categories")
    public abstract List<String> categories();

    @JsonProperty("rating")
    public abstract float rating();

    @JsonProperty("is_closed")
    public abstract boolean closed();

    @JsonProperty("location")
    public abstract LocationEntity location();

    @JsonProperty("coordinates")
    public abstract CoordinatesEntity coordinates();

    /**
     * Builder used to create instances of {@link BusinessEntity}.
     */
    @AutoValue.Builder
    public abstract static class Builder {

        @JsonProperty("id")
        public abstract Builder id(String id);

        @JsonProperty("name")
        public abstract Builder name(String name);

        @JsonProperty("display_phone")
        public abstract Builder phoneNumber(String phoneNumber);

        @JsonProperty("image_url")
        public abstract Builder imageUrl(String imageUrl);

        @JsonProperty("price")
        public abstract Builder price(String price);

        @JsonProperty("categories")
        public abstract Builder categories(List<String> categories);

        @JsonProperty("rating")
        public abstract Builder rating(float rating);

        @JsonProperty("is_closed")
        public abstract Builder closed(boolean closed);

        @JsonProperty("location")
        @JsonDeserialize(builder = LocationEntity.Builder.class)
        public abstract Builder location(LocationEntity location);

        @JsonProperty("coordinates")
        @JsonDeserialize(builder = CoordinatesEntity.Builder.class)
        public abstract Builder coordinates(CoordinatesEntity coordinates);

        public abstract BusinessEntity build();
    }
}