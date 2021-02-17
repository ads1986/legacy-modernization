package br.com.banking.api.slip;

import br.com.banking.api.slip.model.SlipRequest;

import br.com.banking.domain.slip.model.Slip;
import br.com.banking.domain.slip.service.SlipService;
import org.jboss.resteasy.annotations.SseElementType;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/slips")
public class SlipResource {

    @Inject
    private SlipService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(SlipRequest request) {
        service.pay(request.toSlip());
    }

    @GET
    @Path("/stream")
    @Produces(MediaType.SERVER_SENT_EVENTS)
    @SseElementType(MediaType.APPLICATION_JSON)
    public Publisher<Slip> stream() {
        return service.get();
    }

}