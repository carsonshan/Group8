/**
 * Copyright 2017 Goldman Sachs.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package resources;

import org.junit.Test;
import pojo.*;
import javax.ws.rs.core.Application;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;

import java.util.*;
import static org.junit.Assert.assertEquals;

/**
 * Write your tests for the Stock Resource here
 */

public class StockResourceTest extends JerseyTest {

    private static ObjectMapper mapper = new ObjectMapper();

    @Override
    protected Application configure() {
        return new ResourceConfig(Stock.class);
    }

    @Test
    public void testStock1() {
        // checks that number of events between 03/15/2017 and 03/20/2017 is 4
        List<Double> stocksInRange = target().path("/services/stock/startDate/03152017/endDate/03202017/stockTicker/ATVI").request().get(List.class);
        assertEquals(4, stocksInRange.size());
    }

}
