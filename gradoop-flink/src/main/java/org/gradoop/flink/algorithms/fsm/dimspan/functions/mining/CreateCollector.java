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

package org.gradoop.flink.algorithms.fsm.dimspan.functions.mining;

import org.apache.flink.api.common.functions.MapFunction;
import org.gradoop.flink.algorithms.fsm.dimspan.tuples.PatternEmbeddingsMap;
import org.gradoop.flink.algorithms.fsm.dimspan.tuples.GraphWithPatternEmbeddingsMap;

/**
 * bool => (graph, pattern -> embeddings)
 * workaround for bulk iteration intermediate results
 * graph and map are empty
 */
public class CreateCollector implements MapFunction<Boolean, GraphWithPatternEmbeddingsMap> {

  @Override
  public GraphWithPatternEmbeddingsMap map(Boolean aBoolean) throws Exception {

    return new GraphWithPatternEmbeddingsMap(new int[0], PatternEmbeddingsMap.getEmptyOne());
  }
}
