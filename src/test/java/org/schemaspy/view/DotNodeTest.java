/*
 * Copyright (C) 2018 Nils Petzaell
 *
 * This file is part of SchemaSpy.
 *
 * SchemaSpy is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SchemaSpy is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with SchemaSpy. If not, see <http://www.gnu.org/licenses/>.
 */
package org.schemaspy.view;

import org.junit.Test;
import org.schemaspy.model.Database;
import org.schemaspy.model.LogicalTable;
import org.schemaspy.model.Table;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

/**
 * @author Nils Petzaell
 */
public class DotNodeTest {

    @Test
    public void escapeHtml() {
        Database database = mock(Database.class);
        Table table = new LogicalTable(database, "catalog", "schema", "<table>", "comment");
        DotNode dotNode = new DotNode(table,"", "output");
        assertThat(dotNode.toString()).contains("tooltip=\"&lt;table&gt;");
    }

    @Test
    public void urlEncodeLink() {
        Database database = mock(Database.class);
        Table table = new LogicalTable(database, "catalog", "schema", "a table", "comment");
        DotNode dotNode = new DotNode(table,"", "output");
        assertThat(dotNode.toString()).contains("URL=\"a%20table.html\"");
    }
}