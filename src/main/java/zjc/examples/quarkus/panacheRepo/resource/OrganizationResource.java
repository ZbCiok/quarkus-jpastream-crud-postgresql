package zjc.examples.quarkus.panacheRepo.resource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDetailsDto;
import zjc.examples.quarkus.panacheRepo.dto.OrganizationDto;
import zjc.examples.quarkus.panacheRepo.service.OrganizationService;
import java.util.List;

@Path("/organizations")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class OrganizationResource {

    private static final Logger LOG = Logger.getLogger(OrganizationResource.class);
    @Inject
    OrganizationService organizationService;



    @GET
    @Path("/")
    public List<OrganizationDto> getAll() {
        return organizationService.getAll();
    }

    @GET
    @Path("/{id}")
    public OrganizationDto getById(@PathParam("id") Long id) {
        return organizationService.getById(id);
    }

    @GET
    @Path("/detailsById/{id}")
    public OrganizationDetailsDto getDetailsById(@PathParam("id") final Long id) {
        return organizationService.getDetailsById(id);
    }


    // ---------------------------------------------------------



    @PUT
    @Path("/save")
    @Transactional
    public OrganizationDto save(OrganizationDto organizationDto) {
        return organizationService.create(organizationDto);
    }

//    @PUT
//    @Path("/update/{id}")
//    public Organization update(@PathParam("id") Long id, Organization organization) {
//        return organizationService.update(id, organization);
//    }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        organizationService.delete(id);
    }

    @PUT
    @Path("/updateNameFrom/{id}")
    public void updateNameFrom(@PathParam("id") Long id)  {
        organizationService.updateNameFrom(3L);
    }
}
