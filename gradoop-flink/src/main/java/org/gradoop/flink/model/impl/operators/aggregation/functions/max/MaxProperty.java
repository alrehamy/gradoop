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

package org.gradoop.flink.model.impl.operators.aggregation.functions.max;

/**
 * Superclass of aggregate functions that determine a maximal property value.
 */
public abstract class MaxProperty extends Max {
  /**
   * Property key whose value should be aggregated.
   */
  protected final String propertyKey;

  /**
   * Constructor.
   *
   * @param propertyKey property key to aggregate
   */
  public MaxProperty(String propertyKey) {
    this.propertyKey = propertyKey;
  }

  @Override
  public String getAggregatePropertyKey() {
    return "max_" + propertyKey;
  }
}
