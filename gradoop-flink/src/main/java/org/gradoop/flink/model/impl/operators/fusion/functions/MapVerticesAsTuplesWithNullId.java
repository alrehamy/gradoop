/*
 * This file is part of Gradoop.
 *
 * Gradoop is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Gradoop is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Gradoop. If not, see <http://www.gnu.org/licenses/>.
 */

package org.gradoop.flink.model.impl.operators.fusion.functions;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.java.functions.FunctionAnnotation;
import org.apache.flink.api.java.tuple.Tuple2;
import org.gradoop.common.model.impl.id.GradoopId;
import org.gradoop.common.model.impl.pojo.Vertex;

/**
 * Maps vertices that are not associated to a graph id
 * to a null id.
 */
@FunctionAnnotation.ForwardedFields("*->f0")
public class MapVerticesAsTuplesWithNullId
  implements MapFunction<Vertex, Tuple2<Vertex, GradoopId>> {

  /**
   * Reusable returned element
   */
  private final Tuple2<Vertex, GradoopId> reusable;

  /**
   * Default constructor
   */
  public MapVerticesAsTuplesWithNullId() {
    reusable = new Tuple2<>();
    reusable.f1 = GradoopId.NULL_VALUE;
  }

  @Override
  public Tuple2<Vertex, GradoopId> map(Vertex value) throws Exception {
    reusable.f0 = value;
    return reusable;
  }
}
