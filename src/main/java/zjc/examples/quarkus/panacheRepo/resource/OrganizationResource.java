package zjc.examples.quarkus.panacheRepo.resource;

import org.jboss.logging.Logger;
import zjc.examples.quarkus.panacheRepo.entity.Organization;
import zjc.examples.quarkus.panacheRepo.service.OrganizationService;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public List<Organization> findAll() {
        return (List<Organization>) organizationService.getAll();
    }

    @GET
    @Path("/{id}")
    public Organization findById(@PathParam("id") Long id) {
        return organizationService.get(id);
    }


    @PUT
    @Path("/save")
    public Organization save(Organization organization) {
        return organizationService.create(organization);
    }

    @PUT
    @Path("/update/{id}")
    public Organization update(@PathParam("id") Long id, Organization organization) {
        return organizationService.update(id, organization);
    }

    @DELETE
    @Path("/delete/{id}")
    public void delete(@PathParam("id") Long id) {
        organizationService.delete(id);
    }

    @GET
    @Path("/findbyname/{name}")
    public Organization findByName(@PathParam("name") String name) {
        return organizationService.getByName(name);
    }
}
