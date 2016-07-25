/*
 * Copyright (C) 2016 The Dagger Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dagger.internal.codegen;

import static com.google.auto.common.MoreElements.getAnnotationMirror;

import com.google.common.collect.ImmutableSet;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoMap;
import dagger.multibindings.IntoSet;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.ExecutableElement;

/**
 * Utility methods related to processing {@link IntoSet}, {@link ElementsIntoSet}, and {@link
 * IntoMap}.
 */
final class MultibindingAnnotations {
  static ImmutableSet<AnnotationMirror> forMethod(ExecutableElement method) {
    return ImmutableSet.<AnnotationMirror>builder()
        .addAll(getAnnotationMirror(method, IntoSet.class).asSet())
        .addAll(getAnnotationMirror(method, ElementsIntoSet.class).asSet())
        .addAll(getAnnotationMirror(method, IntoMap.class).asSet())
        .build();
  }
}
