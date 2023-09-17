package zjc.examples.quarkus.panacheRepo.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import zjc.examples.quarkus.panacheRepo.dto.EmployeeDto;
import zjc.examples.quarkus.panacheRepo.service.EmployeeService;

import java.util.List;

@Path("/employees")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeResource {

    private static final Logger LOG = Logger.getLogger(EmployeeResource.class);
    @Inject
    EmployeeService employeeService;



//    @GET
//    @Path("/")
//    public RestResponse<List<EmployeeDto>> getAll() {
//        return RestResponse.ResponseBuilder.ok(employeeService.getAll()).build();
//        //return employeeService.getAll();
//    }

    @GET
    @Path("/")
    public List<EmployeeDto> getAll() {
        return employeeService.getAll();
    }

    @GET
    @Path("/{id}")
    public EmployeeDto getById(@PathParam("id") Long id) {
        return employeeService.getById(id);
    }

//    @GET
//    @Path("/detailsById/{id}")
//    public EmployeeDetailsDto getDetailsById(@PathParam("id") final Long id) {
//        return organizationService.getDetailsById(id);
//    }


    // ---------------------------------------------------------



    @PUT
    @Path("/save")
    @Transactional
    public EmployeeDto save(EmployeeDto employeeDto) {
        return employeeService.create(employeeDto);
    }

//    @PUT
//    @Path("/update/{id}")
//    public Organization update(@PathParam("id") Long id, Organization organization) {
//        return organizationService.update(id, organization);
//    }

//    @DELETE
//    @Path("/delete/{id}")
//    public void delete(@PathParam("id") Long id) {
//        organizationService.delete(id);
//    }

//    @PUT
//    @Path("/updateNameFrom/{id}")
//    public void updateNameFrom(@PathParam("id") Long id)  {
//        organizationService.updateNameFrom(3L);
//    }
}
