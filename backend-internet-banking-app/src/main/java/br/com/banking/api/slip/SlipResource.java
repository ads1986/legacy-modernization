package br.com.banking.api.slip;

import br.com.banking.api.slip.model.SlipRequest;
import br.com.banking.domain.slip.service.SlipService;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

@Path("/fruit")
public class SlipResource {

    @Inject
    private SlipService service;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(SlipRequest request) {
        service.pay(request.toSlip());
    }

}