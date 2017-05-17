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
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Set;
import java.util.HashSet;
import java.util.List;


import utility.FileHelper;
import utility.InputValidator;
import pojo.Company;

import jdk.nashorn.internal.objects.annotations.Getter;

@Path("services")
public class CompanyResource {

    // TODO - Add a @GET resource to get company data
    // Your service should return data for a given stock ticker

    @GET
    @Path("/company/{companyId}")
    public Response showCompany(@PathParam("companyId") String companyId)throws IOException{
        List<Company> companies = FileHelper.readAllCompanies("compayInfo.json");
        Company retCompany = new Company();

        for (Company company : companies) {
            if (company.getSymbol().equalsIgnoreCase(companyId)){
                retCompany = company;
            }
        }
        Response.ResponseBuilder response;
        return Response.status(Response.Status.OK).entity(retCompany).build();
    }



}
