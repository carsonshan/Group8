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

import pojo.Stock;
import utility.FileHelper;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Path("services")
public class StockResource {

    public static final SimpleDateFormat DATEFORMAT = new SimpleDateFormat("MM-dd-yyyy");

    @GET
    @Path("stock/startDate/{startDate}/endDate/{endDate}/stockTicker/{stockTicker}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Double> getStocksInRange(@PathParam("startDate") String startDateStr, @PathParam("endDate") String endDateStr, @PathParam("stockTicker") String stockTicker) throws IOException, ParseException {

        Date startDate = DATEFORMAT.parse(startDateStr);
        Date endDate = DATEFORMAT.parse(endDateStr);

        List<Stock> stocks = FileHelper.readAllStocks("historicalStockData.json");

        Map<Date, Double> stocksRangeMap = new TreeMap<Date, Double>();

        for (Stock stock: stocks) {

            for (Map<String, Double> map: stock.getDailyClosePrice() ) {

                for (String keyStr : map.keySet()) {

                    Date key = DATEFORMAT.parse(keyStr);

                    if (((key.before(endDate)) || (key.equals(endDate))) && ((key.after(startDate)) || (key.equals(startDate)))) {
                        stocksRangeMap.put(key, map.get(keyStr));
                    }

                }

            }

        }

        List<Double> stocksInRange = new ArrayList<>();

        for (Date date: stocksRangeMap.keySet()) {

            stocksInRange.add(stocksRangeMap.get(date));

        }

        return stocksInRange;

    }

}
