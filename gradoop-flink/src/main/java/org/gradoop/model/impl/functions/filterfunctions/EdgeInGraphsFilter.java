/*
 * This file is part of gradoop.
 *
 * gradoop is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * gradoop is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with gradoop. If not, see <http://www.gnu.org/licenses/>.
 */

package org.gradoop.model.impl.functions.filterfunctions;

import org.apache.flink.api.common.functions.FilterFunction;
import org.gradoop.model.api.EPGMEdge;

import java.util.List;

/**
 * Checks if an edge is contained in at least one of the given logical
 * graphs.
 *
 * @param <ED> EPGM edge type
 */
public class EdgeInGraphsFilter<ED extends EPGMEdge>
  implements FilterFunction<ED> {

  /**
   * Graph identifiers
   */
  private final List<Long> identifiers;

  /**
   * Creates a filter
   *
   * @param identifiers graph identifiers for containment check
   */
  public EdgeInGraphsFilter(List<Long> identifiers) {
    this.identifiers = identifiers;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean filter(ED edge) throws Exception {
    boolean vertexInGraph = false;
    if (edge.getGraphCount() > 0) {
      for (Long graph : edge.getGraphs()) {
        if (identifiers.contains(graph)) {
          vertexInGraph = true;
          break;
        }
      }
    }
    return vertexInGraph;
  }
}

