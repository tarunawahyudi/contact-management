package com.stacklab.contactmanagementrestfulapi.controller;

import com.stacklab.contactmanagementrestfulapi.entity.User;
import com.stacklab.contactmanagementrestfulapi.model.AddressResponse;
import com.stacklab.contactmanagementrestfulapi.model.CreateAddressRequest;
import com.stacklab.contactmanagementrestfulapi.model.UpdateAddressRequest;
import com.stacklab.contactmanagementrestfulapi.model.WebResponse;
import com.stacklab.contactmanagementrestfulapi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping(
            path = "/api/v1/contacts/{contactId}/addresses",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> create(
            User user,
            @RequestBody CreateAddressRequest request,
            @PathVariable("contactId") String contactId) {

        request.setContactId(contactId);
        AddressResponse response = addressService.create(user, request);
        return WebResponse.<AddressResponse>builder().data(response).build();

    }

    @GetMapping(
            path = "/api/v1/contacts/{contactId}/addresses/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> get(
            User user,
            @PathVariable("contactId") String contactId,
            @PathVariable("addressId") String addressId
    ) {
        AddressResponse response = addressService.get(user, contactId, addressId);
        return WebResponse.<AddressResponse>builder().data(response).build();
    }

    @PutMapping(
            path = "/api/v1/contacts/{contactId}/addresses/{addressId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<AddressResponse> update(
            User user,
            @RequestBody UpdateAddressRequest request,
            @PathVariable("contactId") String contactId,
            @PathVariable("addressId") String addressId
    ) {

        request.setContactId(contactId);
        request.setAddressId(addressId);
        AddressResponse response = addressService.update(user, request);
        return WebResponse.<AddressResponse>builder().data(response).build();

    }

    @DeleteMapping(
            path = "/api/v1/contacts/{contactId}/addresses/{addressId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> remove(
            User user,
            @PathVariable("contactId") String contactId,
            @PathVariable("addressId") String addressId
    ) {

        addressService.remove(user, contactId, addressId);
        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(
            path = "/api/v1/contacts/{contactId}/addresses",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<List<AddressResponse>> list(
            User user,
            @PathVariable("contactId") String contactId
    ) {
        List<AddressResponse> addressResponses = addressService.list(user, contactId);
        return WebResponse.<List<AddressResponse>>builder().data(addressResponses).build();
    }
}
