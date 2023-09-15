package zjc.examples.quarkus.panacheRepo.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import zjc.examples.quarkus.panacheRepo.dto.DepartmentDto;
import zjc.examples.quarkus.panacheRepo.service.DepartmentService;

import java.util.List;

@Path("/departments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    private static final Logger LOG = Logger.getLogger(DepartmentResource.class);
    @Inject
    DepartmentService departmentService;



    @GET
    @Path("/")
    public List<DepartmentDto> getAll() {
        return departmentService.getAll();
    }

    @GET
    @Path("/{id}")
    public DepartmentDto getById(@PathParam("id") Long id) {
        return departmentService.getById(id);
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
    public DepartmentDto save(DepartmentDto departmentDto) {
        return departmentService.create(departmentDto);
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
