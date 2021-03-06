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

import com.google.auto.value.AutoValue;

/**
 * Contains business hour information for 1 day.
 */
@AutoValue
// FIXME? (JACKSON DATABIND) - The generated builder could be used for deserialization.
// However, Jackson does not yet support setting default values for null or missing properties
// per setter/getter methods. Furthermore, it is not as flexible as parsing using the tree model.
// E.G. Missing (or null) property string -> empty string (instead of the default null)
// @JsonDeserialize(builder = AutoValue_BusinessHourEntity.Builder.class)
public abstract class BusinessHourEntity implements Entity {

    /**
     * @return a new {@link Builder}
     */
    public static Builder builder() {
        return new AutoValue_BusinessHourEntity.Builder();
    }

    /**
     * @return from 0 to 6, representing day of the week from Monday to Sunday. You may get the
     * same day of the week more than once if the business has more than one opening time slots.
     */
    public abstract int day();

    /**
     * @return start of the opening hours in a day, in 24-hour clock notation. E.G. 1000 means 10 AM
     */
    public abstract String start();

    /**
     * @return end of the opening hours in a day, in 24-hour clock notation. E.G. 2130 means 9:30 PM
     */
    public abstract String end();

    /**
     * Builder used to create instances of {@link BusinessHourEntity}.
     */
    @AutoValue.Builder
    public abstract static class Builder {

        public abstract Builder day(int day);

        public abstract Builder start(String start);

        public abstract Builder end(String end);

        public abstract BusinessHourEntity build();
    }
}
